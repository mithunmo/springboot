package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTrSalesTransactionHeaders", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByCreatedBy", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.createdBy = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByCreationDate", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.creationDate = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByLastUpdateDate", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByLastUpdatedBy", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPaymentAuthCode", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.paymentAuthCode = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPaymentAuthCodeContaining", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.paymentAuthCode like ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPaymentErrorMsg", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.paymentErrorMsg = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPaymentErrorMsgContaining", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.paymentErrorMsg like ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPaymentStatusId", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.adLookupValuesByPaymentStatusId.lookupValueId = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPaymentTimestamp", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.paymentTimestamp = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderByPrimaryKey", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.salesTrxId = ?1"),
		@NamedQuery(name = "findTrSalesTransactionHeaderBySalesTrxId", query = "select myTrSalesTransactionHeader from TrSalesTransactionHeader myTrSalesTransactionHeader where myTrSalesTransactionHeader.salesTrxId = ?1") })
@Table( name = "tr_sales_transaction_header")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrSalesTransactionHeader")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class TrSalesTransactionHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "SALES_TRX_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer salesTrxId;
	/**
	 */

	@Column(name = "PAYMENT_AUTH_CODE", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paymentAuthCode;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PAYMENT_TIMESTAMP", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar paymentTimestamp;
	
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PAYMENT_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByPaymentStatusId;

	/**
	 */

	@Column(name = "PAYMENT_ERROR_MSG", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paymentErrorMsg;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BATCH_TRX_ID", referencedColumnName = "BATCH_TRX_ID", nullable = false) })
	@XmlTransient
	TrPaymentAuthSubmitHeader trPaymentAuthSubmitHeader;
	/**
	 */
	@OneToMany(mappedBy = "trSalesTransactionHeader", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSalesTransactionDetails> trSalesTransactionDetailses;

	/**
	 */
	public void setSalesTrxId(Integer salesTrxId) {
		this.salesTrxId = salesTrxId;
	}

	/**
	 */
	public Integer getSalesTrxId() {
		return this.salesTrxId;
	}

	/**
	 */
	public void setPaymentAuthCode(String paymentAuthCode) {
		this.paymentAuthCode = paymentAuthCode;
	}

	/**
	 */
	public String getPaymentAuthCode() {
		return this.paymentAuthCode;
	}

	/**
	 */
	public void setPaymentTimestamp(Calendar paymentTimestamp) {
		this.paymentTimestamp = paymentTimestamp;
	}

	/**
	 */
	public Calendar getPaymentTimestamp() {
		return this.paymentTimestamp;
	}

	/**
	 */
	public void setAdLookupValuesByPaymentStatusId(AdLookupValues adLookupValuesByPaymentStatusId) {
		this.adLookupValuesByPaymentStatusId = adLookupValuesByPaymentStatusId;
	}

	/**
	 */
	public AdLookupValues getAdLookupValuesByPaymentStatusId() {
		return this.adLookupValuesByPaymentStatusId;
	}

	/**
	 */
	public void setPaymentErrorMsg(String paymentErrorMsg) {
		this.paymentErrorMsg = paymentErrorMsg;
	}

	/**
	 */
	public String getPaymentErrorMsg() {
		return this.paymentErrorMsg;
	}

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
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
	public void setTrPaymentAuthSubmitHeader(TrPaymentAuthSubmitHeader trPaymentAuthSubmitHeader) {
		this.trPaymentAuthSubmitHeader = trPaymentAuthSubmitHeader;
	}

	/**
	 */
	@JsonIgnore
	public TrPaymentAuthSubmitHeader getTrPaymentAuthSubmitHeader() {
		return trPaymentAuthSubmitHeader;
	}

	/**
	 */
	public void setTrSalesTransactionDetailses(Set<TrSalesTransactionDetails> trSalesTransactionDetailses) {
		this.trSalesTransactionDetailses = trSalesTransactionDetailses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSalesTransactionDetails> getTrSalesTransactionDetailses() {
		if (trSalesTransactionDetailses == null) {
			trSalesTransactionDetailses = new java.util.LinkedHashSet<com.f9g4.domain.TrSalesTransactionDetails>();
		}
		return trSalesTransactionDetailses;
	}

	/**
	 */
	public TrSalesTransactionHeader() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrSalesTransactionHeader that) {
		setSalesTrxId(that.getSalesTrxId());
		setPaymentAuthCode(that.getPaymentAuthCode());
		setPaymentTimestamp(that.getPaymentTimestamp());
		setAdLookupValuesByPaymentStatusId(that.getAdLookupValuesByPaymentStatusId());
		setPaymentErrorMsg(that.getPaymentErrorMsg());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrPaymentAuthSubmitHeader(that.getTrPaymentAuthSubmitHeader());
		setTrSalesTransactionDetailses(new java.util.LinkedHashSet<com.f9g4.domain.TrSalesTransactionDetails>(that.getTrSalesTransactionDetailses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("salesTrxId=[").append(salesTrxId).append("] ");
		buffer.append("paymentAuthCode=[").append(paymentAuthCode).append("] ");
		buffer.append("paymentTimestamp=[").append(paymentTimestamp).append("] ");
		buffer.append("paymentStatusId=[").append(adLookupValuesByPaymentStatusId).append("] ");
		buffer.append("paymentErrorMsg=[").append(paymentErrorMsg).append("] ");
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
		result = (int) (prime * result + ((salesTrxId == null) ? 0 : salesTrxId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrSalesTransactionHeader))
			return false;
		TrSalesTransactionHeader equalCheck = (TrSalesTransactionHeader) obj;
		if ((salesTrxId == null && equalCheck.salesTrxId != null) || (salesTrxId != null && equalCheck.salesTrxId == null))
			return false;
		if (salesTrxId != null && !salesTrxId.equals(equalCheck.salesTrxId))
			return false;
		return true;
	}
}