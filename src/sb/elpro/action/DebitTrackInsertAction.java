/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.DebitFormDetails;

/**
 * @author Wahab
 *
 */
public class DebitTrackInsertAction extends Action{

	HttpSession usersession;
	DebitBo debittrackbo =new DebitBoImpl();
	
	public ActionForward execute (ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("In Bulk Action ");
		usersession = request.getSession(false);
		if(!(usersession == null)){
			 String oper =   request.getParameter("oper");
			 System.out.println("oper "+oper);
			 String action = request.getParameter("action");
			 String rows = request.getParameter("rows");
             String pag = request.getParameter("page");
             String sidx = request.getParameter("sidx");
             String sord = request.getParameter("sord");
             Boolean  search = Boolean.valueOf( request.getParameter("_search"));
             String filters = request.getParameter("filters");
                
             System.out.println("rows "+rows); //4
             System.out.println("page "+pag); //1
             System.out.println("sidx "+sidx);
             System.out.println("sord "+sord);
             System.out.println("action "+action);
             System.out.println("search  "+search);
             System.out.println("filters  "+filters);
             //System.out.println("filters  "+filters);
             if(oper == null){
           	  			 
				List<DebitFormDetails> debittrack = debittrackbo.getDebitTrackDetails(sidx, sord, rows, pag );
				int records = debittrack.size();
				System.out.println("Reords  "+records);
				int page = Integer.parseInt(pag);  //1
                int totalPages = 0; //0
                int totalCount = records; //100
                if (totalCount > 0) {
                	 if (totalCount % Integer.parseInt(rows) == 0) { //10
                		 System.out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
                         totalPages = totalCount / Integer.parseInt(rows);
                         System.out.println("STEP 2 "+totalPages);
                     } else {
                         totalPages = (totalCount / Integer.parseInt(rows)) + 1;
                         System.out.println("STEP 3 "+totalPages);
                     }
                }else {
                    totalPages = 0;
                }
			jsonobj.put("total", totalPages);
			jsonobj.put("page", page);
			jsonobj.put("records", records);
			jsonobj.put("rows", debittrack);
			//jsonobj.accumulate("userdata", totobj);
			System.out.println(jsonobj);		
			out.println(jsonobj);
            }
		 }else{
			 System.out.println("Error Invalid Session");
			 return map.findForward("logout");
		 }
		 return  null;
	}
}
