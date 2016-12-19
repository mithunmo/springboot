package com.f9g4.dao;

import com.f9g4.domain.TrSearchSkills;

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
 * DAO to manage TrSearchSkills entities.
 * 
 */
@Repository("TrSearchSkillsDAO")
@Transactional
public class TrSearchSkillsDAOImpl extends AbstractJpaDao<TrSearchSkills>
		implements TrSearchSkillsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSearchSkills.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSearchSkillsDAOImpl
	 *
	 */
	public TrSearchSkillsDAOImpl() {
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
	 * JPQL Query - findTrSearchSkillsByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSearchSkillsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSkillsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSkillsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSearchSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSkillsByPrimaryKey
	 *
	 */
	@Transactional
	public TrSearchSkills findTrSearchSkillsByPrimaryKey(Integer searchSkillId) throws DataAccessException {

		return findTrSearchSkillsByPrimaryKey(searchSkillId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSkillsByPrimaryKey
	 *
	 */

	@Transactional
	public TrSearchSkills findTrSearchSkillsByPrimaryKey(Integer searchSkillId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchSkillsByPrimaryKey", startResult, maxRows, searchSkillId);
			return (com.f9g4.domain.TrSearchSkills) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchSkillsBySearchSkillId
	 *
	 */
	@Transactional
	public TrSearchSkills findTrSearchSkillsBySearchSkillId(Integer searchSkillId) throws DataAccessException {

		return findTrSearchSkillsBySearchSkillId(searchSkillId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSkillsBySearchSkillId
	 *
	 */

	@Transactional
	public TrSearchSkills findTrSearchSkillsBySearchSkillId(Integer searchSkillId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchSkillsBySearchSkillId", startResult, maxRows, searchSkillId);
			return (com.f9g4.domain.TrSearchSkills) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchSkillsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSearchSkillsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSkillsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSkillsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSearchSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSkillsByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSearchSkillsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSkillsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSkillsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSearchSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchSkillsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSearchSkillsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchSkillsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSkills> findTrSearchSkillsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchSkillsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSearchSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSearchSkillss
	 *
	 */
	@Transactional
	public Set<TrSearchSkills> findAllTrSearchSkillss() throws DataAccessException {

		return findAllTrSearchSkillss(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSearchSkillss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchSkills> findAllTrSearchSkillss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSearchSkillss", startResult, maxRows);
		return new LinkedHashSet<TrSearchSkills>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrSearchSkills entity) {
		return true;
	}
}
