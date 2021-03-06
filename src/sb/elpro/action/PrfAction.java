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
import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.ProductDetails;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class PrfAction extends DispatchAction {
	PrfBo prfbo  =  new PrfBoImpl();
	HttpSession usersession;
	ProductDetails prfbean = new ProductDetails();
	ProductDetails prfprintbean = new ProductDetails();
	
	public ActionForward Save(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 PrfForm prfsaveform =(PrfForm) form;
		 BeanUtils.copyProperties(prfbean, prfsaveform);
		 
		 prfbean.setPrf_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("prf_orderdate")));
		 prfbean.setPrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("prf_cdd")));
		 prfbean.setPrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("prf_add")));
		 prfbean.setPrf_exporterid(prfbean.getPrf_tannid());
		 if(!(prfbean.getPrf_pojwno().startsWith("PO"))){
			 prfbean.setPrf_pojwno("N/A");
		 }
		 System.out.println("Alpha "+prfbean.getPrf_pojwno());
		 usersession = request.getSession(false);
		 System.out.println("Session in PRF  "+usersession);
		 if(!(usersession == null)){
			 JSONObject prfjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("prfactionform")); 
			 if(usersession.getAttribute("prfactionform").equals("edit")){ // Errors Falls here for Save
				 System.out.println("In Edit ");
				    boolean isupdatePrf = prfbo.updatePrfform(prfbean);
					//boolean isupdatePrf = prfbo.savePrfform(prfbean);
					if(isupdatePrf){
						prfjsonobj.put("result", isupdatePrf);
						prfjsonobj.put("success", "Successfully Updated The Form");
						prfsaveform.reset(map, request);
						out.println(prfjsonobj);
						return map.findForward("bulkisloaded");
					}else{
						prfjsonobj.put("result", isupdatePrf);
						prfjsonobj.put("error", "Error in Updated The Form");
						out.println(prfjsonobj);
						return null;
				}
			 }else{
				 boolean issavedPrf = prfbo.savePrfform(prfbean);
				 if(issavedPrf){
				    System.out.println("In ADD ");
					prfjsonobj.put("result", issavedPrf);
					prfjsonobj.put("success", "Successfully Saved The Form");
					prfsaveform.reset(map, request);
					out.println(prfjsonobj);
					return map.findForward("prfissaved");
				 }else{
					prfjsonobj.put("result", issavedPrf);
					prfjsonobj.put("error", "Error in Saving The Form");
					out.println(prfjsonobj);
					return null;
				 }			
			 }	 
		 }else{	
		   usersession.invalidate();
		   System.out.println(" Login Credential Fails");
		   return map.findForward("logout");
		 }
	}
	
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN CLEAR ");
		 PrfForm prfsaveform =(PrfForm) form;
		 prfsaveform.reset(map, request);
		return map.findForward("clearprfform");
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
		response.setHeader("Content-Disposition", "attachment; filename=PRF.xls");
        ServletOutputStream out = response.getOutputStream();
		System.out.println("IN Print  ");
		PrfForm prfprintform =(PrfForm) form;
		prfprintform.setPrf_poref("This is the Title of the Report");
		JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/prf.jrxml");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("pctno",prfprintform.getPrf_contractno());
		hm.put("porderdt", prfprintform.getPrf_orderdate());
		hm.put("ptanneryname", prfprintform.getPrf_tanname());
		hm.put("ptanneryattn", prfprintform.getPrf_tanattn());
		hm.put("ptanneryaddr", prfprintform.getPrf_tanaddr());
		hm.put("ptanneryphone", prfprintform.getPrf_tanphone());
		hm.put("ptanneryfax", prfprintform.getPrf_tanfax());
		hm.put("pcustname", prfprintform.getPrf_custname());
		hm.put("pcustattn", prfprintform.getPrf_custattn());
		hm.put("pcustaddr", prfprintform.getPrf_custaddr());
		hm.put("pcusttel", prfprintform.getPrf_custphone());
		hm.put("pcustfax", prfprintform.getPrf_custfax());
		hm.put("pdesti", prfprintform.getPrf_destination());
		hm.put("pcomm", prfprintform.getPrf_elclasscommission()+" "+prfprintform.getPrf_commission());
		hm.put("ppayment", prfprintform.getPrf_payment());
		hm.put("pinsurance", prfprintform.getPrf_insurance());
		hm.put("pterms", prfprintform.getPrf_terms());
		hm.put("pcdd", prfprintform.getPrf_cdd());
		hm.put("pbankname", prfprintform.getPrf_bankname());
		hm.put("pbankaddr", prfprintform.getPrf_bankaddr());
		hm.put("pbankbranch", prfprintform.getPrf_bankbranch());
		hm.put("pbankphone", prfprintform.getPrf_bankphone());
		hm.put("pbankfax", prfprintform.getPrf_bankfax());
		hm.put("pconsigname", prfprintform.getPrf_consigneename());
		hm.put("pconsigattn", prfprintform.getPrf_consigneeattn());
		System.out.println("getPrf_consigneeaddr"+prfprintform.getPrf_consigneeaddr());
		hm.put("pconsigaddr", prfprintform.getPrf_consigneeaddr());
		hm.put("pconsigphone", prfprintform.getPrf_consigneephone());
		hm.put("pconsigfax", prfprintform.getPrf_consigneefax());
		hm.put("pnotifyname", prfprintform.getPrf_notifyname());
		hm.put("pnotifyattn", prfprintform.getPrf_notifyattn());
		hm.put("pnotifyaddr", prfprintform.getPrf_notifyaddr());
		hm.put("pnotifytele", prfprintform.getPrf_notifyphone());
		hm.put("pnotifyfax", prfprintform.getPrf_notifyfax());
		hm.put("psplcdn", prfprintform.getPrf_special());
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
	
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Logout IN PORF ");
		usersession = request.getSession(false);
		usersession.invalidate();			
		return mapping.findForward("logout");  
	}
	public ActionForward POSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		 if(!(usersession == null)){
			JSONObject prfjsonobj = new JSONObject();
			System.out.println("usersession "+usersession.getId());
			System.out.println("request  "+usersession.getAttribute("prfactionform"));
			System.out.println(" in POJW SAVE FORM ACTION");
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			 ProductDetails posavebean = new ProductDetails();
			 posavebean.setPojw_pojwno(request.getParameter("pojw_pojwno"));
			 posavebean.setPojw_contractno(request.getParameter("pojw_contractno"));
			 posavebean.setPojw_comm(request.getParameter("pojw_comm"));
			 posavebean.setPojw_payterms(request.getParameter("pojw_payterms"));
			 posavebean.setPojw_tanid(request.getParameter("pojw_tanid"));
			 posavebean.setPojw_splcdn(request.getParameter("pojw_splcdn"));
			 posavebean.setPojw_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("pojw_orderdate")));
			 posavebean.setPojw_cddate(DateConversion.ConverttoMysqlDate(request.getParameter("pojw_cddate")));
			
			 if(usersession.getAttribute("prfactionform").equals("add")){
				 boolean issavedPojw = prfbo.savePoJwForm(posavebean);
				 if(issavedPojw){
						prfjsonobj.put("result", issavedPojw);
						prfjsonobj.put("success", "Successfully Saved The Form");
						//pojwsaveform.reset(mapping, request);
						out.println(prfjsonobj);
						return null;
					}else{
						prfjsonobj.put("result", issavedPojw);
						prfjsonobj.put("error", "Error in Saving The Form");
						out.println(prfjsonobj);
						return null;
					}
			 }else{
				/* boolean isupdatePrf = prfbo.updatePrfform(prfbean); // Incomplete
				 if(isupdatePrf){
						prfjsonobj.put("result", isupdatePrf);
						prfjsonobj.put("success", "Successfully Updated The Form");
						pojwsaveform.reset(mapping, request);
						out.println(prfjsonobj);
						return mapping.findForward("bulkisloaded");
				 }else{
						prfjsonobj.put("result", isupdatePrf);
						prfjsonobj.put("error", "Error in Updated The Form");
						out.println(prfjsonobj);
						return null;
					}	*/		
			 }	 
		 }	
		
		System.out.println(" Login Credential Fails");
		usersession.invalidate();	
		return mapping.findForward("logout");
		
	}
	public ActionForward POPrint(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("POSAVE Print ");
		Connection conn1 = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
            System.out.println("conn "+conn1.getCatalog());
            } catch (SQLException ex) {
            } catch (ClassNotFoundException ex) {
            }
		response.setContentType("application/ms-excel"); 
		response.setHeader("Content-Disposition", "attachment; filename=PRFPO.xls");
		ServletOutputStream  myout = response.getOutputStream();
		JasperReport report1 = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/PrfPoForm.jrxml");
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("pojw_pojwno",request.getParameter("pojw_pojwno"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_pojwno"));
		hm1.put("pojw_orderdate", request.getParameter("pojw_orderdate"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_orderdate"));
		hm1.put("pojw_cddate", request.getParameter("pojw_cddate"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_cddate"));
		hm1.put("pojw_contractno", request.getParameter("pojw_contractno"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_contractno"));
		hm1.put("pojw_comm", request.getParameter("pojw_comm"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_comm"));
		hm1.put("pojw_tanname", request.getParameter("pojw_tanname"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_tanname"));
		hm1.put("pojw_tanattn", request.getParameter("pojw_tanattn"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_tanattn"));
		hm1.put("pojw_tanaddr", request.getParameter("pojw_tanaddr"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_tanaddr"));
		hm1.put("pojw_tanphone", request.getParameter("pojw_tanphone"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_tanphone"));
		hm1.put("pojw_tanfax", request.getParameter("pojw_tanfax"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_tanfax"));
		hm1.put("pojw_splcdn", request.getParameter("pojw_splcdn"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_splcdn"));
		hm1.put("pojw_payterms", request.getParameter("pojw_payterms"));
		System.out.println("pojw_pojwno"+request.getParameter("pojw_payterms"));
		
		JasperPrint print1 = JasperFillManager.fillReport(report1, hm1, conn1);
		
		JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
      
 		// Here we assign the parameters jp and baos to the exporter
         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print1);
         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, myout);
 	
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
