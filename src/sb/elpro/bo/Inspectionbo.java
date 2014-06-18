/**
 * 
 */
package sb.elpro.bo;

import java.util.List;
import sb.elpro.model.InspectionBean;
import sb.elpro.model.InspectionGrade;
import sb.elpro.model.ManualTest;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;

/**
 * @author Wahab
 *
 */

public interface InspectionBo {
	
	/**
	 * Method to Return 
	 * @param type 
	 * @param
	 * @return 
	 * etc
	 */
	public List<ProductDetails> getInspCtDetails(String inspctterm, String type)throws Exception;
	
	
	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	
	public List<QualityCtrlrDetails> getInspQltyCtlr(String qcterm)throws Exception;
	
	
	/**
	 * Method to Return 
	 * @param type 
	 * @param
	 * @return 
	 * etc
	 */
	public List<ProductDetails> getInspArtDetails(String artterm, String type)throws Exception;
	
	
	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	//Manual Test 
	public List<ManualTest> getInspectionTestDetails(String sidx, String sord, String artid)throws Exception;
	
	
	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionTestAddDetails(ManualTest insptest, String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionTesEditDetails(ManualTest insptest, String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionTesDelDetails(ManualTest insptest,
			String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	//Grading test  
	public List<InspectionGrade> getInspectionGradeDetails(String sidx,
			String sord, String artid)throws Exception;
	
	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionGradeAddDetails(InspectionGrade inspgrad,
			String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionGradEditDetails(InspectionGrade inspgrad,
			String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionGradeDelDetails(InspectionGrade inspgrad,
			String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	//Reject test  
	public List<InspectionBean> getInspectionRejDetails(String sidx,
			String sord, String artid)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionRejAddDetails(InspectionBean insprej,
			String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionRejEditDetails(InspectionBean insprej,
			String sidx, String sord)throws Exception;

	/**
	 * Method to Return 
	 * @param
	 * @return 
	 * etc
	 */
	public boolean getInspectionGradeRejDetails(InspectionBean insprej,
			String sidx, String sord)throws Exception;


	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	public boolean saveInspectionform(InspectionBean inspbean)throws Exception;

	

	
	
}
