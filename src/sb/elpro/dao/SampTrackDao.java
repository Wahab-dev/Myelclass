/**
 * 
 */
package sb.elpro.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public interface SampTrackDao {

	ArrayList<SampleTrack> getSampleTrackDetailList(String sidx, String sord) throws SQLException;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updateSrStatus(SampleTrack samplemodel, String sidx, String sord)throws SQLException;

}
