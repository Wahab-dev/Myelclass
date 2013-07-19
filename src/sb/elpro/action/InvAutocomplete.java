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
import sb.elpro.model.CustomerDetails;

/**
 * @author Wahab
 * 
 */
public class InvAutocomplete extends Action {
	InvoiceBo invbo = new InvoiceBoImpl();
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
