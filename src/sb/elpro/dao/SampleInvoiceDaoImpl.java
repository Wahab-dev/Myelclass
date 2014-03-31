/**
* This class draws .
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

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.SampleInvoiceBean;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

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
	public boolean getSamInvDelbillDetails(InvBillDetails saminvdelabill) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstdelart = null;
		int noofrows  = 0;
		int isdelart  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delinvbill = new StringBuffer("delete from elpro.tbl_sampleinv_bill WHERE invbillid = '"+saminvdelabill.getInvid()+"' ");
			String sqlquery_delinvbill = sql_delinvbill.toString();
			System.out.println(sqlquery_delinvbill);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delinvbill);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
			if(noofrows == 1){
				if(saminvdelabill.getInvctno().startsWith("L")){
					System.out.println(" Revert PRF Status QTy "+noofrows);
					float qbal = (Float.parseFloat(saminvdelabill.getInvqshpd()) + (Float.parseFloat(saminvdelabill.getInvqbal())));
					float qshped = (Float.parseFloat(saminvdelabill.getInvqty()) - qbal);
					System.out.println("qshped "+qshped);
					System.out.println("qbal "+qbal);
					String qshiped = String.valueOf(qshped);
					String qbalc = String.valueOf(qbal);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+saminvdelabill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstdelart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstdelart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstdelart.setString(2, qbalc);
					System.out.println("getInvqbal " +qbalc);
					pstdelart.setString(3, "");
					System.out.println("INV invdetails " +saminvdelabill.getInvno()+" Dt"+saminvdelabill.getInvdt());
				
					isdelart = pstdelart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isdelart);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Revert SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(saminvdelabill.getInvqshpd()) + (Float.parseFloat(saminvdelabill.getInvqbal())));
					float qbal = (Float.parseFloat(saminvdelabill.getInvqty()) - (Float.parseFloat(saminvdelabill.getInvqshpd())));
					System.out.println("qshped "+qshped);
					System.out.println("qbal "+qbal);
					String qshiped = String.valueOf(qshped);
					String qbalc = String.valueOf(qbal);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+saminvdelabill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstdelart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstdelart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstdelart.setString(2, qbalc);
					System.out.println("getInvqbal " +qbalc);
					pstdelart.setString(3, " ");
					System.out.println("INV invdetails " +"");
					isdelart = pstdelart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isdelart);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#saveSampleInvoiceForm(sb.elpro.model.SampleInvoiceBean)
	 */
	@Override
	public boolean saveSampleInvoiceForm(SampleInvoiceBean sampinvbean)
			throws SQLException {
		System.out.println("In Sample Invoice SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstdischrg = null;
		int noofrows  = 0;
		int rowsdischrg = 0;
		boolean isSaved =true;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savesaminvform = new StringBuffer("insert into tbl_sampleinvform (invtype, invno, invdate, exportersref, expname, taninvno, customer, consignee, notify, amount, otherref, buyer, bank, AWBillNo, AWBillDate, othercharges, discounts, totamt)");
			sql_savesaminvform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_savesaminvform = sql_savesaminvform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savesaminvform);
			pst.setString(1, sampinvbean.getSaminv_invoicetype());
			System.out.println("getInv_invoicetype " +sampinvbean.getSaminv_invoicetype());
			pst.setString(2, sampinvbean.getSaminv_invoiceno());
			System.out.println("getInv_invoiceno " +sampinvbean.getSaminv_invoiceno());
			pst.setString(3, sampinvbean.getSaminv_invdate());
			pst.setString(4, sampinvbean.getSaminv_expref());
			pst.setString(5, sampinvbean.getSaminv_exporter());
			pst.setString(6, sampinvbean.getSaminv_otherref());
			pst.setString(7, sampinvbean.getSaminv_customer());
			pst.setString(8, sampinvbean.getSaminv_buyer());
			pst.setString(9, sampinvbean.getSaminv_notify());
			pst.setString(10, "NA");
			pst.setString(11, "NA");
			pst.setString(12, "NA");
			pst.setString(13, sampinvbean.getSaminv_bank());
			pst.setString(14, sampinvbean.getSaminv_awbillno());
			pst.setString(15, sampinvbean.getSaminv_awbilldate());
			pst.setString(16, sampinvbean.getSaminv_courierchrgs());
			pst.setString(17, sampinvbean.getSaminv_deduction());
			pst.setString(18, sampinvbean.getSaminv_total());
			System.out.println("getInv_total " +sampinvbean.getSaminv_total());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				/*
				 *Insert into the Dispatch Table
				 */
				StringBuffer sql_savesaminvdispform = new StringBuffer("insert into tbl_sampleinv_dispatchdetails (invno, invdate, ctryoforigin, loadingport, ctryofdesti, destination, dischargeport, precarriage, dimension, marks, grosswt, netwt, container, noofpackages, packno)");
				sql_savesaminvdispform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				String sqlquery_savesaminvdispform = sql_savesaminvdispform.toString();
				pstdischrg = (PreparedStatement) con.prepareStatement(sqlquery_savesaminvdispform);
				System.out.println(" IN PRF SAVE IN THE ");
				pstdischrg.setString(1, sampinvbean.getSaminv_invoiceno());
				System.out.println("getInv_invoiceno " +sampinvbean.getSaminv_invoiceno());
				pstdischrg.setString(2, sampinvbean.getSaminv_invdate());
				System.out.println("getInv_invdate " +sampinvbean.getSaminv_invdate());
				pstdischrg.setString(3, sampinvbean.getSaminv_ctryoforigngoods());
				pstdischrg.setString(4, sampinvbean.getSaminv_loadingport());
				pstdischrg.setString(5, sampinvbean.getSaminv_ctryoffinaldesti());
				pstdischrg.setString(6, sampinvbean.getSaminv_finaldesti());
				pstdischrg.setString(7, sampinvbean.getSaminv_dischargeport());
				pstdischrg.setString(8, sampinvbean.getSaminv_precarriageby());
				pstdischrg.setString(9, sampinvbean.getSaminv_dimension());
				pstdischrg.setString(10,  sampinvbean.getSaminv_marksno());
				pstdischrg.setString(11, sampinvbean.getSaminv_grosswt());
				pstdischrg.setString(12, sampinvbean.getSaminv_netwt());
				pstdischrg.setString(13, sampinvbean.getSaminv_precarriageby());
				pstdischrg.setString(14, sampinvbean.getSaminv_noofpackages());
				pstdischrg.setString(15, sampinvbean.getSaminv_packno());
				System.out.println("getInv_packno " +sampinvbean.getSaminv_packno());
				rowsdischrg = pstdischrg.executeUpdate();
			}
			System.out.println("Sucessfully inserted the record.." + rowsdischrg);
		}catch(Exception e){
			e.printStackTrace();
			isSaved = false;
			System.out.println("ERROR RESULT");
		}finally{
			con.close() ;
			pst.close();
			pstdischrg.close();
		}	
		return isSaved;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#getEditSamInvFormDetails(java.lang.String)
	 */
	@Override
	public List<SampleInvoiceBean> getEditSamInvFormDetails(String saminvno)
			throws SQLException {
		List<SampleInvoiceBean> editsaminvformlist = new ArrayList<SampleInvoiceBean>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT * FROM elpro.tbl_sampleinvform form , tbl_sampleinv_dispatchdetails dispatch where form.invno= dispatch.invno and form.invno = '"+saminvno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {	
				SampleInvoiceBean editsinvformbean = new SampleInvoiceBean();
				editsinvformbean.setSaminv_invoicetype(rs.getString("invtype"));
				editsinvformbean.setSaminv_invoiceno(rs.getString("invno"));
				editsinvformbean.setSaminv_invdate(DateConversion.ConverttoNormalDate(rs.getString("invdate")));
				System.out.println("DT "+editsinvformbean.getSaminv_invdate());
				editsinvformbean.setSaminv_expref(rs.getString("exportersref"));
				editsinvformbean.setSaminv_exporter(rs.getString("expname"));
				editsinvformbean.setSaminv_otherref(rs.getString("taninvno"));
				editsinvformbean.setSaminv_customer(rs.getString("customer"));
				editsinvformbean.setSaminv_buyer(rs.getString("consignee"));
				editsinvformbean.setSaminv_notify(rs.getString("notify"));
				//editsinvformbean.setSaminv_destination(rs.getString("amount"));
				//editsinvformbean.setSaminv_endusage(rs.getString("otherref"));
				//editsinvformbean.setSaminv_paymentterms(rs.getString("buyer"));
				editsinvformbean.setSaminv_awbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
				editsinvformbean.setSaminv_bank(rs.getString("bank"));
				editsinvformbean.setSaminv_courierchrgs(rs.getString("othercharges"));
				editsinvformbean.setSaminv_deduction(rs.getString("discounts"));
				editsinvformbean.setSaminv_total(rs.getString("totamt"));
				editsinvformbean.setSaminv_ctryoforigngoods(rs.getString("ctryoforigin"));
				editsinvformbean.setSaminv_loadingport(rs.getString("loadingport"));
				editsinvformbean.setSaminv_ctryoffinaldesti(rs.getString("ctryofdesti"));
				editsinvformbean.setSaminv_finaldesti(rs.getString("destination"));
				editsinvformbean.setSaminv_dischargeport(rs.getString("dischargeport"));
				editsinvformbean.setSaminv_precarriageby(rs.getString("precarriage"));
				editsinvformbean.setSaminv_dimension(rs.getString("dimension"));
				editsinvformbean.setSaminv_marksno(rs.getString("marks"));
				editsinvformbean.setSaminv_grosswt(rs.getString("grosswt"));
				editsinvformbean.setSaminv_netwt(rs.getString("netwt"));
				editsinvformbean.setSaminv_precarriageby(rs.getString("container"));
				editsinvformbean.setSaminv_noofpackages(rs.getString("noofpackages"));
				editsinvformbean.setSaminv_packno(rs.getString("packno"));
				
				editsaminvformlist.add(editsinvformbean);
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
		return editsaminvformlist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampleInvoiceDao#updtSamInvFormDetails(sb.elpro.model.SampleInvoiceBean)
	 */
	@Override
	public boolean updtSamInvFormDetails(SampleInvoiceBean sampinvbean)
			throws SQLException {
		System.out.println("In Sample Invoice EDIT SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstdischrg = null;
		int noofrows  = 0;
		int rowsdischrg = 0;
		boolean isUpdtd =true;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_updtsaminvform = new StringBuffer("update tbl_sampleinvform set invtype = ? ,  invdate= ? , exportersref= ? , expname= ? , taninvno= ? , customer= ? , consignee= ? , notify= ? , amount= ? , otherref= ? , buyer= ? , bank= ? , AWBillNo= ? , AWBillDate= ? , othercharges= ? , discounts= ? , totamt = ? where invno ='"+sampinvbean.getSaminv_invoiceno()+"' ");
			String sqlquery_updtsaminvform = sql_updtsaminvform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtsaminvform);
			pst.setString(1, sampinvbean.getSaminv_invoicetype());
			System.out.println("getInv_invoicetype " +sampinvbean.getSaminv_invoicetype());
			pst.setString(2, sampinvbean.getSaminv_invdate());
			pst.setString(3, sampinvbean.getSaminv_expref());
			pst.setString(4, sampinvbean.getSaminv_exporter());
			pst.setString(5, sampinvbean.getSaminv_otherref());
			pst.setString(6, sampinvbean.getSaminv_customer());
			pst.setString(7, sampinvbean.getSaminv_buyer());
			pst.setString(8, sampinvbean.getSaminv_notify());
			pst.setString(9, "NA");
			pst.setString(10, "NA");
			pst.setString(11, "NA");
			pst.setString(12, sampinvbean.getSaminv_bank());
			pst.setString(13, sampinvbean.getSaminv_awbillno());
			pst.setString(14, sampinvbean.getSaminv_awbilldate());
			pst.setString(15, sampinvbean.getSaminv_courierchrgs());
			pst.setString(16, sampinvbean.getSaminv_deduction());
			pst.setString(17, sampinvbean.getSaminv_total());
			System.out.println("getInv_total " +sampinvbean.getSaminv_total());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				/*
				 *Insert into the Dispatch Table
				 */
				StringBuffer sql_updtsaminvdispform = new StringBuffer("update tbl_sampleinv_dispatchdetails set invdate = ?, ctryoforigin = ?, loadingport = ?, ctryofdesti = ?, destination = ?, dischargeport = ?, precarriage = ?, dimension = ?, marks = ?, grosswt = ?, netwt = ?, container = ?, noofpackages = ?, packno = ?  where invno ='"+sampinvbean.getSaminv_invoiceno()+"' ");
				
				String sqlquery_sql_updtsaminvdispform = sql_updtsaminvdispform.toString();
				pstdischrg = (PreparedStatement) con.prepareStatement(sqlquery_sql_updtsaminvdispform);
				System.out.println(" IN Sample Inv UPDT Dischrg Form ");
				pstdischrg.setString(1, sampinvbean.getSaminv_invdate());
				System.out.println("getInv_invdate " +sampinvbean.getSaminv_invdate());
				pstdischrg.setString(2, sampinvbean.getSaminv_ctryoforigngoods());
				pstdischrg.setString(3, sampinvbean.getSaminv_loadingport());
				pstdischrg.setString(4, sampinvbean.getSaminv_ctryoffinaldesti());
				pstdischrg.setString(5, sampinvbean.getSaminv_finaldesti());
				pstdischrg.setString(6, sampinvbean.getSaminv_dischargeport());
				pstdischrg.setString(7, sampinvbean.getSaminv_precarriageby());
				pstdischrg.setString(8, sampinvbean.getSaminv_dimension());
				pstdischrg.setString(9,  sampinvbean.getSaminv_marksno());
				pstdischrg.setString(10, sampinvbean.getSaminv_grosswt());
				pstdischrg.setString(11, sampinvbean.getSaminv_netwt());
				pstdischrg.setString(12, sampinvbean.getSaminv_precarriageby());
				pstdischrg.setString(13, sampinvbean.getSaminv_noofpackages());
				pstdischrg.setString(14, sampinvbean.getSaminv_packno());
				System.out.println("geInv_packno " +sampinvbean.getSaminv_packno());
				rowsdischrg = pstdischrg.executeUpdate();
			}
			System.out.println("Sucessfully inserted the record.." + rowsdischrg);
		}catch(Exception e){
			e.printStackTrace();
			isUpdtd = false;
			System.out.println("ERROR RESULT");
		}finally{
			con.close() ;
			pst.close();
			pstdischrg.close();
		}	
		return isUpdtd;
	}

}
