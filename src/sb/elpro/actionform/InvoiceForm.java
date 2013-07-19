package sb.elpro.actionform;

import org.apache.struts.action.ActionForm;

public class InvoiceForm extends ActionForm {

		/**
	 * 
	 */
	private static final long serialVersionUID = -7103743427275202140L;
		
		private String invoicetype;
		private String invoiceno;
		private String invdate;
		private String expref;		
		private String otherref;
		private String exporter;
		private String exporterattn;
		private String exporteraddress;
		private String exportertele;
		private String exporterfax;
		private String notify;
		private String notifyattn;
		private String notifyaddress;
		private String notifyfax;
		private String notifytele;
		private String terms;
		private String payment;
		private String bank;
		private String bankbranch;
		private String bankaddress;
		private String banktele;
		private String bankfax;
		private String bankswiftcode;
		private String bankacno;
		private String ctryoforigngoods;
		private String loadingport;
		private String ctryoffinaldesti;
		private String dischargeport;
		private String finaldesti;
		private String grosswt;
		private String dimension;
		private String awbillno;
		private String precarriageby;
		private String placeofreciept;
		private String vesselno;
		private String marksno;
		private String noofpackages;
		private String packno;
		private String netwt;
		private String awbilldate;
		private String courierchrgs;
		private String vatcst;
		private String packingcharges;
		private String custid;
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
		private String customer;		
		private String custaddr;
		private String custattn;
		private String custtele;
		private String custfax;
		private String discount;
		private String ctrno;
		private String pojwno;
		private String pojwtannery;
		private String pojwprice;		
		private String article;
		private String ctrdate;
		private String pono;
		private String color;
		private String size;
		private String substance;
		private String selection;
		private String selectionp;
		private String quantity;
		private String pieces;
		private String rate;
		private String shipment;
		private String qsend;
		private String qremain;
		private String amount;
		private String tc;
		private String type;
		private String total;
		private String reduction;
		
		private String selectForBill;

		private String myname;
		
		
		/**
		 * @return the invoicetype
		 */
		public String getInvoicetype() {
			return invoicetype;
		}
		/**
		 * @param invoicetype the invoicetype to set
		 */
		public void setInvoicetype(String invoicetype) {
			this.invoicetype = invoicetype;
		}
		/**
		 * @return the invoiceno
		 */
		public String getInvoiceno() {
			return invoiceno;
		}
		/**
		 * @param invoiceno the invoiceno to set
		 */
		public void setInvoiceno(String invoiceno) {
			this.invoiceno = invoiceno;
		}
		/**
		 * @return the invdate
		 */
		public String getInvdate() {
			return invdate;
		}
		/**
		 * @param invdate the invdate to set
		 */
		public void setInvdate(String invdate) {
			this.invdate = invdate;
		}
		/**
		 * @return the expref
		 */
		public String getExpref() {
			return expref;
		}
		/**
		 * @param expref the expref to set
		 */
		public void setExpref(String expref) {
			this.expref = expref;
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
		 * @return the exporteraddress
		 */
		public String getExporteraddress() {
			return exporteraddress;
		}
		/**
		 * @param exporteraddress the exporteraddress to set
		 */
		public void setExporteraddress(String exporteraddress) {
			this.exporteraddress = exporteraddress;
		}
		/**
		 * @return the exportertele
		 */
		public String getExportertele() {
			return exportertele;
		}
		/**
		 * @param exportertele the exportertele to set
		 */
		public void setExportertele(String exportertele) {
			this.exportertele = exportertele;
		}
		/**
		 * @return the exporterfax
		 */
		public String getExporterfax() {
			return exporterfax;
		}
		/**
		 * @param exporterfax the exporterfax to set
		 */
		public void setExporterfax(String exporterfax) {
			this.exporterfax = exporterfax;
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
		 * @return the notifyaddress
		 */
		public String getNotifyaddress() {
			return notifyaddress;
		}
		/**
		 * @param notifyaddress the notifyaddress to set
		 */
		public void setNotifyaddress(String notifyaddress) {
			this.notifyaddress = notifyaddress;
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
		 * @return the notifytele
		 */
		public String getNotifytele() {
			return notifytele;
		}
		/**
		 * @param notifytele the notifytele to set
		 */
		public void setNotifytele(String notifytele) {
			this.notifytele = notifytele;
		}
		/**
		 * @return the terms
		 */
		public String getTerms() {
			return terms;
		}
		/**
		 * @param terms the terms to set
		 */
		public void setTerms(String terms) {
			this.terms = terms;
		}
		/**
		 * @return the payment
		 */
		public String getPayment() {
			return payment;
		}
		/**
		 * @param payment the payment to set
		 */
		public void setPayment(String payment) {
			this.payment = payment;
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
		 * @return the bankaddress
		 */
		public String getBankaddress() {
			return bankaddress;
		}
		/**
		 * @param bankaddress the bankaddress to set
		 */
		public void setBankaddress(String bankaddress) {
			this.bankaddress = bankaddress;
		}
		/**
		 * @return the banktele
		 */
		public String getBanktele() {
			return banktele;
		}
		/**
		 * @param banktele the banktele to set
		 */
		public void setBanktele(String banktele) {
			this.banktele = banktele;
		}
		/**
		 * @return the bankfax
		 */
		public String getBankfax() {
			return bankfax;
		}
		/**
		 * @param bankfax the bankfax to set
		 */
		public void setBankfax(String bankfax) {
			this.bankfax = bankfax;
		}
		/**
		 * @return the bankswiftcode
		 */
		public String getBankswiftcode() {
			return bankswiftcode;
		}
		/**
		 * @param bankswiftcode the bankswiftcode to set
		 */
		public void setBankswiftcode(String bankswiftcode) {
			this.bankswiftcode = bankswiftcode;
		}
		/**
		 * @return the bankacno
		 */
		public String getBankacno() {
			return bankacno;
		}
		/**
		 * @param bankacno the bankacno to set
		 */
		public void setBankacno(String bankacno) {
			this.bankacno = bankacno;
		}
		/**
		 * @return the ctryoforigngoods
		 */
		public String getCtryoforigngoods() {
			return ctryoforigngoods;
		}
		/**
		 * @param ctryoforigngoods the ctryoforigngoods to set
		 */
		public void setCtryoforigngoods(String ctryoforigngoods) {
			this.ctryoforigngoods = ctryoforigngoods;
		}
		/**
		 * @return the loadingport
		 */
		public String getLoadingport() {
			return loadingport;
		}
		/**
		 * @param loadingport the loadingport to set
		 */
		public void setLoadingport(String loadingport) {
			this.loadingport = loadingport;
		}
		/**
		 * @return the ctryoffinaldesti
		 */
		public String getCtryoffinaldesti() {
			return ctryoffinaldesti;
		}
		/**
		 * @param ctryoffinaldesti the ctryoffinaldesti to set
		 */
		public void setCtryoffinaldesti(String ctryoffinaldesti) {
			this.ctryoffinaldesti = ctryoffinaldesti;
		}
		/**
		 * @return the dischargeport
		 */
		public String getDischargeport() {
			return dischargeport;
		}
		/**
		 * @param dischargeport the dischargeport to set
		 */
		public void setDischargeport(String dischargeport) {
			this.dischargeport = dischargeport;
		}
		/**
		 * @return the finaldesti
		 */
		public String getFinaldesti() {
			return finaldesti;
		}
		/**
		 * @param finaldesti the finaldesti to set
		 */
		public void setFinaldesti(String finaldesti) {
			this.finaldesti = finaldesti;
		}
		/**
		 * @return the grosswt
		 */
		public String getGrosswt() {
			return grosswt;
		}
		/**
		 * @param grosswt the grosswt to set
		 */
		public void setGrosswt(String grosswt) {
			this.grosswt = grosswt;
		}
		/**
		 * @return the dimension
		 */
		public String getDimension() {
			return dimension;
		}
		/**
		 * @param dimension the dimension to set
		 */
		public void setDimension(String dimension) {
			this.dimension = dimension;
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
		 * @return the precarriageby
		 */
		public String getPrecarriageby() {
			return precarriageby;
		}
		/**
		 * @param precarriageby the precarriageby to set
		 */
		public void setPrecarriageby(String precarriageby) {
			this.precarriageby = precarriageby;
		}
		/**
		 * @return the placeofreciept
		 */
		public String getPlaceofreciept() {
			return placeofreciept;
		}
		/**
		 * @param placeofreciept the placeofreciept to set
		 */
		public void setPlaceofreciept(String placeofreciept) {
			this.placeofreciept = placeofreciept;
		}
		/**
		 * @return the vesselno
		 */
		public String getVesselno() {
			return vesselno;
		}
		/**
		 * @param vesselno the vesselno to set
		 */
		public void setVesselno(String vesselno) {
			this.vesselno = vesselno;
		}
		/**
		 * @return the marksno
		 */
		public String getMarksno() {
			return marksno;
		}
		/**
		 * @param marksno the marksno to set
		 */
		public void setMarksno(String marksno) {
			this.marksno = marksno;
		}
		/**
		 * @return the noofpackages
		 */
		public String getNoofpackages() {
			return noofpackages;
		}
		/**
		 * @param noofpackages the noofpackages to set
		 */
		public void setNoofpackages(String noofpackages) {
			this.noofpackages = noofpackages;
		}
		/**
		 * @return the packno
		 */
		public String getPackno() {
			return packno;
		}
		/**
		 * @param packno the packno to set
		 */
		public void setPackno(String packno) {
			this.packno = packno;
		}
		/**
		 * @return the netwt
		 */
		public String getNetwt() {
			return netwt;
		}
		/**
		 * @param netwt the netwt to set
		 */
		public void setNetwt(String netwt) {
			this.netwt = netwt;
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
		 * @return the courierchrgs
		 */
		public String getCourierchrgs() {
			return courierchrgs;
		}
		/**
		 * @param courierchrgs the courierchrgs to set
		 */
		public void setCourierchrgs(String courierchrgs) {
			this.courierchrgs = courierchrgs;
		}
		/**
		 * @return the vatcst
		 */
		public String getVatcst() {
			return vatcst;
		}
		/**
		 * @param vatcst the vatcst to set
		 */
		public void setVatcst(String vatcst) {
			this.vatcst = vatcst;
		}
		/**
		 * @return the packingcharges
		 */
		public String getPackingcharges() {
			return packingcharges;
		}
		/**
		 * @param packingcharges the packingcharges to set
		 */
		public void setPackingcharges(String packingcharges) {
			this.packingcharges = packingcharges;
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
		 * @return the custtele
		 */
		public String getCusttele() {
			return custtele;
		}
		/**
		 * @param custtele the custtele to set
		 */
		public void setCusttele(String custtele) {
			this.custtele = custtele;
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
		 * @return the ctrno
		 */
		public String getCtrno() {
			return ctrno;
		}
		/**
		 * @param ctrno the ctrno to set
		 */
		public void setCtrno(String ctrno) {
			this.ctrno = ctrno;
		}
		/**
		 * @return the pojwno
		 */
		public String getPojwno() {
			return pojwno;
		}
		/**
		 * @param pojwno the pojwno to set
		 */
		public void setPojwno(String pojwno) {
			this.pojwno = pojwno;
		}
		/**
		 * @return the pojwtannery
		 */
		public String getPojwtannery() {
			return pojwtannery;
		}
		/**
		 * @param pojwtannery the pojwtannery to set
		 */
		public void setPojwtannery(String pojwtannery) {
			this.pojwtannery = pojwtannery;
		}
		/**
		 * @return the pojwprice
		 */
		public String getPojwprice() {
			return pojwprice;
		}
		/**
		 * @param pojwprice the pojwprice to set
		 */
		public void setPojwprice(String pojwprice) {
			this.pojwprice = pojwprice;
		}
		/**
		 * @return the article
		 */
		public String getArticle() {
			return article;
		}
		/**
		 * @param article the article to set
		 */
		public void setArticle(String article) {
			this.article = article;
		}
		/**
		 * @return the ctrdate
		 */
		public String getCtrdate() {
			return ctrdate;
		}
		/**
		 * @param ctrdate the ctrdate to set
		 */
		public void setCtrdate(String ctrdate) {
			this.ctrdate = ctrdate;
		}
		/**
		 * @return the pono
		 */
		public String getPono() {
			return pono;
		}
		/**
		 * @param pono the pono to set
		 */
		public void setPono(String pono) {
			this.pono = pono;
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
		 * @return the qsend
		 */
		public String getQsend() {
			return qsend;
		}
		/**
		 * @param qsend the qsend to set
		 */
		public void setQsend(String qsend) {
			this.qsend = qsend;
		}
		/**
		 * @return the qremain
		 */
		public String getQremain() {
			return qremain;
		}
		/**
		 * @param qremain the qremain to set
		 */
		public void setQremain(String qremain) {
			this.qremain = qremain;
		}
		/**
		 * @return the amount
		 */
		public String getAmount() {
			return amount;
		}
		/**
		 * @param amount the amount to set
		 */
		public void setAmount(String amount) {
			this.amount = amount;
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
		 * @return the type
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * @return the total
		 */
		public String getTotal() {
			return total;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(String total) {
			this.total = total;
		}
		/**
		 * @return the reduction
		 */
		public String getReduction() {
			return reduction;
		}
		/**
		 * @param reduction the reduction to set
		 */
		public void setReduction(String reduction) {
			this.reduction = reduction;
		}
		/**
		 * @return the exporterattn
		 */
		public String getExporterattn() {
			return exporterattn;
		}
		/**
		 * @param exporterattn the exporterattn to set
		 */
		public void setExporterattn(String exporterattn) {
			this.exporterattn = exporterattn;
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
		 * @return the selectForBill
		 */
		public String getSelectForBill() {
			return selectForBill;
		}
		/**
		 * @param selectForBill the selectForBill to set
		 */
		public void setSelectForBill(String selectForBill) {
			this.selectForBill = selectForBill;
		}
		/**
		 * @return the myname
		 */
		public String getMyname() {
			return myname;
		}
		/**
		 * @param myname the myname to set
		 */
		public void setMyname(String myname) {
			this.myname = myname;
		}
		/**
		 * @return the discount
		 */
		public String getDiscount() {
			return discount;
		}
		/**
		 * @param discount the discount to set
		 */
		public void setDiscount(String discount) {
			this.discount = discount;
		}
		
		
		
}
