/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class PaymentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4357664970444053326L;
	
	private String paymentid;
	private String paymentname;
	private String otherdetails;
	private String label;
	

	/**
	 * @return the paymentid
	 */
	public String getPaymentid() {
		return paymentid;
	}
	/**
	 * @param paymentid the paymentid to set
	 */
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	/**
	 * @return the paymentname
	 */
	public String getPaymentname() {
		return paymentname;
	}
	/**
	 * @param paymentname the paymentname to set
	 */
	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}
	/**
	 * @return the otherdetails
	 */
	public String getOtherdetails() {
		return otherdetails;
	}
	/**
	 * @param otherdetails the otherdetails to set
	 */
	public void setOtherdetails(String otherdetails) {
		this.otherdetails = otherdetails;
	}
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
	
	
}
