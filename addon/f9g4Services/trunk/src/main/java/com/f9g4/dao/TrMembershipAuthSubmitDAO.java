package com.f9g4.dao;

import com.f9g4.domain.TrMembershipAuthSubmit;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrMembershipAuthSubmit entities.
 * 
 */
public interface TrMembershipAuthSubmitDAO extends
		JpaDao<TrMembershipAuthSubmit> {

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreatedBy
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreatedBy
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByChargeAmount
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByChargeAmount(java.math.BigDecimal chargeAmount) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByChargeAmount
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByChargeAmount(BigDecimal chargeAmount, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreationDate
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByCreationDate
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByPrimaryKey
	 *
	 */
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByPrimaryKey(Integer memAuthSubmitId) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByPrimaryKey
	 *
	 */
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByPrimaryKey(Integer memAuthSubmitId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByMemAuthSubmitId
	 *
	 */
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByMemAuthSubmitId(Integer memAuthSubmitId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByMemAuthSubmitId
	 *
	 */
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitByMemAuthSubmitId(Integer memAuthSubmitId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByInitTimestamp
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByInitTimestamp(java.util.Calendar initTimestamp) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByInitTimestamp
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByInitTimestamp(Calendar initTimestamp, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdatedBy
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdatedBy
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrMembershipAuthSubmits
	 *
	 */
	public Set<TrMembershipAuthSubmit> findAllTrMembershipAuthSubmits() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrMembershipAuthSubmits
	 *
	 */
	public Set<TrMembershipAuthSubmit> findAllTrMembershipAuthSubmits(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdateDate
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrMembershipAuthSubmitByLastUpdateDate
	 *
	 */
	public Set<TrMembershipAuthSubmit> findTrMembershipAuthSubmitByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	
	/**
	 * JPQL Query - findTrMembershipAuthSubmitBySecurityToken
	 *
	 */
	public TrMembershipAuthSubmit findTrMembershipAuthSubmitBySecurityToken(String securityToken) throws DataAccessException;
}