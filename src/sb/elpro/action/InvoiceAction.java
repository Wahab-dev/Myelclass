/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.InvoiceForm;
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
			 return map.findForward("login"); 
		 }
	}
	public ActionForward Logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In INV Form Logout ");
		usersession = request.getSession(false);
		usersession.invalidate();			
		return map.findForward("login");  
	}
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In INV Clear Logout ");	
		return map.findForward("clear");  
	}
}
