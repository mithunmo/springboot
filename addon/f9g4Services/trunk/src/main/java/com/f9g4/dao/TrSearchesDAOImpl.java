package com.f9g4.dao;

import com.f9g4.domain.TrSearches;

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
 * DAO to manage TrSearches entities.
 * 
 */
@Repository("TrSearchesDAO")
@Transactional
public class TrSearchesDAOImpl extends AbstractJpaDao<TrSearches> implements
		TrSearchesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSearches.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSearchesDAOImpl
	 *
	 */
	public TrSearchesDAOImpl() {
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
	 * JPQL Query - findTrSearchesBySchoolAwardsContaining
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesBySchoolAwardsContaining(String schoolAwards) throws DataAccessException {

		return findTrSearchesBySchoolAwardsContaining(schoolAwards, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesBySchoolAwardsContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesBySchoolAwardsContaining(String schoolAwards, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesBySchoolAwardsContaining", startResult, maxRows, schoolAwards);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrSearchesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrSearchess
	 *
	 */
	@Transactional
	public Set<TrSearches> findAllTrSearchess() throws DataAccessException {

		return findAllTrSearchess(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrSearchess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findAllTrSearchess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrSearchess", startResult, maxRows);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByRating
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByRating(java.math.BigDecimal rating) throws DataAccessException {

		return findTrSearchesByRating(rating, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByRating
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByRating(java.math.BigDecimal rating, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByRating", startResult, maxRows, rating);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByCreationDate
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrSearchesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByPrimaryKey
	 *
	 */
	@Transactional
	public TrSearches findTrSearchesByPrimaryKey(Integer searchId) throws DataAccessException {

		return findTrSearchesByPrimaryKey(searchId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByPrimaryKey
	 *
	 */

	@Transactional
	public TrSearches findTrSearchesByPrimaryKey(Integer searchId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchesByPrimaryKey", startResult, maxRows, searchId);
			return (com.f9g4.domain.TrSearches) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchesByFromPrice
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByFromPrice(java.math.BigDecimal fromPrice) throws DataAccessException {

		return findTrSearchesByFromPrice(fromPrice, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByFromPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByFromPrice(java.math.BigDecimal fromPrice, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByFromPrice", startResult, maxRows, fromPrice);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormatContaining
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByBoardFileFormatContaining(String boardFileFormat) throws DataAccessException {

		return findTrSearchesByBoardFileFormatContaining(boardFileFormat, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormatContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByBoardFileFormatContaining(String boardFileFormat, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByBoardFileFormatContaining", startResult, maxRows, boardFileFormat);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrSearchesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByKeyword
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByKeyword(String keyword) throws DataAccessException {

		return findTrSearchesByKeyword(keyword, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByKeyword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByKeyword(String keyword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByKeyword", startResult, maxRows, keyword);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByOwnerId
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByOwnerId(Integer ownerId) throws DataAccessException {

		return findTrSearchesByOwnerId(ownerId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByOwnerId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByOwnerId(Integer ownerId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByOwnerId", startResult, maxRows, ownerId);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrSearchesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByKeywordContaining
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByKeywordContaining(String keyword) throws DataAccessException {

		return findTrSearchesByKeywordContaining(keyword, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByKeywordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByKeywordContaining(String keyword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByKeywordContaining", startResult, maxRows, keyword);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesBySearchId
	 *
	 */
	@Transactional
	public TrSearches findTrSearchesBySearchId(Integer searchId) throws DataAccessException {

		return findTrSearchesBySearchId(searchId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesBySearchId
	 *
	 */

	@Transactional
	public TrSearches findTrSearchesBySearchId(Integer searchId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrSearchesBySearchId", startResult, maxRows, searchId);
			return (com.f9g4.domain.TrSearches) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrSearchesByToPrice
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByToPrice(java.math.BigDecimal toPrice) throws DataAccessException {

		return findTrSearchesByToPrice(toPrice, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByToPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByToPrice(java.math.BigDecimal toPrice, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByToPrice", startResult, maxRows, toPrice);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesBySchoolAwards
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesBySchoolAwards(String schoolAwards) throws DataAccessException {

		return findTrSearchesBySchoolAwards(schoolAwards, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesBySchoolAwards
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesBySchoolAwards(String schoolAwards, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesBySchoolAwards", startResult, maxRows, schoolAwards);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByDesignerName
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByDesignerName(String designerName) throws DataAccessException {

		return findTrSearchesByDesignerName(designerName, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByDesignerName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByDesignerName(String designerName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByDesignerName", startResult, maxRows, designerName);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesBySearchNameContaining
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesBySearchNameContaining(String searchName) throws DataAccessException {

		return findTrSearchesBySearchNameContaining(searchName, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesBySearchNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesBySearchNameContaining(String searchName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesBySearchNameContaining", startResult, maxRows, searchName);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormat
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByBoardFileFormat(String boardFileFormat) throws DataAccessException {

		return findTrSearchesByBoardFileFormat(boardFileFormat, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormat
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByBoardFileFormat(String boardFileFormat, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByBoardFileFormat", startResult, maxRows, boardFileFormat);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesBySearchName
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesBySearchName(String searchName) throws DataAccessException {

		return findTrSearchesBySearchName(searchName, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesBySearchName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesBySearchName(String searchName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesBySearchName", startResult, maxRows, searchName);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByDesignerNameContaining
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByDesignerNameContaining(String designerName) throws DataAccessException {

		return findTrSearchesByDesignerNameContaining(designerName, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByDesignerNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByDesignerNameContaining(String designerName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByDesignerNameContaining", startResult, maxRows, designerName);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrSearchesByDesignerCountryId
	 *
	 */
	@Transactional
	public Set<TrSearches> findTrSearchesByDesignerCountryId(Integer designerCountryId) throws DataAccessException {

		return findTrSearchesByDesignerCountryId(designerCountryId, -1, -1);
	}

	/**
	 * JPQL Query - findTrSearchesByDesignerCountryId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrSearches> findTrSearchesByDesignerCountryId(Integer designerCountryId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrSearchesByDesignerCountryId", startResult, maxRows, designerCountryId);
		return new LinkedHashSet<TrSearches>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrSearches entity) {
		return true;
	}
}
