/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;

import sb.elpro.dao.DebitDAO;
import sb.elpro.dao.DebitDAOImpl;
import sb.elpro.model.RaiseDebit;

/**
 * @author ADMIN_WIN7
 *
 */
public class DebitBOImpl implements DebitBO {
	 private DebitDAO debdao;
	 RaiseDebit debbean = new RaiseDebit();
	 
	 
	/**
	 * 
	 */
	public DebitBOImpl() {
		this.debdao = new DebitDAOImpl();
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
