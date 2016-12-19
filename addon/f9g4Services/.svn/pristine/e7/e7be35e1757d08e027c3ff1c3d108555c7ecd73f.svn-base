package com.f9g4.dao;

import com.f9g4.domain.TrBoardApproval;

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

/**
 * DAO to manage TrPortfolio entities.
 * 
 */
@Repository("TrBoardApprovalDAO")
@Transactional
public class TrBoardApprovalImpl extends AbstractJpaDao<TrBoardApproval> implements
		TrBoardApprovalDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrBoardApproval.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrPortfolioDAOImpl
	 *
	 */
	public TrBoardApprovalImpl() {
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
	 * JPQL Query - findTrBoardImagesBySourceFileUrl
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardApproval> findTrBoardApprovalById(Integer id) throws DataAccessException {
		Query query = createNamedQuery("findTrBoardApprovalById", -1, -1, id);
		return new LinkedHashSet<TrBoardApproval>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardApproval> findAllTrBoardApproval() throws DataAccessException {
		Query query = createNamedQuery("findAllTrBoardApproval", -1, -1);
		return new LinkedHashSet<TrBoardApproval>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrBoardApproval> findTrBoardApprovalByMainImageUrl(String mainImageUrl)
	{
		Query query = createNamedQuery("findTrBoardApprovalByMainImageUrl", -1, -1,mainImageUrl);
		return new LinkedHashSet<TrBoardApproval>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */

	@Override
	public boolean canBeMerged(TrBoardApproval o) {
		// TODO Auto-generated method stub
		return false;
	}
}
