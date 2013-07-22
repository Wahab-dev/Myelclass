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

import sb.elpro.bo.Inspectionbo;
import sb.elpro.bo.InspectionboImpl;

/**
 * @author Wahab
 *
 */
public class InspectionLoadAction extends Action {

	HttpSession usersession;
	Inspectionbo  inspbo = new InspectionboImpl();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);	
		if(usersession !=null){		   	
				System.out.println("In iNspection Load///////");
				usersession.setAttribute("inspcontractarray",inspbo.getInspCtNo());
				usersession.setAttribute("inspqctrlrarray", inspbo.getInspqtyctrlr());
			}else{
				System.out.println("Inspection is not Loaded,,,");
			}				
		return mapping.findForward("inspectionisloaded");		
	}
}
