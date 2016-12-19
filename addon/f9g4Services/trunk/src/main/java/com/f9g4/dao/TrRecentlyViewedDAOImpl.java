package com.f9g4.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.domain.SingleResultLong;
import com.f9g4.domain.TrActivityScreenCompanyGrid;
import com.f9g4.domain.TrActivityScreenDesignerGrid;
import com.f9g4.domain.TrActivityScreenGraph;
import com.f9g4.domain.TrRecentlyViewed;

/**
 * DAO to manage TrRecentlyViewed entities.
 * 
 */
@Repository("TrRecentlyViewedDAO")
@Transactional
public class TrRecentlyViewedDAOImpl extends AbstractJpaDao<TrRecentlyViewed> implements TrRecentlyViewedDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrRecentlyViewed.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrRecentlyViewedDAOImpl
	 *
	 */
	public TrRecentlyViewedDAOImpl() {
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
	 * JPQL Query - findTrRecentlyViewedByEventTimestamp
	 *
	 */
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByEventTimestamp(java.util.Calendar eventTimestamp) throws DataAccessException {

		return findTrRecentlyViewedByEventTimestamp(eventTimestamp, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByEventTimestamp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByEventTimestamp(java.util.Calendar eventTimestamp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedByEventTimestamp", startResult, maxRows, eventTimestamp);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByClickId
	 *
	 */
	@Transactional
	public TrRecentlyViewed findTrRecentlyViewedByClickId(Integer clickId) throws DataAccessException {

		return findTrRecentlyViewedByClickId(clickId, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByClickId
	 *
	 */

	@Transactional
	public TrRecentlyViewed findTrRecentlyViewedByClickId(Integer clickId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrRecentlyViewedByClickId", startResult, maxRows, clickId);
			return (com.f9g4.domain.TrRecentlyViewed) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrRecentlyViewedByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByCreationDate
	 *
	 */
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrRecentlyViewedByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrRecentlyViewedByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrRecentlyVieweds
	 *
	 */
	@Transactional
	public Set<TrRecentlyViewed> findAllTrRecentlyVieweds() throws DataAccessException {

		return findAllTrRecentlyVieweds(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrRecentlyVieweds
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findAllTrRecentlyVieweds(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrRecentlyVieweds", startResult, maxRows);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrRecentlyViewedByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByPrimaryKey
	 *
	 */
	@Transactional
	public TrRecentlyViewed findTrRecentlyViewedByPrimaryKey(Integer clickId) throws DataAccessException {

		return findTrRecentlyViewedByPrimaryKey(clickId, -1, -1);
	}

	/**
	 * JPQL Query - findTrRecentlyViewedByPrimaryKey
	 *
	 */

	@Transactional
	public TrRecentlyViewed findTrRecentlyViewedByPrimaryKey(Integer clickId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrRecentlyViewedByPrimaryKey", startResult, maxRows, clickId);
			return (com.f9g4.domain.TrRecentlyViewed) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByUserAndEventTimestamp(Integer userId, Calendar eventTimestamp) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedByUserAndEventTimestamp", -1, -1, userId, eventTimestamp);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());	
	}

	@Transactional
	public Long findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(Integer userId, Calendar eventTimestampStart, Calendar eventTimestampEnd) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedCountByUserAndBetweenEventTimestamp", -1, -1, userId, eventTimestampStart, eventTimestampEnd);
		return (Long) query.getSingleResult();
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrRecentlyViewed entity) {
		return true;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp(Integer userId, java.util.Calendar eventTimestamp) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp", -1, -1, userId, eventTimestamp);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());	
	}
	
	//findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestampandGroupbyBoard
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestampandGroupbyBoard(Integer userId, java.util.Calendar eventTimestamp) throws DataAccessException {
		Query query = createNamedQuery("findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp", -1, -1, userId, eventTimestamp);
		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());	
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrRecentlyViewed> findTrRecentlyViewedByUserIdtopn(Integer userId, Integer topn) throws DataAccessException{
		Query query = createNamedQuery("findTrRecentlyViewedByUserIdtopn", -1, topn, userId );

		return new LinkedHashSet<TrRecentlyViewed>(query.getResultList());	
	}
	
	@Transactional
	public Long findTrRecentlyViewedCountByOriginalUserIdAndEventTimestamp(Integer userId, java.util.Calendar eventTimestampStart, java.util.Calendar eventTimestampEnd) throws DataAccessException{
		Query query = createNamedQuery("findTrRecentlyViewedCountByOriginalUserIdAndEventTimestamp", -1, -1, userId, eventTimestampStart, eventTimestampEnd);
		return (Long) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<TrActivityScreenCompanyGrid> GetCompanyGridInfo(Integer userId, Integer memPricingOptionId, Calendar eventTimestampEnd)
			throws DataAccessException {
		
		Query query = getEntityManager().createNamedQuery("findCompanyGridInfo");
		query.setParameter(1, userId);
		query.setParameter(2, eventTimestampEnd);
		query.setParameter(3, memPricingOptionId);
		List<TrActivityScreenCompanyGrid> result = (List<TrActivityScreenCompanyGrid>)query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<TrActivityScreenDesignerGrid> GetDesignerGridInfo(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException{

		Query query = getEntityManager().createNamedQuery("findDesignerGridInfo");
		query.setParameter(1, userId);
		query.setParameter(2, eventTimestampEnd);
		List<TrActivityScreenDesignerGrid> result = (List<TrActivityScreenDesignerGrid>)query.getResultList();
		return result;
	}
	
	@Transactional
	public SingleResultLong GetCompanyCount(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException{
		Query query = getEntityManager().createNamedQuery("findCompanyCount");
		query.setParameter(1, userId);
		query.setParameter(2, eventTimestampEnd);
		return (SingleResultLong) query.getSingleResult();
	}
	
	@Transactional
	public SingleResultLong GetDesignerCount(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException{
		Query query = getEntityManager().createNamedQuery("findDesignerCount");
		query.setParameter(1, userId);
		query.setParameter(2, eventTimestampEnd);
		return (SingleResultLong) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<TrActivityScreenGraph> GetCompanyGraphInfo(Integer userId, Calendar eventTimestampEnd)
			throws DataAccessException {
		
		Query query = getEntityManager().createNamedQuery("findCompanyGraphInfo");
		query.setParameter(1, userId);
		query.setParameter(2, eventTimestampEnd);
		List<TrActivityScreenGraph> result = (List<TrActivityScreenGraph>)query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<TrActivityScreenGraph> GetDesignerGraphInfo(Integer userId, Calendar eventTimestampEnd)
			throws DataAccessException {
		
		Query query = getEntityManager().createNamedQuery("findDesignerGraphInfo");
		query.setParameter(1, userId);
		query.setParameter(2, eventTimestampEnd);
		List<TrActivityScreenGraph> result = (List<TrActivityScreenGraph>)query.getResultList();
		return result;
	}
}
