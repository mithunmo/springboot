package com.f9g4.dao;

import com.f9g4.domain.StSeasonYear;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage StSeasonYear entities.
 * 
 */
public interface StSeasonYearDAO extends JpaDao<StSeasonYear> {

	/**
	 * JPQL Query - findStSeasonYearBySeasonContaining
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearBySeasonContaining(String season) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearBySeasonContaining
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearBySeasonContaining(String season, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByCreationDate
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByCreationDate
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByPrimaryKey
	 *
	 */
	public StSeasonYear findStSeasonYearByPrimaryKey(Integer seasonYearId) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByPrimaryKey
	 *
	 */
	public StSeasonYear findStSeasonYearByPrimaryKey(Integer seasonYearId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLastUpdateDate
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLastUpdateDate
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearBySeasonYearId
	 *
	 */
	public StSeasonYear findStSeasonYearBySeasonYearId(Integer seasonYearId_1) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearBySeasonYearId
	 *
	 */
	public StSeasonYear findStSeasonYearBySeasonYearId(Integer seasonYearId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByYearContaining
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByYearContaining(String year) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByYearContaining
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByYearContaining(String year, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLangCode
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLangCode
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByYear
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByYear(String year_1) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByYear
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByYear(String year_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByActiveStatus
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByActiveStatus
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllStSeasonYears
	 *
	 */
	public Set<StSeasonYear> findAllStSeasonYears() throws DataAccessException;

	/**
	 * JPQL Query - findAllStSeasonYears
	 *
	 */
	public Set<StSeasonYear> findAllStSeasonYears(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByCreatedBy
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByCreatedBy
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLastUpdatedBy
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLastUpdatedBy
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearBySeason
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearBySeason(String season_1) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearBySeason
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearBySeason(String season_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLangCodeContaining
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findStSeasonYearByLangCodeContaining
	 *
	 */
	public Set<StSeasonYear> findStSeasonYearByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

}