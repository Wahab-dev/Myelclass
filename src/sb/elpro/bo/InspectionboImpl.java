/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;

import sb.elpro.dao.InspectionDao;
import sb.elpro.dao.InspectionDaoImpl;
import sb.elpro.model.InspectionLoadBean;

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
	public ArrayList<?> getInspCtNo() throws Exception {
		ArrayList<?> inspctrct = inspdao.getInspContractNumber();
		
		return inspctrct;
	}

	@Override
	public ArrayList<?> getInspqtyctrlr() throws Exception {
		ArrayList<?> inspctrct = inspdao.getInspQtyCtrlr();
		
		return inspctrct;
	}

	
}
