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
public class PrfBoImpl implements PrfBo {

	private PrfDao prfdao;
	
	
	public PrfBoImpl(){
		this.prfdao = new PrfDaoImpl();
	}
	
	@Override
	public ArrayList<AgentDetails> getAgentDetails() throws Exception {
		ArrayList<AgentDetails> agentList = prfdao.getAgentList();
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

	

	@Override
	public ArrayList<DestinationDetails> getDestinationDetails()throws Exception {
		ArrayList<DestinationDetails> destiList = prfdao.getDestinationList();
		return destiList;
	}

	@Override
	public ArrayList<PaymentDetails> getPaymentDetails() throws Exception {
		ArrayList<PaymentDetails> paymentList = prfdao.getPaymnetList();
		return paymentList;
	}

	@Override
	public ArrayList<TermsDetails> getTermsDetails() throws Exception {
		ArrayList<TermsDetails> termList = prfdao.getTermsList();
		return termList;
	}

	@Override
	public ArrayList<CommissionDetails> getCommissionDetails(String comminsion) throws Exception {
		ArrayList<CommissionDetails> commissionList = prfdao.getCommissionList(comminsion);
		return commissionList;
	}

	@Override
	public ArrayList<ProductDetails> savePrfform(ProductDetails prfbean)
			throws Exception {
		ArrayList<ProductDetails> saveprfDetails = prfdao.savePrfForm();
		return saveprfDetails;
	}

	@Override
	public ArrayList<ArticleDetails> getarticledetails() throws Exception {
		ArrayList<ArticleDetails> articleList = prfdao.getArticleList();
		return articleList;
	}
	//get the Article Name
	@Override
	public List<SelectArticle> getarticlename() throws Exception {
		List<SelectArticle> articlenameList = prfdao.getArticleNameList();
		return articlenameList;
	}

	@Override
	public ArrayList<ColourDetails> getColorDetails() throws Exception {
		ArrayList<ColourDetails> colorList = prfdao.getColorList();
		return colorList;
	}

	@Override
	public ArrayList<RateDetails> getRateDetails() throws Exception {
		ArrayList<RateDetails> rateList = prfdao.getRateList();
		return rateList;
	}

	@Override
	public ArrayList<SelectionDetails> getSelectionDetails() throws Exception {
		ArrayList<SelectionDetails> selecList = prfdao.getSelectionList();
		return selecList;
	}

	@Override
	public ArrayList<ShipmentDetails> getShipmentDetails() throws Exception {
		ArrayList<ShipmentDetails> shipmentList = prfdao.getShipmentList();
		return shipmentList;
	}

	@Override
	public ArrayList<SizeRemarks> getSizeremarksDetails() throws Exception {
		ArrayList<SizeRemarks> sizeremarksList = prfdao.getSizeremarksList();
		return sizeremarksList;
	}

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
		String selectp1 = null; 
		String selectp2 = null; 
		String selectp3 = null;
		String selectp4 = null;
		
		String sizemin = prfarticlebean.getPrf_sizemin();
		String sizemax = prfarticlebean.getPrf_sizemax();
		String unit = prfarticlebean.getPrf_unit();
		String sizeremarks = prfarticlebean.getPrf_sizeremarks();		
		String size  = sizemin +" / "+ sizemax + " "+unit + " "+sizeremarks;
		prfarticlebean.setPrf_size(size); 	
		
		String subatancemin = prfarticlebean.getPrf_substancemin();
		String subatancemax = prfarticlebean.getPrf_substancemax();
		String substance = subatancemin + " / " +subatancemax + " mm";
		prfarticlebean.setPrf_substance(substance);
		
		
		 selectp1 = prfarticlebean.getPrf_selectionp1();
		 selectp2 = prfarticlebean.getPrf_selectionp2();
		 selectp3 = prfarticlebean.getPrf_selectionp3();		
		 selectp4 = prfarticlebean.getPrf_selectionp4();
		 
		 String selecp = selectp1+"%"+selectp2+"%"+selectp3+"%"+selectp4;
		 prfarticlebean.setPrf_selectionp(selecp);
		 
		 String rate  = prfarticlebean.getPrf_ratesign() +" "+  prfarticlebean.getPrf_rate() +" "+  prfarticlebean.getPrf_shipment();
		 prfarticlebean.setPrf_price(rate);
		 	
		 String tc = prfarticlebean.getPrf_tcamt() +" "+   prfarticlebean.getPrf_tccurrency() +" "+  prfarticlebean.getPrf_tcagent();
		 prfarticlebean.setPrf_tc(tc);
		 
		 System.out.println("Article Name in BOImpl"+prfarticlebean.getPrf_articlename());
		rowsinserted = prfdao.saveprfArticleList(prfarticlebean);
		return rowsinserted;
	}

	@Override
	public List<PrfArticle> getPrfArticleDetails(String myctno, String sidx, String sord) throws Exception {
		ArrayList<PrfArticle> aticlearray = prfdao.getPrfArticleDetails(myctno,sidx,sord);
		return aticlearray;
	}

	@Override
	public List<ArticleDetails> updateprfArticle(ArticleDetails prfartbean) throws Exception{
		String selectp1 = null; 
		String selectp2 = null; 
		String selectp3 = null;
		String selectp4 = null;
		
		String sizemin = prfartbean.getSize_min();
		String sizemax = prfartbean.getSize_max();
		String unit = prfartbean.getUnit();
		String articletype = prfartbean.getSize_remarks();		
		String size  = sizemin +" / "+ sizemax + " "+unit + " "+articletype;
		prfartbean.setSize(size); 	
		
		String subatancemin = prfartbean.getSubs_min();
		String subatancemax = prfartbean.getSubs_max();
		String substance = subatancemin + " / " +subatancemax+ " mm";
		prfartbean.setSubstance(substance);
		
		selectp1 = prfartbean.getSelp1();
			 selectp2 = prfartbean.getSelp2();
			 selectp3 = prfartbean.getSelp3();		
			 selectp4 = prfartbean.getSelp4();
			 
			String selecp = selectp1+"%"+selectp2+"%"+selectp3+"%"+selectp4;
			prfartbean.setSelp(selecp);
			
			String rate  = prfartbean.getRate_sign() +" "+prfartbean.getRate() +" "+prfartbean.getShipment();
			prfartbean.setPrice(rate);
			
			String tc = prfartbean.getTc_amount() +" "+ prfartbean.getTc_currency()+" "+ prfartbean.getTc_agent();
			prfartbean.setTc(tc);
	
		return prfdao.updateprfArticle(prfartbean);
	}

	@Override
	public List<ArticleDetails> editprfArticle(String prfarticleid) throws Exception {
		 List<ArticleDetails> editarticlelist = prfdao.editprfArticle(prfarticleid);
		 return editarticlelist;
	}

	@Override
	public List<ArticleDetails> getArticleNameinEditGrid(String term)
			throws Exception {
		List<ArticleDetails> prfdarticlenamegridarray = prfdao.getArticleNameinEditGridlist(term);
		return prfdarticlenamegridarray;
	}
	
	@Override
	public List<ArticleDetails> getArticleTypeinEditGrid()
			throws Exception {
		List<ArticleDetails> prfdarticletypegridarray = prfdao.getArticleTypeinEditGridlist();
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
	public List<AutoComplete> getColorinEditGrid(String term) throws Exception {
		List<AutoComplete> prfcolrgridarray = prfdao.getColorGridlist(term);
		return prfcolrgridarray;
	}

	@Override
	public boolean addPrfArticleDetails(PrfArticle artindertdetail,
			String ctno, String sidx, String sord) throws Exception {
		boolean isupdate = prfdao.addprfArticle(artindertdetail,ctno, sidx, sord);
		return isupdate;
	}

	


	



	
}
