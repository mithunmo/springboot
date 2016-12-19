package com.f9g4.web.forms;

//only carry the project basic data(Better performance when show the project list in drop down menu)
public class ContestBeanBasic {

	private Integer portfolioId;
	private Integer contestId;
	private Integer projectType;
	private String title;
	
	public ContestBeanBasic()
	{
	}

	public String getProjectId() {
		String projectType=String.format("%02d", this.projectType);
		String portfolioId=String.format("%07d", this.portfolioId);
		String contestId=String.format("%02d", this.contestId);
		return projectType+"-"+portfolioId+"@"+contestId;
	}
	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public Integer getContestId() {
		return contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
