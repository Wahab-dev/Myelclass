/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.InspectionBean;
import sb.elpro.model.InspectionGrade;
import sb.elpro.model.ManualTest;
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
	ArrayList<ManualTest> getInspTestList(String sidx, String sord, String ctno)throws SQLException;

	boolean getInspTestAddList(ManualTest insptest, String sidx,
			String sord)throws SQLException;

	boolean getInspTestEditList(ManualTest insptest, String sidx, String sord)throws SQLException;

	
	boolean getInspTestDelList(ManualTest insptest, String sidx,
			String sord)throws SQLException;

	//Grading
	ArrayList<InspectionGrade> getInspGradeList(String sidx, String sord, String artid)throws SQLException;

	boolean getInspGradeAddList(InspectionGrade inspgrad, String sidx,
			String sord) throws SQLException;

	boolean getInspGradeEditList(InspectionGrade inspgrad, String sidx,
			String sord)throws SQLException;

	boolean getInspGradeDelList(InspectionGrade inspgrad, String sidx,
			String sord) throws SQLException;

	//Rejetcs
	ArrayList<InspectionBean> getInspRejList(String sidx, String sord, String artid)throws SQLException;

	boolean getInspRejAddList(InspectionBean insprej, String sidx,
			String sord)throws SQLException;

	boolean getInspRejEditList(InspectionBean insprej, String sidx,
			String sord)throws SQLException;

	boolean getInspRejDelList(InspectionBean insprej, String sidx,
			String sord)throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean saveInspectionForm(InspectionBean inspbean)throws SQLException;	


	
}
