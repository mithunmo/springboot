package com.f9g4.dao;

import com.f9g4.domain.AdContacts;

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
 * DAO to manage AdContacts entities.
 * 
 */
@Repository("AdContactsDAO")
@Transactional
public class AdContactsDAOImpl extends AbstractJpaDao<AdContacts> implements
		AdContactsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AdContacts.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdContactsDAOImpl
	 *
	 */
	public AdContactsDAOImpl() {
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
	 * JPQL Query - findAdContactsByWorkExtn
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByWorkExtn(String workExtn) throws DataAccessException {

		return findAdContactsByWorkExtn(workExtn, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByWorkExtn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByWorkExtn(String workExtn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByWorkExtn", startResult, maxRows, workExtn);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByWorkExtnContaining
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByWorkExtnContaining(String workExtn) throws DataAccessException {

		return findAdContactsByWorkExtnContaining(workExtn, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByWorkExtnContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByWorkExtnContaining(String workExtn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByWorkExtnContaining", startResult, maxRows, workExtn);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByWorkPhone
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByWorkPhone(String workPhone) throws DataAccessException {

		return findAdContactsByWorkPhone(workPhone, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByWorkPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByWorkPhone(String workPhone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByWorkPhone", startResult, maxRows, workPhone);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByCreationDate
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findAdContactsByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByFax
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByFax(String fax) throws DataAccessException {

		return findAdContactsByFax(fax, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByFax
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByFax(String fax, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByFax", startResult, maxRows, fax);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByContactId
	 *
	 */
	@Transactional
	public AdContacts findAdContactsByContactId(Integer contactId) throws DataAccessException {

		return findAdContactsByContactId(contactId, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByContactId
	 *
	 */

	@Transactional
	public AdContacts findAdContactsByContactId(Integer contactId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdContactsByContactId", startResult, maxRows, contactId);
			return (com.f9g4.domain.AdContacts) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdContactsByFaxContaining
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByFaxContaining(String fax) throws DataAccessException {

		return findAdContactsByFaxContaining(fax, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByFaxContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByFaxContaining(String fax, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByFaxContaining", startResult, maxRows, fax);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByLastUpdateBy
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByLastUpdateBy(Integer lastUpdateBy) throws DataAccessException {

		return findAdContactsByLastUpdateBy(lastUpdateBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByLastUpdateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByLastUpdateBy(Integer lastUpdateBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByLastUpdateBy", startResult, maxRows, lastUpdateBy);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByPrimaryKey
	 *
	 */
	@Transactional
	public AdContacts findAdContactsByPrimaryKey(Integer contactId) throws DataAccessException {

		return findAdContactsByPrimaryKey(contactId, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByPrimaryKey
	 *
	 */

	@Transactional
	public AdContacts findAdContactsByPrimaryKey(Integer contactId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdContactsByPrimaryKey", startResult, maxRows, contactId);
			return (com.f9g4.domain.AdContacts) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdContactsByLangCode
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByLangCode(String langCode) throws DataAccessException {

		return findAdContactsByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByLastUpdatedDate
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByLastUpdatedDate(java.util.Calendar lastUpdatedDate) throws DataAccessException {

		return findAdContactsByLastUpdatedDate(lastUpdatedDate, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByLastUpdatedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByLastUpdatedDate(java.util.Calendar lastUpdatedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByLastUpdatedDate", startResult, maxRows, lastUpdatedDate);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByCellphoneContaining
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByCellphoneContaining(String cellphone) throws DataAccessException {

		return findAdContactsByCellphoneContaining(cellphone, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByCellphoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByCellphoneContaining(String cellphone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByCellphoneContaining", startResult, maxRows, cellphone);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByCellphone
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByCellphone(String cellphone) throws DataAccessException {

		return findAdContactsByCellphone(cellphone, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByCellphone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByCellphone(String cellphone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByCellphone", startResult, maxRows, cellphone);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByLangCodeContaining(String langCode) throws DataAccessException {

		return findAdContactsByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAdContactss
	 *
	 */
	@Transactional
	public Set<AdContacts> findAllAdContactss() throws DataAccessException {

		return findAllAdContactss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdContactss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAllAdContactss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdContactss", startResult, maxRows);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByCreatedBy
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByCreatedBy(Integer createdBy) throws DataAccessException {

		return findAdContactsByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdContactsByWorkPhoneContaining
	 *
	 */
	@Transactional
	public Set<AdContacts> findAdContactsByWorkPhoneContaining(String workPhone) throws DataAccessException {

		return findAdContactsByWorkPhoneContaining(workPhone, -1, -1);
	}

	/**
	 * JPQL Query - findAdContactsByWorkPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AdContacts> findAdContactsByWorkPhoneContaining(String workPhone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdContactsByWorkPhoneContaining", startResult, maxRows, workPhone);
		return new LinkedHashSet<AdContacts>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AdContacts entity) {
		return true;
	}
}
