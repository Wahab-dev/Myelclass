/**
 * 
 */
package sb.elpro.actionform;

import org.apache.struts.action.ActionForm;

/**
 * @author Wahab
 *
 */
public class InspectionForm extends ActionForm {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1326268577180737805L;
	
	private String inps_ContractNumber;
	private String inps_date;
	private String inps_qualityctrlr;
	private String inps_id;
	private String inps_Comments;
	private String insp_cdn;
	//Grading
	private String inps_GradingId;
	private String inps_grade1skincount;
	private String inps_grade2skincount;
	private String inps_grade3skincount;
	private String inps_grade4skincount;
	private String inps_grade5skincount;
	private String inps_grade1percent;
	private String inps_grade2percent;
	private String inps_grade3percent;
	private String inps_grade4percent;
	private String inps_grade5percent;
	private String inps_grade1comments;
	private String inps_grade2comments;
	private String inps_grade3comments;
	private String inps_grade4comments;
	private String inps_grade5comments;
	
	//Rejects
	private String inps_RejectsId;
	private String inps_sidespassed;
	private String inps_hidespassed;
	private String inps_totalpassed;
	private String inps_substancerejectssides;
	private String inps_substancerejectshides;
	private String inps_substancerejects; 
	private String inps_sizerejectssides;
	private String inps_sizerejectshides;
	private String inps_sizerejects;
	private String inps_selectionrejectssides;
	private String inps_selectionrejectshides;
	private String inps_selectionrejects;
	private String inps_colorrejectssides;
	private String inps_colorrejectshides;
	private String inps_colorrejects;
	private String inps_orgrejectssides;
	private String inps_orgrejectshides;
	private String inps_orgrejects;
	private String inps_otherrejectssides;
	private String inps_otherrejectshides;
	private String inps_otherrejects;
	private String inps_totalrejectssides;
	private String inps_totalrejectshides;
	private String inps_totalrejects;
	
	//Manual Test
	private String inps_TestId;
	private String inps_article;
	private String inps_colortest;
	private String inps_substancetest;
	
	private String inps_tearstrenghttest;
	private String inps_grainbreaktest;
	private String inps_crockingdrytest;
	private String inps_crockingwettest;
	private String inps_finishadhensiontest;
	private String inps_fourfoldtest;
	private String inps_crosssectiontest;
	private String inps_organoleptictest;
	private String[] inps_testedpcs; 
	private String[] inps_testcomments;
	/**
	 * @return the inps_ContractNumber
	 */
	public String getInps_ContractNumber() {
		return inps_ContractNumber;
	}
	/**
	 * @param inps_ContractNumber the inps_ContractNumber to set
	 */
	public void setInps_ContractNumber(String inps_ContractNumber) {
		this.inps_ContractNumber = inps_ContractNumber;
	}
	/**
	 * @return the inps_date
	 */
	public String getInps_date() {
		return inps_date;
	}
	/**
	 * @param inps_date the inps_date to set
	 */
	public void setInps_date(String inps_date) {
		this.inps_date = inps_date;
	}
	/**
	 * @return the inps_qualityctrlr
	 */
	public String getInps_qualityctrlr() {
		return inps_qualityctrlr;
	}
	/**
	 * @param inps_qualityctrlr the inps_qualityctrlr to set
	 */
	public void setInps_qualityctrlr(String inps_qualityctrlr) {
		this.inps_qualityctrlr = inps_qualityctrlr;
	}
	/**
	 * @return the inps_id
	 */
	public String getInps_id() {
		return inps_id;
	}
	/**
	 * @param inps_id the inps_id to set
	 */
	public void setInps_id(String inps_id) {
		this.inps_id = inps_id;
	}
	/**
	 * @return the inps_Comments
	 */
	public String getInps_Comments() {
		return inps_Comments;
	}
	/**
	 * @param inps_Comments the inps_Comments to set
	 */
	public void setInps_Comments(String inps_Comments) {
		this.inps_Comments = inps_Comments;
	}
	/**
	 * @return the inps_GradingId
	 */
	public String getInps_GradingId() {
		return inps_GradingId;
	}
	/**
	 * @param inps_GradingId the inps_GradingId to set
	 */
	public void setInps_GradingId(String inps_GradingId) {
		this.inps_GradingId = inps_GradingId;
	}
	/**
	 * @return the inps_grade1skincount
	 */
	public String getInps_grade1skincount() {
		return inps_grade1skincount;
	}
	/**
	 * @param inps_grade1skincount the inps_grade1skincount to set
	 */
	public void setInps_grade1skincount(String inps_grade1skincount) {
		this.inps_grade1skincount = inps_grade1skincount;
	}
	/**
	 * @return the inps_grade2skincount
	 */
	public String getInps_grade2skincount() {
		return inps_grade2skincount;
	}
	/**
	 * @param inps_grade2skincount the inps_grade2skincount to set
	 */
	public void setInps_grade2skincount(String inps_grade2skincount) {
		this.inps_grade2skincount = inps_grade2skincount;
	}
	/**
	 * @return the inps_grade3skincount
	 */
	public String getInps_grade3skincount() {
		return inps_grade3skincount;
	}
	/**
	 * @param inps_grade3skincount the inps_grade3skincount to set
	 */
	public void setInps_grade3skincount(String inps_grade3skincount) {
		this.inps_grade3skincount = inps_grade3skincount;
	}
	/**
	 * @return the inps_grade4skincount
	 */
	public String getInps_grade4skincount() {
		return inps_grade4skincount;
	}
	/**
	 * @param inps_grade4skincount the inps_grade4skincount to set
	 */
	public void setInps_grade4skincount(String inps_grade4skincount) {
		this.inps_grade4skincount = inps_grade4skincount;
	}
	/**
	 * @return the inps_grade5skincount
	 */
	public String getInps_grade5skincount() {
		return inps_grade5skincount;
	}
	/**
	 * @param inps_grade5skincount the inps_grade5skincount to set
	 */
	public void setInps_grade5skincount(String inps_grade5skincount) {
		this.inps_grade5skincount = inps_grade5skincount;
	}
	/**
	 * @return the inps_grade1percent
	 */
	public String getInps_grade1percent() {
		return inps_grade1percent;
	}
	/**
	 * @param inps_grade1percent the inps_grade1percent to set
	 */
	public void setInps_grade1percent(String inps_grade1percent) {
		this.inps_grade1percent = inps_grade1percent;
	}
	/**
	 * @return the inps_grade2percent
	 */
	public String getInps_grade2percent() {
		return inps_grade2percent;
	}
	/**
	 * @param inps_grade2percent the inps_grade2percent to set
	 */
	public void setInps_grade2percent(String inps_grade2percent) {
		this.inps_grade2percent = inps_grade2percent;
	}
	/**
	 * @return the inps_grade3percent
	 */
	public String getInps_grade3percent() {
		return inps_grade3percent;
	}
	/**
	 * @param inps_grade3percent the inps_grade3percent to set
	 */
	public void setInps_grade3percent(String inps_grade3percent) {
		this.inps_grade3percent = inps_grade3percent;
	}
	/**
	 * @return the inps_grade4percent
	 */
	public String getInps_grade4percent() {
		return inps_grade4percent;
	}
	/**
	 * @param inps_grade4percent the inps_grade4percent to set
	 */
	public void setInps_grade4percent(String inps_grade4percent) {
		this.inps_grade4percent = inps_grade4percent;
	}
	/**
	 * @return the inps_grade5percent
	 */
	public String getInps_grade5percent() {
		return inps_grade5percent;
	}
	/**
	 * @param inps_grade5percent the inps_grade5percent to set
	 */
	public void setInps_grade5percent(String inps_grade5percent) {
		this.inps_grade5percent = inps_grade5percent;
	}
	/**
	 * @return the inps_grade1comments
	 */
	public String getInps_grade1comments() {
		return inps_grade1comments;
	}
	/**
	 * @param inps_grade1comments the inps_grade1comments to set
	 */
	public void setInps_grade1comments(String inps_grade1comments) {
		this.inps_grade1comments = inps_grade1comments;
	}
	/**
	 * @return the inps_grade2comments
	 */
	public String getInps_grade2comments() {
		return inps_grade2comments;
	}
	/**
	 * @param inps_grade2comments the inps_grade2comments to set
	 */
	public void setInps_grade2comments(String inps_grade2comments) {
		this.inps_grade2comments = inps_grade2comments;
	}
	/**
	 * @return the inps_grade3comments
	 */
	public String getInps_grade3comments() {
		return inps_grade3comments;
	}
	/**
	 * @param inps_grade3comments the inps_grade3comments to set
	 */
	public void setInps_grade3comments(String inps_grade3comments) {
		this.inps_grade3comments = inps_grade3comments;
	}
	/**
	 * @return the inps_grade4comments
	 */
	public String getInps_grade4comments() {
		return inps_grade4comments;
	}
	/**
	 * @param inps_grade4comments the inps_grade4comments to set
	 */
	public void setInps_grade4comments(String inps_grade4comments) {
		this.inps_grade4comments = inps_grade4comments;
	}
	/**
	 * @return the inps_grade5comments
	 */
	public String getInps_grade5comments() {
		return inps_grade5comments;
	}
	/**
	 * @param inps_grade5comments the inps_grade5comments to set
	 */
	public void setInps_grade5comments(String inps_grade5comments) {
		this.inps_grade5comments = inps_grade5comments;
	}
	/**
	 * @return the inps_RejectsId
	 */
	public String getInps_RejectsId() {
		return inps_RejectsId;
	}
	/**
	 * @param inps_RejectsId the inps_RejectsId to set
	 */
	public void setInps_RejectsId(String inps_RejectsId) {
		this.inps_RejectsId = inps_RejectsId;
	}
	/**
	 * @return the inps_sidespassed
	 */
	public String getInps_sidespassed() {
		return inps_sidespassed;
	}
	/**
	 * @param inps_sidespassed the inps_sidespassed to set
	 */
	public void setInps_sidespassed(String inps_sidespassed) {
		this.inps_sidespassed = inps_sidespassed;
	}
	/**
	 * @return the inps_hidespassed
	 */
	public String getInps_hidespassed() {
		return inps_hidespassed;
	}
	/**
	 * @param inps_hidespassed the inps_hidespassed to set
	 */
	public void setInps_hidespassed(String inps_hidespassed) {
		this.inps_hidespassed = inps_hidespassed;
	}
	/**
	 * @return the inps_totalpassed
	 */
	public String getInps_totalpassed() {
		return inps_totalpassed;
	}
	/**
	 * @param inps_totalpassed the inps_totalpassed to set
	 */
	public void setInps_totalpassed(String inps_totalpassed) {
		this.inps_totalpassed = inps_totalpassed;
	}
	/**
	 * @return the inps_substancerejectssides
	 */
	public String getInps_substancerejectssides() {
		return inps_substancerejectssides;
	}
	/**
	 * @param inps_substancerejectssides the inps_substancerejectssides to set
	 */
	public void setInps_substancerejectssides(String inps_substancerejectssides) {
		this.inps_substancerejectssides = inps_substancerejectssides;
	}
	/**
	 * @return the inps_substancerejectshides
	 */
	public String getInps_substancerejectshides() {
		return inps_substancerejectshides;
	}
	/**
	 * @param inps_substancerejectshides the inps_substancerejectshides to set
	 */
	public void setInps_substancerejectshides(String inps_substancerejectshides) {
		this.inps_substancerejectshides = inps_substancerejectshides;
	}
	/**
	 * @return the inps_substancerejects
	 */
	public String getInps_substancerejects() {
		return inps_substancerejects;
	}
	/**
	 * @param inps_substancerejects the inps_substancerejects to set
	 */
	public void setInps_substancerejects(String inps_substancerejects) {
		this.inps_substancerejects = inps_substancerejects;
	}
	/**
	 * @return the inps_sizerejectssides
	 */
	public String getInps_sizerejectssides() {
		return inps_sizerejectssides;
	}
	/**
	 * @param inps_sizerejectssides the inps_sizerejectssides to set
	 */
	public void setInps_sizerejectssides(String inps_sizerejectssides) {
		this.inps_sizerejectssides = inps_sizerejectssides;
	}
	/**
	 * @return the inps_sizerejectshides
	 */
	public String getInps_sizerejectshides() {
		return inps_sizerejectshides;
	}
	/**
	 * @param inps_sizerejectshides the inps_sizerejectshides to set
	 */
	public void setInps_sizerejectshides(String inps_sizerejectshides) {
		this.inps_sizerejectshides = inps_sizerejectshides;
	}
	/**
	 * @return the inps_sizerejects
	 */
	public String getInps_sizerejects() {
		return inps_sizerejects;
	}
	/**
	 * @param inps_sizerejects the inps_sizerejects to set
	 */
	public void setInps_sizerejects(String inps_sizerejects) {
		this.inps_sizerejects = inps_sizerejects;
	}
	/**
	 * @return the inps_selectionrejectssides
	 */
	public String getInps_selectionrejectssides() {
		return inps_selectionrejectssides;
	}
	/**
	 * @param inps_selectionrejectssides the inps_selectionrejectssides to set
	 */
	public void setInps_selectionrejectssides(String inps_selectionrejectssides) {
		this.inps_selectionrejectssides = inps_selectionrejectssides;
	}
	/**
	 * @return the inps_selectionrejectshides
	 */
	public String getInps_selectionrejectshides() {
		return inps_selectionrejectshides;
	}
	/**
	 * @param inps_selectionrejectshides the inps_selectionrejectshides to set
	 */
	public void setInps_selectionrejectshides(String inps_selectionrejectshides) {
		this.inps_selectionrejectshides = inps_selectionrejectshides;
	}
	/**
	 * @return the inps_selectionrejects
	 */
	public String getInps_selectionrejects() {
		return inps_selectionrejects;
	}
	/**
	 * @param inps_selectionrejects the inps_selectionrejects to set
	 */
	public void setInps_selectionrejects(String inps_selectionrejects) {
		this.inps_selectionrejects = inps_selectionrejects;
	}
	/**
	 * @return the inps_colorrejectssides
	 */
	public String getInps_colorrejectssides() {
		return inps_colorrejectssides;
	}
	/**
	 * @param inps_colorrejectssides the inps_colorrejectssides to set
	 */
	public void setInps_colorrejectssides(String inps_colorrejectssides) {
		this.inps_colorrejectssides = inps_colorrejectssides;
	}
	/**
	 * @return the inps_colorrejectshides
	 */
	public String getInps_colorrejectshides() {
		return inps_colorrejectshides;
	}
	/**
	 * @param inps_colorrejectshides the inps_colorrejectshides to set
	 */
	public void setInps_colorrejectshides(String inps_colorrejectshides) {
		this.inps_colorrejectshides = inps_colorrejectshides;
	}
	/**
	 * @return the inps_colorrejects
	 */
	public String getInps_colorrejects() {
		return inps_colorrejects;
	}
	/**
	 * @param inps_colorrejects the inps_colorrejects to set
	 */
	public void setInps_colorrejects(String inps_colorrejects) {
		this.inps_colorrejects = inps_colorrejects;
	}
	/**
	 * @return the inps_orgrejectssides
	 */
	public String getInps_orgrejectssides() {
		return inps_orgrejectssides;
	}
	/**
	 * @param inps_orgrejectssides the inps_orgrejectssides to set
	 */
	public void setInps_orgrejectssides(String inps_orgrejectssides) {
		this.inps_orgrejectssides = inps_orgrejectssides;
	}
	/**
	 * @return the inps_orgrejectshides
	 */
	public String getInps_orgrejectshides() {
		return inps_orgrejectshides;
	}
	/**
	 * @param inps_orgrejectshides the inps_orgrejectshides to set
	 */
	public void setInps_orgrejectshides(String inps_orgrejectshides) {
		this.inps_orgrejectshides = inps_orgrejectshides;
	}
	/**
	 * @return the inps_orgrejects
	 */
	public String getInps_orgrejects() {
		return inps_orgrejects;
	}
	/**
	 * @param inps_orgrejects the inps_orgrejects to set
	 */
	public void setInps_orgrejects(String inps_orgrejects) {
		this.inps_orgrejects = inps_orgrejects;
	}
	/**
	 * @return the inps_otherrejectssides
	 */
	public String getInps_otherrejectssides() {
		return inps_otherrejectssides;
	}
	/**
	 * @param inps_otherrejectssides the inps_otherrejectssides to set
	 */
	public void setInps_otherrejectssides(String inps_otherrejectssides) {
		this.inps_otherrejectssides = inps_otherrejectssides;
	}
	/**
	 * @return the inps_otherrejectshides
	 */
	public String getInps_otherrejectshides() {
		return inps_otherrejectshides;
	}
	/**
	 * @param inps_otherrejectshides the inps_otherrejectshides to set
	 */
	public void setInps_otherrejectshides(String inps_otherrejectshides) {
		this.inps_otherrejectshides = inps_otherrejectshides;
	}
	/**
	 * @return the inps_otherrejects
	 */
	public String getInps_otherrejects() {
		return inps_otherrejects;
	}
	/**
	 * @param inps_otherrejects the inps_otherrejects to set
	 */
	public void setInps_otherrejects(String inps_otherrejects) {
		this.inps_otherrejects = inps_otherrejects;
	}
	/**
	 * @return the inps_totalrejectssides
	 */
	public String getInps_totalrejectssides() {
		return inps_totalrejectssides;
	}
	/**
	 * @param inps_totalrejectssides the inps_totalrejectssides to set
	 */
	public void setInps_totalrejectssides(String inps_totalrejectssides) {
		this.inps_totalrejectssides = inps_totalrejectssides;
	}
	/**
	 * @return the inps_totalrejectshides
	 */
	public String getInps_totalrejectshides() {
		return inps_totalrejectshides;
	}
	/**
	 * @param inps_totalrejectshides the inps_totalrejectshides to set
	 */
	public void setInps_totalrejectshides(String inps_totalrejectshides) {
		this.inps_totalrejectshides = inps_totalrejectshides;
	}
	/**
	 * @return the inps_totalrejects
	 */
	public String getInps_totalrejects() {
		return inps_totalrejects;
	}
	/**
	 * @param inps_totalrejects the inps_totalrejects to set
	 */
	public void setInps_totalrejects(String inps_totalrejects) {
		this.inps_totalrejects = inps_totalrejects;
	}
	/**
	 * @return the inps_TestId
	 */
	public String getInps_TestId() {
		return inps_TestId;
	}
	/**
	 * @param inps_TestId the inps_TestId to set
	 */
	public void setInps_TestId(String inps_TestId) {
		this.inps_TestId = inps_TestId;
	}
	/**
	 * @return the inps_article
	 */
	public String getInps_article() {
		return inps_article;
	}
	/**
	 * @param inps_article the inps_article to set
	 */
	public void setInps_article(String inps_article) {
		this.inps_article = inps_article;
	}
	/**
	 * @return the inps_colortest
	 */
	public String getInps_colortest() {
		return inps_colortest;
	}
	/**
	 * @param inps_colortest the inps_colortest to set
	 */
	public void setInps_colortest(String inps_colortest) {
		this.inps_colortest = inps_colortest;
	}
	/**
	 * @return the inps_substancetest
	 */
	public String getInps_substancetest() {
		return inps_substancetest;
	}
	/**
	 * @param inps_substancetest the inps_substancetest to set
	 */
	public void setInps_substancetest(String inps_substancetest) {
		this.inps_substancetest = inps_substancetest;
	}
	/**
	 * @return the inps_tearstrenghttest
	 */
	public String getInps_tearstrenghttest() {
		return inps_tearstrenghttest;
	}
	/**
	 * @param inps_tearstrenghttest the inps_tearstrenghttest to set
	 */
	public void setInps_tearstrenghttest(String inps_tearstrenghttest) {
		this.inps_tearstrenghttest = inps_tearstrenghttest;
	}
	/**
	 * @return the inps_grainbreaktest
	 */
	public String getInps_grainbreaktest() {
		return inps_grainbreaktest;
	}
	/**
	 * @param inps_grainbreaktest the inps_grainbreaktest to set
	 */
	public void setInps_grainbreaktest(String inps_grainbreaktest) {
		this.inps_grainbreaktest = inps_grainbreaktest;
	}
	/**
	 * @return the inps_crockingdrytest
	 */
	public String getInps_crockingdrytest() {
		return inps_crockingdrytest;
	}
	/**
	 * @param inps_crockingdrytest the inps_crockingdrytest to set
	 */
	public void setInps_crockingdrytest(String inps_crockingdrytest) {
		this.inps_crockingdrytest = inps_crockingdrytest;
	}
	/**
	 * @return the inps_crockingwettest
	 */
	public String getInps_crockingwettest() {
		return inps_crockingwettest;
	}
	/**
	 * @param inps_crockingwettest the inps_crockingwettest to set
	 */
	public void setInps_crockingwettest(String inps_crockingwettest) {
		this.inps_crockingwettest = inps_crockingwettest;
	}
	/**
	 * @return the inps_finishadhensiontest
	 */
	public String getInps_finishadhensiontest() {
		return inps_finishadhensiontest;
	}
	/**
	 * @param inps_finishadhensiontest the inps_finishadhensiontest to set
	 */
	public void setInps_finishadhensiontest(String inps_finishadhensiontest) {
		this.inps_finishadhensiontest = inps_finishadhensiontest;
	}
	/**
	 * @return the inps_fourfoldtest
	 */
	public String getInps_fourfoldtest() {
		return inps_fourfoldtest;
	}
	/**
	 * @param inps_fourfoldtest the inps_fourfoldtest to set
	 */
	public void setInps_fourfoldtest(String inps_fourfoldtest) {
		this.inps_fourfoldtest = inps_fourfoldtest;
	}
	/**
	 * @return the inps_crosssectiontest
	 */
	public String getInps_crosssectiontest() {
		return inps_crosssectiontest;
	}
	/**
	 * @param inps_crosssectiontest the inps_crosssectiontest to set
	 */
	public void setInps_crosssectiontest(String inps_crosssectiontest) {
		this.inps_crosssectiontest = inps_crosssectiontest;
	}
	/**
	 * @return the inps_organoleptictest
	 */
	public String getInps_organoleptictest() {
		return inps_organoleptictest;
	}
	/**
	 * @param inps_organoleptictest the inps_organoleptictest to set
	 */
	public void setInps_organoleptictest(String inps_organoleptictest) {
		this.inps_organoleptictest = inps_organoleptictest;
	}
	/**
	 * @return the inps_testedpcs
	 */
	public String[] getInps_testedpcs() {
		return inps_testedpcs;
	}
	/**
	 * @param inps_testedpcs the inps_testedpcs to set
	 */
	public void setInps_testedpcs(String[] inps_testedpcs) {
		this.inps_testedpcs = inps_testedpcs;
	}
	/**
	 * @return the inps_testcomments
	 */
	public String[] getInps_testcomments() {
		return inps_testcomments;
	}
	/**
	 * @param inps_testcomments the inps_testcomments to set
	 */
	public void setInps_testcomments(String[] inps_testcomments) {
		this.inps_testcomments = inps_testcomments;
	}
	/**
	 * @return the insp_cdn
	 */
	public String getInsp_cdn() {
		return insp_cdn;
	}
	/**
	 * @param insp_cdn the insp_cdn to set
	 */
	public void setInsp_cdn(String insp_cdn) {
		this.insp_cdn = insp_cdn;
	}
	
	
	
	
		
}
