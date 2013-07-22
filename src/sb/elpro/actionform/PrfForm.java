/**
 * 
 */
package sb.elpro.actionform;



import org.apache.struts.action.ActionForm;

/**
 * @author Wahab
 *
 */
public class PrfForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3495410020625737320L;
	private String prf_agentid;
	private String prf_agentname;
	private String prf_contractno;
	private String prf_orderdate;
	private String prf_poref;
	private String prf_tannid ;
	private String prf_tanname;
	private String prf_tanaddr;
	private String prf_tanattn;
	private String prf_tanphone;
	private String prf_tanfax;
	private String prf_custid;
	private String prf_custname;
	private String prf_custattn;
	private String prf_custaddr;
	private String prf_custphone;
	private String prf_custfax;
	private String prf_consigneeid;
	private String prf_consigneename;
	private String prf_consigneeattn;
	private String prf_consigneeaddr;
	private String prf_consigneephone;
	private String prf_consigneefax;
	private String prf_notifyid;
	private String prf_notifyname;
	private String prf_notifyattn;
	private String prf_notifyaddr;
	private String prf_notifyphone;
	private String prf_notifyfax;
	private String prf_bankid;
	private String prf_bankname;
	private String prf_bankbranch;
	private String prf_bankaddr;
	private String prf_bankphone;
	private String prf_bankfax;
	private String prf_destination;
	private String prf_destinationid;
	private String prf_terms;
	private String prf_termsid;
	private String prf_payment;
	private String prf_paymentid;
	private String prf_elclasscommission;	
	private String prf_commission;
	private String prf_commissionid;
	private String prf_insurance;
	private String prf_cdd;
	private String prf_add;
	private String prf_special;
	private String prf_commission2;
	private String prf_commission3;
	private boolean isselectedckhbox =false;
	
	
	//Artilce Details
	private String prf_articleid;
	private String articleid;
	private String prf_articlename;
	private String prf_color;
	private String prf_substancemin;
	private String prf_substancemax;
	private String prf_substance;
	private String prf_sizemin;
	private String prf_sizemax;
	private String prf_sizeavg;
	private String prf_sizeremarks;
	private String prf_articletype;
	private String prf_selection;
	private String prf_selectionp1;
	private String prf_selectionp2;
	private String prf_selectionp3;
	private String prf_selectionp4;
	private String prf_quantity;
	private String prf_unit;
	private String prf_pieces;
	private String prf_ratesign;
	private String prf_rate;	
	private String prf_shipment;
	private String prf_tcamt;
	private String prf_tccurrency;
	private String prf_tcagent;
	private String prf_size;
	private String prf_selectionp;
	private String prf_price;
	private String prf_tc;
	
	//Load Values
	private String agentname;
	private String agentid;
	private String contractno ;
	private String tanaddr;
	private String tanattn;
	private String tanfax;
	private String tanid;
	private String tanname;
	private String tanphone;
	private String custaddr;
	private String custattn;
	private String custfax;
	private String custid;
	private String custname;
	private String custphone;
	private String consigaddr;
	private String consigattn;
	private String consigfax;
	private String consigid;
	private String consigname;
	private String consigphone;
	private String notifyaddr;
	private String notifyattn;
	private String notifyfax;
	private String notifyid;
	private String notifyname;
	private String notifyphone;
	private String bankaddr;
	private String bankbranch;
	private String bankid;
	private String bankname;
	private String bankphone;
	private String destid;
	private String destname;
	private String payname;
	private String payid;
	private String termname;
	private String termid;
	private String commname;
	private String commid;
	
	
	
	/**
	 * @return the prf_agentid
	 */
	public String getPrf_agentid() {
		return prf_agentid;
	}
	/**
	 * @param prf_agentid the prf_agentid to set
	 */
	public void setPrf_agentid(String prf_agentid) {
		this.prf_agentid = prf_agentid;
	}
	/**
	 * @return the prf_agentname
	 */
	public String getPrf_agentname() {
		return prf_agentname;
	}
	/**
	 * @param prf_agentname the prf_agentname to set
	 */
	public void setPrf_agentname(String prf_agentname) {
		this.prf_agentname = prf_agentname;
	}
	/**
	 * @return the prf_contractno
	 */
	public String getPrf_contractno() {
		return prf_contractno;
	}
	/**
	 * @param prf_contractno the prf_contractno to set
	 */
	public void setPrf_contractno(String prf_contractno) {
		this.prf_contractno = prf_contractno;
	}
	/**
	 * @return the prf_orderdate
	 */
	public String getPrf_orderdate() {
		return prf_orderdate;
	}
	/**
	 * @param prf_orderdate the prf_orderdate to set
	 */
	public void setPrf_orderdate(String prf_orderdate) {
		this.prf_orderdate = prf_orderdate;
	}
	/**
	 * @return the prf_poref
	 */
	public String getPrf_poref() {
		return prf_poref;
	}
	/**
	 * @param prf_poref the prf_poref to set
	 */
	public void setPrf_poref(String prf_poref) {
		this.prf_poref = prf_poref;
	}
	/**
	 * @return the prf_tannid
	 */
	public String getPrf_tannid() {
		return prf_tannid;
	}
	/**
	 * @param prf_tannid the prf_tannid to set
	 */
	public void setPrf_tannid(String prf_tannid) {
		this.prf_tannid = prf_tannid;
	}
	/**
	 * @return the prf_tanname
	 */
	public String getPrf_tanname() {
		return prf_tanname;
	}
	/**
	 * @param prf_tanname the prf_tanname to set
	 */
	public void setPrf_tanname(String prf_tanname) {
		this.prf_tanname = prf_tanname;
	}
	/**
	 * @return the prf_tanaddr
	 */
	public String getPrf_tanaddr() {
		return prf_tanaddr;
	}
	/**
	 * @param prf_tanaddr the prf_tanaddr to set
	 */
	public void setPrf_tanaddr(String prf_tanaddr) {
		this.prf_tanaddr = prf_tanaddr;
	}
	/**
	 * @return the prf_tanattn
	 */
	public String getPrf_tanattn() {
		return prf_tanattn;
	}
	/**
	 * @param prf_tanattn the prf_tanattn to set
	 */
	public void setPrf_tanattn(String prf_tanattn) {
		this.prf_tanattn = prf_tanattn;
	}
	/**
	 * @return the prf_tanphone
	 */
	public String getPrf_tanphone() {
		return prf_tanphone;
	}
	/**
	 * @param prf_tanphone the prf_tanphone to set
	 */
	public void setPrf_tanphone(String prf_tanphone) {
		this.prf_tanphone = prf_tanphone;
	}
	/**
	 * @return the prf_tanfax
	 */
	public String getPrf_tanfax() {
		return prf_tanfax;
	}
	/**
	 * @param prf_tanfax the prf_tanfax to set
	 */
	public void setPrf_tanfax(String prf_tanfax) {
		this.prf_tanfax = prf_tanfax;
	}
	/**
	 * @return the prf_custid
	 */
	public String getPrf_custid() {
		return prf_custid;
	}
	/**
	 * @param prf_custid the prf_custid to set
	 */
	public void setPrf_custid(String prf_custid) {
		this.prf_custid = prf_custid;
	}
	/**
	 * @return the prf_custname
	 */
	public String getPrf_custname() {
		return prf_custname;
	}
	/**
	 * @param prf_custname the prf_custname to set
	 */
	public void setPrf_custname(String prf_custname) {
		this.prf_custname = prf_custname;
	}
	/**
	 * @return the prf_custattn
	 */
	public String getPrf_custattn() {
		return prf_custattn;
	}
	/**
	 * @param prf_custattn the prf_custattn to set
	 */
	public void setPrf_custattn(String prf_custattn) {
		this.prf_custattn = prf_custattn;
	}
	/**
	 * @return the prf_custaddr
	 */
	public String getPrf_custaddr() {
		return prf_custaddr;
	}
	/**
	 * @param prf_custaddr the prf_custaddr to set
	 */
	public void setPrf_custaddr(String prf_custaddr) {
		this.prf_custaddr = prf_custaddr;
	}
	/**
	 * @return the prf_custphone
	 */
	public String getPrf_custphone() {
		return prf_custphone;
	}
	/**
	 * @param prf_custphone the prf_custphone to set
	 */
	public void setPrf_custphone(String prf_custphone) {
		this.prf_custphone = prf_custphone;
	}
	/**
	 * @return the prf_custfax
	 */
	public String getPrf_custfax() {
		return prf_custfax;
	}
	/**
	 * @param prf_custfax the prf_custfax to set
	 */
	public void setPrf_custfax(String prf_custfax) {
		this.prf_custfax = prf_custfax;
	}
	/**
	 * @return the prf_consigneeid
	 */
	public String getPrf_consigneeid() {
		return prf_consigneeid;
	}
	/**
	 * @param prf_consigneeid the prf_consigneeid to set
	 */
	public void setPrf_consigneeid(String prf_consigneeid) {
		this.prf_consigneeid = prf_consigneeid;
	}
	/**
	 * @return the prf_consigneename
	 */
	public String getPrf_consigneename() {
		return prf_consigneename;
	}
	/**
	 * @param prf_consigneename the prf_consigneename to set
	 */
	public void setPrf_consigneename(String prf_consigneename) {
		this.prf_consigneename = prf_consigneename;
	}
	/**
	 * @return the prf_consigneeattn
	 */
	public String getPrf_consigneeattn() {
		return prf_consigneeattn;
	}
	/**
	 * @param prf_consigneeattn the prf_consigneeattn to set
	 */
	public void setPrf_consigneeattn(String prf_consigneeattn) {
		this.prf_consigneeattn = prf_consigneeattn;
	}
	/**
	 * @return the prf_consigneeaddr
	 */
	public String getPrf_consigneeaddr() {
		return prf_consigneeaddr;
	}
	/**
	 * @param prf_consigneeaddr the prf_consigneeaddr to set
	 */
	public void setPrf_consigneeaddr(String prf_consigneeaddr) {
		this.prf_consigneeaddr = prf_consigneeaddr;
	}
	/**
	 * @return the prf_consigneephone
	 */
	public String getPrf_consigneephone() {
		return prf_consigneephone;
	}
	/**
	 * @param prf_consigneephone the prf_consigneephone to set
	 */
	public void setPrf_consigneephone(String prf_consigneephone) {
		this.prf_consigneephone = prf_consigneephone;
	}
	/**
	 * @return the prf_consigneefax
	 */
	public String getPrf_consigneefax() {
		return prf_consigneefax;
	}
	/**
	 * @param prf_consigneefax the prf_consigneefax to set
	 */
	public void setPrf_consigneefax(String prf_consigneefax) {
		this.prf_consigneefax = prf_consigneefax;
	}
	/**
	 * @return the prf_notifyid
	 */
	public String getPrf_notifyid() {
		return prf_notifyid;
	}
	/**
	 * @param prf_notifyid the prf_notifyid to set
	 */
	public void setPrf_notifyid(String prf_notifyid) {
		this.prf_notifyid = prf_notifyid;
	}
	/**
	 * @return the prf_notifyname
	 */
	public String getPrf_notifyname() {
		return prf_notifyname;
	}
	/**
	 * @param prf_notifyname the prf_notifyname to set
	 */
	public void setPrf_notifyname(String prf_notifyname) {
		this.prf_notifyname = prf_notifyname;
	}
	/**
	 * @return the prf_notifyattn
	 */
	public String getPrf_notifyattn() {
		return prf_notifyattn;
	}
	/**
	 * @param prf_notifyattn the prf_notifyattn to set
	 */
	public void setPrf_notifyattn(String prf_notifyattn) {
		this.prf_notifyattn = prf_notifyattn;
	}
	/**
	 * @return the prf_notifyaddr
	 */
	public String getPrf_notifyaddr() {
		return prf_notifyaddr;
	}
	/**
	 * @param prf_notifyaddr the prf_notifyaddr to set
	 */
	public void setPrf_notifyaddr(String prf_notifyaddr) {
		this.prf_notifyaddr = prf_notifyaddr;
	}
	/**
	 * @return the prf_notifyphone
	 */
	public String getPrf_notifyphone() {
		return prf_notifyphone;
	}
	/**
	 * @param prf_notifyphone the prf_notifyphone to set
	 */
	public void setPrf_notifyphone(String prf_notifyphone) {
		this.prf_notifyphone = prf_notifyphone;
	}
	/**
	 * @return the prf_notifyfax
	 */
	public String getPrf_notifyfax() {
		return prf_notifyfax;
	}
	/**
	 * @param prf_notifyfax the prf_notifyfax to set
	 */
	public void setPrf_notifyfax(String prf_notifyfax) {
		this.prf_notifyfax = prf_notifyfax;
	}
	/**
	 * @return the prf_bankid
	 */
	public String getPrf_bankid() {
		return prf_bankid;
	}
	/**
	 * @param prf_bankid the prf_bankid to set
	 */
	public void setPrf_bankid(String prf_bankid) {
		this.prf_bankid = prf_bankid;
	}
	/**
	 * @return the prf_bankname
	 */
	public String getPrf_bankname() {
		return prf_bankname;
	}
	/**
	 * @param prf_bankname the prf_bankname to set
	 */
	public void setPrf_bankname(String prf_bankname) {
		this.prf_bankname = prf_bankname;
	}
	/**
	 * @return the prf_bankbranch
	 */
	public String getPrf_bankbranch() {
		return prf_bankbranch;
	}
	/**
	 * @param prf_bankbranch the prf_bankbranch to set
	 */
	public void setPrf_bankbranch(String prf_bankbranch) {
		this.prf_bankbranch = prf_bankbranch;
	}
	/**
	 * @return the prf_bankaddr
	 */
	public String getPrf_bankaddr() {
		return prf_bankaddr;
	}
	/**
	 * @param prf_bankaddr the prf_bankaddr to set
	 */
	public void setPrf_bankaddr(String prf_bankaddr) {
		this.prf_bankaddr = prf_bankaddr;
	}
	/**
	 * @return the prf_bankphone
	 */
	public String getPrf_bankphone() {
		return prf_bankphone;
	}
	/**
	 * @param prf_bankphone the prf_bankphone to set
	 */
	public void setPrf_bankphone(String prf_bankphone) {
		this.prf_bankphone = prf_bankphone;
	}
	/**
	 * @return the prf_bankfax
	 */
	public String getPrf_bankfax() {
		return prf_bankfax;
	}
	/**
	 * @param prf_bankfax the prf_bankfax to set
	 */
	public void setPrf_bankfax(String prf_bankfax) {
		this.prf_bankfax = prf_bankfax;
	}
	/**
	 * @return the prf_destination
	 */
	public String getPrf_destination() {
		return prf_destination;
	}
	/**
	 * @param prf_destination the prf_destination to set
	 */
	public void setPrf_destination(String prf_destination) {
		this.prf_destination = prf_destination;
	}
	/**
	 * @return the prf_destinationid
	 */
	public String getPrf_destinationid() {
		return prf_destinationid;
	}
	/**
	 * @param prf_destinationid the prf_destinationid to set
	 */
	public void setPrf_destinationid(String prf_destinationid) {
		this.prf_destinationid = prf_destinationid;
	}
	/**
	 * @return the prf_terms
	 */
	public String getPrf_terms() {
		return prf_terms;
	}
	/**
	 * @param prf_terms the prf_terms to set
	 */
	public void setPrf_terms(String prf_terms) {
		this.prf_terms = prf_terms;
	}
	/**
	 * @return the prf_termsid
	 */
	public String getPrf_termsid() {
		return prf_termsid;
	}
	/**
	 * @param prf_termsid the prf_termsid to set
	 */
	public void setPrf_termsid(String prf_termsid) {
		this.prf_termsid = prf_termsid;
	}
	/**
	 * @return the prf_payment
	 */
	public String getPrf_payment() {
		return prf_payment;
	}
	/**
	 * @param prf_payment the prf_payment to set
	 */
	public void setPrf_payment(String prf_payment) {
		this.prf_payment = prf_payment;
	}
	/**
	 * @return the prf_paymentid
	 */
	public String getPrf_paymentid() {
		return prf_paymentid;
	}
	/**
	 * @param prf_paymentid the prf_paymentid to set
	 */
	public void setPrf_paymentid(String prf_paymentid) {
		this.prf_paymentid = prf_paymentid;
	}
	/**
	 * @return the prf_commission1
	 */
	public String getPrf_commission() {
		return prf_commission;
	}
	/**
	 * @param prf_commission1 the prf_commission1 to set
	 */
	public void setPrf_commission(String prf_commission) {
		this.prf_commission = prf_commission;
	}
	/**
	 * @return the prf_commissionid
	 */
	public String getPrf_commissionid() {
		return prf_commissionid;
	}
	/**
	 * @param prf_commissionid the prf_commissionid to set
	 */
	public void setPrf_commissionid(String prf_commissionid) {
		this.prf_commissionid = prf_commissionid;
	}
	/**
	 * @return the prf_insurance
	 */
	public String getPrf_insurance() {
		return prf_insurance;
	}
	/**
	 * @param prf_insurance the prf_insurance to set
	 */
	public void setPrf_insurance(String prf_insurance) {
		this.prf_insurance = prf_insurance;
	}
	/**
	 * @return the prf_cdd
	 */
	public String getPrf_cdd() {
		return prf_cdd;
	}
	/**
	 * @param prf_cdd the prf_cdd to set
	 */
	public void setPrf_cdd(String prf_cdd) {
		this.prf_cdd = prf_cdd;
	}
	/**
	 * @return the prf_add
	 */
	public String getPrf_add() {
		return prf_add;
	}
	/**
	 * @param prf_add the prf_add to set
	 */
	public void setPrf_add(String prf_add) {
		this.prf_add = prf_add;
	}
	/**
	 * @return the prf_special
	 */
	public String getPrf_special() {
		return prf_special;
	}
	/**
	 * @param prf_special the prf_special to set
	 */
	public void setPrf_special(String prf_special) {
		this.prf_special = prf_special;
	}
	/**
	 * @return the prf_commission2
	 */
	public String getPrf_commission2() {
		return prf_commission2;
	}
	/**
	 * @param prf_commission2 the prf_commission2 to set
	 */
	public void setPrf_commission2(String prf_commission2) {
		this.prf_commission2 = prf_commission2;
	}
	/**
	 * @return the prf_commission3
	 */
	public String getPrf_commission3() {
		return prf_commission3;
	}
	/**
	 * @param prf_commission3 the prf_commission3 to set
	 */
	public void setPrf_commission3(String prf_commission3) {
		this.prf_commission3 = prf_commission3;
	}
	/**
	 * @return the prf_articleid
	 */
	public String getPrf_articleid() {
		return prf_articleid;
	}
	/**
	 * @param prf_articleid the prf_articleid to set
	 */
	public void setPrf_articleid(String prf_articleid) {
		this.prf_articleid = prf_articleid;
	}
	/**
	 * @return the prf_articlename
	 */
	public String getPrf_articlename() {
		return prf_articlename;
	}
	/**
	 * @param prf_articlename the prf_articlename to set
	 */
	public void setPrf_articlename(String prf_articlename) {
		this.prf_articlename = prf_articlename;
	}
	/**
	 * @return the prf_color
	 */
	public String getPrf_color() {
		return prf_color;
	}
	/**
	 * @param prf_color the prf_color to set
	 */
	public void setPrf_color(String prf_color) {
		this.prf_color = prf_color;
	}
	/**
	 * @return the prf_substancemin
	 */
	public String getPrf_substancemin() {
		return prf_substancemin;
	}
	/**
	 * @param prf_substancemin the prf_substancemin to set
	 */
	public void setPrf_substancemin(String prf_substancemin) {
		this.prf_substancemin = prf_substancemin;
	}
	/**
	 * @return the prf_substancemax
	 */
	public String getPrf_substancemax() {
		return prf_substancemax;
	}
	/**
	 * @param prf_substancemax the prf_substancemax to set
	 */
	public void setPrf_substancemax(String prf_substancemax) {
		this.prf_substancemax = prf_substancemax;
	}
	/**
	 * @return the prf_substance
	 */
	public String getPrf_substance() {
		return prf_substance;
	}
	/**
	 * @param prf_substance the prf_substance to set
	 */
	public void setPrf_substance(String prf_substance) {
		this.prf_substance = prf_substance;
	}
	/**
	 * @return the prf_sizemin
	 */
	public String getPrf_sizemin() {
		return prf_sizemin;
	}
	/**
	 * @param prf_sizemin the prf_sizemin to set
	 */
	public void setPrf_sizemin(String prf_sizemin) {
		this.prf_sizemin = prf_sizemin;
	}
	/**
	 * @return the prf_sizemax
	 */
	public String getPrf_sizemax() {
		return prf_sizemax;
	}
	/**
	 * @param prf_sizemax the prf_sizemax to set
	 */
	public void setPrf_sizemax(String prf_sizemax) {
		this.prf_sizemax = prf_sizemax;
	}
	/**
	 * @return the prf_sizeavg
	 */
	public String getPrf_sizeavg() {
		return prf_sizeavg;
	}
	/**
	 * @param prf_sizeavg the prf_sizeavg to set
	 */
	public void setPrf_sizeavg(String prf_sizeavg) {
		this.prf_sizeavg = prf_sizeavg;
	}
	/**
	 * @return the prf_articletype
	 */
	public String getPrf_articletype() {
		return prf_articletype;
	}
	/**
	 * @param prf_articletype the prf_articletype to set
	 */
	public void setPrf_articletype(String prf_articletype) {
		this.prf_articletype = prf_articletype;
	}
	/**
	 * @return the prf_selection
	 */
	public String getPrf_selection() {
		return prf_selection;
	}
	/**
	 * @param prf_selection the prf_selection to set
	 */
	public void setPrf_selection(String prf_selection) {
		this.prf_selection = prf_selection;
	}
	/**
	 * @return the prf_selectionp1
	 */
	public String getPrf_selectionp1() {
		return prf_selectionp1;
	}
	/**
	 * @param prf_selectionp1 the prf_selectionp1 to set
	 */
	public void setPrf_selectionp1(String prf_selectionp1) {
		this.prf_selectionp1 = prf_selectionp1;
	}
	/**
	 * @return the prf_selectionp2
	 */
	public String getPrf_selectionp2() {
		return prf_selectionp2;
	}
	/**
	 * @param prf_selectionp2 the prf_selectionp2 to set
	 */
	public void setPrf_selectionp2(String prf_selectionp2) {
		this.prf_selectionp2 = prf_selectionp2;
	}
	/**
	 * @return the prf_selectionp3
	 */
	public String getPrf_selectionp3() {
		return prf_selectionp3;
	}
	/**
	 * @param prf_selectionp3 the prf_selectionp3 to set
	 */
	public void setPrf_selectionp3(String prf_selectionp3) {
		this.prf_selectionp3 = prf_selectionp3;
	}
	/**
	 * @return the prf_selectionp4
	 */
	public String getPrf_selectionp4() {
		return prf_selectionp4;
	}
	/**
	 * @param prf_selectionp4 the prf_selectionp4 to set
	 */
	public void setPrf_selectionp4(String prf_selectionp4) {
		this.prf_selectionp4 = prf_selectionp4;
	}
	/**
	 * @return the prf_quantity
	 */
	public String getPrf_quantity() {
		return prf_quantity;
	}
	/**
	 * @param prf_quantity the prf_quantity to set
	 */
	public void setPrf_quantity(String prf_quantity) {
		this.prf_quantity = prf_quantity;
	}
	/**
	 * @return the prf_unit
	 */
	public String getPrf_unit() {
		return prf_unit;
	}
	/**
	 * @param prf_unit the prf_unit to set
	 */
	public void setPrf_unit(String prf_unit) {
		this.prf_unit = prf_unit;
	}
	/**
	 * @return the prf_pieces
	 */
	public String getPrf_pieces() {
		return prf_pieces;
	}
	/**
	 * @param prf_pieces the prf_pieces to set
	 */
	public void setPrf_pieces(String prf_pieces) {
		this.prf_pieces = prf_pieces;
	}
	/**
	 * @return the prf_ratesign
	 */
	public String getPrf_ratesign() {
		return prf_ratesign;
	}
	/**
	 * @param prf_ratesign the prf_ratesign to set
	 */
	public void setPrf_ratesign(String prf_ratesign) {
		this.prf_ratesign = prf_ratesign;
	}
	/**
	 * @return the prf_rate
	 */
	public String getPrf_rate() {
		return prf_rate;
	}
	/**
	 * @param prf_rate the prf_rate to set
	 */
	public void setPrf_rate(String prf_rate) {
		this.prf_rate = prf_rate;
	}
	/**
	 * @return the prf_shipment
	 */
	public String getPrf_shipment() {
		return prf_shipment;
	}
	/**
	 * @param prf_shipment the prf_shipment to set
	 */
	public void setPrf_shipment(String prf_shipment) {
		this.prf_shipment = prf_shipment;
	}
	/**
	 * @return the prf_tcamt
	 */
	public String getPrf_tcamt() {
		return prf_tcamt;
	}
	/**
	 * @param prf_tcamt the prf_tcamt to set
	 */
	public void setPrf_tcamt(String prf_tcamt) {
		this.prf_tcamt = prf_tcamt;
	}
	/**
	 * @return the prf_tccurrency
	 */
	public String getPrf_tccurrency() {
		return prf_tccurrency;
	}
	/**
	 * @param prf_tccurrency the prf_tccurrency to set
	 */
	public void setPrf_tccurrency(String prf_tccurrency) {
		this.prf_tccurrency = prf_tccurrency;
	}
	/**
	 * @return the prf_tcagent
	 */
	public String getPrf_tcagent() {
		return prf_tcagent;
	}
	/**
	 * @param prf_tcagent the prf_tcagent to set
	 */
	public void setPrf_tcagent(String prf_tcagent) {
		this.prf_tcagent = prf_tcagent;
	}
	/**
	 * @return the prf_size
	 */
	public String getPrf_size() {
		return prf_size;
	}
	/**
	 * @param prf_size the prf_size to set
	 */
	public void setPrf_size(String prf_size) {
		this.prf_size = prf_size;
	}
	/**
	 * @return the prf_selectionp
	 */
	public String getPrf_selectionp() {
		return prf_selectionp;
	}
	/**
	 * @param prf_selectionp the prf_selectionp to set
	 */
	public void setPrf_selectionp(String prf_selectionp) {
		this.prf_selectionp = prf_selectionp;
	}
	/**
	 * @return the prf_price
	 */
	public String getPrf_price() {
		return prf_price;
	}
	/**
	 * @param prf_price the prf_price to set
	 */
	public void setPrf_price(String prf_price) {
		this.prf_price = prf_price;
	}
	/**
	 * @return the prf_tc
	 */
	public String getPrf_tc() {
		return prf_tc;
	}
	/**
	 * @param prf_tc the prf_tc to set
	 */
	public void setPrf_tc(String prf_tc) {
		this.prf_tc = prf_tc;
	}
	/**
	 * @return the agentname
	 */
	public String getAgentname() {
		return agentname;
	}
	/**
	 * @param agentname the agentname to set
	 */
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	/**
	 * @return the agentid
	 */
	public String getAgentid() {
		return agentid;
	}
	/**
	 * @param agentid the agentid to set
	 */
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	/**
	 * @return the contractno
	 */
	public String getContractno() {
		return contractno;
	}
	/**
	 * @param contractno the contractno to set
	 */
	public void setContractno(String contractno) {
		this.contractno = contractno;
	}
	/**
	 * @return the tanaddr
	 */
	public String getTanaddr() {
		return tanaddr;
	}
	/**
	 * @param tanaddr the tanaddr to set
	 */
	public void setTanaddr(String tanaddr) {
		this.tanaddr = tanaddr;
	}
	/**
	 * @return the tanattn
	 */
	public String getTanattn() {
		return tanattn;
	}
	/**
	 * @param tanattn the tanattn to set
	 */
	public void setTanattn(String tanattn) {
		this.tanattn = tanattn;
	}
	/**
	 * @return the tanfax
	 */
	public String getTanfax() {
		return tanfax;
	}
	/**
	 * @param tanfax the tanfax to set
	 */
	public void setTanfax(String tanfax) {
		this.tanfax = tanfax;
	}
	/**
	 * @return the tanid
	 */
	public String getTanid() {
		return tanid;
	}
	/**
	 * @param tanid the tanid to set
	 */
	public void setTanid(String tanid) {
		this.tanid = tanid;
	}
	/**
	 * @return the tanname
	 */
	public String getTanname() {
		return tanname;
	}
	/**
	 * @param tanname the tanname to set
	 */
	public void setTanname(String tanname) {
		this.tanname = tanname;
	}
	/**
	 * @return the tanphone
	 */
	public String getTanphone() {
		return tanphone;
	}
	/**
	 * @param tanphone the tanphone to set
	 */
	public void setTanphone(String tanphone) {
		this.tanphone = tanphone;
	}
	/**
	 * @return the custaddr
	 */
	public String getCustaddr() {
		return custaddr;
	}
	/**
	 * @param custaddr the custaddr to set
	 */
	public void setCustaddr(String custaddr) {
		this.custaddr = custaddr;
	}
	/**
	 * @return the custattn
	 */
	public String getCustattn() {
		return custattn;
	}
	/**
	 * @param custattn the custattn to set
	 */
	public void setCustattn(String custattn) {
		this.custattn = custattn;
	}
	/**
	 * @return the custfax
	 */
	public String getCustfax() {
		return custfax;
	}
	/**
	 * @param custfax the custfax to set
	 */
	public void setCustfax(String custfax) {
		this.custfax = custfax;
	}
	/**
	 * @return the custid
	 */
	public String getCustid() {
		return custid;
	}
	/**
	 * @param custid the custid to set
	 */
	public void setCustid(String custid) {
		this.custid = custid;
	}
	/**
	 * @return the custname
	 */
	public String getCustname() {
		return custname;
	}
	/**
	 * @param custname the custname to set
	 */
	public void setCustname(String custname) {
		this.custname = custname;
	}
	/**
	 * @return the custphone
	 */
	public String getCustphone() {
		return custphone;
	}
	/**
	 * @param custphone the custphone to set
	 */
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	/**
	 * @return the consigaddr
	 */
	public String getConsigaddr() {
		return consigaddr;
	}
	/**
	 * @param consigaddr the consigaddr to set
	 */
	public void setConsigaddr(String consigaddr) {
		this.consigaddr = consigaddr;
	}
	/**
	 * @return the consigattn
	 */
	public String getConsigattn() {
		return consigattn;
	}
	/**
	 * @param consigattn the consigattn to set
	 */
	public void setConsigattn(String consigattn) {
		this.consigattn = consigattn;
	}
	/**
	 * @return the consigfax
	 */
	public String getConsigfax() {
		return consigfax;
	}
	/**
	 * @param consigfax the consigfax to set
	 */
	public void setConsigfax(String consigfax) {
		this.consigfax = consigfax;
	}
	/**
	 * @return the consigid
	 */
	public String getConsigid() {
		return consigid;
	}
	/**
	 * @param consigid the consigid to set
	 */
	public void setConsigid(String consigid) {
		this.consigid = consigid;
	}
	/**
	 * @return the consigname
	 */
	public String getConsigname() {
		return consigname;
	}
	/**
	 * @param consigname the consigname to set
	 */
	public void setConsigname(String consigname) {
		this.consigname = consigname;
	}
	/**
	 * @return the consigphone
	 */
	public String getConsigphone() {
		return consigphone;
	}
	/**
	 * @param consigphone the consigphone to set
	 */
	public void setConsigphone(String consigphone) {
		this.consigphone = consigphone;
	}
	/**
	 * @return the notifyaddr
	 */
	public String getNotifyaddr() {
		return notifyaddr;
	}
	/**
	 * @param notifyaddr the notifyaddr to set
	 */
	public void setNotifyaddr(String notifyaddr) {
		this.notifyaddr = notifyaddr;
	}
	/**
	 * @return the notifyattn
	 */
	public String getNotifyattn() {
		return notifyattn;
	}
	/**
	 * @param notifyattn the notifyattn to set
	 */
	public void setNotifyattn(String notifyattn) {
		this.notifyattn = notifyattn;
	}
	/**
	 * @return the notifyfax
	 */
	public String getNotifyfax() {
		return notifyfax;
	}
	/**
	 * @param notifyfax the notifyfax to set
	 */
	public void setNotifyfax(String notifyfax) {
		this.notifyfax = notifyfax;
	}
	/**
	 * @return the notifyid
	 */
	public String getNotifyid() {
		return notifyid;
	}
	/**
	 * @param notifyid the notifyid to set
	 */
	public void setNotifyid(String notifyid) {
		this.notifyid = notifyid;
	}
	/**
	 * @return the notifyname
	 */
	public String getNotifyname() {
		return notifyname;
	}
	/**
	 * @param notifyname the notifyname to set
	 */
	public void setNotifyname(String notifyname) {
		this.notifyname = notifyname;
	}
	/**
	 * @return the notifyphone
	 */
	public String getNotifyphone() {
		return notifyphone;
	}
	/**
	 * @param notifyphone the notifyphone to set
	 */
	public void setNotifyphone(String notifyphone) {
		this.notifyphone = notifyphone;
	}
	/**
	 * @return the bankaddr
	 */
	public String getBankaddr() {
		return bankaddr;
	}
	/**
	 * @param bankaddr the bankaddr to set
	 */
	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}
	/**
	 * @return the bankbranch
	 */
	public String getBankbranch() {
		return bankbranch;
	}
	/**
	 * @param bankbranch the bankbranch to set
	 */
	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}
	/**
	 * @return the bankid
	 */
	public String getBankid() {
		return bankid;
	}
	/**
	 * @param bankid the bankid to set
	 */
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	/**
	 * @return the bankname
	 */
	public String getBankname() {
		return bankname;
	}
	/**
	 * @param bankname the bankname to set
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 * @return the bankphone
	 */
	public String getBankphone() {
		return bankphone;
	}
	/**
	 * @param bankphone the bankphone to set
	 */
	public void setBankphone(String bankphone) {
		this.bankphone = bankphone;
	}
	/**
	 * @return the destid
	 */
	public String getDestid() {
		return destid;
	}
	/**
	 * @param destid the destid to set
	 */
	public void setDestid(String destid) {
		this.destid = destid;
	}
	/**
	 * @return the destname
	 */
	public String getDestname() {
		return destname;
	}
	/**
	 * @param destname the destname to set
	 */
	public void setDestname(String destname) {
		this.destname = destname;
	}
	/**
	 * @return the payname
	 */
	public String getPayname() {
		return payname;
	}
	/**
	 * @param payname the payname to set
	 */
	public void setPayname(String payname) {
		this.payname = payname;
	}
	/**
	 * @return the payid
	 */
	public String getPayid() {
		return payid;
	}
	/**
	 * @param payid the payid to set
	 */
	public void setPayid(String payid) {
		this.payid = payid;
	}
	/**
	 * @return the termname
	 */
	public String getTermname() {
		return termname;
	}
	/**
	 * @param termname the termname to set
	 */
	public void setTermname(String termname) {
		this.termname = termname;
	}
	/**
	 * @return the termid
	 */
	public String getTermid() {
		return termid;
	}
	/**
	 * @param termid the termid to set
	 */
	public void setTermid(String termid) {
		this.termid = termid;
	}
	/**
	 * @return the commname
	 */
	public String getCommname() {
		return commname;
	}
	/**
	 * @param commname the commname to set
	 */
	public void setCommname(String commname) {
		this.commname = commname;
	}
	/**
	 * @return the commid
	 */
	public String getCommid() {
		return commid;
	}
	/**
	 * @param commid the commid to set
	 */
	public void setCommid(String commid) {
		this.commid = commid;
	}
	
	
	/**
	 * @return the prf_sizeremarks
	 */
	public String getPrf_sizeremarks() {
		return prf_sizeremarks;
	}
	/**
	 * @param prf_sizeremarks the prf_sizeremarks to set
	 */
	public void setPrf_sizeremarks(String prf_sizeremarks) {
		this.prf_sizeremarks = prf_sizeremarks;
	}
	/**
	 * @return the articleid
	 */
	public String getArticleid() {
		return articleid;
	}
	/**
	 * @param articleid the articleid to set
	 */
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	/**
	 * @return the isselectedckhbox
	 */
	public boolean isIsselectedckhbox() {
		return isselectedckhbox;
	}
	/**
	 * @param isselectedckhbox the isselectedckhbox to set
	 */
	public void setIsselectedckhbox(boolean isselectedckhbox) {
		this.isselectedckhbox = isselectedckhbox;
	}
	/**
	 * @return the prf_elclasscommission
	 */
	public String getPrf_elclasscommission() {
		return prf_elclasscommission;
	}
	/**
	 * @param prf_elclasscommission the prf_elclasscommission to set
	 */
	public void setPrf_elclasscommission(String prf_elclasscommission) {
		this.prf_elclasscommission = prf_elclasscommission;
	}
	
}