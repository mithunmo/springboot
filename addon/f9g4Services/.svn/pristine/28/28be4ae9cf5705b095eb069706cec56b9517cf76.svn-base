package com.f9g4.dao;

import com.f9g4.domain.AdUserMemberships;

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
 * DAO to manage AdUserMemberships entities.
 * 
 */
@Repository("AdUserMembershipsDAO")
@Transactional
public class AdUserMembershipsDAOImpl extends AbstractJpaDao<AdUserMemberships> implements AdUserMembershipsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdUserMemberships.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdUserMembershipsDAOImpl
	 *
	 */
	public AdUserMembershipsDAOImpl() {
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
	 * JPQL Query - findAdUserMembershipsByMembershipId
	 *
	 */
	@Transactional
	public AdUserMemberships findAdUserMembershipsByMembershipId(Integer membershipId) throws DataAccessException {

		return findAdUserMembershipsByMembershipId(membershipId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByMembershipId
	 *
	 */

	@Transactional
	public AdUserMemberships findAdUserMembershipsByMembershipId(Integer membershipId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserMembershipsByMembershipId", startResult, maxRows, membershipId);
			return (com.f9g4.domain.AdUserMemberships) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserMembershipsByExpirationDate
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException {

		return findAdUserMembershipsByExpirationDate(expirationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByExpirationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByExpirationDate(java.util.Calendar expirationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByExpirationDate", startResult, maxRows, expirationDate);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdUserMembershipsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdUserMembershipsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdUserMembershipsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdUserMembershipss
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAllAdUserMembershipss() throws DataAccessException {

		return findAllAdUserMembershipss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdUserMembershipss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAllAdUserMembershipss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdUserMembershipss", startResult, maxRows);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByAutopay
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByAutopay(Integer autopay) throws DataAccessException {

		return findAdUserMembershipsByAutopay(autopay, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByAutopay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByAutopay(Integer autopay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByAutopay", startResult, maxRows, autopay);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByEffectiveDate
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByEffectiveDate(java.util.Calendar effectiveDate) throws DataAccessException {

		return findAdUserMembershipsByEffectiveDate(effectiveDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByEffectiveDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByEffectiveDate(java.util.Calendar effectiveDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByEffectiveDate", startResult, maxRows, effectiveDate);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdUserMembershipsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdUserMembershipsByPrimaryKey
	 *
	 */
	@Transactional
	public AdUserMemberships findAdUserMembershipsByPrimaryKey(Integer membershipId) throws DataAccessException {

		return findAdUserMembershipsByPrimaryKey(membershipId, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByPrimaryKey
	 *
	 */

	@Transactional
	public AdUserMemberships findAdUserMembershipsByPrimaryKey(Integer membershipId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserMembershipsByPrimaryKey", startResult, maxRows, membershipId);
			return (com.f9g4.domain.AdUserMemberships) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdUserMembershipsByAutopayWithdrawDay
	 *
	 */
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByAutopayWithdrawDay(Integer autopayWithdrawDay) throws DataAccessException {

		return findAdUserMembershipsByAutopayWithdrawDay(autopayWithdrawDay, -1, -1);
	}

	/**
	 * JPQL Query - findAdUserMembershipsByAutopayWithdrawDay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdUserMemberships> findAdUserMembershipsByAutopayWithdrawDay(Integer autopayWithdrawDay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdUserMembershipsByAutopayWithdrawDay", startResult, maxRows, autopayWithdrawDay);
		return new LinkedHashSet<AdUserMemberships>(query.getResultList());
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public AdUserMemberships findAdUserMembershipsByUserId(Integer userId) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdUserMembershipsByUserId", -1, -1, userId);
			return (com.f9g4.domain.AdUserMemberships) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdUserMemberships entity) {
		return true;
	}



}
