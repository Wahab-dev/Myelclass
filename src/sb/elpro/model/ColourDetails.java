/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class ColourDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9131987489170761311L;

		private String colourid;
		private String colourname;
		private String pantoneshades;
		private String colourtype; 
		private String colourfamily;
		/**
		 * @return the colourid
		 */
		public String getColourid() {
			return colourid;
		}
		/**
		 * @param colourid the colourid to set
		 */
		public void setColourid(String colourid) {
			this.colourid = colourid;
		}
		/**
		 * @return the colouriame
		 */
		public String getColourname() {
			return colourname;
		}
		/**
		 * @param colouriame the colouriame to set
		 */
		public void setColourname(String colourname) {
			this.colourname = colourname;
		}
		/**
		 * @return the pantoneshades
		 */
		public String getPantoneshades() {
			return pantoneshades;
		}
		/**
		 * @param pantoneshades the pantoneshades to set
		 */
		public void setPantoneshades(String pantoneshades) {
			this.pantoneshades = pantoneshades;
		}
		/**
		 * @return the colourtype
		 */
		public String getColourtype() {
			return colourtype;
		}
		/**
		 * @param colourtype the colourtype to set
		 */
		public void setColourtype(String colourtype) {
			this.colourtype = colourtype;
		}
		/**
		 * @return the colourfamily
		 */
		public String getColourfamily() {
			return colourfamily;
		}
		/**
		 * @param colourfamily the colourfamily to set
		 */
		public void setColourfamily(String colourfamily) {
			this.colourfamily = colourfamily;
		}
		
		
		
}
