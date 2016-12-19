package com.f9g4.dao;

import com.f9g4.domain.StTermsConditions;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage StTermsConditions entities.
 * 
 */
public interface StTermsConditionsDAO extends JpaDao<StTermsConditions> {

	/**
	 * JPQL Query - findAllStTermsConditionss
	 *
	 */
	public Set<StTermsConditions> findAllStTermsConditionss() throws DataAccessException;

	/**
	 * JPQL Query - findAllStTermsConditionss
	 *
	 */
	public Set<StTermsConditions> findAllStTermsConditionss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLangCode
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLangCode
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByPrimaryKey
	 *
	 */
	public StTermsConditions findStTermsConditionsByPrimaryKey(Integer termCondId) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByPrimaryKey
	 *
	 */
	public StTermsConditions findStTermsConditionsByPrimaryKey(Integer termCondId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByExpirationDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByExpirationDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByExpirationDate(Calendar expirationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdatedBy
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdatedBy
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLangCodeContaining
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLangCodeContaining
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByTermCondId
	 *
	 */
	public StTermsConditions findStTermsConditionsByTermCondId(Integer termCondId_1) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByTermCondId
	 *
	 */
	public StTermsConditions findStTermsConditionsByTermCondId(Integer termCondId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByCreatedBy
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByCreatedBy
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdateDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdateDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByCreationDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByCreationDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByReviewedByLegal
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByReviewedByLegal(Integer reviewedByLegal) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByReviewedByLegal
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByReviewedByLegal(Integer reviewedByLegal, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByEffectiveDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByEffectiveDate(java.util.Calendar effectiveDate) throws DataAccessException;

	/**
	 * JPQL Query - findStTermsConditionsByEffectiveDate
	 *
	 */
	public Set<StTermsConditions> findStTermsConditionsByEffectiveDate(Calendar effectiveDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findActiveStTermsConditionsByUserTypeAndTermType
	 *
	 */
	public Set<StTermsConditions> findActiveStTermsConditionsByUserTypeAndTermType(String userType, String termType) throws DataAccessException;

	/**
	 * JPQL Query - findAllStTermsConditionsByUserTypeAndTermType
	 *
	 */	
	public Set<StTermsConditions> findAllStTermsConditionsByUserTypeAndTermType(String userType, String termType) throws DataAccessException;
	
	/**
	 * JPQL Query - findAllStTermsConditionsByUserTypeAndTermType
	 *
	 */	
	public Set<StTermsConditions> findAllTermsConditionsByUserIdAndTermType(Integer userId, List<Integer> termTypeIds) throws DataAccessException;
	
}