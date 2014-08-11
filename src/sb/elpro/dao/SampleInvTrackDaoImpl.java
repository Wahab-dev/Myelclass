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
public class SampleInvTrackDaoImpl implements SampleInvoiceTrackDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceTrackDao#getSamInvTrackList()
	 */
	@Override
	public ArrayList<InvBillDetails> getSamInvTrackList() throws SQLException {
		ArrayList<InvBillDetails> saminvtrackarray = new ArrayList<InvBillDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{	
			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();// limit "+pag+", "+rows+" 
			String sql = "SELECT invtype, form.invno, form.invdate, exportersref, expname, tan.tanshform,  taninvno, customer, cust.shortform, consignee, notify, notify.shortform, amount, otherref, buyer, bank, bank.shortform , AWBillNo, AWBillDate, othercharges, discounts, totamt, invbillid, articleid, artname, color, size, subs, selc, unit, qty, pcs, rate, sampleno, qshpd,qbal, amt, user  FROM  elpro.tbl_sampleinv_bill bill join elpro.tbl_sampleinvform form on form.invno = bill.invno  left outer join tbl_tannery tan on tan.tanid = form.expname left outer join tbl_customer cust on cust.custid = form.customer left outer join tbl_notify notify on notify.notifyid = form.notify left outer join tbl_bank bank on bank.bankid = form.bank order by form.invdate desc,  form.invno desc, artname asc, color asc, selc asc ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				//String currency = rs.getString("rate").substring(0,1).equalsIgnoreCase("$") ? "$" : rs.getString("rate").substring(0,1).equalsIgnoreCase("E")? "Euro" : "Rs";
				InvBillDetails invtrackbean = new InvBillDetails();
					invtrackbean.setInvtype(rs.getString("invtype"));
					invtrackbean.setInvno(rs.getString("invno"));
					invtrackbean.setInvdt((rs.getString("invdate")));
					invtrackbean.setExporter(rs.getString("tanshform"));
					invtrackbean.setTaninvno(rs.getString("taninvno"));
					invtrackbean.setCustomer(rs.getString("cust.shortform"));
					invtrackbean.setInvid(rs.getString("invbillid"));
					invtrackbean.setInvctno(rs.getString("sampleno"));
					invtrackbean.setInvartid(rs.getString("articleid"));
					invtrackbean.setInvartname(rs.getString("artname"));
					invtrackbean.setInvcolor(rs.getString("color"));
					invtrackbean.setInvsize(rs.getString("size"));
					invtrackbean.setInvsubs(rs.getString("subs"));
					invtrackbean.setInvselc(rs.getString("selc"));
					invtrackbean.setInvunit(rs.getString("unit"));
					invtrackbean.setInvpcs(rs.getString("pcs"));
					invtrackbean.setInvrate(rs.getString("rate"));
					invtrackbean.setInvqty(rs.getString("qty")+" "+rs.getString("unit"));
					invtrackbean.setInvqshpd(rs.getString("qshpd")+" sqft");
					invtrackbean.setInvqbal(rs.getString("qbal"));
					invtrackbean.setInvamt(rs.getString("amt"));
					invtrackbean.setInvothercrg(rs.getString("othercharges"));
					invtrackbean.setInvclaim(rs.getString("discounts"));
					invtrackbean.setInvtotamount(rs.getString("totamt"));
					invtrackbean.setAwbillno(rs.getString("AWBillNo"));
					invtrackbean.setUser(rs.getString("user"));
					invtrackbean.setAwbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
					invtrackbean.setConsignee(rs.getString("consignee"));
					invtrackbean.setNotify(rs.getString("notify.shortform"));
					invtrackbean.setOtherref(rs.getString("otherref"));
					invtrackbean.setBuyer(rs.getString("buyer"));
					invtrackbean.setBank(rs.getString("bank.shortform"));
					saminvtrackarray.add(invtrackbean);
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

}
