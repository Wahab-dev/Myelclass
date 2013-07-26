/**
 * 
 */
package sb.elpro.dao;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;

import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class InspectionDaoImpl implements InspectionDao {



	@Override
	public ArrayList<ProductDetails> getInspCtList(String inspctterm)
			throws SQLException {
		ArrayList<ProductDetails> inspCtlist = new ArrayList<ProductDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			//String sql = "SELECT distinct Ctno, Orderdt, pono, inspcdn, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, articletype, articleshfrom  FROM elpro.tbl_prfform prf, elpro.tbl_prf_article article  where prf.Ctno = article.contractno and Ctno like '%"+inspctterm+"%' order by articlename";
			String sql = "SELECT distinct Ctno, inspcdn FROM elpro.tbl_prfform prf where Ctno like '%"+inspctterm+"%' order by Ctno";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ProductDetails inspctbean = new ProductDetails();
				/*inspctbean.setPrf_articlename(rs.getString("articlename"));
				inspctbean.setPrf_orderdate(rs.getString("Orderdt"));
				inspctbean.setPrf_poref(rs.getString("pono"));
				
				inspctbean.setLabel(rs.getString("Ctno"));
				inspctbean.setPrf_size(rs.getString("size"));
				inspctbean.setPrf_substance(rs.getString("substance"));
				inspctbean.setPrf_selection(rs.getString("selection"));
				inspctbean.setPrf_color(rs.getString("color"));*/
				inspctbean.setLabel(rs.getString("Ctno"));
				inspctbean.setPrf_inspcdn(rs.getString("inspcdn"));
				System.out.println("Insp CT  name "+inspctbean.getLabel());
				inspCtlist.add(inspctbean);
			}
			System.out.println("Insp Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Insp Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return inspCtlist;
	}

	@Override
	public ArrayList<QualityCtrlrDetails> getInspQctrlrList(String qcterm)
			throws SQLException {
		ArrayList<QualityCtrlrDetails> inspQtyCtrlrlist = new ArrayList<QualityCtrlrDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT Q_name, Q_id, Q_type FROM elpro.tbl_qualitycontroller where Q_name like '%"+qcterm+"%' order by Q_name";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				QualityCtrlrDetails insqcbean = new QualityCtrlrDetails();
				
				insqcbean.setQc_Id(rs.getString("Q_id"));
				insqcbean.setLabel(rs.getString("Q_name"));
				insqcbean.setQc_Type(rs.getString("Q_type"));
				System.out.println("Insp QTY  name "+insqcbean.getLabel());
				inspQtyCtrlrlist.add(insqcbean);
			}
			System.out.println("Insp Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Insp Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return inspQtyCtrlrlist;
	}

	@Override
	public ArrayList<ProductDetails> getInspArtList(String ctno)
			throws SQLException {
		ArrayList<ProductDetails> inspCtlist = new ArrayList<ProductDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct Ctno, Orderdt, pono, inspcdn, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, articletype, articleshfrom  FROM elpro.tbl_prfform prf, elpro.tbl_prf_article article  where prf.Ctno = article.contractno and Ctno like '%"+ctno+"%' order by articlename";
			//String sql = "SELECT distinct Ctno FROM elpro.tbl_prfform prf where Ctno like '%"+inspctterm+"%' order by articlename";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ProductDetails inspctbean = new ProductDetails();
				inspctbean.setPrf_articlename(rs.getString("articlename"));
				inspctbean.setPrf_orderdate(rs.getString("Orderdt"));
				inspctbean.setPrf_poref(rs.getString("pono"));
				inspctbean.setPrf_inspcdn(rs.getString("inspcdn"));
				inspctbean.setPrf_contractno(rs.getString("Ctno"));
				inspctbean.setPrf_size(rs.getString("size"));
				inspctbean.setPrf_substance(rs.getString("substance"));
				inspctbean.setPrf_selection(rs.getString("selection"));
				inspctbean.setPrf_color(rs.getString("color"));
				inspctbean.setPrf_quantity(rs.getString("quantity"));
				System.out.println("Insp CT  name "+inspctbean.getLabel());
				inspCtlist.add(inspctbean);
			}
			System.out.println("Insp Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Insp Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return inspCtlist;
	}
}
