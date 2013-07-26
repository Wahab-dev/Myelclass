/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;

/**
 * @author Wahab
 *
 */
public class DebSelInvfromCust extends Action{

	HttpSession usersession;
	DebitBo debbo = new DebitBoImpl();
	
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if(usersession != null){	
			String inv = request.getParameter("invno");
			System.out.println("Customer Name "+inv);
			String action = request.getParameter("action");
			System.out.println("action "+action);
			if(action.equalsIgnoreCase("loadGrid")){
				System.out.println("IN LOAD GRID");
				/*List<PrfArticle> article = debbo.getInvCustCtDetails(inv);
				JSONArray jsonOrderArray = JSONArray.fromObject(article);
				System.out.println(jsonOrderArray);					
		 		out.println(jsonOrderArray);*/
			}
		}
		
		return null;
	}
	
}	
