package com.f9g4.dao;

import com.f9g4.domain.TrSearchLanguages;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrSearchLanguages entities.
 * 
 */
public interface TrSearchLanguagesDAO extends JpaDao<TrSearchLanguages> {

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdateDate
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdateDate
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesBySearchLanguageId
	 *
	 */
	public TrSearchLanguages findTrSearchLanguagesBySearchLanguageId(Integer searchLanguageId) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesBySearchLanguageId
	 *
	 */
	public TrSearchLanguages findTrSearchLanguagesBySearchLanguageId(Integer searchLanguageId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByCreatedBy
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByCreatedBy
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrSearchLanguagess
	 *
	 */
	public Set<TrSearchLanguages> findAllTrSearchLanguagess() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrSearchLanguagess
	 *
	 */
	public Set<TrSearchLanguages> findAllTrSearchLanguagess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByPrimaryKey
	 *
	 */
	public TrSearchLanguages findTrSearchLanguagesByPrimaryKey(Integer searchLanguageId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByPrimaryKey
	 *
	 */
	public TrSearchLanguages findTrSearchLanguagesByPrimaryKey(Integer searchLanguageId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByCreationDate
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByCreationDate
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdatedBy
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrSearchLanguagesByLastUpdatedBy
	 *
	 */
	public Set<TrSearchLanguages> findTrSearchLanguagesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

}