package com.f9g4.dao;

import com.f9g4.domain.TrMembershipAuthSubmit;

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
 * DAO to manage TrMembershipAuthSubmit entities.
 * 
 */
@Repository("TrMembershipAuthSubmitDAO")
@Transactional
public class TrMembershipAuthSubmitDAOImpl extends AbstractJpaDao<TrMembershipAuthSubmit> implements TrMembershipAuthSubmitDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrMembershipAuthSubmit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrMembershipAuthSubmitDAOImpl
	 *
	 */
	public TrMembershipAuthSubmitDAOImpl() {
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
	 * JPQL Query - findTrMembershipAuthSubmitByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrMembershipAuthSubmitByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMembershipAuthSubmitByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByChargeAmount
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByChargeAmount(java.math.BigDecimal chargeAmount) throws DataAccessException {

		return findTrMembershipAuthSubmitByChargeAmount(chargeAmount, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByChargeAmount
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByChargeAmount(java.math.BigDecimal chargeAmount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMembershipAuthSubmitByChargeAmount", startResult, maxRows, chargeAmount);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreationDate
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrMembershipAuthSubmitByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMembershipAuthSubmitByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByPrimaryKey
	 *
	 */
	@Transactional
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByPrimaryKey(Integer memAuthSubmitId) throws DataAccessException {

		return findTrMembershipAuthSubmitByPrimaryKey(memAuthSubmitId, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByPrimaryKey
	 *
	 */

	@Transactional
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByPrimaryKey(Integer memAuthSubmitId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrMembershipAuthSubmitByPrimaryKey", startResult, maxRows, memAuthSubmitId);
			return (com.f9g4.domain.TrMembershipAuthSubmit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByMemAuthSubmitId
	 *
	 */
	@Transactional
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByMemAuthSubmitId(Integer memAuthSubmitId) throws DataAccessException {

		return findTrMembershipAuthSubmitByMemAuthSubmitId(memAuthSubmitId, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByMemAuthSubmitId
	 *
	 */

	@Transactional
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByMemAuthSubmitId(Integer memAuthSubmitId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrMembershipAuthSubmitByMemAuthSubmitId", startResult, maxRows, memAuthSubmitId);
			return (com.f9g4.domain.TrMembershipAuthSubmit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByInitTimestamp
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByInitTimestamp(java.util.Calendar initTimestamp) throws DataAccessException {

		return findTrMembershipAuthSubmitByInitTimestamp(initTimestamp, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByInitTimestamp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByInitTimestamp(java.util.Calendar initTimestamp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMembershipAuthSubmitByInitTimestamp", startResult, maxRows, initTimestamp);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrMembershipAuthSubmitByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMembershipAuthSubmitByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrMembershipAuthSubmits
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findAllTrMembershipAuthSubmits() throws DataAccessException {

		return findAllTrMembershipAuthSubmits(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrMembershipAuthSubmits
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findAllTrMembershipAuthSubmits(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrMembershipAuthSubmits", startResult, maxRows);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrMembershipAuthSubmitByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMembershipAuthSubmitByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrMembershipAuthSubmit>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 *
	 */
	public boolean canBeMerged(TrMembershipAuthSubmit entity) {
		return true;
	}

	/**
	 * JPQL Query - findTrMembershipAuthSubmitBySecurityToken
	 *
	 */
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitBySecurityToken(String securityToken) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrMembershipAuthSubmitBySecurityToken", -1, -1, securityToken);
			return (com.f9g4.domain.TrMembershipAuthSubmit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}