package com.f9g4.dao;

import com.f9g4.domain.TrCompanyAvailCredit;
import com.f9g4.domain.TrCompanyCredit;
import com.f9g4.domain.TrCompanyCreditTransactionDetail;
import com.f9g4.domain.TrCompanyCreditTransactionHeader;
import com.f9g4.domain.TrPortfolio;
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
 * DAO to manage TrCompanyCredit entities.
 * 
 */
@Repository("TrCompanyAvailCreditDAO")
@Transactional
public  class TrCompanyAvailCreditDAOImpl extends AbstractJpaDao<TrCompanyAvailCredit>
		implements TrCompanyAvailCreditDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrCompanyAvailCredit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrCompanyCreditDAOImpl
	 *
	 */
	public TrCompanyAvailCreditDAOImpl() {
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


	@Override
	public boolean canBeMerged(TrCompanyAvailCredit o) {
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings("unchecked")
	public Set<TrCompanyAvailCredit> findAvailCreditByUserId(Integer userId,
			int startResult, int maxRows) {
		try {
			Query query = createNamedQuery("findAvailCreditByUserId", startResult, maxRows, userId);
			  return new LinkedHashSet<TrCompanyAvailCredit>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
		
	}

	public Long findTotalAvailCreditByUserId(Integer userId,
			int startResult, int maxRows) {
		try {
			Query query = createNamedQuery("findTotalAvailCreditByUserId", startResult, maxRows, userId);
			  return (Long)query.getResultList().get(0);
		} catch (NoResultException nre) {
			return null;
		}
		
	}

		
			
}
