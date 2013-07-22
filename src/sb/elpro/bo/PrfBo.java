/**
 * 
 */
package sb.elpro.bo;

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
public interface PrfBo  {

	

	public ArrayList<AgentDetails> getAgentDetails() throws Exception;

	public ArrayList<TanneryDetails> getTanneryDetails(String tanterm) throws Exception;

	public ArrayList<CustomerDetails> getCustomerDetails(String custterm) throws Exception;

	public ArrayList<ConsigneeDetails> getConsigneeDetails() throws Exception;

	public ArrayList<NotifyConsigneeDetails> getNotifyDetails() throws Exception;

	public ArrayList<BankDetails> getBankDetails() throws Exception;

	public ArrayList<DestinationDetails> getDestinationDetails()throws Exception;

	public ArrayList<PaymentDetails> getPaymentDetails()throws Exception;

	public ArrayList<TermsDetails> getTermsDetails()throws Exception;

	public ArrayList<CommissionDetails> getCommissionDetails(String commissnterm)throws Exception;

	public ArrayList<ProductDetails> savePrfform(ProductDetails prfbean)throws Exception;

	public ArrayList<ArticleDetails> getarticledetails()throws Exception;

	public ArrayList<ColourDetails> getColorDetails()throws Exception;

	public ArrayList<RateDetails> getRateDetails()throws Exception;

	public ArrayList<SelectionDetails> getSelectionDetails()throws Exception;

	public ArrayList<ShipmentDetails> getShipmentDetails()throws Exception;

	public ArrayList<SizeRemarks> getSizeremarksDetails() throws Exception;

	public ArrayList<TcDetails>  getTcAgentDetails() throws Exception;

	/*
	 * Article Page
	 */
	public List<SelectArticle> getarticlename()throws Exception;

	public int saveprfArticle(PrfArticle prfartbean)throws Exception;
	public List<ArticleDetails> updateprfArticle(ArticleDetails prfbean)throws Exception;
	public List<PrfArticle> getPrfArticleDetails(String myctno, String sidx, String sord)throws Exception;

	//Edit Values 
	public List<ArticleDetails> editprfArticle(String prfarticleid) throws Exception;

	public List<ArticleDetails> getArticleNameinEditGrid(String term) throws Exception;
	
	public List<ArticleDetails> getArticleTypeinEditGrid()throws Exception;
	
	public List<AutoComplete> getColorinEditGrid(String term)throws Exception;

	public List<CommissionDetails> getOtherCommissionDetails(String othercommissnterm) throws Exception;

	public List<BankDetails> getbankDetails(String bankterm)throws Exception;

	public List<ConsigneeDetails> getconsignee(String consigneeterm)throws Exception;

	public List<NotifyConsigneeDetails> getnotifyDetails(String notifyterm)throws Exception;

	public boolean addPrfArticleDetails(PrfArticle artindertdetail,
			String ctno, String sidx, String sord)throws Exception;

	
	

	

	

	
	
	


	//public Object getarticledetails();

}