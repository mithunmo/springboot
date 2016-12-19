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
		@NamedQuery(name = "findAllTrMembershipAuthSubmits", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByChargeAmount", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.chargeAmount = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByCreatedBy", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.createdBy = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByCreationDate", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.creationDate = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByInitTimestamp", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.initTimestamp = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByLastUpdateDate", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByLastUpdatedBy", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitByMemAuthSubmitId", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.memAuthSubmitId = ?1"),
		@NamedQuery(name = "findTrMembershipAuthSubmitBySecurityToken", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.secureToken = ?1"), 
		@NamedQuery(name = "findTrMembershipAuthSubmitByPrimaryKey", query = "select myTrMembershipAuthSubmit from TrMembershipAuthSubmit myTrMembershipAuthSubmit where myTrMembershipAuthSubmit.memAuthSubmitId = ?1") })
@Table( name = "tr_membership_auth_submit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrMembershipAuthSubmit")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class TrMembershipAuthSubmit implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "MEM_AUTH_SUBMIT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer memAuthSubmitId;
	/**
	 */

	@Column(name = "CHARGE_AMOUNT", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal chargeAmount;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INIT_TIMESTAMP", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar initTimestamp;
	
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "MEMBERSHIP_ID", referencedColumnName = "MEMBERSHIP_ID", nullable = false) })
	@XmlTransient
	AdUserMemberships adUserMemberships;
	/**
	 */
	@OneToMany(mappedBy = "trMembershipAuthSubmit", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrReceiveMembershipPayments> trReceiveMembershipPaymentses;

	/**
	 */
	public void setMemAuthSubmitId(Integer memAuthSubmitId) {
		this.memAuthSubmitId = memAuthSubmitId;
	}

	/**
	 */
	public Integer getMemAuthSubmitId() {
		return this.memAuthSubmitId;
	}

	/**
	 */
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	/**
	 */
	public BigDecimal getChargeAmount() {
		return this.chargeAmount;
	}

	/**
	 */
	public void setInitTimestamp(Calendar initTimestamp) {
		this.initTimestamp = initTimestamp;
	}

	/**
	 */
	public Calendar getInitTimestamp() {
		return this.initTimestamp;
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
	public void setAdUserMemberships(AdUserMemberships adUserMemberships) {
		this.adUserMemberships = adUserMemberships;
	}

	/**
	 */
	@JsonIgnore
	public AdUserMemberships getAdUserMemberships() {
		return adUserMemberships;
	}

	/**
	 */
	public void setTrReceiveMembershipPaymentses(Set<TrReceiveMembershipPayments> trReceiveMembershipPaymentses) {
		this.trReceiveMembershipPaymentses = trReceiveMembershipPaymentses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrReceiveMembershipPayments> getTrReceiveMembershipPaymentses() {
		if (trReceiveMembershipPaymentses == null) {
			trReceiveMembershipPaymentses = new java.util.LinkedHashSet<com.f9g4.domain.TrReceiveMembershipPayments>();
		}
		return trReceiveMembershipPaymentses;
	}

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}

	/**
	 */
	public TrMembershipAuthSubmit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrMembershipAuthSubmit that) {
		setMemAuthSubmitId(that.getMemAuthSubmitId());
		setChargeAmount(that.getChargeAmount());
		setInitTimestamp(that.getInitTimestamp());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdUserMemberships(that.getAdUserMemberships());
		setTrReceiveMembershipPaymentses(new java.util.LinkedHashSet<com.f9g4.domain.TrReceiveMembershipPayments>(that.getTrReceiveMembershipPaymentses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("memAuthSubmitId=[").append(memAuthSubmitId).append("] ");
		buffer.append("chargeAmount=[").append(chargeAmount).append("] ");
		buffer.append("initTimestamp=[").append(initTimestamp).append("] ");
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
		result = (int) (prime * result + ((memAuthSubmitId == null) ? 0 : memAuthSubmitId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrMembershipAuthSubmit))
			return false;
		TrMembershipAuthSubmit equalCheck = (TrMembershipAuthSubmit) obj;
		if ((memAuthSubmitId == null && equalCheck.memAuthSubmitId != null) || (memAuthSubmitId != null && equalCheck.memAuthSubmitId == null))
			return false;
		if (memAuthSubmitId != null && !memAuthSubmitId.equals(equalCheck.memAuthSubmitId))
			return false;
		return true;
	}
}
