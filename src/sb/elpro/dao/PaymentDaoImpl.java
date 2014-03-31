/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.PaymentBean;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class PaymentDaoImpl implements PaymentDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PaymentDao#getPaymentPendingList(java.lang.String)
	 */
	@Override
	public ArrayList<DebitFormDetails> getPaymentPendingList(String expo)
			throws SQLException {
		ArrayList<DebitFormDetails> payloadpaylist = new ArrayList<DebitFormDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String sql = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			sql =  "SELECT debitno, debitdate, tanneryid, invno, ctno, taninvdetails, exchgrate, commission, price, quantity, amount, elclassamount, amountinrs, tax, totaltax, tds, totaldue from tbl_debitform where tanneryid = '"+expo+"' order by debitno";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {	
				DebitFormDetails debdetailbean = new DebitFormDetails();
				debdetailbean.setDeb_debitno(rs.getString("debitno"));
				debdetailbean.setDeb_debitdate(rs.getString("debitdate"));
				debdetailbean.setDeb_taninvno(rs.getString("taninvdetails"));
				debdetailbean.setDeb_exchangerate(rs.getString("exchgrate"));
				debdetailbean.setDeb_commission(rs.getString("commission"));
				debdetailbean.setDeb_rate(rs.getString("price"));
				debdetailbean.setDeb_qshipped(rs.getString("quantity"));
				debdetailbean.setDeb_invoiceamt(rs.getString("amount"));
				debdetailbean.setDeb_elclassamt(rs.getString("elclassamount"));
				debdetailbean.setDeb_elclassamtinrs(rs.getString("amountinrs"));
				debdetailbean.setDeb_tax(rs.getString("tax"));
				debdetailbean.setDeb_total(rs.getString("totaltax"));
				debdetailbean.setDeb_tds(rs.getString("tds"));
				debdetailbean.setDeb_due(rs.getString("totaldue"));
				System.out.println("setDeb_due"+debdetailbean.getDeb_due());
				payloadpaylist.add(debdetailbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return payloadpaylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PaymentDao#savePaymentFormDetails(sb.elpro.model.PaymentBean)
	 */
	@Override
	public boolean savePaymentFormDetails(PaymentBean paymntformbean)
			throws SQLException {
		System.out.println("In PRF SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isSaved =true;
		
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savedebitform = new StringBuffer("insert into tbl_paymentform (paymentno, paymentdate, exporter, cheqdetails, debno, debdate, quantity, invamt, elclassamt, total, tax, tds, due, creditedamt, balance, reciptdate, comments)");
			sql_savedebitform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_savedebitform = sql_savedebitform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savedebitform);
			System.out.println(" IN Payment Form SAVE ");
			pst.setString(1, paymntformbean.getPaymentno());
			pst.setString(2, paymntformbean.getPaymentdate());
			pst.setString(3, paymntformbean.getDeb_exporter());
			pst.setString(4, paymntformbean.getChequedetails());
			pst.setString(5, paymntformbean.getDeb_debitno());
			System.out.println("getDeb_debitno " +paymntformbean.getDeb_debitno());
			pst.setString(6, paymntformbean.getDeb_debitdate());
			System.out.println("getDeb_debitdate " +paymntformbean.getDeb_debitdate());
			pst.setString(7, paymntformbean.getDeb_totalquantity());
			pst.setString(8, paymntformbean.getDeb_invoiceamt());
			pst.setString(9, paymntformbean.getDeb_elclassamtinrs());
			pst.setString(10, paymntformbean.getDeb_total());
			pst.setString(11, paymntformbean.getDeb_tax());
			pst.setString(12, paymntformbean.getDeb_tds());
			pst.setString(13, paymntformbean.getDeb_due());
			pst.setString(14, paymntformbean.getCreditamt());
			pst.setString(15, paymntformbean.getBalanceamt());
			pst.setString(16, paymntformbean.getRecieptdate());
			pst.setString(17, paymntformbean.getOtherdetails());
			System.out.println("getOtherdetails " +paymntformbean.getOtherdetails());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
			
			
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
