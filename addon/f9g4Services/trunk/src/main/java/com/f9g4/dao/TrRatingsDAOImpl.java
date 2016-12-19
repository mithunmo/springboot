package com.f9g4.dao;

import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrRatings;

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
 * DAO to manage TrRatings entities.
 * 
 */
@Repository("TrRatingsDAO")
@Transactional
public class TrRatingsDAOImpl extends AbstractJpaDao<TrRatings> implements	TrRatingsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrRatings.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrRatingsDAOImpl
	 *
	 */
	public TrRatingsDAOImpl() {
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
	 * JPQL Query - findTrRatingsByAvgRating
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByAvgRating(java.math.BigDecimal avgRating) throws DataAccessException {

		return findTrRatingsByAvgRating(avgRating, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByAvgRating
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByAvgRating(java.math.BigDecimal avgRating, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByAvgRating", startResult, maxRows, avgRating);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByLangCode
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByLangCode(String langCode) throws DataAccessException {

		return findTrRatingsByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrRatingsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRatingId
	 *
	 */
	@Transactional
	public TrRatings findTrRatingsByRatingId(Integer ratingId) throws DataAccessException {

		return findTrRatingsByRatingId(ratingId, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRatingId
	 *
	 */

	@Transactional
	public TrRatings findTrRatingsByRatingId(Integer ratingId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrRatingsByRatingId", startResult, maxRows, ratingId);
			return (com.f9g4.domain.TrRatings) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrRatingsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrRatingsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrRatingsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRating4
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRating4(java.math.BigDecimal rating4) throws DataAccessException {

		return findTrRatingsByRating4(rating4, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRating4
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRating4(java.math.BigDecimal rating4, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRating4", startResult, maxRows, rating4);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByComment
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByComment(String comment) throws DataAccessException {

		return findTrRatingsByComment(comment, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByComment
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByComment(String comment, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByComment", startResult, maxRows, comment);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRating2
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRating2(java.math.BigDecimal rating2) throws DataAccessException {

		return findTrRatingsByRating2(rating2, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRating2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRating2(java.math.BigDecimal rating2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRating2", startResult, maxRows, rating2);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRating3
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRating3(java.math.BigDecimal rating3) throws DataAccessException {

		return findTrRatingsByRating3(rating3, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRating3
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRating3(java.math.BigDecimal rating3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRating3", startResult, maxRows, rating3);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRating5
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRating5(java.math.BigDecimal rating5) throws DataAccessException {

		return findTrRatingsByRating5(rating5, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRating5
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRating5(java.math.BigDecimal rating5, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRating5", startResult, maxRows, rating5);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRating6
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRating6(java.math.BigDecimal rating6) throws DataAccessException {

		return findTrRatingsByRating6(rating6, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRating6
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRating6(java.math.BigDecimal rating6, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRating6", startResult, maxRows, rating6);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRating1
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRating1(java.math.BigDecimal rating1) throws DataAccessException {

		return findTrRatingsByRating1(rating1, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRating1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRating1(java.math.BigDecimal rating1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRating1", startResult, maxRows, rating1);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrRatingss
	 *
	 */
	@Transactional
	public Set<TrRatings> findAllTrRatingss() throws DataAccessException {

		return findAllTrRatingss(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrRatingss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findAllTrRatingss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrRatingss", startResult, maxRows);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByRatingQuestion6Id
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByRatingQuestion6Id(Integer ratingQuestion6Id) throws DataAccessException {

		return findTrRatingsByRatingQuestion6Id(ratingQuestion6Id, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByRatingQuestion6Id
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRatingQuestion6Id(Integer ratingQuestion6Id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRatingQuestion6Id", startResult, maxRows, ratingQuestion6Id);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByCreationDate
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrRatingsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByPrimaryKey
	 *
	 */
	@Transactional
	public TrRatings findTrRatingsByPrimaryKey(Integer ratingId) throws DataAccessException {

		return findTrRatingsByPrimaryKey(ratingId, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByPrimaryKey
	 *
	 */

	@Transactional
	public TrRatings findTrRatingsByPrimaryKey(Integer ratingId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrRatingsByPrimaryKey", startResult, maxRows, ratingId);
			return (com.f9g4.domain.TrRatings) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrRatingsByCommentContaining
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByCommentContaining(String comment) throws DataAccessException {

		return findTrRatingsByCommentContaining(comment, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByCommentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByCommentContaining(String comment, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByCommentContaining", startResult, maxRows, comment);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRatingsByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<TrRatings> findTrRatingsByLangCodeContaining(String langCode) throws DataAccessException {

		return findTrRatingsByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrRatingsByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrRatings entity) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByUserId(Integer userId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByUserId", -1, -1, userId);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}

	@Transactional
	public TrRatings findTrRatingsByBoardid(Integer boardId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByBoardId", -1, -1, boardId);
		return  (com.f9g4.domain.TrRatings) query.getSingleResult();
	}

	@Transactional
	public TrRatings findTrRatingsByUserforBoard(Integer userid, Integer boardId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByUserIdforBoardId", -1, -1, userid,boardId);
		return  (com.f9g4.domain.TrRatings) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRatings> findTrRatingsByRatingUserId(Integer ratingUserId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrRatingsByRatingUserId", -1, -1, ratingUserId);
		return new LinkedHashSet<TrRatings>(query.getResultList());
	}
	
	
}
