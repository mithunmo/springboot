package com.f9g4.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.f9g4.domain.SingleResultLong;
import com.f9g4.domain.TrActivityScreenCompanyGrid;
import com.f9g4.domain.TrActivityScreenDesignerGrid;
import com.f9g4.domain.TrActivityScreenGraph;
import com.f9g4.domain.TrRecentlyViewed;

/**
 * DAO to manage TrRecentlyViewed entities.
 * 
 */
public interface TrRecentlyViewedDAO extends JpaDao<TrRecentlyViewed> {

	/**
	 * JPQL Query - findTrRecentlyViewedByEventTimestamp
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByEventTimestamp(java.util.Calendar eventTimestamp) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByEventTimestamp
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByEventTimestamp(Calendar eventTimestamp, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByClickId
	 *
	 */
	public TrRecentlyViewed findTrRecentlyViewedByClickId(Integer clickId) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByClickId
	 *
	 */
	public TrRecentlyViewed findTrRecentlyViewedByClickId(Integer clickId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdatedBy
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdatedBy
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByCreationDate
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByCreationDate
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByCreatedBy
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByCreatedBy
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrRecentlyVieweds
	 *
	 */
	public Set<TrRecentlyViewed> findAllTrRecentlyVieweds() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrRecentlyVieweds
	 *
	 */
	public Set<TrRecentlyViewed> findAllTrRecentlyVieweds(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdateDate
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByLastUpdateDate
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByPrimaryKey
	 *
	 */
	public TrRecentlyViewed findTrRecentlyViewedByPrimaryKey(Integer clickId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedByPrimaryKey
	 *
	 */
	public TrRecentlyViewed findTrRecentlyViewedByPrimaryKey(Integer clickId_1, int startResult, int maxRows) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findTrRecentlyViewedByUserAndEventTimestamp
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedByUserAndEventTimestamp(Integer userId, java.util.Calendar eventTimestamp) throws DataAccessException;
	
	/**
	 * JPQL Query - findTrRecentlyViewedCountByUserAndBetweenEventTimestamp
	 *
	 */
	public Long findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(Integer userId, java.util.Calendar eventTimestampStart, java.util.Calendar eventTimestampEnd) throws DataAccessException;

	/**
	 * JPQL Query - findTrRecentlyViewedCountByUserAndBetweenEventTimestamp
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp(Integer userId, java.util.Calendar eventTimestamp) throws DataAccessException;
	
	//findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestampandGroupbyBoard
	/**
	 * JPQL Query - findTrRecentlyViewedCountByUserAndBetweenEventTimestamp
	 *
	 */
	public Set<TrRecentlyViewed> findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestampandGroupbyBoard(Integer userId, java.util.Calendar eventTimestamp) throws DataAccessException;
	
	public Set<TrRecentlyViewed> findTrRecentlyViewedByUserIdtopn(Integer userId, Integer topn) throws DataAccessException;
	
	public Long findTrRecentlyViewedCountByOriginalUserIdAndEventTimestamp(Integer userId, java.util.Calendar eventTimestampStart, java.util.Calendar eventTimestampEnd) throws DataAccessException;
	
	public List<TrActivityScreenCompanyGrid> GetCompanyGridInfo(Integer userId, Integer memPricingOptionId, java.util.Calendar eventTimestampEnd) throws DataAccessException;
	
	public List<TrActivityScreenDesignerGrid> GetDesignerGridInfo(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException;
	
	public SingleResultLong GetCompanyCount(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException;
	
	public SingleResultLong GetDesignerCount(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException;
	
	
	public List<TrActivityScreenGraph> GetCompanyGraphInfo(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException;
	
	public List<TrActivityScreenGraph> GetDesignerGraphInfo(Integer userId, java.util.Calendar eventTimestampEnd) throws DataAccessException;
}