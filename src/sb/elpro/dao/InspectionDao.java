/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.InspectionGrading;
import sb.elpro.model.InspectionManualTest;
import sb.elpro.model.InspectionRejects;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;




/**
 * @author Wahab
 *
 */
public interface InspectionDao {

	ArrayList<ProductDetails> getInspCtList(String inspctterm)throws SQLException;

	ArrayList<QualityCtrlrDetails> getInspQctrlrList(String qcterm)throws SQLException;

	ArrayList<ProductDetails> getInspArtList(String ctno)throws SQLException;

	//test
	ArrayList<InspectionManualTest> getInspTestList(String sidx, String sord)throws SQLException;

	boolean getInspTestAddList(InspectionManualTest insptest, String sidx,
			String sord)throws SQLException;

	boolean getInspTestEditList(InspectionManualTest insptest, String sidx, String sord)throws SQLException;

	
	boolean getInspTestDelList(InspectionManualTest insptest, String sidx,
			String sord)throws SQLException;

	//Grading
	ArrayList<InspectionGrading> getInspGradeList(String sidx, String sord)throws SQLException;

	boolean getInspGradeAddList(InspectionGrading inspgrad, String sidx,
			String sord) throws SQLException;

	boolean getInspGradeEditList(InspectionGrading inspgrad, String sidx,
			String sord)throws SQLException;

	boolean getInspGradeDelList(InspectionGrading inspgrad, String sidx,
			String sord) throws SQLException;

	//Rejetcs
	ArrayList<InspectionRejects> getInspRejList(String sidx, String sord)throws SQLException;

	boolean getInspRejAddList(InspectionRejects insprej, String sidx,
			String sord)throws SQLException;

	boolean getInspRejEditList(InspectionRejects insprej, String sidx,
			String sord)throws SQLException;

	boolean getInspRejDelList(InspectionRejects insprej, String sidx,
			String sord)throws SQLException;	


	
}
