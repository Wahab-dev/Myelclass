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
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.PrfArticle;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.RateDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.model.TcDetails;
import sb.elpro.model.TermsDetails;

/**
 * @author Wahab
 *
 */
public interface PrfBo  {

	public ArrayList<AgentDetails> getAgentDetails(String term) throws Exception;
	public ArrayList<TanneryDetails> getTanneryDetails(String tanterm) throws Exception;
	public ArrayList<CustomerDetails> getCustomerDetails(String custterm) throws Exception;
	public List<BankDetails> getbankDetails(String bankterm)throws Exception;
	public List<ConsigneeDetails> getconsignee(String consigneeterm)throws Exception;
	public List<NotifyConsigneeDetails> getnotifyDetails(String notifyterm)throws Exception;
	public ArrayList<AutoComplete> getPaymentDetails(String term)throws Exception;
	public ArrayList<AutoComplete> getTermsDetails(String term)throws Exception;
	public ArrayList<CommissionDetails> getCommissionDetails(String commissnterm)throws Exception;
	public List<CommissionDetails> getOtherCommissionDetails(String othercommissnterm) throws Exception;

	/*
	 * Article 
	 */
	public List<ArticleDetails> getPrfArticleName(String term) throws Exception;
	public ArrayList<ArticleDetails> getarticledetails()throws Exception;
	//public List<SelectArticle> getarticlename()throws Exception;
	public List<AutoComplete> getPrfColor(String term)throws Exception;
	public List<AutoComplete> getPrfSizeRem()throws Exception;
	//public ArrayList<SizeRemarks> getSizeremarksDetails() throws Exception;
	//public ArrayList<SelectionDetails> getSelectionDetails()throws Exception;
	public List<AutoComplete> getPrfSelection()throws Exception;
	public List<AutoComplete> getQtyUnitDetails(String term)throws Exception;
	public ArrayList<RateDetails> getRateDetails()throws Exception;
	public List<AutoComplete> getShipmentDetails(String term)throws Exception;
	public List<AutoComplete> getCurrencyDetails(String term)throws Exception;
	public List<AutoComplete> getSubCurrencyDetails(String term)throws Exception;
	public ArrayList<TcDetails> getTcAgentDetails() throws Exception;
	public List<AutoComplete> getTcCustDetails(String term)throws Exception;
	public List<AutoComplete> getPrfColormatch()throws Exception;

	
	
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	/*
	 * Prf Crud 
	 */
	public List<PrfArticle> getPrfArticleDetails(String ctno, String sidx, String sord)throws Exception;
	
	public boolean addPrfArticleDetails(PrfArticle artindertdetail,
			String sord, String sidx)throws Exception;

	public boolean editPrfArticleDetails(PrfArticle artindertdetail,
			String ctno, String sidx)throws Exception;

	public boolean delPrfArticleDetails(PrfArticle artindertdetail,
			String artid, String sidx)throws Exception;

	public List<ArticleDetails> getPrfArticleType()throws Exception;

	public int saveprfArticle(PrfArticle prfartbean)throws Exception;
	/*
	 * Edit PRf Form
	 */
	public List<ProductDetails> getEditPrfFormValues(String ctno)throws Exception;

	
	/**  
	 * (Method description)
	 * @param
	 * @return 
	 * etc
	 */
	public boolean updatePrfform(ProductDetails prfbean)throws Exception;
	
	
	//Save Prf
	public boolean savePrfform(ProductDetails prfbean)throws Exception;
		
	/*
	 * PO JW 
	 * 
	 */
	public String getPoJWno()throws Exception;
	public boolean savePoJwForm(ProductDetails prfbean)throws Exception;
	public List<PrfArticle> getPojwArticleDetails(String ctno)throws Exception;
	
	//Copy Article to POJW Article
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	public List<PrfArticle> getPoJwPrfArticleDetails(String copyctno, String copypojw)throws Exception;
	

	
	

}
