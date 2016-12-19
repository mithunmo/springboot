package com.f9g4.dao;

import com.f9g4.domain.TrSearchLanguages;

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
 * DAO to manage TrSearchLanguages entities.
 * 
 */
@Repository("TrSearchLanguagesDAO")
@Transactional
public class TrSearchLanguagesDAOImpl extends AbstractJpaDao<TrSearchLanguages>
		implements TrSearchLanguagesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSearchLanguages.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSearchLanguagesDAOImpl
	 *
	 */
	public TrSearchLanguagesDAOImpl() {
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
	 * JPQL Query - findTrSearchLanguagesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSearchLanguagesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchLanguagesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSearchLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchLanguagesBySearchLanguageId
	 *
	 */
	@Transactional
	public TrSearchLanguages findTrSearchLanguagesBySearchLanguageId(Integer searchLanguageId) throws DataAccessException {

		return findTrSearchLanguagesBySearchLanguageId(searchLanguageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchLanguagesBySearchLanguageId
	 *
	 */

	@Transactional
	public TrSearchLanguages findTrSearchLanguagesBySearchLanguageId(Integer searchLanguageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchLanguagesBySearchLanguageId", startResult, maxRows, searchLanguageId);
			return (com.f9g4.domain.TrSearchLanguages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSearchLanguagesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchLanguagesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSearchLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSearchLanguagess
	 *
	 */
	@Transactional
	public Set<TrSearchLanguages> findAllTrSearchLanguagess() throws DataAccessException {

		return findAllTrSearchLanguagess(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSearchLanguagess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchLanguages> findAllTrSearchLanguagess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSearchLanguagess", startResult, maxRows);
		return new LinkedHashSet<TrSearchLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByPrimaryKey
	 *
	 */
	@Transactional
	public TrSearchLanguages findTrSearchLanguagesByPrimaryKey(Integer searchLanguageId) throws DataAccessException {

		return findTrSearchLanguagesByPrimaryKey(searchLanguageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByPrimaryKey
	 *
	 */

	@Transactional
	public TrSearchLanguages findTrSearchLanguagesByPrimaryKey(Integer searchLanguageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchLanguagesByPrimaryKey", startResult, maxRows, searchLanguageId);
			return (com.f9g4.domain.TrSearchLanguages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSearchLanguagesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchLanguagesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSearchLanguages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSearchLanguagesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchLanguagesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSearchLanguages>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrSearchLanguages entity) {
		return true;
	}
}
