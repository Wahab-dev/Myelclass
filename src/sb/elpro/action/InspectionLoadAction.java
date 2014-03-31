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

import sb.elpro.bo.InspectionBo;
import sb.elpro.bo.InspectionBoImpl;
import sb.elpro.model.SampleInvoiceBean;

/**
 * @author Wahab
 *
 */
public class InspectionLoadAction extends Action {

	HttpSession usersession;
	//InspectionBo  inspbo = new InspectionBoImpl();
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("Sacre Soutane ");
		usersession = request.getSession(false);	
		if(usersession !=null){	
			String action = request.getParameter("action");
			System.out.println("In Inspection ADD Form");
			if(action == null){
				System.out.println("In iNspection Load.....");
				usersession.setAttribute("inspactionform", "add");
			}else if(action.equalsIgnoreCase("editinspform")){
				System.out.println("In Inspection Edit Form");
				String actionform = "edit";
				/*String saminvno = request.getParameter("invno");
				usersession.setAttribute("sampleinvactionform", actionform);
				usersession.setAttribute("editsaminvno", saminvno);
				List<SampleInvoiceBean> editSamInvform = sampleinvbo.getEditSamInvFormValues(saminvno);
				usersession.setAttribute("editsaminvform", editSamInvform);*/
				
			}
			return mapping.findForward("inspectionisloaded");
		}else{
				System.out.println("Inspection is not Loaded,,,");
				return mapping.findForward("login");
		}		
	}
}
