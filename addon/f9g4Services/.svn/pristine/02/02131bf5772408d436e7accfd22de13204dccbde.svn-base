package com.f9g4.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.common.bo.Account;
import com.f9g4.common.bo.DesignWall;
import com.f9g4.common.bo.SearchResults;
import com.f9g4.common.util.Constants;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrBoardSearch;

/**
 * DAO to manage TrBoard entities.
 * 
 */
@Repository("TrBoardDAO")
@Transactional
public class TrBoardDAOImpl extends AbstractJpaDao<TrBoard> implements TrBoardDAO {

	@Autowired @Value("${f9g4.service.search.admin_rating.min}")
	private Float minAdminRating; //to filter out the designer we don't want to show in the search result.
	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrBoard.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrBoardDAOImpl
	 *
	 */
	public TrBoardDAOImpl() {
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
	 * JPQL Query - findTrBoardByExpirationDate
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException {

		return findTrBoardByExpirationDate(expirationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByExpirationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByExpirationDate(java.util.Calendar expirationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByExpirationDate", startResult, maxRows, expirationDate);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByTotalPrice
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByTotalPrice(java.math.BigDecimal totalPrice) throws DataAccessException {

		return findTrBoardByTotalPrice(totalPrice, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByTotalPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByTotalPrice(java.math.BigDecimal totalPrice, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByTotalPrice", startResult, maxRows, totalPrice);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByName
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByName(String name) throws DataAccessException {

		return findTrBoardByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByName", startResult, maxRows, name);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByLangCode
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByLangCode(String langCode) throws DataAccessException {

		return findTrBoardByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrBoardByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByBoardId
	 *
	 */
	@Transactional
	public TrBoard findTrBoardByBoardId(Integer boardId) throws DataAccessException {

		return findTrBoardByBoardId(boardId, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByBoardId
	 *
	 */

	@Transactional
	public TrBoard findTrBoardByBoardId(Integer boardId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrBoardByBoardId", startResult, maxRows, boardId);
			return (com.f9g4.domain.TrBoard) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllTrBoards
	 *
	 */
	@Transactional
	public Set<TrBoard> findAllTrBoards() throws DataAccessException {

		return findAllTrBoards(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrBoards
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findAllTrBoards(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrBoards", startResult, maxRows);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByLangCodeContaining(String langCode) throws DataAccessException {

		return findTrBoardByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrBoardByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByDescriptionContaining(String description) throws DataAccessException {

		return findTrBoardByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByNameContaining
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByNameContaining(String name) throws DataAccessException {

		return findTrBoardByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByKeywordContaining
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByKeywordContaining(String keyword) throws DataAccessException {

		return findTrBoardByKeywordContaining(keyword, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByKeywordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByKeywordContaining(String keyword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByKeywordContaining", startResult, maxRows, keyword);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByPrimaryKey
	 *
	 */
	@Transactional
	public TrBoard findTrBoardByPrimaryKey(Integer boardId) throws DataAccessException {

		return findTrBoardByPrimaryKey(boardId, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByPrimaryKey
	 *
	 */

	@Transactional
	public TrBoard findTrBoardByPrimaryKey(Integer boardId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrBoardByPrimaryKey", startResult, maxRows, boardId);
			return (com.f9g4.domain.TrBoard) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrBoardByCreationDate
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrBoardByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByPublishToMp(Integer publishToMp) throws DataAccessException {

		return findTrBoardByPublishToMp(publishToMp, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByPublishToMp(Integer publishToMp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByPublishToMp", startResult, maxRows, publishToMp);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}
	
	/**
	 * JPQL Query - findTrBoardByContainingPublishToMp
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByContainingPublishToMP(List<Integer> publishToMp, List<Integer> portfolioTypes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByContainingPublishToMP", startResult, maxRows);
		query.setParameter(1, publishToMp);
		query.setParameter(2, portfolioTypes);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	
	/**
	 * JPQL Query - findTrBoardByPortfolioIdforBuyer
	 *
	 */
	@SuppressWarnings("unchecked")	
	@Transactional
	public Set<TrBoard> findTrBoardByPortfolioIdforBuyer(Integer portfolioid) throws DataAccessException {

		Query query = createNamedQuery("findTrBoardByPortfolioIdforBuyer", -1, -1, portfolioid);
		return new LinkedHashSet<TrBoard>(query.getResultList());

	}

	/**
	 * JPQL Query - findTrBoardByPortfolioIdforUser
	 *
	 */
	@SuppressWarnings("unchecked")	
	@Transactional
	public Set<TrBoard> findTrBoardByPortfolioIdforUser(Integer portfolioid, Integer userid) throws DataAccessException {

		Query query = createNamedQuery("findTrBoardByPortfolioIdforUser", -1, -1, portfolioid, userid);
		return new LinkedHashSet<TrBoard>(query.getResultList());

	}
	
	
	
	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByPortfolioId(Integer portfolioid) throws DataAccessException {

		return findTrBoardByPortfolioId(portfolioid, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByPublishToMp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByPortfolioId(Integer portfolioid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByPortfolioId", startResult, maxRows, portfolioid);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByKeyword
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByKeyword(String keyword) throws DataAccessException {

		return findTrBoardByKeyword(keyword, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByKeyword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByKeyword(String keyword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByKeyword", startResult, maxRows, keyword);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByDescription
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByDescription(String description) throws DataAccessException {

		return findTrBoardByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByDescription", startResult, maxRows, description);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByBoardPrice
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByBoardPrice(java.math.BigDecimal boardPrice) throws DataAccessException {

		return findTrBoardByBoardPrice(boardPrice, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByBoardPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByBoardPrice(java.math.BigDecimal boardPrice, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByBoardPrice", startResult, maxRows, boardPrice);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrBoard> findTrBoardByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrBoardByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardByBoardIds(List<Integer> boardIds) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByBoardIds", -1, -1, boardIds);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrBoard entity) {
		return true;
	}
	
	/**
	 * sorcolumn , 1- userName, 2 - totalPrice, 3. boardName 4. boardId 5 - sellerPayDate, 6 - paymentStatusId 7-lastname 8-firstname
	 * sortdirection, 1- Asc, any other number descending oreder.. 
	 * 
	 */
	@Transactional
	public SearchResults findDesingwallBoards(int sortColumn, int sortOrder,  Integer firstResult, Integer maxResults, Object... parameters) throws DataAccessException{
		
		SearchResults searchResults = new SearchResults();
		
		String queryStr = " Select new com.f9g4.common.bo.DesignWall( board.adUsersByOriginalUserId.userName,(trSalesTransactionDetailses.sellerShare+trSalesTransactionDetailses.commission), board.boardPrice,board.totalPrice, board.name, board.boardId," +
				" trSalesTransactionDetailses.trSalesTransactionHeader.paymentTimestamp, trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId, " +
				" board.adUsersByOriginalUserId.firstname , board.adUsersByOriginalUserId.lastname, trBoardImageses.sourceFileUrl, trBoardImageses.thumbnailUrl ,trBoardImageses.fileType, trBoardImageses.fileName, " +
				" board.adUsersByOriginalUserId.profilename, board.adUsersByOriginalUserId.useProfilename " +
				") from TrBoard board inner join board.trBoardImageses trBoardImageses inner join board.trSalesTransactionDetailses trSalesTransactionDetailses " +
				" where board.adUsersByCurrentUserId.userId = ? and trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId in (407,533) ";

		//Query for total Amount
		String queryForTotalAmount  = " Select sum((trSalesTransactionDetailses.sellerShare+trSalesTransactionDetailses.commission)) as totalAmount from TrBoard board inner join board.trSalesTransactionDetailses trSalesTransactionDetailses " +
										" where board.adUsersByCurrentUserId.userId = ? and trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId in (407,533)";
		//Query for total rows			
		String queryForTotalRecords = " Select count(*) as count                    from TrBoard board inner join board.trSalesTransactionDetailses trSalesTransactionDetailses" +
										" where board.adUsersByCurrentUserId.userId = ? and trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId in (407,533)";
		

		
		String orderBy = " "; 
		
		
		switch(sortColumn){
			case 1:
				if(sortOrder == 1){
					orderBy = " ORDER BY board.adUsersByOriginalUserId.userName ASC";
				}else{
					orderBy = " ORDER BY board.adUsersByOriginalUserId.userName DESC";
				}
				break;
			case 2:
				if(sortOrder == 1){
					orderBy = " ORDER BY board.totalPrice ASC";
				}else{
					orderBy = " ORDER BY board.totalPrice DESC";
				}
			break;
			case 3:
				if(sortOrder == 1){
					orderBy = " ORDER BY trSalesTransactionDetailses.trSalesTransactionHeader.paymentTimestamp ASC";
				}else{
					orderBy = " ORDER BY trSalesTransactionDetailses.trSalesTransactionHeader.paymentTimestamp DESC";
				}
			break;
			case 4:
				if(sortOrder == 1){
					orderBy = " ORDER BY trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId ASC";
				}else{
					orderBy = " ORDER BY trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId DESC";
				}
			break;
		}
		
		//execute the total Amount
		Query amountQuery = entityManager.createQuery(queryForTotalAmount);
				 
		//first execute the count
		Query countQuery = entityManager.createQuery(queryForTotalRecords);
		
		TypedQuery<DesignWall> query = entityManager.createQuery(queryStr + orderBy, DesignWall.class);

		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i + 1, parameters[i]);
				countQuery.setParameter(i + 1, parameters[i]);
				amountQuery.setParameter(i + 1, parameters[i]);
			}
		}
		
		query.setFirstResult(firstResult == null || firstResult < 0 ? DEFAULT_FIRST_RESULT_INDEX : firstResult);
		if (maxResults != null && maxResults > 0)
				query.setMaxResults(maxResults);
		
		//now execute the query..
		//countQuery.getResultList();
		long totalRows = (Long) countQuery.getSingleResult();
		searchResults.setTotalRows(totalRows);
		
		BigDecimal totalAmount = (BigDecimal) amountQuery.getSingleResult();
		searchResults.setTotalAmount(totalAmount);
				
		if(totalRows > 0){
			List<DesignWall> results = query.getResultList();
			searchResults.setResults(results);
		}
		return searchResults;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.f9g4.dao.TrBoardDAO#findDesignerAccount(int, int, java.lang.Integer, java.lang.Integer, java.lang.Object[])
	private Integer boardId;
	private String boardName;
	private String boardPrice;
	private String boardImage;
	private Integer portfilioId;
	private String portfolioName;
	private Integer purchaserId;
	private String purchaserName;
	private Calendar dateSold;
	private int paymentStatusId;
	 */
	@Transactional
	public SearchResults findDesignerAccount(int sortColumn, int sortOrder,  Integer firstResult, Integer maxResults, Object... parameters) throws DataAccessException
	{
		SearchResults searchResults = new SearchResults();
		
		String queryStr = " Select new com.f9g4.common.bo.Account( board.boardId, board.name, board.boardPrice, board.totalPrice,trBoardImageses.thumbnailUrl, trBoardImageses.fileName, board.trPortfolio.portfolioId, board.trPortfolio.name," +
				" board.adUsersByCurrentUserId.userId, board.adUsersByCurrentUserId.companyName," +
				" trSalesTransactionDetailses.trSalesTransactionHeader.paymentTimestamp, trSalesTransactionDetailses.adLookupValuesByDesignerPaymentStatusId.lookupValueId, trSalesTransactionDetailses.adLookupValuesByDesignerPaymentStatusId.description" +
				") from TrBoard board inner join board.trBoardImageses trBoardImageses inner join board.trSalesTransactionDetailses trSalesTransactionDetailses" +
				" where board.adUsersByOriginalUserId.userId = ? and board.adUsersByOriginalUserId.userId <> board.adUsersByCurrentUserId.userId and (board.adLookupValuesStatusId.lookupValueId = 469 or board.adLookupValuesStatusId.lookupValueId = 471)";
				/*" where board.adUsersByOriginalUserId.userId = ? and board.adUsersByOriginalUserId.userId <> board.adUsersByCurrentUserId.userId and trSalesTransactionDetailses.trSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId in (407,533) ";*/

		//Query for total Amount
		String queryForTotalAmount  = " Select sum(board.boardPrice) as totalAmount from TrBoard board" +
										" where board.adUsersByOriginalUserId.userId = ? and board.adUsersByOriginalUserId.userId <> board.adUsersByCurrentUserId.userId and (board.adLookupValuesStatusId.lookupValueId = 469 or board.adLookupValuesStatusId.lookupValueId = 471)";
		//Query for total rows			
		String queryForTotalRecords = " Select count(*) as count from TrBoard board" +
										" where board.adUsersByOriginalUserId.userId = ? and board.adUsersByOriginalUserId.userId <> board.adUsersByCurrentUserId.userId and (board.adLookupValuesStatusId.lookupValueId = 469 or board.adLookupValuesStatusId.lookupValueId = 471)";
		
		String orderBy = " "; 
		
		
		switch(sortColumn){
			case 1:
				if(sortOrder == 1)
					orderBy = " ORDER BY board.trPortfolio.name ASC";
				else
					orderBy = " ORDER BY board.trPortfolio.name DESC";
				break;
			case 2:
				if(sortOrder == 1)
					orderBy = " ORDER BY board.name ASC";
				else
					orderBy = " ORDER BY board.name DESC";
				break;
			case 3:
				if(sortOrder == 1)
					orderBy = " ORDER BY board.adUsersByCurrentUserId.companyName ASC";
				else
					orderBy = " ORDER BY board.adUsersByCurrentUserId.companyName DESC";
				break;
			case 4:
				if(sortOrder == 1)
					orderBy = " ORDER BY board.totalPrice ASC";
				else
					orderBy = " ORDER BY board.totalPrice DESC";
				break;
			case 5:
				if(sortOrder == 1)
					orderBy = " ORDER BY trSalesTransactionDetailses.trSalesTransactionHeader.paymentTimestamp ASC";
				else
					orderBy = " ORDER BY trSalesTransactionDetailses.trSalesTransactionHeader.paymentTimestamp DESC";
				break;
			case 6:
				if(sortOrder == 1)
					orderBy = " ORDER BY trSalesTransactionDetailses.adLookupValuesByDesignerPaymentStatusId.lookupValueId ASC";
				else
					orderBy = " ORDER BY trSalesTransactionDetailses.adLookupValuesByDesignerPaymentStatusId.lookupValueId DESC";
				break;
		}
		
		//execute the total Amount
		Query amountQuery = entityManager.createQuery(queryForTotalAmount);
				 
		//first execute the count
		Query countQuery = entityManager.createQuery(queryForTotalRecords);
		
		TypedQuery<Account> query = entityManager.createQuery(queryStr + orderBy, Account.class);
		//TypedQuery<Account> query = entityManager.createQuery(queryStr, Account.class);

		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i + 1, parameters[i]);
				countQuery.setParameter(i + 1, parameters[i]);
				amountQuery.setParameter(i + 1, parameters[i]);
			}
		}
		
		query.setFirstResult(firstResult == null || firstResult < 0 ? DEFAULT_FIRST_RESULT_INDEX : firstResult);
		if (maxResults != null && maxResults > 0)
				query.setMaxResults(maxResults);
		
		//now execute the query..
		//countQuery.getResultList();
		long totalRows = (Long) countQuery.getSingleResult();
		searchResults.setTotalRows(totalRows);
		
		BigDecimal totalAmount = (BigDecimal) amountQuery.getSingleResult();
		searchResults.setTotalAmount(totalAmount);
				
		if(totalRows > 0){
			List<Account> results = query.getResultList();
			searchResults.setResults(results);
		}
		return searchResults;
	}

	
	@SuppressWarnings({ "unchecked"})
	@Transactional
	public Set<TrBoard> findTrBoardByCurrentUserId(Integer currentUserId) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardByCurrentUserId", -1, -1, currentUserId);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}
	
	
	@SuppressWarnings({ "unchecked"})
	@Transactional
	public Set<TrBoardSearch> findTrBoardsBySearchCriteria(String designerName, Integer ratingStart, Integer ratingEnd, Integer[] countryIds, 
			Integer[] langIds, Integer[] skillIds, String schoolAwards, 
			Integer division, Integer category, String product, String[] productType, 
			Integer[] seasonYearIds, Integer[] saleTypeIds, BigDecimal priceLow, BigDecimal priceHigh, String keywords,Integer limt,Integer memPricingOption, 
			boolean isPortfolioSearch, Date searchStartDt , Date searchEndDt,
			Integer[] expertiseIds, Integer[] specialtyIds, Integer[] educationIds,
			Integer minAdminRating, Integer maxAdminRating) throws DataAccessException {
	
		/**
		?1 - designer name
		?2 ,?3 - rating start and end
		?4, ?5 - countryid's 
		?6, ?7 - langids
		?8, ?9 - skills id
		?10 - awards - string
		?11  - product  - p_category_id1
		?12   - product type - p_category_id2
		?13  -  category 3   -  p_category_id3 (No use for now)
		?14  -  category 4  -  p_category_id4 (No use for now)
		?15   -     season year ids - p_ss_year_id
		?16   -     season year ids - p_ss_year_id
		?17   -  saletype ids'  (image types) - p_sale_type_id
		?18   -  saletype ids'  (image types) - p_sale_type_id
		?19   -  price low
		?20   -  price high
		?21   -  Limit
		?22   -  Keywords
		?13 : membership pricing option
		?14 : name of category level 3
		
		//07242014 Fred change index
		?33 - ?? : category 4 list. Parameter will extend dynamically base on the length of product type.
		
		//07242014 Fred change index
		Kamlesh added new portfolio search option 
		?23- board creation start date.
		?24 - board creation end date
		
		//08012014 Fred add index for specialty, education and expertise
		?25, ?26 - Expertise
		?27, ?28 - Specialty
		?29, ?30 - Education
		?31, ?32 - Admin Rating
		*/
		
		//Query query = getEntityManager().createNamedQuery("findTrBoardsBySearchCriteria");
		
		//generate level4 OR statements dynamically
		int baseLevel4Index=33;
		String level4Statements = " and ( upper(tb.keyword) like upper(?"+baseLevel4Index+")";
		if(productType!=null && productType.length>0)
		{
			for(int i=baseLevel4Index+1;i<(baseLevel4Index+productType.length);i++)
			level4Statements += " OR upper(tb.keyword) like upper(?"+i+") ";
		}
		level4Statements+=" ) ";
		String expertiseSubQ="";
		String specialtySubQ="";
		String educationSubQ="";
		//sub-query for expertise
		if(expertiseIds != null && expertiseIds.length > 0)
		{
			expertiseSubQ=" AND EXISTS (SELECT 1 FROM ad_user_expertise aue WHERE aue.active_status = 1 and aue.user_id = tb.original_user_id AND (aue.exp_id in (?25) " + /* Enclose String in single quotes */
       				" OR aue.exp_id = IFNULL(?26, aue.exp_id))) ";
		}
		//sub-query for specialty
		if(specialtyIds != null && specialtyIds.length > 0)
		{
			specialtySubQ=" AND EXISTS (SELECT 1 FROM ad_user_specialities asp WHERE asp.active_status = 1 and asp.user_id = tb.original_user_id AND (asp.spl_id in (?27) " + /* Enclose String in single quotes */
   					" OR asp.spl_id = IFNULL(?28, asp.spl_id))) ";
		}
		//sub-query for education
		if(educationIds != null && educationIds.length > 0)
		{
			educationSubQ=" AND EXISTS (SELECT 1 FROM ad_user_educations aedu WHERE aedu.active_status = 1 and aedu.user_id = tb.original_user_id AND (aedu.edu_id in (?29) " + /* Enclose String in single quotes */
       				" OR aedu.edu_id = IFNULL(?30, aedu.edu_id))) ";
		}
		
		String queryStr = "SELECT tbm.* , tbi.* , (tbm.total_price+((tbm.total_price*commission)/100)) as TEMP_SALE_PRICE "+
				" from tr_board tbm, tr_board_images tbi, st_mem_pricing_options po"+
				" where tbm.board_id = tbi.board_id "+
			    "AND po.mem_pricing_id = ?13 "+
				"AND EXISTS ( "+
						"SELECT 1 "+
						" from tr_board tb " +
						" where "  +
						/* Designer Name */
						"  EXISTS (SELECT \'1\' FROM ad_users au WHERE au.active_status = 1 and upper(concat(FirstName, LastName)) like upper(replace(?1 ,' ','%')) AND au.user_id = tb.original_user_id AND au.admin_rating between ?31 and ?32 )" +
						
						/* Rating  for 5 Pass Low/High=5, 4 to 1 = low=1 and high =4 and for ALL = 0 and 5*/
						// " AND  (SELECT ifNULL(SUM(AVG_RATING),0) FROM tr_ratings tr WHERE tr.user_id = tb.original_user_id) Between ?2 AND ?3 " +
						" AND (SELECT ifNULL(ifNULL(SUM(AVG_RATING),0)/ifNULL(COUNT(AVG_RATING),1),0) FROM tr_ratings tr WHERE tr.user_id = tb.original_user_id) Between ?2 AND ?3 " +
						
						/* Designer Country PASS STRING OF COUNTRY IDs enclosed in ' */
						" AND EXISTS (SELECT 1 FROM ad_addresses aad WHERE aad.active_status = 1 and aad.user_id = tb.original_user_id AND ( aad.country_id in (?4) "  + /* Enclose String in single quotes */ 
					    " OR aad.country_id = IFNULL(?5, aad.country_id ))) " + /*Pass NULL If no data */
				
					    /* Languages PASS LANG CODE*/
						" AND EXISTS (SELECT 1 FROM ad_user_languages aul WHERE aul.active_status = 1 and aul.user_id = tb.original_user_id AND (aul.language_id in (?6)" + /* Enclose String in single quotes */
						" OR aul.language_id  = IFNULL(?7, aul.language_id))) " +			
				
						/* Skills PASS SKILL CODE */
						" AND EXISTS (SELECT 1 FROM ad_user_skills aus WHERE  aus.active_status = 1 and aus.user_id = tb.original_user_id AND (aus.skill_id in (?8) " + /* Enclose String in single quotes */
					    " OR aus.skill_id = IFNULL(?9, aus.skill_id))) " + 
						
						/* Expertise 08012014 */
						expertiseSubQ +

       					/* Specialty 08012014 */
       					specialtySubQ +

      					/* Education 08012014 */
      					educationSubQ +
						
						/* Schools,Awards,Events,Markets */
						" AND EXISTS (SELECT 1 FROM ad_users au  WHERE  au.active_status = 1 and upper(IFNULL(au.school_awards,'X')) like upper(?10) and au.user_id = tb.original_user_id ) " +

						/* Product Pass NULL if no Value */
						" AND EXISTS (Select 1 from tr_portfolio tp where tp.active_status = 1  and  tb.portfolio_id = tp.portfolio_id " +
						
								" AND tp.cat_level1_id =IFNULL(?11 ,tp.cat_level1_id) " +

								" AND tp.cat_level2_id = IFNULL(?12 ,tp.cat_level2_id) " +
								
								//" AND tb.cat_level3_id = IFNULL(?13 ,tb.cat_level3_id) " + //Move to keyword
								
								//" AND IFNULL(tb.cat_level4_id, 0) = IFNULL(?14, IFNULL(tb.cat_level4_id,0)) " + //Move to keyword
								
								/* Season PASS SEASON YEAR ID leave it blank to get all*/
								" AND (tp.season_year_id IN (?15) OR tp.season_year_id = IFNULL(?16, tp.season_year_id)) " +
						 ")" +		
						/* Board File Format */
						" AND ( tb.SALE_TYPE_ID IN (?17) OR tb.SALE_TYPE_ID = IFNULL(?18, tb.SALE_TYPE_ID)) " +
								
						/* price_range_options */
						" AND (tbm.total_price+((tbm.total_price*commission)/100)) between ifnull(?19, (tbm.total_price+((tbm.total_price*commission)/100))) and ifnull(?20,  (tbm.total_price+((tbm.total_price*commission)/100))) "  +  

						/* keywords */
						" AND EXISTS (SELECT 1 FROM ad_users au WHERE au.active_status = 1 " + 
						" and upper(tb.keyword) like upper(?22) " +
						/* for category level 3*/
						" and upper(tb.keyword) like upper(?14) " +
						/* for category 4*/
						level4Statements +
						" and au.user_id = tb.original_user_id ) " +

						/* Exclude Expired members */
						" AND EXISTS (select 1 From ad_user_memberships aum Where aum.user_id = tb.original_user_id and sysdate() between aum.effective_date and aum.expiration_date) "  +
						
						/*Show only Available Boards */
						" AND EXISTS (SELECT 1 FROM ad_lookup_values alv where alv.active_status = 1 and alv.lookup_code = 'AVAILABLE' and alv. lookup_value_id = tb.status_id) " +
						
						" ";
						if(isPortfolioSearch==false){
							//04302014 Fred - new logic to check the original user is visible user=================================
							/*Portfolio has to be sellable*/
							queryStr=queryStr + " AND EXISTS (SELECT 1 FROM tr_portfolio tp WHERE tp.sellable = 1 and tp.portfolio_id = tb.portfolio_id) "+
							/*Designer has reviewed portfolio pages more than 3*/
							" AND EXISTS (SELECT 1 FROM tr_portfolio tp LEFT JOIN tr_board tbp ON tp.portfolio_id = tbp.portfolio_id "+
							" WHERE tp.sellable = 0 AND tp.active_status = 1 AND tbp.active_status = 1 AND tbp.publish_to_mp = 1 AND tp.user_id = tb.original_user_id "+
							" GROUP BY tbp.original_user_id "+
							" HAVING COUNT(tbp.board_id) >= 3) ";
						}
						//=====================================================================================================
						else{
							queryStr=queryStr + "AND EXISTS (SELECT 1 FROM tr_portfolio tp WHERE tp.sellable = 0 and tp.portfolio_id = tb.portfolio_id) " +
									" AND tb.CREATION_DATE between  ?23 AND ?24";
						}
						/*Other Conditions */
						queryStr=queryStr +" AND tb.active_status = 1 "  + /*Show only those that are not deleted */
			            " AND tb.current_user_id = tb.original_user_id " +   /*Show only those on the market */
			            " AND tb.Expiration_Date > SYSDATE() " +
			            " AND tb.Publish_to_mp = 1 " + /*Show only those on the market */
			            " AND tbm.board_id = tb.board_id " +
			            " ) "+
						" ORDER BY tbm.effective_date desc LIMIT 0, ?21" /*Show only top n records */;
		TypedQuery<com.f9g4.domain.TrBoardSearch> query = (TypedQuery<TrBoardSearch>) entityManager.createNativeQuery(queryStr, com.f9g4.domain.TrBoardSearch.class);
		
		if(null != designerName ){
			designerName = "%" + designerName +"%";
		}else{
			designerName = "%%";
		}
		query.setParameter(1, designerName );
		
		query.setParameter(2, ratingStart);
		query.setParameter(3, ratingEnd);

		if(null == countryIds || countryIds.length ==0){
			query.setParameter(4, null);
			query.setParameter(5, null);
		}else{
			List<Integer> countries=Arrays.asList(countryIds);
			query.setParameter(4, countries);
			query.setParameter(5, arrayToString(countryIds, ",")); //convert to a string
		}

		//lang
		if(null == langIds || langIds.length ==0){
			query.setParameter(6, null);
			query.setParameter(7, null); 	
		}else{
			List<Integer> langs=Arrays.asList(langIds);
			query.setParameter(6, langs);
			query.setParameter(7, arrayToString(langIds, ",")); //convert to a string
		}

		
		//skill		
		if(null == skillIds || skillIds.length ==0){
			query.setParameter(8, null);
			query.setParameter(9, null); 	
		}else{
			List<Integer> skills=Arrays.asList(skillIds);
			query.setParameter(8, skills);
			query.setParameter(9, arrayToString(skillIds, ",")); //convert to a string
		}
		
		//08012014 Fred Expertise	
		if(null != expertiseIds && expertiseIds.length > 0){
			List<Integer> expertiseList=Arrays.asList(expertiseIds);
			query.setParameter(25, expertiseList);
			query.setParameter(26, arrayToString(expertiseIds, ",")); //convert to a string 	
		}
		
		//08012014 Fred Specialty	
		if(null != specialtyIds && specialtyIds.length > 0){
			List<Integer> specialtyList=Arrays.asList(specialtyIds);
			query.setParameter(27, specialtyList);
			query.setParameter(28, arrayToString(specialtyIds, ",")); //convert to a string	
		}
				
		//08012014 Fred Education	
		if(null != educationIds && educationIds.length > 0){
			List<Integer> educationList=Arrays.asList(educationIds);
			query.setParameter(29, educationList);
			query.setParameter(30, arrayToString(educationIds, ",")); //convert to a string
		}
		
		schoolAwards = (null == schoolAwards? "%%" : "%"+schoolAwards+"%");
		query.setParameter(10, schoolAwards);
		
		keywords = ((null == keywords || keywords.isEmpty())? "%"+Constants.KEYWORD_KEYWORD_XML.replace("${content}", "")+"%" : "%"+Constants.KEYWORD_KEYWORD_XML.replace("${content}", keywords)+"%");
		query.setParameter(22, keywords);
		
		query.setParameter(11, division);
		query.setParameter(12, category);
		//query.setParameter(13, product); //TODO No use for now
		//query.setParameter(14, productType); //TODO No use for now
		//Set multiple values for category level 4
		if(productType!=null)
		{
			if(productType.length>0)
			{
				for(int i=0;i<productType.length;i++)
					query.setParameter(baseLevel4Index+i, "%"+Constants.KEYWORD_PRODUCT_TYPE_XML.replace("${content}", productType[i])+"%");
			}
			else
				query.setParameter(baseLevel4Index, "%"+Constants.KEYWORD_PRODUCT_TYPE_XML.replace("${content}", "")+"%");
		}
		else
		{
			query.setParameter(baseLevel4Index, "%"+Constants.KEYWORD_PRODUCT_TYPE_XML.replace("${content}", "")+"%");
		}
		//category level 3
		if(product==null)
			product="";
		query.setParameter(14, "%"+Constants.KEYWORD_PRODUCT_XML.replace("${content}", product)+"%");
			
		//seasonYearIds		
		if(null == seasonYearIds || seasonYearIds.length ==0){
			query.setParameter(15, null);
			query.setParameter(16, null); 
		}else{
			List<Integer> seasonYears=Arrays.asList(seasonYearIds);
			query.setParameter(15, seasonYears);
			query.setParameter(16, arrayToString(seasonYearIds, ",")); //convert to a string
		}
						
		//saletype ids		
		if(null == saleTypeIds || saleTypeIds.length ==0){
			query.setParameter(17, null);
			query.setParameter(18, null);
		}else{
			List<Integer> saleTypes=Arrays.asList(saleTypeIds);
			query.setParameter(17, saleTypes);
			query.setParameter(18, arrayToString(saleTypeIds, ",")); //convert to a string
		}
		
		if(isPortfolioSearch){
			if(searchStartDt !=null && searchEndDt !=null){
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					query.setParameter(23, dateFormat.format(searchStartDt));
					query.setParameter(24, dateFormat.format(searchEndDt));
			}
		}

		query.setParameter(19, priceLow);
		query.setParameter(20, priceHigh);
		query.setParameter(21, limt);
		//set membership pricing option id
		query.setParameter(13, memPricingOption);
		//bind admin rating
		query.setParameter(31, minAdminRating);
		query.setParameter(32, maxAdminRating);
		LinkedHashSet<TrBoardSearch> result = new LinkedHashSet<TrBoardSearch>(query.getResultList());
		return result;
	}
	
	// Convert an array of strings to one string.
	// Put the 'separator' string between each element.
	private  String arrayToString(Integer[] a, String separator) {
	    StringBuffer result = new StringBuffer();
	    if (null != a && a.length > 0) {
	        result.append(a[0]);
	        for (int i=1; i<a.length; i++) {
	            result.append(separator);
	            result.append(a[i]);
	        }
	    }
	    return result.toString();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object> findTrBoardsCountAndTotalPurchasedByUser(Integer userId) throws DataAccessException {
		Query query = getEntityManager().createNativeQuery("SELECT count(*) as count, sum(total_price) as totalAmount from tr_board WHERE current_user_id=? AND PUBLISH_TO_MP = 0");		
		query.setParameter(1, userId);
		List<Object> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional

	public Set<TrBoardSearch> findTrBoardsFromRecentlyViewedBoards(Integer userId, Integer memPricingOptionId, Integer limit) throws DataAccessException {
		Query query = getEntityManager().createNamedQuery("findTrBoardsFromRecentlyViewedBoards");
		query.setParameter(1, userId );
		query.setParameter(2, limit);
		query.setParameter(3, memPricingOptionId);
		return new LinkedHashSet<TrBoardSearch>(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardSearch> findTrBoardsForMayWeSuggest(Integer memPricingOptionId, Integer limit)throws DataAccessException {
		Query query = getEntityManager().createNamedQuery("findTrBoardsForMayWeSuggest");
		query.setParameter(1, limit);
		query.setParameter(2, memPricingOptionId);
		//admin rating
		query.setParameter(3, minAdminRating);
		query.setParameter(4, new BigDecimal(5.0));
		return new LinkedHashSet<TrBoardSearch>(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardForSample(Integer limit) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardForSample",0,limit);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoard> findTrBoardForSampleByUserId(List<Integer> userIds, Integer limit) throws DataAccessException
	{
		Query query = createNamedQuery("findTrBoardForSampleByUserId",0,limit);
		query.setParameter(1, userIds);
		return new LinkedHashSet<TrBoard>(query.getResultList());
	}

	public Set<TrBoardSearch> findTrBoardsOfExamplesBySearchCriteria(
			String designerName, Integer[] countryIds, Integer[] langIds,
			Integer[] skillIds, String schoolAwards, Integer limt,
			boolean isPortfolioSearch, Date searchStartDt, Date searchEndDt,
			Integer[] expertiseIds, Integer[] specialtyIds,
			Integer[] educationIds, Integer minAdminRating,
			Integer maxAdminRating) throws DataAccessException {
		
		
		int baseLevel4Index=33;
		String level4Statements = " and ( upper(tb.keyword) like upper(?"+baseLevel4Index+")";
		
		level4Statements+=" ) ";
		String expertiseSubQ="";
		String specialtySubQ="";
		String educationSubQ="";
		//sub-query for expertise
		if(expertiseIds != null && expertiseIds.length > 0)
		{
			expertiseSubQ=" AND EXISTS (SELECT 1 FROM ad_user_expertise aue WHERE aue.active_status = 1 and aue.user_id = tb.original_user_id AND (aue.exp_id in (?25) " + /* Enclose String in single quotes */
       				" OR aue.exp_id = IFNULL(?26, aue.exp_id))) ";
		}
		//sub-query for specialty
		if(specialtyIds != null && specialtyIds.length > 0)
		{
			specialtySubQ=" AND EXISTS (SELECT 1 FROM ad_user_specialities asp WHERE asp.active_status = 1 and asp.user_id = tb.original_user_id AND (asp.spl_id in (?27) " + /* Enclose String in single quotes */
   					" OR asp.spl_id = IFNULL(?28, asp.spl_id))) ";
		}
		//sub-query for education
		if(educationIds != null && educationIds.length > 0)
		{
			educationSubQ=" AND EXISTS (SELECT 1 FROM ad_user_educations aedu WHERE aedu.active_status = 1 and aedu.user_id = tb.original_user_id AND (aedu.edu_id in (?29) " + /* Enclose String in single quotes */
       				" OR aedu.edu_id = IFNULL(?30, aedu.edu_id))) ";
		}
		
		String queryStr = "SELECT tbm.* , tbi.*, 1 as TEMP_SALE_PRICE  "+
				" from tr_board tbm, tr_board_images tbi"+
				" where tbm.board_id = tbi.board_id "+
				"AND EXISTS ( "+
						"SELECT 1 "+
						" from tr_board tb " +
						" where "  +
						/* Designer Name */
						"  EXISTS (SELECT \'1\' FROM ad_users au WHERE au.active_status = 1 and upper(concat(FirstName, LastName)) like upper(replace(?1 ,' ','%')) AND au.user_id = tb.original_user_id AND au.admin_rating between ?31 and ?32 )" +
												
						/* Designer Country PASS STRING OF COUNTRY IDs enclosed in ' */
						" AND EXISTS (SELECT 1 FROM ad_addresses aad WHERE aad.active_status = 1 and aad.user_id = tb.original_user_id AND ( aad.country_id in (?4) "  + /* Enclose String in single quotes */ 
					    " OR aad.country_id = IFNULL(?5, aad.country_id ))) " + /*Pass NULL If no data */
				
					    /* Languages PASS LANG CODE*/
						" AND EXISTS (SELECT 1 FROM ad_user_languages aul WHERE aul.active_status = 1 and aul.user_id = tb.original_user_id AND (aul.language_id in (?6)" + /* Enclose String in single quotes */
						" OR aul.language_id  = IFNULL(?7, aul.language_id))) " +			
				
						/* Skills PASS SKILL CODE */
						" AND EXISTS (SELECT 1 FROM ad_user_skills aus WHERE  aus.active_status = 1 and aus.user_id = tb.original_user_id AND (aus.skill_id in (?8) " + /* Enclose String in single quotes */
					    " OR aus.skill_id = IFNULL(?9, aus.skill_id))) " + 
						
						/* Expertise 08012014 */
						expertiseSubQ +

       					/* Specialty 08012014 */
       					specialtySubQ +

      					/* Education 08012014 */
      					educationSubQ +
						
						/* Schools,Awards,Events,Markets */
						" AND EXISTS (SELECT 1 FROM ad_users au  WHERE  au.active_status = 1 and upper(IFNULL(au.school_awards,'X')) like upper(?10) and au.user_id = tb.original_user_id ) " +
						
						/*Show only Available Boards */
						" AND EXISTS (SELECT 1 FROM ad_lookup_values alv where alv.active_status = 1 and alv.lookup_code = 'AVAILABLE' and alv. lookup_value_id = tb.status_id) " +
						
					//	" AND (tbm.total_price+((tbm.total_price*commission)/100)) between ifnull(?19, (tbm.total_price+((tbm.total_price*commission)/100))) and ifnull(?20,  (tbm.total_price+((tbm.total_price*commission)/100))) "  +  
	
						" ";
						if(isPortfolioSearch==false){
							//04302014 Fred - new logic to check the original user is visible user=================================
							/*Portfolio has to be sellable*/
							queryStr=queryStr + " AND EXISTS (SELECT 1 FROM tr_portfolio tp WHERE tp.sellable = 0 and tp.portfolio_id = tb.portfolio_id) "+
							/*Designer has reviewed portfolio pages more than 3*/
							" AND EXISTS (SELECT 1 FROM tr_portfolio tp LEFT JOIN tr_board tbp ON tp.portfolio_id = tbp.portfolio_id "+
							" WHERE tp.sellable = 0 AND tp.active_status = 1 AND tbp.active_status = 1 AND tbp.publish_to_mp = 1 AND tp.user_id = tb.original_user_id "+
							" GROUP BY tbp.original_user_id "+
							" HAVING COUNT(tbp.board_id) >= 3) ";
						}
						//=====================================================================================================
						else{
							queryStr=queryStr + "AND EXISTS (SELECT 1 FROM tr_portfolio tp WHERE tp.sellable = 0 and  tp.active_status = 0 and tp.name like 'Samples Portfolio for%' and tp.portfolio_id = tb.portfolio_id) " +
									" AND tb.CREATION_DATE between  ?23 AND ?24";
						}
						/*Other Conditions */
						queryStr=queryStr +" AND tb.active_status = 0 "  + /*Show only those that are not deleted */
			            " AND tb.current_user_id = tb.original_user_id " +   /*Show only those on the market */
			         //   " AND tb.Expiration_Date > SYSDATE() " +
			            " AND tb.Publish_to_mp = 2 " + /*Show only those on the market */
			            " AND tb.board_price = 1"+
			            " AND tb.total_price = 1"+
			            " AND tbm.board_id = tb.board_id " +
			            " ) "+
						" ORDER BY tbm.effective_date desc LIMIT 0, ?21" /*Show only top n records */;
		TypedQuery<com.f9g4.domain.TrBoardSearch> query = (TypedQuery<TrBoardSearch>) entityManager.createNativeQuery(queryStr, com.f9g4.domain.TrBoardSearch.class);
		
		if(null != designerName ){
			designerName = "%" + designerName +"%";
		}else{
			designerName = "%%";
		}
				
		query.setParameter(1, designerName );
		
	//	query.setParameter(2, ratingStart);
	//	query.setParameter(3, ratingEnd);

		if(null == countryIds || countryIds.length ==0){
			query.setParameter(4, null);
			query.setParameter(5, null);
		}else{
			List<Integer> countries=Arrays.asList(countryIds);
			query.setParameter(4, countries);
			query.setParameter(5, arrayToString(countryIds, ",")); //convert to a string
		}

		//lang
		if(null == langIds || langIds.length ==0){
			query.setParameter(6, null);
			query.setParameter(7, null); 	
		}else{
			List<Integer> langs=Arrays.asList(langIds);
			query.setParameter(6, langs);
			query.setParameter(7, arrayToString(langIds, ",")); //convert to a string
		}

		
		//skill		
		if(null == skillIds || skillIds.length ==0){
			query.setParameter(8, null);
			query.setParameter(9, null); 	
		}else{
			List<Integer> skills=Arrays.asList(skillIds);
			query.setParameter(8, skills);
			query.setParameter(9, arrayToString(skillIds, ",")); //convert to a string
		}
		
		//08012014 Fred Expertise	
		if(null != expertiseIds && expertiseIds.length > 0){
			List<Integer> expertiseList=Arrays.asList(expertiseIds);
			query.setParameter(25, expertiseList);
			query.setParameter(26, arrayToString(expertiseIds, ",")); //convert to a string 	
		}
		
		//08012014 Fred Specialty	
		if(null != specialtyIds && specialtyIds.length > 0){
			List<Integer> specialtyList=Arrays.asList(specialtyIds);
			query.setParameter(27, specialtyList);
			query.setParameter(28, arrayToString(specialtyIds, ",")); //convert to a string	
		}
				
		//08012014 Fred Education	
		if(null != educationIds && educationIds.length > 0){
			List<Integer> educationList=Arrays.asList(educationIds);
			query.setParameter(29, educationList);
			query.setParameter(30, arrayToString(educationIds, ",")); //convert to a string
		}
		
		schoolAwards = (null == schoolAwards? "%%" : "%"+schoolAwards+"%");
		query.setParameter(10, schoolAwards);
				
		if(isPortfolioSearch){
			if(searchStartDt !=null && searchEndDt !=null){
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					query.setParameter(23, dateFormat.format(searchStartDt));
					query.setParameter(24, dateFormat.format(searchEndDt));
			}
		}

		//query.setParameter(19, null);
		//query.setParameter(20, null);
		
		query.setParameter(21, limt);
		//set membership pricing option id
		//query.setParameter(13, memPricingOption);
		//bind admin rating
		query.setParameter(31, minAdminRating);
		query.setParameter(32, maxAdminRating);
		
		LinkedHashSet<TrBoardSearch> result = new LinkedHashSet<TrBoardSearch>(query.getResultList());

		return result;
	}
	
	
}
