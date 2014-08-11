/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.SampleInvoiceBo;
import sb.elpro.bo.SampleInvoiceBoImpl;
import sb.elpro.model.SampleInvoiceBean;
import sb.elpro.model.SampleRequest;

/**
 * @author Wahab
 *
 */
public class SampleInvoiceLoadAction extends Action{
	HttpSession usersession;
	SampleInvoiceBo sampleinvbo = new SampleInvoiceBoImpl();
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception, ServletException{
		usersession = request.getSession(false);
		if(!(usersession == null)){
			String action = request.getParameter("action");
			System.out.println("STR  action"+action);
			if(action == null){
				usersession.setAttribute("sampleinvactionform", "add");
				System.out.println("IN  Sample Invoice");
			}else if(action.equalsIgnoreCase("editsaminvform")){
				System.out.println("In Sample Invoice Edit Form");
				String actionform = "edit";
				String saminvno = request.getParameter("invno");
				usersession.setAttribute("sampleinvactionform", actionform);
				usersession.setAttribute("editsaminvno", saminvno);
				List<SampleInvoiceBean> editSamInvform = sampleinvbo.getEditSamInvFormValues(saminvno);
				usersession.setAttribute("editsaminvform", editSamInvform);
				
			}
			return map.findForward("sampleinvoiceisloaded");
		}else{
			System.out.println("Error");
			return map.findForward("logout");
		}
	}
}
