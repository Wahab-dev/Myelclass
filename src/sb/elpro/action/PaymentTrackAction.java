/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */
public class PaymentTrackAction extends  Action {
	HttpSession usersession;
	public ActionForward execute(ActionMapping map, ActionForm form,  
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("In Payment Track Action");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		usersession = request.getSession(false);
		if(!(usersession == null)){
			return map.findForward("paytrackisloaded");
		}else{
			System.out.println("In Invalid Session");
			return map.findForward("logout");
		}	
	}
}
