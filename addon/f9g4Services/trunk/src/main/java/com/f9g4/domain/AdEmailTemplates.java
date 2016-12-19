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
import javax.persistence.NamedNativeQuery;
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
import org.hibernate.annotations.NamedNativeQueries;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAdEmailTemplatesById", query = "select myAdEmailTemplates from AdEmailTemplates myAdEmailTemplates where myAdEmailTemplates.emailTemplateId = ?1"),
		@NamedQuery(name = "findAdEmailTemplatesByTemplateCode", query = "select myAdEmailTemplates from AdEmailTemplates myAdEmailTemplates where myAdEmailTemplates.emailTemplateCode = ?1"),
		@NamedQuery(name = "findAdEmailTemplatesByTemplateCodeContaining", query = "select myAdEmailTemplates from AdEmailTemplates myAdEmailTemplates where myAdEmailTemplates.emailTemplateCode Like ?1")
		 })
@Table( name = "ad_email_templates")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdEmailTemplates")
public class AdEmailTemplates implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Column(name = "EMAIL_TEMPL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer emailTemplateId;
	/**
	 */
	
	@Column(name = "TEMPL_CODE", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String emailTemplateCode;
	/**
	 */
	
	@Column(name = "SUBJECT", length = 255, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subject;
	/**
	 */
	
	@Column(name = "BODY", length = 255, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String body;
	/**
	 */
	
	@Column(name = "SUPPORT_EMAIL", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String supportEmail;
	/**
	 */
	
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
	public Integer getEmailTemplateId() {
		return emailTemplateId;
	}
	public void setEmailTemplateId(Integer emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}
	public String getEmailTemplateCode() {
		return emailTemplateCode;
	}
	public void setEmailTemplateCode(String emailTemplateCode) {
		this.emailTemplateCode = emailTemplateCode;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
	public String getSupportEmail() {
		return supportEmail;
	}
	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime
				* result
				+ ((emailTemplateCode == null) ? 0 : emailTemplateCode
						.hashCode());
		result = prime * result
				+ ((emailTemplateId == null) ? 0 : emailTemplateId.hashCode());
		result = prime * result
				+ ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result
				+ ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((supportEmail == null) ? 0 : supportEmail.hashCode());
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
		AdEmailTemplates other = (AdEmailTemplates) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
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
		if (emailTemplateCode == null) {
			if (other.emailTemplateCode != null)
				return false;
		} else if (!emailTemplateCode.equals(other.emailTemplateCode))
			return false;
		if (emailTemplateId == null) {
			if (other.emailTemplateId != null)
				return false;
		} else if (!emailTemplateId.equals(other.emailTemplateId))
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
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (supportEmail == null) {
			if (other.supportEmail != null)
				return false;
		} else if (!supportEmail.equals(other.supportEmail))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AdEmailTemplates [emailTemplateId=" + emailTemplateId
				+ ", emailTemplateCode=" + emailTemplateCode + ", subject="
				+ subject + ", body=" + body + ", supportEmail=" + supportEmail
				+ ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedBy="
				+ lastUpdatedBy + "]";
	}
}
