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
		@NamedQuery(name = "findAdUserMembershipsByAutopay", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.autopay = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByAutopayWithdrawDay", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.autopayWithdrawDay = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByCreatedBy", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.createdBy = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByCreationDate", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.creationDate = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByEffectiveDate", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.effectiveDate = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByExpirationDate", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.expirationDate = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByLastUpdateDate", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByLastUpdatedBy", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByMembershipId", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.membershipId = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByUserId", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.adUsers.userId = ?1"),
		@NamedQuery(name = "findAdUserMembershipsByPrimaryKey", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships where myAdUserMemberships.membershipId = ?1"),
		@NamedQuery(name = "findAllAdUserMembershipss", query = "select myAdUserMemberships from AdUserMemberships myAdUserMemberships") })
@Table( name = "ad_user_memberships")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdUserMemberships")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class AdUserMemberships implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "MEMBERSHIP_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer membershipId;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar effectiveDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expirationDate;
	/**
	 * 0 = false, 1= true
	 * 
	 */

	@Column(name = "AUTOPAY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer autopay;
	/**
	 * Autopay withdrawal date
	 * 
	 */

	@Column(name = "AUTOPAY_WITHDRAW_DAY")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer autopayWithdrawDay;
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
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PAYMENT_STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValues;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "MEMBER_PRICING_ID", referencedColumnName = "MEM_PRICING_ID", nullable = false) })
	@XmlTransient
	StMemPricingOptions stMemPricingOptions;
	/**
	 */
	@OneToMany(mappedBy = "adUserMemberships", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrMembershipAuthSubmit> trMembershipAuthSubmits;

	/**
	 */
	public void setMembershipId(Integer membershipId) {
		this.membershipId = membershipId;
	}

	/**
	 */
	public Integer getMembershipId() {
		return this.membershipId;
	}

	/**
	 */
	public void setEffectiveDate(Calendar effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 */
	public Calendar getEffectiveDate() {
		return this.effectiveDate;
	}

	/**
	 */
	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 */
	public Calendar getExpirationDate() {
		return this.expirationDate;
	}

	/**
	 * 0 = false, 1= true
	 * 
	 */
	public void setAutopay(Integer autopay) {
		this.autopay = autopay;
	}

	/**
	 * 0 = false, 1= true
	 * 
	 */
	public Integer getAutopay() {
		return this.autopay;
	}

	/**
	 * Autopay withdrawal date
	 * 
	 */
	public void setAutopayWithdrawDay(Integer autopayWithdrawDay) {
		this.autopayWithdrawDay = autopayWithdrawDay;
	}

	/**
	 * Autopay withdrawal date
	 * 
	 */
	public Integer getAutopayWithdrawDay() {
		return this.autopayWithdrawDay;
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
	public void setStMemPricingOptions(StMemPricingOptions stMemPricingOptions) {
		this.stMemPricingOptions = stMemPricingOptions;
	}

	/**
	 */
	@JsonIgnore
	public StMemPricingOptions getStMemPricingOptions() {
		return stMemPricingOptions;
	}

	/**
	 */
	public void setTrMembershipAuthSubmits(Set<TrMembershipAuthSubmit> trMembershipAuthSubmits) {
		this.trMembershipAuthSubmits = trMembershipAuthSubmits;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrMembershipAuthSubmit> getTrMembershipAuthSubmits() {
		if (trMembershipAuthSubmits == null) {
			trMembershipAuthSubmits = new java.util.LinkedHashSet<com.f9g4.domain.TrMembershipAuthSubmit>();
		}
		return trMembershipAuthSubmits;
	}

	/**
	 */
	public AdUserMemberships() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdUserMemberships that) {
		setMembershipId(that.getMembershipId());
		setEffectiveDate(that.getEffectiveDate());
		setExpirationDate(that.getExpirationDate());
		setAutopay(that.getAutopay());
		setAutopayWithdrawDay(that.getAutopayWithdrawDay());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdUsers(that.getAdUsers());
		setAdLookupValues(that.getAdLookupValues());
		setStMemPricingOptions(that.getStMemPricingOptions());
		setTrMembershipAuthSubmits(new java.util.LinkedHashSet<com.f9g4.domain.TrMembershipAuthSubmit>(that.getTrMembershipAuthSubmits()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("membershipId=[").append(membershipId).append("] ");
		buffer.append("effectiveDate=[").append(effectiveDate).append("] ");
		buffer.append("expirationDate=[").append(expirationDate).append("] ");
		buffer.append("autopay=[").append(autopay).append("] ");
		buffer.append("autopayWithdrawDay=[").append(autopayWithdrawDay).append("] ");
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
		result = (int) (prime * result + ((membershipId == null) ? 0 : membershipId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdUserMemberships))
			return false;
		AdUserMemberships equalCheck = (AdUserMemberships) obj;
		if ((membershipId == null && equalCheck.membershipId != null) || (membershipId != null && equalCheck.membershipId == null))
			return false;
		if (membershipId != null && !membershipId.equals(equalCheck.membershipId))
			return false;
		return true;
	}
}
