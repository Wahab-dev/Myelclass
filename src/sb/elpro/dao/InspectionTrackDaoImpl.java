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
import sb.elpro.utility.DateConversion;



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
			String sql = "SELECT inspid, inspdate, qualitycontroller, contractno, form.articleid, article, form.color, inspcdn, totinspected, grade, skincount, percent, totpassed, totrejects FROM tbl_inspform form,  tbl_inspgradedetails grade,  tbl_insprejectdetails rej where form.articleid = grade.articleid and form.articleid = rej.articleid order by inspid desc";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionBean insptrackbean = new InspectionBean();
				insptrackbean.setInspid(rs.getString("inspid"));
				insptrackbean.setInspdate( DateConversion.ConverttoNormalDate(rs.getString("inspdate")));
				insptrackbean.setInspqualityctrlr(rs.getString("qualitycontroller"));
				insptrackbean.setInspContractNo(rs.getString("contractno"));
				insptrackbean.setArticleid(rs.getString("articleid"));
				insptrackbean.setArticle(rs.getString("article"));
				insptrackbean.setColor(rs.getString("color"));
				insptrackbean.setInsp_cdn(rs.getString("inspcdn"));
				insptrackbean.setTotinspected(rs.getString("totinspected"));
				insptrackbean.setGrade(rs.getString("grade"));
				insptrackbean.setSkincount(rs.getString("skincount"));
				insptrackbean.setPercent(rs.getString("percent"));
				insptrackbean.setTotpassed(rs.getString("totpassed"));
				insptrackbean.setTotrejects(rs.getString("totrejects"));
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
