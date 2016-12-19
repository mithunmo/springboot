package com.f9g4.dao;

import com.f9g4.domain.TrSalesTransactionHeader;

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
 * DAO to manage TrSalesTransactionHeader entities.
 * 
 */
@Repository("TrSalesTransactionHeaderDAO")
@Transactional
public class TrSalesTransactionHeaderDAOImpl extends AbstractJpaDao<TrSalesTransactionHeader>
		implements TrSalesTransactionHeaderDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSalesTransactionHeader.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSalesTransactionHeaderDAOImpl
	 *
	 */
	public TrSalesTransactionHeaderDAOImpl() {
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
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentAuthCodeContaining
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentAuthCodeContaining(String paymentAuthCode) throws DataAccessException {

		return findTrSalesTransactionHeaderByPaymentAuthCodeContaining(paymentAuthCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentAuthCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentAuthCodeContaining(String paymentAuthCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByPaymentAuthCodeContaining", startResult, maxRows, paymentAuthCode);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPrimaryKey
	 *
	 */
	@Transactional
	public TrSalesTransactionHeader findTrSalesTransactionHeaderByPrimaryKey(Integer salesTrxId) throws DataAccessException {

		return findTrSalesTransactionHeaderByPrimaryKey(salesTrxId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPrimaryKey
	 *
	 */

	@Transactional
	public TrSalesTransactionHeader findTrSalesTransactionHeaderByPrimaryKey(Integer salesTrxId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSalesTransactionHeaderByPrimaryKey", startResult, maxRows, salesTrxId);
			return (com.f9g4.domain.TrSalesTransactionHeader) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSalesTransactionHeaderByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentErrorMsgContaining
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentErrorMsgContaining(String paymentErrorMsg) throws DataAccessException {

		return findTrSalesTransactionHeaderByPaymentErrorMsgContaining(paymentErrorMsg, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentErrorMsgContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentErrorMsgContaining(String paymentErrorMsg, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByPaymentErrorMsgContaining", startResult, maxRows, paymentErrorMsg);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSalesTransactionHeaders
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findAllTrSalesTransactionHeaders() throws DataAccessException {

		return findAllTrSalesTransactionHeaders(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSalesTransactionHeaders
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findAllTrSalesTransactionHeaders(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSalesTransactionHeaders", startResult, maxRows);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSalesTransactionHeaderByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentAuthCode
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentAuthCode(String paymentAuthCode) throws DataAccessException {

		return findTrSalesTransactionHeaderByPaymentAuthCode(paymentAuthCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentAuthCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentAuthCode(String paymentAuthCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByPaymentAuthCode", startResult, maxRows, paymentAuthCode);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentTimestamp
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentTimestamp(java.util.Calendar paymentTimestamp) throws DataAccessException {

		return findTrSalesTransactionHeaderByPaymentTimestamp(paymentTimestamp, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentTimestamp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentTimestamp(java.util.Calendar paymentTimestamp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByPaymentTimestamp", startResult, maxRows, paymentTimestamp);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSalesTransactionHeaderByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentErrorMsg
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentErrorMsg(String paymentErrorMsg) throws DataAccessException {

		return findTrSalesTransactionHeaderByPaymentErrorMsg(paymentErrorMsg, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentErrorMsg
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentErrorMsg(String paymentErrorMsg, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByPaymentErrorMsg", startResult, maxRows, paymentErrorMsg);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSalesTransactionHeaderByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderBySalesTrxId
	 *
	 */
	@Transactional
	public TrSalesTransactionHeader findTrSalesTransactionHeaderBySalesTrxId(Integer salesTrxId) throws DataAccessException {

		return findTrSalesTransactionHeaderBySalesTrxId(salesTrxId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderBySalesTrxId
	 *
	 */

	@Transactional
	public TrSalesTransactionHeader findTrSalesTransactionHeaderBySalesTrxId(Integer salesTrxId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSalesTransactionHeaderBySalesTrxId", startResult, maxRows, salesTrxId);
			return (com.f9g4.domain.TrSalesTransactionHeader) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentStatusId
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentStatusId(Integer paymentStatusId) throws DataAccessException {

		return findTrSalesTransactionHeaderByPaymentStatusId(paymentStatusId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionHeaderByPaymentStatusId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionHeader> findTrSalesTransactionHeaderByPaymentStatusId(Integer paymentStatusId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionHeaderByPaymentStatusId", startResult, maxRows, paymentStatusId);
		return new LinkedHashSet<TrSalesTransactionHeader>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrSalesTransactionHeader entity) {
		return true;
	}
}
