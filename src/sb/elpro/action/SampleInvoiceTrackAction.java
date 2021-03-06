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

import sb.elpro.bo.SampleInvoiceTrackBo;
import sb.elpro.bo.SampleInvoiceTrackBoImpl;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public class SampleInvoiceTrackAction extends Action{
	HttpSession usersession;
	SampleInvoiceTrackBo saminvtrackbo = new SampleInvoiceTrackBoImpl();
	JSONObject jsonobj = new JSONObject();
	 /* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		usersession = request.getSession(false);
		if(!(usersession == null)){
			String action = request.getParameter("action");
			String rows = request.getParameter("rows");
            String pag = request.getParameter("page");
            String sidx = request.getParameter("sidx");
            String sord = request.getParameter("sord");
			
            System.out.println("rows "+rows); //4
            System.out.println("page "+pag); //1
            System.out.println("sidx "+sidx);
            System.out.println("sord "+sord);
			System.out.println("action "+action);
			if(action.equalsIgnoreCase("load")){
				List<InvBillDetails> sampleinvtracklist = saminvtrackbo.getSamInvTrackDetails();
				int records = sampleinvtracklist.size();
				
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
				jsonobj.put("rows", sampleinvtracklist);
				System.out.println(jsonobj);		
				out.println(jsonobj);	
			}
		}else{
			System.out.println("invalid User Credentials ");
			mapping.findForward("logout");
		}
		return null;
	}
}
