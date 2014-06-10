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
import sb.elpro.model.InspectionGrade;
import sb.elpro.model.ManualTest;
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
			String sql = "SELECT distinct Ctno, inspcdn FROM elpro.tbl_prfform prf where Ctno like '%"+inspctterm+"%' order by Ctno";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ProductDetails inspctbean = new ProductDetails();
				inspctbean.setPrf_contractno(rs.getString("Ctno"));
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
			String sql = "SELECT Ctno, Orderdt, tanname, custname, pono, inspcdn, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, prfarticleid, articletype, articleshfrom  FROM  elpro.tbl_prf_article article  left outer join elpro.tbl_prfform prf on prf.Ctno = article.contractno  left outer join elpro.tbl_tannery tan on  tan.tanid = prf.tanneryid  left outer join elpro.tbl_customer cust on  cust.custid = prf.customerid where Ctno like '%"+ctno+"%' order by articlename";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				String qty =  rs.getString("quantity")+" "+ rs.getString("unit");
				ProductDetails inspctbean = new ProductDetails();
				inspctbean.setPrf_articlename(rs.getString("articlename"));
				inspctbean.setPrf_articleid(rs.getString("prfarticleid"));
				inspctbean.setPrf_orderdate(rs.getString("Orderdt"));
				inspctbean.setPrf_tannid(rs.getString("tanname"));
				inspctbean.setPrf_custid(rs.getString("custname"));
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
	public ArrayList<ManualTest> getInspTestList(String sidx,
			String sord, String artid) throws SQLException {
		ArrayList<ManualTest> insptestarray = new ArrayList<ManualTest>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, testid, articleid, color, contractno, colortest, colorpieces, colorresult, colorcomments, subtest, subpieces, subresult, subcomments, teartest, tearpieces, tearresult, tearcomments, graintest, grainpieces, grainresult, graincomments, crockwettest, crockwetpieces, crockwetresult, crockwetcomments, crockdrytest, crockdrypieces, crockdryresult, crockdrycomments, finishtest, finishpieces, finishresult, fnishcomments, fourtest, fourpieces, fourresult, fourcomments, dyetest, dyepieces, dyeresult, dyecomments, orgtest, orgpieces, orgresult, orgcomments FROM elpro.tbl_insptestdetails where articleid = '"+artid+"' order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ManualTest insptestbean = new ManualTest();
			 insptestbean.setId(rs.getString("id"));
			 insptestbean.setTestid(rs.getString("testid"));
			 insptestbean.setArticleid(rs.getString("articleid"));
			 insptestbean.setTestcolor(rs.getString("color"));
			 insptestbean.setContractno(rs.getString("contractno"));
			 insptestbean.setColortest(rs.getString("colortest"));
			 insptestbean.setColortested(rs.getString("colorpieces"));
			 insptestbean.setColorresult(rs.getString("colorresult"));
			 insptestbean.setColorcomments(rs.getString("colorcomments"));
			 insptestbean.setSubtest(rs.getString("subtest"));
			 insptestbean.setSubtested(rs.getString("subpieces"));
			 insptestbean.setSubresult(rs.getString("subresult"));
			 insptestbean.setSubcomments(rs.getString("subcomments"));
			 insptestbean.setTeartest(rs.getString("teartest"));
			 insptestbean.setTeartested(rs.getString("tearpieces"));
			 insptestbean.setTearresult(rs.getString("tearresult"));
			 insptestbean.setTearcomments(rs.getString("tearcomments"));
			 insptestbean.setGrainbreaktest(rs.getString("graintest"));
			 insptestbean.setGrainbreaktested(rs.getString("grainpieces"));
			 insptestbean.setGrainbreakresult(rs.getString("grainresult"));
			 insptestbean.setGrainbreakcomments(rs.getString("graincomments"));
			 insptestbean.setCrockingwettest(rs.getString("crockwettest"));	
			 insptestbean.setCrockingwettested(rs.getString("crockwetpieces"));
			 insptestbean.setCrockingwetresult(rs.getString("crockwetresult"));
			 insptestbean.setCrockingwetcomments(rs.getString("crockwetcomments"));
			 insptestbean.setCrockingdrytest(rs.getString("crockdrytest"));
			 insptestbean.setCrockingdrytested(rs.getString("crockdrypieces"));
			 insptestbean.setCrockingdryresult(rs.getString("crockdryresult"));
			 insptestbean.setCrockingdrycomments(rs.getString("crockdrycomments"));
			 insptestbean.setFinishadhensiontest(rs.getString("finishtest"));
			 insptestbean.setFinishadhensiontested(rs.getString("finishpieces"));
			 insptestbean.setFinishadhensionresult(rs.getString("finishresult"));
			 insptestbean.setFinishadhensioncomments(rs.getString("fnishcomments"));
			 insptestbean.setFourfoldstest(rs.getString("fourtest"));
			 insptestbean.setFourfoldstested(rs.getString("fourpieces"));
			 insptestbean.setFourfoldsresult(rs.getString("fourresult"));
			 insptestbean.setFourfoldscomments(rs.getString("fourcomments"));
			 insptestbean.setDyethrutest(rs.getString("dyetest"));
			 insptestbean.setDyethrutested(rs.getString("dyepieces"));
			 insptestbean.setDyethruresult(rs.getString("dyeresult"));
			 insptestbean.setDyethrucomments(rs.getString("dyecomments"));
			 insptestbean.setOrganoleptictest(rs.getString("orgtest"));
			 insptestbean.setOrganoleptictested(rs.getString("orgpieces"));
			 insptestbean.setOrganolepticresult(rs.getString("orgresult"));
			 insptestbean.setOrganolepticcomments(rs.getString("orgcomments"));
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
	public boolean getInspTestAddList(ManualTest insptest, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveinspTest = new StringBuffer("insert into tbl_insptestdetails (testid, articleid, color, contractno, colortest, colorpieces, colorresult, colorcomments, subtest, subpieces, subresult, subcomments, teartest, tearpieces,tearresult ,tearcomments , graintest, grainpieces, grainresult,graincomments ,crockwettest ,crockwetpieces , crockwetresult, crockwetcomments, crockdrytest, crockdrypieces, crockdryresult, crockdrycomments, finishtest, finishpieces,finishresult , fnishcomments, fourtest, fourpieces, fourresult, fourcomments, dyetest, dyepieces, dyeresult, dyecomments, orgtest,orgpieces ,orgresult , orgcomments)");
			sql_saveinspTest.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveinspTest = sql_saveinspTest.toString();
			
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveinspTest);
			pst.setString(1, insptest.getTestid());
			pst.setString(2, insptest.getArticleid());
			pst.setString(3, insptest.getTestcolor());
			pst.setString(4, insptest.getContractno());
			pst.setString(5, insptest.getColortest());
			pst.setString(6, insptest.getColortested	());
			pst.setString(7, insptest.getColorresult());
			pst.setString(8, insptest.getColorcomments());
			pst.setString(9, insptest.getSubtest());
			pst.setString(10, insptest.getSubtested());
			pst.setString(11, insptest.getSubresult());
			pst.setString(12, insptest.getSubcomments());
			pst.setString(13, insptest.getTeartest());
			pst.setString(14, insptest.getTeartested());
			pst.setString(15, insptest.getTearresult());
			pst.setString(16, insptest.getTearcomments());
			pst.setString(17, insptest.getGrainbreaktest());
			pst.setString(18, insptest.getGrainbreaktested());
			pst.setString(19, insptest.getGrainbreakresult());
			pst.setString(20, insptest.getGrainbreakcomments());
			pst.setString(21, insptest.getCrockingwettest());	
			pst.setString(22, insptest.getCrockingwettested());
			pst.setString(23, insptest.getCrockingwetresult());
			pst.setString(24, insptest.getCrockingwetcomments());
			pst.setString(25, insptest.getCrockingdrytest());
			pst.setString(26, insptest.getCrockingdrytested());
			pst.setString(27, insptest.getCrockingdryresult());
			pst.setString(28, insptest.getCrockingdrycomments());
			pst.setString(29, insptest.getFinishadhensiontest());
			pst.setString(30, insptest.getFinishadhensiontested());
			pst.setString(31, insptest.getFinishadhensionresult());
			pst.setString(32, insptest.getFinishadhensioncomments());
			pst.setString(33, insptest.getFourfoldstest());
			pst.setString(34, insptest.getFourfoldstested());
			pst.setString(35, insptest.getFourfoldsresult());
			pst.setString(36, insptest.getFourfoldscomments());
			pst.setString(37, insptest.getDyethrutest());
			pst.setString(38, insptest.getDyethrutested());
			pst.setString(39, insptest.getDyethruresult());
			pst.setString(40, insptest.getDyethrucomments());
			pst.setString(41, insptest.getOrganoleptictest());
			pst.setString(42, insptest.getOrganoleptictested());
			pst.setString(43, insptest.getOrganolepticresult());
			pst.setString(44, insptest.getOrganolepticcomments());
			//pst.setString(45, insptest.get);
			
			System.out.println("getTestid " +insptest.getTestid());
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
	public boolean getInspTestEditList(ManualTest insptest, String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveInsptest = new StringBuffer("UPDATE elpro.tbl_insptestdetails SET testid = ? , articleid = ? , color = ? , contractno = ? , colortest = ? , colorpieces = ? , colorresult = ?, colorcomments= ?, subtest= ?, subpieces= ?, subresult= ?, subcomments= ?, teartest= ?, tearpieces= ?, tearresult= ?, tearcomments= ?, graintest= ?, grainpieces= ?, grainresult= ?, graincomments= ?, crockwettest= ?, crockwetpieces= ?, crockwetresult= ?, crockwetcomments= ?, crockdrytest= ?, crockdrypieces= ?, crockdryresult= ?, crockdrycomments= ?, finishtest= ?, finishpieces= ?, finishresult= ?, fnishcomments= ?, fourtest = ?, fourpieces =?, fourresult = ?, fourcomments = ?, dyetest= ?, dyepieces= ?, dyeresult= ?, dyecomments= ?, orgtest= ?, orgpieces= ?, orgresult= ?, orgcomments = ?  WHERE id = '"+insptest.getId()+"' ");
			String sqlquery_saveInsptest = sql_saveInsptest.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveInsptest);
			pst.setString(1, insptest.getTestid());
			System.out.println("getTestid " +insptest.getTestid());
			pst.setString(2, insptest.getArticleid());
			pst.setString(3, insptest.getTestcolor());
			pst.setString(4, insptest.getContractno());
			pst.setString(5, insptest.getColortest());
			pst.setString(6, insptest.getColortested());
			pst.setString(7, insptest.getColorresult());
			pst.setString(8, insptest.getColorcomments());
			pst.setString(9, insptest.getSubtest());
			pst.setString(10, insptest.getSubtested());
			pst.setString(11, insptest.getSubresult());
			pst.setString(12, insptest.getSubcomments());
			pst.setString(13, insptest.getTeartest());
			pst.setString(14, insptest.getTeartested());
			pst.setString(15, insptest.getTearresult());
			pst.setString(16, insptest.getTearcomments());
			pst.setString(17, insptest.getGrainbreaktest());
			pst.setString(18, insptest.getGrainbreaktested());
			pst.setString(19, insptest.getGrainbreakresult());
			pst.setString(20, insptest.getGrainbreakcomments());
			pst.setString(21, insptest.getCrockingwettest());
			pst.setString(22, insptest.getCrockingwettested());
			pst.setString(23, insptest.getCrockingwetresult());
			pst.setString(24, insptest.getCrockingwetcomments());
			pst.setString(25, insptest.getCrockingdrytest());
			pst.setString(26, insptest.getCrockingdrytested());
			pst.setString(27, insptest.getCrockingdryresult());
			pst.setString(28, insptest.getCrockingdrycomments());
			pst.setString(29, insptest.getFinishadhensiontest());
			pst.setString(30, insptest.getFinishadhensiontested());
			pst.setString(31, insptest.getFinishadhensionresult());
			pst.setString(32, insptest.getFinishadhensioncomments());
			pst.setString(33, insptest.getFourfoldstest());
			pst.setString(34, insptest.getFourfoldstested());
			pst.setString(35, insptest.getFourfoldsresult());
			pst.setString(36, insptest.getFourfoldscomments());
			pst.setString(37, insptest.getDyethrutest());
			pst.setString(38, insptest.getDyethrutested());
			pst.setString(39, insptest.getDyethruresult());
			pst.setString(40, insptest.getDyethrucomments());
			pst.setString(41, insptest.getOrganoleptictest());
			pst.setString(42, insptest.getOrganoleptictested());
			pst.setString(43, insptest.getOrganolepticresult());
			pst.setString(44, insptest.getOrganolepticcomments());
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
	public boolean getInspTestDelList(ManualTest insptest,
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
	public ArrayList<InspectionGrade> getInspGradeList(String sidx,
			String sord, String artid) throws SQLException {
		ArrayList<InspectionGrade> inspgradearray = new ArrayList<InspectionGrade>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT id, gradeid, articleid, color, grtotinspected, grade1, skincount1, percent1, comment1, grade2, skincount2, percent2, comment2, grade3, skincount3, percent3, comment3, grade4, skincount4, percent4, comment4, grade5, skincount5, percent5, comment5, improvement, skincount6, percent6, comment6 FROM tbl_inspgradedetails where articleid ='"+artid+"' order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				InspectionGrade inspgradebean = new InspectionGrade();
			    inspgradebean.setId(rs.getString("id"));
			    inspgradebean.setGradeid(rs.getString("gradeid"));
				inspgradebean.setArtid(rs.getString("articleid"));
				inspgradebean.setGradecolor(rs.getString("color"));
				inspgradebean.setGrtotinspected(rs.getString("grtotinspected"));
				inspgradebean.setGrade1(rs.getString("grade1"));
				inspgradebean.setSkincount1(rs.getString("skincount1"));
				inspgradebean.setPercent1(rs.getString("percent1"));
				inspgradebean.setComment1(rs.getString("comment1"));
				inspgradebean.setGrade2(rs.getString("grade2"));
				inspgradebean.setSkincount2(rs.getString("skincount2"));
				inspgradebean.setPercent2(rs.getString("percent2"));
				inspgradebean.setComment2(rs.getString("comment2"));
				inspgradebean.setGrade3(rs.getString("grade3"));
				inspgradebean.setSkincount3(rs.getString("skincount3"));
				inspgradebean.setPercent3(rs.getString("percent3"));
				inspgradebean.setComment3(rs.getString("comment3"));
				
				inspgradebean.setGrade4(rs.getString("grade4"));
				inspgradebean.setSkincount4(rs.getString("skincount4"));
				inspgradebean.setPercent4(rs.getString("percent4"));
				inspgradebean.setComment4(rs.getString("comment4"));
				inspgradebean.setGrade5(rs.getString("grade5"));
				inspgradebean.setSkincount5(rs.getString("skincount5"));
				inspgradebean.setPercent5(rs.getString("percent5"));
				inspgradebean.setComment5(rs.getString("comment5"));
				
				inspgradebean.setImprovement(rs.getString("improvement"));
				inspgradebean.setSkincount6(rs.getString("skincount6"));
				inspgradebean.setPercent6(rs.getString("percent6"));
				inspgradebean.setComment6(rs.getString("comment6"));
				inspgradearray.add(inspgradebean);
			}
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
		}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		}	
		return inspgradearray;
	}

	@Override
	public boolean getInspGradeAddList(InspectionGrade  inspgrad, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveinspgrad = new StringBuffer("insert into tbl_inspgradedetails (gradeid, articleid, color, grtotinspected, grade1, skincount1, percent1, comment1, grade2, skincount2, percent2, comment2, grade3, skincount3, percent3, comment3, grade4, skincount4, percent4, comment4, grade5, skincount5, percent5, comment5, improvement, skincount6, percent6, comment6)");
			sql_saveinspgrad.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveinspgrad = sql_saveinspgrad.toString();
			
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveinspgrad);
			pst.setString(1, inspgrad.getGradeid());
			System.out.println("getGradeid " +inspgrad.getGradeid());
			pst.setString(2, inspgrad.getArtid());
			pst.setString(3, inspgrad.getGradecolor());
			pst.setString(4, inspgrad.getGrtotinspected());  
			pst.setString(5, inspgrad.getGrade1());
			pst.setString(6, inspgrad.getSkincount1());
			pst.setString(7, inspgrad.getPercent1());
			pst.setString(8, inspgrad.getComment1());
			pst.setString(9, inspgrad.getGrade2());
			pst.setString(10, inspgrad.getSkincount2());
			pst.setString(11, inspgrad.getPercent2());
			pst.setString(12, inspgrad.getComment2());
			pst.setString(13, inspgrad.getGrade3());
			pst.setString(14, inspgrad.getSkincount3());
			pst.setString(15, inspgrad.getPercent3());
			pst.setString(16, inspgrad.getComment3());
			pst.setString(17, inspgrad.getGrade4());
			pst.setString(18, inspgrad.getSkincount4());
			pst.setString(19, inspgrad.getPercent4());
			pst.setString(20, inspgrad.getComment4());
			pst.setString(21, inspgrad.getGrade5());
			pst.setString(22, inspgrad.getSkincount5());
			pst.setString(23, inspgrad.getPercent5());
			pst.setString(24, inspgrad.getComment5());
			pst.setString(25, inspgrad.getImprovement());
			pst.setString(26, inspgrad.getSkincount6());
			pst.setString(27, inspgrad.getPercent6());
			pst.setString(28, inspgrad.getComment6());
			System.out.println("getComment5 " +inspgrad.getComment5());
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
	public boolean getInspGradeEditList(InspectionGrade inspgrad, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveInspgrad = new StringBuffer("UPDATE elpro.tbl_inspgradedetails SET gradeid = ? , articleid = ? , color = ? ,grtotinspected = ? , grade1= ? , skincount1 = ? ,  percent1 = ? , comment1 = ?, grade2= ? , skincount2 = ? ,  percent2 = ? , comment2 = ?, grade3= ? , skincount3 = ? ,  percent3 = ? , comment3 = ?, grade4= ? , skincount4 = ? ,  percent4 = ? , comment4 = ?, grade5= ? , skincount5 = ? ,  percent5 = ? , comment5 = ?, improvement= ? , skincount6 = ? ,  percent6 = ? , comment6 = ?  WHERE id = '"+inspgrad.getId()+"' ");
			String sqlquery_saveInspgrad = sql_saveInspgrad.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveInspgrad);
			pst.setString(1, inspgrad.getGradeid());
			System.out.println("getGradeid " +inspgrad.getGradeid());
			pst.setString(2, inspgrad.getArtid());
			pst.setString(3, inspgrad.getGradecolor());
			pst.setString(4, inspgrad.getGrtotinspected()); 
			pst.setString(5, inspgrad.getGrade1());
			pst.setString(6, inspgrad.getSkincount1());
			pst.setString(7, inspgrad.getPercent1());
			pst.setString(8, inspgrad.getComment1());
			pst.setString(9, inspgrad.getGrade2());
			pst.setString(10, inspgrad.getSkincount2());
			pst.setString(11, inspgrad.getPercent2());
			pst.setString(12, inspgrad.getComment2());
			pst.setString(13, inspgrad.getGrade3());
			pst.setString(14, inspgrad.getSkincount3());
			pst.setString(15, inspgrad.getPercent3());
			pst.setString(16, inspgrad.getComment3());
			pst.setString(17, inspgrad.getGrade4());
			pst.setString(18, inspgrad.getSkincount4());
			pst.setString(19, inspgrad.getPercent4());
			pst.setString(20, inspgrad.getComment4());
			pst.setString(21, inspgrad.getGrade5());
			pst.setString(22, inspgrad.getSkincount5());
			pst.setString(23, inspgrad.getPercent5());
			pst.setString(24, inspgrad.getComment5());
			pst.setString(25, inspgrad.getImprovement());
			pst.setString(26, inspgrad.getSkincount6());
			pst.setString(27, inspgrad.getPercent6());
			pst.setString(28, inspgrad.getComment6());
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
	public boolean getInspGradeDelList(InspectionGrade inspgrad, String sidx,
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

	/* (non-Javadoc)
	 * @see sb.elpro.dao.InspectionDao#saveInspectionForm(sb.elpro.model.InspectionBean)
	 */
	@Override
	public boolean saveInspectionForm(InspectionBean inspbean)
			throws SQLException {
		System.out.println("In Sample Invoice SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isSaved =true;
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savinspform = new StringBuffer("insert into tbl_inspform (inspdate, qualitycontroller, contractno, articleid, inspcdn, totpassed, inspcomments)");
			sql_savinspform.append("values (?,?,?,?,?,?,?)");
			String sqlquery_savinspform = sql_savinspform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savinspform);
			pst.setString(1, inspbean.getInspdate());
			System.out.println("getInspdate " +inspbean.getInspdate());
			pst.setString(2, inspbean.getInspqualityctrlr());
			pst.setString(3, inspbean.getInspContractNo());
			pst.setString(4, inspbean.getArtidhidden());
			pst.setString(5, inspbean.getInsp_cdn());
			pst.setString(6, inspbean.getTotpassed());
			pst.setString(7, inspbean.getInspcomments());
			System.out.println("getComments " +inspbean.getComments());
			noofrows = pst.executeUpdate();
		System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isSaved = false;
			System.out.println("ERROR RESULT");
		}finally{
			con.close() ;
			pst.close();
		}	
	return isSaved;
	}

}
