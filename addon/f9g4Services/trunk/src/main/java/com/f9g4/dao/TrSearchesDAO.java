package com.f9g4.dao;

import com.f9g4.domain.TrSearches;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrSearches entities.
 * 
 */
public interface TrSearchesDAO extends JpaDao<TrSearches> {

	/**
	 * JPQL Query - findTrSearchesBySchoolAwardsContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesBySchoolAwardsContaining(String schoolAwards) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySchoolAwardsContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesBySchoolAwardsContaining(String schoolAwards, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByLastUpdateDate
	 *
	 */
	public Set<TrSearches> findTrSearchesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByLastUpdateDate
	 *
	 */
	public Set<TrSearches> findTrSearchesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrSearchess
	 *
	 */
	public Set<TrSearches> findAllTrSearchess() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrSearchess
	 *
	 */
	public Set<TrSearches> findAllTrSearchess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByRating
	 *
	 */
	public Set<TrSearches> findTrSearchesByRating(java.math.BigDecimal rating) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByRating
	 *
	 */
	public Set<TrSearches> findTrSearchesByRating(BigDecimal rating, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByCreationDate
	 *
	 */
	public Set<TrSearches> findTrSearchesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByCreationDate
	 *
	 */
	public Set<TrSearches> findTrSearchesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByPrimaryKey
	 *
	 */
	public TrSearches findTrSearchesByPrimaryKey(Integer searchId) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByPrimaryKey
	 *
	 */
	public TrSearches findTrSearchesByPrimaryKey(Integer searchId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByFromPrice
	 *
	 */
	public Set<TrSearches> findTrSearchesByFromPrice(java.math.BigDecimal fromPrice) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByFromPrice
	 *
	 */
	public Set<TrSearches> findTrSearchesByFromPrice(BigDecimal fromPrice, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormatContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesByBoardFileFormatContaining(String boardFileFormat) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormatContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesByBoardFileFormatContaining(String boardFileFormat, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByCreatedBy
	 *
	 */
	public Set<TrSearches> findTrSearchesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByCreatedBy
	 *
	 */
	public Set<TrSearches> findTrSearchesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByKeyword
	 *
	 */
	public Set<TrSearches> findTrSearchesByKeyword(String keyword) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByKeyword
	 *
	 */
	public Set<TrSearches> findTrSearchesByKeyword(String keyword, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByOwnerId
	 *
	 */
	public Set<TrSearches> findTrSearchesByOwnerId(Integer ownerId) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByOwnerId
	 *
	 */
	public Set<TrSearches> findTrSearchesByOwnerId(Integer ownerId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByLastUpdatedBy
	 *
	 */
	public Set<TrSearches> findTrSearchesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByLastUpdatedBy
	 *
	 */
	public Set<TrSearches> findTrSearchesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByKeywordContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesByKeywordContaining(String keyword_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByKeywordContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesByKeywordContaining(String keyword_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySearchId
	 *
	 */
	public TrSearches findTrSearchesBySearchId(Integer searchId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySearchId
	 *
	 */
	public TrSearches findTrSearchesBySearchId(Integer searchId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByToPrice
	 *
	 */
	public Set<TrSearches> findTrSearchesByToPrice(java.math.BigDecimal toPrice) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByToPrice
	 *
	 */
	public Set<TrSearches> findTrSearchesByToPrice(BigDecimal toPrice, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySchoolAwards
	 *
	 */
	public Set<TrSearches> findTrSearchesBySchoolAwards(String schoolAwards_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySchoolAwards
	 *
	 */
	public Set<TrSearches> findTrSearchesBySchoolAwards(String schoolAwards_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByDesignerName
	 *
	 */
	public Set<TrSearches> findTrSearchesByDesignerName(String designerName) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByDesignerName
	 *
	 */
	public Set<TrSearches> findTrSearchesByDesignerName(String designerName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySearchNameContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesBySearchNameContaining(String searchName) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySearchNameContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesBySearchNameContaining(String searchName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormat
	 *
	 */
	public Set<TrSearches> findTrSearchesByBoardFileFormat(String boardFileFormat_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByBoardFileFormat
	 *
	 */
	public Set<TrSearches> findTrSearchesByBoardFileFormat(String boardFileFormat_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySearchName
	 *
	 */
	public Set<TrSearches> findTrSearchesBySearchName(String searchName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesBySearchName
	 *
	 */
	public Set<TrSearches> findTrSearchesBySearchName(String searchName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByDesignerNameContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesByDesignerNameContaining(String designerName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByDesignerNameContaining
	 *
	 */
	public Set<TrSearches> findTrSearchesByDesignerNameContaining(String designerName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByDesignerCountryId
	 *
	 */
	public Set<TrSearches> findTrSearchesByDesignerCountryId(Integer designerCountryId) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchesByDesignerCountryId
	 *
	 */
	public Set<TrSearches> findTrSearchesByDesignerCountryId(Integer designerCountryId, int startResult, int maxRows) throws DataAccessException;

}