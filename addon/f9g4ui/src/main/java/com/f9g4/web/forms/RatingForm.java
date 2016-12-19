package com.f9g4.web.forms;

import java.util.Arrays;

public class RatingForm 
{	
	private Integer boardId;
	private Integer ratingUserId;
	//private Integer userId;
	//private Integer avgRatingId;
	private Float rate_1;
	private int rate_1_questionId;
	private Float rate_1_1_q;
	private int rate_2_questionId;
	private Float rate_1_1_p;
	private int rate_3_questionId;
	private Float rate_1_1_r;
	private int rate_4_questionId;
	private Float rate_1_1_c;
	private int messageId;
	private String comment;
	
	
	public int getRate_1_questionId() {
		return rate_1_questionId;
	}
	public void setRate_1_questionId(int rate_1_questionId) {
		this.rate_1_questionId = rate_1_questionId;
	}
	public int getRate_2_questionId() {
		return rate_2_questionId;
	}
	public void setRate_2_questionId(int rate_2_questionId) {
		this.rate_2_questionId = rate_2_questionId;
	}
	public int getRate_3_questionId() {
		return rate_3_questionId;
	}
	public void setRate_3_questionId(int rate_3_questionId) {
		this.rate_3_questionId = rate_3_questionId;
	}
	public int getRate_4_questionId() {
		return rate_4_questionId;
	}
	public void setRate_4_questionId(int rate_4_questionId) {
		this.rate_4_questionId = rate_4_questionId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Integer getRatingUserId() {
		return ratingUserId;
	}
	public void setRatingUserId(Integer ratingUserId) {
		this.ratingUserId = ratingUserId;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public Float getRate_1() {
		return rate_1;
	}
	public void setRate_1(Float rate_1) {
		this.rate_1 = rate_1;
	}
	public Float getRate_1_1_q() {
		return rate_1_1_q;
	}
	public void setRate_1_1_q(Float rate_1_1_q) {
		this.rate_1_1_q = rate_1_1_q;
	}
	public Float getRate_1_1_p() {
		return rate_1_1_p;
	}
	public void setRate_1_1_p(Float rate_1_1_p) {
		this.rate_1_1_p = rate_1_1_p;
	}
	public Float getRate_1_1_r() {
		return rate_1_1_r;
	}
	public void setRate_1_1_r(Float rate_1_1_r) {
		this.rate_1_1_r = rate_1_1_r;
	}
	public Float getRate_1_1_c() {
		return rate_1_1_c;
	}
	public void setRate_1_1_c(Float rate_1_1_c) {
		this.rate_1_1_c = rate_1_1_c;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	@Override
	public String toString() {
		return "RatingForm [boardId=" + boardId + ", ratingUserId="
				+ ratingUserId + ", rate_1=" + rate_1 + ", rate_1_questionId="
				+ rate_1_questionId + ", rate_1_1_q=" + rate_1_1_q
				+ ", rate_2_questionId=" + rate_2_questionId + ", rate_1_1_p="
				+ rate_1_1_p + ", rate_3_questionId=" + rate_3_questionId
				+ ", rate_1_1_r=" + rate_1_1_r + ", rate_4_questionId="
				+ rate_4_questionId + ", rate_1_1_c=" + rate_1_1_c
				+ ", messageId=" + messageId + ", comment=" + comment + "]";
	}
}
