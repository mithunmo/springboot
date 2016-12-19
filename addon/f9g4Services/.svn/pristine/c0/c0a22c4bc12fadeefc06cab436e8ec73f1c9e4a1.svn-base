package com.f9g4.dao;

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
@Repository("TrReferralsDAO")
@Transactional
public class TrReferralsDAOImpl extends AbstractJpaDao<TrReferrals> implements	TrReferralsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrReferrals.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrReferralsDAOImpl
	 *
	 */
	public TrReferralsDAOImpl() {
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
	 * JPQL Query - findTrReferralsByMessage
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByMessage(String message) throws DataAccessException {

		return findTrReferralsByMessage(message, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByMessage
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByMessage(String message, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByMessage", startResult, maxRows, message);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByLangCode
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByLangCode(String langCode) throws DataAccessException {

		return findTrReferralsByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByAuthCodeContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByAuthCodeContaining(String authCode) throws DataAccessException {

		return findTrReferralsByAuthCodeContaining(authCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByAuthCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByAuthCodeContaining(String authCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByAuthCodeContaining", startResult, maxRows, authCode);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsBySignedupOn
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsBySignedupOn(java.util.Calendar signedupOn) throws DataAccessException {

		return findTrReferralsBySignedupOn(signedupOn, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsBySignedupOn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsBySignedupOn(java.util.Calendar signedupOn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsBySignedupOn", startResult, maxRows, signedupOn);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByWhyReferContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByWhyReferContaining(String whyRefer) throws DataAccessException {

		return findTrReferralsByWhyReferContaining(whyRefer, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByWhyReferContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByWhyReferContaining(String whyRefer, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByWhyReferContaining", startResult, maxRows, whyRefer);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByLastNameContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastNameContaining(String lastName) throws DataAccessException {

		return findTrReferralsByLastNameContaining(lastName, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByLastNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastNameContaining(String lastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByLastNameContaining", startResult, maxRows, lastName);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsBySignedupUserId
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsBySignedupUserId(Integer signedupUserId) throws DataAccessException {

		return findTrReferralsBySignedupUserId(signedupUserId, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsBySignedupUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsBySignedupUserId(Integer signedupUserId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsBySignedupUserId", startResult, maxRows, signedupUserId);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByWhyRefer
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByWhyRefer(String whyRefer) throws DataAccessException {

		return findTrReferralsByWhyRefer(whyRefer, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByWhyRefer
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByWhyRefer(String whyRefer, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByWhyRefer", startResult, maxRows, whyRefer);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastUpdatedBy(java.util.Calendar lastUpdatedBy) throws DataAccessException {

		return findTrReferralsByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastUpdatedBy(java.util.Calendar lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastUpdateDate(Integer lastUpdateDate) throws DataAccessException {

		return findTrReferralsByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastUpdateDate(Integer lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByPrimaryKey
	 *
	 */
	@Transactional
	public TrReferrals findTrReferralsByPrimaryKey(Integer referralId) throws DataAccessException {

		return findTrReferralsByPrimaryKey(referralId, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByPrimaryKey
	 *
	 */

	@Transactional
	public TrReferrals findTrReferralsByPrimaryKey(Integer referralId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrReferralsByPrimaryKey", startResult, maxRows, referralId);
			return (com.f9g4.domain.TrReferrals) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrReferralsByEmailAddress
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByEmailAddress(String emailAddress) throws DataAccessException {

		return findTrReferralsByEmailAddress(emailAddress, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByEmailAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByEmailAddress(String emailAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByEmailAddress", startResult, maxRows, emailAddress);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByMessageContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByMessageContaining(String message) throws DataAccessException {

		return findTrReferralsByMessageContaining(message, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByMessageContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByMessageContaining(String message, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByMessageContaining", startResult, maxRows, message);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByEmailAddressContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByEmailAddressContaining(String emailAddress) throws DataAccessException {

		return findTrReferralsByEmailAddressContaining(emailAddress, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByEmailAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByEmailAddressContaining(String emailAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByEmailAddressContaining", startResult, maxRows, emailAddress);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByFirstNameContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByFirstNameContaining(String firstName) throws DataAccessException {

		return findTrReferralsByFirstNameContaining(firstName, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByFirstNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByFirstNameContaining(String firstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByFirstNameContaining", startResult, maxRows, firstName);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByAuthCode
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByAuthCode(String authCode) throws DataAccessException {

		return findTrReferralsByAuthCode(authCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByAuthCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByAuthCode(String authCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByAuthCode", startResult, maxRows, authCode);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByFirstName
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByFirstName(String firstName) throws DataAccessException {

		return findTrReferralsByFirstName(firstName, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByFirstName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByFirstName(String firstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByFirstName", startResult, maxRows, firstName);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByExpirationDate
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByExpirationDate(java.util.Calendar expirationDate) throws DataAccessException {

		return findTrReferralsByExpirationDate(expirationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByExpirationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByExpirationDate(java.util.Calendar expirationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByExpirationDate", startResult, maxRows, expirationDate);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByReferralId
	 *
	 */
	@Transactional
	public TrReferrals findTrReferralsByReferralId(Integer referralId) throws DataAccessException {

		return findTrReferralsByReferralId(referralId, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByReferralId
	 *
	 */

	@Transactional
	public TrReferrals findTrReferralsByReferralId(Integer referralId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrReferralsByReferralId", startResult, maxRows, referralId);
			return (com.f9g4.domain.TrReferrals) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrReferralsByDateSent
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByDateSent(java.util.Calendar dateSent) throws DataAccessException {

		return findTrReferralsByDateSent(dateSent, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByDateSent
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByDateSent(java.util.Calendar dateSent, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByDateSent", startResult, maxRows, dateSent);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByLastName
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastName(String lastName) throws DataAccessException {

		return findTrReferralsByLastName(lastName, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByLastName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByLastName(String lastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByLastName", startResult, maxRows, lastName);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrReferralsByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<TrReferrals> findTrReferralsByLangCodeContaining(String langCode) throws DataAccessException {

		return findTrReferralsByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrReferralsByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrReferralss
	 *
	 */
	@Transactional
	public Set<TrReferrals> findAllTrReferralss() throws DataAccessException {

		return findAllTrReferralss(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrReferralss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findAllTrReferralss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrReferralss", startResult, maxRows);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrReferrals entity) {
		return true;
	}

	/**
	 * JPQL Query - findTrReferralsByUser
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrReferrals> findTrReferralsByUser(int userId) throws DataAccessException {
		Query query = createNamedQuery("findTrReferralsByUser", -1, -1, userId);
		return new LinkedHashSet<TrReferrals>(query.getResultList());
	}
}
