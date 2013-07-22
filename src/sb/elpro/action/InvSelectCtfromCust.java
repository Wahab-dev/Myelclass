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
import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.PrfArticle;
/**
 * @author Wahab
 *
 */
public class InvSelectCtfromCust extends Action {

	HttpSession usersession;
	InvoiceBo invbo = new InvoiceBoImpl();
	JSONObject jsonobj = new JSONObject();
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if(usersession != null){	
			String ctno = request.getParameter("ctno");
			String action = request.getParameter("action");
			String rows = request.getParameter("rows");
            String pag = request.getParameter("page");
            String sidx = request.getParameter("sidx");
            String sord = request.getParameter("sord");
			
            System.out.println("rows "+rows); //4
            System.out.println("page "+pag); //1
            System.out.println("sidx "+sidx);
            System.out.println("sord "+sord);
            System.out.println("ctno "+ctno);
			System.out.println("action "+action);
			if(action.equalsIgnoreCase("load")){
				String custid = request.getParameter("custid");
				System.out.println("Customer Id "+custid);
			
				List<CustomerInvoice> invctlist = invbo.getInvCustCtDetails(custid, sidx,sord);
				int records = invctlist.size();
				//jsonobj
				
				
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
				jsonobj.put("rows", invctlist);
				System.out.println(jsonobj);		
				out.println(jsonobj);
				/*
				JSONArray jsonOrderArray = JSONArray.fromObject(article);
				System.out.println(jsonOrderArray);					
		 		out.println(jsonOrderArray);*/
			
			}else if(action.equalsIgnoreCase("selectCt")){
				//List<CustomerInvoice> article = invbo.getInvCustCtDetails();
				//jsonobj
		   }
		}
		
		return null;
	}
}