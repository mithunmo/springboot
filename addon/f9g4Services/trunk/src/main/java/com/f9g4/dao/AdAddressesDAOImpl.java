package com.f9g4.dao;

import com.f9g4.domain.AdAddresses;

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
 * DAO to manage AdAddresses entities.
 * 
 */
@Repository("AdAddressesDAO")
@Transactional
public class AdAddressesDAOImpl extends AbstractJpaDao<AdAddresses> implements
		AdAddressesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdAddresses.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdAddressesDAOImpl
	 *
	 */
	public AdAddressesDAOImpl() {
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
	 * JPQL Query - findAdAddressesByPostalCode
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByPostalCode(String postalCode) throws DataAccessException {

		return findAdAddressesByPostalCode(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByPostalCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByPostalCode(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByPostalCode", startResult, maxRows, postalCode);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByAddressId
	 *
	 */
	@Transactional
	public AdAddresses findAdAddressesByAddressId(Integer addressId) throws DataAccessException {

		return findAdAddressesByAddressId(addressId, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByAddressId
	 *
	 */

	@Transactional
	public AdAddresses findAdAddressesByAddressId(Integer addressId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdAddressesByAddressId", startResult, maxRows, addressId);
			return (com.f9g4.domain.AdAddresses) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdAddressesByPrimaryKey
	 *
	 */
	@Transactional
	public AdAddresses findAdAddressesByPrimaryKey(Integer addressId) throws DataAccessException {

		return findAdAddressesByPrimaryKey(addressId, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByPrimaryKey
	 *
	 */

	@Transactional
	public AdAddresses findAdAddressesByPrimaryKey(Integer addressId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdAddressesByPrimaryKey", startResult, maxRows, addressId);
			return (com.f9g4.domain.AdAddresses) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAdAddressess
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAllAdAddressess() throws DataAccessException {

		return findAllAdAddressess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdAddressess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAllAdAddressess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdAddressess", startResult, maxRows);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByCounty
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByCounty(String county) throws DataAccessException {

		return findAdAddressesByCounty(county, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByCounty
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByCounty(String county, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByCounty", startResult, maxRows, county);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine2Containing
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine2Containing(String addressLine2) throws DataAccessException {

		return findAdAddressesByAddressLine2Containing(addressLine2, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine2Containing(String addressLine2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByAddressLine2Containing", startResult, maxRows, addressLine2);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByCreationDate
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdAddressesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByPostalCodeContaining
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByPostalCodeContaining(String postalCode) throws DataAccessException {

		return findAdAddressesByPostalCodeContaining(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByPostalCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByPostalCodeContaining", startResult, maxRows, postalCode);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByCountyContaining
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByCountyContaining(String county) throws DataAccessException {

		return findAdAddressesByCountyContaining(county, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByCountyContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByCountyContaining(String county, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByCountyContaining", startResult, maxRows, county);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findAdAddressesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByLangCode
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByLangCode(String langCode) throws DataAccessException {

		return findAdAddressesByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine1Containing
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine1Containing(String addressLine1) throws DataAccessException {

		return findAdAddressesByAddressLine1Containing(addressLine1, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine1Containing(String addressLine1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByAddressLine1Containing", startResult, maxRows, addressLine1);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByCity
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByCity(String city) throws DataAccessException {

		return findAdAddressesByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByCity", startResult, maxRows, city);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByState
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByState(String state) throws DataAccessException {

		return findAdAddressesByState(state, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByState", startResult, maxRows, state);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByActiveStatus
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findAdAddressesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findAdAddressesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByLangCodeContaining(String langCode) throws DataAccessException {

		return findAdAddressesByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByCityContaining
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByCityContaining(String city) throws DataAccessException {

		return findAdAddressesByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByStateContaining
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByStateContaining(String state) throws DataAccessException {

		return findAdAddressesByStateContaining(state, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine1
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine1(String addressLine1) throws DataAccessException {

		return findAdAddressesByAddressLine1(addressLine1, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine1(String addressLine1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByAddressLine1", startResult, maxRows, addressLine1);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdAddressesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine2
	 *
	 */
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine2(String addressLine2) throws DataAccessException {

		return findAdAddressesByAddressLine2(addressLine2, -1, -1);
	}

	/**
	 * JPQL Query - findAdAddressesByAddressLine2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdAddresses> findAdAddressesByAddressLine2(String addressLine2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdAddressesByAddressLine2", startResult, maxRows, addressLine2);
		return new LinkedHashSet<AdAddresses>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdAddresses entity) {
		return true;
	}
}
