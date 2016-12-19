package com.f9g4.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.domain.AdUserEducations;
import com.f9g4.domain.AdUserEducations;


@Repository("AdUserEducationsDAO")
@Transactional
public class AdUserEducationsDAOImpl extends AbstractJpaDao<AdUserEducations> implements AdUserEducationsDAO {
	
	
	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserEducations.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;
	
	

	public AdUserEducationsDAOImpl() {
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



	public boolean canBeMerged(AdUserEducations o) {
			return true;
	}

	public Set<AdUserEducations> findAdUserEducationsByLastUpdatedBy(
			Integer lastUpdatedBy) throws DataAccessException {
		return findAdUserEducationsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByLastUpdatedBy(
			Integer lastUpdatedBy, int startResult, int maxRows)
			throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertiseByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserEducations>(query.getResultList());
	}

	public AdUserEducations findAdUserEducationsByUserEducationId(
			Integer userEducationId) throws DataAccessException {
			return findAdUserEducationsByUserEducationId(userEducationId, -1, -1);
	}

	public AdUserEducations findAdUserEducationsByUserEducationId(
			Integer userEducationId, int startResult, int maxRows)
			throws DataAccessException {
		try {
			Query query = createNamedQuery(
					"findAdUserEducationsByUserExpertiseId", startResult,
					maxRows, userEducationId);
			return (AdUserEducations) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserEducationsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserEducationsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserEducationsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserEducationsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserEducations>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserEducationsByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUserEducationsByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserEducationsByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserEducationsByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUserEducations>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserEducationsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserEducationsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserEducationsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserEducationsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserEducations>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserEducationss
	 *
	 */
	@Transactional
	public Set<AdUserEducations> findAllAdUserEducationss() throws DataAccessException {

		return findAllAdUserEducationss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserEducationss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserEducations> findAllAdUserEducationss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserEducationss", startResult, maxRows);
		return new LinkedHashSet<AdUserEducations>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserEducationsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserEducationsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserEducationsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserEducations> findAdUserEducationsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserEducationsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserEducations>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserEducationsByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserEducations findAdUserEducationsByPrimaryKey(Integer userEducationId) throws DataAccessException {

		return findAdUserEducationsByPrimaryKey(userEducationId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserEducationsByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserEducations findAdUserEducationsByPrimaryKey(Integer userEducationId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserEducationsByPrimaryKey", startResult, maxRows, userEducationId);
			return (com.f9g4.domain.AdUserEducations) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
