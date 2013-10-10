/**
 * 
 */
package sb.elpro.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.InspectionDao;
import sb.elpro.dao.InspectionDaoImpl;
import sb.elpro.model.InspectionBean;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;
import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public class InspectionboImpl implements Inspectionbo {
	private InspectionDao inspdao;
	InspectionBean insploadbean = new InspectionBean();
	
	
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
	public List<InspectionBean> getInspectionTestDetails(String sidx, String sord)
			throws Exception {
		ArrayList<InspectionBean> InspTestList = inspdao.getInspTestList(sidx,sord);
		return InspTestList;
	}


	@Override
	public boolean getInspectionTestAddDetails(InspectionBean insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestAddList = inspdao.getInspTestAddList(insptest, sidx,sord);
		return InspTestAddList;
	}


	@Override
	public boolean getInspectionTesEditDetails(InspectionBean insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestEditList = inspdao.getInspTestEditList(insptest, sidx,sord);
		return InspTestEditList;
	}


	@Override
	public boolean getInspectionTesDelDetails(InspectionBean insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestDelList = inspdao.getInspTestDelList(insptest, sidx,sord);
		return InspTestDelList;
	}


	@Override
	public List<InspectionBean> getInspectionGradeDetails(String sidx,
			String sord) throws Exception {
		ArrayList<InspectionBean> InspGradeList = inspdao.getInspGradeList(sidx,sord);
		return InspGradeList;
	}


	@Override
	public boolean getInspectionGradeAddDetails(InspectionBean inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeAddList = inspdao.getInspGradeAddList(inspgrad, sidx,sord);
		return InspGradeAddList;
	}


	@Override
	public boolean getInspectionGradEditDetails(InspectionBean inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeEditList = inspdao.getInspGradeEditList(inspgrad, sidx,sord);
		return InspGradeEditList;
	}


	@Override
	public boolean getInspectionGradeDelDetails(InspectionBean inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeDelList = inspdao.getInspGradeDelList(inspgrad, sidx,sord);
		return InspGradeDelList;
	}


	@Override
	public List<InspectionBean> getInspectionRejDetails(String sidx,
			String sord) throws Exception {
		ArrayList<InspectionBean> InspRejList = inspdao.getInspRejList(sidx,sord);
		return InspRejList;
	}


	@Override
	public boolean getInspectionRejAddDetails(InspectionBean insprej,
			String sidx, String sord) throws SQLException {
		boolean InspRejAddList = inspdao.getInspRejAddList(insprej, sidx,sord);
		return InspRejAddList;
	}


	@Override
	public boolean getInspectionRejEditDetails(InspectionBean insprej,
			String sidx, String sord) throws Exception {
		boolean InspRejEditList = inspdao.getInspRejEditList(insprej, sidx,sord);
		return InspRejEditList;
	}


	@Override
	public boolean getInspectionGradeRejDetails(InspectionBean insprej,
			String sidx, String sord) throws SQLException {
		boolean InspRejDelList = inspdao.getInspRejDelList(insprej, sidx,sord);
		return InspRejDelList;
	}


	
	
	
}
