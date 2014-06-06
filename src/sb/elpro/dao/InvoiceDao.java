/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;
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
import sb.elpro.model.TermsDetails;

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

	ArrayList<CustomerInvoice> getInvCustCtlist(String custid, String sortname, String type, String sortord)throws SQLException;
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
//	ArrayList<CustomerInvoice> getinvCustSampleDetails(String custname, String sidx, String sord)throws SQLException;

	ArrayList<CustomerDetails> getInvCustlist(String custterm)throws SQLException;

	
	ArrayList<ArticleDetails> getInvSelContractDetails(String ctno, String type)throws SQLException;

	boolean getInvAddbillDetails(InvBillDetails invbill)throws SQLException;

	ArrayList<InvBillDetails> getInvBillDetails(String invno, String ctno, String type)throws SQLException;

	String getInvoiceNoDetails(String invtype)throws SQLException;

	boolean getInvAddbillSecondDetails(InvBillDetails invaddagainbill)throws SQLException;

	boolean getInvEditbillDetails(InvBillDetails inveditbill)throws SQLException;

	boolean getInvDelbillDetails(InvBillDetails invaddagainbill)throws SQLException;

	
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	ArrayList<InvBillDetails> getInvBillTotAmtDetails(String invno)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	String getSampleInvoiceNoDetails(String saminvtype)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean saveInvoiceForm(InvoiceBean invbean)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InvoiceBean> getEditInvFormDetails(String invno)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updtInvFormDetails(InvoiceBean invbean)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<TermsDetails> getInvTermlist(String term)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<PaymentDetails> getInvPayTermlist(String term)throws SQLException;

	

	

		
}
