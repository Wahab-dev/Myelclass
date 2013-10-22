/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

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
public interface InvoiceBo {

	public List<ExporterDetails> getInvExporter(String expterm) throws Exception;

	public List<NotifyConsigneeDetails> getInvNotify() throws Exception;

	public List<BankDetails> getInvBank() throws Exception;
	
	public List<DestinationDetails> getLoadinCtryName(String loadctryterm)throws Exception;

	public List<DestinationDetails> getLoadinPortName(String loadportterm, String ctryvalterm)throws Exception;
	
	public List<DestinationDetails> getDestiCtryName(String destictryterm)throws Exception;
	
	public List<DestinationDetails> getDestiPortName(String destictryterm,String destictryvalterm)throws Exception;
	
	
	
	

	

	public List<CustomerDetails> getInvCustomer()throws Exception;

	public List<InvCustContractDetails> getInvCustContract()throws Exception;

	public List<CustomerInvoice> getInvCustCtDetails(String cust, String sord, String sord2)throws Exception;

	public List<CustomerDetails> getCustomerDetails(String tanterm)throws Exception;

	

	public List<ArticleDetails> getInvSelCtDetails(String ctno)throws Exception;

	public int getInvAddBillDetails(InvBillDetails invbill)throws Exception;

	public List<InvBillDetails> getInvBillDetails(String invno)throws Exception;

	public String getInvoiceNo(String invtype)throws Exception;

	

	
	
}
