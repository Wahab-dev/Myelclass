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

/**
 * @author Wahab
 *
 */
public class BulkDaoImpl implements Bulkdao {

	@Override
	public ArrayList<BulkArticle> getBulkDetailList(String sidx, String sord)
			throws SQLException {
		ArrayList<BulkArticle> bulkarray = new ArrayList<BulkArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct article.prfarticleid, form.agent, form.Ctno, Orderdt, pono, exporterid, tanneryid, customerid, cdd_date, add_date, destination, terms, payment, commission, splcdn, inspcdn, consigneeid, notifyid,  bankid,  pojw, article.articleid, articletype, articleshfrom, articlename, color, size, substance, selection, selectionpercent, quantity , unit,pcs, rate, tc, article.prfarticleid, user, statuse.prfarticleid, status, Qtyshpd, Qbal, invdetails, reps,  comments, feddback, statuse.contractno, rdd_date FROM elpro.tbl_prfform form, elpro.tbl_prf_article article, elpro.tbl_prfarticle_status statuse where form.Ctno = article.contractno and article.prfarticleid = statuse.prfarticleid order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				BulkArticle bulkbean = new BulkArticle();
				bulkbean.setCtno(rs.getString("Ctno"));
				bulkbean.setAgent(rs.getString("agent"));
				bulkbean.setOrderdt(rs.getString("Orderdt"));
				bulkbean.setPono(rs.getString("pono"));
				bulkbean.setTanneryid(rs.getString("tanneryid"));
				bulkbean.setExporterid(rs.getString("exporterid"));
				bulkbean.setCustomerid(rs.getString("customerid"));
				bulkbean.setCdd_date(rs.getString("cdd_date"));
				bulkbean.setAdd_date(rs.getString("add_date"));
				bulkbean.setDestination(rs.getString("destination"));
				bulkbean.setTerms(rs.getString("terms"));
				bulkbean.setPayment(rs.getString("payment"));
				bulkbean.setCommission(rs.getString("commission"));
				bulkbean.setSplcdn(rs.getString("splcdn"));
				bulkbean.setInspcdn(rs.getString("inspcdn"));
				bulkbean.setConsigneeid(rs.getString("consigneeid"));
				bulkbean.setNotifyid(rs.getString("notifyid"));
				bulkbean.setBankid(rs.getString("bankid"));
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
				bulkbean.setQtyshpd(rs.getString("Qtyshpd"));
				bulkbean.setQbal(rs.getString("Qbal"));
				bulkbean.setInvdetails(rs.getString("invdetails"));
				bulkbean.setReps(rs.getString("reps"));
				bulkbean.setComments(rs.getString("comments"));
				bulkbean.setFeddback(rs.getString("feddback"));
				bulkbean.setRdd_date(rs.getString("rdd_date"));
				
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
			String sql = "SELECT  sum(quantity) as qty , sum(Qtyshpd) as Qshipd, sum(Qbal) as Qbal FROM elpro.tbl_prf_article article, elpro.tbl_prfarticle_status statuse where article.prfarticleid = statuse.prfarticleid";
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
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_updateBtrStatus = new StringBuffer("UPDATE elpro.tbl_prfarticle_status SET artname =?, status = ? , Qtyshpd = ? , Qbal = ? , invdetails = ? , reps = ? , comments = ? , feddback = ? , contractno = ? , rdd_date = ? WHERE prfarticleid = '"+bulkmodel.getPrfarticleid()+"' ");
			String sqlquery_updateBtrStatus = sql_updateBtrStatus.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updateBtrStatus);
			pst.setString(1, bulkmodel.getArticlename());
			System.out.println("getArticlename " +bulkmodel.getArticlename());
			pst.setString(2, bulkmodel.getStatus());
			System.out.println("getStatus " +bulkmodel.getStatus());
			pst.setString(3, bulkmodel.getQtyshpd());
			pst.setString(4, bulkmodel.getQbal());
			pst.setString(5, bulkmodel.getInvdetails());
			pst.setString(6, bulkmodel.getReps());
			pst.setString(7, bulkmodel.getComments());
			pst.setString(8, bulkmodel.getFeddback());
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
