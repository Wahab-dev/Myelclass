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
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class SampleInvoiceDaoImpl implements SampleInvoiceDao{

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getSamInvCustsampleDet(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<CustomerInvoice> getSamInvCustsampleDet(String custname,
			String type, String sidx, String sord) throws SQLException {
		ArrayList<CustomerInvoice> invcustctrraylist = new ArrayList<CustomerInvoice>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String sql = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			if(type.equalsIgnoreCase("sample")){
				sql = "SELECT Sampleno, orderdt, refno, customerid,  tanneryid, deliverid, destination, add_date, cdd_date, handledby, isinvraised FROM elpro.tbl_srfform where customerid like '%"+custname+"%' order by "+sidx+" "+sord+" ";
			}else{
			   sql = "(SELECT Sampleno, orderdt, refno, customerid,  tanneryid, deliverid, destination,add_date, cdd_date, handledby, isinvraised FROM elpro.tbl_srfform where customerid like '%"+custname+"%') union (SELECT Ctno, Orderdt as Dt, pono as refno, customerid as cust,  tanneryid, consigneeid, destination, add_date, cdd_date, commission, othercommission FROM elpro.tbl_prfform where customerid like '%"+custname+"%') order by "+sidx+" "+sord+" ";
			}
			
			System.out.println("SQL + "+sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {						
			 CustomerInvoice InvCustCtbean = new CustomerInvoice();
			  InvCustCtbean.setSampleno(rs.getString("Sampleno"));
			  InvCustCtbean.setOrderdt(rs.getString("orderdt"));
			  InvCustCtbean.setRefno(rs.getString("refno")); //
			  InvCustCtbean.setCustomer(rs.getString("customerid"));
			  InvCustCtbean.setTannery(rs.getString("tanneryid"));
			  InvCustCtbean.setDeliverid(rs.getString("deliverid"));
			  InvCustCtbean.setDestination(rs.getString("destination"));
			  InvCustCtbean.setAdd_date(rs.getString("add_date"));
			  InvCustCtbean.setCdd_date(rs.getString("cdd_date"));
			  InvCustCtbean.setHandledby(rs.getString("handledby"));
			  InvCustCtbean.setIsinvraised(rs.getString("isinvraised"));
			  System.out.println("getSampleno "+InvCustCtbean.getSampleno());
			 invcustctrraylist.add(InvCustCtbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Load Ct Sample Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invcustctrraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getInvSelSampleDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<ArticleDetails> getInvSelSampleDetails(String samno,
			String type) throws SQLException {
		ArrayList<ArticleDetails> invloadportarraylist = new ArrayList<ArticleDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String sql = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			System.out.println(" Type in Daoimpl "+type);
			if(type.equalsIgnoreCase("sample")){
				System.out.println(" in IF");
				sql =  "SELECT articletype, articlename, color, size, substance, selection , quantity ,unit, pcs, shpd, bal,  rate, articleid,  art.sampleno, art.srfarticleid, status, rdd_date, courierdetails, reps, feedbackdetails FROM elpro.tbl_srf_article art, elpro.tbl_srfarticle_status statuse Where art.srfarticleid = statuse.srfarticleid and art.sampleno in ("+samno+") order by art.sampleno";
			}else{
				System.out.println(" in else");
				sql = "(SELECT articletype, articlename, color, size, substance, selection , quantity ,unit, pcs, shpd, bal,  rate, articleid,  art.sampleno, art.srfarticleid, status, rdd_date, courierdetails, reps, feedbackdetails FROM elpro.tbl_srf_article art, elpro.tbl_srfarticle_status statuse Where art.srfarticleid = statuse.srfarticleid and art.sampleno in ("+samno+")) union (SELECT articletype, articlename, color, size, substance, selection, quantity, unit, pcs, qshipped, qbal, rate, tc, article.contractno, prfarticleid, status, rdd_date, comments, reps, feddback  from tbl_prf_article article, elpro.tbl_prfarticle_status statuse where prf_articleid = prfarticleid and article.contractno in ("+samno+")) ";
			}
			//String sql = "SELECT articleid, articlename, size, substance, selection, selectionpercent, color, quantity, qshipped, qbal, unit, pcs, rate, tc, article.contractno, prfarticleid from tbl_prf_article article, elpro.tbl_prfarticle_status statuse where  prf_articleid = prfarticleid and article.contractno in ("+ctno+") order by article.contractno";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {	
				ArticleDetails saminvartbean = new ArticleDetails();
				saminvartbean.setArticletype(rs.getString("articletype"));
				saminvartbean.setArticlename(rs.getString("articlename"));
				saminvartbean.setSize(rs.getString("size"));
				saminvartbean.setSubstance(rs.getString("substance"));
				saminvartbean.setSelection(rs.getString("selection"));
				saminvartbean.setColor(rs.getString("color"));
				saminvartbean.setQuantity(rs.getString("quantity"));
				saminvartbean.setUnit(rs.getString("unit"));
				saminvartbean.setPieces(rs.getString("pcs"));
				saminvartbean.setQshipped(rs.getFloat("shpd"));
				saminvartbean.setQbal(rs.getFloat("bal"));
				saminvartbean.setRate(rs.getString("rate"));
				saminvartbean.setSampleno(rs.getString("sampleno"));
				saminvartbean.setSrfarticleid(rs.getString("srfarticleid"));
				saminvartbean.setStatus(rs.getString("status"));
				saminvartbean.setComments(rs.getString("courierdetails"));
				saminvartbean.setRdd(rs.getString("rdd_date"));
				saminvartbean.setReps(rs.getString("reps"));
				saminvartbean.setFeedback(rs.getString("feedbackdetails"));
				System.out.println("Art CT List"+saminvartbean.getSampleno());
				invloadportarraylist.add(saminvartbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Sample Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invloadportarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getSamInvAddbillDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvAddbillDetails(InvBillDetails saminvbill)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		int noofrows  = 0;
		int updtart = 0;
		boolean isInserted = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_sampleinv_bill (sampleno, artname, color, size, subs, selc, unit, qty, pcs, rate, invno, invdate, qshpd, qbal, amt,articleid)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			System.out.println("Insert quert" +sqlquery_saveprfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, saminvbill.getInvctno());
			System.out.println("getInvsampleno " +saminvbill.getInvctno());
			pst.setString(2, saminvbill.getInvartname());
			System.out.println("getInvartname " +saminvbill.getInvartname());
			pst.setString(3, saminvbill.getInvcolor());
			pst.setString(4, saminvbill.getInvsize());
			pst.setString(5, saminvbill.getInvsubs());
			pst.setString(6, saminvbill.getInvselc());
			pst.setString(7, saminvbill.getInvunit());
			pst.setString(8, saminvbill.getInvqty());
			pst.setString(9, saminvbill.getInvpcs());
			pst.setString(10, saminvbill.getInvrate());
			pst.setString(11, saminvbill.getInvno());
			pst.setString(12, saminvbill.getInvdt());
			pst.setString(13, saminvbill.getInvqshpd());
			pst.setString(14, saminvbill.getInvqbal());
			pst.setString(15, saminvbill.getInvamt());
			pst.setString(16, saminvbill.getInvartid());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
			if(noofrows == 1){
				if(saminvbill.getInvctno().startsWith("L")){
					System.out.println(" Update PRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminvbill.getInvqty()) - (Float.parseFloat(saminvbill.getInvqbal())));
					System.out.println("qbal "+qshped);
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+saminvbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pst1 = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pst1.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pst1.setString(2, saminvbill.getInvqbal());
					System.out.println("getInvqbal " +saminvbill.getInvqbal());
					pst1.setString(3, saminvbill.getInvno()+" Dt"+saminvbill.getInvdt());
					System.out.println("INV invdetails " +saminvbill.getInvno()+" Dt"+saminvbill.getInvdt());
				
					updtart = pst1.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + updtart);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Update SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminvbill.getInvqty()) - (Float.parseFloat(saminvbill.getInvqbal())));
					System.out.println("qbal "+qshped);
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+saminvbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pst1 = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pst1.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pst1.setString(2, saminvbill.getInvqbal());
					System.out.println("getInvqbal " +saminvbill.getInvqbal());
					pst1.setString(3, saminvbill.getInvno()+" Dt"+saminvbill.getInvdt());
					System.out.println("INV invdetails " +saminvbill.getInvno()+" Dt"+saminvbill.getInvdt());
					updtart = pst1.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + updtart);
				}
				
			}
			System.out.println("Sucessfully inserted the record.." + noofrows);
			
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
		isInserted = false;
	}finally{
		 con.close() ;
		 pst.close();
   }	
	return isInserted;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getSamInvBillDetails(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<InvBillDetails> getSamInvBillDetails(String invno,
			String samno, String type) throws SQLException {
		ArrayList<InvBillDetails> saminvBilllist = new ArrayList<InvBillDetails>();		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT invbillid, articleid, artname, color, size, subs, selc, unit,  qty, pcs, rate,  sampleno, invno, invdate, qshpd, qbal, amt FROM elpro.tbl_sampleinv_bill where sampleno in ("+samno+") order by invno, artname ";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {						
				InvBillDetails saminvbillbean = new InvBillDetails();
				saminvbillbean.setInvid(rs.getString("invbillid"));
				saminvbillbean.setInvartid(rs.getString("articleid"));
				saminvbillbean.setInvartname(rs.getString("artname"));
				saminvbillbean.setInvcolor(rs.getString("color"));
				saminvbillbean.setInvsize(rs.getString("size"));
				saminvbillbean.setInvsubs(rs.getString("subs"));
				saminvbillbean.setInvselc(rs.getString("selc"));
				saminvbillbean.setInvqty(rs.getString("qty"));
				saminvbillbean.setInvunit(rs.getString("unit"));
				saminvbillbean.setInvpcs(rs.getString("pcs"));
				saminvbillbean.setInvrate(rs.getString("rate"));
				saminvbillbean.setInvctno(rs.getString("sampleno"));
				saminvbillbean.setInvno(rs.getString("invno"));
				saminvbillbean.setInvdt(rs.getString("invdate"));
				saminvbillbean.setInvqshpd(rs.getString("qshpd"));
				saminvbillbean.setInvqbal(rs.getString("qbal"));
				saminvbillbean.setInvamt(rs.getString("amt"));
				System.out.println("Sample Bill  List"+saminvbillbean.getInvctno());
				saminvBilllist.add(saminvbillbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Sample Bill ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return saminvBilllist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getSamInvBillTotAmtDetails(java.lang.String)
	 */
	@Override
	public ArrayList<InvBillDetails> getSamInvBillTotAmtDetails(String invno)
			throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<InvBillDetails> samtotalamtarray = new ArrayList<InvBillDetails>();
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT  sum(qshpd) as qshpd , sum(pcs) as pcs, sum(amt) as totamt FROM elpro.tbl_sampleinv_bill where invno = '"+invno+"'";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			if(rs.next()){
				InvBillDetails saminvbilltot = new InvBillDetails();
				 saminvbilltot.setInvqty(rs.getString("qshpd"));
				 saminvbilltot.setInvpcs(rs.getString("pcs"));
				 saminvbilltot.setInvamt(rs.getString("totamt"));
				 samtotalamtarray.add(saminvbilltot);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return samtotalamtarray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getInvAddbillSecondDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvAddbillSecondDetails(InvBillDetails saminvaddagainbill)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstadd2tart = null;
		int noofrows  = 0;
		int isadd2art = 0;
		boolean isInserted = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_sampleinv_bill (sampleno, artname, color, size, subs, selc, qty, unit, pcs, rate, invno, invdate, qshpd, qbal, amt, articleid)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			System.out.println("Insert quert" +sqlquery_saveprfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, saminvaddagainbill.getInvctno());
			System.out.println("getInvctno " +saminvaddagainbill.getInvctno());
			pst.setString(2, saminvaddagainbill.getInvartname());
			System.out.println("getInvartname " +saminvaddagainbill.getInvartname());
			pst.setString(3, saminvaddagainbill.getInvcolor());
			pst.setString(4, saminvaddagainbill.getInvsize());
			pst.setString(5, saminvaddagainbill.getInvsubs());
			pst.setString(6, saminvaddagainbill.getInvselc());
			pst.setString(7, saminvaddagainbill.getInvqty());
			pst.setString(8, saminvaddagainbill.getInvunit());
			pst.setString(9, saminvaddagainbill.getInvpcs());
			pst.setString(10, saminvaddagainbill.getInvrate());
			pst.setString(11, saminvaddagainbill.getInvno());
			pst.setString(12, saminvaddagainbill.getInvdt());
			pst.setString(13, saminvaddagainbill.getInvqshpd());
			System.out.println("getInvqshpd " +saminvaddagainbill.getInvqshpd());
			pst.setString(14, saminvaddagainbill.getInvqbal());
			System.out.println("getInvqbal " +saminvaddagainbill.getInvqbal());
			pst.setString(15, saminvaddagainbill.getInvamt());
			System.out.println("getInvamt " +saminvaddagainbill.getInvamt());
			pst.setString(16, saminvaddagainbill.getInvartid());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				if(saminvaddagainbill.getInvctno().startsWith("L")){
					System.out.println(" Update PRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminvaddagainbill.getInvqty()) - (Float.parseFloat(saminvaddagainbill.getInvqbal())));
					System.out.println("qbal "+qshped);
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+saminvaddagainbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstadd2tart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstadd2tart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstadd2tart.setString(2, saminvaddagainbill.getInvqbal());
					System.out.println("getInvqbal " +saminvaddagainbill.getInvqbal());
					pstadd2tart.setString(3, saminvaddagainbill.getInvno()+" Dt"+saminvaddagainbill.getInvdt());
					System.out.println("INV invdetails " +saminvaddagainbill.getInvno()+" Dt"+saminvaddagainbill.getInvdt());
				
					isadd2art = pstadd2tart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isadd2art);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Update SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminvaddagainbill.getInvqty()) - (Float.parseFloat(saminvaddagainbill.getInvqbal())));
					System.out.println("qbal "+qshped);
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+saminvaddagainbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstadd2tart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstadd2tart.setString(1,qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstadd2tart.setString(2, saminvaddagainbill.getInvqbal());
					System.out.println("getInvqbal " +saminvaddagainbill.getInvqbal());
					pstadd2tart.setString(3, saminvaddagainbill.getInvno()+" Dt"+saminvaddagainbill.getInvdt());
					System.out.println("INV invdetails " +saminvaddagainbill.getInvno()+" Dt"+saminvaddagainbill.getInvdt());
					isadd2art = pstadd2tart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isadd2art);
				}
			}
			System.out.println("Sucessfully inserted the record.." + noofrows);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
		isInserted = false;
	}finally{
		 con.close() ;
		 pst.close();
   }	
	return isInserted;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getInvEditbillDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvEditbillDetails(InvBillDetails saminveditbill)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstupdtart = null;
		int noofrows  = 0;
		int isupdart = 0;
		boolean isupdate = true;
		
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("UPDATE elpro.tbl_sampleinv_bill SET rate = ? , qshpd = ? , qbal = ? , amt = ? WHERE invbillid = '"+saminveditbill.getInvid()+"' ");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, saminveditbill.getInvrate());
			System.out.println("getInvrate " +saminveditbill.getInvrate());
			pst.setString(2, saminveditbill.getInvqshpd());
			System.out.println("getInvqshpd " +saminveditbill.getInvqshpd());
			pst.setString(3, saminveditbill.getInvqbal());
			pst.setString(4, saminveditbill.getInvamt());
			//pst.setString(15, artindertdetail.getArtshform() );
			System.out.println("INV Article ID " +saminveditbill.getInvid());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				if(saminveditbill.getInvctno().startsWith("L")){
					System.out.println(" Update PRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminveditbill.getInvqty()) - (Float.parseFloat(saminveditbill.getInvqbal())));
					System.out.println("qbal "+qshped);
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+saminveditbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstupdtart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstupdtart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstupdtart.setString(2, saminveditbill.getInvqbal());
					System.out.println("getInvqbal " +saminveditbill.getInvqbal());
					pstupdtart.setString(3, saminveditbill.getInvno()+" Dt"+saminveditbill.getInvdt());
					System.out.println("INV invdetails " +saminveditbill.getInvno()+" Dt"+saminveditbill.getInvdt());
				
					isupdart = pstupdtart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isupdart);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Update SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminveditbill.getInvqty()) - (Float.parseFloat(saminveditbill.getInvqbal())));
					System.out.println("qbal "+qshped);
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+saminveditbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstupdtart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstupdtart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstupdtart.setString(2, saminveditbill.getInvqbal());
					System.out.println("getInvqbal " +saminveditbill.getInvqbal());
					pstupdtart.setString(3, saminveditbill.getInvno()+" Dt"+saminveditbill.getInvdt());
					System.out.println("INV invdetails " +saminveditbill.getInvno()+" Dt"+saminveditbill.getInvdt());
					isupdart = pstupdtart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isupdart);
				}
			}
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isupdate = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isupdate;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getInvDelbillDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvDelbillDetails(InvBillDetails saminvdelabill)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
