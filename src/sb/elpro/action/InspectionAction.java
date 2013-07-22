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


import sb.elpro.bo.InspectionboImpl;

/**
 * @author ADMIN_WIN7
 *
 */
public class InspectionAction extends DispatchAction {
	HttpSession usersession;
	InspectionboImpl invbo = new InspectionboImpl();
	
		public ActionForward Save(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN INSPECTION >>>>>>>>>");
		return mapping.getInputForward();	
		}
		
		public ActionForward Logout(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			usersession = request.getSession(false);
			usersession.invalidate();			
			return mapping.findForward("login");
		}
}
