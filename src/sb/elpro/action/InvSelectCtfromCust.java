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

import sb.elpro.bo.BulkBo;
import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.InvoiceTotAmtDetails;
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
			
			/*
			 *  Grid  -1 - invctgrid 
			 *  Loads the Customers Ct Details 
			 */
			if(action.equalsIgnoreCase("load")){
				String custname = request.getParameter("custname");
				System.out.println("custname  "+custname);			
				List<CustomerInvoice> invctlist = invbo.getInvCustCtDetails(custname, sidx,sord);
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
			}else if(action.equalsIgnoreCase("loadsubgrid")){ //Grid 2 -  loads the Subgrid. based on Selected Ct Details
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
		   }else if(action.equalsIgnoreCase("addBill")){ //Grid 2 - Load Ct Details.
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
			   invbill.setInvartid(request.getParameter("prfarticleid"));
			   invbill.setInvno(request.getParameter("invoiceno"));
			   invbill.setInvtype(request.getParameter("invoicetype"));
			   invbill.setInvdt(request.getParameter("invoicedt"));
			   String oper = request.getParameter("oper");
			   if(oper.equalsIgnoreCase("edit")){
				   /*
				    * Perform Edit Function
				    */
			   }else if(oper.equalsIgnoreCase("add")){//Grid 2 - Add Bill. For the 1 Grade 
				   boolean invbilllist = invbo.getInvAddBillDetails(invbill);
				   if(invbilllist){
					   jsonobj.clear();
					   jsonobj.put("Success", "Successfully Inserted The Record");	
					   out.println(jsonobj);	
					}else{
						jsonobj.clear();
						jsonobj.put("Error", "Error in Inserting the Record ");	
						out.println(jsonobj);	
					}
				   
			   }else{
				   /*
				    * Perform Delete Function
				    */
			   }
               
   			 
				
		   }else if(action.equalsIgnoreCase("loadBill")){ //Loads Grid 3 - Calls Immediately after Load 2 Add Method 
			   String invno = request.getParameter("invno");
			   String ctno = request.getParameter("ctno");
			   String oper = request.getParameter("oper");
			   /*  String invtype = request.getParameter("invoicetype");*/
			   if(oper == null){ // Load Operation
					List<InvBillDetails> invbilllist = invbo.getInvBillDetails(invno,ctno);
			   		int records = invbilllist.size();
			   		int page = Integer.parseInt(pag);
		            int totalPages = 0;
		            int totalCount = records;
		            
		            
		            List<InvoiceTotAmtDetails> invtotamt = invbo.getInvBillTotAmt(invno);
		            
		            
		            if (totalCount > 0) {
		               	 if(totalCount % Integer.parseInt(rows) == 0) {
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
			   }else{ // Option For Add, Edit , Del
				   InvBillDetails invaddagainbill = new InvBillDetails();
				   invaddagainbill.setInvctno(request.getParameter("invctno"));
				   invaddagainbill.setInvcolor(request.getParameter("invcolor"));
				   invaddagainbill.setInvartname(request.getParameter("invartname"));
				   invaddagainbill.setInvsize(request.getParameter("invsize"));
				   invaddagainbill.setInvsubs(request.getParameter("invsubs"));
				   invaddagainbill.setInvselc(request.getParameter("invselc"));
				   invaddagainbill.setInvqty(request.getParameter("invqty"));
				   invaddagainbill.setInvrate(request.getParameter("invrate"));
				   invaddagainbill.setInvqshpd(request.getParameter("invqshpd"));
				   invaddagainbill.setInvqbal(request.getParameter("invqbal"));
				   invaddagainbill.setInvamt(request.getParameter("invamt"));
				   invaddagainbill.setInvtc(request.getParameter("invtc"));
				   invaddagainbill.setInvartid(request.getParameter("invartid"));
				   invaddagainbill.setInvno(request.getParameter("invno"));
				   invaddagainbill.setInvdt(request.getParameter("invdt"));
				   invaddagainbill.setInvid(request.getParameter("invid"));
				   
			   	   if(oper.equalsIgnoreCase("add")){
			   		   /*
			   		    * Add Second Shipmemnt for the same article 
			   		    */
			   		 boolean invbillsecondaddlist = invbo.getInvBillAddDetails(invaddagainbill);
			   		 if(invbillsecondaddlist){
						   jsonobj.clear();
						   jsonobj.put("Success", "Successfully Inserted The Record");	
						   out.println(jsonobj);	
					 }else{
							jsonobj.clear();
							jsonobj.put("Error", "Error in Inserting the Record ");	
							out.println(jsonobj);	
					}	
			   	   }else if(oper.equalsIgnoreCase("edit")){
			   		/*
			   		    * Edit Second Shipmemnt for the same article 
			   		    */
			   		 boolean invbilleditlist = invbo.getInvBillEditDetails(invaddagainbill);
			   		 if(invbilleditlist){
						   jsonobj.clear();
						   jsonobj.put("Success", "Successfully Edited The Record");	
						   out.println(jsonobj);	
					 }else{
							jsonobj.clear();
							jsonobj.put("Error", "Error in Edited the Record ");	
							out.println(jsonobj);	
					}	
			   	   }else{
				   		 boolean invbilldellist = invbo.getInvBillDelDetails(invaddagainbill);
				   		 if(invbilldellist){
							   jsonobj.clear();
							   jsonobj.put("Success", "Successfully Deleted The Record");	
							   out.println(jsonobj);	
						 }else{
								jsonobj.clear();
								jsonobj.put("Error", "Error in Deleted the Record ");	
								out.println(jsonobj);	
						}	
				   	   }
		   }
		   }else if(action.equalsIgnoreCase("editBill")) {
			   System.out.println("In EDit MOde OF ADD BILLL ");
		   }
		}
		
		return null;
	}
}
