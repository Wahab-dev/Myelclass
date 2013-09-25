/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.BulkArticle;

/**
 * @author Wahab
 *
 */
public interface Bulkdao {

	ArrayList<BulkArticle> getBulkDetailList(String sidx, String sord) throws SQLException;

	boolean updateBtrStatus(BulkArticle bulkmodel, String sidx, String sord) throws SQLException;

}
