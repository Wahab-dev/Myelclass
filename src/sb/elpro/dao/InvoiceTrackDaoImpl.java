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
import sb.elpro.model.Invpaymentdetails;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;


/**
 * @author Wahab
 *
 */
public class InvoiceTrackDaoImpl implements InvoiceTrackDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InvoiceTrackDao#getInvTrackList()
	 */
	@Override
	public ArrayList<InvBillDetails> getInvTrackList() throws SQLException {
		ArrayList<InvBillDetails> invtrackarray = new ArrayList<InvBillDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{				
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();// limit "+pag+", "+rows+" 
			String sql = "SELECT invtype, form.invno, form.invdate,  tanshform, taninvno,  cust.shortform, invbillid, ctno,  articleid, artname, color, size, subs, selc, unit, pcs, rate, tc, qty, qshpd, qbal, amt,  othercharges, discounts , totamt, AWBillNo, AWBillDate, comm, othercomm,  consignee,  notifyname, otherref, buyer,  bankname, deduction, bankcharge, amtrecvd, recieptdate, balance, exrate, amtininr, remarks FROM tbl_inv_bill bill left outer join tbl_invform form on form.invno = bill.invno left outer join elpro.tbl_tannery tan on  tan.tanid = form.expname left outer join elpro.tbl_customer cust on  cust.custid = form.customer left outer join elpro.tbl_consignee consig on  consig.consigid = form.consignee left outer join elpro.tbl_notify notify on  notify.notifyid = form.notify left outer join elpro.tbl_bank bank on  bank.bankid = form.bank left outer join elpro.tbl_invpayment pay on  pay.invno = form.invno order by form.invno, ctno, artname, color ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 // String currency = rs.getString("rate").substring(0,1).equalsIgnoreCase("$") ? "$" : rs.getString("rate").substring(0,1).equalsIgnoreCase("E")? "Euro" : "Rs";
			  InvBillDetails invtrackbean = new InvBillDetails();
				invtrackbean.setInvtype(rs.getString("invtype"));
				invtrackbean.setInvno(rs.getString("invno"));
				invtrackbean.setInvdt((rs.getString("invdate")));
				invtrackbean.setExporter(rs.getString("tanshform"));
				invtrackbean.setTaninvno(rs.getString("taninvno"));
				invtrackbean.setCustomer(rs.getString("shortform"));
				invtrackbean.setInvid(rs.getString("invbillid"));
				invtrackbean.setInvctno(rs.getString("ctno"));
				invtrackbean.setInvartid(rs.getString("articleid"));
				invtrackbean.setInvartname(rs.getString("artname"));
				invtrackbean.setInvcolor(rs.getString("color"));
				invtrackbean.setInvsize(rs.getString("size"));
				invtrackbean.setInvsubs(rs.getString("subs"));
				invtrackbean.setInvselc(rs.getString("selc"));
				invtrackbean.setInvunit(rs.getString("unit"));
				invtrackbean.setInvpcs(rs.getString("pcs"));
				invtrackbean.setInvrate(rs.getString("rate")); 
				invtrackbean.setInvtc(rs.getString("tc"));
				invtrackbean.setInvqty(rs.getString("qty")+" "+rs.getString("unit"));
				invtrackbean.setInvqshpd(rs.getString("qshpd"));
				invtrackbean.setInvqbal(rs.getString("qbal"));
				invtrackbean.setInvamt(rs.getString("amt"));
				invtrackbean.setInvothercrg(rs.getString("othercharges"));
				invtrackbean.setInvclaim(rs.getString("discounts"));
				invtrackbean.setInvtotamount(rs.getString("totamt"));
				invtrackbean.setAwbillno(rs.getString("AWBillNo"));
				invtrackbean.setAwbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
				invtrackbean.setInvcomm(rs.getString("comm"));
				invtrackbean.setInvothercomm(rs.getString("othercomm"));
				invtrackbean.setConsignee(rs.getString("consignee"));
				invtrackbean.setNotify(rs.getString("notifyname"));
				invtrackbean.setOtherref(rs.getString("otherref"));
				invtrackbean.setBuyer(rs.getString("buyer"));
				invtrackbean.setBank(rs.getString("bankname"));
				invtrackbean.setDeduction(rs.getString("deduction"));
				invtrackbean.setBankcharge(rs.getString("bankcharge"));
				invtrackbean.setAmtrecieved(rs.getString("amtrecvd"));
				invtrackbean.setRecieptdate(DateConversion.ConverttoNormalDate(rs.getString("recieptdate")));
				invtrackbean.setBalanceamt(rs.getString("balance"));
				invtrackbean.setExchngrate(rs.getString("exrate"));
				invtrackbean.setAmtininr(rs.getString("amtininr"));
				invtrackbean.setRemarks(rs.getString("remarks"));
				invtrackarray.add(invtrackbean);
			}	
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("ERROR RESULT");
		}finally{
		 con.close() ;
		 st.close();
		 rs.close();
		}	
			return invtrackarray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InvoiceTrackDao#addPayment(sb.elpro.model.Invpaymentdetails)
	 */
	@Override
	public boolean addPayment(Invpaymentdetails invpay) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isuadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addpayment = new StringBuffer("insert into elpro.tbl_invpayment (invno, totalamt, deduction, bankcharge, amtrecvd, recieptdate, balance, exrate, amtininr, remarks)");
			sql_addpayment.append("values (?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_addpayment = sql_addpayment.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addpayment);
			pst.setString(1, invpay.getInvno());
			System.out.println("getInvno " +invpay.getInvno());
			pst.setString(2, invpay.getInvtotamt());
			System.out.println("getInvtotamt " +invpay.getInvtotamt());
			pst.setString(3, invpay.getDeduction());
			System.out.println("getDeduction "+invpay.getDeduction());
			pst.setString(4, invpay.getBankcharge());
			pst.setString(5, invpay.getAmtrecieved());
			pst.setString(6, invpay.getRecieptdate());
			pst.setString(7, invpay.getBalanceamt());
			System.out.println("getBalanceamt "+invpay.getBalanceamt());
			pst.setString(8, invpay.getExchngrate());
			System.out.println("getExchngrate "+invpay.getExchngrate());
			pst.setString(9, invpay.getAmtininr());
			pst.setString(10, invpay.getRemarks());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isuadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isuadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InvoiceTrackDao#editPayment(sb.elpro.model.Invpaymentdetails)
	 */
	@Override
	public boolean editPayment(Invpaymentdetails invpay) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows = 0;
		boolean isedited = true;
		try{		
			con = DBConnection.getConnection();
			StringBuffer sql_editdebstatus = new StringBuffer("UPDATE elpro.tbl_invpayment SET deduction = ? , bankcharge = ? , amtrecvd = ? , recieptdate = ? , balance = ? , exrate = ? , amtininr = ? , remarks = ? WHERE invno = '"+invpay.getInvno()+"' ");
			String sqlquery_editdebstatus = sql_editdebstatus.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_editdebstatus);
			pst.setString(1, invpay.getDeduction());
			pst.setString(2, invpay.getBankcharge());
			pst.setString(3, invpay.getAmtrecieved());
			pst.setString(4, invpay.getRecieptdate());
			pst.setString(5, invpay.getBalanceamt());
			pst.setString(6, invpay.getExchngrate());
			pst.setString(7, invpay.getAmtininr());
			pst.setString(8, invpay.getRemarks());
			System.out.println("getRemarks " +invpay.getRemarks());
			noofrows = pst.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		isedited = false;
		System.out.println("ERROR RESULT");
		}finally{
		 con.close() ;
		 pst.close();
		}	
		return isedited;
	}

}
