/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;




/**
 * @author Wahab
 *
 */
public interface InspectionDao {

	ArrayList<ProductDetails> getInspCtList(String inspctterm)throws SQLException;

	ArrayList<QualityCtrlrDetails> getInspQctrlrList(String qcterm)throws SQLException;

	ArrayList<ProductDetails> getInspArtList(String ctno)throws SQLException;
}
