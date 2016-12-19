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
		@NamedQuery(name = "findAllStMemPricingOptionss", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions"),
		@NamedQuery(name = "findStMemPricingOptionsByCommission", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.commission = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByCreatedBy", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.createdBy = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByCreationDate", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.creationDate = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByDescription", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.description = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByDescriptionContaining", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.description like ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByDurationInMonths", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.durationInMonths = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByEffectiveDate", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.effectiveDate = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByExpirationDate", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.expirationDate = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByLangCode", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.langCode = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByLangCodeContaining", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.langCode like ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByLastUpdateDate", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.lastUpdateDate = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByLastUpdatedBy", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByMemPricingId", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.memPricingId = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByPrice", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.price = ?1"),
		@NamedQuery(name = "findStMemPricingOptionsByUserTypeAndMembershipType", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions " +
				" inner join myStMemPricingOptions.adLookupValuesByUserTypeId  adLookupValuesByUserType " +
				" inner join myStMemPricingOptions.adLookupValuesByMembershipTypeId  adLookupValuesByMembershipType " + 
				" where adLookupValuesByUserType.lookupCode = ?1 and adLookupValuesByMembershipType.lookupCode = ?2  and myStMemPricingOptions.expirationDate IS NULL "),
		@NamedQuery(name = "findStMemPricingOptionsByPrimaryKey", query = "select myStMemPricingOptions from StMemPricingOptions myStMemPricingOptions where myStMemPricingOptions.memPricingId = ?1") })
@Table( name = "st_mem_pricing_options")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "StMemPricingOptions")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class StMemPricingOptions implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "MEM_PRICING_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer memPricingId;
	/**
	 */

	@Column(name = "DURATION_IN_MONTHS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer durationInMonths;
	/**
	 */

	@Column(name = "PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal price;
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

	@Column(name = "DESCRIPTION", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 * Commission for each member type
	 * 
	 */

	@Column(name = "COMMISSION", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal commission;
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
	@JoinColumns({ @JoinColumn(name = "MEMBERSHIP_TYPE_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByMembershipTypeId;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_TYPE_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByUserTypeId;
	/**
	 */
	@OneToMany(mappedBy = "stMemPricingOptions", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUserMemberships> adUserMembershipses;

	/**
	 */
	public void setMemPricingId(Integer memPricingId) {
		this.memPricingId = memPricingId;
	}

	/**
	 */
	public Integer getMemPricingId() {
		return this.memPricingId;
	}

	/**
	 */
	public void setDurationInMonths(Integer durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	/**
	 */
	public Integer getDurationInMonths() {
		return this.durationInMonths;
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
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Commission for each member type
	 * 
	 */
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	/**
	 * Commission for each member type
	 * 
	 */
	public BigDecimal getCommission() {
		return this.commission;
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
	public void setAdLookupValuesByMembershipTypeId(AdLookupValues adLookupValuesByMembershipTypeId) {
		this.adLookupValuesByMembershipTypeId = adLookupValuesByMembershipTypeId;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByMembershipTypeId() {
		return adLookupValuesByMembershipTypeId;
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
	public void setAdUserMembershipses(Set<AdUserMemberships> adUserMembershipses) {
		this.adUserMembershipses = adUserMembershipses;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUserMemberships> getAdUserMembershipses() {
		if (adUserMembershipses == null) {
			adUserMembershipses = new java.util.LinkedHashSet<com.f9g4.domain.AdUserMemberships>();
		}
		return adUserMembershipses;
	}

	/**
	 */
	public StMemPricingOptions() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(StMemPricingOptions that) {
		setMemPricingId(that.getMemPricingId());
		setDurationInMonths(that.getDurationInMonths());
		setPrice(that.getPrice());
		setEffectiveDate(that.getEffectiveDate());
		setExpirationDate(that.getExpirationDate());
		setDescription(that.getDescription());
		setCommission(that.getCommission());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setAdLookupValuesByMembershipTypeId(that.getAdLookupValuesByMembershipTypeId());
		setAdLookupValuesByUserTypeId(that.getAdLookupValuesByUserTypeId());
		setAdUserMembershipses(new java.util.LinkedHashSet<com.f9g4.domain.AdUserMemberships>(that.getAdUserMembershipses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("memPricingId=[").append(memPricingId).append("] ");
		buffer.append("durationInMonths=[").append(durationInMonths).append("] ");
		buffer.append("price=[").append(price).append("] ");
		buffer.append("effectiveDate=[").append(effectiveDate).append("] ");
		buffer.append("expirationDate=[").append(expirationDate).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("commission=[").append(commission).append("] ");
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
		result = (int) (prime * result + ((memPricingId == null) ? 0 : memPricingId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof StMemPricingOptions))
			return false;
		StMemPricingOptions equalCheck = (StMemPricingOptions) obj;
		if ((memPricingId == null && equalCheck.memPricingId != null) || (memPricingId != null && equalCheck.memPricingId == null))
			return false;
		if (memPricingId != null && !memPricingId.equals(equalCheck.memPricingId))
			return false;
		return true;
	}
}
