/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public interface SampleInvoiceTrackDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<InvBillDetails> getSamInvTrackList() throws SQLException;

}
