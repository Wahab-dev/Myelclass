/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.PaymentBean;
import sb.elpro.model.PaymentDetails;

/**
 * @author Wahab
 *
 */
public interface PaymentBo {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<DebitFormDetails> getPaymentDebDetails(String expo) throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean savePaymentform(PaymentBean paymntformbean) throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<PaymentBean> getPayTrackDetails()throws Exception;

}
