/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.PaymentBean;

/**
 * @author Wahab
 *
 */
public interface PaymentDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<DebitFormDetails> getPaymentPendingList(String expo)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean savePaymentFormDetails(PaymentBean paymntformbean)throws SQLException;

}
