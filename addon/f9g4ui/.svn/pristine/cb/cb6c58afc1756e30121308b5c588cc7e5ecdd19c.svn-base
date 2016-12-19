package com.f9g4.web.forms;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.f9g4.businessobjects.services.TrActivityDomain;

public class ActivityGrid {
	Integer boardId;
	String boardImageUrl;
	String boardName;
	boolean showImage;
	String typeCode;
	Integer designerId;
	String designerName;
	Date dateViewed;
	String strDateViewed;
	int noofHits;
	String portfolioname;
	String price;
	String salePrice;
	String season;

	public ActivityGrid(TrActivityDomain trActivityDomain) {
		// TODO Auto-generated constructor stub
		setBoardImageUrl(trActivityDomain.getBoardImageUrl());
		setBoardName(trActivityDomain.getBoardName());
		if(trActivityDomain.getDateViewed()!=null)
		{
			setDateViewed(trActivityDomain.getDateViewed().toGregorianCalendar().getTime());
			SimpleDateFormat dateFormater = new SimpleDateFormat("MMM-dd-yyyy"); 
			setStrDateViewed(dateFormater.format(getDateViewed()));
		}
		setDesignerName(trActivityDomain.getDesignerName());
		setNoofHits(trActivityDomain.getNoofhits());
		setPortfolioname(trActivityDomain.getPortfolioname());
		setPrice(trActivityDomain.getPrice());
		setSeason(trActivityDomain.getSeason());
		setBoardId(trActivityDomain.getBoardId());
		setDesignerId(trActivityDomain.getDesignerId());
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public boolean isShowImage() {
		return showImage;
	}

	public void setShowImage(boolean showImage) {
		this.showImage = showImage;
	}

	public Integer getDesignerId() {
		return designerId;
	}

	public void setDesignerId(Integer designerId) {
		this.designerId = designerId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardImageUrl() {
		return boardImageUrl;
	}

	public void setBoardImageUrl(String boardImageUrl) {
		this.boardImageUrl = boardImageUrl;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public Date getDateViewed() {
		return dateViewed;
	}

	public void setDateViewed(Date dateViewed) {
		this.dateViewed = dateViewed;
	}

	public String getStrDateViewed() {
		return strDateViewed;
	}

	public void setStrDateViewed(String strDateViewed) {
		this.strDateViewed = strDateViewed;
	}

	public int getNoofHits() {
		return noofHits;
	}

	public void setNoofHits(int noofHits) {
		this.noofHits = noofHits;
	}

	public String getPortfolioname() {
		return portfolioname;
	}

	public void setPortfolioname(String portfolioname) {
		this.portfolioname = portfolioname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

}
