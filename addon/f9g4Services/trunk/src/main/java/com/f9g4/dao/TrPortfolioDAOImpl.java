package com.f9g4.dao;

import com.f9g4.domain.TrPortfolio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage TrPortfolio entities.
 * 
 */
@Repository("TrPortfolioDAO")
@Transactional
public class TrPortfolioDAOImpl extends AbstractJpaDao<TrPortfolio> implements
		TrPortfolioDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrPortfolio.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrPortfolioDAOImpl
	 *
	 */
	public TrPortfolioDAOImpl() {
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
	 * JPQL Query - findTrPortfolioByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrPortfolioByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByDescription
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByDescription(String description) throws DataAccessException {

		return findTrPortfolioByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByDescription", startResult, maxRows, description);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByCreationDate
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrPortfolioByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByActiveStatus
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findTrPortfolioByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrPortfolioByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByLangCode
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLangCode(String langCode) throws DataAccessException {

		return findTrPortfolioByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByPortfolioId
	 *
	 */
	@Transactional
	public TrPortfolio findTrPortfolioByPortfolioId(Integer portfolioId) throws DataAccessException {

		return findTrPortfolioByPortfolioId(portfolioId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByPortfolioId
	 *
	 */

	@Transactional
	public TrPortfolio findTrPortfolioByPortfolioId(Integer portfolioId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPortfolioByPortfolioId", startResult, maxRows, portfolioId);
			return (com.f9g4.domain.TrPortfolio) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPortfolioByNameContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByNameContaining(String name) throws DataAccessException {

		return findTrPortfolioByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByPrimaryKey
	 *
	 */
	@Transactional
	public TrPortfolio findTrPortfolioByPrimaryKey(Integer portfolioId) throws DataAccessException {

		return findTrPortfolioByPrimaryKey(portfolioId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByPrimaryKey
	 *
	 */

	@Transactional
	public TrPortfolio findTrPortfolioByPrimaryKey(Integer portfolioId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPortfolioByPrimaryKey", startResult, maxRows, portfolioId);
			return (com.f9g4.domain.TrPortfolio) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	
	@Transactional
	public  Set<TrPortfolio> findTrPortfolioByUserId(Integer userId) throws DataAccessException {

		return findTrPortfolioByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByPrimaryKey
	 *
	 */

	@Transactional
	public  Set<TrPortfolio> findTrPortfolioByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPortfolioByUserId", startResult, maxRows, userId);
			  return new LinkedHashSet<TrPortfolio>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllTrPortfolios
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findAllTrPortfolios() throws DataAccessException {

		return findAllTrPortfolios(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrPortfolios
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findAllTrPortfolios(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrPortfolios", startResult, maxRows);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrPortfolioByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByDescriptionContaining(String description) throws DataAccessException {

		return findTrPortfolioByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLangCodeContaining(String langCode) throws DataAccessException {

		return findTrPortfolioByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioByName
	 *
	 */
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByName(String name) throws DataAccessException {

		return findTrPortfolioByName(name, -1, -1);
	}
	
	/**
	 * JPQL Query - findTrPortfolioByName
	 *
	 */
	@Transactional
	public  Set<TrPortfolio> findUnsellableTrPortfolioByUserId(Integer userId) throws DataAccessException {

		return findUnsellableTrPortfolioByUserId(userId, -1, -1);
	}
	
	@Transactional
	public  Set<TrPortfolio> findUnsellableTrPortfolioByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUnsellableTrPortfolioByUserId", startResult, maxRows, userId);
			  return new LinkedHashSet<TrPortfolio>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	@Transactional
	public  Set<TrPortfolio> findTrPortfolioByUserIdAndSellable(Integer userId, Integer sellable) throws DataAccessException
	{
		try {
			Query query = createNamedQuery("findTrPortfolioByUserIdAndSellable", -1, -1, userId, sellable);
			  return new LinkedHashSet<TrPortfolio>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPortfolioByName
	 *
	 */
	

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolio> findTrPortfolioByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioByName", startResult, maxRows, name);
		return new LinkedHashSet<TrPortfolio>(query.getResultList());
	}
	
	public Long checkBoardStatusByPortfolioId(int portfolioId) throws DataAccessException {
		String queryStr= "select count(*) from TrBoard myTrBoard where myTrboard.trPortfolio.portfolioId = ? and myTrboard.adLookupValuesStatusId.lookupValueId in (468,534)";
		
		Query countQuery = entityManager.createQuery(queryStr);
		
		countQuery.setParameter(1,portfolioId);
		Long total = (Long) countQuery.getSingleResult();
		return total;
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrPortfolio entity) {
		return true;
	}
}
