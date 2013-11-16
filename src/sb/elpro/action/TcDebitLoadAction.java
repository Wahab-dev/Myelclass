/**
 * 
 */
package sb.elpro.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.TcDebitBo;
import sb.elpro.bo.TcDebitBoImpl;
import sb.elpro.model.InvoiceForm;


/**
 * @author Wahab
 *
 */
public class TcDebitLoadAction extends Action {
	
	HttpSession usersession;
	TcDebitBo tcdebitbo = new TcDebitBoImpl();
	 
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);	
		
		if(usersession !=null){	
			String invno = request.getParameter("invno");
			System.out.println("invno"+invno);
			List<InvoiceForm> invdetails = tcdebitbo.getinvDetails(invno);
			usersession.setAttribute("invdetails", invdetails);
			
		}
		return mapping.findForward("tcdebitisloaded");
	}
	
}
