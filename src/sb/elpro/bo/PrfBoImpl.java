/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.PrfDao;
import sb.elpro.dao.PrfDaoImpl;
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
import sb.elpro.model.SelectArticle;
import sb.elpro.model.SelectionDetails;
import sb.elpro.model.SizeRemarks;
import sb.elpro.model.TanneryDetails;
import sb.elpro.model.TcDetails;
import sb.elpro.model.TermsDetails;

/**
 * @author Wahab
 *
 */
public class PrfBoImpl implements PrfBo {

	private PrfDao prfdao;
	
	
	public PrfBoImpl(){
		this.prfdao = new PrfDaoImpl();
	}
	
	@Override
	
	public ArrayList<AgentDetails> getAgentDetails(String term) throws Exception {
		ArrayList<AgentDetails> agentList = prfdao.getAgentList(term);
		return agentList;
	}

	@Override
	public ArrayList<TanneryDetails> getTanneryDetails(String tanterm) throws Exception {
		ArrayList<TanneryDetails> tanneryList = prfdao.getTanneryList(tanterm);
		return tanneryList;
	}

	@Override
	public ArrayList<CustomerDetails> getCustomerDetails(String custterm) throws Exception {
		ArrayList<CustomerDetails> customerList = prfdao.getCustomerList(custterm);
		return customerList;
	}

	

	/*@Override
	public ArrayList<DestinationDetails> getDestinationDetails()throws Exception {
		ArrayList<DestinationDetails> destiList = prfdao.getDestinationList();
		return destiList;
	}
*/
	@Override
	public ArrayList<AutoComplete> getPaymentDetails(String terms) throws Exception {
		ArrayList<AutoComplete> paymentList = prfdao.getPaymnetList(terms);
		return paymentList;
	}

	@Override
	public ArrayList<AutoComplete> getTermsDetails(String payment) throws Exception {
		ArrayList<AutoComplete> termList = prfdao.getTermsList(payment);
		return termList;
	}

	@Override
	public ArrayList<CommissionDetails> getCommissionDetails(String comminsion) throws Exception {
		ArrayList<CommissionDetails> commissionList = prfdao.getCommissionList(comminsion);
		return commissionList;
	}

	

	@Override
	public ArrayList<ArticleDetails> getarticledetails() throws Exception {
		ArrayList<ArticleDetails> articleList = prfdao.getArticleList();
		return articleList;
	}
	//get the Article Name
	/*@Override
	public List<SelectArticle> getarticlename() throws Exception {
		List<SelectArticle> articlenameList = prfdao.getArticleNameList();
		return articlenameList;
	}*/

	@Override
	public ArrayList<RateDetails> getRateDetails() throws Exception {
		ArrayList<RateDetails> rateList = prfdao.getRateList();
		return rateList;
	}

	/*@Override
	public ArrayList<SelectionDetails> getSelectionDetails() throws Exception {
		ArrayList<SelectionDetails> selecList = prfdao.getSelectionList();
		return selecList;
	}*/

	/*@Override
	public ArrayList<AutoComplete> getShipmentDetails() throws Exception {
		ArrayList<AutoComplete> shipmentList = prfdao.getShipmentList();
		return shipmentList;
	}*/

/*	@Override
	public ArrayList<SizeRemarks> getSizeremarksDetails() throws Exception {
		ArrayList<SizeRemarks> sizeremarksList = prfdao.getSizeremarksList();
		return sizeremarksList;
	}*/

	@Override
	public ArrayList<TcDetails> getTcAgentDetails() throws Exception {
		ArrayList<TcDetails> tcagentList = prfdao.getTcAgentList();
		return tcagentList;
	}

	/*
	 * Article Page
	 * @see sb.elpro.bo.PrfBo#saveprfArticle(sb.elpro.model.PrfArticle)
	 */
	@Override
	public int saveprfArticle(PrfArticle prfarticlebean) 
			throws Exception  {
		int rowsinserted = 0;		 
		 String rate  = prfarticlebean.getPrf_ratesign() +" "+  prfarticlebean.getPrf_rate() +" "+  prfarticlebean.getPrf_shipment();
		 prfarticlebean.setPrf_price(rate);
		 	
		 String tc = prfarticlebean.getPrf_tcamt() +" "+   prfarticlebean.getPrf_tccurrency() +" "+  prfarticlebean.getPrf_tcagent();
		 prfarticlebean.setPrf_tc(tc);
		 
		 System.out.println("Article Name in BOImpl"+prfarticlebean.getPrf_articlename());
		rowsinserted = prfdao.saveprfArticleList(prfarticlebean);
		return rowsinserted;
	}

	
	@Override
	public List<ArticleDetails> getPrfArticleName(String term)
			throws Exception {
		List<ArticleDetails> prfdarticlenamegridarray = prfdao.getPrfArticleNamelist(term);
		return prfdarticlenamegridarray;
	}
	
	@Override
	public List<ArticleDetails> getPrfArticleType()
			throws Exception {
		List<ArticleDetails> prfdarticletypegridarray = prfdao.getPrfArticleTypelist();
		return prfdarticletypegridarray;
	}

	@Override
	public List<CommissionDetails> getOtherCommissionDetails(
			String othercommissnterm) throws Exception {
		ArrayList<CommissionDetails> othercommissionList = prfdao.getOtherCommissionList(othercommissnterm);
		return othercommissionList;
	}

	@Override
	public List<BankDetails> getbankDetails(String bankterm) throws Exception {
		ArrayList<BankDetails> bankList = prfdao.getbankList(bankterm);
		return bankList;
	}

	@Override
	public List<ConsigneeDetails> getconsignee(String consigneeterm) throws Exception {
		ArrayList<ConsigneeDetails> consigneeList = prfdao.getcnsigneeList(consigneeterm);
		return consigneeList;
	}

	@Override
	public List<NotifyConsigneeDetails> getnotifyDetails(String notifyterm) throws Exception {
		ArrayList<NotifyConsigneeDetails> notifyList = prfdao.getnotifyList(notifyterm);
		return notifyList;
	}

	@Override
	public List<AutoComplete> getPrfColor(String term) throws Exception {
		List<AutoComplete> prfcolrgridarray = prfdao.getPrfColorlist(term);
		return prfcolrgridarray;
	}

	@Override
	public List<PrfArticle> getPrfArticleDetails(String ctno, String sidx, String sord) throws Exception {
		ArrayList<PrfArticle> aticlearray = prfdao.getPrfArticleDetails(ctno,sidx,sord);
		return aticlearray;
	}

	
	@Override
	public boolean addPrfArticleDetails(PrfArticle artindertdetail,
			String sidx, String sord) throws Exception {
		boolean isadded = prfdao.addprfArticle(artindertdetail, sidx, sord);
		return isadded;
	}

	@Override
	public boolean editPrfArticleDetails(PrfArticle artindertdetail,
			String sidx, String sord) throws Exception {
		boolean isupdate = prfdao.editprfArticle(artindertdetail, sidx, sord);
		return isupdate;
	}

	@Override
	public boolean delPrfArticleDetails(PrfArticle artindertdetail,
			String sidx, String sord) throws Exception {
		boolean isdelete = prfdao.delprfArticle(artindertdetail, sidx, sord);
		return isdelete;
	}

	
	/*
	 * (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getEditPrfArticleDetails(java.lang.String)
	 * Edit PRf Form
	 */
	
		
	@Override
	public List<ProductDetails> getEditPrfFormValues(String ctno) throws Exception {
		List<ProductDetails> editprfformarray = prfdao.getEditPrfFormDetails(ctno);
		return editprfformarray;
	}

	@Override
	public boolean savePrfform(ProductDetails prfbean)
			throws Exception {
		boolean isSavePrf = prfdao.savePrfForm(prfbean);
		return isSavePrf;
	}
	
	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#updatePrfform(sb.elpro.model.ProductDetails)
	 */
	@Override
	public boolean updatePrfform(ProductDetails prfbean) throws Exception {
		boolean isUpdatePrf = prfdao.updatePrfForm(prfbean);
		return isUpdatePrf;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getPoJWno()
	 */
	@Override
	public String getPoJWno() throws Exception {
		String maxpojwno = prfdao.getPoJwno();
		if(maxpojwno.isEmpty() || maxpojwno.equalsIgnoreCase("Null")){
			maxpojwno = "PO001/14-15";
		}		
		return maxpojwno;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#savePoJwForm(sb.elpro.model.PoJwBean)
	 */
	@Override
	public boolean savePoJwForm(ProductDetails pojw) throws Exception{
		boolean isSavePoJw = prfdao.savePoJwForm(pojw);
		return isSavePoJw;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getShipmentDetails(java.lang.String)
	 */
	@Override
	public List<AutoComplete> getShipmentDetails(String term) throws Exception {
		ArrayList<AutoComplete> shipmentList = prfdao.getShipmentList(term);
		return shipmentList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getPrfSelection()
	 */
	@Override
	public List<AutoComplete> getPrfSelection() throws Exception {
		ArrayList<AutoComplete> selecList = prfdao.getPrfSelectionList();
		return selecList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getPrfColormatch()
	 */
	@Override
	public List<AutoComplete> getPrfColormatch() throws Exception {
		ArrayList<AutoComplete> colormatchList = prfdao.getPrfColorMatchList();
		return colormatchList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getPojwArticleDetails(java.lang.String)
	 */
	@Override
	public List<PrfArticle> getPojwArticleDetails(String ctno)  throws Exception {
		ArrayList<PrfArticle> pojwaticlearray = prfdao.getPojwArticleDetails(ctno);
		return pojwaticlearray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getPrfSizeRem()
	 */
	@Override
	public List<AutoComplete> getPrfSizeRem() throws Exception {
		ArrayList<AutoComplete> sizeremList = prfdao.getSizeRemList();
		return sizeremList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getQtyUnitDetails(java.lang.String)
	 */
	@Override
	public List<AutoComplete> getQtyUnitDetails(String term) throws Exception {
		ArrayList<AutoComplete> qtyunitList = prfdao.getQtyunitList();
		return qtyunitList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getCurrencyDetails(java.lang.String)
	 */
	@Override
	public List<AutoComplete> getCurrencyDetails(String term) throws Exception {
		ArrayList<AutoComplete> currncyList = prfdao.getCurrencyList();
		return currncyList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getSubCurrencyDetails(java.lang.String)
	 */
	@Override
	public List<AutoComplete> getSubCurrencyDetails(String term)
			throws Exception {
		ArrayList<AutoComplete> subcurrncyList = prfdao.getSubCurrencyList();
		return subcurrncyList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getTcCustDetails(java.lang.String)
	 */
	@Override
	public List<AutoComplete> getTcCustDetails(String term) throws Exception {
		ArrayList<AutoComplete> tccustList = prfdao.getTcCustList();
		return tccustList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.PrfBo#getPoJwPrfArticleDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public List<PrfArticle> getPoJwPrfArticleDetails(String copyctno, String copypojw) throws Exception {
		ArrayList<PrfArticle> tccustList = prfdao.addpoArticle(copyctno, copypojw);
			return tccustList;
	}



	
}
