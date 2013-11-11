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

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 *
 */
public class DebAutoComplete extends Action {

	DebitBo debbo = new DebitBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request,  HttpServletResponse response) throws Exception{
		 response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			usersession = request.getSession(false);
			if(usersession != null){
				String action = request.getParameter("action");
				if(action.equalsIgnoreCase("debExp")){ 
					System.out.println("In debExp Autocomplete");
					String tanterm = request.getParameter("term");
					List<TanneryDetails> exporterlist =  debbo.getDebExporter(tanterm);
					System.out.println("List Value " +exporterlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(exporterlist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}
				else if (action.equalsIgnoreCase("Taninv")){
					System.out.println("In TanInv Autocomplete");
					String tanterm = request.getParameter("term");
					String expname = request.getParameter("expname");
					List<AutoComplete> exporterlist =  debbo.getDebInvno(tanterm, expname);
					System.out.println("List Value " +exporterlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(exporterlist);
					System.out.println(jsonOrdertanArray);
					out.println(jsonOrdertanArray);
				}
			}else{
				
			}
			return null;
	}
}
