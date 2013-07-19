/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab	
 *
 */
public class SizeRemarks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869990616193364576L;
	
		private String sizeremarksid;
		private String sizeremarks;
		
		
		/**
		 * @return the sizeremarksid
		 */
		public String getSizeremarksid() {
			return sizeremarksid;
		}
		/**
		 * @param sizeremarksid the sizeremarksid to set
		 */
		public void setSizeremarksid(String sizeremarksid) {
			this.sizeremarksid = sizeremarksid;
		}
		/**
		 * @return the sizeremarks
		 */
		public String getSizeremarks() {
			return sizeremarks;
		}
		/**
		 * @param sizeremarks the sizeremarks to set
		 */
		public void setSizeremarks(String sizeremarks) {
			this.sizeremarks = sizeremarks;
		}
}
