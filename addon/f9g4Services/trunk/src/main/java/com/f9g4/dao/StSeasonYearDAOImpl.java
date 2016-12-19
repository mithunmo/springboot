package com.f9g4.dao;

import com.f9g4.domain.StSeasonYear;

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
 * DAO to manage StSeasonYear entities.
 * 
 */
@Repository("StSeasonYearDAO")
@Transactional
public class StSeasonYearDAOImpl extends AbstractJpaDao<StSeasonYear> implements
		StSeasonYearDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { StSeasonYear.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StSeasonYearDAOImpl
	 *
	 */
	public StSeasonYearDAOImpl() {
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
	 * JPQL Query - findStSeasonYearBySeasonContaining
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearBySeasonContaining(String season) throws DataAccessException {

		return findStSeasonYearBySeasonContaining(season, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearBySeasonContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearBySeasonContaining(String season, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearBySeasonContaining", startResult, maxRows, season);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByCreationDate
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findStSeasonYearByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByPrimaryKey
	 *
	 */
	@Transactional
	public StSeasonYear findStSeasonYearByPrimaryKey(Integer seasonYearId) throws DataAccessException {

		return findStSeasonYearByPrimaryKey(seasonYearId, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByPrimaryKey
	 *
	 */

	@Transactional
	public StSeasonYear findStSeasonYearByPrimaryKey(Integer seasonYearId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStSeasonYearByPrimaryKey", startResult, maxRows, seasonYearId);
			return (com.f9g4.domain.StSeasonYear) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStSeasonYearByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findStSeasonYearByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearBySeasonYearId
	 *
	 */
	@Transactional
	public StSeasonYear findStSeasonYearBySeasonYearId(Integer seasonYearId) throws DataAccessException {

		return findStSeasonYearBySeasonYearId(seasonYearId, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearBySeasonYearId
	 *
	 */

	@Transactional
	public StSeasonYear findStSeasonYearBySeasonYearId(Integer seasonYearId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStSeasonYearBySeasonYearId", startResult, maxRows, seasonYearId);
			return (com.f9g4.domain.StSeasonYear) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStSeasonYearByYearContaining
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByYearContaining(String year) throws DataAccessException {

		return findStSeasonYearByYearContaining(year, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByYearContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByYearContaining(String year, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByYearContaining", startResult, maxRows, year);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByLangCode
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLangCode(String langCode) throws DataAccessException {

		return findStSeasonYearByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByYear
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByYear(String year) throws DataAccessException {

		return findStSeasonYearByYear(year, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByYear
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByYear(String year, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByYear", startResult, maxRows, year);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByActiveStatus
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findStSeasonYearByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllStSeasonYears
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findAllStSeasonYears() throws DataAccessException {

		return findAllStSeasonYears(-1, -1);
	}

	/**
	 * JPQL Query - findAllStSeasonYears
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findAllStSeasonYears(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStSeasonYears", startResult, maxRows);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByCreatedBy
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByCreatedBy(Integer createdBy) throws DataAccessException {

		return findStSeasonYearByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findStSeasonYearByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearBySeason
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearBySeason(String season) throws DataAccessException {

		return findStSeasonYearBySeason(season, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearBySeason
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearBySeason(String season, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearBySeason", startResult, maxRows, season);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * JPQL Query - findStSeasonYearByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLangCodeContaining(String langCode) throws DataAccessException {

		return findStSeasonYearByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStSeasonYearByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StSeasonYear> findStSeasonYearByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStSeasonYearByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<StSeasonYear>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(StSeasonYear entity) {
		return true;
	}
}
