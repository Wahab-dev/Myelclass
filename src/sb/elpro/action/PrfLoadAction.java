/**
 * 
 */
package sb.elpro.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.PrfForm;
import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.ProductDetails;

/**
 * @author Wahab
 *
 */
public class PrfLoadAction extends DispatchAction{
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	JSONObject jsonobj = new JSONObject();
	
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("In PRf Load");
		usersession = request.getSession(false);
		if(usersession != null){
			String action = request.getParameter("action");
			System.out.println("Bulb  action"+action);
			
			usersession.setAttribute("paymentarray", prfbo.getPaymentDetails());
			usersession.setAttribute("termsarray", prfbo.getTermsDetails());	
			usersession.setAttribute("colorarray", prfbo.getColorDetails());
			usersession.setAttribute("ratearray", prfbo.getRateDetails());
			usersession.setAttribute("selectionarray", prfbo.getSelectionDetails());
			usersession.setAttribute("shipmentarray", prfbo.getShipmentDetails());
			usersession.setAttribute("sizeremarkarray", prfbo.getSizeremarksDetails());
			usersession.setAttribute("tcagentarray", prfbo.getTcAgentDetails());
			if(action == null){
				PrfForm prfsaveform =(PrfForm) form;
				usersession.setAttribute("actionform", "add");
				System.out.println("IN PRF IS LOADED");
				prfsaveform.reset(map, request);
				return map.findForward("prfisloaded");
			}else if(action.equalsIgnoreCase("editform")){
				/*
				 * Method to Set Values for PRF FORM
				 */
				System.out.println("Session value");
				System.out.println("In Edit Form");
				String ctno = request.getParameter("ctno");
				usersession.setAttribute("actionform", "edit");
				request.setAttribute("editprfctno", ctno);
				List<ProductDetails> editprfform = prfbo.getEditPrfFormValues(ctno);
				usersession.setAttribute("editprfform", editprfform);
				
				return map.findForward("prfisloaded");
			}
			return map.findForward("prfisloaded");
		}else{
			System.out.println("Error Invalid Session");
			return map.findForward("login");
		}	
	}
	/*public ActionForward editform(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("What The Hell IS This >>>>>");
		
		return null;
	}*/
}
