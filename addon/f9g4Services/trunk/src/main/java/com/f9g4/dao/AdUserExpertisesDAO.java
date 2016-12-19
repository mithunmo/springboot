package com.f9g4.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.f9g4.domain.AdUserExpertises;


public interface AdUserExpertisesDAO extends JpaDao<AdUserExpertises> {
	/**
	 * JPQL Query - findAdUserExpertisesByLastUpdatedBy
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByLastUpdatedBy
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByUserSkillId
	 *
	 */
	public AdUserExpertises findAdUserExpertisesByUserExpertiseId(Integer userExpertiseId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByUserSkillId
	 *
	 */
	public AdUserExpertises findAdUserExpertisesByUserExpertiseId(Integer userExpertiseId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByLastUpdateDate
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByLastUpdateDate
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByActiveStatus
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByActiveStatus
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByCreationDate
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByCreationDate
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserExpertisess
	 *
	 */
	public Set<AdUserExpertises> findAllAdUserExpertisess() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserExpertisess
	 *
	 */
	public Set<AdUserExpertises> findAllAdUserExpertisess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByCreatedBy
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByCreatedBy
	 *
	 */
	public Set<AdUserExpertises> findAdUserExpertisesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByPrimaryKey
	 *
	 */
	public AdUserExpertises findAdUserExpertisesByPrimaryKey(Integer userExpertiseId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserExpertisesByPrimaryKey
	 *
	 */
	public AdUserExpertises findAdUserExpertisesByPrimaryKey(Integer userExpertiseId, int startResult, int maxRows) throws DataAccessException;


}
