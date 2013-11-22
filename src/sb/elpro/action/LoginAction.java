/**
 * 
 */
package sb.elpro.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.LoginForm;
import sb.elpro.actionform.NewUserForm;
import sb.elpro.bo.LoginBo;
import sb.elpro.bo.LoginBoImpl;
import sb.elpro.model.NewUserDetails;
import sb.elpro.model.UserDetails;


/**
 * @author Wahab
 *
 */
public class LoginAction extends DispatchAction {

	LoginBo loginbo = new LoginBoImpl();
	UserDetails user = new UserDetails();
	NewUserDetails userdetails = new NewUserDetails();
	String forward = "gotoMenu";
	HttpSession usersession;
	public ActionForward Login(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession();
		LoginForm loginform = (LoginForm) form;
		BeanUtils.copyProperties(user, loginform);
		user = loginbo.isValidUser(user);
		usersession.setAttribute("user", user);
		if(user.getName().equals("WrongUser")){
			String myforward = "failure";
			return map.findForward(myforward);	
		}
		return map.findForward(forward);	
	}
	
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN CLEAR ");
		LoginForm loginform = (LoginForm) form;
		loginform.reset(map, request);
		return map.findForward("reset");
	}
	
	//Regidter New USer
	public ActionForward Registernewuser(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN NewUser ");
		NewUserForm newuserfrm = (NewUserForm) form;
		BeanUtils.copyProperties(userdetails, newuserfrm);
		userdetails = loginbo.createNewUser(userdetails);
		
		return map.findForward("newuser");
	}
	
	
	public ActionForward ClearRegForm(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In Clear Reg Form");
		NewUserForm newuserfrm = (NewUserForm) form;
		newuserfrm.reset(map, request);
		return map.findForward("reset");
	}
	
	
	//Forget Password
	public ActionForward Sendpassword(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		NewUserForm newuserfrm = (NewUserForm) form;
		BeanUtils.copyProperties(userdetails, newuserfrm);
		//Yet to Configure
		//userdetails = loginbo.updatePassword(userdetails);
		
		return map.findForward("newuser");
	}
	
	
	public ActionForward Clearpwdform(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In Clear Forget PWD Form");
		NewUserForm newuserfrm = (NewUserForm) form;
		newuserfrm.reset(map, request);
		return map.findForward("reset");
	}
	
	
	public ActionForward Logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("In LOGOUT");
		usersession = request.getSession(false);
		usersession.invalidate();			
		return map.findForward("login");  
	}
}
