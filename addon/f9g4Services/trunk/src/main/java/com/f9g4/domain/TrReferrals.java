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
		@NamedQuery(name = "findAllTrReferralss", query = "select myTrReferrals from TrReferrals myTrReferrals"),
		@NamedQuery(name = "findTrReferralsByAuthCode", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.authCode = ?1"),
		@NamedQuery(name = "findTrReferralsByAuthCodeContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.authCode like ?1"),
		@NamedQuery(name = "findTrReferralsByDateSent", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.dateSent = ?1"),
		@NamedQuery(name = "findTrReferralsByEmailAddress", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.emailAddress = ?1"),
		@NamedQuery(name = "findTrReferralsByEmailAddressContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.emailAddress like ?1"),
		@NamedQuery(name = "findTrReferralsByExpirationDate", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.expirationDate = ?1"),
		@NamedQuery(name = "findTrReferralsByFirstName", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.firstName = ?1"),
		@NamedQuery(name = "findTrReferralsByFirstNameContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.firstName like ?1"),
		@NamedQuery(name = "findTrReferralsByLangCode", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.langCode = ?1"),
		@NamedQuery(name = "findTrReferralsByLangCodeContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.langCode like ?1"),
		@NamedQuery(name = "findTrReferralsByLastName", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.lastName = ?1"),
		@NamedQuery(name = "findTrReferralsByLastNameContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.lastName like ?1"),
		@NamedQuery(name = "findTrReferralsByLastUpdateDate", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrReferralsByLastUpdatedBy", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrReferralsByMessage", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.message = ?1"),
		@NamedQuery(name = "findTrReferralsByMessageContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.message like ?1"),
		@NamedQuery(name = "findTrReferralsByPrimaryKey", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.referralId = ?1"),
		@NamedQuery(name = "findTrReferralsByReferralId", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.referralId = ?1"),
		@NamedQuery(name = "findTrReferralsBySignedupOn", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.signedupOn = ?1"),
		@NamedQuery(name = "findTrReferralsBySignedupUserId", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.signedupUserId = ?1"),
		@NamedQuery(name = "findTrReferralsByWhyRefer", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.whyRefer = ?1"),
		@NamedQuery(name = "findTrReferralsByUser", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.adUsers.userId = ?1"),
		@NamedQuery(name = "findTrReferralsByWhyReferContaining", query = "select myTrReferrals from TrReferrals myTrReferrals where myTrReferrals.whyRefer like ?1") })
@Table( name = "tr_referrals")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrReferrals")
public class TrReferrals implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "REFERRAL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer referralId;
	/**
	 */

	@Column(name = "FIRST_NAME", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String firstName;
	/**
	 */

	@Column(name = "LAST_NAME", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lastName;
	/**
	 */

	@Column(name = "PHONE", length = 40, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	/**
	 */
	
	@Column(name = "EMAIL_ADDRESS", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String emailAddress;
	/**
	 */

	@Column(name = "SIGNEDUP_USER_ID")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer signedupUserId;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expirationDate;
	/**
	 */

	@Column(name = "WHY_REFER", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String whyRefer;
	/**
	 */

	@Column(name = "MESSAGE", length = 2000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String message;
	/**
	 */

	@Column(name = "AUTH_CODE", length = 120, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authCode;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_SENT", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateSent;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SIGNEDUP_ON")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar signedupOn;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;
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
	@JoinColumns({ @JoinColumn(name = "SENT_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 */
	public void setReferralId(Integer referralId) {
		this.referralId = referralId;
	}

	/**
	 */
	public Integer getReferralId() {
		return this.referralId;
	}

	/**
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 */
	public void setSignedupUserId(Integer signedupUserId) {
		this.signedupUserId = signedupUserId;
	}

	/**
	 */
	public Integer getSignedupUserId() {
		return this.signedupUserId;
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
	 */
	public void setWhyRefer(String whyRefer) {
		this.whyRefer = whyRefer;
	}

	/**
	 */
	public String getWhyRefer() {
		return this.whyRefer;
	}

	/**
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 */
	public String getAuthCode() {
		return this.authCode;
	}

	/**
	 */
	public void setDateSent(Calendar dateSent) {
		this.dateSent = dateSent;
	}

	/**
	 */
	public Calendar getDateSent() {
		return this.dateSent;
	}

	/**
	 */
	public void setSignedupOn(Calendar signedupOn) {
		this.signedupOn = signedupOn;
	}

	/**
	 */
	public Calendar getSignedupOn() {
		return this.signedupOn;
	}

	/**
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 */
	public String getLangCode() {
		return this.langCode;
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
	public TrReferrals() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrReferrals that) {
		setReferralId(that.getReferralId());
		setFirstName(that.getFirstName());
		setLastName(that.getLastName());
		setPhone(that.getPhone());
		setEmailAddress(that.getEmailAddress());
		setSignedupUserId(that.getSignedupUserId());
		setExpirationDate(that.getExpirationDate());
		setWhyRefer(that.getWhyRefer());
		setMessage(that.getMessage());
		setAuthCode(that.getAuthCode());
		setDateSent(that.getDateSent());
		setSignedupOn(that.getSignedupOn());
		setLangCode(that.getLangCode());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdUsers(that.getAdUsers());
	}

	@Override
	public String toString() {
		return "TrReferrals [referralId=" + referralId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", emailAddress=" + emailAddress + ", signedupUserId="
				+ signedupUserId + ", expirationDate=" + expirationDate
				+ ", whyRefer=" + whyRefer + ", message=" + message
				+ ", authCode=" + authCode + ", dateSent=" + dateSent
				+ ", signedupOn=" + signedupOn + ", langCode=" + langCode
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", adUsers=" + adUsers + "]";
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((referralId == null) ? 0 : referralId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrReferrals))
			return false;
		TrReferrals equalCheck = (TrReferrals) obj;
		if ((referralId == null && equalCheck.referralId != null) || (referralId != null && equalCheck.referralId == null))
			return false;
		if (referralId != null && !referralId.equals(equalCheck.referralId))
			return false;
		return true;
	}
}
