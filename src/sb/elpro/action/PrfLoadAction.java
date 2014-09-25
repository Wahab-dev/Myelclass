/**
 * 
 */
package sb.elpro.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.PrfForm;
import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.ProductDetails;

import net.sf.json.JSONObject;

/**
 * @author Wahab
 *
 */
public class PrfLoadAction extends Action{
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	JSONObject jsonobj = new JSONObject();
	
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);
		if(!(usersession == null)){
			String action = request.getParameter("action");
			System.out.println("action value "+action);
			/*usersession.setAttribute("paymentarray", prfbo.getPaymentDetails());
			usersession.setAttribute("termsarray", prfbo.getTermsDetails());	
			usersession.setAttribute("colorarray", prfbo.getColorDetails());
			usersession.setAttribute("ratearray", prfbo.getRateDetails());
			usersession.setAttribute("selectionarray", prfbo.getSelectionDetails());
			usersession.setAttribute("shipmentarray", prfbo.getShipmentDetails());
			usersession.setAttribute("sizeremarkarray", prfbo.getSizeremarksDetails());
			usersession.setAttribute("tcagentarray", prfbo.getTcAgentDetails());
*/			
			if(action == null){ // Check for Null Values 
				/*
				 * Method to Set Values for PRF FORM
				 */
				usersession.setAttribute("prfactionform", "add");
				System.out.println("IN PRF IS LOADED");
				
				
//				System.out.println("In Edit Form");
//				String ctno = request.getParameter("ctno");
//				usersession.setAttribute("prfactionform", "edit");
//				request.setAttribute("editprfctno", ctno);
//				List<ProductDetails> editprfform = prfbo.getEditPrfFormValues(ctno);
//				usersession.setAttribute("editprfform", editprfform);
//				return map.findForward("prfisloaded");
			}else{
				System.out.println("In Edit Form");
				String ctno = request.getParameter("ctno");
				usersession.setAttribute("prfactionform", "edit");
				request.setAttribute("editprfctno", ctno);
				List<ProductDetails> editprfform = prfbo.getEditPrfFormValues(ctno);
				usersession.setAttribute("editprfform", editprfform);
				return map.findForward("prfisloaded");
			}
			return map.findForward("prfisloaded");
		}else{
			System.out.println("Error Invalid Session");
			return map.findForward("logout");
		}	
	}
	
}
