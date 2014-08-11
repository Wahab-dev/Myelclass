/**
 * 
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
import sb.elpro.model.InvBillDetails;
/**
 * @author Wahab
 *
 */
public class DebSelInvfromCust extends Action{

	HttpSession usersession;
	DebitBo debbo = new DebitBoImpl();
	JSONObject jsonobj = new JSONObject();
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		usersession = request.getSession(false);
		if(!(usersession == null)){
			String action = request.getParameter("action");
			String rows = request.getParameter("rows");
            String pag = request.getParameter("page");
			String inv = request.getParameter("invno");
			
			System.out.println("inv N0 "+inv);
			System.out.println("action "+action);
			if(action.equalsIgnoreCase("loadGrid")){
				System.out.println("IN Debit LOAD GRID");
				String invno = request.getParameter("invno");
				List<InvBillDetails> debitlist = debbo.getDebitInvDetails(invno);
				int records = debitlist.size();
				int page = Integer.parseInt(pag);
                int totalPages = 0;
                int totalCount = records;
                if (totalCount > 0) {
                	 if (totalCount % Integer.parseInt(rows) == 0) {
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
				jsonobj.put("rows", debitlist);
				System.out.println(jsonobj);		
				out.println(jsonobj);
			}else if(action.equalsIgnoreCase("waived")){
				System.out.println("IN Debit Waive");
				String invid = request.getParameter("invid");
				boolean debitwaive = debbo.setDebitWaive(invid);
				if(debitwaive){
					 jsonobj.put("Success", "Successfully waived ");
				}else{
					jsonobj.put("Error", "Some error");
				}
			}
		}else{

		}
			return null;
	}
	
}	
