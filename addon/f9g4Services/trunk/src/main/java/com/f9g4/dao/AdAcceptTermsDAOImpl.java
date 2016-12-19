package com.f9g4.dao;

import com.f9g4.domain.AdAcceptTerms;

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
 * DAO to manage AdAcceptTerms entities.
 * 
 */
@Repository("AdAcceptTermsDAO")
@Transactional
public class AdAcceptTermsDAOImpl extends AbstractJpaDao<AdAcceptTerms>
		implements AdAcceptTermsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdAcceptTerms.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdAcceptTermsDAOImpl
	 *
	 */
	public AdAcceptTermsDAOImpl() {
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
	 * JPQL Query - findAdAcceptTermsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdAcceptTermsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAcceptTermsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdAcceptTerms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdAcceptTermss
	 *
	 */
	@Transactional
	public Set<AdAcceptTerms> findAllAdAcceptTermss() throws DataAccessException {

		return findAllAdAcceptTermss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdAcceptTermss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAcceptTerms> findAllAdAcceptTermss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdAcceptTermss", startResult, maxRows);
		return new LinkedHashSet<AdAcceptTerms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAcceptTermsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdAcceptTermsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAcceptTermsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdAcceptTerms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdAcceptTermsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAcceptTermsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdAcceptTerms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAcceptTermsByPrimaryKey
	 *
	 */
	@Transactional
	public AdAcceptTerms findAdAcceptTermsByPrimaryKey(Integer acceptTermId) throws DataAccessException {

		return findAdAcceptTermsByPrimaryKey(acceptTermId, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByPrimaryKey
	 *
	 */

	@Transactional
	public AdAcceptTerms findAdAcceptTermsByPrimaryKey(Integer acceptTermId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdAcceptTermsByPrimaryKey", startResult, maxRows, acceptTermId);
			return (com.f9g4.domain.AdAcceptTerms) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptanceDate
	 *
	 */
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByAcceptanceDate(java.util.Calendar acceptanceDate) throws DataAccessException {

		return findAdAcceptTermsByAcceptanceDate(acceptanceDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptanceDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByAcceptanceDate(java.util.Calendar acceptanceDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAcceptTermsByAcceptanceDate", startResult, maxRows, acceptanceDate);
		return new LinkedHashSet<AdAcceptTerms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAcceptTermsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdAcceptTermsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAcceptTerms> findAdAcceptTermsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAcceptTermsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdAcceptTerms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptTermId
	 *
	 */
	@Transactional
	public AdAcceptTerms findAdAcceptTermsByAcceptTermId(Integer acceptTermId) throws DataAccessException {

		return findAdAcceptTermsByAcceptTermId(acceptTermId, -1, -1);
	}

	/**
	 * JPQL Query - findAdAcceptTermsByAcceptTermId
	 *
	 */

	@Transactional
	public AdAcceptTerms findAdAcceptTermsByAcceptTermId(Integer acceptTermId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdAcceptTermsByAcceptTermId", startResult, maxRows, acceptTermId);
			return (com.f9g4.domain.AdAcceptTerms) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdAcceptTerms entity) {
		return true;
	}
}
