package com.f9g4.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

import com.f9g4.domain.AdUserSpecialities;


public interface AdUserSpecialitiesDAO extends JpaDao<AdUserSpecialities> {
	/**
	 * JPQL Query - findAdUserSpecialitiesByLastUpdatedBy
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByLastUpdatedBy
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByUserSkillId
	 *
	 */
	public AdUserSpecialities findAdUserSpecialitiesByUserSpecialitiesId(Integer userSpecialitiesId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByUserSkillId
	 *
	 */
	public AdUserSpecialities findAdUserSpecialitiesByUserSpecialitiesId(Integer userSpecialitiesId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByLastUpdateDate
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByLastUpdateDate
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByActiveStatus
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByActiveStatus
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreationDate
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreationDate
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserSpecialitiess
	 *
	 */
	public Set<AdUserSpecialities> findAllAdUserSpecialitiess() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserSpecialitiess
	 *
	 */
	public Set<AdUserSpecialities> findAllAdUserSpecialitiess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreatedBy
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByCreatedBy
	 *
	 */
	public Set<AdUserSpecialities> findAdUserSpecialitiesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByPrimaryKey
	 *
	 */
	public AdUserSpecialities findAdUserSpecialitiesByPrimaryKey(Integer userSpecialitiesId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSpecialitiesByPrimaryKey
	 *
	 */
	public AdUserSpecialities findAdUserSpecialitiesByPrimaryKey(Integer userSpecialitiesId, int startResult, int maxRows) throws DataAccessException;


}
