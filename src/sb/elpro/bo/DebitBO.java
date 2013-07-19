/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;

import sb.elpro.model.RaiseDebit;

/**
 * @author Wahab
 *
 */
public interface DebitBO {

	ArrayList<RaiseDebit> getDebExporter() throws Exception;

	ArrayList<RaiseDebit> getDebTanInvno() throws Exception;

}
