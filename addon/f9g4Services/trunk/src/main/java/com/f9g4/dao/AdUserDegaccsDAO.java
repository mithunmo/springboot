package com.f9g4.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.f9g4.domain.AdUserDegaccs;


public interface AdUserDegaccsDAO extends JpaDao<AdUserDegaccs> {
	/**
	 * JPQL Query - findAdUserDegaccsByLastUpdatedBy
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByLastUpdatedBy
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByUserSkillId
	 *
	 */
	public AdUserDegaccs findAdUserDegaccsByUserDegaccsId(Integer userDEgaccsId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByUserSkillId
	 *
	 */
	public AdUserDegaccs findAdUserDegaccsByUserDegaccsId(Integer userDEgaccsId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByLastUpdateDate
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByLastUpdateDate
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByActiveStatus
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByActiveStatus
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByCreationDate
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByCreationDate
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserDegaccss
	 *
	 */
	public Set<AdUserDegaccs> findAllAdUserDegaccss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserDegaccss
	 *
	 */
	public Set<AdUserDegaccs> findAllAdUserDegaccss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByCreatedBy
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByCreatedBy
	 *
	 */
	public Set<AdUserDegaccs> findAdUserDegaccsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByPrimaryKey
	 *
	 */
	public AdUserDegaccs findAdUserDegaccsByPrimaryKey(Integer userDEgaccsId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserDegaccsByPrimaryKey
	 *
	 */
	public AdUserDegaccs findAdUserDegaccsByPrimaryKey(Integer userDEgaccsId, int startResult, int maxRows) throws DataAccessException;


}
