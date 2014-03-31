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

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.BankDetails;	
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.ExporterDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.InvCustContractDetails;
import sb.elpro.model.InvoiceBean;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public ArrayList<ExporterDetails> getInvExporter(String expterm) throws SQLException {
		 ArrayList<ExporterDetails> invexporterarray = new ArrayList<ExporterDetails>();			
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;			
			try{			
				con = DBConnection.getConnection();
				st = (Statement) con.createStatement();
				String sql = "SELECT tanname, tanattn, tanaddr, tanphone, tanfax, expid, cstno, tinno, exprefno FROM elpro.tbl_tannery where tanname like '%"+expterm+"%' order by tanname";
				rs = st.executeQuery(sql);
				while(rs.next()) {	
				ExporterDetails invexporterbean = new ExporterDetails();
					invexporterbean.setExpname(rs.getString("tanname"));
					invexporterbean.setExpaddr(rs.getString("tanaddr"));
					invexporterbean.setExpref(rs.getString("exprefno"));
					invexporterbean.setExpphone(rs.getString("tanphone"));
					invexporterbean.setExpfax(rs.getString("tanfax"));
					invexporterbean.setExpattn(rs.getString("tanattn"));
					System.out.println("Exporter"+invexporterbean.getExpname());
					invexporterarray.add(invexporterbean);
				}
			}catch(Exception e){
				System.out.println("ERROR RESULT");
				e.printStackTrace();
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }			
			return invexporterarray;
	}

	@Override
	public ArrayList<NotifyConsigneeDetails> getInvNotify() throws SQLException {
		 ArrayList<NotifyConsigneeDetails> InvNotifyarray = new ArrayList<NotifyConsigneeDetails>();			
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;			
			try{			
				con = DBConnection.getConnection();
				st = (Statement) con.createStatement();
				String sql = "SELECT notifyname, notifyattn, notifyaddr, notifyphone, notifyfax FROM elpro.tbl_notify order by notifyname";
				rs = st.executeQuery(sql);
				while(rs.next()) {	
					NotifyConsigneeDetails InvNotifybean = new NotifyConsigneeDetails();
					InvNotifybean.setNotifyConsigneeName(rs.getString("notifyname"));
					InvNotifybean.setNotifyConsigneeAttention(rs.getString("notifyattn"));
					InvNotifybean.setNotifyConsigneeAddress(rs.getString("notifyaddr"));
					InvNotifybean.setNotifyConsigneeContactNo(rs.getString("notifyphone"));
					InvNotifybean.setNotifyConsigneefax(rs.getString("notifyfax"));
					System.out.println("notifyname"+InvNotifybean.getNotifyConsigneeName());
					InvNotifyarray.add(InvNotifybean);
				}
			}catch(Exception e){
				System.out.println("ERROR RESULT");
				e.printStackTrace();
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }			
			return InvNotifyarray;
	}

	@Override
	public ArrayList<BankDetails> getInvBank() throws SQLException {
		ArrayList<BankDetails> InvBankarray = new ArrayList<BankDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT bankname, bankbranch, bankaddr, swiftcode, Acctno FROM elpro.tbl_bank order by bankname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				BankDetails InvBankbean = new BankDetails();
				InvBankbean.setBankName(rs.getString("bankname"));
				InvBankbean.setBankBranch(rs.getString("bankbranch"));
				InvBankbean.setBankAddress(rs.getString("bankaddr"));
				InvBankbean.setBankSwiftCode(rs.getString("swiftcode"));
				InvBankbean.setBankAcctNo(rs.getString("Acctno"));
				System.out.println("bank name"+InvBankbean.getBankName());
				InvBankarray.add(InvBankbean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return InvBankarray;
	}
	
	
	@Override
	public ArrayList<DestinationDetails> getInvDestiCtrylist(String destictryterm) throws SQLException {
		ArrayList<DestinationDetails> InvDestiCountryarray = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct destcountry FROM elpro.tbl_destination where destcountry like '%"+destictryterm+"%' order by destcountry";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails InvDestiCountrybean = new DestinationDetails();
				InvDestiCountrybean.setDestictry(rs.getString("destcountry"));
				System.out.println("destcountry"+InvDestiCountrybean.getDestictry());
				InvDestiCountryarray.add(InvDestiCountrybean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return InvDestiCountryarray;
	}
	
	@Override
	public ArrayList<DestinationDetails> getInvDestiPortlist(String destictryterm, String destictryvalterm) throws SQLException {
		ArrayList<DestinationDetails> InvFinalDestiarray = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT destname, destcountry FROM elpro.tbl_destination where destcountry like '%"+destictryvalterm+"%' and destname like '%"+destictryterm+"%' order by destname";
			System.out.println("SQL  "+sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails InvFinalDestibean = new DestinationDetails();
				InvFinalDestibean.setDestiname(rs.getString("destname"));
				System.out.println("destname"+InvFinalDestibean.getDestiname());
				InvFinalDestiarray.add(InvFinalDestibean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return InvFinalDestiarray;
	}
	

	/*@Override
	public ArrayList<DestinationDetails> getinvDischargePort()
			throws SQLException {
		ArrayList<DestinationDetails> InvDischargePortarray = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct DestinationName FROM elpro.tbl_destinationport order by DestinationName";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails InvDischargeportbean = new DestinationDetails();
				InvDischargeportbean.setDestination(rs.getString("DestinationName"));
				System.out.println("Result Added Successfully");
				System.out.println("DestinationName"+InvDischargeportbean.getDestination());
				InvDischargePortarray.add(InvDischargeportbean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return InvDischargePortarray;
	}*/

	@Override
	public ArrayList<CustomerDetails> getinvCustomerDetails()
			throws SQLException {
		ArrayList<CustomerDetails> invcustrraylist = new ArrayList<CustomerDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{	con = DBConnection.getConnection();
		st = (Statement) con.createStatement();
		String sql = "SELECT custid, custname, custaddr, custattn, custphone, custfax, agentid, shortform FROM elpro.tbl_customer";
		rs = st.executeQuery(sql);
		while(rs.next()) {	
			CustomerDetails custbean = new CustomerDetails();
			custbean.setCustomerAddress(rs.getString("custaddr"));
			custbean.setCustomerAttention(rs.getString("custattn"));
			custbean.setCustomerFax(rs.getString("custfax"));
			custbean.setCustomerId(rs.getString("custid"));
			custbean.setCustomerName(rs.getString("custname"));
			custbean.setCustomerTelephone(rs.getString("custphone"));			
			System.out.println("Customer  name "+custbean.getCustomerName());
			invcustrraylist.add(custbean);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Customer Name ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return invcustrraylist;
	}

	@Override
	public ArrayList<InvCustContractDetails> getinvCustContracttDetails()
			throws SQLException {
		ArrayList<InvCustContractDetails> invcustctrraylist = new ArrayList<InvCustContractDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;				
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "select CNo, Agent, OrderDate, Tannery, Customer, Consignee, Notify, Exporter from elpro.prf order by Customer";
			rs = st.executeQuery(sql);
			while(rs.next()) {						
					InvCustContractDetails InvCustCtbean = new InvCustContractDetails();
					InvCustCtbean.setCustName(rs.getString("Customer"));
					InvCustCtbean.setCosigneeId (rs.getString("Consignee"));
					InvCustCtbean.setCtNo(rs.getString("CNo"));
					InvCustCtbean.setExporterName(rs.getString("Exporter"));
					InvCustCtbean.setIssuedDate(rs.getString("OrderDate"));
					InvCustCtbean.setNotifyId(rs.getString("Notify"));
					InvCustCtbean.setTannerName(rs.getString("Tannery"));
					InvCustCtbean.setAgent(rs.getString("Agent"));
					System.out.println("Ct No "+InvCustCtbean.getCtNo());
					invcustctrraylist.add(InvCustCtbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invcustctrraylist;
}

	@Override
	public ArrayList<CustomerInvoice> getInvCustCtlist(String custid, String type, String sortname, String sortorder) throws SQLException {
		ArrayList<CustomerInvoice> invcustctrraylist = new ArrayList<CustomerInvoice>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String sql = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			if(type.equalsIgnoreCase("ct")){
				sql = "SELECT Ctno, Orderdt as Dt, pono as refno, customerid as cust,  tanneryid, consigneeid, destination, add_date, cdd_date, commission, othercommission FROM elpro.tbl_prfform where customerid like '%"+custid+"%' order by "+sortname+" "+sortorder+" ";
			}else{
				 sql = "(SELECT Ctno, Orderdt as Dt, pono as refno, customerid as cust,  tanneryid, consigneeid, destination, add_date, cdd_date, commission, othercommission FROM elpro.tbl_prfform where customerid like '%"+custid+"%') union (SELECT Sampleno, orderdt, refno, customerid,  tanneryid, deliverid, destination,add_date, cdd_date, handledby, isinvraised FROM elpro.tbl_srfform where customerid like '%"+custid+"%') order by "+sortname+" "+sortorder+" ";
			}
			
			System.out.println("SQL + "+sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {						
			 CustomerInvoice InvCustCtbean = new CustomerInvoice();
			  InvCustCtbean.setCtno(rs.getString("Ctno"));
			  InvCustCtbean.setOrderdt(rs.getString("Dt"));
			  InvCustCtbean.setPono(rs.getString("refno")); //
			  InvCustCtbean.setCustomer(rs.getString("cust"));
			  InvCustCtbean.setTannery(rs.getString("tanneryid"));
			  InvCustCtbean.setConsignee(rs.getString("consigneeid"));
			  InvCustCtbean.setDestination(rs.getString("destination"));
			  InvCustCtbean.setCommission(rs.getString("commission"));
			  InvCustCtbean.setOthercommission(rs.getString("othercommission"));
			  InvCustCtbean.setCdd_date(rs.getString("cdd_date"));
			  InvCustCtbean.setAdd_date(rs.getString("add_date"));
			  System.out.println("etCtno "+InvCustCtbean.getCtno());
			 invcustctrraylist.add(InvCustCtbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invcustctrraylist;
	}
	/*  Not Necessary - merged Sample with CT
	 * (non-Javadoc)
	 * @see sb.elpro.dao.InvoiceDao#getinvCustSampleDetails(java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public ArrayList<CustomerInvoice> getinvCustSampleDetails(String custname,
			String sidx, String sord) throws SQLException {
		ArrayList<CustomerInvoice> invcustctrraylist = new ArrayList<CustomerInvoice>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT Sampleno, orderdt, refno, priority, handledby, customerid, tanneryid, deliverid, add_date, cdd_date, isinvraised FROM elpro.tbl_srfform  where customerid like '%"+custname+"%' order by "+sidx+" "+sord+" ";
			System.out.println("SQL + "+sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {						
			 CustomerInvoice InvCustCtbean = new CustomerInvoice();
			  InvCustCtbean.setSampleno(rs.getString("Sampleno"));
			  InvCustCtbean.setOrderdt(rs.getString("orderdt"));
			  InvCustCtbean.setRefno(rs.getString("refno"));
			  InvCustCtbean.setPriority(rs.getString("priority")); //
			  InvCustCtbean.setHandledby(rs.getString("handledby"));
			  InvCustCtbean.setScustomerid(rs.getString("customerid"));
			  InvCustCtbean.setStanneryid(rs.getString("tanneryid"));
			  InvCustCtbean.setDeliverid(rs.getString("deliverid"));
			  InvCustCtbean.setSadd_date(rs.getString("add_date"));
			  InvCustCtbean.setScdd_date(rs.getString("cdd_date"));
			  InvCustCtbean.setIsinvraised(rs.getString("isinvraised"));
			  System.out.println("Sampleno "+InvCustCtbean.getSampleno());
			 invcustctrraylist.add(InvCustCtbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invcustctrraylist;
	}*/
	@Override
	public ArrayList<CustomerDetails> getInvCustlist(String custterm)
			throws SQLException {
		ArrayList<CustomerDetails> invcustarraylist = new ArrayList<CustomerDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT custid, custname, custaddr, custattn, custphone, custfax, shortform FROM elpro.tbl_customer where custname like '%"+custterm+"%'order by custname";
			rs = st.executeQuery(sql);
			while(rs.next()) {						
				CustomerDetails InvCustbean = new CustomerDetails();
					InvCustbean.setValue(rs.getString("custname"));
					InvCustbean.setCustomerAddress(rs.getString("custaddr"));
					InvCustbean.setCustomerAttention(rs.getString("custattn"));
					InvCustbean.setCustomerTelephone(rs.getString("custphone"));
					InvCustbean.setCustomerFax(rs.getString("custfax"));
					InvCustbean.setLabel(rs.getString("custname"));
					InvCustbean.setCustomerId(rs.getString("custid"));
					System.out.println("Cust CT List"+InvCustbean.getValue().length());
					invcustarraylist.add(InvCustbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invcustarraylist;
	}

	@Override
	public ArrayList<DestinationDetails> getInvloadctrylist(String loadctryterm)
			throws SQLException {
		ArrayList<DestinationDetails> invcustarraylist = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT CountryId, CountryName FROM elpro.tbl_desticountry where CountryName like '%"+loadctryterm+"%' order by CountryName";
			rs = st.executeQuery(sql);
			while(rs.next()) {						
				DestinationDetails InvCtrybean = new DestinationDetails();
				InvCtrybean.setDestiname(rs.getString("CountryName"));
				InvCtrybean.setDestiid(rs.getString("CountryId"));
				System.out.println("Cust CT List"+InvCtrybean);
				invcustarraylist.add(InvCtrybean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invcustarraylist;
	}

	@Override
	public ArrayList<DestinationDetails> getInvloadportlist(String loadportterm, String ctryvalterm)
			throws SQLException {
		ArrayList<DestinationDetails> invloadportarraylist = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT loadingid, loadingname, loadingcountry FROM elpro.tbl_loading where loadingcountry = '"+ctryvalterm+"'  and LoadingName like '%"+loadportterm+"%'order by LoadingName";
			rs = st.executeQuery(sql);
			while(rs.next()) {						
				DestinationDetails Invloadportbean = new DestinationDetails();
				Invloadportbean.setDestiname(rs.getString("LoadingName"));
				Invloadportbean.setDestiid(rs.getString("LoadingId"));
				System.out.println("Cust CT List"+Invloadportbean);
				invloadportarraylist.add(Invloadportbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invloadportarraylist;
	}

	@Override
	public ArrayList<ArticleDetails> getInvSelContractDetails(String ctno, String type)
			throws SQLException {
		ArrayList<ArticleDetails> invloadportarraylist = new ArrayList<ArticleDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String sql = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			if(type.equalsIgnoreCase("ct")){
				sql =  "SELECT articletype, articlename, color, size, substance, selection, quantity, unit, pcs, qshipped, qbal, rate, tc, article.contractno, prfarticleid, status, rdd_date, comments, reps, feddback from tbl_prf_article article, elpro.tbl_prfarticle_status statuse  where prf_articleid = prfarticleid and article.contractno in ("+ctno+") order by article.contractno";
			}else{
				sql = "(SELECT articletype, articlename, color, size, substance, selection, quantity, unit, pcs, qshipped, qbal, rate, tc, article.contractno, prfarticleid, status, rdd_date, comments, reps, feddback from tbl_prf_article article, elpro.tbl_prfarticle_status statuse  where prf_articleid = prfarticleid and article.contractno in ("+ctno+")) union (SELECT articletype, articlename, color, size, substance, selection , quantity ,unit, pcs, shpd, bal,  rate, articleid,  art.sampleno, art.srfarticleid, status, rdd_date, courierdetails, reps, feedbackdetails FROM elpro.tbl_srf_article art, elpro.tbl_srfarticle_status statuse Where  art.srfarticleid = statuse.srfarticleid and art.sampleno in ("+ctno+") order by article.contractno)";
			}
			//String sql = "SELECT articleid, articlename, size, substance, selection, selectionpercent, color, quantity, qshipped, qbal, unit, pcs, rate, tc, article.contractno, prfarticleid from tbl_prf_article article, elpro.tbl_prfarticle_status statuse where  prf_articleid = prfarticleid and article.contractno in ("+ctno+") order by article.contractno";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {	
				ArticleDetails artbean = new ArticleDetails();
				artbean.setArticletype(rs.getString("articletype"));
				artbean.setArticlename(rs.getString("articlename"));
				artbean.setSize(rs.getString("size"));
				artbean.setSubstance(rs.getString("substance"));
				artbean.setSelection(rs.getString("selection"));
				artbean.setColor(rs.getString("color"));
				artbean.setQuantity(rs.getString("quantity"));
				artbean.setUnit(rs.getString("unit"));
				artbean.setPieces(rs.getString("pcs"));
				artbean.setQshipped(rs.getFloat("qshipped"));
				artbean.setQbal(rs.getFloat("qbal"));
				artbean.setRate(rs.getString("rate"));
				artbean.setTc(rs.getString("tc"));
				artbean.setContractno(rs.getString("contractno"));
				artbean.setPrfarticleid(rs.getString("prfarticleid"));
				artbean.setStatus(rs.getString("status"));
				artbean.setComments(rs.getString("comments"));
				artbean.setRdd(rs.getString("rdd_date"));
				artbean.setReps(rs.getString("reps"));
				artbean.setFeedback(rs.getString("feddback"));
				System.out.println("Art CT List"+artbean.getContractno());
				invloadportarraylist.add(artbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invloadportarraylist;
	}

	@Override
	public boolean getInvAddbillDetails(InvBillDetails invbill) throws SQLException {
	
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		int noofrows  = 0;
		int updtart = 0;
		boolean isInserted = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_inv_bill (ctno, artname, color, size, subs, selc, unit, qty, pcs, rate, tc, comm, invno, invdate, qshpd, qbal, amt,articleid)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			System.out.println("Insert quert" +sqlquery_saveprfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, invbill.getInvctno());
			System.out.println("getInvctno " +invbill.getInvctno());
			pst.setString(2, invbill.getInvartname());
			System.out.println("getInvartname " +invbill.getInvartname());
			pst.setString(3, invbill.getInvcolor());
			pst.setString(4, invbill.getInvsize());
			pst.setString(5, invbill.getInvsubs());
			pst.setString(6, invbill.getInvselc());
			pst.setString(7, invbill.getInvunit());
			pst.setString(8, invbill.getInvqty());
			pst.setString(9, invbill.getInvpcs());
			pst.setString(10, invbill.getInvrate());
			pst.setString(11, invbill.getInvtc());
			pst.setString(12, invbill.getInvcomm());
			pst.setString(13, invbill.getInvno());
			pst.setString(14, invbill.getInvdt());
			pst.setString(15, invbill.getInvqshpd());
			pst.setString(16, invbill.getInvqbal());
			pst.setString(17, invbill.getInvamt());
			pst.setString(18, invbill.getInvartid());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
			if(noofrows == 1){
				if(invbill.getInvctno().startsWith("L")){
					System.out.println(" Update PRF Status QTy "+noofrows);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+invbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pst1 = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pst1.setString(1, invbill.getInvqshpd());
					System.out.println("getInvqshpd " +invbill.getInvqshpd());
					pst1.setString(2, invbill.getInvqbal());
					System.out.println("getInvqbal " +invbill.getInvqbal());
					pst1.setString(3, invbill.getInvno()+" Dt"+invbill.getInvdt());
					System.out.println("INV invdetails " +invbill.getInvno()+" Dt"+invbill.getInvdt());
				
					updtart = pst1.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + updtart);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Update SRF Status QTy "+noofrows);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+invbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pst1 = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pst1.setString(1, invbill.getInvqshpd());
					System.out.println("getInvqshpd " +invbill.getInvqshpd());
					pst1.setString(2, invbill.getInvqbal());
					System.out.println("getInvqbal " +invbill.getInvqbal());
					pst1.setString(3, invbill.getInvno()+" Dt"+invbill.getInvdt());
					System.out.println("INV invdetails " +invbill.getInvno()+" Dt"+invbill.getInvdt());
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

	@Override
	public ArrayList<InvBillDetails> getInvBillDetails(String invno, String ctno,String type)
			throws SQLException {
		ArrayList<InvBillDetails> invBilllist = new ArrayList<InvBillDetails>();		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT invbillid, articleid, artname, color, size, subs, selc, unit,  qty, pcs, rate, tc, comm, ctno, invno, invdate, qshpd, qbal, amt FROM elpro.tbl_inv_bill where ctno in ("+ctno+") order by invno, artname ";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {						
				InvBillDetails invbillbean = new InvBillDetails();
				invbillbean.setInvid(rs.getString("invbillid"));
				invbillbean.setInvartid(rs.getString("articleid"));
				invbillbean.setInvartname(rs.getString("artname"));
				invbillbean.setInvcolor(rs.getString("color"));
				invbillbean.setInvsize(rs.getString("size"));
				invbillbean.setInvsubs(rs.getString("subs"));
				invbillbean.setInvselc(rs.getString("selc"));
				invbillbean.setInvqty(rs.getString("qty"));
				invbillbean.setInvunit(rs.getString("unit"));
				invbillbean.setInvpcs(rs.getString("pcs"));
				invbillbean.setInvrate(rs.getString("rate"));
				invbillbean.setInvtc(rs.getString("tc"));
				invbillbean.setInvctno(rs.getString("ctno"));
				invbillbean.setInvno(rs.getString("invno"));
				invbillbean.setInvdt(rs.getString("invdate"));
				invbillbean.setInvqshpd(rs.getString("qshpd"));
				invbillbean.setInvqbal(rs.getString("qbal"));
				invbillbean.setInvamt(rs.getString("amt"));
				System.out.println("Art CT List"+invbillbean.getInvctno());
				invBilllist.add(invbillbean);
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return invBilllist;
	}

	@Override
	public String getInvoiceNoDetails(String invtype)
			throws SQLException {
		String maxCtno= "";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, invtype, maxinvno FROM elpro.tbl_invno where invtype in ('"+invtype+"')";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {
				 maxCtno = rs.getString("maxinvno");
				/*InvoiceForm invNobean = new InvoiceForm();
				//invNobean.setInvid(rs.getString("id"));
				invNobean.setInv_type(rs.getString("invtype"));
				invNobean.setInv_invoiceno(rs.getString("maxinvno"));
				System.out.println("INV NO"+invNobean.getInv_invoiceno());*/
				
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return maxCtno;
   }

	@Override
	public boolean getInvAddbillSecondDetails(InvBillDetails invaddagainbill)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstadd2tart = null;
		int noofrows  = 0;
		int isadd2art = 0;
		boolean isInserted = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_inv_bill (ctno, artname, color, size, subs, selc, qty, unit, pcs, rate, tc, comm,invno, invdate, qshpd, qbal, amt,articleid)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			System.out.println("Insert quert" +sqlquery_saveprfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, invaddagainbill.getInvctno());
			System.out.println("getInvctno " +invaddagainbill.getInvctno());
			pst.setString(2, invaddagainbill.getInvartname());
			System.out.println("getInvartname " +invaddagainbill.getInvartname());
			pst.setString(3, invaddagainbill.getInvcolor());
			pst.setString(4, invaddagainbill.getInvsize());
			pst.setString(5, invaddagainbill.getInvsubs());
			pst.setString(6, invaddagainbill.getInvselc());
			pst.setString(7, invaddagainbill.getInvqty());
			pst.setString(8, invaddagainbill.getInvunit());
			pst.setString(9, invaddagainbill.getInvpcs());
			pst.setString(10, invaddagainbill.getInvrate());
			pst.setString(11, invaddagainbill.getInvtc());
		
			pst.setString(12, invaddagainbill.getInvcomm());
			pst.setString(13, invaddagainbill.getInvno());
			pst.setString(14, invaddagainbill.getInvdt());
			pst.setString(15, invaddagainbill.getInvqshpd());
			pst.setString(16, invaddagainbill.getInvqbal());
			pst.setString(17, invaddagainbill.getInvamt());
			pst.setString(18, invaddagainbill.getInvartid());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				if(invaddagainbill.getInvctno().startsWith("L")){
					System.out.println(" Update PRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(invaddagainbill.getInvqty()) - Float.parseFloat(invaddagainbill.getInvqbal()));
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+invaddagainbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstadd2tart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstadd2tart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstadd2tart.setString(2, invaddagainbill.getInvqbal());
					System.out.println("getInvqbal " +invaddagainbill.getInvqbal());
					pstadd2tart.setString(3, invaddagainbill.getInvno()+" Dt"+invaddagainbill.getInvdt());
					System.out.println("INV invdetails " +invaddagainbill.getInvno()+" Dt"+invaddagainbill.getInvdt());
				
					isadd2art = pstadd2tart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isadd2art);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Update SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(invaddagainbill.getInvqty()) - Float.parseFloat(invaddagainbill.getInvqbal()));
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+invaddagainbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstadd2tart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstadd2tart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstadd2tart.setString(2, invaddagainbill.getInvqbal());
					System.out.println("getInvqbal " +invaddagainbill.getInvqbal());
					pstadd2tart.setString(3, invaddagainbill.getInvno()+" Dt"+invaddagainbill.getInvdt());
					System.out.println("INV invdetails " +invaddagainbill.getInvno()+" Dt"+invaddagainbill.getInvdt());
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

	@Override
	public boolean getInvEditbillDetails(InvBillDetails inveditbill)throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstupdtart = null;
		int noofrows  = 0;
		int isupdart = 0;
		boolean isupdate = true;
		
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("UPDATE elpro.tbl_inv_bill SET rate = ? , qshpd = ? , qbal = ? , amt = ? WHERE invbillid = '"+inveditbill.getInvid()+"' ");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, inveditbill.getInvrate());
			System.out.println("getInvrate " +inveditbill.getInvrate());
			pst.setString(2, inveditbill.getInvqshpd());
			System.out.println("getInvqshpd " +inveditbill.getInvqshpd());
			pst.setString(3, inveditbill.getInvqbal());
			pst.setString(4, inveditbill.getInvamt());
			System.out.println("INV Article ID " +inveditbill.getInvid());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				if(inveditbill.getInvctno().startsWith("L")){
					System.out.println(" Update PRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(inveditbill.getInvqty()) - Float.parseFloat(inveditbill.getInvqbal()));
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+inveditbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstupdtart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstupdtart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstupdtart.setString(2, inveditbill.getInvqbal());
					System.out.println("getInvqbal " +inveditbill.getInvqbal());
					pstupdtart.setString(3, inveditbill.getInvno()+" Dt"+inveditbill.getInvdt());
					System.out.println("INV invdetails " +inveditbill.getInvno()+" Dt"+inveditbill.getInvdt());
				
					isupdart = pstupdtart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isupdart);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Update SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(inveditbill.getInvqty()) - Float.parseFloat(inveditbill.getInvqbal()));
					String qshiped = String.valueOf(qshped);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+inveditbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstupdtart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstupdtart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstupdtart.setString(2, inveditbill.getInvqbal());
					System.out.println("getInvqbal " +inveditbill.getInvqbal());
					pstupdtart.setString(3, inveditbill.getInvno()+" Dt"+inveditbill.getInvdt());
					System.out.println("INV invdetails " +inveditbill.getInvno()+" Dt"+inveditbill.getInvdt());
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
		return isupdate;	
	}

	@Override
	public boolean getInvDelbillDetails(InvBillDetails invaddagainbill)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstdelart = null;
		int noofrows  = 0;
		int isdelart  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("delete from elpro.tbl_inv_bill WHERE invbillid = '"+invaddagainbill.getInvid()+"' ");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			System.out.println(sqlquery_saveprfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
			if(noofrows == 1){
				System.out.println("CT NO "+invaddagainbill.getInvctno());
				if(invaddagainbill.getInvctno().startsWith("L")){
					System.out.println(" Revert PRF Status QTy "+noofrows);
					float qbal = (Float.parseFloat(invaddagainbill.getInvqshpd()) + (Float.parseFloat(invaddagainbill.getInvqbal())));
					float qshped = (Float.parseFloat(invaddagainbill.getInvqty()) - qbal);
					System.out.println("qshped "+qshped);
					System.out.println("qbal "+qbal);
					String qshiped = String.valueOf(qshped);
					String qbalc = String.valueOf(qbal);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET qshipped = ? , qbal = ? , invdetails = ?  WHERE prf_articleid = '"+invaddagainbill.getInvartid()+"' ");
					String sqlquery_updartqty = sql_updartqty.toString();
					System.out.println("Update quert" +sqlquery_updartqty);
					pstdelart = (PreparedStatement) con.prepareStatement(sqlquery_updartqty);
					pstdelart.setString(1, qshiped);
					System.out.println("getInvqshpd " +qshiped);
					pstdelart.setString(2, qbalc);
					System.out.println("getInvqbal " +qbalc);
					pstdelart.setString(3, "");
					System.out.println("INV invdetails " +invaddagainbill.getInvno()+" Dt"+invaddagainbill.getInvdt());
				
					isdelart = pstdelart.executeUpdate();
					System.out.println("Sucessfully Updated the record.." + isdelart);
				}else{
					//Code to Update the status of the Sample Article 
					System.out.println(" Revert SRF Status QTy "+noofrows);
					float qshped = (Float.parseFloat(invaddagainbill.getInvqshpd()) + (Float.parseFloat(invaddagainbill.getInvqbal())));
					float qbal = (Float.parseFloat(invaddagainbill.getInvqty()) - (Float.parseFloat(invaddagainbill.getInvqshpd())));
					System.out.println("qshped "+qshped);
					System.out.println("qbal "+qbal);
					String qshiped = String.valueOf(qshped);
					String qbalc = String.valueOf(qbal);
					StringBuffer sql_updartqty = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET shpd = ? , bal = ? , courierdetails = ?  WHERE srfarticleid = '"+invaddagainbill.getInvartid()+"' ");
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
	 * @see sb.elpro.dao.InvoiceDao#getBulkQtyDetails(java.lang.String)
	 */
	@Override
	public ArrayList<InvBillDetails> getInvBillTotAmtDetails(String invno) throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<InvBillDetails> totalamtarray = new ArrayList<InvBillDetails>();
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT  sum(qshpd) as qshpd , sum(pcs) as pcs, sum(amt) as totamt FROM elpro.tbl_inv_bill where invno = '"+invno+"'";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			if(rs.next()){
				InvBillDetails invbilltot = new InvBillDetails();
				 invbilltot.setInvqty(rs.getString("qshpd"));
				 invbilltot.setInvpcs(rs.getString("pcs"));
				 invbilltot.setInvamt(rs.getString("totamt"));
				 totalamtarray.add(invbilltot);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return totalamtarray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InvoiceDao#getSampleInvoiceNoDetails(java.lang.String)
	 */
	@Override
	public String getSampleInvoiceNoDetails(String saminvtype)
			throws SQLException {
		String maxsampinvno= "";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, invtype, maxinvno FROM elpro.tbl_sampleinvno where invtype in ('"+saminvtype+"')";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {
				maxsampinvno = rs.getString("maxinvno");
				/*InvoiceForm invNobean = new InvoiceForm();
				//invNobean.setInvid(rs.getString("id"));
				invNobean.setInv_type(rs.getString("invtype"));
				invNobean.setInv_invoiceno(rs.getString("maxinvno"));
				System.out.println("INV NO"+invNobean.getInv_invoiceno());*/
				
			}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 st.close();
		 rs.close();
   }	
	return maxsampinvno;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InvoiceDao#saveInvoiceForm(sb.elpro.model.InvoiceBean)
	 */
	@Override
	public boolean saveInvoiceForm(InvoiceBean invbean) throws SQLException {
		System.out.println("In Sample Invoice SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstdischrg = null;
		int noofrows  = 0;
		int rowsdischrg = 0;
		boolean isSaved =true;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_saveinvform = new StringBuffer("insert into tbl_invform (invtype, invno, invdate, exportersref, expname, taninvno, customer, consignee, notify, totalamount, otherref, buyer, bank, AWBillNo, AWBillDate, othercharges, discounts, totamt)");
			sql_saveinvform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveinvform = sql_saveinvform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveinvform);
			pst.setString(1, invbean.getInv_invoicetype());
			System.out.println("getInv_invoicetype " +invbean.getInv_invoicetype());
			pst.setString(2, invbean.getInv_invoiceno());
			System.out.println("getInv_invoiceno " +invbean.getInv_invoiceno());
			pst.setString(3, invbean.getInv_invdate());
			pst.setString(4, invbean.getInv_expref());
			pst.setString(5, invbean.getInv_exporter());
			pst.setString(6, invbean.getInv_otherref());
			pst.setString(7, invbean.getInv_customer());
			pst.setString(8, invbean.getInv_buyer());
			pst.setString(9, invbean.getInv_notify());
			pst.setString(10, "NA");
			pst.setString(11, "NA");
			pst.setString(12, "NA");
			pst.setString(13, invbean.getInv_bank());
			pst.setString(14, invbean.getInv_awbillno());
			pst.setString(15, invbean.getInv_awbilldate());
			pst.setString(16, invbean.getInv_courierchrgs());
			pst.setString(17, invbean.getInv_deduction());
			pst.setString(18, invbean.getInv_total());
			System.out.println("getInv_total " +invbean.getInv_total());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				/*
				 *Insert into the Dispatch Table
				 */
				StringBuffer sql_saveinvdispform = new StringBuffer("insert into tbl_inv_dispatchdetails (invno, invdate, ctryoforigin, loadingport, ctryofdesti, destination, dischargeport, precarriage, dimension, marks, grosswt, netwt, container, noofpackages, packno)");
				sql_saveinvdispform.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				String sqlquery_saveinvdispform = sql_saveinvdispform.toString();
				pstdischrg = (PreparedStatement) con.prepareStatement(sqlquery_saveinvdispform);
				System.out.println(" IN INV DISP SAVE IN THE ");
				pstdischrg.setString(1, invbean.getInv_invoiceno());
				System.out.println("getInv_invoiceno " +invbean.getInv_invoiceno());
				pstdischrg.setString(2, invbean.getInv_invdate());
				System.out.println("getInv_invdate " +invbean.getInv_invdate());
				pstdischrg.setString(3, invbean.getInv_ctryoforigngoods());
				pstdischrg.setString(4, invbean.getInv_loadingport());
				pstdischrg.setString(5, invbean.getInv_ctryoffinaldesti());
				pstdischrg.setString(6, invbean.getInv_finaldesti());
				pstdischrg.setString(7, invbean.getInv_dischargeport());
				pstdischrg.setString(8, invbean.getInv_precarriageby());
				pstdischrg.setString(9, invbean.getInv_dimension());
				pstdischrg.setString(10,  invbean.getInv_marksno());
				pstdischrg.setString(11, invbean.getInv_grosswt());
				pstdischrg.setString(12, invbean.getInv_netwt());
				pstdischrg.setString(13, invbean.getInv_precarriageby());
				pstdischrg.setString(14, invbean.getInv_noofpackages());
				pstdischrg.setString(15, invbean.getInv_packno());
				System.out.println("getInv_packno " +invbean.getInv_packno());
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
	 * @see sb.elpro.dao.InvoiceDao#getEditInvFormDetails(java.lang.String)
	 */
	@Override
	public List<InvoiceBean> getEditInvFormDetails(String invno)
			throws SQLException {
		List<InvoiceBean> editinvformlist = new ArrayList<InvoiceBean>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT * FROM elpro.tbl_invform form , tbl_inv_dispatchdetails dispatch where form.invno= dispatch.invno and form.invno = '"+invno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {	
				InvoiceBean editinvformbean = new InvoiceBean();
				editinvformbean.setInv_invoicetype(rs.getString("invtype"));
				editinvformbean.setInv_invoiceno(rs.getString("invno"));
				editinvformbean.setInv_invdate(DateConversion.ConverttoNormalDate(rs.getString("invdate")));
				System.out.println("DT "+editinvformbean.getInv_invdate());
				editinvformbean.setInv_expref(rs.getString("exportersref"));
				editinvformbean.setInv_exporter(rs.getString("expname"));
				editinvformbean.setInv_otherref(rs.getString("taninvno"));
				editinvformbean.setInv_customer(rs.getString("customer"));
				editinvformbean.setInv_buyer(rs.getString("consignee"));
				editinvformbean.setInv_notify(rs.getString("notify"));
				//editinvformbean.setInv_destination(rs.getString("amount"));
				//editinvformbean.setInv_endusage(rs.getString("otherref"));
				//editinvformbean.setInv_paymentterms(rs.getString("buyer"));
				editinvformbean.setInv_awbilldate(DateConversion.ConverttoNormalDate(rs.getString("AWBillDate")));
				editinvformbean.setInv_bank(rs.getString("bank"));
				editinvformbean.setInv_courierchrgs(rs.getString("othercharges"));
				editinvformbean.setInv_deduction(rs.getString("discounts"));
				editinvformbean.setInv_total(rs.getString("totamt"));
				editinvformbean.setInv_ctryoforigngoods(rs.getString("ctryoforigin"));
				editinvformbean.setInv_loadingport(rs.getString("loadingport"));
				editinvformbean.setInv_ctryoffinaldesti(rs.getString("ctryofdesti"));
				editinvformbean.setInv_finaldesti(rs.getString("destination"));
				editinvformbean.setInv_dischargeport(rs.getString("dischargeport"));
				editinvformbean.setInv_precarriageby(rs.getString("precarriage"));
				editinvformbean.setInv_dimension(rs.getString("dimension"));
				editinvformbean.setInv_marksno(rs.getString("marks"));
				editinvformbean.setInv_grosswt(rs.getString("grosswt"));
				editinvformbean.setInv_netwt(rs.getString("netwt"));
				editinvformbean.setInv_precarriageby(rs.getString("container"));
				editinvformbean.setInv_noofpackages(rs.getString("noofpackages"));
				editinvformbean.setInv_packno(rs.getString("packno"));
				
				editinvformlist.add(editinvformbean);
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
	 * @see sb.elpro.dao.InvoiceDao#updtInvFormDetails(sb.elpro.model.InvoiceBean)
	 */
	@Override
	public boolean updtInvFormDetails(InvoiceBean invbean) throws SQLException {
		System.out.println("In Invoice EDIT SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstdischrg = null;
		int noofrows  = 0;
		int rowsdischrg = 0;
		boolean isUpdtd =true;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_updtsaminvform = new StringBuffer("update tbl_invform set invtype = ? ,  invdate= ? , exportersref= ? , expname= ? , taninvno= ? , customer= ? , consignee= ? , notify= ? , amount= ? , otherref= ? , buyer= ? , bank= ? , AWBillNo= ? , AWBillDate= ? , othercharges= ? , discounts= ? , totamt = ? where invno ='"+invbean.getInv_invoiceno()+"' ");
			String sqlquery_updtsaminvform = sql_updtsaminvform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtsaminvform);
			pst.setString(1, invbean.getInv_invoicetype());
			System.out.println("getInv_invoicetype " +invbean.getInv_invoicetype());
			pst.setString(2, invbean.getInv_invdate());
			pst.setString(3, invbean.getInv_expref());
			pst.setString(4, invbean.getInv_exporter());
			pst.setString(5, invbean.getInv_otherref());
			pst.setString(6, invbean.getInv_customer());
			pst.setString(7, invbean.getInv_buyer());
			pst.setString(8, invbean.getInv_notify());
			pst.setString(9, "NA");
			pst.setString(10, "NA");
			pst.setString(11, "NA");
			pst.setString(12, invbean.getInv_bank());
			pst.setString(13, invbean.getInv_awbillno());
			pst.setString(14, invbean.getInv_awbilldate());
			pst.setString(15, invbean.getInv_courierchrgs());
			pst.setString(16, invbean.getInv_deduction());
			pst.setString(17, invbean.getInv_total());
			System.out.println("getInv_total " +invbean.getInv_total());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				/*
				 *Insert into the Dispatch Table
				 */
				StringBuffer sql_updtsaminvdispform = new StringBuffer("update tbl_inv_dispatchdetails set invdate = ?, ctryoforigin = ?, loadingport = ?, ctryofdesti = ?, destination = ?, dischargeport = ?, precarriage = ?, dimension = ?, marks = ?, grosswt = ?, netwt = ?, container = ?, noofpackages = ?, packno = ?  where invno ='"+invbean.getInv_invoiceno()+"' ");
				
				String sqlquery_sql_updtsaminvdispform = sql_updtsaminvdispform.toString();
				pstdischrg = (PreparedStatement) con.prepareStatement(sqlquery_sql_updtsaminvdispform);
				System.out.println(" IN Inv UPDT Dischrg Form ");
				pstdischrg.setString(1, invbean.getInv_invdate());
				System.out.println("getInv_invdate " +invbean.getInv_invdate());
				pstdischrg.setString(2, invbean.getInv_ctryoforigngoods());
				pstdischrg.setString(3, invbean.getInv_loadingport());
				pstdischrg.setString(4, invbean.getInv_ctryoffinaldesti());
				pstdischrg.setString(5, invbean.getInv_finaldesti());
				pstdischrg.setString(6, invbean.getInv_dischargeport());
				pstdischrg.setString(7, invbean.getInv_precarriageby());
				pstdischrg.setString(8, invbean.getInv_dimension());
				pstdischrg.setString(9,  invbean.getInv_marksno());
				pstdischrg.setString(10, invbean.getInv_grosswt());
				pstdischrg.setString(11, invbean.getInv_netwt());
				pstdischrg.setString(12, invbean.getInv_precarriageby());
				pstdischrg.setString(13, invbean.getInv_noofpackages());
				pstdischrg.setString(14, invbean.getInv_packno());
				System.out.println("geInv_packno " +invbean.getInv_packno());
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
