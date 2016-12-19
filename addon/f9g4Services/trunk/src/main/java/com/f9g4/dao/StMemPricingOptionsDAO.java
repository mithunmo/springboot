package com.f9g4.dao;

import com.f9g4.domain.StMemPricingOptions;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage StMemPricingOptions entities.
 * 
 */
public interface StMemPricingOptionsDAO extends JpaDao<StMemPricingOptions> {

	/**
	 * JPQL Query - findStMemPricingOptionsByPrimaryKey
	 *
	 */
	public StMemPricingOptions findStMemPricingOptionsByPrimaryKey(Integer memPricingId) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByPrimaryKey
	 *
	 */
	public StMemPricingOptions findStMemPricingOptionsByPrimaryKey(Integer memPricingId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCodeContaining
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCodeContaining(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCodeContaining
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByMemPricingId
	 *
	 */
	public StMemPricingOptions findStMemPricingOptionsByMemPricingId(Integer memPricingId_1) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByMemPricingId
	 *
	 */
	public StMemPricingOptions findStMemPricingOptionsByMemPricingId(Integer memPricingId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllStMemPricingOptionss
	 *
	 */
	public Set<StMemPricingOptions> findAllStMemPricingOptionss() throws DataAccessException;

	/**
	 * JPQL Query - findAllStMemPricingOptionss
	 *
	 */
	public Set<StMemPricingOptions> findAllStMemPricingOptionss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByExpirationDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByExpirationDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByExpirationDate(Calendar expirationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByDescription
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByDescription
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCode
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCode(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCode
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCode(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByDescriptionContaining
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByDescriptionContaining
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByCreationDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByCreationDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByDurationInMonths
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByDurationInMonths(Integer durationInMonths) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByDurationInMonths
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByDurationInMonths(Integer durationInMonths, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByCreatedBy
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByCreatedBy
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByEffectiveDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByEffectiveDate(java.util.Calendar effectiveDate) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByEffectiveDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByEffectiveDate(Calendar effectiveDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByPrice
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByPrice(java.math.BigDecimal price) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByPrice
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByPrice(BigDecimal price, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByCommission
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByCommission(java.math.BigDecimal commission) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByCommission
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByCommission(BigDecimal commission, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdateDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdateDate
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdatedBy
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdatedBy
	 *
	 */
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - findStMemPricingOptionsByUserTypeAndMembershipType
	 *
	 */
	public StMemPricingOptions findStMemPricingOptionsByUserTypeAndMembershipType(String UserType, String membershipType) throws DataAccessException;

}