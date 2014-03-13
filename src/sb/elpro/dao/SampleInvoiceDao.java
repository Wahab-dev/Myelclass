/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public interface SampleInvoiceDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<CustomerInvoice> getSamInvCustsampleDet(String custname,
			String type, String sidx, String sord) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<ArticleDetails> getInvSelSampleDetails(String samno, String type)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvAddbillDetails(InvBillDetails saminvbill)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<InvBillDetails> getSamInvBillDetails(String invno, String samno,
			String type)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<InvBillDetails> getSamInvBillTotAmtDetails(String invno)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvAddbillSecondDetails(InvBillDetails saminvaddagainbill)throws SQLException;
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvEditbillDetails(InvBillDetails saminveditbill)throws SQLException;
	

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvDelbillDetails(InvBillDetails saminvdelabill)throws SQLException;

}
