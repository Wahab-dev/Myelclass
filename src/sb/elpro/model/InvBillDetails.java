/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 * 10.08.13	
 * 	Complete Billing Details of the Inv
 */
public class InvBillDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7572427471855732864L;

		
	private String invartid;
	private String invid;
	private String invno;
	private String invtype;
	private String invdt;
	private String invartname;
	private String invcolor;
	private String invsize;
	private String invsubs;
	private String invselc;
	private String invqty;
	private String invunit;
	private String invpcs;
	private String invrate;
	private String invqshpd;
	private String invqbal;
	private String invamt;
	private String invclaim;
	private String invcstvat;
	private String invothercrg;
	private String invtotamount;
	private String invtc;
	private String invcomm;
	private String invothercomm;
	private String invctno;
	private String taninvno;
	
	private String exporter;
	private String exporterref;
	private String otherref;
	private String customer;
	private String awbillno;
	private String awbilldate;
	private String consignee;
	private String notify;
	private String buyer;
	private String bank;
	
	//Debit Details
	private String debid;
	private String bankcharge;
	private String realizedamt;
	private String exchngrate;
	private String amtininr;
	private String debdt;
	private String remarks;
	
	private String user;
	private String debamt;
	
	/**
	 * @return the bankcharge
	 */
	public String getBankcharge() {
		return bankcharge;
	}
	/**
	 * @param bankcharge the bankcharge to set
	 */
	public void setBankcharge(String bankcharge) {
		this.bankcharge = bankcharge;
	}
	/**
	 * @return the realizedamt
	 */
	public String getRealizedamt() {
		return realizedamt;
	}
	/**
	 * @param realizedamt the realizedamt to set
	 */
	public void setRealizedamt(String realizedamt) {
		this.realizedamt = realizedamt;
	}
	/**
	 * @return the exchngrate
	 */
	public String getExchngrate() {
		return exchngrate;
	}
	/**
	 * @param exchngrate the exchngrate to set
	 */
	public void setExchngrate(String exchngrate) {
		this.exchngrate = exchngrate;
	}
	/**
	 * @return the amtininr
	 */
	public String getAmtininr() {
		return amtininr;
	}
	/**
	 * @param amtininr the amtininr to set
	 */
	public void setAmtininr(String amtininr) {
		this.amtininr = amtininr;
	}
	/**
	 * @return the debdt
	 */
	public String getDebdt() {
		return debdt;
	}
	/**
	 * @param debdt the debdt to set
	 */
	public void setDebdt(String debdt) {
		this.debdt = debdt;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	/**
	 * @return the exporter
	 */
	public String getExporter() {
		return exporter;
	}
	/**
	 * @param exporter the exporter to set
	 */
	public void setExporter(String exporter) {
		this.exporter = exporter;
	}
	/**
	 * @return the exporterref
	 */
	public String getExporterref() {
		return exporterref;
	}
	/**
	 * @param exporterref the exporterref to set
	 */
	public void setExporterref(String exporterref) {
		this.exporterref = exporterref;
	}
	/**
	 * @return the otherref
	 */
	public String getOtherref() {
		return otherref;
	}
	/**
	 * @param otherref the otherref to set
	 */
	public void setOtherref(String otherref) {
		this.otherref = otherref;
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
	 * @return the awbillno
	 */
	public String getAwbillno() {
		return awbillno;
	}
	/**
	 * @param awbillno the awbillno to set
	 */
	public void setAwbillno(String awbillno) {
		this.awbillno = awbillno;
	}
	/**
	 * @return the awbilldate
	 */
	public String getAwbilldate() {
		return awbilldate;
	}
	/**
	 * @param awbilldate the awbilldate to set
	 */
	public void setAwbilldate(String awbilldate) {
		this.awbilldate = awbilldate;
	}
	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * @return the notify
	 */
	public String getNotify() {
		return notify;
	}
	/**
	 * @param notify the notify to set
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}
	/**
	 * @return the buyer
	 */
	public String getBuyer() {
		return buyer;
	}
	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	/**
	 * @return the invartid
	 */
	public String getInvartid() {
		return invartid;
	}
	/**
	 * @param invartid the invartid to set
	 */
	public void setInvartid(String invartid) {
		this.invartid = invartid;
	}
	/**
	 * @return the invid
	 */
	public String getInvid() {
		return invid;
	}
	/**
	 * @param invid the invid to set
	 */
	public void setInvid(String invid) {
		this.invid = invid;
	}
	
	/**
	 * @return the invartname
	 */
	public String getInvartname() {
		return invartname;
	}
	/**
	 * @param invartname the invartname to set
	 */
	public void setInvartname(String invartname) {
		this.invartname = invartname;
	}
	/**
	 * @return the invcolor
	 */
	public String getInvcolor() {
		return invcolor;
	}
	/**
	 * @param invcolor the invcolor to set
	 */
	public void setInvcolor(String invcolor) {
		this.invcolor = invcolor;
	}
	/**
	 * @return the invsize
	 */
	public String getInvsize() {
		return invsize;
	}
	/**
	 * @param invsize the invsize to set
	 */
	public void setInvsize(String invsize) {
		this.invsize = invsize;
	}
	/**
	 * @return the invsubs
	 */
	public String getInvsubs() {
		return invsubs;
	}
	/**
	 * @param invsubs the invsubs to set
	 */
	public void setInvsubs(String invsubs) {
		this.invsubs = invsubs;
	}
	/**
	 * @return the invselc
	 */
	public String getInvselc() {
		return invselc;
	}
	/**
	 * @param invselc the invselc to set
	 */
	public void setInvselc(String invselc) {
		this.invselc = invselc;
	}
	/**
	 * @return the invqty
	 */
	public String getInvqty() {
		return invqty;
	}
	/**
	 * @param invqty the invqty to set
	 */
	public void setInvqty(String invqty) {
		this.invqty = invqty;
	}
	/**
	 * @return the invrate
	 */
	public String getInvrate() {
		return invrate;
	}
	/**
	 * @param invrate the invrate to set
	 */
	public void setInvrate(String invrate) {
		this.invrate = invrate;
	}
	/**
	 * @return the invqshpd
	 */
	public String getInvqshpd() {
		return invqshpd;
	}
	/**
	 * @param invqshpd the invqshpd to set
	 */
	public void setInvqshpd(String invqshpd) {
		this.invqshpd = invqshpd;
	}
	/**
	 * @return the invqbal
	 */
	public String getInvqbal() {
		return invqbal;
	}
	/**
	 * @param invqbal the invqbal to set
	 */
	public void setInvqbal(String invqbal) {
		this.invqbal = invqbal;
	}
	/**
	 * @return the invamt
	 */
	public String getInvamt() {
		return invamt;
	}
	/**
	 * @param invamt the invamt to set
	 */
	public void setInvamt(String invamt) {
		this.invamt = invamt;
	}
	/**
	 * @return the invclaim
	 */
	public String getInvclaim() {
		return invclaim;
	}
	/**
	 * @param invclaim the invclaim to set
	 */
	public void setInvclaim(String invclaim) {
		this.invclaim = invclaim;
	}
	/**
	 * @return the invcstvat
	 */
	public String getInvcstvat() {
		return invcstvat;
	}
	/**
	 * @param invcstvat the invcstvat to set
	 */
	public void setInvcstvat(String invcstvat) {
		this.invcstvat = invcstvat;
	}
	/**
	 * @return the invothercrg
	 */
	public String getInvothercrg() {
		return invothercrg;
	}
	/**
	 * @param invothercrg the invothercrg to set
	 */
	public void setInvothercrg(String invothercrg) {
		this.invothercrg = invothercrg;
	}
	/**
	 * @return the invtotamount
	 */
	public String getInvtotamount() {
		return invtotamount;
	}
	/**
	 * @param invtotamount the invtotamount to set
	 */
	public void setInvtotamount(String invtotamount) {
		this.invtotamount = invtotamount;
	}
	/**
	 * @return the invtc
	 */
	public String getInvtc() {
		return invtc;
	}
	/**
	 * @param invtc the invtc to set
	 */
	public void setInvtc(String invtc) {
		this.invtc = invtc;
	}
	
	/**
	 * @return the invctno
	 */
	public String getInvctno() {
		return invctno;
	}
	/**
	 * @param invctno the invctno to set
	 */
	public void setInvctno(String invctno) {
		this.invctno = invctno;
	}
	/**
	 * @return the invpcs
	 */
	public String getInvpcs() {
		return invpcs;
	}
	/**
	 * @param invpcs the invpcs to set
	 */
	public void setInvpcs(String invpcs) {
		this.invpcs = invpcs;
	}
	/**
	 * @return the invno
	 */
	public String getInvno() {
		return invno;
	}
	/**
	 * @param invno the invno to set
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	/**
	 * @return the invcomm
	 */
	public String getInvcomm() {
		return invcomm;
	}
	/**
	 * @param invcomm the invcomm to set
	 */
	public void setInvcomm(String invcomm) {
		this.invcomm = invcomm;
	}
	/**
	 * @return the invtype
	 */
	public String getInvtype() {
		return invtype;
	}
	/**
	 * @param invtype the invtype to set
	 */
	public void setInvtype(String invtype) {
		this.invtype = invtype;
	}
	/**
	 * @return the invdt
	 */
	public String getInvdt() {
		return invdt;
	}
	/**
	 * @param invdt the invdt to set
	 */
	public void setInvdt(String invdt) {
		this.invdt = invdt;
	}
	/**
	 * @return the invunit
	 */
	public String getInvunit() {
		return invunit;
	}
	/**
	 * @param invunit the invunit to set
	 */
	public void setInvunit(String invunit) {
		this.invunit = invunit;
	}
	/**
	 * @return the invothercomm
	 */
	public String getInvothercomm() {
		return invothercomm;
	}
	/**
	 * @param invothercomm the invothercomm to set
	 */
	public void setInvothercomm(String invothercomm) {
		this.invothercomm = invothercomm;
	}
	/**
	 * @return the taninvno
	 */
	public String getTaninvno() {
		return taninvno;
	}
	/**
	 * @param taninvno the taninvno to set
	 */
	public void setTaninvno(String taninvno) {
		this.taninvno = taninvno;
	}
	/**
	 * @return the debid
	 */
	public String getDebid() {
		return debid;
	}
	/**
	 * @param debid the debid to set
	 */
	public void setDebid(String debid) {
		this.debid = debid;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the debamt
	 */
	public String getDebamt() {
		return debamt;
	}
	/**
	 * @param debamt the debamt to set
	 */
	public void setDebamt(String debamt) {
		this.debamt = debamt;
	}
	
		
}
