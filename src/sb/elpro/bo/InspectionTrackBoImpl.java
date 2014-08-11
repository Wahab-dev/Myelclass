/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.dao.InspectionDao;
import sb.elpro.dao.InspectionDaoImpl;
import sb.elpro.dao.InspectionTrackDao;
import sb.elpro.dao.InspectionTrackDaoImpl;
import sb.elpro.model.InspectionBean;

/**
 * @author Wahab
 *
 */
public class InspectionTrackBoImpl implements InspectionTrackBo {
	private InspectionTrackDao insptrackdao;
	
	public InspectionTrackBoImpl(){
		this.insptrackdao = new InspectionTrackDaoImpl(); 			
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InspectionTrackBo#getInspectionTrackDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public List<InspectionBean> getInspectionTrackDetails() throws Exception {
		System.out.println("In INSp Trac BOIMPL");
		List<InspectionBean> getInspTrackList = insptrackdao.getInspectionTrackLoad();
 		return getInspTrackList;
	}

	
}
