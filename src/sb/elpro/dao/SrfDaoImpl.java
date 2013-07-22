package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import sb.elpro.action.SrfArticle;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.EndUsageDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.utility.DBConnection;

public class SrfDaoImpl implements SrfDao {
	@Override
	public int getSampleno() throws SQLException {
		return 0;
	}

	@Override
	public ArrayList<HandledByDetails> getsrfhandledby(String term) throws SQLException {
		ArrayList<HandledByDetails> handledbyarray = new ArrayList<HandledByDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT name, type FROM elpro.tbl_handledby where name like '%"+term+"%'  order by name";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				HandledByDetails handledbybean = new HandledByDetails();
				handledbybean.setLabel(rs.getString("name"));
				handledbybean.setSrf_handledbytype(rs.getString("type"));
				System.out.println("handledby  name "+handledbybean.getLabel());
				handledbyarray.add(handledbybean);
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return handledbyarray;
	}

	@Override
	public ArrayList<EndUsageDetails> getsrfendusage(String term) throws SQLException {
		ArrayList<EndUsageDetails> endusagearray = new ArrayList<EndUsageDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT endusagename, endusagetype FROM elpro.tbl_srfendusage where endusagename like '%"+term+"%'   order by endusagename";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				EndUsageDetails endusagebean = new EndUsageDetails();
				endusagebean.setLabel(rs.getString("endusagename"));
				endusagebean.setSrf_endusagetype(rs.getString("endusagetype"));
				System.out.println("endusage name "+endusagebean.getLabel());
				endusagearray.add(endusagebean);
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close();
			 st.close();
			 rs.close();
	   }			
		return endusagearray;
	}

	@Override
	public ArrayList<TanneryDetails> getTannery(String term) throws SQLException {
		ArrayList<TanneryDetails> tanarraylist = new ArrayList<TanneryDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT tanid, tanname, tanaddr, tanattn, tanphone, tanfax  FROM elpro.tbl_tannery where tanname like '%"+term+"%' order by tanname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				TanneryDetails tanbean = new TanneryDetails();
				tanbean.setTanneryAddress(rs.getString("tanaddr"));
				tanbean.setTanneryAttention(rs.getString("tanattn"));
				tanbean.setTanneryFax(rs.getString("tanfax"));
				tanbean.setTanneryId(rs.getString("tanid"));
				tanbean.setLabel(rs.getString("tanname"));
				tanbean.setTanneryContactNo(rs.getString("tanphone"));
				System.out.println("Tan name "+tanbean.getLabel());
				tanarraylist.add(tanbean);
			}
			System.out.println("Tannery Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Tannery Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return tanarraylist;
	}

	@Override
	public ArrayList<CustomerDetails> getCustomer() throws SQLException {
		ArrayList<CustomerDetails> custrraylist = new ArrayList<CustomerDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{	con = DBConnection.getConnection();
		st = (Statement) con.createStatement();
		String sql = "SELECT custid, custname, custaddr, custattn, custphone, custfax, agentid, shortform FROM elpro.tbl_customer order by custname";
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
			custrraylist.add(custbean);
			}
		System.out.println("Customer Name Result Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Customer Name ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return custrraylist;
	}

	@Override
	public List<AutoComplete> getDestination(String term) throws SQLException {
		List<AutoComplete> destarraylist = new ArrayList<AutoComplete>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT shortform, destname, destcountry FROM elpro.tbl_destination where destname like '%"+term+"%' order by destname";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				//destarraylist.add(rs.getString("destname"));
				AutoComplete destbean = new AutoComplete();
				destbean.setLabel(rs.getString("destname"));	
				destbean.setValue(rs.getString("destcountry"));
				destbean.setShform(rs.getString("shortform"));
				//System.out.println("dest name "+destbean.getLabel());
				destarraylist.add(destbean);
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
		return destarraylist;
	}

	@Override
	public ArrayList<PaymentDetails> getPayment(String term) throws SQLException {
		ArrayList<PaymentDetails> payarraylist = new ArrayList<PaymentDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT payid, payname FROM tbl_payment where payname like '%"+term+"%' order by payname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				PaymentDetails paybean = new PaymentDetails();
				paybean.setLabel(rs.getString("payname"));
				paybean.setPaymentId(rs.getString("payid"));
				System.out.println("Payment name "+paybean.getPayment());
				payarraylist.add(paybean);
				}
			System.out.println("payname Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("payname ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return payarraylist;
	}

	@Override
	public ArrayList<SrfArticle> getSrfArticleDetails(String sno)
			throws SQLException {
		ArrayList<SrfArticle> articlearray = new ArrayList<SrfArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT Article, Color, Size, Substance, Selection, Selectionp, Quantity, Unit, pieces, Rate, Tc, ColorMatching, TapeTest, CrockingWet, CrockingDry, Fourfold, KeyTest, SampleNo, Status, CourierDetails, Srf_ArticleID, FeedBackDetails, ArticleID from tbl_srf_article where SampleNo = '"+sno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				SrfArticle artbean = new SrfArticle();
				artbean.setArticleid(rs.getString("ArticleID"));
				artbean.setSrf_articleid(rs.getString("Srf_ArticleID"));
				artbean.setSrf_articlename(rs.getString("Article"));
				artbean.setSrf_color(rs.getString("Color"));
				artbean.setSrf_size(rs.getString("Size"));
				artbean.setSrf_substance(rs.getString("Substance"));
				artbean.setSrf_selection(rs.getString("Selection"));
				artbean.setSrf_selectionp(rs.getString("Selectionp"));
				artbean.setSrf_quantity(rs.getString("Quantity"));
				artbean.setSrf_price(rs.getString("Rate"));
				artbean.setSrf_tc(rs.getString("Tc"));
				articlearray.add(artbean);
			}
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
		}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		}	
		return articlearray;	

	}
	
	
}