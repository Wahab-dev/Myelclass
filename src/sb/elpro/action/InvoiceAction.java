/**
 * 
 */
package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author Wahab
 *
 */
public class InvoiceAction extends DispatchAction{
	HttpSession usersession;
	public ActionForward saveInvoice(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		return map.findForward("login");
	}
	public ActionForward Logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		usersession.invalidate();			
		return map.findForward("login");  
	}
}
