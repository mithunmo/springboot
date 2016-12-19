package com.f9g4.dao;

import com.f9g4.domain.TrPortfolioImages;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrPortfolioImages entities.
 * 
 */
public interface TrPortfolioImagesDAO extends JpaDao<TrPortfolioImages> {

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrl
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrl(String sourceFileUrl) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrl
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrl(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpatedBy
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpatedBy(Integer lastUpatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpatedBy
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpatedBy(Integer lastUpatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileTypeContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileTypeContaining(String fileType) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileTypeContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileTypeContaining(String fileType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByPrimaryKey
	 *
	 */
	public TrPortfolioImages findTrPortfolioImagesByPrimaryKey(Integer boardImageId) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByPrimaryKey
	 *
	 */
	public TrPortfolioImages findTrPortfolioImagesByPrimaryKey(Integer boardImageId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileName
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileName(String fileName) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileName
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileName(String fileName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByBoardImageId
	 *
	 */
	public TrPortfolioImages findTrPortfolioImagesByBoardImageId(Integer boardImageId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByBoardImageId
	 *
	 */
	public TrPortfolioImages findTrPortfolioImagesByBoardImageId(Integer boardImageId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByCreationDate
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByCreationDate
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrl
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrl(String mainImageUrl) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrl
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrl(String mainImageUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileNameContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileNameContaining(String fileName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileNameContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileNameContaining(String fileName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrlContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrlContaining(String sourceFileUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrlContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrlContaining(String sourceFileUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileType
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileType(String fileType_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByFileType
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileType(String fileType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrl
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrl(String thumbnailUrl) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrl
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrl(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrlContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrlContaining(String mainImageUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrlContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrlContaining(String mainImageUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrlContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrlContaining(String thumbnailUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrlContaining
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrlContaining(String thumbnailUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	public Set<TrPortfolioImages> findAllTrPortfolioImagess() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	public Set<TrPortfolioImages> findAllTrPortfolioImagess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByCreatedBy
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByCreatedBy
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpdateDate
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpdateDate
	 *
	 */
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

}