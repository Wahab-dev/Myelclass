/**
 * 
 */
package sb.elpro.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;

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
				//usersession.setAttribute("InvExporterarray",invbo.getInvExporter());
				//usersession.setAttribute("InvNotifyarray",invbo.getInvNotify());
				//usersession.setAttribute("invBankarray",invbo.getInvBank());
				//usersession.setAttribute("invCustomerarray",invbo.getInvCustomer());
				//usersession.setAttribute("invCustContract", invbo.getInvCustContract());
				//usersession.setAttribute("invoiceno",invbo.getInvoiceNo());
			}else{
				System.out.println("Error");
			}
			return map.findForward("invoiceisloaded");
		}
}
