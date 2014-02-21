/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.BulkDaoImpl;
import sb.elpro.dao.BulkDao;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;

/**
 * @author Wahab
 *
 */

public class BulkBoImpl implements BulkBo {
	
	 private BulkDao bulkdao;

	 /**
	  *
	  */
		public BulkBoImpl() {
			this.bulkdao = new BulkDaoImpl();
		}

	@Override
	public List<BulkArticle> getBulkDetails(String sidx, String sord, String rows, String pag)
			throws Exception {
		ArrayList<BulkArticle> customerList = bulkdao.getBulkDetailList(sidx, sord, rows, pag);
		return customerList;
	}

	@Override
	public boolean addBtrStatus(BulkArticle bulkmodel, String sidx, String sord)
			throws Exception {
		boolean isstatusupdate = bulkdao.updateBtrStatus(bulkmodel, sidx, sord);
		return isstatusupdate;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.BulkBo#getBulkTotqty(java.lang.String, java.lang.String)
	 * Method to Calculate TotQTy, Shpd, bal For Bulk Footer
	 */
	@Override
	public List<BulkQtyDetails> getBulkTotqty(String sidx, String sord)
			throws Exception {
		ArrayList<BulkQtyDetails> qtydetails = bulkdao.getBulkQtyDetails(sidx, sord);
		return qtydetails;
	}

	
}
