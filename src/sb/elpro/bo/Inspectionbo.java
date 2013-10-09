/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.action.InvSelectCtfromCust;
import sb.elpro.model.InspectionGrading;
import sb.elpro.model.InspectionManualTest;
import sb.elpro.model.InspectionRejects;
import sb.elpro.model.InvCustContractDetails;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;
import sb.elpro.model.SampleTrack;

/**
 * @author ADMIN_WIN7
 *
 */
public interface Inspectionbo {

	
	public List<ProductDetails> getInspCtDetails(String inspctterm)throws Exception;

	public List<QualityCtrlrDetails> getInspQltyCtlr(String qcterm)throws Exception;

	public List<ProductDetails> getInspArtDetails(String artterm)throws Exception;

	
	//Manual Test 
	public List<InspectionManualTest> getInspectionTestDetails(String sidx, String sord)throws Exception;

	public boolean getInspectionTestAddDetails(InspectionManualTest insptest, String sidx, String sord)throws Exception;

	public boolean getInspectionTesEditDetails(InspectionManualTest insptest, String sidx, String sord)throws Exception;

	public boolean getInspectionTesDelDetails(InspectionManualTest insptest,
			String sidx, String sord)throws Exception;

	//Grading test  
	public List<InspectionGrading> getInspectionGradeDetails(String sidx,
			String sord)throws Exception;
	public boolean getInspectionGradeAddDetails(InspectionGrading inspgrad,
			String sidx, String sord)throws Exception;

	public boolean getInspectionGradEditDetails(InspectionGrading inspgrad,
			String sidx, String sord)throws Exception;

	public boolean getInspectionGradeDelDetails(InspectionGrading inspgrad,
			String sidx, String sord)throws Exception;

	//Reject test  
	public List<InspectionRejects> getInspectionRejDetails(String sidx,
			String sord)throws Exception;

	public boolean getInspectionRejAddDetails(InspectionRejects insprej,
			String sidx, String sord)throws Exception;

	public boolean getInspectionRejEditDetails(InspectionRejects insprej,
			String sidx, String sord)throws Exception;

	public boolean getInspectionGradeRejDetails(InspectionRejects insprej,
			String sidx, String sord)throws Exception;

	
	
}
