package com.f9g4.dao;

import com.f9g4.domain.TrReceiveMembershipPayments;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrReceiveMembershipPayments entities.
 * 
 */
public interface TrReceiveMembershipPaymentsDAO extends
		JpaDao<TrReceiveMembershipPayments> {

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreationDate
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreationDate
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByMemPaymentId
	 *
	 */
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByMemPaymentId(Integer memPaymentId) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByMemPaymentId
	 *
	 */
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByMemPaymentId(Integer memPaymentId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcode
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcode(String authcode) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcode
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcode(String authcode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentAmount
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentAmount(java.math.BigDecimal paymentAmount) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentAmount
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentAmount(BigDecimal paymentAmount, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdateDate
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdateDate
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentError
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentError(String paymentError) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentError
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentError(String paymentError, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentErrorContaining
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentErrorContaining(String paymentError_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPaymentErrorContaining
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByPaymentErrorContaining(String paymentError_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdatedBy
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByLastUpdatedBy
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcodeContaining
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcodeContaining(String authcode_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthcodeContaining
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthcodeContaining(String authcode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrReceiveMembershipPaymentss
	 *
	 */
	public Set<TrReceiveMembershipPayments> findAllTrReceiveMembershipPaymentss() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrReceiveMembershipPaymentss
	 *
	 */
	public Set<TrReceiveMembershipPayments> findAllTrReceiveMembershipPaymentss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByReceivedTimestamp
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByReceivedTimestamp(java.util.Calendar receivedTimestamp) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByReceivedTimestamp
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByReceivedTimestamp(Calendar receivedTimestamp, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedByContaining
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedByContaining(String createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedByContaining
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedByContaining(String createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedBy
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedBy(String createdBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByCreatedBy
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByCreatedBy(String createdBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthStatusId
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthStatusId(Integer authStatusId) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByAuthStatusId
	 *
	 */
	public Set<TrReceiveMembershipPayments> findTrReceiveMembershipPaymentsByAuthStatusId(Integer authStatusId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPrimaryKey
	 *
	 */
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByPrimaryKey(Integer memPaymentId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrReceiveMembershipPaymentsByPrimaryKey
	 *
	 */
	public TrReceiveMembershipPayments findTrReceiveMembershipPaymentsByPrimaryKey(Integer memPaymentId_1, int startResult, int maxRows) throws DataAccessException;

}