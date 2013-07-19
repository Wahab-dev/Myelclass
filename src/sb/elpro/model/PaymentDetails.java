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
	
	private String paymentId;
	private String payment;
	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
}
