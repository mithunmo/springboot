package com.f9g4.web.Helper;

import com.f9g4.businessobjects.domain.TrPortfolioContestDomain;
import com.f9g4.common.util.ProjectFormatter;

public class ProjectHelper {

	private ProjectHelper() {}
	
	public static String projectIdFormatter(TrPortfolioContestDomain source)
	{
		return ProjectFormatter.projectIdFormatter(source.getProjectType(), source.getContestPortfolioDomain().getPortfolioId(), source.getContestId());
	}
}
