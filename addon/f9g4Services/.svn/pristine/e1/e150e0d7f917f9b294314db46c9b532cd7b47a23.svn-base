package com.f9g4.dao;

import com.f9g4.domain.TrSearchCategories;

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
 * DAO to manage TrSearchCategories entities.
 * 
 */
@Repository("TrSearchCategoriesDAO")
@Transactional
public class TrSearchCategoriesDAOImpl extends AbstractJpaDao<TrSearchCategories>
		implements TrSearchCategoriesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSearchCategories.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSearchCategoriesDAOImpl
	 *
	 */
	public TrSearchCategoriesDAOImpl() {
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
	 * JPQL Query - findTrSearchCategoriesByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSearchCategoriesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchCategoriesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSearchCategories>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSearchCategoriesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchCategoriesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSearchCategories>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSearchCategoriess
	 *
	 */
	@Transactional
	public Set<TrSearchCategories> findAllTrSearchCategoriess() throws DataAccessException {

		return findAllTrSearchCategoriess(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSearchCategoriess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchCategories> findAllTrSearchCategoriess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSearchCategoriess", startResult, maxRows);
		return new LinkedHashSet<TrSearchCategories>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSearchCategoriesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchCategoriesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSearchCategories>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSearchCategoriesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearchCategories> findTrSearchCategoriesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchCategoriesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSearchCategories>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByPrimaryKey
	 *
	 */
	@Transactional
	public TrSearchCategories findTrSearchCategoriesByPrimaryKey(Integer searchCategoryId) throws DataAccessException {

		return findTrSearchCategoriesByPrimaryKey(searchCategoryId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchCategoriesByPrimaryKey
	 *
	 */

	@Transactional
	public TrSearchCategories findTrSearchCategoriesByPrimaryKey(Integer searchCategoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchCategoriesByPrimaryKey", startResult, maxRows, searchCategoryId);
			return (com.f9g4.domain.TrSearchCategories) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchCategoriesBySearchCategoryId
	 *
	 */
	@Transactional
	public TrSearchCategories findTrSearchCategoriesBySearchCategoryId(Integer searchCategoryId) throws DataAccessException {

		return findTrSearchCategoriesBySearchCategoryId(searchCategoryId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchCategoriesBySearchCategoryId
	 *
	 */

	@Transactional
	public TrSearchCategories findTrSearchCategoriesBySearchCategoryId(Integer searchCategoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchCategoriesBySearchCategoryId", startResult, maxRows, searchCategoryId);
			return (com.f9g4.domain.TrSearchCategories) query.getSingleResult();
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
	public boolean canBeMerged(TrSearchCategories entity) {
		return true;
	}
}
