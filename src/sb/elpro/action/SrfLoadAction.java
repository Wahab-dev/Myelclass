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
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;

/**
 * @author Wahab
 *
 */
public class SrfLoadAction extends Action  { 
	SrfBo srfbo = new SrfBoImpl();
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
		public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, 
				HttpServletResponse response) throws Exception{
			System.out.println("It is SRF Load Action");
			usersession = request.getSession(false);
			if(usersession != null){
				//usersession.setAttribute("tanneryarray", srfbo.getTanneryDetails());
				usersession.setAttribute("customerarray", srfbo.getCustomerDetails());
				usersession.setAttribute("sampleno", srfbo.getSampleno());
				//usersession.setAttribute("handledbyarray",srfbo.getsrfhandledby());
				//usersession.setAttribute("endusagearray", srfbo.getsrfEndusage());
				
				//usersession.setAttribute("paymentarray", srfbo.getPaymentDetails());
			}
			return map.findForward("srfisloaded");
		}
}
