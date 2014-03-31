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

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.SampleRequest;

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
				//usersession.setAttribute("customerarray", srfbo.getCustomerDetails());
				//usersession.setAttribute("sampleno", srfbo.getSampleno());
				String action = request.getParameter("action");
				System.out.println("STR  action"+action);
				if(action == null){
					//System.out.println("Sample Number "+sampleno.toString());
					usersession.setAttribute("srfactionform", "add");
					System.out.println("IN SRF IS LOADED");
					
				}else if(action.equalsIgnoreCase("editform")){
					/*
					 * Method to Set Values for SRF FORM
					 * 
					 */
					System.out.println("In SRF Edit Form");
					String actionform = "edit";
					String sampleno = request.getParameter("sampleno");
					usersession.setAttribute("srfactionform", actionform);
					usersession.setAttribute("editsrfsampleno", sampleno);
					//usersession.setAttribute("editprfform", prfbo.getEditPrfFormValues(ctno));
					List<SampleRequest> editSrfform = srfbo.getEditSrfFormValues(sampleno);
					usersession.setAttribute("editsrfform", editSrfform);
					
				}
				return map.findForward("srfisloaded");
			}else{
				return map.findForward("login");
			}
		
		}
}
