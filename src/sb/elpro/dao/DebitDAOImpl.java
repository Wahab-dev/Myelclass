/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import sb.elpro.model.RaiseDebit;
import sb.elpro.utility.DBConnection;

/**
 * @author ADMIN_WIN7
 *
 */
public class DebitDAOImpl implements DebitDAO {

	@Override
	public ArrayList<RaiseDebit> getDebExporter() throws Exception {
		ArrayList<RaiseDebit> debexporterarray = new ArrayList<RaiseDebit>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT expname, expattn, expaddr, expphone, expfax, expref FROM elpro.tbl_exporter order by expname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 RaiseDebit debexporterbean = new RaiseDebit();
				debexporterbean.setTannery(rs.getString("expname"));
				debexporterbean.setTanaddr(rs.getString("expaddr"));
				debexporterbean.setTantelephone(rs.getString("expphone"));
				debexporterbean.setTanfax(rs.getString("expfax"));
				debexporterbean.setTanattn(rs.getString("expattn"));
			 System.out.println("Result Added Successfully");
			 System.out.println("Exporter"+debexporterbean.getTannery());
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
	public ArrayList<RaiseDebit> getDebTanInvno() throws Exception {
		ArrayList<RaiseDebit> debTaninvarray = new ArrayList<RaiseDebit>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT expref FROM elpro.tbl_exporter";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				RaiseDebit debtaninvbean = new RaiseDebit();
				debtaninvbean.setTaninvno(rs.getString("expref"));
				
				System.out.println("Result Added Successfully");
				System.out.println("Exporter"+debtaninvbean.getTaninvno());
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
