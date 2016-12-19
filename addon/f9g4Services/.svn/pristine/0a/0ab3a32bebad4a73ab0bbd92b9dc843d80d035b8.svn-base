package com.f9g4.dao;

import com.f9g4.domain.TrPortfolioContest;
import com.f9g4.domain.TrPortfolioContestMembers;
import com.f9g4.domain.TrPortfolioImages;

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
 * DAO to manage TrPortfolioContestMembers entities.
 * 
 */
@Repository("TrPortfolioContestMembersDAO")
@Transactional
public class TrPortfolioContestMembersDAOImpl extends AbstractJpaDao<TrPortfolioContestMembers>
		implements TrPortfolioContestMembersDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrPortfolioContestMembers.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrPortfolioContestDAOImpl
	 *
	 */
	public TrPortfolioContestMembersDAOImpl() {
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

	public Set<TrPortfolioContestMembers> findAllTrPortfolioContestMembers()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<TrPortfolioContestMembers> findAllTrPortfolioContestMembers(int startResult,
			int maxRows) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean canBeMerged(TrPortfolioContestMembers o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public Set<TrPortfolioContestMembers> findAllTrPortfolioByUserId(Integer userId, int startResult, int maxRows) {
		try {
			Query query = createNamedQuery("findAllTrPortfolioByUserId", startResult, maxRows, userId);
			  return new LinkedHashSet<TrPortfolioContestMembers>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Set<Integer> findAllContestMembersByPortfolioId(
			Integer portfolioId, int startResult, int maxRows) {
		try {
			Query query = createNamedQuery("findAllContestMembersByPortfolioId", -1, -1, portfolioId);
			  return new LinkedHashSet<Integer>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public Set<TrPortfolioContestMembers> findAllActiveContestMembersByPortfolioId(
			Integer portfolioId, int startResult, int maxRows) {
		try {
			Query query = createNamedQuery("findAllActiveContestMembersByPortfolioId", -1, -1, portfolioId);
			  return new LinkedHashSet<TrPortfolioContestMembers>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public TrPortfolioContestMembers findContestMembersByPortfolioIdAndUserId(
			Integer portfolioId, Integer userId, int startResult, int maxRows) {
		try {
			Query query = createNamedQuery("findContestMembersByPortfolioIdAndUserId", -1, -1, portfolioId, userId);
			  return (TrPortfolioContestMembers)query.getResultList().get(0);
		} catch (NoResultException nre) {
			return null;
		}
		
	}
	
}
