/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.action.SrfArticle;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.DestinationDetailstemp;
import sb.elpro.model.EndUsageDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.TanneryDetails;


/**
 * @author Wahab
 *
 */
public interface  SrfBo {

	public int getSampleno()throws Exception;

	public ArrayList<HandledByDetails> getsrfhandledby() throws Exception;

	public ArrayList<EndUsageDetails> getsrfEndusage() throws Exception;

	public ArrayList<TanneryDetails> getTanneryDetails(String term) throws Exception;

	public ArrayList<CustomerDetails> getCustomerDetails() throws Exception;

	public List<AutoComplete> getDestinationDetails(String term) throws Exception;

	public ArrayList<PaymentDetails> getPaymentDetails() throws Exception;

	public List<SrfArticle> getSrfArticleDetails(String sno) throws Exception;

	//public ArrayList<HandledByDetails> getsrfEndusage()throws Exception;
	
}
