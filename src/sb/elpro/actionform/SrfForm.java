/**
 * 
 */
package sb.elpro.actionform;

import org.apache.struts.action.ActionForm;

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
	private String sampleno;
	private String orderdate;
	private String referenceno;
	private String priority;
	private String handledby;
	private String customer;
	private String tanname;
	private String tanattn;
	private String tanaddr;	
	private String tanphone;
	private String tanfax;
	private String custname;
	private String custattn;	
	private String custaddr;
	private String custphone;
	private String custfax;	
	private String custacctno;
	private String endusage;	
	private String destination;	
	private String paymentterms;	
	private String cdd;	
	private String add;	
	private String deliver;
	private String splcdn;	
	private String splcdn1; 
	
	
	//Article Values
	private String articleid;
	private String articlename;
	private String color;
	private String substancemin;
	private String substancemax;
	private String substance;
	private String sizemin;
	private String sizemax;
	private String sizeavg;
	private String articletype;
	private String selection;
	private String selectionp1;
	private String selectionp2;
	private String selectionp3;
	private String selectionp4;
	private String quantity;
	private String unit;
	private String pieces;
	private String ratesign;
	private String rate;	
	private String shipment;
	private String tcamt;
	private String tccurrency;
	private String tcagent;
	private String colormatching;
	private String tapetest;
	private String drynoofrubs;
	private String wetnoofrubs;
	private String fourfolds;
	private String keytest;
	private String size;
	private String tc;
	private String selectionp;
	private String srfarticleid;
	
	//Sample status
	private String status;
	private String courier;
	private String feedback;
	private String isSample;
	
	
	
	/**
	 * @return the sampleno
	 */
	public String getSampleno() {
		return sampleno;
	}
	/**
	 * @param sampleno the sampleno to set
	 */
	public void setSampleno(String sampleno) {
		this.sampleno = sampleno;
	}
	/**
	 * @return the orderdate
	 */
	public String getOrderdate() {
		return orderdate;
	}
	/**
	 * @param orderdate the orderdate to set
	 */
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	/**
	 * @return the referenceno
	 */
	public String getReferenceno() {
		return referenceno;
	}
	/**
	 * @param referenceno the referenceno to set
	 */
	public void setReferenceno(String referenceno) {
		this.referenceno = referenceno;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the handledby
	 */
	public String getHandledby() {
		return handledby;
	}
	/**
	 * @param handledby the handledby to set
	 */
	public void setHandledby(String handledby) {
		this.handledby = handledby;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
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
	 * @return the custacctno
	 */
	public String getCustacctno() {
		return custacctno;
	}
	/**
	 * @param custacctno the custacctno to set
	 */
	public void setCustacctno(String custacctno) {
		this.custacctno = custacctno;
	}
	/**
	 * @return the endusage
	 */
	public String getEndusage() {
		return endusage;
	}
	/**
	 * @param endusage the endusage to set
	 */
	public void setEndusage(String endusage) {
		this.endusage = endusage;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the paymentterms
	 */
	public String getPaymentterms() {
		return paymentterms;
	}
	/**
	 * @param paymentterms the paymentterms to set
	 */
	public void setPaymentterms(String paymentterms) {
		this.paymentterms = paymentterms;
	}
	/**
	 * @return the cdd
	 */
	public String getCdd() {
		return cdd;
	}
	/**
	 * @param cdd the cdd to set
	 */
	public void setCdd(String cdd) {
		this.cdd = cdd;
	}
	/**
	 * @return the add
	 */
	public String getAdd() {
		return add;
	}
	/**
	 * @param add the add to set
	 */
	public void setAdd(String add) {
		this.add = add;
	}
	/**
	 * @return the splcdn
	 */
	public String getSplcdn() {
		return splcdn;
	}
	/**
	 * @param splcdn the splcdn to set
	 */
	public void setSplcdn(String splcdn) {
		this.splcdn = splcdn;
	}
	/**
	 * @return the splcdn1
	 */
	public String getSplcdn1() {
		return splcdn1;
	}
	/**
	 * @param splcdn1 the splcdn1 to set
	 */
	public void setSplcdn1(String splcdn1) {
		this.splcdn1 = splcdn1;
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
	 * @return the articlename
	 */
	public String getArticlename() {
		return articlename;
	}
	/**
	 * @param articlename the articlename to set
	 */
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the substancemin
	 */
	public String getSubstancemin() {
		return substancemin;
	}
	/**
	 * @param substancemin the substancemin to set
	 */
	public void setSubstancemin(String substancemin) {
		this.substancemin = substancemin;
	}
	/**
	 * @return the substancemax
	 */
	public String getSubstancemax() {
		return substancemax;
	}
	/**
	 * @param substancemax the substancemax to set
	 */
	public void setSubstancemax(String substancemax) {
		this.substancemax = substancemax;
	}
	/**
	 * @return the substance
	 */
	public String getSubstance() {
		return substance;
	}
	/**
	 * @param substance the substance to set
	 */
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	/**
	 * @return the sizemin
	 */
	public String getSizemin() {
		return sizemin;
	}
	/**
	 * @param sizemin the sizemin to set
	 */
	public void setSizemin(String sizemin) {
		this.sizemin = sizemin;
	}
	/**
	 * @return the sizemax
	 */
	public String getSizemax() {
		return sizemax;
	}
	/**
	 * @param sizemax the sizemax to set
	 */
	public void setSizemax(String sizemax) {
		this.sizemax = sizemax;
	}
	/**
	 * @return the sizeavg
	 */
	public String getSizeavg() {
		return sizeavg;
	}
	/**
	 * @param sizeavg the sizeavg to set
	 */
	public void setSizeavg(String sizeavg) {
		this.sizeavg = sizeavg;
	}
	/**
	 * @return the articletype
	 */
	public String getArticletype() {
		return articletype;
	}
	/**
	 * @param articletype the articletype to set
	 */
	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}
	/**
	 * @return the selection
	 */
	public String getSelection() {
		return selection;
	}
	/**
	 * @param selection the selection to set
	 */
	public void setSelection(String selection) {
		this.selection = selection;
	}
	/**
	 * @return the selectionp1
	 */
	public String getSelectionp1() {
		return selectionp1;
	}
	/**
	 * @param selectionp1 the selectionp1 to set
	 */
	public void setSelectionp1(String selectionp1) {
		this.selectionp1 = selectionp1;
	}
	/**
	 * @return the selectionp2
	 */
	public String getSelectionp2() {
		return selectionp2;
	}
	/**
	 * @param selectionp2 the selectionp2 to set
	 */
	public void setSelectionp2(String selectionp2) {
		this.selectionp2 = selectionp2;
	}
	/**
	 * @return the selectionp3
	 */
	public String getSelectionp3() {
		return selectionp3;
	}
	/**
	 * @param selectionp3 the selectionp3 to set
	 */
	public void setSelectionp3(String selectionp3) {
		this.selectionp3 = selectionp3;
	}
	/**
	 * @return the selectionp4
	 */
	public String getSelectionp4() {
		return selectionp4;
	}
	/**
	 * @param selectionp4 the selectionp4 to set
	 */
	public void setSelectionp4(String selectionp4) {
		this.selectionp4 = selectionp4;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the pieces
	 */
	public String getPieces() {
		return pieces;
	}
	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(String pieces) {
		this.pieces = pieces;
	}
	/**
	 * @return the ratesign
	 */
	public String getRatesign() {
		return ratesign;
	}
	/**
	 * @param ratesign the ratesign to set
	 */
	public void setRatesign(String ratesign) {
		this.ratesign = ratesign;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the shipment
	 */
	public String getShipment() {
		return shipment;
	}
	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(String shipment) {
		this.shipment = shipment;
	}
	/**
	 * @return the tcamt
	 */
	public String getTcamt() {
		return tcamt;
	}
	/**
	 * @param tcamt the tcamt to set
	 */
	public void setTcamt(String tcamt) {
		this.tcamt = tcamt;
	}
	/**
	 * @return the tccurrency
	 */
	public String getTccurrency() {
		return tccurrency;
	}
	/**
	 * @param tccurrency the tccurrency to set
	 */
	public void setTccurrency(String tccurrency) {
		this.tccurrency = tccurrency;
	}
	/**
	 * @return the tcagent
	 */
	public String getTcagent() {
		return tcagent;
	}
	/**
	 * @param tcagent the tcagent to set
	 */
	public void setTcagent(String tcagent) {
		this.tcagent = tcagent;
	}
	/**
	 * @return the colormatching
	 */
	public String getColormatching() {
		return colormatching;
	}
	/**
	 * @param colormatching the colormatching to set
	 */
	public void setColormatching(String colormatching) {
		this.colormatching = colormatching;
	}
	/**
	 * @return the tapetest
	 */
	public String getTapetest() {
		return tapetest;
	}
	/**
	 * @param tapetest the tapetest to set
	 */
	public void setTapetest(String tapetest) {
		this.tapetest = tapetest;
	}
	/**
	 * @return the drynoofrubs
	 */
	public String getDrynoofrubs() {
		return drynoofrubs;
	}
	/**
	 * @param drynoofrubs the drynoofrubs to set
	 */
	public void setDrynoofrubs(String drynoofrubs) {
		this.drynoofrubs = drynoofrubs;
	}
	/**
	 * @return the wetnoofrubs
	 */
	public String getWetnoofrubs() {
		return wetnoofrubs;
	}
	/**
	 * @param wetnoofrubs the wetnoofrubs to set
	 */
	public void setWetnoofrubs(String wetnoofrubs) {
		this.wetnoofrubs = wetnoofrubs;
	}
	/**
	 * @return the fourfolds
	 */
	public String getFourfolds() {
		return fourfolds;
	}
	/**
	 * @param fourfolds the fourfolds to set
	 */
	public void setFourfolds(String fourfolds) {
		this.fourfolds = fourfolds;
	}
	/**
	 * @return the keytest
	 */
	public String getKeytest() {
		return keytest;
	}
	/**
	 * @param keytest the keytest to set
	 */
	public void setKeytest(String keytest) {
		this.keytest = keytest;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the tc
	 */
	public String getTc() {
		return tc;
	}
	/**
	 * @param tc the tc to set
	 */
	public void setTc(String tc) {
		this.tc = tc;
	}
	/**
	 * @return the selectionp
	 */
	public String getSelectionp() {
		return selectionp;
	}
	/**
	 * @param selectionp the selectionp to set
	 */
	public void setSelectionp(String selectionp) {
		this.selectionp = selectionp;
	}
	/**
	 * @return the srfarticleid
	 */
	public String getSrfarticleid() {
		return srfarticleid;
	}
	/**
	 * @param srfarticleid the srfarticleid to set
	 */
	public void setSrfarticleid(String srfarticleid) {
		this.srfarticleid = srfarticleid;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the courier
	 */
	public String getCourier() {
		return courier;
	}
	/**
	 * @param courier the courier to set
	 */
	public void setCourier(String courier) {
		this.courier = courier;
	}
	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * @return the isSample
	 */
	public String getIsSample() {
		return isSample;
	}
	/**
	 * @param isSample the isSample to set
	 */
	public void setIsSample(String isSample) {
		this.isSample = isSample;
	}
	/**
	 * @return the deliver
	 */
	public String getDeliver() {
		return deliver;
	}
	/**
	 * @param deliver the deliver to set
	 */
	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}
	
	
	
}
