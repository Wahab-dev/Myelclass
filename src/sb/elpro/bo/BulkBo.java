/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.InvoiceTotAmtDetails;

/**
 * @author Wahab
 *
 */
public interface BulkBo {
	/**
	 * Method to Return Complete Bulk Tracking Details 
	 * @param
	 * @return 
	 * etc
	 */

	List<BulkArticle> getBulkDetails(String sidx, String sord, String rows, String pag) throws Exception;
	

	/**
	 * Method to Add the status of the Ct  
	 * @param
	 * @return 
	 * etc
	 */
	boolean addBtrStatus(BulkArticle bulkmodel, String sidx, String sord)throws Exception;

	/**  
	 * Method to return Tot Qty, Shpd, Bal for Bulk
	 * @param
	 * @return
	 * etc
	 */
	List<BulkQtyDetails> getBulkTotqty(String sidx, String sord)throws Exception;


	
}
