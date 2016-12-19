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
import javax.persistence.OneToOne;
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
		@NamedQuery(name = "findAllTrMessagess", query = "select myTrMessages from TrMessages myTrMessages"),
		@NamedQuery(name = "findTrMessagesByActiveStatus", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.activeStatus = ?1"),
		@NamedQuery(name = "findTrMessagesByCreatedBy", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.createdBy = ?1"),
		@NamedQuery(name = "findTrMessagesByCreationDate", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.creationDate = ?1"),
		@NamedQuery(name = "findTrMessagesByLangCode", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.langCode = ?1"),
		@NamedQuery(name = "findTrMessagesByLangCodeContaining", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.langCode like ?1"),
		@NamedQuery(name = "findTrMessagesByLastUpdateDate", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrMessagesByLastUpdatedBy", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrMessagesByMessageBody", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.messageBody = ?1"),
		@NamedQuery(name = "findTrMessagesByMessageBodyContaining", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.messageBody like ?1"),
		@NamedQuery(name = "findTrMessagesByMessageId", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.messageId = ?1"),
		@NamedQuery(name = "findTrMessagesByMessageType", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.messageType = ?1"),
		@NamedQuery(name = "findTrMessagesByMessageTypeContaining", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.messageType like ?1"),
		@NamedQuery(name = "findTrMessagesByPrimaryKey", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.messageId = ?1"),
		@NamedQuery(name = "findTrMessagesByReadOn", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.readOn = ?1"),
		@NamedQuery(name = "findTrMessagesBySubject", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.subject = ?1"),
		@NamedQuery(name = "findTrMessagesByUserAndMessageType", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.adUsersByToUserId.userId= ?1 and myTrMessages.messageType = ?2 and myTrMessages.activeStatus = 1 order by myTrMessages.creationDate desc"),
		@NamedQuery(name = "findTrMessagesByUserMessageTypeAndMessageStatus", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.adUsersByToUserId.userId= ?1 and myTrMessages.messageType = ?2 and myTrMessages.adLookupValues.lookupCode = ?3 and myTrMessages.activeStatus = 1 order by myTrMessages.creationDate desc"),
		@NamedQuery(name = "findTrMessagesCountByUserMessageTypeAndMessageStatus", query = "select count(*) as count from TrMessages myTrMessages where myTrMessages.adUsersByToUserId.userId= ?1 and myTrMessages.messageType = ?2 and myTrMessages.adLookupValues.lookupCode = ?3 and myTrMessages.activeStatus = 1 order by myTrMessages.creationDate desc"),
		@NamedQuery(name = "findTrMessagesByBoardUserMessageTypeAndMessageStatus", query = "select tm from TrMessages tm where tm.trBoard.boardId = ?1 and tm.messageType = ?4 and ((tm.adUsersByToUserId.userId =?2 or adUsersByToUserId.userId =?3)and (tm.adUsersByFromUserId.userId=?2 or tm.adUsersByFromUserId.userId=?3)) order by tm.lastUpdateDate desc" ),
		@NamedQuery(name = "findLastestBoardDesignerMessagesbyUserID", query = "select myTrMessage from TrMessages myTrMessage " +
										"where myTrMessage.creationDate in " +
											" (select max(tm2.creationDate) from TrMessages tm2 " +
											" where myTrMessage.trBoard.boardId = tm2.trBoard.boardId and (tm2.adUsersByFromUserId.userId !=?1 ) " +
											//" and (myTrMessage.trBoard.adLookupValuesStatusId.lookupValueId = 470 " +
											//	" or (myTrMessage.trBoard.adLookupValuesStatusId.lookupValueId = 471 and myTrMessage.trBoard.adUsersByOriginalUserId.userId=?1 and tm2.adUsersByFromUserId.userId=myTrMessage.trBoard.adUsersByCurrentUserId.userId)) " +
											" and  tm2.messageType = ?2 " +
											" group by tm2.adUsersByFromUserId.userId,tm2.trBoard.boardId) " +
										" and myTrMessage.messageType = ?2 " +
										" and (myTrMessage.adUsersByToUserId.userId=?1 or myTrMessage.adUsersByFromUserId.userId=?1) " +
										" and myTrMessage.trBoard.activeStatus = 1 " +
										" and myTrMessage.activeStatus = 1 " + //Show the message only if it's active.
										" order by myTrMessage.creationDate desc "),
										
		@NamedQuery(name = "findLastestBoardCompanyMessagesbyUserID", query = "select myTrMessage from TrMessages myTrMessage " +
										"where myTrMessage.creationDate in " +
											" (select max(tm2.creationDate) from TrMessages tm2 " +
											" where (tm2.adUsersByFromUserId.userId=?1 or tm2.adUsersByToUserId.userId=?1) " +
											" and  tm2.messageType = ?2 " +
											" group by tm2.trBoard.boardId) " +
										" and myTrMessage.messageType = ?2 " +
										" and (myTrMessage.adUsersByToUserId.userId=?1 or myTrMessage.adUsersByFromUserId.userId=?1) " +
										//" and (myTrMessage.trBoard.adLookupValuesStatusId.lookupValueId = 470 " +
										//	" or (myTrMessage.trBoard.adLookupValuesStatusId.lookupValueId = 471 and myTrMessage.trBoard.adUsersByCurrentUserId.userId=?1 )) " +
										" and myTrMessage.trBoard.activeStatus = 1 " +
										" and myTrMessage.activeStatus = 1 " + //Show the message only if it's active.
										" group by myTrMessage.trBoard.boardId" + //Group by board id
										" order by myTrMessage.creationDate desc "),
		@NamedQuery(name = "findTrMessagesBySubjectContaining", query = "select myTrMessages from TrMessages myTrMessages where myTrMessages.subject like ?1") })

@Table( name = "tr_messages")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrMessages")
public class TrMessages implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "MESSAGE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	Integer messageId;
	/**
	 */

	@Column(name = "SUBJECT", length = 1000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subject;
	/**
	 */

	@Column(name = "MESSAGE_BODY", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String messageBody;
	/**
	 * ALERT or INBOX
	 * 
	 */

	@Column(name = "MESSAGE_TYPE", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String messageType;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "READ_ON")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar readOn;
	/**
	 */

	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;
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
	@Temporal(TemporalType.TIMESTAMP)
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "TO_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsersByToUserId;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "MSG_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValues;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard trBoard;
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "FROM_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsersByFromUserId;

	/**
	 */
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	/**
	 */
	public Integer getMessageId() {
		return this.messageId;
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
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	/**
	 */
	public String getMessageBody() {
		return this.messageBody;
	}

	/**
	 * ALERT or INBOX
	 * 
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * ALERT or INBOX
	 * 
	 */
	public String getMessageType() {
		return this.messageType;
	}

	/**
	 */
	public void setReadOn(Calendar readOn) {
		this.readOn = readOn;
	}

	/**
	 */
	public Calendar getReadOn() {
		return this.readOn;
	}

	/**
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 */
	public Integer getActiveStatus() {
		return this.activeStatus;
	}

	/**
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 */
	public String getLangCode() {
		return this.langCode;
	}

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
	public void setAdUsersByToUserId(AdUsers adUsersByToUserId) {
		this.adUsersByToUserId = adUsersByToUserId;
	}

	/**
	 */
	@JsonIgnore
	public AdUsers getAdUsersByToUserId() {
		return adUsersByToUserId;
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
	public void setTrBoard(TrBoard trBoard) {
		this.trBoard = trBoard;
	}

	/**
	 */
	@JsonIgnore
	public TrBoard getTrBoard() {
		return trBoard;
	}

	/**
	 */
	public void setAdUsersByFromUserId(AdUsers adUsersByFromUserId) {
		this.adUsersByFromUserId = adUsersByFromUserId;
	}

	/**
	 */
	@JsonIgnore
	public AdUsers getAdUsersByFromUserId() {
		return adUsersByFromUserId;
	}

	/**
	 */
	public TrMessages() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrMessages that) {
		setMessageId(that.getMessageId());
		setSubject(that.getSubject());
		setMessageBody(that.getMessageBody());
		setMessageType(that.getMessageType());
		setReadOn(that.getReadOn());
		setActiveStatus(that.getActiveStatus());
		setLangCode(that.getLangCode());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdUsersByToUserId(that.getAdUsersByToUserId());
		setAdLookupValues(that.getAdLookupValues());
		setTrBoard(that.getTrBoard());
		setAdUsersByFromUserId(that.getAdUsersByFromUserId());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("messageId=[").append(messageId).append("] ");
		buffer.append("subject=[").append(subject).append("] ");
		buffer.append("messageBody=[").append(messageBody).append("] ");
		buffer.append("messageType=[").append(messageType).append("] ");
		buffer.append("readOn=[").append(readOn).append("] ");
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");
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
		result = (int) (prime * result + ((messageId == null) ? 0 : messageId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrMessages))
			return false;
		TrMessages equalCheck = (TrMessages) obj;
		if ((messageId == null && equalCheck.messageId != null) || (messageId != null && equalCheck.messageId == null))
			return false;
		if (messageId != null && !messageId.equals(equalCheck.messageId))
			return false;
		return true;
	}
}
