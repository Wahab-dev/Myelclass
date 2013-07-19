/**
 * 
 */
package sb.elpro.actionform;

import org.apache.struts.action.ActionForm;

/**
 * @author Wahab
 *
 */
public class MenuForm extends ActionForm {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 3310860579186648334L;
		private String mybutton;

		/**
		 * @return the mybutton
		 */
		public String getMybutton() {
			return mybutton;
		}

		/**
		 * @param mybutton the mybutton to set
		 */
		public void setMybutton(String mybutton) {
			this.mybutton = mybutton;
		}
		
}
