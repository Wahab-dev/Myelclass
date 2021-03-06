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
import sb.elpro.model.Invpaymentdetails;
import sb.elpro.model.SampleDebBean;
import sb.elpro.utility.DateConversion;

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
			}else if(action.equalsIgnoreCase("paymnt")){
				String oper = request.getParameter("oper");
				System.out.println("In Pymenbt Recieved ");
				Invpaymentdetails invpay = new Invpaymentdetails();				
				invpay.setInvno(request.getParameter("invno"));
				invpay.setInvtotamt(request.getParameter("invtotamount"));
				invpay.setDeduction(request.getParameter("deduction"));
				invpay.setBankcharge(request.getParameter("bankcharge"));
				invpay.setAmtrecieved(request.getParameter("amtrecieved"));
				invpay.setBalanceamt(request.getParameter("balanceamt"));
				invpay.setExchngrate(request.getParameter("exchngrate"));
				invpay.setAmtininr(request.getParameter("amtininr"));
				invpay.setRecieptdate(DateConversion.ConverttoMysqlDate(request.getParameter("recieptdate")));
				invpay.setRemarks(request.getParameter("remarks"));
				if(oper.equalsIgnoreCase("addpay")){
					boolean isAddedPaymnet = invtrackbo.addPayment(invpay);
					if(isAddedPaymnet){
						jsonobj.put("success", "Successfully Edited The Record");
					}else{
						jsonobj.put("Error", "Error in Editing");
					}
				}else{
					boolean isPaymnetUpdated = invtrackbo.editPayment(invpay);
					if(isPaymnetUpdated){
						jsonobj.put("success", "Successfully Inserted The Record");
					}else{
						jsonobj.put("Error", "Error in Inserrting");
					}
				}
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
