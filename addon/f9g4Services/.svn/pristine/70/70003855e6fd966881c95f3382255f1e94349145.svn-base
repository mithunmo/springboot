package com.f9g4.dao;

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

import com.f9g4.domain.TrMessages;

/**
 * DAO to manage TrMessages entities.
 * 
 */
@Repository("TrMessagesDAO")
@Transactional
public class TrMessagesDAOImpl extends AbstractJpaDao<TrMessages> implements TrMessagesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TrMessages.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_f4g
	 *
	 */
	@PersistenceContext(unitName = "mysql_f4g")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TrMessagesDAOImpl
	 *
	 */
	public TrMessagesDAOImpl() {
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
	 * JPQL Query - findAllTrMessagess
	 *
	 */
	@Transactional
	public Set<TrMessages> findAllTrMessagess() throws DataAccessException {

		return findAllTrMessagess(-1, -1);
	}

	/**
	 * JPQL Query - findAllTrMessagess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findAllTrMessagess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTrMessagess", startResult, maxRows);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByLangCode
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByLangCode(String langCode) throws DataAccessException {

		return findTrMessagesByLangCode(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByLangCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByLangCode", startResult, maxRows, langCode);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByActiveStatus
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByActiveStatus(Integer activeStatus) throws DataAccessException {

		return findTrMessagesByActiveStatus(activeStatus, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByActiveStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByActiveStatus", startResult, maxRows, activeStatus);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByReadOn
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByReadOn(java.util.Calendar readOn) throws DataAccessException {

		return findTrMessagesByReadOn(readOn, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByReadOn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByReadOn(java.util.Calendar readOn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByReadOn", startResult, maxRows, readOn);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByMessageBodyContaining
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageBodyContaining(String messageBody) throws DataAccessException {

		return findTrMessagesByMessageBodyContaining(messageBody, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByMessageBodyContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageBodyContaining(String messageBody, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByMessageBodyContaining", startResult, maxRows, messageBody);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByLastUpdatedBy
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException {

		return findTrMessagesByLastUpdatedBy(lastUpdatedBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByLastUpdatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByLastUpdatedBy", startResult, maxRows, lastUpdatedBy);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesBySubject
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesBySubject(String subject) throws DataAccessException {

		return findTrMessagesBySubject(subject, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesBySubject
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesBySubject(String subject, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesBySubject", startResult, maxRows, subject);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByCreatedBy
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByCreatedBy(Integer createdBy) throws DataAccessException {

		return findTrMessagesByCreatedBy(createdBy, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByCreatedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByCreatedBy", startResult, maxRows, createdBy);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByMessageId
	 *
	 */
	@Transactional
	public TrMessages findTrMessagesByMessageId(Integer messageId) throws DataAccessException {

		return findTrMessagesByMessageId(messageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByMessageId
	 *
	 */

	@Transactional
	public TrMessages findTrMessagesByMessageId(Integer messageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrMessagesByMessageId", startResult, maxRows, messageId);
			return (com.f9g4.domain.TrMessages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrMessagesByPrimaryKey
	 *
	 */
	@Transactional
	public TrMessages findTrMessagesByPrimaryKey(Integer messageId) throws DataAccessException {

		return findTrMessagesByPrimaryKey(messageId, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByPrimaryKey
	 *
	 */

	@Transactional
	public TrMessages findTrMessagesByPrimaryKey(Integer messageId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTrMessagesByPrimaryKey", startResult, maxRows, messageId);
			return (com.f9g4.domain.TrMessages) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTrMessagesByCreationDate
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByCreationDate(java.util.Calendar creationDate) throws DataAccessException {

		return findTrMessagesByCreationDate(creationDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByCreationDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByCreationDate(java.util.Calendar creationDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByCreationDate", startResult, maxRows, creationDate);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByLastUpdateDate
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException {

		return findTrMessagesByLastUpdateDate(lastUpdateDate, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByLastUpdateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByLastUpdateDate(java.util.Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByLastUpdateDate", startResult, maxRows, lastUpdateDate);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesBySubjectContaining
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesBySubjectContaining(String subject) throws DataAccessException {

		return findTrMessagesBySubjectContaining(subject, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesBySubjectContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesBySubjectContaining(String subject, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesBySubjectContaining", startResult, maxRows, subject);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByLangCodeContaining
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByLangCodeContaining(String langCode) throws DataAccessException {

		return findTrMessagesByLangCodeContaining(langCode, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByLangCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByLangCodeContaining(String langCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByLangCodeContaining", startResult, maxRows, langCode);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByMessageType
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageType(String messageType) throws DataAccessException {

		return findTrMessagesByMessageType(messageType, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByMessageType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageType(String messageType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByMessageType", startResult, maxRows, messageType);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByMessageTypeContaining
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageTypeContaining(String messageType) throws DataAccessException {

		return findTrMessagesByMessageTypeContaining(messageType, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByMessageTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageTypeContaining(String messageType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByMessageTypeContaining", startResult, maxRows, messageType);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByMessageBody
	 *
	 */
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageBody(String messageBody) throws DataAccessException {

		return findTrMessagesByMessageBody(messageBody, -1, -1);
	}

	/**
	 * JPQL Query - findTrMessagesByMessageBody
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByMessageBody(String messageBody, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByMessageBody", startResult, maxRows, messageBody);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}
	
	/**
	 * JPQL Query - findTrMessagesByUserAndMessageType
	 *
	 */
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByUserAndMessageType(Integer userId, String messageType) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByUserAndMessageType", -1, -1, userId, messageType);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	/**
	 * JPQL Query - findTrMessagesByUserMessageTypeAndMessageStatus
	 *
	 */
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TrMessages> findTrMessagesByUserMessageTypeAndMessageStatus(Integer userId, String messageType, String messageStatus) throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByUserMessageTypeAndMessageStatus", -1, -1, userId, messageType, messageStatus);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public Long findTrMessagesCountByUserMessageTypeAndMessageStatus(Integer userId, String messageType, String messageStatus)throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesCountByUserMessageTypeAndMessageStatus", -1, -1, userId, messageType, messageStatus);
		return (Long) query.getSingleResult();
	}

	
	
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(TrMessages entity) {
		return true;
	}

	public Set<TrMessages> findTrMessagesByBoardUserMessageTypeAndMessageStatus(
			Integer boardid, Integer duserId,Integer cuserid, String messageType)
			throws DataAccessException {
		Query query = createNamedQuery("findTrMessagesByBoardUserMessageTypeAndMessageStatus", -1, -1, boardid,duserId,cuserid, messageType);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}

	//findLastestBoardDesignerMessagesbyUserID
	public Set<TrMessages> findLastestBoardDesignerMessagesbyUserID(
			 Integer userId, String messageType)
			throws DataAccessException {
		Query query = createNamedQuery("findLastestBoardDesignerMessagesbyUserID", -1, -1, userId, messageType);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}
	
	public Set<TrMessages> findLastestBoardCompanyMessagesbyUserID(
			 Integer userId, String messageType)
			throws DataAccessException {
		Query query = createNamedQuery("findLastestBoardCompanyMessagesbyUserID", -1, -1, userId, messageType);
		return new LinkedHashSet<TrMessages>(query.getResultList());
	}
	
}
