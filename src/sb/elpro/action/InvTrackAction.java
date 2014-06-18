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


import sb.elpro.bo.InvoiceTrackBo;
import sb.elpro.bo.InvoiceTrackBoImpl;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public class InvTrackAction extends Action {
	HttpSession usersession;
	InvoiceTrackBo invtrackbo = new InvoiceTrackBoImpl();
	JSONObject jsonobj = new JSONObject();
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {		
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(usersession != null){
			String action = request.getParameter("action");
			String rows = request.getParameter("rows");
            String pag = request.getParameter("page");
            String sidx = request.getParameter("sidx");
            String sord = request.getParameter("sord");
			
            System.out.println("rows "+rows); //4
            System.out.println("page "+pag); //1
            System.out.println("sidx "+sidx);
            System.out.println("sord "+sord);
           // System.out.println("ctno "+ctno);
			System.out.println("action "+action);
			
			if(action.equalsIgnoreCase("load")){
				List<InvBillDetails> invtracklist = invtrackbo.getInvTrackDetails();
				int records = invtracklist.size();
				
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
				jsonobj.put("rows", invtracklist);
				System.out.println(jsonobj);		
				out.println(jsonobj);				
			}
			
		}else{
			System.out.println("Invalid User pls Login Again");
			return map.findForward("logout");
		}
		return  null;
	}
	
}
