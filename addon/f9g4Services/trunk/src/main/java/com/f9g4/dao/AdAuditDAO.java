package com.f9g4.dao;

import com.f9g4.domain.AdAudit;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdAudit entities.
 * 
 */
public interface AdAuditDAO extends JpaDao<AdAudit> {

	/**
	 * JPQL Query - findAdAuditByLastUpdateDate
	 *
	 */
	public Set<AdAudit> findAdAuditByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLastUpdateDate
	 *
	 */
	public Set<AdAudit> findAdAuditByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByPrimaryKey
	 *
	 */
	public AdAudit findAdAuditByPrimaryKey(Integer auditId) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByPrimaryKey
	 *
	 */
	public AdAudit findAdAuditByPrimaryKey(Integer auditId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLangCodeContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByLangCodeContaining(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLangCodeContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdAudits
	 *
	 */
	public Set<AdAudit> findAllAdAudits() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdAudits
	 *
	 */
	public Set<AdAudit> findAllAdAudits(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLangCode
	 *
	 */
	public Set<AdAudit> findAdAuditByLangCode(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLangCode
	 *
	 */
	public Set<AdAudit> findAdAuditByLangCode(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLastUpdatedBy
	 *
	 */
	public Set<AdAudit> findAdAuditByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByLastUpdatedBy
	 *
	 */
	public Set<AdAudit> findAdAuditByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByOldValueContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByOldValueContaining(String oldValue) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByOldValueContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByOldValueContaining(String oldValue, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByTableName
	 *
	 */
	public Set<AdAudit> findAdAuditByTableName(String tableName) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByTableName
	 *
	 */
	public Set<AdAudit> findAdAuditByTableName(String tableName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByNewValueContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByNewValueContaining(String newValue) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByNewValueContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByNewValueContaining(String newValue, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByColumnName
	 *
	 */
	public Set<AdAudit> findAdAuditByColumnName(String columnName) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByColumnName
	 *
	 */
	public Set<AdAudit> findAdAuditByColumnName(String columnName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByOldValue
	 *
	 */
	public Set<AdAudit> findAdAuditByOldValue(String oldValue_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByOldValue
	 *
	 */
	public Set<AdAudit> findAdAuditByOldValue(String oldValue_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByAuditId
	 *
	 */
	public AdAudit findAdAuditByAuditId(Integer auditId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByAuditId
	 *
	 */
	public AdAudit findAdAuditByAuditId(Integer auditId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByNewValue
	 *
	 */
	public Set<AdAudit> findAdAuditByNewValue(String newValue_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByNewValue
	 *
	 */
	public Set<AdAudit> findAdAuditByNewValue(String newValue_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByCreationDate
	 *
	 */
	public Set<AdAudit> findAdAuditByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByCreationDate
	 *
	 */
	public Set<AdAudit> findAdAuditByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByColumnNameContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByColumnNameContaining(String columnName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByColumnNameContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByColumnNameContaining(String columnName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByTableNameContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByTableNameContaining(String tableName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByTableNameContaining
	 *
	 */
	public Set<AdAudit> findAdAuditByTableNameContaining(String tableName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByTransactionPkid
	 *
	 */
	public Set<AdAudit> findAdAuditByTransactionPkid(Integer transactionPkid) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByTransactionPkid
	 *
	 */
	public Set<AdAudit> findAdAuditByTransactionPkid(Integer transactionPkid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByCreatedBy
	 *
	 */
	public Set<AdAudit> findAdAuditByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdAuditByCreatedBy
	 *
	 */
	public Set<AdAudit> findAdAuditByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

}