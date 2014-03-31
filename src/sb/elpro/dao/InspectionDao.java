/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.InspectionBean;
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
	ArrayList<InspectionBean> getInspTestList(String sidx, String sord, String ctno)throws SQLException;

	boolean getInspTestAddList(InspectionBean insptest, String sidx,
			String sord)throws SQLException;

	boolean getInspTestEditList(InspectionBean insptest, String sidx, String sord)throws SQLException;

	
	boolean getInspTestDelList(InspectionBean insptest, String sidx,
			String sord)throws SQLException;

	//Grading
	ArrayList<InspectionBean> getInspGradeList(String sidx, String sord, String artid)throws SQLException;

	boolean getInspGradeAddList(InspectionBean inspgrad, String sidx,
			String sord) throws SQLException;

	boolean getInspGradeEditList(InspectionBean inspgrad, String sidx,
			String sord)throws SQLException;

	boolean getInspGradeDelList(InspectionBean inspgrad, String sidx,
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
