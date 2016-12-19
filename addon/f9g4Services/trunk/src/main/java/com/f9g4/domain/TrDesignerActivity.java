package com.f9g4.domain;

import javax.persistence.Entity;

@Entity
public class TrDesignerActivity extends TrBoardSearch{

	private int totalViewd;

	public int getTotalViewd() {
		return totalViewd;
	}

	public void setTotalViewd(int totalViewd) {
		this.totalViewd = totalViewd;
	}
	
	
	
}
