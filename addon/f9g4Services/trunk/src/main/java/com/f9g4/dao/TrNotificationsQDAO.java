package com.f9g4.dao;

import com.f9g4.domain.TrNotificationsQ;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TrNotificationsQ entities.
 * 
 */
public interface TrNotificationsQDAO extends JpaDao<TrNotificationsQ> {

	/**
	 * JPQL Query - findTrNotificationsQByDeliveryDate
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByDeliveryDate(java.util.Calendar deliveryDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByDeliveryDate
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByDeliveryDate(Calendar deliveryDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByCreationDate
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByCreationDate
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateAfter
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateAfter(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateAfter
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateAfter(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByFromEmail
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmail(String fromEmail) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByFromEmail
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmail(String fromEmail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByBodyTextContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByBodyTextContaining(String bodyText) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByBodyTextContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByBodyTextContaining(String bodyText, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByCreatedBy
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByCreatedBy
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByPrimaryKey
	 *
	 */
	public TrNotificationsQ findTrNotificationsQByPrimaryKey(Integer notificationId) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByPrimaryKey
	 *
	 */
	public TrNotificationsQ findTrNotificationsQByPrimaryKey(Integer notificationId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByToEmail
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByToEmail(String toEmail) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByToEmail
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByToEmail(String toEmail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByFromUserId
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByFromUserId(Integer fromUserId) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByFromUserId
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByFromUserId(Integer fromUserId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTrNotificationsQs
	 *
	 */
	public Set<TrNotificationsQ> findAllTrNotificationsQs() throws DataAccessException;

	/**
	 * JPQL Query - findAllTrNotificationsQs
	 *
	 */
	public Set<TrNotificationsQ> findAllTrNotificationsQs(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByBodyText
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByBodyText(String bodyText_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByBodyText
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByBodyText(String bodyText_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQBySubjectContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQBySubjectContaining(String subject) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQBySubjectContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQBySubjectContaining(String subject, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQBySubject
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQBySubject(String subject_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQBySubject
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQBySubject(String subject_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByNotificationId
	 *
	 */
	public TrNotificationsQ findTrNotificationsQByNotificationId(Integer notificationId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByNotificationId
	 *
	 */
	public TrNotificationsQ findTrNotificationsQByNotificationId(Integer notificationId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByToEmailContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByToEmailContaining(String toEmail_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByToEmailContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByToEmailContaining(String toEmail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByToUserId
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByToUserId(Integer toUserId) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByToUserId
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByToUserId(Integer toUserId, int startResult, int maxRows) throws DataAccessException;

	
	/**
	 * JPQL Query - findTrNotificationsQByStatusid
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByStatusId(Integer statusId) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQBystatusId
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByStatusId(Integer statusId, int startResult, int maxRows) throws DataAccessException;


	
	/**
	 * JPQL Query - findTrNotificationsQByLastUpdatedBy
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdatedBy
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDate
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDate(java.util.Calendar lastUpdateDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDate
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDate(Calendar lastUpdateDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByFromEmailContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmailContaining(String fromEmail_1) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByFromEmailContaining
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByFromEmailContaining(String fromEmail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateBefore
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateBefore(java.util.Calendar lastUpdateDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findTrNotificationsQByLastUpdateDateBefore
	 *
	 */
	public Set<TrNotificationsQ> findTrNotificationsQByLastUpdateDateBefore(Calendar lastUpdateDate_2, int startResult, int maxRows) throws DataAccessException;

}