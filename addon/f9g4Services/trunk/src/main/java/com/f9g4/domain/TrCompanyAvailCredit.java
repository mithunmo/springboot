package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
	@NamedQuery(name = "findAvailCreditByUserId", query = "select myTrCompanyAvailCredit from TrCompanyAvailCredit myTrCompanyAvailCredit where myTrCompanyAvailCredit.userId = ?1  "),
	@NamedQuery(name = "findTotalAvailCreditByUserId", query = "select sum(myTrCompanyAvailCredit.total) from TrCompanyAvailCredit myTrCompanyAvailCredit where myTrCompanyAvailCredit.userId = ?1 group by (myTrCompanyAvailCredit.userId) ")
	
 })
@Table(name = "tr_company_avail_credit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrCompanyAvailCredit")
public class TrCompanyAvailCredit implements Serializable {

	private static final long serialVersionUID = 1L;
			
	@Column(name = "total", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer total;
	/**
	 */
			
	@Column(name = "COMPANY_CREDIT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer companyCreditId;
	/**
	 */

	@Column(name = "USER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer userId;
	/**
	 */
	
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}	
	
	public Integer getCompanyCreditId() {
		return companyCreditId;
	}

	public void setCompanyCreditId(Integer companyCreditId) {
		this.companyCreditId = companyCreditId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TrCompanyAvailCredit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrCompanyAvailCredit that) {
		setCompanyCreditId(that.getCompanyCreditId());
		setUserId(that.getUserId());
		setTotal(that.getTotal());
	}


	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();
		buffer.append("companyCreditId=[").append(companyCreditId).append("] ");
		buffer.append("total=[").append(total).append("] ");
		buffer.append("userId=[").append(userId).append("] ");
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
		if (!(obj instanceof TrCompanyAvailCredit))
			return false;
		TrCompanyAvailCredit equalCheck = (TrCompanyAvailCredit) obj;
		if (( companyCreditId == null && equalCheck.companyCreditId != null) || (companyCreditId != null && equalCheck.companyCreditId == null))
			return false;
		if (companyCreditId != null && !companyCreditId.equals(equalCheck.companyCreditId))
			return false;
		return true;
	}
}
