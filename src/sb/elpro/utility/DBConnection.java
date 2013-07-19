/**
 * 
 */
package sb.elpro.utility;


import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * @author Wahab
 *
 */
public class DBConnection {

	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
	}
}
