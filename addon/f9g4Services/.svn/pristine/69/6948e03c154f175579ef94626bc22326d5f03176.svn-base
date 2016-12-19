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
		@NamedQuery(name = "findAllTrPaymentAuthSubmits", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByAuthSubmitId", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.authSubmitId = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByCreatedBy", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.createdBy = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByCreationDate", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.creationDate = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByLastUpdateDate", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByLastUpdatedBy", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByPrice", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.price = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitByPrimaryKey", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.authSubmitId = ?1"),
		@NamedQuery(name = "findTrPaymentAuthSubmitBySecureToken", query = "select myTrPaymentAuthSubmit from TrPaymentAuthSubmit myTrPaymentAuthSubmit where myTrPaymentAuthSubmit.secureToken = ?1") })
@Table( name = "tr_payment_auth_submit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrPaymentAuthSubmit")
public class TrPaymentAuthSubmit implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "AUTH_SUBMIT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer authSubmitId;
	/**
	 */

	@Column(name = "PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal price;
	
	@Column(name = "SECURE_TOKEN", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String secureToken;

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}

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
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard trBoard;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BATCH_TRX_ID", referencedColumnName = "BATCH_TRX_ID", nullable = false) })
	@XmlTransient
	TrPaymentAuthSubmitHeader trPaymentAuthSubmitHeader;

	/**
	 */
	public void setAuthSubmitId(Integer authSubmitId) {
		this.authSubmitId = authSubmitId;
	}

	/**
	 */
	public Integer getAuthSubmitId() {
		return this.authSubmitId;
	}

	/**
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 */
	public BigDecimal getPrice() {
		return this.price;
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
	public TrPaymentAuthSubmit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrPaymentAuthSubmit that) {
		setAuthSubmitId(that.getAuthSubmitId());
		setPrice(that.getPrice());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrBoard(that.getTrBoard());
		setAdUsers(that.getAdUsers());
		setTrPaymentAuthSubmitHeader(that.getTrPaymentAuthSubmitHeader());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("authSubmitId=[").append(authSubmitId).append("] ");
		buffer.append("price=[").append(price).append("] ");
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
		result = (int) (prime * result + ((authSubmitId == null) ? 0 : authSubmitId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrPaymentAuthSubmit))
			return false;
		TrPaymentAuthSubmit equalCheck = (TrPaymentAuthSubmit) obj;
		if ((authSubmitId == null && equalCheck.authSubmitId != null) || (authSubmitId != null && equalCheck.authSubmitId == null))
			return false;
		if (authSubmitId != null && !authSubmitId.equals(equalCheck.authSubmitId))
			return false;
		return true;
	}
}
