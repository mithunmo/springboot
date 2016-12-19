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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
		@NamedQuery(name = "findAllStTermsConditionss", query = "select myStTermsConditions from StTermsConditions myStTermsConditions"),
		@NamedQuery(name = "findStTermsConditionsByCreatedBy", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.createdBy = ?1"),
		@NamedQuery(name = "findStTermsConditionsByCreationDate", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.creationDate = ?1"),
		@NamedQuery(name = "findStTermsConditionsByEffectiveDate", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.effectiveDate = ?1"),
		@NamedQuery(name = "findStTermsConditionsByExpirationDate", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.expirationDate = ?1"),
		@NamedQuery(name = "findStTermsConditionsByLangCode", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.langCode = ?1"),
		@NamedQuery(name = "findStTermsConditionsByLangCodeContaining", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.langCode like ?1"),
		@NamedQuery(name = "findStTermsConditionsByLastUpdateDate", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.lastUpdateDate = ?1"),
		@NamedQuery(name = "findStTermsConditionsByLastUpdatedBy", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findStTermsConditionsByPrimaryKey", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.termCondId = ?1"),
		@NamedQuery(name = "findStTermsConditionsByReviewedByLegal", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.reviewedByLegal = ?1"),		
/*		@NamedQuery(name = "findActiveStTermsConditionsByUserTypeAndTermType", query = "select myStTermsConditions from " +
				" StTermsConditions myStTermsConditions inner join myStTermsConditions.adLookupValuesByUserTypeId  adLookupValuesByUserType " +
				" inner join myStTermsConditions.adLookupValuesByTermTypeId  adLookupValuesByTermType " +
				" where adLookupValuesByUserType.lookupCode = ?1 and adLookupValuesByTermType.lookupCode = ?2 and (myStTermsConditions.expirationDate IS NULL OR myStTermsConditions.expirationDate <= ?3) "),
*/		@NamedQuery(name = "findActiveStTermsConditionsByUserTypeAndTermType", query = "select myStTermsConditions from " +
		" StTermsConditions myStTermsConditions inner join myStTermsConditions.adLookupValuesByUserTypeId  adLookupValuesByUserType " +
		" inner join myStTermsConditions.adLookupValuesByTermTypeId  adLookupValuesByTermType " +
		" where adLookupValuesByUserType.lookupCode = ?1 and adLookupValuesByTermType.lookupCode = ?2 and myStTermsConditions.expirationDate IS NULL "),			
		
		@NamedQuery(name = "findAllStTermsConditionsByUserTypeAndTermType", query = "select myStTermsConditions from " +
		" StTermsConditions myStTermsConditions inner join myStTermsConditions.adLookupValuesByUserTypeId  adLookupValuesByUserType " +
		" inner join myStTermsConditions.adLookupValuesByTermTypeId  adLookupValuesByTermType " +
		" where adLookupValuesByUserType.lookupCode = ?1 and adLookupValuesByTermType.lookupCode = ?2 "),
		
		@NamedQuery(name = "findStTermsConditionsByTermCondId", query = "select myStTermsConditions from StTermsConditions myStTermsConditions where myStTermsConditions.termCondId = ?1") })

@NamedNativeQueries({
	@NamedNativeQuery(name = "findAllTermsConditionsByUserIdAndTermType", query= "SELECT stc.* " + 
			"FROM ad_accept_terms aat, st_terms_conditions stc " + 
			"WHERE aat.USER_ID = ?1 " +
			"and aat.TERM_COND_ID = stc.TERM_COND_ID " +
			"and stc.TERM_TYPE_ID in (?2) " +
			"ORDER BY aat.ACCEPTANCE_DATE DESC ",
			resultClass = com.f9g4.domain.StTermsConditions.class)
})
@Table( name = "st_terms_conditions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "StTermsConditions")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class StTermsConditions implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "TERM_COND_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer termCondId;
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
	@Column(name = "EXPIRATION_DATE")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expirationDate;
	/**
	 */

	@Column(name = "DISPLAYED_TERMS", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] displayedTerms;
	/**
	 * 1=reviewed 0=not reviewed
	 * 
	 */

	@Column(name = "REVIEWED_BY_LEGAL")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer reviewedByLegal;
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

	@Column(name = "LANG_CODE", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_TYPE_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByUserTypeId;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "TERM_TYPE_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByTermTypeId;
	
//	/**
//	 */
//	@OneToMany(mappedBy = "stTermsConditions", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@XmlElement(name = "", namespace = "")
//	java.util.Set<com.f9g4.domain.AdAcceptTerms> adAcceptTermses;

	/**
	 */
	public void setTermCondId(Integer termCondId) {
		this.termCondId = termCondId;
	}

	/**
	 */
	public Integer getTermCondId() {
		return this.termCondId;
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
	 */
	public void setDisplayedTerms(byte[] displayedTerms) {
		this.displayedTerms = displayedTerms;
	}

	/**
	 */
	public byte[] getDisplayedTerms() {
		return this.displayedTerms;
	}

	/**
	 * 1=reviewed 0=not reviewed
	 * 
	 */
	public void setReviewedByLegal(Integer reviewedByLegal) {
		this.reviewedByLegal = reviewedByLegal;
	}

	/**
	 * 1=reviewed 0=not reviewed
	 * 
	 */
	public Integer getReviewedByLegal() {
		return this.reviewedByLegal;
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
	public void setAdLookupValuesByUserTypeId(AdLookupValues adLookupValuesByUserTypeId) {
		this.adLookupValuesByUserTypeId = adLookupValuesByUserTypeId;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByUserTypeId() {
		return adLookupValuesByUserTypeId;
	}

	/**
	 */
	public void setAdLookupValuesByTermTypeId(AdLookupValues adLookupValuesByTermTypeId) {
		this.adLookupValuesByTermTypeId = adLookupValuesByTermTypeId;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByTermTypeId() {
		return adLookupValuesByTermTypeId;
	}

//	/**
//	 */
//	public void setAdAcceptTermses(Set<AdAcceptTerms> adAcceptTermses) {
//		this.adAcceptTermses = adAcceptTermses;
//	}
//
//	/**
//	 */
//	@JsonIgnore
//	public Set<AdAcceptTerms> getAdAcceptTermses() {
//		if (adAcceptTermses == null) {
//			adAcceptTermses = new java.util.LinkedHashSet<com.f9g4.domain.AdAcceptTerms>();
//		}
//		return adAcceptTermses;
//	}

	/**
	 */
	public StTermsConditions() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(StTermsConditions that) {
		setTermCondId(that.getTermCondId());
		setEffectiveDate(that.getEffectiveDate());
		setExpirationDate(that.getExpirationDate());
		setDisplayedTerms(that.getDisplayedTerms());
		setReviewedByLegal(that.getReviewedByLegal());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setAdLookupValuesByUserTypeId(that.getAdLookupValuesByUserTypeId());
		setAdLookupValuesByTermTypeId(that.getAdLookupValuesByTermTypeId());
		//setAdAcceptTermses(new java.util.LinkedHashSet<com.f9g4.domain.AdAcceptTerms>(that.getAdAcceptTermses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("termCondId=[").append(termCondId).append("] ");
		buffer.append("effectiveDate=[").append(effectiveDate).append("] ");
		buffer.append("expirationDate=[").append(expirationDate).append("] ");
		buffer.append("displayedTerms=[").append(displayedTerms).append("] ");
		buffer.append("reviewedByLegal=[").append(reviewedByLegal).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((termCondId == null) ? 0 : termCondId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof StTermsConditions))
			return false;
		StTermsConditions equalCheck = (StTermsConditions) obj;
		if ((termCondId == null && equalCheck.termCondId != null) || (termCondId != null && equalCheck.termCondId == null))
			return false;
		if (termCondId != null && !termCondId.equals(equalCheck.termCondId))
			return false;
		return true;
	}
}
