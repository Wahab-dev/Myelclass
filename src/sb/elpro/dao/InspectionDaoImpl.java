/**
 * 
 */
package sb.elpro.dao;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import sb.elpro.model.InspectionLoadBean;

import sb.elpro.utility.DBConnection;

/**
 * @author ADMIN_WIN7
 *
 */
public class InspectionDaoImpl implements InspectionDao {

	@Override
	public ArrayList<InspectionLoadBean> getInspContractNumber() throws Exception {
		ArrayList inspctrct  = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT CONTRACT_NUMBER FROM elpro.tab_prf ";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionLoadBean insploadbean  = new InspectionLoadBean();
				insploadbean.setInspContractNo(rs.getString("CONTRACT_NUMBER"));
				
				System.out.println("Result Added Successfully");
				
				inspctrct.add(insploadbean);
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return inspctrct;
		
	}

	@Override
	public ArrayList getInspQtyCtrlr() throws Exception {
		ArrayList inspqtyctrl  = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT QualityControllerName FROM elpro.tbl_qualitycontroller ";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionLoadBean inspqtyloadbean  = new InspectionLoadBean();
				inspqtyloadbean.setInspqualityctrlr(rs.getString("QualityControllerName"));
				
				System.out.println("Result Added Successfully");
				
				inspqtyctrl.add(inspqtyloadbean);
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return inspqtyctrl;

	}
}
