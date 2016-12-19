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
		@NamedQuery(name = "findAllTrSalesTransactionDetailss", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByComments", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.comments = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByCommentsContaining", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.comments like ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByCommission", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.commission = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByCreatedBy", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.createdBy = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByCreationDate", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.creationDate = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByLastUpdateDate", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByLastUpdatedBy", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByPaymentStatusId", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.adLookupValuesByDesignerPaymentStatusId.lookupValueId = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsByPrimaryKey", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.salesTrxDetailId = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsBySalesTrxDetailId", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.salesTrxDetailId = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsBySellerPayDate", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.sellerPayDate = ?1"),
		@NamedQuery(name = "findTrSalesTransactionDetailsBySellerShare", query = "select myTrSalesTransactionDetails from TrSalesTransactionDetails myTrSalesTransactionDetails where myTrSalesTransactionDetails.sellerShare = ?1") })
@Table( name = "tr_sales_transaction_details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrSalesTransactionDetails")
public class TrSalesTransactionDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SALES_TRX_DETAIL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer salesTrxDetailId;
	/**
	 */

	@Column(name = "SELLER_SHARE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal sellerShare;
	/**
	 */

	@Column(name = "COMMISSION", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal commission;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SELLER_PAY_DATE")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar sellerPayDate;
	/**
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "DESIGNER_PAYMENT_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByDesignerPaymentStatusId;
	/**
	 */

	@Column(name = "COMMENTS", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String comments;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer lastUpdatedBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard trBoard;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "SALES_TRX_ID", referencedColumnName = "SALES_TRX_ID", nullable = false) })
	@XmlTransient
	TrSalesTransactionHeader trSalesTransactionHeader;

	/**
	 */
	public void setSalesTrxDetailId(Integer salesTrxDetailId) {
		this.salesTrxDetailId = salesTrxDetailId;
	}

	/**
	 */
	public Integer getSalesTrxDetailId() {
		return this.salesTrxDetailId;
	}

	/**
	 */
	public void setSellerShare(BigDecimal sellerShare) {
		this.sellerShare = sellerShare;
	}

	/**
	 */
	public BigDecimal getSellerShare() {
		return this.sellerShare;
	}

	/**
	 */
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	/**
	 */
	public BigDecimal getCommission() {
		return this.commission;
	}

	/**
	 */
	public void setSellerPayDate(Calendar sellerPayDate) {
		this.sellerPayDate = sellerPayDate;
	}

	/**
	 */
	public Calendar getSellerPayDate() {
		return this.sellerPayDate;
	}

	/**
	 */
	public void setDesignerPaymentStatusId(AdLookupValues paymentStatusId) {
		this.adLookupValuesByDesignerPaymentStatusId = paymentStatusId;
	}

	/**
	 */
	public AdLookupValues getDesignerPaymentStatusId() {
		return this.adLookupValuesByDesignerPaymentStatusId;
	}

	/**
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 */
	public String getComments() {
		return this.comments;
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
	public void setAdUsers(AdUsers adUsers) {
		this.adUsers = adUsers;
	}

	/**
	 */
	@JsonIgnore
	public AdUsers getAdUsers() {
		return adUsers;
	}

	/**
	 */
	public void setTrSalesTransactionHeader(TrSalesTransactionHeader trSalesTransactionHeader) {
		this.trSalesTransactionHeader = trSalesTransactionHeader;
	}

	/**
	 */
	@JsonIgnore
	public TrSalesTransactionHeader getTrSalesTransactionHeader() {
		return trSalesTransactionHeader;
	}

	/**
	 */
	public TrSalesTransactionDetails() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrSalesTransactionDetails that) {
		setSalesTrxDetailId(that.getSalesTrxDetailId());
		setSellerShare(that.getSellerShare());
		setCommission(that.getCommission());
		setSellerPayDate(that.getSellerPayDate());
		setDesignerPaymentStatusId(that.getDesignerPaymentStatusId());
		setComments(that.getComments());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrBoard(that.getTrBoard());
		setAdUsers(that.getAdUsers());
		setTrSalesTransactionHeader(that.getTrSalesTransactionHeader());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("salesTrxDetailId=[").append(salesTrxDetailId).append("] ");
		buffer.append("sellerShare=[").append(sellerShare).append("] ");
		buffer.append("commission=[").append(commission).append("] ");
		buffer.append("sellerPayDate=[").append(sellerPayDate).append("] ");
		buffer.append("paymentStatusId=[").append(this.getDesignerPaymentStatusId()).append("] ");
		buffer.append("comments=[").append(comments).append("] ");
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
		result = (int) (prime * result + ((salesTrxDetailId == null) ? 0 : salesTrxDetailId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrSalesTransactionDetails))
			return false;
		TrSalesTransactionDetails equalCheck = (TrSalesTransactionDetails) obj;
		if ((salesTrxDetailId == null && equalCheck.salesTrxDetailId != null) || (salesTrxDetailId != null && equalCheck.salesTrxDetailId == null))
			return false;
		if (salesTrxDetailId != null && !salesTrxDetailId.equals(equalCheck.salesTrxDetailId))
			return false;
		return true;
	}
}
