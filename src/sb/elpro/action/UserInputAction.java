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

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import sb.elpro.bo.UserInputBo;
import sb.elpro.bo.UserInputBoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 *
 */
public class UserInputAction extends Action{
	UserInputBo userinputbo  =  new UserInputBoImpl();
		/* (non-Javadoc)
		 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			//usersession = request.getSession(false);
			PrintWriter out = response.getWriter();
			JSONObject jsonobj = new JSONObject();
			response.setContentType("application/json");
			
			String actn = request.getParameter("actn");
			String oper =   request.getParameter("oper");
			System.out.println("actn "+actn);
			System.out.println("oper "+oper);
			
			if(actn.equalsIgnoreCase("tan")){
				if(oper == null){
					List<TanneryDetails> tandetails = userinputbo.getTanneryDetails();
					int records = tandetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", tandetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{	
					TanneryDetails addtannerydetail = new TanneryDetails();
					 addtannerydetail.setTanneryName(request.getParameter("tanneryName"));
					 addtannerydetail.setTanneryAttention(request.getParameter("tanneryAttention")) ;
					 addtannerydetail.setTanneryAddress(request.getParameter("tanneryAddress")) ;
					 addtannerydetail.setTanneryContactNo(request.getParameter("tanneryContactNo"));
					 addtannerydetail.setTanneryShortForm(request.getParameter("tanneryShortForm"));
					 addtannerydetail.setTanneryFax(request.getParameter("tanneryFax"));
					 addtannerydetail.setTanneryId(request.getParameter("tanneryId"));
					 System.out.println("TANID "+request.getParameter("tanneryId"));
					 if(oper.equalsIgnoreCase("add")){
						boolean isaddedtandetails = userinputbo.addTanneryDetails(addtannerydetail);
						if(isaddedtandetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatedtandetails = userinputbo.editTanneryDetails(addtannerydetail);
						if(isupdatedtandetails){
							jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeletetandetails = userinputbo.delTanneryDetails(addtannerydetail);
						if(isdeletetandetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}
				}
				
			}else if(actn.equalsIgnoreCase("cust")){
				if(oper == null){
					List<CustomerDetails> custdetails = userinputbo.getCustomerDetails();
					int records = custdetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", custdetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{	
					CustomerDetails addcustdetail = new CustomerDetails();
					 addcustdetail.setCustomerName(request.getParameter("customerName"));
					 addcustdetail.setCustomerAttention(request.getParameter("customerAttention")) ;
					 addcustdetail.setCustomerAddress(request.getParameter("customerAddress")) ;
					 addcustdetail.setCustomerTelephone(request.getParameter("customerTelephone"));
					 addcustdetail.setCustomerShortForm(request.getParameter("customerShortForm"));
					 addcustdetail.setCustomerFax(request.getParameter("customerFax"));
					 addcustdetail.setCustomerId(request.getParameter("customerId"));
					 System.out.println("custid "+request.getParameter("customerId"));
					 if(oper.equalsIgnoreCase("add")){
						boolean isaddedcustdetails = userinputbo.addCustdetails(addcustdetail);
						if(isaddedcustdetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatedcustdetails = userinputbo.editCustDetails(addcustdetail);
						if(isupdatedcustdetails){
							jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeletecustdetails = userinputbo.delCustDetails(addcustdetail);
						if(isdeletecustdetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}
				}
			}else if(actn.equalsIgnoreCase("consig")){
				if(oper == null){
					List<ConsigneeDetails> consigdetails = userinputbo.getConsigneeDetails();
					int records = consigdetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", consigdetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{
					ConsigneeDetails addconsigdetail = new ConsigneeDetails();
					 addconsigdetail.setConsigneeName(request.getParameter("consigneeName"));
					 addconsigdetail.setConsigneeAttention(request.getParameter("consigneeAttention")) ;
					 addconsigdetail.setConsigneeAddress(request.getParameter("consigneeAddress")) ;
					 addconsigdetail.setConsigneeContactNo(request.getParameter("consigneeContactNo"));
					 addconsigdetail.setConsigneeShortForm(request.getParameter("consigneeShortForm"));
					 addconsigdetail.setConsigneefax(request.getParameter("consigneefax"));
					 addconsigdetail.setConsigneeId(request.getParameter("consigneeId"));
					 System.out.println("consigneeId "+request.getParameter("consigneeId"));
					if(oper.equalsIgnoreCase("add")){
						boolean isaddedconsigdetails = userinputbo.addConsigdetails(addconsigdetail);
						if(isaddedconsigdetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatedconsigdetails = userinputbo.editConsigDetails(addconsigdetail);
						if(isupdatedconsigdetails){
							jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeleteconsigdetails = userinputbo.delConsigDetails(addconsigdetail);
						if(isdeleteconsigdetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}
					
				}
			}else if(actn.equalsIgnoreCase("notify")){
				if(oper == null){
					List<NotifyConsigneeDetails> notifydetails = userinputbo.getNotifyDetails();
					int records = notifydetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", notifydetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{
					NotifyConsigneeDetails addnotifydetail = new NotifyConsigneeDetails();
					 addnotifydetail.setNotifyConsigneeName(request.getParameter("notifyConsigneeName"));
					 addnotifydetail.setNotifyConsigneeAttention(request.getParameter("notifyConsigneeAttention")) ;
					 addnotifydetail.setNotifyConsigneeAddress(request.getParameter("notifyConsigneeAddress")) ;
					 addnotifydetail.setNotifyConsigneeContactNo(request.getParameter("notifyConsigneeContactNo"));
					 addnotifydetail.setNotifyConsigneeShortForm(request.getParameter("notifyConsigneeShortForm"));
					 addnotifydetail.setNotifyConsigneefax(request.getParameter("notifyConsigneefax"));
					 addnotifydetail.setNotifyConsigneeId(request.getParameter("notifyConsigneeId"));
					 System.out.println("consigneeId "+request.getParameter("notifyConsigneeId"));
					if(oper.equalsIgnoreCase("add")){
						boolean isaddednotifydetails = userinputbo.addNotifydetails(addnotifydetail);
						if(isaddednotifydetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatednotifydetails = userinputbo.editNotifyDetails(addnotifydetail);
						if(isupdatednotifydetails){
							jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeletenotifydetails = userinputbo.delNotifyDetails(addnotifydetail);
						if(isdeletenotifydetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}
				}
			}else if(actn.equalsIgnoreCase("bank")){
				if(oper == null){
					List<BankDetails> bankdetails = userinputbo.getBankDetails();
					int records = bankdetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", bankdetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{
					BankDetails addbankdetail = new BankDetails();
					 addbankdetail.setBankId(request.getParameter("bankId"));
					 addbankdetail.setBankName(request.getParameter("bankName")) ;
					 addbankdetail.setBankAddress(request.getParameter("bankAddress")) ;
					 addbankdetail.setBankBranch(request.getParameter("bankBranch"));
					 addbankdetail.setBankSwiftCode(request.getParameter("bankSwiftCode"));
					 addbankdetail.setBankContactNo(request.getParameter("bankContactNo"));
					 addbankdetail.setBankFax(request.getParameter("bankFax"));
					 System.out.println("bankId "+request.getParameter("bankId"));
					if(oper.equalsIgnoreCase("add")){
						boolean isaddedbankdetails = userinputbo.addBankdetails(addbankdetail);
						if(isaddedbankdetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatedbankdetails = userinputbo.editBankDetails(addbankdetail);
						if(isupdatedbankdetails){
							jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeletebankdetails = userinputbo.delBankDetails(addbankdetail);
						if(isdeletebankdetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}
				}
			}else if(actn.equalsIgnoreCase("article")){
				if(oper == null){
					List<ArticleDetails> articledetails = userinputbo.getArticleDetails();
					int records = articledetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", articledetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{
					ArticleDetails addarticledetail = new ArticleDetails();
					 addarticledetail.setArticleid(request.getParameter("articleid"));
					 addarticledetail.setArticletype(request.getParameter("articletype")) ;
					 addarticledetail.setArticlename(request.getParameter("articlename")) ;
					 addarticledetail.setArticleshortform(request.getParameter("articleshortform"));
					 addarticledetail.setSize(request.getParameter("size"));
					 addarticledetail.setSubstance(request.getParameter("substance"));
					 addarticledetail.setRate(request.getParameter("rate"));
					 addarticledetail.setTc(request.getParameter("tc"));
					 System.out.println("articleid "+request.getParameter("articleid"));
					if(oper.equalsIgnoreCase("add")){
						boolean isaddedarticledetails = userinputbo.addArticledetails(addarticledetail);
						if(isaddedarticledetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatedarticledetails = userinputbo.editArticleDetails(addarticledetail);
						if(isupdatedarticledetails){
							jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeletearticledetails = userinputbo.delArticleDetails(addarticledetail);
						if(isdeletearticledetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}
				}
			}else if(actn.equalsIgnoreCase("comm")){
				if(oper == null){
					List<CommissionDetails> commdetails = userinputbo.getCommissionDetails();
					int records = commdetails.size();
					System.out.println("Reords  "+records);						
					String rows = request.getParameter("rows");
	                String pag = request.getParameter("page");
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
					jsonobj.put("rows", commdetails);
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{
					CommissionDetails addcommdetail = new CommissionDetails();
					 addcommdetail.setCommid(request.getParameter("commid"));
					 addcommdetail.setCommname(request.getParameter("commname")) ;
					 addcommdetail.setCommagent(request.getParameter("commagent")) ;
					 addcommdetail.setCommplace(request.getParameter("commplace"));
					 addcommdetail.setCommtype(request.getParameter("commtype"));
					 addcommdetail.setAgenttype(request.getParameter("agenttype"));
					 System.out.println("commname "+request.getParameter("commname"));
					 if(oper.equalsIgnoreCase("add")){
						boolean isaddedcommdetails = userinputbo.addCommdetails(addcommdetail);
						if(isaddedcommdetails){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
						boolean isupdatedcommdetails = userinputbo.editCommDetails(addcommdetail);
						if(isupdatedcommdetails){
						jsonobj.put("success", "Successfully Edited The Record");
						}else{
							jsonobj.put("Error", "Error in edititng");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isdeletecommdetails = userinputbo.delCommDetails(addcommdetail);
						if(isdeletecommdetails){
							jsonobj.put("success", "Successfully deleted The Record");
						}else{
							jsonobj.put("Error", "Error in deleteing");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
						}
				}
			}else{
			
				
				
			}
            return null;
		}
}
