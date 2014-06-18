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


import sb.elpro.actionform.InspectionForm;
import sb.elpro.bo.InspectionBo;
import sb.elpro.bo.InspectionBoImpl;
import sb.elpro.model.InspectionBean;
import sb.elpro.utility.DateConversion;

/**
 * @author ADMIN_WIN7
 *
 */
public class InspectionAction extends DispatchAction {
	HttpSession usersession;
	InspectionBo inspbo = new InspectionBoImpl();
	 InspectionBean inspbean = new InspectionBean();
		public ActionForward Save(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			System.out.println("In Inspection Save Form");
			 PrintWriter out = response.getWriter();
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 usersession = request.getSession(false);
			 JSONObject inspjsonobj = new JSONObject();
			 if(!(usersession == null)){
				
				 InspectionForm inspform =  (InspectionForm) form;
				 BeanUtils.copyProperties(inspbean, inspform);
				 inspbean.setInspdate(DateConversion.ConverttoMysqlDate(request.getParameter("inspdate")));
				 System.out.println("Sample Inv Type"+inspbean.getInspdate());
				 
				 System.out.println("usersession "+usersession.getId());
				 System.out.println("request  "+usersession.getAttribute("inspactionform"));
				 if(usersession.getAttribute("inspactionform").equals("edit")){
					/* boolean isupdtsampleinv = sampinvbo.updtSampleInvoiceform(sampinvbean);
					 if(isupdtsampleinv){
						 sampinvjsonobj.put("result", isupdtsampleinv);
						 sampinvjsonobj.put("success", "Successfully UPdt The Form");
						 sampinvform.reset(map, request);
							out.println(sampinvjsonobj);
							return map.findForward("sampleinvoicetrackisloaded");
						}else{
							sampinvjsonobj.put("result", isupdtsampleinv);
							sampinvjsonobj.put("error", "Error in UPdt  Form");
							out.println(sampinvjsonobj);
							return null;*/
				 }else{
						boolean issavedinsp = inspbo.saveInspectionform(inspbean);
						if(issavedinsp){
							inspjsonobj.put("result", issavedinsp);
							inspjsonobj.put("success", "Successfully Saved The Form");
							inspform.reset(mapping, request);
							System.out.println("Sucesfully saved The Form ");
							out.println(inspjsonobj);
							return mapping.findForward("inspissaved");
						}else{
							inspjsonobj.put("result", issavedinsp);
							inspjsonobj.put("error", "Error in Saving The Form");
							out.println(inspjsonobj);
							return null;
						}
				}
			}else{
					System.out.println("Invalid Login credentials");
					mapping.findForward("logout");
				 }
			return null;
		}
		
		public ActionForward Logout(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			System.out.println("IN INSPECTION LOGOUT");
			usersession = request.getSession(false);
			//usersession.removeAttribute("");
			usersession.invalidate();			
			return mapping.findForward("logout");
		}
		public ActionForward Print(ActionMapping mapping, ActionForm form, 
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
			response.setHeader("Content-Disposition", "attachment; filename=Inspection.xls");
	        ServletOutputStream out = response.getOutputStream();
			System.out.println("IN Inspection Print");
			 InspectionForm inspform =  (InspectionForm) form;
			//srfprintform.setPrf_poref("This is the Title of the Report");
			JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/inspectionform.jrxml");
			HashMap<String, Object> hm = new HashMap<String, Object>();
			//hm.put("pctno",inspform.getArticleid());
			hm.put("particleid", inspform.getArtidhidden());
			hm.put("pqc", inspform.getInspqualityctrlr());
			hm.put("pinspdate", inspform.getInspdate());
			hm.put("pinsctno", inspform.getInspContractNo());
			System.out.println("Type "+inspform.getInsptype());
			hm.put("ptype", inspform.getInsptype());
			
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
