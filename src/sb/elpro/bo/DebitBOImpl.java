/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.DebitDao;
import sb.elpro.dao.DebitDaoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.RaiseDebit;
import sb.elpro.model.TanneryDetails;

/**
 * @author ADMIN_WIN7
 *
 */
public class DebitBoImpl implements DebitBo {
	 private DebitDao debdao;
	 RaiseDebit debbean = new RaiseDebit();
	 TanneryDetails tanbean = new TanneryDetails();
	 AutoComplete autocomplt = new AutoComplete();
	 
	/**
	 * 
	 */
	public DebitBoImpl() {
		this.debdao = new DebitDaoImpl();
	}


	@Override
	public ArrayList<TanneryDetails> getDebExporter(String debexp) throws Exception {
		ArrayList<TanneryDetails> debExporterarr = debdao.getDebExporter(debexp);
		if(debExporterarr.isEmpty()){
			tanbean.setTanneryName("NA");
			debExporterarr.add(tanbean);
		}
		return debExporterarr;
	}


	@Override
	public List<AutoComplete> getDebInvno(String invterm) throws Exception {
		ArrayList<AutoComplete> DebTanInvnarr = debdao.getDebTanInvno(invterm);
		if(DebTanInvnarr.isEmpty()){
			autocomplt.setLabel("NA");
			DebTanInvnarr.add(autocomplt);
		}
		return DebTanInvnarr;
	}


	@Override
	public List<RaiseDebit> getDebitInvDetails(String invno) throws Exception {
		ArrayList<RaiseDebit> getDebInvnarr = debdao.getDebInvnolist(invno);
		return getDebInvnarr;
	}


	/*@Override
	public List<RaiseDebit> getDebitInvDetails(String invno) throws Exception {
		ArrayList<RaiseDebit> getDebInvnarr = debdao.getDebInvnolist(invno);
		return null;
	}*/


	


}
