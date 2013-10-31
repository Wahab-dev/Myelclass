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
import sb.elpro.model.PrfArticle;
import sb.elpro.model.RaiseDebit;
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
				debexporterbean.setTanneryName(rs.getString("expname"));
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
			String sql = "SELECT invno, taninvno FROM elpro.tbl_invform";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete debtaninvbean = new AutoComplete();
				debtaninvbean.setLabel(rs.getString("invno"));
				debtaninvbean.setShform(rs.getString("taninvno"));
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

	@Override
	public ArrayList<RaiseDebit> getDebInvnolist(String invno)
			throws SQLException {
		ArrayList<RaiseDebit> debInvarray = new ArrayList<RaiseDebit>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT  artname, color, qty, rate, tc, comm, ctno, form.invdate, qshpd, qbal, amt, form.invno, taninvno, totalamount FROM tbl_invform form, tbl_inv_bill bill where form.invno = bill.invno";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				RaiseDebit Debbean = new RaiseDebit();
				Debbean.setDeb_invno(rs.getString("invno"));
				Debbean.setDeb_invdate(rs.getString("invdate"));
				Debbean.setDeb_contractno(rs.getString("ctno"));
				Debbean.setDeb_article(rs.getString("artname"));
				Debbean.setDeb_color(rs.getString("color"));
				Debbean.setDeb_totalquantity(rs.getString("qty"));
				Debbean.setDeb_rate(rs.getString("rate"));
				Debbean.setDeb_tc(rs.getString("tc"));
				Debbean.setDeb_commission1(rs.getString("comm"));
				Debbean.setDeb_qshipped(rs.getString("qshpd"));
				Debbean.setDeb_qremain(rs.getString("qbal"));
				Debbean.setDeb_invoiceamt(rs.getString("amt"));
				System.out.println("Artilce REtrieved Successfully");
				System.out.println("getDeb_invno  "+Debbean.getDeb_invno());
				debInvarray.add(Debbean);
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return debInvarray;
	}



}
