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


import sb.elpro.bo.BulkBo;
import sb.elpro.bo.BulkBoImpl;

/**
 * @author Wahab
 * 
 */
public class BulkAction extends DispatchAction  {
	HttpSession usersession;
	BulkBo bulkbo  =  new BulkBoImpl();
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In Btr Action");
		usersession.invalidate();			
		return mapping.findForward("logout");  
	}	
			
	
}
