/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;

/**
 * @author Wahab
 *
 */
public interface BulkBo {

	List<BulkArticle> getBulkDetails(String sidx, String sord, String rows, String pag) throws Exception;

	boolean addBtrStatus(BulkArticle bulkmodel, String sidx, String sord)throws Exception;

	/**  
	 * Method to return Tot Qty, Shpd, Bal for Bulk
	 * @param
	 * @return
	 * etc
	 */
	List<BulkQtyDetails> getBulkTotqty(String sidx, String sord)throws Exception;

}
