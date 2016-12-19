package com.f9g4.web.forms;

import java.util.Arrays;


public class ContestBeanDetail {

	private Integer contestId;
	private Integer portfolioId;
	private String title;
	private Integer contestType;
	private Integer contestStatus;
	private String dueDate;
	private Integer winners;
	private Integer client;
	private Integer division;
	private Integer category;
	private String[] product;
	private String[] productType;
	private String subKeywords1;
	private String subKeywords2;
	private String subKeywords3;
	private String subKeywords4;
	private Integer season;
	private String associatedBrandsInfluence;
	private String associatedBrandsHangWith;
	private String introduction;
	private String description;
	private String deliverables;
	private String otherInformation;
	private Integer dimensions;
	private Integer format;
	
	//portfolio images
	private Integer[] portfolio_image_id;
	private String[] filename;
	private String[] filename_ext;
	private String[] filename_400;
	private String[] filename_100;
	private String[] filename_original;
	private Integer[] filestatus;
	private Integer[] active_status;
	
	//options
	private Boolean returnSubmissions;
	private Boolean sendNotification;
	
	public Boolean getReturnSubmissions() {
		return returnSubmissions;
	}
	public void setReturnSubmissions(Boolean returnSubmissions) {
		this.returnSubmissions = returnSubmissions;
	}
	public Boolean getSendNotification() {
		return sendNotification;
	}
	public void setSendNotification(Boolean sendNotification) {
		this.sendNotification = sendNotification;
	}
	public Integer[] getPortfolio_image_id() {
		return portfolio_image_id;
	}
	public void setPortfolio_image_id(Integer[] portfolio_image_id) {
		this.portfolio_image_id = portfolio_image_id;
	}
	public String[] getFilename() {
		return filename;
	}
	public void setFilename(String[] filename) {
		this.filename = filename;
	}
	public String[] getFilename_ext() {
		return filename_ext;
	}
	public void setFilename_ext(String[] filename_ext) {
		this.filename_ext = filename_ext;
	}
	public String[] getFilename_400() {
		return filename_400;
	}
	public void setFilename_400(String[] filename_400) {
		this.filename_400 = filename_400;
	}
	public String[] getFilename_100() {
		return filename_100;
	}
	public void setFilename_100(String[] filename_100) {
		this.filename_100 = filename_100;
	}
	public String[] getFilename_original() {
		return filename_original;
	}
	public void setFilename_original(String[] filename_original) {
		this.filename_original = filename_original;
	}
	public Integer[] getFilestatus() {
		return filestatus;
	}
	public void setFilestatus(Integer[] filestatus) {
		this.filestatus = filestatus;
	}
	public Integer[] getActive_status() {
		return active_status;
	}
	public void setActive_status(Integer[] active_status) {
		this.active_status = active_status;
	}
	public Integer getContestId() {
		return contestId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public Integer getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}
	public Integer getContestStatus() {
		return contestStatus;
	}
	public void setContestStatus(Integer contestStatus) {
		this.contestStatus = contestStatus;
	}
	public String[] getProduct() {
		return product;
	}
	public void setProduct(String[] product) {
		this.product = product;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getContestType() {
		return contestType;
	}
	public void setContestType(Integer contestType) {
		this.contestType = contestType;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getWinners() {
		return winners;
	}
	public void setWinners(Integer winners) {
		this.winners = winners;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public Integer getDivision() {
		return division;
	}
	public void setDivision(Integer division) {
		this.division = division;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String[] getProductType() {
		return productType;
	}
	public void setProductType(String[] productType) {
		this.productType = productType;
	}
	public String getSubKeywords1() {
		return subKeywords1;
	}
	public void setSubKeywords1(String subKeywords1) {
		this.subKeywords1 = subKeywords1;
	}
	public String getSubKeywords2() {
		return subKeywords2;
	}
	public void setSubKeywords2(String subKeywords2) {
		this.subKeywords2 = subKeywords2;
	}
	public String getSubKeywords3() {
		return subKeywords3;
	}
	public void setSubKeywords3(String subKeywords3) {
		this.subKeywords3 = subKeywords3;
	}
	public String getSubKeywords4() {
		return subKeywords4;
	}
	public void setSubKeywords4(String subKeywords4) {
		this.subKeywords4 = subKeywords4;
	}
	public Integer getSeason() {
		return season;
	}
	public void setSeason(Integer season) {
		this.season = season;
	}
	public String getAssociatedBrandsInfluence() {
		return associatedBrandsInfluence;
	}
	public void setAssociatedBrandsInfluence(String associatedBrandsInfluence) {
		this.associatedBrandsInfluence = associatedBrandsInfluence;
	}
	public String getAssociatedBrandsHangWith() {
		return associatedBrandsHangWith;
	}
	public void setAssociatedBrandsHangWith(String associatedBrandsHangWith) {
		this.associatedBrandsHangWith = associatedBrandsHangWith;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeliverables() {
		return deliverables;
	}
	public void setDeliverables(String deliverables) {
		this.deliverables = deliverables;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	public Integer getDimensions() {
		return dimensions;
	}
	public void setDimensions(Integer dimensions) {
		this.dimensions = dimensions;
	}
	public Integer getFormat() {
		return format;
	}
	public void setFormat(Integer format) {
		this.format = format;
	}
	
	@Override
	public String toString() {
		return "ContestBeanDetail [contestId=" + contestId + ", portfolioId="
				+ portfolioId + ", title=" + title + ", contestType="
				+ contestType + ", contestStatus=" + contestStatus
				+ ", dueDate=" + dueDate + ", winners=" + winners + ", client="
				+ client + ", division=" + division + ", category=" + category
				+ ", product=" + Arrays.toString(product) + ", productType="
				+ Arrays.toString(productType) + ", subKeywords1="
				+ subKeywords1 + ", subKeywords2=" + subKeywords2
				+ ", subKeywords3=" + subKeywords3 + ", subKeywords4="
				+ subKeywords4 + ", season=" + season
				+ ", associatedBrandsInfluence=" + associatedBrandsInfluence
				+ ", associatedBrandsHangWith=" + associatedBrandsHangWith
				+ ", introduction=" + introduction + ", description="
				+ description + ", deliverables=" + deliverables
				+ ", otherInformation=" + otherInformation + ", dimensions="
				+ dimensions + ", format=" + format + ", portfolio_image_id="
				+ Arrays.toString(portfolio_image_id) + ", filename="
				+ Arrays.toString(filename) + ", filename_ext="
				+ Arrays.toString(filename_ext) + ", filename_400="
				+ Arrays.toString(filename_400) + ", filename_100="
				+ Arrays.toString(filename_100) + ", filename_original="
				+ Arrays.toString(filename_original) + ", filestatus="
				+ Arrays.toString(filestatus) + ", active_status="
				+ Arrays.toString(active_status) + ", returnSubmissions="
				+ returnSubmissions + ", sendNotification=" + sendNotification
				+ "]";
	}
}
