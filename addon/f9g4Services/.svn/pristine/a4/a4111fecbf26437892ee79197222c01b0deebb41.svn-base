package com.f9g4.dao;

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

import com.f9g4.domain.AdUserExpertises;

@Repository("AdUserExpertisesDAO")
@Transactional
public class AdUserExpertiseDAOImpl extends AbstractJpaDao<AdUserExpertises> implements AdUserExpertisesDAO {
	
	
	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserExpertises.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;
	
	

	public AdUserExpertiseDAOImpl() {
		super();
		
	}

	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}



	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	

	public Set<Class<?>> getTypes() {
		return dataTypes;
	}



	public boolean canBeMerged(AdUserExpertises o) {
			return true;
	}

	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdatedBy(
			Integer lastUpdatedBy) throws DataAccessException {
		return findAdUserExpertisesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdatedBy(
			Integer lastUpdatedBy, int startResult, int maxRows)
			throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertiseByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserExpertises>(query.getResultList());
	}

	public AdUserExpertises findAdUserExpertisesByUserExpertiseId(
			Integer userExpertiseId) throws DataAccessException {
			return findAdUserExpertisesByUserExpertiseId(userExpertiseId, -1, -1);
	}

	public AdUserExpertises findAdUserExpertisesByUserExpertiseId(
			Integer userExpertiseId, int startResult, int maxRows)
			throws DataAccessException {
		try {
			Query query = createNamedQuery(
					"findAdUserExpertisesByUserExpertiseId", startResult,
					maxRows, userExpertiseId);
			return (AdUserExpertises) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserExpertisesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserExpertisesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserExpertisesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertisesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserExpertises>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserExpertisesByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUserExpertisesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserExpertisesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertisesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUserExpertises>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserExpertisesByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserExpertisesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserExpertisesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertisesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserExpertises>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserExpertisess
	 *
	 */
	@Transactional
	public Set<AdUserExpertises> findAllAdUserExpertisess() throws DataAccessException {

		return findAllAdUserExpertisess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserExpertisess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserExpertises> findAllAdUserExpertisess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserExpertisess", startResult, maxRows);
		return new LinkedHashSet<AdUserExpertises>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserExpertisesByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserExpertisesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserExpertisesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserExpertises> findAdUserExpertisesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertisesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserExpertises>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserExpertisesByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserExpertises findAdUserExpertisesByPrimaryKey(Integer userExpertiseId) throws DataAccessException {

		return findAdUserExpertisesByPrimaryKey(userExpertiseId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserExpertisesByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserExpertises findAdUserExpertisesByPrimaryKey(Integer userExpertiseId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserExpertisesByPrimaryKey", startResult, maxRows, userExpertiseId);
			return (com.f9g4.domain.AdUserExpertises) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
