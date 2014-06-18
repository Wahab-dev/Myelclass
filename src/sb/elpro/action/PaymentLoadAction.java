/**
* This class draws .
* @author Wahab
* @version 1.2
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

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.bo.PaymentBo;
import sb.elpro.bo.PaymentBoImpl;
import sb.elpro.model.DebitFormDetails;

/**
 * @author Wahab
 *
 */
public class PaymentLoadAction extends Action {

	HttpSession usersession;
	PaymentBo paymentbo = new PaymentBoImpl();

	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);	
		if(usersession !=null){		   	
			String action = request.getParameter("action");
			System.out.println("payment  action PPP"+action);
			if(action == null){
				System.out.println("In payment Load.....");
				usersession.setAttribute("payactionform", "add");
				
			}else{
				System.out.println("In payment Edit Form");
				String actionform = "edit";
				/*String deb_debitno = request.getParameter("deb_debitno");
				usersession.setAttribute("payactionform", actionform);
				usersession.setAttribute("editdebno", deb_debitno);
				List<DebitFormDetails> editpayform = paymentbo.getEditDebFormValues(deb_debitno);
				usersession.setAttribute("editpayform", editpayform);*/
			}
			return map.findForward("paymntisloaded");
		}else{
			System.out.println("Error");
			return map.findForward("logout");
		}
		
	}
}
