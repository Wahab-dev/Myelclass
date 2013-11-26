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
import com.mysql.jdbc.Statement;

import sb.elpro.model.InspectionBean;
import sb.elpro.utility.DBConnection;



/**
 * @author Wahab
 *
 */
public class InspectionTrackDaoImpl implements InspectionTrackDao {

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InspectionTrackDao#getInspectionTrackLoad(java.lang.String, java.lang.String)
	 */
	@Override
	public List<InspectionBean> getInspectionTrackLoad(String sidx, String sord)
			throws SQLException {
		ArrayList<InspectionBean> insptracklist = new ArrayList<InspectionBean>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT inspid, status, inspdate, qualitycontroller, contractno, articleid, article, color, inspcdn, testid, gradeid, rejectsid, totinspected, inspcomments FROM tbl_inspform  order by "+sidx+" "+sord+" ";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionBean insptrackbean = new InspectionBean();
				insptrackbean.setArticle(rs.getString("article"));
				insptrackbean.setArticleid(rs.getString("articleid"));
				insptrackbean.setColor(rs.getString("color"));
				insptrackbean.setInspid(rs.getString("inspid"));
				insptrackbean.setInspdate(rs.getString("inspdate"));
				insptrackbean.setInspContractNo(rs.getString("contractno"));
				insptrackbean.setStatus(rs.getString("status"));
				insptrackbean.setInspqualityctrlr(rs.getString("qualitycontroller"));
				insptrackbean.setInspcdn(rs.getString("inspcdn"));
				insptrackbean.setTestid(rs.getString("testid"));
				insptrackbean.setRejectsid(rs.getString("rejectsid"));
				insptrackbean.setGradeid(rs.getString("gradeid"));
				insptrackbean.setTotinspected(rs.getString("totinspected"));
				insptrackbean.setInspcomments(rs.getString("inspcomments"));
				insptracklist.add(insptrackbean);
			}
			System.out.println("Insp Track loaded Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Insp Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return insptracklist;
	}

}
