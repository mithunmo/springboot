package com.f9g4.dao;

import com.f9g4.domain.AdCompanyNews;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdCompanyNews entities.
 * 
 */
public interface AdCompanyNewsDAO extends JpaDao<AdCompanyNews> {

	/**
	 * JPQL Query - findAdCompanyNewsByStartDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByStartDate(java.util.Calendar startDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByStartDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByStartDate(Calendar startDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentAliasContaining
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentAliasContaining(String contentAlias) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentAliasContaining
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentAliasContaining(String contentAlias, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByPrimaryKey
	 *
	 */
	public AdCompanyNews findAdCompanyNewsByPrimaryKey(Integer compNewsId) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByPrimaryKey
	 *
	 */
	public AdCompanyNews findAdCompanyNewsByPrimaryKey(Integer compNewsId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */
	public Set<AdCompanyNews> findAllAdCompanyNewss() throws DataAccessException;
	
	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */
	public List<AdCompanyNews> findAllActiveAdCompanyNewss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */
	public List<AdCompanyNews> findAllActiveAdCompanyNewss(int startResult, int maxRows) throws DataAccessException;

	
	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */
	public Set<AdCompanyNews> findAllAdCompanyNewss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByCreatedBy
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByCreatedBy
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByCompNewsId
	 *
	 */
	public AdCompanyNews findAdCompanyNewsByCompNewsId(Integer compNewsId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByCompNewsId
	 *
	 */
	public AdCompanyNews findAdCompanyNewsByCompNewsId(Integer compNewsId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdatedBy
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdatedBy
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocation
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocation(String contentLocation) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocation
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocation(String contentLocation, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocationContaining
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocationContaining(String contentLocation_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocationContaining
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocationContaining(String contentLocation_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentType
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentType(String contentType) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentType
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentType(String contentType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByCreationDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByCreationDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdateDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdateDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentTypeContaining
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentTypeContaining(String contentType_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentTypeContaining
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentTypeContaining(String contentType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentAlias
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentAlias(String contentAlias_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByContentAlias
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByContentAlias(String contentAlias_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByEndDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByEndDate(java.util.Calendar endDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsByEndDate
	 *
	 */
	public Set<AdCompanyNews> findAdCompanyNewsByEndDate(Calendar endDate, int startResult, int maxRows) throws DataAccessException;

}