package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class MenuAction extends DispatchAction{
	public ActionForward PrfScreen(ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response ) throws  Exception{
			System.out.println("IN PRF SCREEN ");
			return map.findForward("gotoprf");
	}
		
	public ActionForward SrfScreen(ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response ) throws  Exception{			
			System.out.println("IN SRF SCREEN ");			
			return map.findForward("gotosrf");
	}
		
}
