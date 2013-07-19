/**
 * 
 */
package sb.elpro.bo;

import sb.elpro.model.NewUserDetails;
import sb.elpro.model.UserDetails;

/**
 * @author Wahab
 *
 */
public interface LoginBo {

	UserDetails isValidUser(UserDetails user) throws Exception;

	NewUserDetails createNewUser(NewUserDetails userdetails)throws Exception;
	

}
