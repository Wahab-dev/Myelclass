/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class SelectionDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 422054741797583457L;
	
		private String selectionid;
		private String selectionname;
		/**
		 * @return the selectionid
		 */
		public String getSelectionid() {
			return selectionid;
		}
		/**
		 * @param selectionid the selectionid to set
		 */
		public void setSelectionid(String selectionid) {
			this.selectionid = selectionid;
		}
		/**
		 * @return the selectionname
		 */
		public String getSelectionname() {
			return selectionname;
		}
		/**
		 * @param selectionname the selectionname to set
		 */
		public void setSelectionname(String selectionname) {
			this.selectionname = selectionname;
		}
		
}
