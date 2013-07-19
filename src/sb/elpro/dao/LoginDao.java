/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;

import sb.elpro.model.NewUserDetails;
import sb.elpro.model.UserDetails;

/**
 * @author Wahab
 *
 */
public interface LoginDao {
	
	//Check whether the user is Valid or Not
	public UserDetails isValidUser(UserDetails user) throws SQLException;
	
	//New USer Registration
	public NewUserDetails createNewUser(NewUserDetails userdetails) throws SQLException;
	
}
