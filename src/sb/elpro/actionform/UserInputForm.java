/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.actionform;

import org.apache.struts.action.ActionForm;

/**
 * @author Wahab
 *
 */
public class UserInputForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2623714906992393437L;
	
		private String tanname;
		private String tanaddr;
		private String tanattn;
		private String tanphone;
		private String tanfax;
		private String tanshform;
		private String tanmail;
		/**
		 * @return the tanname
		 */
		public String getTanname() {
			return tanname;
		}
		/**
		 * @param tanname the tanname to set
		 */
		public void setTanname(String tanname) {
			this.tanname = tanname;
		}
		/**
		 * @return the tanaddr
		 */
		public String getTanaddr() {
			return tanaddr;
		}
		/**
		 * @param tanaddr the tanaddr to set
		 */
		public void setTanaddr(String tanaddr) {
			this.tanaddr = tanaddr;
		}
		/**
		 * @return the tanattn
		 */
		public String getTanattn() {
			return tanattn;
		}
		/**
		 * @param tanattn the tanattn to set
		 */
		public void setTanattn(String tanattn) {
			this.tanattn = tanattn;
		}
		/**
		 * @return the tanphone
		 */
		public String getTanphone() {
			return tanphone;
		}
		/**
		 * @param tanphone the tanphone to set
		 */
		public void setTanphone(String tanphone) {
			this.tanphone = tanphone;
		}
		/**
		 * @return the tanfax
		 */
		public String getTanfax() {
			return tanfax;
		}
		/**
		 * @param tanfax the tanfax to set
		 */
		public void setTanfax(String tanfax) {
			this.tanfax = tanfax;
		}
		/**
		 * @return the tanshform
		 */
		public String getTanshform() {
			return tanshform;
		}
		/**
		 * @param tanshform the tanshform to set
		 */
		public void setTanshform(String tanshform) {
			this.tanshform = tanshform;
		}
		/**
		 * @return the tanmail
		 */
		public String getTanmail() {
			return tanmail;
		}
		/**
		 * @param tanmail the tanmail to set
		 */
		public void setTanmail(String tanmail) {
			this.tanmail = tanmail;
		}
}
