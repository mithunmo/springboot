package com.f9g4.dao;

import com.f9g4.domain.AdUserMemberships;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdUserMemberships entities.
 * 
 */
public interface AdUserMembershipsDAO extends JpaDao<AdUserMemberships> {

	/**
	 * JPQL Query - findAdUserMembershipsByMembershipId
	 *
	 */
	public AdUserMemberships findAdUserMembershipsByMembershipId(Integer membershipId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByMembershipId
	 *
	 */
	public AdUserMemberships findAdUserMembershipsByMembershipId(Integer membershipId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByExpirationDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByExpirationDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByExpirationDate(Calendar expirationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdatedBy
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdatedBy
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdateDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdateDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByCreatedBy
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByCreatedBy
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserMembershipss
	 *
	 */
	public Set<AdUserMemberships> findAllAdUserMembershipss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserMembershipss
	 *
	 */
	public Set<AdUserMemberships> findAllAdUserMembershipss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByAutopay
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByAutopay(Integer autopay) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByAutopay
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByAutopay(Integer autopay, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByEffectiveDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByEffectiveDate(java.util.Calendar effectiveDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByEffectiveDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByEffectiveDate(Calendar effectiveDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByCreationDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByCreationDate
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByPrimaryKey
	 *
	 */
	public AdUserMemberships findAdUserMembershipsByPrimaryKey(Integer membershipId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByPrimaryKey
	 *
	 */
	public AdUserMemberships findAdUserMembershipsByPrimaryKey(Integer membershipId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByAutopayWithdrawDay
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByAutopayWithdrawDay(Integer autopayWithdrawDay) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserMembershipsByAutopayWithdrawDay
	 *
	 */
	public Set<AdUserMemberships> findAdUserMembershipsByAutopayWithdrawDay(Integer autopayWithdrawDay, int startResult, int maxRows) throws DataAccessException;

	
	/**
	 * JPQL Query - findAdUserMembershipsByUserId
	 *
	 */
	public AdUserMemberships findAdUserMembershipsByUserId(Integer userId) throws DataAccessException;

}