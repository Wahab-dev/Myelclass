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

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.InvoiceForm;
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
	public List<InvoiceForm> getinvDetails(String invno) throws SQLException {
		ArrayList<InvoiceForm> invarraylist = new ArrayList<InvoiceForm>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT expname, invno, articlename, articleshortform, size, substance, selection, color, selectionpercent, quantity, pcs, rate, tc, othername FROM tbl_article";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				InvoiceForm invbean = new InvoiceForm();
				invbean.setInv_exporter(rs.getString("expname"));
				invbean.setInv_exporteraddress(rs.getString(""));
				invbean.setInv_invoiceno(rs.getString("invno"));
				invbean.setInv_otherref(rs.getString(""));
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
