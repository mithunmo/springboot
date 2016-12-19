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
		@NamedQuery(name = "findAllTrSearchSkillss", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills"),
		@NamedQuery(name = "findTrSearchSkillsByCreatedBy", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills where myTrSearchSkills.createdBy = ?1"),
		@NamedQuery(name = "findTrSearchSkillsByCreationDate", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills where myTrSearchSkills.creationDate = ?1"),
		@NamedQuery(name = "findTrSearchSkillsByLastUpdateDate", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills where myTrSearchSkills.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrSearchSkillsByLastUpdatedBy", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills where myTrSearchSkills.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrSearchSkillsByPrimaryKey", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills where myTrSearchSkills.searchSkillId = ?1"),
		@NamedQuery(name = "findTrSearchSkillsBySearchSkillId", query = "select myTrSearchSkills from TrSearchSkills myTrSearchSkills where myTrSearchSkills.searchSkillId = ?1") })
@Table( name = "tr_search_skills")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrSearchSkills")
public class TrSearchSkills implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SEARCH_SKILL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer searchSkillId;
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
	@JoinColumns({ @JoinColumn(name = "SEARCH_ID", referencedColumnName = "SEARCH_ID", nullable = false) })
	@XmlTransient
	TrSearches trSearches;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "SKILL_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValues;

	/**
	 */
	public void setSearchSkillId(Integer searchSkillId) {
		this.searchSkillId = searchSkillId;
	}

	/**
	 */
	public Integer getSearchSkillId() {
		return this.searchSkillId;
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
	public void setTrSearches(TrSearches trSearches) {
		this.trSearches = trSearches;
	}

	/**
	 */
	@JsonIgnore
	public TrSearches getTrSearches() {
		return trSearches;
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
	public TrSearchSkills() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrSearchSkills that) {
		setSearchSkillId(that.getSearchSkillId());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrSearches(that.getTrSearches());
		setAdLookupValues(that.getAdLookupValues());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("searchSkillId=[").append(searchSkillId).append("] ");
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
		result = (int) (prime * result + ((searchSkillId == null) ? 0 : searchSkillId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrSearchSkills))
			return false;
		TrSearchSkills equalCheck = (TrSearchSkills) obj;
		if ((searchSkillId == null && equalCheck.searchSkillId != null) || (searchSkillId != null && equalCheck.searchSkillId == null))
			return false;
		if (searchSkillId != null && !searchSkillId.equals(equalCheck.searchSkillId))
			return false;
		return true;
	}
}
