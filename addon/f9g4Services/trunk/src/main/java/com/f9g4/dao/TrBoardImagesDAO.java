package com.f9g4.dao;

import com.f9g4.domain.TrBoardImages;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrBoardImages entities.
 * 
 */
public interface TrBoardImagesDAO extends JpaDao<TrBoardImages> {

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrl
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrl(String sourceFileUrl) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrl
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrl(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByLastUpatedBy
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByLastUpatedBy(Integer lastUpatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByLastUpatedBy
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByLastUpatedBy(Integer lastUpatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileTypeContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileTypeContaining(String fileType) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileTypeContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileTypeContaining(String fileType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByPrimaryKey
	 *
	 */
	public TrBoardImages findTrBoardImagesByPrimaryKey(Integer boardImageId) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByPrimaryKey
	 *
	 */
	public TrBoardImages findTrBoardImagesByPrimaryKey(Integer boardImageId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileName
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileName(String fileName) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileName
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileName(String fileName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByBoardImageId
	 *
	 */
	public TrBoardImages findTrBoardImagesByBoardImageId(Integer boardImageId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByBoardImageId
	 *
	 */
	public TrBoardImages findTrBoardImagesByBoardImageId(Integer boardImageId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByCreationDate
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByCreationDate
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrl
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrl(String mainImageUrl) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrl
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrl(String mainImageUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileNameContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileNameContaining(String fileName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileNameContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileNameContaining(String fileName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrlContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrlContaining(String sourceFileUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrlContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrlContaining(String sourceFileUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileType
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileType(String fileType_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByFileType
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByFileType(String fileType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrl
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrl(String thumbnailUrl) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrl
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrl(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrlContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrlContaining(String mainImageUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrlContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrlContaining(String mainImageUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrlContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrlContaining(String thumbnailUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrlContaining
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrlContaining(String thumbnailUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrBoardImagess
	 *
	 */
	public Set<TrBoardImages> findAllTrBoardImagess() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrBoardImagess
	 *
	 */
	public Set<TrBoardImages> findAllTrBoardImagess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByCreatedBy
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByCreatedBy
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByLastUpdateDate
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrBoardImagesByLastUpdateDate
	 *
	 */
	public Set<TrBoardImages> findTrBoardImagesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

}