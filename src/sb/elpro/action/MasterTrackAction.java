/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * @author Wahab
 *
 */
public class MasterTrackAction extends Action {
	HttpSession usersession;
		public ActionForward execute (ActionMapping map, ActionForm form, 
					HttpServletRequest request, HttpServletResponse response) throws Exception{			
			usersession = request.getSession(false);
			
			/*
			 * Check for Valid USer - If S Load the Grid 
			 * 
			 */
			if(usersession != null){
				 
				
				System.out.println("In Master Tracking Form");
				return map.findForward("masterisloaded");			
			 }else{
				 System.out.println("Error Invalid Session");
				 return map.findForward("login");
			 }	
		}
}
