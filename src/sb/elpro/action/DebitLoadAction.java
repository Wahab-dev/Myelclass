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

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.model.DebitFormDetails;

/**
 * @author Wahab
 *
 */
public class DebitLoadAction extends Action {

	HttpSession usersession;
	DebitBo debitbo = new DebitBoImpl();
	
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);
		if(!(usersession == null)){
			String action = request.getParameter("action");
			System.out.println("Debit  action PPP"+action);
			if(action == null){
				System.out.println("In Debit Load.....");
				usersession.setAttribute("debitactionform", "add");				
			}else{	
				System.out.println("In Debit Edit Form");
				String deb_debitno = request.getParameter("deb_debitno");
				usersession.setAttribute("debitactionform", "edit"); //
				
				usersession.setAttribute("editdebno", deb_debitno);
				List<DebitFormDetails> editdebform = debitbo.getEditDebFormValues(deb_debitno);
				usersession.setAttribute("invnoforedit", editdebform); 
				usersession.setAttribute("editdebform", editdebform);
			}
			return map.findForward("debitisloaded");
		}else{
			System.out.println("Error");
			return map.findForward("logout");
		}
	}
}
