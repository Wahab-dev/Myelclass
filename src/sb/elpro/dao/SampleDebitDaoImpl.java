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
			st = (Statement) con.createStatement();// limit "+pag+", "+rows+" 
			String sql = "SELECT * FROM elpro.tbl_sampleinvform  form left join  elpro.tbl_sample_debform debit ON debit.invno=form.invno INNER JOIN elpro.tbl_sampleinv_bill bill on bill.invno = form.invno order by form.invno";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				 InvBillDetails samdebbean = new InvBillDetails();
				 /*String dt = rs.getString("debdate");
				 System.out.println("DT "+dt);
				 System.out.println("Trim "+dt.equalsIgnoreCase(null));
				 if(!(dt.trim().length()== 0)){
					 System.out.println("HI");
					 
				 }else{
					 dt = "2014-01-01";
				 }*/
					samdebbean.setInvtype(rs.getString("invtype"));
					samdebbean.setInvno(rs.getString("invno"));
					samdebbean.setInvdt(DateConversion.ConverttoNormalDate(rs.getString("invdate")));
					samdebbean.setExporter(rs.getString("expname"));
					samdebbean.setTaninvno(rs.getString("taninvno"));
					samdebbean.setCustomer(rs.getString("customer"));
					samdebbean.setInvid(rs.getString("invbillid"));
					samdebbean.setInvctno(rs.getString("sampleno"));
					samdebbean.setInvartid(rs.getString("articleid"));
					samdebbean.setInvartname(rs.getString("artname"));
					samdebbean.setInvcolor(rs.getString("color"));
					samdebbean.setInvsize(rs.getString("size"));
					samdebbean.setInvsubs(rs.getString("subs"));
					samdebbean.setInvselc(rs.getString("selc"));
					samdebbean.setInvunit(rs.getString("unit"));
					samdebbean.setInvpcs(rs.getString("pcs"));
					samdebbean.setInvrate(rs.getString("rate"));
					samdebbean.setInvqty(rs.getString("qty")+" "+rs.getString("unit"));
					samdebbean.setInvqshpd(rs.getString("qshpd"));
					samdebbean.setInvqbal(rs.getString("qbal"));
					samdebbean.setInvamt(rs.getString("amt"));
					samdebbean.setInvothercrg(rs.getString("othercharges"));
					samdebbean.setInvclaim(rs.getString("discounts"));
					samdebbean.setInvtotamount(rs.getString("totamt"));
					samdebbean.setAwbillno(rs.getString("AWBillNo"));
					samdebbean.setAwbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
					samdebbean.setConsignee(rs.getString("consignee"));
					samdebbean.setNotify(rs.getString("notify"));
					samdebbean.setOtherref(rs.getString("otherref"));
					samdebbean.setBuyer(rs.getString("buyer"));
					samdebbean.setBank(rs.getString("bank"));
					samdebbean.setDebid(rs.getString("debid"));
					samdebbean.setDebdt(rs.getString("debdate"));
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
