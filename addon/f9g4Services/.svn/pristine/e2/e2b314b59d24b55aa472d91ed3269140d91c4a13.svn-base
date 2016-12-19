package com.f9g4.dao;

import com.f9g4.domain.TrReceiveMembershipPayments;

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
 * DAO to manage TrReceiveMembershipPayments entities.
 * 
 */
@Repository("TrReceiveMembershipPaymentsDAO")
@Transactional
public class TrReceiveMembershipPaymentsDAOImpl extends AbstractJpaDao<TrReceiveMembershipPayments>
		implements TrReceiveMembershipPaymentsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrReceiveMembershipPayments.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrReceiveMembershipPaymentsDAOImpl
	 *
	 */
	public TrReceiveMembershipPaymentsDAOImpl() {
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
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreationDate
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByMemPaymentId
	 *
	 */
	@Transactional
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByMemPaymentId(Integer memPaymentId) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByMemPaymentId(memPaymentId, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByMemPaymentId
	 *
	 */

	@Transactional
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByMemPaymentId(Integer memPaymentId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrReceiveMembershipPaymentsByMemPaymentId", startResult, maxRows, memPaymentId);
			return (com.f9g4.domain.TrReceiveMembershipPayments) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcode
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcode(String authcode) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByAuthcode(authcode, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcode(String authcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByAuthcode", startResult, maxRows, authcode);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentAmount
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentAmount(java.math.BigDecimal paymentAmount) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByPaymentAmount(paymentAmount, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentAmount
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentAmount(java.math.BigDecimal paymentAmount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByPaymentAmount", startResult, maxRows, paymentAmount);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentError
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentError(String paymentError) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByPaymentError(paymentError, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentError
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentError(String paymentError, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByPaymentError", startResult, maxRows, paymentError);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentErrorContaining
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentErrorContaining(String paymentError) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByPaymentErrorContaining(paymentError, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentErrorContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentErrorContaining(String paymentError, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByPaymentErrorContaining", startResult, maxRows, paymentError);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcodeContaining
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcodeContaining(String authcode) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByAuthcodeContaining(authcode, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcodeContaining(String authcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByAuthcodeContaining", startResult, maxRows, authcode);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrReceiveMembershipPaymentss
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findAllTrReceiveMembershipPaymentss() throws DataAccessException {

		return findAllTrReceiveMembershipPaymentss(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrReceiveMembershipPaymentss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findAllTrReceiveMembershipPaymentss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrReceiveMembershipPaymentss", startResult, maxRows);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByReceivedTimestamp
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByReceivedTimestamp(java.util.Calendar receivedTimestamp) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByReceivedTimestamp(receivedTimestamp, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByReceivedTimestamp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByReceivedTimestamp(java.util.Calendar receivedTimestamp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByReceivedTimestamp", startResult, maxRows, receivedTimestamp);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedByContaining
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedByContaining(String createdBy) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByCreatedByContaining(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedByContaining(String createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByCreatedByContaining", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedBy(String createdBy) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedBy(String createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthStatusId
	 *
	 */
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthStatusId(Integer authStatusId) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByAuthStatusId(authStatusId, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthStatusId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthStatusId(Integer authStatusId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReceiveMembershipPaymentsByAuthStatusId", startResult, maxRows, authStatusId);
		return new LinkedHashSet<TrReceiveMembershipPayments>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPrimaryKey
	 *
	 */
	@Transactional
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByPrimaryKey(Integer memPaymentId) throws DataAccessException {

		return findTrReceiveMembershipPaymentsByPrimaryKey(memPaymentId, -1, -1);
	}

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPrimaryKey
	 *
	 */

	@Transactional
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByPrimaryKey(Integer memPaymentId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrReceiveMembershipPaymentsByPrimaryKey", startResult, maxRows, memPaymentId);
			return (com.f9g4.domain.TrReceiveMembershipPayments) query.getSingleResult();
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
	public boolean canBeMerged(TrReceiveMembershipPayments entity) {
		return true;
	}
}
