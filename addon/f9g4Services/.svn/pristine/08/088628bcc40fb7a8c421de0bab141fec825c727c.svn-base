package com.f9g4.dao;

import com.f9g4.domain.StCategoryMaster;

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
 * DAO to manage StCategoryMaster entities.
 * 
 */
@Repository("StCategoryMasterDAO")
@Transactional
public class StCategoryMasterDAOImpl extends AbstractJpaDao<StCategoryMaster> implements StCategoryMasterDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { StCategoryMaster.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StCategoryMasterDAOImpl
	 *
	 */
	public StCategoryMasterDAOImpl() {
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
	 * JPQL Query - findStCategoryMasterByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findStCategoryMasterByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByCreationDate
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findStCategoryMasterByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByPrimaryKey
	 *
	 */
	@Transactional
	public StCategoryMaster findStCategoryMasterByPrimaryKey(Integer categoryId) throws DataAccessException {

		return findStCategoryMasterByPrimaryKey(categoryId, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByPrimaryKey
	 *
	 */

	@Transactional
	public StCategoryMaster findStCategoryMasterByPrimaryKey(Integer categoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStCategoryMasterByPrimaryKey", startResult, maxRows, categoryId);
			return (com.f9g4.domain.StCategoryMaster) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findStCategoryMasterByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByActiveStatus
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findStCategoryMasterByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByLangCode
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLangCode(String langCode) throws DataAccessException {

		return findStCategoryMasterByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByParentId
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByParentId(Integer parentId) throws DataAccessException {

		return findStCategoryMasterByParentId(parentId, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByParentId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByParentId(Integer parentId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByParentId", startResult, maxRows, parentId);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByCategoryId
	 *
	 */
	@Transactional
	public StCategoryMaster findStCategoryMasterByCategoryId(Integer categoryId) throws DataAccessException {

		return findStCategoryMasterByCategoryId(categoryId, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByCategoryId
	 *
	 */

	@Transactional
	public StCategoryMaster findStCategoryMasterByCategoryId(Integer categoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStCategoryMasterByCategoryId", startResult, maxRows, categoryId);
			return (com.f9g4.domain.StCategoryMaster) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStCategoryMasterByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLangCodeContaining(String langCode) throws DataAccessException {

		return findStCategoryMasterByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByName
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByName(String name) throws DataAccessException {

		return findStCategoryMasterByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByName", startResult, maxRows, name);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByNameContaining
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByNameContaining(String name) throws DataAccessException {

		return findStCategoryMasterByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByCreatedBy
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByCreatedBy(Integer createdBy) throws DataAccessException {

		return findStCategoryMasterByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findStCategoryMasterByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllStCategoryMasters
	 *
	 */
	@Transactional
	public Set<StCategoryMaster> findAllStCategoryMasters() throws DataAccessException {

		return findAllStCategoryMasters(-1, -1);
	}

	/**
	 * JPQL Query - findAllStCategoryMasters
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findAllStCategoryMasters(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStCategoryMasters", startResult, maxRows);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByLevel
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLevel(Integer level) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByLevel", -1, -1, level);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}

	/**
	 * JPQL Query - findStCategoryMasterByLevel
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMasterByLevelAndParentId(Integer level, Integer parentId) throws DataAccessException {
		Query query = createNamedQuery("findStCategoryMasterByLevelAndParentId", -1, -1, level, parentId);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMastersForLevel3(int level1Id, int level2Id, int startResult, int maxRows) throws DataAccessException
	{
		Query query = createNamedQuery("findStCategoryMastersForLevel3", startResult, maxRows);
		query.setParameter(1, level1Id);
		query.setParameter(2, level2Id);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StCategoryMaster> findStCategoryMastersForLevel4(int level1Id, int level2Id, List<String> nameOnLevel3, int startResult, int maxRows) throws DataAccessException
	{
		Query query = createNamedQuery("findStCategoryMastersForLevel4", startResult, maxRows);
		query.setParameter(1, level1Id);
		query.setParameter(2, level2Id);
		query.setParameter(3, nameOnLevel3);
		return new LinkedHashSet<StCategoryMaster>(query.getResultList());
	}
	
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(StCategoryMaster entity) {
		return true;
	}



}