/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import sb.elpro.model.AutoComplete;
import sb.elpro.model.TanneryDetails;
import sb.elpro.utility.DBConnection;

/**
 * @author ADMIN_WIN7
 *
 */
public class DebitDaoImpl implements DebitDao {

	@Override
	public ArrayList<TanneryDetails> getDebExporter(String debex) throws SQLException{
		ArrayList<TanneryDetails> debexporterarray = new ArrayList<TanneryDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT expname, expattn, expaddr, expphone, expfax, expref FROM elpro.tbl_exporter where expname like '%"+debex+"%' order by expname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 TanneryDetails debexporterbean = new TanneryDetails();
				debexporterbean.setLabel(rs.getString("expname"));
				debexporterbean.setTanneryAddress(rs.getString("expaddr"));
				debexporterbean.setTanneryContactNo(rs.getString("expphone"));
				debexporterbean.setTanneryFax(rs.getString("expfax"));
				debexporterbean.setTanneryAttention(rs.getString("expattn"));
			 System.out.println("Result Added Successfully");
			 System.out.println("Exporter"+debexporterbean.getTanneryName());
			 debexporterarray.add(debexporterbean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return debexporterarray;
	}

	@Override
	public ArrayList<AutoComplete> getDebTanInvno(String debinv) throws SQLException {
		ArrayList<AutoComplete> debTaninvarray = new ArrayList<AutoComplete>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT expref FROM elpro.tbl_exporter";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete debtaninvbean = new AutoComplete();
				debtaninvbean.setLabel(rs.getString("expref"));
				debtaninvbean.setValue(rs.getString("expref"));
				System.out.println("Result Added Successfully");
				//System.out.println("Exporter"+debtaninvbean.getDeb_taninvno());
				debTaninvarray.add(debtaninvbean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return debTaninvarray;
	}



}
