package com.f9g4.dao;

import com.f9g4.domain.TrPaymentAuthSubmitHeader;

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
 * DAO to manage TrPaymentAuthSubmitHeader entities.
 * 
 */
@Repository("TrPaymentAuthSubmitHeaderDAO")
@Transactional
public class TrPaymentAuthSubmitHeaderDAOImpl extends AbstractJpaDao<TrPaymentAuthSubmitHeader> implements TrPaymentAuthSubmitHeaderDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrPaymentAuthSubmitHeader.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrPaymentAuthSubmitHeaderDAOImpl
	 *
	 */
	public TrPaymentAuthSubmitHeaderDAOImpl() {
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
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByBatchTrxId
	 *
	 */
	@Transactional
	public TrPaymentAuthSubmitHeader findTrPaymentAuthSubmitHeaderByBatchTrxId(Integer batchTrxId) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByBatchTrxId(batchTrxId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByBatchTrxId
	 *
	 */

	@Transactional
	public TrPaymentAuthSubmitHeader findTrPaymentAuthSubmitHeaderByBatchTrxId(Integer batchTrxId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByBatchTrxId", startResult, maxRows, batchTrxId);
			return (com.f9g4.domain.TrPaymentAuthSubmitHeader) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByShipping
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByShipping(java.math.BigDecimal shipping) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByShipping(shipping, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByShipping
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByShipping(java.math.BigDecimal shipping, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByShipping", startResult, maxRows, shipping);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByTotal
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByTotal(java.math.BigDecimal total) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByTotal(total, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByTotal
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByTotal(java.math.BigDecimal total, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByTotal", startResult, maxRows, total);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrPaymentAuthSubmitHeaders
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findAllTrPaymentAuthSubmitHeaders() throws DataAccessException {

		return findAllTrPaymentAuthSubmitHeaders(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrPaymentAuthSubmitHeaders
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findAllTrPaymentAuthSubmitHeaders(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrPaymentAuthSubmitHeaders", startResult, maxRows);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByPrimaryKey
	 *
	 */
	@Transactional
	public TrPaymentAuthSubmitHeader findTrPaymentAuthSubmitHeaderByPrimaryKey(Integer batchTrxId) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByPrimaryKey(batchTrxId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByPrimaryKey
	 *
	 */

	@Transactional
	public TrPaymentAuthSubmitHeader findTrPaymentAuthSubmitHeaderByPrimaryKey(Integer batchTrxId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByPrimaryKey", startResult, maxRows, batchTrxId);
			return (com.f9g4.domain.TrPaymentAuthSubmitHeader) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderBySubtotal
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderBySubtotal(java.math.BigDecimal subtotal) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderBySubtotal(subtotal, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderBySubtotal
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderBySubtotal(java.math.BigDecimal subtotal, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderBySubtotal", startResult, maxRows, subtotal);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByTax
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByTax(java.math.BigDecimal tax) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByTax(tax, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByTax
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByTax(java.math.BigDecimal tax, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByTax", startResult, maxRows, tax);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByCreationDate
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrPaymentAuthSubmitHeaderByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitHeaderByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmitHeader> findTrPaymentAuthSubmitHeaderByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrPaymentAuthSubmitHeader>(query.getResultList());
	}

	@Transactional
	public TrPaymentAuthSubmitHeader findTrPaymentAuthSubmitHeaderBySecureToken(String secureToken) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPaymentAuthSubmitHeaderBySecureToken", -1, -1, secureToken);
			return (com.f9g4.domain.TrPaymentAuthSubmitHeader) query.getSingleResult();
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
	public boolean canBeMerged(TrPaymentAuthSubmitHeader entity) {
		return true;
	}

	
}
