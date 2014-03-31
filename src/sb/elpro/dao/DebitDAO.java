/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.model.AutoComplete;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.InvoiceBean;
import sb.elpro.model.RaiseDebit;
import sb.elpro.model.TanneryDetails;

/**
 * @author ADMIN_WIN7
 *
 */
public interface DebitDao { 
	  
	ArrayList<TanneryDetails> getDebExporter(String debexp) throws SQLException;
	
	ArrayList<AutoComplete> getDebTanInvno(String debTaninv, String expname) throws SQLException;

	ArrayList<InvBillDetails> getDebInvnolist(String invno) throws SQLException;

	boolean setDebInvnoWaived(String invid) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean saveDebitFormDetails(DebitFormDetails debformbean)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<DebitFormDetails> getDebitTracklist(String sidx, String sord)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	String getDebitnoteno()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<DebitFormDetails> getEditDebFormDetails(String deb_debitno)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updtDebFormDetails(DebitFormDetails debformbean)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	String getPaynoteno()throws SQLException;


	
	
}
