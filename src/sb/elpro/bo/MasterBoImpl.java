/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.BulkDaoImpl;
import sb.elpro.dao.BulkDao;
import sb.elpro.dao.MasterDao;
import sb.elpro.dao.MasterDaoImpl;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.Masterbean;

/**
 * @author Wahab
 *
 */
public class MasterBoImpl implements MasterBo {
	
	private MasterDao masterdao;
	/**
	 * 
	 */
	public MasterBoImpl() {
		this.masterdao = new MasterDaoImpl();
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.MasterBo#getMasterDetails(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Masterbean> getMasterDetails(String sidx, String sord,
			String rows, String pag) throws Exception {
		ArrayList<Masterbean> masterList = masterdao.getMasterDetailList(sidx, sord, rows, pag);
		return masterList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.MasterBo#getMasterTotqty(java.lang.String, java.lang.String)
	 */
	@Override
	public List<BulkQtyDetails> getMasterTotqty(String sidx, String sord)
			throws Exception {
		ArrayList<BulkQtyDetails> masterqtydetails = masterdao.getMasterQtyDetails(sidx, sord);
		return masterqtydetails;
	}

}
