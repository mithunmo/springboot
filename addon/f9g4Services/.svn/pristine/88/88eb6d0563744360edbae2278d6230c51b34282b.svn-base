package com.f9g4.dao;

import com.f9g4.domain.AdUserSkills;

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
 * DAO to manage AdUserSkills entities.
 * 
 */
@Repository("AdUserSkillsDAO")
@Transactional
public class AdUserSkillsDAOImpl extends AbstractJpaDao<AdUserSkills> implements
		AdUserSkillsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserSkills.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdUserSkillsDAOImpl
	 *
	 */
	public AdUserSkillsDAOImpl() {
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
	 * JPQL Query - findAdUserSkillsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdUserSkillsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSkillsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSkillsByUserSkillId
	 *
	 */
	@Transactional
	public AdUserSkills findAdUserSkillsByUserSkillId(Integer userSkillId) throws DataAccessException {

		return findAdUserSkillsByUserSkillId(userSkillId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByUserSkillId
	 *
	 */

	@Transactional
	public AdUserSkills findAdUserSkillsByUserSkillId(Integer userSkillId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserSkillsByUserSkillId", startResult, maxRows, userSkillId);
			return (com.f9g4.domain.AdUserSkills) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserSkillsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSkillsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSkillsByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUserSkillsByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSkillsByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUserSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSkillsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserSkillsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSkillsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserSkillss
	 *
	 */
	@Transactional
	public Set<AdUserSkills> findAllAdUserSkillss() throws DataAccessException {

		return findAllAdUserSkillss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserSkillss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSkills> findAllAdUserSkillss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserSkillss", startResult, maxRows);
		return new LinkedHashSet<AdUserSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSkillsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserSkillsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSkills> findAdUserSkillsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSkillsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserSkills>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSkillsByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserSkills findAdUserSkillsByPrimaryKey(Integer userSkillId) throws DataAccessException {

		return findAdUserSkillsByPrimaryKey(userSkillId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSkillsByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserSkills findAdUserSkillsByPrimaryKey(Integer userSkillId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserSkillsByPrimaryKey", startResult, maxRows, userSkillId);
			return (com.f9g4.domain.AdUserSkills) query.getSingleResult();
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
	public boolean canBeMerged(AdUserSkills entity) {
		return true;
	}
}
