/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.PrintWriter;
import java.util.Iterator;
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
import sb.elpro.bo.SampleInvoiceBo;
import sb.elpro.bo.SampleInvoiceBoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public class SampleInvSelectCtfromCust extends Action {

	HttpSession usersession;
	SampleInvoiceBo saminvbo = new SampleInvoiceBoImpl();
	JSONObject jsonobj = new JSONObject();
	
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
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
			
			/*
			 *  Grid  -1 - invctgrid 
			 *  Loads the Customers Sample Details 
			 */	
			if(action.equalsIgnoreCase("load")){
				String custname = request.getParameter("custname");
				String type = request.getParameter("type");
				System.out.println("custname  "+custname);			
				System.out.println("type"+type);
				
				List<CustomerInvoice> saminvctlist = saminvbo.getSamInvCustsampleDetails(custname, type, sidx,sord);
				int records = saminvctlist.size();
						
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
				jsonobj.put("rows", saminvctlist);
				System.out.println(jsonobj);		
				out.println(jsonobj);
			}else  if(action.equalsIgnoreCase("loadsubgrid")){
				String samno = request.getParameter("samno");
				System.out.println("samno Id "+samno);		
				String type = request.getParameter("type");
				System.out.println("type))))))"+type);
				
				List<ArticleDetails> saminvctlist = saminvbo.getInvSelSampleDetails(samno, type);
				int records = saminvctlist.size();
				
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
				jsonobj.put("rows", saminvctlist);
				System.out.println(jsonobj);		
				out.println(jsonobj);	
			}else if(action.equalsIgnoreCase("addBill")){
				System.out.println(" In Add Bill Details s");
				   InvBillDetails saminvbill = new InvBillDetails();
				   saminvbill.setInvctno(request.getParameter("sampleno"));
				   saminvbill.setInvcolor(request.getParameter("color"));
				   saminvbill.setInvartname(request.getParameter("articlename"));
				   saminvbill.setInvsize(request.getParameter("size"));
				   saminvbill.setInvsubs(request.getParameter("substance"));
				   saminvbill.setInvselc(request.getParameter("selection"));
				   saminvbill.setInvunit(request.getParameter("unit"));
				   saminvbill.setInvqty(request.getParameter("quantity"));
				   saminvbill.setInvrate(request.getParameter("rate"));
				   saminvbill.setInvqshpd(request.getParameter("qshipped"));
				   saminvbill.setInvqbal(request.getParameter("qbal"));
				   saminvbill.setInvamt(request.getParameter("amount"));
				   saminvbill.setInvpcs(request.getParameter("pieces"));
				   System.out.println("pieces"+request.getParameter("pieces"));
				   saminvbill.setInvartid(request.getParameter("srfarticleid"));
				   saminvbill.setInvno(request.getParameter("saminvoiceno"));
				   saminvbill.setInvtype(request.getParameter("saminvoicetype"));
				   saminvbill.setInvdt(request.getParameter("saminvoicedt"));
				   String oper = request.getParameter("oper");
				   if(oper.equalsIgnoreCase("edit")){
					   /*
					    * Perform Edit Function
					    */
				   }else if(oper.equalsIgnoreCase("add")){//Grid 2 - Add Bill. For the 1 Grade 
					   boolean saminvbilllist = saminvbo.getSampleInvAddBillDetails(saminvbill);
					   if(saminvbilllist){
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
			}
			else if(action.equalsIgnoreCase("loadBill")){
				String invno = request.getParameter("saminvno");
				System.out.println("Sample Inv No "+invno);
				String samno = request.getParameter("samno");
				String oper = request.getParameter("oper");
				String type = request.getParameter("type");
				System.out.println("type00000000s"+type);
				   if(oper == null){ // Load Operation
					   	 String totqtyshpd ="";
		         		 String totpcs = "";
		         		 String totamt ="";
						List<InvBillDetails> saminvbilllist = saminvbo.getSamInvBillDetails(invno,samno,type);
				   		int records = saminvbilllist.size();
				   		int page = Integer.parseInt(pag);
			            int totalPages = 0;
			            int totalCount = records;
			            
			            /*
			             * For tot Amt
			             */
			            List<InvBillDetails> saminvtotamt = saminvbo.getSamInvBillTotAmt(invno);
			            Iterator<InvBillDetails> iter = saminvtotamt.iterator();  
			            while(iter.hasNext()){                
			            	InvBillDetails invtotamtBean = iter.next();
			            	totqtyshpd  = invtotamtBean.getInvqty();
				        	totpcs  = invtotamtBean.getInvpcs();
				        	totamt = invtotamtBean.getInvamt(); 
				        	System.out.println("SAm Tot QTY LIS "+totqtyshpd);
				        	System.out.println("SAm Tot PCs LIS "+totpcs);
				        	System.out.println("SAm Tot Amt LIS "+totamt);
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
						jsonobj.put("rows", saminvbilllist);
						jsonobj.accumulate("userdata", totobj);
						System.out.println(jsonobj);		
						out.println(jsonobj);	
				   }else{
					   // Option For Add, Edit , Del
					   InvBillDetails saminvaddagainbill = new InvBillDetails();
					   saminvaddagainbill.setInvctno(request.getParameter("invctno"));
					   System.out.println(" invctno"+saminvaddagainbill.getInvctno());
					   saminvaddagainbill.setInvcolor(request.getParameter("invcolor"));
					   saminvaddagainbill.setInvartname(request.getParameter("invartname"));
					   saminvaddagainbill.setInvsize(request.getParameter("invsize"));
					   saminvaddagainbill.setInvsubs(request.getParameter("invsubs"));
					   saminvaddagainbill.setInvselc(request.getParameter("invselc"));
					   saminvaddagainbill.setInvunit(request.getParameter("invunit"));
					   saminvaddagainbill.setInvqty(request.getParameter("invqty"));
					   saminvaddagainbill.setInvpcs(request.getParameter("invpcs"));
					   saminvaddagainbill.setInvrate(request.getParameter("invrate"));
					   saminvaddagainbill.setInvqshpd(request.getParameter("invqshpd"));
					   System.out.println(" invqshpd"+saminvaddagainbill.getInvqshpd());
					   saminvaddagainbill.setInvqbal(request.getParameter("invqbal"));
					   System.out.println(" invqbal"+saminvaddagainbill.getInvqbal());
					   saminvaddagainbill.setInvamt(request.getParameter("invamt"));
					   System.out.println(" invamt"+saminvaddagainbill.getInvamt());
					   saminvaddagainbill.setInvartid(request.getParameter("invartid"));
					   saminvaddagainbill.setInvno(request.getParameter("invno"));
					   saminvaddagainbill.setInvdt(request.getParameter("invdt"));
					   saminvaddagainbill.setInvid(request.getParameter("invid"));
					   
				   	   if(oper.equalsIgnoreCase("add")){
				   		   /*
				   		    * Add Second Shipmemnt for the same article 
				   		    */
				   		 boolean saminvbillsecondaddlist = saminvbo.getSamInvBillAddDetails(saminvaddagainbill);
				   		 if(saminvbillsecondaddlist){
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
				   		 boolean saminvbilleditlist = saminvbo.getSamInvBillEditDetails(saminvaddagainbill);
				   		 if(saminvbilleditlist){
							   jsonobj.clear();
							   jsonobj.put("Success", "Successfully Edited The Record");	
							   out.println(jsonobj);	
						 }else{
								jsonobj.clear();
								jsonobj.put("Error", "Error in Edited the Record ");	
								out.println(jsonobj);	
						}	
				   	   }else{
					   		 boolean saminvbilldellist = saminvbo.getSamInvBillDelDetails(saminvaddagainbill);
					   		 if(saminvbilldellist){
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
				
			}
		}else{
			System.out.println("Invalid User pls Login Again");
			return map.findForward("login");
		}
		
		return null;
	}
}
