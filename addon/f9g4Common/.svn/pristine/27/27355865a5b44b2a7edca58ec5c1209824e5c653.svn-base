package com.f9g4.common.util;

public class ProjectFormatter {

	private ProjectFormatter() {}
	
	public static String projectIdFormatter(Integer projectType, Integer portfolioId, Integer contestId)
	{
		String formattedProjectType=String.format("%02d", projectType);
		String formattedPortfolioId=String.format("%07d", portfolioId);
		String formattedContestId=String.format("%02d", contestId);
		return formattedProjectType+"-"+formattedPortfolioId+"@"+formattedContestId;
	}
}
