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

import sb.elpro.bo.InspectionBo;
import sb.elpro.bo.InspectionBoImpl;

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
				System.out.println("In iNspection Load.....");
				return mapping.findForward("inspectionisloaded");		
		}else{
				System.out.println("Inspection is not Loaded,,,");
				return mapping.findForward("login");
		}		
	}
}
