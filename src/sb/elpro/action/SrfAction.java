/**
 * 
 */
package sb.elpro.action;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.PrfForm;
import sb.elpro.actionform.SrfForm;
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.SampleRequest;
import sb.elpro.utility.DateConversion;



/**
 * @author Wahab
 *
 */
public class SrfAction extends DispatchAction {
	HttpSession usersession;
	SrfBo srfbo = new SrfBoImpl();
	SampleRequest srfbean = new SampleRequest();
	
	public ActionForward Save(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 usersession = request.getSession(false); 
		 PrintWriter out = response.getWriter();
		 JSONObject srfjsonobj = new JSONObject();
		if(!(usersession == null)){
		System.out.println("In Save Srf Form  >>>");
		
		 SrfForm srfsaveform =(SrfForm) form;
		 BeanUtils.copyProperties(srfbean, srfsaveform);
		 srfbean.setSrf_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("srf_orderdate")));
		 srfbean.setSrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("srf_cdd")));
		 srfbean.setSrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("srf_add")));
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("srfactionform"));
			 if(usersession.getAttribute("srfactionform").equals("edit")){
				 System.out.println("In Update SRF FORM");
				  boolean isupdtSrf = srfbo.updtSrfform(srfbean);
				  if(isupdtSrf){	 
						srfjsonobj.put("result", isupdtSrf);
						srfjsonobj.put("success", "Successfully Saved The Form");
						srfsaveform.reset(map, request);
						out.println(srfjsonobj);
						 return map.findForward("sampletrackisloaded");
					 }else{
						srfjsonobj.put("result", isupdtSrf);
						srfjsonobj.put("error", "Error in Saving The Form");
						out.println(srfjsonobj);
						return null;
					 }
			 }
			 else{ 
				 boolean issavedSrf = srfbo.saveSrfform(srfbean);
				 if(issavedSrf){	 
					srfjsonobj.put("result", issavedSrf);
					srfjsonobj.put("success", "Successfully Saved The Form");
					srfsaveform.reset(map, request);
					out.println(srfjsonobj);
					 return map.findForward("srfissaved");
				 }else{
					srfjsonobj.put("result", issavedSrf);
					srfjsonobj.put("error", "Error in Saving The Form");
					out.println(srfjsonobj);
					return null;
				 }
			 }
		 }else{	 
		 System.out.println(" LOgin Credential Fails");
		 return map.findForward("login");
		 }
	}
	
	public ActionForward logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
		usersession.invalidate();			
		
		return map.findForward("login");
	}
	
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN CLEAR ");
		 SrfForm srfsaveform =(SrfForm) form;
		 srfsaveform.reset(map, request);
		return map.findForward("clearsrfform");
	}
	public ActionForward Print(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN Print  ");
		Connection conn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
            System.out.println("conn "+conn.getCatalog());
            } catch (SQLException ex) {
            } catch (ClassNotFoundException ex) {
            }

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); 
        ServletOutputStream output = response.getOutputStream();

        	JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/Srf/Srfform.jrxml");
            HashMap<String, Object> params = new HashMap<String, Object>(); 
            params.put("Title", "Sample Track");
        
        	JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, conn);
        	  //Excel Converter
        	
        	JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
           // JExcelApiExporter excelexporter = new JExcelApiExporter(); // supports jasper Report version
   		 
    		// Here we assign the parameters jp and baos to the exporter
            excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
    	
            // Excel specific parameters
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_GRAPHICS,Boolean.FALSE);
            
    		try {
    			excelexporter.exportReport();
    			
    		} catch (JRException e) {
    			throw new RuntimeException(e);
    		} catch (Exception e) {
            e.printStackTrace();
        }	
	
		return null;
	}
}
