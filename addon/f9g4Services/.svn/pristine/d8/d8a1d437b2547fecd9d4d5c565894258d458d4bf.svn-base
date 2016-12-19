package com.f9g4.dao;

import com.f9g4.domain.TrPortfolioContestMembers;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrPortfolioContestMembers entities.
 * 
 */
public interface TrPortfolioContestMembersDAO extends JpaDao<TrPortfolioContestMembers> {


	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	public Set<TrPortfolioContestMembers> findAllTrPortfolioContestMembers() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPortfolioImagess
	 *
	 */
	public Set<TrPortfolioContestMembers> findAllTrPortfolioContestMembers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPortfolioByUserId
	 *
	 */
	public Set<TrPortfolioContestMembers> findAllTrPortfolioByUserId(Integer userId, int startResult, int maxRows);
	

	/**
	 * JPQL Query - findAllContestMembersByPortfolioId 
	 *
	 */
	public Set<Integer> findAllContestMembersByPortfolioId(Integer portfolioId, int startResult, int maxRows);

	/**
	 * JPQL Query - findAllActiveContestMembersByPortfolioId 
	 *
	 */
	public Set<TrPortfolioContestMembers> findAllActiveContestMembersByPortfolioId(Integer portfolioId, int startResult, int maxRows);
	
	/**
	 * JPQL Query - findContestMembersByPortfolioIdAndUserId 
	 *
	 */
	public TrPortfolioContestMembers findContestMembersByPortfolioIdAndUserId(Integer portfolioId, Integer userId, int startResult, int maxRows);
	
}