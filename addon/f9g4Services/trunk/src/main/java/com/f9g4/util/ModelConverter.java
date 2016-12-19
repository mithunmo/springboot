package com.f9g4.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.f9g4.businessobjects.domain.AdAccepttermsDomain;
import com.f9g4.businessobjects.domain.AdAddressDomain;
import com.f9g4.businessobjects.domain.AdContactsDomain;
import com.f9g4.businessobjects.domain.AdEmailTemplatesDomain;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUserDegaccsDomain;
import com.f9g4.businessobjects.domain.AdUserDocumentsDomain;
import com.f9g4.businessobjects.domain.AdUserEducationsDomain;
import com.f9g4.businessobjects.domain.AdUserExpertisesDomain;
import com.f9g4.businessobjects.domain.AdUserLanguagesDomain;
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.AdUserSkillsDomain;
import com.f9g4.businessobjects.domain.AdUserSpecialitiesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.domain.StMemPricingOptionsDomain;
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.StTermConditionDomain;
import com.f9g4.businessobjects.domain.TrBoardApprovalDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrBoardSearchDomain;
import com.f9g4.businessobjects.domain.TrBroadcastMessagesDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrPortfolioImagesDomain;
import com.f9g4.businessobjects.services.ObjectFactory;
import com.f9g4.businessobjects.services.UserInfoDomain;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.LanguageCodesEnum;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.domain.AdAcceptTerms;
import com.f9g4.domain.AdAddresses;
import com.f9g4.domain.AdContacts;
import com.f9g4.domain.AdEmailTemplates;
import com.f9g4.domain.AdLookupTypes;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUserDegaccs;
import com.f9g4.domain.AdUserDocuments;
import com.f9g4.domain.AdUserEducations;
import com.f9g4.domain.AdUserExpertises;
import com.f9g4.domain.AdUserLanguages;
import com.f9g4.domain.AdUserMemberships;
import com.f9g4.domain.AdUserSkills;
import com.f9g4.domain.AdUserSpecialities;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.StCategoryMaster;
import com.f9g4.domain.StMemPricingOptions;
import com.f9g4.domain.StSeasonYear;
import com.f9g4.domain.StTermsConditions;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrBoardApproval;
import com.f9g4.domain.TrBoardImages;
import com.f9g4.domain.TrBoardSearch;
import com.f9g4.domain.TrBroadcastMessages;
import com.f9g4.domain.TrMessages;
import com.f9g4.domain.TrPortfolio;
import com.f9g4.domain.TrPortfolioImages;

@Component
public class ModelConverter {

	public static ObjectFactory svcObjFactory = new ObjectFactory();
	public static com.f9g4.businessobjects.domain.ObjectFactory domainObjFactory = new com.f9g4.businessobjects.domain.ObjectFactory();
	
	
	public void convertAdUsersEntityToDomain(AdUsers adUsers, AdUsersDomain adUsersDomain) throws DatatypeConfigurationException {
	
		//Mapping the properties..
		adUsersDomain.setAboutYou(adUsers.getAboutYou());
		adUsersDomain.setActiveStatus(adUsers.getActiveStatus());
		adUsersDomain.setCompanyname(adUsers.getCompanyName());
		adUsersDomain.setCompanywebsite(adUsers.getCompanyWebsite());
		adUsersDomain.setFirstname(adUsers.getFirstname());
		adUsersDomain.setProfilename(adUsers.getProfilename());
		adUsersDomain.setUseProfilename(adUsers.getUseProfilename());
		adUsersDomain.setLangCode(adUsers.getLangCode());
		adUsersDomain.setLastname(adUsers.getLastname());
		adUsersDomain.setLogoimageurl(adUsers.getLogoImageUrl());
		adUsersDomain.setOverallRating((null != adUsers.getOverallRating()? adUsers.getOverallRating().floatValue() : 0.0f));
		adUsersDomain.setPassword(adUsers.getPassword());
		AdLookupValuesDomain regStatus=new AdLookupValuesDomain();
		this.convertAdLookupValuesEntityToDomain(adUsers.getAdLookupValuesByRegStatusId(), regStatus);
		adUsersDomain.setRegisterStatus(regStatus);
		adUsersDomain.setRegisterStatusId(adUsers.getAdLookupValuesByRegStatusId().getLookupValueId());
		adUsersDomain.setRegisterStatusCode(adUsers.getAdLookupValuesByRegStatusId().getLookupCode());
		adUsersDomain.setSchoolawards(adUsers.getSchoolAwards());
		if(adUsers.getSecurityAnswer1()!=null)
			adUsersDomain.setSecurityAnswer1(adUsers.getSecurityAnswer1());
		if(adUsers.getSecurityAnswer2()!=null)
			adUsersDomain.setSecurityAnswer2(adUsers.getSecurityAnswer2());
		adUsersDomain.setSecurityAnswer3(adUsers.getSecurityAnswer3());
		if(adUsers.getAdLookupValuesBySecurityQuestion1Id()!=null)
			adUsersDomain.setSecurityQuestion1(adUsers.getAdLookupValuesBySecurityQuestion1Id().getLookupValueId());
		if(adUsers.getAdLookupValuesBySecurityQuestion2Id()!=null)
			adUsersDomain.setSecurityQuestion2(adUsers.getAdLookupValuesBySecurityQuestion2Id().getLookupValueId());
		//adUsersDomain.setSecurityquestion3(adUsers.getAdLookupValuesBySecurityQuestion3Id().getLookupValueId());
		adUsersDomain.setUserType(adUsers.getAdLookupValuesByUserTypeId().getLookupCode());
		adUsersDomain.setTaxid(adUsers.getTaxId());
		adUsersDomain.setUserId(adUsers.getUserId());
		adUsersDomain.setUserName(adUsers.getUserName());
		adUsersDomain.setIsTempPassword(adUsers.getTempPassword());
		if(adUsers.getAdminRating()!=null)
			adUsersDomain.setAdminRating(adUsers.getAdminRating().floatValue());
		adUsersDomain.setHowDidYouHearAboutUs(adUsers.getHowDidYouHearAboutUs());
		
		//New columns
		//KAmlesh :: We Dont need this
//		adUsersDomain.setHowDidYouHearAboutUs(adUsers.getHowDidYouHearAboutUs());
//		if(adUsers.getEducationId()!=null)
//		{
//			adUsersDomain.setEducation(new AdLookupValuesDomain());
//			convertSingleAdLookupValuesEntityToDomain(adUsers.getEducationId(), adUsersDomain.getEducation());
//		}
//		if(adUsers.getSpecialtyId()!=null)
//		{
//			adUsersDomain.setSpecialty(new AdLookupValuesDomain());
//			convertSingleAdLookupValuesEntityToDomain(adUsers.getSpecialtyId(), adUsersDomain.getSpecialty());
//		}
//		if(adUsers.getExpertiseId()!=null)
//		{
//			adUsersDomain.setExpertise(new AdLookupValuesDomain());
//			convertSingleAdLookupValuesEntityToDomain(adUsers.getExpertiseId(), adUsersDomain.getExpertise());
//		}
//		if(adUsers.getDegAccId()!=null)
//		{
//			adUsersDomain.setDegAcc(new AdLookupValuesDomain());
//			convertSingleAdLookupValuesEntityToDomain(adUsers.getDegAccId(), adUsersDomain.getDegAcc());
//		}
		if(adUsers.getYrsExpId()!=null)
		{
			adUsersDomain.setYrsExp(new AdLookupValuesDomain());
			convertSingleAdLookupValuesEntityToDomain(adUsers.getYrsExpId(), adUsersDomain.getYrsExp());
		}
		adUsersDomain.setCompaniesWorked(adUsers.getCompaniesWorked());
		adUsersDomain.setApproverComments(adUsers.getApproverComments());
		
//		adUsersDomain.getAcceptedTermsCondition(); - done
//		adUsersDomain.getActiveUser(); -- not for registration service
//		adUsersDomain.getAddress(); -- done
//		adUsersDomain.getBoards();  -- not for registration service
//		adUsersDomain.getContacts(); -- done
//		adUsersDomain.getMessages();-- not for registration service
//		adUsersDomain.getPaymentAuthSubmit();-- not for registration service
//		adUsersDomain.getPortfolio();-- not for registration service
//		adUsersDomain.getRecentlyViewed();-- not for registration service
//		adUsersDomain.getRatings();-- not for registration service
//		adUsersDomain.getReferrals();-- not for registration service
//		adUsersDomain.getSalesTransactionDetails();-- not for registration service
//		adUsersDomain.getUserLangs(); -- done
//		adUsersDomain.getUserMembership();-- not for registration service
//		adUsersDomain.getUseSkills(); -- done
	}

	public void convertAdUsersEntityAssociationsToDomain(AdUsers adUsers, AdUsersDomain adUsersDomain) throws DatatypeConfigurationException {
		
		//Map associations...
		List<AdAccepttermsDomain> adAccepttermsDomainsList = adUsersDomain.getAcceptedTermsCondition();
		this.convertAdAcceptTermsEntityToDomain(adUsers.getAdAcceptTermses(), adAccepttermsDomainsList);
			
		List<AdAddressDomain> adAddressDomainList = adUsersDomain.getAddress();
		convertAdAddressEntityToDomain(adUsers.getAdAddresseses(), adAddressDomainList);

		List<AdContactsDomain> adContactsDomainList = adUsersDomain.getContacts();
		this.convertAdContactsEntityToDomain(adUsers.getAdContactses(), adContactsDomainList);
		
		List<AdUserLanguagesDomain> adUserLanguagesDomainList = adUsersDomain.getUserLangs();
		this.convertAdUserLanguagesEntityToDomain(adUsers.getAdUserLanguageses(), adUserLanguagesDomainList);
		
		//TODO - rename UseSkills element to UserSkills in shcema..
		List<AdUserSkillsDomain> adUserSkillsDomainList =  adUsersDomain.getUseSkills();
		this.convertAdUserSkillsEntityToDomain(adUsers.getAdUserSkillses(), adUserSkillsDomainList);
		
		//Kamlesh - Added multiselect for education, expetise , speciality and DEgaccs.
		//**********************************************************************************************
		
		List<AdUserEducationsDomain> adUserEDucationsDomainList =  adUsersDomain.getEducation();
		this.convertAdUserEducationsEntityToDomain(adUsers.getAdUserEducations(), adUserEDucationsDomainList);
		
		List<AdUserExpertisesDomain> adUserExpertisessDomainList =  adUsersDomain.getExpertise();
		this.convertAdUserExpertisesEntityToDomain(adUsers.getAdUserExpertises(), adUserExpertisessDomainList);
		
		List<AdUserSpecialitiesDomain> adUserSpecialitiessDomainList =  adUsersDomain.getSpecialty();
		this.convertAdUserSpecialitiesEntityToDomain(adUsers.getAdUserSpecialities(), adUserSpecialitiessDomainList);
		
		List<AdUserDegaccsDomain> adUserDegaccsDomainList =  adUsersDomain.getDegAcc();
		this.convertAdUserDegaccsEntityToDomain(adUsers.getAdUserDegaccs(), adUserDegaccsDomainList);
		
		//***********************************************************************************************
		
		List<AdUserMembershipDomain> adUserMembershipDomainList =  adUsersDomain.getUserMembership();
		this.convertAdUserMembershipsEntityToDomain(adUsers.getAdUserMembershipset(), adUserMembershipDomainList);
		
		List<AdUserDocumentsDomain> adUserDocumentsDomainList = adUsersDomain.getUserDocuments();
		adUserDocumentsDomainList.addAll(this.convertAdUserDocumentsEntityToDomain(adUsers.getAdUserDocuments()));
	}
	

	public void convertAdAddressEntityToDomain(Set<AdAddresses> adAddressesSet, List <AdAddressDomain> adAddressDomainList){

		for (AdAddresses adAddressEntity : adAddressesSet) {
			AdAddressDomain adAddressDomain = ModelConverter.domainObjFactory.createAdAddressDomain();
			adAddressDomain.setActiveStatus(adAddressEntity.getActiveStatus());
			adAddressDomain.setAddressId(adAddressEntity.getAddressId());
			adAddressDomain.setAddressLine1(adAddressEntity.getAddressLine1());
			if(!StringUtils.isEmpty(adAddressEntity.getAddressLine2())){
				adAddressDomain.setAddressLine2(adAddressEntity.getAddressLine2());
			}
			adAddressDomain.setCity(adAddressEntity.getCity());
			//
			if(!StringUtils.isEmpty(adAddressEntity.getCounty())){
				adAddressDomain.setCounty(adAddressEntity.getCounty());	
			}
			if(adAddressEntity.getAdLookupValues()!=null){
				adAddressDomain.setCountryId(adAddressEntity.getAdLookupValues().getLookupValueId());
				adAddressDomain.setCountryName(adAddressEntity.getAdLookupValues().getDescription());
			}
			adAddressDomain.setLangCode(adAddressEntity.getLangCode());
			if(!StringUtils.isEmpty(adAddressEntity.getPostalCode())){
				adAddressDomain.setPostalcode(adAddressEntity.getPostalCode());
			}
			if(!StringUtils.isEmpty(adAddressEntity.getState())){
				adAddressDomain.setState(adAddressEntity.getState());
			}
			adAddressDomain.setUserId(adAddressEntity.getAdUsers().getUserId());
			adAddressDomainList.add(adAddressDomain);
		}
	}
		
	public void convertAdAddressDomainToEntity(AdAddressDomain adAddressDomain, AdAddresses adAddressesEntity,  AdLookupValues countryLookupValue, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adAddressesEntity.setCreatedBy(adAddressDomain.getCreatedby());
			adAddressesEntity.setCreationDate(today);
		}
		
		adAddressesEntity.setActiveStatus(adAddressDomain.getActiveStatus());
		adAddressesEntity.setAddressLine1(adAddressDomain.getAddressLine1());
		adAddressesEntity.setAddressLine2(adAddressDomain.getAddressLine2());
		//Country
		adAddressesEntity.setAdLookupValues(countryLookupValue);
		adAddressesEntity.setAdUsers(userEntity);
		adAddressesEntity.setCity(adAddressDomain.getCity());
		adAddressesEntity.setCounty(adAddressDomain.getCounty());
		adAddressesEntity.setLangCode(adAddressDomain.getLangCode());
		adAddressesEntity.setPostalCode(adAddressDomain.getPostalcode());
		adAddressesEntity.setState(adAddressDomain.getState());
		
		adAddressesEntity.setLastUpdateDate(today);
		adAddressesEntity.setLastUpdatedBy(adAddressDomain.getLastupdateby());	
	}

	/*

	 */
	public void convertAdAcceptTermsEntityToDomain(Set<AdAcceptTerms> adAcceptTermsSet, List <AdAccepttermsDomain> adAccepttermsDomainsList) throws DatatypeConfigurationException{
		for (AdAcceptTerms adAcceptTerm : adAcceptTermsSet) {
			AdAccepttermsDomain adAccepttermsDomain = ModelConverter.domainObjFactory.createAdAccepttermsDomain();
			adAccepttermsDomain.setAcceptanceDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(adAcceptTerm.getAcceptanceDate()));
			adAccepttermsDomain.setAcceptTermId(adAcceptTerm.getAcceptTermId());
			adAccepttermsDomain.setTermConditionId(adAcceptTerm.getStTermsConditions().getTermCondId());
			adAccepttermsDomain.setUserId(adAcceptTerm.getAdUsers().getUserId());
			adAccepttermsDomainsList.add(adAccepttermsDomain);
		}
	}
	

	public void convertAdAcceptTermsDomainToEntity(AdAccepttermsDomain adAccepttermsDomain, AdAcceptTerms adAcceptTerms, StTermsConditions stTermsConditions, AdUsers userEntity, int byId, boolean isForUpdate){
		
		adAcceptTerms.setAcceptanceDate(adAccepttermsDomain.getAcceptanceDate().toGregorianCalendar());
		adAcceptTerms.setAdUsers(userEntity);
		if(isForUpdate){
			adAcceptTerms.setLastUpdatedBy(byId);
			adAcceptTerms.setLastUpdateDate(Calendar.getInstance());				
		}else{
			adAcceptTerms.setCreatedBy(byId);
			adAcceptTerms.setCreationDate(Calendar.getInstance());			
			adAcceptTerms.setLastUpdatedBy(byId);
			adAcceptTerms.setLastUpdateDate(Calendar.getInstance());
		}
		adAcceptTerms.setStTermsConditions(stTermsConditions);
	}
	
	
	public void convertAdContactsEntityToDomain(Set<AdContacts> adContactSet, List <AdContactsDomain> adContactsDomainList){
		for (AdContacts adContact : adContactSet) {
			AdContactsDomain adContactsDomain = new AdContactsDomain();
			adContactsDomain.setCellphone(adContact.getCellphone());
			adContactsDomain.setContactId(adContact.getContactId());
			adContactsDomain.setFax(adContact.getFax());
			adContactsDomain.setLangCode(adContact.getLangCode());
			adContactsDomain.setUserId(adContact.getAdUsers().getUserId());
			adContactsDomain.setWorkext(adContact.getWorkExtn());
			adContactsDomain.setWorkphone(adContact.getWorkPhone());
			adContactsDomainList.add(adContactsDomain);
		}
	}
	
	public void convertAdContactsDomainToEntity(AdContactsDomain adContactsDomain, AdContacts adContact,   AdUsers userEntity, boolean isForUpdate){
		adContact.setAdUsers(userEntity);
		adContact.setCellphone(adContactsDomain.getCellphone());		
		adContact.setFax(adContactsDomain.getFax());
		adContact.setLangCode(adContactsDomain.getLangCode());
		adContact.setWorkExtn(adContactsDomain.getWorkext());
		adContact.setWorkPhone(adContactsDomain.getWorkphone());
		if(!isForUpdate){
			adContact.setCreatedBy(adContactsDomain.getCreatedby());
			adContact.setCreationDate(Calendar.getInstance());
		}
		adContact.setLastUpdateBy(adContactsDomain.getLastupdateby());
		adContact.setLastUpdatedDate(Calendar.getInstance());

	}

	
	public void convertAdUserLanguagesEntityToDomain(Set<AdUserLanguages> adUserLanguagesSet, List<AdUserLanguagesDomain> adUserLanguagesDomainList){
		for (AdUserLanguages adUserLanguages : adUserLanguagesSet) {
			if(ActiveStatusEnum.ACTIVE.value() == adUserLanguages.getActiveStatus()){
				AdUserLanguagesDomain adUserLanguagesDomain = new AdUserLanguagesDomain();
				adUserLanguagesDomain.setActiveStatus(adUserLanguages.getActiveStatus());
				adUserLanguagesDomain.setLangId(adUserLanguages.getAdLookupValues().getLookupValueId());
				adUserLanguagesDomain.setLangName(adUserLanguages.getAdLookupValues().getDescription());
				adUserLanguagesDomain.setUserId(adUserLanguages.getAdUsers().getUserId());
				adUserLanguagesDomain.setUserLangId(adUserLanguages.getUserLangId());
				adUserLanguagesDomainList.add(adUserLanguagesDomain);				
			}
		}
	}
	

	public void convertAdUserLanguagesDomainToEntity(AdUserLanguagesDomain adUserLanguagesDomain, AdUserLanguages adUserLanguagesEnity, AdLookupValues adLookupValuesLang, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adUserLanguagesEnity.setCreatedBy(adUserLanguagesDomain.getCreatedby());
			adUserLanguagesEnity.setCreationDate(today);			
		}
		adUserLanguagesEnity.setActiveStatus(adUserLanguagesDomain.getActiveStatus());
		adUserLanguagesEnity.setAdLookupValues(adLookupValuesLang);
		adUserLanguagesEnity.setAdUsers(userEntity);
		adUserLanguagesEnity.setLastUpdateDate(today);
		adUserLanguagesEnity.setLastUpdatedBy(adUserLanguagesDomain.getLastupdateby());
	}
	
	public void convertAdUserSkillsEntityToDomain(Set<AdUserSkills> adUserSkillsSet, List <AdUserSkillsDomain> adUserSkillsDomainsList){
		for (AdUserSkills adUserSkills : adUserSkillsSet) {
			if(ActiveStatusEnum.ACTIVE.value() == adUserSkills.getActiveStatus()){
				//map only active 
				AdUserSkillsDomain adUserSkillsDomain = new AdUserSkillsDomain();
				adUserSkillsDomain.setActiveStatus(adUserSkills.getActiveStatus());
				adUserSkillsDomain.setSkillId(adUserSkills.getAdLookupValues().getLookupValueId());
				adUserSkillsDomain.setSkillName(adUserSkills.getAdLookupValues().getDescription());
				adUserSkillsDomain.setUserId(adUserSkills.getAdUsers().getUserId());
				adUserSkillsDomain.setUserSkillId(adUserSkills.getUserSkillId());
				adUserSkillsDomainsList.add(adUserSkillsDomain);				
			}
		}
	}
	
	public void convertAdUserEducationsEntityToDomain(Set<AdUserEducations> adUserEducationsSet, List <AdUserEducationsDomain> adUserEducationsDomainsList){
		for (AdUserEducations adUserEducations : adUserEducationsSet) {
			if(ActiveStatusEnum.ACTIVE.value() == adUserEducations.getActiveStatus() || ActiveStatusEnum.OTHERS.value() == adUserEducations.getActiveStatus()){
				//map only active 
				AdUserEducationsDomain adUserEducationsDomain = new AdUserEducationsDomain();
				adUserEducationsDomain.setActiveStatus(adUserEducations.getActiveStatus());
				adUserEducationsDomain.setEducationId(adUserEducations.getAdLookupValues().getLookupValueId());
				adUserEducationsDomain.setEducationName(adUserEducations.getAdLookupValues().getDescription());
				adUserEducationsDomain.setUserId(adUserEducations.getAdUsers().getUserId());
				adUserEducationsDomainsList.add(adUserEducationsDomain);				
			}
		}
	}
	
	public void convertAdUserExpertisesEntityToDomain(Set<AdUserExpertises> adUserExpertisesSet, List <AdUserExpertisesDomain> adUserExpertisesDomainsList){
		for (AdUserExpertises adUserExpertises : adUserExpertisesSet) {
			if(ActiveStatusEnum.ACTIVE.value() == adUserExpertises.getActiveStatus() || ActiveStatusEnum.OTHERS.value() == adUserExpertises.getActiveStatus()){
				//map only active 
				AdUserExpertisesDomain adUserExpertisesDomain = new AdUserExpertisesDomain();
				adUserExpertisesDomain.setActiveStatus(adUserExpertises.getActiveStatus());
				adUserExpertisesDomain.setExpertiseId(adUserExpertises.getAdLookupValues().getLookupValueId());
				adUserExpertisesDomain.setExpertiseName(adUserExpertises.getAdLookupValues().getDescription());
				adUserExpertisesDomain.setUserId(adUserExpertises.getAdUsers().getUserId());
				adUserExpertisesDomainsList.add(adUserExpertisesDomain);				
			}
		}
	}
	
	public void convertAdUserSpecialitiesEntityToDomain(Set<AdUserSpecialities> adUserSpecialitiesSet, List <AdUserSpecialitiesDomain> adUserSpecialitiesDomainsList){
		for (AdUserSpecialities adUserSpecialities : adUserSpecialitiesSet) {
			if(ActiveStatusEnum.ACTIVE.value() == adUserSpecialities.getActiveStatus() || ActiveStatusEnum.OTHERS.value() == adUserSpecialities.getActiveStatus()){
				//map only active 
				AdUserSpecialitiesDomain adUserSpecialitiesDomain = new AdUserSpecialitiesDomain();
				adUserSpecialitiesDomain.setActiveStatus(adUserSpecialities.getActiveStatus());
				adUserSpecialitiesDomain.setSpecialitiesId(adUserSpecialities.getAdLookupValues().getLookupValueId());
				adUserSpecialitiesDomain.setSpecialitiesName(adUserSpecialities.getAdLookupValues().getDescription());
				adUserSpecialitiesDomain.setUserId(adUserSpecialities.getAdUsers().getUserId());
				adUserSpecialitiesDomainsList.add(adUserSpecialitiesDomain);				
			}
		}
	}
	
	public void convertAdUserDegaccsEntityToDomain(Set<AdUserDegaccs> adUserDegaccsSet, List <AdUserDegaccsDomain> adUserDegaccsDomainsList){
		for (AdUserDegaccs adUserDegaccs : adUserDegaccsSet) {
			if(ActiveStatusEnum.ACTIVE.value() == adUserDegaccs.getActiveStatus()){
				//map only active 
				AdUserDegaccsDomain adUserDegaccsDomain = new AdUserDegaccsDomain();
				adUserDegaccsDomain.setActiveStatus(adUserDegaccs.getActiveStatus());
				adUserDegaccsDomain.setUserId(adUserDegaccs.getAdUsers().getUserId());
				adUserDegaccsDomain.setDegaccsId(adUserDegaccs.getAdLookupValues().getLookupValueId());
				adUserDegaccsDomain.setDegaccsName(adUserDegaccs.getAdLookupValues().getDescription());
				adUserDegaccsDomainsList.add(adUserDegaccsDomain);				
			}
		}
	}


	public void convertAdUserSkillsDomainToEntity(AdUserSkillsDomain adUserSkillsDomain, AdUserSkills adUserSkillsEntity, AdLookupValues adLookupValuesSkill, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adUserSkillsEntity.setCreatedBy(adUserSkillsDomain.getCreatedby());
			adUserSkillsEntity.setCreationDate(today);
		}
		adUserSkillsEntity.setActiveStatus(adUserSkillsDomain.getActiveStatus());
		adUserSkillsEntity.setAdUsers(userEntity);
		adUserSkillsEntity.setAdLookupValues(adLookupValuesSkill);
		adUserSkillsEntity.setLastUpdateDate(today);
		adUserSkillsEntity.setLastUpdatedBy(adUserSkillsDomain.getLastupdateby());
	}
	
	public void convertAdUserEducationsDomainToEntity(AdUserEducationsDomain adUserEducationsDomain, AdUserEducations adUserEducationsEntity, AdLookupValues adLookupValuesEducations, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adUserEducationsEntity.setCreatedBy(adUserEducationsDomain.getCreatedby());
			adUserEducationsEntity.setCreationDate(today);
		}
		adUserEducationsEntity.setActiveStatus(adUserEducationsDomain.getActiveStatus());
		adUserEducationsEntity.setAdUsers(userEntity);
		adUserEducationsEntity.setAdLookupValues(adLookupValuesEducations);
		adUserEducationsEntity.setLastUpdateDate(today);
		adUserEducationsEntity.setLastUpdatedBy(adUserEducationsDomain.getLastupdateby());
	}
	
	public void convertAdUserExpertisesDomainToEntity(AdUserExpertisesDomain adUserExpertisesDomain, AdUserExpertises adUserExpertisesEntity, AdLookupValues adLookupValuesExpertises, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adUserExpertisesEntity.setCreatedBy(adUserExpertisesDomain.getCreatedby());
			adUserExpertisesEntity.setCreationDate(today);
		}
		adUserExpertisesEntity.setActiveStatus(adUserExpertisesDomain.getActiveStatus());
		adUserExpertisesEntity.setAdUsers(userEntity);
		adUserExpertisesEntity.setAdLookupValues(adLookupValuesExpertises);
		adUserExpertisesEntity.setLastUpdateDate(today);
		adUserExpertisesEntity.setLastUpdatedBy(adUserExpertisesDomain.getLastupdateby());
	}
	
	public void convertAdUserAdUserSpecialitiesDomainToEntity(AdUserSpecialitiesDomain adUserAdUserSpecialitiesDomain, AdUserSpecialities adUserEducationsEntity, AdLookupValues adLookupValuesSpecialities, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adUserEducationsEntity.setCreatedBy(adUserAdUserSpecialitiesDomain.getCreatedby());
			adUserEducationsEntity.setCreationDate(today);
		}
		adUserEducationsEntity.setActiveStatus(adUserAdUserSpecialitiesDomain.getActiveStatus());
		adUserEducationsEntity.setAdUsers(userEntity);
		adUserEducationsEntity.setAdLookupValues(adLookupValuesSpecialities);
		adUserEducationsEntity.setLastUpdateDate(today);
		adUserEducationsEntity.setLastUpdatedBy(adUserAdUserSpecialitiesDomain.getLastupdateby());
	}
	
	public void convertAdUserDegaccsDomainToEntity(AdUserDegaccsDomain adUserDegaccsDomain, AdUserDegaccs adUserExpertisesDegaccs, AdLookupValues adLookupValuesDegaccs, AdUsers userEntity, boolean isForUpdate){
		Calendar today = Calendar.getInstance();
		if(!isForUpdate){
			adUserExpertisesDegaccs.setCreatedBy(adUserDegaccsDomain.getCreatedby());
			adUserExpertisesDegaccs.setCreationDate(today);
		}
		adUserExpertisesDegaccs.setActiveStatus(adUserDegaccsDomain.getActiveStatus());
		adUserExpertisesDegaccs.setAdUsers(userEntity);
		adUserExpertisesDegaccs.setAdLookupValues(adLookupValuesDegaccs);
		adUserExpertisesDegaccs.setLastUpdateDate(today);
		adUserExpertisesDegaccs.setLastUpdatedBy(adUserDegaccsDomain.getLastupdateby());
	}
	
	
	


	public void convertAdUserMembershipsEntityToDomain(Set<AdUserMemberships> adUserMembershipsSet, List <AdUserMembershipDomain> adUserMembershipDomainsList) throws DatatypeConfigurationException{
		for (AdUserMemberships adUserMemberships : adUserMembershipsSet) {
			AdUserMembershipDomain adUserMembershipDomain = new AdUserMembershipDomain();
			adUserMembershipDomain.setAutopay(adUserMemberships.getAutopay());
			
			if(null != adUserMemberships.getAutopayWithdrawDay())
					adUserMembershipDomain.setAutopayWithdrawDate(adUserMemberships.getAutopayWithdrawDay());
			
			adUserMembershipDomain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(adUserMemberships.getEffectiveDate()));
			adUserMembershipDomain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(adUserMemberships.getExpirationDate()));
			adUserMembershipDomain.setMembershipid(adUserMemberships.getMembershipId());
			adUserMembershipDomain.setMembershipPricingId(adUserMemberships.getStMemPricingOptions().getMemPricingId());
			adUserMembershipDomain.setMembershipPrice(adUserMemberships.getStMemPricingOptions().getPrice());
			adUserMembershipDomain.setPaymentStatusId(adUserMemberships.getAdLookupValues().getLookupValueId());
			adUserMembershipDomain.setUserId(adUserMemberships.getAdUsers().getUserId());
			adUserMembershipDomainsList.add(adUserMembershipDomain);
		}
	}
	
	public void convertAdUserMembershipsDomainToEntity(AdUserMembershipDomain domain, AdUserMemberships entity) throws DatatypeConfigurationException{
		//Update payment status
		AdLookupValues paymentStatus=new AdLookupValues();
		paymentStatus.setLookupValueId(domain.getPaymentStatusId());
		entity.setAdLookupValues(paymentStatus); //Payment status
		//Update membership pricing id
		StMemPricingOptions stMemPricingOptions = new StMemPricingOptions();
		stMemPricingOptions.setMemPricingId(domain.getMembershipPricingId());
		entity.setStMemPricingOptions(stMemPricingOptions);
	}
	
	
	public void convertAdLookupValuesEntityToDomain(Set<AdLookupValues> adLookupValuesSet, List <AdLookupValuesDomain> adLookupValuesDomainList){
		for (AdLookupValues adLookupValues : adLookupValuesSet) {
			AdLookupValuesDomain adLookupValuesDomain = new AdLookupValuesDomain();
			adLookupValuesDomain.setActiveStatus(adLookupValues.getActiveStatus());
			adLookupValuesDomain.setDescription(adLookupValues.getDescription());
			adLookupValuesDomain.setLangCode(adLookupValues.getLangCode());
			adLookupValuesDomain.setLookupCode(adLookupValues.getLookupCode());
			adLookupValuesDomain.setLookupTypeId(adLookupValues.getAdLookupTypes().getLookupTypeId());
			adLookupValuesDomain.setLookupValueId(adLookupValues.getLookupValueId());
			adLookupValuesDomainList.add(adLookupValuesDomain);
		}
	}
	
	public void convertAdLookupValuesEntityToDomain(AdLookupValues adLookupValues, AdLookupValuesDomain adLookupValuesDomain){
			adLookupValuesDomain.setActiveStatus(adLookupValues.getActiveStatus());
			adLookupValuesDomain.setDescription(adLookupValues.getDescription());
			adLookupValuesDomain.setLangCode(adLookupValues.getLangCode());
			adLookupValuesDomain.setLookupCode(adLookupValues.getLookupCode());
			adLookupValuesDomain.setLookupTypeId(adLookupValues.getAdLookupTypes().getLookupTypeId());
			adLookupValuesDomain.setLookupValueId(adLookupValues.getLookupValueId());
	}
	
	public void convertAdLookupValuesDomainToEntity(AdLookupValuesDomain domain,AdLookupValues entity, AdLookupTypes lookupType){
		entity.setLookupValueId(domain.getLookupValueId());
		entity.setAdLookupTypes(lookupType); //set lookup type
		entity.setLookupCode(domain.getLookupCode()); //Should be unique value
		entity.setDescription(domain.getDescription());
		entity.setActiveStatus(domain.getActiveStatus());
		entity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		entity.setCreatedBy(2);
		entity.setLastUpdateBy(2);
		entity.setCreationDate(Calendar.getInstance());
		entity.setLastUpdateDate(Calendar.getInstance());
	}
	
	public void convertSingleAdLookupValuesEntityToDomain(AdLookupValues adLookupValue, AdLookupValuesDomain adLookupValuesDomain){
		adLookupValuesDomain.setActiveStatus(adLookupValue.getActiveStatus());
		adLookupValuesDomain.setDescription(adLookupValue.getDescription());
		adLookupValuesDomain.setLangCode(adLookupValue.getLangCode());
		adLookupValuesDomain.setLookupCode(adLookupValue.getLookupCode());
		adLookupValuesDomain.setLookupTypeId(adLookupValue.getAdLookupTypes().getLookupTypeId());
		adLookupValuesDomain.setLookupValueId(adLookupValue.getLookupValueId());
	}
	
	/**
	 *
	 */
	public void convertTrMessagesEntityToDomain(Set<TrMessages> trMessagesSet, List <TrMessagesDomain> trMessagesDomainsList) throws DatatypeConfigurationException{
		for (TrMessages trMessages : trMessagesSet) {
			TrMessagesDomain trMessagesDomain = ModelConverter.domainObjFactory.createTrMessagesDomain();
			trMessagesDomain.setActiveStatus(trMessages.getActiveStatus());
			trMessagesDomain.setBoardId(trMessages.getTrBoard().getBoardId());
			trMessagesDomain.setBoardName(trMessages.getTrBoard().getName());
			TrBoardImages boardImage=trMessages.getTrBoard().getTrBoardImageses().iterator().next();
			trMessagesDomain.setBoardThumbnailUrl(boardImage.getThumbnailUrl());
			trMessagesDomain.setBoardTileUrl(boardImage.getFileName());
			trMessagesDomain.setBoard(convertTrBoardEntityToDomain(trMessages.getTrBoard()));
			trMessagesDomain.setFromUserId(trMessages.getAdUsersByFromUserId().getUserId());
			trMessagesDomain.setFromUserFirstName(trMessages.getAdUsersByFromUserId().getFirstname());
			trMessagesDomain.setFromUserLastName(trMessages.getAdUsersByFromUserId().getLastname());
			trMessagesDomain.setFromUserCompanyName(trMessages.getAdUsersByFromUserId().getCompanyName());
			trMessagesDomain.setFromUserLogoUrl(trMessages.getAdUsersByFromUserId().getLogoImageUrl());
			trMessagesDomain.setLangCode(trMessages.getLangCode());
			trMessagesDomain.setMessageBody(trMessages.getMessageBody());
			trMessagesDomain.setMessageId(trMessages.getMessageId());
			trMessagesDomain.setMessageType(trMessages.getMessageType());
			trMessagesDomain.setMsgStatusId(trMessages.getAdLookupValues().getLookupValueId());
			trMessagesDomain.setReadOn(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trMessages.getReadOn()));
			trMessagesDomain.setSubject(trMessages.getSubject());
			trMessagesDomain.setToUserId(trMessages.getAdUsersByToUserId().getUserId());
			trMessagesDomain.setToUserFirstName(trMessages.getAdUsersByToUserId().getFirstname());
			trMessagesDomain.setToUserLastName(trMessages.getAdUsersByToUserId().getLastname());
			trMessagesDomain.setToUserCompanyName(trMessages.getAdUsersByToUserId().getCompanyName());
			trMessagesDomain.setToUserLogoUrl(trMessages.getAdUsersByToUserId().getLogoImageUrl());
			trMessagesDomain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trMessages.getLastUpdateDate()));
			trMessagesDomain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trMessages.getCreationDate()));
			//profile name
			trMessagesDomain.setFromUserProfilename(trMessages.getAdUsersByFromUserId().getProfilename());
			trMessagesDomain.setFromUserUseProfilename(trMessages.getAdUsersByFromUserId().getUseProfilename());
			trMessagesDomain.setToUserProfilename(trMessages.getAdUsersByToUserId().getProfilename());
			trMessagesDomain.setToUserUseProfilename(trMessages.getAdUsersByToUserId().getUseProfilename());
			//user type
			AdLookupValuesDomain fromUserTypeDomain = new AdLookupValuesDomain();
			AdLookupValuesDomain toUserTypeDomain = new AdLookupValuesDomain();
			this.convertAdLookupValuesEntityToDomain(trMessages.getAdUsersByFromUserId().getAdLookupValuesByUserTypeId(), fromUserTypeDomain);
			this.convertAdLookupValuesEntityToDomain(trMessages.getAdUsersByToUserId().getAdLookupValuesByUserTypeId(), toUserTypeDomain);
			trMessagesDomain.setFromUserType(fromUserTypeDomain);
			trMessagesDomain.setToUserType(toUserTypeDomain);
			trMessagesDomainsList.add(trMessagesDomain);
		}
	}
	
	public void convertTrBoardEntityToDomain(Set<TrBoard> trBoardSet, List <TrBoardDomain> trBoardDomainsList) throws DatatypeConfigurationException{	
		for(TrBoard trBoardEntity : trBoardSet){
			TrBoardDomain trBoardDomain = new TrBoardDomain();
			trBoardDomain.setBoardId(trBoardEntity.getBoardId());
			trBoardDomain.setBoardPrice(trBoardEntity.getBoardPrice());
			if(trBoardEntity.getStCategoryMasterByCatLevel3Id()!=null)
				trBoardDomain.setCategoryLevel3Id(trBoardEntity.getStCategoryMasterByCatLevel3Id().getCategoryId());
			if(trBoardEntity.getStCategoryMasterByCatLevel4Id()!=null)
				trBoardDomain.setCategoryLevel4Id(trBoardEntity.getStCategoryMasterByCatLevel4Id().getCategoryId());
			if(trBoardEntity.getStCategoryMasterByCatLevel5Id()!=null)
				trBoardDomain.setCategoryLevel5Id(trBoardEntity.getStCategoryMasterByCatLevel5Id().getCategoryId());
			trBoardDomain.setCurrentUerId(trBoardEntity.getAdUsersByCurrentUserId().getUserId());
			trBoardDomain.setDescription(trBoardEntity.getDescription());
			trBoardDomain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trBoardEntity.getExpirationDate()));
			trBoardDomain.setKeyword(trBoardEntity.getKeyword());
			trBoardDomain.setLangCode(trBoardEntity.getLangCode());
			trBoardDomain.setName(trBoardEntity.getName());
			trBoardDomain.setOriginalUserId(trBoardEntity.getAdUsersByOriginalUserId().getUserId());
			trBoardDomain.setPortfolioId(trBoardEntity.getTrPortfolio().getPortfolioId());
			trBoardDomain.setPortfolioUserId(trBoardEntity.getTrPortfolio().getAdUsers().getUserId());
			trBoardDomain.setPublishToMP(trBoardEntity.getPublishToMp());
			trBoardDomain.setSaleTypeId(trBoardEntity.getAdLookupValues().getLookupValueId());
			trBoardDomain.setTotalPrice(trBoardEntity.getTotalPrice());
			trBoardDomain.setActiveStatus(trBoardEntity.getActiveStatus());
			AdUsersDomain currentUser=new AdUsersDomain();
			convertAdUsersEntityToDomain(trBoardEntity.getAdUsersByCurrentUserId(), currentUser);
			trBoardDomain.setCurrentUser(currentUser);
			AdUsersDomain originalUser=new AdUsersDomain();
			convertAdUsersEntityToDomain(trBoardEntity.getAdUsersByOriginalUserId(), originalUser);
			trBoardDomain.setOriginalUser(originalUser);
			//set board images domain
			convertTrBoardImagesEntityToDomain(trBoardEntity.getTrBoardImageses(),trBoardDomain.getBoardImages());
			trBoardDomainsList.add(trBoardDomain);
		}
	}
	
	public void convertTrBoardImagesEntityToDomain(Set<TrBoardImages> trBoardImagesSet,List<TrBoardImagesDomain> trBoardImagesDomainList)
	{
		for(TrBoardImages trBoardImagesEntity: trBoardImagesSet)
		{
			TrBoardImagesDomain trBoardImagesDomain=new TrBoardImagesDomain();
			trBoardImagesDomain.setBoardImageId(trBoardImagesEntity.getBoardImageId());
			trBoardImagesDomain.setSourceFileURL(trBoardImagesEntity.getSourceFileUrl());
			trBoardImagesDomain.setFileName(trBoardImagesEntity.getFileName());
			trBoardImagesDomain.setThumbnailUrl(trBoardImagesEntity.getThumbnailUrl());
			trBoardImagesDomain.setMainImageUrl(trBoardImagesEntity.getMainImageUrl());
			try {
				trBoardImagesDomain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trBoardImagesEntity.getCreationDate()));
				trBoardImagesDomain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trBoardImagesEntity.getLastUpdateDate()));
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			trBoardImagesDomainList.add(trBoardImagesDomain);
		}
	}
	
	public StTermConditionDomain convertStTermConditionEntityToDomain(StTermsConditions stTermConditions) throws DatatypeConfigurationException{

		StTermConditionDomain stTermConditionDomain = new StTermConditionDomain();
		stTermConditionDomain.setDisplayedTerm(stTermConditions.getDisplayedTerms());
		if(null != stTermConditions.getEffectiveDate()){
			stTermConditionDomain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(stTermConditions.getEffectiveDate()));
		}

		if(null != stTermConditions.getExpirationDate()){
			stTermConditionDomain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(stTermConditions.getExpirationDate()));
		}

		stTermConditionDomain.setLangCode(stTermConditions.getLangCode());
		stTermConditionDomain.setReviewedByLegal(stTermConditions.getReviewedByLegal());
		stTermConditionDomain.setTermCondId(stTermConditions.getTermCondId());
		stTermConditionDomain.setTermTypeId(stTermConditions.getAdLookupValuesByTermTypeId().getLookupValueId());
		stTermConditionDomain.setUserTypeId(stTermConditions.getAdLookupValuesByUserTypeId().getLookupValueId());

		return stTermConditionDomain;
	}
	
	public StCategoryMasterDomain convertStCategoryMasterEntityToDomain(StCategoryMaster stCategoryMaster) throws DatatypeConfigurationException{
		StCategoryMasterDomain stCategoryMasterDomain = new StCategoryMasterDomain();
		stCategoryMasterDomain.setActiveStatus(stCategoryMaster.getActiveStatus());
		stCategoryMasterDomain.setCategoryId(stCategoryMaster.getCategoryId());
		stCategoryMasterDomain.setCreatedby(stCategoryMaster.getCreatedBy());
		stCategoryMasterDomain.setLangCode(stCategoryMaster.getLangCode());
		stCategoryMasterDomain.setLastupdateby(stCategoryMaster.getLastUpdatedBy());
		stCategoryMasterDomain.setLevel(stCategoryMaster.getLevel());
		stCategoryMasterDomain.setName(stCategoryMaster.getName());
		stCategoryMasterDomain.setParentID(stCategoryMaster.getParentId());	
		return stCategoryMasterDomain;
	}
	
	public StSeasonYearDomain convertStSeasonYearEntityToDomain(StSeasonYear stSeasonYear) throws DatatypeConfigurationException{
		StSeasonYearDomain stSeasonYearDomain = new StSeasonYearDomain();
		stSeasonYearDomain.setActiveStatus(stSeasonYear.getActiveStatus());
		stSeasonYearDomain.setCreatedby(stSeasonYear.getCreatedBy());
		stSeasonYearDomain.setLangCode(stSeasonYear.getLangCode());
		stSeasonYearDomain.setLastupdateby(stSeasonYear.getLastUpdatedBy());
		stSeasonYearDomain.setSeason(stSeasonYear.getSeason());
		stSeasonYearDomain.setSeasonYearId(stSeasonYear.getSeasonYearId());
		//stSeasonYearDomain.setYear(stSeasonYear.getYear());
		return stSeasonYearDomain;
	}
	
	public void convertTrBoardSearchEntitysToDomains(Set<TrBoardSearch> trBoardSet, List<TrBoardSearchDomain> trBoardDomainsList) throws DatatypeConfigurationException{
//		List<TrBoardSearchDomain> trBoardDomainsList = response.getTrBoardSearchDomains();
		for(TrBoardSearch trBoard : trBoardSet){
			TrBoardSearchDomain searchDomain = new TrBoardSearchDomain();
			searchDomain.setBoardId(trBoard.getBoardId());
			searchDomain.setBoardPrice(trBoard.getBoardPrice());
			searchDomain.setDescription(trBoard.getDescription());
			searchDomain.setMainImageUrl(trBoard.getMainImageUrl());
			searchDomain.setName(trBoard.getName());
//			searchDomain.setPortfolioId(trBoard.get);
			searchDomain.setThumbnailUrl(trBoard.getThumbnailUrl());
			searchDomain.setTotalPrice(trBoard.getTotalPrice());
			searchDomain.setSalePrice(trBoard.getSalePrice().setScale(2, BigDecimal.ROUND_HALF_UP)); //Show SALE_PRICE(With company commission) instead of total_price.
			searchDomain.setDesignerName(trBoard.getDesigner().getFirstname()+" "+trBoard.getDesigner().getLastname());
			searchDomain.setDate(DateUtil.toXMLGregorianCalendar(trBoard.getDate()));
			//set tile image url
			searchDomain.setTileImageUrl(trBoard.getTileImageUrl());
			trBoardDomainsList.add(searchDomain);
		}		
	}
	
	public TrBoardDomain convertTrBoardEntityToDomain(TrBoard trBoard) throws DatatypeConfigurationException
	{
		TrBoardDomain trBoardDomain = new TrBoardDomain();
		trBoardDomain.setBoardId(trBoard.getBoardId());
		trBoardDomain.setBoardPrice(trBoard.getBoardPrice());
		if(trBoard.getStCategoryMasterByCatLevel3Id()!=null)
			trBoardDomain.setCategoryLevel3Id(trBoard.getStCategoryMasterByCatLevel3Id().getCategoryId());
		if(trBoard.getStCategoryMasterByCatLevel4Id()!=null)
			trBoardDomain.setCategoryLevel4Id(trBoard.getStCategoryMasterByCatLevel4Id().getCategoryId());
		if(trBoard.getStCategoryMasterByCatLevel5Id()!=null)
			trBoardDomain.setCategoryLevel5Id(trBoard.getStCategoryMasterByCatLevel5Id().getCategoryId());
		trBoardDomain.setCurrentUerId(trBoard.getAdUsersByCurrentUserId().getUserId());
		trBoardDomain.setDescription(trBoard.getDescription());
		trBoardDomain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(trBoard.getExpirationDate()));
		trBoardDomain.setKeyword(trBoard.getKeyword());
		trBoardDomain.setLangCode(trBoard.getLangCode());
		trBoardDomain.setName(trBoard.getName());
		trBoardDomain.setOriginalUserId(trBoard.getAdUsersByOriginalUserId().getUserId());
		trBoardDomain.setPortfolioId(trBoard.getTrPortfolio().getPortfolioId());
		trBoardDomain.setPortfolioUserId(trBoard.getTrPortfolio().getAdUsers().getUserId());
		trBoardDomain.setPublishToMP(trBoard.getPublishToMp());
		trBoardDomain.setSaleTypeId(trBoard.getAdLookupValues().getLookupValueId());
		trBoardDomain.setTotalPrice(trBoard.getTotalPrice());
		trBoardDomain.setStatusId(trBoard.getAdLookupValuesStatusId().getLookupValueId());
		trBoardDomain.setLastupdateby(trBoard.getLastUpdatedBy());
		//set board images domain
		convertTrBoardImagesEntityToDomain(trBoard.getTrBoardImageses(),trBoardDomain.getBoardImages());
		return trBoardDomain;
	}
	
	public TrBoardApproval convertTrBoardApprovalDomainToEntity(TrBoardApprovalDomain domain) {
		TrBoardApproval entity=new TrBoardApproval();
		entity.setMainImageUrl(domain.getMainImageUrl());
		entity.setApprovalStatus(domain.getApprovalStatus());
		entity.setComments(domain.getComments());
		entity.setApproverName(domain.getApproverName());
		entity.setProcessStatus(domain.getProcessStatus());
		entity.setErrorMessage(domain.getErrorMessage());
		entity.setCreationDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getCreationDate()));
		entity.setCreatedBy(domain.getCreatedBy());
		entity.setLastUpdateDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getLastUpdateDate()));
		entity.setLastUpdatedBy(domain.getLastUpdatedBy());
		return entity;
	}
	
	public TrBoardApprovalDomain convertTrBoardApprovalEntityToDomain(TrBoardApproval entity) throws DatatypeConfigurationException {
		TrBoardApprovalDomain domain=new TrBoardApprovalDomain();
		domain.setMainImageUrl(entity.getMainImageUrl());
		domain.setApprovalStatus(domain.getApprovalStatus());
		domain.setComments(domain.getComments());
		domain.setApproverName(domain.getApproverName());
		domain.setProcessStatus(domain.getProcessStatus());
		domain.setErrorMessage(domain.getErrorMessage());
		domain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getCreationDate()));
		domain.setCreatedBy(domain.getCreatedBy());
		domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getLastUpdateDate()));
		domain.setLastUpdatedBy(domain.getLastUpdatedBy());
		return domain;
	}
	
	public StMemPricingOptionsDomain convertStMemPricingOptionsEntityToDomain(StMemPricingOptions entity) throws DatatypeConfigurationException
	{
		StMemPricingOptionsDomain domain=new StMemPricingOptionsDomain();
		domain.setCommission(entity.getCommission());
		domain.setCreatedby(entity.getCreatedBy());
		domain.setDescription(entity.getDescription());
		domain.setDurationInMonths(entity.getDurationInMonths());
		domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getEffectiveDate()));
		domain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getExpirationDate()));
		domain.setLangCode(entity.getLangCode());
		domain.setLastupdateby(entity.getLastUpdatedBy());
		domain.setMemberPricingId(entity.getMemPricingId());
		domain.setMembershipTypeId(entity.getAdLookupValuesByMembershipTypeId().getLookupValueId());
		domain.setPrice(entity.getPrice());
		domain.setUserTypeId(entity.getAdLookupValuesByUserTypeId().getLookupValueId());
		AdLookupValuesDomain membershipType=new AdLookupValuesDomain();
		this.convertSingleAdLookupValuesEntityToDomain(entity.getAdLookupValuesByMembershipTypeId(), membershipType);
		domain.setMembershipType(membershipType);
		return domain;
	}
	
	public void convertStMemPricingOptionsEntityToDomain(Set<StMemPricingOptions> entity,List<StMemPricingOptionsDomain> domain) throws DatatypeConfigurationException
	{
		for(StMemPricingOptions item:entity)
		{
			StMemPricingOptionsDomain entry=new StMemPricingOptionsDomain();
			entry=convertStMemPricingOptionsEntityToDomain(item);
			domain.add(entry);
		}
	}
	
	
	public UserInfoDomain convertAdUsersToUserInfoDomain(AdUsers entity, ArrayList<ArrayList<TrBoardImages>> images) {
		UserInfoDomain domain=new UserInfoDomain();
		domain.setName(entity.getFirstname()+" "+entity.getLastname());
		AdLookupValuesDomain regStatusDomain=new AdLookupValuesDomain();
		this.convertSingleAdLookupValuesEntityToDomain(entity.getAdLookupValuesByRegStatusId(), regStatusDomain);
		domain.setRegStatus(regStatusDomain);
		
		AdLookupValuesDomain userType=new AdLookupValuesDomain();
		this.convertSingleAdLookupValuesEntityToDomain(entity.getAdLookupValuesByUserTypeId(), userType);
		domain.setUserType(userType);
		
		domain.setActiveStatus(entity.getActiveStatus());
		domain.setUserLogo(entity.getLogoImageUrl());
		domain.setUserId(entity.getUserId());
		domain.setUserName(entity.getUserName());
		domain.setApproverComment(entity.getApproverComments());
		domain.setAdminRating(entity.getAdminRating().intValue());

		if ( images != null ){
			TrPortfolioDomain portfolioDomain = new TrPortfolioDomain();		
			
			for ( int i= 0; i < images.size() ; i++){
				for(int j=0; j< images.get(i).size(); j++){
					TrBoardDomain trBoardDomainItem = new TrBoardDomain();
					TrBoardImagesDomain imagesDomain  = new TrBoardImagesDomain();
					imagesDomain.setThumbnailUrl(images.get(i).get(j).getThumbnailUrl());
					trBoardDomainItem.getBoardImages().add(imagesDomain);
					portfolioDomain.getBoards().add(trBoardDomainItem);
				}
			}

		
			domain.getPortfolio().add(portfolioDomain);
		}
		
		try {
			this.convertAdUserMembershipsEntityToDomain(entity.getAdUserMembershipset(), domain.getMembership());
			for(AdUserMemberships item:entity.getAdUserMembershipset())
				domain.setMemPricingOption(this.convertStMemPricingOptionsEntityToDomain(item.getStMemPricingOptions()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return domain;
	}
	
	public TrBroadcastMessagesDomain convertTrBroadcastMessagesEntityToDomain(TrBroadcastMessages entity) {
		TrBroadcastMessagesDomain domain = new TrBroadcastMessagesDomain();
		AdLookupValuesDomain scopeDomain = new AdLookupValuesDomain();
		this.convertSingleAdLookupValuesEntityToDomain(entity.getAdLookupValuesByMsgScopeId(), scopeDomain);
		AdLookupValuesDomain statusDomain = new AdLookupValuesDomain();
		this.convertSingleAdLookupValuesEntityToDomain(entity.getAdLookupValuesByMsgStatusId(), statusDomain);
		domain.setBroadcastId(entity.getBroadcastId());
		domain.setTemplateName(entity.getTemplateName());
		domain.setSubject(entity.getSubject());
		domain.setMessageText(entity.getMessageText());
		domain.setMsgScopeId(entity.getAdLookupValuesByMsgScopeId().getLookupValueId());
		domain.setMsgStatusId(entity.getAdLookupValuesByMsgStatusId().getLookupValueId());
		domain.setAdLookupValuesByMsgScopeId(scopeDomain);
		domain.setAdLookupValuesByMsgStatusId(statusDomain);
		domain.setErrorMessage(entity.getErrorMessage());
		domain.setCreatedBy(entity.getCreatedBy());
		domain.setLastUpdatedBy(entity.getLastUpdatedBy());
		try {
			domain.setProcessedDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getProcessedDate()));
			domain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getCreationDate()));
			domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getLastUpdateDate()));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return domain;
	}
	
	public List<TrBroadcastMessagesDomain> convertTrBroadcastMessagesEntityToDomain(Set<TrBroadcastMessages> entitySet) {
		List<TrBroadcastMessagesDomain> domainList = new ArrayList<TrBroadcastMessagesDomain>();
		for(TrBroadcastMessages item : entitySet) {
			domainList.add(convertTrBroadcastMessagesEntityToDomain(item));
		}
		return domainList;
	}
	
	public TrBroadcastMessages convertTrBroadcastMessagesDomainToEntity(TrBroadcastMessagesDomain domain) {
		TrBroadcastMessages entity = new TrBroadcastMessages();
		AdLookupValues scopeEntity = new AdLookupValues();
		AdLookupValues statusEntity = new AdLookupValues();
		scopeEntity.setLookupValueId(domain.getMsgScopeId());
		statusEntity.setLookupValueId(domain.getMsgStatusId());
		entity.setTemplateName(domain.getTemplateName());
		entity.setSubject(domain.getSubject());
		entity.setMessageText(domain.getMessageText());
		entity.setAdLookupValuesByMsgScopeId(scopeEntity);
		entity.setAdLookupValuesByMsgStatusId(statusEntity);
		entity.setErrorMessage(domain.getErrorMessage());
		entity.setCreatedBy(domain.getCreatedBy());
		entity.setLastUpdatedBy(domain.getLastUpdatedBy());
		try {
			entity.setProcessedDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getProcessedDate()));
			entity.setCreationDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getCreationDate()));
			entity.setLastUpdateDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getLastUpdateDate()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	public AdEmailTemplatesDomain convertEntityToDomain(AdEmailTemplates entity)
	{
		AdEmailTemplatesDomain domain = new AdEmailTemplatesDomain();
		domain.setEmailTemplId(entity.getEmailTemplateId());
		domain.setTempCode(entity.getEmailTemplateCode());
		domain.setSubject(entity.getSubject());
		domain.setBody(entity.getBody());
		domain.setSupportEmail(entity.getSupportEmail());
		domain.setCreatedBy(entity.getCreatedBy());
		domain.setLastUpdatedBy(entity.getLastUpdatedBy());
		try {
			domain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getCreationDate()));
			domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(entity.getLastUpdateDate()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return domain;
	}
	
	public List<AdEmailTemplatesDomain> convertEntityToDomain(Set<AdEmailTemplates> entitySet)
	{
		List<AdEmailTemplatesDomain> domainList = new ArrayList<AdEmailTemplatesDomain>();
		for(AdEmailTemplates item : entitySet)
			domainList.add(convertEntityToDomain(item));
		return domainList;
	}
	
	public TrPortfolioImagesDomain convertTrPortfolioImagesEntityToDomain(TrPortfolioImages entity)
	{
		TrPortfolioImagesDomain domain = new TrPortfolioImagesDomain();
		try
		{
			domain.setPortfolioImageId(entity.getPortfolioImageId());
			domain.setPortfolioId(entity.getTrPortfolio().getPortfolioId());
			domain.setSourceFileURL(entity.getSourceFileUrl());
			domain.setFileName(entity.getFileName());
			domain.setThumbnailUrl(entity.getThumbnailUrl());
			domain.setMainImageUrl(entity.getMainImageUrl());
			domain.setFileType(entity.getFileType());
			domain.setCreatedby(entity.getCreatedBy());
			domain.setLastupdateby(entity.getLastUpatedBy());
			domain.setActiveStatus(entity.getActiveStatus());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return domain;
	}
	
	public List<TrPortfolioImagesDomain> convertTrPortfolioImagesEntityToDomain(Set<TrPortfolioImages> entities)
	{
		List<TrPortfolioImagesDomain> domains= new ArrayList<TrPortfolioImagesDomain>();
		//only retrieve first 2 results
		int count=1;
		if(entities!=null && !entities.isEmpty()) //do the conversion when data existed
		{
			for(TrPortfolioImages entity : entities)
			{
				if(count>2)
					break;
				TrPortfolioImagesDomain domain = this.convertTrPortfolioImagesEntityToDomain(entity);
				domains.add(domain);
				count++;
			}
			//sort the collection to make it order by id ascending.
			Collections.sort(domains, new Comparator<TrPortfolioImagesDomain>() {
		        public int compare(TrPortfolioImagesDomain o1, TrPortfolioImagesDomain o2) {
		            if(o1.getPortfolioImageId()>o2.getPortfolioImageId())
		            	return 1;
		            else
		            	return -1;
		          }
			});
		}
		return domains;
	}
	
	public TrPortfolioImages convertTrPortfolioImagesDomainToEntity(TrPortfolioImagesDomain domain)
	{
		TrPortfolioImages entity = new TrPortfolioImages();
		entity.setPortfolioImageId(entity.getPortfolioImageId());
		TrPortfolio portfolio = new TrPortfolio();
		portfolio.setPortfolioId(domain.getPortfolioId());
		entity.setPortfolioImageId(domain.getPortfolioImageId());
		entity.setTrPortfolio(portfolio);
		entity.setSourceFileUrl(domain.getSourceFileURL());
		entity.setFileName(domain.getFileName());
		entity.setThumbnailUrl(domain.getThumbnailUrl());
		entity.setMainImageUrl(domain.getMainImageUrl());
		entity.setFileType(domain.getFileType());
		entity.setCreatedBy(domain.getCreatedby());
		entity.setLastUpatedBy(domain.getLastupdateby());
		entity.setCreationDate(Calendar.getInstance());
		entity.setLastUpdateDate(Calendar.getInstance());
		entity.setActiveStatus(domain.getActiveStatus());
		return entity;
	}
	
	public Set<TrPortfolioImages> convertTrPortfolioImagesDomainToEntity(List<TrPortfolioImagesDomain> domains)
	{
		Set<TrPortfolioImages> entities = new LinkedHashSet<TrPortfolioImages>();
		for(TrPortfolioImagesDomain domain : domains) 
		{
			TrPortfolioImages entity = new TrPortfolioImages();
			entity=this.convertTrPortfolioImagesDomainToEntity(domain);
			entities.add(entity);
		}
		return entities;
	}
	
	public AdUserDocumentsDomain convertAdUserDocumentsEntityToDomain(AdUserDocuments entity)
	{
		AdUserDocumentsDomain domain = new AdUserDocumentsDomain();
		domain.setDocId(entity.getDocId());
		domain.setUserId(entity.getAdUsers().getUserId());
		domain.setSourceFileURL(entity.getSourceFileUrl());
		domain.setFileType(entity.getFileType());
		domain.setFileName(entity.getFileName());
		domain.setThumbnailUrl(entity.getThumbnailUrl());
		domain.setMainImageUrl(entity.getMainImageUrl());
		domain.setFileType(entity.getFileType());
		domain.setCreatedby(entity.getCreatedBy());
		domain.setCreatedby(entity.getLastUpatedBy());
		domain.setActiveStatus(entity.getActiveStatus());
		return domain;
	}
	
	public AdUserDocuments convertAdUserDocumentsDomainToEntity(AdUserDocumentsDomain domain, AdUsers adUsers)
	{
		AdUserDocuments entity = new AdUserDocuments();
		entity.setDocId(domain.getDocId());
		entity.setAdUsers(adUsers);
		entity.setSourceFileUrl(domain.getSourceFileURL());
		entity.setFileType(domain.getFileType());
		entity.setFileName(domain.getFileName());
		entity.setThumbnailUrl(domain.getThumbnailUrl());
		entity.setMainImageUrl(domain.getMainImageUrl());
		entity.setFileType(domain.getFileType());
		entity.setCreatedBy(domain.getCreatedby());
		entity.setLastUpatedBy(domain.getLastupdateby());
		entity.setCreationDate(Calendar.getInstance());
		entity.setLastUpdateDate(Calendar.getInstance());
		entity.setActiveStatus(domain.getActiveStatus());
		return entity;
	}
	
	public List<AdUserDocumentsDomain> convertAdUserDocumentsEntityToDomain(Set<AdUserDocuments> entitySet)
	{
		List<AdUserDocumentsDomain> domainList = new ArrayList<AdUserDocumentsDomain>();
		for(AdUserDocuments entity : entitySet)
		{
			AdUserDocumentsDomain item = this.convertAdUserDocumentsEntityToDomain(entity);
			domainList.add(item);
		}
		return domainList;
	}
	
	public Set<AdUserDocuments> convertAdUserDocumentsDomainToEntity(List<AdUserDocumentsDomain> domains, AdUsers adUsers)
	{
		Set<AdUserDocuments> entity = new HashSet<AdUserDocuments>();
		for(AdUserDocumentsDomain domain : domains)
		{
			AdUserDocuments item = this.convertAdUserDocumentsDomainToEntity(domain,adUsers);
			entity.add(item);
		}
		return entity;
	}
	
	public TrPortfolioDomain convertEntityToDomain(TrPortfolio portfolio) {
		TrPortfolioDomain portfoliodomain = new TrPortfolioDomain();
		portfoliodomain.setActiveStatus(portfolio.getActiveStatus());
		portfoliodomain.setUserId(portfolio.getAdUsers().getUserId());
		portfoliodomain.setCreatedby(portfolio.getCreatedBy());
		portfoliodomain.setDescription(portfolio.getDescription());
		portfoliodomain.setLangCode(portfolio.getLangCode());
		portfoliodomain.setLastupdateby(portfolio.getLastUpdatedBy());
		portfoliodomain.setName(portfolio.getName());
		portfoliodomain.setPortfolioId(portfolio.getPortfolioId());
		portfoliodomain.setCategoryLevel1Id(portfolio.getStCategoryMasterByCatLevel1Id().getCategoryId());
		portfoliodomain.setCategoryLevel2Id(portfolio.getStCategoryMasterByCatLevel2Id().getCategoryId());
		portfoliodomain.setCategoryLevel1(portfolio.getStCategoryMasterByCatLevel1Id().getName());
		portfoliodomain.setCategoryLevel2(portfolio.getStCategoryMasterByCatLevel2Id().getName());
		portfoliodomain.setSeasonYearId(portfolio.getStSeasonYear().getSeasonYearId());
		// convert trPortfolioImages and boards
		List<TrBoardDomain> boards=portfoliodomain.getBoards();
		List<TrPortfolioImagesDomain> portfolioImages=portfoliodomain.getPortfolioImages();
		try
		{
			this.convertTrBoardEntityToDomain(portfolio.getTrBoards(), boards);
			portfolioImages.addAll(this.convertTrPortfolioImagesEntityToDomain(portfolio.getTrPortfolioImages()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//set boards to domain  -C==================================================================
		/*List<TrBoardDomain> domain=portfoliodomain.getBoards();
		Set<TrBoard> boards=portfolio.getTrBoards();
		
		while(boards.iterator().hasNext())
		{
			logger.trace("IN LOOP");
			TrBoardDomain boardDomain=convertEntityToDomain(boards.iterator().next());
			domain.add(boardDomain);
		}*/
		portfoliodomain.setSellable(portfolio.getSellable()); //04222014 Fred - convert sellable value
		return portfoliodomain;
	}

}