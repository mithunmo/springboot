package com.f9g4.dao;

import com.f9g4.domain.AdActiveUsers;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdActiveUsers entities.
 * 
 */
public interface AdActiveUsersDAO extends JpaDao<AdActiveUsers> {

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdateDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdateDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByCreatedBy
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByCreatedBy
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByPrimaryKey
	 *
	 */
	public AdActiveUsers findAdActiveUsersByPrimaryKey(Integer activeUserId) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByPrimaryKey
	 *
	 */
	public AdActiveUsers findAdActiveUsersByPrimaryKey(Integer activeUserId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdActiveUserss
	 *
	 */
	public Set<AdActiveUsers> findAllAdActiveUserss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdActiveUserss
	 *
	 */
	public Set<AdActiveUsers> findAllAdActiveUserss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByActiveUserId
	 *
	 */
	public AdActiveUsers findAdActiveUsersByActiveUserId(Integer activeUserId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByActiveUserId
	 *
	 */
	public AdActiveUsers findAdActiveUsersByActiveUserId(Integer activeUserId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersBySessionId
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersBySessionId(Integer sessionId) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersBySessionId
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersBySessionId(Integer sessionId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByCreationDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByCreationDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdatedBy
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLastUpdatedBy
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLogoutDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLogoutDate(java.util.Calendar logoutDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLogoutDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLogoutDate(Calendar logoutDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLoginDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLoginDate(java.util.Calendar loginDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdActiveUsersByLoginDate
	 *
	 */
	public Set<AdActiveUsers> findAdActiveUsersByLoginDate(Calendar loginDate, int startResult, int maxRows) throws DataAccessException;

	
	public AdActiveUsers findAdActiveUsersSingleResultBySessionId(String sessionId) throws DataAccessException;
	
}