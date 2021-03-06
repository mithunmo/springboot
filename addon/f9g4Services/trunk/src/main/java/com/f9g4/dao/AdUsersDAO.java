package com.f9g4.dao;

import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrBoardSearch;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdUsers entities.
 * 
 */
public interface AdUsersDAO extends JpaDao<AdUsers> {

	/**
	 * JPQL Query - findAdUsersBySchoolAwards
	 *
	 */
	public Set<AdUsers> findAdUsersBySchoolAwards(String schoolAwards) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySchoolAwards
	 *
	 */
	public Set<AdUsers> findAdUsersBySchoolAwards(String schoolAwards, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3Containing
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer3Containing(String securityAnswer3) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3Containing
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer3Containing(String securityAnswer3, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLangCodeContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByLangCodeContaining(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLangCodeContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByFirstnameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByFirstnameContaining(String firstname) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByFirstnameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByAboutYouContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByAboutYouContaining(String aboutYou) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByAboutYouContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByAboutYouContaining(String aboutYou, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByActiveStatus
	 *
	 */
	public Set<AdUsers> findAdUsersByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByActiveStatus
	 *
	 */
	public Set<AdUsers> findAdUsersByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCreationDate
	 *
	 */
	public Set<AdUsers> findAdUsersByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCreationDate
	 *
	 */
	public Set<AdUsers> findAdUsersByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer3(String securityAnswer3_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer3(String securityAnswer3_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByUserId
	 *
	 */
	public AdUsers findAdUsersByUserId(Integer userId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByUserId
	 *
	 */
	public AdUsers findAdUsersByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyNameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyNameContaining(String companyName) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyNameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyNameContaining(String companyName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByFirstname
	 *
	 */
	public Set<AdUsers> findAdUsersByFirstname(String firstname_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByFirstname
	 *
	 */
	public Set<AdUsers> findAdUsersByFirstname(String firstname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByAboutYou
	 *
	 */
	public Set<AdUsers> findAdUsersByAboutYou(String aboutYou_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByAboutYou
	 *
	 */
	public Set<AdUsers> findAdUsersByAboutYou(String aboutYou_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByTaxIdContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByTaxIdContaining(String taxId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByTaxIdContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByTaxIdContaining(String taxId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByUserNameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByUserNameContaining(String userName) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByUserNameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByUserNameContaining(String userName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastUpdateDate
	 *
	 */
	public Set<AdUsers> findAdUsersByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastUpdateDate
	 *
	 */
	public Set<AdUsers> findAdUsersByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1Containing
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer1Containing(String securityAnswer1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1Containing
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer1Containing(String securityAnswer1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastUpdatedBy
	 *
	 */
	public Set<AdUsers> findAdUsersByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastUpdatedBy
	 *
	 */
	public Set<AdUsers> findAdUsersByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByPasswordContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByPasswordContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyName
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyName(String companyName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyName
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyName(String companyName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastname
	 *
	 */
	public Set<AdUsers> findAdUsersByLastname(String lastname) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastname
	 *
	 */
	public Set<AdUsers> findAdUsersByLastname(String lastname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCreatedBy
	 *
	 */
	public Set<AdUsers> findAdUsersByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCreatedBy
	 *
	 */
	public Set<AdUsers> findAdUsersByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySchoolAwardsContaining
	 *
	 */
	public Set<AdUsers> findAdUsersBySchoolAwardsContaining(String schoolAwards_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySchoolAwardsContaining
	 *
	 */
	public Set<AdUsers> findAdUsersBySchoolAwardsContaining(String schoolAwards_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByOverallRating
	 *
	 */
	public Set<AdUsers> findAdUsersByOverallRating(java.math.BigDecimal overallRating) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByOverallRating
	 *
	 */
	public Set<AdUsers> findAdUsersByOverallRating(BigDecimal overallRating, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastnameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByLastnameContaining(String lastname_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLastnameContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByLastnameContaining(String lastname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByUserName
	 *
	 */
	public Set<AdUsers> findAdUsersByUserName(String userName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByProfileName
	 *
	 */
	public Set<AdUsers> findAdUsersByProfileName(String profileName_1) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findAdUsersByUserName
	 *
	 */
	public Set<AdUsers> findAdUsersByUserName(String userName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyWebsiteContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyWebsiteContaining(String companyWebsite) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyWebsiteContaining
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyWebsiteContaining(String companyWebsite, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLangCode
	 *
	 */
	public Set<AdUsers> findAdUsersByLangCode(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByLangCode
	 *
	 */
	public Set<AdUsers> findAdUsersByLangCode(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer2(String securityAnswer2) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer2(String securityAnswer2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer1(String securityAnswer1_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer1(String securityAnswer1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByPrimaryKey
	 *
	 */
	public AdUsers findAdUsersByPrimaryKey(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByPrimaryKey
	 *
	 */
	public AdUsers findAdUsersByPrimaryKey(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2Containing
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer2Containing(String securityAnswer2_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2Containing
	 *
	 */
	public Set<AdUsers> findAdUsersBySecurityAnswer2Containing(String securityAnswer2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByPassword
	 *
	 */
	public Set<AdUsers> findAdUsersByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByPassword
	 *
	 */
	public Set<AdUsers> findAdUsersByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyWebsite
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyWebsite(String companyWebsite_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByCompanyWebsite
	 *
	 */
	public Set<AdUsers> findAdUsersByCompanyWebsite(String companyWebsite_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserss
	 *
	 */
	public Set<AdUsers> findAllAdUserss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserss
	 *
	 */
	public Set<AdUsers> findAllAdUserss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByTaxId
	 *
	 */
	public Set<AdUsers> findAdUsersByTaxId(String taxId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByTaxId
	 *
	 */
	public Set<AdUsers> findAdUsersByTaxId(String taxId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUsersByUserName
	 *
	 */	
	public AdUsers findAdUsersByUserNameSingleResult(String userName) throws DataAccessException;
	
	/**
	 * JPQL Query - findAdUsersByUserName
	 *
	 */	
	public Set<AdUsers> findAdUsersByRegStatusAndUserType(List<Integer> RegStatus,List<Integer> UserType,Integer orderByOption, Integer firstRec, Integer maxRec) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findAdUsersBySearchCriteria
	 */
	public Set<AdUsers> findAdUsersBySearchCriteria(
			String designerName, Integer[] countryIds, 
			Integer[] langIds, Integer[] skillIds, String schoolAwards, 
			Integer limt, 
			Integer[] expertiseIds, Integer[] specialtyIds, Integer[] educationIds,
			Integer minAdminRating, Integer maxAdminRating) throws DataAccessException;

}