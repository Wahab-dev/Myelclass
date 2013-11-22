/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class BulkQtyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6772578454046093996L;
	private String quantity;
	private String qtyshpd;
	private String qbal;
	/**
	 * @return the qbal
	 */
	public String getQbal() {
		return qbal;
	}
	/**
	 * @param qbal the qbal to set
	 */
	public void setQbal(String qbal) {
		this.qbal = qbal;
	}
	/**
	 * @return the qtyshpd
	 */
	public String getQtyshpd() {
		return qtyshpd;
	}
	/**
	 * @param qtyshpd the qtyshpd to set
	 */
	public void setQtyshpd(String qtyshpd) {
		this.qtyshpd = qtyshpd;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
