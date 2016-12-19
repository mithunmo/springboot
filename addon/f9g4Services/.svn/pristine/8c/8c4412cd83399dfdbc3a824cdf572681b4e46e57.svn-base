package com.f9g4.dao;

import com.f9g4.domain.StMemPricingOptions;

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
 * DAO to manage StMemPricingOptions entities.
 * 
 */
@Repository("StMemPricingOptionsDAO")
@Transactional
public class StMemPricingOptionsDAOImpl extends AbstractJpaDao<StMemPricingOptions>
		implements StMemPricingOptionsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { StMemPricingOptions.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StMemPricingOptionsDAOImpl
	 *
	 */
	public StMemPricingOptionsDAOImpl() {
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
	 * JPQL Query - findStMemPricingOptionsByPrimaryKey
	 *
	 */
	@Transactional
	public StMemPricingOptions findStMemPricingOptionsByPrimaryKey(Integer memPricingId) throws DataAccessException {

		return findStMemPricingOptionsByPrimaryKey(memPricingId, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByPrimaryKey
	 *
	 */

	@Transactional
	public StMemPricingOptions findStMemPricingOptionsByPrimaryKey(Integer memPricingId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStMemPricingOptionsByPrimaryKey", startResult, maxRows, memPricingId);
			return (com.f9g4.domain.StMemPricingOptions) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCodeContaining(String langCode) throws DataAccessException {

		return findStMemPricingOptionsByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByMemPricingId
	 *
	 */
	@Transactional
	public StMemPricingOptions findStMemPricingOptionsByMemPricingId(Integer memPricingId) throws DataAccessException {

		return findStMemPricingOptionsByMemPricingId(memPricingId, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByMemPricingId
	 *
	 */

	@Transactional
	public StMemPricingOptions findStMemPricingOptionsByMemPricingId(Integer memPricingId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStMemPricingOptionsByMemPricingId", startResult, maxRows, memPricingId);
			return (com.f9g4.domain.StMemPricingOptions) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllStMemPricingOptionss
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findAllStMemPricingOptionss() throws DataAccessException {

		return findAllStMemPricingOptionss(-1, -1);
	}

	/**
	 * JPQL Query - findAllStMemPricingOptionss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findAllStMemPricingOptionss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStMemPricingOptionss", startResult, maxRows);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByExpirationDate
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException {

		return findStMemPricingOptionsByExpirationDate(expirationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByExpirationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByExpirationDate(java.util.Calendar expirationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByExpirationDate", startResult, maxRows, expirationDate);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByDescription
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescription(String description) throws DataAccessException {

		return findStMemPricingOptionsByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByDescription", startResult, maxRows, description);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCode
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCode(String langCode) throws DataAccessException {

		return findStMemPricingOptionsByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescriptionContaining(String description) throws DataAccessException {

		return findStMemPricingOptionsByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByCreationDate
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findStMemPricingOptionsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByDurationInMonths
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByDurationInMonths(Integer durationInMonths) throws DataAccessException {

		return findStMemPricingOptionsByDurationInMonths(durationInMonths, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByDurationInMonths
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByDurationInMonths(Integer durationInMonths, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByDurationInMonths", startResult, maxRows, durationInMonths);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByCreatedBy
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findStMemPricingOptionsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByEffectiveDate
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByEffectiveDate(java.util.Calendar effectiveDate) throws DataAccessException {

		return findStMemPricingOptionsByEffectiveDate(effectiveDate, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByEffectiveDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByEffectiveDate(java.util.Calendar effectiveDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByEffectiveDate", startResult, maxRows, effectiveDate);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByPrice
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByPrice(java.math.BigDecimal price) throws DataAccessException {

		return findStMemPricingOptionsByPrice(price, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByPrice(java.math.BigDecimal price, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByPrice", startResult, maxRows, price);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByCommission
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByCommission(java.math.BigDecimal commission) throws DataAccessException {

		return findStMemPricingOptionsByCommission(commission, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByCommission
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByCommission(java.math.BigDecimal commission, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByCommission", startResult, maxRows, commission);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findStMemPricingOptionsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findStMemPricingOptionsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findStMemPricingOptionsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StMemPricingOptions> findStMemPricingOptionsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<StMemPricingOptions>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(StMemPricingOptions entity) {
		return true;
	}

	public StMemPricingOptions findStMemPricingOptionsByUserTypeAndMembershipType( String userType, String membershipType) throws DataAccessException {
		Query query = createNamedQuery("findStMemPricingOptionsByUserTypeAndMembershipType", -1, -1, userType, membershipType);
		return (StMemPricingOptions) query.getSingleResult();
	}
}
