/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;


import sb.elpro.dao.InvoiceDao;
import sb.elpro.dao.InvoiceDaoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.ExporterDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.InvCustContractDetails;
import sb.elpro.model.NotifyConsigneeDetails;

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
	public List<DestinationDetails> getInvLoadingPort() throws Exception {
		ArrayList<DestinationDetails> invloadingportarr = invdao.getInvLoadingPort();
		return invloadingportarr;
	}
	@Override
	public List<DestinationDetails> getInvFinalDestinationCountry()
			throws Exception {
		ArrayList<DestinationDetails> invDestiCountryarr = invdao.getInvDestiCountry();
		return invDestiCountryarr;
	}
	@Override
	public List<DestinationDetails> getInvFinalDestination() throws Exception {
		ArrayList<DestinationDetails> invFinalDestinationarr = invdao.getInvFinalDestination();
		return invFinalDestinationarr;
	}
	@Override
	public List<DestinationDetails> getInvDischargeport() throws Exception {
		ArrayList<DestinationDetails> invDischargeportarr = invdao.getinvDischargePort();
		return invDischargeportarr;
	}
	@Override
	public List<CustomerDetails> getInvCustomer() throws Exception {
		ArrayList<CustomerDetails> invCustomerarr = invdao.getinvCustomerDetails();
		return invCustomerarr;
	}
	@Override
	public List<InvCustContractDetails> getInvCustContract()  throws Exception {
		ArrayList<InvCustContractDetails> invCustomerctarr = invdao.getinvCustContracttDetails();
		return invCustomerctarr;
	}
	
	///GRID LOAD CUSTOMER CT DETAILS
	@Override
	public List<CustomerInvoice> getInvCustCtDetails(String custid, String sortname, String sortord) throws Exception {
		ArrayList<CustomerInvoice> invCustomerctlist = invdao.getInvCustCtlist(custid, sortname,sortord );
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
	public List<ArticleDetails> getInvSelCtDetails(String ctno)
			throws Exception {
		ArrayList<ArticleDetails> invSelCtarr = invdao.getInvDelContractDetails(ctno);
		return invSelCtarr;
	}
	@Override
	public int getInvAddBillDetails(InvBillDetails invbill)
			throws Exception {
		int invaddbillarr = invdao.getInvAddbillDetails(invbill);
		System.out.println("111");
		return invaddbillarr;
	}
	@Override
	public List<InvBillDetails> getInvBillDetails(String invno)
			throws Exception {
		ArrayList<InvBillDetails> invBillarr = invdao.getInvBillDetails(invno);
		return invBillarr;
	}
	
	
}
