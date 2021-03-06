/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.model.SampleRequest;
import sb.elpro.model.SrfArticle;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.EndUsageDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.TanneryDetails;


/**
 * @author Wahab
 *
 */
public interface  SrfBo {

	public String getSampleno()throws Exception;

	public ArrayList<HandledByDetails> getsrfhandledby(String handlbyterm) throws Exception;

	public List<AutoComplete> getsrfEndusage(String endusageterm) throws Exception;

	public ArrayList<TanneryDetails> getTanneryDetails(String term) throws Exception;

	public ArrayList<CustomerDetails> getCustomerDetails() throws Exception;

	public List<AutoComplete> getDestinationDetails(String term) throws Exception;

	public ArrayList<PaymentDetails> getPaymentDetails(String pymntterm) throws Exception;

	public List<SrfArticle> getSrfArticleDetails(String sidx, String sord, String sord2) throws Exception;

	public boolean addSrfArticleDetails(SrfArticle artindertdetail,
			
			String sidx, String sord) throws Exception;

	public boolean editSrfArticleDetails(SrfArticle artindertdetail,
			String sidx, String sord) throws Exception;

	public boolean delPrfArticleDetails(SrfArticle artindertdetail,
			String sidx, String sord)throws Exception;

	public List<SampleRequest> getEditSrfFormValues(String sampleno)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	public boolean saveSrfform(SampleRequest srfbean) throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	public boolean updtSrfform(SampleRequest srfbean) throws Exception;

	
}
