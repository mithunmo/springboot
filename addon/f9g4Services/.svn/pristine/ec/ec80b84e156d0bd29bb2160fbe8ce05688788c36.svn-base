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
		@NamedQuery(name = "findAllAdUserDocuments", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments"),
		@NamedQuery(name = "findAdUserDocumentsByUserId", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.docId = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByCreatedBy", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.createdBy = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByCreationDate", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.creationDate = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByFileName", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.fileName = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByFileNameContaining", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.fileName like ?1"),
		@NamedQuery(name = "findAdUserDocumentsByFileType", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.fileType = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByFileTypeContaining", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.fileType like ?1"),
		@NamedQuery(name = "findAdUserDocumentsByLastUpatedBy", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.lastUpatedBy = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByLastUpdateDate", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByMainImageUrl", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.mainImageUrl = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByMainImageUrlContaining", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.mainImageUrl like ?1"),
		@NamedQuery(name = "findAdUserDocumentsByPrimaryKey", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.docId = ?1"),
		@NamedQuery(name = "findAdUserDocumentsBySourceFileUrl", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.sourceFileUrl = ?1"),
		@NamedQuery(name = "findAdUserDocumentsBySourceFileUrlContaining", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.sourceFileUrl like ?1"),
		@NamedQuery(name = "findAdUserDocumentsByThumbnailUrl", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.thumbnailUrl = ?1"),
		@NamedQuery(name = "findAdUserDocumentsByThumbnailUrlContaining", query = "select myAdUserDocuments from AdUserDocuments myAdUserDocuments where myAdUserDocuments.thumbnailUrl like ?1") })
@Table( name = "ad_user_documents")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdUserDocuments")
public class AdUserDocuments implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue
	@Column(name = "DOC_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer docId;
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

	@Column(name = "THUMBNAIL_URL", length = 1000, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String thumbnailUrl;
	/**
	 */

	@Column(name = "MAIN_IMAGE_URL", length = 1000, nullable = true)
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
	Integer lastUpatedBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	
	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
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
	public AdUserDocuments() {
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public AdUsers getAdUsers() {
		return adUsers;
	}

	public void setAdUsers(AdUsers adUsers) {
		this.adUsers = adUsers;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdUserDocuments that) {
		setDocId(that.getDocId());
		setSourceFileUrl(that.getSourceFileUrl());
		setFileType(that.getFileType());
		setFileName(that.getFileName());
		setThumbnailUrl(that.getThumbnailUrl());
		setMainImageUrl(that.getMainImageUrl());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpatedBy(that.getLastUpatedBy());
		setActiveStatus(that.getActiveStatus());
		setAdUsers(that.getAdUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("docId=[").append(docId).append("] ");
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
		result = (int) (prime * result + ((docId == null) ? 0 : docId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdUserDocuments))
			return false;
		AdUserDocuments equalCheck = (AdUserDocuments) obj;
		if ((docId == null && equalCheck.docId != null) || (docId != null && equalCheck.docId == null))
			return false;
		if (docId != null && !docId.equals(equalCheck.docId))
			return false;
		return true;
	}
}
