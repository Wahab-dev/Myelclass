/**
 * 
 */
package sb.elpro.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.model.SampleTrack;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class SampleTrackAction extends Action {
	HttpSession usersession;
	public ActionForward execute(ActionMapping map, ActionForm form,  
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		usersession = request.getSession(false);
		if(usersession != null){
			//PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("In Sample Track Action ");
			 return map.findForward("sampletrackisloaded");	
		}else{
			return map.findForward("login");	
		}
				
	}
	
	
}
