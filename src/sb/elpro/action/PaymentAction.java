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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.DebitForm;
import sb.elpro.actionform.PaymentForm;
import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.bo.PaymentBo;
import sb.elpro.bo.PaymentBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.PaymentBean;
import sb.elpro.model.PaymentDetails;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class PaymentAction extends DispatchAction{
	HttpSession usersession;
	PaymentBo paymntbo = new PaymentBoImpl();
	PaymentBean paymntformbean = new PaymentBean();
	
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
		 PaymentForm paymentsaveform =(PaymentForm) form;
		 BeanUtils.copyProperties(paymntformbean, paymentsaveform);
		 usersession = request.getSession(false);
		 System.out.println("Sessio n "+usersession);
		 paymntformbean.setPaymentdate(DateConversion.ConverttoMysqlDate(request.getParameter("deb_debitdate")));
		 paymntformbean.setRecieptdate(DateConversion.ConverttoMysqlDate(request.getParameter("recieptdate")));
		 if(!(usersession == null)){
			 
			 JSONObject debjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("payactionform"));
			 if(usersession.getAttribute("payactionform").equals("edit")){
				 /*boolean isupdtdeb = debbo.updtDebitform(debformbean);
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
					} */
			 }else{
				 boolean issavedpay = paymntbo.savePaymentform(paymntformbean);
				 if(issavedpay){
						debjsonobj.put("result", issavedpay);
						debjsonobj.put("success", "Successfully Saved The Form");
						paymentsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("paymntissaved");
					}else{
						debjsonobj.put("result", issavedpay);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					}
			 }
			 return null;
		 }
		 else{
			 System.out.println(" Invalid Session");
			 return mapping.findForward("login");
		 }
		
		 
	}
}
