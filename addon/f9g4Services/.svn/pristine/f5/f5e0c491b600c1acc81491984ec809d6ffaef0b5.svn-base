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
		@NamedQuery(name = "findAllTrBoardImagess", query = "select myTrBoardImages from TrBoardImages myTrBoardImages"),
		@NamedQuery(name = "findTrBoardImagesByBoardImageId", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.boardImageId = ?1"),
		@NamedQuery(name = "findTrBoardImagesByCreatedBy", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.createdBy = ?1"),
		@NamedQuery(name = "findTrBoardImagesByCreationDate", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.creationDate = ?1"),
		@NamedQuery(name = "findTrBoardImagesByFileName", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.fileName = ?1"),
		@NamedQuery(name = "findTrBoardImagesByFileNameContaining", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.fileName like ?1"),
		@NamedQuery(name = "findTrBoardImagesByFileType", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.fileType = ?1"),
		@NamedQuery(name = "findTrBoardImagesByFileTypeContaining", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.fileType like ?1"),
		@NamedQuery(name = "findTrBoardImagesByLastUpatedBy", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.lastUpatedBy = ?1"),
		@NamedQuery(name = "findTrBoardImagesByLastUpdateDate", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrBoardImagesByMainImageUrl", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.mainImageUrl = ?1"),
		@NamedQuery(name = "findTrBoardImagesByMainImageUrlContaining", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.mainImageUrl like ?1"),
		@NamedQuery(name = "findTrBoardImagesByPrimaryKey", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.boardImageId = ?1"),
		@NamedQuery(name = "findTrBoardImagesBySourceFileUrl", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.sourceFileUrl = ?1"),
		@NamedQuery(name = "findTrBoardImagesBySourceFileUrlContaining", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.sourceFileUrl like ?1"),
		@NamedQuery(name = "findTrBoardImagesByThumbnailUrl", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.thumbnailUrl = ?1"),
		@NamedQuery(name = "findTrBoardImagesByThumbnailUrlContaining", query = "select myTrBoardImages from TrBoardImages myTrBoardImages where myTrBoardImages.thumbnailUrl like ?1") })
@Table( name = "tr_board_images")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrBoardImages")
public class TrBoardImages implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue
	@Column(name = "BOARD_IMAGE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer boardImageId;
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

	@Column(name = "LAST_UPATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpatedBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard trBoard;

	/**
	 */
	public void setBoardImageId(Integer boardImageId) {
		this.boardImageId = boardImageId;
	}

	/**
	 */
	public Integer getBoardImageId() {
		return this.boardImageId;
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
	public void setTrBoard(TrBoard trBoard) {
		this.trBoard = trBoard;
	}

	/**
	 */
	@JsonIgnore
	public TrBoard getTrBoard() {
		return trBoard;
	}

	/**
	 */
	public TrBoardImages() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrBoardImages that) {
		setBoardImageId(that.getBoardImageId());
		setSourceFileUrl(that.getSourceFileUrl());
		setFileType(that.getFileType());
		setFileName(that.getFileName());
		setThumbnailUrl(that.getThumbnailUrl());
		setMainImageUrl(that.getMainImageUrl());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpatedBy(that.getLastUpatedBy());
		setTrBoard(that.getTrBoard());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("boardImageId=[").append(boardImageId).append("] ");
		buffer.append("sourceFileUrl=[").append(sourceFileUrl).append("] ");
		buffer.append("fileType=[").append(fileType).append("] ");
		buffer.append("fileName=[").append(fileName).append("] ");
		buffer.append("thumbnailUrl=[").append(thumbnailUrl).append("] ");
		buffer.append("mainImageUrl=[").append(mainImageUrl).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpatedBy=[").append(lastUpatedBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((boardImageId == null) ? 0 : boardImageId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrBoardImages))
			return false;
		TrBoardImages equalCheck = (TrBoardImages) obj;
		if ((boardImageId == null && equalCheck.boardImageId != null) || (boardImageId != null && equalCheck.boardImageId == null))
			return false;
		if (boardImageId != null && !boardImageId.equals(equalCheck.boardImageId))
			return false;
		return true;
	}
}
