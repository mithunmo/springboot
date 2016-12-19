package com.f9g4.dao;

import com.f9g4.domain.TrBroadcastMessages;
import com.f9g4.domain.TrReferrals;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrBroadcastMessages entities.
 * 
 */
public interface TrBroadcastMessagesDAO extends JpaDao<TrBroadcastMessages> {

	/**
	 * JPQL Query - findAllTrBroadcastMessages
	 *
	 */
	public Set<TrBroadcastMessages> findAllTrBroadcastMessages() throws DataAccessException;
	
	/**
	 * JPQL Query - findAllTrBroadcastMessages
	 *
	 */
	public Set<TrBroadcastMessages> findTrBroadcastMessagesByBroadcastId(Integer broadcastId) throws DataAccessException;
	
	/**
	 * JPQL Query - findAllTrBroadcastMessages
	 *
	 */
	public Set<TrBroadcastMessages> findTrBroadcastMessagesByMsgScopeId(Integer msgScopeId) throws DataAccessException;
	
	/**
	 * JPQL Query - findAllTrBroadcastMessages
	 *
	 */
	public Set<TrBroadcastMessages> findTrBroadcastMessagesByMsgStatusId(Integer msgStatusId) throws DataAccessException;


	
}