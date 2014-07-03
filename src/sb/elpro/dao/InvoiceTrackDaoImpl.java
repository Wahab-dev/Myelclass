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
import com.mysql.jdbc.Statement;

import sb.elpro.model.InvBillDetails;
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
			String sql = "SELECT invtype, form.invno, form.invdate,  tanshform, taninvno,  cust.shortform, invbillid, ctno,  articleid, artname, color, size, subs, selc, unit, pcs, rate, tc, qty, qshpd, qbal, amt,  othercharges, discounts , totamt, AWBillNo, AWBillDate, comm, othercomm,  consignee,  notifyname,  otherref, buyer,  bankname  FROM tbl_inv_bill bill left outer join tbl_invform form on form.invno = bill.invno left outer join elpro.tbl_tannery tan on  tan.tanid = form.expname  left outer join elpro.tbl_customer cust on  cust.custid = form.customer  left outer join elpro.tbl_consignee consig on  consig.consigid = form.consignee  left outer join elpro.tbl_notify notify on  notify.notifyid = form.notify  left outer join elpro.tbl_bank bank on  bank.bankid = form.bank  order by form.invno ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 // String currency = rs.getString("rate").substring(0,1).equalsIgnoreCase("$") ? "$" : rs.getString("rate").substring(0,1).equalsIgnoreCase("E")? "Euro" : "Rs";
			  InvBillDetails invtrackbean = new InvBillDetails();
				invtrackbean.setInvtype(rs.getString("invtype"));
				invtrackbean.setInvno(rs.getString("invno"));
				invtrackbean.setInvdt(DateConversion.ConverttoNormalDate(rs.getString("invdate")));
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

}
