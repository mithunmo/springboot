package com.f9g4.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.domain.TrPayGatewayAuditLog;
import com.f9g4.domain.TrSalesTransactionDetails;

/**
 * DAO to manage TrPayGatewayAuditLog entities.
 * 
 */
@Repository("TrPayGatewayAuditLogDAO")
@Transactional
public class TrPayGatewayAuditLogDAOImpl extends AbstractJpaDao<TrPayGatewayAuditLog> implements TrPayGatewayAuditLogDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrSalesTransactionDetails.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrSalesTransactionDetailsDAOImpl
	 *
	 */
	public TrPayGatewayAuditLogDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAllTrPayGatewayAuditLog
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPayGatewayAuditLog> findAllTrPayGatewayAuditLog(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrPayGatewayAuditLog", startResult, maxRows);
		return new LinkedHashSet<TrPayGatewayAuditLog>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrPayGatewayAuditLogByPayGatewayId
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public TrPayGatewayAuditLog findAllTrPayGatewayAuditLogByPayGatewayId(Integer payGatewayId) throws DataAccessException {
		Query query = createNamedQuery("findAllTrPayGatewayAuditLogByPayGatewayId", -1, -1);
		return (TrPayGatewayAuditLog) query.getSingleResult();
	}

	
	/**
	 * JPQL Query - findAllTrPayGatewayAuditLog
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrPayGatewayAuditLog> findAllTrPayGatewayAuditLog()throws DataAccessException {
		Query query = createNamedQuery("findAllTrPayGatewayAuditLog", -1, -1);
		return new LinkedHashSet<TrPayGatewayAuditLog>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 */
	@Override
	public boolean canBeMerged(TrPayGatewayAuditLog o) {
		return true;
	}
}
