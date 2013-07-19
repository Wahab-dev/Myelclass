/**
 * 
 */
package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;

/**
 * @author Wahab
 *
 */
public class PrfLoadAction extends Action{
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("IN LOAD");
		usersession = request.getSession(false);
		if(usersession != null){
			usersession.setAttribute("agentarray", prfbo.getAgentDetails());
			//usersession.setAttribute("tanneryarray", prfbo.getTanneryDetails());
			//usersession.setAttribute("customerarray", prfbo.getCustomerDetails());
			usersession.setAttribute("consigneearray", prfbo.getConsigneeDetails());
			usersession.setAttribute("notifyarray", prfbo.getNotifyDetails());			
			usersession.setAttribute("bankarray", prfbo.getBankDetails());
			usersession.setAttribute("destiarray", prfbo.getDestinationDetails());
			usersession.setAttribute("paymentarray", prfbo.getPaymentDetails());
			usersession.setAttribute("termsarray", prfbo.getTermsDetails());
			//usersession.setAttribute("commarray", prfbo.getCommissionDetails());	
			usersession.setAttribute("articlearray", prfbo.getarticledetails());
			usersession.setAttribute("colorarray", prfbo.getColorDetails());
			usersession.setAttribute("ratearray", prfbo.getRateDetails());
			usersession.setAttribute("selectionarray", prfbo.getSelectionDetails());
			usersession.setAttribute("shipmentarray", prfbo.getShipmentDetails());
			usersession.setAttribute("sizeremarkarray", prfbo.getSizeremarksDetails());
			usersession.setAttribute("tcagentarray", prfbo.getTcAgentDetails());
			return map.findForward("prfisloaded");
		}else{
			System.out.println("Error Invalid Session");
			return map.findForward("login");
		}	
	}
}
