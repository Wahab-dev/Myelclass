/**
 * 
 */
package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import sb.elpro.model.AgentDetails;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PrfArticle;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.RateDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.model.TcDetails;
import sb.elpro.utility.DBConnection;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class PrfDaoImpl implements PrfDao {

	@Override
	public ArrayList<AgentDetails> getAgentList(String agenterm) throws SQLException {
		ArrayList<AgentDetails> agentarraylist = new ArrayList<AgentDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT agentid, agentname, contractno FROM elpro.tbl_prfctno where agentname like '%"+agenterm+"%' and agenttype ='U' order by agentname;";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AgentDetails agentlist  = new AgentDetails();
				agentlist.setAgentname(rs.getString("agentname"));
				String ctno = rs.getString("contractno").trim();
				String agent = ctno.substring(0, 1);
				int ictno = Integer.parseInt(ctno.substring(1));
				System.out.println(" CT NO  "+ ++ictno);
				ctno = agent+ictno;
				agentlist.setContractNo(ctno);
				System.out.println("Agent name "+agentlist.getAgentname());
				agentarraylist.add(agentlist);
			}
			System.out.println("Agent List Added Successfully");
		}catch(Exception e){
			System.out.println("Agent List Result ERROR");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return agentarraylist;
	}

	@Override
	public ArrayList<TanneryDetails> getTanneryList(String tanterm) throws SQLException {
		ArrayList<TanneryDetails> tanarraylist = new ArrayList<TanneryDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT tanid, tanname, tanaddr, tanattn, tanphone, tanfax  FROM elpro.tbl_tannery where tanname like '%"+tanterm+"%' order by tanname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			 TanneryDetails tanbean = new TanneryDetails();
				tanbean.setTanneryAddress(rs.getString("tanaddr"));
				tanbean.setTanneryAttention(rs.getString("tanattn"));
				tanbean.setTanneryFax(rs.getString("tanfax"));
				tanbean.setTanneryId(rs.getString("tanid"));
				tanbean.setLabel(rs.getString("tanname"));
				tanbean.setTanneryContactNo(rs.getString("tanphone"));
				System.out.println("Tan name "+tanbean.getTanneryName());
				tanarraylist.add(tanbean);
			}
			System.out.println("Tannery Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Tannery Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return tanarraylist;
	}

	@Override
	public ArrayList<CustomerDetails> getCustomerList(String custterm) throws SQLException {
		ArrayList<CustomerDetails> custrraylist = new ArrayList<CustomerDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{	con = DBConnection.getConnection();
		st = (Statement) con.createStatement();
		String sql = "SELECT custid, custname, custaddr, custattn, custphone, custfax, agentid, shortform FROM elpro.tbl_customer where custname like '%"+custterm+"%' order by custname";
		rs = st.executeQuery(sql);
		while(rs.next()) {	
			CustomerDetails custbean = new CustomerDetails();
			custbean.setCustomerAddress(rs.getString("custaddr"));
			custbean.setCustomerAttention(rs.getString("custattn"));
			custbean.setCustomerFax(rs.getString("custfax"));
			custbean.setCustomerId(rs.getString("custid"));
			custbean.setLabel(rs.getString("custname"));
			custbean.setCustomerTelephone(rs.getString("custphone"));			
			System.out.println("Customer  name "+custbean.getCustomerName());
			custrraylist.add(custbean);
			}
		System.out.println("Customer Name Result Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Customer Name ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return custrraylist;
	}
	
	@Override
	public ArrayList<AutoComplete> getTermsList(String term) throws SQLException {
		ArrayList<AutoComplete> termsarray = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT termid, termname FROM tbl_terms where termname like '%"+term+"%' order by termname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete termsbean = new AutoComplete();
				termsbean.setValue(rs.getString("termname"));
				termsbean.setLabel(rs.getString("termid"));
				System.out.println("Terms name "+termsbean.getValue());
				termsarray.add(termsbean);
				}
			System.out.println("termname Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Terms ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return termsarray;
	}
	
	@Override
	public ArrayList<AutoComplete> getPaymnetList(String payment) throws SQLException {
		ArrayList<AutoComplete> payarraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT payid, payname FROM tbl_payment where payname like '%"+payment+"%' order by payname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete paybean = new AutoComplete();
				paybean.setValue(rs.getString("payname"));
				paybean.setLabel(rs.getString("payid"));
				System.out.println("Payment name "+paybean.getValue());
				payarraylist.add(paybean);
				}
			System.out.println("payname Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("payname ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return payarraylist;
	}

	

	@Override
	public ArrayList<CommissionDetails> getCommissionList(String commsioon) throws SQLException {
		ArrayList<CommissionDetails> comarraylist = new ArrayList<CommissionDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT commid, commname, commagent, commplace, commtype, agenttype FROM elpro.tbl_commission where agenttype ='el' and commname like '%"+commsioon+"%' order by commname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				CommissionDetails commbean = new CommissionDetails();
				commbean.setCommissionId(rs.getString("commid"));
				commbean.setValue(rs.getString("commname"));
				commbean.setLabel(rs.getString("commagent"));
				commbean.setCommplace(rs.getString("commplace"));
				commbean.setCommtype(rs.getString("commtype"));
				commbean.setAgenttype(rs.getString("agenttype"));
				System.out.println("Commission name "+commbean.getCommission());
				comarraylist.add(commbean);
				}
			System.out.println("Commission Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Commission ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return comarraylist;
	}
	@Override
	public ArrayList<CommissionDetails> getOtherCommissionList(
			String othercomminsion) throws SQLException {
		ArrayList<CommissionDetails> othercomarraylist = new ArrayList<CommissionDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT commid, commname, commagent, commplace, commtype, agenttype FROM elpro.tbl_commission where agenttype !='el' and commname like '%"+othercomminsion+"%' order by commname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				CommissionDetails othercommbean = new CommissionDetails();
				othercommbean.setCommissionId(rs.getString("commid"));
				othercommbean.setValue(rs.getString("commname"));
				othercommbean.setLabel(rs.getString("commagent"));
				othercommbean.setCommplace(rs.getString("commplace"));
				othercommbean.setCommtype(rs.getString("commtype"));
				othercommbean.setAgenttype(rs.getString("agenttype"));
				System.out.println("OTHER Commission name "+othercommbean.getCommission());
				othercomarraylist.add(othercommbean);
				}
			System.out.println("Commission Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Commission ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return othercomarraylist;
	}

	@Override
	public ArrayList<BankDetails> getbankList(String bankterm)
			throws SQLException {
		ArrayList<BankDetails> bankarraylist = new ArrayList<BankDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT bankid, bankname, bankbranch, bankaddr, bankphone, bankfax, swiftcode, shortform, Acctno FROM elpro.tbl_bank where bankname like '%"+bankterm+"%' order by bankname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				BankDetails bankbean = new BankDetails();
				bankbean.setBankAddress(rs.getString("bankaddr"));
				bankbean.setBankBranch(rs.getString("bankbranch"));
				bankbean.setBankFax(rs.getString("bankfax"));
				bankbean.setBankName(rs.getString("bankname"));
				bankbean.setBankSwiftCode(rs.getString("swiftcode"));
				bankbean.setBankContactNo(rs.getString("bankphone"));
				bankbean.setBankAcctNo(rs.getString("Acctno"));
				bankbean.setBankId(rs.getString("bankid"));
				System.out.println("Bank  name "+bankbean.getBankName());
				bankarraylist.add(bankbean);
				}
			System.out.println("Bank Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Bank ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return bankarraylist;
	}

	@Override
	public ArrayList<ConsigneeDetails> getcnsigneeList(String consigneeterm)
			throws SQLException {
		ArrayList<ConsigneeDetails> consigarrayList = new ArrayList<ConsigneeDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT consigid, consigname, consigattn, consigaddr, consigphone, consigfax, shortform FROM elpro.tbl_consignee where consigname like '%"+consigneeterm+"%' order by consigname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ConsigneeDetails consigbean = new ConsigneeDetails();
				consigbean.setConsigneeAddress(rs.getString("consigaddr"));
				consigbean.setConsigneeAttention(rs.getString("consigattn"));
				consigbean.setConsigneefax(rs.getString("consigfax"));
				consigbean.setLabel(rs.getString("consigname"));
				consigbean.setValue(rs.getString("consigname"));
				consigbean.setConsigneeId(rs.getString("consigid"));
				consigbean.setConsigneeContactNo(rs.getString("consigphone"));
				System.out.println("consig  name "+consigbean.getConsigneeName());
				consigarrayList.add(consigbean);
				}
			System.out.println("consig Result Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("consig ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return consigarrayList;
	}

	@Override
	public ArrayList<NotifyConsigneeDetails> getnotifyList(String notifyterm)
			throws SQLException {
		ArrayList<NotifyConsigneeDetails> notifyconsigarrayList = new ArrayList<NotifyConsigneeDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT notifyid, notifyname, notifyattn, notifyaddr, notifyphone, notifyfax, shortform FROM elpro.tbl_notify where notifyname like '%"+notifyterm+"%' order by notifyname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				NotifyConsigneeDetails notifyconsigbean = new NotifyConsigneeDetails();
				notifyconsigbean.setNotifyConsigneeAddress(rs.getString("notifyaddr"));
				notifyconsigbean.setNotifyConsigneeId(rs.getString("notifyid"));
				notifyconsigbean.setNotifyConsigneeAttention(rs.getString("notifyattn"));
				notifyconsigbean.setNotifyConsigneefax(rs.getString("notifyfax"));
				notifyconsigbean.setNotifyConsigneeName(rs.getString("notifyname"));
				notifyconsigbean.setNotifyConsigneeContactNo(rs.getString("notifyphone"));				
				System.out.println("Notify  name "+notifyconsigbean.getNotifyConsigneeName());
				notifyconsigarrayList.add(notifyconsigbean);
			}
			System.out.println("Notify Result Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
			return notifyconsigarrayList;
	}

	@Override
	public ArrayList<ArticleDetails> getArticleList() throws SQLException {
		ArrayList<ArticleDetails> artarraylist = new ArrayList<ArticleDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articlename, articleshortform, size, substance, selection, color, selectionpercent, quantity, pcs, rate, tc, othername FROM tbl_article";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		
			ArticleDetails artbean = new ArticleDetails();
				artbean.setArticleid(rs.getString("articleid"));
				artbean.setArticletype(rs.getString("articletype"));
				artbean.setArticlename(rs.getString("articlename"));
				artbean.setArticleshortform(rs.getString("articleshortform"));
				artbean.setSize(rs.getString("size"));
				artbean.setSubstance(rs.getString("substance"));
				artbean.setSelection(rs.getString("selection"));
				artbean.setSelp(rs.getString("selectionpercent"));
				artbean.setColor(rs.getString("color"));
				artbean.setRate(rs.getString("rate"));
				artbean.setTc(rs.getString("tc"));
				artbean.setArticlefamily(rs.getString("othername"));				
				System.out.println("Article name "+artbean.getArticlename());
				artarraylist.add(artbean);
				}
			System.out.println("Article Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Article ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return artarraylist;
	}
	
	@Override
	public ArrayList<PrfArticle> getPrfArticleDetails(String ctno, String sidx, String sord) throws SQLException {
		ArrayList<PrfArticle> articlearray = new ArrayList<PrfArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articleshfrom, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, user, contractno, prfarticleid FROM tbl_prf_article where contractno = '"+ctno+"' order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				PrfArticle artbean = new PrfArticle();
				artbean.setArticleid(rs.getString("articleid"));
				artbean.setPrf_articletype(rs.getString("articletype"));
				artbean.setArtshform(rs.getString("articleshfrom"));
				artbean.setPrf_articlename(rs.getString("articlename"));
				artbean.setPrf_size(rs.getString("size"));
				artbean.setPrf_substance(rs.getString("substance"));
				artbean.setPrf_selection(rs.getString("selection"));
				artbean.setPrf_selectionp(rs.getString("selectionpercent"));
				artbean.setPrf_color(rs.getString("color"));
				artbean.setPrf_quantity(rs.getString("quantity"));
				artbean.setPrf_contractnum(rs.getString("contractno"));
				artbean.setPrf_articleid(rs.getString("color"));
				artbean.setPrf_unit(rs.getString("unit"));
				artbean.setPrf_pieces(rs.getString("pcs"));
				artbean.setPrf_rate(rs.getString("rate"));
				artbean.setPrf_tc(rs.getString("tc"));
				System.out.println(" tC  "+artbean.getPrf_tc());
				artbean.setUser(rs.getString("user"));
				artbean.setPrf_articleid(rs.getString("prfarticleid"));	
				System.out.println("Artilce REtrieved Successfully");
				System.out.println("Article name "+artbean.getPrf_articlename());
				articlearray.add(artbean);
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return articlearray;
	}

	
	@Override
	public List<ArticleDetails> getPrfArticleNamelist(String term)
			throws SQLException {
		List<ArticleDetails> artnameeditarraylist = new ArrayList<ArticleDetails>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articlename, articleshortform, size, substance, selection, color, selectionpercent, quantity, pcs, rate, tc, othername FROM elpro.tbl_article where articlename like '%"+term+"%' order by articlename";
			
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				String siz = rs.getString("size");
				int size_index = siz.indexOf(' ');
				String sizval = siz.substring(0, size_index);
				String sizerem = siz.substring(size_index+1);
				
				String rat = rs.getString("rate");
				System.out.println("rat "+rat);
				int shipmntindex = rat.indexOf(' ');
				int shipmntindexlst = rat.lastIndexOf(' ');
				System.out.println(" shipmntindex"+shipmntindex);
				String ratesign = rat.substring(0,shipmntindex).trim();
				System.out.println(" ratesign"+ratesign);
				String rateamt = rat.substring(shipmntindex+1,shipmntindexlst).trim();
				System.out.println(" rateamt"+rateamt);
				String shipment = rat.substring(shipmntindexlst+1).trim();
				System.out.println(" shipment"+shipment);
				
				//tc calc
				String tc = rs.getString("tc");
				int tctemindex = tc.indexOf(' ');
				int tctemlastindex = tc.lastIndexOf(' ');
				String tcamt = tc.substring(0,tctemindex).trim();
				System.out.println(" tcamt"+tcamt);
				String tcsign = tc.substring(tctemindex,tctemlastindex).trim();
				System.out.println(" tcsign"+tcsign);
				String tcto = tc.substring(tctemlastindex).trim();
				System.out.println(" tcto"+tcto);
				
				
				ArticleDetails artbean = new ArticleDetails();
				artbean.setArticleshortform(rs.getString("articleshortform"));
				artbean.setArticlename(rs.getString("articlename"));
				artbean.setArticleid(rs.getString("articleid"));
				artbean.setColor(rs.getString("color"));
				artbean.setSize(sizval); 
				artbean.setSize_remarks(sizerem);
				artbean.setSubstance(rs.getString("substance"));
				artbean.setSelection(rs.getString("selection"));
				artbean.setSelp(rs.getString("selectionpercent"));
				artbean.setRate_sign(ratesign);
				System.out.println("ratesign ++"+ratesign);
				artbean.setRateamt(rateamt);
				System.out.println("rateamt ++"+rateamt);
				artbean.setShipment(shipment);
				artbean.setTc_agent(tcto);
				artbean.setTc_amount(tcamt);
				artbean.setTc_currency(tcsign);
				artnameeditarraylist.add(artbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return artnameeditarraylist;
	}
	
	@Override
	public List<AutoComplete> getPrfColorlist(String term) throws SQLException {
		List<AutoComplete> artnameeditarraylist = new ArrayList<AutoComplete>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT colorid, colorname, pantoneshades FROM tbl_color where colorname like '%"+term+"%' order by colorname";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				AutoComplete destbean = new AutoComplete();
				destbean.setLabel(rs.getString("colorname"));	
				destbean.setValue(rs.getString("colorname"));
				artnameeditarraylist.add(destbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return artnameeditarraylist;
	}
	
	@Override
	public ArrayList<TcDetails> getTcAgentList() throws SQLException {
		ArrayList<TcDetails> tcarraylist = new ArrayList<TcDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT tcid, tcagent FROM tbl_tcagent";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				TcDetails tcbean = new TcDetails();
				tcbean.setTcid(rs.getString("tcid"));
				tcbean.setTcagent(rs.getString("tcagent"));			
				System.out.println("tc name "+tcbean.getTcagent());
				tcarraylist.add(tcbean);
				}
			System.out.println("tc Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("tc ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return tcarraylist;
	}
	
	@Override
	public ArrayList<RateDetails> getRateList() throws SQLException {
		ArrayList<RateDetails> ratearraylist = new ArrayList<RateDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT rate_id, rate_symbol, rate_subtype FROM tbl_rate";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				RateDetails ratebean = new RateDetails();
				ratebean.setRateid(rs.getString("rate_id"));
				ratebean.setRate(rs.getString("rate_symbol"));	
				ratebean.setDenomination(rs.getString("rate_subtype"));
				System.out.println("Rate name "+ratebean.getRate());
				ratearraylist.add(ratebean);
				}
			System.out.println("Rate Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Rate ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return ratearraylist;
	}

	/*@Override
	public ArrayList<AutoComplete> getShipmentList() throws SQLException {
		ArrayList<AutoComplete> shiparraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT shipmentid, shipment FROM tbl_shipment order by shipmentid";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete shipbean = new AutoComplete();
				shipbean.setShform(rs.getString("shipmentid"));
				shipbean.setValue(rs.getString("shipment"));			
				System.out.println("Shipment name "+shipbean.getValue());
				shiparraylist.add(shipbean);
				}
			System.out.println("Shipment Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Shipment ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return shiparraylist;
	}*/

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getShipmentList(java.lang.String)
	 */
	@Override
	public ArrayList<AutoComplete> getShipmentList(String term)throws SQLException {
		ArrayList<AutoComplete> shipmentlist = new ArrayList<AutoComplete>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT shipment FROM elpro.tbl_shipment order by shipment";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				AutoComplete shpmntbean = new AutoComplete();
				shpmntbean.setValue(rs.getString("shipment"));	
				shipmentlist.add(shpmntbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return shipmentlist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getPrfSelectionList()
	 */
	@Override
	public ArrayList<AutoComplete> getPrfSelectionList() throws SQLException {
		ArrayList<AutoComplete> selectlist = new ArrayList<AutoComplete>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT selection FROM elpro.tbl_selection order by selection";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				AutoComplete selectbean = new AutoComplete();
				selectbean.setValue(rs.getString("selection"));	
				selectlist.add(selectbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return selectlist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getPrfColorMatchList()
	 */
	@Override
	public ArrayList<AutoComplete> getPrfColorMatchList() throws SQLException {
		ArrayList<AutoComplete> colormatchlist = new ArrayList<AutoComplete>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT colormatch FROM elpro.tbl_colormatch order by colormatch";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				AutoComplete colormatchbean = new AutoComplete();
				colormatchbean.setValue(rs.getString("colormatch"));	
				colormatchlist.add(colormatchbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return colormatchlist;
	}
	/*
	 * Load Article dDetails Based on Article Name
	 */

	@Override
	public int saveprfArticleList(PrfArticle prfarticlebean)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_prf_article (articleid, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, contractno)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, prfarticlebean.getArticleid());
			System.out.println("getArticleid " +prfarticlebean.getArticleid());
			pst.setString(2, prfarticlebean.getPrf_articlename());
			System.out.println("getArticlename " +prfarticlebean.getPrf_articlename());
			pst.setString(3, prfarticlebean.getPrf_size());
			pst.setString(4, prfarticlebean.getPrf_substance());
			pst.setString(5, prfarticlebean.getPrf_selection());
			pst.setString(6, prfarticlebean.getPrf_selectionp());
			pst.setString(7, prfarticlebean.getPrf_color());
			pst.setString(8, prfarticlebean.getPrf_quantity());
			pst.setString(9, prfarticlebean.getPrf_unit());
			pst.setString(10, prfarticlebean.getPrf_pieces());
			pst.setString(11, prfarticlebean.getPrf_price());
			pst.setString(12, prfarticlebean.getPrf_tc());
			pst.setString(13, prfarticlebean.getPrf_contractnum());
			System.out.println("getContractno " +prfarticlebean.getPrf_contractnum());
			noofrows = pst.executeUpdate();
			System.out.println(" IN ARTICLE SAVE "+noofrows);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	return noofrows;
	}

	@Override
	public boolean addprfArticle(PrfArticle artindertdetail, 
			String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		int noofrows  = 0;
		int addstatusrow  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_prf_article (articleid, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, contractno, articletype, articleshfrom,user)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, artindertdetail.getArticleid());
			System.out.println("getArticleid " +artindertdetail.getArticleid());
			pst.setString(2, artindertdetail.getPrf_articlename());
			System.out.println("getArticlename " +artindertdetail.getPrf_articlename());
			pst.setString(3, artindertdetail.getPrf_size());
			pst.setString(4, artindertdetail.getPrf_substance());
			pst.setString(5, artindertdetail.getPrf_selection());
			pst.setString(6, artindertdetail.getPrf_selectionp());
			pst.setString(7, artindertdetail.getPrf_color());
			pst.setString(8, artindertdetail.getPrf_quantity());
			pst.setString(9, artindertdetail.getPrf_unit());
			pst.setString(10, artindertdetail.getPrf_pieces());
			pst.setString(11, artindertdetail.getPrf_rate());
			pst.setString(12, artindertdetail.getPrf_tc());
			pst.setString(13, artindertdetail.getPrf_contractnum());
			pst.setString(14, artindertdetail.getPrf_articletype());
			pst.setString(15, artindertdetail.getArtshform() );
			pst.setString(16, artindertdetail.getUser());
			System.out.println("getContractno " +artindertdetail.getPrf_contractnum());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				System.out.println(" ID "+artindertdetail.getPrf_articleid());
				System.out.println(" Save for Status table "+noofrows);
				StringBuffer sql_saveprfArticlestatus = new StringBuffer("insert into elpro.tbl_prfarticle_status (artname, status, qty, qshipped, qbal, invdetails, reps, comments, feddback, contractno, rdd_date) ");
				sql_saveprfArticlestatus.append("values (?,?,?,?,?,?,?,?,?,?,?)");
				String sqlquery_saveprfArticlestatus = sql_saveprfArticlestatus.toString();
				System.out.println("Save quert" +sqlquery_saveprfArticlestatus);
				pst1 = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticlestatus);
				//int prfarticleid = Integer.parseInt(artindertdetail.getPrf_articleid());
				pst1.setString(1, artindertdetail.getPrf_articlename());
				System.out.println("getPrf_articlename " +artindertdetail.getPrf_articlename());
				pst1.setString(2, "P");
				pst1.setString(3, artindertdetail.getPrf_quantity());
				pst1.setString(4, "0");
				pst1.setString(5, artindertdetail.getPrf_quantity());
				pst1.setString(6, "NA");
				pst1.setString(7, "NA");
				pst1.setString(8, "NA");
				pst1.setString(9, "NA");
				pst1.setString(10, artindertdetail.getPrf_contractnum());
				pst1.setString(11, "2014-01-01");
				addstatusrow = pst1.executeUpdate();
				System.out.println("Sucessfully Inseerter in Status Table." + addstatusrow);
			}
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isadded;
	}

	@Override
	public List<ArticleDetails> getPrfArticleTypelist()
			throws SQLException {
		List<ArticleDetails> arttypeeditarraylist = new ArrayList<ArticleDetails>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articletype FROM elpro.tbl_articletype order by articletype asc";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				//destarraylist.add(rs.getString("destname"));
				ArticleDetails artbean = new ArticleDetails();
				artbean.setValue(rs.getString("articletype"));	
			//	artbean.setLabel(rs.getString("articleshortform"));
				//artbean.setArticleid(rs.getString("articleid"));
				arttypeeditarraylist.add(artbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return arttypeeditarraylist;
	}

	@Override
	public boolean editprfArticle(PrfArticle artindertdetail, 
			String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		int noofrows  = 0;
		int updatestatusrow = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("UPDATE elpro.tbl_prf_article SET articleid = ? , articlename = ? , size = ? , substance = ? , selection = ? , selectionpercent = ? , color = ? , quantity = ? , unit = ? , pcs = ? , rate = ? , tc = ? , contractno = ? ,  articletype = ? , articleshfrom = ?  WHERE prfarticleid = '"+artindertdetail.getPrf_articleid()+"' ");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			pst.setString(1, artindertdetail.getArticleid());
			System.out.println("getArticleid " +artindertdetail.getArticleid());
			pst.setString(2, artindertdetail.getPrf_articlename());
			System.out.println("getArticlename " +artindertdetail.getPrf_articlename());
			pst.setString(3, artindertdetail.getPrf_size());
			pst.setString(4, artindertdetail.getPrf_substance());
			pst.setString(5, artindertdetail.getPrf_selection());
			pst.setString(6, artindertdetail.getPrf_selectionp());
			pst.setString(7, artindertdetail.getPrf_color());
			pst.setString(8, artindertdetail.getPrf_quantity());
			pst.setString(9, artindertdetail.getPrf_unit());
			pst.setString(10, artindertdetail.getPrf_pieces());
			pst.setString(11, artindertdetail.getPrf_rate());
			pst.setString(12, artindertdetail.getPrf_tc());
			pst.setString(13, artindertdetail.getPrf_contractnum());
			pst.setString(14, artindertdetail.getPrf_articletype());
			pst.setString(15, artindertdetail.getArtshform() );
			System.out.println("Prf Article ID " +artindertdetail.getPrf_articleid());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){
				System.out.println(" Update for Status table "+noofrows);
				StringBuffer sql_updateprfArticlestatus = new StringBuffer("UPDATE elpro.tbl_prfarticle_status set artname = ? , qty = ? , qbal = ?  WHERE prf_articleid = '"+artindertdetail.getPrf_articleid()+"' ");
				String sqlquery_updateprfArticlestatus = sql_updateprfArticlestatus.toString();
				System.out.println("Save quert" +sqlquery_updateprfArticlestatus);
				pst1 = (PreparedStatement) con.prepareStatement(sqlquery_updateprfArticlestatus);
				pst1.setString(1, artindertdetail.getPrf_articlename());
				pst1.setString(2, artindertdetail.getPrf_quantity());
				pst1.setString(3, artindertdetail.getPrf_quantity());
				updatestatusrow = pst1.executeUpdate();
				System.out.println("Sucessfully Inseerter in Status Table." + updatestatusrow);
			}
			System.out.println("Sucessfully inserted the record.." + noofrows);
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isupdate = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
		return isupdate;
	}

	@Override
	public boolean delprfArticle(PrfArticle artindertdetail, String sidx, 
			String sord) throws SQLException {
			Connection con = null;
			PreparedStatement pst = null;
			PreparedStatement pst1 = null;
			int noofrows  = 0;
			int delstatusrow  = 0;
			boolean isdel = true;
			try{			
				con = DBConnection.getConnection();
				StringBuffer sql_saveprfArticle = new StringBuffer("delete from elpro.tbl_prf_article WHERE prfarticleid = '"+artindertdetail.getPrf_articleid()+"' ");
				String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
				System.out.println(sqlquery_saveprfArticle);
				pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
				noofrows = pst.executeUpdate();
				if(noofrows == 1){
					System.out.println(" Delete for Status table "+noofrows);
					StringBuffer sql_delprfArticlestatus = new StringBuffer("delete from  elpro.tbl_prfarticle_status WHERE prf_articleid = '"+artindertdetail.getPrf_articleid()+"' ");
					String sqlquery_delprfArticlestatus = sql_delprfArticlestatus.toString();
					System.out.println("Save quert" +sqlquery_delprfArticlestatus);
					pst1 = (PreparedStatement) con.prepareStatement(sqlquery_delprfArticlestatus);

					delstatusrow = pst1.executeUpdate();
					System.out.println("Sucessfully Inseerter in Status Table." + delstatusrow);
				}
				System.out.println("Sucessfully inserted the record.." + noofrows);
				System.out.println("Sucessfully inserted the record.." + noofrows);
				System.out.println("Sucessfully deleted the record.." + noofrows);
			}catch(Exception e){
				e.printStackTrace();
				isdel = false;
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 pst.close();
		   }	
			return isdel;
	}
	
	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getSizeRemList()
	 */
	@Override
	public ArrayList<AutoComplete> getSizeRemList() throws SQLException {
		ArrayList<AutoComplete> sizeremarraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT shform, sizeremarksid FROM elpro.tbl_sizeremarks order by sizeremarks";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete sizerembean = new AutoComplete();
				sizerembean.setValue(rs.getString("shform"));		
				System.out.println("selection name "+sizerembean.getValue());
				sizeremarraylist.add(sizerembean);
				}
			System.out.println("selection Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("selection ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return sizeremarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getQtyunitList()
	 */
	@Override
	public ArrayList<AutoComplete> getQtyunitList() throws SQLException {
		ArrayList<AutoComplete> qtyunitarraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT unit, comments FROM elpro.tbl_unit order by unitid";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete qtyunitbean = new AutoComplete();
				qtyunitbean.setValue(rs.getString("unit"));		
				System.out.println("unit name "+qtyunitbean.getValue());
				qtyunitarraylist.add(qtyunitbean);
				}
			System.out.println("qty unit Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("qty unit ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return qtyunitarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getCurrencyList()
	 */
	@Override
	public ArrayList<AutoComplete> getCurrencyList() throws SQLException {
		ArrayList<AutoComplete> currencyarraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT name, symbol FROM elpro.tbl_currency order by currencyid";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete currencybean = new AutoComplete();
				currencybean.setValue(rs.getString("symbol"));		
				System.out.println("getCurrencyList "+currencybean.getValue());
				currencyarraylist.add(currencybean);
				}
			System.out.println("symbol Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("symbol ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return currencyarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getSubCurrencyList()
	 */
	@Override
	public ArrayList<AutoComplete> getSubCurrencyList() throws SQLException {
		ArrayList<AutoComplete> subcurrencyarraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct sub FROM elpro.tbl_currency order by currencyid";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete subcurrencybean = new AutoComplete();
				subcurrencybean.setValue(rs.getString("sub"));		
				System.out.println("getsubCurrencyList "+subcurrencybean.getValue());
				subcurrencyarraylist.add(subcurrencybean);
				}
			System.out.println("symbol Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("symbol ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return subcurrencyarraylist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getTcCustList()
	 */
	@Override
	public ArrayList<AutoComplete> getTcCustList() throws SQLException {
		ArrayList<AutoComplete> tccustarraylist = new ArrayList<AutoComplete>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT distinct tcagent FROM elpro.tbl_tcagent order by tcagent";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete tccustbean = new AutoComplete();
				tccustbean.setValue(rs.getString("tcagent"));		
				System.out.println("tcagent "+tccustbean.getValue());
				tccustarraylist.add(tccustbean);
				}
			System.out.println("tcagent Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("tcagent ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return tccustarraylist;
	}

	
	@Override
	public boolean savePrfForm(ProductDetails prfbean) throws SQLException {
		System.out.println("In PRF SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		int noofrowsupdtd  = 0;
		boolean isSaved =true;
		
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_prfform (Ctno, agent, Orderdt, pono, exporterid, tanneryid, customerid, cdd_date, add_date, destination, terms, insurance, payment, commission, othercommission, splcdn, inspcdn, consigneeid, notifyid, bankid, pojw)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			System.out.println(" IN PRF SAVE IN THE ");
			pst.setString(1, prfbean.getPrf_contractno());
			System.out.println("getPrf_contractno " +prfbean.getPrf_contractno());
			pst.setString(2, prfbean.getPrf_agentname());
			System.out.println("getPrf_agentname " +prfbean.getPrf_agentname());
			pst.setString(3, prfbean.getPrf_orderdate());
			pst.setString(4, prfbean.getPrf_poreftype() +", "+ prfbean.getPrf_poref());
			pst.setString(5, prfbean.getPrf_exporterid());
			pst.setString(6, prfbean.getPrf_tannid());
			pst.setString(7, prfbean.getPrf_custid());
			pst.setString(8, prfbean.getPrf_cdd());
			pst.setString(9, prfbean.getPrf_add());
			pst.setString(10, prfbean.getPrf_destination());
			pst.setString(11, prfbean.getPrf_terms());
			pst.setString(12, prfbean.getPrf_insurance());
			pst.setString(13, prfbean.getPrf_payment());
			pst.setString(14, prfbean.getPrf_elclasscommission());
			pst.setString(15, prfbean.getPrf_commission());
			pst.setString(16, prfbean.getPrf_special());
			pst.setString(17, prfbean.getPrf_inspcdn());
			pst.setString(18, prfbean.getPrf_consigneeid());
			pst.setString(19, prfbean.getPrf_notifyid());
			pst.setString(20, prfbean.getPrf_bankid());
			pst.setString(21, prfbean.getPrf_pojwno());
			System.out.println("getPrf_pojw " +prfbean.getPrf_pojwno());
			noofrows = pst.executeUpdate();
			if(noofrows == 1){ 
				/*
				 * Call the STored Procedure for the prfctno table update
				 * Save Prfno in Table 
				 */
			System.out.println(" Save for Ct No table "+noofrows);
			StringBuffer sql_updtprfctno = new StringBuffer("UPDATE elpro.tbl_prfctno SET contractno = ?  WHERE agentname = '"+prfbean.getPrf_agentname()+"' ");
			String sqlquery_updtprfctno = sql_updtprfctno.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtprfctno);
			pst.setString(1, prfbean.getPrf_contractno());
			System.out.println("getPrf_contractno " +prfbean.getPrf_contractno());
			noofrowsupdtd = pst.executeUpdate();
			System.out.println("Sucessfully updtd the CTNo Table." + noofrowsupdtd);
			}
			System.out.println("Sucessfully inserted the record.." + noofrows);
	}catch(Exception e){
		e.printStackTrace();
		isSaved = false;
		System.out.println("ERROR RESULT");
	}finally{
		 con.close() ;
		 pst.close();
   }	
		return isSaved;
	}

	
	

		

	


	
	

	@Override
	public List<ProductDetails> getEditPrfFormDetails(String ctno)
			throws SQLException {
		List<ProductDetails> editprfformlist = new ArrayList<ProductDetails>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT form.Ctno, form.agent, form.Orderdt, form.pono, form.exporterid, form.tanneryid, form.customerid, form.cdd_date, form.add_date, form.destination, form.terms, form.payment, form.commission, form.othercommission, form.splcdn, form.inspcdn, form.consigneeid, form.notifyid, form.bankid, form.pojw, tan.tanid as exporterid, tan.tanname as exporter, tan.tanattn as exporterattn, tan.tanaddr as exporteraddr, tan.tanphone as exporterphone, tan.tanfax as exporterfax, cust.custid, cust.custname, cust.custaddr, cust.custattn, cust.custphone, cust.custfax, consig.consigname,consig.consigattn, consig.consigaddr, consig.consigphone, consig.consigfax, notify.notifyname, notify.notifyattn, notify.notifyaddr,notify.notifyphone, notify.notifyfax, bank.bankname, bank.bankbranch, bank.bankaddr, bank.bankphone, bank.bankfax,pojw.pojwno, pojw.orderdate, pojw.CDD, pojw.com, pojw.Tannery, tan1.tanid, tan1.tanname, tan1.tanattn, tan1.tanaddr, tan1.tanphone, tan1.tanfax, pojw.splcdn, pojw.paymentterm , pojw.Ctno as contractno, pojw.Category FROM elpro.tbl_prfform form  left outer join elpro.tbl_tannery tan on form.tanneryid =  tan.tanid left outer join elpro.tbl_customer cust on form.customerid =  cust.custid left outer join elpro.tbl_consignee consig on form.consigneeid =  consig.consigid left outer join elpro.tbl_notify notify on form.notifyid =  notify.notifyid left outer join elpro.tbl_bank bank on form.bankid =  bank.bankid left outer join elpro.tbl_pojw pojw on pojw.Ctno =  form.Ctno left outer join elpro.tbl_tannery tan1 on pojw.Tannery =  tan1.tanid where form.Ctno= '"+ctno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);	
			if(rs.next()) {	
					String varrefno = rs.getString("pono");
					int index = varrefno.indexOf(',');
					String reftype = varrefno.substring(0,index);
					System.out.println(" reftype"+reftype);
					String refno = varrefno.substring(index+1);
					System.out.println(" refno"+refno);
				
				ProductDetails editprfformbean = new ProductDetails();
				editprfformbean.setPrf_agentname(rs.getString("agent"));
				editprfformbean.setPrf_orderdate(DateConversion.ConverttoNormalDate(rs.getString("Orderdt")));
				editprfformbean.setPrf_poref(refno);
				editprfformbean.setPrf_poreftype(reftype);
				System.out.println("PONONO "+editprfformbean.getPrf_poref());
				editprfformbean.setPrf_exporterid(rs.getString("exporterid"));
				editprfformbean.setPrf_tannid(rs.getString("exporterid"));
				editprfformbean.setPrf_tanname(rs.getString("exporter"));
				editprfformbean.setPrf_tanattn(rs.getString("exporterattn"));
				editprfformbean.setPrf_tanaddr(rs.getString("exporteraddr"));
				editprfformbean.setPrf_tanphone(rs.getString("exporterphone"));
				editprfformbean.setPrf_tanfax(rs.getString("exporterfax"));
				editprfformbean.setPrf_custid(rs.getString("customerid"));
				editprfformbean.setPrf_custname(rs.getString("cust.custname"));
				editprfformbean.setPrf_custattn(rs.getString("cust.custattn"));
				editprfformbean.setPrf_custaddr(rs.getString("cust.custaddr"));
				editprfformbean.setPrf_custphone(rs.getString("cust.custphone"));
				editprfformbean.setPrf_custfax(rs.getString("cust.custfax"));
				editprfformbean.setPrf_cdd(DateConversion.ConverttoNormalDate(rs.getString("cdd_date")));
				editprfformbean.setPrf_add(DateConversion.ConverttoNormalDate(rs.getString("add_date")));
				editprfformbean.setPrf_destination(rs.getString("destination"));
				editprfformbean.setPrf_terms(rs.getString("terms"));
				editprfformbean.setPrf_payment(rs.getString("payment"));
				editprfformbean.setPrf_elclasscommission(rs.getString("commission"));
				editprfformbean.setPrf_commission(rs.getString("othercommission"));
				editprfformbean.setPrf_special(rs.getString("splcdn"));
				editprfformbean.setPrf_inspcdn(rs.getString("inspcdn"));
				editprfformbean.setPrf_consigneeid(rs.getString("consigneeid"));
				editprfformbean.setPrf_consigneename(rs.getString("consig.consigname"));
				editprfformbean.setPrf_consigneeattn(rs.getString("consig.consigattn"));
				editprfformbean.setPrf_consigneeaddr(rs.getString("consig.consigaddr"));
				editprfformbean.setPrf_consigneephone(rs.getString("consig.consigphone"));
				editprfformbean.setPrf_consigneefax(rs.getString("consig.consigfax"));
				
				editprfformbean.setPrf_notifyid(rs.getString("notifyid"));
				editprfformbean.setPrf_notifyname(rs.getString("notify.notifyname"));
				editprfformbean.setPrf_notifyattn(rs.getString("notify.notifyattn"));
				editprfformbean.setPrf_notifyaddr(rs.getString("notify.notifyaddr"));
				editprfformbean.setPrf_notifyphone(rs.getString("notify.notifyphone"));
				editprfformbean.setPrf_notifyfax(rs.getString("notify.notifyfax"));
				
				editprfformbean.setPrf_bankid(rs.getString("bankid"));
				editprfformbean.setPrf_bankname(rs.getString("bank.bankname"));
				editprfformbean.setPrf_bankaddr(rs.getString("bank.bankaddr"));
				editprfformbean.setPrf_bankbranch(rs.getString("bank.bankbranch"));
				editprfformbean.setPrf_bankphone(rs.getString("bank.bankphone"));
				editprfformbean.setPrf_bankfax(rs.getString("bank.bankfax"));
				
				editprfformbean.setPrf_pojwno(rs.getString("pojw"));
				
				
				//pojw
				editprfformbean.setPojw_pojwno(rs.getString("pojw"));
				System.out.println(" / "+rs.getString("orderdate"));
				editprfformbean.setPojw_orderdate(DateConversion.ConverttoNormalDate(rs.getString("orderdate")));
				
				editprfformbean.setPojw_cddate(DateConversion.ConverttoNormalDate(rs.getString("CDD")));
				editprfformbean.setPojw_tanid(rs.getString("tanid"));
				editprfformbean.setPojw_tanname(rs.getString("tanname"));
				editprfformbean.setPojw_tanattn(rs.getString("tanattn"));
				editprfformbean.setPojw_tanaddr(rs.getString("tanaddr"));
				editprfformbean.setPojw_tanphone(rs.getString("tanphone"));
				editprfformbean.setPojw_tanfax(rs.getString("tanfax"));
				editprfformbean.setPojw_contractno(rs.getString("contractno"));
				editprfformbean.setPojw_comm(rs.getString("com"));
				editprfformbean.setPojw_payterms(rs.getString("paymentterm"));
				editprfformbean.setPojw_splcdn(rs.getString("splcdn"));
				
				editprfformbean.setFormaction("edit");
				 
				
				editprfformlist.add(editprfformbean);
				
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return editprfformlist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#updatePrfForm(sb.elpro.model.ProductDetails)
	 */
	@Override
	public boolean updatePrfForm(ProductDetails prfbean) throws SQLException {
		System.out.println("In PRF Update");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isUpdated =true;
		
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_uptprfArticle = new StringBuffer("Update tbl_prfform SET Orderdt = ? , pono = ? , exporterid  = ? , tanneryid = ? , customerid = ?, cdd_date = ?, add_date = ? , destination = ? , terms = ? , insurance = ? , payment = ? , commission = ? , othercommission = ? , splcdn = ? , inspcdn = ? , consigneeid = ? , notifyid = ? , bankid =? , pojw =? where Ctno = '"+prfbean.getPrf_contractno()+ "'");
			String sqlquery_uptprfArticle = sql_uptprfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_uptprfArticle);
	
			pst.setString(1, prfbean.getPrf_orderdate());
			pst.setString(2, prfbean.getPrf_poreftype() +", "+ prfbean.getPrf_poref());
			pst.setString(3, prfbean.getPrf_exporterid());
			pst.setString(4, prfbean.getPrf_tannid());
			pst.setString(5, prfbean.getPrf_custid());
			pst.setString(6, prfbean.getPrf_cdd());
			pst.setString(7, prfbean.getPrf_add());
			pst.setString(8, prfbean.getPrf_destination());
			pst.setString(9, prfbean.getPrf_terms());
			pst.setString(10, prfbean.getPrf_insurance());
			pst.setString(11, prfbean.getPrf_payment());
			pst.setString(12, prfbean.getPrf_elclasscommission());
			pst.setString(13, prfbean.getPrf_commission());
			pst.setString(14, prfbean.getPrf_special());
			pst.setString(15, prfbean.getPrf_inspcdn());
			pst.setString(16, prfbean.getPrf_consigneeid());
			pst.setString(17, prfbean.getPrf_notifyid());
			pst.setString(18, prfbean.getPrf_bankid());
			pst.setString(19, prfbean.getPrf_pojwno());
			System.out.println("getPrf_pojw " +prfbean.getPrf_pojwno());
			noofrows = pst.executeUpdate();
			
			System.out.println("Sucessfully UPDATED  the PRF FORM WHOAAAAA!.." + noofrows);
	}catch(Exception e){
		e.printStackTrace();
		isUpdated = false;
		System.out.println("ERROR RESULT");
	}finally{
		 con.close() ;
		 pst.close();
   }	
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getPoJwno()
	 */
	@Override
	public String getPoJwno() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String pojw = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT max(pojwno) as pojwno FROM elpro.tbl_pojw";
			rs = st.executeQuery(sql);
			if(rs.next()) {	
				System.out.println(" IN POJW get NO");
				String spojwno =  rs.getString("pojwno").trim();
				int pono = Integer.parseInt(spojwno.substring(spojwno.indexOf('O')+1))+1;
				 pojw = "PO"+pono;
				System.out.println("pojwno "+pojw);	
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return pojw;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#savePoJwForm(sb.elpro.model.PoJwBean)
	 */
	@Override
	public boolean savePoJwForm(ProductDetails pojw) throws SQLException {
		System.out.println("In POJW SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isSaved =true;		
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savepojwform = new StringBuffer("insert into tbl_pojw (pojwno, orderdate, CDD, Tannery, splcdn, com, paymentterm, Ctno, Category)");
			sql_savepojwform.append("values (?,?,?,?,?,?,?,?,?)");
			String sqlquery_savepojwform = sql_savepojwform.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savepojwform);
			pst.setString(1, pojw.getPojw_pojwno());
			System.out.println("getPojwno " +pojw.getPojw_pojwno());
			pst.setString(2, pojw.getPojw_orderdate());
			System.out.println("getPojw_orderdate " +pojw.getPojw_orderdate());
			pst.setString(3, pojw.getPojw_cddate());
			pst.setString(4, pojw.getPojw_tanid());
			pst.setString(5, pojw.getPojw_splcdn());
			pst.setString(6, pojw.getPojw_comm());
			pst.setString(7, pojw.getPojw_payterms());
			pst.setString(8, pojw.getPojw_contractno());
			pst.setString(9,"PO");
			noofrows = pst.executeUpdate();
			/*if(noofrows == 1){ 
				
				 * Call the STored Procedure for the prfctno table update
				 * Save Prfno in Table 				 
			System.out.println(" Save for Ct No table "+noofrows);
			StringBuffer sql_updtprfctno = new StringBuffer("UPDATE elpro.tbl_prfctno SET contractno = ?  WHERE agentname = '"+prfbean.getPrf_agentname()+"' ");
			String sqlquery_updtprfctno = sql_updtprfctno.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_updtprfctno);
			pst.setString(1, prfbean.getPrf_contractno());
			System.out.println("getPrf_contractno " +prfbean.getPrf_contractno());
			noofrowsupdtd = pst.executeUpdate();
			System.out.println("Sucessfully updtd the CTNo Table." + noofrowsupdtd);
			}*/
			System.out.println("Sucessfully inserted the record.." + noofrows);
	}catch(Exception e){
		e.printStackTrace();
		isSaved = false;
		System.out.println("ERROR RESULT");
	}finally{
		 con.close() ;
		 pst.close();
   }	
		return isSaved;
	}

	

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#getPojwArticleDetails(java.lang.String)
	 */
	@Override
	public ArrayList<PrfArticle> getPojwArticleDetails(String ctno)
			throws SQLException {
		ArrayList<PrfArticle> pojwarticlearray = new ArrayList<PrfArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articleshfrom, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, user, contractno, prfarticleid FROM tbl_prf_article where contractno = '"+ctno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			PrfArticle pojwartbean = new PrfArticle();
				pojwartbean.setArticleid(rs.getString("articleid"));
				pojwartbean.setPrf_articletype(rs.getString("articletype"));
				pojwartbean.setArtshform(rs.getString("articleshfrom"));
				pojwartbean.setPrf_articlename(rs.getString("articlename"));
				pojwartbean.setPrf_size(rs.getString("size"));
				pojwartbean.setPrf_substance(rs.getString("substance"));
				pojwartbean.setPrf_selection(rs.getString("selection"));
				pojwartbean.setPrf_selectionp(rs.getString("selectionpercent"));
				pojwartbean.setPrf_color(rs.getString("color"));
				pojwartbean.setPrf_quantity(rs.getString("quantity"));
				pojwartbean.setPrf_contractnum(rs.getString("contractno"));
				pojwartbean.setPrf_articleid(rs.getString("color"));
				pojwartbean.setPrf_unit(rs.getString("unit"));
				pojwartbean.setPrf_pieces(rs.getString("pcs"));
				pojwartbean.setPrf_rate(rs.getString("rate"));
				pojwartbean.setPrf_tc(rs.getString("tc"));
				System.out.println(" tC  "+pojwartbean.getPrf_tc());
				pojwartbean.setUser(rs.getString("user"));
				pojwartbean.setPrf_articleid(rs.getString("prfarticleid"));		
				System.out.println("Article name "+pojwartbean.getPrf_articlename());
				pojwarticlearray.add(pojwartbean);
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return pojwarticlearray;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.PrfDao#addpoArticle(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<PrfArticle> addpoArticle(String copyctno, String copypojw)
			throws SQLException {
		ArrayList<PrfArticle> pojwloadarticlearray = new ArrayList<PrfArticle>();
		Connection con = null;
		//PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		Statement st = null;
		ResultSet rs = null;
		int noofrows  = 0;
		int addstatusrow = 0;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articleshfrom, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, user, contractno, prfarticleid FROM tbl_prf_article where contractno = '"+copyctno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
			PrfArticle pojwselartbean = new PrfArticle();
				pojwselartbean.setArticleid(rs.getString("articleid"));
				pojwselartbean.setPrf_articletype(rs.getString("articletype"));
				pojwselartbean.setPrf_articlename(rs.getString("articlename"));
				pojwselartbean.setArtshform(rs.getString("articleshfrom"));
				pojwselartbean.setPrf_size(rs.getString("size"));
				System.out.println("size "+rs.getString("size"));
				pojwselartbean.setPrf_substance(rs.getString("substance"));
				pojwselartbean.setPrf_selection(rs.getString("selection"));
				pojwselartbean.setPrf_selectionp(rs.getString("selectionpercent"));
				pojwselartbean.setPrf_color(rs.getString("color"));
				pojwselartbean.setPrf_quantity(rs.getString("quantity"));
				pojwselartbean.setPrf_contractnum(rs.getString("contractno"));
				pojwselartbean.setPrf_articleid(rs.getString("prfarticleid"));
				pojwselartbean.setPrf_unit(rs.getString("unit"));
				pojwselartbean.setPrf_pieces(rs.getString("pcs"));
				pojwselartbean.setPrf_rate(rs.getString("rate"));
				System.out.println("rate "+rs.getString("rate"));
				pojwselartbean.setPrf_tc(rs.getString("tc"));
				System.out.println("rate "+rs.getString("tc"));
				pojwselartbean.setUser(rs.getString("user"));
				pojwselartbean.setPrf_articleid(rs.getString("prfarticleid"));	
				System.out.println("Artilce REtrieved Successfully");
				System.out.println("Article name "+pojwselartbean.getPrf_articlename());
				pojwloadarticlearray.add(pojwselartbean);
				}
		/*
		 * Method to Copy the Article from Contract TO POJW 
		 */
			StringBuffer sql_saveprfArticle = new StringBuffer("insert into tbl_prf_article (articleid, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, contractno, articletype, articleshfrom,user)");
			sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			pst1 = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
			for(int i=0; i<pojwloadarticlearray.size(); i++){
				PrfArticle  pojwarticlearray = pojwloadarticlearray.get(i);
				pst1.setString(1, pojwarticlearray.getArticleid());
				System.out.println("getArticleid " +pojwarticlearray.getArticleid());
				pst1.setString(2, pojwarticlearray.getPrf_articlename());
				System.out.println("getArticlename " +pojwarticlearray.getPrf_articlename());
				pst1.setString(3, pojwarticlearray.getPrf_size());
				pst1.setString(4, pojwarticlearray.getPrf_substance());
				pst1.setString(5, pojwarticlearray.getPrf_selection());
				pst1.setString(6, pojwarticlearray.getPrf_selectionp());
				pst1.setString(7, pojwarticlearray.getPrf_color());
				pst1.setString(8, pojwarticlearray.getPrf_quantity());
				pst1.setString(9, pojwarticlearray.getPrf_unit());
				pst1.setString(10, pojwarticlearray.getPrf_pieces());
				pst1.setString(11, pojwarticlearray.getPrf_rate());
				pst1.setString(12, pojwarticlearray.getPrf_tc());
				pst1.setString(13, copypojw);
				pst1.setString(14, pojwarticlearray.getPrf_articletype());
				pst1.setString(15, pojwarticlearray.getArtshform() );
				pst1.setString(16, pojwarticlearray.getUser());
				System.out.println("getContractno " +pojwarticlearray.getPrf_contractnum());
			}
			noofrows = pst1.executeUpdate();
			System.out.println("noofrows INSERTED  "+noofrows);
			if(noofrows == 1){
				System.out.println(" Save for Status table "+noofrows);
				StringBuffer sql_saveprfArticlestatus = new StringBuffer("insert into elpro.tbl_prfarticle_status (artname, status, qty, qshipped, qbal, invdetails, reps, comments, feddback, contractno, rdd_date) ");
				sql_saveprfArticlestatus.append("values (?,?,?,?,?,?,?,?,?,?,?)");
				String sqlquery_saveprfArticlestatus = sql_saveprfArticlestatus.toString();
				System.out.println("Save quert" +sqlquery_saveprfArticlestatus);
				pst2 = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticlestatus);
				for(int i=0; i<pojwloadarticlearray.size(); i++){
				 PrfArticle  pojwstatusarticlearray = pojwloadarticlearray.get(i);
					pst2.setString(1, pojwstatusarticlearray.getPrf_articlename());
					System.out.println("getPrf_articlename " +pojwstatusarticlearray.getPrf_articlename());
					pst2.setString(2, "P");
					pst2.setString(3, pojwstatusarticlearray.getPrf_quantity());
					pst2.setString(4, "0");
					pst2.setString(5, pojwstatusarticlearray.getPrf_quantity());
					pst2.setString(6, "NA");
					pst2.setString(7, "NA");
					pst2.setString(8, "NA");
					pst2.setString(9, "NA");
					pst2.setString(10, pojwstatusarticlearray.getPrf_contractnum());
					pst2.setString(11, "2014-01-01");
				}
				//int prfarticleid = Integer.parseInt(pojwarticlearray.getPrf_articleid());
				addstatusrow = pst2.executeUpdate();
				System.out.println("Sucessfully Inseerter in Status Table." + addstatusrow);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return pojwloadarticlearray;
	}
}
