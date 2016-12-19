package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
		@NamedQuery(name = "findAllTrPortfolioImages", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages"),
		@NamedQuery(name = "findTrPortfolioImagesByPortfolioImageId", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.portfolioImageId = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByCreatedBy", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.createdBy = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByCreationDate", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.creationDate = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByFileName", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.fileName = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByFileNameContaining", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.fileName like ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByFileType", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.fileType = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByFileTypeContaining", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.fileType like ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByLastUpatedBy", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.lastUpatedBy = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByLastUpdateDate", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByMainImageUrl", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.mainImageUrl = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByMainImageUrlContaining", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.mainImageUrl like ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByPrimaryKey", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.portfolioImageId = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesBySourceFileUrl", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.sourceFileUrl = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesBySourceFileUrlContaining", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.sourceFileUrl like ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByThumbnailUrl", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.thumbnailUrl = ?1"),
		@NamedQuery(name = "findTrPortfolioImagesByThumbnailUrlContaining", query = "select myTrPortfolioImages from TrPortfolioImages myTrPortfolioImages where myTrPortfolioImages.thumbnailUrl like ?1") })
@Table( name = "tr_portfolio_images")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrPortfolioImages")
public class TrPortfolioImages implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue
	@Column(name = "PORTFOLIO_IMAGE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer portfolioImageId;
	/**
	 */

	@Column(name = "SOURCE_FILE_URL", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String sourceFileUrl;
	/**
	 */

	@Column(name = "FILE_TYPE", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String fileType;
	/**
	 */

	@Column(name = "FILE_NAME", length = 200, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String fileName;
	/**
	 */

	@Column(name = "THUMBNAIL_URL", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String thumbnailUrl;
	/**
	 */

	@Column(name = "MAIN_IMAGE_URL", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String mainImageUrl;
	/**
	 */
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
	/**
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = true)
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
	@Column(name = "LAST_UPDATE_DATE", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastUpdateDate;
	/**
	 */

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpatedBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PORTFOLIO_ID", referencedColumnName = "PORTFOLIO_ID", nullable = false) })
	@XmlTransient
	TrPortfolio trPortfolio;

	
	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Integer getPortfolioImageId() {
		return portfolioImageId;
	}

	public void setPortfolioImageId(Integer portfolioImageId) {
		this.portfolioImageId = portfolioImageId;
	}

	public TrPortfolio getTrPortfolio() {
		return trPortfolio;
	}

	public void setTrPortfolio(TrPortfolio trPortfolio) {
		this.trPortfolio = trPortfolio;
	}

	/**
	 */
	public void setSourceFileUrl(String sourceFileUrl) {
		this.sourceFileUrl = sourceFileUrl;
	}

	/**
	 */
	public String getSourceFileUrl() {
		return this.sourceFileUrl;
	}

	/**
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 */
	public String getFileType() {
		return this.fileType;
	}

	/**
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 */
	public String getThumbnailUrl() {
		return this.thumbnailUrl;
	}

	/**
	 */
	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	/**
	 */
	public String getMainImageUrl() {
		return this.mainImageUrl;
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
	public void setLastUpatedBy(Integer lastUpatedBy) {
		this.lastUpatedBy = lastUpatedBy;
	}

	/**
	 */
	public Integer getLastUpatedBy() {
		return this.lastUpatedBy;
	}

	/**
	 */
	public TrPortfolioImages() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrPortfolioImages that) {
		setPortfolioImageId(that.getPortfolioImageId());
		setSourceFileUrl(that.getSourceFileUrl());
		setFileType(that.getFileType());
		setFileName(that.getFileName());
		setThumbnailUrl(that.getThumbnailUrl());
		setMainImageUrl(that.getMainImageUrl());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpatedBy(that.getLastUpatedBy());
		setTrPortfolio(that.getTrPortfolio());
		setActiveStatus(that.getActiveStatus());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("portfolioImageId=[").append(portfolioImageId).append("] ");
		buffer.append("sourceFileUrl=[").append(sourceFileUrl).append("] ");
		buffer.append("fileType=[").append(fileType).append("] ");
		buffer.append("fileName=[").append(fileName).append("] ");
		buffer.append("thumbnailUrl=[").append(thumbnailUrl).append("] ");
		buffer.append("mainImageUrl=[").append(mainImageUrl).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpatedBy=[").append(lastUpatedBy).append("] ");
		buffer.append("lastUpatedBy=[").append(activeStatus).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((portfolioImageId == null) ? 0 : portfolioImageId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrPortfolioImages))
			return false;
		TrPortfolioImages equalCheck = (TrPortfolioImages) obj;
		if ((portfolioImageId == null && equalCheck.portfolioImageId != null) || (portfolioImageId != null && equalCheck.portfolioImageId == null))
			return false;
		if (portfolioImageId != null && !portfolioImageId.equals(equalCheck.portfolioImageId))
			return false;
		return true;
	}
}
