/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.InvBillDetails;
import sb.elpro.model.Invpaymentdetails;

/**
 * @author Wahab
 *
 */
public interface InvoiceTrackBo {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InvBillDetails> getInvTrackDetails() throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addPayment(Invpaymentdetails invpay) throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editPayment(Invpaymentdetails invpay)throws Exception;


}
