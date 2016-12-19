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

import com.f9g4.domain.AdUserSpecialities;

@Repository("AdUserSpecialitiesDAO")
@Transactional
public class AdUserSpecialitiesDAOImpl extends AbstractJpaDao<AdUserSpecialities> implements AdUserSpecialitiesDAO {
	
	
	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserSpecialities.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;
	
	

	public AdUserSpecialitiesDAOImpl() {
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



	public boolean canBeMerged(AdUserSpecialities o) {
			return true;
	}

	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdatedBy(
			Integer lastUpdatedBy) throws DataAccessException {
		return findAdUserSpecialitiesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdatedBy(
			Integer lastUpdatedBy, int startResult, int maxRows)
			throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertiseByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserSpecialities>(query.getResultList());
	}

	public AdUserSpecialities findAdUserSpecialitiesByUserSpecialitiesId(
			Integer userSpecialitiesId) throws DataAccessException {
			return findAdUserSpecialitiesByUserSpecialitiesId(userSpecialitiesId, -1, -1);
	}

	public AdUserSpecialities findAdUserSpecialitiesByUserSpecialitiesId(
			Integer userSpecialitiesId, int startResult, int maxRows)
			throws DataAccessException {
		try {
			Query query = createNamedQuery(
					"findAdUserSpecialitiesByUserExpertiseId", startResult,
					maxRows, userSpecialitiesId);
			return (AdUserSpecialities) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserSpecialitiesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSpecialitiesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserSpecialities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUserSpecialitiesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSpecialitiesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUserSpecialities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserSpecialitiesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSpecialitiesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserSpecialities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserSpecialitiess
	 *
	 */
	@Transactional
	public Set<AdUserSpecialities> findAllAdUserSpecialitiess() throws DataAccessException {

		return findAllAdUserSpecialitiess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserSpecialitiess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSpecialities> findAllAdUserSpecialitiess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserSpecialitiess", startResult, maxRows);
		return new LinkedHashSet<AdUserSpecialities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserSpecialitiesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserSpecialitiesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserSpecialities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserSpecialities findAdUserSpecialitiesByPrimaryKey(Integer userSpecialitiesId) throws DataAccessException {

		return findAdUserSpecialitiesByPrimaryKey(userSpecialitiesId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserSpecialitiesByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserSpecialities findAdUserSpecialitiesByPrimaryKey(Integer userSpecialitiesId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserSpecialitiesByPrimaryKey", startResult, maxRows, userSpecialitiesId);
			return (com.f9g4.domain.AdUserSpecialities) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
