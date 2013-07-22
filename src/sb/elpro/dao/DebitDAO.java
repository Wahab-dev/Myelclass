/**
 * 
 */
package sb.elpro.dao;

import java.util.ArrayList;

import sb.elpro.model.RaiseDebit;

/**
 * @author ADMIN_WIN7
 *
 */
public interface DebitDao { 
	  
	ArrayList<RaiseDebit> getDebExporter() throws Exception;

	ArrayList<RaiseDebit> getDebTanInvno() throws Exception;

	
}
