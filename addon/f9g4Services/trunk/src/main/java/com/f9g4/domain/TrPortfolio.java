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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTrPortfolios", query = "select myTrPortfolio from TrPortfolio myTrPortfolio"),
		@NamedQuery(name = "findTrPortfolioByActiveStatus", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.activeStatus = ?1"),
		@NamedQuery(name = "findTrPortfolioByCreatedBy", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.createdBy = ?1"),
		@NamedQuery(name = "findTrPortfolioByCreationDate", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.creationDate = ?1"),
		@NamedQuery(name = "findTrPortfolioByDescription", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.description = ?1"),
		@NamedQuery(name = "findTrPortfolioByDescriptionContaining", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.description like ?1"),
		@NamedQuery(name = "findTrPortfolioByLangCode", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.langCode = ?1"),
		@NamedQuery(name = "findTrPortfolioByLangCodeContaining", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.langCode like ?1"),
		@NamedQuery(name = "findTrPortfolioByLastUpdateDate", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrPortfolioByLastUpdatedBy", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrPortfolioByName", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.name = ?1"),
		@NamedQuery(name = "findTrPortfolioByNameContaining", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.name like ?1"),
		@NamedQuery(name = "findTrPortfolioByPortfolioId", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.portfolioId = ?1"),
		@NamedQuery(name = "findTrPortfolioByUserId", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.adUsers.userId = ?1 and myTrPortfolio.activeStatus = 1 and myTrPortfolio.sellable = 1"),
		@NamedQuery(name = "findTrPortfolioByPrimaryKey", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.portfolioId = ?1"),
		@NamedQuery(name = "findTrPortfolioByUserIdAndSellable", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.adUsers.userId = ?1 and myTrPortfolio.activeStatus = 1 and myTrPortfolio.sellable = ?2"),
		@NamedQuery(name = "findUnsellableTrPortfolioByUserId", query = "select myTrPortfolio from TrPortfolio myTrPortfolio where myTrPortfolio.adUsers.userId = ?1 and myTrPortfolio.activeStatus = 1 and myTrPortfolio.sellable = 0")
		})
@Table( name = "tr_portfolio")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrPortfolio")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class TrPortfolio implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	
	@Id
	@Column(name = "PORTFOLIO_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)	
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer portfolioId;
	/**
	 */

	@Column(name = "NAME", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "DESCRIPTION", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
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

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "SEASON_YEAR_ID", referencedColumnName = "SEASON_YEAR_ID", nullable = false) })
	@XmlTransient
	StSeasonYear stSeasonYear;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CAT_LEVEL1_ID", referencedColumnName = "CATEGORY_ID", nullable = false) })
	@XmlTransient
	StCategoryMaster stCategoryMasterByCatLevel1Id;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CAT_LEVEL2_ID", referencedColumnName = "CATEGORY_ID", nullable = false) })
	@XmlTransient
	StCategoryMaster stCategoryMasterByCatLevel2Id;
	/**
	 */
	@OneToMany(mappedBy = "trPortfolio", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrBoard> trBoards;
	/**
	 */
	@OneToMany(mappedBy = "trPortfolio", cascade = { CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@OrderBy("creationDate DESC")
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrPortfolioImages> trPortfolioImages;
	/**
	 */
	@Column(name = "SELLABLE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sellable;
	/**
	 */

	public java.util.Set<com.f9g4.domain.TrPortfolioImages> getTrPortfolioImages() {
		return trPortfolioImages;
	}

	public void setTrPortfolioImages(
			java.util.Set<com.f9g4.domain.TrPortfolioImages> trPortfolioImages) {
		this.trPortfolioImages = trPortfolioImages;
	}
	/**
	 */
	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	/**
	 */
	public Integer getPortfolioId() {
		return this.portfolioId;
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
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
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
	public void setStCategoryMasterByCatLevel1Id(StCategoryMaster stCategoryMasterByCatLevel1Id) {
		this.stCategoryMasterByCatLevel1Id = stCategoryMasterByCatLevel1Id;
	}

	/**
	 */
	@JsonIgnore
	public StCategoryMaster getStCategoryMasterByCatLevel1Id() {
		return stCategoryMasterByCatLevel1Id;
	}

	/**
	 */
	public void setStCategoryMasterByCatLevel2Id(StCategoryMaster stCategoryMasterByCatLevel2Id) {
		this.stCategoryMasterByCatLevel2Id = stCategoryMasterByCatLevel2Id;
	}

	/**
	 */
	@JsonIgnore
	public StCategoryMaster getStCategoryMasterByCatLevel2Id() {
		return stCategoryMasterByCatLevel2Id;
	}

	/**
	 */
	public void setTrBoards(Set<TrBoard> trBoards) {
		this.trBoards = trBoards;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrBoard> getTrBoards() {
		if (trBoards == null) {
			trBoards = new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>();
		}
		return trBoards;
	}

	public Integer getSellable() {
		return sellable;
	}

	public void setSellable(Integer sellable) {
		this.sellable = sellable;
	}

	/**
	 */
	public TrPortfolio() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrPortfolio that) {
		setPortfolioId(that.getPortfolioId());
		setName(that.getName());
		setDescription(that.getDescription());
		setActiveStatus(that.getActiveStatus());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setStSeasonYear(that.getStSeasonYear());
		setAdUsers(that.getAdUsers());
		setStCategoryMasterByCatLevel1Id(that.getStCategoryMasterByCatLevel1Id());
		setStCategoryMasterByCatLevel2Id(that.getStCategoryMasterByCatLevel2Id());
		setTrBoards(new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>(that.getTrBoards()));
		setTrPortfolioImages(new java.util.LinkedHashSet<com.f9g4.domain.TrPortfolioImages>(that.getTrPortfolioImages()));
		setSellable(that.getSellable());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("portfolioId=[").append(portfolioId).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");
		buffer.append("sellable=[").append(sellable).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrPortfolio))
			return false;
		TrPortfolio equalCheck = (TrPortfolio) obj;
		if ((portfolioId == null && equalCheck.portfolioId != null) || (portfolioId != null && equalCheck.portfolioId == null))
			return false;
		if (portfolioId != null && !portfolioId.equals(equalCheck.portfolioId))
			return false;
		return true;
	}
}
