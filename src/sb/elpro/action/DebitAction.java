/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;

/**
 * @author Wahab
 *
 */
public class DebitAction extends DispatchAction {
	HttpSession usersession;
	DebitBo debbo = new DebitBoImpl();
	/*public ActionForward Load(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
		if(usersession != null){
			usersession.setAttribute("DebExporter",debbo.getDebExporter());
			usersession.setAttribute("DebTanInvno",debbo.getDebTanInvno());
			usersession.setAttribute("invBank",invbo.getInvBank());
			usersession.setAttribute("invLoadingPort",invbo.getInvLoadingPort());
			usersession.setAttribute("invCountryFinalDesti",invbo.getInvFinalDestinationCountry());
			usersession.setAttribute("invFinalDestination",invbo.getInvFinalDestination());
			usersession.setAttribute("invDischargeport",invbo.getInDischargeport());
			usersession.setAttribute("invCustomer",invbo.getInvCustomer());
			//usersession.setAttribute("invoiceno",invbo.getInvoiceNo());
			//usersession.setAttribute("invoiceno",invbo.getInvoiceNo());
		}
		return mapping.getInputForward();
	}*/
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
		if(usersession != null){
		usersession.invalidate();
		}
		//return mapping.getInputForward();
		return mapping.findForward("login");
	}
	public ActionForward Save(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Save");
		
		return mapping.getInputForward();
	}
	public ActionForward RaiseTc(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Clear");
		
		return mapping.getInputForward();
	}
	public ActionForward Clickhere(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Clear");
		
		return mapping.getInputForward();
		
	}
	public ActionForward Calculate(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Calculate");
		
		return mapping.getInputForward();
		
	}
	public ActionForward Waived(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Waived");
		
		return mapping.getInputForward();
		
	}
	
}
