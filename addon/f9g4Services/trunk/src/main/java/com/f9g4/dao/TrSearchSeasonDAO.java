package com.f9g4.dao;

import com.f9g4.domain.TrSearchSeason;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrSearchSeason entities.
 * 
 */
public interface TrSearchSeasonDAO extends JpaDao<TrSearchSeason> {

	/**
	 * JPQL Query - findTrSearchSeasonByCreationDate
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByCreationDate
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdatedBy
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdatedBy
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdateDate
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByLastUpdateDate
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrSearchSeasons
	 *
	 */
	public Set<TrSearchSeason> findAllTrSearchSeasons() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrSearchSeasons
	 *
	 */
	public Set<TrSearchSeason> findAllTrSearchSeasons(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByCreatedBy
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByCreatedBy
	 *
	 */
	public Set<TrSearchSeason> findTrSearchSeasonByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByPrimaryKey
	 *
	 */
	public TrSearchSeason findTrSearchSeasonByPrimaryKey(Integer searchSeasonId) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonByPrimaryKey
	 *
	 */
	public TrSearchSeason findTrSearchSeasonByPrimaryKey(Integer searchSeasonId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonBySearchSeasonId
	 *
	 */
	public TrSearchSeason findTrSearchSeasonBySearchSeasonId(Integer searchSeasonId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchSeasonBySearchSeasonId
	 *
	 */
	public TrSearchSeason findTrSearchSeasonBySearchSeasonId(Integer searchSeasonId_1, int startResult, int maxRows) throws DataAccessException;

}