package com.f9g4.dao;

import com.f9g4.domain.TrPortfolioContest;
import com.f9g4.domain.TrPortfolioImages;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrPortfolioImages entities.
 * 
 */
public interface TrPortfolioContestDAO extends JpaDao<TrPortfolioContest> {


	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	public Set<TrPortfolioContest> findAllTrPortfolioContests() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	public Set<TrPortfolioContest> findAllTrPortfolioContests(int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */	
	public TrPortfolioContest findTrPortfolioContestByPortfolioId(Integer portfolioId, int startResult, int maxRows);

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */	
	public TrPortfolioContest findTrPortfolioByContestIdAndPortfolioId(Integer portfolioId, Integer contestId, int startResult, int maxRows);
	
	
}