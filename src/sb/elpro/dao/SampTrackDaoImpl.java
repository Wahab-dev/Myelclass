/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import sb.elpro.model.SampleTrack;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class SampTrackDaoImpl implements SampTrackDao {

	@Override
	public ArrayList<SampleTrack> getSampleTrackDetailList(String sidx,
			String sord) throws SQLException {
		ArrayList<SampleTrack> sampletrackarray = new ArrayList<SampleTrack>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT form.sampleno, form.agentid,  form.orderdt, form.refno, form.priority, form.handledby, form.customerid, form.tanneryid, form.deliverid, form.destination, form.terms, form.add_date, form.cdd_date, form.splcdn, form.inspcdn, form.forwaderid, form.isinvraised, article.articleid, article.articletype, article.articleshform, article.articlename, article.color, article.size, article.substance, article.selection, article.selectionp, article.quantity, article.unit, article.pcs, article.rate, article.colormatching, article.tapetest, article.crockingwet, article.crockingdry, article.fourfolds, article.keytest, article.srfarticleid, article.user, status.status, status.rdd_date, status.courierdetails, status.reps, status.feedbackdetails FROM elpro.tbl_srfform form, tbl_srf_article article, tbl_srfarticle_status status where form.sampleno = article.sampleno and article.srfarticleid = status.srfarticleid order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 SampleTrack samptrackbean = new SampleTrack();
			 	samptrackbean.setSampleno(rs.getString("sampleno"));
			 	samptrackbean.setAgentid(rs.getString("agentid"));
			 	samptrackbean.setOrderdt(rs.getString("orderdt"));
			 	samptrackbean.setRefno(rs.getString("refno"));
			 	samptrackbean.setPriority(rs.getString("priority"));
			 	samptrackbean.setHandledby(rs.getString("handledby"));
			 	samptrackbean.setCustomerid(rs.getString("customerid"));
			 	samptrackbean.setTanneryid(rs.getString("tanneryid"));
			 	samptrackbean.setDeliverid(rs.getString("deliverid"));
			 	samptrackbean.setDestination(rs.getString("destination"));
			 	samptrackbean.setTerms(rs.getString("terms"));
			 	samptrackbean.setAdd_date(rs.getString("add_date"));
			 	samptrackbean.setCdd_date(rs.getString("cdd_date"));
			 	samptrackbean.setSplcdn(rs.getString("splcdn"));
			 	samptrackbean.setInspcdn(rs.getString("inspcdn"));
			 	samptrackbean.setForwaderid(rs.getString("forwaderid"));
			 	samptrackbean.setIsinvraised(rs.getString("isinvraised"));
			 	
			 	samptrackbean.setArticleid(rs.getString("articleid"));
			 	samptrackbean.setArticletype(rs.getString("articletype"));
			 	samptrackbean.setArticleshform(rs.getString("articleshform"));
			 	samptrackbean.setArticlename(rs.getString("articlename"));
			 	samptrackbean.setColor(rs.getString("color"));
			 	samptrackbean.setSize(rs.getString("size"));
			 	samptrackbean.setSubstance(rs.getString("substance"));
			 	samptrackbean.setSelectionp(rs.getString("selectionp"));
			 	samptrackbean.setSelection(rs.getString("selection"));
			 	samptrackbean.setQuantity(rs.getString("quantity"));
			 	samptrackbean.setUnit(rs.getString("unit"));
			 	samptrackbean.setPcs(rs.getString("pcs"));
			 	samptrackbean.setRate(rs.getString("rate"));
			 	samptrackbean.setColormatching(rs.getString("colormatching"));
			 	samptrackbean.setTapetest(rs.getString("tapetest"));
			 	samptrackbean.setCrockingwet(rs.getString("crockingwet"));
			 	samptrackbean.setCrockingdry(rs.getString("crockingdry"));
			 	samptrackbean.setFourfolds(rs.getString("fourfolds"));
			 	samptrackbean.setKeytest(rs.getString("keytest"));
			 	samptrackbean.setSrfarticleid(rs.getString("srfarticleid"));
			 	samptrackbean.setUser(rs.getString("user"));
			 	
			 	samptrackbean.setStatus(rs.getString("status"));
			 	samptrackbean.setRdd_date(rs.getString("rdd_date"));
			 	samptrackbean.setCourierdetails(rs.getString("courierdetails"));
			 	samptrackbean.setReps(rs.getString("reps"));
			 	samptrackbean.setFeedbackdetails(rs.getString("feedbackdetails"));
			 
			 
			 
				//samptrackbean.setAdd_date(add_date);
			sampletrackarray.add(samptrackbean);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
	return sampletrackarray;
	}
}
