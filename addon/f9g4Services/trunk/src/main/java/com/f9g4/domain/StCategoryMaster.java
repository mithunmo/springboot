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
		@NamedQuery(name = "findAllStCategoryMasters", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster"),
		@NamedQuery(name = "findStCategoryMasterByActiveStatus", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.activeStatus = ?1"),
		@NamedQuery(name = "findStCategoryMasterByCategoryId", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.categoryId = ?1"),
		@NamedQuery(name = "findStCategoryMasterByCreatedBy", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.createdBy = ?1"),
		@NamedQuery(name = "findStCategoryMasterByCreationDate", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.creationDate = ?1"),
		@NamedQuery(name = "findStCategoryMasterByLangCode", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.langCode = ?1"),
		@NamedQuery(name = "findStCategoryMasterByLangCodeContaining", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.langCode like ?1"),
		@NamedQuery(name = "findStCategoryMasterByLastUpdateDate", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.lastUpdateDate = ?1"),
		@NamedQuery(name = "findStCategoryMasterByLastUpdatedBy", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findStCategoryMasterByName", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.name = ?1"),
		@NamedQuery(name = "findStCategoryMasterByNameContaining", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.name like ?1"),
		@NamedQuery(name = "findStCategoryMasterByParentId", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.parentId = ?1"),
		@NamedQuery(name = "findStCategoryMasterByLevel", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.level = ?1 order by name"),
		@NamedQuery(name = "findStCategoryMasterByLevelAndParentId", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.level = ?1 and myStCategoryMaster.parentId = ?2"),
		@NamedQuery(name = "findStCategoryMasterByPrimaryKey", query = "select myStCategoryMaster from StCategoryMaster myStCategoryMaster where myStCategoryMaster.categoryId = ?1"),
		@NamedQuery(name = "findStCategoryMastersForLevel3", query = "select sm3 " +
				"from StCategoryMaster sm1, StCategoryMaster sm2, StCategoryMaster sm3 " +
				"where sm1.categoryId in ?1 " +
				"and sm2.categoryId in ?2 " +
				"and sm1.categoryId = sm2.parentId " +
				"and sm2.categoryId = sm3.parentId " +
				"and sm1.activeStatus = 1 " +
				"and sm2.activeStatus = 1 " +
				"and sm3.activeStatus = 1 " +
				"group by sm3.name"),
		@NamedQuery(name = "findStCategoryMastersForLevel4", query = "select sm4 " +
				"from StCategoryMaster sm1, StCategoryMaster sm2, StCategoryMaster sm3, StCategoryMaster sm4 " +
				"where sm1.categoryId in ?1 " +
				"and sm2.categoryId in ?2 " +
				"and sm3.name in ?3 " +
				"and sm1.categoryId = sm2.parentId " +
				"and sm2.categoryId = sm3.parentId " +
				"and sm3.categoryId = sm4.parentId " +
				"and sm1.activeStatus = 1 " +
				"and sm2.activeStatus = 1 " +
				"and sm3.activeStatus = 1 " +
				"and sm4.activeStatus = 1 " +
				"group by sm4.name")
})
@Table( name = "st_category_master")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "StCategoryMaster")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class StCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CATEGORY_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer categoryId;
	/**
	 */

	@Column(name = "PARENT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer parentId;
	/**
	 */

	@Column(name = "NAME", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
	
	/**
	 */

	@Column(name = "LEVEL", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer level;	
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

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	@OneToMany(mappedBy = "stCategoryMasterByCatLevel1Id", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrPortfolio> trPortfoliosForCatLevel2Id;
	/**
	 */
	@OneToMany(mappedBy = "stCategoryMasterByCatLevel3Id", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrBoard> trBoardsForCatLevel5Id;
	/**
	 */
	@OneToMany(mappedBy = "stCategoryMasterByCatLevel1Id", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrPortfolio> trPortfoliosForCatLevel1Id;
	/**
	 */
	@OneToMany(mappedBy = "stCategoryMasterByCatLevel3Id", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrBoard> trBoardsForCatLevel4Id;
	/**
	 */
	@OneToMany(mappedBy = "stCategoryMaster", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchCategories> trSearchCategorieses;
	/**
	 */
	@OneToMany(mappedBy = "stCategoryMasterByCatLevel3Id", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrBoard> trBoardsForCatLevel3Id;

	/**
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 */
	public Integer getCategoryId() {
		return this.categoryId;
	}

	/**
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 */
	public Integer getParentId() {
		return this.parentId;
	}

	/**
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
	public void setTrPortfoliosForCatLevel2Id(Set<TrPortfolio> trPortfoliosForCatLevel2Id) {
		this.trPortfoliosForCatLevel2Id = trPortfoliosForCatLevel2Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrPortfolio> getTrPortfoliosForCatLevel2Id() {
		if (trPortfoliosForCatLevel2Id == null) {
			trPortfoliosForCatLevel2Id = new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolio>();
		}
		return trPortfoliosForCatLevel2Id;
	}

	/**
	 */
	public void setTrBoardsForCatLevel5Id(Set<TrBoard> trBoardsForCatLevel5Id) {
		this.trBoardsForCatLevel5Id = trBoardsForCatLevel5Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrBoard> getTrBoardsForCatLevel5Id() {
		if (trBoardsForCatLevel5Id == null) {
			trBoardsForCatLevel5Id = new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>();
		}
		return trBoardsForCatLevel5Id;
	}

	/**
	 */
	public void setTrPortfoliosForCatLevel1Id(Set<TrPortfolio> trPortfoliosForCatLevel1Id) {
		this.trPortfoliosForCatLevel1Id = trPortfoliosForCatLevel1Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrPortfolio> getTrPortfoliosForCatLevel1Id() {
		if (trPortfoliosForCatLevel1Id == null) {
			trPortfoliosForCatLevel1Id = new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolio>();
		}
		return trPortfoliosForCatLevel1Id;
	}

	/**
	 */
	public void setTrBoardsForCatLevel4Id(Set<TrBoard> trBoardsForCatLevel4Id) {
		this.trBoardsForCatLevel4Id = trBoardsForCatLevel4Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrBoard> getTrBoardsForCatLevel4Id() {
		if (trBoardsForCatLevel4Id == null) {
			trBoardsForCatLevel4Id = new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>();
		}
		return trBoardsForCatLevel4Id;
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
	public void setTrBoardsForCatLevel3Id(Set<TrBoard> trBoardsForCatLevel3Id) {
		this.trBoardsForCatLevel3Id = trBoardsForCatLevel3Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrBoard> getTrBoardsForCatLevel3Id() {
		if (trBoardsForCatLevel3Id == null) {
			trBoardsForCatLevel3Id = new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>();
		}
		return trBoardsForCatLevel3Id;
	}

	/**
	 */
	public StCategoryMaster() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(StCategoryMaster that) {
		setCategoryId(that.getCategoryId());
		setParentId(that.getParentId());
		setName(that.getName());
		setActiveStatus(that.getActiveStatus());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setTrPortfoliosForCatLevel2Id(new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolio>(that.getTrPortfoliosForCatLevel2Id()));
		setTrBoardsForCatLevel5Id(new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>(that.getTrBoardsForCatLevel5Id()));
		setTrPortfoliosForCatLevel1Id(new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolio>(that.getTrPortfoliosForCatLevel1Id()));
		setTrBoardsForCatLevel4Id(new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>(that.getTrBoardsForCatLevel4Id()));
		setTrSearchCategorieses(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchCategories>(that.getTrSearchCategorieses()));
		setTrBoardsForCatLevel3Id(new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>(that.getTrBoardsForCatLevel3Id()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("categoryId=[").append(categoryId).append("] ");
		buffer.append("parentId=[").append(parentId).append("] ");
		buffer.append("name=[").append(name).append("] ");
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
		result = (int) (prime * result + ((categoryId == null) ? 0 : categoryId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof StCategoryMaster))
			return false;
		StCategoryMaster equalCheck = (StCategoryMaster) obj;
		if ((categoryId == null && equalCheck.categoryId != null) || (categoryId != null && equalCheck.categoryId == null))
			return false;
		if (categoryId != null && !categoryId.equals(equalCheck.categoryId))
			return false;
		return true;
	}
}
