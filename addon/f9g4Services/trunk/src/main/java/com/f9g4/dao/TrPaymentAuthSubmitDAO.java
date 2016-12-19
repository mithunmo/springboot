package com.f9g4.dao;

import com.f9g4.domain.TrPaymentAuthSubmit;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrPaymentAuthSubmit entities.
 * 
 */
public interface TrPaymentAuthSubmitDAO extends JpaDao<TrPaymentAuthSubmit> {

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreatedBy
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreatedBy
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPaymentAuthSubmits
	 *
	 */
	public Set<TrPaymentAuthSubmit> findAllTrPaymentAuthSubmits() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPaymentAuthSubmits
	 *
	 */
	public Set<TrPaymentAuthSubmit> findAllTrPaymentAuthSubmits(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrice
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByPrice(java.math.BigDecimal price) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrice
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByPrice(BigDecimal price, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdateDate
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdateDate
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrimaryKey
	 *
	 */
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByPrimaryKey(Integer authSubmitId) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByPrimaryKey
	 *
	 */
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByPrimaryKey(Integer authSubmitId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdatedBy
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByLastUpdatedBy
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByAuthSubmitId
	 *
	 */
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByAuthSubmitId(Integer authSubmitId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByAuthSubmitId
	 *
	 */
	public TrPaymentAuthSubmit findTrPaymentAuthSubmitByAuthSubmitId(Integer authSubmitId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreationDate
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrPaymentAuthSubmitByCreationDate
	 *
	 */
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;
	
	public Set<TrPaymentAuthSubmit> findTrPaymentAuthSubmitBySecureToken(String SecureToken) throws DataAccessException;

}