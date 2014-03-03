/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 *
 */
public interface UserInputBo {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<TanneryDetails> getTanneryDetails() throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addTanneryDetails(TanneryDetails addtannerydetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editTanneryDetails(TanneryDetails edittannerydetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delTanneryDetails(TanneryDetails deltannerydetail)throws Exception;
/*
 * Customer 
 * 
 * -----------------------------------------------------------------------------------------------------
 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<CustomerDetails> getCustomerDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addCustdetails(CustomerDetails addcustdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editCustDetails(CustomerDetails editcustdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delCustDetails(CustomerDetails delcustdetail)throws Exception;
/*
 * Consignee 
 * 
 * -----------------------------------------------------------------------------------------------------
 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<ConsigneeDetails> getConsigneeDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addConsigdetails(ConsigneeDetails addconsigdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editConsigDetails(ConsigneeDetails addconsigdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delConsigDetails(ConsigneeDetails addconsigdetail)throws Exception;
	/*
	 * Notify  
	 * 
	 * -----------------------------------------------------------------------------------------------------
	 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<NotifyConsigneeDetails> getNotifyDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addNotifydetails(NotifyConsigneeDetails addnotifydetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editNotifyDetails(NotifyConsigneeDetails addnotifydetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delNotifyDetails(NotifyConsigneeDetails addnotifydetail)throws Exception;
	/*
	 * Bank  
	 * 
	 * -----------------------------------------------------------------------------------------------------
	 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<BankDetails> getBankDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addBankdetails(BankDetails addbankdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editBankDetails(BankDetails addbankdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delBankDetails(BankDetails addbankdetail)throws Exception;
	/*
	 * Article  
	 * 
	 * -----------------------------------------------------------------------------------------------------
	 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<ArticleDetails> getArticleDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addArticledetails(ArticleDetails addarticledetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editArticleDetails(ArticleDetails editarticledetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delArticleDetails(ArticleDetails delarticledetail)throws Exception;
	/*
	 * Commission  
	 * 
	 * -----------------------------------------------------------------------------------------------------
	 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<CommissionDetails> getCommissionDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addCommdetails(CommissionDetails addcommdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean editCommDetails(CommissionDetails addcommdetail)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean delCommDetails(CommissionDetails addcommdetail)throws Exception;



}
