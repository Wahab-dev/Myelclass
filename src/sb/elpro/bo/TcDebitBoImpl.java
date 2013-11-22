/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.dao.TcDebitDao;
import sb.elpro.dao.TcDebitDaoImpl;
import sb.elpro.model.InvoiceForm;

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
	public List<InvoiceForm> getinvDetails(String invno) throws Exception {
		List<InvoiceForm> tcgetInvDetailslist = tcdebitdao.getinvDetails(invno);
		return tcgetInvDetailslist;
	}
	
	
}
