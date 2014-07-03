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

import sb.elpro.model.InvBillDetails;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class SampleDebitDaoImpl implements SampleDebitDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleDebitDao#getSampleDebList()
	 */
	@Override
	public ArrayList<InvBillDetails> getSampleDebList() throws SQLException {
		ArrayList<InvBillDetails> saminvtrackarray = new ArrayList<InvBillDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{	
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct form.invno, form.invtype, form.invdate, tan.tanshform, taninvno,  cust.shortform as Cust, notify.shortform as Notify, bank.shortform, AWBillNo, AWBillDate, othercharges, discounts, totamt, debid, invamt, bankcharg, realizedamt, exrate, amtinrs, debdate, remarks FROM elpro.tbl_sampleinvform form left join  elpro.tbl_sample_debform debit ON debit.invno=form.invno left outer join tbl_tannery tan on tan.tanid = form.expname left outer join tbl_customer cust on cust.custid = form.customer left outer join tbl_notify notify on notify.notifyid = form.notify left outer join tbl_bank bank on bank.bankid = form.bank  order by form.invdate desc, form.invno desc";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				 InvBillDetails samdebbean = new InvBillDetails();
					samdebbean.setInvtype(rs.getString("invtype"));
					samdebbean.setInvno(rs.getString("invno"));
					samdebbean.setInvdt(DateConversion.ConverttoNormalDate(rs.getString("invdate")));
					samdebbean.setExporter(rs.getString("tan.tanshform"));
					samdebbean.setTaninvno(rs.getString("taninvno"));
					samdebbean.setCustomer(rs.getString("Cust"));
					samdebbean.setInvothercrg(rs.getString("othercharges"));
					samdebbean.setInvclaim(rs.getString("discounts"));
					samdebbean.setInvtotamount(rs.getString("totamt"));
					samdebbean.setAwbillno(rs.getString("AWBillNo"));
					samdebbean.setAwbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
					samdebbean.setNotify(rs.getString("Notify"));
					samdebbean.setBank(rs.getString("bank.shortform"));
					samdebbean.setDebid(rs.getString("debid"));
					samdebbean.setDebdt(DateConversion.ConverttoNormalDate(rs.getString("debdate")));
					samdebbean.setBankcharge(rs.getString("bankcharg"));
					samdebbean.setRealizedamt(rs.getString("realizedamt"));
					samdebbean.setExchngrate(rs.getString("exrate"));
					samdebbean.setAmtininr(rs.getString("amtinrs"));
					samdebbean.setRemarks(rs.getString("remarks"));
					saminvtrackarray.add(samdebbean);
				}		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
		}	
			return saminvtrackarray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleDebitDao#updatSamDebStatus(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean updatSamDebStatus(InvBillDetails sampledeb)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updateSamdebStatus = new StringBuffer("insert into elpro.tbl_sample_debform (invtype, invno, invamt, bankcharg, realizedamt, exrate, amtinrs, debdate, remarks)");
			sql_updateSamdebStatus.append("values (?,?,?,?,?,?,?,?,?)");
			String sqlquery_updateSamdebStatus = sql_updateSamdebStatus.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updateSamdebStatus);
			pst.setString(1, sampledeb.getInvtype());
			System.out.println("getInvtype " +sampledeb.getInvtype());
			pst.setString(2, sampledeb.getInvno());
			System.out.println("getInvno " +sampledeb.getInvno());
			pst.setString(3, sampledeb.getInvamt());
			System.out.println("getAmtininr "+sampledeb.getInvamt());
			pst.setString(4, sampledeb.getBankcharge());
			pst.setString(5, sampledeb.getRealizedamt());
			pst.setString(6, sampledeb.getExchngrate());
			pst.setString(7, sampledeb.getAmtininr());
			System.out.println("getAmtininr "+sampledeb.getAmtininr());
			pst.setString(8, sampledeb.getDebdt());
			System.out.println("getDebdt "+sampledeb.getDebdt());
			pst.setString(9, sampledeb.getRemarks());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isupdate = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isupdate;
	}

}
