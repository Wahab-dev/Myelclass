/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

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
public class InvTrackLoadAction extends Action {

	HttpSession usersession;
	InvoiceBo invtrackbobo = new InvoiceBoImpl();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);
		if(!(usersession == null)){
			//usersession.setAttribute("DebExporter",debitbo.getDebExporter());
			//usersession.setAttribute("DebTanInvno",debitbo.getDebTanInvno());
			//usersession.setAttribute(arg0, arg1)
		}
			return mapping.findForward("invtrackisloaded");
	}
}
