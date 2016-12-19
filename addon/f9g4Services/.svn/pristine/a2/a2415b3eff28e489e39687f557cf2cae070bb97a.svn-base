package com.f9g4.dao;

import com.f9g4.domain.AdLookupValues;
import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage AdLookupValues entities.
 * 
 */
@Repository("AdLookupValuesDAO")
@Transactional
public class AdLookupValuesDAOImpl extends AbstractJpaDao<AdLookupValues> implements AdLookupValuesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdLookupValues.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdLookupValuesDAOImpl
	 *
	 */
	public AdLookupValuesDAOImpl() {
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
	 * JPQL Query - findAdLookupValuesByPrimaryKey
	 *
	 */
	@Transactional
	public AdLookupValues findAdLookupValuesByPrimaryKey(Integer lookupValueId) throws DataAccessException {

		return findAdLookupValuesByPrimaryKey(lookupValueId, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByPrimaryKey
	 *
	 */

	@Transactional
	public AdLookupValues findAdLookupValuesByPrimaryKey(Integer lookupValueId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdLookupValuesByPrimaryKey", startResult, maxRows, lookupValueId);
			return (com.f9g4.domain.AdLookupValues) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdLookupValuesByLangCode
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLangCode(String langCode) throws DataAccessException {

		return findAdLookupValuesByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByLookupValueId
	 *
	 */
	@Transactional
	public AdLookupValues findAdLookupValuesByLookupValueId(Integer lookupValueId) throws DataAccessException {

		return findAdLookupValuesByLookupValueId(lookupValueId, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLookupValueId
	 *
	 */

	@Transactional
	public AdLookupValues findAdLookupValuesByLookupValueId(Integer lookupValueId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdLookupValuesByLookupValueId", startResult, maxRows, lookupValueId);
			return (com.f9g4.domain.AdLookupValues) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdLookupValuesByCreationDate
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdLookupValuesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLangCodeContaining(String langCode) throws DataAccessException {

		return findAdLookupValuesByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdLookupValuesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByLastUpdateBy
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLastUpdateBy(Integer lastUpdateBy) throws DataAccessException {

		return findAdLookupValuesByLastUpdateBy(lastUpdateBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLastUpdateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLastUpdateBy(Integer lastUpdateBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLastUpdateBy", startResult, maxRows, lastUpdateBy);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdLookupValuesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdLookupValuesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByDescription
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByDescription(String description) throws DataAccessException {

		return findAdLookupValuesByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByDescription", startResult, maxRows, description);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByDescriptionContaining(String description) throws DataAccessException {

		return findAdLookupValuesByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByLookupCodeContaining
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLookupCodeContaining(String lookupCode) throws DataAccessException {

		return findAdLookupValuesByLookupCodeContaining(lookupCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLookupCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLookupCodeContaining(String lookupCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLookupCodeContaining", startResult, maxRows, lookupCode);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdLookupValuess
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAllAdLookupValuess() throws DataAccessException {

		return findAllAdLookupValuess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdLookupValuess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable(cacheName="findAllAdLookupValuess")
	public Set<AdLookupValues> findAllAdLookupValuess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdLookupValuess", startResult, maxRows);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupValuesByLookupCode
	 *
	 */
	@Transactional
	public Set<AdLookupValues> findAdLookupValuesByLookupCode(String lookupCode) throws DataAccessException {

		return findAdLookupValuesByLookupCode(lookupCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupValuesByLookupCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable(cacheName="findAdLookupValuesByLookupCode")
	public Set<AdLookupValues> findAdLookupValuesByLookupCode(String lookupCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLookupCode", startResult, maxRows, lookupCode);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdLookupValues entity) {
		return true;
	}
	

	@Transactional
	public AdLookupValues findAdLookupValuesByLookupCodeSingleResult(String lookupCode) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLookupCode", -1, -1, lookupCode);
		return (AdLookupValues)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Cacheable(cacheName="findAdLookupValuesByLookupType")
	public Set<AdLookupValues> findAdLookupValuesByLookupType(String lookupType) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupValuesByLookupType", -1, -1, lookupType);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}
	
	@SuppressWarnings("findAdLookupValuesByLookupType")
	@Transactional
	@Cacheable(cacheName="aduserlookupvalues")
	public Set<AdLookupValues> findAllAdLookupValuesByLookupType(String lookupType) throws DataAccessException {
		Query query = createNamedQuery("findAllAdLookupValuesByLookupType", -1, -1, lookupType);
		return new LinkedHashSet<AdLookupValues>(query.getResultList());
	}
	
	@TriggersRemove(cacheName="aduserlookupvalues", removeAll=true)
    public void clearAduserlookupvaluesCaches() {}
	
	@TriggersRemove(cacheName="findAdLookupValuesByLookupType", removeAll=true)
    public void clearAduserlookupvaluesByLookupTypeCaches() {}
}