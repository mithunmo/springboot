package com.f9g4.dao;

import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrBoardSearch;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage AdUsers entities.
 * 
 */
@Repository("AdUsersDAO")
@Transactional
public class AdUsersDAOImpl extends AbstractJpaDao<AdUsers> implements AdUsersDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUsers.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdUsersDAOImpl
	 *
	 */
	public AdUsersDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAdUsersBySchoolAwards
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySchoolAwards(String schoolAwards) throws DataAccessException {

		return findAdUsersBySchoolAwards(schoolAwards, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySchoolAwards
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySchoolAwards(String schoolAwards, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySchoolAwards", startResult, maxRows, schoolAwards);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3Containing
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer3Containing(String securityAnswer3) throws DataAccessException {

		return findAdUsersBySecurityAnswer3Containing(securityAnswer3, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer3Containing(String securityAnswer3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySecurityAnswer3Containing", startResult, maxRows, securityAnswer3);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByLangCodeContaining(String langCode) throws DataAccessException {

		return findAdUsersByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByFirstnameContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByFirstnameContaining(String firstname) throws DataAccessException {

		return findAdUsersByFirstnameContaining(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByFirstnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByFirstnameContaining(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByFirstnameContaining", startResult, maxRows, firstname);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByAboutYouContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByAboutYouContaining(String aboutYou) throws DataAccessException {

		return findAdUsersByAboutYouContaining(aboutYou, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByAboutYouContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByAboutYouContaining(String aboutYou, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByAboutYouContaining", startResult, maxRows, aboutYou);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUsersByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUsersByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer3(String securityAnswer3) throws DataAccessException {

		return findAdUsersBySecurityAnswer3(securityAnswer3, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer3
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer3(String securityAnswer3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySecurityAnswer3", startResult, maxRows, securityAnswer3);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByUserId
	 *
	 */
	@Transactional
	public AdUsers findAdUsersByUserId(Integer userId) throws DataAccessException {

		return findAdUsersByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByUserId
	 *
	 */

	@Transactional
	public AdUsers findAdUsersByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUsersByUserId", startResult, maxRows, userId);
			return (com.f9g4.domain.AdUsers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUsersByCompanyNameContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyNameContaining(String companyName) throws DataAccessException {

		return findAdUsersByCompanyNameContaining(companyName, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByCompanyNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyNameContaining(String companyName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByCompanyNameContaining", startResult, maxRows, companyName);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByFirstname
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByFirstname(String firstname) throws DataAccessException {

		return findAdUsersByFirstname(firstname, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByFirstname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByFirstname(String firstname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByFirstname", startResult, maxRows, firstname);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByAboutYou
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByAboutYou(String aboutYou) throws DataAccessException {

		return findAdUsersByAboutYou(aboutYou, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByAboutYou
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByAboutYou(String aboutYou, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByAboutYou", startResult, maxRows, aboutYou);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByTaxIdContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByTaxIdContaining(String taxId) throws DataAccessException {

		return findAdUsersByTaxIdContaining(taxId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByTaxIdContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByTaxIdContaining(String taxId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByTaxIdContaining", startResult, maxRows, taxId);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByUserNameContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByUserNameContaining(String userName) throws DataAccessException {

		return findAdUsersByUserNameContaining(userName, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByUserNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByUserNameContaining(String userName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByUserNameContaining", startResult, maxRows, userName);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUsersByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1Containing
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer1Containing(String securityAnswer1) throws DataAccessException {

		return findAdUsersBySecurityAnswer1Containing(securityAnswer1, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer1Containing(String securityAnswer1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySecurityAnswer1Containing", startResult, maxRows, securityAnswer1);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdUsersByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByPasswordContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByPasswordContaining(String password) throws DataAccessException {

		return findAdUsersByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByCompanyName
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyName(String companyName) throws DataAccessException {

		return findAdUsersByCompanyName(companyName, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByCompanyName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyName(String companyName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByCompanyName", startResult, maxRows, companyName);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByLastname
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByLastname(String lastname) throws DataAccessException {

		return findAdUsersByLastname(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByLastname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByLastname(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByLastname", startResult, maxRows, lastname);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUsersByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersBySchoolAwardsContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySchoolAwardsContaining(String schoolAwards) throws DataAccessException {

		return findAdUsersBySchoolAwardsContaining(schoolAwards, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySchoolAwardsContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySchoolAwardsContaining(String schoolAwards, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySchoolAwardsContaining", startResult, maxRows, schoolAwards);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByOverallRating
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByOverallRating(java.math.BigDecimal overallRating) throws DataAccessException {

		return findAdUsersByOverallRating(overallRating, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByOverallRating
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByOverallRating(java.math.BigDecimal overallRating, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByOverallRating", startResult, maxRows, overallRating);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByLastnameContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByLastnameContaining(String lastname) throws DataAccessException {

		return findAdUsersByLastnameContaining(lastname, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByLastnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByLastnameContaining(String lastname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByLastnameContaining", startResult, maxRows, lastname);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByUserName
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByUserName(String userName) throws DataAccessException {

		return findAdUsersByUserName(userName, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByUserName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByUserName(String userName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByUserName", startResult, maxRows, userName);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByCompanyWebsiteContaining
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyWebsiteContaining(String companyWebsite) throws DataAccessException {

		return findAdUsersByCompanyWebsiteContaining(companyWebsite, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByCompanyWebsiteContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyWebsiteContaining(String companyWebsite, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByCompanyWebsiteContaining", startResult, maxRows, companyWebsite);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByLangCode
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByLangCode(String langCode) throws DataAccessException {

		return findAdUsersByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer2(String securityAnswer2) throws DataAccessException {

		return findAdUsersBySecurityAnswer2(securityAnswer2, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer2(String securityAnswer2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySecurityAnswer2", startResult, maxRows, securityAnswer2);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer1(String securityAnswer1) throws DataAccessException {

		return findAdUsersBySecurityAnswer1(securityAnswer1, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer1(String securityAnswer1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySecurityAnswer1", startResult, maxRows, securityAnswer1);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByPrimaryKey
	 *
	 */
	@Transactional
	public AdUsers findAdUsersByPrimaryKey(Integer userId) throws DataAccessException {

		return findAdUsersByPrimaryKey(userId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByPrimaryKey
	 *
	 */

	@Transactional
	public AdUsers findAdUsersByPrimaryKey(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUsersByPrimaryKey", startResult, maxRows, userId);
			return (com.f9g4.domain.AdUsers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2Containing
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer2Containing(String securityAnswer2) throws DataAccessException {

		return findAdUsersBySecurityAnswer2Containing(securityAnswer2, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersBySecurityAnswer2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersBySecurityAnswer2Containing(String securityAnswer2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersBySecurityAnswer2Containing", startResult, maxRows, securityAnswer2);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByPassword
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByPassword(String password) throws DataAccessException {

		return findAdUsersByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByPassword", startResult, maxRows, password);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByCompanyWebsite
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyWebsite(String companyWebsite) throws DataAccessException {

		return findAdUsersByCompanyWebsite(companyWebsite, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByCompanyWebsite
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByCompanyWebsite(String companyWebsite, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByCompanyWebsite", startResult, maxRows, companyWebsite);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserss
	 *
	 */
	@Transactional
	public Set<AdUsers> findAllAdUserss() throws DataAccessException {

		return findAllAdUserss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAllAdUserss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserss", startResult, maxRows);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUsersByTaxId
	 *
	 */
	@Transactional
	public Set<AdUsers> findAdUsersByTaxId(String taxId) throws DataAccessException {

		return findAdUsersByTaxId(taxId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUsersByTaxId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByTaxId(String taxId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUsersByTaxId", startResult, maxRows, taxId);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdUsers entity) {
		return true;
	}
	
	
	@Transactional
	public AdUsers findAdUsersByUserNameSingleResult(String userName) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUsersByUserName", -1, -1, userName);
			return (com.f9g4.domain.AdUsers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUsers> findAdUsersByRegStatusAndUserType(List<Integer> RegStatus,List<Integer> UserType,Integer orderByOption, Integer firstRec, Integer maxRec) throws DataAccessException {
		String queryStr = "select distinct myAdUsers from AdUsers myAdUsers, AdUserMemberships aum where myAdUsers.adLookupValuesByRegStatusId.lookupValueId in ?1 and myAdUsers.adLookupValuesByUserTypeId.lookupValueId in ?2 and myAdUsers.userId = aum.adUsers.userId";
		String orderBy = "";
		String direction = "";
		switch(Math.abs(orderByOption))
		{
		case 1:
			orderBy = " order by myAdUsers.lastname";
			break;
		case 2:
			orderBy = " order by myAdUsers.userName";
			break;
		case 3:
			orderBy = " order by aum.expirationDate";
			break;
		case 4:
			orderBy = " order by aum.effectiveDate";
			break;
		case 5:
			orderBy = " order by myAdUsers.firstname";
			break;
		case 6:
			orderBy = " order by myAdUsers.adminRating";
			break;
		default:
			orderBy = " order by myAdUsers.lastname";
			break;
		}
		if(orderByOption >= 0)
			direction = " ASC";
		else
			direction = " DESC";
		Query query = createQuery(queryStr+orderBy+direction, firstRec, maxRec);
		query.setParameter(1, RegStatus);
		query.setParameter(2, UserType);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	public Set<AdUsers> findAdUsersByProfileName(String profileName_1)
			throws DataAccessException {
		
		Query query = createNamedQuery("findAdUsersByProfileName", -1, -1, profileName_1);
		return new LinkedHashSet<AdUsers>(query.getResultList());
	}

	public Set<AdUsers> findAdUsersBySearchCriteria(String designerName,
			Integer[] countryIds,
			Integer[] langIds, Integer[] skillIds, String schoolAwards,
			Integer limt, 
			Integer[] expertiseIds, Integer[] specialtyIds,
			Integer[] educationIds, Integer minAdminRating,
			Integer maxAdminRating) throws DataAccessException {
		
		String expertiseSubQ="";
		String specialtySubQ="";
		String educationSubQ="";
		String langSubQ="";
		String skillsSubQ="";
		String countrySubQ="";

		if (countryIds!= null && countryIds.length >0 ) {
			countrySubQ = "AND EXISTS (SELECT 1 FROM ad_addresses aad WHERE aad.active_status = 1 and aad.user_id = au.user_id AND ( aad.country_id in (?2) "  +  
				    " OR aad.country_id = IFNULL(?3, aad.country_id ))) ";			
		}
		
		if(langIds != null && langIds.length > 0)
		{
			langSubQ= " AND EXISTS (SELECT 1 FROM ad_user_languages aul WHERE aul.active_status = 1 and aul.user_id = au.user_id AND (aul.language_id in (?4)" + 
					" OR aul.language_id  = IFNULL(?5, aul.language_id))) ";												
		}
		
		if(skillIds != null && skillIds.length > 0)
		{
			skillsSubQ= " AND EXISTS (SELECT 1 FROM ad_user_skills aus WHERE  aus.active_status = 1 and aus.user_id = au.user_id AND (aus.skill_id in (?6) " + 
				    " OR aus.skill_id = IFNULL(?7, aus.skill_id)))  "; 
		}
		
		if(expertiseIds != null && expertiseIds.length > 0)
		{
			expertiseSubQ=" AND EXISTS (SELECT 1 FROM ad_user_expertise aue WHERE aue.active_status = 1 and aue.user_id = tb.original_user_id AND (aue.exp_id in (?8) " + /* Enclose String in single quotes */
       				" OR aue.exp_id = IFNULL(?9, aue.exp_id))) ";
		}
		
		if(specialtyIds != null && specialtyIds.length > 0)
		{
			specialtySubQ=" AND EXISTS (SELECT 1 FROM ad_user_specialities asp WHERE asp.active_status = 1 and asp.user_id = tb.original_user_id AND (asp.spl_id in (?11) " + /* Enclose String in single quotes */
   					" OR asp.spl_id = IFNULL(?12, asp.spl_id))) ";
		}
		
		if(educationIds != null && educationIds.length > 0)
		{
			educationSubQ=" AND EXISTS (SELECT 1 FROM ad_user_educations aedu WHERE aedu.active_status = 1 and aedu.user_id = tb.original_user_id AND (aedu.edu_id in (?13) " + /* Enclose String in single quotes */
       				" OR aedu.edu_id = IFNULL(?14, aedu.edu_id))) ";
		}
		
		String queryStr = "select  * from ad_users myAdUsers where exists"
				+ " ( select 1 from ad_users au where "				
			    + " au.active_status = 1 and"
			    + " upper(concat(FirstName, LastName)) like upper(replace(?1 ,' ','%')) and"
			    + " upper(IFNULL(au.school_awards,'X')) like upper(?10) AND  au.user_id = myAdUsers.user_id"
			    + " AND au.admin_rating between ?15 and ?16   "
			    + countrySubQ
				+ langSubQ +
				skillsSubQ +
				expertiseSubQ +
				specialtySubQ +
				educationSubQ + ") limit 0, ?17";
		

		TypedQuery<com.f9g4.domain.AdUsers> query = (TypedQuery<AdUsers>) entityManager.createNativeQuery(queryStr, com.f9g4.domain.AdUsers.class);				
		
		if(null != designerName ){
			designerName = "%" + designerName +"%";
		}else{
			designerName = "%%";
		}
				
		query.setParameter(1, designerName );
		if(null == countryIds || countryIds.length ==0){
			query.setParameter(2, null);
			query.setParameter(3, null);
		}else{
			List<Integer> countries=Arrays.asList(countryIds);
			query.setParameter(2, countries);
			query.setParameter(3, arrayToString(countryIds, ",")); //convert to a string
		}

		if(null != langIds && langIds.length > 0){
			List<Integer> langs=Arrays.asList(langIds);
			query.setParameter(4, langs);
			query.setParameter(5, arrayToString(langIds, ",")); //convert to a string
		}

	
		if(null != skillIds && skillIds.length > 0){
			List<Integer> skills=Arrays.asList(skillIds);
			query.setParameter(6, skills);
			query.setParameter(7, arrayToString(skillIds, ",")); //convert to a string
		}
		
		if(null != expertiseIds && expertiseIds.length > 0){
			List<Integer> expertiseList=Arrays.asList(expertiseIds);
			query.setParameter(8, expertiseList);
			query.setParameter(9, arrayToString(expertiseIds, ",")); //convert to a string 	
		}
		
		if(null != specialtyIds && specialtyIds.length > 0){
			List<Integer> specialtyList=Arrays.asList(specialtyIds);
			query.setParameter(11, specialtyList);
			query.setParameter(12, arrayToString(specialtyIds, ",")); //convert to a string	
		}
				
		if(null != educationIds && educationIds.length > 0){
			List<Integer> educationList=Arrays.asList(educationIds);
			query.setParameter(13, educationList);
			query.setParameter(14, arrayToString(educationIds, ",")); //convert to a string
		}
		
		schoolAwards = (null == schoolAwards? "%%" : "%"+schoolAwards+"%");
		query.setParameter(10, schoolAwards);
		
		query.setParameter(15, minAdminRating);
		query.setParameter(16, maxAdminRating);

		query.setParameter(17, limt);

		LinkedHashSet<AdUsers> result = new LinkedHashSet<AdUsers>(query.getResultList());
		return result;
	
	}

	private  String arrayToString(Integer[] a, String separator) {
	    StringBuffer result = new StringBuffer();
	    if (null != a && a.length > 0) {
	        result.append(a[0]);
	        for (int i=1; i<a.length; i++) {
	            result.append(separator);
	            result.append(a[i]);
	        }
	    }
	    return result.toString();
	}
	

}