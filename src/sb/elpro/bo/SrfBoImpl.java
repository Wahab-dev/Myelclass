/**
 * 
 */
package sb.elpro.bo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sb.elpro.model.SrfArticle;
import sb.elpro.dao.SrfDao;
import sb.elpro.dao.SrfDaoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.EndUsageDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 *
 */
public class SrfBoImpl implements SrfBo {
	private SrfDao srfdao;	
	public SrfBoImpl(){
		this.srfdao = new SrfDaoImpl();
	}
	@Override
	public int getSampleno() throws Exception {
		int sampleno = srfdao.getSampleno();
		/*if(sampleno == 0){
			String sampleno= "S0001";
		}*/		
		return sampleno;
	}
	@Override
	public ArrayList<HandledByDetails> getsrfhandledby(String term) throws Exception {
		ArrayList<HandledByDetails> srfhandledbyarray = srfdao.getsrfhandledby(term);
		//HandledByDetails srfhandledby = new HandledByDetails();
		/*if(srfhandledbyarray.isEmpty()){
			srfhandledbyarray.setHandledbyname("NA");
			srfhandledbyarray.add(srfhandledby);
		}	*/	
		return srfhandledbyarray;
	}
	@Override
	public ArrayList<EndUsageDetails> getsrfEndusage(String term) throws Exception {
		ArrayList<EndUsageDetails> srfendusagearray = srfdao.getsrfendusage(term);
		return srfendusagearray;
	}
	@Override
	public ArrayList<TanneryDetails> getTanneryDetails(String term) throws Exception {
		ArrayList<TanneryDetails> srftannerarray = srfdao.getTannery(term);
		System.out.println("List To Array"+srftannerarray.toArray());
		Iterator<TanneryDetails> iter =  srftannerarray.iterator();
		while (iter.hasNext()) {
			TanneryDetails type = iter.next();
			System.out.println("Tannery Values in Iter "+type.getTanneryName());			
		}
		return srftannerarray;
	}
	@Override
	public ArrayList<CustomerDetails> getCustomerDetails() throws Exception {
		ArrayList<CustomerDetails> srfcustomerarray = srfdao.getCustomer();
		return srfcustomerarray;
	}
	@Override
	public List<AutoComplete> getDestinationDetails(String term)
			throws Exception {
		List<AutoComplete> srfdestiarray = srfdao.getDestination(term);
		return srfdestiarray;
	}
	@Override
	public ArrayList<PaymentDetails> getPaymentDetails(String term) throws Exception {
		ArrayList<PaymentDetails> srfpaymentearray = srfdao.getPayment(term);
		return srfpaymentearray;
	}
	@Override
	public List<SrfArticle> getSrfArticleDetails(String sidx, String sord) throws Exception {
		ArrayList<SrfArticle> srfaticlearray = srfdao.getSrfArticleDetails(sidx, sord);
		return srfaticlearray;
	}
	@Override
	public boolean addSrfArticleDetails(SrfArticle artindertdetail,
			String sidx, String sord) throws Exception {
		boolean isadded = srfdao.addsrfArticle(artindertdetail, sidx, sord);
		return isadded;
	}
	@Override
	public boolean editSrfArticleDetails(SrfArticle artindertdetail,
			String sidx, String sord) throws Exception {
		boolean isupdated = srfdao.editsrfArticle(artindertdetail, sidx, sord);
		return isupdated;
	}
	@Override
	public boolean delPrfArticleDetails(SrfArticle artindertdetail,
			String sidx, String sord) throws Exception {
		boolean isdeleted = srfdao.delsrfArticle(artindertdetail, sidx, sord);
		return isdeleted;
	}
	

}
