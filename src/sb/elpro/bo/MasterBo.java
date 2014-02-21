/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.Masterbean;

/**
 * @author Wahab
 *
 */
public interface MasterBo{

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<Masterbean> getMasterDetails(String sidx, String sord, String rows,
			String pag) throws Exception ;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<BulkQtyDetails> getMasterTotqty(String sidx, String sord)throws Exception ;

}
