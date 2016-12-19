package com.f9g4.web.forms;

import java.util.Arrays;



public class RegistrationForm {
	
	private String userType;

	private String userName;

	private String password;
	
	private String confirmPassword;
	
	private int securityQ1; 
	
	private String securityQ1Value;
	
	private int securityQ2; 
	
	private String securityQ2Value;
	
	private String firstName;
	
	private String lastName;
	
	private String street1;
	
	private String street2;
	
	private String city;
	
	private int state;
	
	private String zip;
	
	private int country;
	
	private String cell;
	
	private String workPhone;
	
	private String ext;
	
	private int langs[];
	
	private String aboutYou;

	private String companyName;
	
	private String website;
	
	private String workPhone1;
	
	private String ext1;
	
	private int skills[];

	private String schools;
	
	private String fax;
	
	private boolean termsAccepted;	
	
	private int acceptedTermsId;
	
	private String logoImageUrl;
	
	private Boolean isTempPassword;
	
	private Integer[] education;
	private String[] otherEducation;
	private Integer[] specialty;
	private String[] otherSpecialty;
	
	//private int education;
	
	//private String otherEducation;
	
	//private int specialty;
	
	//private String otherSpecialty;
	
	/*private int expertise;
	
	private int degAcc;
	
	private int yrsExpl;*/
	
	private String howDidYouHearAboutUs;
	
	/*public int getExpertise() {
		return expertise;
	}
	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}
	public int getDegAcc() {
		return degAcc;
	}
	public void setDegAcc(int degAcc) {
		this.degAcc = degAcc;
	}
	public int getYrsExpl() {
		return yrsExpl;
	}
	public void setYrsExpl(int yrsExpl) {
		this.yrsExpl = yrsExpl;
	}*/
	
	
	public String getHowDidYouHearAboutUs() {
		return howDidYouHearAboutUs;
	}
	public Integer[] getEducation() {
		return education;
	}
	public void setEducation(Integer[] education) {
		this.education = education;
	}
	public String[] getOtherEducation() {
		return otherEducation;
	}
	public void setOtherEducation(String[] otherEducation) {
		this.otherEducation = otherEducation;
	}
	public Integer[] getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Integer[] specialty) {
		this.specialty = specialty;
	}
	public String[] getOtherSpecialty() {
		return otherSpecialty;
	}
	public void setOtherSpecialty(String[] otherSpecialty) {
		this.otherSpecialty = otherSpecialty;
	}
	public void setHowDidYouHearAboutUs(String howDidYouHearAboutUs) {
		this.howDidYouHearAboutUs = howDidYouHearAboutUs;
	}
	public Boolean getIsTempPassword() {
		if(isTempPassword==null)
			isTempPassword=false;
		return isTempPassword;
	}
	public void setIsTempPassword(Boolean isTempPassword) {
		this.isTempPassword = isTempPassword;
	}
	public String getLogoImageUrl() {
		return logoImageUrl;
	}
	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getSecurityQ1() {
		return securityQ1;
	}
	public void setSecurityQ1(int securityQ1) {
		this.securityQ1 = securityQ1;
	}
	public String getSecurityQ1Value() {
		return securityQ1Value;
	}
	public void setSecurityQ1Value(String securityQ1Value) {
		this.securityQ1Value = securityQ1Value;
	}
	public int getSecurityQ2() {
		return securityQ2;
	}
	public void setSecurityQ2(int securityQ2) {
		this.securityQ2 = securityQ2;
	}
	public String getSecurityQ2Value() {
		return securityQ2Value;
	}
	public void setSecurityQ2Value(String securityQ2Value) {
		this.securityQ2Value = securityQ2Value;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public int[] getLangs() {
		return langs;
	}
	public void setLangs(int[] langs) {
		this.langs = langs;
	}
	public String getAboutYou() {
		return aboutYou;
	}
	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getWorkPhone1() {
		return workPhone1;
	}
	public void setWorkPhone1(String workPhone1) {
		this.workPhone1 = workPhone1;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public int[] getSkills() {
		return skills;
	}
	public void setSkills(int[] skills) {
		this.skills = skills;
	}
	public String getSchools() {
		return schools;
	}
	public void setSchools(String schools) {
		this.schools = schools;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public boolean isTermsAccepted() {
		return termsAccepted;
	}
	public void setTermsAccepted(boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}

	public int getAcceptedTermsId() {
		return acceptedTermsId;
	}
	public void setAcceptedTermsId(int acceptedTermsId) {
		this.acceptedTermsId = acceptedTermsId;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "RegistrationForm [userType=" + userType + ", userName="
				+ userName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", securityQ1=" + securityQ1
				+ ", securityQ1Value=" + securityQ1Value + ", securityQ2="
				+ securityQ2 + ", securityQ2Value=" + securityQ2Value
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", street1=" + street1 + ", street2=" + street2 + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", country="
				+ country + ", cell=" + cell + ", workPhone=" + workPhone
				+ ", ext=" + ext + ", langs=" + Arrays.toString(langs)
				+ ", aboutYou=" + aboutYou + ", companyName=" + companyName
				+ ", website=" + website + ", workPhone1=" + workPhone1
				+ ", ext1=" + ext1 + ", skills=" + Arrays.toString(skills)
				+ ", schools=" + schools + ", fax=" + fax + ", termsAccepted="
				+ termsAccepted + ", acceptedTermsId=" + acceptedTermsId
				+ ", logoImageUrl=" + logoImageUrl + ", isTempPassword="
				+ isTempPassword + ", educationId="
				+ Arrays.toString(education) + ", otherEducation="
				+ Arrays.toString(otherEducation) + ", specialtyId="
				+ Arrays.toString(specialty) + ", otherSpecialty="
				+ Arrays.toString(otherSpecialty) + ", howDidYouHearAboutUs="
				+ howDidYouHearAboutUs + "]";
	}
}