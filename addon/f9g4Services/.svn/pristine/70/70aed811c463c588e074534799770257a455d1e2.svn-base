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
		@NamedQuery(name = "findAllTrSearchCategoriess", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories"),
		@NamedQuery(name = "findTrSearchCategoriesByCreatedBy", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories where myTrSearchCategories.createdBy = ?1"),
		@NamedQuery(name = "findTrSearchCategoriesByCreationDate", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories where myTrSearchCategories.creationDate = ?1"),
		@NamedQuery(name = "findTrSearchCategoriesByLastUpdateDate", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories where myTrSearchCategories.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrSearchCategoriesByLastUpdatedBy", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories where myTrSearchCategories.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrSearchCategoriesByPrimaryKey", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories where myTrSearchCategories.searchCategoryId = ?1"),
		@NamedQuery(name = "findTrSearchCategoriesBySearchCategoryId", query = "select myTrSearchCategories from TrSearchCategories myTrSearchCategories where myTrSearchCategories.searchCategoryId = ?1") })
@Table( name = "tr_search_categories")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrSearchCategories")
public class TrSearchCategories implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SEARCH_CATEGORY_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer searchCategoryId;
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
	@JoinColumns({ @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false) })
	@XmlTransient
	StCategoryMaster stCategoryMaster;

	/**
	 */
	public void setSearchCategoryId(Integer searchCategoryId) {
		this.searchCategoryId = searchCategoryId;
	}

	/**
	 */
	public Integer getSearchCategoryId() {
		return this.searchCategoryId;
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
	public void setStCategoryMaster(StCategoryMaster stCategoryMaster) {
		this.stCategoryMaster = stCategoryMaster;
	}

	/**
	 */
	@JsonIgnore
	public StCategoryMaster getStCategoryMaster() {
		return stCategoryMaster;
	}

	/**
	 */
	public TrSearchCategories() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrSearchCategories that) {
		setSearchCategoryId(that.getSearchCategoryId());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrSearches(that.getTrSearches());
		setStCategoryMaster(that.getStCategoryMaster());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("searchCategoryId=[").append(searchCategoryId).append("] ");
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
		result = (int) (prime * result + ((searchCategoryId == null) ? 0 : searchCategoryId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrSearchCategories))
			return false;
		TrSearchCategories equalCheck = (TrSearchCategories) obj;
		if ((searchCategoryId == null && equalCheck.searchCategoryId != null) || (searchCategoryId != null && equalCheck.searchCategoryId == null))
			return false;
		if (searchCategoryId != null && !searchCategoryId.equals(equalCheck.searchCategoryId))
			return false;
		return true;
	}
}
