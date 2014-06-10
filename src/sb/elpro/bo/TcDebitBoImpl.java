/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.dao.TcDebitDao;
import sb.elpro.dao.TcDebitDaoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvoiceBean;

/**
 * @author Wahab
 *
 */
public class TcDebitBoImpl implements TcDebitBo {
	private TcDebitDao tcdebitdao;	
	/**
	 * 
	 */
	public TcDebitBoImpl(){
		this.tcdebitdao = new TcDebitDaoImpl();
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.TcDebitBo#getinvDetails(java.lang.String)
	 */
	@Override
	public List<InvoiceBean> getinvDetails(String invno) throws Exception {
		List<InvoiceBean> tcgetInvDetailslist = tcdebitdao.getinvDetails(invno);
		return tcgetInvDetailslist;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.TcDebitBo#saveTCDebitform(sb.elpro.model.DebitFormDetails)
	 */
	@Override
	public boolean saveTCDebitform(DebitFormDetails tcformbean)
			throws Exception {
		boolean savetcdebfom = tcdebitdao.saveTCDebitFormDetails(tcformbean);
		return savetcdebfom;
	}
	
	
}
