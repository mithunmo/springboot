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
		@NamedQuery(name = "findAllStSeasonYears", query = "select myStSeasonYear from StSeasonYear myStSeasonYear"),
		@NamedQuery(name = "findStSeasonYearByActiveStatus", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.activeStatus = ?1"),
		@NamedQuery(name = "findStSeasonYearByCreatedBy", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.createdBy = ?1"),
		@NamedQuery(name = "findStSeasonYearByCreationDate", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.creationDate = ?1"),
		@NamedQuery(name = "findStSeasonYearByLangCode", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.langCode = ?1"),
		@NamedQuery(name = "findStSeasonYearByLangCodeContaining", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.langCode like ?1"),
		@NamedQuery(name = "findStSeasonYearByLastUpdateDate", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.lastUpdateDate = ?1"),
		@NamedQuery(name = "findStSeasonYearByLastUpdatedBy", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findStSeasonYearByPrimaryKey", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.seasonYearId = ?1"),
		@NamedQuery(name = "findStSeasonYearBySeason", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.season = ?1"),
		@NamedQuery(name = "findStSeasonYearBySeasonContaining", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.season like ?1"),
		@NamedQuery(name = "findStSeasonYearBySeasonYearId", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.seasonYearId = ?1")
		//@NamedQuery(name = "findStSeasonYearByYear", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.year = ?1"),
		//@NamedQuery(name = "findStSeasonYearByYearContaining", query = "select myStSeasonYear from StSeasonYear myStSeasonYear where myStSeasonYear.year like ?1") 
		})
@Table( name = "st_season_year")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "StSeasonYear")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class StSeasonYear implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SEASON_YEAR_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seasonYearId;
	/**
	 */

	@Column(name = "SEASON", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String season;
	/**
	 */

	/*@Column(name = "YEAR", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String year;*/
	/**
	 */

	@Column(name = "ACTIVE_STATUS")
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

	@Column(name = "LANG_CODE", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	@OneToMany(mappedBy = "stSeasonYear", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrPortfolio> trPortfolios;
	/**
	 */
	@OneToMany(mappedBy = "stSeasonYear", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchSeason> trSearchSeasons;

	/**
	 */
	public void setSeasonYearId(Integer seasonYearId) {
		this.seasonYearId = seasonYearId;
	}

	/**
	 */
	public Integer getSeasonYearId() {
		return this.seasonYearId;
	}

	/**
	 */
	public void setSeason(String season) {
		this.season = season;
	}

	/**
	 */
	public String getSeason() {
		return this.season;
	}

	/**
	 */
	/*public void setYear(String year) {
		this.year = year;
	}*/

	/**
	 */
	/*public String getYear() {
		return this.year;
	}*/

	/**
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
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
	public void setTrPortfolios(Set<TrPortfolio> trPortfolios) {
		this.trPortfolios = trPortfolios;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrPortfolio> getTrPortfolios() {
		if (trPortfolios == null) {
			trPortfolios = new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolio>();
		}
		return trPortfolios;
	}

	/**
	 */
	public void setTrSearchSeasons(Set<TrSearchSeason> trSearchSeasons) {
		this.trSearchSeasons = trSearchSeasons;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSearchSeason> getTrSearchSeasons() {
		if (trSearchSeasons == null) {
			trSearchSeasons = new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSeason>();
		}
		return trSearchSeasons;
	}

	/**
	 */
	public StSeasonYear() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(StSeasonYear that) {
		setSeasonYearId(that.getSeasonYearId());
		setSeason(that.getSeason());
		/*setYear(that.getYear());*/
		setActiveStatus(that.getActiveStatus());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setTrPortfolios(new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolio>(that.getTrPortfolios()));
		setTrSearchSeasons(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSeason>(that.getTrSearchSeasons()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("seasonYearId=[").append(seasonYearId).append("] ");
		buffer.append("season=[").append(season).append("] ");
		/*buffer.append("year=[").append(year).append("] ");*/
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
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
		result = (int) (prime * result + ((seasonYearId == null) ? 0 : seasonYearId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof StSeasonYear))
			return false;
		StSeasonYear equalCheck = (StSeasonYear) obj;
		if ((seasonYearId == null && equalCheck.seasonYearId != null) || (seasonYearId != null && equalCheck.seasonYearId == null))
			return false;
		if (seasonYearId != null && !seasonYearId.equals(equalCheck.seasonYearId))
			return false;
		return true;
	}
}
