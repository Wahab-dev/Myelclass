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

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.SelectArticle;

/**
 * @author Wahab
 * Design for the drop down list for article name in prf grid
 *
 */
public class ArticleSelectList extends Action{
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	
	 
	public ActionForward execute (ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("In Article Selected List Servlet");
		usersession = request.getSession(false);
		if(!(usersession == null)){
		
			/*List<SelectArticle> articlelist = prfbo.getarticlename();
			JSONArray jsonOrderArray = JSONArray.fromObject(articlelist);
			System.out.println("articlelist  "+jsonOrderArray);
			out.println(jsonOrderArray);*/       
			//  Not sure where it calls so commented 
		} 
			return null;
	}
		
}
