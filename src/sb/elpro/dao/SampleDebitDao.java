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
public interface SampleDebitDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<InvBillDetails> getSampleDebList() throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updatSamDebStatus(InvBillDetails sampledeb)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updatSamDebEditStatus(InvBillDetails sampledeb)throws SQLException;


}
