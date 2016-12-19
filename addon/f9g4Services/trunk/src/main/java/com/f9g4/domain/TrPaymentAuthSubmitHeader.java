package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
		@NamedQuery(name = "findAllTrPaymentAuthSubmitHeaders", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByBatchTrxId", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.batchTrxId = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByCreatedBy", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.createdBy = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByCreationDate", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.creationDate = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByLastUpdateDate", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByLastUpdatedBy", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByPrimaryKey", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.batchTrxId = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByShipping", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.shipping = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderBySubtotal", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.subtotal = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByTax", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.tax = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderBySecureToken", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.secureToken = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitHeaderByTotal", query = "select myTrPaymentAuthSubmitHeader from TrPaymentAuthSubmitHeader myTrPaymentAuthSubmitHeader where myTrPaymentAuthSubmitHeader.total = ?1") })
@Table( name = "tr_payment_auth_submit_header")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrPaymentAuthSubmitHeader")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class TrPaymentAuthSubmitHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BATCH_TRX_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer batchTrxId;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 */

	@Column(name = "SUBTOTAL", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal subtotal;
	/**
	 */

	@Column(name = "SHIPPING", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal shipping;
	/**
	 */

	@Column(name = "TAX", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal tax;
	/**
	 * Total Charge Amount sent to Paypal
	 * 
	 */

	@Column(name = "TOTAL", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal total;
	
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
	@OneToMany(mappedBy = "trPaymentAuthSubmitHeader", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSalesTransactionHeader> trSalesTransactionHeaders;
	/**
	 */
	@OneToMany(mappedBy = "trPaymentAuthSubmitHeader", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrPaymentAuthSubmit> trPaymentAuthSubmits;

	/**
	 */
	public void setBatchTrxId(Integer batchTrxId) {
		this.batchTrxId = batchTrxId;
	}

	/**
	 */
	public Integer getBatchTrxId() {
		return this.batchTrxId;
	}

	/**
	 */
	public AdUsers getAdUsers() {
		return adUsers;
	}

	/**
	 */
	public void setAdUsers(AdUsers adUsers) {
		this.adUsers = adUsers;
	}

	/**
	 */

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 */
	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	/**
	 */
	public void setShipping(BigDecimal shipping) {
		this.shipping = shipping;
	}

	/**
	 */
	public BigDecimal getShipping() {
		return this.shipping;
	}

	/**
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 */
	public BigDecimal getTax() {
		return this.tax;
	}

	/**
	 * Total Charge Amount sent to Paypal
	 * 
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * Total Charge Amount sent to Paypal
	 * 
	 */
	public BigDecimal getTotal() {
		return this.total;
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
	public void setTrSalesTransactionHeaders(Set<TrSalesTransactionHeader> trSalesTransactionHeaders) {
		this.trSalesTransactionHeaders = trSalesTransactionHeaders;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSalesTransactionHeader> getTrSalesTransactionHeaders() {
		if (trSalesTransactionHeaders == null) {
			trSalesTransactionHeaders = new java.util.LinkedHashSet<com.f9g4.domain.TrSalesTransactionHeader>();
		}
		return trSalesTransactionHeaders;
	}

	/**
	 */
	public void setTrPaymentAuthSubmits(Set<TrPaymentAuthSubmit> trPaymentAuthSubmits) {
		this.trPaymentAuthSubmits = trPaymentAuthSubmits;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrPaymentAuthSubmit> getTrPaymentAuthSubmits() {
		if (trPaymentAuthSubmits == null) {
			trPaymentAuthSubmits = new java.util.LinkedHashSet<com.f9g4.domain.TrPaymentAuthSubmit>();
		}
		return trPaymentAuthSubmits;
	}

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}
	
	/**
	 */
	public TrPaymentAuthSubmitHeader() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrPaymentAuthSubmitHeader that) {
		setBatchTrxId(that.getBatchTrxId());
		setSubtotal(that.getSubtotal());
		setShipping(that.getShipping());
		setTax(that.getTax());
		setTotal(that.getTotal());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrSalesTransactionHeaders(new java.util.LinkedHashSet<com.f9g4.domain.TrSalesTransactionHeader>(that.getTrSalesTransactionHeaders()));
		setTrPaymentAuthSubmits(new java.util.LinkedHashSet<com.f9g4.domain.TrPaymentAuthSubmit>(that.getTrPaymentAuthSubmits()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("batchTrxId=[").append(batchTrxId).append("] ");
		buffer.append("subtotal=[").append(subtotal).append("] ");
		buffer.append("shipping=[").append(shipping).append("] ");
		buffer.append("tax=[").append(tax).append("] ");
		buffer.append("total=[").append(total).append("] ");
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
		result = (int) (prime * result + ((batchTrxId == null) ? 0 : batchTrxId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrPaymentAuthSubmitHeader))
			return false;
		TrPaymentAuthSubmitHeader equalCheck = (TrPaymentAuthSubmitHeader) obj;
		if ((batchTrxId == null && equalCheck.batchTrxId != null) || (batchTrxId != null && equalCheck.batchTrxId == null))
			return false;
		if (batchTrxId != null && !batchTrxId.equals(equalCheck.batchTrxId))
			return false;
		return true;
	}
}
