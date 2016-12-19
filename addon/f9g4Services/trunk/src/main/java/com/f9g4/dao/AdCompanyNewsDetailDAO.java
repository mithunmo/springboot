package com.f9g4.dao;

import com.f9g4.domain.AdCompanyNewsDetail;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdCompanyNewsDetail entities.
 * 
 */
public interface AdCompanyNewsDetailDAO extends JpaDao<AdCompanyNewsDetail> {

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreatedBy
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreatedBy
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeadingContaining
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeadingContaining(String contentHeading) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeadingContaining
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeadingContaining(String contentHeading, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCompNewsDtlId
	 *
	 */
	public AdCompanyNewsDetail findAdCompanyNewsDetailByCompNewsDtlId(Integer compNewsDtlId) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCompNewsDtlId
	 *
	 */
	public AdCompanyNewsDetail findAdCompanyNewsDetailByCompNewsDtlId(Integer compNewsDtlId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByPrimaryKey
	 *
	 */
	public AdCompanyNewsDetail findAdCompanyNewsDetailByPrimaryKey(Integer compNewsDtlId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByPrimaryKey
	 *
	 */
	public AdCompanyNewsDetail findAdCompanyNewsDetailByPrimaryKey(Integer compNewsDtlId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePathContaining
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePathContaining(String contentImagePath) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePathContaining
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePathContaining(String contentImagePath, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeading
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeading(String contentHeading_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeading
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeading(String contentHeading_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdateDate
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdateDate
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdCompanyNewsDetails
	 *
	 */
	public Set<AdCompanyNewsDetail> findAllAdCompanyNewsDetails() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdCompanyNewsDetails
	 *
	 */
	public Set<AdCompanyNewsDetail> findAllAdCompanyNewsDetails(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreationDate
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreationDate
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentDetail
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentDetail(String contentDetail) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentDetail
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentDetail(String contentDetail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePath
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePath(String contentImagePath_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePath
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePath(String contentImagePath_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdatedBy
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdatedBy
	 *
	 */
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

}