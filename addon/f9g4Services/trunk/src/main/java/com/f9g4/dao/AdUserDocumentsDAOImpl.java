package com.f9g4.dao;

import com.f9g4.domain.AdUserDocuments;

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
@Repository("AdUserDocumentsDAO")
@Transactional
public class AdUserDocumentsDAOImpl extends AbstractJpaDao<AdUserDocuments>
		implements AdUserDocumentsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserDocuments.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdUserDocumentsDAOImpl
	 *
	 */
	public AdUserDocumentsDAOImpl() {
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
	 * JPQL Query - findAdUserDocumentsBySourceFileUrl
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsBySourceFileUrl(String sourceFileUrl) throws DataAccessException {

		return findAdUserDocumentsBySourceFileUrl(sourceFileUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsBySourceFileUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsBySourceFileUrl(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsBySourceFileUrl", startResult, maxRows, sourceFileUrl);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByLastUpatedBy
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByLastUpatedBy(Integer lastUpatedBy) throws DataAccessException {

		return findAdUserDocumentsByLastUpatedBy(lastUpatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByLastUpatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByLastUpatedBy(Integer lastUpatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByLastUpatedBy", startResult, maxRows, lastUpatedBy);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileTypeContaining
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileTypeContaining(String fileType) throws DataAccessException {

		return findAdUserDocumentsByFileTypeContaining(fileType, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileTypeContaining(String fileType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByFileTypeContaining", startResult, maxRows, fileType);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserDocuments findAdUserDocumentsByPrimaryKey(Integer docId) throws DataAccessException {

		return findAdUserDocumentsByPrimaryKey(docId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserDocuments findAdUserDocumentsByPrimaryKey(Integer docId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserDocumentsByPrimaryKey", startResult, maxRows, docId);
			return (com.f9g4.domain.AdUserDocuments) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileName
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileName(String fileName) throws DataAccessException {

		return findAdUserDocumentsByFileName(fileName, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileName(String fileName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByFileName", startResult, maxRows, fileName);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByBoardImageId
	 *
	 */
	@Transactional
	public AdUserDocuments findAdUserDocumentsByDocId(Integer docId) throws DataAccessException {

		return findAdUserDocumentsByDocId(docId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByBoardImageId
	 *
	 */

	@Transactional
	public AdUserDocuments findAdUserDocumentsByDocId(Integer docId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserDocumentsByDocId", startResult, maxRows, docId);
			return (com.f9g4.domain.AdUserDocuments) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserDocumentsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserDocumentsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByMainImageUrl
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByMainImageUrl(String mainImageUrl) throws DataAccessException {

		return findAdUserDocumentsByMainImageUrl(mainImageUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByMainImageUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByMainImageUrl(String mainImageUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByMainImageUrl", startResult, maxRows, mainImageUrl);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileNameContaining
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileNameContaining(String fileName) throws DataAccessException {

		return findAdUserDocumentsByFileNameContaining(fileName, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileNameContaining(String fileName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByFileNameContaining", startResult, maxRows, fileName);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsBySourceFileUrlContaining
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsBySourceFileUrlContaining(String sourceFileUrl) throws DataAccessException {

		return findAdUserDocumentsBySourceFileUrlContaining(sourceFileUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsBySourceFileUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsBySourceFileUrlContaining(String sourceFileUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsBySourceFileUrlContaining", startResult, maxRows, sourceFileUrl);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileType
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileType(String fileType) throws DataAccessException {

		return findAdUserDocumentsByFileType(fileType, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByFileType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByFileType(String fileType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByFileType", startResult, maxRows, fileType);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByThumbnailUrl
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByThumbnailUrl(String thumbnailUrl) throws DataAccessException {

		return findAdUserDocumentsByThumbnailUrl(thumbnailUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByThumbnailUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByThumbnailUrl(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByThumbnailUrl", startResult, maxRows, thumbnailUrl);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByMainImageUrlContaining
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByMainImageUrlContaining(String mainImageUrl) throws DataAccessException {

		return findAdUserDocumentsByMainImageUrlContaining(mainImageUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByMainImageUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByMainImageUrlContaining(String mainImageUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByMainImageUrlContaining", startResult, maxRows, mainImageUrl);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByThumbnailUrlContaining
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByThumbnailUrlContaining(String thumbnailUrl) throws DataAccessException {

		return findAdUserDocumentsByThumbnailUrlContaining(thumbnailUrl, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByThumbnailUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByThumbnailUrlContaining(String thumbnailUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByThumbnailUrlContaining", startResult, maxRows, thumbnailUrl);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserDocuments
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAllAdUserDocuments() throws DataAccessException {

		return findAllAdUserDocuments(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserDocuments
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAllAdUserDocuments(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserDocuments", startResult, maxRows);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserDocumentsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserDocumentsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserDocumentsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserDocumentsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserDocuments> findAdUserDocumentsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserDocumentsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserDocuments>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdUserDocuments entity) {
		return true;
	}

}
