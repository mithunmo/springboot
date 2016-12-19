package com.f9g4.dao;

import com.f9g4.domain.TrPortfolioImages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage TrBoardImages entities.
 * 
 */
@Repository("TrPortfolioImagesDAO")
@Transactional
public class TrPortfolioImagesDAOImpl extends AbstractJpaDao<TrPortfolioImages>
		implements TrPortfolioImagesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrPortfolioImages.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrPortfolioImagesDAOImpl
	 *
	 */
	public TrPortfolioImagesDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrl
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrl(String sourceFileUrl) throws DataAccessException {

		return findTrPortfolioImagesBySourceFileUrl(sourceFileUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrl(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesBySourceFileUrl", startResult, maxRows, sourceFileUrl);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpatedBy
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpatedBy(Integer lastUpatedBy) throws DataAccessException {

		return findTrPortfolioImagesByLastUpatedBy(lastUpatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpatedBy(Integer lastUpatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByLastUpatedBy", startResult, maxRows, lastUpatedBy);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileTypeContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileTypeContaining(String fileType) throws DataAccessException {

		return findTrPortfolioImagesByFileTypeContaining(fileType, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileTypeContaining(String fileType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByFileTypeContaining", startResult, maxRows, fileType);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByPrimaryKey
	 *
	 */
	@Transactional
	public TrPortfolioImages findTrPortfolioImagesByPrimaryKey(Integer boardImageId) throws DataAccessException {

		return findTrPortfolioImagesByPrimaryKey(boardImageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByPrimaryKey
	 *
	 */

	@Transactional
	public TrPortfolioImages findTrPortfolioImagesByPrimaryKey(Integer boardImageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPortfolioImagesByPrimaryKey", startResult, maxRows, boardImageId);
			return (com.f9g4.domain.TrPortfolioImages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileName
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileName(String fileName) throws DataAccessException {

		return findTrPortfolioImagesByFileName(fileName, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileName(String fileName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByFileName", startResult, maxRows, fileName);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByBoardImageId
	 *
	 */
	@Transactional
	public TrPortfolioImages findTrPortfolioImagesByBoardImageId(Integer boardImageId) throws DataAccessException {

		return findTrPortfolioImagesByBoardImageId(boardImageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByBoardImageId
	 *
	 */

	@Transactional
	public TrPortfolioImages findTrPortfolioImagesByBoardImageId(Integer boardImageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrPortfolioImagesByBoardImageId", startResult, maxRows, boardImageId);
			return (com.f9g4.domain.TrPortfolioImages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByCreationDate
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrPortfolioImagesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrl
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrl(String mainImageUrl) throws DataAccessException {

		return findTrPortfolioImagesByMainImageUrl(mainImageUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrl(String mainImageUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByMainImageUrl", startResult, maxRows, mainImageUrl);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileNameContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileNameContaining(String fileName) throws DataAccessException {

		return findTrPortfolioImagesByFileNameContaining(fileName, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileNameContaining(String fileName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByFileNameContaining", startResult, maxRows, fileName);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrlContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrlContaining(String sourceFileUrl) throws DataAccessException {

		return findTrPortfolioImagesBySourceFileUrlContaining(sourceFileUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesBySourceFileUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesBySourceFileUrlContaining(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesBySourceFileUrlContaining", startResult, maxRows, sourceFileUrl);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileType
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileType(String fileType) throws DataAccessException {

		return findTrPortfolioImagesByFileType(fileType, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByFileType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByFileType(String fileType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByFileType", startResult, maxRows, fileType);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrl
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrl(String thumbnailUrl) throws DataAccessException {

		return findTrPortfolioImagesByThumbnailUrl(thumbnailUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrl(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByThumbnailUrl", startResult, maxRows, thumbnailUrl);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrlContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrlContaining(String mainImageUrl) throws DataAccessException {

		return findTrPortfolioImagesByMainImageUrlContaining(mainImageUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByMainImageUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByMainImageUrlContaining(String mainImageUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByMainImageUrlContaining", startResult, maxRows, mainImageUrl);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrlContaining
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrlContaining(String thumbnailUrl) throws DataAccessException {

		return findTrPortfolioImagesByThumbnailUrlContaining(thumbnailUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByThumbnailUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByThumbnailUrlContaining(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByThumbnailUrlContaining", startResult, maxRows, thumbnailUrl);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findAllTrPortfolioImagess() throws DataAccessException {

		return findAllTrPortfolioImagess(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findAllTrPortfolioImagess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrPortfolioImagess", startResult, maxRows);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrPortfolioImagesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrPortfolioImagesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrPortfolioImagesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPortfolioImages> findTrPortfolioImagesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrPortfolioImagesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrPortfolioImages>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrPortfolioImages entity) {
		return true;
	}
}
