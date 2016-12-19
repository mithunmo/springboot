package com.f9g4.dao;

import com.f9g4.domain.AdCompanyNewsDetail;

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
 * DAO to manage AdCompanyNewsDetail entities.
 * 
 */
@Repository("AdCompanyNewsDetailDAO")
@Transactional
public class AdCompanyNewsDetailDAOImpl extends AbstractJpaDao<AdCompanyNewsDetail>
		implements AdCompanyNewsDetailDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdCompanyNewsDetail.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdCompanyNewsDetailDAOImpl
	 *
	 */
	public AdCompanyNewsDetailDAOImpl() {
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
	 * JPQL Query - findAdCompanyNewsDetailByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdCompanyNewsDetailByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeadingContaining
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeadingContaining(String contentHeading) throws DataAccessException {

		return findAdCompanyNewsDetailByContentHeadingContaining(contentHeading, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeadingContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeadingContaining(String contentHeading, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByContentHeadingContaining", startResult, maxRows, contentHeading);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCompNewsDtlId
	 *
	 */
	@Transactional
	public AdCompanyNewsDetail findAdCompanyNewsDetailByCompNewsDtlId(Integer compNewsDtlId) throws DataAccessException {

		return findAdCompanyNewsDetailByCompNewsDtlId(compNewsDtlId, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCompNewsDtlId
	 *
	 */

	@Transactional
	public AdCompanyNewsDetail findAdCompanyNewsDetailByCompNewsDtlId(Integer compNewsDtlId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdCompanyNewsDetailByCompNewsDtlId", startResult, maxRows, compNewsDtlId);
			return (com.f9g4.domain.AdCompanyNewsDetail) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByPrimaryKey
	 *
	 */
	@Transactional
	public AdCompanyNewsDetail findAdCompanyNewsDetailByPrimaryKey(Integer compNewsDtlId) throws DataAccessException {

		return findAdCompanyNewsDetailByPrimaryKey(compNewsDtlId, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByPrimaryKey
	 *
	 */

	@Transactional
	public AdCompanyNewsDetail findAdCompanyNewsDetailByPrimaryKey(Integer compNewsDtlId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdCompanyNewsDetailByPrimaryKey", startResult, maxRows, compNewsDtlId);
			return (com.f9g4.domain.AdCompanyNewsDetail) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePathContaining
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePathContaining(String contentImagePath) throws DataAccessException {

		return findAdCompanyNewsDetailByContentImagePathContaining(contentImagePath, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePathContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePathContaining(String contentImagePath, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByContentImagePathContaining", startResult, maxRows, contentImagePath);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeading
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeading(String contentHeading) throws DataAccessException {

		return findAdCompanyNewsDetailByContentHeading(contentHeading, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentHeading
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentHeading(String contentHeading, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByContentHeading", startResult, maxRows, contentHeading);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdCompanyNewsDetailByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdCompanyNewsDetails
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAllAdCompanyNewsDetails() throws DataAccessException {

		return findAllAdCompanyNewsDetails(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdCompanyNewsDetails
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAllAdCompanyNewsDetails(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdCompanyNewsDetails", startResult, maxRows);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreationDate
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdCompanyNewsDetailByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentDetail
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentDetail(String contentDetail) throws DataAccessException {

		return findAdCompanyNewsDetailByContentDetail(contentDetail, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentDetail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentDetail(String contentDetail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByContentDetail", startResult, maxRows, contentDetail);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePath
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePath(String contentImagePath) throws DataAccessException {

		return findAdCompanyNewsDetailByContentImagePath(contentImagePath, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByContentImagePath
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByContentImagePath(String contentImagePath, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByContentImagePath", startResult, maxRows, contentImagePath);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdCompanyNewsDetailByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsDetailByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNewsDetail> findAdCompanyNewsDetailByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsDetailByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdCompanyNewsDetail>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdCompanyNewsDetail entity) {
		return true;
	}
}
