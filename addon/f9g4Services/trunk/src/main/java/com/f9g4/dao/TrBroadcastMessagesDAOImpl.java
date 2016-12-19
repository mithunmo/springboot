package com.f9g4.dao;

import com.f9g4.domain.TrBroadcastMessages;
import com.f9g4.domain.TrReferrals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage TrReferrals entities.
 * 
 */
@Repository("TrBroadcastMessagesDAO")
@Transactional
public class TrBroadcastMessagesDAOImpl extends AbstractJpaDao<TrBroadcastMessages> implements	TrBroadcastMessagesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrBroadcastMessages.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrBroadcastMessagesDAO
	 *
	 */
	public TrBroadcastMessagesDAOImpl() {
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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrBroadcastMessages o) {
		return true;
	}
	
	/**
	 * JPQL Query - findTrReferralsByMessage
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBroadcastMessages> findAllTrBroadcastMessages() throws DataAccessException {
		Query query = createNamedQuery("findAllTrBroadcastMessages", -1, -1);
		return new LinkedHashSet<TrBroadcastMessages>(query.getResultList());
	}

	@Transactional
	public Set<TrBroadcastMessages> findTrBroadcastMessagesByBroadcastId(Integer broadcastId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrBroadcastMessagesByBroadcastId", -1, -1);
		query.setParameter(1, broadcastId);
		return new LinkedHashSet<TrBroadcastMessages>(query.getResultList());
	}

	@Transactional
	public Set<TrBroadcastMessages> findTrBroadcastMessagesByMsgScopeId(Integer msgScopeId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrBroadcastMessagesByMsgScopeId", -1, -1);
		query.setParameter(1, msgScopeId);
		return new LinkedHashSet<TrBroadcastMessages>(query.getResultList());
	}

	@Transactional
	public Set<TrBroadcastMessages> findTrBroadcastMessagesByMsgStatusId(Integer msgStatusId)
			throws DataAccessException {
		Query query = createNamedQuery("findTrBroadcastMessagesByMsgStatusId", -1, -1);
		query.setParameter(1, msgStatusId);
		return new LinkedHashSet<TrBroadcastMessages>(query.getResultList());
	}
}
