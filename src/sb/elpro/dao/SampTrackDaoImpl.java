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


import sb.elpro.model.SampleTrack;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

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
			String sql = "SELECT form.sampleno, orderdt, refno, priority, handledby, cust.shortform, tan.tanshform,  del.shortform, destination, endusage, terms, add_date, cdd_date, splcdn, inspcdn,  forwaderid, isinvraised, articleid, articletype, articleshform, articlename, color, size,  substance, selection, selectionp, concat (quantity,' ',unit) as quantity, unit, pcs, rate, colormatching, tapetest,  crockingwet, crockingdry, fourfolds, keytest, article.srfarticleid, user, shpd, bal, status, rdd_date, courierdetails, reps, feedbackdetails FROM  elpro.tbl_srf_article article join elpro.tbl_srfarticle_status stats on article.srfarticleid = stats.srfarticleid left join elpro.tbl_srfform form on form.sampleno = article.sampleno left join elpro.tbl_customer cust on cust.custid = form.customerid left join elpro.tbl_tannery tan on tan.tanid = form.tanneryid left join elpro.tbl_customer del on del.custid = form.customerid order by form.sampleno desc, article.articletype asc, article.articlename asc, article.color asc";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 SampleTrack samptrackbean = new SampleTrack();
			 	samptrackbean.setSampleno(rs.getString("sampleno"));
			 	samptrackbean.setOrderdt(rs.getString("orderdt"));
			 	samptrackbean.setRefno(rs.getString("refno"));
			 	samptrackbean.setPriority(rs.getString("priority"));
			 	samptrackbean.setHandledby(rs.getString("handledby"));
			 	samptrackbean.setCustomerid(rs.getString("cust.shortform"));
			 	samptrackbean.setTanneryid(rs.getString("tan.tanshform"));
			 	samptrackbean.setDeliverid(rs.getString("del.shortform"));
			 	samptrackbean.setDestination(rs.getString("destination"));
			 	samptrackbean.setEndusage(rs.getString("endusage")); //==
			 	samptrackbean.setTerms(rs.getString("terms"));
			 	samptrackbean.setAdd_date(DateConversion.ConverttoNormalDate(rs.getString("add_date")));
			 	samptrackbean.setCdd_date(DateConversion.ConverttoNormalDate(rs.getString("cdd_date")));
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

			 	samptrackbean.setShpd(rs.getString("shpd")); // 
			 	samptrackbean.setBal(rs.getString("bal")); //
			 	samptrackbean.setStatus(rs.getString("status"));
			 	samptrackbean.setRdd_date(DateConversion.ConverttoNormalDate(rs.getString("rdd_date")));
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SampTrackDao#updateSrStatus(sb.elpro.model.SampleTrack, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateSrStatus(SampleTrack samplemodel, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		StringBuffer sql_updateBtrStatus  = null;
		try{			
			con = DBConnection.getConnection();
			System.out.println("SRF Article ID "+samplemodel.getSrfarticleid());
			String isupdtar = samplemodel.getIsupdtar();
			System.out.println("isupdtar " +isupdtar);
			if(isupdtar.equalsIgnoreCase("true")){
				 sql_updateBtrStatus = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET  artname=?, status = ? , courierdetails = ? , reps = ? ,  feedbackdetails = ? , sampleno = ? , rdd_date = ? WHERE artname   = '"+samplemodel.getArticlename()+"' and sampleno = '"+samplemodel.getSampleno() +"' ");
			}else{
				 sql_updateBtrStatus = new StringBuffer("UPDATE elpro.tbl_srfarticle_status SET  artname=?, status = ? , courierdetails = ? , reps = ? ,  feedbackdetails = ? , sampleno = ? , rdd_date = ? WHERE srfarticleid  = '"+samplemodel.getSrfarticleid()+"' ");
			}
			String sqlquery_updateBtrStatus = sql_updateBtrStatus.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updateBtrStatus);
			pst.setString(1, samplemodel.getArticlename());
			System.out.println("SNo " +samplemodel.getArticlename());
			pst.setString(2, samplemodel.getStatus());
			System.out.println("STATUS " +samplemodel.getStatus());
			pst.setString(3, samplemodel.getCourierdetails());
			System.out.println("getCourierdetails " +samplemodel.getCourierdetails());
			pst.setString(4, samplemodel.getReps());
			pst.setString(5, samplemodel.getFeedbackdetails());
			pst.setString(6, samplemodel.getSampleno());
			pst.setString(7, samplemodel.getRdd_date());
			
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
