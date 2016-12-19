package com.f9g4.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAdAuditByAuditId", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.auditId = ?1"),
		@NamedQuery(name = "findAdAuditByColumnName", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.columnName = ?1"),
		@NamedQuery(name = "findAdAuditByColumnNameContaining", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.columnName like ?1"),
		@NamedQuery(name = "findAdAuditByCreatedBy", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.createdBy = ?1"),
		@NamedQuery(name = "findAdAuditByCreationDate", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.creationDate = ?1"),
		@NamedQuery(name = "findAdAuditByLangCode", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.langCode = ?1"),
		@NamedQuery(name = "findAdAuditByLangCodeContaining", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.langCode like ?1"),
		@NamedQuery(name = "findAdAuditByLastUpdateDate", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdAuditByLastUpdatedBy", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdAuditByNewValue", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.newValue = ?1"),
		@NamedQuery(name = "findAdAuditByNewValueContaining", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.newValue like ?1"),
		@NamedQuery(name = "findAdAuditByOldValue", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.oldValue = ?1"),
		@NamedQuery(name = "findAdAuditByOldValueContaining", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.oldValue like ?1"),
		@NamedQuery(name = "findAdAuditByPrimaryKey", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.auditId = ?1"),
		@NamedQuery(name = "findAdAuditByTableName", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.tableName = ?1"),
		@NamedQuery(name = "findAdAuditByTableNameContaining", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.tableName like ?1"),
		@NamedQuery(name = "findAdAuditByTransactionPkid", query = "select myAdAudit from AdAudit myAdAudit where myAdAudit.transactionPkid = ?1"),
		@NamedQuery(name = "findAllAdAudits", query = "select myAdAudit from AdAudit myAdAudit") })
@Table( name = "ad_audit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdAudit")
public class AdAudit implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Primary Key
	 * 
	 */

	@Column(name = "AUDIT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer auditId;
	/**
	 * Table Name that is being changed.
	 * 
	 */

	@Column(name = "TABLE_NAME", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String tableName;
	/**
	 * Column Name that is being changed.
	 * 
	 */

	@Column(name = "COLUMN_NAME", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String columnName;
	/**
	 * Present column value
	 * 
	 */

	@Column(name = "OLD_VALUE", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String oldValue;
	/**
	 * New Value of the column
	 * 
	 */

	@Column(name = "NEW_VALUE", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String newValue;
	/**
	 * Primary Key of the table row that is being operated on.
	 * 
	 */

	@Column(name = "TRANSACTION_PKID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer transactionPkid;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar creationDate;
	/**
	 */

	@Column(name = "CREATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer createdBy;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastUpdateDate;
	/**
	 */

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpdatedBy;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 * Primary Key
	 * 
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * Primary Key
	 * 
	 */
	public Integer getAuditId() {
		return this.auditId;
	}

	/**
	 * Table Name that is being changed.
	 * 
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Table Name that is being changed.
	 * 
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * Column Name that is being changed.
	 * 
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Column Name that is being changed.
	 * 
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * Present column value
	 * 
	 */
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	/**
	 * Present column value
	 * 
	 */
	public String getOldValue() {
		return this.oldValue;
	}

	/**
	 * New Value of the column
	 * 
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	/**
	 * New Value of the column
	 * 
	 */
	public String getNewValue() {
		return this.newValue;
	}

	/**
	 * Primary Key of the table row that is being operated on.
	 * 
	 */
	public void setTransactionPkid(Integer transactionPkid) {
		this.transactionPkid = transactionPkid;
	}

	/**
	 * Primary Key of the table row that is being operated on.
	 * 
	 */
	public Integer getTransactionPkid() {
		return this.transactionPkid;
	}

	/**
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 */
	public Calendar getCreationDate() {
		return this.creationDate;
	}

	/**
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 */
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	/**
	 */
	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 */
	public Calendar getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	/**
	 */
	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 */
	public Integer getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	/**
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 */
	public String getLangCode() {
		return this.langCode;
	}

	/**
	 */
	public AdAudit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdAudit that) {
		setAuditId(that.getAuditId());
		setTableName(that.getTableName());
		setColumnName(that.getColumnName());
		setOldValue(that.getOldValue());
		setNewValue(that.getNewValue());
		setTransactionPkid(that.getTransactionPkid());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("auditId=[").append(auditId).append("] ");
		buffer.append("tableName=[").append(tableName).append("] ");
		buffer.append("columnName=[").append(columnName).append("] ");
		buffer.append("oldValue=[").append(oldValue).append("] ");
		buffer.append("newValue=[").append(newValue).append("] ");
		buffer.append("transactionPkid=[").append(transactionPkid).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((auditId == null) ? 0 : auditId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdAudit))
			return false;
		AdAudit equalCheck = (AdAudit) obj;
		if ((auditId == null && equalCheck.auditId != null) || (auditId != null && equalCheck.auditId == null))
			return false;
		if (auditId != null && !auditId.equals(equalCheck.auditId))
			return false;
		return true;
	}
}
