/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 *
 */
public interface UserInputDao {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<TanneryDetails> getTanneryList() throws SQLException;

	/**  
	 * (Method description)
	 * @param addtannerydetail 
	 * @param
	 * @return
	 * etc
	 */
	boolean addTanneryList(TanneryDetails addtannerydetail) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editTanneryList(TanneryDetails addtannerydetail) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delTanneryList(TanneryDetails deltannerydetail)throws SQLException;
/*
 * -----------------------------------------------------------------------------------------------------
 * Customer Deatils 
 * -----------------------------------------------------------------------------------------------------
 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<CustomerDetails> getCustomerList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addCustomerList(CustomerDetails addcustdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editCustomerList(CustomerDetails editcustdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delCustomerList(CustomerDetails delcustdetail)throws SQLException;

	
	// ----------------------------Consignee Details -------------------------------------//
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<ConsigneeDetails> getConsigneeList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addConsigneeList(ConsigneeDetails addconsigdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editConsigList(ConsigneeDetails editconsigdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delConsigList(ConsigneeDetails delconsigdetail)throws SQLException;

	// ----------------------------Notify Consignee Details -------------------------------------//
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<NotifyConsigneeDetails> getNotifyList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addNotifyList(NotifyConsigneeDetails addnotifydetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editNotifyList(NotifyConsigneeDetails editnotifydetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delNotifyList(NotifyConsigneeDetails delnotifydetail)throws SQLException;
	
	
	// ----------------------------Bank Details -------------------------------------//
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<BankDetails> getBankList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addBankList(BankDetails addbankdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editBankList(BankDetails editbankdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delBankList(BankDetails delbankdetail)throws SQLException;

	// ----------------------------Article Details -------------------------------------//
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<ArticleDetails> getArticleList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addArticleList(ArticleDetails addarticledetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editArticleList(ArticleDetails editarticledetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delArticleList(ArticleDetails delarticledetail)throws SQLException;
	// ----------------------------Commission Details -------------------------------------//
	
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<CommissionDetails> getCommList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addCommList(CommissionDetails addcommdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editCommList(CommissionDetails editcommdetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delCommList(CommissionDetails delcommdetail)throws SQLException;
	// ----------------------------Destination Details -------------------------------------//
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<DestinationDetails> getDestiList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addDestiList(DestinationDetails adddestidetail)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editDestiList(DestinationDetails editdestidetail)throws SQLException;
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delDestiList(DestinationDetails deldestidetail)throws SQLException;




}
