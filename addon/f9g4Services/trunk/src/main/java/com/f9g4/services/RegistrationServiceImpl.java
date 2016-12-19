package com.f9g4.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdAccepttermsDomain;
import com.f9g4.businessobjects.domain.AdAddressDomain;
import com.f9g4.businessobjects.domain.AdContactsDomain;
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
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.services.CheckUsernameAvailabilityResponse;
import com.f9g4.businessobjects.services.DeleteUserResponse;
import com.f9g4.businessobjects.services.DesignWallBoardInfoDomain;
import com.f9g4.businessobjects.services.DesignerAccountDomain;
import com.f9g4.businessobjects.services.GetAlertsResponse;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetDesignWallBoardInfoResponse;
import com.f9g4.businessobjects.services.GetDesignerAccountResponse;
import com.f9g4.businessobjects.services.GetLatestTermsByUserResponse;
import com.f9g4.businessobjects.services.GetLookupTypeValuesForTypeResponse;
import com.f9g4.businessobjects.services.GetMembershipdetailsResponse;
import com.f9g4.businessobjects.services.GetSeasonYearsResponse;
import com.f9g4.businessobjects.services.GetSecurityQuestionResponse;
import com.f9g4.businessobjects.services.GetTermsConditionsResponse;
import com.f9g4.businessobjects.services.GetUsersListRequest;
import com.f9g4.businessobjects.services.GetUsersListResponse;
import com.f9g4.businessobjects.services.RegisterUserRequest;
import com.f9g4.businessobjects.services.RegisterUserResponse;
import com.f9g4.businessobjects.services.ResetPasswordRequest;
import com.f9g4.businessobjects.services.ResetPasswordResponse;
import com.f9g4.businessobjects.services.SearchUsersRequest;
import com.f9g4.businessobjects.services.SearchUsersResponse;
import com.f9g4.businessobjects.services.SecurityQuestion;
import com.f9g4.businessobjects.services.UpdateAdminRatingRequest;
import com.f9g4.businessobjects.services.UpdateAdminRatingResponse;
import com.f9g4.businessobjects.services.UpdateApproverCommentRequest;
import com.f9g4.businessobjects.services.UpdateApproverCommentResponse;
import com.f9g4.businessobjects.services.UpdateMembershipRequest;
import com.f9g4.businessobjects.services.UpdateMembershipResponse;
import com.f9g4.businessobjects.services.UpdatePasswordRequest;
import com.f9g4.businessobjects.services.UpdatePasswordResponse;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsRequest;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsResponse;
import com.f9g4.businessobjects.services.UpdateUserNameRequest;
import com.f9g4.businessobjects.services.UpdateUserNameResponse;
import com.f9g4.businessobjects.services.UpdateUserRequest;
import com.f9g4.businessobjects.services.UpdateUserResponse;
import com.f9g4.businessobjects.services.UserInfoDomain;
import com.f9g4.businessobjects.services.ValidateSecurityQuestionsRequest;
import com.f9g4.businessobjects.services.ValidateSecurityQuestionsResponse;
import com.f9g4.businessobjects.services.ValidateUserRequest;
import com.f9g4.businessobjects.services.ValidateUserResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.bo.Account;
import com.f9g4.common.bo.DesignWall;
import com.f9g4.common.bo.SearchResults;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.LanguageCodesEnum;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.MessageTypes;
import com.f9g4.common.util.RegistrationStatusEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.dao.AdAcceptTermsDAO;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUserDocumentsDAO;
import com.f9g4.dao.AdUserMembershipsDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.StCategoryMasterDAO;
import com.f9g4.dao.StMemPricingOptionsDAO;
import com.f9g4.dao.StSeasonYearDAO;
import com.f9g4.dao.StTermsConditionsDAO;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.dao.TrMessagesDAO;
import com.f9g4.dao.TrPortfolioDAO;
import com.f9g4.domain.AdAcceptTerms;
import com.f9g4.domain.AdAddresses;
import com.f9g4.domain.AdContacts;
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
import com.f9g4.domain.TrBoardImages;
import com.f9g4.domain.TrBoardSearch;
import com.f9g4.domain.TrMessages;
import com.f9g4.domain.TrPortfolio;
import com.f9g4.services.rest.IRegistrationService;
import com.f9g4.util.DateUtil;
import com.f9g4.util.ModelConverter;
import com.google.common.collect.Lists;

@Service("registerService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class RegistrationServiceImpl implements IRegistrationService {
	
	private static Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	@Autowired
	private AdUsersDAO adUsersDAO;

	@Autowired
	private StTermsConditionsDAO stTermsConditionsDAO; 
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	
	@Autowired
	AdUserMembershipsDAO adUserMembershipsDAO;
	
	@Autowired
	private ModelConverter modelConverter;
	
	@Autowired
	private TrBoardDAO trBoardDAO;
	
	@Autowired
	private AdAcceptTermsDAO adAcceptTermsDAO; 

	@Autowired
	private StCategoryMasterDAO stCategoryMasterDAO;
	
	@Autowired
	private StMemPricingOptionsDAO stMemPricingOptionsDAO;
	
	@Autowired
	private TrPortfolioDAO trPortfolioDAO;
	
	@Autowired
	private AdUserDocumentsDAO adUserDocumentsDAO;
	
	@Autowired @Value("${f9g4.service.search.maxresults}")
	private Integer searchMaxResults;
	
	public RegisterUserResponse registerUser(RegisterUserRequest request) {
		
		RegisterUserResponse response = new RegisterUserResponse();
		Status status = new Status();
		response.setStatus(status);
		
		try{
			AdUsersDomain usersDomain = request.getUser();
			AdUsers userEntity = new AdUsers();
			userEntity.setAboutYou(usersDomain.getAboutYou());
			userEntity.setActiveStatus(usersDomain.getActiveStatus());
			
			//initlize 
			Set<AdAcceptTerms> adAcceptTermses = new  HashSet<AdAcceptTerms>();
			//iterate Accepted Terms Condition..
			List<AdAccepttermsDomain> accepttermsDomains = usersDomain.getAcceptedTermsCondition();
			for (AdAccepttermsDomain adAccepttermsDomain : accepttermsDomains) {	
				StTermsConditions stTermsConditions = stTermsConditionsDAO.findStTermsConditionsByTermCondId(adAccepttermsDomain.getTermConditionId());
				AdAcceptTerms acceptTerms = new AdAcceptTerms(); 
				modelConverter.convertAdAcceptTermsDomainToEntity(adAccepttermsDomain, acceptTerms, stTermsConditions, userEntity, getUserIdForCreatedByAndModifiedBy(), false);
				adAcceptTermses.add(acceptTerms);
			}
			userEntity.setAdAcceptTermses(adAcceptTermses);
			
			Set<AdAddresses> adAddresseses = new HashSet<AdAddresses>();
			List<AdAddressDomain> adAddress =  usersDomain.getAddress();
			for (AdAddressDomain adAddressDomain : adAddress) {
				AdAddresses adAddressesEntity = new AdAddresses();
				//Find the Country code from lookup values..
				AdLookupValues countryLookupValue =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(adAddressDomain.getCountryId());		
				modelConverter.convertAdAddressDomainToEntity(adAddressDomain, adAddressesEntity, countryLookupValue, userEntity, false);
				adAddresseses.add(adAddressesEntity);
			}
			userEntity.setAdAddresseses(adAddresseses);
			
			Set<AdContacts> adContactsSet = new HashSet<AdContacts>();
			List<AdContactsDomain> adContacts = usersDomain.getContacts();
			for (AdContactsDomain adContactsDomain : adContacts) {
				AdContacts adContact = new AdContacts();
				modelConverter.convertAdContactsDomainToEntity(adContactsDomain, adContact, userEntity,  false);
				adContactsSet.add(adContact);
			}
			userEntity.setAdContactses(adContactsSet);
			
			AdLookupValues adLookupValuesByRegStatusId =  adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeCode());
			userEntity.setAdLookupValuesByRegStatusId(adLookupValuesByRegStatusId);
			
			AdLookupValues adLookupValuesBySecurityQuestion1Id =  adLookupValuesDAO.findAdLookupValuesByLookupValueId(usersDomain.getSecurityQuestion1());
			userEntity.setAdLookupValuesBySecurityQuestion1Id(adLookupValuesBySecurityQuestion1Id);
			
			AdLookupValues adLookupValuesBySecurityQuestion2Id =  adLookupValuesDAO.findAdLookupValuesByLookupValueId(usersDomain.getSecurityQuestion2());
			userEntity.setAdLookupValuesBySecurityQuestion2Id(adLookupValuesBySecurityQuestion2Id);
			
			Set<AdUserLanguages> adUserLanguageses = new HashSet<AdUserLanguages>();
			List<AdUserLanguagesDomain> adUserLanguagesDomains = usersDomain.getUserLangs();
			for (AdUserLanguagesDomain adUserLanguagesDomain : adUserLanguagesDomains) {
				AdLookupValues adLookupValuesLang =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(adUserLanguagesDomain.getLangId());
				AdUserLanguages adUserLanguagesEnity = new AdUserLanguages();
				modelConverter.convertAdUserLanguagesDomainToEntity(adUserLanguagesDomain, adUserLanguagesEnity, adLookupValuesLang, userEntity, false);
				adUserLanguageses.add(adUserLanguagesEnity);
			}
			userEntity.setAdUserLanguageses(adUserLanguageses);
			
			Set<AdUserSkills> adUserSkillses = new HashSet<AdUserSkills>();
			List<AdUserSkillsDomain> userSkillsDomains = usersDomain.getUseSkills();
			for (AdUserSkillsDomain adUserSkillsDomain : userSkillsDomains) {
				AdLookupValues adLookupValuesSkill = adLookupValuesDAO.findAdLookupValuesByLookupValueId(adUserSkillsDomain.getSkillId());
				AdUserSkills adUserSkillsEntity = new AdUserSkills();
				modelConverter.convertAdUserSkillsDomainToEntity(adUserSkillsDomain, adUserSkillsEntity, adLookupValuesSkill, userEntity, false);
				adUserSkillses.add(adUserSkillsEntity);			
			}
			userEntity.setAdUserSkillses(adUserSkillses);
			
			//Kamlesh adding new logic for multiple education, expertise, specialities, degaccs
			//************************************************************************************
			
			Set<AdUserEducations> adUserEducations = new HashSet<AdUserEducations>();
			List<AdUserEducationsDomain> adUserEducationsDomain = usersDomain.getEducation();
			for (AdUserEducationsDomain userEducationsDomain : adUserEducationsDomain) {
				if(userEducationsDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
					AdLookupValues educationEntity = new AdLookupValues();
					AdLookupTypes educationType = new AdLookupTypes();
					educationType.setActiveStatus(1);
					educationType.setLookupTypeId(LookupTypeEnum.EDUCATION.getTypeId());
					educationEntity.setLookupValueId(userEducationsDomain.getUserEducationId());
					educationEntity.setAdLookupTypes(educationType); //set lookup type
					educationEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
					educationEntity.setDescription(userEducationsDomain.getOther().toUpperCase());
					educationEntity.setActiveStatus(1);
					educationEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
					educationEntity.setCreatedBy(2);
					educationEntity.setLastUpdateBy(2);
					educationEntity.setCreationDate(Calendar.getInstance());
					educationEntity.setLastUpdateDate(Calendar.getInstance());
					AdLookupValues educationEntity1=adLookupValuesDAO.merge(educationEntity);			
					adLookupValuesDAO.clearAduserlookupvaluesCaches();
					userEducationsDomain.setEducationId(educationEntity1.getLookupValueId());
				}
				AdLookupValues adLookupValuesEducation = adLookupValuesDAO.findAdLookupValuesByLookupValueId(userEducationsDomain.getEducationId());
				AdUserEducations adUserEducationEntity = new AdUserEducations();
				modelConverter.convertAdUserEducationsDomainToEntity(userEducationsDomain, adUserEducationEntity, adLookupValuesEducation, userEntity, false);
				adUserEducations.add(adUserEducationEntity);			
			}
			
			userEntity.setAdUserEducations(adUserEducations);
			
			
			Set<AdUserExpertises> adUserExpertises = new HashSet<AdUserExpertises>();
			List<AdUserExpertisesDomain> adUserExpertisesDomain = usersDomain.getExpertise();
			for (AdUserExpertisesDomain userExpertisesDomain : adUserExpertisesDomain) {
				
				if(userExpertisesDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
					AdLookupValues expertisesEntity = new AdLookupValues();
					AdLookupTypes expertisesType = new AdLookupTypes();
					expertisesType.setActiveStatus(1);
					expertisesType.setLookupTypeId(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeId());
					expertisesEntity.setLookupValueId(userExpertisesDomain.getUserExpertiseId());
					expertisesEntity.setAdLookupTypes(expertisesType); //set lookup type
					expertisesEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
					expertisesEntity.setDescription(userExpertisesDomain.getOther().toUpperCase());
					expertisesEntity.setActiveStatus(1);
					expertisesEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
					expertisesEntity.setCreatedBy(2);
					expertisesEntity.setLastUpdateBy(2);
					expertisesEntity.setCreationDate(Calendar.getInstance());
					expertisesEntity.setLastUpdateDate(Calendar.getInstance());
					AdLookupValues expertisesEntity1=adLookupValuesDAO.merge(expertisesEntity);			
					adLookupValuesDAO.clearAduserlookupvaluesCaches();
					userExpertisesDomain.setExpertiseId(expertisesEntity1.getLookupValueId());
				}
				AdLookupValues adLookupValuesExpertises = adLookupValuesDAO.findAdLookupValuesByLookupValueId(userExpertisesDomain.getExpertiseId());
				AdUserExpertises adUserExpertisesEntity = new AdUserExpertises();
				modelConverter.convertAdUserExpertisesDomainToEntity(userExpertisesDomain, adUserExpertisesEntity, adLookupValuesExpertises, userEntity, false);
				adUserExpertises.add(adUserExpertisesEntity);			
			}
			
			userEntity.setAdUserExpertises(adUserExpertises);
			
			Set<AdUserSpecialities> adUserSpecialities = new HashSet<AdUserSpecialities>();
			List<AdUserSpecialitiesDomain> adUserSpecialitiesDomain = usersDomain.getSpecialty();
			for (AdUserSpecialitiesDomain userSpecialitiesDomain : adUserSpecialitiesDomain) {
				if(userSpecialitiesDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
					AdLookupValues specialitiesEntity = new AdLookupValues();
					AdLookupTypes specialitiesType = new AdLookupTypes();
					specialitiesType.setActiveStatus(1);
					specialitiesType.setLookupTypeId(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeId());
					specialitiesEntity.setLookupValueId(userSpecialitiesDomain.getUserSpecialitiesId());
					specialitiesEntity.setAdLookupTypes(specialitiesType); //set lookup type
					specialitiesEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
					specialitiesEntity.setDescription(userSpecialitiesDomain.getOther().toUpperCase());
					specialitiesEntity.setActiveStatus(1);
					specialitiesEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
					specialitiesEntity.setCreatedBy(2);
					specialitiesEntity.setLastUpdateBy(2);
					specialitiesEntity.setCreationDate(Calendar.getInstance());
					specialitiesEntity.setLastUpdateDate(Calendar.getInstance());
					AdLookupValues specialitiesEntity1=adLookupValuesDAO.merge(specialitiesEntity);			
					adLookupValuesDAO.clearAduserlookupvaluesCaches();
					userSpecialitiesDomain.setSpecialitiesId(specialitiesEntity1.getLookupValueId());
				}
				AdLookupValues adLookupValuesSpecialities = adLookupValuesDAO.findAdLookupValuesByLookupValueId(userSpecialitiesDomain.getSpecialitiesId());
				AdUserSpecialities adUserSpecialitiesEntity = new AdUserSpecialities();
				modelConverter.convertAdUserAdUserSpecialitiesDomainToEntity(userSpecialitiesDomain, adUserSpecialitiesEntity, adLookupValuesSpecialities, userEntity, false);
				adUserSpecialities.add(adUserSpecialitiesEntity);			
			}
			
			userEntity.setAdUserSpecialities(adUserSpecialities);
			
			
			Set<AdUserDegaccs> adUserDegaccs = new HashSet<AdUserDegaccs>();
			List<AdUserDegaccsDomain> adUserDegaccsDomain = usersDomain.getDegAcc();
			for (AdUserDegaccsDomain userDegaccsDomain : adUserDegaccsDomain) {
				if(userDegaccsDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
					AdLookupValues  userDegaccsEntity = new AdLookupValues();
					AdLookupTypes  userDegaccsType = new AdLookupTypes();
					userDegaccsType.setActiveStatus(1);
					userDegaccsType.setLookupTypeId(LookupTypeEnum.EDUCATION.getTypeId());
					userDegaccsEntity.setLookupValueId(userDegaccsDomain.getDegaccsId());
					userDegaccsEntity.setAdLookupTypes(userDegaccsType); //set lookup type
					userDegaccsEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
					userDegaccsEntity.setDescription(userDegaccsDomain.getOther().toUpperCase());
					userDegaccsEntity.setActiveStatus(1);
					userDegaccsEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
					userDegaccsEntity.setCreatedBy(2);
					userDegaccsEntity.setLastUpdateBy(2);
					userDegaccsEntity.setCreationDate(Calendar.getInstance());
					userDegaccsEntity.setLastUpdateDate(Calendar.getInstance());
					AdLookupValues userDegaccsEntity1=adLookupValuesDAO.merge(userDegaccsEntity);			
					adLookupValuesDAO.clearAduserlookupvaluesCaches();
					userDegaccsDomain.setDegaccsId(userDegaccsEntity1.getLookupValueId());
				}
				AdLookupValues adLookupValuesDegaccs = adLookupValuesDAO.findAdLookupValuesByLookupValueId(userDegaccsDomain.getDegaccsId());
				AdUserDegaccs adUserDegaccsEntity = new AdUserDegaccs();
				modelConverter.convertAdUserDegaccsDomainToEntity(userDegaccsDomain, adUserDegaccsEntity, adLookupValuesDegaccs, userEntity, false);
				adUserDegaccs.add(adUserDegaccsEntity);			
			}
			
			userEntity.setAdUserDegaccs(adUserDegaccs);
			
			//***************************************************************************************************
			
			//Add record for additional documents
			/*Set<AdUserDocuments> adUserDocuments = new HashSet<AdUserDocuments>();
			List<AdUserDocumentsDomain> userDocumentsDomains = usersDomain.getUserDocuments();
			for (AdUserDocumentsDomain adUserDocumentsDomain : userDocumentsDomains) {
				AdUserDocuments adUserDocumentsEntity = new AdUserDocuments();
				adUserDocumentsEntity = modelConverter.convertAdUserDocumentsDomainToEntity(adUserDocumentsDomain, userEntity);
				adUserDocuments.add(adUserDocumentsEntity);			
			}
			userEntity.setAdUserDocuments(adUserDocuments);*/
			
			//education. if active status = 2, create a new lookupvalue.
			
			//KAmlesh :: We dont need this logic added OTher logic...................
			//*********************************************************************************************
			
//			if(usersDomain.getEducation()!=null)
//			{
//				List<AdUserEducationsDomain> educationList = usersDomain.getEducation();
//				for (AdUserEducationsDomain educationDomain : educationList) {
//					AdUserEducations educationEntity = new AdUserEducations();
////					userEntity.setEducationId(educationEntity.getUserEducationId());
//					userEntity.setAdUserEducations(adUserEducations);
//					//TODO get the new lookupvalue id
//					educationEntity.setLookupValueId(educationDomain.getLookupValueId());
//					if(educationDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value())
//					{
//						 
//						AdLookupTypes educationType = new AdLookupTypes();
//						educationType.setLookupTypeId(LookupTypeEnum.EDUCATION.getTypeId());
//						modelConverter.convertAdLookupValuesDomainToEntity(educationDomain, educationEntity, educationType);
//						adLookupValuesDAO.clearAduserlookupvaluesCaches(); //clear cache
//						//determine a unique lookup code
//						Integer index=adLookupValuesDAO.findAllAdLookupValuesByLookupType(LookupTypeEnum.EDUCATION.getTypeName()).size()+1;
//						educationEntity.setLookupCode(educationEntity.getLookupCode()+index);
//						educationEntity=adLookupValuesDAO.merge(educationEntity); //insert record
//						adLookupValuesDAO.refresh(educationEntity);
//						userEntity.getEducationId().setLookupValueId(educationEntity.getLookupValueId());
//					}
//					
//				}
//				
//			}
			
			
			//specialty. if active status = 2, create a new lookupvalue.
//			if(usersDomain.getSpecialty()!=null)
//			{
//				AdLookupValuesDomain specialtyDomain = usersDomain.getSpecialty();
//				AdLookupValues specialtyEntity = new AdLookupValues();
//				userEntity.setSpecialtyId(specialtyEntity);
//				specialtyEntity.setLookupValueId(specialtyDomain.getLookupValueId());
//				if(specialtyDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()) //create new lookupvalues
//				{
//					AdLookupTypes specialtyType = new AdLookupTypes();
//					specialtyType.setLookupTypeId(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeId());
//					modelConverter.convertAdLookupValuesDomainToEntity(specialtyDomain, specialtyEntity, specialtyType);
//					adLookupValuesDAO.clearAduserlookupvaluesCaches(); //clear cache
//					//determine a unique lookup code
//					Integer index=adLookupValuesDAO.findAllAdLookupValuesByLookupType(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeName()).size()+1;
//					specialtyEntity.setLookupCode(specialtyEntity.getLookupCode()+index);
//					specialtyEntity=adLookupValuesDAO.merge(specialtyEntity); //insert record
//					adLookupValuesDAO.refresh(specialtyEntity);
//					userEntity.getSpecialtyId().setLookupValueId(specialtyEntity.getLookupValueId());
//				}
//			}
			
			
			//how do you hear about us
			userEntity.setHowDidYouHearAboutUs(usersDomain.getHowDidYouHearAboutUs());
			
			userEntity.setCompanyName(usersDomain.getCompanyname());
			userEntity.setCompanyWebsite(usersDomain.getCompanywebsite());
			userEntity.setFirstname(usersDomain.getFirstname());
			userEntity.setLangCode(usersDomain.getLangCode());
			userEntity.setLastname(usersDomain.getLastname());
			userEntity.setUseProfilename(usersDomain.getUseProfilename());
			
			long randomNum = DateUtil.randomNumber();
			Set<AdUsers> users = adUsersDAO.findAdUsersByProfileName(usersDomain.getProfilename()+ " " +String.valueOf(randomNum));
			int count = users.size();
			
			/* Checks for a unique seven digit number. If it fails in 5000 then we might have to increase 
			 the digit to 16 digit  
			 */
			
			for (int i=0; i < 5000 ; i++) {
				 randomNum = DateUtil.randomNumber();
				 count = adUsersDAO.findAdUsersByProfileName(usersDomain.getProfilename()+ " " +String.valueOf(randomNum)).size();
				 if (count == 0 ) break;								 
			}
			
			if (count != 0){
				logger.error("No Unique number found ");				
			} else {					
				userEntity.setProfilename(usersDomain.getProfilename()+ " " +String.valueOf(randomNum));
			}
			
			Calendar today = Calendar.getInstance();
			
			userEntity.setCreatedBy(usersDomain.getCreatedby());
			userEntity.setCreationDate(today);
			userEntity.setLastUpdatedBy(usersDomain.getLastupdateby());
			userEntity.setLastUpdateDate(today);
			
			userEntity.setLogoImageUrl(usersDomain.getLogoimageurl());
			userEntity.setPassword(usersDomain.getPassword());
			userEntity.setSchoolAwards(usersDomain.getSchoolawards());
			userEntity.setSecurityAnswer1(usersDomain.getSecurityAnswer1());
			userEntity.setSecurityAnswer2(usersDomain.getSecurityAnswer2());
			userEntity.setTaxId(usersDomain.getTaxid());
			userEntity.setUserName(usersDomain.getUserName());
			userEntity.setTempPassword(usersDomain.getIsTempPassword());
			userEntity.setAdminRating(new BigDecimal(usersDomain.getAdminRating())); //04172014 Fred - setup admin rating
			AdLookupValues userType = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(usersDomain.getUserType());
			userEntity.setAdLookupValuesByUserTypeId(userType);
			AdUsers userEntityReturn = adUsersDAO.merge(userEntity);
			
			
			
			//AdLookupValues userType  = userEntityReturn.getAdLookupValuesByUserTypeId();
			
			//right now we have only standerd
			StMemPricingOptions stMemPricingOptions  = stMemPricingOptionsDAO.findStMemPricingOptionsByUserTypeAndMembershipType(userType.getLookupCode()
										, LookupTypeValueEnum.MEMEBERSHIP_TYPE_STANDARD.getTypeCode());
			
			//create membership 
			Calendar yesterday = Calendar.getInstance();
			yesterday.add(Calendar.DATE, -1);
			AdUserMemberships adUserMemberships = new AdUserMemberships();
			//set payment due as yesterday..
			adUserMemberships.setAdLookupValues(adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_DUE.getTypeCode()));
			adUserMemberships.setAdUsers(userEntityReturn);
			adUserMemberships.setAutopay(0);//
			adUserMemberships.setAutopayWithdrawDay(0);
			adUserMemberships.setCreatedBy(userEntityReturn.getUserId());
			adUserMemberships.setCreationDate(today);
			adUserMemberships.setEffectiveDate(yesterday);//yesterday
			adUserMemberships.setExpirationDate(yesterday);
			adUserMemberships.setLastUpdateDate(today);
			adUserMemberships.setLastUpdatedBy(userEntityReturn.getUserId());
			//stMemPricingOptions
			adUserMemberships.setStMemPricingOptions(stMemPricingOptions);
			adUserMembershipsDAO.merge(adUserMemberships);
			
			usersDomain.setUserId(userEntityReturn.getUserId());
			
			response.setUser(usersDomain);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		}catch(Exception ex){
			logger.error("Exception Occurred", ex);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());		
		}
		return response;
	}
	
	public ViewUserResponse viewUser(int userId) {
		AdUsers adUsers = adUsersDAO.findAdUsersByUserId(userId);
		AdUsersDomain adUsersDomain = new AdUsersDomain();	
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		try {
			//conver Entity to domain object
			modelConverter.convertAdUsersEntityToDomain(adUsers, adUsersDomain);
			//conver Entity associations to domain object
			modelConverter.convertAdUsersEntityAssociationsToDomain(adUsers, adUsersDomain);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		ViewUserResponse viewUserResponse = ModelConverter.svcObjFactory.createViewUserResponse();
		viewUserResponse.setUser(adUsersDomain);
		viewUserResponse.setStatus(status);
		return viewUserResponse;
	}


	public ViewUserResponse viewUserByUserName(String userName) {
		AdUsers adUsers = adUsersDAO.findAdUsersByUserNameSingleResult(userName);
		AdUsersDomain adUsersDomain = new AdUsersDomain();
		ViewUserResponse viewUserResponse = ModelConverter.svcObjFactory.createViewUserResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		viewUserResponse.setStatus(status);
		try {
			//conver Entity to domain object
			modelConverter.convertAdUsersEntityToDomain(adUsers, adUsersDomain);
			//conver Entity associations to domain object
			modelConverter.convertAdUsersEntityAssociationsToDomain(adUsers, adUsersDomain);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		viewUserResponse.setUser(adUsersDomain);
		return viewUserResponse;
	}

	public UpdateUserResponse updateUser(UpdateUserRequest request) {
		
		UpdateUserResponse response = ModelConverter.svcObjFactory.createUpdateUserResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			
			Calendar today = Calendar.getInstance();
			
			AdUsersDomain user = request.getUser();
			
			AdLookupValues adLookupValuesBySecurityQuestion1Id =  adLookupValuesDAO.findAdLookupValuesByLookupValueId(user.getSecurityQuestion1());
			AdLookupValues adLookupValuesBySecurityQuestion2Id =  adLookupValuesDAO.findAdLookupValuesByLookupValueId(user.getSecurityQuestion2());
			
			AdUsers userEntity = adUsersDAO.findAdUsersByUserId(user.getUserId());
			userEntity.setAboutYou(user.getAboutYou());
			userEntity.setActiveStatus(user.getActiveStatus());
			userEntity.setCompanyName(user.getCompanyname());
			userEntity.setCompanyWebsite(user.getCompanywebsite());
			userEntity.setFirstname(user.getFirstname());
			userEntity.setLangCode(user.getLangCode());
			userEntity.setLastname(user.getLastname());
			userEntity.setLastUpdatedBy(user.getLastupdateby());
			userEntity.setLogoImageUrl(user.getLogoimageurl());
			userEntity.setPassword(user.getPassword());
			userEntity.setSchoolAwards(user.getSchoolawards());
			userEntity.setSecurityAnswer1(user.getSecurityAnswer1());
			userEntity.setSecurityAnswer2(user.getSecurityAnswer2());
			userEntity.setTaxId(user.getTaxid());
			userEntity.setUserName(user.getUserName());
			userEntity.setLastUpdateDate(today);
			userEntity.setAdLookupValuesBySecurityQuestion1Id(adLookupValuesBySecurityQuestion1Id);
			userEntity.setAdLookupValuesBySecurityQuestion2Id(adLookupValuesBySecurityQuestion2Id);
			userEntity.setTempPassword(user.getIsTempPassword());
			userEntity.setAdminRating(new BigDecimal(user.getAdminRating()));

			Set<AdUserLanguages> adUsersLanguagesEnitiySet = userEntity.getAdUserLanguageses();
			HashMap<Integer,AdUserLanguages> LanguageIds = new HashMap<Integer, AdUserLanguages>();
			//Setting all the languages in the database to zero in the meantime 
			//capturing the reference in the hash map for status updates if language is present already
			for (AdUserLanguages adUserLanguages : adUsersLanguagesEnitiySet) {
				LanguageIds.put(adUserLanguages.getAdLookupValues().getLookupValueId(),adUserLanguages);
				adUserLanguages.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			}
			List<AdUserLanguagesDomain> requestLaguages =  request.getUser().getUserLangs();
			for (AdUserLanguagesDomain adUserLanguagesDomain : requestLaguages) {
				Integer curLangId = adUserLanguagesDomain.getLangId();
				if(LanguageIds.containsKey(curLangId))
					LanguageIds.get(curLangId).setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				else
				{
					AdLookupValues adLookupValuesLang =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(curLangId);
					AdUserLanguages adUserLanguagesEnity = new AdUserLanguages();
					adUserLanguagesDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					modelConverter.convertAdUserLanguagesDomainToEntity(adUserLanguagesDomain, adUserLanguagesEnity, adLookupValuesLang, userEntity, false);
					adUsersLanguagesEnitiySet.add(adUserLanguagesEnity);
				}
			}
		
			Set<AdUserSkills> adUsersSkillsEnitiySet = userEntity.getAdUserSkillses();
			HashMap<Integer,AdUserSkills> SkillIds = new HashMap<Integer, AdUserSkills>();
			for (AdUserSkills adUserSkills : adUsersSkillsEnitiySet) {
				SkillIds.put(adUserSkills.getAdLookupValues().getLookupValueId(), adUserSkills);
					adUserSkills.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			}
			List<AdUserSkillsDomain> requestSkills = request.getUser().getUseSkills();
			for (AdUserSkillsDomain adUserSkillsDomain : requestSkills) {
				Integer skillId = adUserSkillsDomain.getSkillId();
				if(SkillIds.containsKey(skillId))
					SkillIds.get(skillId).setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				else
				{
					AdLookupValues adLookupValuesSkill =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(skillId);
					AdUserSkills adUserSkillsEnity = new AdUserSkills();
					adUserSkillsDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					modelConverter.convertAdUserSkillsDomainToEntity(adUserSkillsDomain, adUserSkillsEnity, adLookupValuesSkill, userEntity, false);
					adUsersSkillsEnitiySet.add(adUserSkillsEnity);		
				}
					
			}
			
			Set<AdUserEducations> adUsersEducationsEnitiySet = userEntity.getAdUserEducations();
			HashMap<Integer,AdUserEducations> educationsId = new HashMap<Integer, AdUserEducations>();
			for (AdUserEducations adUserEducations : adUsersEducationsEnitiySet) {
				educationsId.put(adUserEducations.getAdLookupValues().getLookupValueId(), adUserEducations);
				adUserEducations.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			}
			List<AdUserEducationsDomain> requestEducations = request.getUser().getEducation();
			for (AdUserEducationsDomain adUserEducationDomain : requestEducations) {
				Integer educationId = adUserEducationDomain.getEducationId();
				if(educationsId.containsKey(educationId))
					educationsId.get(educationId).setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				else
				{
					AdUserEducations adUserEducationEnity = new AdUserEducations();
					if(adUserEducationDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
						AdLookupValues educationEntity = new AdLookupValues();
						AdLookupTypes educationType = new AdLookupTypes();
						educationType.setActiveStatus(1);
						educationType.setLookupTypeId(LookupTypeEnum.EDUCATION.getTypeId());
						educationEntity.setLookupValueId(adUserEducationDomain.getUserEducationId());
						educationEntity.setAdLookupTypes(educationType); //set lookup type
						educationEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
						educationEntity.setDescription(adUserEducationDomain.getOther().toUpperCase());
						educationEntity.setActiveStatus(1);
						educationEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
						educationEntity.setCreatedBy(2);
						educationEntity.setLastUpdateBy(2);
						educationEntity.setCreationDate(Calendar.getInstance());
						educationEntity.setLastUpdateDate(Calendar.getInstance());
						AdLookupValues educationEntity1=adLookupValuesDAO.merge(educationEntity);			
						adLookupValuesDAO.clearAduserlookupvaluesCaches();
						adLookupValuesDAO.clearAduserlookupvaluesByLookupTypeCaches();
						adUserEducationDomain.setEducationId(educationEntity1.getLookupValueId());
						modelConverter.convertAdUserEducationsDomainToEntity(adUserEducationDomain, adUserEducationEnity, educationEntity1, userEntity, false);
					}
					else
					{
						AdLookupValues adLookupValuesEducation =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(educationId);
						adUserEducationDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
						modelConverter.convertAdUserEducationsDomainToEntity(adUserEducationDomain, adUserEducationEnity, adLookupValuesEducation, userEntity, false);
					}
					adUsersEducationsEnitiySet.add(adUserEducationEnity);
				}
					
			}
			
			Set<AdUserExpertises> adUsersExpertisesEnitiySet = userEntity.getAdUserExpertises();
			HashMap<Integer,AdUserExpertises> expertisesId = new HashMap<Integer, AdUserExpertises>();
			for (AdUserExpertises adUserExpertise : adUsersExpertisesEnitiySet) {
				expertisesId.put(adUserExpertise.getAdLookupValues().getLookupValueId(), adUserExpertise);
				adUserExpertise.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			}
			List<AdUserExpertisesDomain> requestExpertise = request.getUser().getExpertise();
			for (AdUserExpertisesDomain adUserExpertiseDomain : requestExpertise) {
				Integer expertiseId = adUserExpertiseDomain.getExpertiseId();
				if(expertisesId.containsKey(expertiseId))
					expertisesId.get(expertiseId).setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				else
				{
					AdUserExpertises adUserExpertiseEnity = new AdUserExpertises();
					if(adUserExpertiseDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
						AdLookupValues expertisesEntity = new AdLookupValues();
						AdLookupTypes expertisesType = new AdLookupTypes();
						expertisesType.setActiveStatus(1);
						expertisesType.setLookupTypeId(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeId());
						expertisesEntity.setLookupValueId(adUserExpertiseDomain.getUserExpertiseId());
						expertisesEntity.setAdLookupTypes(expertisesType); //set lookup type
						expertisesEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
						expertisesEntity.setDescription(adUserExpertiseDomain.getOther().toUpperCase());
						expertisesEntity.setActiveStatus(1);
						expertisesEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
						expertisesEntity.setCreatedBy(2);
						expertisesEntity.setLastUpdateBy(2);
						expertisesEntity.setCreationDate(Calendar.getInstance());
						expertisesEntity.setLastUpdateDate(Calendar.getInstance());
						AdLookupValues expertisesEntity1=adLookupValuesDAO.merge(expertisesEntity);			
						adLookupValuesDAO.clearAduserlookupvaluesCaches();
						adLookupValuesDAO.clearAduserlookupvaluesByLookupTypeCaches();
						adUserExpertiseDomain.setExpertiseId(expertisesEntity1.getLookupValueId());
						modelConverter.convertAdUserExpertisesDomainToEntity(adUserExpertiseDomain, adUserExpertiseEnity, expertisesEntity1, userEntity, false);
					}
					else
					{
						AdLookupValues adLookupValuesEducation =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(expertiseId);
						adUserExpertiseDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
						modelConverter.convertAdUserExpertisesDomainToEntity(adUserExpertiseDomain, adUserExpertiseEnity, adLookupValuesEducation, userEntity, false);
					}
					adUsersExpertisesEnitiySet.add(adUserExpertiseEnity);		
				}
					
			}
			
			
			Set<AdUserSpecialities> adUsersSpecialitiesEnitiySet = userEntity.getAdUserSpecialities();
			HashMap<Integer,AdUserSpecialities> specialitiesId = new HashMap<Integer, AdUserSpecialities>();
			for (AdUserSpecialities adUserSpecialities : adUsersSpecialitiesEnitiySet) {
				specialitiesId.put(adUserSpecialities.getAdLookupValues().getLookupValueId(), adUserSpecialities);
				adUserSpecialities.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			}
			List<AdUserSpecialitiesDomain> requestSpecialities = request.getUser().getSpecialty();
			for (AdUserSpecialitiesDomain adUserSpecialitiesDomain : requestSpecialities) {
				Integer specialityId = adUserSpecialitiesDomain.getSpecialitiesId();
				if(specialitiesId.containsKey(specialityId))
					specialitiesId.get(specialityId).setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				else
				{
					AdUserSpecialities adUserSpecialitiesEnity = new AdUserSpecialities();
					if(adUserSpecialitiesDomain.getActiveStatus()==ActiveStatusEnum.OTHERS.value()){
						AdLookupValues specialitiesEntity = new AdLookupValues();
						AdLookupTypes specialitiesType = new AdLookupTypes();
						specialitiesType.setActiveStatus(1);
						specialitiesType.setLookupTypeId(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeId());
						specialitiesEntity.setLookupValueId(adUserSpecialitiesDomain.getUserSpecialitiesId());
						specialitiesEntity.setAdLookupTypes(specialitiesType); //set lookup type
						specialitiesEntity.setLookupCode(UUID.randomUUID().toString()); //Should be unique value
						specialitiesEntity.setDescription(adUserSpecialitiesDomain.getOther().toUpperCase());
						specialitiesEntity.setActiveStatus(1);
						specialitiesEntity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
						specialitiesEntity.setCreatedBy(2);
						specialitiesEntity.setLastUpdateBy(2);
						specialitiesEntity.setCreationDate(Calendar.getInstance());
						specialitiesEntity.setLastUpdateDate(Calendar.getInstance());
						AdLookupValues specialitiesEntity1=adLookupValuesDAO.merge(specialitiesEntity);			
						adLookupValuesDAO.clearAduserlookupvaluesCaches();
						adLookupValuesDAO.clearAduserlookupvaluesByLookupTypeCaches();
						adUserSpecialitiesDomain.setSpecialitiesId(specialitiesEntity1.getLookupValueId());
						modelConverter.convertAdUserAdUserSpecialitiesDomainToEntity(adUserSpecialitiesDomain,adUserSpecialitiesEnity,  specialitiesEntity1, userEntity, false);
					}
					else
					{
						AdLookupValues adLookupValuesSpeciality =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(specialityId);
						adUserSpecialitiesDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
						modelConverter.convertAdUserAdUserSpecialitiesDomainToEntity(adUserSpecialitiesDomain,adUserSpecialitiesEnity,  adLookupValuesSpeciality, userEntity, false);
					}
					adUsersSpecialitiesEnitiySet.add(adUserSpecialitiesEnity);		
				}
					
			}
			
			Set<AdUserDegaccs> adUsersDegaccsEnitiySet = userEntity.getAdUserDegaccs();
			HashMap<Integer,AdUserDegaccs> degaccsId = new HashMap<Integer, AdUserDegaccs>();
			for (AdUserDegaccs adUserDegaccs : adUsersDegaccsEnitiySet) {
				degaccsId.put(adUserDegaccs.getAdLookupValues().getLookupValueId(), adUserDegaccs);
				adUserDegaccs.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			}
			List<AdUserDegaccsDomain> requestDegaccs = request.getUser().getDegAcc();
			for (AdUserDegaccsDomain adUserDegaccsDomain : requestDegaccs) {
				Integer degaccId = adUserDegaccsDomain.getDegaccsId();
				if(degaccsId.containsKey(degaccId))
					degaccsId.get(degaccId).setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				else
				{
					AdLookupValues adLookupValuesEducation =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(degaccId);
					AdUserDegaccs adUserDegaccsEnity = new AdUserDegaccs();
					adUserDegaccsDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					modelConverter.convertAdUserDegaccsDomainToEntity(adUserDegaccsDomain, adUserDegaccsEnity, adLookupValuesEducation, userEntity, false);
					adUsersDegaccsEnitiySet.add(adUserDegaccsEnity);		
				}
					
			}
		
			//address is always update..
			AdAddresses adAddressesActive = null;
			Set<AdAddresses> adAddressesEnititySet =  userEntity.getAdAddresseses();
			if(null != adAddressesEnititySet && adAddressesEnititySet.size() > 0){
				adAddressesActive = adAddressesEnititySet.iterator().next();//get first item..
			}
			
			List<AdAddressDomain> adAddress =  user.getAddress();
			AdAddressDomain adAddressDomain = adAddress.get(0); // we will get only one address for update.
			
			if(null == adAddressesActive){
				// add new active address..			
				AdLookupValues countryLookupValue =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(adAddressDomain.getCountryId());		
				AdAddresses adAddressesEntity = new AdAddresses();
				modelConverter.convertAdAddressDomainToEntity(adAddressDomain, adAddressesEntity, countryLookupValue, userEntity, false);
				adAddressesEnititySet.add(adAddressesEntity);
			}else{
				//update active address..
				AdLookupValues countryLookupValue =  adLookupValuesDAO.findAdLookupValuesByPrimaryKey(adAddressDomain.getCountryId());
				modelConverter.convertAdAddressDomainToEntity(adAddressDomain, adAddressesActive, countryLookupValue, userEntity, true);
			}
			
			
			//Contact is always update..
			Set<AdContacts> adContactsEntitySet = userEntity.getAdContactses();
			//get active address
			AdContacts adContactsActive = null;
			if(adContactsEntitySet.size() > 0){
				adContactsActive = adContactsEntitySet.iterator().next();// assuming we always have only one contact.
			}
			
			List<AdContactsDomain> adContactsDomainsList =  user.getContacts();
			AdContactsDomain adContactsDomain  = adContactsDomainsList.get(0); // we will get only one contact for update.
			
			if(null == adContactsActive){
				// add new 			
				adContactsActive = new AdContacts();
				modelConverter.convertAdContactsDomainToEntity(adContactsDomain, adContactsActive, userEntity,  false);
				adContactsEntitySet.add(adContactsActive);
			}else{
				//update 
				modelConverter.convertAdContactsDomainToEntity(adContactsDomain, adContactsActive, userEntity,  true);
			}
			
			//update new columns
			//education. (Needs to handle Others value)
//			if(user.getEducation()!=null)
//			{
//				AdLookupValuesDomain educationDomain = user.getEducation();
//				AdLookupTypes educationType = new AdLookupTypes();
//				educationType.setLookupTypeId(LookupTypeEnum.EDUCATION.getTypeId());
//				AdLookupValues educationEntity = new AdLookupValues();
//				if(userEntity.getEducationId() != null)
//					educationEntity.setLookupValueId(userEntity.getEducationId().getLookupValueId()); //use the same valueId to update the description
//				modelConverter.convertAdLookupValuesDomainToEntity(educationDomain, educationEntity, educationType);
//				if(educationDomain.getActiveStatus() == ActiveStatusEnum.OTHERS.value()) //update or insert adlookupvalues table
//				{
//					if(educationDomain.getLookupValueId() == 0) //Generate lookupcode
//					{	
//						adLookupValuesDAO.clearAduserlookupvaluesCaches(); //clear cache
//						//determine a unique lookup code
//						Integer index=adLookupValuesDAO.findAllAdLookupValuesByLookupType(LookupTypeEnum.EDUCATION.getTypeName()).size()+1;
//						educationEntity.setLookupCode(educationEntity.getLookupCode()+index); //update lookup code with new index
//					}
//					educationEntity=adLookupValuesDAO.merge(educationEntity);
//					adLookupValuesDAO.refresh(educationEntity); //get lookupvalue id
//				}
//				userEntity.setEducationId(educationEntity);
//			}
//			else
//			{
//				userEntity.setEducationId(null);
//			}
			
			//specialty (Needs to handle Others value)
//			if(user.getSpecialty()!=null)
//			{
//				AdLookupValuesDomain specialtyDomain = user.getSpecialty();
//				AdLookupTypes specailtyType = new AdLookupTypes();
//				specailtyType.setLookupTypeId(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeId());
//				AdLookupValues specialtyEntity = new AdLookupValues();
//				if(userEntity.getSpecialtyId() != null)
//					specialtyEntity.setLookupValueId(userEntity.getSpecialtyId().getLookupValueId()); //use the same valueId to update the description
//				modelConverter.convertAdLookupValuesDomainToEntity(specialtyDomain, specialtyEntity, specailtyType);
//				if(specialtyDomain.getActiveStatus() == ActiveStatusEnum.OTHERS.value()) //update or insert adlookupvalues table
//				{
//					if(specialtyDomain.getLookupValueId() == 0) //Generate lookupcode
//					{	
//						adLookupValuesDAO.clearAduserlookupvaluesCaches(); //clear cache
//						//determine a unique lookup code
//						Integer index=adLookupValuesDAO.findAllAdLookupValuesByLookupType(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeName()).size()+1;
//						specialtyEntity.setLookupCode(specialtyEntity.getLookupCode()+index); //update lookup code with new index
//					}
//					specialtyEntity=adLookupValuesDAO.merge(specialtyEntity);
//					adLookupValuesDAO.refresh(specialtyEntity); //get lookupvalue id
//				}
//				userEntity.setSpecialtyId(specialtyEntity);
//			}
//			else
//			{
//				userEntity.setSpecialtyId(null);
//			}
//			
			//expertise (Needs to handle Others value)
//			if(user.getExpertise()!=null)
//			{
//				AdLookupValuesDomain expertiseDomain = user.getExpertise();
//				AdLookupTypes expertiseType = new AdLookupTypes();
//				expertiseType.setLookupTypeId(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeId());
//				AdLookupValues expertiseEntity = new AdLookupValues();
//				if(userEntity.getExpertiseId() != null)
//					expertiseEntity.setLookupValueId(userEntity.getExpertiseId().getLookupValueId()); //use the same valueId to update the description
//				modelConverter.convertAdLookupValuesDomainToEntity(expertiseDomain, expertiseEntity, expertiseType);
//				if(expertiseDomain.getActiveStatus() == ActiveStatusEnum.OTHERS.value()) //update or insert adlookupvalues table
//				{
//					if(expertiseDomain.getLookupValueId() == 0) //Generate lookupcode
//					{	
//						adLookupValuesDAO.clearAduserlookupvaluesCaches(); //clear cache
//						//determine a unique lookup code
//						Integer index=adLookupValuesDAO.findAllAdLookupValuesByLookupType(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeName()).size()+1;
//						expertiseEntity.setLookupCode(expertiseEntity.getLookupCode()+index); //update lookup code with new index
//					}
//					expertiseEntity=adLookupValuesDAO.merge(expertiseEntity);
//					adLookupValuesDAO.refresh(expertiseEntity); //get lookupvalue id
//				}
//				userEntity.setExpertiseId(expertiseEntity);
//			}
//			else
//			{
//				userEntity.setExpertiseId(null);
//			}
//			
			//degree
//			userEntity.setDegAccId(null);
//			if(user.getDegAcc()!=null)
//			{
//				AdLookupValues degAcc = new AdLookupValues();
//				modelConverter.convertAdLookupValuesDomainToEntity(user.getDegAcc(),degAcc,null);
//				userEntity.setDegAccId(degAcc);
//			}
//			
			//year of experience
			userEntity.setYrsExpId(null);
			if(user.getYrsExp()!=null)
			{
				AdLookupValues yrsExp = new AdLookupValues();
				modelConverter.convertAdLookupValuesDomainToEntity(user.getYrsExp(),yrsExp,null);
				userEntity.setYrsExpId(yrsExp);
			}
			
			//companies worked
			userEntity.setCompaniesWorked(user.getCompaniesWorked());
			
			//update additional documents
			Set<AdUserDocuments> adUserDocumentsEntitySet = userEntity.getAdUserDocuments();
			//get active document
			AdUserDocuments userDoc = null;
			if(adUserDocumentsEntitySet.size() > 0)
				userDoc = adUserDocumentsEntitySet.iterator().next();
			
			adUserDocumentsEntitySet.clear();
			List<AdUserDocumentsDomain> adUserDocumentsDomains = user.getUserDocuments();
			if(adUserDocumentsDomains.size()>0)
			{
				AdUserDocumentsDomain item = adUserDocumentsDomains.get(0);
				if(userDoc!=null) //already have record in database
				{
					item.setDocId(userDoc.getDocId());
					userDoc = modelConverter.convertAdUserDocumentsDomainToEntity(item,userEntity);
				}
				else //create new record
				{
					userDoc = new AdUserDocuments();
					userDoc = modelConverter.convertAdUserDocumentsDomainToEntity(item,userEntity);
				}
				adUserDocumentsEntitySet.add(userDoc);
			}
			else //no record updated
			{
				if(userDoc!=null) //deleted the current record
				{
					adUserDocumentsEntitySet.clear();
					//remove record
					adUserDocumentsDAO.remove(userDoc);
				}
			}
			
			AdUsers newUserEntity = adUsersDAO.merge(userEntity);
			adUsersDAO.flush();
			adUsersDAO.refresh(newUserEntity);
            AdUsersDomain adUsersDomain = new AdUsersDomain();
            modelConverter.convertAdUsersEntityToDomain(newUserEntity, adUsersDomain);
            modelConverter.convertAdUsersEntityAssociationsToDomain(newUserEntity, adUsersDomain);
            response.setUser(adUsersDomain); 
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}

	public DeleteUserResponse deleteUser(int userId) {
		DeleteUserResponse deleteUserResponse = ModelConverter.svcObjFactory.createDeleteUserResponse();
		Status status = new Status();
		deleteUserResponse.setStatus(status);
		try{
			AdUsers adUsers = adUsersDAO.findAdUsersByUserId(userId);
			adUsers.setActiveStatus(ActiveStatusEnum.INACTIVE.value());
			adUsersDAO.merge(adUsers);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return deleteUserResponse;
	}

	public UpdateUserNameResponse updateUserName(UpdateUserNameRequest request) {
		UpdateUserNameResponse updateUserNameResponse = ModelConverter.svcObjFactory.createUpdateUserNameResponse();
		Status status = new Status();
		updateUserNameResponse.setStatus(status);
		
		AdUsers adUsers = adUsersDAO.findAdUsersByUserId(request.getUserId());
		//if user neme is same as existing username ? 
		//if new user name is empty?  
		Set<AdUsers> adUserSet = adUsersDAO.findAdUsersByUserName(request.getNewUserName());
		if(adUserSet.size() == 0){
			//success 
			adUsers.setUserName(request.getNewUserName());
			adUsersDAO.merge(adUsers);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());//scuccess
		}else{
			//Failed - user name exists in the system.
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return updateUserNameResponse;
	}

	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request) {
		UpdatePasswordResponse updatePasswordResponse = ModelConverter.svcObjFactory.createUpdatePasswordResponse();
		Status status = new Status();
		updatePasswordResponse.setStatus(status);
		try{
			AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(request.getUserId());
			adUsers.setPassword(request.getNewPassword());
			adUsersDAO.merge(adUsers);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());//success
		}catch(Exception ex){
			logger.error("Exception Occurred", ex);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}	
		return updatePasswordResponse;
	}

	/**
	 * 
	 */
	public ValidateUserResponse validateUser(ValidateUserRequest request) {
		ValidateUserResponse validateUserResponse = ModelConverter.svcObjFactory.createValidateUserResponse();
		Status status = new Status();
		AdUsersDomain adUserDomain = new AdUsersDomain();
		validateUserResponse.setStatus(status);
		try {
			if(StringUtils.isEmpty(request.getUserName()) || StringUtils.isEmpty(request.getPassword())){
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_LOGIN_INVALID_INPUT.getCode());
			}else{
				AdUsers adusers = adUsersDAO.findAdUsersByUserNameSingleResult(request.getUserName());
				if(null == adusers){
					status.setStatuscode(StatusCodesEnum.STATUS_ERR_USER_NOT_FOUND.getCode());
				}else{

					if(request.getPassword().equals(adusers.getPassword())){					
						modelConverter.convertAdUsersEntityToDomain(adusers, adUserDomain);
						//conver Entity associations to domain object
						modelConverter.convertAdUsersEntityAssociationsToDomain(adusers, adUserDomain);

						validateUserResponse.setUser(adUserDomain);
						//Setting the default value so that the system can change the data after checking the params
						validateUserResponse.setMembershipExprired(false);

						//only reg status of CD or SBSC can pass the logic. Other status will return error code below.
						if(adusers.getAdLookupValuesByRegStatusId().getLookupValueId()==RegistrationStatusEnum.CF.value())
						{
							//user has completed the registration but has not signed up for the membership
							//have to redirect to the membership page
							validateUserResponse.setMembershipExprired(true);
						}
						
						else if(adusers.getAdLookupValuesByRegStatusId().getLookupValueId()==RegistrationStatusEnum.WC.value())
						{
							//user has signed up but is waiting for the confiramtion 
							//gotta give him a login failure but then he should be giveb a info sayinf that 
							//customer support is looking into his profile and will be update shortly
							//12102013 - If the user submit the samples completed, should have the same logic.
							//01082013 - remove the logic updated at 12102013
							status.setStatuscode(StatusCodesEnum.STATUS_ERR_REGISTRATION_VETTING_PROCESS.getCode());
							return validateUserResponse;
						}
						
						else if(adusers.getAdLookupValuesByRegStatusId().getLookupValueId()!=RegistrationStatusEnum.CD.value() && !adusers.getAdLookupValuesByRegStatusId().getLookupCode().equals(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeCode()))
						{
							//Sorry this userid is not authorized to use our system
							status.setStatuscode(StatusCodesEnum.STATUS_ERR_REGISTRATION_DENIED.getCode());
							return validateUserResponse;
						}
						
						//check membership
						//designer with examples submission complete status do not need to check membership. Allow them to login but with limited access
						if(!(adusers.getAdLookupValuesByUserTypeId().getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && adusers.getAdLookupValuesByRegStatusId().getLookupCode().equals(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeCode())))
						{
							Set<AdUserMemberships> userMemberships = adusers.getAdUserMembershipset();
							AdUserMemberships currentMembership = userMemberships.iterator().next();
							//check for membership only incase of membershipexpired flag has not been set
							if(currentMembership!=null && validateUserResponse.isMembershipExprired()==false)
							{
								Calendar cal = Calendar.getInstance();
								Date todaysdate = cal.getTime();
								//if expiration date is greater than the current date set the membership status to expired
								if(currentMembership.getExpirationDate().getTime().before(todaysdate))
								{
									validateUserResponse.setMembershipExprired(true);
								}
							}
							else
							{
								//membership not found shouldn't happen since there is atleast a expired membership  
							}
						}
						
						//check accepted terms
						//only the approved user we check the registration terms the have accepted.
						boolean isExpired = false;
						if(adusers.getAdLookupValuesByRegStatusId().getLookupCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()))
						{
							Set<AdAcceptTerms> adAcceptTermsesSet = adusers.getAdAcceptTermses();
							if(null != adAcceptTermsesSet && adAcceptTermsesSet.size() ==0){
								//not accepted any terms and conditions..
								logger.debug("User didn't acceppted t and c.");
								isExpired =true;
							}else{
								isExpired =true;
								for (AdAcceptTerms adAcceptTerms : adAcceptTermsesSet) {
									if( null!=adAcceptTerms.getStTermsConditions() && null != adAcceptTerms.getStTermsConditions().getAdLookupValuesByTermTypeId() 
											&&  LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode().equals(adAcceptTerms.getStTermsConditions().getAdLookupValuesByTermTypeId().getLookupCode())){
										
										if(adAcceptTerms.getStTermsConditions().getExpirationDate() == null || 
												adAcceptTerms.getStTermsConditions().getExpirationDate().compareTo(Calendar.getInstance()) > 0){
											logger.debug("accepted t and c expired on {} ", adAcceptTerms.getStTermsConditions().getExpirationDate() );
											isExpired =false;
											break;
										}
									}
								}							
							}
						}
						
						validateUserResponse.setTermsExprired(isExpired);
						
						//if the accepted terms and conditions are expired get the latest terms and conditions.						
						if(isExpired){
							// get the latest terms and conditions by user type
							Set<StTermsConditions> stTermsConditions = stTermsConditionsDAO.findActiveStTermsConditionsByUserTypeAndTermType(
									adUserDomain.getUserType(), LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode());
							//if the set is null or empty, throw the exception
							if(null != stTermsConditions && stTermsConditions.size() > 0) {
								for(StTermsConditions item : stTermsConditions)
									validateUserResponse.setLatestTermsId(item.getTermCondId());
								status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());//0 for success..
							}
							else {
								status.setStatuscode(StatusCodesEnum.STATUS_ERR_NO_ACTIVE_TERMS.getCode());
								status.setDescription("Cannot find active terms");
							}
						}
						else {
							status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());//0 for success..
						}
					}else{
						//authentication failed 
						status.setStatuscode(StatusCodesEnum.STATUS_ERR_AUTH_FAILED.getCode());
					}
				}
			}
		} catch (DatatypeConfigurationException e) {
			logger.error("Exception Occurred", e);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return validateUserResponse;
	}
	


	public GetMembershipdetailsResponse getMembershipdetails(int userId) {
		GetMembershipdetailsResponse getMembershipdetailsResponse = ModelConverter.svcObjFactory.createGetMembershipdetailsResponse();
		Status status = new Status();
		getMembershipdetailsResponse.setStatus(status);
		
		try{
			AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(userId);
			List<AdUserMembershipDomain> adUserMembershipDomainsList = new ArrayList<AdUserMembershipDomain>();
			modelConverter.convertAdUserMembershipsEntityToDomain(adUsers.getAdUserMembershipset(), adUserMembershipDomainsList);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());//success
		}catch(Exception ex){
			logger.error("Exception Occurred", ex);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}		
		return getMembershipdetailsResponse;
	}

	public UpdateMembershipResponse updateMembership(UpdateMembershipRequest request) {
		UpdateMembershipResponse updateMembershipResponse = ModelConverter.svcObjFactory.createUpdateMembershipResponse();
		Status status = new Status();
		updateMembershipResponse.setStatus(status);
		
		try{
			AdUserMembershipDomain adUserMembershipDomain =	request.getAdUserMembership();
			
			AdUserMemberships adUserMembership =adUserMembershipsDAO.findAdUserMembershipsByMembershipId(request.getAdUserMembership().getMembershipid());
			adUserMembership.setAutopay(adUserMembershipDomain.getAutopay());
			adUserMembership.setAutopayWithdrawDay(adUserMembershipDomain.getAutopayWithdrawDate());
			adUserMembership.setEffectiveDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembershipDomain.getEffectiveDate()));
			adUserMembership.setExpirationDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembershipDomain.getExperiationDate()));
			
			//TODO - how to map StMemPricingOptions and TrMembershipAuthSubmits
//			adUserMembershipDomain.getPaymentStatusId()
//			adUserMembershipDomain.getMembershipPricingId()
//			adUserMembership.setStMemPricingOptions(stMemPricingOptions);
//			adUserMembership.setTrMembershipAuthSubmits(trMembershipAuthSubmits);
			
			adUserMembershipsDAO.merge(adUserMembership);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());//success	
		}catch(Exception ex){
			logger.error("Exception Occurred", ex);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return updateMembershipResponse;
	}
	
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		ResetPasswordResponse response = new ResetPasswordResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			AdUsers adUsers = adUsersDAO.findAdUsersByUserId(request.getUserId());
			adUsers.setPassword(request.getNewPassword());
			adUsersDAO.merge(adUsers);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetSecurityQuestionResponse getSecurityQuestions(String emailId) {

		GetSecurityQuestionResponse response = new GetSecurityQuestionResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			if(StringUtils.isEmpty(emailId)){
				//TODO add Erorr codes...
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			}else{
				AdUsers adUsers = adUsersDAO.findAdUsersByUserNameSingleResult(emailId);
				if(null!=adUsers)
				{
					status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
					
					AdLookupValues ad1;
					AdLookupValues ad2;
					//Support null value for security question id.
					if(adUsers.getAdLookupValuesBySecurityQuestion1Id()!=null)
					{
						ad1 = adUsers.getAdLookupValuesBySecurityQuestion1Id();
						SecurityQuestion q1 = new SecurityQuestion();
						q1.setQuestionId(ad1.getLookupValueId());
						q1.setDescription(ad1.getDescription());
						response.setSecurityQuestion1(q1);
					}
					if(adUsers.getAdLookupValuesBySecurityQuestion2Id()!=null)
					{
					 	ad2 = adUsers.getAdLookupValuesBySecurityQuestion2Id();
					 	SecurityQuestion q2 = new SecurityQuestion();
						q2.setQuestionId(ad2.getLookupValueId());
						q2.setDescription(ad2.getDescription());
						response.setSecurityQuestion2(q2);
					}
				}
				else
				{
					status.setStatuscode(StatusCodesEnum.STATUS_ERR_USER_NOT_FOUND.getCode());
				}
			}
		}catch(Throwable th){
			logger.error("Error occured", th);
			//TODO define the error code..
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
		
	public UpdateTermsAndConditionsResponse updateTermsAndConditions(UpdateTermsAndConditionsRequest request) {
		UpdateTermsAndConditionsResponse response = new UpdateTermsAndConditionsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		AdAcceptTerms adAcceptTerms = null;
		try{
			
			boolean isNew = true;
			
			AdAccepttermsDomain adAccepttermsDomain = request.getAdAccepttermsDomain();
			StTermsConditions stTermsConditions = stTermsConditionsDAO.findStTermsConditionsByPrimaryKey(adAccepttermsDomain.getTermConditionId());
			
			AdUsers adUsers = adUsersDAO.findAdUsersByUserId(request.getUserId());
			/*Set<AdAcceptTerms> adAcceptTermsSet = adUsers.getAdAcceptTermses();
			if(null != adAcceptTermsSet && adAcceptTermsSet.size() > 0){
				for (AdAcceptTerms adAcceptTerm : adAcceptTermsSet) {
					StTermsConditions stTerms = adAcceptTerm.getStTermsConditions();
					logger.debug("stTerms : {}",  stTerms);
					logger.debug("stTermsConditions : {}", stTermsConditions);
					if(stTerms.getAdLookupValuesByTermTypeId() == stTermsConditions.getAdLookupValuesByTermTypeId()){
						//isNew = false;
						adAcceptTerms = adAcceptTerm;
					}
				}	
			}*/
			if(isNew){
				adAcceptTerms = new AdAcceptTerms();
				adAcceptTerms.setAcceptanceDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adAccepttermsDomain.getAcceptanceDate()));
				adAcceptTerms.setAdUsers(adUsers);
				adAcceptTerms.setCreatedBy(this.getUserIdForCreatedByAndModifiedBy());
				adAcceptTerms.setCreationDate(Calendar.getInstance());
				adAcceptTerms.setLastUpdateDate(Calendar.getInstance());
				adAcceptTerms.setLastUpdatedBy(this.getUserIdForCreatedByAndModifiedBy());
				adAcceptTerms.setStTermsConditions(stTermsConditions);
			}/*else{
				adAcceptTerms.setStTermsConditions(stTermsConditions);
				adAcceptTerms.setAcceptanceDate(Calendar.getInstance());
				adAcceptTerms.setLastUpdateDate(Calendar.getInstance());
				adAcceptTerms.setLastUpdatedBy(this.getUserIdForCreatedByAndModifiedBy());
			}*/
			adAcceptTermsDAO.merge(adAcceptTerms);
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	private int getUserIdForCreatedByAndModifiedBy(){
		return 1;
	}

	public ValidateSecurityQuestionsResponse validateSecurityQuestions(ValidateSecurityQuestionsRequest request) {
		ValidateSecurityQuestionsResponse response = new ValidateSecurityQuestionsResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			AdUsers adUsers = adUsersDAO.findAdUsersByUserId(request.getUserId());
			AdLookupValues securityQ1 = adUsers.getAdLookupValuesBySecurityQuestion1Id();
			AdLookupValues securityQ2 = adUsers.getAdLookupValuesBySecurityQuestion2Id();
			AdLookupValues securityQ3 = adUsers.getAdLookupValuesBySecurityQuestion3Id();
			
			SecurityQuestion securityQuestion1 = request.getSecurityQuestion1();
			SecurityQuestion securityQuestion2 = request.getSecurityQuestion2();
			SecurityQuestion securityQuestion3 = request.getSecurityQuestion3();
			
			//check selected security questions are matching...?
			if(!(securityQuestion1.getQuestionId() == securityQ1.getLookupValueId() &&
					securityQuestion2.getQuestionId() == securityQ2.getLookupValueId() &&
					securityQuestion3.getQuestionId() == securityQ3.getLookupValueId()) ){
					//TODO define the error code..
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());					
			}
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetLookupTypeValuesForTypeResponse getLookupTypeValues(String lookupType) 
	{
		GetLookupTypeValuesForTypeResponse response = new GetLookupTypeValuesForTypeResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			List<AdLookupValuesDomain> adLookupValuesDomainList = response.getLookupTypeValues();
			Set<AdLookupValues> adLookupValuesSet = adLookupValuesDAO.findAdLookupValuesByLookupType(lookupType);
			modelConverter.convertAdLookupValuesEntityToDomain(adLookupValuesSet, adLookupValuesDomainList);			
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}

	@Autowired
	private TrMessagesDAO trMessagesDAO;
	
	public GetAlertsResponse getAlerts(int userId,boolean setMessageStatus) {
		GetAlertsResponse response = new GetAlertsResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			//TODO remove hardcoding..
			Set<TrMessages>  trMessagesSet = trMessagesDAO.findTrMessagesByUserAndMessageType(userId, "ALERT");
			List<TrMessagesDomain> trMessagesDomainsList = response.getAlertMessages();
			modelConverter.convertTrMessagesEntityToDomain(trMessagesSet, trMessagesDomainsList);
			//Set message status
			if(setMessageStatus==true)
			{
				AdLookupValues readStatus=new AdLookupValues();
				readStatus.setLookupValueId(LookupTypeValueEnum.MESSAGE_STATUS_READ.getTypeId());
				for(TrMessages item:trMessagesSet)
				{
					item.setAdLookupValues(readStatus);
					trMessagesDAO.merge(item);
				}
			}
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	/**
	 * sorcolumn , 1- userName, 2 - totalPrice, 3 - sellerPayDate, 4 - paymentStatusId
	 * sortdirection, 1- Asc, any other number descending oreder.. 
	 * 
	 */
	public GetDesignWallBoardInfoResponse getDesignWallBoardInfo(int userId, int startingRecord, int noOfRecords, int sortColumn, int sortDirection) {
		GetDesignWallBoardInfoResponse response = new GetDesignWallBoardInfoResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			logger.trace("Pravin bfore query Execution !1");

			SearchResults searchResults = trBoardDAO.findDesingwallBoards(sortColumn, sortDirection, startingRecord, noOfRecords, userId);
			
			List<DesignWall> designWallList = (List<DesignWall>) searchResults.getResults();
			response.setTotalRows(searchResults.getTotalRows());
			List<DesignWallBoardInfoDomain> trMessagesDomainsList = response.getBoards();
			if(searchResults.getTotalRows()>0)
				response.setTotalAmount(searchResults.getTotalAmount().doubleValue());
		
			if(designWallList!=null)
			{
				for (DesignWall designWall : designWallList) {
					AdLookupValues value = adLookupValuesDAO.findAdLookupValuesByPrimaryKey(designWall.getPaymentStatusId());
					
					DesignWallBoardInfoDomain designWallBoardInfoDomain = new DesignWallBoardInfoDomain();
					
					designWallBoardInfoDomain.setSellerPayDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(designWall.getSellerPayDate()));
					designWallBoardInfoDomain.setBoardPrice(designWall.getBoardPrice().setScale(2, RoundingMode.HALF_UP));
					//designWallBoardInfoDomain.setTotalPrice(designWall.getTotalPrice().doubleValue());
					designWallBoardInfoDomain.setTotalPrice(designWall.getSalePrice().setScale(2, RoundingMode.HALF_UP)); //Show sale price
					designWallBoardInfoDomain.setUserName(designWall.getUserName());
					designWallBoardInfoDomain.setFirstname(designWall.getFirstName());
					designWallBoardInfoDomain.setLastname(designWall.getLastName());
					designWallBoardInfoDomain.setStatusdescription(value.getDescription());
					designWallBoardInfoDomain.setMainImageUrl(designWall.getOriginalName());
					designWallBoardInfoDomain.setThumbnailUrl(designWall.getThumbnailName());
					designWallBoardInfoDomain.setTileImageUrl(designWall.getFileName());
					designWallBoardInfoDomain.setFileType(designWall.getFileType());
					designWallBoardInfoDomain.setName(designWall.getName());
					designWallBoardInfoDomain.setBoardId(designWall.getBoardId());
					designWallBoardInfoDomain.setProfilename(designWall.getProfilename());
					designWallBoardInfoDomain.setUseProfilename(designWall.getUseProfilename());
					
					trMessagesDomainsList.add(designWallBoardInfoDomain);
				}
			}
			
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetDesignerAccountResponse getDesignerAccountInfo(int userId, int startingRecord, int noOfRecords, int sortColumn, int sortDirection) 
	{
		GetDesignerAccountResponse response = new GetDesignerAccountResponse();
		Status status = new Status();
		response.setStatus(status);
		try{
			logger.trace("Pravin bfore query Execution !1");

			SearchResults searchResults = trBoardDAO.findDesignerAccount(sortColumn, sortDirection, startingRecord, noOfRecords, userId);
			
			List<Account> accountList = (List<Account>) searchResults.getResults();
			response.setTotalRows(searchResults.getTotalRows());
			List<DesignerAccountDomain> accountDomainList = response.getBoards();
			if(searchResults.getTotalRows()>0)
				response.setTotalAmount(searchResults.getTotalAmount().doubleValue());
		
			if(accountList!=null)
			{
				for (Account account : accountList) 
				{
					AdLookupValues value = adLookupValuesDAO.findAdLookupValuesByPrimaryKey(account.getPaymentStatusId());
					
					DesignerAccountDomain designerAccountDomain = new DesignerAccountDomain();
					
					designerAccountDomain.setBoardId(account.getBoardId());
					designerAccountDomain.setBoardImage(account.getBoardImage());
					designerAccountDomain.setTileImageUrl(account.getTileImageUrl());
					designerAccountDomain.setBoardName(account.getBoardName());
					designerAccountDomain.setBoardPrice(account.getBoardPrice());
					designerAccountDomain.setTotalPrice(account.getTotalPrice());
					designerAccountDomain.setPortfilioId(account.getPortfilioId());
					designerAccountDomain.setPortfolioName(account.getPortfolioName());
					designerAccountDomain.setPurchaserId(account.getPurchaserId());
					designerAccountDomain.setPurchaserName(account.getPurchaserName());
					designerAccountDomain.setDateSold(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(account.getDateSold()));
					designerAccountDomain.setPaymentStatusId(account.getPaymentStatusId());
					designerAccountDomain.setPaymentStatus(account.getPaymentStatus());
					
					accountDomainList.add(designerAccountDomain);
				}
			}
			
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}

	public GetTermsConditionsResponse getTermsConditions(int termsId) {
		GetTermsConditionsResponse response = new GetTermsConditionsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			StTermsConditions stTermsConditions = stTermsConditionsDAO.findStTermsConditionsByPrimaryKey(termsId);
			response.setTermCondition(modelConverter.convertStTermConditionEntityToDomain(stTermsConditions));
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}

	/**
	 * 
	 * @param userType - designer, customer
	 * @param termsType - registration, sale
	 * @return
	 */
	public GetTermsConditionsResponse getLatestTermsConditions(String termsType , String userType) {
		GetTermsConditionsResponse response = new GetTermsConditionsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			//StTermsConditions stTermsConditions = stTermsConditionsDAO.findStTermsConditionsByPrimaryKey(termsId);
//			Set<StTermsConditions> stTermsConditionsSet = stTermsConditionsDAO.findAllStTermsConditionsByUserTypeAndTermType(
//					LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode(), LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode());
//			
			Set<StTermsConditions> stTermsConditionsSet = stTermsConditionsDAO.findAllStTermsConditionsByUserTypeAndTermType(userType, termsType);

			StTermsConditions stTermsConditions = null;
			if(null != stTermsConditionsSet && stTermsConditionsSet.size() ==1){
				//we have only one.
				stTermsConditions = stTermsConditionsSet.iterator().next();
			}else if(null != stTermsConditionsSet && stTermsConditionsSet.size() > 1){
				for(StTermsConditions termsConditions : stTermsConditionsSet){
					//	Assumption, one terms and condition will have expiration date as null
					if(termsConditions.getExpirationDate() == null){
						stTermsConditions = termsConditions;
					}
				}
			}
			if(null != stTermsConditions){
				response.setTermCondition(modelConverter.convertStTermConditionEntityToDomain(stTermsConditions));
			}
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetLatestTermsByUserResponse getLatestTermsByUser(Integer userId)
	{
		GetLatestTermsByUserResponse response = new GetLatestTermsByUserResponse();
		Status status = new Status();
		response.setStatus(status);
		List<Integer> termTypes = new ArrayList<Integer>();
		//get registration term type id
		Set<AdLookupValues> termTypeSet=adLookupValuesDAO.findAdLookupValuesByLookupCode(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode());
		AdLookupValues termType = termTypeSet.iterator().next();
		termTypes.add(termType.getLookupValueId());
		//get term type id for designer (BASIC version)
		Set<AdLookupValues> degTermTypeSet=adLookupValuesDAO.findAdLookupValuesByLookupCode(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION_DESIGNER.getTypeCode());
		AdLookupValues degTermType = degTermTypeSet.iterator().next();
		termTypes.add(degTermType.getLookupValueId());
		Set<StTermsConditions> latestTerms = stTermsConditionsDAO.findAllTermsConditionsByUserIdAndTermType(userId, termTypes);
		if(latestTerms.size()>0)
		{
			try {
				status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
				response.setTerm(modelConverter.convertStTermConditionEntityToDomain(latestTerms.iterator().next()));
			} catch (DatatypeConfigurationException e) {
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			}
		}
		else
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		return response;
	}

	public GetCategoriesResponse getCategories(Integer level, Integer parentId) {
		GetCategoriesResponse response = new GetCategoriesResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			Set<StCategoryMaster> stCategoryMasters = stCategoryMasterDAO.findStCategoryMasterByLevel(level);
			List<StCategoryMasterDomain> stCategoryMastersList = response.getStCategoryMasterDomain();
			for(StCategoryMaster stCategoryMaster : stCategoryMasters)
			{
				if(stCategoryMaster.getParentId().equals(parentId))
				{
					stCategoryMastersList.add(modelConverter.convertStCategoryMasterEntityToDomain(stCategoryMaster));
				}
			}
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetCategoriesResponse getCategoriesByLevel(GetCategoriesRequest request) {
		GetCategoriesResponse response = new GetCategoriesResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			TrPortfolio portfolio = new TrPortfolio();
			int level1,level2;
			if(request.getPortfolioId()!=0)
			{
				//Get level 1 and 2 from portfolioId
				portfolio = trPortfolioDAO.findTrPortfolioByPortfolioId(request.getPortfolioId());
				level1 = portfolio.getStCategoryMasterByCatLevel1Id().getCategoryId();
				level2 = portfolio.getStCategoryMasterByCatLevel2Id().getCategoryId();
			}
			else
			{
				level1 = request.getLevel1();
				level2 = request.getLevel2();
			}
			Set<StCategoryMaster> stCategoryMasters;
			if(request.getLevel() == 3)
				stCategoryMasters = stCategoryMasterDAO.findStCategoryMastersForLevel3(level1, level2, -1, -1);
			else
				stCategoryMasters = stCategoryMasterDAO.findStCategoryMastersForLevel4(level1, level2,request.getNameForLevel3(), -1, -1);
			List<StCategoryMasterDomain> stCategoryMastersList = response.getStCategoryMasterDomain();
			for(StCategoryMaster stCategoryMaster : stCategoryMasters)
				stCategoryMastersList.add(modelConverter.convertStCategoryMasterEntityToDomain(stCategoryMaster));
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}

	@Autowired
	private StSeasonYearDAO stSeasonYearDAO;
	
	public GetSeasonYearsResponse getSeasonAllYears() {
		GetSeasonYearsResponse response = new GetSeasonYearsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			List<StSeasonYearDomain> stSeasonYearDomains = response.getStSeasonYearDomains();
			//TODO show the seasons only active.
			Set<StSeasonYear> stSeasonYearsSet =  stSeasonYearDAO.findStSeasonYearByActiveStatus(ActiveStatusEnum.ACTIVE.value());
			for(StSeasonYear stSeasonYear : stSeasonYearsSet){
				stSeasonYearDomains.add(modelConverter.convertStSeasonYearEntityToDomain(stSeasonYear));
			}
		}catch(Throwable th){
			logger.error("Error occured", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}

	public CheckUsernameAvailabilityResponse checkUserNameAvailability(
			String userName) {
		
		CheckUsernameAvailabilityResponse response = new CheckUsernameAvailabilityResponse();
		Set<AdUsers> users = adUsersDAO.findAdUsersByUserName(userName);
		
		if(users.size()>0)
			response.setIsAvailable(false);
		else
			response.setIsAvailable(true);
		
		return response;
	}
	
	public GetUsersListResponse getUsersList(GetUsersListRequest request)
	{
		GetUsersListResponse response = new GetUsersListResponse();
		Status status = new Status();
		response.setStatus(status);
		List<Integer> regStatusIdList = new ArrayList<Integer>();
		for (AdLookupValuesDomain item : request.getRegStatus()) {
			// get id by typecode
			Set<AdLookupValues> lookupValue = adLookupValuesDAO
					.findAdLookupValuesByLookupCode(item.getLookupCode());
			if (lookupValue.size() > 0)
				regStatusIdList.add(lookupValue.iterator().next()
						.getLookupValueId());
			else
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN
						.getCode());
		}
		List<Integer> userTypeIdList = new ArrayList<Integer>();
		for (AdLookupValuesDomain item : request.getUserType()) {
			// get id by typecode
			Set<AdLookupValues> lookupValue = adLookupValuesDAO
					.findAdLookupValuesByLookupCode(item.getLookupCode());
			if (lookupValue.size() > 0)
				userTypeIdList.add(lookupValue.iterator().next()
						.getLookupValueId());
			else
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN
						.getCode());
		}
		List<UserInfoDomain> users = response.getUsers();
		List<AdUsersDomain> adUsers = response.getUsersAdUsersDomain();
		List<TrPortfolioDomain> portfolio = null;
		
		ArrayList<ArrayList<TrBoardImages>> portfolioList = new ArrayList<ArrayList<TrBoardImages>>();
		// get total counts
		for (AdUsers item : adUsersDAO.findAdUsersByRegStatusAndUserType(
				regStatusIdList, userTypeIdList, request.getSortOption(),
				request.getFirstResult(), request.getMaxResult())) {
			portfolioList.clear();
			for (TrPortfolio portfolioItem : trPortfolioDAO
					.findTrPortfolioByUserIdAndSellable(item.getUserId(), 0)) {

				if (portfolioItem.getName().equals("Default Portfolio")) {					
					for (TrBoard boardItem : trBoardDAO
							.findTrBoardByPortfolioId(portfolioItem
									.getPortfolioId())) {
												
						Set<TrBoardImages> boardImagesList = boardItem
								.getTrBoardImageses();
						
						portfolioList.add(Lists.newArrayList(boardImagesList));
					}
				}
			}
			users.add(modelConverter.convertAdUsersToUserInfoDomain(item , portfolioList));
			AdUsersDomain adUserDomain = new AdUsersDomain();
			try {
				modelConverter.convertAdUsersEntityToDomain(item, adUserDomain);
				modelConverter.convertAdUsersEntityAssociationsToDomain(item, adUserDomain);
				if ( portfolioList != null ){
					TrPortfolioDomain portfolioDomain = new TrPortfolioDomain();		
					TrBoardDomain boardDomain = new TrBoardDomain();
				
					for ( int i= 0; i < portfolioList.size() ; i++){
						for(int j=0; j< portfolioList.get(i).size(); j++)
						{
							TrBoardDomain trBoardDomainItem  = new TrBoardDomain();
							TrBoardImagesDomain imagesDomain = new TrBoardImagesDomain();
							imagesDomain.setThumbnailUrl(portfolioList.get(i).get(j).getThumbnailUrl());
							trBoardDomainItem.getBoardImages().add(imagesDomain);
							boardDomain.getBoardImages().add(imagesDomain);
							portfolioDomain.getBoards().add(boardDomain);
						}
					}				
				
					adUserDomain.getPortfolio().add(portfolioDomain);
				}
				adUsers.add(adUserDomain);
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		response.setTotal(adUsersDAO.findAdUsersByRegStatusAndUserType(
				regStatusIdList, userTypeIdList, request.getSortOption(), -1,
				-1).size());
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		return response;
	}
	
	public UpdateApproverCommentResponse updateApproverComment(UpdateApproverCommentRequest request)
	{
		UpdateApproverCommentResponse response = new UpdateApproverCommentResponse();
		Status status = new Status();
		response.setStatus(status);
		try
		{
			AdUsers userEntity = adUsersDAO.findAdUsersByUserId(request.getUserId());
			userEntity.setApproverComments(request.getApproverComment());
			AdUsers newUserEntity = adUsersDAO.merge(userEntity);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			response.setApproverComment(newUserEntity.getApproverComments());
		}
		catch(Exception e)
		{
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public UpdateAdminRatingResponse updateApprovalRating(UpdateAdminRatingRequest request){
		UpdateAdminRatingResponse response = new UpdateAdminRatingResponse();
		Status status = new Status();
		response.setStatus(status);
		try {
			AdUsers userEntity = adUsersDAO.findAdUsersByUserId(request.getUserId());
			userEntity.setAdminRating(new BigDecimal(request.getRating()));
			AdUsers userEntitynew=adUsersDAO.store(userEntity);
			
			response.setRating(userEntitynew.getAdminRating().floatValue());
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public SearchUsersResponse searchUsers(SearchUsersRequest request){
		SearchUsersResponse response = new SearchUsersResponse();
		Status status = new Status();
		response.setStatus(status);

		try {
		
			int limit = searchMaxResults;
	
			Integer [] countryIds = null;
			if(null != request.getCountryIds() && request.getCountryIds().size() > 0){
				countryIds = request.getCountryIds().toArray(new Integer[0]);
			}
	
			Integer [] langIds = null;
			if(null != request.getLanguageIds() && request.getLanguageIds().size() > 0){
				langIds = request.getLanguageIds().toArray(new Integer[0]);
			}
	
			
			Integer [] skillIds = null;
			if(null != request.getSkillIds() && request.getSkillIds().size() > 0){
				skillIds = request.getSkillIds().toArray(new Integer[0]);
			}
			
			Integer [] expertiseIds = null;
			if(null != request.getExpertiseIds() && request.getExpertiseIds().size() > 0) {
				expertiseIds = request.getExpertiseIds().toArray(new Integer[0]);
			}
			
			Integer [] specialtyIds = null;
			if(null != request.getSpecialtyIds() && request.getSpecialtyIds().size() > 0) {
				specialtyIds = request.getSpecialtyIds().toArray(new Integer[0]);
			}
			
			Integer [] educationIds = null;
			if(null != request.getEducationIds() && request.getEducationIds().size() > 0) {
				educationIds = request.getEducationIds().toArray(new Integer[0]);
			}
	
			Set<AdUsers> users = adUsersDAO.findAdUsersBySearchCriteria(request.getDesignerName(),
					countryIds, langIds, skillIds,
					request.getSchoolAwards(), limit, expertiseIds, specialtyIds,
					educationIds, request.getMinAdminRating(), request.getMaxAdminRating());
						
			for ( AdUsers item : users){
					AdUsersDomain adUserDomain = new AdUsersDomain();
						modelConverter.convertAdUsersEntityToDomain(item, adUserDomain);
						modelConverter.convertAdUsersEntityAssociationsToDomain(item, adUserDomain);
				response.getUsers().add(adUserDomain);
			}
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		} catch(Exception e){
			e.printStackTrace();
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());					
		}
		
		return response;
	}
	
}