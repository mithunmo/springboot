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
		@NamedQuery(name = "findAdLookupValuesByActiveStatus", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.activeStatus = ?1"),
		@NamedQuery(name = "findAdLookupValuesByCreatedBy", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.createdBy = ?1"),
		@NamedQuery(name = "findAdLookupValuesByCreationDate", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.creationDate = ?1"),
		@NamedQuery(name = "findAdLookupValuesByDescription", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.description = ?1"),
		@NamedQuery(name = "findAdLookupValuesByDescriptionContaining", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.description like ?1"),
		@NamedQuery(name = "findAdLookupValuesByLangCode", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.langCode = ?1"),
		@NamedQuery(name = "findAdLookupValuesByLangCodeContaining", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.langCode like ?1"),
		@NamedQuery(name = "findAdLookupValuesByLastUpdateBy", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.lastUpdateBy = ?1"),
		@NamedQuery(name = "findAdLookupValuesByLastUpdateDate", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdLookupValuesByLookupCode", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.lookupCode = ?1"),
		@NamedQuery(name = "findAdLookupValuesByLookupCodeContaining", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.lookupCode like ?1"),
		@NamedQuery(name = "findAdLookupValuesByLookupValueId", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.lookupValueId = ?1"),
		@NamedQuery(name = "findAdLookupValuesByPrimaryKey", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.lookupValueId = ?1"),
		@NamedQuery(name = "findAdLookupValuesByLookupType", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.adLookupTypes.lookupType = ?1 and myAdLookupValues.activeStatus =1 order by description"),
		@NamedQuery(name = "findAllAdLookupValuesByLookupType", query = "select myAdLookupValues from AdLookupValues myAdLookupValues where myAdLookupValues.adLookupTypes.lookupType = ?1"),
		@NamedQuery(name = "findAllAdLookupValuess", query = "select myAdLookupValues from AdLookupValues myAdLookupValues") })
@Table( name = "ad_lookup_values")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdLookupValues")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class AdLookupValues implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Primary Key
	 * 
	 */

	@Column(name = "LOOKUP_VALUE_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer lookupValueId;
	/**
	 */

	@Column(name = "LOOKUP_CODE", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lookupCode;
	/**
	 */

	@Column(name = "DESCRIPTION", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 * 1= Active, 0 = Inactive
	 * 
	 */

	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;
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

	@Column(name = "LAST_UPDATE_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpdateBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "LOOKUP_TYPE_ID", referencedColumnName = "LOOKUP_TYPE_ID", nullable = false) })
	@XmlTransient
	AdLookupTypes adLookupTypes;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchLanguages> trSearchLanguageses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByUserTypeId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.StTermsConditions> stTermsConditionsesForTermTypeId;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUserMemberships> adUserMembershipses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRateTransactionId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingsesForRatingQuestion5Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrBoard> trBoards;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRateTransactionId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingsesForRatingQuestion3Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRateTransactionId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingsesForRatingQuestion2Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUserLanguages> adUserLanguageses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByMembershipTypeId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.StMemPricingOptions> stMemPricingOptionsesForUserTypeId;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRateTransactionId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingsesForRatingQuestion1Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUserSkills> adUserSkillses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRegStatusId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUsers> adUsersesForSecurityQuestion3Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRegStatusId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUsers> adUsersesForRegStatusId;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRateTransactionId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingsesForRateTransactionId;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSearchSkills> trSearchSkillses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrMessages> trMessageses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdAddresses> adAddresseses;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByUserTypeId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.StTermsConditions> stTermsConditionsesForUserTypeId;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByMembershipTypeId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.StMemPricingOptions> stMemPricingOptionsesForMembershipTypeId;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValues", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrNotificationsQ> trNotificationsQs;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRegStatusId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUsers> adUsersesForSecurityQuestion1Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRegStatusId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.AdUsers> adUsersesForSecurityQuestion2Id;
	/**
	 */
	@OneToMany(mappedBy = "adLookupValuesByRateTransactionId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingsesForRatingQuestion4Id;

	/**
	 * Primary Key
	 * 
	 */
	public void setLookupValueId(Integer lookupValueId) {
		this.lookupValueId = lookupValueId;
	}

	/**
	 * Primary Key
	 * 
	 */
	public Integer getLookupValueId() {
		return this.lookupValueId;
	}

	/**
	 */
	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	/**
	 */
	public String getLookupCode() {
		return this.lookupCode;
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
	 * 1= Active, 0 = Inactive
	 * 
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * 1= Active, 0 = Inactive
	 * 
	 */
	public Integer getActiveStatus() {
		return this.activeStatus;
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
	public void setLastUpdateBy(Integer lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	/**
	 */
	public Integer getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	/**
	 */
	public void setAdLookupTypes(AdLookupTypes adLookupTypes) {
		this.adLookupTypes = adLookupTypes;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupTypes getAdLookupTypes() {
		return adLookupTypes;
	}

	/**
	 */
	public void setTrSearchLanguageses(Set<TrSearchLanguages> trSearchLanguageses) {
		this.trSearchLanguageses = trSearchLanguageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSearchLanguages> getTrSearchLanguageses() {
		if (trSearchLanguageses == null) {
			trSearchLanguageses = new java.util.LinkedHashSet<com.f9g4.domain.TrSearchLanguages>();
		}
		return trSearchLanguageses;
	}

	/**
	 */
	public void setStTermsConditionsesForTermTypeId(Set<StTermsConditions> stTermsConditionsesForTermTypeId) {
		this.stTermsConditionsesForTermTypeId = stTermsConditionsesForTermTypeId;
	}

	/**
	 */
	@JsonIgnore
	public Set<StTermsConditions> getStTermsConditionsesForTermTypeId() {
		if (stTermsConditionsesForTermTypeId == null) {
			stTermsConditionsesForTermTypeId = new java.util.LinkedHashSet<com.f9g4.domain.StTermsConditions>();
		}
		return stTermsConditionsesForTermTypeId;
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
	public void setTrRatingsesForRatingQuestion5Id(Set<TrRatings> trRatingsesForRatingQuestion5Id) {
		this.trRatingsesForRatingQuestion5Id = trRatingsesForRatingQuestion5Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingsesForRatingQuestion5Id() {
		if (trRatingsesForRatingQuestion5Id == null) {
			trRatingsesForRatingQuestion5Id = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingsesForRatingQuestion5Id;
	}

	/**
	 */
	public void setTrBoards(Set<TrBoard> trBoards) {
		this.trBoards = trBoards;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrBoard> getTrBoards() {
		if (trBoards == null) {
			trBoards = new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>();
		}
		return trBoards;
	}

	/**
	 */
	public void setTrRatingsesForRatingQuestion3Id(Set<TrRatings> trRatingsesForRatingQuestion3Id) {
		this.trRatingsesForRatingQuestion3Id = trRatingsesForRatingQuestion3Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingsesForRatingQuestion3Id() {
		if (trRatingsesForRatingQuestion3Id == null) {
			trRatingsesForRatingQuestion3Id = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingsesForRatingQuestion3Id;
	}

	/**
	 */
	public void setTrRatingsesForRatingQuestion2Id(Set<TrRatings> trRatingsesForRatingQuestion2Id) {
		this.trRatingsesForRatingQuestion2Id = trRatingsesForRatingQuestion2Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingsesForRatingQuestion2Id() {
		if (trRatingsesForRatingQuestion2Id == null) {
			trRatingsesForRatingQuestion2Id = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingsesForRatingQuestion2Id;
	}

	/**
	 */
	public void setAdUserLanguageses(Set<AdUserLanguages> adUserLanguageses) {
		this.adUserLanguageses = adUserLanguageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUserLanguages> getAdUserLanguageses() {
		if (adUserLanguageses == null) {
			adUserLanguageses = new java.util.LinkedHashSet<com.f9g4.domain.AdUserLanguages>();
		}
		return adUserLanguageses;
	}

	/**
	 */
	public void setStMemPricingOptionsesForUserTypeId(Set<StMemPricingOptions> stMemPricingOptionsesForUserTypeId) {
		this.stMemPricingOptionsesForUserTypeId = stMemPricingOptionsesForUserTypeId;
	}

	/**
	 */
	@JsonIgnore
	public Set<StMemPricingOptions> getStMemPricingOptionsesForUserTypeId() {
		if (stMemPricingOptionsesForUserTypeId == null) {
			stMemPricingOptionsesForUserTypeId = new java.util.LinkedHashSet<com.f9g4.domain.StMemPricingOptions>();
		}
		return stMemPricingOptionsesForUserTypeId;
	}

	/**
	 */
	public void setTrRatingsesForRatingQuestion1Id(Set<TrRatings> trRatingsesForRatingQuestion1Id) {
		this.trRatingsesForRatingQuestion1Id = trRatingsesForRatingQuestion1Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingsesForRatingQuestion1Id() {
		if (trRatingsesForRatingQuestion1Id == null) {
			trRatingsesForRatingQuestion1Id = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingsesForRatingQuestion1Id;
	}

	/**
	 */
	public void setAdUserSkillses(Set<AdUserSkills> adUserSkillses) {
		this.adUserSkillses = adUserSkillses;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUserSkills> getAdUserSkillses() {
		if (adUserSkillses == null) {
			adUserSkillses = new java.util.LinkedHashSet<com.f9g4.domain.AdUserSkills>();
		}
		return adUserSkillses;
	}

	/**
	 */
	public void setAdUsersesForSecurityQuestion3Id(Set<AdUsers> adUsersesForSecurityQuestion3Id) {
		this.adUsersesForSecurityQuestion3Id = adUsersesForSecurityQuestion3Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUsers> getAdUsersesForSecurityQuestion3Id() {
		if (adUsersesForSecurityQuestion3Id == null) {
			adUsersesForSecurityQuestion3Id = new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>();
		}
		return adUsersesForSecurityQuestion3Id;
	}

	/**
	 */
	public void setAdUsersesForRegStatusId(Set<AdUsers> adUsersesForRegStatusId) {
		this.adUsersesForRegStatusId = adUsersesForRegStatusId;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUsers> getAdUsersesForRegStatusId() {
		if (adUsersesForRegStatusId == null) {
			adUsersesForRegStatusId = new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>();
		}
		return adUsersesForRegStatusId;
	}

	/**
	 */
	public void setTrRatingsesForRateTransactionId(Set<TrRatings> trRatingsesForRateTransactionId) {
		this.trRatingsesForRateTransactionId = trRatingsesForRateTransactionId;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingsesForRateTransactionId() {
		if (trRatingsesForRateTransactionId == null) {
			trRatingsesForRateTransactionId = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingsesForRateTransactionId;
	}

	/**
	 */
	public void setTrSearchSkillses(Set<TrSearchSkills> trSearchSkillses) {
		this.trSearchSkillses = trSearchSkillses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSearchSkills> getTrSearchSkillses() {
		if (trSearchSkillses == null) {
			trSearchSkillses = new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSkills>();
		}
		return trSearchSkillses;
	}

	/**
	 */
	public void setTrMessageses(Set<TrMessages> trMessageses) {
		this.trMessageses = trMessageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrMessages> getTrMessageses() {
		if (trMessageses == null) {
			trMessageses = new java.util.LinkedHashSet<com.f9g4.domain.TrMessages>();
		}
		return trMessageses;
	}

	/**
	 */
	public void setAdAddresseses(Set<AdAddresses> adAddresseses) {
		this.adAddresseses = adAddresseses;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdAddresses> getAdAddresseses() {
		if (adAddresseses == null) {
			adAddresseses = new java.util.LinkedHashSet<com.f9g4.domain.AdAddresses>();
		}
		return adAddresseses;
	}

	/**
	 */
	public void setStTermsConditionsesForUserTypeId(Set<StTermsConditions> stTermsConditionsesForUserTypeId) {
		this.stTermsConditionsesForUserTypeId = stTermsConditionsesForUserTypeId;
	}

	/**
	 */
	@JsonIgnore
	public Set<StTermsConditions> getStTermsConditionsesForUserTypeId() {
		if (stTermsConditionsesForUserTypeId == null) {
			stTermsConditionsesForUserTypeId = new java.util.LinkedHashSet<com.f9g4.domain.StTermsConditions>();
		}
		return stTermsConditionsesForUserTypeId;
	}

	/**
	 */
	public void setStMemPricingOptionsesForMembershipTypeId(Set<StMemPricingOptions> stMemPricingOptionsesForMembershipTypeId) {
		this.stMemPricingOptionsesForMembershipTypeId = stMemPricingOptionsesForMembershipTypeId;
	}

	/**
	 */
	@JsonIgnore
	public Set<StMemPricingOptions> getStMemPricingOptionsesForMembershipTypeId() {
		if (stMemPricingOptionsesForMembershipTypeId == null) {
			stMemPricingOptionsesForMembershipTypeId = new java.util.LinkedHashSet<com.f9g4.domain.StMemPricingOptions>();
		}
		return stMemPricingOptionsesForMembershipTypeId;
	}

	/**
	 */
	public void setTrNotificationsQs(Set<TrNotificationsQ> trNotificationsQs) {
		this.trNotificationsQs = trNotificationsQs;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrNotificationsQ> getTrNotificationsQs() {
		if (trNotificationsQs == null) {
			trNotificationsQs = new java.util.LinkedHashSet<com.f9g4.domain.TrNotificationsQ>();
		}
		return trNotificationsQs;
	}

	/**
	 */
	public void setAdUsersesForSecurityQuestion1Id(Set<AdUsers> adUsersesForSecurityQuestion1Id) {
		this.adUsersesForSecurityQuestion1Id = adUsersesForSecurityQuestion1Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUsers> getAdUsersesForSecurityQuestion1Id() {
		if (adUsersesForSecurityQuestion1Id == null) {
			adUsersesForSecurityQuestion1Id = new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>();
		}
		return adUsersesForSecurityQuestion1Id;
	}

	/**
	 */
	public void setAdUsersesForSecurityQuestion2Id(Set<AdUsers> adUsersesForSecurityQuestion2Id) {
		this.adUsersesForSecurityQuestion2Id = adUsersesForSecurityQuestion2Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<AdUsers> getAdUsersesForSecurityQuestion2Id() {
		if (adUsersesForSecurityQuestion2Id == null) {
			adUsersesForSecurityQuestion2Id = new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>();
		}
		return adUsersesForSecurityQuestion2Id;
	}

	/**
	 */
	public void setTrRatingsesForRatingQuestion4Id(Set<TrRatings> trRatingsesForRatingQuestion4Id) {
		this.trRatingsesForRatingQuestion4Id = trRatingsesForRatingQuestion4Id;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingsesForRatingQuestion4Id() {
		if (trRatingsesForRatingQuestion4Id == null) {
			trRatingsesForRatingQuestion4Id = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingsesForRatingQuestion4Id;
	}

	/**
	 */
	public AdLookupValues() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdLookupValues that) {
		setLookupValueId(that.getLookupValueId());
		setLookupCode(that.getLookupCode());
		setDescription(that.getDescription());
		setActiveStatus(that.getActiveStatus());
		setLangCode(that.getLangCode());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdateBy(that.getLastUpdateBy());
		setAdLookupTypes(that.getAdLookupTypes());
		setTrSearchLanguageses(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchLanguages>(that.getTrSearchLanguageses()));
		setStTermsConditionsesForTermTypeId(new java.util.LinkedHashSet<com.f9g4.domain.StTermsConditions>(that.getStTermsConditionsesForTermTypeId()));
		setAdUserMembershipses(new java.util.LinkedHashSet<com.f9g4.domain.AdUserMemberships>(that.getAdUserMembershipses()));
		setTrRatingsesForRatingQuestion5Id(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingsesForRatingQuestion5Id()));
		setTrBoards(new java.util.LinkedHashSet<com.f9g4.domain.TrBoard>(that.getTrBoards()));
		setTrRatingsesForRatingQuestion3Id(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingsesForRatingQuestion3Id()));
		setTrRatingsesForRatingQuestion2Id(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingsesForRatingQuestion2Id()));
		setAdUserLanguageses(new java.util.LinkedHashSet<com.f9g4.domain.AdUserLanguages>(that.getAdUserLanguageses()));
		setStMemPricingOptionsesForUserTypeId(new java.util.LinkedHashSet<com.f9g4.domain.StMemPricingOptions>(that.getStMemPricingOptionsesForUserTypeId()));
		setTrRatingsesForRatingQuestion1Id(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingsesForRatingQuestion1Id()));
		setAdUserSkillses(new java.util.LinkedHashSet<com.f9g4.domain.AdUserSkills>(that.getAdUserSkillses()));
		setAdUsersesForSecurityQuestion3Id(new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>(that.getAdUsersesForSecurityQuestion3Id()));
		setAdUsersesForRegStatusId(new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>(that.getAdUsersesForRegStatusId()));
		setTrRatingsesForRateTransactionId(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingsesForRateTransactionId()));
		setTrSearchSkillses(new java.util.LinkedHashSet<com.f9g4.domain.TrSearchSkills>(that.getTrSearchSkillses()));
		setTrMessageses(new java.util.LinkedHashSet<com.f9g4.domain.TrMessages>(that.getTrMessageses()));
		setAdAddresseses(new java.util.LinkedHashSet<com.f9g4.domain.AdAddresses>(that.getAdAddresseses()));
		setStTermsConditionsesForUserTypeId(new java.util.LinkedHashSet<com.f9g4.domain.StTermsConditions>(that.getStTermsConditionsesForUserTypeId()));
		setStMemPricingOptionsesForMembershipTypeId(new java.util.LinkedHashSet<com.f9g4.domain.StMemPricingOptions>(that.getStMemPricingOptionsesForMembershipTypeId()));
		setTrNotificationsQs(new java.util.LinkedHashSet<com.f9g4.domain.TrNotificationsQ>(that.getTrNotificationsQs()));
		setAdUsersesForSecurityQuestion1Id(new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>(that.getAdUsersesForSecurityQuestion1Id()));
		setAdUsersesForSecurityQuestion2Id(new java.util.LinkedHashSet<com.f9g4.domain.AdUsers>(that.getAdUsersesForSecurityQuestion2Id()));
		setTrRatingsesForRatingQuestion4Id(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingsesForRatingQuestion4Id()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("lookupValueId=[").append(lookupValueId).append("] ");
		buffer.append("lookupCode=[").append(lookupCode).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdateBy=[").append(lastUpdateBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((lookupValueId == null) ? 0 : lookupValueId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdLookupValues))
			return false;
		AdLookupValues equalCheck = (AdLookupValues) obj;
		if ((lookupValueId == null && equalCheck.lookupValueId != null) || (lookupValueId != null && equalCheck.lookupValueId == null))
			return false;
		if (lookupValueId != null && !lookupValueId.equals(equalCheck.lookupValueId))
			return false;
		return true;
	}
}
