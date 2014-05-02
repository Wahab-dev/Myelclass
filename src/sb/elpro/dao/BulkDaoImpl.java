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

import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class BulkDaoImpl implements BulkDao {

	@Override
	public ArrayList<BulkArticle> getBulkDetailList(String sidx, String sord, String rows, String pag)
			throws SQLException {
		ArrayList<BulkArticle> bulkarray = new ArrayList<BulkArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	
		try{	
			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();// limit "+pag+", "+rows+" 
			String sql = "SELECT distinct article.prfarticleid, form.agent, form.Ctno, Orderdt, pono, exporterid, tanneryid, customerid, cdd_date, add_date, destination, terms, payment, commission, splcdn, inspcdn, consigneeid, form.notifyid,  form.bankid,  pojw, article.articleid, articletype, articleshfrom, articlename, color, size, substance, selection, selectionpercent, quantity , unit,pcs, rate, tc, article.prfarticleid, user, stats.prf_articleid, status, qshipped, qbal, invdetails, reps,  comments,  feddback, stats.contractno, rdd_date, tan.tanshform, cust.shortform as custshform,consig.shortform as consigshform ,notify.shortform as notifyshform ,bank.shortform as bankshform FROM  elpro.tbl_prf_article article left outer join elpro.tbl_prfarticle_status stats on article.prfarticleid = stats.prf_articleid left outer join elpro.tbl_prfform form on form.Ctno = article.contractno left outer join elpro.tbl_tannery tan on  tan.tanid = form.tanneryid left outer join elpro.tbl_customer cust on  cust.custid = form.customerid left outer join elpro.tbl_consignee consig on  consig.consigid = form.consigneeid left outer join elpro.tbl_notify notify on  notify.notifyid = form.notifyid left outer join elpro.tbl_bank bank on  bank.bankid = form.bankid order by form.Ctno desc, articletype asc, articlename asc, color asc ";
			System.out.println(sql);
			System.out.println(" Rows "+rows);
			System.out.println(" Page "+pag);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			BulkArticle bulkbean = new BulkArticle();
				bulkbean.setCtno(rs.getString("Ctno"));
				bulkbean.setAgent(rs.getString("agent"));
				bulkbean.setOrderdt(DateConversion.ConverttoNormalDate(rs.getString("Orderdt")));
				bulkbean.setPono(rs.getString("pono"));
				bulkbean.setTanneryid(rs.getString("tan.tanshform"));
				bulkbean.setExporterid(rs.getString("tan.tanshform"));
				bulkbean.setCustomerid(rs.getString("custshform"));
				bulkbean.setCdd_date(DateConversion.ConverttoNormalDate(rs.getString("cdd_date")));
				bulkbean.setAdd_date(DateConversion.ConverttoNormalDate(rs.getString("add_date")));
				bulkbean.setDestination(rs.getString("destination"));
				bulkbean.setTerms(rs.getString("terms"));
				bulkbean.setPayment(rs.getString("payment"));
				bulkbean.setCommission(rs.getString("commission"));
				bulkbean.setSplcdn(rs.getString("splcdn"));
				bulkbean.setInspcdn(rs.getString("inspcdn"));
				bulkbean.setConsigneeid(rs.getString("consigshform"));
				bulkbean.setNotifyid(rs.getString("notifyshform"));
				bulkbean.setBankid(rs.getString("bankshform"));
				bulkbean.setPojw(rs.getString("pojw"));
				
				bulkbean.setPrfarticleid(rs.getString("article.prfarticleid"));
				bulkbean.setArticleid(rs.getString("article.articleid"));
				bulkbean.setArticletype(rs.getString("articletype"));
				bulkbean.setArticleshfrom(rs.getString("articleshfrom"));
				bulkbean.setArticlename(rs.getString("articlename"));
				bulkbean.setColor(rs.getString("color"));
				bulkbean.setSize(rs.getString("size"));
				bulkbean.setSubstance(rs.getString("substance"));
				bulkbean.setSelection(rs.getString("selection"));
				bulkbean.setSelectionpercent(rs.getString("selectionpercent"));
				bulkbean.setQuantity(rs.getString("quantity"));
				bulkbean.setUnit(rs.getString("unit"));
				bulkbean.setPcs(rs.getString("pcs"));
				bulkbean.setRate(rs.getString("rate"));
				bulkbean.setTc(rs.getString("tc"));
				bulkbean.setUser(rs.getString("user"));
				bulkbean.setStatus(rs.getString("status"));
				bulkbean.setQshipped(rs.getString("qshipped"));
				bulkbean.setQbal(rs.getString("qbal"));
				bulkbean.setInvdetails(rs.getString("invdetails"));
				bulkbean.setReps(rs.getString("reps"));
				bulkbean.setComments(rs.getString("comments"));
				bulkbean.setFeddback(rs.getString("feddback"));
				bulkbean.setRdd_date(DateConversion.ConverttoNormalDate(rs.getString("rdd_date")));
				System.out.println("RDD DAte "+ DateConversion.ConverttoNormalDate(rs.getString("rdd_date")));
				bulkarray.add(bulkbean);
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return bulkarray;
	}
	
	/* (non-Javadoc)
	 * @see sb.elpro.dao.Bulkdao#getBulkQtyDetails()
	 */
	@Override
	public ArrayList<BulkQtyDetails> getBulkQtyDetails(String sidx, String sord) throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BulkQtyDetails> totalarray = new ArrayList<BulkQtyDetails>();
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT  sum(quantity) as qty , sum(qshipped) as Qshipd, sum(qbal) as Qbal FROM elpro.tbl_prf_article article, elpro.tbl_prfarticle_status statuse where article.prfarticleid = statuse.prf_articleid";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			if(rs.next()){
				BulkQtyDetails bulqty = new BulkQtyDetails();
				bulqty.setQbal(rs.getString("Qbal"));
				bulqty.setQuantity(rs.getString("qty"));
				bulqty.setQtyshpd(rs.getString("Qshipd"));
				totalarray.add(bulqty);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return totalarray;
	}

	@Override
	public boolean updateBtrStatus(BulkArticle bulkmodel, String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		StringBuffer sql_updateBtrStatus  = null;
		try{			
			con = DBConnection.getConnection();
			String isupdtar = bulkmodel.getIsupdtar();
			System.out.println("isupdtar " +isupdtar);
			if(isupdtar.equalsIgnoreCase("true")){
				 sql_updateBtrStatus = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET artname =?, status = ? , qshipped = ? , qbal = ? , invdetails = ? , reps = ? , comments = ? , feddback = ? , contractno = ? , rdd_date = ? WHERE contractno = '"+bulkmodel.getCtno()+"' and artname = '"+bulkmodel.getArticlename()+"' ");
			}else{
				 sql_updateBtrStatus = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET artname =?, status = ? , qshipped = ? , qbal = ? , invdetails = ? , reps = ? , comments = ? , feddback = ? , contractno = ? , rdd_date = ? WHERE prf_articleid = '"+bulkmodel.getPrfarticleid()+"' ");
			}
			String sqlquery_updateBtrStatus = sql_updateBtrStatus.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updateBtrStatus);
			pst.setString(1, bulkmodel.getArticlename());
			System.out.println("getArticlename " +bulkmodel.getArticlename());
			pst.setString(2, bulkmodel.getStatus());
			System.out.println("getStatus " +bulkmodel.getStatus());
			pst.setString(3, bulkmodel.getQshipped());
			pst.setString(4, bulkmodel.getQbal());
			pst.setString(5, bulkmodel.getInvdetails());
			pst.setString(6, bulkmodel.getReps());
			pst.setString(7, bulkmodel.getComments());
			System.out.println("getComments "+bulkmodel.getComments());
			pst.setString(8, bulkmodel.getFeddback());
			System.out.println("getFeddback "+bulkmodel.getFeddback());
			System.out.println("getContracts "+bulkmodel.getCtno());
			pst.setString(9, bulkmodel.getCtno());
			pst.setString(10, bulkmodel.getRdd_date());
			
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
