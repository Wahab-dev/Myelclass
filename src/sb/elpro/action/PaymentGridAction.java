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
import sb.elpro.bo.PaymentBo;
import sb.elpro.bo.PaymentBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public class PaymentGridAction extends Action{
	HttpSession usersession;
	PaymentBo paymnetbo = new PaymentBoImpl();
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
            //String sidx = request.getParameter("sidx");
            //String sord = request.getParameter("sord");
			String inv = request.getParameter("invno");
			
			System.out.println("inv N0 "+inv);
			System.out.println("action "+action);
			if(action.equalsIgnoreCase("loadGrid")){
				System.out.println("IN Payment LOAD GRID");
				String exporter = request.getParameter("exporter");
				List<DebitFormDetails> paylist = paymnetbo.getPaymentDebDetails(exporter);
				int records = paylist.size();
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
				jsonobj.put("rows", paylist);
				System.out.println(jsonobj);		
				out.println(jsonobj);
			}
		}
		return null;
	}
}
