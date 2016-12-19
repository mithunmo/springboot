package com.f9g4.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.f9g4.common.bo.SearchResults;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrBoardSearch;

/**
 * DAO to manage TrBoard entities.
 * 
 */
public interface TrBoardDAO extends JpaDao<TrBoard> {

	/**
	 * JPQL Query - findTrBoardByExpirationDate
	 *
	 */
	public Set<TrBoard> findTrBoardByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByExpirationDate
	 *
	 */
	public Set<TrBoard> findTrBoardByExpirationDate(Calendar expirationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByTotalPrice
	 *
	 */
	public Set<TrBoard> findTrBoardByTotalPrice(java.math.BigDecimal totalPrice) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByTotalPrice
	 *
	 */
	public Set<TrBoard> findTrBoardByTotalPrice(BigDecimal totalPrice, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByName
	 *
	 */
	public Set<TrBoard> findTrBoardByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByName
	 *
	 */
	public Set<TrBoard> findTrBoardByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLangCode
	 *
	 */
	public Set<TrBoard> findTrBoardByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLangCode
	 *
	 */
	public Set<TrBoard> findTrBoardByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLastUpdateDate
	 *
	 */
	public Set<TrBoard> findTrBoardByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLastUpdateDate
	 *
	 */
	public Set<TrBoard> findTrBoardByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByBoardId
	 *
	 */
	public TrBoard findTrBoardByBoardId(Integer boardId) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByBoardId
	 *
	 */
	public TrBoard findTrBoardByBoardId(Integer boardId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrBoards
	 *
	 */
	public Set<TrBoard> findAllTrBoards() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrBoards
	 *
	 */
	public Set<TrBoard> findAllTrBoards(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLangCodeContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLangCodeContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByCreatedBy
	 *
	 */
	public Set<TrBoard> findTrBoardByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByCreatedBy
	 *
	 */
	public Set<TrBoard> findTrBoardByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByDescriptionContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByDescriptionContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByNameContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByNameContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByKeywordContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByKeywordContaining(String keyword) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByKeywordContaining
	 *
	 */
	public Set<TrBoard> findTrBoardByKeywordContaining(String keyword, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByPrimaryKey
	 *
	 */
	public TrBoard findTrBoardByPrimaryKey(Integer boardId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByPrimaryKey
	 *
	 */
	public TrBoard findTrBoardByPrimaryKey(Integer boardId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByCreationDate
	 *
	 */
	public Set<TrBoard> findTrBoardByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByCreationDate
	 *
	 */
	public Set<TrBoard> findTrBoardByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */
	public Set<TrBoard> findTrBoardByPublishToMp(Integer publishToMp) throws DataAccessException;
	
	/**
	 * JPQL Query - findTrBoardByContainingPublishToMp
	 *
	 */
	public Set<TrBoard> findTrBoardByContainingPublishToMP(List<Integer> publishToMp, List<Integer> portfolioTypes, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - findTrBoardByPortfolioIdforBuyer
	 *
	 */
	public Set<TrBoard> findTrBoardByPortfolioIdforBuyer(Integer portfolioid) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByPortfolioIdforUser
	 *
	 */
	public Set<TrBoard> findTrBoardByPortfolioIdforUser(Integer portfolioid, Integer userid) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */
	public Set<TrBoard> findTrBoardByPortfolioId(Integer portfolioid) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */
	public Set<TrBoard> findTrBoardByPublishToMp(Integer publishToMp, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByKeyword
	 *
	 */
	public Set<TrBoard> findTrBoardByKeyword(String keyword_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByKeyword
	 *
	 */
	public Set<TrBoard> findTrBoardByKeyword(String keyword_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByDescription
	 *
	 */
	public Set<TrBoard> findTrBoardByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByDescription
	 *
	 */
	public Set<TrBoard> findTrBoardByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByBoardPrice
	 *
	 */
	public Set<TrBoard> findTrBoardByBoardPrice(java.math.BigDecimal boardPrice) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByBoardPrice
	 *
	 */
	public Set<TrBoard> findTrBoardByBoardPrice(BigDecimal boardPrice, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLastUpdatedBy
	 *
	 */
	public Set<TrBoard> findTrBoardByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardByLastUpdatedBy
	
	 */
	public Set<TrBoard> findTrBoardByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;


	/**
	 * JPQL Query - findTrBoardByCurrentUserId
	 *
	 */
	public Set<TrBoard> findTrBoardByCurrentUserId(Integer currentUserId) throws DataAccessException;

	
	public SearchResults findDesingwallBoards(int sortColumn, int sortOrder,  Integer firstResult, Integer maxResults, Object... parameters)throws DataAccessException;
	
	public SearchResults findDesignerAccount(int sortColumn, int sortOrder,  Integer firstResult, Integer maxResults, Object... parameters)throws DataAccessException;

	public Set<TrBoard> findTrBoardByBoardIds(List<Integer> boardIds) throws DataAccessException;
		
	public Set<TrBoardSearch> findTrBoardsBySearchCriteria(
			String designerName, Integer ratingStart, Integer ratingEnd, Integer[] countryIds, 
			Integer[] langIds, Integer[] skillIds, String schoolAwards, 
			Integer division, Integer category, String product, String[] productType,
			Integer[] seasonYearIds, Integer[] saleTypeIds, BigDecimal priceLow, BigDecimal priceHigh, String keywords,Integer limt,Integer memPricingOption, 
			boolean isPortfolioSearch, Date searchStartDt , Date searchEndDt,
			Integer[] expertiseIds, Integer[] specialtyIds, Integer[] educationIds,
			Integer minAdminRating, Integer maxAdminRating) throws DataAccessException;
	
	public Set<TrBoardSearch> findTrBoardsOfExamplesBySearchCriteria(String designerName, 
			Integer[] countryIds, Integer[] langIds, Integer[] skillIds, String schoolAwards, 
			Integer limt, 
			boolean isPortfolioSearch, Date searchStartDt , Date searchEndDt,
			Integer[] expertiseIds, Integer[] specialtyIds, Integer[] educationIds,
			Integer minAdminRating, Integer maxAdminRating) throws DataAccessException;
	
	public List<Object> findTrBoardsCountAndTotalPurchasedByUser(Integer userId) throws DataAccessException;
	
	public Set<TrBoardSearch> findTrBoardsFromRecentlyViewedBoards(Integer userId, Integer memPricingOptionId, Integer limit) throws DataAccessException;
	
	public Set<TrBoardSearch> findTrBoardsForMayWeSuggest(Integer memPricingOptionId, Integer limit) throws DataAccessException;
	
	public Set<TrBoard> findTrBoardForSample(Integer limit) throws DataAccessException;
	
	public Set<TrBoard> findTrBoardForSampleByUserId(List<Integer> userIds, Integer limit) throws DataAccessException;
	
}