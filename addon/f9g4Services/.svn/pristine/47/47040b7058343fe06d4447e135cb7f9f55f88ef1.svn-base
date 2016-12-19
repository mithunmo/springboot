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
		@NamedQuery(name = "findAdAcceptTermsByAcceptTermId", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.acceptTermId = ?1"),
		@NamedQuery(name = "findAdAcceptTermsByAcceptanceDate", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.acceptanceDate = ?1"),
		@NamedQuery(name = "findAdAcceptTermsByCreatedBy", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.createdBy = ?1"),
		@NamedQuery(name = "findAdAcceptTermsByCreationDate", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.creationDate = ?1"),
		@NamedQuery(name = "findAdAcceptTermsByLastUpdateDate", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdAcceptTermsByLastUpdatedBy", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdAcceptTermsByPrimaryKey", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms where myAdAcceptTerms.acceptTermId = ?1"),
		@NamedQuery(name = "findAllAdAcceptTermss", query = "select myAdAcceptTerms from AdAcceptTerms myAdAcceptTerms") })
@Table( name = "ad_accept_terms")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdAcceptTerms")
public class AdAcceptTerms implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "ACCEPT_TERM_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer acceptTermId;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACCEPTANCE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar acceptanceDate;
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
	@JoinColumns({ @JoinColumn(name = "TERM_COND_ID", referencedColumnName = "TERM_COND_ID", nullable = false) })
	@XmlTransient
	StTermsConditions stTermsConditions;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 */
	public void setAcceptTermId(Integer acceptTermId) {
		this.acceptTermId = acceptTermId;
	}

	/**
	 */
	public Integer getAcceptTermId() {
		return this.acceptTermId;
	}

	/**
	 */
	public void setAcceptanceDate(Calendar acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	/**
	 */
	public Calendar getAcceptanceDate() {
		return this.acceptanceDate;
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
	public void setStTermsConditions(StTermsConditions stTermsConditions) {
		this.stTermsConditions = stTermsConditions;
	}

	/**
	 */
	@JsonIgnore
	public StTermsConditions getStTermsConditions() {
		return stTermsConditions;
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
	public AdAcceptTerms() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdAcceptTerms that) {
		setAcceptTermId(that.getAcceptTermId());
		setAcceptanceDate(that.getAcceptanceDate());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setStTermsConditions(that.getStTermsConditions());
		setAdUsers(that.getAdUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("acceptTermId=[").append(acceptTermId).append("] ");
		buffer.append("acceptanceDate=[").append(acceptanceDate).append("] ");
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
		result = (int) (prime * result + ((acceptTermId == null) ? 0 : acceptTermId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdAcceptTerms))
			return false;
		AdAcceptTerms equalCheck = (AdAcceptTerms) obj;
		if ((acceptTermId == null && equalCheck.acceptTermId != null) || (acceptTermId != null && equalCheck.acceptTermId == null))
			return false;
		if (acceptTermId != null && !acceptTermId.equals(equalCheck.acceptTermId))
			return false;
		return true;
	}
}
