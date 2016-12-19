package com.f9g4.dao;

import com.f9g4.domain.StTermsConditions;

import java.util.Arrays;
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
 * DAO to manage StTermsConditions entities.
 * 
 */
@Repository("StTermsConditionsDAO")
@Transactional
public class StTermsConditionsDAOImpl extends AbstractJpaDao<StTermsConditions>	implements StTermsConditionsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { StTermsConditions.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StTermsConditionsDAOImpl
	 *
	 */
	public StTermsConditionsDAOImpl() {
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
	 * JPQL Query - findAllStTermsConditionss
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findAllStTermsConditionss() throws DataAccessException {

		return findAllStTermsConditionss(-1, -1);
	}

	/**
	 * JPQL Query - findAllStTermsConditionss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findAllStTermsConditionss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStTermsConditionss", startResult, maxRows);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByLangCode
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLangCode(String langCode) throws DataAccessException {

		return findStTermsConditionsByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByPrimaryKey
	 *
	 */
	@Transactional
	public StTermsConditions findStTermsConditionsByPrimaryKey(Integer termCondId) throws DataAccessException {

		return findStTermsConditionsByPrimaryKey(termCondId, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByPrimaryKey
	 *
	 */

	@Transactional
	public StTermsConditions findStTermsConditionsByPrimaryKey(Integer termCondId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStTermsConditionsByPrimaryKey", startResult, maxRows, termCondId);
			return (com.f9g4.domain.StTermsConditions) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStTermsConditionsByExpirationDate
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException {

		return findStTermsConditionsByExpirationDate(expirationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByExpirationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByExpirationDate(java.util.Calendar expirationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByExpirationDate", startResult, maxRows, expirationDate);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findStTermsConditionsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLangCodeContaining(String langCode) throws DataAccessException {

		return findStTermsConditionsByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByTermCondId
	 *
	 */
	@Transactional
	public StTermsConditions findStTermsConditionsByTermCondId(Integer termCondId) throws DataAccessException {

		return findStTermsConditionsByTermCondId(termCondId, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByTermCondId
	 *
	 */

	@Transactional
	public StTermsConditions findStTermsConditionsByTermCondId(Integer termCondId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStTermsConditionsByTermCondId", startResult, maxRows, termCondId);
			return (com.f9g4.domain.StTermsConditions) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStTermsConditionsByCreatedBy
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findStTermsConditionsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findStTermsConditionsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByCreationDate
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findStTermsConditionsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByReviewedByLegal
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByReviewedByLegal(Integer reviewedByLegal) throws DataAccessException {

		return findStTermsConditionsByReviewedByLegal(reviewedByLegal, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByReviewedByLegal
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByReviewedByLegal(Integer reviewedByLegal, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByReviewedByLegal", startResult, maxRows, reviewedByLegal);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}

	/**
	 * JPQL Query - findStTermsConditionsByEffectiveDate
	 *
	 */
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByEffectiveDate(java.util.Calendar effectiveDate) throws DataAccessException {

		return findStTermsConditionsByEffectiveDate(effectiveDate, -1, -1);
	}

	/**
	 * JPQL Query - findStTermsConditionsByEffectiveDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findStTermsConditionsByEffectiveDate(java.util.Calendar effectiveDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStTermsConditionsByEffectiveDate", startResult, maxRows, effectiveDate);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}


	/**
	 * JPQL Query - findActiveStTermsConditionsByUserTypeAndTermType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findActiveStTermsConditionsByUserTypeAndTermType(String userType, String termType) throws DataAccessException {
		//Query query = createNamedQuery("findActiveStTermsConditionsByUserTypeAndTermType", -1, -1, userType, termType, Calendar.getInstance());
		Query query = createNamedQuery("findActiveStTermsConditionsByUserTypeAndTermType", -1, -1, userType, termType);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}
	
	
	/**
	 * JPQL Query - findAllStTermsConditionsByUserTypeAndTermType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findAllStTermsConditionsByUserTypeAndTermType(String userType, String termType) throws DataAccessException {
		Query query = createNamedQuery("findAllStTermsConditionsByUserTypeAndTermType", -1, -1, userType, termType);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StTermsConditions> findAllTermsConditionsByUserIdAndTermType(Integer userId, List<Integer> termTypeIds) throws DataAccessException {
		Query query = createNamedQuery("findAllTermsConditionsByUserIdAndTermType", -1, -1);
		query.setParameter(1, userId);
		query.setParameter(2, termTypeIds);
		return new LinkedHashSet<StTermsConditions>(query.getResultList());
	}
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(StTermsConditions entity) {
		return true;
	}
}
