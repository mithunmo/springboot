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
		@NamedQuery(name = "findAllTrSearchSeasons", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason"),
		@NamedQuery(name = "findTrSearchSeasonByCreatedBy", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason where myTrSearchSeason.createdBy = ?1"),
		@NamedQuery(name = "findTrSearchSeasonByCreationDate", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason where myTrSearchSeason.creationDate = ?1"),
		@NamedQuery(name = "findTrSearchSeasonByLastUpdateDate", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason where myTrSearchSeason.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrSearchSeasonByLastUpdatedBy", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason where myTrSearchSeason.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrSearchSeasonByPrimaryKey", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason where myTrSearchSeason.searchSeasonId = ?1"),
		@NamedQuery(name = "findTrSearchSeasonBySearchSeasonId", query = "select myTrSearchSeason from TrSearchSeason myTrSearchSeason where myTrSearchSeason.searchSeasonId = ?1") })
@Table( name = "tr_search_season")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrSearchSeason")
public class TrSearchSeason implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SEARCH_SEASON_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer searchSeasonId;
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
	@JoinColumns({ @JoinColumn(name = "SEASON_YEAR_ID", referencedColumnName = "SEASON_YEAR_ID", nullable = false) })
	@XmlTransient
	StSeasonYear stSeasonYear;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "SEARCH_ID", referencedColumnName = "SEARCH_ID", nullable = false) })
	@XmlTransient
	TrSearches trSearches;

	/**
	 */
	public void setSearchSeasonId(Integer searchSeasonId) {
		this.searchSeasonId = searchSeasonId;
	}

	/**
	 */
	public Integer getSearchSeasonId() {
		return this.searchSeasonId;
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
	public void setStSeasonYear(StSeasonYear stSeasonYear) {
		this.stSeasonYear = stSeasonYear;
	}

	/**
	 */
	@JsonIgnore
	public StSeasonYear getStSeasonYear() {
		return stSeasonYear;
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
	public TrSearchSeason() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrSearchSeason that) {
		setSearchSeasonId(that.getSearchSeasonId());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setStSeasonYear(that.getStSeasonYear());
		setTrSearches(that.getTrSearches());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("searchSeasonId=[").append(searchSeasonId).append("] ");
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
		result = (int) (prime * result + ((searchSeasonId == null) ? 0 : searchSeasonId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrSearchSeason))
			return false;
		TrSearchSeason equalCheck = (TrSearchSeason) obj;
		if ((searchSeasonId == null && equalCheck.searchSeasonId != null) || (searchSeasonId != null && equalCheck.searchSeasonId == null))
			return false;
		if (searchSeasonId != null && !searchSeasonId.equals(equalCheck.searchSeasonId))
			return false;
		return true;
	}
}
