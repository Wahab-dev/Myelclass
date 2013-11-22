/**
 * 
 */
package sb.elpro.bo;

import java.util.List;
import sb.elpro.model.InspectionBean;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;

/**
 * @author ADMIN_WIN7
 *
 */
public interface Inspectionbo {

	
	public List<ProductDetails> getInspCtDetails(String inspctterm)throws Exception;

	public List<QualityCtrlrDetails> getInspQltyCtlr(String qcterm)throws Exception;

	public List<ProductDetails> getInspArtDetails(String artterm)throws Exception;

	
	//Manual Test 
	public List<InspectionBean> getInspectionTestDetails(String sidx, String sord, String artid)throws Exception;

	public boolean getInspectionTestAddDetails(InspectionBean insptest, String sidx, String sord)throws Exception;

	public boolean getInspectionTesEditDetails(InspectionBean insptest, String sidx, String sord)throws Exception;

	public boolean getInspectionTesDelDetails(InspectionBean insptest,
			String sidx, String sord)throws Exception;

	//Grading test  
	public List<InspectionBean> getInspectionGradeDetails(String sidx,
			String sord, String artid)throws Exception;
	public boolean getInspectionGradeAddDetails(InspectionBean inspgrad,
			String sidx, String sord)throws Exception;

	public boolean getInspectionGradEditDetails(InspectionBean inspgrad,
			String sidx, String sord)throws Exception;

	public boolean getInspectionGradeDelDetails(InspectionBean inspgrad,
			String sidx, String sord)throws Exception;

	//Reject test  
	public List<InspectionBean> getInspectionRejDetails(String sidx,
			String sord, String artid)throws Exception;

	public boolean getInspectionRejAddDetails(InspectionBean insprej,
			String sidx, String sord)throws Exception;

	public boolean getInspectionRejEditDetails(InspectionBean insprej,
			String sidx, String sord)throws Exception;

	public boolean getInspectionGradeRejDetails(InspectionBean insprej,
			String sidx, String sord)throws Exception;

	
	
}
