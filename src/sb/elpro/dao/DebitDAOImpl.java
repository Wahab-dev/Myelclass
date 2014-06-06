/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import sb.elpro.model.AutoComplete;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

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
			String sql = "Select distinct form.expname, tanid, tanname, tanaddr, tanattn, tanphone, tanfax  from elpro.tbl_invform form left outer join elpro.tbl_tannery tan on tan.tanid = form.expname  where  tanname like '%"+debex+"%' and tanname not in ('International Corporation') order by expname asc";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 TanneryDetails debexporterbean = new TanneryDetails();
			 	debexporterbean.setTanneryId(rs.getString("tanid"));
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
			String sql = "SELECT invno, taninvno, tanname FROM elpro.tbl_invform form left outer join elpro.tbl_tannery tan on tan.tanid = form.expname where tanname like '"+expname+"' and invno like '%"+debinv+"%' and invno NOT IN(select invno from elpro.tbl_debitstatus)";
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
	public ArrayList<InvBillDetails> getDebInvnolist(String invno)throws SQLException {
		ArrayList<InvBillDetails> debInvarray = new ArrayList<InvBillDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT  artname, color, size, subs, selc, qty, rate, tc, comm, othercomm, ctno, form.invdate, qshpd, qbal, amt, form.invno, taninvno, othercharges, discounts, totamt FROM tbl_invform form, tbl_inv_bill bill where form.invno = bill.invno and form.invno = '"+invno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
			InvBillDetails invdetload= new InvBillDetails();
				invdetload.setInvno(rs.getString("invno"));
				invdetload.setInvdt(DateConversion.ConverttoNormalDate(rs.getString("invdate")));
				invdetload.setInvctno(rs.getString("ctno"));
				invdetload.setInvartname(rs.getString("artname"));
				invdetload.setInvcolor(rs.getString("color"));
				invdetload.setInvsize(rs.getString("size"));
				invdetload.setInvsubs(rs.getString("subs"));
				invdetload.setInvselc(rs.getString("selc"));
				invdetload.setInvqty(rs.getString("qty"));
				invdetload.setInvrate(rs.getString("rate"));
				invdetload.setInvtc(rs.getString("tc"));
				invdetload.setInvcomm(rs.getString("comm"));
				invdetload.setInvothercomm(rs.getString("othercomm"));
				invdetload.setInvqshpd(rs.getString("qshpd"));
				invdetload.setInvqbal(rs.getString("qbal"));
				invdetload.setInvamt(rs.getString("amt"));
				invdetload.setInvtotamount(rs.getString("totamt"));
				invdetload.setInvclaim(rs.getString("discounts"));
				invdetload.setInvothercrg(rs.getString("othercharges"));
				System.out.println("Article Retrieved Successfully");
				System.out.println("invno  "+invdetload.getInvno());
				debInvarray.add(invdetload);
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
			pst.setString(1, "WL001");
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.DebitDao#saveDebitFormDetails(sb.elpro.model.DebitFormDetails)
	 */
	@Override
	public boolean saveDebitFormDetails(DebitFormDetails debformbean)
			throws SQLException {
		System.out.println("In PRF SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pststatus = null;
		PreparedStatement pstupdt = null;
		int noofrows  = 0;
		int noofrowsstatus  = 0;
		int noofrowsupdt  = 0;
		boolean isSaved =true;
		
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savedebitform = new StringBuffer("insert into tbl_debitform (debitno, debitdate, tanneryid, invno, ctno, taninvdetails, exchgrate, commission, price, quantity, amount, elclassamount, amountinrs, tax, totaltax, tds, totaldue)");
			sql_savedebitform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_savedebitform = sql_savedebitform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savedebitform);
			System.out.println(" IN Debit Form SAVE ");
			pst.setString(1, debformbean.getDeb_debitno());
			System.out.println("getDeb_debitno " +debformbean.getDeb_debitno());
			pst.setString(2, debformbean.getDeb_debitdate());
			System.out.println("getDeb_debitdate " +debformbean.getDeb_debitdate());
			pst.setString(3, debformbean.getDeb_exporterid());
			pst.setString(4, debformbean.getDeb_elclassrefno());
			pst.setString(5, debformbean.getDeb_contractno());
			pst.setString(6, debformbean.getDeb_taninvno());
			pst.setString(7, debformbean.getDeb_exchangerate());
			pst.setString(8, debformbean.getDeb_commission());
			pst.setString(9, debformbean.getDeb_rate());
			pst.setString(10, debformbean.getDeb_totalquantity());
			pst.setString(11, debformbean.getDeb_invoiceamt());
			pst.setString(12, debformbean.getDeb_elclassamt());
			pst.setString(13, debformbean.getDeb_elclassamtinrs());
			pst.setString(14, debformbean.getDeb_tax());
			pst.setString(15, debformbean.getDeb_total());
			pst.setString(16, debformbean.getDeb_tds());
			pst.setString(17, debformbean.getDeb_due());
			System.out.println("getDeb_due " +debformbean.getDeb_due());
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
				pststatus.setString(1, debformbean.getDeb_debitno());
				System.out.println("getDeb_debitno " +debformbean.getDeb_debitno());
				pststatus.setString(2, debformbean.getDeb_elclassrefno());
				System.out.println("getDeb_invno " +debformbean.getDeb_elclassrefno());
				pststatus.setString(3, "NA");
				noofrowsstatus = pststatus.executeUpdate();
				System.out.println("Sucessfully inserted the record.." + noofrowsstatus);
			}
			if(noofrowsstatus == 1){
				/*
				 * Update Debitno Table 
				 */
				System.out.println(" Insert Data in debitno table ");
				StringBuffer sql_updtdebitno = new StringBuffer("update tbl_debitno set debitno = ? where agent =?");
				String sqlquery_updtdebitno = sql_updtdebitno.toString();
				pstupdt = (PreparedStatement) con.prepareStatement(sqlquery_updtdebitno);
				System.out.println(" IN Debit Form Status ");
				pstupdt.setString(1, debformbean.getDeb_debitno());
				pstupdt.setString(2, "elclass");
				System.out.println("getDeb_debitno " +debformbean.getDeb_debitno());
				noofrowsupdt = pstupdt.executeUpdate();
				System.out.println("Sucessfully Updtsd the record.." + noofrowsupdt);
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.DebitDao#getDebitTracklist(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<DebitFormDetails> getDebitTracklist(String sidx,
			String sord) throws SQLException {
		ArrayList<DebitFormDetails> debtrackarray = new ArrayList<DebitFormDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT debitno, debitdate, tanneryid, tan.tanshform as Tannery, invno, ctno, taninvdetails, exchgrate, commission, price, quantity, amount,  elclassamount, amountinrs, tax, totaltax, tds, totaldue  FROM tbl_debitform form left outer join elpro.tbl_tannery tan on tan.tanid = form.tanneryid order by debitno desc";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
		     DebitFormDetails debtrackbean = new DebitFormDetails();
				debtrackbean.setDeb_debitno(rs.getString("debitno"));
				debtrackbean.setDeb_debitdate(DateConversion.ConverttoNormalDate(rs.getString("debitdate")));
				debtrackbean.setDeb_exporter(rs.getString("Tannery"));
				debtrackbean.setDeb_elclassrefno(rs.getString("invno"));
				debtrackbean.setDeb_contractno(rs.getString("ctno"));
				debtrackbean.setDeb_taninvno(rs.getString("taninvdetails"));
				debtrackbean.setDeb_exchangerate(rs.getString("exchgrate"));
				debtrackbean.setDeb_commission(rs.getString("commission"));
				debtrackbean.setDeb_rate(rs.getString("price"));
				debtrackbean.setDeb_qshipped(rs.getString("quantity"));
				debtrackbean.setDeb_invoiceamt(rs.getString("amount"));
				debtrackbean.setDeb_elclassamt(rs.getString("elclassamount"));
				debtrackbean.setDeb_elclassamtinrs(rs.getString("amountinrs"));
				debtrackbean.setDeb_tax(rs.getString("tax"));
				debtrackbean.setDeb_total(rs.getString("totaltax"));
				debtrackbean.setDeb_tds(rs.getString("tds"));
				debtrackbean.setDeb_due(rs.getString("totaldue"));			
			 System.out.println("debitno"+debtrackbean.getDeb_debitno());
			 debtrackarray.add(debtrackbean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return debtrackarray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.DebitDao#getDebitnoteno()
	 */
	@Override
	public String getDebitnoteno() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String debitvalueNew = "";
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT debitno FROM elpro.tbl_debitno where agent = 'elclass'";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				String debitno = rs.getString("debitno").trim();
				int iprefix = debitno.indexOf('/');
				System.out.println("iprefix"+iprefix);
				String ident = debitno.substring(0, 2); 
				System.out.println("ident"+ident);
				int debno =Integer.parseInt(debitno.substring(2, iprefix));
				System.out.println("debno"+debno);
				debno  += 1; 
				System.out.println("debno ++ "+debno);
				String debitvalue = Integer.toString(debno);
				System.out.println("debitvalue" +debitvalue);
		    	if(debitvalue.length() == 1)
		    	{
		    		debitvalueNew = ident+"00"+Integer.toString(debno)+"/14-15";
		    	}
		    	else if(debitvalue.length() == 2)
		    	{
		    		debitvalueNew = ident+"0"+Integer.toString(debno)+"/14-15";
		    	}
		    	else if(debitvalue.length() == 3)
		    	{
		    		debitvalueNew = ident+Integer.toString(debno)+"/14-15";
		    	}
		    	else
		    	{
		    		debitvalueNew = ident+Integer.toString(debno)+"/14-15";
		    	}
			
				System.out.println("debitvalueNew No "+debitvalueNew);	
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return debitvalueNew;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.DebitDao#getEditDebFormDetails(java.lang.String)
	 */
	@Override
	public List<DebitFormDetails> getEditDebFormDetails(String deb_debitno)
			throws SQLException {
		List<DebitFormDetails> editinvformlist = new ArrayList<DebitFormDetails>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT debitno, debitdate, tanneryid, tanname, tanaddr, tanphone, invno, ctno, taninvdetails, exchgrate, commission, price, quantity, amount, elclassamount, amountinrs, tax, totaltax, tds, totaldue FROM elpro.tbl_debitform form join elpro.tbl_tannery tan on tan.tanid=form.tanneryid where debitno = '"+deb_debitno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {	
				DebitFormDetails editdebformbean = new DebitFormDetails();
				editdebformbean.setDeb_debitno(rs.getString("debitno"));
				editdebformbean.setDeb_debitdate(DateConversion.ConverttoNormalDate(rs.getString("debitdate")));
				System.out.println("DT "+editdebformbean.getDeb_debitdate());
				editdebformbean.setDeb_exporterid(rs.getString("tanneryid"));
				editdebformbean.setDeb_exporter(rs.getString("tanname"));
				editdebformbean.setDeb_tanaddr(rs.getString("tanaddr"));
				editdebformbean.setDeb_tantelephone(rs.getString("tanphone"));
				editdebformbean.setDeb_elclassrefno(rs.getString("invno"));
				editdebformbean.setDeb_contractno(rs.getString("ctno"));
				editdebformbean.setDeb_taninvno(rs.getString("taninvdetails"));
				editdebformbean.setDeb_exchangerate(rs.getString("exchgrate"));
				editdebformbean.setDeb_commission(rs.getString("commission"));
				//editdebformbean.setInv_destination(rs.getString("amount"));
				//editdebformbean.setInv_endusage(rs.getString("otherref"));
				//editdebformbean.setInv_paymentterms(rs.getString("buyer"));
				//editdebformbean.setInv_awbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
				editdebformbean.setDeb_rate(rs.getString("price"));
				editdebformbean.setDeb_qshipped(rs.getString("quantity"));
				editdebformbean.setDeb_invoiceamt(rs.getString("amount"));
				editdebformbean.setDeb_elclassamt(rs.getString("elclassamount"));
				editdebformbean.setDeb_elclassamtinrs(rs.getString("amountinrs"));
				editdebformbean.setDeb_tax(rs.getString("tax"));
				editdebformbean.setDeb_total(rs.getString("totaltax"));
				editdebformbean.setDeb_tds(rs.getString("tds"));
				editdebformbean.setDeb_due(rs.getString("totaldue"));
				editinvformlist.add(editdebformbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return editinvformlist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.DebitDao#updtDebFormDetails(sb.elpro.model.DebitFormDetails)
	 */
	@Override
	public boolean updtDebFormDetails(DebitFormDetails debformbean)
			throws SQLException {
		System.out.println("In Deb EDIT SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isUpdtd =true;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_updtsaminvform = new StringBuffer("update tbl_debitform set debitdate = ? ,  tanneryid= ? , invno= ? , taninvdetails= ? , exchgrate= ? , commission= ? , price= ? , quantity= ? , amount= ? , elclassamount= ? , amountinrs= ? , tax= ? , totaltax= ? , tds= ? , totaldue= ? where debitno ='"+debformbean.getDeb_debitno()+"' ");
			String sqlquery_updtsaminvform = sql_updtsaminvform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtsaminvform);
			pst.setString(1, debformbean.getDeb_debitdate());
			System.out.println("getDeb_invoicetype " +debformbean.getDeb_debitdate());
			pst.setString(2, debformbean.getDeb_exporterid());
			pst.setString(3, debformbean.getDeb_elclassrefno());
			pst.setString(4, debformbean.getDeb_taninvno());
			pst.setString(5, debformbean.getDeb_exchangerate());
			pst.setString(6, debformbean.getDeb_commission());
			pst.setString(7, debformbean.getDeb_rate());
			pst.setString(8, debformbean.getDeb_totalquantity());
			pst.setString(9, debformbean.getDeb_invoiceamt());
			pst.setString(10,debformbean.getDeb_elclassamt());
			pst.setString(11,debformbean.getDeb_elclassamtinrs());
			pst.setString(12, debformbean.getDeb_tax());
			pst.setString(13, debformbean.getDeb_total());
			pst.setString(14, debformbean.getDeb_tds());
			pst.setString(15, debformbean.getDeb_due());
			System.out.println("getDeb_due " +debformbean.getDeb_due());
			noofrows = pst.executeUpdate();
			
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isUpdtd = false;
			System.out.println("ERROR RESULT");
		}finally{
			con.close() ;
			pst.close();
		}	
		return isUpdtd;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.DebitDao#getPaynoteno()
	 */
	@Override
	public String getPaynoteno() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String debit = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT max(paymentno) as paymentno FROM elpro.tbl_paymentno";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				String debitno = rs.getString("paymentno").trim();
				int iprefix = debitno.indexOf('/');
				String debitnoi = debitno.substring(2, iprefix);
				int ideit = Integer.parseInt(debitnoi)+1;
				System.out.println(" Debit No val "+ ideit);
				debit = "PL"+ideit+"/13-14";
				System.out.println("SAmpleNo "+debit);	
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return debit;
	}



}
