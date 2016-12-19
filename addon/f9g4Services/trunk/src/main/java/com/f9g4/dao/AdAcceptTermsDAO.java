package com.f9g4.dao;

import com.f9g4.domain.AdAcceptTerms;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdAcceptTerms entities.
 * 
 */
public interface AdAcceptTermsDAO extends JpaDao<AdAcceptTerms> {

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdateDate
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdateDate
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdAcceptTermss
	 *
	 */
	public Set<AdAcceptTerms> findAllAdAcceptTermss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdAcceptTermss
	 *
	 */
	public Set<AdAcceptTerms> findAllAdAcceptTermss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByCreatedBy
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByCreatedBy
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdatedBy
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdatedBy
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByPrimaryKey
	 *
	 */
	public AdAcceptTerms findAdAcceptTermsByPrimaryKey(Integer acceptTermId) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByPrimaryKey
	 *
	 */
	public AdAcceptTerms findAdAcceptTermsByPrimaryKey(Integer acceptTermId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptanceDate
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByAcceptanceDate(java.util.Calendar acceptanceDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptanceDate
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByAcceptanceDate(Calendar acceptanceDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByCreationDate
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByCreationDate
	 *
	 */
	public Set<AdAcceptTerms> findAdAcceptTermsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptTermId
	 *
	 */
	public AdAcceptTerms findAdAcceptTermsByAcceptTermId(Integer acceptTermId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptTermId
	 *
	 */
	public AdAcceptTerms findAdAcceptTermsByAcceptTermId(Integer acceptTermId_1, int startResult, int maxRows) throws DataAccessException;

}