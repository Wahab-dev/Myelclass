/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.InvoiceBean;

/**
 * @author Wahab
 *
 */
public interface TcDebitBo  {

	/**
	 * Method to Return the COmplerte Invoice Details of the Contract  
	 * @param
	 * @return 
	 * etc
	 */
	List<InvoiceBean> getinvDetails(String invno) throws Exception;

	
}