/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.AutoComplete;
import sb.elpro.model.RaiseDebit;
import sb.elpro.model.TanneryDetails;

/**
 * @author ADMIN_WIN7
 *
 */
public interface DebitDao { 
	  
	ArrayList<TanneryDetails> getDebExporter(String debexp) throws SQLException;
	
	ArrayList<AutoComplete> getDebTanInvno(String debTaninv) throws SQLException;

	ArrayList<RaiseDebit> getDebInvnolist(String invno) throws SQLException;

	
	
}
