package com.f9g4.dao;

import com.f9g4.domain.AdLookupTypes;

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
 * DAO to manage AdLookupTypes entities.
 * 
 */
@Repository("AdLookupTypesDAO")
@Transactional
public class AdLookupTypesDAOImpl extends AbstractJpaDao<AdLookupTypes>
		implements AdLookupTypesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdLookupTypes.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdLookupTypesDAOImpl
	 *
	 */
	public AdLookupTypesDAOImpl() {
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
	 * JPQL Query - findAdLookupTypesByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdLookupTypesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLangCode
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLangCode(String langCode) throws DataAccessException {

		return findAdLookupTypesByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupType
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupType(String lookupType) throws DataAccessException {

		return findAdLookupTypesByLookupType(lookupType, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupType(String lookupType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLookupType", startResult, maxRows, lookupType);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLangCodeContaining(String langCode) throws DataAccessException {

		return findAdLookupTypesByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByCreationDate
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdLookupTypesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdLookupTypesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByPrimaryKey
	 *
	 */
	@Transactional
	public AdLookupTypes findAdLookupTypesByPrimaryKey(Integer lookupTypeId) throws DataAccessException {

		return findAdLookupTypesByPrimaryKey(lookupTypeId, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByPrimaryKey
	 *
	 */

	@Transactional
	public AdLookupTypes findAdLookupTypesByPrimaryKey(Integer lookupTypeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdLookupTypesByPrimaryKey", startResult, maxRows, lookupTypeId);
			return (com.f9g4.domain.AdLookupTypes) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdLookupTypesByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdLookupTypesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeId
	 *
	 */
	@Transactional
	public AdLookupTypes findAdLookupTypesByLookupTypeId(Integer lookupTypeId) throws DataAccessException {

		return findAdLookupTypesByLookupTypeId(lookupTypeId, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeId
	 *
	 */

	@Transactional
	public AdLookupTypes findAdLookupTypesByLookupTypeId(Integer lookupTypeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdLookupTypesByLookupTypeId", startResult, maxRows, lookupTypeId);
			return (com.f9g4.domain.AdLookupTypes) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeContaining
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupTypeContaining(String lookupType) throws DataAccessException {

		return findAdLookupTypesByLookupTypeContaining(lookupType, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupTypeContaining(String lookupType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLookupTypeContaining", startResult, maxRows, lookupType);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescription
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescription(String lookupDescription) throws DataAccessException {

		return findAdLookupTypesByLookupDescription(lookupDescription, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescription(String lookupDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLookupDescription", startResult, maxRows, lookupDescription);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescriptionContaining
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescriptionContaining(String lookupDescription) throws DataAccessException {

		return findAdLookupTypesByLookupDescriptionContaining(lookupDescription, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescriptionContaining(String lookupDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLookupDescriptionContaining", startResult, maxRows, lookupDescription);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdLookupTypess
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAllAdLookupTypess() throws DataAccessException {

		return findAllAdLookupTypess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdLookupTypess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAllAdLookupTypess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdLookupTypess", startResult, maxRows);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdLookupTypesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdLookupTypes>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdLookupTypes entity) {
		return true;
	}

	public AdLookupTypes findAdLookupTypesByLookupTypeName(String lookupType) throws DataAccessException {
		Query query = createNamedQuery("findAdLookupTypesByLookupType", -1, -1 , lookupType);
		return (com.f9g4.domain.AdLookupTypes) query.getSingleResult();
	}
}
