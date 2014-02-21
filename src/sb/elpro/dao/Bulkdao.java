/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;

/**
 * @author Wahab
 *
 */
public interface BulkDao {

	ArrayList<BulkArticle> getBulkDetailList(String sidx, String sord, String rows, String pag) throws SQLException;

	boolean updateBtrStatus(BulkArticle bulkmodel, String sidx, String sord) throws SQLException;

	

	/**  
	 * Method to return Tot Qty, Shpd, Bal for Bulk
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<BulkQtyDetails> getBulkQtyDetails(String sidx, String sord) throws SQLException;

}
