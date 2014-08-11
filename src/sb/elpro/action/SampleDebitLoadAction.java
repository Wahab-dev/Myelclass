/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.bo.SampleDebitBo;
import sb.elpro.bo.SampleDebitBoImpl;

/**
 * @author Wahab
 *
 */
public class SampleDebitLoadAction extends Action{
	HttpSession usersession;
	SampleDebitBo sampledebitbo = new SampleDebitBoImpl();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);
		if(!(usersession == null)){
			return mapping.findForward("sampledebitisloaded");
		}else{
			return mapping.findForward("logout");
		}
	}
}
