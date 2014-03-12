/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class DestinationDetails implements Serializable {
	
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1183888154180959707L;
		private String destiid;
		private String destiname;
		private String destictry;
		private String destishform;
		private String destiport;
		private String destiplace;
		
		
	
		/**
		 * @return the destishform
		 */
		public String getDestishform() {
			return destishform;
		}
		/**
		 * @param destishform the destishform to set
		 */
		public void setDestishform(String destishform) {
			this.destishform = destishform;
		}
		/**
		 * @return the destiport
		 */
		public String getDestiport() {
			return destiport;
		}
		/**
		 * @param destiport the destiport to set
		 */
		public void setDestiport(String destiport) {
			this.destiport = destiport;
		}
		/**
		 * @return the destiplace
		 */
		public String getDestiplace() {
			return destiplace;
		}
		/**
		 * @param destiplace the destiplace to set
		 */
		public void setDestiplace(String destiplace) {
			this.destiplace = destiplace;
		}
		/**
		 * @return the destiid
		 */
		public String getDestiid() {
			return destiid;
		}
		/**
		 * @param destiid the destiid to set
		 */
		public void setDestiid(String destiid) {
			this.destiid = destiid;
		}
		/**
		 * @return the destiname
		 */
		public String getDestiname() {
			return destiname;
		}
		/**
		 * @param destiname the destiname to set
		 */
		public void setDestiname(String destiname) {
			this.destiname = destiname;
		}
		/**
		 * @return the destictry
		 */
		public String getDestictry() {
			return destictry;
		}
		/**
		 * @param destictry the destictry to set
		 */
		public void setDestictry(String destictry) {
			this.destictry = destictry;
		}
		
		
		
}
