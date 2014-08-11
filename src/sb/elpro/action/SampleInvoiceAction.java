/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.SampleInvoiceForm;
import sb.elpro.actionform.SrfForm;
import sb.elpro.bo.SampleInvoiceBo;
import sb.elpro.bo.SampleInvoiceBoImpl;
import sb.elpro.model.SampleInvoiceBean;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class SampleInvoiceAction extends DispatchAction {

	SampleInvoiceBo sampinvbo = new SampleInvoiceBoImpl();
	HttpSession usersession;
	SampleInvoiceBean sampinvbean = new SampleInvoiceBean();

	public ActionForward Save(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 System.out.println("In Sample Invoice Save Form");
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 JSONObject sampinvjsonobj = new JSONObject();
		 usersession = request.getSession(false);
		 if(!(usersession == null)){
			 SampleInvoiceForm sampinvform =  (SampleInvoiceForm) form;
			 BeanUtils.copyProperties(sampinvbean, sampinvform);
			 sampinvbean.setSaminv_invdate(DateConversion.ConverttoMysqlDate(request.getParameter("saminv_invdate")));
			 sampinvbean.setSaminv_awbilldate(DateConversion.ConverttoMysqlDate(request.getParameter("saminv_awbilldate")));
			 System.out.println("Sample Inv Type"+sampinvbean.getSaminv_invoicetype());
			 System.out.println("Sample Inv No"+sampinvbean.getSaminv_invoiceno());
			
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("sampleinvactionform"));
			 if(usersession.getAttribute("sampleinvactionform").equals("edit")){
				 boolean isupdtsampleinv = sampinvbo.updtSampleInvoiceform(sampinvbean);
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
						return null;
					}
			 }else{
				 boolean issavedsampleinv = sampinvbo.saveSampleInvoiceform(sampinvbean);
				 if(issavedsampleinv){
					 sampinvjsonobj.put("result", issavedsampleinv);
					 sampinvjsonobj.put("success", "Successfully Saved The Form");
					 sampinvform.reset(map, request);
						out.println(sampinvjsonobj);
						return map.findForward("sampleinvissaved");
					}else{
						sampinvjsonobj.put("result", issavedsampleinv);
						sampinvjsonobj.put("error", "Error in Saving The Form");
						out.println(sampinvjsonobj);
						return null;
					}
			 }
		 }else{
			 System.out.println("Invalid Sesssion");
			 usersession.invalidate();			
			 return map.findForward("logout");  	
		 }
		 
		
	}
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN CLEAR ");
		 SampleInvoiceForm saminvsaveform =(SampleInvoiceForm) form;
		 saminvsaveform.reset(map, request);
		return map.findForward("clearsaminvform");
	}
	public ActionForward Logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		usersession.invalidate();			
		return map.findForward("logout");
	}
}
