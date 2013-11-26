/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.InspectionBean;

/**
 * @author Wahab
 *
 */
public interface InspectionTrackBo {

	/**  
	 * Method to load Insp tarcking 
	 * @param
	 * @return
	 * etc
	 */
	List<InspectionBean> getInspectionTrackDetails(String sidx, String sord) throws Exception;

	
}
