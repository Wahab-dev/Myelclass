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
public class InvoiceTotAmtDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7808428384158203146L;

	private String amount;
	private String totalamount;
	private String othercharge;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the totalamount
	 */
	public String getTotalamount() {
		return totalamount;
	}
	/**
	 * @param totalamount the totalamount to set
	 */
	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}
	/**
	 * @return the othercharge
	 */
	public String getOthercharge() {
		return othercharge;
	}
	/**
	 * @param othercharge the othercharge to set
	 */
	public void setOthercharge(String othercharge) {
		this.othercharge = othercharge;
	}
	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	private String discount;
	
	
}
