/**
 * 
 */
package sb.elpro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import sb.elpro.model.NewUserDetails;
import sb.elpro.model.UserDetails;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class LoginDaoImpl implements LoginDao{

	@Override
	public UserDetails isValidUser(UserDetails user) throws SQLException {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			//Query String
			String sql = "Select Name From elpro.login where UserName = ? and Password = ? and Role= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getRole());
			rs = pst.executeQuery();
			
			if(rs.next()){
				user.setName(rs.getString("Name"));		
			}else{
				user.setName("WrongUser");	// Need to Add Guest in the Future
			}
			System.out.println(" User Name "+user.getName());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
			pst.close();
			rs.close();
		}	
		return user;
	}

	@Override
	public NewUserDetails createNewUser(NewUserDetails userdetails)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{			
			con = DBConnection.getConnection();
			//Query String
			StringBuffer sql_savenewUser = new StringBuffer("insert into tbl_userdetails  (firstname, lastname, age, gender, dob, contactno, emailid)");
			sql_savenewUser.append("values (?,?,?,?,?,?,?)");
			String sqlquery_savenewUser = sql_savenewUser.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savenewUser);
			
			//pst.setString(1, userdetails.getu());
			pst.setString(1, userdetails.getfName());
			pst.setString(2, userdetails.getlName());
			pst.setString(3, userdetails.getAge());
			pst.setString(4, userdetails.getGender());
			pst.setString(5, userdetails.getdOB());
			pst.setString(6, userdetails.getContactNo());
			pst.setString(7, userdetails.getEmailId());
			rs = pst.executeUpdate();
			System.out.println(rs);
			
			System.out.println(" First Name "+userdetails.getfName());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
			pst.close();
		}	
		return userdetails;
	}
}
