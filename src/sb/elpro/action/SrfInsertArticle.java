	/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;

/**
 * @author Wahab
 *
 */
public class SrfInsertArticle extends Action{

		SrfBo srfbo = new SrfBoImpl();
		HttpSession usersession;
		
		public ActionForward execute(ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			usersession = request.getSession(false);
			if(usersession != null){
				String sno = request.getParameter("sno");
				System.out.println("sno "+sno);
				String action = request.getParameter("action");
				System.out.println("action "+action);
				if(action.equalsIgnoreCase("load")){
					List<SrfArticle> article = srfbo.getSrfArticleDetails(sno);
					JSONArray jsonOrderArray = JSONArray.fromObject(article);
					System.out.println(jsonOrderArray);					
			 		out.println(jsonOrderArray);
				}else{
					System.out.println("action in EDDIT MODE");	
			}
			
			System.out.println("In Article Selected List Servlet");
			
		}
			return null;
	}
}
    