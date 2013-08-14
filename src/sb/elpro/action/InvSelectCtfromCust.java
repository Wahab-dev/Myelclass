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

import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;
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
			//String ctno = request.getParameter("ctno");
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
				String custid = request.getParameter("custid");
				System.out.println("Customer Id "+custid);			
				List<CustomerInvoice> invctlist = invbo.getInvCustCtDetails(custid, sidx,sord);
				int records = invctlist.size();
				
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
			}else if(action.equalsIgnoreCase("loadsubgrid")){
				String ctno = request.getParameter("ctno");
				System.out.println("ctno Id "+ctno);			
				List<ArticleDetails> invctlist = invbo.getInvSelCtDetails(ctno);
				int records = invctlist.size();
				
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
		   }else if(action.equalsIgnoreCase("addBill")){
			   System.out.println(" In Add Bill Details s");
			   InvBillDetails invbill = new InvBillDetails();
			  
			   invbill.setInvctno(request.getParameter("contractno"));
			   invbill.setInvcolor(request.getParameter("color"));
			   invbill.setInvartname(request.getParameter("articlename"));
			   invbill.setInvsize(request.getParameter("size"));
			   invbill.setInvsubs(request.getParameter("substance"));
			   invbill.setInvselc(request.getParameter("selection"));
			   invbill.setInvqty(request.getParameter("quantity"));
			   invbill.setInvrate(request.getParameter("rate"));
			   invbill.setInvqshpd(request.getParameter("qshipped"));
			   invbill.setInvqbal(request.getParameter("qbal"));
			   invbill.setInvamt(request.getParameter("amount"));
			   invbill.setInvtc(request.getParameter("tc"));
			   invbill.setInvartid(request.getParameter("articleid"));
			  // invbill.setInv(request.getParameter("id"));
			   //invbill.setInvctno(request.getParameter("ctno"));
			   
			   
			  // String oper = request.getParameter("oper");
			   //if(oper.equalsIgnoreCase("edit")){
               int invbilllist = invbo.getInvAddBillDetails(invbill);
   			  // int records = invbilllist.size();
			  /* int page = Integer.parseInt(pag);
               int totalPages = 0;
               int totalCount = 0;
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
               
               jsonobj.put("total", 1);
				jsonobj.put("page", 1);
				jsonobj.put("records", 1);
				jsonobj.put("rows", 1);*/
				System.out.println(invbilllist);		
				out.println(invbilllist);	
		   }else if(action.equalsIgnoreCase("loadBill")){
			   String invno = request.getParameter("invno");
			   System.out.println("invno"+invno);
			   List<InvBillDetails> invbilllist = invbo.getInvBillDetails(invno);
			   int records = invbilllist.size();
				
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
				jsonobj.put("rows", invbilllist);
				System.out.println(jsonobj);		
				out.println(jsonobj);	
		   }else if(action.equalsIgnoreCase("editBill")) {
			   System.out.println("In EDit MOde OF ADD BILLL ");
		   }
		}
		
		return null;
	}
}
