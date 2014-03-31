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

import sb.elpro.bo.TcDebitBo;
import sb.elpro.bo.TcDebitBoImpl;
import sb.elpro.model.InvoiceBean;


/**
 * @author Wahab
 *
 */
public class TcDebitLoadAction extends Action {
	
	HttpSession usersession;
	TcDebitBo tcdebitbo = new TcDebitBoImpl();
	 
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);	
		if(usersession !=null){	
			String tcdeb_tcdebitno = request.getParameter("tcdeb_tcdebitno");
			System.out.println("tcdeb_tcdebitno????"+tcdeb_tcdebitno);
			String tcdeb_exporter = request.getParameter("tcdeb_exporter");
			System.out.println("tcdeb_exporter????"+tcdeb_exporter);
			String tcdeb_tcdebitdate = request.getParameter("tcdeb_tcdebitdate");
			System.out.println("tcdeb_tcdebitdate????"+tcdeb_tcdebitdate);
			String tcdeb_taninvno = request.getParameter("tcdeb_taninvno");
			System.out.println("tcdeb_taninvno????"+tcdeb_taninvno);
			String tcdeb_elclassrefno = request.getParameter("tcdeb_elclassrefno");
			System.out.println("tcdeb_elclassrefno????"+tcdeb_elclassrefno);
			String tcdeb_exchangerate = request.getParameter("tcdeb_exchangerate");
			System.out.println("tcdeb_exchangerate????"+tcdeb_exchangerate);
			String tcdeb_tcamt = request.getParameter("tcdeb_tcamt");
			System.out.println("tcdeb_tcamt????"+tcdeb_tcamt);
			String tcdeb_rate = request.getParameter("tcdeb_rate");
			System.out.println("tcdeb_rate????"+tcdeb_rate);
			
			//List<InvoiceForm> invdetails = tcdebitbo.getinvDetails(invno);
			//usersession.setAttribute("invdetails", invdetails);
			
		}
		return mapping.findForward("tcdebitisloaded");
	}
	
}
