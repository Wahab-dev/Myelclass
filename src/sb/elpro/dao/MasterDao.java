/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.Masterbean;

/**
 * @author Wahab
 *
 */
public interface MasterDao  {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<Masterbean> getMasterDetailList(String sidx, String sord,
			String rows, String pag)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<BulkQtyDetails> getMasterQtyDetails(String sidx, String sord)
	throws SQLException;

}
