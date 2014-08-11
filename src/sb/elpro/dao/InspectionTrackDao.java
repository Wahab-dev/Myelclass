/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.List;

import sb.elpro.model.InspectionBean;

/**
 * @author Wahab
 *
 */
public interface InspectionTrackDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InspectionBean> getInspectionTrackLoad() throws SQLException;

}
