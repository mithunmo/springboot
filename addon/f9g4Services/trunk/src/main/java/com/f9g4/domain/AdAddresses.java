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
		@NamedQuery(name = "findAdAddressesByActiveStatus", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.activeStatus = ?1"),
		@NamedQuery(name = "findAdAddressesByAddressId", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.addressId = ?1"),
		@NamedQuery(name = "findAdAddressesByAddressLine1", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.addressLine1 = ?1"),
		@NamedQuery(name = "findAdAddressesByAddressLine1Containing", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.addressLine1 like ?1"),
		@NamedQuery(name = "findAdAddressesByAddressLine2", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.addressLine2 = ?1"),
		@NamedQuery(name = "findAdAddressesByAddressLine2Containing", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.addressLine2 like ?1"),
		@NamedQuery(name = "findAdAddressesByCity", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.city = ?1"),
		@NamedQuery(name = "findAdAddressesByCityContaining", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.city like ?1"),
		@NamedQuery(name = "findAdAddressesByCounty", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.county = ?1"),
		@NamedQuery(name = "findAdAddressesByCountyContaining", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.county like ?1"),
		@NamedQuery(name = "findAdAddressesByCreatedBy", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.createdBy = ?1"),
		@NamedQuery(name = "findAdAddressesByCreationDate", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.creationDate = ?1"),
		@NamedQuery(name = "findAdAddressesByLangCode", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.langCode = ?1"),
		@NamedQuery(name = "findAdAddressesByLangCodeContaining", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.langCode like ?1"),
		@NamedQuery(name = "findAdAddressesByLastUpdateDate", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdAddressesByLastUpdatedBy", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdAddressesByPostalCode", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.postalCode = ?1"),
		@NamedQuery(name = "findAdAddressesByPostalCodeContaining", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.postalCode like ?1"),
		@NamedQuery(name = "findAdAddressesByPrimaryKey", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.addressId = ?1"),
		@NamedQuery(name = "findAdAddressesByState", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.state = ?1"),
		@NamedQuery(name = "findAdAddressesByStateContaining", query = "select myAdAddresses from AdAddresses myAdAddresses where myAdAddresses.state like ?1"),
		@NamedQuery(name = "findAllAdAddressess", query = "select myAdAddresses from AdAddresses myAdAddresses") })
@Table( name = "ad_addresses")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdAddresses")
public class AdAddresses implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "ADDRESS_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer addressId;
	/**
	 */

	@Column(name = "ADDRESS_LINE1", length = 500, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine1;
	/**
	 */

	@Column(name = "ADDRESS_LINE2", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine2;
	/**
	 */

	@Column(name = "CITY", length = 240, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "COUNTY", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String county;
	/**
	 */

	@Column(name = "STATE", length = 240, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "POSTAL_CODE", length = 60, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String postalCode;
	/**
	 */

	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
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

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = true) })
	@XmlTransient
	AdLookupValues adLookupValues;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	/**
	 */
	public Integer getAddressId() {
		return this.addressId;
	}

	/**
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 */
	public String getAddressLine1() {
		return this.addressLine1;
	}

	/**
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 */
	public String getAddressLine2() {
		return this.addressLine2;
	}

	/**
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 */
	public String getCounty() {
		return this.county;
	}

	/**
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 */
	public String getState() {
		return this.state;
	}

	/**
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 */
	public Integer getActiveStatus() {
		return this.activeStatus;
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
	public AdAddresses() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdAddresses that) {
		setAddressId(that.getAddressId());
		setAddressLine1(that.getAddressLine1());
		setAddressLine2(that.getAddressLine2());
		setCity(that.getCity());
		setCounty(that.getCounty());
		setState(that.getState());
		setPostalCode(that.getPostalCode());
		setActiveStatus(that.getActiveStatus());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setAdLookupValues(that.getAdLookupValues());
		setAdUsers(that.getAdUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("addressId=[").append(addressId).append("] ");
		buffer.append("addressLine1=[").append(addressLine1).append("] ");
		buffer.append("addressLine2=[").append(addressLine2).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("county=[").append(county).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("postalCode=[").append(postalCode).append("] ");
		buffer.append("activeStatus=[").append(activeStatus).append("] ");
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
		result = (int) (prime * result + ((addressId == null) ? 0 : addressId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdAddresses))
			return false;
		AdAddresses equalCheck = (AdAddresses) obj;
		if ((addressId == null && equalCheck.addressId != null) || (addressId != null && equalCheck.addressId == null))
			return false;
		if (addressId != null && !addressId.equals(equalCheck.addressId))
			return false;
		return true;
	}
}
