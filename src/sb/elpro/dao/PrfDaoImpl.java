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
import sb.elpro.model.ColourDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.DestinationDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.PrfArticle;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.RateDetails;
import sb.elpro.model.SelectArticle;
import sb.elpro.model.SelectionDetails;
import sb.elpro.model.ShipmentDetails;
import sb.elpro.model.SizeRemarks;
import sb.elpro.model.TanneryDetails;
import sb.elpro.model.TcDetails;
import sb.elpro.model.TermsDetails;
import sb.elpro.utility.DBConnection;

/**
 * @author Wahab
 *
 */
public class PrfDaoImpl implements PrfDao {

	@Override
	public ArrayList<AgentDetails> getAgentList() throws SQLException {
		ArrayList<AgentDetails> agentarraylist = new ArrayList<AgentDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT agentid, agentname, contractno FROM elpro.tbl_agent order by agentname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AgentDetails agentlist  = new AgentDetails();
				agentlist.setAgentname(rs.getString("agentname"));
				agentlist.setAgentId(rs.getString("agentid"));
				agentlist.setContractNo(rs.getString("contractno"));	
				System.out.println("Agent name "+agentlist.getContractNo());
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
				System.out.println("Tan name "+tanbean.getLabel());
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
/*
	@Override
	public ArrayList<ConsigneeDetails> getConsigneeList() throws SQLException {
		ArrayList<ConsigneeDetails> consigarrayList = new ArrayList<ConsigneeDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT consigid, consigname, consigattn, consigaddr, consigphone, consigfax FROM elpro.tbl_consignee";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ConsigneeDetails consigbean = new ConsigneeDetails();
				consigbean.setConsigneeAddress(rs.getString("consigaddr"));
				consigbean.setConsigneeAttention(rs.getString("consigattn"));
				consigbean.setConsigneefax(rs.getString("consigfax"));
				consigbean.setConsigneeId(rs.getString("consigid"));
				consigbean.setConsigneeName(rs.getString("consigname"));
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
	public ArrayList<NotifyConsigneeDetails> getNotifyList() throws SQLException {
		ArrayList<NotifyConsigneeDetails> notifyconsigarrayList = new ArrayList<NotifyConsigneeDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT notifyid, notifyname, notifyattn, notifyaddr, notifyphone, notifyfax FROM elpro.tbl_notify";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				NotifyConsigneeDetails notifyconsigbean = new NotifyConsigneeDetails();
				notifyconsigbean.setNotifyConsigneeAddress(rs.getString("notifyaddr"));
				notifyconsigbean.setNotifyConsigneeAttention(rs.getString("notifyattn"));
				notifyconsigbean.setNotifyConsigneefax(rs.getString("notifyfax"));
				notifyconsigbean.setNotifyConsigneeId(rs.getString("notifyid"));
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
	public ArrayList<BankDetails> getBankList() throws SQLException {
		ArrayList<BankDetails> bankarraylist = new ArrayList<BankDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT bankid, bankname, bankbranch, bankaddr, bankphone, bankfax FROM elpro.tbl_bank";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				BankDetails bankbean = new BankDetails();
				bankbean.setBankAddress(rs.getString("bankaddr"));
				bankbean.setBankBranch(rs.getString("bankbranch"));
				bankbean.setBankId(rs.getString("bankid"));
				bankbean.setBankName(rs.getString("bankname"));
				bankbean.setBankContactNo(rs.getString("bankphone"));
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
*/
	@Override
	public ArrayList<DestinationDetails> getDestinationList() throws SQLException {
		ArrayList<DestinationDetails> destarraylist = new ArrayList<DestinationDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT destid, destname FROM elpro.tbl_destination";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				DestinationDetails destbean = new DestinationDetails();
				destbean.setDestination(rs.getString("destname"));
				destbean.setDestinationId(rs.getString("destid"));				
				System.out.println("dest name "+destbean.getDestination());
				destarraylist.add(destbean);				
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
		return destarraylist;
			
	}

	@Override
	public ArrayList<PaymentDetails> getPaymnetList() throws SQLException {
		ArrayList<PaymentDetails> payarraylist = new ArrayList<PaymentDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT payid, payname FROM tbl_payment";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				PaymentDetails paybean = new PaymentDetails();
				paybean.setPayment(rs.getString("payname"));
				paybean.setPaymentId(rs.getString("payid"));
				System.out.println("Payment name "+paybean.getPayment());
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
	public ArrayList<TermsDetails> getTermsList() throws SQLException {
		ArrayList<TermsDetails> termsarray = new ArrayList<TermsDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT termid, termname FROM tbl_terms";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				TermsDetails termsbean = new TermsDetails();
				termsbean.setTermName(rs.getString("termname"));
				termsbean.setTermId(rs.getString("termid"));
				System.out.println("Terms name "+termsbean.getTermName());
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
	public ArrayList<ProductDetails> savePrfForm() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
	public List<SelectArticle> getArticleNameList() throws SQLException {
		List<SelectArticle> artarrayNamelist = new ArrayList<SelectArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articlename FROM tbl_article";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				SelectArticle selbean= new SelectArticle();
				selbean.setPrf_articleid(rs.getString("articleid"));
				selbean.setPrf_articlename(rs.getString("articlename"));
				artarrayNamelist.add(selbean);
				}
			System.out.println("Article name "+artarrayNamelist.toString());
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Article name ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return artarrayNamelist;
	}
	
	
	
	@Override
	public ArrayList<ColourDetails> getColorList() throws SQLException {
		ArrayList<ColourDetails> colorarraylist = new ArrayList<ColourDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT colorid, colorname FROM tbl_color";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ColourDetails colorbean = new ColourDetails();
				colorbean.setColourid(rs.getString("colorid"));
				colorbean.setColourname(rs.getString("colorname"));			
				System.out.println("Color name "+colorbean.getColourname());
				colorarraylist.add(colorbean);
				}
			System.out.println("Color Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Color ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return colorarraylist;
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

	@Override
	public ArrayList<SelectionDetails> getSelectionList() throws SQLException {
		ArrayList<SelectionDetails> selecarraylist = new ArrayList<SelectionDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT selection, selectionid FROM tbl_selection";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				SelectionDetails selecbean = new SelectionDetails();
				selecbean.setSelectionid(rs.getString("selectionid"));
				selecbean.setSelectionname(rs.getString("selection"));			
				System.out.println("selection name "+selecbean.getSelectionname());
				selecarraylist.add(selecbean);
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
		return selecarraylist;
	}

	@Override
	public ArrayList<ShipmentDetails> getShipmentList() throws SQLException {
		ArrayList<ShipmentDetails> shiparraylist = new ArrayList<ShipmentDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT shipmentid, shipment FROM tbl_shipment";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ShipmentDetails shipbean = new ShipmentDetails();
				shipbean.setShipmentid(rs.getString("shipmentid"));
				shipbean.setShipmentname(rs.getString("shipment"));			
				System.out.println("Shipment name "+shipbean.getShipmentname());
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
	}

	@Override
	public ArrayList<SizeRemarks> getSizeremarksList() throws SQLException {
		ArrayList<SizeRemarks> sizeremarraylist = new ArrayList<SizeRemarks>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT sizeremarksid, sizeremarks FROM tbl_sizeremarks";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				SizeRemarks sizerembean = new SizeRemarks();
				sizerembean.setSizeremarksid(rs.getString("sizeremarksid"));
				sizerembean.setSizeremarks(rs.getString("sizeremarks"));			
				System.out.println("sizeremarks name "+sizerembean.getSizeremarks());
				sizeremarraylist.add(sizerembean);
				}
			System.out.println("sizeremarks Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("sizeremarks ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
			}
		return sizeremarraylist;
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
			System.out.println("Sucessfully inserted the record.." + noofrows);
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
	public ArrayList<PrfArticle> getPrfArticleDetails( String sidx, String sord) throws SQLException {
		ArrayList<PrfArticle> articlearray = new ArrayList<PrfArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype, articleshfrom, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, user, contractno, prfarticleid FROM tbl_prf_article order by "+sidx+" "+sord+"";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				/*String qty = rs.getString("quantity") +" "+rs.getString("unit");
				*/
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
	public List<ArticleDetails> editprfArticle(String prfarticleid)throws SQLException {
	Connection con = null;
	ResultSet rs = null;
	Statement st = null;
	ArrayList<ArticleDetails> editarticle = new ArrayList<ArticleDetails>();			
	try{			
		con = DBConnection.getConnection();
		st = (Statement) con.createStatement();
		String sql ="select articleid, articlename, size, substance, selection, selectionpercent, color, quantity, unit, pcs, rate, tc, contractno from tbl_prf_article where prfarticleid = '"+prfarticleid+"' ";			
		rs = st.executeQuery(sql);
		while(rs.next()) {	
			String size = rs.getString("size");
			int size_minindex = size.indexOf('/');
			int size_remindex = size.lastIndexOf(' ');	
			String sizemin = size.substring(0, size_minindex-1);			
			String sizemaxtemp =  size.substring(size_minindex+2,size_remindex);			
			String sizerem =  size.substring(size_remindex+1);
			int size_maxindex = sizemaxtemp.indexOf(' ');
			String sizemax = sizemaxtemp.substring(0, size_maxindex);
			float sizeavgf = ((Float.parseFloat (sizemin) + Float.parseFloat(sizemax)) /2) ;
			sizeavgf = Math.round(sizeavgf);
			String sizeavg = String.valueOf(sizeavgf);
			
			
			String substance = rs.getString("substance");
			int subsindex = substance.indexOf('/');
			int subsindexmm = substance.indexOf('m');		
			String subsmin = substance.substring(0, subsindex);
			String subsmax = substance.substring(subsindex+2, subsindexmm);
			
			String rate = rs.getString("rate");
			int rateindex = rate.indexOf(" ");
			int rateindex1 = rate.lastIndexOf(" ");
			String ratesign = rate.substring(0, rateindex);
			String rateamt = rate.substring(rateindex+1, rateindex1);
			String shipment = rate.substring(rateindex1+1);
				
			String tc = rs.getString("tc");
			int tcindex = tc.indexOf(" ");
			int tcindex1 = tc.lastIndexOf(" ");
			String tcsign = tc.substring(0, tcindex);
			String tcamt = tc.substring(tcindex+1, tcindex1);
			String agent = tc.substring(tcindex1+1);
			
			System.out.println("Size Avg"+sizeavg);
			System.out.println("sizemin"+sizemin);
			System.out.println("sizemaxtemp"+sizemaxtemp);
			System.out.println("sizemaxfinal"+sizemax);
			System.out.println("sizerem"+sizerem);
			System.out.println("subsmin"+subsmin);
			System.out.println("subsmax"+subsmax);		
			System.out.println("rate sign"+ratesign);
			System.out.println("rate amt"+rateamt);
			System.out.println("shipment"+shipment);
			System.out.println("tc sign"+tcsign);
			System.out.println("tc amt"+tcamt);
			System.out.println("agent"+agent);
			
			ArticleDetails article = new ArticleDetails();
			article.setArticleid(prfarticleid);
			article.setArticlename(rs.getString("articlename"));
			article.setColor(rs.getString("Color"));	
			article.setSize_min(sizemin);
			article.setSize_max(sizemax);
			article.setSize_remarks(sizerem);
			article.setSize_avg(sizeavg);
			article.setSubs_min(subsmin);
			article.setSubs_max(subsmax);
			article.setSelection(rs.getString("selection"));
			article.setRate_sign(ratesign);
			article.setRate(rateamt);
			article.setShipment(shipment);
			article.setSelp(rs.getString("selectionpercent"));
			article.setQuantity(rs.getString("quantity"));
			article.setUnit(rs.getString("unit"));		
			article.setPieces(rs.getString("pcs"));
			article.setTc_amount(tcamt);
			article.setTc_currency(tcsign);
			article.setTc_agent(agent);
			article.setContractno(rs.getString("contractno"));
		 System.out.println("Result added Successfully");
		 System.out.println("articlename "+article.getArticlename());
		 editarticle.add(article);
		}	
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("ERROR RESULT");
	}finally{
		 con.close();
		 st.close();
		 rs.close();
   }	
	return editarticle;
	}

	@Override
	public List<ArticleDetails> updateprfArticle(ArticleDetails prfartbean)
			throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ArrayList<ArticleDetails> editarticle = new ArrayList<ArticleDetails>();			
		try{			
			con = DBConnection.getConnection();
			String sql ="update tbl_prf_article set articlename=?, size=?, substance=?, selection=?, selectionpercent=?, color=?, quantity=?, unit=?, pcs=?, rate=?, tc=? where prfarticleid =? ";			
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, prfartbean.getArticlename());
			System.out.println("Article name: " +prfartbean.getArticlename());
			pst.setString(2, prfartbean.getSize());
			System.out.println("Size: " +prfartbean.getSize());
			pst.setString(3, prfartbean.getSubstance());
			System.out.println("Substance: " +prfartbean.getSubstance());
			pst.setString(4, prfartbean.getSelection());
			System.out.println("Selection: " +prfartbean.getSelection());
			pst.setString(5, prfartbean.getSelp());
			System.out.println("Selectionp: " +prfartbean.getSelp());
			pst.setString(6, prfartbean.getColor());
			System.out.println("Color: " +prfartbean.getColor());
			pst.setString(7, prfartbean.getQuantity());
			System.out.println("Quantity: " +prfartbean.getQuantity());
			pst.setString(8, prfartbean.getUnit());
			System.out.println("Unit: " +prfartbean.getUnit());
			pst.setString(9, prfartbean.getPieces());
			System.out.println("Pieces: " +prfartbean.getPieces());
			pst.setString(10, prfartbean.getPrice());
			System.out.println("Rate: " +prfartbean.getPrice());
			pst.setString(11, prfartbean.getTc());
			System.out.println("Tc: " +prfartbean.getTc());
			pst.setString(12, prfartbean.getArticleid());
			System.out.println("prf Articleid: " +prfartbean.getArticleid());
			int iflag = pst.executeUpdate(); // execute update st
			System.out.println("IFALG VALYE"+iflag); 
			System.out.println("Suucess  RESULT");	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR RESULT");
		}finally{
			 con.close();
			 pst.close();
			 
	   }	
		return editarticle;
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
			//String sql = "SELECT articleid, articletype, articlename, articleshortform, size, substance, selection, color, selectionpercent, quantity, pcs, rate, tc, othername FROM elpro.tbl_article where articletype like '%"+term+"%' order by articlename";
			String sql = "SELECT articleid, articletype, articlename, articleshortform, size, substance, selection, color, selectionpercent, quantity, pcs, rate, tc, othername FROM elpro.tbl_article where articlename like '%"+term+"%' order by articlename";
			//String sql = "SELECT distinct articlename FROM elpro.tbl_article where articlename like '%"+term+"%'order by articlename";
			
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
				String rateamt = rat.substring(shipmntindex+1,shipmntindexlst-1).trim();
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
				//destarraylist.add(rs.getString("destname"));
				AutoComplete destbean = new AutoComplete();
				destbean.setLabel(rs.getString("colorname"));	
				destbean.setValue(rs.getString("colorname"));
				//destbean.setShform(rs.getString("articleshortform"));
				//System.out.println("dest name "+destbean.getLabel());
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
			String sql = "SELECT consigname, consigattn, consigaddr, consigphone, consigfax, shortform FROM elpro.tbl_consignee where consigname like '%"+consigneeterm+"%' order by consigname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				ConsigneeDetails consigbean = new ConsigneeDetails();
				consigbean.setConsigneeAddress(rs.getString("consigaddr"));
				consigbean.setConsigneeAttention(rs.getString("consigattn"));
				consigbean.setConsigneefax(rs.getString("consigfax"));
				consigbean.setLabel(rs.getString("shortform"));
				consigbean.setValue(rs.getString("consigname"));
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
			String sql = "SELECT notifyname, notifyattn, notifyaddr, notifyphone, notifyfax, shortform FROM elpro.tbl_notify where notifyname like '%"+notifyterm+"%' order by notifyname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				NotifyConsigneeDetails notifyconsigbean = new NotifyConsigneeDetails();
				notifyconsigbean.setNotifyConsigneeAddress(rs.getString("notifyaddr"));
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
	public boolean addprfArticle(PrfArticle artindertdetail, 
			String sidx, String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
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
			String sql = "SELECT distinct articletype FROM elpro.tbl_article order by articletype";
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
		int noofrows  = 0;
		boolean isupdate = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("UPDATE elpro.tbl_prf_article SET articleid = ? , articlename = ? , size = ? , substance = ? , selection = ? , selectionpercent = ? , color = ? , quantity = ? , unit = ? , pcs = ? , rate = ? , tc = ? , contractno = ? ,  articletype = ? , articleshfrom = ?  WHERE prfarticleid = '"+artindertdetail.getPrf_articleid()+"' ");
			//sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isupdate = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isupdate;
	}

	@Override
	public boolean delprfArticle(PrfArticle artindertdetail, String sidx, 
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_saveprfArticle = new StringBuffer("delete from elpro.tbl_prf_article WHERE prfarticleid = '"+artindertdetail.getPrf_articleid()+"' ");
			//sql_saveprfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_saveprfArticle = sql_saveprfArticle.toString();
			System.out.println(sqlquery_saveprfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_saveprfArticle);
		//	pst.setString(1, artindertdetail.getPrf_articleid());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isdel;
	}



	

	
}
