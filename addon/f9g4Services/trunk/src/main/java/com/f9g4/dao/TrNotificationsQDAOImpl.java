package com.f9g4.dao;

import com.f9g4.domain.TrNotificationsQ;

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
 * DAO to manage TrNotificationsQ entities.
 * 
 */
@Repository("TrNotificationsQDAO")
@Transactional
public class TrNotificationsQDAOImpl extends AbstractJpaDao<TrNotificationsQ>
		implements TrNotificationsQDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrNotificationsQ.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrNotificationsQDAOImpl
	 *
	 */
	public TrNotificationsQDAOImpl() {
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
	 * JPQL Query - findTrNotificationsQByDeliveryDate
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByDeliveryDate(java.util.Calendar deliveryDate) throws DataAccessException {

		return findTrNotificationsQByDeliveryDate(deliveryDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByDeliveryDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByDeliveryDate(java.util.Calendar deliveryDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByDeliveryDate", startResult, maxRows, deliveryDate);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByCreationDate
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrNotificationsQByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateAfter
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateAfter(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrNotificationsQByLastUpdateDateAfter(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateAfter(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByLastUpdateDateAfter", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByFromEmail
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmail(String fromEmail) throws DataAccessException {

		return findTrNotificationsQByFromEmail(fromEmail, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByFromEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmail(String fromEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByFromEmail", startResult, maxRows, fromEmail);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByBodyTextContaining
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByBodyTextContaining(String bodyText) throws DataAccessException {

		return findTrNotificationsQByBodyTextContaining(bodyText, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByBodyTextContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByBodyTextContaining(String bodyText, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByBodyTextContaining", startResult, maxRows, bodyText);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrNotificationsQByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByPrimaryKey
	 *
	 */
	@Transactional
	public TrNotificationsQ findTrNotificationsQByPrimaryKey(Integer notificationId) throws DataAccessException {

		return findTrNotificationsQByPrimaryKey(notificationId, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByPrimaryKey
	 *
	 */

	@Transactional
	public TrNotificationsQ findTrNotificationsQByPrimaryKey(Integer notificationId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrNotificationsQByPrimaryKey", startResult, maxRows, notificationId);
			return (com.f9g4.domain.TrNotificationsQ) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrNotificationsQByToEmail
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByToEmail(String toEmail) throws DataAccessException {

		return findTrNotificationsQByToEmail(toEmail, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByToEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByToEmail(String toEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByToEmail", startResult, maxRows, toEmail);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByFromUserId
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByFromUserId(Integer fromUserId) throws DataAccessException {

		return findTrNotificationsQByFromUserId(fromUserId, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByFromUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByFromUserId(Integer fromUserId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByFromUserId", startResult, maxRows, fromUserId);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByMsgStatusContaining
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByMsgStatusContaining(String msgStatus) throws DataAccessException {

		return findTrNotificationsQByMsgStatusContaining(msgStatus, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByMsgStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByMsgStatusContaining(String msgStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByMsgStatusContaining", startResult, maxRows, msgStatus);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTrNotificationsQs
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findAllTrNotificationsQs() throws DataAccessException {

		return findAllTrNotificationsQs(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrNotificationsQs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findAllTrNotificationsQs(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrNotificationsQs", startResult, maxRows);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByBodyText
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByBodyText(String bodyText) throws DataAccessException {

		return findTrNotificationsQByBodyText(bodyText, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByBodyText
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByBodyText(String bodyText, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByBodyText", startResult, maxRows, bodyText);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQBySubjectContaining
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQBySubjectContaining(String subject) throws DataAccessException {

		return findTrNotificationsQBySubjectContaining(subject, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQBySubjectContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQBySubjectContaining(String subject, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQBySubjectContaining", startResult, maxRows, subject);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQBySubject
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQBySubject(String subject) throws DataAccessException {

		return findTrNotificationsQBySubject(subject, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQBySubject
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQBySubject(String subject, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQBySubject", startResult, maxRows, subject);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByNotificationId
	 *
	 */
	@Transactional
	public TrNotificationsQ findTrNotificationsQByNotificationId(Integer notificationId) throws DataAccessException {

		return findTrNotificationsQByNotificationId(notificationId, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByNotificationId
	 *
	 */

	@Transactional
	public TrNotificationsQ findTrNotificationsQByNotificationId(Integer notificationId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrNotificationsQByNotificationId", startResult, maxRows, notificationId);
			return (com.f9g4.domain.TrNotificationsQ) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrNotificationsQByToEmailContaining
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByToEmailContaining(String toEmail) throws DataAccessException {

		return findTrNotificationsQByToEmailContaining(toEmail, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByToEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByToEmailContaining(String toEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByToEmailContaining", startResult, maxRows, toEmail);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}
	
	/**
	 * JPQL Query - findTrNotificationsQByStatusId
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByStatusId(Integer statusId) throws DataAccessException {

		return findTrNotificationsQByStatusId(statusId, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByToUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByStatusId(Integer statusId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByStatusId", startResult, maxRows, statusId);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}



	/**
	 * JPQL Query - findTrNotificationsQByToUserId
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByToUserId(Integer toUserId) throws DataAccessException {

		return findTrNotificationsQByToUserId(toUserId, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByToUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByToUserId(Integer toUserId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByToUserId", startResult, maxRows, toUserId);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}


	/**
	 * JPQL Query - findTrNotificationsQByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrNotificationsQByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrNotificationsQByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByFromEmailContaining
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmailContaining(String fromEmail) throws DataAccessException {

		return findTrNotificationsQByFromEmailContaining(fromEmail, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByFromEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmailContaining(String fromEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByFromEmailContaining", startResult, maxRows, fromEmail);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateBefore
	 *
	 */
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateBefore(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrNotificationsQByLastUpdateDateBefore(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateBefore(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrNotificationsQByLastUpdateDateBefore", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrNotificationsQ>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrNotificationsQ entity) {
		return true;
	}
}
