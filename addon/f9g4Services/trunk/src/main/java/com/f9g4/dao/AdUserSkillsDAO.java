package com.f9g4.dao;

import com.f9g4.domain.AdUserSkills;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdUserSkills entities.
 * 
 */
public interface AdUserSkillsDAO extends JpaDao<AdUserSkills> {

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdatedBy
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdatedBy
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByUserSkillId
	 *
	 */
	public AdUserSkills findAdUserSkillsByUserSkillId(Integer userSkillId) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByUserSkillId
	 *
	 */
	public AdUserSkills findAdUserSkillsByUserSkillId(Integer userSkillId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdateDate
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByLastUpdateDate
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByActiveStatus
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByActiveStatus
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByCreationDate
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByCreationDate
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserSkillss
	 *
	 */
	public Set<AdUserSkills> findAllAdUserSkillss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdUserSkillss
	 *
	 */
	public Set<AdUserSkills> findAllAdUserSkillss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByCreatedBy
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByCreatedBy
	 *
	 */
	public Set<AdUserSkills> findAdUserSkillsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByPrimaryKey
	 *
	 */
	public AdUserSkills findAdUserSkillsByPrimaryKey(Integer userSkillId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdUserSkillsByPrimaryKey
	 *
	 */
	public AdUserSkills findAdUserSkillsByPrimaryKey(Integer userSkillId_1, int startResult, int maxRows) throws DataAccessException;

}