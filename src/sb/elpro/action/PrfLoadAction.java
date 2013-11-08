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

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.PrfArticle;
import sb.elpro.model.ProductDetails;

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
		System.out.println("In PRf Load");
		usersession = request.getSession(false);
		if(usersession != null){
			usersession.setAttribute("agentarray", prfbo.getAgentDetails());
			usersession.setAttribute("destiarray", prfbo.getDestinationDetails());
			usersession.setAttribute("paymentarray", prfbo.getPaymentDetails());
			usersession.setAttribute("termsarray", prfbo.getTermsDetails());	
			//usersession.setAttribute("articlearray", prfbo.getarticledetails());
			usersession.setAttribute("colorarray", prfbo.getColorDetails());
			usersession.setAttribute("ratearray", prfbo.getRateDetails());
			usersession.setAttribute("selectionarray", prfbo.getSelectionDetails());
			usersession.setAttribute("shipmentarray", prfbo.getShipmentDetails());
			usersession.setAttribute("sizeremarkarray", prfbo.getSizeremarksDetails());
			usersession.setAttribute("tcagentarray", prfbo.getTcAgentDetails());
			String action = request.getParameter("action");
			System.out.println("Bulb  action"+action);
			
			if(action == null){
				return map.findForward("prfisloaded");
			}else if(action.equalsIgnoreCase("editform")){
				/*
				 * Method to Set Values for PRF FORM
				 */
				System.out.println("In Edit Form");
				String actionform = "edit";
				String ctno = request.getParameter("ctno");
				usersession.setAttribute("actionform", actionform);
				usersession.setAttribute("editprfctno", ctno);
				//usersession.setAttribute("editprfform", prfbo.getEditPrfFormValues(ctno));
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
}
