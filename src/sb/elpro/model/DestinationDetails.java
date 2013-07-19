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
		private String destinationId;
		private String destination;
		private String destinationCountry;
		/**
		 * @return the destinationId
		 */
		public String getDestinationId() {
			return destinationId;
		}
		/**
		 * @param destinationId the destinationId to set
		 */
		public void setDestinationId(String destinationId) {
			this.destinationId = destinationId;
		}
		/**
		 * @return the destination
		 */
		public String getDestination() {
			return destination;
		}
		/**
		 * @param destination the destination to set
		 */
		public void setDestination(String destination) {
			this.destination = destination;
		}
		/**
		 * @return the destinationCountry
		 */
		public String getDestinationCountry() {
			return destinationCountry;
		}
		/**
		 * @param destinationCountry the destinationCountry to set
		 */
		public void setDestinationCountry(String destinationCountry) {
			this.destinationCountry = destinationCountry;
		}
		
		
		
}
