/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

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

/**
 * @author Wahab
 *
 */
public class SampleInvoiceLoadAction extends Action{
	HttpSession usersession;
	SampleInvoiceBo samplebo = new SampleInvoiceBoImpl();
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception, ServletException{
		usersession = request.getSession(false);
		if(usersession != null){
			return map.findForward("sampleinvoiceisloaded");
		}else{
			System.out.println("Error");
			return map.findForward("login");
		}
		
	}
}
