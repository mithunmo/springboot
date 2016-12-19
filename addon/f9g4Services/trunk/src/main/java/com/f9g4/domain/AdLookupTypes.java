package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAdLookupTypesByActiveStatus", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.activeStatus = ?1"),
		@NamedQuery(name = "findAdLookupTypesByCreatedBy", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.createdBy = ?1"),
		@NamedQuery(name = "findAdLookupTypesByCreationDate", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.creationDate = ?1"),
		@NamedQuery(name = "findAdLookupTypesByLangCode", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.langCode = ?1"),
		@NamedQuery(name = "findAdLookupTypesByLangCodeContaining", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.langCode like ?1"),
		@NamedQuery(name = "findAdLookupTypesByLastUpdateDate", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdLookupTypesByLastUpdatedBy", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdLookupTypesByLookupDescription", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lookupDescription = ?1"),
		@NamedQuery(name = "findAdLookupTypesByLookupDescriptionContaining", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lookupDescription like ?1"),
		@NamedQuery(name = "findAdLookupTypesByLookupType", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lookupType = ?1"),
		@NamedQuery(name = "findAdLookupTypesByLookupTypeContaining", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lookupType like ?1"),
		@NamedQuery(name = "findAdLookupTypesByLookupTypeId", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lookupTypeId = ?1"),
		@NamedQuery(name = "findAdLookupTypesByPrimaryKey", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes where myAdLookupTypes.lookupTypeId = ?1"),
		@NamedQuery(name = "findAllAdLookupTypess", query = "select myAdLookupTypes from AdLookupTypes myAdLookupTypes") })
@Table( name = "ad_lookup_types")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdLookupTypes")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class AdLookupTypes implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Primary Key
	 * 
	 */
	
	@Column(name = "LOOKUP_TYPE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	Integer lookupTypeId;
	/**
	 * Header Code to describe the lookup type
	 * 
	 */

	@Column(name = "LOOKUP_TYPE", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lookupType;
	/**
	 * Provide Description for lookup type
	 * 
	 */

	@Column(name = "LOOKUP_DESCRIPTION", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lookupDescription;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;
	/**
	 * 0=Inactive 1=Active
	 * 
	 */

	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
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
	@OneToMany(mappedBy = "adLookupTypes", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdLookupValues> adLookupValueses;

	/**
	 * Primary Key
	 * 
	 */
	public void setLookupTypeId(Integer lookupTypeId) {
		this.lookupTypeId = lookupTypeId;
	}

	/**
	 * Primary Key
	 * 
	 */
	public Integer getLookupTypeId() {
		return this.lookupTypeId;
	}

	/**
	 * Header Code to describe the lookup type
	 * 
	 */
	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	/**
	 * Header Code to describe the lookup type
	 * 
	 */
	public String getLookupType() {
		return this.lookupType;
	}

	/**
	 * Provide Description for lookup type
	 * 
	 */
	public void setLookupDescription(String lookupDescription) {
		this.lookupDescription = lookupDescription;
	}

	/**
	 * Provide Description for lookup type
	 * 
	 */
	public String getLookupDescription() {
		return this.lookupDescription;
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
	 * 0=Inactive 1=Active
	 * 
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * 0=Inactive 1=Active
	 * 
	 */
	public Integer getActiveStatus() {
		return this.activeStatus;
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
	public void setAdLookupValueses(Set<AdLookupValues> adLookupValueses) {
		this.adLookupValueses = adLookupValueses;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdLookupValues> getAdLookupValueses() {
		if (adLookupValueses == null) {
			adLookupValueses = new java.util.LinkedHashSet<com.f9g4.domain.AdLookupValues>();
		}
		return adLookupValueses;
	}

	/**
	 */
	public AdLookupTypes() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdLookupTypes that) {
		setLookupTypeId(that.getLookupTypeId());
		setLookupType(that.getLookupType());
		setLookupDescription(that.getLookupDescription());
		setLangCode(that.getLangCode());
		setActiveStatus(that.getActiveStatus());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdLookupValueses(new java.util.LinkedHashSet<com.f9g4.domain.AdLookupValues>(that.getAdLookupValueses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("lookupTypeId=[").append(lookupTypeId).append("] ");
		buffer.append("lookupType=[").append(lookupType).append("] ");
		buffer.append("lookupDescription=[").append(lookupDescription).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((lookupTypeId == null) ? 0 : lookupTypeId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdLookupTypes))
			return false;
		AdLookupTypes equalCheck = (AdLookupTypes) obj;
		if ((lookupTypeId == null && equalCheck.lookupTypeId != null) || (lookupTypeId != null && equalCheck.lookupTypeId == null))
			return false;
		if (lookupTypeId != null && !lookupTypeId.equals(equalCheck.lookupTypeId))
			return false;
		return true;
	}
}
