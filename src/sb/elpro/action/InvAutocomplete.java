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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.InvoiceBo;
import sb.elpro.bo.InvoiceBoImpl;
import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.ExporterDetails;
import sb.elpro.model.NotifyConsigneeDetails;

/**
 * @author Wahab
 * 
 */
public class InvAutocomplete extends Action {
	InvoiceBo invbo = new InvoiceBoImpl();
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request,  HttpServletResponse response) throws Exception{
		 response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			usersession = request.getSession(false);
			if(usersession != null){
				String action = request.getParameter("action");
				if(action.equalsIgnoreCase("customer")){ 
					System.out.println("In Customer Autocomplete");
					String tanterm = request.getParameter("term");
					List<CustomerDetails> tannerylist =  invbo.getCustomerDetails(tanterm);
					System.out.println("List Value " +tannerylist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(tannerylist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("bank")) {
					System.out.println("In bank Autocomplete");
					String bankterm = request.getParameter("term");
					List<BankDetails> banklist =  prfbo.getbankDetails(bankterm);
					System.out.println("List Value " +banklist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(banklist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("notify")) {
					String notifyterm = request.getParameter("term");
					System.out.println("notifyterme"+notifyterm);
					List<NotifyConsigneeDetails> notifylist =  prfbo.getnotifyDetails(notifyterm);
					System.out.println("List Value " +notifylist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(notifylist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("exporter")) {
					System.out.println("In exporter Autocomplete");
					String expterm = request.getParameter("term");
					List<ExporterDetails> exprtrlist =  invbo.getInvExporter(expterm);
					System.out.println("List Value " +exprtrlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(exprtrlist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("loadctry")) {
					System.out.println("In loadctry Autocomplete");
					String loadctryterm = request.getParameter("term");
					List<DestinationDetails> loadctrylist =  invbo.getLoadinCtryName(loadctryterm);
					System.out.println("List Value " +loadctrylist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(loadctrylist);
					System.out.println(jsonOrdertanArray);
					out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("loadport")) {
					System.out.println("In loadport Autocomplete");
					String loadportterm = request.getParameter("term");
					String ctryvalterm = request.getParameter("ctryval");
					List<DestinationDetails> loadporttermlist =  invbo.getLoadinPortName(loadportterm, ctryvalterm);
					System.out.println("List Value " +loadporttermlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(loadporttermlist);
					System.out.println(jsonOrdertanArray);
					out.println(jsonOrdertanArray);
				}
				else{
					/*
					 * Here i am using first letter enter from the Entry using request .getparamanter 
					 * and passing the value
					 * 
					 */
					/*String term = request.getParameter("term");
					System.out.println(" Term "+term);
				//	List<AutoComplete> destinationlist =  invbo.getDestinationDetails(term);
					System.out.println("List Value " +destinationlist.size());
					JSONArray jsonOrderArray = JSONArray.fromObject(destinationlist);
					 System.out.println(jsonOrderArray);
			 		out.println(jsonOrderArray);*/
					}
				 out.close();
			}else{
				System.out.println("Invalid User pls Login Again");
				return mapping.findForward("login");
			}
			
		return null;
	}
}
