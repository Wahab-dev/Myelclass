/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
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
public interface SrfDao {

	int getSampleno() throws SQLException;

	ArrayList<HandledByDetails> getsrfhandledby(String term) throws SQLException;

	ArrayList<EndUsageDetails> getsrfendusage(String term)throws SQLException;

	ArrayList<TanneryDetails> getTannery(String term) throws SQLException;

	ArrayList<CustomerDetails> getCustomer()throws SQLException;

	List<AutoComplete> getDestination(String term)throws SQLException;

	ArrayList<PaymentDetails> getPayment(String term)throws SQLException;

	ArrayList<SrfArticle> getSrfArticleDetails(String sampleno, String sidx, String sord)throws SQLException;

	boolean addsrfArticle(SrfArticle artindertdetail, String sidx, String sord)throws SQLException;

	boolean editsrfArticle(SrfArticle artindertdetail, String sidx, String sord)throws SQLException;

	boolean delsrfArticle(SrfArticle artindertdetail, String sidx, String sord)throws SQLException;

	List<SampleRequest> getEditSrfFormDetails(String sampleno)throws SQLException;

}
