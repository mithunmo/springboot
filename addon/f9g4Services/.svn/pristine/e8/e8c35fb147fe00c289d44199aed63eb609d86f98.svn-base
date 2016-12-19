package com.f9g4.dao;

import com.f9g4.domain.AdEmailTemplates;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.StSeasonYear;
import com.f9g4.domain.TrBoardImages;
import com.f9g4.domain.TrBoardApproval;
import com.f9g4.domain.TrPortfolio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
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
@Repository("AdEmailTamplatesDAO")
@Transactional
public class AdEmailTemplatesImpl extends AbstractJpaDao<AdEmailTemplates> implements
		AdEmailTemplatesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdEmailTemplates.class }));

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
	public AdEmailTemplatesImpl() {
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
	public AdEmailTemplates findAdEmailTemplatesById(Integer id)
	{
		try {
			Query query = createNamedQuery("findAdEmailTemplatesById", -1, -1, id);
			return (AdEmailTemplates) query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	public AdEmailTemplates findAdEmailTemplatesByTemplateCode(String code)
	{
		try {
			Query query = createNamedQuery("findAdEmailTemplatesByTemplateCode", -1, -1, code);
			return (AdEmailTemplates) query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	public Set<AdEmailTemplates> findAdEmailTemplatesByTemplateCodeContaining(String code)
	{
		Query query = createNamedQuery("findAdEmailTemplatesByTemplateCodeContaining", -1, -1);
		query.setParameter(1, code);
		return new LinkedHashSet<AdEmailTemplates>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrPortfolio entity) {
		return true;
	}

	@Override
	public boolean canBeMerged(AdEmailTemplates o) {
		// TODO Auto-generated method stub
		return false;
	}
}
