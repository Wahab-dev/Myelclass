/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.ExporterDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.InvCustContractDetails;
import sb.elpro.model.InvoiceForm;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PrfArticle;

/**
 * @author Wahab
 *
 */
public interface InvoiceDao {

	ArrayList<ExporterDetails> getInvExporter(String expterm) throws SQLException;

	ArrayList<NotifyConsigneeDetails> getInvNotify()throws SQLException;

	ArrayList<BankDetails> getInvBank() throws SQLException;
	
	ArrayList<DestinationDetails> getInvloadctrylist(String loadctryterm)throws SQLException;

	ArrayList<DestinationDetails> getInvloadportlist(String loadportterm, String ctryvalterm)throws SQLException;

	ArrayList<DestinationDetails> getInvDestiCtrylist(String destictryterm)throws SQLException;
	
	ArrayList<DestinationDetails> getInvDestiPortlist(String destictryterm, String destictryvalterm)throws SQLException;

	

	ArrayList<CustomerDetails> getinvCustomerDetails()throws SQLException;

	ArrayList<InvCustContractDetails> getinvCustContracttDetails()throws SQLException;

	ArrayList<CustomerInvoice> getInvCustCtlist(String custid, String sortname, String sortord)throws SQLException;

	ArrayList<CustomerDetails> getInvCustlist(String custterm)throws SQLException;

	
	ArrayList<ArticleDetails> getInvDelContractDetails(String ctno)throws SQLException;

	int getInvAddbillDetails(InvBillDetails invbill)throws SQLException;

	ArrayList<InvBillDetails> getInvBillDetails(String invno)throws SQLException;

	String getInvoiceNoDetails(String invtype)throws SQLException;

	

		
}
