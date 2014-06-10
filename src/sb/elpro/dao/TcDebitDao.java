/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.List;

import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvoiceBean;

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
	List<InvoiceBean> getinvDetails(String invno ) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean saveTCDebitFormDetails(DebitFormDetails tcformbean) throws SQLException;

}
