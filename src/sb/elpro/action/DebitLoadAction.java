/**
 * 
 */
package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.DebitBO;
import sb.elpro.bo.DebitBOImpl;

/**
 * @author Wahab
 *
 */
public class DebitLoadAction extends Action {

	HttpSession usersession;
	DebitBO debitbo = new sb.elpro.bo.DebitBOImpl();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);	
		if(usersession !=null){		   	
			usersession.setAttribute("DebExporter",debitbo.getDebExporter());
			usersession.setAttribute("DebTanInvno",debitbo.getDebTanInvno());
			//usersession.setAttribute(arg0, arg1)
			
		}
		return mapping.findForward("debitisloaded");
	}
}
