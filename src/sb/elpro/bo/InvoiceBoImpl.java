/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;


import sb.elpro.actionform.InvoiceForm;
import sb.elpro.dao.InvoiceDao;
import sb.elpro.dao.InvoiceDaoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.ExporterDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.InvCustContractDetails;
import sb.elpro.model.InvoiceBean;
import sb.elpro.model.InvoiceTotAmtDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.SampleInvoiceBean;
import sb.elpro.model.TermsDetails;

/**
 * @author Wahab
 *
 */
public class InvoiceBoImpl implements InvoiceBo {
	 private InvoiceDao invdao;
	 
	 
	public InvoiceBoImpl() {
		this.invdao = new InvoiceDaoImpl();
	}
	@Override
	public List<ExporterDetails> getInvExporter(String expterm) throws Exception {
		ArrayList<ExporterDetails> invExporterarr = invdao.getInvExporter(expterm);
		return invExporterarr;
	}
	@Override
	public List<NotifyConsigneeDetails> getInvNotify() throws Exception {
		ArrayList<NotifyConsigneeDetails> invNotifyarr = invdao.getInvNotify();
		return invNotifyarr;
	}
	@Override
	public List<BankDetails> getInvBank() throws Exception {
		ArrayList<BankDetails> invBankarr = invdao.getInvBank();
		return invBankarr;
	}
	
	@Override
	public List<DestinationDetails> getLoadinCtryName(String loadctryterm)
			throws Exception {
		ArrayList<DestinationDetails> invLoadinCtryNamelist = invdao.getInvloadctrylist(loadctryterm);
		return invLoadinCtryNamelist;
	}
	
	@Override
	public List<DestinationDetails> getLoadinPortName(String loadportterm, String ctryvalterm)
			throws Exception {
		ArrayList<DestinationDetails> invLoadinPortNamelist = invdao.getInvloadportlist(loadportterm,ctryvalterm);
		return invLoadinPortNamelist;
	}

	@Override
	public List<DestinationDetails> getDestiCtryName(String destictryterm)
			throws Exception {
		ArrayList<DestinationDetails> invDestiCtryNamelist = invdao.getInvDestiCtrylist(destictryterm);
		return invDestiCtryNamelist;
	}
	
	@Override
	public List<DestinationDetails> getDestiPortName(String destictryterm, String destictryvalterm) throws Exception {
		ArrayList<DestinationDetails> invDestiPortNamelist = invdao.getInvDestiPortlist(destictryterm, destictryvalterm);
		return invDestiPortNamelist;
	}
	
	@Override
	public List<CustomerDetails> getInvCustomer() throws Exception {
		ArrayList<CustomerDetails> invCustomerarr = invdao.getinvCustomerDetails();
		return invCustomerarr;
	}
	///GRID LOAD CUSTOMER CT DETAILS
	@Override
	public List<CustomerInvoice> getInvCustCtDetails(String custid, String type, String sortname, String sortord) throws Exception {
		ArrayList<CustomerInvoice> invCustomerctlist = invdao.getInvCustCtlist(custid, type, sortname,sortord );
		return invCustomerctlist;
	}
	//Autocomplete Customer
	@Override
	public List<CustomerDetails> getCustomerDetails(String custterm)
			throws Exception {
		ArrayList<CustomerDetails> invCustomerctlist = invdao.getInvCustlist(custterm);
		return invCustomerctlist;
	}
	
	
	@Override
	public List<ArticleDetails> getInvSelCtDetails(String ctno, String type)
			throws Exception {
		ArrayList<ArticleDetails> invSelCtarr = invdao.getInvSelContractDetails(ctno,type);
		return invSelCtarr;
	}
	@Override
	public boolean getInvAddBillDetails(InvBillDetails invbill)
			throws Exception {
		boolean invaddbillarr = invdao.getInvAddbillDetails(invbill);
		return invaddbillarr;
	}
	@Override
	public List<InvBillDetails> getInvBillDetails(String invno, String ctno,String type)
			throws Exception {
		ArrayList<InvBillDetails> invBillarr = invdao.getInvBillDetails(invno,ctno,type);
		return invBillarr;
	}
	@Override
	public String getInvoiceNo(String invtype) throws Exception {
		String invNumarr = invdao.getInvoiceNoDetails(invtype);
		return invNumarr;
	}
	@Override
	public boolean getInvBillAddDetails(InvBillDetails invaddagainbill) throws Exception {
		boolean invaddagainbillarr = invdao.getInvAddbillSecondDetails(invaddagainbill);
		return invaddagainbillarr;
	}
	@Override
	public boolean getInvBillEditDetails(InvBillDetails inveditbill)
			throws Exception {
		boolean inveditbillarr = invdao.getInvEditbillDetails(inveditbill);
		return inveditbillarr;
	}
	@Override
	public boolean getInvBillDelDetails(InvBillDetails invaddagainbill)
			throws Exception {
		boolean invdelbill = invdao.getInvDelbillDetails(invaddagainbill);
		return invdelbill;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#getInvBillTotAmt(java.lang.String)
	 */
	@Override
	public List<InvBillDetails> getInvBillTotAmt(String invno)
			throws Exception {
		ArrayList<InvBillDetails> invamtdetails = invdao.getInvBillTotAmtDetails(invno);
		return invamtdetails;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#getSampleInvoiceNo(java.lang.String)
	 */
	@Override
	public String getSampleInvoiceNo(String saminvtype) throws Exception {
		String saminvNumarr = invdao.getSampleInvoiceNoDetails(saminvtype);
		return saminvNumarr;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#saveInvoiceform(sb.elpro.model.InvoiceBean)
	 */
	@Override
	public boolean saveInvoiceform(InvoiceBean invbean) throws Exception {
		boolean isSaveInvoice =  invdao.saveInvoiceForm(invbean);
		return isSaveInvoice;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#getEditInvFormValues(java.lang.String)
	 */
	@Override
	public List<InvoiceBean> getEditInvFormValues(String invno)
			throws Exception {
		List<InvoiceBean> invgeteditForm = invdao.getEditInvFormDetails(invno);
		return invgeteditForm;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#updtInvoiceform(sb.elpro.model.InvoiceBean)
	 */
	@Override
	public boolean updtInvoiceform(InvoiceBean invbean) throws Exception {
		boolean isupdtinvForm = invdao.updtInvFormDetails(invbean);
		return isupdtinvForm;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#getInvTermList(java.lang.String)
	 */
	@Override
	public List<TermsDetails> getInvTermList(String term)
			throws Exception {
		List<TermsDetails> invtermslist = invdao.getInvTermlist(term);
		return invtermslist;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceBo#getPayTermList(java.lang.String)
	 */
	@Override
	public List<PaymentDetails> getPayTermList(String term) throws Exception {
		List<PaymentDetails> invpaytermslist = invdao.getInvPayTermlist(term);
		return invpaytermslist;
	}
	
	
	
	
}
