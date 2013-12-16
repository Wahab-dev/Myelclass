/**
 * 
 */
package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.SampTrackDao;
import sb.elpro.dao.SampTrackDaoImpl;
import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public class SampTrackBoImpl implements SampTrackBo {

		private SampTrackDao samptrackdao;
		
		public SampTrackBoImpl(){
			this.samptrackdao = new SampTrackDaoImpl();
		}

		@Override
		public List<SampleTrack> getSampleTrackDetails(String sidx, String sord)
				throws Exception {
			ArrayList<SampleTrack> sampletrackList = samptrackdao.getSampleTrackDetailList(sidx, sord);
			return sampletrackList;
		}

		/* (non-Javadoc)
		 * @see sb.elpro.bo.SampTrackBo#addStrStatus(sb.elpro.model.SampleTrack, java.lang.String, java.lang.String)
		 */
		@Override
		public boolean addStrStatus(SampleTrack samplemodel, String sidx,
				String sord) throws Exception {
			boolean isstatusupdate = samptrackdao.updateSrStatus(samplemodel, sidx, sord);
			return isstatusupdate;
		}
		
		
		
		
}
