package com.f9g4.dao;

import com.f9g4.domain.TrPaymentAuthSubmit;

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
 * DAO to manage TrPaymentAuthSubmit entities.
 * 
 */
@Repository("TrPaymentAuthSubmitDAO")
@Transactional
public class TrPaymentAuthSubmitDAOImpl extends AbstractJpaDao<TrPaymentAuthSubmit>
		implements TrPaymentAuthSubmitDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrPaymentAuthSubmit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrPaymentAuthSubmitDAOImpl
	 *
	 */
	public TrPaymentAuthSubmitDAOImpl() {
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
	 * JPQL Query - findTrPaymentAuthSubmitByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrPaymentAuthSubmitByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrPaymentAuthSubmits
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmit> findAllTrPaymentAuthSubmits() throws DataAccessException {

		return findAllTrPaymentAuthSubmits(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrPaymentAuthSubmits
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmit> findAllTrPaymentAuthSubmits(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrPaymentAuthSubmits", startResult, maxRows);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrice
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByPrice(java.math.BigDecimal price) throws DataAccessException {

		return findTrPaymentAuthSubmitByPrice(price, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByPrice(java.math.BigDecimal price, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitByPrice", startResult, maxRows, price);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrPaymentAuthSubmitByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrimaryKey
	 *
	 */
	@Transactional
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByPrimaryKey(Integer authSubmitId) throws DataAccessException {

		return findTrPaymentAuthSubmitByPrimaryKey(authSubmitId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrimaryKey
	 *
	 */

	@Transactional
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByPrimaryKey(Integer authSubmitId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPaymentAuthSubmitByPrimaryKey", startResult, maxRows, authSubmitId);
			return (com.f9g4.domain.TrPaymentAuthSubmit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrPaymentAuthSubmitByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByAuthSubmitId
	 *
	 */
	@Transactional
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByAuthSubmitId(Integer authSubmitId) throws DataAccessException {

		return findTrPaymentAuthSubmitByAuthSubmitId(authSubmitId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByAuthSubmitId
	 *
	 */

	@Transactional
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByAuthSubmitId(Integer authSubmitId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPaymentAuthSubmitByAuthSubmitId", startResult, maxRows, authSubmitId);
			return (com.f9g4.domain.TrPaymentAuthSubmit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreationDate
	 *
	 */
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrPaymentAuthSubmitByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrPaymentAuthSubmit entity) {
		return true;
	}

	@SuppressWarnings("unchecked")
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitBySecureToken(
			String SecureToken) throws DataAccessException {
		Query query = createNamedQuery("findTrPaymentAuthSubmitBySecureToken",-1,-1,SecureToken);
		return new LinkedHashSet<TrPaymentAuthSubmit>(query.getResultList());
	}
}
