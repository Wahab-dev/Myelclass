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
	public ArrayList<InspectionBean> getInspectionTrackLoad()
			throws SQLException {
		ArrayList<InspectionBean> insptracklist = new ArrayList<InspectionBean>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			//String sql = "SELECT invno FROM elpro.tbl_invform";
			String sql = "SELECT inspid, inspdate, qualitycontroller, form.contractno, concat_ws('-',art.articlename,sart.articlename) as articlename, grade.color, testid, gradeid, rejectid, rjtotinspected, rej.totpassed, skincount1, skincount2, skincount3, skincount4, skincount5, skincount6, totrejects, form.inspcomments, inspcdn FROM elpro.tbl_inspform form left outer join elpro.tbl_inspgradedetails grade on form.inspid = grade.id and form.articleid = grade.articleid left outer join elpro.tbl_insptestdetails test on  form.inspid = test.id and form.articleid = test.articleid left outer join elpro.tbl_insprejectdetails rej on form.inspid = rej.id and form.articleid = rej.articleid left outer join elpro.tbl_prf_article art on art.prfarticleid = grade.articleid left outer join elpro.tbl_srf_article sart on sart.srfarticleid = grade.articleid order by form.inspdate desc, form.contractno, art.articlename desc, color desc";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			InspectionBean insptrackbean = new InspectionBean();
				insptrackbean.setInspid(rs.getString("inspid"));
				insptrackbean.setInspdate((rs.getString("inspdate")));
				insptrackbean.setInspqualityctrlr(rs.getString("qualitycontroller"));	
				insptrackbean.setInspContractNo(rs.getString("contractno"));
				insptrackbean.setArticle(rs.getString("articlename"));
				insptrackbean.setColor(rs.getString("color"));
				insptrackbean.setTestid(rs.getString("testid"));
				insptrackbean.setGradeid(rs.getString("gradeid"));
				insptrackbean.setRejectid(rs.getString("rejectid"));
				insptrackbean.setRjtotinspected(rs.getString("rjtotinspected"));
				insptrackbean.setTotpassed(rs.getString("totpassed"));
				insptrackbean.setSkincount1(rs.getString("skincount1"));
				insptrackbean.setSkincount2(rs.getString("skincount2"));
				insptrackbean.setSkincount3(rs.getString("skincount3"));
				insptrackbean.setSkincount4(rs.getString("skincount4"));
				insptrackbean.setSkincount5(rs.getString("skincount5"));
				insptrackbean.setSkincount6(rs.getString("skincount6"));
				insptrackbean.setTotrejects(rs.getString("totrejects"));
				insptrackbean.setInspcomments(rs.getString("inspcomments"));
				insptrackbean.setInsp_cdn(rs.getString("inspcdn"));
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
