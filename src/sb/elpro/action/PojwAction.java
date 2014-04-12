/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */
public class PojwAction extends Action {

		/* (non-Javadoc)
		 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		@Override
		public ActionForward execute(ActionMapping map, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			System.out.println(" in POJW SAVE FORM ACTION");
			String pojwno = request.getParameter("prf_pojw");
			System.out.println(" in POJW SAVE FORM ACTION"+pojwno);
			return null;
		}
}
