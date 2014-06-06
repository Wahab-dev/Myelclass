/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.DebitDao;
import sb.elpro.dao.DebitDaoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvBillDetails;
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
	public List<AutoComplete> getDebInvno(String invterm, String expname) throws Exception {
		ArrayList<AutoComplete> DebTanInvnarr = debdao.getDebTanInvno(invterm, expname);
		if(DebTanInvnarr.isEmpty()){
			autocomplt.setLabel("NA");
			DebTanInvnarr.add(autocomplt);
		}
		return DebTanInvnarr;
	}


	@Override
	public List<InvBillDetails> getDebitInvDetails(String invno) throws Exception {
		ArrayList<InvBillDetails> getDebInvnarr = debdao.getDebInvnolist(invno);
		return getDebInvnarr;
	}


	@Override
	public boolean setDebitWaive(String invid) throws Exception {
		boolean setDebWaived = debdao.setDebInvnoWaived(invid);
		return setDebWaived;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.DebitBo#saveDebitform(sb.elpro.model.DebitFormDetails)
	 */
	@Override
	public boolean saveDebitform(DebitFormDetails debformbean) throws Exception {
		boolean savedebfom = debdao.saveDebitFormDetails(debformbean);
		return savedebfom;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.DebitBo#getDebitTrackDetails(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<DebitFormDetails> getDebitTrackDetails(String sidx,
			String sord, String rows, String pag) throws Exception {
		ArrayList<DebitFormDetails> getDebitTrackarr = debdao.getDebitTracklist(sidx,sord );
		return getDebitTrackarr;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.DebitBo#getDebno(java.lang.String)
	 */
	@Override
	public String getDebno(String tanterm) throws Exception {
		String maxdebno = debdao.getDebitnoteno();
		return maxdebno;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.DebitBo#getEditDebFormValues(java.lang.String)
	 */
	@Override
	public List<DebitFormDetails> getEditDebFormValues(String deb_debitno)
			throws Exception {
		List<DebitFormDetails> debgeteditForm = debdao.getEditDebFormDetails(deb_debitno);
		return debgeteditForm;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.DebitBo#updtDebitform(sb.elpro.model.DebitFormDetails)
	 */
	@Override
	public boolean updtDebitform(DebitFormDetails debformbean) throws Exception {
		boolean isupdtDebForm = debdao.updtDebFormDetails(debformbean);
		return isupdtDebForm;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.DebitBo#getPayno(java.lang.String)
	 */
	@Override
	public String getPayno(String tanterm) throws Exception {
		String maxpayno = debdao.getPaynoteno();
		if(maxpayno.isEmpty() || maxpayno.equalsIgnoreCase("Null")){
			maxpayno = "P001/14-15";
		}		
		return maxpayno;
	}
	

}
