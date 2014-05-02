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

import sb.elpro.actionform.DebitForm;
import sb.elpro.actionform.PrfForm;
import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.ProductDetails;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class DebitAction extends DispatchAction {
	HttpSession usersession;
	DebitBo debbo = new DebitBoImpl();
	DebitFormDetails debformbean = new DebitFormDetails();
	/*public ActionForward Load(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
		if(usersession != null){
			usersession.setAttribute("DebExporter",debbo.getDebExporter());
			usersession.setAttribute("DebTanInvno",debbo.getDebTanInvno());
			usersession.setAttribute("invBank",invbo.getInvBank());
			usersession.setAttribute("invLoadingPort",invbo.getInvLoadingPort());
			usersession.setAttribute("invCountryFinalDesti",invbo.getInvFinalDestinationCountry());
			usersession.setAttribute("invFinalDestination",invbo.getInvFinalDestination());
			usersession.setAttribute("invDischargeport",invbo.getInDischargeport());
			usersession.setAttribute("invCustomer",invbo.getInvCustomer());
			//usersession.setAttribute("invoiceno",invbo.getInvoiceNo());
			//usersession.setAttribute("invoiceno",invbo.getInvoiceNo());
		}
		return mapping.getInputForward();
	}*/
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
	
		usersession.invalidate();
		
		//return mapping.getInputForward();
		return mapping.findForward("login");
	}
	public ActionForward Save(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Save");
		 PrintWriter out = response.getWriter();
		 DebitForm debsaveform =(DebitForm) form;
		 BeanUtils.copyProperties(debformbean, debsaveform);
		 usersession = request.getSession(false);
		 System.out.println("Sessio n "+usersession);
		 debformbean.setDeb_debitdate(DateConversion.ConverttoMysqlDate(request.getParameter("deb_debitdate")));
		 //debformbean.setPrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("prf_cdd")));
		 //debformbean.setPrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("prf_add")));
		 if(!(usersession == null)){
			 
			 JSONObject debjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("debactionform"));
			 if(usersession.getAttribute("debactionform").equals("edit")){
				 boolean isupdtdeb = debbo.updtDebitform(debformbean);
				 if(isupdtdeb){
						debjsonobj.put("result", isupdtdeb);
						debjsonobj.put("success", "Successfully Saved The Form");
						debsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("gotodebittracking");
					}else{
						debjsonobj.put("result", isupdtdeb);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					} 
			 }else{
				 boolean issaveddeb = debbo.saveDebitform(debformbean);
				 if(issaveddeb){
						debjsonobj.put("result", issaveddeb);
						debjsonobj.put("success", "Successfully Saved The Form");
						debsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("debissaved");
					}else{
						debjsonobj.put("result", issaveddeb);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					}
			 }
			
		 }
		 else{
			 System.out.println(" Invalid Session");
			 return mapping.findForward("login");
		 }
		 
	}
	public ActionForward TcSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in TC SAVE");
		/* PrintWriter out = response.getWriter();
		 DebitForm debsaveform =(DebitForm) form;
		 BeanUtils.copyProperties(debformbean, debsaveform);
		  */
		 System.out.println(" Debit TC"+debformbean.getTcdeb_tcdebitno());
		return mapping.getInputForward();
	}
	public ActionForward Clickhere(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Clear");
		
		return mapping.getInputForward();
		
	}
	public ActionForward Calculate(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Calculate");
		
		return mapping.getInputForward();
		
	}
	public ActionForward Print(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Print");
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
		hm.put("pdebexporter",prfprintform.getPrf_contractno());
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
