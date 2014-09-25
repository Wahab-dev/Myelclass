/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.actionform;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author Wahab
 *
 */
public class LoadActionForm extends ActionForm{

		private String action;
		

		/**
		 * @return the action
		 */
		public String getAction() {
			return action;
		}

		/**
		 * @param action the action to set
		 */
		public void setAction(String action) {
			this.action = action;
		}
		
}
