package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
		@NamedQuery(name = "findAllTrSearchess", query = "select myTrSearches from TrSearches myTrSearches"),
		@NamedQuery(name = "findTrSearchesByBoardFileFormat", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.boardFileFormat = ?1"),
		@NamedQuery(name = "findTrSearchesByBoardFileFormatContaining", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.boardFileFormat like ?1"),
		@NamedQuery(name = "findTrSearchesByCreatedBy", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.createdBy = ?1"),
		@NamedQuery(name = "findTrSearchesByCreationDate", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.creationDate = ?1"),
		@NamedQuery(name = "findTrSearchesByDesignerCountryId", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.designerCountryId = ?1"),
		@NamedQuery(name = "findTrSearchesByDesignerName", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.designerName = ?1"),
		@NamedQuery(name = "findTrSearchesByDesignerNameContaining", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.designerName like ?1"),
		@NamedQuery(name = "findTrSearchesByFromPrice", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.fromPrice = ?1"),
		@NamedQuery(name = "findTrSearchesByKeyword", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.keyword = ?1"),
		@NamedQuery(name = "findTrSearchesByKeywordContaining", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.keyword like ?1"),
		@NamedQuery(name = "findTrSearchesByLastUpdateDate", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrSearchesByLastUpdatedBy", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrSearchesByOwnerId", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.ownerId = ?1"),
		@NamedQuery(name = "findTrSearchesByPrimaryKey", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.searchId = ?1"),
		@NamedQuery(name = "findTrSearchesByRating", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.rating = ?1"),
		@NamedQuery(name = "findTrSearchesBySchoolAwards", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.schoolAwards = ?1"),
		@NamedQuery(name = "findTrSearchesBySchoolAwardsContaining", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.schoolAwards like ?1"),
		@NamedQuery(name = "findTrSearchesBySearchId", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.searchId = ?1"),
		@NamedQuery(name = "findTrSearchesBySearchName", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.searchName = ?1"),
		@NamedQuery(name = "findTrSearchesBySearchNameContaining", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.searchName like ?1"),
		@NamedQuery(name = "findTrSearchesByToPrice", query = "select myTrSearches from TrSearches myTrSearches where myTrSearches.toPrice = ?1") })
@Table( name = "tr_searches")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrSearches")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class TrSearches implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SEARCH_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer searchId;
	/**
	 */

	@Column(name = "OWNER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ownerId;
	/**
	 */

	@Column(name = "SEARCH_NAME", length = 120, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String searchName;
	/**
	 */

	@Column(name = "DESIGNER_COUNTRY_ID")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer designerCountryId;
	/**
	 */

	@Column(name = "RATING", scale = 2, precision = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating;
	/**
	 */

	@Column(name = "SCHOOL_AWARDS", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String schoolAwards;
	/**
	 */

	@Column(name = "KEYWORD", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String keyword;
	/**
	 */

	@Column(name = "BOARD_FILE_FORMAT", length = 30)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String boardFileFormat;
	/**
	 */

	@Column(name = "FROM_PRICE", scale = 2, precision = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal fromPrice;
	/**
	 */

	@Column(name = "TO_PRICE", scale = 2, precision = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal toPrice;
	/**
	 */

	@Column(name = "DESIGNER_NAME", length = 120)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String designerName;
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
	@OneToMany(mappedBy = "trSearches", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchLanguages> trSearchLanguageses;
	/**
	 */
	@OneToMany(mappedBy = "trSearches", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchSeason> trSearchSeasons;
	/**
	 */
	@OneToMany(mappedBy = "trSearches", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchSkills> trSearchSkillses;
	/**
	 */
	@OneToMany(mappedBy = "trSearches", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchCategories> trSearchCategorieses;

	/**
	 */
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	/**
	 */
	public Integer getSearchId() {
		return this.searchId;
	}

	/**
	 */
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 */
	public Integer getOwnerId() {
		return this.ownerId;
	}

	/**
	 */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/**
	 */
	public String getSearchName() {
		return this.searchName;
	}

	/**
	 */
	public void setDesignerCountryId(Integer designerCountryId) {
		this.designerCountryId = designerCountryId;
	}

	/**
	 */
	public Integer getDesignerCountryId() {
		return this.designerCountryId;
	}

	/**
	 */
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	/**
	 */
	public BigDecimal getRating() {
		return this.rating;
	}

	/**
	 */
	public void setSchoolAwards(String schoolAwards) {
		this.schoolAwards = schoolAwards;
	}

	/**
	 */
	public String getSchoolAwards() {
		return this.schoolAwards;
	}

	/**
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 */
	public String getKeyword() {
		return this.keyword;
	}

	/**
	 */
	public void setBoardFileFormat(String boardFileFormat) {
		this.boardFileFormat = boardFileFormat;
	}

	/**
	 */
	public String getBoardFileFormat() {
		return this.boardFileFormat;
	}

	/**
	 */
	public void setFromPrice(BigDecimal fromPrice) {
		this.fromPrice = fromPrice;
	}

	/**
	 */
	public BigDecimal getFromPrice() {
		return this.fromPrice;
	}

	/**
	 */
	public void setToPrice(BigDecimal toPrice) {
		this.toPrice = toPrice;
	}

	/**
	 */
	public BigDecimal getToPrice() {
		return this.toPrice;
	}

	/**
	 */
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	/**
	 */
	public String getDesignerName() {
		return this.designerName;
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
	public void setTrSearchLanguageses(Set<TrSearchLanguages> trSearchLanguageses) {
		this.trSearchLanguageses = trSearchLanguageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSearchLanguages> getTrSearchLanguageses() {
		if (trSearchLanguageses == null) {
			trSearchLanguageses = new java.util.LinkedHashSet<com.f9g4.domain.TrSearchLanguages>();
		}
		return trSearchLanguageses;
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
	public void setTrSearchSkillses(Set<TrSearchSkills> trSearchSkillses) {
		this.trSearchSkillses = trSearchSkillses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSearchSkills> getTrSearchSkillses() {
		if (trSearchSkillses == null) {
			trSearchSkillses = new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSkills>();
		}
		return trSearchSkillses;
	}

	/**
	 */
	public void setTrSearchCategorieses(Set<TrSearchCategories> trSearchCategorieses) {
		this.trSearchCategorieses = trSearchCategorieses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSearchCategories> getTrSearchCategorieses() {
		if (trSearchCategorieses == null) {
			trSearchCategorieses = new java.util.LinkedHashSet<com.f9g4.domain.TrSearchCategories>();
		}
		return trSearchCategorieses;
	}

	/**
	 */
	public TrSearches() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrSearches that) {
		setSearchId(that.getSearchId());
		setOwnerId(that.getOwnerId());
		setSearchName(that.getSearchName());
		setDesignerCountryId(that.getDesignerCountryId());
		setRating(that.getRating());
		setSchoolAwards(that.getSchoolAwards());
		setKeyword(that.getKeyword());
		setBoardFileFormat(that.getBoardFileFormat());
		setFromPrice(that.getFromPrice());
		setToPrice(that.getToPrice());
		setDesignerName(that.getDesignerName());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrSearchLanguageses(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchLanguages>(that.getTrSearchLanguageses()));
		setTrSearchSeasons(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSeason>(that.getTrSearchSeasons()));
		setTrSearchSkillses(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSkills>(that.getTrSearchSkillses()));
		setTrSearchCategorieses(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchCategories>(that.getTrSearchCategorieses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("searchId=[").append(searchId).append("] ");
		buffer.append("ownerId=[").append(ownerId).append("] ");
		buffer.append("searchName=[").append(searchName).append("] ");
		buffer.append("designerCountryId=[").append(designerCountryId).append("] ");
		buffer.append("rating=[").append(rating).append("] ");
		buffer.append("schoolAwards=[").append(schoolAwards).append("] ");
		buffer.append("keyword=[").append(keyword).append("] ");
		buffer.append("boardFileFormat=[").append(boardFileFormat).append("] ");
		buffer.append("fromPrice=[").append(fromPrice).append("] ");
		buffer.append("toPrice=[").append(toPrice).append("] ");
		buffer.append("designerName=[").append(designerName).append("] ");
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
		result = (int) (prime * result + ((searchId == null) ? 0 : searchId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrSearches))
			return false;
		TrSearches equalCheck = (TrSearches) obj;
		if ((searchId == null && equalCheck.searchId != null) || (searchId != null && equalCheck.searchId == null))
			return false;
		if (searchId != null && !searchId.equals(equalCheck.searchId))
			return false;
		return true;
	}
}
