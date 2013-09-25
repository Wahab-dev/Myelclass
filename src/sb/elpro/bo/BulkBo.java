/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.BulkArticle;

/**
 * @author Wahab
 *
 */
public interface BulkBo {

	List<BulkArticle> getBulkDetails(String sidx, String sord) throws Exception;

	boolean addBtrStatus(BulkArticle bulkmodel, String sidx, String sord)throws Exception;

}
