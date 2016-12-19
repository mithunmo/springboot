package com.f9g4.web.forms;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.f9g4.businessobjects.services.DesignWallBoardInfoDomain;
import com.f9g4.businessobjects.services.DesignerAccountDomain;


public class DesignerAccountForm {
	int boardId;
    String boardName;
    BigDecimal boardPrice;
    String boardImage;
    String tileImageUrl;
    int portfilioId;
    String portfolioName;
    int purchaserId;
    String purchaserName;
    Date dateSold;
    int paymentStatusId;
    String paymentStatus;
    
    public DesignerAccountForm(DesignerAccountDomain item) 
    {
		// TODO Auto-generated constructor stub
    	this.boardId=item.getBoardId();
    	this.boardName=item.getBoardName();
    	this.boardPrice=item.getBoardPrice();
    	this.boardImage=item.getBoardImage();
    	this.portfilioId=item.getPortfilioId();
    	this.portfolioName=item.getPortfolioName();
    	this.purchaserId=item.getPurchaserId();
    	this.purchaserName=item.getPurchaserName();
    	//convert to Calendar
    	this.dateSold=item.getDateSold().toGregorianCalendar().getTime();
    	this.paymentStatusId=item.getPaymentStatusId();
    	this.paymentStatus=item.getPaymentStatus();
    	this.tileImageUrl=item.getTileImageUrl();
	}

	public String getTileImageUrl() {
		return tileImageUrl;
	}

	public void setTileImageUrl(String tileImageUrl) {
		this.tileImageUrl = tileImageUrl;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
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

	public int getPortfilioId() {
		return portfilioId;
	}

	public void setPortfilioId(int portfilioId) {
		this.portfilioId = portfilioId;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public int getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(int purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
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

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}
    
}
