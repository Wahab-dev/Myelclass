/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import sb.elpro.model.AutoComplete;
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
			String sql = "SELECT tanname, tanaddr, tanattn, tanphone, tanfax FROM elpro.tbl_tannery where tanname like '%"+debex+"%' and tanname in ( Select distinct form.expname from elpro.tbl_invform form where form.expname not in ('International Corporation')) order by tanname;";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 TanneryDetails debexporterbean = new TanneryDetails();
				debexporterbean.setTanneryName(rs.getString("tanname"));
				debexporterbean.setTanneryAddress(rs.getString("tanaddr"));
				debexporterbean.setTanneryContactNo(rs.getString("tanphone"));
				debexporterbean.setTanneryFax(rs.getString("tanfax"));
				debexporterbean.setTanneryAttention(rs.getString("tanattn"));
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
	public ArrayList<AutoComplete> getDebTanInvno(String debinv, String expname) throws SQLException {
		ArrayList<AutoComplete> debTaninvarray = new ArrayList<AutoComplete>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT invno, taninvno FROM elpro.tbl_invform where expname = '"+expname+"' and invno like '%"+debinv+"%' and invno NOT IN(select invno from elpro.tbl_debitstatus)";
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
			
			String sql = "SELECT  artname, color, qty, rate, tc, comm, othercomm, ctno, form.invdate, qshpd, qbal, amt, form.invno, taninvno, totalamount FROM tbl_invform form, tbl_inv_bill bill where form.invno = bill.invno and form.invno = '"+invno+"' ";
			//String commsql = "select othercommssion, commission from tbl_prfform where where "
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
				Debbean.setDeb_elclasscommission(rs.getString("comm"));
				Debbean.setDeb_othercommission(rs.getString("othercomm"));
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

	@Override
	public boolean setDebInvnoWaived(String invid)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean iswaived = true;
		String status ="closed";
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_insertDebitstatus = new StringBuffer("insert into elpro.tbl_debitstatus (debitnoteno, invno, status)");
			sql_insertDebitstatus.append("values (?,?,?)");
			String sqlquery_insertDebitstatus = sql_insertDebitstatus.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_insertDebitstatus);
			pst.setString(1, "EL001");
			pst.setString(2, invid);
			System.out.println("invid " +invid);
			pst.setString(3, status);
			System.out.println("status " +status);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			iswaived = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return iswaived;
	}



}
