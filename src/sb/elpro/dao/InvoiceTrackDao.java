/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.InvBillDetails;
import sb.elpro.model.Invpaymentdetails;

/**
 * @author Wahab
 *
 */
public interface InvoiceTrackDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<InvBillDetails> getInvTrackList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addPayment(Invpaymentdetails invpay)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editPayment(Invpaymentdetails invpay)throws SQLException;

}
