/**
 * 
 */
package sb.elpro.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import sb.elpro.actionform.InvoiceForm;
import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;
import sb.elpro.model.InvoiceBean;
import sb.elpro.model.SampleInvoiceBean;

/**
 * @author Wahab
 *
 */
public class InvoiceLoadAction extends Action {
	HttpSession usersession;
	InvoiceBo invbo = new InvoiceBoImpl();
		public ActionForward execute(ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception, ServletException{
			usersession = request.getSession(false);
			if(usersession != null){
				String action = request.getParameter("action");
				System.out.println("Inv  action PPP"+action);
				if(action == null){
					usersession.setAttribute("invactionform", "add");
				return map.findForward("invoiceisloaded");
				}else if(action.equalsIgnoreCase("editinvform")){
					System.out.println("In Invoice Edit Form");
					String actionform = "edit";
					String invno = request.getParameter("invno");
					usersession.setAttribute("invactionform", actionform);
					usersession.setAttribute("editinvno", invno);
					List<InvoiceBean> editinvform = invbo.getEditInvFormValues(invno);
					usersession.setAttribute("editinvform", editinvform);
					
				}
				return map.findForward("invoiceisloaded");
			}else{
				System.out.println("Error");
				return map.findForward("logout");
			}
			
		}
}
