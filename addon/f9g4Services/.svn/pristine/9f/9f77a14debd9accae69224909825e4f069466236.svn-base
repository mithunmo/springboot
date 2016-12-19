package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
	@NamedQuery(name = "findAllTrBroadcastMessages", query = "select myTrBroadcastMessages from TrBroadcastMessages myTrBroadcastMessages"),
	@NamedQuery(name = "findTrBroadcastMessagesByBroadcastId", query = "select myTrBroadcastMessages from TrBroadcastMessages myTrBroadcastMessages where myTrBroadcastMessages.broadcastId=?1"),
	@NamedQuery(name = "findTrBroadcastMessagesByMsgScopeId", query = "select myTrBroadcastMessages from TrBroadcastMessages myTrBroadcastMessages where myTrBroadcastMessages.adLookupValuesByMsgScopeId.lookupValueId=?1"),
	@NamedQuery(name = "findTrBroadcastMessagesByMsgStatusId", query = "select myTrBroadcastMessages from TrBroadcastMessages myTrBroadcastMessages where myTrBroadcastMessages.adLookupValuesByMsgStatusId.lookupValueId=?1")
})


@Table( name = "tr_broadcast_messages")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrBroadcastMessages")
public class TrBroadcastMessages implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "BROADCAST_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer broadcastId;
	/**
	 */

	@Column(name = "TEMPLATE_NAME", length = 45, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String templateName;
	/**
	 */
	
	@Column(name = "SUBJECT", length = 500, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subject;
	/**
	 */

	@Column(name = "MESSAGE_TEXT", length = 4000, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String messageText;
	/**
	 */
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "MSG_SCOPE_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByMsgScopeId;
	/**
	 */
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "MSG_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByMsgStatusId;
	/**
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROCESSED_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar processedDate;
	/**
	 */

	@Column(name = "ERROR_MESSAGE", length = 500, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String errorMessage;
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
	 * Positive, Negative, Neutral
	 * 
	 */

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpdatedBy;
	/**
	 */
	
	public Integer getBroadcastId() {
		return broadcastId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setBroadcastId(Integer broadcastId) {
		this.broadcastId = broadcastId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Calendar getProcessedDate() {
		return processedDate;
	}
	public void setProcessedDate(Calendar processedDate) {
		this.processedDate = processedDate;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Calendar getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Calendar getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public AdLookupValues getAdLookupValuesByMsgScopeId() {
		return adLookupValuesByMsgScopeId;
	}
	public void setAdLookupValuesByMsgScopeId(
			AdLookupValues adLookupValuesByMsgScopeId) {
		this.adLookupValuesByMsgScopeId = adLookupValuesByMsgScopeId;
	}
	public AdLookupValues getAdLookupValuesByMsgStatusId() {
		return adLookupValuesByMsgStatusId;
	}
	public void setAdLookupValuesByMsgStatusId(
			AdLookupValues adLookupValuesByMsgStatusId) {
		this.adLookupValuesByMsgStatusId = adLookupValuesByMsgStatusId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((adLookupValuesByMsgScopeId == null) ? 0
						: adLookupValuesByMsgScopeId.hashCode());
		result = prime
				* result
				+ ((adLookupValuesByMsgStatusId == null) ? 0
						: adLookupValuesByMsgStatusId.hashCode());
		result = prime * result
				+ ((broadcastId == null) ? 0 : broadcastId.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result
				+ ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result
				+ ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
		result = prime * result
				+ ((messageText == null) ? 0 : messageText.hashCode());
		result = prime * result
				+ ((processedDate == null) ? 0 : processedDate.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((templateName == null) ? 0 : templateName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrBroadcastMessages other = (TrBroadcastMessages) obj;
		if (adLookupValuesByMsgScopeId == null) {
			if (other.adLookupValuesByMsgScopeId != null)
				return false;
		} else if (!adLookupValuesByMsgScopeId
				.equals(other.adLookupValuesByMsgScopeId))
			return false;
		if (adLookupValuesByMsgStatusId == null) {
			if (other.adLookupValuesByMsgStatusId != null)
				return false;
		} else if (!adLookupValuesByMsgStatusId
				.equals(other.adLookupValuesByMsgStatusId))
			return false;
		if (broadcastId == null) {
			if (other.broadcastId != null)
				return false;
		} else if (!broadcastId.equals(other.broadcastId))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (lastUpdatedBy == null) {
			if (other.lastUpdatedBy != null)
				return false;
		} else if (!lastUpdatedBy.equals(other.lastUpdatedBy))
			return false;
		if (messageText == null) {
			if (other.messageText != null)
				return false;
		} else if (!messageText.equals(other.messageText))
			return false;
		if (processedDate == null) {
			if (other.processedDate != null)
				return false;
		} else if (!processedDate.equals(other.processedDate))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (templateName == null) {
			if (other.templateName != null)
				return false;
		} else if (!templateName.equals(other.templateName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TrBroadcastMessages [broadcastId=" + broadcastId
				+ ", templateName=" + templateName + ", subject=" + subject
				+ ", messageText=" + messageText
				+ ", adLookupValuesByMsgScopeId=" + adLookupValuesByMsgScopeId
				+ ", adLookupValuesByMsgStatusId="
				+ adLookupValuesByMsgStatusId + ", processedDate="
				+ processedDate + ", errorMessage=" + errorMessage
				+ ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedBy="
				+ lastUpdatedBy + "]";
	}
}
