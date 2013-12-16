/**
 * 
 */
package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public interface SampTrackBo {

	List<SampleTrack> getSampleTrackDetails(String sidx, String sord) throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addStrStatus(SampleTrack samplemodel, String sidx, String sord) throws Exception;

}
