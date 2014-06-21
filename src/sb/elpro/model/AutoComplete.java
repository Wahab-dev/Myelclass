package sb.elpro.model;

import java.io.Serializable;

public class AutoComplete implements Serializable {

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1273690433844895976L;
		private String label;
		private String value;
		private String other;
		private String shform;
		
		
		
		/**
		 * @return the label
		 */
		public String getLabel() {
			return label;
		}
		/**
		 * @param label the label to set
		 */
		public void setLabel(String label) {
			this.label = label;
		}
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}
		/**
		 * @return the shform
		 */
		public String getShform() {
			return shform;
		}
		/**
		 * @param shform the shform to set
		 */
		public void setShform(String shform) {
			this.shform = shform;
		}
		/**
		 * @return the other
		 */
		public String getOther() {
			return other;
		}
		/**
		 * @param other the other to set
		 */
		public void setOther(String other) {
			this.other = other;
		}
		
}
