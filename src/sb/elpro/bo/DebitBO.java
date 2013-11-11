/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.model.AutoComplete;
import sb.elpro.model.RaiseDebit;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 *
 */
public interface DebitBo {

	ArrayList<TanneryDetails> getDebExporter(String tanterm) throws Exception;

	List<AutoComplete> getDebInvno(String tanterm, String expname)throws Exception;

	List<RaiseDebit> getDebitInvDetails(String invno)throws Exception;

	boolean setDebitWaive(String invid)throws Exception;

}
