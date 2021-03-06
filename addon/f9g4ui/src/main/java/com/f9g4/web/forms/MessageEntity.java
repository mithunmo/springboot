package com.f9g4.web.forms;

import java.util.Date;


public class MessageEntity {

	private Integer messageId;
	private Integer boardId;
	private	String boardName;
	private String boardUrl;
	private String boardTileUrl;
	private boolean showImage;
	private String typeCode;
	private Integer toUserId;
	private String toUserFirstName;
	private String toUserLastName;
	private String toUserCompanyName;
	private Boolean toUserIsCompany;
	private String toUserLogo;
	private String toFinalName; //User name after apply profile name logic 
	private Integer fromUserId;
	private String fromUserFirstName;
	private String fromUserLastName;
	private String fromUserCompanyName;
	private Boolean fromUserIsCompany;
	private String fromUserLogo;
	private String fromFinalName; //User name after apply profile name logic
	private String messageBody;
	private Date date;
	
	
	public String getToFinalName() {
		return toFinalName;
	}
	public void setToFinalName(String toFinalName) {
		this.toFinalName = toFinalName;
	}
	public String getFromFinalName() {
		return fromFinalName;
	}
	public void setFromFinalName(String fromFinalName) {
		this.fromFinalName = fromFinalName;
	}
	public String getToUserCompanyName() {
		return toUserCompanyName;
	}
	public void setToUserCompanyName(String toUserCompanyName) {
		this.toUserCompanyName = toUserCompanyName;
	}
	public Boolean getToUserIsCompany() {
		return toUserIsCompany;
	}
	public void setToUserIsCompany(Boolean toUserIsCompany) {
		this.toUserIsCompany = toUserIsCompany;
	}
	public String getFromUserCompanyName() {
		return fromUserCompanyName;
	}
	public void setFromUserCompanyName(String fromUserCompanyName) {
		this.fromUserCompanyName = fromUserCompanyName;
	}
	public Boolean getFromUserIsCompany() {
		return fromUserIsCompany;
	}
	public void setFromUserIsCompany(Boolean fromUserIsCompany) {
		this.fromUserIsCompany = fromUserIsCompany;
	}
	public String getToUserFirstName() {
		return toUserFirstName;
	}
	public void setToUserFirstName(String toUserFirstName) {
		this.toUserFirstName = toUserFirstName;
	}
	public String getToUserLastName() {
		return toUserLastName;
	}
	public void setToUserLastName(String toUserLastName) {
		this.toUserLastName = toUserLastName;
	}
	public String getFromUserFirstName() {
		return fromUserFirstName;
	}
	public void setFromUserFirstName(String fromUserFirstName) {
		this.fromUserFirstName = fromUserFirstName;
	}
	public String getFromUserLastName() {
		return fromUserLastName;
	}
	public void setFromUserLastName(String fromUserLastName) {
		this.fromUserLastName = fromUserLastName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getBoardTileUrl() {
		return boardTileUrl;
	}
	public void setBoardTileUrl(String boardTileUrl) {
		this.boardTileUrl = boardTileUrl;
	}
	public boolean isShowImage() {
		return showImage;
	}
	public void setShowImage(boolean showImage) {
		this.showImage = showImage;
	}
	public String getBoardUrl() {
		return boardUrl;
	}
	public void setBoardUrl(String boardUrl) {
		this.boardUrl = boardUrl;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
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
	public Integer getToUserId() {
		return toUserId;
	}
	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}
	public String getToUserLogo() {
		return toUserLogo;
	}
	public void setToUserLogo(String toUserLogo) {
		this.toUserLogo = toUserLogo;
	}
	public Integer getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getFromUserLogo() {
		return fromUserLogo;
	}
	public void setFromUserLogo(String fromUserLogo) {
		this.fromUserLogo = fromUserLogo;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "MessageEntity [messageId=" + messageId + ", boardId=" + boardId
				+ ", boardName=" + boardName + ", boardUrl=" + boardUrl
				+ ", boardTileUrl=" + boardTileUrl + ", showImage=" + showImage
				+ ", typeCode=" + typeCode + ", toUserId=" + toUserId
				+ ", toUserFirstName=" + toUserFirstName + ", toUserLastName="
				+ toUserLastName + ", toUserCompanyName=" + toUserCompanyName
				+ ", toUserIsCompany=" + toUserIsCompany + ", toUserLogo="
				+ toUserLogo + ", toFinalName=" + toFinalName + ", fromUserId="
				+ fromUserId + ", fromUserFirstName=" + fromUserFirstName
				+ ", fromUserLastName=" + fromUserLastName
				+ ", fromUserCompanyName=" + fromUserCompanyName
				+ ", fromUserIsCompany=" + fromUserIsCompany
				+ ", fromUserLogo=" + fromUserLogo + ", fromFinalName="
				+ fromFinalName + ", messageBody=" + messageBody + ", date="
				+ date + "]";
	}
}
