package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class TrBoardSearch implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	
	@Column(name = "BOARD_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	Integer boardId;
	/**
	 */

	@Column(name = "NAME")
	@Basic(fetch = FetchType.EAGER)
	
	String name;
	/**
	 */

	@Column(name = "DESCRIPTION", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	
	String description;
	

	/**
	 * Designers wants to get paid
	 * 
	 */
	@Column(name = "BOARD_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	BigDecimal boardPrice;
	
	/**
	 * Designer
	 * 
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ORIGINAL_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers designer;

	/**
	 * Post to Market Place. 1= Post 0 = Do not Post
	 * 
	 */
	@Column(name = "PUBLISH_TO_MP", nullable = false)
	@Basic(fetch = FetchType.EAGER)	
	Integer publishToMp;

	@Column(name = "TOTAL_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)	
	BigDecimal totalPrice;
	
	@Column(name = "TEMP_SALE_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	BigDecimal salePrice;

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	Integer lastUpdatedBy;

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	String langCode;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)	
	Integer activeStatus;

	@Column(name = "BOARD_IMAGE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	Integer boardImageId;

	@Column(name = "THUMBNAIL_URL", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	String thumbnailUrl;
	
	@Column(name = "MAIN_IMAGE_URL", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	String mainImageUrl;
	
	@Column(name = "FILE_NAME", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	String tileImageUrl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar date;
	
	
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getTileImageUrl() {
		return tileImageUrl;
	}

	public void setTileImageUrl(String tileImageUrl) {
		this.tileImageUrl = tileImageUrl;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public AdUsers getDesigner() {
		return designer;
	}

	public void setDesigner(AdUsers designer) {
		this.designer = designer;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getBoardPrice() {
		return boardPrice;
	}

	public void setBoardPrice(BigDecimal boardPrice) {
		this.boardPrice = boardPrice;
	}

	public Integer getPublishToMp() {
		return publishToMp;
	}

	public void setPublishToMp(Integer publishToMp) {
		this.publishToMp = publishToMp;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Integer getBoardImageId() {
		return boardImageId;
	}

	public void setBoardImageId(Integer boardImageId) {
		this.boardImageId = boardImageId;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boardId == null) ? 0 : boardId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrBoardSearch other = (TrBoardSearch) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
