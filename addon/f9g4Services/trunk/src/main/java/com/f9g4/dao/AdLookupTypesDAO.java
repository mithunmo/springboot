package com.f9g4.dao;

import com.f9g4.domain.AdLookupTypes;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdLookupTypes entities.
 * 
 */
public interface AdLookupTypesDAO extends JpaDao<AdLookupTypes> {

	/**
	 * JPQL Query - findAdLookupTypesByCreatedBy
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByCreatedBy
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLangCode
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLangCode
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupType
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupType(String lookupType) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupType
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupType(String lookupType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLangCodeContaining
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLangCodeContaining
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByCreationDate
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByCreationDate
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdatedBy
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdatedBy
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByPrimaryKey
	 *
	 */
	public AdLookupTypes findAdLookupTypesByPrimaryKey(Integer lookupTypeId) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByPrimaryKey
	 *
	 */
	public AdLookupTypes findAdLookupTypesByPrimaryKey(Integer lookupTypeId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByActiveStatus
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByActiveStatus
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeId
	 *
	 */
	public AdLookupTypes findAdLookupTypesByLookupTypeId(Integer lookupTypeId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeId
	 *
	 */
	public AdLookupTypes findAdLookupTypesByLookupTypeId(Integer lookupTypeId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeContaining
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupTypeContaining(String lookupType_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupTypeContaining
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupTypeContaining(String lookupType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescription
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescription(String lookupDescription) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescription
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescription(String lookupDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescriptionContaining
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescriptionContaining(String lookupDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLookupDescriptionContaining
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLookupDescriptionContaining(String lookupDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdLookupTypess
	 *
	 */
	public Set<AdLookupTypes> findAllAdLookupTypess() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdLookupTypess
	 *
	 */
	public Set<AdLookupTypes> findAllAdLookupTypess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdateDate
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdLookupTypesByLastUpdateDate
	 *
	 */
	public Set<AdLookupTypes> findAdLookupTypesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	
	/**
	 * JPQL Query - findAdLookupTypesByLookupType
	 *
	 */
	public AdLookupTypes findAdLookupTypesByLookupTypeName(String lookupType) throws DataAccessException;

}