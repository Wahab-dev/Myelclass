/**
* This class draws.
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
 
import sb.elpro.model.InvoiceBean;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class TcDebitDaoImpl implements TcDebitDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.TcDebitDao#getinvDetails(java.lang.String)
	 */
	@Override
	public List<InvoiceBean> getinvDetails(String invno) throws SQLException {
		ArrayList<InvoiceBean> invarraylist = new ArrayList<InvoiceBean>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT expname, invno, taninvno FROM elpro.tbl_invform where invno = '"+invno+"'";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InvoiceBean invbean = new InvoiceBean();
				invbean.setInv_exporter(rs.getString("expname"));
				invbean.setInv_invoiceno(rs.getString("invno"));
				invbean.setInv_otherref(rs.getString("taninvno"));
				System.out.println("setInv_invoiceno "+invbean.getInv_exporter());
				invarraylist.add(invbean);
				}
			System.out.println("Article Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Article ERROR RESULT");
			}finally{
				 con.close() ;	
				 st.close();
				 rs.close();
		   }	
		return invarraylist;
	}

	
}
