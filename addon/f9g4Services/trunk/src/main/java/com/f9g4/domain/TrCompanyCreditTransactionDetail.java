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
@Table( name = "tr_company_credit_transaction_detail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrCompanyCreditTransactionDetail")
public class TrCompanyCreditTransactionDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 */
	@GeneratedValue
	@Column(name = "TXN_DETAIL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer txnDetailId;
			
	@Column(name = "NUM_CREDITS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numCredits;
	/**
	 */

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "TXN_HEADER_ID", referencedColumnName = "TXN_HEADER_ID", nullable = false) })
	@XmlTransient
	TrCompanyCreditTransactionHeader txnHeaderId;
	
		
	@Column(name = "COMPANY_CREDIT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer companyCreditId;
	/**
	 */
	
	public Integer getTxnDetailId() {
		return txnDetailId;
	}

	public void setTxnDetailId(Integer txnDetailId) {
		this.txnDetailId = txnDetailId;
	}

	public Integer getNumCredits() {
		return numCredits;
	}

	public void setNumCredits(Integer numCredits) {
		this.numCredits = numCredits;
	}


	public TrCompanyCreditTransactionHeader getTxnHeaderId() {
		return txnHeaderId;
	}

	public void setTxnHeaderId(TrCompanyCreditTransactionHeader txnHeaderId) {
		this.txnHeaderId = txnHeaderId;
	}

	public Integer getCompanyCreditId() {
		return companyCreditId;
	}

	public void setCompanyCreditId(Integer companyCreditId) {
		this.companyCreditId = companyCreditId;
	}
	
	public TrCompanyCreditTransactionDetail() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrCompanyCreditTransactionDetail that) {
		setCompanyCreditId(that.getCompanyCreditId());
		setNumCredits(that.getNumCredits());
		setTxnDetailId(that.getTxnDetailId());
	}


	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();
		buffer.append("companyCreditId=[").append(companyCreditId).append("] ");
		buffer.append("numCredits=[").append(numCredits).append("] ");
		buffer.append("txnDetailId=[").append(txnDetailId).append("] ");
		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((txnDetailId == null) ? 0 : txnDetailId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrCompanyCreditTransactionDetail))
			return false;
		TrCompanyCreditTransactionDetail equalCheck = (TrCompanyCreditTransactionDetail) obj;
		if (( txnDetailId == null && equalCheck.txnDetailId != null) || (txnDetailId != null && equalCheck.txnDetailId == null))
			return false;
		if (txnDetailId != null && !txnDetailId.equals(equalCheck.txnDetailId))
			return false;
		return true;
	}
}
