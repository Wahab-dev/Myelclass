/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.model.AgentDetails;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.BankDetails;
import sb.elpro.model.ColourDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.PoJwBean;
import sb.elpro.model.PojwArticle;
import sb.elpro.model.PrfArticle;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.RateDetails;
import sb.elpro.model.SelectArticle;
import sb.elpro.model.SelectionDetails;
import sb.elpro.model.ShipmentDetails;
import sb.elpro.model.SizeRemarks;
import sb.elpro.model.TanneryDetails;
import sb.elpro.model.TcDetails;
import sb.elpro.model.TermsDetails;

/**
 * @author Wahab
 *
 */
public interface PrfDao {

	ArrayList<AgentDetails> getAgentList(String term) throws SQLException;

	ArrayList<TanneryDetails> getTanneryList(String tanterm) throws SQLException;
	
	ArrayList<CustomerDetails> getCustomerList(String custterm) throws SQLException;


//	ArrayList<DestinationDetails> getDestinationList() throws SQLException;

	ArrayList<AutoComplete> getPaymnetList(String terms) throws SQLException;

	ArrayList<AutoComplete> getTermsList(String terms)throws SQLException;

	ArrayList<CommissionDetails> getCommissionList(String comminsion) throws SQLException;
	ArrayList<CommissionDetails> getOtherCommissionList(String othercomminsion) throws SQLException;
	

	boolean savePrfForm(ProductDetails prfbean)throws SQLException;

	ArrayList<ArticleDetails> getArticleList()throws SQLException;

	ArrayList<RateDetails> getRateList()throws SQLException;

	//ArrayList<SelectionDetails> getSelectionList()throws SQLException;

	//ArrayList<AutoComplete> getShipmentList()throws SQLException;

	//ArrayList<SizeRemarks> getSizeremarksList()throws SQLException;

	ArrayList<TcDetails> getTcAgentList() throws SQLException;
	
	

	/*
	 * Article Page
	 */
	//List<SelectArticle> getArticleNameList() throws SQLException;
	/*
	 * Load Article dDetails Based on Article Name
	 */
	int saveprfArticleList(PrfArticle prfarticlebean)throws SQLException;

	ArrayList<PrfArticle> getPrfArticleDetails( String ctno, String sidx, String sord)throws SQLException;

	List<ArticleDetails> getPrfArticleNamelist(String term)throws SQLException;
	

	List<AutoComplete> getPrfColorlist(String term)throws SQLException;
	
	ArrayList<BankDetails> getbankList(String bankterm)throws SQLException;

	ArrayList<ConsigneeDetails> getcnsigneeList(String consigneeterm)throws SQLException;

	ArrayList<NotifyConsigneeDetails> getnotifyList(String notifyterm)throws SQLException;

	boolean addprfArticle(PrfArticle artindertdetail, String sidx,
			String sord)throws SQLException;

	boolean editprfArticle(PrfArticle artindertdetail, String ctno,
			String sidx)throws SQLException;

	boolean delprfArticle(PrfArticle artindertdetail, String artid,
			String sidx)throws SQLException;

	List<ArticleDetails> getPrfArticleTypelist() throws SQLException;

	
	/*
	 * Edit PRf Form
	 */
	List<ProductDetails> getEditPrfFormDetails(String ctno) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updatePrfForm(ProductDetails prfbean) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	String getPoJwno()throws SQLException;
/*
 * 
 * POJW SAVE 
 */
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean savePoJwForm(ProductDetails pojw)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getShipmentList(String term)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getPrfSelectionList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getPrfColorMatchList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<PrfArticle> getPojwArticleDetails(String ctno)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getSizeRemList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getQtyunitList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getCurrencyList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getSubCurrencyList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<AutoComplete> getTcCustList()throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<PrfArticle> addpoArticle(String copyctno, String copypojw) throws SQLException;

}
