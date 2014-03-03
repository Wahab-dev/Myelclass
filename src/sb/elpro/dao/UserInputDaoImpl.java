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
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class UserInputDaoImpl implements UserInputDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getTanneryList()
	 */
	@Override
	public ArrayList<TanneryDetails> getTanneryList() throws SQLException {
		ArrayList<TanneryDetails> tanarraylist = new ArrayList<TanneryDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT tanid, tanname, tanaddr, tanattn, tanphone, tanfax, tanshform  FROM elpro.tbl_tannery order by tanname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				TanneryDetails tanbean = new TanneryDetails();
				tanbean.setTanneryAddress(rs.getString("tanaddr"));
				tanbean.setTanneryAttention(rs.getString("tanattn"));
				tanbean.setTanneryFax(rs.getString("tanfax"));
				tanbean.setTanneryName(rs.getString("tanname"));
				tanbean.setTanneryContactNo(rs.getString("tanphone"));
				tanbean.setTanneryShortForm(rs.getString("tanshform"));
				tanbean.setTanneryId(rs.getString("tanid"));
				System.out.println("Tan name "+tanbean.getTanneryName());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addTanneryList()
	 */
	@Override
	public boolean addTanneryList(TanneryDetails addtannerybean) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addtannery= new StringBuffer("insert into tbl_tannery ( tanname, tanaddr, tanattn, tanphone, tanfax,tanshform)");
			sql_addtannery.append("values (?,?,?,?,?,?)");
			String sqlquery_addtannery = sql_addtannery.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addtannery);
			pst.setString(1, addtannerybean.getTanneryName());
			System.out.println("getTanneryName " +addtannerybean.getTanneryName());
			pst.setString(2, addtannerybean.getTanneryAddress());
			System.out.println("getTanneryAddress " +addtannerybean.getTanneryAddress());
			pst.setString(3, addtannerybean.getTanneryAttention());
			pst.setString(4, addtannerybean.getTanneryContactNo());
			pst.setString(5, addtannerybean.getTanneryFax());
			pst.setString(6, addtannerybean.getTanneryShortForm());
			System.out.println("getTanneryShortForm " +addtannerybean.getTanneryShortForm());
			noofrows = pst.executeUpdate();
			System.out.println(" IN TAN ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editTanneryList(sb.elpro.model.TanneryDetails)
	 */
	@Override
	public boolean editTanneryList(TanneryDetails edittannerydetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updttan = new StringBuffer("UPDATE elpro.tbl_tannery SET tanname = ? , tanaddr = ? , tanattn = ? , tanphone = ? , tanfax = ? , tanshform = ?  WHERE tanid = '"+edittannerydetail.getTanneryId()+"' ");
			String sqlquery_updttan  = sql_updttan.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updttan);
			pst.setString(1, edittannerydetail.getTanneryName());
			System.out.println("getTanneryName " +edittannerydetail.getTanneryName());
			pst.setString(2, edittannerydetail.getTanneryAddress());
			System.out.println("getTanneryAddress " +edittannerydetail.getTanneryAddress());
			pst.setString(3, edittannerydetail.getTanneryAttention());
			pst.setString(4, edittannerydetail.getTanneryContactNo());
			pst.setString(5, edittannerydetail.getTanneryFax());
			pst.setString(6, edittannerydetail.getTanneryShortForm());
			System.out.println(" getTanneryID"+edittannerydetail.getTanneryId());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delTanneryList(sb.elpro.model.TanneryDetails)
	 */
	@Override
	public boolean delTanneryList(TanneryDetails deltannerydetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_deltandetails = new StringBuffer("delete from elpro.tbl_tannery WHERE tanid = '"+deltannerydetail.getTanneryId()+"' ");
			String sqlquery_deltandetails = sql_deltandetails.toString();
			System.out.println(sqlquery_deltandetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_deltandetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getCustomerList()
	 */
	@Override
	public ArrayList<CustomerDetails> getCustomerList() throws SQLException {
		ArrayList<CustomerDetails> custarraylist = new ArrayList<CustomerDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT custid, custname, custaddr, custattn, custphone, custfax, shortform FROM elpro.tbl_customer order by custname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				CustomerDetails custbean = new CustomerDetails();
				custbean.setCustomerAddress(rs.getString("custaddr"));
				custbean.setCustomerAttention(rs.getString("custattn"));
				custbean.setCustomerFax(rs.getString("custfax"));
				custbean.setCustomerName(rs.getString("custname"));
				custbean.setCustomerTelephone(rs.getString("custphone"));
				custbean.setCustomerShortForm(rs.getString("shortform"));
				custbean.setCustomerId(rs.getString("custid"));
				System.out.println("Tan name "+custbean.getCustomerName());
				custarraylist.add(custbean);
			}
			System.out.println("Cust Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Cust Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return custarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addCustomerList(sb.elpro.model.CustomerDetails)
	 */
	@Override
	public boolean addCustomerList(CustomerDetails addcustbean)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addcust= new StringBuffer("insert into tbl_customer ( custname, custaddr, custattn, custphone, custfax, shortform)");
			sql_addcust.append("values (?,?,?,?,?,?)");
			String sqlquery_addcust = sql_addcust.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addcust);
			pst.setString(1, addcustbean.getCustomerName());
			System.out.println("getCustomerName " +addcustbean.getCustomerName());
			pst.setString(2, addcustbean.getCustomerAddress());
			System.out.println("getCustomerAddress " +addcustbean.getCustomerAddress());
			pst.setString(3, addcustbean.getCustomerAttention());
			pst.setString(4, addcustbean.getCustomerTelephone());
			pst.setString(5, addcustbean.getCustomerFax());
			pst.setString(6, addcustbean.getCustomerShortForm());
			System.out.println("getCustomerShortForm " +addcustbean.getCustomerShortForm());
			noofrows = pst.executeUpdate();
			System.out.println(" IN Cust ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editCustomerList(sb.elpro.model.CustomerDetails)
	 */
	@Override
	public boolean editCustomerList(CustomerDetails editcustdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updttan = new StringBuffer("UPDATE elpro.tbl_customer SET custname = ? , custaddr = ? , custattn = ? , custphone = ? , custfax = ? , shortform = ?  WHERE custid	 = '"+editcustdetail.getCustomerId()+"' ");
			String sqlquery_updttan  = sql_updttan.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updttan);
			pst.setString(1, editcustdetail.getCustomerName());
			System.out.println("getCustomerName " +editcustdetail.getCustomerName());
			pst.setString(2, editcustdetail.getCustomerAddress());
			System.out.println("getCustomerAddress " +editcustdetail.getCustomerAddress());
			pst.setString(3, editcustdetail.getCustomerAttention());
			pst.setString(4, editcustdetail.getCustomerTelephone());
			pst.setString(5, editcustdetail.getCustomerFax());
			pst.setString(6, editcustdetail.getCustomerShortForm());
			System.out.println(" getCustomerId"+editcustdetail.getCustomerId());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delCustomerList(sb.elpro.model.CustomerDetails)
	 */
	@Override
	public boolean delCustomerList(CustomerDetails delcustdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delcustdetails = new StringBuffer("delete from elpro.tbl_customer WHERE custid = '"+delcustdetail.getCustomerId()+"' ");
			String sqlquery_delcustdetails = sql_delcustdetails.toString();
			System.out.println(sqlquery_delcustdetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delcustdetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getConsigneeList()
	 */
	@Override
	public ArrayList<ConsigneeDetails> getConsigneeList() throws SQLException {
		ArrayList<ConsigneeDetails> tanarraylist = new ArrayList<ConsigneeDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT consigid, consigname, consigattn, consigaddr, consigphone, consigfax, shortform FROM elpro.tbl_consignee order by consigname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ConsigneeDetails consigbean = new ConsigneeDetails();
				consigbean.setConsigneeAddress(rs.getString("consigaddr"));
				consigbean.setConsigneeAttention(rs.getString("consigattn"));
				consigbean.setConsigneefax(rs.getString("consigfax"));
				consigbean.setConsigneeName(rs.getString("consigname"));
				consigbean.setConsigneeContactNo(rs.getString("consigphone"));
				consigbean.setConsigneeShortForm(rs.getString("shortform"));
				consigbean.setConsigneeId(rs.getString("consigid"));
				System.out.println("consigname "+consigbean.getConsigneeName());
				tanarraylist.add(consigbean);
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addConsigneeList(sb.elpro.model.ConsigneeDetails)
	 */
	@Override
	public boolean addConsigneeList(ConsigneeDetails addconsigdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addcust= new StringBuffer("insert into tbl_consignee ( consigname, consigaddr, consigattn, consigphone, consigfax, shortform)");
			sql_addcust.append("values (?,?,?,?,?,?)");
			String sqlquery_addcust = sql_addcust.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addcust);
			pst.setString(1, addconsigdetail.getConsigneeName());
			System.out.println("ConsigneeName " +addconsigdetail.getConsigneeName());
			pst.setString(2, addconsigdetail.getConsigneeAddress());
			System.out.println("getConsigneeAddress " +addconsigdetail.getConsigneeAddress());
			pst.setString(3, addconsigdetail.getConsigneeAttention());
			pst.setString(4, addconsigdetail.getConsigneeContactNo());
			pst.setString(5, addconsigdetail.getConsigneefax());
			pst.setString(6, addconsigdetail.getConsigneeShortForm());
			System.out.println("getConsigneeShortForm " +addconsigdetail.getConsigneeShortForm());
			noofrows = pst.executeUpdate();
			System.out.println(" IN Cust ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editConsigList(sb.elpro.model.ConsigneeDetails)
	 */
	@Override
	public boolean editConsigList(ConsigneeDetails editconsigdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updttan = new StringBuffer("UPDATE elpro.tbl_consignee SET consigname = ? , consigaddr = ? , consigattn = ? , consigphone = ? , consigfax = ? , shortform = ?  WHERE consigid = '"+editconsigdetail.getConsigneeId()+"' ");
			String sqlquery_updttan  = sql_updttan.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updttan);
			pst.setString(1, editconsigdetail.getConsigneeName());
			System.out.println("getConsigneeName " +editconsigdetail.getConsigneeName());
			pst.setString(2, editconsigdetail.getConsigneeAddress());
			System.out.println("getConsigneeAddress " +editconsigdetail.getConsigneeAddress());
			pst.setString(3, editconsigdetail.getConsigneeAttention());
			pst.setString(4, editconsigdetail.getConsigneeContactNo());
			pst.setString(5, editconsigdetail.getConsigneefax());
			pst.setString(6, editconsigdetail.getConsigneeShortForm());
			System.out.println(" getCustomerId"+editconsigdetail.getCustomerId());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delConsigList(sb.elpro.model.ConsigneeDetails)
	 */
	@Override
	public boolean delConsigList(ConsigneeDetails delconsigdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delconsigdetails = new StringBuffer("delete from elpro.tbl_consignee WHERE consigid = '"+delconsigdetail.getConsigneeId()+"' ");
			String sqlquery_delconsigdetails = sql_delconsigdetails.toString();
			System.out.println(sqlquery_delconsigdetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delconsigdetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getNotifyList()
	 */
	@Override
	public ArrayList<NotifyConsigneeDetails> getNotifyList()
			throws SQLException {
		ArrayList<NotifyConsigneeDetails> notifylist = new ArrayList<NotifyConsigneeDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT notifyid, notifyname, notifyattn, notifyaddr, notifyphone, notifyfax, shortform FROM elpro.tbl_notify order by notifyname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				NotifyConsigneeDetails notifyconsigbean = new NotifyConsigneeDetails();
				notifyconsigbean.setNotifyConsigneeAddress(rs.getString("notifyaddr"));
				notifyconsigbean.setNotifyConsigneeAttention(rs.getString("notifyattn"));
				notifyconsigbean.setNotifyConsigneefax(rs.getString("notifyfax"));
				notifyconsigbean.setNotifyConsigneeName(rs.getString("notifyname"));
				notifyconsigbean.setNotifyConsigneeContactNo(rs.getString("notifyphone"));
				notifyconsigbean.setNotifyConsigneeShortForm(rs.getString("shortform"));
				notifyconsigbean.setNotifyConsigneeId(rs.getString("notifyid"));
				System.out.println("getNotifyConsigneeName "+notifyconsigbean.getNotifyConsigneeName());
				notifylist.add(notifyconsigbean);
			}
			System.out.println("getNotifyConsigneeName Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("getNotifyConsigneeName Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return notifylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addNotifyList(sb.elpro.model.NotifyConsigneeDetails)
	 */
	@Override
	public boolean addNotifyList(NotifyConsigneeDetails addnotifydetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addnotify= new StringBuffer("insert into tbl_notify ( notifyname, notifyaddr, notifyattn, notifyphone, notifyfax, shortform)");
			sql_addnotify.append("values (?,?,?,?,?,?)");
			String sqlquery_addnotify = sql_addnotify.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addnotify);
			pst.setString(1, addnotifydetail.getNotifyConsigneeName());
			System.out.println("ConsigneeName " +addnotifydetail.getNotifyConsigneeName());
			pst.setString(2, addnotifydetail.getNotifyConsigneeAddress());
			System.out.println("getConsigneeAddress " +addnotifydetail.getNotifyConsigneeAddress());
			pst.setString(3, addnotifydetail.getNotifyConsigneeAttention());
			pst.setString(4, addnotifydetail.getNotifyConsigneeContactNo());
			pst.setString(5, addnotifydetail.getNotifyConsigneefax());
			pst.setString(6, addnotifydetail.getNotifyConsigneeShortForm());
			System.out.println("addnotifydetail " +addnotifydetail.getNotifyConsigneeShortForm());
			noofrows = pst.executeUpdate();
			System.out.println(" IN notify ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editNotifyList(sb.elpro.model.NotifyConsigneeDetails)
	 */
	@Override
	public boolean editNotifyList(NotifyConsigneeDetails editnotifydetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updttan = new StringBuffer("UPDATE elpro.tbl_notify SET notifyname = ? , notifyaddr = ? , notifyattn = ? , notifyphone = ? , notifyfax = ? , shortform = ?  WHERE notifyid = '"+editnotifydetail.getNotifyConsigneeId()+"' ");
			String sqlquery_updttan  = sql_updttan.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updttan);
			pst.setString(1, editnotifydetail.getNotifyConsigneeName());
			System.out.println("getConsigneeName " +editnotifydetail.getNotifyConsigneeName());
			pst.setString(2, editnotifydetail.getNotifyConsigneeAddress());
			System.out.println("getConsigneeAddress " +editnotifydetail.getNotifyConsigneeAddress());
			pst.setString(3, editnotifydetail.getNotifyConsigneeAttention());
			pst.setString(4, editnotifydetail.getNotifyConsigneeContactNo());
			pst.setString(5, editnotifydetail.getNotifyConsigneefax());
			pst.setString(6, editnotifydetail.getNotifyConsigneeShortForm());
			System.out.println(" getnotifyomerId"+editnotifydetail.getNotifyConsigneeId());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delNotifyList(sb.elpro.model.NotifyConsigneeDetails)
	 */
	@Override
	public boolean delNotifyList(NotifyConsigneeDetails delnotifydetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delnotifydetails = new StringBuffer("delete from elpro.tbl_notify WHERE notifyid = '"+delnotifydetail.getNotifyConsigneeId()+"' ");
			String sqlquery_delnotifydetails = sql_delnotifydetails.toString();
			System.out.println(sqlquery_delnotifydetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delnotifydetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getBankList()
	 */
	@Override
	public ArrayList<BankDetails> getBankList() throws SQLException {
		ArrayList<BankDetails> banklist = new ArrayList<BankDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT bankid, bankname, bankbranch, bankaddr, bankphone, bankfax, swiftcode, shortform, Acctno FROM elpro.tbl_bank order by bankname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				BankDetails bankbean = new BankDetails();
				bankbean.setBankId(rs.getString("bankid"));
				bankbean.setBankName(rs.getString("bankname"));
				bankbean.setBankAddress(rs.getString("bankaddr"));
				bankbean.setBankBranch(rs.getString("bankbranch"));
				bankbean.setBankSwiftCode(rs.getString("swiftcode"));
				bankbean.setBankContactNo(rs.getString("bankphone"));
				bankbean.setBankFax(rs.getString("bankfax"));
				System.out.println("bankname "+bankbean.getBankName());
				banklist.add(bankbean);
			}
			System.out.println("getNotifyConsigneeName Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("getNotifyConsigneeName Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return banklist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addBankList(sb.elpro.model.BankDetails)
	 */
	@Override
	public boolean addBankList(BankDetails addbankdetail) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addtannery= new StringBuffer("insert into tbl_bank ( bankname, bankbranch, bankaddr, bankphone,bankfax, swiftcode)");
			sql_addtannery.append("values (?,?,?,?,?,?)");
			String sqlquery_addtannery = sql_addtannery.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addtannery);
			pst.setString(1, addbankdetail.getBankName());
			System.out.println("getBankName " +addbankdetail.getBankName());
			pst.setString(2, addbankdetail.getBankBranch());
			pst.setString(3, addbankdetail.getBankAddress());
			pst.setString(4, addbankdetail.getBankContactNo());
			pst.setString(5, addbankdetail.getBankFax());
			pst.setString(6, addbankdetail.getBankSwiftCode());
			System.out.println("getBankSwiftCode " +addbankdetail.getBankSwiftCode());
			noofrows = pst.executeUpdate();
			System.out.println(" IN TAN ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editBankList(sb.elpro.model.BankDetails)
	 */
	@Override
	public boolean editBankList(BankDetails editbankdetail) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updtbank = new StringBuffer("UPDATE elpro.tbl_bank SET bankname = ? , bankbranch = ? , bankaddr = ? , bankphone = ? , bankfax = ? , swiftcode = ?  WHERE bankid = '"+editbankdetail.getBankId()+"' ");
			String sqlquery_updtbank  = sql_updtbank.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtbank);
			pst.setString(1, editbankdetail.getBankName());
			System.out.println("getBankName " +editbankdetail.getBankName());
			pst.setString(2, editbankdetail.getBankBranch());
			System.out.println("getBankBranch " +editbankdetail.getBankBranch());
			pst.setString(3, editbankdetail.getBankAddress());
			pst.setString(4, editbankdetail.getBankContactNo());
			pst.setString(5, editbankdetail.getBankFax());
			pst.setString(6, editbankdetail.getBankSwiftCode());
			System.out.println(" getBankSwiftCode"+editbankdetail.getBankSwiftCode());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delBankList(sb.elpro.model.BankDetails)
	 */
	@Override
	public boolean delBankList(BankDetails delbankdetail) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delbankdetails = new StringBuffer("delete from elpro.tbl_bank WHERE bankid = '"+delbankdetail.getBankId()+"' ");
			String sqlquery_delbankdetails = sql_delbankdetails.toString();
			System.out.println(sqlquery_delbankdetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delbankdetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getArticleList()
	 */
	@Override
	public ArrayList<ArticleDetails> getArticleList() throws SQLException {
		ArrayList<ArticleDetails> artarraylist = new ArrayList<ArticleDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articlename, articleshortform, size, substance, rate, tc  FROM elpro.tbl_article order by articlename";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ArticleDetails artbean = new ArticleDetails();
				artbean.setArticleid(rs.getString("articleid"));
				artbean.setArticletype(rs.getString("articletype"));
				artbean.setArticlename(rs.getString("articlename"));
				artbean.setArticleshortform(rs.getString("articleshortform"));
				artbean.setSize(rs.getString("size"));
				artbean.setSubstance(rs.getString("substance"));
				artbean.setRate(rs.getString("rate"));
				artbean.setTc(rs.getString("tc"));
				System.out.println("articlename name "+artbean.getArticlename());
				artarraylist.add(artbean);
			}
			System.out.println("articlename Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("articlename Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return artarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addArticleList(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean addArticleList(ArticleDetails addarticledetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addarticle= new StringBuffer("insert into tbl_article ( articletype, articlename, articleshortform, size, substance, rate, tc )");
			sql_addarticle.append("values (?,?,?,?,?,?,?)");
			String sqlquery_addarticle = sql_addarticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addarticle);
			pst.setString(1, addarticledetail.getArticletype());
			System.out.println("Articletype " +addarticledetail.getArticletype());
			pst.setString(2, addarticledetail.getArticlename());
			pst.setString(3, addarticledetail.getArticleshortform());
			pst.setString(4, addarticledetail.getSize());
			pst.setString(5, addarticledetail.getSubstance());
			pst.setString(6, addarticledetail.getRate());
			pst.setString(7, addarticledetail.getTc());
			System.out.println("getArticlename " +addarticledetail.getArticlename());
			noofrows = pst.executeUpdate();
			System.out.println(" IN articlename ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editArticleList(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean editArticleList(ArticleDetails editarticledetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updtarticle = new StringBuffer("UPDATE elpro.tbl_article SET articletype = ? , articlename = ? , articleshortform = ? , size = ? , substance = ? , rate = ? , tc = ?  WHERE articleid = '"+editarticledetail.getArticleid()+"' ");
			String sqlquery_updtarticle  = sql_updtarticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtarticle);
			pst.setString(1, editarticledetail.getArticletype());
			System.out.println("getArticletype " +editarticledetail.getArticletype());
			pst.setString(2, editarticledetail.getArticlename());
			System.out.println("getArticlename " +editarticledetail.getArticlename());
			pst.setString(3, editarticledetail.getArticleshortform());
			pst.setString(4, editarticledetail.getSize());
			pst.setString(5, editarticledetail.getSubstance());
			pst.setString(6, editarticledetail.getRate());
			pst.setString(7, editarticledetail.getTc());
			System.out.println(" getRate"+editarticledetail.getRate());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delArticleList(sb.elpro.model.ArticleDetails)
	 */
	@Override
	public boolean delArticleList(ArticleDetails delarticledetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delarticledetails = new StringBuffer("delete from elpro.tbl_article WHERE articleid = '"+delarticledetail.getArticleid()+"' ");
			String sqlquery_delarticledetails = sql_delarticledetails.toString();
			System.out.println(sqlquery_delarticledetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delarticledetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#getCommList()
	 */
	@Override
	public ArrayList<CommissionDetails> getCommList() throws SQLException {
		ArrayList<CommissionDetails> commarraylist = new ArrayList<CommissionDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT commid, commname, commagent, commplace, commtype, agenttype  FROM elpro.tbl_commission order by commname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				CommissionDetails commbean = new CommissionDetails();
				commbean.setCommid(rs.getString("commid"));
				commbean.setCommname(rs.getString("commname"));
				commbean.setCommagent(rs.getString("commagent"));
				commbean.setCommplace(rs.getString("commplace"));
				commbean.setCommtype(rs.getString("commtype"));
				commbean.setAgenttype(rs.getString("agenttype"));
				System.out.println("commname "+commbean.getCommname());
				commarraylist.add(commbean);
			}
			System.out.println("articlename Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("articlename Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return commarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#addCommList(sb.elpro.model.CommissionDetails)
	 */
	@Override
	public boolean addCommList(CommissionDetails addcommdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_addcust= new StringBuffer("insert into tbl_commission ( commid, commname, commagent, commplace, commtype, agenttype)");
			sql_addcust.append("values (?,?,?,?,?,?)");
			String sqlquery_addcust = sql_addcust.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_addcust);
			pst.setString(1, addcommdetail.getCommid());
			System.out.println("getCommid " +addcommdetail.getCommid());
			pst.setString(2, addcommdetail.getCommname());
			System.out.println("getCommname " +addcommdetail.getCommname());
			pst.setString(3, addcommdetail.getCommagent());
			pst.setString(4, addcommdetail.getCommplace());
			pst.setString(5, addcommdetail.getCommtype());
			pst.setString(6, addcommdetail.getAgenttype());
			System.out.println("getCustomerShortForm " +addcommdetail.getAgenttype());
			noofrows = pst.executeUpdate();
			System.out.println(" IN Comm ADD "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isadded;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#editCommList(sb.elpro.model.CommissionDetails)
	 */
	@Override
	public boolean editCommList(CommissionDetails editcommdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updtcomm = new StringBuffer("UPDATE elpro.tbl_commission SET commname = ? , commagent = ? , commplace = ? , commtype = ? , agenttype = ?  WHERE commid = '"+editcommdetail.getCommid()+"' ");
			String sqlquery_updtcomm  = sql_updtcomm.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtcomm);
			pst.setString(1, editcommdetail.getCommname());
			System.out.println("getCommname " +editcommdetail.getAgenttype());
			pst.setString(2, editcommdetail.getCommagent());
			System.out.println("getCommagent " +editcommdetail.getCommagent());
			pst.setString(3, editcommdetail.getCommplace());
			pst.setString(4, editcommdetail.getCommtype());
			pst.setString(5, editcommdetail.getAgenttype());
			System.out.println(" getAgenttype"+editcommdetail.getAgenttype());
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.UserInputDao#delCommList(sb.elpro.model.CommissionDetails)
	 */
	@Override
	public boolean delCommList(CommissionDetails delcommdetail)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delcommdetails = new StringBuffer("delete from elpro.tbl_commission WHERE commid = '"+delcommdetail.getCommid()+"' ");
			String sqlquery_delcommdetails = sql_delcommdetails.toString();
			System.out.println(sqlquery_delcommdetails);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delcommdetails);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isdel;
	}
}
