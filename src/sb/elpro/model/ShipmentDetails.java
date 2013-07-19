/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class ShipmentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4348857555079010506L;

	private String shipmentid;
	private String shipmentname;
	private String shipmenttype;
	
	/**
	 * @return the shipmentid
	 */
	public String getShipmentid() {
		return shipmentid;
	}
	/**
	 * @param shipmentid the shipmentid to set
	 */
	public void setShipmentid(String shipmentid) {
		this.shipmentid = shipmentid;
	}
	/**
	 * @return the shipmentname
	 */
	public String getShipmentname() {
		return shipmentname;
	}
	/**
	 * @param shipmentname the shipmentname to set
	 */
	public void setShipmentname(String shipmentname) {
		this.shipmentname = shipmentname;
	}
	/**
	 * @return the shipmenttype
	 */
	public String getShipmenttype() {
		return shipmenttype;
	}
	/**
	 * @param shipmenttype the shipmenttype to set
	 */
	public void setShipmenttype(String shipmenttype) {
		this.shipmenttype = shipmenttype;
	}
}
