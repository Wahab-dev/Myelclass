/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		usersession = request.getSession(false);
		if(!(usersession == null)){	
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
				String custid = request.getParameter("custid");
				String type = request.getParameter("type");
				System.out.println("custid  "+custid);			
				System.out.println("type"+type);
				
				List<CustomerInvoice> invctlist = invbo.getInvCustCtDetails(custid, type, sidx,sord);
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
				String type = request.getParameter("type");
				System.out.println("type))))))"+type);
				
				List<ArticleDetails> invctlist = invbo.getInvSelCtDetails(ctno,type);
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
			   invbill.setInvunit(request.getParameter("unit"));
			   invbill.setInvqty(request.getParameter("quantity"));
			   invbill.setInvrate(request.getParameter("rate"));
			   invbill.setInvqshpd(request.getParameter("qshipped"));
			   invbill.setInvqbal(request.getParameter("qbal"));
			   invbill.setInvamt(request.getParameter("amount"));
			   invbill.setInvtc(request.getParameter("tc"));
			   invbill.setInvpcs(request.getParameter("pieces"));
			   System.out.println("TC"+request.getParameter("tc"));
			   System.out.println("pieces"+request.getParameter("pieces"));// 
			   invbill.setInvartid(request.getParameter("prfarticleid"));
			   invbill.setInvno(request.getParameter("invoiceno"));
			   invbill.setInvtype(request.getParameter("invoicetype"));
			   invbill.setInvdt(request.getParameter("invoicedt"));
			   invbill.setUser(request.getParameter("user"));
			   invbill.setInvcomm(request.getParameter("commission"));
			   invbill.setInvothercomm(request.getParameter("othercommission"));
			   			   
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
			   String type = request.getParameter("type");
				System.out.println("type00000000s"+type);
			   /*  String invtype = request.getParameter("invoicetype");*/
			   if(oper == null){ // Load Operation
				   	 String totqtyshpd ="";
	         		 String totpcs = "";
	         		 String totamt ="";
					List<InvBillDetails> invbilllist = invbo.getInvBillDetails(invno,ctno,type);
			   		int records = invbilllist.size();
			   		int page = Integer.parseInt(pag);
		            int totalPages = 0;
		            int totalCount = records;
		            
		            /*
		             * For tot Amt
		             */
		            List<InvBillDetails> invtotamt = invbo.getInvBillTotAmt(invno);
		            Iterator<InvBillDetails> iter = invtotamt.iterator();  
		            while(iter.hasNext()){                
		            	InvBillDetails invtotamtBean = iter.next();
		            	totqtyshpd  = invtotamtBean.getInvqty();
			        	totpcs  = invtotamtBean.getInvpcs();
			        	totamt = invtotamtBean.getInvamt(); 
			        	System.out.println("Tot QTY LIS "+totqtyshpd);
			        	System.out.println("Tot PCs LIS "+totpcs);
			        	System.out.println("Tot Amt LIS "+totamt);
			        }
				
				
				   JSONObject totobj = new JSONObject();
				   totobj.put("invqshpd", totqtyshpd);
				   totobj.put("invpcs", totpcs);
				   totobj.put("invamt", totamt);
		            if (totalCount > 0) {
		               	 if(totalCount % Integer.parseInt(rows) == 0) {
		               		 	totalPages = totalCount / Integer.parseInt(rows);
		                  } else {
		                        totalPages = (totalCount / Integer.parseInt(rows)) + 1;
		                  }
		             }else {
		                   totalPages = 0;
		             }
		            jsonobj.put("total", totalPages);
					jsonobj.put("page", page);
					jsonobj.put("records", records);
					jsonobj.put("rows", invbilllist);
					jsonobj.accumulate("userdata", totobj);
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
				   invaddagainbill.setInvunit(request.getParameter("invunit"));
				   invaddagainbill.setInvqty(request.getParameter("invqty"));
				   invaddagainbill.setInvpcs(request.getParameter("invpcs"));
				   invaddagainbill.setInvrate(request.getParameter("invrate"));
				   invaddagainbill.setInvqshpd(request.getParameter("invqshpd"));
				   invaddagainbill.setInvqbal(request.getParameter("invqbal"));
				   invaddagainbill.setInvamt(request.getParameter("invamt"));
				   invaddagainbill.setInvtc(request.getParameter("invtc"));
				   invaddagainbill.setInvartid(request.getParameter("invartid"));
				   invaddagainbill.setInvno(request.getParameter("invno"));
				   invaddagainbill.setInvdt(request.getParameter("invdt"));
				   invaddagainbill.setInvid(request.getParameter("invid"));
				   invaddagainbill.setInvcomm(request.getParameter("invcomm"));
				   invaddagainbill.setInvothercomm(request.getParameter("invothercomm"));
				   invaddagainbill.setUser(request.getParameter("invuser"));
				   
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
		}else{
			System.out.println("Invalid User pls Login Again");
			return map.findForward("logout");
		}
		return null;
	}
}
