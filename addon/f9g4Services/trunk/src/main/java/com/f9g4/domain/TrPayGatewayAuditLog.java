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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTrPayGatewayAuditLog", query = "select myTrPayGatewayAuditLog from TrPayGatewayAuditLog myTrPayGatewayAuditLog"),
		@NamedQuery(name = "findAllTrPayGatewayAuditLogByPayGatewayId", query = "select myTrPayGatewayAuditLog from TrPayGatewayAuditLog myTrPayGatewayAuditLog where myTrPayGatewayAuditLog.payGatewayId = ?1")
		})

@Table( name = "tr_pay_gateway_audit_log")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrPayGatewayAuditLog")
public class TrPayGatewayAuditLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 */
	@Column(name = "PAY_GATEWAY_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)	
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer payGatewayId;
	
	/**
	 */
	@Column(name = "SECURE_TOKEN", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String secureToken;
	
	
	/**
	 */
	@Column(name = "ACK", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String ack;

	/**
	 */
	@Column(name = "CORRELATION_ID", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String correlationId;
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar timestamp;
	
	/**
	 */
	@Column(name = "BUILD", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String buils;
	

	/**
	 */
	@Column(name = "PAY_STATUS", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String payStatus;
	

	/**
	 */
	@Column(name = "PENDING_REASON", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String pendingReason;
	

	/**
	 */
	@Column(name = "TRANSACTION_ID", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String transactionId;
	

	/**
	 */
	@Column(name = "TRANSACTION_STATUS", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String transactionStatus;
	

	/**
	 */
	@Column(name = "SENDER_TRANSACTION_ID", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String senderTransactionId;
	

	/**
	 */
	@Column(name = "SEND_TRX_STATUS", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String snderTransactionStatus;
	

	/**
	 */
	@Column(name = "MEMO", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String memo;
	

	/**
	 */
	@Column(name = "SENDER_EMAIL", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String senderEmail;
	

	

	@Column(name = "ACTION_TYPE", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String actionType;
	
	
	@Column(name = "CANCEL_URL", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String cancelUrl;
	
	
	@Column(name = "RETURN_URL", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String returnUrl;
	
	
	@Column(name = "CURRENCY_CODE", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String currencyCode;
	
	@Column(name = "FEES_PAYER", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String feesPayer;
	
	
	@Column(name = "TRACKING_ID", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String trackingId;


	public Integer getPayGatewayId() {
		return payGatewayId;
	}


	public void setPayGatewayId(Integer payGatewayId) {
		this.payGatewayId = payGatewayId;
	}


	public String getSecureToken() {
		return secureToken;
	}


	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}


	public String getAck() {
		return ack;
	}


	public void setAck(String ack) {
		this.ack = ack;
	}


	public String getCorrelationId() {
		return correlationId;
	}


	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}


	public Calendar getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}


	public String getBuils() {
		return buils;
	}


	public void setBuils(String buils) {
		this.buils = buils;
	}


	public String getPayStatus() {
		return payStatus;
	}


	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}


	public String getPendingReason() {
		return pendingReason;
	}


	public void setPendingReason(String pendingReason) {
		this.pendingReason = pendingReason;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public String getSenderTransactionId() {
		return senderTransactionId;
	}


	public void setSenderTransactionId(String senderTransactionId) {
		this.senderTransactionId = senderTransactionId;
	}


	public String getSnderTransactionStatus() {
		return snderTransactionStatus;
	}


	public void setSnderTransactionStatus(String snderTransactionStatus) {
		this.snderTransactionStatus = snderTransactionStatus;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getSenderEmail() {
		return senderEmail;
	}


	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}


	public String getActionType() {
		return actionType;
	}


	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


	public String getCancelUrl() {
		return cancelUrl;
	}


	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}


	public String getReturnUrl() {
		return returnUrl;
	}


	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public String getFeesPayer() {
		return feesPayer;
	}


	public void setFeesPayer(String feesPayer) {
		this.feesPayer = feesPayer;
	}


	public String getTrackingId() {
		return trackingId;
	}


	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}


	@Override
	public String toString() {
		return "TrPayGatewayAuditLog [payGatewayId=" + payGatewayId
				+ ", secureToken=" + secureToken + ", ack=" + ack
				+ ", correlationId=" + correlationId + ", timestamp="
				+ timestamp + ", buils=" + buils + ", payStatus=" + payStatus
				+ ", pendingReason=" + pendingReason + ", transactionId="
				+ transactionId + ", transactionStatus=" + transactionStatus
				+ ", senderTransactionId=" + senderTransactionId
				+ ", snderTransactionStatus=" + snderTransactionStatus
				+ ", memo=" + memo + ", senderEmail=" + senderEmail
				+ ", actionType=" + actionType + ", cancelUrl=" + cancelUrl
				+ ", returnUrl=" + returnUrl + ", currencyCode=" + currencyCode
				+ ", feesPayer=" + feesPayer + ", trackingId=" + trackingId
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((payGatewayId == null) ? 0 : payGatewayId.hashCode());
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
		TrPayGatewayAuditLog other = (TrPayGatewayAuditLog) obj;
		if (payGatewayId == null) {
			if (other.payGatewayId != null)
				return false;
		} else if (!payGatewayId.equals(other.payGatewayId))
			return false;
		return true;
	}
	
	
}