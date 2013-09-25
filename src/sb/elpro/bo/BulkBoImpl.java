/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.BulkDaoImpl;
import sb.elpro.dao.Bulkdao;
import sb.elpro.dao.PrfDao;
import sb.elpro.dao.PrfDaoImpl;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.CustomerDetails;

/**
 * @author Wahab
 *
 */

public class BulkBoImpl implements BulkBo {
	
	 private Bulkdao bulkdao;

	 /**
		 * 
		 */
		public BulkBoImpl() {
			this.bulkdao = new BulkDaoImpl();
		}

	@Override
	public List<BulkArticle> getBulkDetails(String sidx, String sord)
			throws Exception {
		ArrayList<BulkArticle> customerList = bulkdao.getBulkDetailList(sidx, sord);
		return customerList;
	}

	@Override
	public boolean addBtrStatus(BulkArticle bulkmodel, String sidx, String sord)
			throws Exception {
		boolean isstatusupdate = bulkdao.updateBtrStatus(bulkmodel, sidx, sord);
		return isstatusupdate;
	}
}
