package com.f9g4.common.bo;

import java.math.BigDecimal;
import java.util.Calendar;

import com.f9g4.common.util.LookupTypeValueEnum;

public class Account 
{
	private Integer boardId;
	private String boardName;
	private BigDecimal boardPrice;
	private BigDecimal totalPrice;
	private String boardImage;
	private String tileImageUrl;
	private Integer portfilioId;
	private String portfolioName;
	private Integer purchaserId;
	private String purchaserName;
	private Calendar dateSold;
	private int paymentStatusId;
	private String paymentStatus;
	
	
	public Account(Integer boardId, String boardName, BigDecimal boardPrice, BigDecimal totalPrice,
			String boardImage, String tileImageUrl, Integer portfilioId, String portfolioName,
			Integer purchaserId, String purchaserName, Calendar dateSold,
			int paymentStatusId,String paymentStatus) 
	{
		super();
		this.boardId = boardId;
		this.boardName = boardName;
		this.boardPrice = boardPrice;
		this.totalPrice = totalPrice;
		this.boardImage = boardImage;
		this.portfilioId = portfilioId;
		this.portfolioName = portfolioName;
		this.purchaserId = purchaserId;
		this.purchaserName = purchaserName;
		this.dateSold = dateSold;
		this.paymentStatusId = paymentStatusId;
		this.paymentStatus = paymentStatus;
		this.tileImageUrl = tileImageUrl;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTileImageUrl() {
		return tileImageUrl;
	}

	public void setTileImageUrl(String tileImageUrl) {
		this.tileImageUrl = tileImageUrl;
	}

	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public BigDecimal getBoardPrice() {
		return boardPrice;
	}
	public void setBoardPrice(BigDecimal boardPrice) {
		this.boardPrice = boardPrice;
	}
	public String getBoardImage() {
		return boardImage;
	}
	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	public Integer getPortfilioId() {
		return portfilioId;
	}
	public void setPortfilioId(Integer portfilioId) {
		this.portfilioId = portfilioId;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public Integer getPurchaserId() {
		return purchaserId;
	}
	public void setPurchaserId(Integer purchaserId) {
		this.purchaserId = purchaserId;
	}
	public String getPurchaserName() {
		return purchaserName;
	}
	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}
	public Calendar getDateSold() {
		return dateSold;
	}
	public void setDateSold(Calendar dateSold) {
		this.dateSold = dateSold;
	}
	public int getPaymentStatusId() {
		return paymentStatusId;
	}
	public void setPaymentStatusId(int paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Account [boardId=" + boardId + ", boardName=" + boardName
				+ ", boardPrice=" + boardPrice + ", totalPrice=" + totalPrice
				+ ", boardImage=" + boardImage + ", tileImageUrl="
				+ tileImageUrl + ", portfilioId=" + portfilioId
				+ ", portfolioName=" + portfolioName + ", purchaserId="
				+ purchaserId + ", purchaserName=" + purchaserName
				+ ", dateSold=" + dateSold + ", paymentStatusId="
				+ paymentStatusId + ", paymentStatus=" + paymentStatus + "]";
	}
}
