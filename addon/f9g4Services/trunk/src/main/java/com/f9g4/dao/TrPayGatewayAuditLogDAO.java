package com.f9g4.dao;

import com.f9g4.domain.TrPayGatewayAuditLog;
import com.f9g4.domain.TrSalesTransactionDetails;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrPayGatewayAuditLog entities.
 * 
 */
public interface TrPayGatewayAuditLogDAO extends JpaDao<TrPayGatewayAuditLog> {

	/**
	 * JPQL Query - findAllTrPayGatewayAuditLog
	 *
	 */
	public Set<TrPayGatewayAuditLog> findAllTrPayGatewayAuditLog() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrPayGatewayAuditLog
	 *
	 */
	public Set<TrPayGatewayAuditLog> findAllTrPayGatewayAuditLog(int startResult, int maxRows) throws DataAccessException;

	
	/**
	 * JPQL Query - findAllTrPayGatewayAuditLogByPayGatewayId
	 *
	 */
	public TrPayGatewayAuditLog findAllTrPayGatewayAuditLogByPayGatewayId(Integer payGatewayId) throws DataAccessException;

}