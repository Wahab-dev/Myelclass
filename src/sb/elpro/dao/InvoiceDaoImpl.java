/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.utility.DBConnection;

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
				String sql = "SELECT expname, expattn, expaddr, expphone, expfax, expref FROM elpro.tbl_exporter where expname like '%"+expterm+"%' order by expname";
				rs = st.executeQuery(sql);
				while(rs.next()) {	
					ExporterDetails invexporterbean = new ExporterDetails();
					invexporterbean.setExpname(rs.getString("expname"));
					invexporterbean.setExpaddr(rs.getString("expaddr"));
					invexporterbean.setExpref(rs.getString("expref"));
					invexporterbean.setExpphone(rs.getString("expphone"));
					invexporterbean.setExpfax(rs.getString("expfax"));
					invexporterbean.setExpattn(rs.getString("expattn"));
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
	public ArrayList<DestinationDetails> getInvLoadingPort()
			throws SQLException {
		ArrayList<DestinationDetails> InvloadingPortarray = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT LoadingName FROM elpro.tbl_loadingport order by LoadingName";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails Invloadingportbean = new DestinationDetails();
				Invloadingportbean.setDestination(rs.getString("LoadingName"));
				System.out.println("Result Added Successfully");
				System.out.println("DestinationName"+Invloadingportbean.getDestination());
				InvloadingPortarray.add(Invloadingportbean);
			}
		}catch(Exception e){
			System.out.println("ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return InvloadingPortarray;
	}

	@Override
	public ArrayList<DestinationDetails> getInvDestiCountry()
			throws SQLException {
		ArrayList<DestinationDetails> InvDestiCountryarray = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT CountryName FROM elpro.tbl_desticountry order by CountryName";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails InvDestiCountrybean = new DestinationDetails();
				InvDestiCountrybean.setDestinationCountry(rs.getString("CountryName"));
				System.out.println("CountryName"+InvDestiCountrybean.getDestinationCountry());
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
	public ArrayList<DestinationDetails> getInvFinalDestination()
			throws SQLException {
		ArrayList<DestinationDetails> InvFinalDestiarray = new ArrayList<DestinationDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT DestinationName FROM elpro.tbl_destinationport order by DestinationName";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails InvFinalDestibean = new DestinationDetails();
				InvFinalDestibean.setDestination(rs.getString("DestinationName"));
				System.out.println("DestinationName"+InvFinalDestibean.getDestination());
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

	@Override
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
	}

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
	public ArrayList<CustomerInvoice> getInvCustCtlist(String custid, String sortname, String sortorder) throws SQLException {
		ArrayList<CustomerInvoice> invcustctrraylist = new ArrayList<CustomerInvoice>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT Ctno, Orderdt, pono, customerid, cdd_date, add_date, destination, commission FROM elpro.tbl_prfform where customerid like '%"+custid+"%' order by "+sortname+" "+sortorder+" ";
			System.out.println("SQL + "+sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {						
				CustomerInvoice InvCustCtbean = new CustomerInvoice();
					InvCustCtbean.setCtno(rs.getString("Ctno"));
					InvCustCtbean.setOrderdt(rs.getString("Orderdt"));
					InvCustCtbean.setPono(rs.getString("pono")); //
					InvCustCtbean.setCustomerid(rs.getString("customerid"));
					InvCustCtbean.setCdd_date(rs.getString("cdd_date"));
					InvCustCtbean.setAdd_date(rs.getString("add_date"));
					InvCustCtbean.setDestination(rs.getString("destination"));
					InvCustCtbean.setCommission(rs.getString("commission"));
					
					System.out.println("Cust Name "+InvCustCtbean.getCustomerid());
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
			String sql = "SELECT CountryId, CountryName FROM elpro.tbl_desticountry where CountryName like '%"+loadctryterm+"%'order by CountryName";
			rs = st.executeQuery(sql);
			while(rs.next()) {						
				DestinationDetails InvCtrybean = new DestinationDetails();
				InvCtrybean.setDestination(rs.getString("CountryName"));
				InvCtrybean.setDestinationId(rs.getString("CountryId"));
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
			String sql = "SELECT LoadingId, LoadingName FROM elpro.tbl_loadingport where LoadingName like '%"+loadportterm+"%'order by LoadingName";
			rs = st.executeQuery(sql);
			while(rs.next()) {						
				DestinationDetails Invloadportbean = new DestinationDetails();
				Invloadportbean.setDestination(rs.getString("LoadingName"));
				Invloadportbean.setDestinationId(rs.getString("LoadingId"));
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
	public ArrayList<ArticleDetails> getInvDelContractDetails(String ctno)
			throws SQLException {
		ArrayList<ArticleDetails> invloadportarraylist = new ArrayList<ArticleDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, contractno, prfarticleid from tbl_prf_article where contractno in ("+ctno+") order by contractno";
			System.out.println((sql));
			rs = st.executeQuery(sql);
			System.out.println((sql));
			while(rs.next()) {						
				ArticleDetails artbean = new ArticleDetails();
				artbean.setArticleid(rs.getString("articleid"));
				artbean.setArticlename(rs.getString("articlename"));
				artbean.setSize(rs.getString("size"));
				artbean.setSubstance(rs.getString("substance"));
				artbean.setSelection(rs.getString("selection"));
				artbean.setSelp(rs.getString("selectionpercent"));
				artbean.setColor(rs.getString("color"));
				artbean.setQuantity(rs.getString("quantity"));
				artbean.setUnit(rs.getString("unit"));
				artbean.setRate(rs.getString("rate"));
				artbean.setTc(rs.getString("tc"));
				artbean.setContractno(rs.getString("contractno"));
				artbean.setPrfarticleid(rs.getString("prfarticleid"));
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
	public int getInvAddbillDetails(InvBillDetails invbill)
			throws SQLException {
	
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_inv_bill (ctno, artname, color, size, subs, selc, qty, pcs, rate, tc, comm,invno, invdate, qshpd, qbal, amt,articleid)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			
			pst.setString(7, invbill.getInvqty());
			pst.setString(8, invbill.getInvpcs());
			pst.setString(9, invbill.getInvrate());
			pst.setString(10, invbill.getInvtc());
			
			pst.setString(11, invbill.getInvcomm());
			pst.setString(12, invbill.getInvno());
			pst.setString(13, invbill.getInvdate());
			pst.setString(14, invbill.getInvqshpd());
			pst.setString(15, invbill.getInvqbal());
			pst.setString(16, invbill.getInvamt());
			pst.setString(17, invbill.getInvartid());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Customer Name ERROR RESULT");
	}finally{
		 con.close() ;
		 pst.close();
   }	
	return noofrows;
	}

	@Override
	public ArrayList<InvBillDetails> getInvBillDetails(String invno)
			throws SQLException {
		ArrayList<InvBillDetails> invBilllist = new ArrayList<InvBillDetails>();		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT invbillid, articleid, artname, color, size, subs, selc, qty, pcs, rate, tc, comm, ctno, invno, invdate, qshpd, qbal, amt FROM elpro.tbl_inv_bill where invno in ("+invno+") order by artname";
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
				//invbillbean.setUnit(rs.getString("pcs"));
				invbillbean.setInvrate(rs.getString("rate"));
				invbillbean.setInvtc(rs.getString("tc"));
				invbillbean.setInvctno(rs.getString("ctno"));
				invbillbean.setInvno(rs.getString("invno"));
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
	

}
