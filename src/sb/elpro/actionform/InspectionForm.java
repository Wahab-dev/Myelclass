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
	
	private String InpsContractNumber;
	private String inspdate;
	private String inspqualityctrlr;
	private String Inspectionid;
	private String Comments;

	
	//Grading
	private String GradingId;
	private String grade1skincount;
	private String grade2skincount;
	private String grade3skincount;
	private String grade4skincount;
	private String grade5skincount;
	private String grade1percent;
	private String grade2percent;
	private String grade3percent;
	private String grade4percent;
	private String grade5percent;
	private String grade1comments;
	private String grade2comments;
	private String grade3comments;
	private String grade4comments;
	private String grade5comments;
	
	//Rejects
	private String RejectsId;
	private String sidespassed;
	private String hidespassed;
	private String totalpassed;
	private String substancerejectssides;
	private String substancerejectshides;
	private String substancerejects;
	private String sizerejectssides;
	private String sizerejectshides;
	private String sizerejects;
	private String selectionrejectssides;
	private String selectionrejectshides;
	private String selectionrejects;
	private String colorrejectssides;
	private String colorrejectshides;
	private String colorrejects;
	private String orgrejectssides;
	private String orgrejectshides;
	private String orgrejects;
	private String otherrejectssides;
	private String otherrejectshides;
	private String otherrejects;
	private String totalrejectssides;
	private String totalrejectshides;
	private String totalrejects;
	
	//Manual Test
	private String TestId;
	private String article;
	private String colortest;
	private String substancetest;
	
	private String tearstrenghttest;
	private String grainbreaktest;
	private String crockingdrytest;
	private String crockingwettest;
	private String finishadhensiontest;
	private String fourfoldtest;
	private String crosssectiontest;
	private String organoleptictest;
	private String[] testedpcs; 
	private String[] testcomments;
	
	
	
	
	/**
	 * @return the inspectionid
	 */
	public String getInspectionid() {
		return Inspectionid;
	}
	/**
	 * @param inspectionid the inspectionid to set
	 */
	public void setInspectionid(String inspectionid) {
		Inspectionid = inspectionid;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return Comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		Comments = comments;
	}
	/**
	 * @return the gradingId
	 */
	public String getGradingId() {
		return GradingId;
	}
	/**
	 * @param gradingId the gradingId to set
	 */
	public void setGradingId(String gradingId) {
		GradingId = gradingId;
	}
	/**
	 * @return the grade1skincount
	 */
	public String getGrade1skincount() {
		return grade1skincount;
	}
	/**
	 * @param grade1skincount the grade1skincount to set
	 */
	public void setGrade1skincount(String grade1skincount) {
		this.grade1skincount = grade1skincount;
	}
	/**
	 * @return the grade2skincount
	 */
	public String getGrade2skincount() {
		return grade2skincount;
	}
	/**
	 * @param grade2skincount the grade2skincount to set
	 */
	public void setGrade2skincount(String grade2skincount) {
		this.grade2skincount = grade2skincount;
	}
	/**
	 * @return the grade3skincount
	 */
	public String getGrade3skincount() {
		return grade3skincount;
	}
	/**
	 * @param grade3skincount the grade3skincount to set
	 */
	public void setGrade3skincount(String grade3skincount) {
		this.grade3skincount = grade3skincount;
	}
	/**
	 * @return the grade4skincount
	 */
	public String getGrade4skincount() {
		return grade4skincount;
	}
	/**
	 * @param grade4skincount the grade4skincount to set
	 */
	public void setGrade4skincount(String grade4skincount) {
		this.grade4skincount = grade4skincount;
	}
	/**
	 * @return the grade5skincount
	 */
	public String getGrade5skincount() {
		return grade5skincount;
	}
	/**
	 * @param grade5skincount the grade5skincount to set
	 */
	public void setGrade5skincount(String grade5skincount) {
		this.grade5skincount = grade5skincount;
	}
	/**
	 * @return the grade1percent
	 */
	public String getGrade1percent() {
		return grade1percent;
	}
	/**
	 * @param grade1percent the grade1percent to set
	 */
	public void setGrade1percent(String grade1percent) {
		this.grade1percent = grade1percent;
	}
	/**
	 * @return the grade2percent
	 */
	public String getGrade2percent() {
		return grade2percent;
	}
	/**
	 * @param grade2percent the grade2percent to set
	 */
	public void setGrade2percent(String grade2percent) {
		this.grade2percent = grade2percent;
	}
	/**
	 * @return the grade3percent
	 */
	public String getGrade3percent() {
		return grade3percent;
	}
	/**
	 * @param grade3percent the grade3percent to set
	 */
	public void setGrade3percent(String grade3percent) {
		this.grade3percent = grade3percent;
	}
	/**
	 * @return the grade4percent
	 */
	public String getGrade4percent() {
		return grade4percent;
	}
	/**
	 * @param grade4percent the grade4percent to set
	 */
	public void setGrade4percent(String grade4percent) {
		this.grade4percent = grade4percent;
	}
	/**
	 * @return the grade5percent
	 */
	public String getGrade5percent() {
		return grade5percent;
	}
	/**
	 * @param grade5percent the grade5percent to set
	 */
	public void setGrade5percent(String grade5percent) {
		this.grade5percent = grade5percent;
	}
	/**
	 * @return the grade1comments
	 */
	public String getGrade1comments() {
		return grade1comments;
	}
	/**
	 * @param grade1comments the grade1comments to set
	 */
	public void setGrade1comments(String grade1comments) {
		this.grade1comments = grade1comments;
	}
	/**
	 * @return the grade2comments
	 */
	public String getGrade2comments() {
		return grade2comments;
	}
	/**
	 * @param grade2comments the grade2comments to set
	 */
	public void setGrade2comments(String grade2comments) {
		this.grade2comments = grade2comments;
	}
	/**
	 * @return the grade3comments
	 */
	public String getGrade3comments() {
		return grade3comments;
	}
	/**
	 * @param grade3comments the grade3comments to set
	 */
	public void setGrade3comments(String grade3comments) {
		this.grade3comments = grade3comments;
	}
	/**
	 * @return the grade4comments
	 */
	public String getGrade4comments() {
		return grade4comments;
	}
	/**
	 * @param grade4comments the grade4comments to set
	 */
	public void setGrade4comments(String grade4comments) {
		this.grade4comments = grade4comments;
	}
	/**
	 * @return the grade5comments
	 */
	public String getGrade5comments() {
		return grade5comments;
	}
	/**
	 * @param grade5comments the grade5comments to set
	 */
	public void setGrade5comments(String grade5comments) {
		this.grade5comments = grade5comments;
	}
	/**
	 * @return the rejectsId
	 */
	public String getRejectsId() {
		return RejectsId;
	}
	/**
	 * @param rejectsId the rejectsId to set
	 */
	public void setRejectsId(String rejectsId) {
		RejectsId = rejectsId;
	}
	/**
	 * @return the sidespassed
	 */
	public String getSidespassed() {
		return sidespassed;
	}
	/**
	 * @param sidespassed the sidespassed to set
	 */
	public void setSidespassed(String sidespassed) {
		this.sidespassed = sidespassed;
	}
	/**
	 * @return the hidespassed
	 */
	public String getHidespassed() {
		return hidespassed;
	}
	/**
	 * @param hidespassed the hidespassed to set
	 */
	public void setHidespassed(String hidespassed) {
		this.hidespassed = hidespassed;
	}
	/**
	 * @return the totalpassed
	 */
	public String getTotalpassed() {
		return totalpassed;
	}
	/**
	 * @param totalpassed the totalpassed to set
	 */
	public void setTotalpassed(String totalpassed) {
		this.totalpassed = totalpassed;
	}
	/**
	 * @return the substancerejectssides
	 */
	public String getSubstancerejectssides() {
		return substancerejectssides;
	}
	/**
	 * @param substancerejectssides the substancerejectssides to set
	 */
	public void setSubstancerejectssides(String substancerejectssides) {
		this.substancerejectssides = substancerejectssides;
	}
	/**
	 * @return the substancerejectshides
	 */
	public String getSubstancerejectshides() {
		return substancerejectshides;
	}
	/**
	 * @param substancerejectshides the substancerejectshides to set
	 */
	public void setSubstancerejectshides(String substancerejectshides) {
		this.substancerejectshides = substancerejectshides;
	}
	/**
	 * @return the substancerejects
	 */
	public String getSubstancerejects() {
		return substancerejects;
	}
	/**
	 * @param substancerejects the substancerejects to set
	 */
	public void setSubstancerejects(String substancerejects) {
		this.substancerejects = substancerejects;
	}
	/**
	 * @return the sizerejectssides
	 */
	public String getSizerejectssides() {
		return sizerejectssides;
	}
	/**
	 * @param sizerejectssides the sizerejectssides to set
	 */
	public void setSizerejectssides(String sizerejectssides) {
		this.sizerejectssides = sizerejectssides;
	}
	/**
	 * @return the sizerejectshides
	 */
	public String getSizerejectshides() {
		return sizerejectshides;
	}
	/**
	 * @param sizerejectshides the sizerejectshides to set
	 */
	public void setSizerejectshides(String sizerejectshides) {
		this.sizerejectshides = sizerejectshides;
	}
	/**
	 * @return the sizerejects
	 */
	public String getSizerejects() {
		return sizerejects;
	}
	/**
	 * @param sizerejects the sizerejects to set
	 */
	public void setSizerejects(String sizerejects) {
		this.sizerejects = sizerejects;
	}
	/**
	 * @return the selectionrejectssides
	 */
	public String getSelectionrejectssides() {
		return selectionrejectssides;
	}
	/**
	 * @param selectionrejectssides the selectionrejectssides to set
	 */
	public void setSelectionrejectssides(String selectionrejectssides) {
		this.selectionrejectssides = selectionrejectssides;
	}
	/**
	 * @return the selectionrejectshides
	 */
	public String getSelectionrejectshides() {
		return selectionrejectshides;
	}
	/**
	 * @param selectionrejectshides the selectionrejectshides to set
	 */
	public void setSelectionrejectshides(String selectionrejectshides) {
		this.selectionrejectshides = selectionrejectshides;
	}
	/**
	 * @return the selectionrejects
	 */
	public String getSelectionrejects() {
		return selectionrejects;
	}
	/**
	 * @param selectionrejects the selectionrejects to set
	 */
	public void setSelectionrejects(String selectionrejects) {
		this.selectionrejects = selectionrejects;
	}
	/**
	 * @return the colorrejectssides
	 */
	public String getColorrejectssides() {
		return colorrejectssides;
	}
	/**
	 * @param colorrejectssides the colorrejectssides to set
	 */
	public void setColorrejectssides(String colorrejectssides) {
		this.colorrejectssides = colorrejectssides;
	}
	/**
	 * @return the colorrejectshides
	 */
	public String getColorrejectshides() {
		return colorrejectshides;
	}
	/**
	 * @param colorrejectshides the colorrejectshides to set
	 */
	public void setColorrejectshides(String colorrejectshides) {
		this.colorrejectshides = colorrejectshides;
	}
	/**
	 * @return the colorrejects
	 */
	public String getColorrejects() {
		return colorrejects;
	}
	/**
	 * @param colorrejects the colorrejects to set
	 */
	public void setColorrejects(String colorrejects) {
		this.colorrejects = colorrejects;
	}
	/**
	 * @return the orgrejectssides
	 */
	public String getOrgrejectssides() {
		return orgrejectssides;
	}
	/**
	 * @param orgrejectssides the orgrejectssides to set
	 */
	public void setOrgrejectssides(String orgrejectssides) {
		this.orgrejectssides = orgrejectssides;
	}
	/**
	 * @return the orgrejectshides
	 */
	public String getOrgrejectshides() {
		return orgrejectshides;
	}
	/**
	 * @param orgrejectshides the orgrejectshides to set
	 */
	public void setOrgrejectshides(String orgrejectshides) {
		this.orgrejectshides = orgrejectshides;
	}
	/**
	 * @return the orgrejects
	 */
	public String getOrgrejects() {
		return orgrejects;
	}
	/**
	 * @param orgrejects the orgrejects to set
	 */
	public void setOrgrejects(String orgrejects) {
		this.orgrejects = orgrejects;
	}
	/**
	 * @return the otherrejectssides
	 */
	public String getOtherrejectssides() {
		return otherrejectssides;
	}
	/**
	 * @param otherrejectssides the otherrejectssides to set
	 */
	public void setOtherrejectssides(String otherrejectssides) {
		this.otherrejectssides = otherrejectssides;
	}
	/**
	 * @return the otherrejectshides
	 */
	public String getOtherrejectshides() {
		return otherrejectshides;
	}
	/**
	 * @param otherrejectshides the otherrejectshides to set
	 */
	public void setOtherrejectshides(String otherrejectshides) {
		this.otherrejectshides = otherrejectshides;
	}
	/**
	 * @return the otherrejects
	 */
	public String getOtherrejects() {
		return otherrejects;
	}
	/**
	 * @param otherrejects the otherrejects to set
	 */
	public void setOtherrejects(String otherrejects) {
		this.otherrejects = otherrejects;
	}
	/**
	 * @return the totalrejectssides
	 */
	public String getTotalrejectssides() {
		return totalrejectssides;
	}
	/**
	 * @param totalrejectssides the totalrejectssides to set
	 */
	public void setTotalrejectssides(String totalrejectssides) {
		this.totalrejectssides = totalrejectssides;
	}
	/**
	 * @return the totalrejectshides
	 */
	public String getTotalrejectshides() {
		return totalrejectshides;
	}
	/**
	 * @param totalrejectshides the totalrejectshides to set
	 */
	public void setTotalrejectshides(String totalrejectshides) {
		this.totalrejectshides = totalrejectshides;
	}
	/**
	 * @return the totalrejects
	 */
	public String getTotalrejects() {
		return totalrejects;
	}
	/**
	 * @param totalrejects the totalrejects to set
	 */
	public void setTotalrejects(String totalrejects) {
		this.totalrejects = totalrejects;
	}
	/**
	 * @return the testId
	 */
	public String getTestId() {
		return TestId;
	}
	/**
	 * @param testId the testId to set
	 */
	public void setTestId(String testId) {
		TestId = testId;
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
	 * @return the colortest
	 */
	public String getColortest() {
		return colortest;
	}
	/**
	 * @param colortest the colortest to set
	 */
	public void setColortest(String colortest) {
		this.colortest = colortest;
	}
	/**
	 * @return the substancetest
	 */
	public String getSubstancetest() {
		return substancetest;
	}
	/**
	 * @param substancetest the substancetest to set
	 */
	public void setSubstancetest(String substancetest) {
		this.substancetest = substancetest;
	}
	/**
	 * @return the tearstrenghttest
	 */
	public String getTearstrenghttest() {
		return tearstrenghttest;
	}
	/**
	 * @param tearstrenghttest the tearstrenghttest to set
	 */
	public void setTearstrenghttest(String tearstrenghttest) {
		this.tearstrenghttest = tearstrenghttest;
	}
	/**
	 * @return the grainbreaktest
	 */
	public String getGrainbreaktest() {
		return grainbreaktest;
	}
	/**
	 * @param grainbreaktest the grainbreaktest to set
	 */
	public void setGrainbreaktest(String grainbreaktest) {
		this.grainbreaktest = grainbreaktest;
	}
	/**
	 * @return the crockingdrytest
	 */
	public String getCrockingdrytest() {
		return crockingdrytest;
	}
	/**
	 * @param crockingdrytest the crockingdrytest to set
	 */
	public void setCrockingdrytest(String crockingdrytest) {
		this.crockingdrytest = crockingdrytest;
	}
	/**
	 * @return the crockingwettest
	 */
	public String getCrockingwettest() {
		return crockingwettest;
	}
	/**
	 * @param crockingwettest the crockingwettest to set
	 */
	public void setCrockingwettest(String crockingwettest) {
		this.crockingwettest = crockingwettest;
	}
	/**
	 * @return the finishadhensiontest
	 */
	public String getFinishadhensiontest() {
		return finishadhensiontest;
	}
	/**
	 * @param finishadhensiontest the finishadhensiontest to set
	 */
	public void setFinishadhensiontest(String finishadhensiontest) {
		this.finishadhensiontest = finishadhensiontest;
	}
	/**
	 * @return the fourfoldtest
	 */
	public String getFourfoldtest() {
		return fourfoldtest;
	}
	/**
	 * @param fourfoldtest the fourfoldtest to set
	 */
	public void setFourfoldtest(String fourfoldtest) {
		this.fourfoldtest = fourfoldtest;
	}
	/**
	 * @return the crosssectiontest
	 */
	public String getCrosssectiontest() {
		return crosssectiontest;
	}
	/**
	 * @param crosssectiontest the crosssectiontest to set
	 */
	public void setCrosssectiontest(String crosssectiontest) {
		this.crosssectiontest = crosssectiontest;
	}
	/**
	 * @return the organoleptictest
	 */
	public String getOrganoleptictest() {
		return organoleptictest;
	}
	/**
	 * @param organoleptictest the organoleptictest to set
	 */
	public void setOrganoleptictest(String organoleptictest) {
		this.organoleptictest = organoleptictest;
	}
	/**
	 * @return the testedpcs
	 */
	public String[] getTestedpcs() {
		return testedpcs;
	}
	/**
	 * @param testedpcs the testedpcs to set
	 */
	public void setTestedpcs(String[] testedpcs) {
		this.testedpcs = testedpcs;
	}
	/**
	 * @return the testcomments
	 */
	public String[] getTestcomments() {
		return testcomments;
	}
	/**
	 * @param testcomments the testcomments to set
	 */
	public void setTestcomments(String[] testcomments) {
		this.testcomments = testcomments;
	}
	/**
	 * @return the inpsContractNumber
	 */
	public String getInpsContractNumber() {
		return InpsContractNumber;
	}
	/**
	 * @param inpsContractNumber the inpsContractNumber to set
	 */
	public void setInpsContractNumber(String inpsContractNumber) {
		InpsContractNumber = inpsContractNumber;
	}
	
	/**
	 * @return the inspdate
	 */
	public String getInspdate() {
		return inspdate;
	}
	/**
	 * @param inspdate the inspdate to set
	 */
	public void setInspdate(String inspdate) {
		this.inspdate = inspdate;
	}
	/**
	 * @return the inspqualityctrlr
	 */
	public String getInspqualityctrlr() {
		return inspqualityctrlr;
	}
	/**
	 * @param inspqualityctrlr the inspqualityctrlr to set
	 */
	public void setInspqualityctrlr(String inspqualityctrlr) {
		this.inspqualityctrlr = inspqualityctrlr;
	}
	
	
}
