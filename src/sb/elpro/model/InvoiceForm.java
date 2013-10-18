/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class InvoiceForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2017781039158616835L;
	
	private String inv_invoicetype;
	private String inv_invoiceno;
	private String inv_invdate;
	private String inv_expref;		
	private String inv_otherref;
	
	private String inv_exporter; //Exporter
	private String inv_exporterattn;
	private String inv_exporteraddress;
	private String inv_exportertele;
	private String inv_exporterfax;
	private String inv_notify;  //Notify
	private String inv_notifyattn;
	private String inv_notifyaddress;
	private String inv_notifyfax;
	private String inv_notifytele;
	private String inv_bank;  //Bank
	private String inv_bankbranch;
	private String inv_bankaddress;
	private String inv_banktele;
	private String inv_bankfax;
	private String inv_bankswiftcode;
	private String inv_bankacno;
	private String inv_custid;  // Cust
	private String inv_customer;		
	private String inv_custaddr;
	private String inv_custattn;
	private String inv_custtele;
	private String inv_custfax;
	private String inv_buyerid;// buyer
	private String inv_buyer;
	private String inv_buyeraddr;
	private String inv_buyerattn;
	private String inv_buyertele;
	private String inv_buyerfax;
	
	private String inv_terms;
	private String inv_payment;
	
	//Dispatch Info
	private String inv_ctryoforigngoods;
	private String inv_loadingport;
	private String inv_ctryoffinaldesti;
	private String inv_dischargeport;
	private String inv_finaldesti;
	private String inv_awbillno;
	private String inv_precarriageby;
	private String inv_placeofreciept;
	private String inv_vesselno;
	private String inv_marksno;
	private String inv_noofpackages;
	private String inv_packno;
	private String inv_awbilldate;
	
	//Dimension 
	private String inv_grosswt;
	private String inv_dimension;
	private String inv_netwt;
	
	//Other Chrgs
	private String inv_discount;
	private String inv_deduction;
	private String inv_courierchrgs;
	private String inv_vatcst;
	private String othercharges;
	
	///pojw
	private String inv_pojwno;
	private String inv_pojwtannery;
	private String inv_pojwprice;	
	
	//Article Details 	
	private String inv_article;
	private String inv_ctrno;
	private String inv_ctrdate;
	private String inv_pono;
	private String inv_color;
	private String inv_size;
	private String inv_substance;
	private String inv_selection;
	private String inv_selectionp;
	private String inv_quantity;
	private String inv_pieces;
	private String inv_rate;
	private String inv_shipment;
	private String inv_qsend;
	private String inv_qremain;
	private String inv_amount;
	private String inv_tc;
	private String inv_type;
	private String inv_total;
	
	
	
	/**
	 * @return the inv_invoicetype
	 */
	public String getInv_invoicetype() {
		return inv_invoicetype;
	}
	/**
	 * @param inv_invoicetype the inv_invoicetype to set
	 */
	public void setInv_invoicetype(String inv_invoicetype) {
		this.inv_invoicetype = inv_invoicetype;
	}
	/**
	 * @return the inv_invoiceno
	 */
	public String getInv_invoiceno() {
		return inv_invoiceno;
	}
	/**
	 * @param inv_invoiceno the inv_invoiceno to set
	 */
	public void setInv_invoiceno(String inv_invoiceno) {
		this.inv_invoiceno = inv_invoiceno;
	}
	/**
	 * @return the inv_invdate
	 */
	public String getInv_invdate() {
		return inv_invdate;
	}
	/**
	 * @param inv_invdate the inv_invdate to set
	 */
	public void setInv_invdate(String inv_invdate) {
		this.inv_invdate = inv_invdate;
	}
	/**
	 * @return the inv_expref
	 */
	public String getInv_expref() {
		return inv_expref;
	}
	/**
	 * @param inv_expref the inv_expref to set
	 */
	public void setInv_expref(String inv_expref) {
		this.inv_expref = inv_expref;
	}
	/**
	 * @return the inv_otherref
	 */
	public String getInv_otherref() {
		return inv_otherref;
	}
	/**
	 * @param inv_otherref the inv_otherref to set
	 */
	public void setInv_otherref(String inv_otherref) {
		this.inv_otherref = inv_otherref;
	}
	/**
	 * @return the inv_exporter
	 */
	public String getInv_exporter() {
		return inv_exporter;
	}
	/**
	 * @param inv_exporter the inv_exporter to set
	 */
	public void setInv_exporter(String inv_exporter) {
		this.inv_exporter = inv_exporter;
	}
	/**
	 * @return the inv_exporterattn
	 */
	public String getInv_exporterattn() {
		return inv_exporterattn;
	}
	/**
	 * @param inv_exporterattn the inv_exporterattn to set
	 */
	public void setInv_exporterattn(String inv_exporterattn) {
		this.inv_exporterattn = inv_exporterattn;
	}
	/**
	 * @return the inv_exporteraddress
	 */
	public String getInv_exporteraddress() {
		return inv_exporteraddress;
	}
	/**
	 * @param inv_exporteraddress the inv_exporteraddress to set
	 */
	public void setInv_exporteraddress(String inv_exporteraddress) {
		this.inv_exporteraddress = inv_exporteraddress;
	}
	/**
	 * @return the inv_exportertele
	 */
	public String getInv_exportertele() {
		return inv_exportertele;
	}
	/**
	 * @param inv_exportertele the inv_exportertele to set
	 */
	public void setInv_exportertele(String inv_exportertele) {
		this.inv_exportertele = inv_exportertele;
	}
	/**
	 * @return the inv_exporterfax
	 */
	public String getInv_exporterfax() {
		return inv_exporterfax;
	}
	/**
	 * @param inv_exporterfax the inv_exporterfax to set
	 */
	public void setInv_exporterfax(String inv_exporterfax) {
		this.inv_exporterfax = inv_exporterfax;
	}
	/**
	 * @return the inv_notify
	 */
	public String getInv_notify() {
		return inv_notify;
	}
	/**
	 * @param inv_notify the inv_notify to set
	 */
	public void setInv_notify(String inv_notify) {
		this.inv_notify = inv_notify;
	}
	/**
	 * @return the inv_notifyattn
	 */
	public String getInv_notifyattn() {
		return inv_notifyattn;
	}
	/**
	 * @param inv_notifyattn the inv_notifyattn to set
	 */
	public void setInv_notifyattn(String inv_notifyattn) {
		this.inv_notifyattn = inv_notifyattn;
	}
	/**
	 * @return the inv_notifyaddress
	 */
	public String getInv_notifyaddress() {
		return inv_notifyaddress;
	}
	/**
	 * @param inv_notifyaddress the inv_notifyaddress to set
	 */
	public void setInv_notifyaddress(String inv_notifyaddress) {
		this.inv_notifyaddress = inv_notifyaddress;
	}
	/**
	 * @return the inv_notifyfax
	 */
	public String getInv_notifyfax() {
		return inv_notifyfax;
	}
	/**
	 * @param inv_notifyfax the inv_notifyfax to set
	 */
	public void setInv_notifyfax(String inv_notifyfax) {
		this.inv_notifyfax = inv_notifyfax;
	}
	/**
	 * @return the inv_notifytele
	 */
	public String getInv_notifytele() {
		return inv_notifytele;
	}
	/**
	 * @param inv_notifytele the inv_notifytele to set
	 */
	public void setInv_notifytele(String inv_notifytele) {
		this.inv_notifytele = inv_notifytele;
	}
	/**
	 * @return the inv_bank
	 */
	public String getInv_bank() {
		return inv_bank;
	}
	/**
	 * @param inv_bank the inv_bank to set
	 */
	public void setInv_bank(String inv_bank) {
		this.inv_bank = inv_bank;
	}
	/**
	 * @return the inv_bankbranch
	 */
	public String getInv_bankbranch() {
		return inv_bankbranch;
	}
	/**
	 * @param inv_bankbranch the inv_bankbranch to set
	 */
	public void setInv_bankbranch(String inv_bankbranch) {
		this.inv_bankbranch = inv_bankbranch;
	}
	/**
	 * @return the inv_bankaddress
	 */
	public String getInv_bankaddress() {
		return inv_bankaddress;
	}
	/**
	 * @param inv_bankaddress the inv_bankaddress to set
	 */
	public void setInv_bankaddress(String inv_bankaddress) {
		this.inv_bankaddress = inv_bankaddress;
	}
	/**
	 * @return the inv_banktele
	 */
	public String getInv_banktele() {
		return inv_banktele;
	}
	/**
	 * @param inv_banktele the inv_banktele to set
	 */
	public void setInv_banktele(String inv_banktele) {
		this.inv_banktele = inv_banktele;
	}
	/**
	 * @return the inv_bankfax
	 */
	public String getInv_bankfax() {
		return inv_bankfax;
	}
	/**
	 * @param inv_bankfax the inv_bankfax to set
	 */
	public void setInv_bankfax(String inv_bankfax) {
		this.inv_bankfax = inv_bankfax;
	}
	/**
	 * @return the inv_bankswiftcode
	 */
	public String getInv_bankswiftcode() {
		return inv_bankswiftcode;
	}
	/**
	 * @param inv_bankswiftcode the inv_bankswiftcode to set
	 */
	public void setInv_bankswiftcode(String inv_bankswiftcode) {
		this.inv_bankswiftcode = inv_bankswiftcode;
	}
	/**
	 * @return the inv_bankacno
	 */
	public String getInv_bankacno() {
		return inv_bankacno;
	}
	/**
	 * @param inv_bankacno the inv_bankacno to set
	 */
	public void setInv_bankacno(String inv_bankacno) {
		this.inv_bankacno = inv_bankacno;
	}
	/**
	 * @return the inv_custid
	 */
	public String getInv_custid() {
		return inv_custid;
	}
	/**
	 * @param inv_custid the inv_custid to set
	 */
	public void setInv_custid(String inv_custid) {
		this.inv_custid = inv_custid;
	}
	/**
	 * @return the inv_customer
	 */
	public String getInv_customer() {
		return inv_customer;
	}
	/**
	 * @param inv_customer the inv_customer to set
	 */
	public void setInv_customer(String inv_customer) {
		this.inv_customer = inv_customer;
	}
	/**
	 * @return the inv_custaddr
	 */
	public String getInv_custaddr() {
		return inv_custaddr;
	}
	/**
	 * @param inv_custaddr the inv_custaddr to set
	 */
	public void setInv_custaddr(String inv_custaddr) {
		this.inv_custaddr = inv_custaddr;
	}
	/**
	 * @return the inv_custattn
	 */
	public String getInv_custattn() {
		return inv_custattn;
	}
	/**
	 * @param inv_custattn the inv_custattn to set
	 */
	public void setInv_custattn(String inv_custattn) {
		this.inv_custattn = inv_custattn;
	}
	/**
	 * @return the inv_custtele
	 */
	public String getInv_custtele() {
		return inv_custtele;
	}
	/**
	 * @param inv_custtele the inv_custtele to set
	 */
	public void setInv_custtele(String inv_custtele) {
		this.inv_custtele = inv_custtele;
	}
	/**
	 * @return the inv_custfax
	 */
	public String getInv_custfax() {
		return inv_custfax;
	}
	/**
	 * @param inv_custfax the inv_custfax to set
	 */
	public void setInv_custfax(String inv_custfax) {
		this.inv_custfax = inv_custfax;
	}
	/**
	 * @return the inv_buyerid
	 */
	public String getInv_buyerid() {
		return inv_buyerid;
	}
	/**
	 * @param inv_buyerid the inv_buyerid to set
	 */
	public void setInv_buyerid(String inv_buyerid) {
		this.inv_buyerid = inv_buyerid;
	}
	/**
	 * @return the inv_buyer
	 */
	public String getInv_buyer() {
		return inv_buyer;
	}
	/**
	 * @param inv_buyer the inv_buyer to set
	 */
	public void setInv_buyer(String inv_buyer) {
		this.inv_buyer = inv_buyer;
	}
	/**
	 * @return the inv_buyeraddr
	 */
	public String getInv_buyeraddr() {
		return inv_buyeraddr;
	}
	/**
	 * @param inv_buyeraddr the inv_buyeraddr to set
	 */
	public void setInv_buyeraddr(String inv_buyeraddr) {
		this.inv_buyeraddr = inv_buyeraddr;
	}
	/**
	 * @return the inv_buyerattn
	 */
	public String getInv_buyerattn() {
		return inv_buyerattn;
	}
	/**
	 * @param inv_buyerattn the inv_buyerattn to set
	 */
	public void setInv_buyerattn(String inv_buyerattn) {
		this.inv_buyerattn = inv_buyerattn;
	}
	/**
	 * @return the inv_buyertele
	 */
	public String getInv_buyertele() {
		return inv_buyertele;
	}
	/**
	 * @param inv_buyertele the inv_buyertele to set
	 */
	public void setInv_buyertele(String inv_buyertele) {
		this.inv_buyertele = inv_buyertele;
	}
	/**
	 * @return the inv_buyerfax
	 */
	public String getInv_buyerfax() {
		return inv_buyerfax;
	}
	/**
	 * @param inv_buyerfax the inv_buyerfax to set
	 */
	public void setInv_buyerfax(String inv_buyerfax) {
		this.inv_buyerfax = inv_buyerfax;
	}
	/**
	 * @return the inv_terms
	 */
	public String getInv_terms() {
		return inv_terms;
	}
	/**
	 * @param inv_terms the inv_terms to set
	 */
	public void setInv_terms(String inv_terms) {
		this.inv_terms = inv_terms;
	}
	/**
	 * @return the inv_payment
	 */
	public String getInv_payment() {
		return inv_payment;
	}
	/**
	 * @param inv_payment the inv_payment to set
	 */
	public void setInv_payment(String inv_payment) {
		this.inv_payment = inv_payment;
	}
	/**
	 * @return the inv_ctryoforigngoods
	 */
	public String getInv_ctryoforigngoods() {
		return inv_ctryoforigngoods;
	}
	/**
	 * @param inv_ctryoforigngoods the inv_ctryoforigngoods to set
	 */
	public void setInv_ctryoforigngoods(String inv_ctryoforigngoods) {
		this.inv_ctryoforigngoods = inv_ctryoforigngoods;
	}
	/**
	 * @return the inv_loadingport
	 */
	public String getInv_loadingport() {
		return inv_loadingport;
	}
	/**
	 * @param inv_loadingport the inv_loadingport to set
	 */
	public void setInv_loadingport(String inv_loadingport) {
		this.inv_loadingport = inv_loadingport;
	}
	/**
	 * @return the inv_ctryoffinaldesti
	 */
	public String getInv_ctryoffinaldesti() {
		return inv_ctryoffinaldesti;
	}
	/**
	 * @param inv_ctryoffinaldesti the inv_ctryoffinaldesti to set
	 */
	public void setInv_ctryoffinaldesti(String inv_ctryoffinaldesti) {
		this.inv_ctryoffinaldesti = inv_ctryoffinaldesti;
	}
	/**
	 * @return the inv_dischargeport
	 */
	public String getInv_dischargeport() {
		return inv_dischargeport;
	}
	/**
	 * @param inv_dischargeport the inv_dischargeport to set
	 */
	public void setInv_dischargeport(String inv_dischargeport) {
		this.inv_dischargeport = inv_dischargeport;
	}
	/**
	 * @return the inv_finaldesti
	 */
	public String getInv_finaldesti() {
		return inv_finaldesti;
	}
	/**
	 * @param inv_finaldesti the inv_finaldesti to set
	 */
	public void setInv_finaldesti(String inv_finaldesti) {
		this.inv_finaldesti = inv_finaldesti;
	}
	/**
	 * @return the inv_awbillno
	 */
	public String getInv_awbillno() {
		return inv_awbillno;
	}
	/**
	 * @param inv_awbillno the inv_awbillno to set
	 */
	public void setInv_awbillno(String inv_awbillno) {
		this.inv_awbillno = inv_awbillno;
	}
	/**
	 * @return the inv_precarriageby
	 */
	public String getInv_precarriageby() {
		return inv_precarriageby;
	}
	/**
	 * @param inv_precarriageby the inv_precarriageby to set
	 */
	public void setInv_precarriageby(String inv_precarriageby) {
		this.inv_precarriageby = inv_precarriageby;
	}
	/**
	 * @return the inv_placeofreciept
	 */
	public String getInv_placeofreciept() {
		return inv_placeofreciept;
	}
	/**
	 * @param inv_placeofreciept the inv_placeofreciept to set
	 */
	public void setInv_placeofreciept(String inv_placeofreciept) {
		this.inv_placeofreciept = inv_placeofreciept;
	}
	/**
	 * @return the inv_vesselno
	 */
	public String getInv_vesselno() {
		return inv_vesselno;
	}
	/**
	 * @param inv_vesselno the inv_vesselno to set
	 */
	public void setInv_vesselno(String inv_vesselno) {
		this.inv_vesselno = inv_vesselno;
	}
	/**
	 * @return the inv_marksno
	 */
	public String getInv_marksno() {
		return inv_marksno;
	}
	/**
	 * @param inv_marksno the inv_marksno to set
	 */
	public void setInv_marksno(String inv_marksno) {
		this.inv_marksno = inv_marksno;
	}
	/**
	 * @return the inv_noofpackages
	 */
	public String getInv_noofpackages() {
		return inv_noofpackages;
	}
	/**
	 * @param inv_noofpackages the inv_noofpackages to set
	 */
	public void setInv_noofpackages(String inv_noofpackages) {
		this.inv_noofpackages = inv_noofpackages;
	}
	/**
	 * @return the inv_packno
	 */
	public String getInv_packno() {
		return inv_packno;
	}
	/**
	 * @param inv_packno the inv_packno to set
	 */
	public void setInv_packno(String inv_packno) {
		this.inv_packno = inv_packno;
	}
	/**
	 * @return the inv_awbilldate
	 */
	public String getInv_awbilldate() {
		return inv_awbilldate;
	}
	/**
	 * @param inv_awbilldate the inv_awbilldate to set
	 */
	public void setInv_awbilldate(String inv_awbilldate) {
		this.inv_awbilldate = inv_awbilldate;
	}
	/**
	 * @return the inv_grosswt
	 */
	public String getInv_grosswt() {
		return inv_grosswt;
	}
	/**
	 * @param inv_grosswt the inv_grosswt to set
	 */
	public void setInv_grosswt(String inv_grosswt) {
		this.inv_grosswt = inv_grosswt;
	}
	/**
	 * @return the inv_dimension
	 */
	public String getInv_dimension() {
		return inv_dimension;
	}
	/**
	 * @param inv_dimension the inv_dimension to set
	 */
	public void setInv_dimension(String inv_dimension) {
		this.inv_dimension = inv_dimension;
	}
	/**
	 * @return the inv_netwt
	 */
	public String getInv_netwt() {
		return inv_netwt;
	}
	/**
	 * @param inv_netwt the inv_netwt to set
	 */
	public void setInv_netwt(String inv_netwt) {
		this.inv_netwt = inv_netwt;
	}
	/**
	 * @return the inv_discount
	 */
	public String getInv_discount() {
		return inv_discount;
	}
	/**
	 * @param inv_discount the inv_discount to set
	 */
	public void setInv_discount(String inv_discount) {
		this.inv_discount = inv_discount;
	}
	/**
	 * @return the inv_deduction
	 */
	public String getInv_deduction() {
		return inv_deduction;
	}
	/**
	 * @param inv_deduction the inv_deduction to set
	 */
	public void setInv_deduction(String inv_deduction) {
		this.inv_deduction = inv_deduction;
	}
	/**
	 * @return the inv_courierchrgs
	 */
	public String getInv_courierchrgs() {
		return inv_courierchrgs;
	}
	/**
	 * @param inv_courierchrgs the inv_courierchrgs to set
	 */
	public void setInv_courierchrgs(String inv_courierchrgs) {
		this.inv_courierchrgs = inv_courierchrgs;
	}
	/**
	 * @return the inv_vatcst
	 */
	public String getInv_vatcst() {
		return inv_vatcst;
	}
	/**
	 * @param inv_vatcst the inv_vatcst to set
	 */
	public void setInv_vatcst(String inv_vatcst) {
		this.inv_vatcst = inv_vatcst;
	}
	/**
	 * @return the othercharges
	 */
	public String getOthercharges() {
		return othercharges;
	}
	/**
	 * @param othercharges the othercharges to set
	 */
	public void setOthercharges(String othercharges) {
		this.othercharges = othercharges;
	}
	/**
	 * @return the inv_pojwno
	 */
	public String getInv_pojwno() {
		return inv_pojwno;
	}
	/**
	 * @param inv_pojwno the inv_pojwno to set
	 */
	public void setInv_pojwno(String inv_pojwno) {
		this.inv_pojwno = inv_pojwno;
	}
	/**
	 * @return the inv_pojwtannery
	 */
	public String getInv_pojwtannery() {
		return inv_pojwtannery;
	}
	/**
	 * @param inv_pojwtannery the inv_pojwtannery to set
	 */
	public void setInv_pojwtannery(String inv_pojwtannery) {
		this.inv_pojwtannery = inv_pojwtannery;
	}
	/**
	 * @return the inv_pojwprice
	 */
	public String getInv_pojwprice() {
		return inv_pojwprice;
	}
	/**
	 * @param inv_pojwprice the inv_pojwprice to set
	 */
	public void setInv_pojwprice(String inv_pojwprice) {
		this.inv_pojwprice = inv_pojwprice;
	}
	/**
	 * @return the inv_article
	 */
	public String getInv_article() {
		return inv_article;
	}
	/**
	 * @param inv_article the inv_article to set
	 */
	public void setInv_article(String inv_article) {
		this.inv_article = inv_article;
	}
	/**
	 * @return the inv_ctrno
	 */
	public String getInv_ctrno() {
		return inv_ctrno;
	}
	/**
	 * @param inv_ctrno the inv_ctrno to set
	 */
	public void setInv_ctrno(String inv_ctrno) {
		this.inv_ctrno = inv_ctrno;
	}
	/**
	 * @return the inv_ctrdate
	 */
	public String getInv_ctrdate() {
		return inv_ctrdate;
	}
	/**
	 * @param inv_ctrdate the inv_ctrdate to set
	 */
	public void setInv_ctrdate(String inv_ctrdate) {
		this.inv_ctrdate = inv_ctrdate;
	}
	/**
	 * @return the inv_pono
	 */
	public String getInv_pono() {
		return inv_pono;
	}
	/**
	 * @param inv_pono the inv_pono to set
	 */
	public void setInv_pono(String inv_pono) {
		this.inv_pono = inv_pono;
	}
	/**
	 * @return the inv_color
	 */
	public String getInv_color() {
		return inv_color;
	}
	/**
	 * @param inv_color the inv_color to set
	 */
	public void setInv_color(String inv_color) {
		this.inv_color = inv_color;
	}
	/**
	 * @return the inv_size
	 */
	public String getInv_size() {
		return inv_size;
	}
	/**
	 * @param inv_size the inv_size to set
	 */
	public void setInv_size(String inv_size) {
		this.inv_size = inv_size;
	}
	/**
	 * @return the inv_substance
	 */
	public String getInv_substance() {
		return inv_substance;
	}
	/**
	 * @param inv_substance the inv_substance to set
	 */
	public void setInv_substance(String inv_substance) {
		this.inv_substance = inv_substance;
	}
	/**
	 * @return the inv_selection
	 */
	public String getInv_selection() {
		return inv_selection;
	}
	/**
	 * @param inv_selection the inv_selection to set
	 */
	public void setInv_selection(String inv_selection) {
		this.inv_selection = inv_selection;
	}
	/**
	 * @return the inv_selectionp
	 */
	public String getInv_selectionp() {
		return inv_selectionp;
	}
	/**
	 * @param inv_selectionp the inv_selectionp to set
	 */
	public void setInv_selectionp(String inv_selectionp) {
		this.inv_selectionp = inv_selectionp;
	}
	/**
	 * @return the inv_quantity
	 */
	public String getInv_quantity() {
		return inv_quantity;
	}
	/**
	 * @param inv_quantity the inv_quantity to set
	 */
	public void setInv_quantity(String inv_quantity) {
		this.inv_quantity = inv_quantity;
	}
	/**
	 * @return the inv_pieces
	 */
	public String getInv_pieces() {
		return inv_pieces;
	}
	/**
	 * @param inv_pieces the inv_pieces to set
	 */
	public void setInv_pieces(String inv_pieces) {
		this.inv_pieces = inv_pieces;
	}
	/**
	 * @return the inv_rate
	 */
	public String getInv_rate() {
		return inv_rate;
	}
	/**
	 * @param inv_rate the inv_rate to set
	 */
	public void setInv_rate(String inv_rate) {
		this.inv_rate = inv_rate;
	}
	/**
	 * @return the inv_shipment
	 */
	public String getInv_shipment() {
		return inv_shipment;
	}
	/**
	 * @param inv_shipment the inv_shipment to set
	 */
	public void setInv_shipment(String inv_shipment) {
		this.inv_shipment = inv_shipment;
	}
	/**
	 * @return the inv_qsend
	 */
	public String getInv_qsend() {
		return inv_qsend;
	}
	/**
	 * @param inv_qsend the inv_qsend to set
	 */
	public void setInv_qsend(String inv_qsend) {
		this.inv_qsend = inv_qsend;
	}
	/**
	 * @return the inv_qremain
	 */
	public String getInv_qremain() {
		return inv_qremain;
	}
	/**
	 * @param inv_qremain the inv_qremain to set
	 */
	public void setInv_qremain(String inv_qremain) {
		this.inv_qremain = inv_qremain;
	}
	/**
	 * @return the inv_amount
	 */
	public String getInv_amount() {
		return inv_amount;
	}
	/**
	 * @param inv_amount the inv_amount to set
	 */
	public void setInv_amount(String inv_amount) {
		this.inv_amount = inv_amount;
	}
	/**
	 * @return the inv_tc
	 */
	public String getInv_tc() {
		return inv_tc;
	}
	/**
	 * @param inv_tc the inv_tc to set
	 */
	public void setInv_tc(String inv_tc) {
		this.inv_tc = inv_tc;
	}
	/**
	 * @return the inv_type
	 */
	public String getInv_type() {
		return inv_type;
	}
	/**
	 * @param inv_type the inv_type to set
	 */
	public void setInv_type(String inv_type) {
		this.inv_type = inv_type;
	}
	/**
	 * @return the inv_total
	 */
	public String getInv_total() {
		return inv_total;
	}
	/**
	 * @param inv_total the inv_total to set
	 */
	public void setInv_total(String inv_total) {
		this.inv_total = inv_total;
	}
}
