package com.f9g4.dao;

import com.f9g4.domain.TrSalesTransactionDetails;

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
 * DAO to manage TrSalesTransactionDetails entities.
 * 
 */
@Repository("TrSalesTransactionDetailsDAO")
@Transactional
public class TrSalesTransactionDetailsDAOImpl extends AbstractJpaDao<TrSalesTransactionDetails>
		implements TrSalesTransactionDetailsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSalesTransactionDetails.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSalesTransactionDetailsDAOImpl
	 *
	 */
	public TrSalesTransactionDetailsDAOImpl() {
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
	 * JPQL Query - findTrSalesTransactionDetailsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSalesTransactionDetailsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsBySellerPayDate
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsBySellerPayDate(java.util.Calendar sellerPayDate) throws DataAccessException {

		return findTrSalesTransactionDetailsBySellerPayDate(sellerPayDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsBySellerPayDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsBySellerPayDate(java.util.Calendar sellerPayDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsBySellerPayDate", startResult, maxRows, sellerPayDate);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCommission
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCommission(java.math.BigDecimal commission) throws DataAccessException {

		return findTrSalesTransactionDetailsByCommission(commission, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCommission
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCommission(java.math.BigDecimal commission, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByCommission", startResult, maxRows, commission);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSalesTransactionDetailss
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findAllTrSalesTransactionDetailss() throws DataAccessException {

		return findAllTrSalesTransactionDetailss(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSalesTransactionDetailss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findAllTrSalesTransactionDetailss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSalesTransactionDetailss", startResult, maxRows);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSalesTransactionDetailsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsBySalesTrxDetailId
	 *
	 */
	@Transactional
	public TrSalesTransactionDetails findTrSalesTransactionDetailsBySalesTrxDetailId(Integer salesTrxDetailId) throws DataAccessException {

		return findTrSalesTransactionDetailsBySalesTrxDetailId(salesTrxDetailId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsBySalesTrxDetailId
	 *
	 */

	@Transactional
	public TrSalesTransactionDetails findTrSalesTransactionDetailsBySalesTrxDetailId(Integer salesTrxDetailId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSalesTransactionDetailsBySalesTrxDetailId", startResult, maxRows, salesTrxDetailId);
			return (com.f9g4.domain.TrSalesTransactionDetails) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByPrimaryKey
	 *
	 */
	@Transactional
	public TrSalesTransactionDetails findTrSalesTransactionDetailsByPrimaryKey(Integer salesTrxDetailId) throws DataAccessException {

		return findTrSalesTransactionDetailsByPrimaryKey(salesTrxDetailId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByPrimaryKey
	 *
	 */

	@Transactional
	public TrSalesTransactionDetails findTrSalesTransactionDetailsByPrimaryKey(Integer salesTrxDetailId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSalesTransactionDetailsByPrimaryKey", startResult, maxRows, salesTrxDetailId);
			return (com.f9g4.domain.TrSalesTransactionDetails) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsBySellerShare
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsBySellerShare(java.math.BigDecimal sellerShare) throws DataAccessException {

		return findTrSalesTransactionDetailsBySellerShare(sellerShare, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsBySellerShare
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsBySellerShare(java.math.BigDecimal sellerShare, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsBySellerShare", startResult, maxRows, sellerShare);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSalesTransactionDetailsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSalesTransactionDetailsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByPaymentStatusId
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByPaymentStatusId(Integer paymentStatusId) throws DataAccessException {

		return findTrSalesTransactionDetailsByPaymentStatusId(paymentStatusId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByPaymentStatusId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByPaymentStatusId(Integer paymentStatusId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByPaymentStatusId", startResult, maxRows, paymentStatusId);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCommentsContaining
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCommentsContaining(String comments) throws DataAccessException {

		return findTrSalesTransactionDetailsByCommentsContaining(comments, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByCommentsContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByCommentsContaining(String comments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByCommentsContaining", startResult, maxRows, comments);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByComments
	 *
	 */
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByComments(String comments) throws DataAccessException {

		return findTrSalesTransactionDetailsByComments(comments, -1, -1);
	}

	/**
	 * JPQL Query - findTrSalesTransactionDetailsByComments
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSalesTransactionDetails> findTrSalesTransactionDetailsByComments(String comments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSalesTransactionDetailsByComments", startResult, maxRows, comments);
		return new LinkedHashSet<TrSalesTransactionDetails>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrSalesTransactionDetails entity) {
		return true;
	}
}
