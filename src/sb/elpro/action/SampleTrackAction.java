/**
 * 
 */
package sb.elpro.action;

import java.io.IOException;
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
public class SampleTrackAction extends Action {
	HttpSession usersession;
	public ActionForward execute(ActionMapping map, ActionForm form,  
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			//PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("In Sample Track Action ");
			usersession = request.getSession(false);
			if(!(usersession == null)){
				//PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				System.out.println("In Sample Track Action ");
				 return map.findForward("sampletrackisloaded");	
			}else{
				return map.findForward("logout");	
			}
			
	}
	
	
}
