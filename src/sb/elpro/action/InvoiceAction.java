/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JREmptyDataSource;
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

import sb.elpro.actionform.InvoiceForm;
import sb.elpro.actionform.PrfForm;
import sb.elpro.actionform.SampleInvoiceForm;
import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;
import sb.elpro.bo.SampleInvoiceBo;
import sb.elpro.bo.SampleInvoiceBoImpl;
import sb.elpro.model.InvoiceBean;
import sb.elpro.model.SampleInvoiceBean;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class InvoiceAction extends DispatchAction{
	InvoiceBo invbo = new InvoiceBoImpl();
	HttpSession usersession;
	InvoiceBean invbean = new InvoiceBean();
	public ActionForward Save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		 System.out.println("In Invoice Save Form");
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 usersession = request.getSession(false);
		 JSONObject invjsonobj = new JSONObject();
		 if(!(usersession == null)){
			 InvoiceForm invform =  (InvoiceForm) form;
			 BeanUtils.copyProperties(invbean, invform);
			 invbean.setInv_invdate(DateConversion.ConverttoMysqlDate(request.getParameter("inv_invdate")));
			 invbean.setInv_awbilldate(DateConversion.ConverttoMysqlDate(request.getParameter("inv_awbilldate")));
			 System.out.println("Sample Inv Type"+invbean.getInv_invoicetype());
			 System.out.println("Sample Inv No"+invbean.getInv_invoiceno());
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("invactionform"));
			 if(usersession.getAttribute("invactionform").equals("edit")){
				 System.out.println(" in Inv Edi Form");
				 boolean isupdtinv = invbo.updtInvoiceform(invbean);
				 if(isupdtinv){
					 invjsonobj.put("result", isupdtinv);
					 invjsonobj.put("success", "Successfully UPdt The Form");
					 invform.reset(map, request);
						out.println(invjsonobj);
						return map.findForward("invoicetrackisloaded");
					}else{
						invjsonobj.put("result", isupdtinv);
						invjsonobj.put("error", "Error in UPdt  Form");
						out.println(invjsonobj);
						return null;
					}
			 }else{
				 boolean issavedinv = invbo.saveInvoiceform(invbean);
				 if(issavedinv){
					 invjsonobj.put("result", issavedinv);
					 invjsonobj.put("success", "Successfully Saved The Form");
					 invform.reset(map, request);
						out.println(invjsonobj);
						return map.findForward("invissaved");
					}else{
						invjsonobj.put("result", issavedinv);
						invjsonobj.put("error", "Error in Saving The Form");
						out.println(invjsonobj);
						return null;
					}
			 }
		  }else{
			 System.out.println("Invalid Sesssion");
			 return map.findForward("logout"); 
		 }
	}
	public ActionForward Logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In INV Form Logout ");
		usersession = request.getSession(false);
		usersession.invalidate();			
		return map.findForward("logout");  
	}
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In INV Clear Logout ");	
		return map.findForward("clear");  
	}
	public ActionForward Print(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("application/ms-excel"); 
		 response.setHeader("Content-Disposition", "attachment; filename=Invoice.xls");
        ServletOutputStream out = response.getOutputStream();
		System.out.println("IN Print  ");
		InvoiceForm invprintform =(InvoiceForm) form;
		BeanUtils.copyProperties(invbean, invprintform);
		
		JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/invoiceform.jrxml");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("pexprtrname",invprintform.getInv_exporter());
		hm.put("pexprtrattn", invprintform.getInv_exporterattn());
		hm.put("pexprtraddr", invprintform.getInv_exporteraddress());
		hm.put("pexprtrtele", invprintform.getInv_exportertele());
		hm.put("pexprtrfax", invprintform.getInv_exporterfax());
		hm.put("pconsigname", invprintform.getInv_customer());
		hm.put("pconsigattn", invprintform.getInv_custattn());
		hm.put("pconsigaddr", invprintform.getInv_custaddr());
		hm.put("pconsigtele", invprintform.getInv_custtele());
		hm.put("pconsigfax", invprintform.getInv_custfax());
		hm.put("pnotifyname", invprintform.getInv_notify());
		hm.put("pnotifyattn", invprintform.getInv_notifyattn());
		hm.put("pnotifyaddr", invprintform.getInv_notifyaddress());
		hm.put("pnotifytele", invprintform.getInv_notifytele());
		hm.put("pnotifyfax", invprintform.getInv_notifyfax());
		hm.put("pbuyer", invprintform.getInv_buyer());
		hm.put("pbuyerattn", invprintform.getInv_buyerattn());
		hm.put("pbuyeraddr", invprintform.getInv_buyeraddr());
		hm.put("pbuyertele", invprintform.getInv_buyertele());
		hm.put("pbuyerfax", invprintform.getInv_buyerfax());
		hm.put("pinvno", invprintform.getInv_invoiceno());
		hm.put("pinvdt", invprintform.getInv_invdate());
		hm.put("pexporef", invprintform.getInv_expref());
		hm.put("potherref", invprintform.getInv_otherref());
		hm.put("ppono", invprintform.getInv_pono());
		hm.put("pcog", invprintform.getInv_ctryoforigngoods());
		hm.put("pcof", invprintform.getInv_ctryoffinaldesti());
		hm.put("pterms", invprintform.getInv_terms());
		hm.put("ppaymnt", invprintform.getInv_payment());
		hm.put("pprecariageby", invprintform.getInv_precarriageby());
		//hm.put("pprecarrierplace", invprintform.getInv_);
		hm.put("pvessel", invprintform.getInv_vesselno());
		hm.put("ploadingport", invprintform.getInv_loadingport());
		hm.put("pdestiport", invprintform.getInv_dischargeport());
		hm.put("pfinaldesti", invprintform.getInv_finaldesti());
		hm.put("pmarksnctnr", invprintform.getInv_marksno());
		hm.put("pkindpack", invprintform.getInv_packno());
		hm.put("pgrwt", invprintform.getInv_grosswt());
		hm.put("pnetwt", invprintform.getInv_netwt());
		//hm.put("pamtinwords", invprintform.getInv_);
		JasperPrint print = JasperFillManager.fillReport(report, hm, new JREmptyDataSource());
		
		JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
      
 		// Here we assign the parameters jp and baos to the exporter
         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
 	
         // Excel specific parameters
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
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
