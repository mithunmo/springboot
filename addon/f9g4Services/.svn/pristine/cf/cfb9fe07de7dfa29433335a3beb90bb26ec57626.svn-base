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

import com.f9g4.domain.AdUserDegaccs;

@Repository("AdUserDegaccsDAO")
@Transactional
public class AdUserDegaccsDAOImpl extends AbstractJpaDao<AdUserDegaccs> implements
		AdUserDegaccsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserDegaccs.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;
	
	

	public AdUserDegaccsDAOImpl() {
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



	public boolean canBeMerged(AdUserDegaccs o) {
			return true;
	}

	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdatedBy(
			Integer lastUpdatedBy) throws DataAccessException {
		return findAdUserDegaccsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdatedBy(
			Integer lastUpdatedBy, int startResult, int maxRows)
			throws DataAccessException {
		Query query = createNamedQuery("findAdUserExpertiseByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserDegaccs>(query.getResultList());
	}

	public AdUserDegaccs findAdUserDegaccsByUserDegaccsId(
			Integer userDegaccsId) throws DataAccessException {
			return findAdUserDegaccsByUserDegaccsId(userDegaccsId, -1, -1);
	}

	public AdUserDegaccs findAdUserDegaccsByUserDegaccsId(
			Integer userDegaccsId, int startResult, int maxRows)
			throws DataAccessException {
		try {
			Query query = createNamedQuery(
					"findAdUserDegaccsByUserExpertiseId", startResult,
					maxRows, userDegaccsId);
			return (AdUserDegaccs) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserDegaccsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserDegaccsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDegaccsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDegaccsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserDegaccs>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDegaccsByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdUserDegaccsByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDegaccsByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDegaccsByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdUserDegaccs>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDegaccsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserDegaccsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDegaccsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDegaccsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserDegaccs>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserDegaccss
	 *
	 */
	@Transactional
	public Set<AdUserDegaccs> findAllAdUserDegaccss() throws DataAccessException {

		return findAllAdUserDegaccss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserDegaccss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDegaccs> findAllAdUserDegaccss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserDegaccss", startResult, maxRows);
		return new LinkedHashSet<AdUserDegaccs>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDegaccsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserDegaccsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDegaccsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDegaccs> findAdUserDegaccsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDegaccsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserDegaccs>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDegaccsByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserDegaccs findAdUserDegaccsByPrimaryKey(Integer userDegaccsId) throws DataAccessException {

		return findAdUserDegaccsByPrimaryKey(userDegaccsId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDegaccsByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserDegaccs findAdUserDegaccsByPrimaryKey(Integer userDegaccsId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserDegaccsByPrimaryKey", startResult, maxRows, userDegaccsId);
			return (com.f9g4.domain.AdUserDegaccs) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}



}
