/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.InspectionDao;
import sb.elpro.dao.InspectionDaoImpl;
import sb.elpro.model.InspectionLoadBean;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;
import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public class InspectionboImpl implements Inspectionbo {
	private InspectionDao inspdao;
	InspectionLoadBean insploadbean = new InspectionLoadBean();
	
	
	public InspectionboImpl(){
		this.inspdao = new InspectionDaoImpl(); 			
	}
	
	
	@Override
	public List<ProductDetails> getInspCtDetails(String inspctterm) throws Exception {
		ArrayList<ProductDetails> InspCtList = inspdao.getInspCtList(inspctterm);
		return InspCtList;
	}


	@Override
	public List<QualityCtrlrDetails> getInspQltyCtlr(String qcterm) throws Exception {
		ArrayList<QualityCtrlrDetails> InspqcList = inspdao.getInspQctrlrList(qcterm);
		return InspqcList;
	}


	@Override
	public List<ProductDetails> getInspArtDetails(String ctno) throws Exception {
		ArrayList<ProductDetails> InspArtList = inspdao.getInspArtList(ctno);
		return InspArtList;
	}


	@Override
	public List<SampleTrack> getInspectionTestDetails(String sidx, String sord)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
