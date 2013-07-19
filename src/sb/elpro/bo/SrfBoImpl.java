/**
 * 
 */
package sb.elpro.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sb.elpro.action.SrfArticle;
import sb.elpro.dao.SrfDao;
import sb.elpro.dao.SrfDaoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.DestinationDetailstemp;
import sb.elpro.model.EndUsageDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.PrfArticle;
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
	public ArrayList<HandledByDetails> getsrfhandledby() throws Exception {
		ArrayList<HandledByDetails> srfhandledbyarray = srfdao.getsrfhandledby();
		//HandledByDetails srfhandledby = new HandledByDetails();
		/*if(srfhandledbyarray.isEmpty()){
			srfhandledbyarray.setHandledbyname("NA");
			srfhandledbyarray.add(srfhandledby);
		}	*/	
		return srfhandledbyarray;
	}
	@Override
	public ArrayList<EndUsageDetails> getsrfEndusage() throws Exception {
		ArrayList<EndUsageDetails> srfendusagearray = srfdao.getsrfendusage();
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
	public ArrayList<PaymentDetails> getPaymentDetails() throws Exception {
		ArrayList<PaymentDetails> srfpaymentearray = srfdao.getPayment();
		return srfpaymentearray;
	}
	@Override
	public List<SrfArticle> getSrfArticleDetails(String sno) throws Exception {
		ArrayList<SrfArticle> srfaticlearray = srfdao.getSrfArticleDetails(sno);
		return srfaticlearray;
	}
	

}
