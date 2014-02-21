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

	/**
	 * Method to Return the Exporter Name 
	 * @param
	 * @return 
	 * etc
	 */

	ArrayList<TanneryDetails> getDebExporter(String tanterm) throws Exception;

	/**
	 * Method to Return the Inv No based on the Exporter 
	 * @param
	 * @return 
	 * etc
	 */

	List<AutoComplete> getDebInvno(String tanterm, String expname)throws Exception;

	/**
	 * Method to Return the COmplerte Invoice Details of the Contract  
	 * @param
	 * @return 
	 * etc
	 */

	List<RaiseDebit> getDebitInvDetails(String invno)throws Exception;

	/**
	 * Method to Check the Debit note is Waived or Not	
	 * @param
	 * @return 
	 * etc
	 */

	boolean setDebitWaive(String invid)throws Exception;

}
