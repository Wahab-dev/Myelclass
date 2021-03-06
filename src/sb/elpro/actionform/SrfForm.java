/**
 * 
 */
package sb.elpro.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */
public class SrfForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7800330383675319633L;
	
	
	//Form Values
	private String srf_sampleno;
	private String srf_agentname;
	private String srf_orderdate;
	private String srf_poreftype;
	private String srf_referenceno;
	private String srf_priority;
	private String srf_handledby;
	private String srf_customer;
	private String srf_customerid;
	private String srf_tanname;
	private String srf_tannameid;
	private String srf_tanattn;
	private String srf_tanaddr;	
	private String srf_tanphone;
	private String srf_tanfax;
	/*private String srf_custname;
	private String srf_custattn;	
	private String srf_custaddr;
	private String srf_custphone;
	private String srf_custfax;	
	private String srf_custacctno;*/
	private String srf_endusage;	
	private String srf_destination;	
	private String srf_paymentterms;	
	private String srf_cdd;	
	private String srf_add;	
	private String srf_deliver;
	private String srf_deliverid;
	private String srf_deliverattn;
	private String srf_deliveraddr;
	private String srf_deliverphone;
	private String srf_deliverfax;
	private String srf_deliveracctno;
	private String srf_splcdn;	
	private String srf_inspcdn; 
	private String srf_forwarder; 
	
	
	//Article Values
	private String srf_articleid;
	private String srf_articlename;
	private String srf_color;
	private String srf_substancemin;
	private String srf_substancemax;
	private String srf_substance;
	private String srf_sizemin;
	private String srf_sizemax;
	private String srf_sizeavg;
	private String srf_articletype;
	private String srf_selection;
	private String srf_selectionp1;
	private String srf_selectionp2;
	private String srf_selectionp3;
	private String srf_selectionp4;
	private String srf_quantity;
	private String srf_unit;
	private String srf_pieces;
	private String srf_ratesign;
	private String srf_rate;	
	private String srf_shipment;
	private String srf_tcamt;
	private String srf_tccurrency;
	private String srf_tcagent;
	private String srf_colormatching;
	private String srf_tapetest;
	private String srf_drynoofrubs;
	private String srf_wetnoofrubs;
	private String srf_fourfolds;
	private String srf_keytest;
	private String srf_size;
	private String srf_tc;
	private String srf_selectionp;
	private String srf_srfarticleid;
	
	//Sample status
	private String srf_status;
	private String srf_courier;
	private String srf_feedback;
	private String srf_isSample;
	private String srfactionform;
	
	private String srfaction;
	/**
	 * @return the srf_sampleno
	 */
	public String getSrf_sampleno() {
		return srf_sampleno;
	}
	/**
	 * @param srf_sampleno the srf_sampleno to set
	 */
	public void setSrf_sampleno(String srf_sampleno) {
		this.srf_sampleno = srf_sampleno;
	}
	/**
	 * @return the srf_orderdate
	 */
	public String getSrf_orderdate() {
		return srf_orderdate;
	}
	/**
	 * @param srf_orderdate the srf_orderdate to set
	 */
	public void setSrf_orderdate(String srf_orderdate) {
		this.srf_orderdate = srf_orderdate;
	}
	/**
	 * @return the srf_referenceno
	 */
	public String getSrf_referenceno() {
		return srf_referenceno;
	}
	/**
	 * @param srf_referenceno the srf_referenceno to set
	 */
	public void setSrf_referenceno(String srf_referenceno) {
		this.srf_referenceno = srf_referenceno;
	}
	/**
	 * @return the srf_priority
	 */
	public String getSrf_priority() {
		return srf_priority;
	}
	/**
	 * @param srf_priority the srf_priority to set
	 */
	public void setSrf_priority(String srf_priority) {
		this.srf_priority = srf_priority;
	}
	/**
	 * @return the srf_handledby
	 */
	public String getSrf_handledby() {
		return srf_handledby;
	}
	/**
	 * @param srf_handledby the srf_handledby to set
	 */
	public void setSrf_handledby(String srf_handledby) {
		this.srf_handledby = srf_handledby;
	}
	/**
	 * @return the srf_customer
	 */
	public String getSrf_customer() {
		return srf_customer;
	}
	/**
	 * @param srf_customer the srf_customer to set
	 */
	public void setSrf_customer(String srf_customer) {
		this.srf_customer = srf_customer;
	}
	/**
	 * @return the srf_tanname
	 */
	public String getSrf_tanname() {
		return srf_tanname;
	}
	/**
	 * @param srf_tanname the srf_tanname to set
	 */
	public void setSrf_tanname(String srf_tanname) {
		this.srf_tanname = srf_tanname;
	}
	/**
	 * @return the srf_tanattn
	 */
	public String getSrf_tanattn() {
		return srf_tanattn;
	}
	/**
	 * @param srf_tanattn the srf_tanattn to set
	 */
	public void setSrf_tanattn(String srf_tanattn) {
		this.srf_tanattn = srf_tanattn;
	}
	/**
	 * @return the srf_tanaddr
	 */
	public String getSrf_tanaddr() {
		return srf_tanaddr;
	}
	/**
	 * @param srf_tanaddr the srf_tanaddr to set
	 */
	public void setSrf_tanaddr(String srf_tanaddr) {
		this.srf_tanaddr = srf_tanaddr;
	}
	/**
	 * @return the srf_tanphone
	 */
	public String getSrf_tanphone() {
		return srf_tanphone;
	}
	/**
	 * @param srf_tanphone the srf_tanphone to set
	 */
	public void setSrf_tanphone(String srf_tanphone) {
		this.srf_tanphone = srf_tanphone;
	}
	/**
	 * @return the srf_tanfax
	 */
	public String getSrf_tanfax() {
		return srf_tanfax;
	}
	/**
	 * @param srf_tanfax the srf_tanfax to set
	 */
	public void setSrf_tanfax(String srf_tanfax) {
		this.srf_tanfax = srf_tanfax;
	}
	/**
	 * @return the srf_custname
	 */
	
	/**
	 * @return the srf_endusage
	 */
	public String getSrf_endusage() {
		return srf_endusage;
	}
	/**
	 * @param srf_endusage the srf_endusage to set
	 */
	public void setSrf_endusage(String srf_endusage) {
		this.srf_endusage = srf_endusage;
	}
	/**
	 * @return the srf_destination
	 */
	public String getSrf_destination() {
		return srf_destination;
	}
	/**
	 * @param srf_destination the srf_destination to set
	 */
	public void setSrf_destination(String srf_destination) {
		this.srf_destination = srf_destination;
	}
	/**
	 * @return the srf_paymentterms
	 */
	public String getSrf_paymentterms() {
		return srf_paymentterms;
	}
	/**
	 * @param srf_paymentterms the srf_paymentterms to set
	 */
	public void setSrf_paymentterms(String srf_paymentterms) {
		this.srf_paymentterms = srf_paymentterms;
	}
	/**
	 * @return the srf_cdd
	 */
	public String getSrf_cdd() {
		return srf_cdd;
	}
	/**
	 * @param srf_cdd the srf_cdd to set
	 */
	public void setSrf_cdd(String srf_cdd) {
		this.srf_cdd = srf_cdd;
	}
	/**
	 * @return the srf_add
	 */
	public String getSrf_add() {
		return srf_add;
	}
	/**
	 * @param srf_add the srf_add to set
	 */
	public void setSrf_add(String srf_add) {
		this.srf_add = srf_add;
	}
	/**
	 * @return the srf_deliver
	 */
	public String getSrf_deliver() {
		return srf_deliver;
	}
	/**
	 * @param srf_deliver the srf_deliver to set
	 */
	public void setSrf_deliver(String srf_deliver) {
		this.srf_deliver = srf_deliver;
	}
	/**
	 * @return the srf_splcdn
	 */
	public String getSrf_splcdn() {
		return srf_splcdn;
	}
	/**
	 * @param srf_splcdn the srf_splcdn to set
	 */
	public void setSrf_splcdn(String srf_splcdn) {
		this.srf_splcdn = srf_splcdn;
	}
	
	/**
	 * @return the srf_articleid
	 */
	public String getSrf_articleid() {
		return srf_articleid;
	}
	/**
	 * @param srf_articleid the srf_articleid to set
	 */
	public void setSrf_articleid(String srf_articleid) {
		this.srf_articleid = srf_articleid;
	}
	/**
	 * @return the srf_articlename
	 */
	public String getSrf_articlename() {
		return srf_articlename;
	}
	/**
	 * @param srf_articlename the srf_articlename to set
	 */
	public void setSrf_articlename(String srf_articlename) {
		this.srf_articlename = srf_articlename;
	}
	/**
	 * @return the srf_color
	 */
	public String getSrf_color() {
		return srf_color;
	}
	/**
	 * @param srf_color the srf_color to set
	 */
	public void setSrf_color(String srf_color) {
		this.srf_color = srf_color;
	}
	/**
	 * @return the srf_substancemin
	 */
	public String getSrf_substancemin() {
		return srf_substancemin;
	}
	/**
	 * @param srf_substancemin the srf_substancemin to set
	 */
	public void setSrf_substancemin(String srf_substancemin) {
		this.srf_substancemin = srf_substancemin;
	}
	/**
	 * @return the srf_substancemax
	 */
	public String getSrf_substancemax() {
		return srf_substancemax;
	}
	/**
	 * @param srf_substancemax the srf_substancemax to set
	 */
	public void setSrf_substancemax(String srf_substancemax) {
		this.srf_substancemax = srf_substancemax;
	}
	/**
	 * @return the srf_substance
	 */
	public String getSrf_substance() {
		return srf_substance;
	}
	/**
	 * @param srf_substance the srf_substance to set
	 */
	public void setSrf_substance(String srf_substance) {
		this.srf_substance = srf_substance;
	}
	/**
	 * @return the srf_sizemin
	 */
	public String getSrf_sizemin() {
		return srf_sizemin;
	}
	/**
	 * @param srf_sizemin the srf_sizemin to set
	 */
	public void setSrf_sizemin(String srf_sizemin) {
		this.srf_sizemin = srf_sizemin;
	}
	/**
	 * @return the srf_sizemax
	 */
	public String getSrf_sizemax() {
		return srf_sizemax;
	}
	/**
	 * @param srf_sizemax the srf_sizemax to set
	 */
	public void setSrf_sizemax(String srf_sizemax) {
		this.srf_sizemax = srf_sizemax;
	}
	/**
	 * @return the srf_sizeavg
	 */
	public String getSrf_sizeavg() {
		return srf_sizeavg;
	}
	/**
	 * @param srf_sizeavg the srf_sizeavg to set
	 */
	public void setSrf_sizeavg(String srf_sizeavg) {
		this.srf_sizeavg = srf_sizeavg;
	}
	/**
	 * @return the srf_articletype
	 */
	public String getSrf_articletype() {
		return srf_articletype;
	}
	/**
	 * @param srf_articletype the srf_articletype to set
	 */
	public void setSrf_articletype(String srf_articletype) {
		this.srf_articletype = srf_articletype;
	}
	/**
	 * @return the srf_selection
	 */
	public String getSrf_selection() {
		return srf_selection;
	}
	/**
	 * @param srf_selection the srf_selection to set
	 */
	public void setSrf_selection(String srf_selection) {
		this.srf_selection = srf_selection;
	}
	/**
	 * @return the srf_selectionp1
	 */
	public String getSrf_selectionp1() {
		return srf_selectionp1;
	}
	/**
	 * @param srf_selectionp1 the srf_selectionp1 to set
	 */
	public void setSrf_selectionp1(String srf_selectionp1) {
		this.srf_selectionp1 = srf_selectionp1;
	}
	/**
	 * @return the srf_selectionp2
	 */
	public String getSrf_selectionp2() {
		return srf_selectionp2;
	}
	/**
	 * @param srf_selectionp2 the srf_selectionp2 to set
	 */
	public void setSrf_selectionp2(String srf_selectionp2) {
		this.srf_selectionp2 = srf_selectionp2;
	}
	/**
	 * @return the srf_selectionp3
	 */
	public String getSrf_selectionp3() {
		return srf_selectionp3;
	}
	/**
	 * @param srf_selectionp3 the srf_selectionp3 to set
	 */
	public void setSrf_selectionp3(String srf_selectionp3) {
		this.srf_selectionp3 = srf_selectionp3;
	}
	/**
	 * @return the srf_selectionp4
	 */
	public String getSrf_selectionp4() {
		return srf_selectionp4;
	}
	/**
	 * @param srf_selectionp4 the srf_selectionp4 to set
	 */
	public void setSrf_selectionp4(String srf_selectionp4) {
		this.srf_selectionp4 = srf_selectionp4;
	}
	/**
	 * @return the srf_quantity
	 */
	public String getSrf_quantity() {
		return srf_quantity;
	}
	/**
	 * @param srf_quantity the srf_quantity to set
	 */
	public void setSrf_quantity(String srf_quantity) {
		this.srf_quantity = srf_quantity;
	}
	/**
	 * @return the srf_unit
	 */
	public String getSrf_unit() {
		return srf_unit;
	}
	/**
	 * @param srf_unit the srf_unit to set
	 */
	public void setSrf_unit(String srf_unit) {
		this.srf_unit = srf_unit;
	}
	/**
	 * @return the srf_pieces
	 */
	public String getSrf_pieces() {
		return srf_pieces;
	}
	/**
	 * @param srf_pieces the srf_pieces to set
	 */
	public void setSrf_pieces(String srf_pieces) {
		this.srf_pieces = srf_pieces;
	}
	/**
	 * @return the srf_ratesign
	 */
	public String getSrf_ratesign() {
		return srf_ratesign;
	}
	/**
	 * @param srf_ratesign the srf_ratesign to set
	 */
	public void setSrf_ratesign(String srf_ratesign) {
		this.srf_ratesign = srf_ratesign;
	}
	/**
	 * @return the srf_rate
	 */
	public String getSrf_rate() {
		return srf_rate;
	}
	/**
	 * @param srf_rate the srf_rate to set
	 */
	public void setSrf_rate(String srf_rate) {
		this.srf_rate = srf_rate;
	}
	/**
	 * @return the srf_shipment
	 */
	public String getSrf_shipment() {
		return srf_shipment;
	}
	/**
	 * @param srf_shipment the srf_shipment to set
	 */
	public void setSrf_shipment(String srf_shipment) {
		this.srf_shipment = srf_shipment;
	}
	/**
	 * @return the srf_tcamt
	 */
	public String getSrf_tcamt() {
		return srf_tcamt;
	}
	/**
	 * @param srf_tcamt the srf_tcamt to set
	 */
	public void setSrf_tcamt(String srf_tcamt) {
		this.srf_tcamt = srf_tcamt;
	}
	/**
	 * @return the srf_tccurrency
	 */
	public String getSrf_tccurrency() {
		return srf_tccurrency;
	}
	/**
	 * @param srf_tccurrency the srf_tccurrency to set
	 */
	public void setSrf_tccurrency(String srf_tccurrency) {
		this.srf_tccurrency = srf_tccurrency;
	}
	/**
	 * @return the srf_tcagent
	 */
	public String getSrf_tcagent() {
		return srf_tcagent;
	}
	/**
	 * @param srf_tcagent the srf_tcagent to set
	 */
	public void setSrf_tcagent(String srf_tcagent) {
		this.srf_tcagent = srf_tcagent;
	}
	/**
	 * @return the srf_colormatching
	 */
	public String getSrf_colormatching() {
		return srf_colormatching;
	}
	/**
	 * @param srf_colormatching the srf_colormatching to set
	 */
	public void setSrf_colormatching(String srf_colormatching) {
		this.srf_colormatching = srf_colormatching;
	}
	/**
	 * @return the srf_tapetest
	 */
	public String getSrf_tapetest() {
		return srf_tapetest;
	}
	/**
	 * @param srf_tapetest the srf_tapetest to set
	 */
	public void setSrf_tapetest(String srf_tapetest) {
		this.srf_tapetest = srf_tapetest;
	}
	/**
	 * @return the srf_drynoofrubs
	 */
	public String getSrf_drynoofrubs() {
		return srf_drynoofrubs;
	}
	/**
	 * @param srf_drynoofrubs the srf_drynoofrubs to set
	 */
	public void setSrf_drynoofrubs(String srf_drynoofrubs) {
		this.srf_drynoofrubs = srf_drynoofrubs;
	}
	/**
	 * @return the srf_wetnoofrubs
	 */
	public String getSrf_wetnoofrubs() {
		return srf_wetnoofrubs;
	}
	/**
	 * @param srf_wetnoofrubs the srf_wetnoofrubs to set
	 */
	public void setSrf_wetnoofrubs(String srf_wetnoofrubs) {
		this.srf_wetnoofrubs = srf_wetnoofrubs;
	}
	/**
	 * @return the srf_fourfolds
	 */
	public String getSrf_fourfolds() {
		return srf_fourfolds;
	}
	/**
	 * @param srf_fourfolds the srf_fourfolds to set
	 */
	public void setSrf_fourfolds(String srf_fourfolds) {
		this.srf_fourfolds = srf_fourfolds;
	}
	/**
	 * @return the srf_keytest
	 */
	public String getSrf_keytest() {
		return srf_keytest;
	}
	/**
	 * @param srf_keytest the srf_keytest to set
	 */
	public void setSrf_keytest(String srf_keytest) {
		this.srf_keytest = srf_keytest;
	}
	/**
	 * @return the srf_size
	 */
	public String getSrf_size() {
		return srf_size;
	}
	/**
	 * @param srf_size the srf_size to set
	 */
	public void setSrf_size(String srf_size) {
		this.srf_size = srf_size;
	}
	/**
	 * @return the srf_tc
	 */
	public String getSrf_tc() {
		return srf_tc;
	}
	/**
	 * @param srf_tc the srf_tc to set
	 */
	public void setSrf_tc(String srf_tc) {
		this.srf_tc = srf_tc;
	}
	/**
	 * @return the srf_selectionp
	 */
	public String getSrf_selectionp() {
		return srf_selectionp;
	}
	/**
	 * @param srf_selectionp the srf_selectionp to set
	 */
	public void setSrf_selectionp(String srf_selectionp) {
		this.srf_selectionp = srf_selectionp;
	}
	/**
	 * @return the srf_srfarticleid
	 */
	public String getSrf_srfarticleid() {
		return srf_srfarticleid;
	}
	/**
	 * @param srf_srfarticleid the srf_srfarticleid to set
	 */
	public void setSrf_srfarticleid(String srf_srfarticleid) {
		this.srf_srfarticleid = srf_srfarticleid;
	}
	/**
	 * @return the srf_status
	 */
	public String getSrf_status() {
		return srf_status;
	}
	/**
	 * @param srf_status the srf_status to set
	 */
	public void setSrf_status(String srf_status) {
		this.srf_status = srf_status;
	}
	/**
	 * @return the srf_courier
	 */
	public String getSrf_courier() {
		return srf_courier;
	}
	/**
	 * @param srf_courier the srf_courier to set
	 */
	public void setSrf_courier(String srf_courier) {
		this.srf_courier = srf_courier;
	}
	/**
	 * @return the srf_feedback
	 */
	public String getSrf_feedback() {
		return srf_feedback;
	}
	/**
	 * @param srf_feedback the srf_feedback to set
	 */
	public void setSrf_feedback(String srf_feedback) {
		this.srf_feedback = srf_feedback;
	}
	/**
	 * @return the srf_isSample
	 */
	public String getSrf_isSample() {
		return srf_isSample;
	}
	/**
	 * @param srf_isSample the srf_isSample to set
	 */
	public void setSrf_isSample(String srf_isSample) {
		this.srf_isSample = srf_isSample;
	}
	/**
	 * @return the srf_agentname
	 */
	public String getSrf_agentname() {
		return srf_agentname;
	}
	/**
	 * @param srf_agentname the srf_agentname to set
	 */
	public void setSrf_agentname(String srf_agentname) {
		this.srf_agentname = srf_agentname;
	}
	/**
	 * @return the srf_inspcdn
	 */
	public String getSrf_inspcdn() {
		return srf_inspcdn;
	}
	/**
	 * @param srf_inspcdn the srf_inspcdn to set
	 */
	public void setSrf_inspcdn(String srf_inspcdn) {
		this.srf_inspcdn = srf_inspcdn;
	}
	/**
	 * @return the srf_poreftype
	 */
	public String getSrf_poreftype() {
		return srf_poreftype;
	}
	/**
	 * @param srf_poreftype the srf_poreftype to set
	 */
	public void setSrf_poreftype(String srf_poreftype) {
		this.srf_poreftype = srf_poreftype;
	}
	/**
	 * @return the srf_forwarder
	 */
	public String getSrf_forwarder() {
		return srf_forwarder;
	}
	/**
	 * @param srf_forwarder the srf_forwarder to set
	 */
	public void setSrf_forwarder(String srf_forwarder) {
		this.srf_forwarder = srf_forwarder;
	}
	
	
		/* (non-Javadoc)
		 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
		 */
		@Override
		public void reset(ActionMapping mapping, HttpServletRequest request) {
			
			System.out.println("IN SRF CLEAR FORM ");
			srf_sampleno ="";
			srf_agentname ="";
			srf_orderdate ="";
			srf_poreftype ="";
			srf_referenceno ="";
			srf_priority ="";
			srf_handledby ="";
			srf_customer ="";
			srf_tanname ="";
			srf_tanattn ="";
			srf_tanaddr ="";	
			srf_tanphone ="";
			srf_tanfax ="";
			srf_endusage ="";	
			srf_destination ="";	
			srf_paymentterms ="";	
			srf_cdd ="";	
			srf_add ="";	
			srf_deliver ="";
			srf_deliverattn ="";
			srf_deliveraddr ="";
			srf_deliverphone ="";
			srf_deliverfax ="";
			srf_splcdn ="";	
			srf_inspcdn =""; 
			srf_forwarder =""; 
			//super.reset(mapping, request);
		}
		/**
		 * @return the srfactionform
		 */
		public String getSrfactionform() {
			return srfactionform;
		}
		/**
		 * @param srfactionform the srfactionform to set
		 */
		public void setSrfactionform(String srfactionform) {
			this.srfactionform = srfactionform;
		}
		
		/**
		 * @return the srf_deliverattn
		 */
		public String getSrf_deliverattn() {
			return srf_deliverattn;
		}
		/**
		 * @param srf_deliverattn the srf_deliverattn to set
		 */
		public void setSrf_deliverattn(String srf_deliverattn) {
			this.srf_deliverattn = srf_deliverattn;
		}
		/**
		 * @return the srf_deliveraddr
		 */
		public String getSrf_deliveraddr() {
			return srf_deliveraddr;
		}
		/**
		 * @param srf_deliveraddr the srf_deliveraddr to set
		 */
		public void setSrf_deliveraddr(String srf_deliveraddr) {
			this.srf_deliveraddr = srf_deliveraddr;
		}
		/**
		 * @return the srf_deliverphone
		 */
		public String getSrf_deliverphone() {
			return srf_deliverphone;
		}
		/**
		 * @param srf_deliverphone the srf_deliverphone to set
		 */
		public void setSrf_deliverphone(String srf_deliverphone) {
			this.srf_deliverphone = srf_deliverphone;
		}
		/**
		 * @return the srf_deliverfax
		 */
		public String getSrf_deliverfax() {
			return srf_deliverfax;
		}
		/**
		 * @param srf_deliverfax the srf_deliverfax to set
		 */
		public void setSrf_deliverfax(String srf_deliverfax) {
			this.srf_deliverfax = srf_deliverfax;
		}
		/**
		 * @return the srf_customerid
		 */
		public String getSrf_customerid() {
			return srf_customerid;
		}
		/**
		 * @param srf_customerid the srf_customerid to set
		 */
		public void setSrf_customerid(String srf_customerid) {
			this.srf_customerid = srf_customerid;
		}
		/**
		 * @return the srf_tannameid
		 */
		public String getSrf_tannameid() {
			return srf_tannameid;
		}
		/**
		 * @param srf_tannameid the srf_tannameid to set
		 */
		public void setSrf_tannameid(String srf_tannameid) {
			this.srf_tannameid = srf_tannameid;
		}
		/**
		 * @return the srf_deliverid
		 */
		public String getSrf_deliverid() {
			return srf_deliverid;
		}
		/**
		 * @param srf_deliverid the srf_deliverid to set
		 */
		public void setSrf_deliverid(String srf_deliverid) {
			this.srf_deliverid = srf_deliverid;
		}
		/**
		 * @return the srf_deliveracctno
		 */
		public String getSrf_deliveracctno() {
			return srf_deliveracctno;
		}
		/**
		 * @param srf_deliveracctno the srf_deliveracctno to set
		 */
		public void setSrf_deliveracctno(String srf_deliveracctno) {
			this.srf_deliveracctno = srf_deliveracctno;
		}
		/**
		 * @return the srfaction
		 */
		public String getSrfaction() {
			return srfaction;
		}
		/**
		 * @param srfaction the srfaction to set
		 */
		public void setSrfaction(String srfaction) {
			this.srfaction = srfaction;
		}
}
