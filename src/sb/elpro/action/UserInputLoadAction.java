/**
* This class draws .
* @author Wahab
* @version 1.2
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
public class UserInputLoadAction extends Action{
HttpSession usersession;
		public ActionForward execute( ActionMapping map, ActionForm form,
				HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{		
				return map.findForward("userinputisloaded");			
				
		}
		
}
