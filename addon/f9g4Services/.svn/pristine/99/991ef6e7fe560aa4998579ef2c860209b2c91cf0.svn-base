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
		@NamedQuery(name = "findAdContactsByCellphone", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.cellphone = ?1"),
		@NamedQuery(name = "findAdContactsByCellphoneContaining", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.cellphone like ?1"),
		@NamedQuery(name = "findAdContactsByContactId", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.contactId = ?1"),
		@NamedQuery(name = "findAdContactsByCreatedBy", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.createdBy = ?1"),
		@NamedQuery(name = "findAdContactsByCreationDate", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.creationDate = ?1"),
		@NamedQuery(name = "findAdContactsByFax", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.fax = ?1"),
		@NamedQuery(name = "findAdContactsByFaxContaining", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.fax like ?1"),
		@NamedQuery(name = "findAdContactsByLangCode", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.langCode = ?1"),
		@NamedQuery(name = "findAdContactsByLangCodeContaining", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.langCode like ?1"),
		@NamedQuery(name = "findAdContactsByLastUpdateBy", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.lastUpdateBy = ?1"),
		@NamedQuery(name = "findAdContactsByLastUpdatedDate", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.lastUpdatedDate = ?1"),
		@NamedQuery(name = "findAdContactsByPrimaryKey", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.contactId = ?1"),
		@NamedQuery(name = "findAdContactsByWorkExtn", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.workExtn = ?1"),
		@NamedQuery(name = "findAdContactsByWorkExtnContaining", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.workExtn like ?1"),
		@NamedQuery(name = "findAdContactsByWorkPhone", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.workPhone = ?1"),
		@NamedQuery(name = "findAdContactsByWorkPhoneContaining", query = "select myAdContacts from AdContacts myAdContacts where myAdContacts.workPhone like ?1"),
		@NamedQuery(name = "findAllAdContactss", query = "select myAdContacts from AdContacts myAdContacts") })
@Table( name = "ad_contacts")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdContacts")
public class AdContacts implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CONTACT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer contactId;
	/**
	 */

	@Column(name = "WORK_PHONE", length = 40)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String workPhone;
	/**
	 */

	@Column(name = "WORK_EXTN", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String workExtn;
	/**
	 */

	@Column(name = "CELLPHONE", length = 40)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String cellphone;
	/**
	 */

	@Column(name = "FAX", length = 40)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String fax;
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
	
	/*Change the column name -C*/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastUpdatedDate;
	/**
	 */

	/*Change the column name -C*/
	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpdateBy;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	/**
	 */
	public Integer getContactId() {
		return this.contactId;
	}

	/**
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 */
	public String getWorkPhone() {
		return this.workPhone;
	}

	/**
	 */
	public void setWorkExtn(String workExtn) {
		this.workExtn = workExtn;
	}

	/**
	 */
	public String getWorkExtn() {
		return this.workExtn;
	}

	/**
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 */
	public String getCellphone() {
		return this.cellphone;
	}

	/**
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 */
	public String getFax() {
		return this.fax;
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
	public void setLastUpdatedDate(Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 */
	public Calendar getLastUpdatedDate() {
		return this.lastUpdatedDate;
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
	public AdContacts() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 * 
	 */
	public void copy(AdContacts that) {
		setContactId(that.getContactId());
		setWorkPhone(that.getWorkPhone());
		setWorkExtn(that.getWorkExtn());
		setCellphone(that.getCellphone());
		setFax(that.getFax());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdatedDate(that.getLastUpdatedDate());
		setLastUpdateBy(that.getLastUpdateBy());
		setLangCode(that.getLangCode());
		setAdUsers(that.getAdUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 * 
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("contactId=[").append(contactId).append("] ");
		buffer.append("workPhone=[").append(workPhone).append("] ");
		buffer.append("workExtn=[").append(workExtn).append("] ");
		buffer.append("cellphone=[").append(cellphone).append("] ");
		buffer.append("fax=[").append(fax).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdatedDate=[").append(lastUpdatedDate).append("] ");
		buffer.append("lastUpdateBy=[").append(lastUpdateBy).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((contactId == null) ? 0 : contactId
				.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdContacts))
			return false;
		AdContacts equalCheck = (AdContacts) obj;
		if ((contactId == null && equalCheck.contactId != null)
				|| (contactId != null && equalCheck.contactId == null))
			return false;
		if (contactId != null && !contactId.equals(equalCheck.contactId))
			return false;
		return true;
	}
}
