package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAdUserExpertisesByActiveStatus", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.activeStatus = ?1"),
		@NamedQuery(name = "findAdUserExpertisesByCreatedBy", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.createdBy = ?1"),
		@NamedQuery(name = "findAdUserExpertisesByCreationDate", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.creationDate = ?1"),
		@NamedQuery(name = "findAdUserExpertisesByLastUpdateDate", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdUserExpertisesByLastUpdatedBy", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdUserExpertisesByPrimaryKey", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.userExpertiseId = ?1"),
		@NamedQuery(name = "findAdUserExpertisesByUserExpertiseId", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises where myAdUserExpertises.userExpertiseId = ?1"),
		@NamedQuery(name = "findAllAdUserExpertisess", query = "select myAdUserExpertises from AdUserExpertises myAdUserExpertises") })
@Table( name = "ad_user_expertise")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdUserExpertises")
public class AdUserExpertises implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "USER_EXP_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userExpertiseId;
	/**
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "EXP_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValues;

	/**
	 * 
	 * 
	 */
	
	/**
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	





	public Integer getUserExpertiseId() {
		return userExpertiseId;
	}







	public void setUserExpertiseId(Integer userExpertiseId) {
		this.userExpertiseId = userExpertiseId;
	}







	/**
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
	public void setAdUsers(AdUsers adUsers) {
		this.adUsers = adUsers;
	}

	/**
	 */
	@JsonIgnore
	public AdUsers getAdUsers() {
		return adUsers;
	}

	/**
	 */
	public void setAdLookupValues(AdLookupValues adLookupValues) {
		this.adLookupValues = adLookupValues;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValues() {
		return adLookupValues;
	}

	/**
	 */
	public AdUserExpertises() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdUserExpertises that) {
		setUserExpertiseId(that.getUserExpertiseId());
		setActiveStatus(that.getActiveStatus());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdUsers(that.getAdUsers());
		setAdLookupValues(that.getAdLookupValues());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userSkillId=[").append(userExpertiseId).append("] ");
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activeStatus == null) ? 0 : activeStatus.hashCode());
		result = prime * result
				+ ((adLookupValues == null) ? 0 : adLookupValues.hashCode());
		result = prime * result + ((adUsers == null) ? 0 : adUsers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdUserExpertises other = (AdUserExpertises) obj;
		if (activeStatus == null) {
			if (other.activeStatus != null)
				return false;
		} else if (!activeStatus.equals(other.activeStatus))
			return false;
		if (adLookupValues == null) {
			if (other.adLookupValues != null)
				return false;
		} else if (!adLookupValues.equals(other.adLookupValues))
			return false;
		if (adUsers == null) {
			if (other.adUsers != null)
				return false;
		} else if (!adUsers.equals(other.adUsers))
			return false;
		return true;
	}

}
