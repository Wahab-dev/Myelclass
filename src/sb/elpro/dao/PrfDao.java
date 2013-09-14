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
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PaymentDetails;
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

	ArrayList<AgentDetails> getAgentList() throws SQLException;

	ArrayList<TanneryDetails> getTanneryList(String tanterm) throws SQLException;
	
	ArrayList<CustomerDetails> getCustomerList(String custterm) throws SQLException;

	/*ArrayList<ConsigneeDetails> getConsigneeList()throws SQLException;

	ArrayList<NotifyConsigneeDetails> getNotifyList()throws SQLException;

	ArrayList<BankDetails> getBankList() throws SQLException; 
*/
	ArrayList<DestinationDetails> getDestinationList() throws SQLException;

	ArrayList<PaymentDetails> getPaymnetList() throws SQLException;

	ArrayList<TermsDetails> getTermsList()throws SQLException;

	ArrayList<CommissionDetails> getCommissionList(String comminsion) throws SQLException;
	ArrayList<CommissionDetails> getOtherCommissionList(String othercomminsion) throws SQLException;
	

	ArrayList<ProductDetails> savePrfForm()throws SQLException;

	ArrayList<ArticleDetails> getArticleList()throws SQLException;

	ArrayList<ColourDetails> getColorList()throws SQLException;

	ArrayList<RateDetails> getRateList()throws SQLException;

	ArrayList<SelectionDetails> getSelectionList()throws SQLException;

	ArrayList<ShipmentDetails> getShipmentList()throws SQLException;

	ArrayList<SizeRemarks> getSizeremarksList()throws SQLException;

	ArrayList<TcDetails> getTcAgentList() throws SQLException;
	
	

	/*
	 * Article Page
	 */
	List<SelectArticle> getArticleNameList() throws SQLException;
	int saveprfArticleList(PrfArticle prfarticlebean)throws SQLException;

	ArrayList<PrfArticle> getPrfArticleDetails(String sidx, String sord)throws SQLException;

	List<ArticleDetails> editprfArticle(String prfarticleid)throws SQLException;

	List<ArticleDetails> updateprfArticle(ArticleDetails prfbean)throws SQLException;

	List<ArticleDetails> getPrfArticleNamelist(String term)throws SQLException;
	

	List<AutoComplete> getPrfColorlist(String term)throws SQLException;
	
	ArrayList<BankDetails> getbankList(String bankterm)throws SQLException;

	ArrayList<ConsigneeDetails> getcnsigneeList(String consigneeterm)throws SQLException;

	ArrayList<NotifyConsigneeDetails> getnotifyList(String notifyterm)throws SQLException;

	boolean addprfArticle(PrfArticle artindertdetail, String ctno, String sidx,
			String sord)throws SQLException;

	boolean editprfArticle(PrfArticle artindertdetail, String ctno,
			String sidx, String sord)throws SQLException;

	boolean delprfArticle(PrfArticle artindertdetail, String artid,
			String sidx, String sord)throws SQLException;

	List<ArticleDetails> getPrfArticleTypelist() throws SQLException;

	
	
}
