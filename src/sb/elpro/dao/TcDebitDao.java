/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.List;

import sb.elpro.model.InvoiceForm;

/**
 * @author Wahab
 *
 */
public interface TcDebitDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InvoiceForm> getinvDetails(String invno ) throws SQLException;

}
