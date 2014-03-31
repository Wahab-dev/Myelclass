/**
 * 
 */
package sb.elpro.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.DebitForm;
import sb.elpro.actionform.PrfForm;
import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.ProductDetails;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class DebitAction extends DispatchAction {
	HttpSession usersession;
	DebitBo debbo = new DebitBoImpl();
	DebitFormDetails debformbean = new DebitFormDetails();
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
	
		usersession.invalidate();
		
		//return mapping.getInputForward();
		return mapping.findForward("login");
	}
	public ActionForward Save(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Save");
		 PrintWriter out = response.getWriter();
		 DebitForm debsaveform =(DebitForm) form;
		 BeanUtils.copyProperties(debformbean, debsaveform);
		 usersession = request.getSession(false);
		 System.out.println("Sessio n "+usersession);
		 debformbean.setDeb_debitdate(DateConversion.ConverttoMysqlDate(request.getParameter("deb_debitdate")));
		 //debformbean.setPrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("prf_cdd")));
		 //debformbean.setPrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("prf_add")));
		 if(!(usersession == null)){
			 
			 JSONObject debjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("debactionform"));
			 if(usersession.getAttribute("debactionform").equals("edit")){
				 boolean isupdtdeb = debbo.updtDebitform(debformbean);
				 if(isupdtdeb){
						debjsonobj.put("result", isupdtdeb);
						debjsonobj.put("success", "Successfully Saved The Form");
						debsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("gotodebittracking");
					}else{
						debjsonobj.put("result", isupdtdeb);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					} 
			 }else{
				 boolean issaveddeb = debbo.saveDebitform(debformbean);
				 if(issaveddeb){
						debjsonobj.put("result", issaveddeb);
						debjsonobj.put("success", "Successfully Saved The Form");
						debsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("debissaved");
					}else{
						debjsonobj.put("result", issaveddeb);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					}
			 }
			
		 }
		 else{
			 System.out.println(" Invalid Session");
			 return mapping.findForward("login");
		 }
		 
	}
	public ActionForward TcSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in TC SAVE");
		/* PrintWriter out = response.getWriter();
		 DebitForm debsaveform =(DebitForm) form;
		 BeanUtils.copyProperties(debformbean, debsaveform);
		  */
		 System.out.println(" Debit TC"+debformbean.getTcdeb_tcdebitno());
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
