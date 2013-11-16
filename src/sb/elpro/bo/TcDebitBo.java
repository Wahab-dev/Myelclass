/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.InvoiceForm;

/**
 * @author Wahab
 *
 */
public interface TcDebitBo  {

	List<InvoiceForm> getinvDetails(String invno) throws Exception;

	
}
