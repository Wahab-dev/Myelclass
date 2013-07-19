/**
 * 
 */
package sb.elpro.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author Wahab
 *
 */
public class LoginForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1016103390752747819L;
	private String name;
	private String username;
	private String password;
	private String role;
	private String dob;
	private String emailid;
	private String repassword;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	//Validation
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors loginerrors = new ActionErrors();
		
		if(username.equalsIgnoreCase("null") || username.trim().equals("")){
			loginerrors.add("username",new ActionMessage("error.username.required"));
		}else if(password.equalsIgnoreCase("null") || password.trim().equals("")){
			loginerrors.add("password", new ActionMessage("error.password.required"));
		}else if(role.equalsIgnoreCase("0") || role.trim().equals("")){
			loginerrors.add("role", new ActionMessage("error.role.required"));
		}								
		return loginerrors;
	}
		
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		super.reset(mapping, request);
		username = "";
		password = "";
		role ="";
		}	
	
	
	//Register User
	
	private String fName;
	private String lName;
	private String age;
	private String gender;
	private String dOB;
	private String emailId;
	private String contactNo;
	private String userType;
	private String userName;
	private String passWord;
	private String regID;

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dOB
	 */
	public String getdOB() {
		return dOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * @return the regID
	 */
	public String getRegID() {
		return regID;
	}
	/**
	 * @param regID the regID to set
	 */
	public void setRegID(String regID) {
		this.regID = regID;
	}
	/**
	 * @return the repassword
	 */
	public String getRepassword() {
		return repassword;
	}
	/**
	 * @param repassword the repassword to set
	 */
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	
	
}
