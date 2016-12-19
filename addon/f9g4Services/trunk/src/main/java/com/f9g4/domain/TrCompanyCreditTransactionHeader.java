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
@Table( name = "tr_company_credit_transaction_header")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrCompanyCreditTransactionHeader")
public class TrCompanyCreditTransactionHeader implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue
	@Column(name = "TXN_HEADER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer txnHeaderId;
		
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
	
	@Column(name = "TOTAL_CREDITS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer totalCredits;
	
		
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


	public Integer getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Integer getTxnHeaderId() {
		return txnHeaderId;
	}

	public void setTxnHeaderId(Integer txnHeaderId) {
		this.txnHeaderId = txnHeaderId;
	}
	
	
	public TrCompanyCreditTransactionHeader() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrCompanyCreditTransactionHeader that) {
		setTxnHeaderId(that.getTxnHeaderId());
		setTotalCredits(that.getTotalCredits());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());		
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();
		buffer.append("txnHeaderId=[").append(txnHeaderId).append("] ");
		buffer.append("totalCredits=[").append(totalCredits).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((txnHeaderId == null) ? 0 : txnHeaderId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrCompanyCreditTransactionHeader))
			return false;
		TrCompanyCreditTransactionHeader equalCheck = (TrCompanyCreditTransactionHeader) obj;
		if (( txnHeaderId == null && equalCheck.txnHeaderId != null) || (txnHeaderId != null && equalCheck.txnHeaderId == null))
			return false;
		if (txnHeaderId != null && !txnHeaderId.equals(equalCheck.txnHeaderId))
			return false;
		return true;
	}
}
