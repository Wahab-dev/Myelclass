/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.action.InvSelectCtfromCust;
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

	public List<SampleTrack> getInspectionTestDetails(String sidx, String sord)throws Exception;
}
