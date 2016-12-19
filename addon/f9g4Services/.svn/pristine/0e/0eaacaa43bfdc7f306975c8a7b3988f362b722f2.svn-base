package com.f9g4.dao;

import com.f9g4.domain.TrBoardImages;

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
@Repository("TrBoardImagesDAO")
@Transactional
public class TrBoardImagesDAOImpl extends AbstractJpaDao<TrBoardImages>
		implements TrBoardImagesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrBoardImages.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrBoardImagesDAOImpl
	 *
	 */
	public TrBoardImagesDAOImpl() {
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
	 * JPQL Query - findTrBoardImagesBySourceFileUrl
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrl(String sourceFileUrl) throws DataAccessException {

		return findTrBoardImagesBySourceFileUrl(sourceFileUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrl(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesBySourceFileUrl", startResult, maxRows, sourceFileUrl);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByLastUpatedBy
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByLastUpatedBy(Integer lastUpatedBy) throws DataAccessException {

		return findTrBoardImagesByLastUpatedBy(lastUpatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByLastUpatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByLastUpatedBy(Integer lastUpatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByLastUpatedBy", startResult, maxRows, lastUpatedBy);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileTypeContaining
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileTypeContaining(String fileType) throws DataAccessException {

		return findTrBoardImagesByFileTypeContaining(fileType, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileTypeContaining(String fileType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByFileTypeContaining", startResult, maxRows, fileType);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByPrimaryKey
	 *
	 */
	@Transactional
	public TrBoardImages findTrBoardImagesByPrimaryKey(Integer boardImageId) throws DataAccessException {

		return findTrBoardImagesByPrimaryKey(boardImageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByPrimaryKey
	 *
	 */

	@Transactional
	public TrBoardImages findTrBoardImagesByPrimaryKey(Integer boardImageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrBoardImagesByPrimaryKey", startResult, maxRows, boardImageId);
			return (com.f9g4.domain.TrBoardImages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileName
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileName(String fileName) throws DataAccessException {

		return findTrBoardImagesByFileName(fileName, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileName(String fileName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByFileName", startResult, maxRows, fileName);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByBoardImageId
	 *
	 */
	@Transactional
	public TrBoardImages findTrBoardImagesByBoardImageId(Integer boardImageId) throws DataAccessException {

		return findTrBoardImagesByBoardImageId(boardImageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByBoardImageId
	 *
	 */

	@Transactional
	public TrBoardImages findTrBoardImagesByBoardImageId(Integer boardImageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrBoardImagesByBoardImageId", startResult, maxRows, boardImageId);
			return (com.f9g4.domain.TrBoardImages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrBoardImagesByCreationDate
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrBoardImagesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrl
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrl(String mainImageUrl) throws DataAccessException {

		return findTrBoardImagesByMainImageUrl(mainImageUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrl(String mainImageUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByMainImageUrl", startResult, maxRows, mainImageUrl);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileNameContaining
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileNameContaining(String fileName) throws DataAccessException {

		return findTrBoardImagesByFileNameContaining(fileName, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileNameContaining(String fileName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByFileNameContaining", startResult, maxRows, fileName);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrlContaining
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrlContaining(String sourceFileUrl) throws DataAccessException {

		return findTrBoardImagesBySourceFileUrlContaining(sourceFileUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesBySourceFileUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesBySourceFileUrlContaining(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesBySourceFileUrlContaining", startResult, maxRows, sourceFileUrl);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileType
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileType(String fileType) throws DataAccessException {

		return findTrBoardImagesByFileType(fileType, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByFileType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByFileType(String fileType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByFileType", startResult, maxRows, fileType);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrl
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrl(String thumbnailUrl) throws DataAccessException {

		return findTrBoardImagesByThumbnailUrl(thumbnailUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrl(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByThumbnailUrl", startResult, maxRows, thumbnailUrl);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrlContaining
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrlContaining(String mainImageUrl) throws DataAccessException {

		return findTrBoardImagesByMainImageUrlContaining(mainImageUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByMainImageUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByMainImageUrlContaining(String mainImageUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByMainImageUrlContaining", startResult, maxRows, mainImageUrl);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrlContaining
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrlContaining(String thumbnailUrl) throws DataAccessException {

		return findTrBoardImagesByThumbnailUrlContaining(thumbnailUrl, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByThumbnailUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByThumbnailUrlContaining(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByThumbnailUrlContaining", startResult, maxRows, thumbnailUrl);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrBoardImagess
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findAllTrBoardImagess() throws DataAccessException {

		return findAllTrBoardImagess(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrBoardImagess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findAllTrBoardImagess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrBoardImagess", startResult, maxRows);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrBoardImagesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrBoardImagesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrBoardImagesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrBoardImagesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardImages> findTrBoardImagesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardImagesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrBoardImages>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrBoardImages entity) {
		return true;
	}
}
