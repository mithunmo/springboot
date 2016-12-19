package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class TrActivityScreenDesignerGrid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CLICK_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer clickId;

	@Column(name = "BOARD_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	Integer boardId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard board;
	
	@Column(name = "NAME", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	
	@Column(name = "THUMBNAIL_URL", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String thumbnailUrl;
	
	@Column(name = "PORTFOLIO_NAME", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String portfolioName;
	
	@Column(name = "BOARD_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal boardPrice;
	
	@Column(name = "TOTAL_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal totalPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_TIMESTAMP", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar eventTimestamp;
	
	@Column(name = "SEASON", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String season;
	/**
	 */

	/*@Column(name = "YEAR", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String year;*/
	

	@Column(name = "ORIGINAL_USER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	Integer userId;


	public BigDecimal getBoardPrice() {
		return boardPrice;
	}


	public void setBoardPrice(BigDecimal boardPrice) {
		this.boardPrice = boardPrice;
	}


	public TrBoard getBoard() {
		return board;
	}


	public void setBoard(TrBoard board) {
		this.board = board;
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


	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}


	public String getPortfolioName() {
		return portfolioName;
	}


	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Calendar getEventTimestamp() {
		return eventTimestamp;
	}


	public void setEventTimestamp(Calendar eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}


	public String getSeason() {
		return season;
	}


	public void setSeason(String season) {
		this.season = season;
	}


	/*public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}*/


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getClickId() {
		return clickId;
	}


	public void setClickId(Integer clickId) {
		this.clickId = clickId;
	}
}
