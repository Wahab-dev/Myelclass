/**
 * 
 */
package sb.elpro.dao;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sb.elpro.model.InspectionBean;
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
			String sql = "SELECT distinct Ctno, Orderdt, tanneryid, customerid, pono, inspcdn, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, prfarticleid, articletype, articleshfrom  FROM elpro.tbl_prfform prf, elpro.tbl_prf_article article  where prf.Ctno = article.contractno and Ctno like '%"+ctno+"%' order by articlename";
			//String sql = "SELECT distinct Ctno FROM elpro.tbl_prfform prf where Ctno like '%"+inspctterm+"%' order by articlename";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				String qty =  rs.getString("quantity")+" "+ rs.getString("unit");
				
				ProductDetails inspctbean = new ProductDetails();
				inspctbean.setPrf_articlename(rs.getString("articlename"));
				inspctbean.setPrf_articleid(rs.getString("prfarticleid"));
				inspctbean.setPrf_orderdate(rs.getString("Orderdt"));
				inspctbean.setPrf_tannid(rs.getString("tanneryid"));
				inspctbean.setPrf_custid(rs.getString("customerid"));
				inspctbean.setPrf_poref(rs.getString("pono"));
				inspctbean.setPrf_inspcdn(rs.getString("inspcdn"));
				inspctbean.setPrf_contractno(rs.getString("Ctno"));
				inspctbean.setPrf_size(rs.getString("size"));
				inspctbean.setPrf_substance(rs.getString("substance"));
				inspctbean.setPrf_selection(rs.getString("selection"));
				inspctbean.setPrf_selectionp(rs.getString("selectionpercent"));
				inspctbean.setPrf_color(rs.getString("color"));
				inspctbean.setPrf_quantity(qty);
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
	public ArrayList<InspectionBean> getInspTestList(String sidx,
			String sord, String artid) throws SQLException {
		ArrayList<InspectionBean> insptestarray = new ArrayList<InspectionBean>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, testid, testtype,  pcstested, result, comments, articleid, color FROM tbl_insptestdetails where articleid = '"+artid+"' order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionBean insptestbean = new InspectionBean();
			 insptestbean.setId(rs.getString("id"));
			    insptestbean.setTestid(rs.getString("testid"));
			    insptestbean.setTesttype(rs.getString("testtype"));
				insptestbean.setTestedpcs(rs.getString("pcstested"));
				insptestbean.setResult(rs.getString("result"));
				insptestbean.setComments(rs.getString("comments"));
				insptestbean.setArticleid(rs.getString("articleid"));
				insptestbean.setColortest(rs.getString("color"));
				insptestarray.add(insptestbean);
			}
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
		}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		}	
		return insptestarray;
		}

	@Override
	public boolean getInspTestAddList(InspectionBean insptest, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveinspTest = new StringBuffer("insert into tbl_insptestdetails (testid, articleid, color, testtype, pcstested, result, comments)");
			sql_saveinspTest.append("values (?,?,?,?,?,?,?)");
			String sqlquery_saveinspTest = sql_saveinspTest.toString();
			
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveinspTest);
			pst.setString(1, insptest.getTestid());
			pst.setString(2, insptest.getArticleid());
			pst.setString(3, insptest.getColortest());
			pst.setString(4, insptest.getTesttype());
			pst.setString(5, insptest.getTestedpcs());
			pst.setString(6, insptest.getResult());
			pst.setString(7, insptest.getComments());
			
			System.out.println("getComments " +insptest.getComments());
			noofrows = pst.executeUpdate();
			
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	return isadded;
	}

	@Override
	public boolean getInspTestEditList(InspectionBean insptest,
			String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveInsptest = new StringBuffer("UPDATE elpro.tbl_insptestdetails SET testid = ? , articleid = ? , color = ? , testtype = ? , pcstested = ? , result = ? , comments = ?  WHERE id = '"+insptest.getId()+"' ");
			String sqlquery_saveInsptest = sql_saveInsptest.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveInsptest);
			pst.setString(1, insptest.getTestid());
			System.out.println("getTestid " +insptest.getTestid());
			pst.setString(2, insptest.getArticleid());
			pst.setString(3, insptest.getColortest());
			pst.setString(4, insptest.getTesttype());
			pst.setString(5, insptest.getTestedpcs());
			pst.setString(6, insptest.getResult());
			pst.setString(7, insptest.getComments());
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

	@Override
	public boolean getInspTestDelList(InspectionBean insptest,
			String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delInsptest = new StringBuffer("delete from elpro.tbl_insptestdetails WHERE id = '"+insptest.getId()+"' ");			
			String sqlquery_delInsptest = sql_delInsptest.toString();
			System.out.println(sqlquery_delInsptest);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delInsptest);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isdel;
	}

	@Override
	public ArrayList<InspectionBean> getInspGradeList(String sidx,
			String sord, String artid) throws SQLException {
		ArrayList<InspectionBean> insptestarray = new ArrayList<InspectionBean>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, gradeid, articleid, color, grade, skincount, grtotinspected, percent, comment FROM tbl_inspgradedetails where articleid ='"+artid+"' order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionBean insptestbean = new InspectionBean();
			 insptestbean.setId(rs.getString("id"));
			    insptestbean.setGradeid(rs.getString("gradeid"));
				insptestbean.setArticleid(rs.getString("articleid"));
				insptestbean.setGradecolor(rs.getString("color"));
				insptestbean.setGrade(rs.getString("grade"));
				insptestbean.setSkincount(rs.getString("skincount"));
				insptestbean.setPercent(rs.getString("percent"));
				insptestbean.setGrtotinspected(rs.getString("grtotinspected"));
				insptestbean.setComment(rs.getString("comment"));
				insptestarray.add(insptestbean);
			}
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
		}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		}	
		return insptestarray;
	}

	@Override
	public boolean getInspGradeAddList(InspectionBean inspgrad, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveinspgrad = new StringBuffer("insert into tbl_inspgradedetails (gradeid, articleid, color, grade, skincount, grtotinspected, percent, comment)");
			sql_saveinspgrad.append("values (?,?,?,?,?,?,?,?)");
			String sqlquery_saveinspgrad = sql_saveinspgrad.toString();
			
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveinspgrad);
			pst.setString(1, inspgrad.getGradeid());
			System.out.println("getGradeid " +inspgrad.getGradeid());
			pst.setString(2, inspgrad.getArticleid());
			pst.setString(3, inspgrad.getGradecolor());
			pst.setString(4, inspgrad.getGrade());
			pst.setString(5, inspgrad.getSkincount());
			pst.setString(6, inspgrad.getGrtotinspected());  
			pst.setString(7, inspgrad.getPercent());
			pst.setString(8, inspgrad.getComment());
			
			System.out.println("getComment " +inspgrad.getComment());
			noofrows = pst.executeUpdate();
			
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	return isadded;
	}

	@Override
	public boolean getInspGradeEditList(InspectionBean inspgrad, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveInspgrad = new StringBuffer("UPDATE elpro.tbl_inspgradedetails SET gradeid = ? , articleid = ? , color = ? , grade= ? , skincount = ? , grtotinspected = ? , percent = ? , comment = ?  WHERE id = '"+inspgrad.getId()+"' ");
			String sqlquery_saveInspgrad = sql_saveInspgrad.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveInspgrad);
			pst.setString(1, inspgrad.getGradeid());
			System.out.println("getGradeid " +inspgrad.getGradeid());
			pst.setString(2, inspgrad.getArticleid());
			pst.setString(3, inspgrad.getGradecolor());
			pst.setString(4, inspgrad.getGrade());
			pst.setString(5, inspgrad.getSkincount());
			pst.setString(6, inspgrad.getGrtotinspected()); 
			pst.setString(7, inspgrad.getPercent());
			pst.setString(8, inspgrad.getComment());
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

	@Override
	public boolean getInspGradeDelList(InspectionBean inspgrad, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delInspgrade = new StringBuffer("delete from elpro.tbl_inspgradedetails WHERE id = '"+inspgrad.getId()+"' ");			
			String sqlquery_delInspgrade = sql_delInspgrade.toString();
			System.out.println(sqlquery_delInspgrade);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delInspgrade);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isdel;
	}

	@Override
	public ArrayList<InspectionBean> getInspRejList(String sidx, String sord, String artid)
			throws SQLException {
		ArrayList<InspectionBean> insprejarray = new ArrayList<InspectionBean>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, rejectid, articleid, arttype, color, rjtotinspected, totpassed, totrejects, subsrejects, sizerejects, selecrejects, colorrejects, orgrejects, otherrejects  FROM tbl_insprejectdetails where articleid = '"+artid+"' order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionBean insprejbean = new InspectionBean();
				insprejbean.setId(rs.getString("id"));
			    insprejbean.setRejectid(rs.getString("rejectid"));
				insprejbean.setArticleid(rs.getString("articleid"));
				insprejbean.setArttype(rs.getString("arttype"));
				insprejbean.setRejcolor(rs.getString("color"));
				insprejbean.setRjtotinspected(rs.getString("rjtotinspected"));
				insprejbean.setTotpassed(rs.getString("totpassed"));
				insprejbean.setTotrejects(rs.getString("totrejects"));
				insprejbean.setSubsrejects(rs.getString("subsrejects"));
				insprejbean.setSizerejects(rs.getString("sizerejects"));
				insprejbean.setSelecrejects(rs.getString("selecrejects"));
				insprejbean.setColorrejects(rs.getString("colorrejects"));
				insprejbean.setOrgrejects(rs.getString("orgrejects"));
				insprejbean.setOtherrejects(rs.getString("otherrejects"));
				insprejarray.add(insprejbean);
			}
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
		}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		}	
		return insprejarray;
	}

	@Override
	public boolean getInspRejAddList(InspectionBean insprej, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveinsprej = new StringBuffer("insert into tbl_insprejectdetails (rejectid, articleid, arttype,  color, rjtotinspected, totpassed, totrejects, subsrejects, sizerejects, selecrejects, colorrejects, orgrejects, otherrejects )");
			sql_saveinsprej.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveinsprejinspgrad = sql_saveinsprej.toString();
			
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveinsprejinspgrad);
			pst.setString(1, insprej.getRejectid());
			System.out.println("getRejectid " +insprej.getRejectid());
			pst.setString(2, insprej.getArticleid());
			pst.setString(3, insprej.getArttype());
			pst.setString(4, insprej.getRejcolor());
			pst.setString(5, insprej.getRjtotinspected());
			pst.setString(6, insprej.getTotpassed());
			pst.setString(7, insprej.getTotrejects());
			pst.setString(8, insprej.getSubsrejects());
			pst.setString(9, insprej.getSizerejects());
			pst.setString(10, insprej.getSelecrejects());
			pst.setString(11, insprej.getColorrejects());
			pst.setString(12, insprej.getOrgrejects());
			pst.setString(13, insprej.getOtherrejects());
			System.out.println("getOtherrejects " +insprej.getOtherrejects());
			noofrows = pst.executeUpdate();
			
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	return isadded;
	}

	@Override
	public boolean getInspRejEditList(InspectionBean insprej, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveInsprej = new StringBuffer("UPDATE elpro.tbl_insprejectdetails SET rejectid = ? , articleid = ? , arttype= ?, color = ? , rjtotinspected= ? , totpassed = ? , totrejects = ? , subsrejects = ?, sizerejects = ? , selecrejects = ? , colorrejects = ? , orgrejects= ?, otherrejects = ?  WHERE id = '"+insprej.getId()+"' ");
			String sqlquery_saveInsprej = sql_saveInsprej.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveInsprej);
			pst.setString(1, insprej.getRejectid());
			System.out.println("getRejectid " +insprej.getRejectid());
			pst.setString(2, insprej.getArticleid());
			pst.setString(3, insprej.getArttype());
			pst.setString(4, insprej.getRejcolor());
			pst.setString(5, insprej.getRjtotinspected());
			pst.setString(6, insprej.getTotpassed());
			pst.setString(7, insprej.getTotrejects());
			pst.setString(8, insprej.getSubsrejects());
			pst.setString(9, insprej.getSizerejects());
			pst.setString(10, insprej.getSelecrejects());
			pst.setString(11, insprej.getColorrejects());
			pst.setString(12, insprej.getOrgrejects());
			pst.setString(13, insprej.getOtherrejects());
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

	@Override
	public boolean getInspRejDelList(InspectionBean insprej, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delInsprej= new StringBuffer("delete from elpro.tbl_insprejectdetails WHERE id = '"+insprej.getId()+"' ");			
			String sqlquery_delInsprej = sql_delInsprej.toString();
			System.out.println(sqlquery_delInsprej);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delInsprej);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isdel;
	}

}
