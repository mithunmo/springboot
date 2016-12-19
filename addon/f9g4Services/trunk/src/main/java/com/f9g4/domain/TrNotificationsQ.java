package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTrNotificationsQs", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ"),
		@NamedQuery(name = "findTrNotificationsQByBodyText", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.bodyText = ?1"),
		@NamedQuery(name = "findTrNotificationsQByBodyTextContaining", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.bodyText like ?1"),
		@NamedQuery(name = "findTrNotificationsQByCreatedBy", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.createdBy = ?1"),
		@NamedQuery(name = "findTrNotificationsQByCreationDate", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.creationDate = ?1"),
		@NamedQuery(name = "findTrNotificationsQByDeliveryDate", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.deliveryDate = ?1"),
		@NamedQuery(name = "findTrNotificationsQByFromEmail", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.fromEmail = ?1"),
		@NamedQuery(name = "findTrNotificationsQByFromEmailContaining", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.fromEmail like ?1"),
		@NamedQuery(name = "findTrNotificationsQByFromUserId", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.fromUserId = ?1"),
		@NamedQuery(name = "findTrNotificationsQByLastUpdateDate", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrNotificationsQByLastUpdateDateAfter", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.lastUpdateDate > ?1"),
		@NamedQuery(name = "findTrNotificationsQByLastUpdateDateBefore", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.lastUpdateDate < ?1"),
		@NamedQuery(name = "findTrNotificationsQByLastUpdatedBy", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrNotificationsQByNotificationId", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.notificationId = ?1"),
		@NamedQuery(name = "findTrNotificationsQByPrimaryKey", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.notificationId = ?1"),
		@NamedQuery(name = "findTrNotificationsQBySubject", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.subject = ?1"),
		@NamedQuery(name = "findTrNotificationsQBySubjectContaining", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.subject like ?1"),
		@NamedQuery(name = "findTrNotificationsQByToEmail", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.toEmail = ?1"),
		@NamedQuery(name = "findTrNotificationsQByToEmailContaining", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.toEmail like ?1"),
		@NamedQuery(name = "findTrNotificationsQByStatusId", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.adLookupValues.lookupValueId = ?1") ,
		@NamedQuery(name = "findTrNotificationsQByToUserId", query = "select myTrNotificationsQ from TrNotificationsQ myTrNotificationsQ where myTrNotificationsQ.toUserId = ?1") })

@Table( name = "tr_notifications_q")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrNotificationsQ")
public class TrNotificationsQ implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "NOTIFICATION_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer notificationId;
	/**
	 */

	@Column(name = "FROM_USER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer fromUserId;
	/**
	 */

	@Column(name = "TO_USER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer toUserId;
	/**
	 */

	@Column(name = "FROM_EMAIL", length = 150, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String fromEmail;
	/**
	 */

	@Column(name = "TO_EMAIL", length = 150, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String toEmail;
	/**
	 */

	@Column(name = "SUBJECT", length = 1000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subject;
	/**
	 */

	@Column(name = "BODY_TEXT", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String bodyText;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELIVERY_DATE")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar deliveryDate;
	/**
	 */

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar creationDate;
	/**
	 */

	@Column(name = "CREATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer createdBy;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastUpdateDate;
	/**
	 */

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpdatedBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "EMAIL_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID") })
	@XmlTransient
	AdLookupValues adLookupValues;

	/**
	 */
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 */
	public Integer getNotificationId() {
		return this.notificationId;
	}

	/**
	 */
	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}

	/**
	 */
	public Integer getFromUserId() {
		return this.fromUserId;
	}

	/**
	 */
	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 */
	public Integer getToUserId() {
		return this.toUserId;
	}

	/**
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 */
	public String getFromEmail() {
		return this.fromEmail;
	}

	/**
	 */
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	/**
	 */
	public String getToEmail() {
		return this.toEmail;
	}

	/**
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 */
	public String getSubject() {
		return this.subject;
	}

	/**
	 */
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	/**
	 */
	public String getBodyText() {
		return this.bodyText;
	}

	/**
	 */
	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 */
	public Calendar getDeliveryDate() {
		return this.deliveryDate;
	}

	/**
	 */
	
	/**
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 */
	public Calendar getCreationDate() {
		return this.creationDate;
	}

	/**
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 */
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	/**
	 */
	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 */
	public Calendar getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	/**
	 */
	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 */
	public Integer getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	/**
	 */
	public void setAdLookupValues(AdLookupValues adLookupValues) {
		this.adLookupValues = adLookupValues;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValues() {
		return adLookupValues;
	}

	/**
	 */
	public TrNotificationsQ() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrNotificationsQ that) {
		setNotificationId(that.getNotificationId());
		setFromUserId(that.getFromUserId());
		setToUserId(that.getToUserId());
		setFromEmail(that.getFromEmail());
		setToEmail(that.getToEmail());
		setSubject(that.getSubject());
		setBodyText(that.getBodyText());
		setDeliveryDate(that.getDeliveryDate());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdLookupValues(that.getAdLookupValues());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("notificationId=[").append(notificationId).append("] ");
		buffer.append("fromUserId=[").append(fromUserId).append("] ");
		buffer.append("toUserId=[").append(toUserId).append("] ");
		buffer.append("fromEmail=[").append(fromEmail).append("] ");
		buffer.append("toEmail=[").append(toEmail).append("] ");
		buffer.append("subject=[").append(subject).append("] ");
		buffer.append("bodyText=[").append(bodyText).append("] ");
		buffer.append("deliveryDate=[").append(deliveryDate).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((notificationId == null) ? 0 : notificationId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrNotificationsQ))
			return false;
		TrNotificationsQ equalCheck = (TrNotificationsQ) obj;
		if ((notificationId == null && equalCheck.notificationId != null) || (notificationId != null && equalCheck.notificationId == null))
			return false;
		if (notificationId != null && !notificationId.equals(equalCheck.notificationId))
			return false;
		return true;
	}
}
