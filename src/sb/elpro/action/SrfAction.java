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
	SampleRequest srfprintbean = new SampleRequest();
	
	public ActionForward Save(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 PrintWriter out = response.getWriter();
		 JSONObject srfjsonobj = new JSONObject();
		 usersession = request.getSession(false);
		 if(!(usersession == null)){
			 SrfForm srfsaveform =(SrfForm) form;
			 BeanUtils.copyProperties(srfbean, srfsaveform);
			 srfbean.setSrf_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("srf_orderdate")));
			 srfbean.setSrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("srf_cdd")));
			 srfbean.setSrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("srf_add")));

			 System.out.println("request  "+usersession.getAttribute("srfactionform"));
			 if(usersession.getAttribute("srfactionform").equals("edit")){
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
		 usersession.invalidate();	
		 System.out.println(" LOgin Credential Fails");
		 return map.findForward("logout");
		 }
	}
	
	public ActionForward logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
		usersession.invalidate();			
		return map.findForward("logout");
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
		
		Connection conn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
            System.out.println("conn "+conn.getCatalog());
            } catch (SQLException ex) {
            } catch (ClassNotFoundException ex) {
            }
		response.setContentType("application/ms-excel"); 
		response.setHeader("Content-Disposition", "attachment; filename=SRF.xls");
        ServletOutputStream out = response.getOutputStream();
		System.out.println("IN Print  ");
		SrfForm srfprintform =(SrfForm) form;
		//srfprintform.setPrf_poref("This is the Title of the Report");
		JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/SampleForm.jrxml");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("psno",srfprintform.getSrf_sampleno());
		hm.put("porddt", srfprintform.getSrf_orderdate());
		hm.put("pcust", srfprintform.getSrf_customer());
		hm.put("phandl", srfprintform.getSrf_handledby());
		hm.put("prefno", srfprintform.getSrf_referenceno());
		hm.put("ppriority", srfprintform.getSrf_priority());
		hm.put("ptanname", srfprintform.getSrf_tanname());
		hm.put("ptanattn", srfprintform.getSrf_tanattn());
		hm.put("ptannaddr", srfprintform.getSrf_tanaddr());
		hm.put("ptanntele", srfprintform.getSrf_tanphone());
		hm.put("ptannfax", srfprintform.getSrf_tanfax());
		hm.put("pdelname", srfprintform.getSrf_deliver());
		hm.put("pdelattn", srfprintform.getSrf_deliverattn());
		hm.put("pdeladdr", srfprintform.getSrf_deliveraddr());
		hm.put("pdeltele", srfprintform.getSrf_deliverphone());
		hm.put("pdelfax", srfprintform.getSrf_deliverfax());
		hm.put("pcolrmatch", srfprintform.getSrf_colormatching());
		hm.put("ptapetest", srfprintform.getSrf_tapetest());
		//hm.put("pcrockwet", srfprintform.);
		//hm.put("pcrockdry", srfprintform.getSrf_bankbranch());
		hm.put("pendusage", srfprintform.getSrf_endusage());
		hm.put("pdesti", srfprintform.getSrf_destination());
		hm.put("pdeldate", srfprintform.getSrf_cdd());
		hm.put("psplcdn", srfprintform.getSrf_splcdn());
		JasperPrint print = JasperFillManager.fillReport(report, hm, conn);
		
		JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
      
 		// Here we assign the parameters jp and baos to the exporter
         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
 	
         // Excel specific parameters
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_GRAPHICS,Boolean.FALSE);
         
        try {
        	excelexporter.exportReport();
			
		} catch (JRException e) {
			throw new RuntimeException(e);
		}catch (Exception e) {
   			e.printStackTrace();
		}
	
		return null;
	}
}
