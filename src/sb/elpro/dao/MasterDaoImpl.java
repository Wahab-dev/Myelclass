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
import com.mysql.jdbc.Statement;

import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.Masterbean;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class MasterDaoImpl implements MasterDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.MasterDao#getMasterDetailList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Masterbean> getMasterDetailList(String sidx, String sord,
			String rows, String pag) throws SQLException {
		ArrayList<Masterbean> masterarray = new ArrayList<Masterbean>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	
		try{	
			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();// limit "+pag+", "+rows+" 
			String sql = "SELECT Ctno, agent, Orderdt, pono, exporterid, tanneryid, customerid,  add_date,  rdd_date, destination, commission, othercommission,  consigneeid, notifyid, pojw, articleid, concat (articletype,'',articleshfrom,articlename) as article, color, size, substance, selection, concat (quantity,unit) as qty, qshipped, qbal, rate, tc,  user,   status,  invdetails, reps, comments, feddback FROM `elpro`.`tbl_prfform` form , `elpro`.`tbl_prf_article` article, tbl_prfarticle_status status where  Ctno = article.contractno and article.contractno = status.contractno and prf_articleid = prfarticleid  order by Ctno asc, article desc, color desc ";
			System.out.println(sql);
			System.out.println(" Rows "+rows);
			System.out.println(" Page "+pag);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 Masterbean masterbean= new Masterbean();
			 	masterbean.setCtno(rs.getString("Ctno"));
			 	masterbean.setAgent(rs.getString("agent"));
			 	masterbean.setOrderdt(rs.getString("Orderdt"));
			 	masterbean.setPono(rs.getString("pono"));
			 	masterbean.setTanneryid(rs.getString("tanneryid"));
			 	masterbean.setExporterid(rs.getString("exporterid"));
			 	masterbean.setCustomerid(rs.getString("customerid"));
			 	masterbean.setAdd_date(DateConversion.ConverttoNormalDate(rs.getString("add_date")));
				masterbean.setRdd_date(DateConversion.ConverttoNormalDate(rs.getString("rdd_date")));
				masterbean.setDestination(rs.getString("destination"));
				masterbean.setCommission(rs.getString("commission"));
				masterbean.setOthercommission(rs.getString("othercommission"));
				masterbean.setConsigneeid(rs.getString("consigneeid"));
				masterbean.setNotifyid(rs.getString("notifyid"));
				masterbean.setPojw(rs.getString("pojw"));
				
				masterbean.setArticleid(rs.getString("article.articleid"));
				masterbean.setArticlename(rs.getString("article"));
				masterbean.setColor(rs.getString("color"));
				masterbean.setSize(rs.getString("size"));
				masterbean.setSubstance(rs.getString("substance"));
				masterbean.setSelection(rs.getString("selection"));
				masterbean.setQuantity(rs.getString("qty"));
				masterbean.setRate(rs.getString("rate"));
				masterbean.setTc(rs.getString("tc"));
				masterbean.setUser(rs.getString("user"));
				masterbean.setStatus(rs.getString("status"));
				masterbean.setQshipped(rs.getString("qshipped"));
				masterbean.setQbal(rs.getString("qbal"));
				masterbean.setInvdetails(rs.getString("invdetails"));
				masterbean.setReps(rs.getString("reps"));
				masterbean.setComments(rs.getString("comments"));
				masterbean.setFeddback(rs.getString("feddback"));
				
				masterarray.add(masterbean);
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return masterarray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.MasterDao#getMasterQtyDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<BulkQtyDetails> getMasterQtyDetails(String sidx,
			String sord) throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BulkQtyDetails> mastertotalarray = new ArrayList<BulkQtyDetails>();
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
				mastertotalarray.add(bulqty);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return mastertotalarray;
	}
	
}
