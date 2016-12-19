package com.f9g4.dao;

import com.f9g4.domain.AdActiveUsers;

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
 * DAO to manage AdActiveUsers entities.
 * 
 */
@Repository("AdActiveUsersDAO")
@Transactional
public class AdActiveUsersDAOImpl extends AbstractJpaDao<AdActiveUsers>
		implements AdActiveUsersDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdActiveUsers.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdActiveUsersDAOImpl
	 *
	 */
	public AdActiveUsersDAOImpl() {
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
	 * JPQL Query - findAdActiveUsersByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdActiveUsersByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdActiveUsersByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByPrimaryKey
	 *
	 */
	@Transactional
	public AdActiveUsers findAdActiveUsersByPrimaryKey(Integer activeUserId) throws DataAccessException {

		return findAdActiveUsersByPrimaryKey(activeUserId, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByPrimaryKey
	 *
	 */

	@Transactional
	public AdActiveUsers findAdActiveUsersByPrimaryKey(Integer activeUserId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdActiveUsersByPrimaryKey", startResult, maxRows, activeUserId);
			return (com.f9g4.domain.AdActiveUsers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAdActiveUserss
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAllAdActiveUserss() throws DataAccessException {

		return findAllAdActiveUserss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdActiveUserss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAllAdActiveUserss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdActiveUserss", startResult, maxRows);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByActiveUserId
	 *
	 */
	@Transactional
	public AdActiveUsers findAdActiveUsersByActiveUserId(Integer activeUserId) throws DataAccessException {

		return findAdActiveUsersByActiveUserId(activeUserId, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByActiveUserId
	 *
	 */

	@Transactional
	public AdActiveUsers findAdActiveUsersByActiveUserId(Integer activeUserId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdActiveUsersByActiveUserId", startResult, maxRows, activeUserId);
			return (com.f9g4.domain.AdActiveUsers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdActiveUsersBySessionId
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersBySessionId(Integer sessionId) throws DataAccessException {

		return findAdActiveUsersBySessionId(sessionId, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersBySessionId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersBySessionId(Integer sessionId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersBySessionId", startResult, maxRows, sessionId);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByCreationDate
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdActiveUsersByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdActiveUsersByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByLogoutDate
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLogoutDate(java.util.Calendar logoutDate) throws DataAccessException {

		return findAdActiveUsersByLogoutDate(logoutDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByLogoutDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLogoutDate(java.util.Calendar logoutDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersByLogoutDate", startResult, maxRows, logoutDate);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersByLoginDate
	 *
	 */
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLoginDate(java.util.Calendar loginDate) throws DataAccessException {

		return findAdActiveUsersByLoginDate(loginDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdActiveUsersByLoginDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdActiveUsers> findAdActiveUsersByLoginDate(java.util.Calendar loginDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdActiveUsersByLoginDate", startResult, maxRows, loginDate);
		return new LinkedHashSet<AdActiveUsers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdActiveUsersBySessionId
	 *
	 */
	@Transactional
	public AdActiveUsers findAdActiveUsersSingleResultBySessionId(String sessionId) throws DataAccessException {
		
		try {
			Query query = createNamedQuery("findAdActiveUsersBySessionId", -1, -1, sessionId);
			return (com.f9g4.domain.AdActiveUsers) query.getSingleResult();
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
	public boolean canBeMerged(AdActiveUsers entity) {
		return true;
	}
}
