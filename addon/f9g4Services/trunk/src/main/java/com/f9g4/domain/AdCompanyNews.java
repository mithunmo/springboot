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
		@NamedQuery(name = "findAdCompanyNewsByCompNewsId", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.compNewsId = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByContentAlias", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.contentAlias = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByContentAliasContaining", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.contentAlias like ?1"),
		@NamedQuery(name = "findAdCompanyNewsByContentLocation", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.contentLocation = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByContentLocationContaining", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.contentLocation like ?1"),
		@NamedQuery(name = "findAdCompanyNewsByContentType", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.contentType = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByContentTypeContaining", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.contentType like ?1"),
		@NamedQuery(name = "findAdCompanyNewsByCreatedBy", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.createdBy = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByCreationDate", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.creationDate = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByEndDate", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.endDate = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByLastUpdateDate", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByLastUpdatedBy", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByPrimaryKey", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.compNewsId = ?1"),
		@NamedQuery(name = "findAdCompanyNewsByStartDate", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.startDate = ?1"),
		@NamedQuery(name = "findAllAdCompanyNewss", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews"),
		@NamedQuery(name = "findAllActiveAdCompanyNewss", query = "select myAdCompanyNews from AdCompanyNews myAdCompanyNews where myAdCompanyNews.startDate <=?1 and myAdCompanyNews.endDate>= ?2 ")
		
})
@Table( name = "ad_company_news")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdCompanyNews")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class AdCompanyNews implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "COMP_NEWS_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer compNewsId;
	/**
	 */

	@Column(name = "CONTENT_TYPE", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contentType;
	/**
	 */

	@Column(name = "CONTENT_LOCATION", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contentLocation;
	/**
	 */

	@Column(name = "CONTENT_ALIAS", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contentAlias;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endDate;
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
	@OneToMany(mappedBy = "adCompanyNews", cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdCompanyNewsDetail> adCompanyNewsDetails;

	/**
	 */
	public void setCompNewsId(Integer compNewsId) {
		this.compNewsId = compNewsId;
	}

	/**
	 */
	public Integer getCompNewsId() {
		return this.compNewsId;
	}

	/**
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 */
	public String getContentType() {
		return this.contentType;
	}

	/**
	 */
	public void setContentLocation(String contentLocation) {
		this.contentLocation = contentLocation;
	}

	/**
	 */
	public String getContentLocation() {
		return this.contentLocation;
	}

	/**
	 */
	public void setContentAlias(String contentAlias) {
		this.contentAlias = contentAlias;
	}

	/**
	 */
	public String getContentAlias() {
		return this.contentAlias;
	}

	/**
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 */
	public Calendar getStartDate() {
		return this.startDate;
	}

	/**
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 */
	public Calendar getEndDate() {
		return this.endDate;
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
	public void setAdCompanyNewsDetails(Set<AdCompanyNewsDetail> adCompanyNewsDetails) {
		this.adCompanyNewsDetails = adCompanyNewsDetails;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdCompanyNewsDetail> getAdCompanyNewsDetails() {
		if (adCompanyNewsDetails == null) {
			adCompanyNewsDetails = new java.util.LinkedHashSet<com.f9g4.domain.AdCompanyNewsDetail>();
		}
		return adCompanyNewsDetails;
	}

	/**
	 */
	public AdCompanyNews() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdCompanyNews that) {
		setCompNewsId(that.getCompNewsId());
		setContentType(that.getContentType());
		setContentLocation(that.getContentLocation());
		setContentAlias(that.getContentAlias());
		setStartDate(that.getStartDate());
		setEndDate(that.getEndDate());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdCompanyNewsDetails(new java.util.LinkedHashSet<com.f9g4.domain.AdCompanyNewsDetail>(that.getAdCompanyNewsDetails()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("compNewsId=[").append(compNewsId).append("] ");
		buffer.append("contentType=[").append(contentType).append("] ");
		buffer.append("contentLocation=[").append(contentLocation).append("] ");
		buffer.append("contentAlias=[").append(contentAlias).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");
		buffer.append("endDate=[").append(endDate).append("] ");
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
		result = (int) (prime * result + ((compNewsId == null) ? 0 : compNewsId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdCompanyNews))
			return false;
		AdCompanyNews equalCheck = (AdCompanyNews) obj;
		if ((compNewsId == null && equalCheck.compNewsId != null) || (compNewsId != null && equalCheck.compNewsId == null))
			return false;
		if (compNewsId != null && !compNewsId.equals(equalCheck.compNewsId))
			return false;
		return true;
	}
}
