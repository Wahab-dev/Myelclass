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
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 * Created on 08.03.13
 * Used to check for Auto complete in Select Tag
 */
public class AutoCompleteServlet extends Action{

	SrfBo srfbo = new SrfBoImpl();
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		//response.setContentType("application/json");
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		usersession = request.getSession(false);
		if(!(usersession == null)){
			//get the request from the jsp
			/*String tan = request.getParameter("tan");
			System.out.println();
			List<TanneryDetails> tannerlist =  prfbo.getTanneryDetails();*/
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("tan")){
				String term = request.getParameter("term");
				List<TanneryDetails> tannerylist =  srfbo.getTanneryDetails(term);
				System.out.println("List Value " +tannerylist.size());
				JSONArray jsonOrdertanArray = JSONArray.fromObject(tannerylist);
				 System.out.println(jsonOrdertanArray);
		 		out.println(jsonOrdertanArray);
			}/*else if (action.equalsIgnoreCase("artname")){ --> Duplicate code from PrfAutocomplete
				String term = request.getParameter("term");
				List<AutoComplete> articlelist =  prfbo.getArticleNameinEditGrid();
				System.out.println("List Value " +articlelist.size());
				JSONArray jsonOrdertanArray = JSONArray.fromObject(articlelist);
				 System.out.println(jsonOrdertanArray);
		 		out.println(jsonOrdertanArray);
			}*/
			else{
			/*
			 * Here i am using first letter enter from the Entry using request .getparamanter 
			 * and passing the value
			 * 
			 */
			String term = request.getParameter("term");
			System.out.println(" Term "+term);
			List<AutoComplete> destinationlist =  srfbo.getDestinationDetails(term);
			System.out.println("List Value " +destinationlist.size());
			JSONArray jsonOrderArray = JSONArray.fromObject(destinationlist);
			 System.out.println(jsonOrderArray);
	 		out.println(jsonOrderArray);
			}
       
			 out.close();
		}
			return null;
	}		
}
