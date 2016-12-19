package com.f9g4.dao;

import com.f9g4.domain.TrSearchSeason;

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
 * DAO to manage TrSearchSeason entities.
 * 
 */
@Repository("TrSearchSeasonDAO")
@Transactional
public class TrSearchSeasonDAOImpl extends AbstractJpaDao<TrSearchSeason>
		implements TrSearchSeasonDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSearchSeason.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSearchSeasonDAOImpl
	 *
	 */
	public TrSearchSeasonDAOImpl() {
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
	 * JPQL Query - findTrSearchSeasonByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSearchSeasonByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSeasonByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSeasonByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSearchSeason>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSearchSeasonByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSeasonByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSearchSeason>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSearchSeasonByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSeasonByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSearchSeason>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSearchSeasons
	 *
	 */
	@Transactional
	public Set<TrSearchSeason> findAllTrSearchSeasons() throws DataAccessException {

		return findAllTrSearchSeasons(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSearchSeasons
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSeason> findAllTrSearchSeasons(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSearchSeasons", startResult, maxRows);
		return new LinkedHashSet<TrSearchSeason>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSeasonByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSearchSeasonByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSeasonByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSeason> findTrSearchSeasonByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSeasonByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSearchSeason>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSeasonByPrimaryKey
	 *
	 */
	@Transactional
	public TrSearchSeason findTrSearchSeasonByPrimaryKey(Integer searchSeasonId) throws DataAccessException {

		return findTrSearchSeasonByPrimaryKey(searchSeasonId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSeasonByPrimaryKey
	 *
	 */

	@Transactional
	public TrSearchSeason findTrSearchSeasonByPrimaryKey(Integer searchSeasonId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchSeasonByPrimaryKey", startResult, maxRows, searchSeasonId);
			return (com.f9g4.domain.TrSearchSeason) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchSeasonBySearchSeasonId
	 *
	 */
	@Transactional
	public TrSearchSeason findTrSearchSeasonBySearchSeasonId(Integer searchSeasonId) throws DataAccessException {

		return findTrSearchSeasonBySearchSeasonId(searchSeasonId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSeasonBySearchSeasonId
	 *
	 */

	@Transactional
	public TrSearchSeason findTrSearchSeasonBySearchSeasonId(Integer searchSeasonId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchSeasonBySearchSeasonId", startResult, maxRows, searchSeasonId);
			return (com.f9g4.domain.TrSearchSeason) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrSearchSeason entity) {
		return true;
	}
}
