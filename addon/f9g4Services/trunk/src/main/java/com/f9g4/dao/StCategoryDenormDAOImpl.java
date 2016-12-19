package com.f9g4.dao;

import com.f9g4.domain.StCategoryDenorm;

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
 * DAO to manage StCategoryDenorm entities.
 * 
 */
@Repository("StCategoryDenormDAO")
@Transactional
public class StCategoryDenormDAOImpl extends AbstractJpaDao<StCategoryDenorm>
		implements StCategoryDenormDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { StCategoryDenorm.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StCategoryDenormDAOImpl
	 *
	 */
	public StCategoryDenormDAOImpl() {
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
	 * JPQL Query - findStCategoryDenormByCatLevel2ValueContaining
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2ValueContaining(String catLevel2Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel2ValueContaining(catLevel2Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2ValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2ValueContaining(String catLevel2Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel2ValueContaining", startResult, maxRows, catLevel2Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByPrimaryKey
	 *
	 */
	@Transactional
	public StCategoryDenorm findStCategoryDenormByPrimaryKey(Integer categoryDenormId) throws DataAccessException {

		return findStCategoryDenormByPrimaryKey(categoryDenormId, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByPrimaryKey
	 *
	 */

	@Transactional
	public StCategoryDenorm findStCategoryDenormByPrimaryKey(Integer categoryDenormId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStCategoryDenormByPrimaryKey", startResult, maxRows, categoryDenormId);
			return (com.f9g4.domain.StCategoryDenorm) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStCategoryDenormByCategoryDenormId
	 *
	 */
	@Transactional
	public StCategoryDenorm findStCategoryDenormByCategoryDenormId(Integer categoryDenormId) throws DataAccessException {

		return findStCategoryDenormByCategoryDenormId(categoryDenormId, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCategoryDenormId
	 *
	 */

	@Transactional
	public StCategoryDenorm findStCategoryDenormByCategoryDenormId(Integer categoryDenormId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStCategoryDenormByCategoryDenormId", startResult, maxRows, categoryDenormId);
			return (com.f9g4.domain.StCategoryDenorm) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Value
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Value(String catLevel1Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel1Value(catLevel1Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Value
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Value(String catLevel1Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel1Value", startResult, maxRows, catLevel1Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Id
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Id(Integer catLevel1Id) throws DataAccessException {

		return findStCategoryDenormByCatLevel1Id(catLevel1Id, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1Id
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1Id(Integer catLevel1Id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel1Id", startResult, maxRows, catLevel1Id);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCreatedBy
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCreatedBy(Integer createdBy) throws DataAccessException {

		return findStCategoryDenormByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findStCategoryDenormByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCreationDate
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findStCategoryDenormByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3ValueContaining
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3ValueContaining(String catLevel3Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel3ValueContaining(catLevel3Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3ValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3ValueContaining(String catLevel3Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel3ValueContaining", startResult, maxRows, catLevel3Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllStCategoryDenorms
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findAllStCategoryDenorms() throws DataAccessException {

		return findAllStCategoryDenorms(-1, -1);
	}

	/**
	 * JPQL Query - findAllStCategoryDenorms
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findAllStCategoryDenorms(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStCategoryDenorms", startResult, maxRows);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5ValueContaining
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5ValueContaining(String catLevel5Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel5ValueContaining(catLevel5Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5ValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5ValueContaining(String catLevel5Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel5ValueContaining", startResult, maxRows, catLevel5Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Value
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Value(String catLevel4Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel4Value(catLevel4Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Value
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Value(String catLevel4Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel4Value", startResult, maxRows, catLevel4Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByLangCode
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLangCode(String langCode) throws DataAccessException {

		return findStCategoryDenormByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findStCategoryDenormByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1ValueContaining
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1ValueContaining(String catLevel1Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel1ValueContaining(catLevel1Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel1ValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel1ValueContaining(String catLevel1Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel1ValueContaining", startResult, maxRows, catLevel1Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4ValueContaining
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4ValueContaining(String catLevel4Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel4ValueContaining(catLevel4Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4ValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4ValueContaining(String catLevel4Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel4ValueContaining", startResult, maxRows, catLevel4Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Value
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Value(String catLevel2Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel2Value(catLevel2Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Value
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Value(String catLevel2Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel2Value", startResult, maxRows, catLevel2Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Value
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Value(String catLevel5Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel5Value(catLevel5Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Value
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Value(String catLevel5Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel5Value", startResult, maxRows, catLevel5Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Id
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Id(Integer catLevel2Id) throws DataAccessException {

		return findStCategoryDenormByCatLevel2Id(catLevel2Id, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel2Id
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel2Id(Integer catLevel2Id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel2Id", startResult, maxRows, catLevel2Id);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Id
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Id(Integer catLevel4Id) throws DataAccessException {

		return findStCategoryDenormByCatLevel4Id(catLevel4Id, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel4Id
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel4Id(Integer catLevel4Id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel4Id", startResult, maxRows, catLevel4Id);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLangCodeContaining(String langCode) throws DataAccessException {

		return findStCategoryDenormByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Id
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Id(Integer catLevel5Id) throws DataAccessException {

		return findStCategoryDenormByCatLevel5Id(catLevel5Id, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel5Id
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel5Id(Integer catLevel5Id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel5Id", startResult, maxRows, catLevel5Id);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Value
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Value(String catLevel3Value) throws DataAccessException {

		return findStCategoryDenormByCatLevel3Value(catLevel3Value, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Value
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Value(String catLevel3Value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel3Value", startResult, maxRows, catLevel3Value);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Id
	 *
	 */
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Id(Integer catLevel3Id) throws DataAccessException {

		return findStCategoryDenormByCatLevel3Id(catLevel3Id, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryDenormByCatLevel3Id
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryDenorm> findStCategoryDenormByCatLevel3Id(Integer catLevel3Id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryDenormByCatLevel3Id", startResult, maxRows, catLevel3Id);
		return new LinkedHashSet<StCategoryDenorm>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(StCategoryDenorm entity) {
		return true;
	}
}
