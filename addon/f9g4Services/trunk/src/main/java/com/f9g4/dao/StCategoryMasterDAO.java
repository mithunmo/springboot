package com.f9g4.dao;

import com.f9g4.domain.StCategoryMaster;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage StCategoryMaster entities.
 * 
 */
public interface StCategoryMasterDAO extends JpaDao<StCategoryMaster> {

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdateDate
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdateDate
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByCreationDate
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByCreationDate
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByPrimaryKey
	 *
	 */
	public StCategoryMaster findStCategoryMasterByPrimaryKey(Integer categoryId) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByPrimaryKey
	 *
	 */
	public StCategoryMaster findStCategoryMasterByPrimaryKey(Integer categoryId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdatedBy
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdatedBy
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByActiveStatus
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByActiveStatus
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLangCode
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLangCode
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByParentId
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByParentId(Integer parentId) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByParentId
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByParentId(Integer parentId, int startResult, int maxRows) throws DataAccessException;


	/**
	 * JPQL Query - findStCategoryMasterByLevel
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLevel(Integer level) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findStCategoryMasterByLevel
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLevelAndParentId(Integer level, Integer parentId) throws DataAccessException;

	
	/**
	 * JPQL Query - findStCategoryMasterByCategoryId
	 *
	 */
	public StCategoryMaster findStCategoryMasterByCategoryId(Integer categoryId_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByCategoryId
	 *
	 */
	public StCategoryMaster findStCategoryMasterByCategoryId(Integer categoryId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLangCodeContaining
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByLangCodeContaining
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByName
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByName
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByNameContaining
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByNameContaining
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByCreatedBy
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findStCategoryMasterByCreatedBy
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMasterByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllStCategoryMasters
	 *
	 */
	public Set<StCategoryMaster> findAllStCategoryMasters() throws DataAccessException;

	/**
	 * JPQL Query - findAllStCategoryMasters
	 *
	 */
	public Set<StCategoryMaster> findAllStCategoryMasters(int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - findAllStCategoryMasters
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMastersForLevel3(int level1Id, int level2Id, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - findAllStCategoryMasters
	 *
	 */
	public Set<StCategoryMaster> findStCategoryMastersForLevel4(int level1Id, int level2Id, List<String> nameOnLevel3, int startResult, int maxRows) throws DataAccessException;

}