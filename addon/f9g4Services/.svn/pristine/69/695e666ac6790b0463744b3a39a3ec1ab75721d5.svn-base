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
import javax.persistence.Lob;
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
		@NamedQuery(name = "findAdCompanyNewsDetailByCompNewsDtlId", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.compNewsDtlId = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByContentDetail", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.contentDetail = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByContentHeading", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.contentHeading = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByContentHeadingContaining", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.contentHeading like ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByContentImagePath", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.contentImagePath = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByContentImagePathContaining", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.contentImagePath like ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByCreatedBy", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.createdBy = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByCreationDate", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.creationDate = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByLastUpdateDate", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByLastUpdatedBy", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdCompanyNewsDetailByPrimaryKey", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail where myAdCompanyNewsDetail.compNewsDtlId = ?1"),
		@NamedQuery(name = "findAllAdCompanyNewsDetails", query = "select myAdCompanyNewsDetail from AdCompanyNewsDetail myAdCompanyNewsDetail") })
@Table( name = "ad_company_news_detail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdCompanyNewsDetail")
public class AdCompanyNewsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "COMP_NEWS_DTL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer compNewsDtlId;
	/**
	 */

	@Column(name = "CONTENT_IMAGE", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] contentImage;
	/**
	 */

	@Column(name = "CONTENT_IMAGE_PATH", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contentImagePath;
	/**
	 */

	@Column(name = "CONTENT_HEADING", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contentHeading;
	/**
	 */

	@Column(name = "CONTENT_DETAIL", nullable = false, columnDefinition = "LONGTEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String contentDetail;
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
	@JoinColumns({ @JoinColumn(name = "COMP_NEWS_ID", referencedColumnName = "COMP_NEWS_ID", nullable = false) })
	@XmlTransient
	AdCompanyNews adCompanyNews;

	/**
	 */
	public void setCompNewsDtlId(Integer compNewsDtlId) {
		this.compNewsDtlId = compNewsDtlId;
	}

	/**
	 */
	public Integer getCompNewsDtlId() {
		return this.compNewsDtlId;
	}

	/**
	 */
	public void setContentImage(byte[] contentImage) {
		this.contentImage = contentImage;
	}

	/**
	 */
	public byte[] getContentImage() {
		return this.contentImage;
	}

	/**
	 */
	public void setContentImagePath(String contentImagePath) {
		this.contentImagePath = contentImagePath;
	}

	/**
	 */
	public String getContentImagePath() {
		return this.contentImagePath;
	}

	/**
	 */
	public void setContentHeading(String contentHeading) {
		this.contentHeading = contentHeading;
	}

	/**
	 */
	public String getContentHeading() {
		return this.contentHeading;
	}

	/**
	 */
	public void setContentDetail(String contentDetail) {
		this.contentDetail = contentDetail;
	}

	/**
	 */
	public String getContentDetail() {
		return this.contentDetail;
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
	public void setAdCompanyNews(AdCompanyNews adCompanyNews) {
		this.adCompanyNews = adCompanyNews;
	}

	/**
	 */
	@JsonIgnore
	public AdCompanyNews getAdCompanyNews() {
		return adCompanyNews;
	}

	/**
	 */
	public AdCompanyNewsDetail() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdCompanyNewsDetail that) {
		setCompNewsDtlId(that.getCompNewsDtlId());
		setContentImage(that.getContentImage());
		setContentImagePath(that.getContentImagePath());
		setContentHeading(that.getContentHeading());
		setContentDetail(that.getContentDetail());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdCompanyNews(that.getAdCompanyNews());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("compNewsDtlId=[").append(compNewsDtlId).append("] ");
		buffer.append("contentImage=[").append(contentImage).append("] ");
		buffer.append("contentImagePath=[").append(contentImagePath).append("] ");
		buffer.append("contentHeading=[").append(contentHeading).append("] ");
		buffer.append("contentDetail=[").append(contentDetail).append("] ");
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
		result = (int) (prime * result + ((compNewsDtlId == null) ? 0 : compNewsDtlId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdCompanyNewsDetail))
			return false;
		AdCompanyNewsDetail equalCheck = (AdCompanyNewsDetail) obj;
		if ((compNewsDtlId == null && equalCheck.compNewsDtlId != null) || (compNewsDtlId != null && equalCheck.compNewsDtlId == null))
			return false;
		if (compNewsDtlId != null && !compNewsDtlId.equals(equalCheck.compNewsDtlId))
			return false;
		return true;
	}
}
