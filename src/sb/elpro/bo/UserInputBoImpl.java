/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.UserInputDao;
import sb.elpro.dao.UserInputDaoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.model.TermsDetails;

/**
 * @author Wahab
 *
 */
public class UserInputBoImpl implements UserInputBo {

private UserInputDao userinputdao;
	
	
	public UserInputBoImpl(){
		this.userinputdao = new UserInputDaoImpl();
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getTanneryDetails()
	 */
	@Override
	public List<TanneryDetails> getTanneryDetails() throws Exception {
		ArrayList<TanneryDetails> tanneryList = userinputdao.getTanneryList();
		return tanneryList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addTanneryDetails(sb.elpro.model.TanneryDetails)
	 */
	@Override
	public boolean addTanneryDetails(TanneryDetails addtannerydetail) throws Exception {
		boolean isaddedtanneryList = userinputdao.addTanneryList(addtannerydetail);
		return isaddedtanneryList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editTanneryDetails(sb.elpro.model.TanneryDetails)
	 */
	@Override
	public boolean editTanneryDetails(TanneryDetails edittannerydetail)
			throws Exception {
		boolean isupdtdtanneryList = userinputdao.editTanneryList(edittannerydetail);
		return isupdtdtanneryList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delTanneryDetails(sb.elpro.model.TanneryDetails)
	 */
	@Override
	public boolean delTanneryDetails(TanneryDetails deltannerydetail)
			throws Exception {
		boolean isdeltanneryList = userinputdao.delTanneryList(deltannerydetail);
		return isdeltanneryList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getCustomerDetails()
	 */
	@Override
	public List<CustomerDetails> getCustomerDetails() throws Exception {
		ArrayList<CustomerDetails> customerList = userinputdao.getCustomerList();
		return customerList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addcustdetails(sb.elpro.model.CustomerDetails)
	 */
	@Override
	public boolean addCustdetails(CustomerDetails addcustdetail)
			throws Exception {
		boolean isaddedcustList = userinputdao.addCustomerList(addcustdetail);
		return isaddedcustList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editcustDetails(sb.elpro.model.CustomerDetails)
	 */
	@Override
	public boolean editCustDetails(CustomerDetails editcustdetail)
			throws Exception {
		boolean isupdtdcustList = userinputdao.editCustomerList(editcustdetail);
		return isupdtdcustList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delcustDetails(sb.elpro.model.CustomerDetails)
	 */
	@Override
	public boolean delCustDetails(CustomerDetails delcustdetail)
			throws Exception {
		boolean isdeltdcustList = userinputdao.delCustomerList(delcustdetail);
		return isdeltdcustList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getConsigneeDetails()
	 */
	@Override
	public List<ConsigneeDetails> getConsigneeDetails() throws Exception {
		ArrayList<ConsigneeDetails> consigList = userinputdao.getConsigneeList();
		return consigList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addConsigdetails(sb.elpro.model.ConsigneeDetails)
	 */
	@Override
	public boolean addConsigdetails(ConsigneeDetails addconsigdetail)
			throws Exception {
		boolean isaddedconsigList = userinputdao.addConsigneeList(addconsigdetail);
		return isaddedconsigList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editConsigDetails(sb.elpro.model.ConsigneeDetails)
	 */
	@Override
	public boolean editConsigDetails(ConsigneeDetails editconsigdetail)
			throws Exception {
		boolean isupdtdconsigList = userinputdao.editConsigList(editconsigdetail);
		return isupdtdconsigList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delConsigDetails(sb.elpro.model.ConsigneeDetails)
	 */
	@Override
	public boolean delConsigDetails(ConsigneeDetails delconsigdetail)
			throws Exception {
		boolean isdeltdconsigtList = userinputdao.delConsigList(delconsigdetail);
		return isdeltdconsigtList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getNotifyDetails()
	 */
	@Override
	public List<NotifyConsigneeDetails> getNotifyDetails() throws Exception {
		ArrayList<NotifyConsigneeDetails> notifyList = userinputdao.getNotifyList();
		return notifyList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addNotifydetails(sb.elpro.model.NotifyConsigneeDetails)
	 */
	@Override
	public boolean addNotifydetails(NotifyConsigneeDetails addnotifydetail)
			throws Exception {
		boolean isaddednotifyList = userinputdao.addNotifyList(addnotifydetail);
		return isaddednotifyList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editNotifyDetails(sb.elpro.model.NotifyConsigneeDetails)
	 */
	@Override
	public boolean editNotifyDetails(NotifyConsigneeDetails editnotifydetail)
			throws Exception {
		boolean isupdtdnotifyList = userinputdao.editNotifyList(editnotifydetail);
		return isupdtdnotifyList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delNotifyDetails(sb.elpro.model.NotifyConsigneeDetails)
	 */
	@Override
	public boolean delNotifyDetails(NotifyConsigneeDetails delnotifydetail)
			throws Exception {
		boolean isdeltdnotifyList = userinputdao.delNotifyList(delnotifydetail);
		return isdeltdnotifyList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getBankDetails()
	 */
	@Override
	public List<BankDetails> getBankDetails() throws Exception {
		ArrayList<BankDetails> bankList = userinputdao.getBankList();
		return bankList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addBankdetails(sb.elpro.model.BankDetails)
	 */
	@Override
	public boolean addBankdetails(BankDetails addbankdetail) throws Exception {
		boolean isaddedbankList = userinputdao.addBankList(addbankdetail);
		return isaddedbankList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editBankDetails(sb.elpro.model.BankDetails)
	 */
	@Override
	public boolean editBankDetails(BankDetails editbankdetail) throws Exception {
		boolean isupdtdbankList = userinputdao.editBankList(editbankdetail);
		return isupdtdbankList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delBankDetails(sb.elpro.model.BankDetails)
	 */
	@Override
	public boolean delBankDetails(BankDetails delbankdetail) throws Exception {
		boolean isdeltdbankList = userinputdao.delBankList(delbankdetail);
		return isdeltdbankList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getArticleDetails()
	 */
	@Override
	public List<ArticleDetails> getArticleDetails() throws Exception {
		ArrayList<ArticleDetails> articleList = userinputdao.getArticleList();
		return articleList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addArticledetails(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean addArticledetails(ArticleDetails addarticledetail)  throws Exception{
		boolean isaddedarticleList = userinputdao.addArticleList(addarticledetail);
		return isaddedarticleList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editArticleDetails(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean editArticleDetails(ArticleDetails editarticledetail)  throws Exception{
		boolean isupdtdarticleList = userinputdao.editArticleList(editarticledetail);
		return isupdtdarticleList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delArticleDetails(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean delArticleDetails(ArticleDetails delarticledetail)  throws Exception{
		boolean isdeltdarticleList = userinputdao.delArticleList(delarticledetail);
		return isdeltdarticleList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getCommissionDetails()
	 */
	@Override
	public List<CommissionDetails> getCommissionDetails() throws Exception {
		ArrayList<CommissionDetails> commList = userinputdao.getCommList();
		return commList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addCommdetails(sb.elpro.model.CommissionDetails)
	 */
	@Override
	public boolean addCommdetails(CommissionDetails addcommdetail)
			throws Exception {
		boolean isaddedcommList = userinputdao.addCommList(addcommdetail);
		return isaddedcommList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editCommDetails(sb.elpro.model.CommissionDetails)
	 */
	@Override
	public boolean editCommDetails(CommissionDetails editcommdetail)
			throws Exception {
		boolean isupdtdcommList = userinputdao.editCommList(editcommdetail);
		return isupdtdcommList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delCommDetails(sb.elpro.model.CommissionDetails)
	 */
	@Override
	public boolean delCommDetails(CommissionDetails delcommdetail)
			throws Exception {
		boolean isdeltdcommList = userinputdao.delCommList(delcommdetail);
		return isdeltdcommList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getDestiDetails()
	 */
	@Override
	public List<DestinationDetails> getDestiDetails() throws Exception {
		ArrayList<DestinationDetails> destiList = userinputdao.getDestiList();
		return destiList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addDestidetails(sb.elpro.model.DestinationDetails)
	 */
	@Override
	public boolean addDestidetails(DestinationDetails adddestidetail)
			throws Exception {
		boolean isaddeddestiList = userinputdao.addDestiList(adddestidetail);
		return isaddeddestiList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editDestiDetails(sb.elpro.model.DestinationDetails)
	 */
	@Override
	public boolean editDestiDetails(DestinationDetails editdestidetail)
			throws Exception {
		boolean isupdtddestiList = userinputdao.editDestiList(editdestidetail);
		return isupdtddestiList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delDestiDetails(sb.elpro.model.DestinationDetails)
	 */
	@Override
	public boolean delDestiDetails(DestinationDetails deldestidetail)
			throws Exception {
		boolean isdeltddestiList = userinputdao.delDestiList(deldestidetail);
		return isdeltddestiList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getColorDetails()
	 */
	@Override
	public List<ArticleDetails> getColorDetails() throws Exception {
		ArrayList<ArticleDetails> colorList = userinputdao.getColorList();
		return colorList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addColordetails(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean addColordetails(ArticleDetails addcolorbean)
			throws Exception {
		boolean isaddedcolorList = userinputdao.addColorList(addcolorbean);
		return isaddedcolorList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editColorDetails(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean editColorDetails(ArticleDetails editcolorbean)
			throws Exception {
		boolean isupdtdcolorList = userinputdao.editColorList(editcolorbean);
		return isupdtdcolorList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delColorDetails(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean delColorDetails(ArticleDetails delcolorbean)
			throws Exception {
		boolean isdeltdcolorList = userinputdao.delColorList(delcolorbean);
		return isdeltdcolorList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getTermDetails()
	 */
	@Override
	public List<TermsDetails> getTermDetails() throws Exception {
		ArrayList<TermsDetails> termList = userinputdao.getTermList();
		return termList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addTermdetails(sb.elpro.model.TermsDetails)
	 */
	@Override
	public boolean addTermdetails(TermsDetails addtermbean) throws Exception {
		boolean isaddedtermList = userinputdao.addTermList(addtermbean);
		return isaddedtermList;
	}



	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editTermDetails(sb.elpro.model.TermsDetails)
	 */
	@Override
	public boolean editTermDetails(TermsDetails edittermbean) throws Exception {
		boolean isupdtdtermList = userinputdao.editTermList(edittermbean);
		return isupdtdtermList;
		
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delTermDetails(sb.elpro.model.TermsDetails)
	 */
	@Override
	public boolean delTermDetails(TermsDetails deltermbean) throws Exception {
		
		boolean isdeltdtermList = userinputdao.delTermList(deltermbean);
		return isdeltdtermList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#getPaymntDetails()
	 */
	@Override
	public List<PaymentDetails> getPaymntDetails() throws Exception {
		ArrayList<PaymentDetails> paymntList = userinputdao.getPaymntList();
		return paymntList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#addPaymntdetails(sb.elpro.model.PaymentDetails)
	 */
	@Override
	public boolean addPaymntdetails(PaymentDetails addpaymntbean)
			throws Exception {
		boolean isaddedpaymntList = userinputdao.addPaymntList(addpaymntbean);
		return isaddedpaymntList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#editPaymntDetails(sb.elpro.model.PaymentDetails)
	 */
	@Override
	public boolean editPaymntDetails(PaymentDetails editpaymntbean)
			throws Exception {
		boolean isupdtdpaymntList = userinputdao.editPaymntList(editpaymntbean);
		return isupdtdpaymntList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.UserInputBo#delPaymntDetails(sb.elpro.model.PaymentDetails)
	 */
	@Override
	public boolean delPaymntDetails(PaymentDetails delpaymntbean)
			throws Exception {
		boolean isdeltdpaymntList = userinputdao.delPaymntList(delpaymntbean);
		return isdeltdpaymntList;
	}

	
	
}
