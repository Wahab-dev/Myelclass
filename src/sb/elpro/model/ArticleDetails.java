/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class ArticleDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 799134027231799348L;
	
	private String articleid;
	private String articlename;
	private String articletype;
	private String articlefamily;
	private String articleshortform;
	private String color;
	private String size;
	private String size_min;
	private String size_max;
	private String size_avg;
	private String size_remarks;
	private String substance;
	private String subs_min;
	private String subs_max;
	private String selection;
	private String selp1;
	private String selp2;
	private String selp3;
	private String selp4;
	private String selp;
	private String quantity;
	private String unit;
	private float qshipped;
	private float qbal;
	private String rate_sign;
	private String rate;
	private String pieces;
	private String rateamt;
	private String shipment;
	private String tc;
	private String tc_currency;
	private String tc_amount;
	private String tc_agent;
	private String price;
	private String contractno;
	private String prfarticleid;
	private String status;
	private String rdd;
	private String comments;
	private String reps;
	private String feedback;
	private String label;
	private String value;
	
	
	// Future combine SRFARticle and Article model class
	private String colormatch;
	private String tapetest;
	private String crockwet;
	private String crockdry;
	private String fourfold;
	private String keytest;
	private String sampleno;
	private String srfarticleid;
	
	//color details 
	private String colorid;
	private String pantoneshade;
	private String colorothername;
	private String colorrefno;
	
	//Commission Details 
	private String commission;
	private String othercommission;
	
	
	
	/**
	 * @return the colormatch
	 */
	public String getColormatch() {
		return colormatch;
	}
	/**
	 * @param colormatch the colormatch to set
	 */
	public void setColormatch(String colormatch) {
		this.colormatch = colormatch;
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
	 * @return the crockwet
	 */
	public String getCrockwet() {
		return crockwet;
	}
	/**
	 * @param crockwet the crockwet to set
	 */
	public void setCrockwet(String crockwet) {
		this.crockwet = crockwet;
	}
	/**
	 * @return the crockdry
	 */
	public String getCrockdry() {
		return crockdry;
	}
	/**
	 * @param crockdry the crockdry to set
	 */
	public void setCrockdry(String crockdry) {
		this.crockdry = crockdry;
	}
	/**
	 * @return the fourfold
	 */
	public String getFourfold() {
		return fourfold;
	}
	/**
	 * @param fourfold the fourfold to set
	 */
	public void setFourfold(String fourfold) {
		this.fourfold = fourfold;
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
	 * @return the articlefamily
	 */
	public String getArticlefamily() {
		return articlefamily;
	}
	/**
	 * @param articlefamily the articlefamily to set
	 */
	public void setArticlefamily(String articlefamily) {
		this.articlefamily = articlefamily;
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
	 * @return the size_min
	 */
	public String getSize_min() {
		return size_min;
	}
	/**
	 * @param size_min the size_min to set
	 */
	public void setSize_min(String size_min) {
		this.size_min = size_min;
	}
	/**
	 * @return the size_max
	 */
	public String getSize_max() {
		return size_max;
	}
	/**
	 * @param size_max the size_max to set
	 */
	public void setSize_max(String size_max) {
		this.size_max = size_max;
	}
	/**
	 * @return the size_avg
	 */
	public String getSize_avg() {
		return size_avg;
	}
	/**
	 * @param size_avg the size_avg to set
	 */
	public void setSize_avg(String size_avg) {
		this.size_avg = size_avg;
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
	 * @return the subs_min
	 */
	public String getSubs_min() {
		return subs_min;
	}
	/**
	 * @param subs_min the subs_min to set
	 */
	public void setSubs_min(String subs_min) {
		this.subs_min = subs_min;
	}
	/**
	 * @return the subs_max
	 */
	public String getSubs_max() {
		return subs_max;
	}
	/**
	 * @param subs_max the subs_max to set
	 */
	public void setSubs_max(String subs_max) {
		this.subs_max = subs_max;
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
	 * @return the selp1
	 */
	public String getSelp1() {
		return selp1;
	}
	/**
	 * @param selp1 the selp1 to set
	 */
	public void setSelp1(String selp1) {
		this.selp1 = selp1;
	}
	/**
	 * @return the selp2
	 */
	public String getSelp2() {
		return selp2;
	}
	/**
	 * @param selp2 the selp2 to set
	 */
	public void setSelp2(String selp2) {
		this.selp2 = selp2;
	}
	/**
	 * @return the selp3
	 */
	public String getSelp3() {
		return selp3;
	}
	/**
	 * @param selp3 the selp3 to set
	 */
	public void setSelp3(String selp3) {
		this.selp3 = selp3;
	}
	/**
	 * @return the selp4
	 */
	public String getSelp4() {
		return selp4;
	}
	/**
	 * @param selp4 the selp4 to set
	 */
	public void setSelp4(String selp4) {
		this.selp4 = selp4;
	}
	/**
	 * @return the selp
	 */
	public String getSelp() {
		return selp;
	}
	/**
	 * @param selp the selp to set
	 */
	public void setSelp(String selp) {
		this.selp = selp;
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
	 * @return the rate_sign
	 */
	public String getRate_sign() {
		return rate_sign;
	}
	/**
	 * @param rate_sign the rate_sign to set
	 */
	public void setRate_sign(String rate_sign) {
		this.rate_sign = rate_sign;
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
	 * @return the tc_amount
	 */
	public String getTc_amount() {
		return tc_amount;
	}
	/**
	 * @param tc_amount the tc_amount to set
	 */
	public void setTc_amount(String tc_amount) {
		this.tc_amount = tc_amount;
	}
	/**
	 * @return the tc_agent
	 */
	public String getTc_agent() {
		return tc_agent;
	}
	/**
	 * @param tc_agent the tc_agent to set
	 */
	public void setTc_agent(String tc_agent) {
		this.tc_agent = tc_agent;
	}
	/**
	 * @return the articleshortform
	 */
	public String getArticleshortform() {
		return articleshortform;
	}
	/**
	 * @param articleshortform the articleshortform to set
	 */
	public void setArticleshortform(String articleshortform) {
		this.articleshortform = articleshortform;
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
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the size_remarks
	 */
	public String getSize_remarks() {
		return size_remarks;
	}
	/**
	 * @param size_remarks the size_remarks to set
	 */
	public void setSize_remarks(String size_remarks) {
		this.size_remarks = size_remarks;
	}
	/**
	 * @return the tc_currency
	 */
	public String getTc_currency() {
		return tc_currency;
	}
	/**
	 * @param tc_currency the tc_currency to set
	 */
	public void setTc_currency(String tc_currency) {
		this.tc_currency = tc_currency;
	}
	/**
	 * @return the prfarticleid
	 */
	public String getPrfarticleid() {
		return prfarticleid;
	}
	/**
	 * @param prfarticleid the prfarticleid to set
	 */
	public void setPrfarticleid(String prfarticleid) {
		this.prfarticleid = prfarticleid;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the rateamt
	 */
	public String getRateamt() {
		return rateamt;
	}
	/**
	 * @param rateamt the rateamt to set
	 */
	public void setRateamt(String rateamt) {
		this.rateamt = rateamt;
	}
	
	/**
	 * @return the qshipped
	 */
	public float getQshipped() {
		return qshipped;
	}
	/**
	 * @param qshipped the qshipped to set
	 */
	public void setQshipped(float qshipped) {
		this.qshipped = qshipped;
	}
	/**
	 * @return the qbal
	 */
	public float getQbal() {
		return qbal;
	}
	/**
	 * @param qbal the qbal to set
	 */
	public void setQbal(float qbal) {
		this.qbal = qbal;
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
	 * @return the rdd
	 */
	public String getRdd() {
		return rdd;
	}
	/**
	 * @param rdd the rdd to set
	 */
	public void setRdd(String rdd) {
		this.rdd = rdd;
	}
	/**
	 * @return the reps
	 */
	public String getReps() {
		return reps;
	}
	/**
	 * @param reps the reps to set
	 */
	public void setReps(String reps) {
		this.reps = reps;
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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
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
	 * @return the colorid
	 */
	public String getColorid() {
		return colorid;
	}
	/**
	 * @param colorid the colorid to set
	 */
	public void setColorid(String colorid) {
		this.colorid = colorid;
	}
	/**
	 * @return the pantoneshade
	 */
	public String getPantoneshade() {
		return pantoneshade;
	}
	/**
	 * @param pantoneshade the pantoneshade to set
	 */
	public void setPantoneshade(String pantoneshade) {
		this.pantoneshade = pantoneshade;
	}
	/**
	 * @return the colorothername
	 */
	public String getColorothername() {
		return colorothername;
	}
	/**
	 * @param colorothername the colorothername to set
	 */
	public void setColorothername(String colorothername) {
		this.colorothername = colorothername;
	}
	/**
	 * @return the colorrefno
	 */
	public String getColorrefno() {
		return colorrefno;
	}
	/**
	 * @param colorrefno the colorrefno to set
	 */
	public void setColorrefno(String colorrefno) {
		this.colorrefno = colorrefno;
	}
	/**
	 * @return the othercommission
	 */
	public String getOthercommission() {
		return othercommission;
	}
	/**
	 * @param othercommission the othercommission to set
	 */
	public void setOthercommission(String othercommission) {
		this.othercommission = othercommission;
	}
	/**
	 * @return the commission
	 */
	public String getCommission() {
		return commission;
	}
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(String commission) {
		this.commission = commission;
	}
		

}
