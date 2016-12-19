package com.f9g4.dao;

import com.f9g4.domain.TrBoardApproval;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrPortfolio entities.
 * 
 */
public interface TrBoardApprovalDAO extends JpaDao<TrBoardApproval> {

	/**
	 * JPQL Query - findTrPortfolioByCreatedBy
	 *
	 */
	public Set<TrBoardApproval> findTrBoardApprovalById(Integer id) throws DataAccessException;

	public Set<TrBoardApproval> findAllTrBoardApproval() throws DataAccessException;
	
	public Set<TrBoardApproval> findTrBoardApprovalByMainImageUrl(String mainImageUrl) throws DataAccessException;
	
}