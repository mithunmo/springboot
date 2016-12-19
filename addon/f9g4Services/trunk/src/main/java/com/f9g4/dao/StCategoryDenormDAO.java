package com.f9g4.dao;

import com.f9g4.domain.StCategoryDenorm;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage StCategoryDenorm entities.
 * 
 */
public interface StCategoryDenormDAO extends JpaDao<StCategoryDenorm> {

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2ValueContaining(String catLevel2Value) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2ValueContaining(String catLevel2Value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByPrimaryKey
	 *
	 */
	public StCategoryDenorm findStCategoryDenormByPrimaryKey(Integer categoryDenormId) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByPrimaryKey
	 *
	 */
	public StCategoryDenorm findStCategoryDenormByPrimaryKey(Integer categoryDenormId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCategoryDenormId
	 *
	 */
	public StCategoryDenorm findStCategoryDenormByCategoryDenormId(Integer categoryDenormId_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCategoryDenormId
	 *
	 */
	public StCategoryDenorm findStCategoryDenormByCategoryDenormId(Integer categoryDenormId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Value(String catLevel1Value) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Value(String catLevel1Value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Id(Integer catLevel1Id) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Id(Integer catLevel1Id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCreatedBy
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCreatedBy
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdateDate
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdateDate
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCreationDate
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCreationDate
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3ValueContaining(String catLevel3Value) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3ValueContaining(String catLevel3Value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllStCategoryDenorms
	 *
	 */
	public Set<StCategoryDenorm> findAllStCategoryDenorms() throws DataAccessException;

	/**
	 * JPQL Query - findAllStCategoryDenorms
	 *
	 */
	public Set<StCategoryDenorm> findAllStCategoryDenorms(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5ValueContaining(String catLevel5Value) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5ValueContaining(String catLevel5Value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Value(String catLevel4Value) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Value(String catLevel4Value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLangCode
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLangCode
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdatedBy
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdatedBy
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1ValueContaining(String catLevel1Value_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1ValueContaining(String catLevel1Value_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4ValueContaining(String catLevel4Value_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4ValueContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4ValueContaining(String catLevel4Value_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Value(String catLevel2Value_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Value(String catLevel2Value_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Value(String catLevel5Value_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Value(String catLevel5Value_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Id(Integer catLevel2Id) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Id(Integer catLevel2Id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Id(Integer catLevel4Id) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Id(Integer catLevel4Id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLangCodeContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByLangCodeContaining
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Id(Integer catLevel5Id) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Id(Integer catLevel5Id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Value(String catLevel3Value_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Value
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Value(String catLevel3Value_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Id(Integer catLevel3Id) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Id
	 *
	 */
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Id(Integer catLevel3Id, int startResult, int maxRows) throws DataAccessException;

}