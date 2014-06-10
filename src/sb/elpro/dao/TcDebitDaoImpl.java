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
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
 
import sb.elpro.model.DebitFormDetails;
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.TcDebitDao#saveTCDebitFormDetails(sb.elpro.model.DebitFormDetails)
	 */
	@Override
	public boolean saveTCDebitFormDetails(DebitFormDetails tcformbean)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pststatus = null;
		boolean isSaved =true;
		int noofrows  = 0;
		int noofrowsstatus  = 0;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savetcdebitform = new StringBuffer("insert into tbl_debitform (debitno, debitdate, tanneryid, invno, ctno, taninvdetails, exchgrate, commission, price, quantity, amount, elclassamount, amountinrs, totaltax, totaldue )");
			sql_savetcdebitform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_savetcdebitform = sql_savetcdebitform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savetcdebitform);
			System.out.println(" IN TC Debit Form SAVE ");
			pst.setString(1, tcformbean.getTcdeb_tcdebitno());
			System.out.println("getTcdeb_tcdebitno " +tcformbean.getTcdeb_tcdebitno());
			pst.setString(2, tcformbean.getTcdeb_tcdebitdate());
			System.out.println("getTcdeb_tcdebitdate " +tcformbean.getTcdeb_tcdebitdate());
			pst.setString(3, tcformbean.getTcdeb_exporterid());
			pst.setString(4, tcformbean.getTcdeb_elclassrefno());
			pst.setString(5, tcformbean.getTcdeb_ctno());
			pst.setString(6, tcformbean.getTcdeb_taninvno());
			pst.setString(7, tcformbean.getTcdeb_exchangerate());
			System.out.println("getTcdeb_exchangerate " +tcformbean.getTcdeb_exchangerate());
			pst.setString(8, tcformbean.getTcdeb_commission());
			pst.setString(9, tcformbean.getTcdeb_rate());
			pst.setString(10, tcformbean.getTcdeb_totalquantity());
			pst.setString(11, tcformbean.getTcdeb_invoiceamt());
			pst.setString(12, tcformbean.getTcdeb_elclassamt());
			pst.setString(13, tcformbean.getTcdeb_elclassamt());
			pst.setString(14, tcformbean.getTcdeb_elclassamt());
			pst.setString(15, tcformbean.getTcdeb_elclassamt());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
			if(noofrows == 1){
				/*
				 * Update Debit status Table 
				 */
				System.out.println(" Insert Data in debit Status  ");
				StringBuffer sql_savedebitformstatus = new StringBuffer("insert into tbl_debitstatus (debitnoteno, invno, status)");
				sql_savedebitformstatus.append("values (?,?,?)");
				String sqlquery_savedebitformstatus= sql_savedebitformstatus.toString();
				pststatus = (PreparedStatement) con.prepareStatement(sqlquery_savedebitformstatus);
				System.out.println(" IN Debit Form Status ");
				pststatus.setString(1, tcformbean.getTcdeb_tcdebitno());
				System.out.println("getTcdeb_tcdebitno " +tcformbean.getTcdeb_tcdebitno());
				pststatus.setString(2, tcformbean.getTcdeb_elclassrefno());
				System.out.println("getTcdeb_elclassrefno " +tcformbean.getTcdeb_elclassrefno());
				pststatus.setString(3, "NA");
				noofrowsstatus = pststatus.executeUpdate();
				System.out.println("Sucessfully inserted the record.." + noofrowsstatus);
			}
		}catch(Exception e){
			e.printStackTrace();
			isSaved = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
			return isSaved;
	}

	
}
