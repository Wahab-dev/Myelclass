/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;

import sb.elpro.dao.DebitDao;
import sb.elpro.dao.DebitDaoImpl;
import sb.elpro.model.RaiseDebit;

/**
 * @author ADMIN_WIN7
 *
 */
public class DebitBOImpl implements DebitBO {
	 private DebitDao debdao;
	 RaiseDebit debbean = new RaiseDebit();
	 
	 
	/**
	 * 
	 */
	public DebitBOImpl() {
		this.debdao = new DebitDaoImpl();
	}


	@Override
	public ArrayList<RaiseDebit> getDebExporter() throws Exception {
		ArrayList<RaiseDebit> debExporterarr = debdao.getDebExporter();
		if(debExporterarr.isEmpty()){
			debbean.setTannery("NA");
			debExporterarr.add(debbean);
		}
		return debExporterarr;
	}


	@Override
	public ArrayList<RaiseDebit> getDebTanInvno() throws Exception {
		ArrayList<RaiseDebit> DebTanInvnarr = debdao.getDebTanInvno();
		if(DebTanInvnarr.isEmpty()){
			debbean.setTaninvno("NA");
			DebTanInvnarr.add(debbean);
		}
		return DebTanInvnarr;
	}



}
