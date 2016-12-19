package com.f9g4.dao;

import com.f9g4.domain.AdCompanyNews;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
 * DAO to manage AdCompanyNews entities.
 * 
 */
@Repository("AdCompanyNewsDAO")
@Transactional
public class AdCompanyNewsDAOImpl extends AbstractJpaDao<AdCompanyNews>
		implements AdCompanyNewsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdCompanyNews.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdCompanyNewsDAOImpl
	 *
	 */
	public AdCompanyNewsDAOImpl() {
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
	 * JPQL Query - findAdCompanyNewsByStartDate
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findAdCompanyNewsByStartDate(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByStartDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByStartDate(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByStartDate", startResult, maxRows, startDate);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentAliasContaining
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentAliasContaining(String contentAlias) throws DataAccessException {

		return findAdCompanyNewsByContentAliasContaining(contentAlias, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentAliasContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentAliasContaining(String contentAlias, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByContentAliasContaining", startResult, maxRows, contentAlias);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByPrimaryKey
	 *
	 */
	@Transactional
	public AdCompanyNews findAdCompanyNewsByPrimaryKey(Integer compNewsId) throws DataAccessException {

		return findAdCompanyNewsByPrimaryKey(compNewsId, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByPrimaryKey
	 *
	 */

	@Transactional
	public AdCompanyNews findAdCompanyNewsByPrimaryKey(Integer compNewsId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdCompanyNewsByPrimaryKey", startResult, maxRows, compNewsId);
			return (com.f9g4.domain.AdCompanyNews) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAllAdCompanyNewss() throws DataAccessException {

		return findAllAdCompanyNewss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAllAdCompanyNewss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdCompanyNewss", startResult, maxRows);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	
	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */
	@Transactional
	public List<AdCompanyNews> findAllActiveAdCompanyNewss() throws DataAccessException {

		return findAllActiveAdCompanyNewss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdCompanyNewss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public List<AdCompanyNews> findAllActiveAdCompanyNewss(int startResult, int maxRows) throws DataAccessException {
		Calendar today=Calendar.getInstance();
		Query query = createNamedQuery("findAllActiveAdCompanyNewss", startResult, maxRows,today,today );
		return query.getResultList();
	}

	/**
	 * JPQL Query - findAdCompanyNewsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdCompanyNewsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByCompNewsId
	 *
	 */
	@Transactional
	public AdCompanyNews findAdCompanyNewsByCompNewsId(Integer compNewsId) throws DataAccessException {

		return findAdCompanyNewsByCompNewsId(compNewsId, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByCompNewsId
	 *
	 */

	@Transactional
	public AdCompanyNews findAdCompanyNewsByCompNewsId(Integer compNewsId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdCompanyNewsByCompNewsId", startResult, maxRows, compNewsId);
			return (com.f9g4.domain.AdCompanyNews) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdCompanyNewsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocation
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocation(String contentLocation) throws DataAccessException {

		return findAdCompanyNewsByContentLocation(contentLocation, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocation
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocation(String contentLocation, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByContentLocation", startResult, maxRows, contentLocation);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocationContaining
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocationContaining(String contentLocation) throws DataAccessException {

		return findAdCompanyNewsByContentLocationContaining(contentLocation, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentLocationContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentLocationContaining(String contentLocation, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByContentLocationContaining", startResult, maxRows, contentLocation);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentType
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentType(String contentType) throws DataAccessException {

		return findAdCompanyNewsByContentType(contentType, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentType(String contentType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByContentType", startResult, maxRows, contentType);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdCompanyNewsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdCompanyNewsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentTypeContaining
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentTypeContaining(String contentType) throws DataAccessException {

		return findAdCompanyNewsByContentTypeContaining(contentType, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentTypeContaining(String contentType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByContentTypeContaining", startResult, maxRows, contentType);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentAlias
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentAlias(String contentAlias) throws DataAccessException {

		return findAdCompanyNewsByContentAlias(contentAlias, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByContentAlias
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByContentAlias(String contentAlias, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByContentAlias", startResult, maxRows, contentAlias);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdCompanyNewsByEndDate
	 *
	 */
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByEndDate(java.util.Calendar endDate) throws DataAccessException {

		return findAdCompanyNewsByEndDate(endDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdCompanyNewsByEndDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdCompanyNews> findAdCompanyNewsByEndDate(java.util.Calendar endDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdCompanyNewsByEndDate", startResult, maxRows, endDate);
		return new LinkedHashSet<AdCompanyNews>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdCompanyNews entity) {
		return true;
	}
}
