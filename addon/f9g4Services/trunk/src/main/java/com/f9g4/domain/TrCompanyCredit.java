package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
	
 })
@Table( name = "tr_company_credit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrCompanyCredit")
public class TrCompanyCredit implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue
	@Column(name = "COMPANY_CREDIT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer companyCreditId;
		
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUser;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = true)
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
	@Column(name = "LAST_UPDATE_DATE", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastUpdateDate;
	/**
	 */

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpatedBy;

	
	@Column(name = "TOTAL_CREDITS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer totalCredits;
	/**
	 */

	@Column(name = "CREDIT_VAL", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer creditVal;
	/**
	 */

	@Column(name = "TOTAL_CREDIT_AMOUNT", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer totalCreditAmount;
	/**
	 */
	
	public AdUsers getAdUser() {
		return adUser;
	}

	public void setAdUser(AdUsers adUser) {
		this.adUser = adUser;
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
	public void setLastUpatedBy(Integer lastUpatedBy) {
		this.lastUpatedBy = lastUpatedBy;
	}

	/**
	 */
	public Integer getLastUpatedBy() {
		return this.lastUpatedBy;
	}	
	
	/**
	 */
	
	public Integer getCompanyCreditId() {
		return companyCreditId;
	}

	public void setCompanyCreditId(Integer companyCreditId) {
		this.companyCreditId = companyCreditId;
	}

	public Integer getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Integer getCreditVal() {
		return creditVal;
	}

	public void setCreditVal(Integer creditVal) {
		this.creditVal = creditVal;
	}

	public Integer getTotalCreditAmount() {
		return totalCreditAmount;
	}

	public void setTotalCreditAmount(Integer totalCreditAmount) {
		this.totalCreditAmount = totalCreditAmount;
	}
	
	
	
	public TrCompanyCredit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrCompanyCredit that) {
		setCompanyCreditId(that.getCompanyCreditId());
		setTotalCreditAmount(that.getTotalCreditAmount());
		setTotalCredits(that.getTotalCredits());
		setCreditVal(that.getCreditVal());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpatedBy(that.getLastUpatedBy());
		
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();
		buffer.append("companyCreditId=[").append(companyCreditId).append("] ");
		buffer.append("totalCreditAmount=[").append(totalCreditAmount).append("] ");
		buffer.append("totalCredits=[").append(totalCredits).append("] ");
		buffer.append("creditVal=[").append(creditVal).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpatedBy=[").append(lastUpatedBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((companyCreditId == null) ? 0 : companyCreditId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrCompanyCredit))
			return false;
		TrCompanyCredit equalCheck = (TrCompanyCredit) obj;
		if (( companyCreditId == null && equalCheck.companyCreditId != null) || (companyCreditId != null && equalCheck.companyCreditId == null))
			return false;
		if (companyCreditId != null && !companyCreditId.equals(equalCheck.companyCreditId))
			return false;
		return true;
	}
}
