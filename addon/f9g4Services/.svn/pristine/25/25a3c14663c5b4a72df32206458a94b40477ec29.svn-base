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
		@NamedQuery(name = "findAllTrReceiveMembershipPaymentss", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByAuthStatusId", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.adLookupValuesByAuthStatusId.lookupValueId = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByAuthcode", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.authcode = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByAuthcodeContaining", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.authcode like ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByCreatedBy", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.createdBy = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByCreatedByContaining", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.createdBy like ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByCreationDate", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.creationDate = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByLastUpdateDate", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByLastUpdatedBy", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByMemPaymentId", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.memPaymentId = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByPaymentAmount", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.paymentAmount = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByPaymentError", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.paymentError = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByPaymentErrorContaining", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.paymentError like ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByPrimaryKey", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.memPaymentId = ?1"),
		@NamedQuery(name = "findTrReceiveMembershipPaymentsByReceivedTimestamp", query = "select myTrReceiveMembershipPayments from TrReceiveMembershipPayments myTrReceiveMembershipPayments where myTrReceiveMembershipPayments.receivedTimestamp = ?1") })
@Table( name = "tr_receive_membership_payments")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrReceiveMembershipPayments")
public class TrReceiveMembershipPayments implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "MEM_PAYMENT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer memPaymentId;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECEIVED_TIMESTAMP", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar receivedTimestamp;
	/**
	 */

	@Column(name = "PAYMENT_AMOUNT", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal paymentAmount;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "AUTH_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByAuthStatusId;

	/**
	 */

	@Column(name = "AUTHCODE", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authcode;
	/**
	 */

	@Column(name = "PAYMENT_ERROR", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paymentError;
	
	/**
	 */	
	@Column(name = "SECURE_TOKEN", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String secureToken;

	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar creationDate;
	
	/**
	 */

	@Column(name = "CREATED_BY", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String createdBy;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PAYMENT_TRANSMISSION_ID", referencedColumnName = "MEM_AUTH_SUBMIT_ID", nullable = false) })
	@XmlTransient
	TrMembershipAuthSubmit trMembershipAuthSubmit;

	/**
	 */
	public void setMemPaymentId(Integer memPaymentId) {
		this.memPaymentId = memPaymentId;
	}

	/**
	 */
	public Integer getMemPaymentId() {
		return this.memPaymentId;
	}

	/**
	 */
	public void setReceivedTimestamp(Calendar receivedTimestamp) {
		this.receivedTimestamp = receivedTimestamp;
	}

	/**
	 */
	public Calendar getReceivedTimestamp() {
		return this.receivedTimestamp;
	}

	/**
	 */
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 */
	public BigDecimal getPaymentAmount() {
		return this.paymentAmount;
	}

	/**
	 */
	public void setAdLookupValuesByAuthStatusId(AdLookupValues adLookupValuesByAuthStatusId) {
		this.adLookupValuesByAuthStatusId = adLookupValuesByAuthStatusId;
	}

	/**
	 */
	public AdLookupValues getAdLookupValuesByAuthStatusId() {
		return this.adLookupValuesByAuthStatusId;
	}

	/**
	 */
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	/**
	 */
	public String getAuthcode() {
		return this.authcode;
	}

	/**
	 */
	public void setPaymentError(String paymentError) {
		this.paymentError = paymentError;
	}

	/**
	 */
	public String getPaymentError() {
		return this.paymentError;
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
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 */
	public String getCreatedBy() {
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
	public void setTrMembershipAuthSubmit(TrMembershipAuthSubmit trMembershipAuthSubmit) {
		this.trMembershipAuthSubmit = trMembershipAuthSubmit;
	}

	/**
	 */
	@JsonIgnore
	public TrMembershipAuthSubmit getTrMembershipAuthSubmit() {
		return trMembershipAuthSubmit;
	}

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}

	/**
	 */
	public TrReceiveMembershipPayments() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrReceiveMembershipPayments that) {
		setMemPaymentId(that.getMemPaymentId());
		setReceivedTimestamp(that.getReceivedTimestamp());
		setPaymentAmount(that.getPaymentAmount());
		setAdLookupValuesByAuthStatusId(that.getAdLookupValuesByAuthStatusId());
		setAuthcode(that.getAuthcode());
		setPaymentError(that.getPaymentError());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrMembershipAuthSubmit(that.getTrMembershipAuthSubmit());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("memPaymentId=[").append(memPaymentId).append("] ");
		buffer.append("receivedTimestamp=[").append(receivedTimestamp).append("] ");
		buffer.append("paymentAmount=[").append(paymentAmount).append("] ");
		buffer.append("authStatusId=[").append(adLookupValuesByAuthStatusId).append("] ");
		buffer.append("authcode=[").append(authcode).append("] ");
		buffer.append("paymentError=[").append(paymentError).append("] ");
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
		result = (int) (prime * result + ((memPaymentId == null) ? 0 : memPaymentId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrReceiveMembershipPayments))
			return false;
		TrReceiveMembershipPayments equalCheck = (TrReceiveMembershipPayments) obj;
		if ((memPaymentId == null && equalCheck.memPaymentId != null) || (memPaymentId != null && equalCheck.memPaymentId == null))
			return false;
		if (memPaymentId != null && !memPaymentId.equals(equalCheck.memPaymentId))
			return false;
		return true;
	}
}
