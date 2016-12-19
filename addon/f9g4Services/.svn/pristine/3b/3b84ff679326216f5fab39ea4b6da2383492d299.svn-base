package com.f9g4.dao;

import com.f9g4.domain.AdUserLanguages;

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
 * DAO to manage AdUserLanguages entities.
 * 
 */
@Repository("AdUserLanguagesDAO")
@Transactional
public class AdUserLanguagesDAOImpl extends AbstractJpaDao<AdUserLanguages>
		implements AdUserLanguagesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserLanguages.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdUserLanguagesDAOImpl
	 *
	 */
	public AdUserLanguagesDAOImpl() {
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
	 * JPQL Query - findAllAdUserLanguagess
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAllAdUserLanguagess() throws DataAccessException {

		return findAllAdUserLanguagess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserLanguagess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAllAdUserLanguagess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserLanguagess", startResult, maxRows);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdateDateAfter
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdateDateAfter(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserLanguagesByLastUpdateDateAfter(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdateDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdateDateAfter(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByLastUpdateDateAfter", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUserLanguagesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdateDateBefore
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdateDateBefore(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserLanguagesByLastUpdateDateBefore(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdateDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdateDateBefore(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByLastUpdateDateBefore", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserLanguages findAdUserLanguagesByPrimaryKey(Integer userLangId) throws DataAccessException {

		return findAdUserLanguagesByPrimaryKey(userLangId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserLanguages findAdUserLanguagesByPrimaryKey(Integer userLangId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserLanguagesByPrimaryKey", startResult, maxRows, userLangId);
			return (com.f9g4.domain.AdUserLanguages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserLanguagesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreationDateBefore
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreationDateBefore(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserLanguagesByCreationDateBefore(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreationDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreationDateBefore(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByCreationDateBefore", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserLanguagesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByUserLangId
	 *
	 */
	@Transactional
	public AdUserLanguages findAdUserLanguagesByUserLangId(Integer userLangId) throws DataAccessException {

		return findAdUserLanguagesByUserLangId(userLangId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByUserLangId
	 *
	 */

	@Transactional
	public AdUserLanguages findAdUserLanguagesByUserLangId(Integer userLangId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserLanguagesByUserLangId", startResult, maxRows, userLangId);
			return (com.f9g4.domain.AdUserLanguages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserLanguagesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdUserLanguagesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreationDateAfter
	 *
	 */
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreationDateAfter(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserLanguagesByCreationDateAfter(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserLanguagesByCreationDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserLanguages> findAdUserLanguagesByCreationDateAfter(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserLanguagesByCreationDateAfter", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserLanguages>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdUserLanguages entity) {
		return true;
	}
}
