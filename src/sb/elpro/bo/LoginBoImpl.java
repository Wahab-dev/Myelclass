/**
 * 
 */
package sb.elpro.bo;


import sb.elpro.dao.LoginDao;
import sb.elpro.dao.LoginDaoImpl;
import sb.elpro.model.NewUserDetails;
import sb.elpro.model.UserDetails;

/**
 * @author Wahab
 *
 */
public class LoginBoImpl implements LoginBo {
	
	
	private LoginDao logindao;
	
	
	/**
	 * 
	 */
	public LoginBoImpl() {
		this.logindao = new LoginDaoImpl();
		
	}

	@Override
	public UserDetails isValidUser(UserDetails user) throws Exception {
			return logindao.isValidUser(user);
	}

	@Override
	public NewUserDetails createNewUser(NewUserDetails userdetails)
			throws Exception {
		return logindao.createNewUser(userdetails);
	}

}
