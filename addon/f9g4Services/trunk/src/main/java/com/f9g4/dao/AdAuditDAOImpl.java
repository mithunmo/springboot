package com.f9g4.dao;

import com.f9g4.domain.AdAudit;

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
 * DAO to manage AdAudit entities.
 * 
 */
@Repository("AdAuditDAO")
@Transactional
public class AdAuditDAOImpl extends AbstractJpaDao<AdAudit> implements
		AdAuditDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdAudit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdAuditDAOImpl
	 *
	 */
	public AdAuditDAOImpl() {
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
	 * JPQL Query - findAdAuditByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdAuditByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByPrimaryKey
	 *
	 */
	@Transactional
	public AdAudit findAdAuditByPrimaryKey(Integer auditId) throws DataAccessException {

		return findAdAuditByPrimaryKey(auditId, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByPrimaryKey
	 *
	 */

	@Transactional
	public AdAudit findAdAuditByPrimaryKey(Integer auditId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdAuditByPrimaryKey", startResult, maxRows, auditId);
			return (com.f9g4.domain.AdAudit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdAuditByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByLangCodeContaining(String langCode) throws DataAccessException {

		return findAdAuditByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdAudits
	 *
	 */
	@Transactional
	public Set<AdAudit> findAllAdAudits() throws DataAccessException {

		return findAllAdAudits(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdAudits
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAllAdAudits(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdAudits", startResult, maxRows);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByLangCode
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByLangCode(String langCode) throws DataAccessException {

		return findAdAuditByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdAuditByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByOldValueContaining
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByOldValueContaining(String oldValue) throws DataAccessException {

		return findAdAuditByOldValueContaining(oldValue, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByOldValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByOldValueContaining(String oldValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByOldValueContaining", startResult, maxRows, oldValue);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByTableName
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByTableName(String tableName) throws DataAccessException {

		return findAdAuditByTableName(tableName, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByTableName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByTableName(String tableName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByTableName", startResult, maxRows, tableName);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByNewValueContaining
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByNewValueContaining(String newValue) throws DataAccessException {

		return findAdAuditByNewValueContaining(newValue, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByNewValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByNewValueContaining(String newValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByNewValueContaining", startResult, maxRows, newValue);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByColumnName
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByColumnName(String columnName) throws DataAccessException {

		return findAdAuditByColumnName(columnName, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByColumnName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByColumnName(String columnName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByColumnName", startResult, maxRows, columnName);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByOldValue
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByOldValue(String oldValue) throws DataAccessException {

		return findAdAuditByOldValue(oldValue, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByOldValue
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByOldValue(String oldValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByOldValue", startResult, maxRows, oldValue);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByAuditId
	 *
	 */
	@Transactional
	public AdAudit findAdAuditByAuditId(Integer auditId) throws DataAccessException {

		return findAdAuditByAuditId(auditId, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByAuditId
	 *
	 */

	@Transactional
	public AdAudit findAdAuditByAuditId(Integer auditId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdAuditByAuditId", startResult, maxRows, auditId);
			return (com.f9g4.domain.AdAudit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdAuditByNewValue
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByNewValue(String newValue) throws DataAccessException {

		return findAdAuditByNewValue(newValue, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByNewValue
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByNewValue(String newValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByNewValue", startResult, maxRows, newValue);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByCreationDate
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdAuditByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByColumnNameContaining
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByColumnNameContaining(String columnName) throws DataAccessException {

		return findAdAuditByColumnNameContaining(columnName, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByColumnNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByColumnNameContaining(String columnName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByColumnNameContaining", startResult, maxRows, columnName);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByTableNameContaining
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByTableNameContaining(String tableName) throws DataAccessException {

		return findAdAuditByTableNameContaining(tableName, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByTableNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByTableNameContaining(String tableName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByTableNameContaining", startResult, maxRows, tableName);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByTransactionPkid
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByTransactionPkid(Integer transactionPkid) throws DataAccessException {

		return findAdAuditByTransactionPkid(transactionPkid, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByTransactionPkid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByTransactionPkid(Integer transactionPkid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByTransactionPkid", startResult, maxRows, transactionPkid);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAuditByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdAudit> findAdAuditByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdAuditByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdAuditByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAudit> findAdAuditByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAuditByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdAudit>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdAudit entity) {
		return true;
	}
}
