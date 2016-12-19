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
import javax.persistence.NamedNativeQuery;
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
import org.hibernate.annotations.NamedNativeQueries;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findTrBoardApprovalById", query = "select myTrBoardApproval from TrBoardApproval myTrBoardApproval where myTrBoardApproval.boardApprovalId = ?1"),
		@NamedQuery(name = "findAllTrBoardApproval", query = "select myTrBoardApproval from TrBoardApproval myTrBoardApproval"),
		@NamedQuery(name = "findTrBoardApprovalByMainImageUrl", query = "select myTrBoardApproval from TrBoardApproval myTrBoardApproval where myTrBoardApproval.mainImageUrl = ?1 AND myTrBoardApproval.processStatus = NULL")
		 })
@Table( name = "tr_board_approval")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrBoardApproval")
public class TrBoardApproval implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Column(name = "BOARD_APPROVAL_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer boardApprovalId;
	/**
	 */
	
	@Column(name = "MAIN_IMAGE_URL", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String mainImageUrl;
	/**
	 */
	
	@Column(name = "APPROVAL_STATUS", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer approvalStatus;
	/**
	 */
	
	@Column(name = "COMMENTS", length=2000,nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String comments;
	/**
	 */
	
	@Column(name = "APPROVER_NAME", length = 200, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String approverName;
	/**
	 */
	
	@Column(name = "PROCESS_STATUS", length = 12, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String processStatus;
	/**
	 */
	
	@Column(name = "ERROR_MESSAGE", length = 2000, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String errorMessage;
	/**
	 */
	
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
	
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = true) })
	@XmlTransient
	TrBoard trBoard;
	
	
	public TrBoard getTrBoard() {
		return trBoard;
	}
	public void setTrBoard(TrBoard trBoard) {
		this.trBoard = trBoard;
	}
	public Integer getBoardApprovalId() {
		return boardApprovalId;
	}
	public void setBoardApprovalId(Integer boardApprovalId) {
		this.boardApprovalId = boardApprovalId;
	}
	public String getMainImageUrl() {
		return mainImageUrl;
	}
	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}
	public Integer getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Calendar getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Calendar getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approvalStatus == null) ? 0 : approvalStatus.hashCode());
		result = prime * result
				+ ((approverName == null) ? 0 : approverName.hashCode());
		result = prime * result
				+ ((boardApprovalId == null) ? 0 : boardApprovalId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result
				+ ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result
				+ ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
		result = prime * result
				+ ((mainImageUrl == null) ? 0 : mainImageUrl.hashCode());
		result = prime * result
				+ ((processStatus == null) ? 0 : processStatus.hashCode());
		result = prime * result + ((trBoard == null) ? 0 : trBoard.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrBoardApproval other = (TrBoardApproval) obj;
		if (approvalStatus == null) {
			if (other.approvalStatus != null)
				return false;
		} else if (!approvalStatus.equals(other.approvalStatus))
			return false;
		if (approverName == null) {
			if (other.approverName != null)
				return false;
		} else if (!approverName.equals(other.approverName))
			return false;
		if (boardApprovalId == null) {
			if (other.boardApprovalId != null)
				return false;
		} else if (!boardApprovalId.equals(other.boardApprovalId))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (lastUpdatedBy == null) {
			if (other.lastUpdatedBy != null)
				return false;
		} else if (!lastUpdatedBy.equals(other.lastUpdatedBy))
			return false;
		if (mainImageUrl == null) {
			if (other.mainImageUrl != null)
				return false;
		} else if (!mainImageUrl.equals(other.mainImageUrl))
			return false;
		if (processStatus == null) {
			if (other.processStatus != null)
				return false;
		} else if (!processStatus.equals(other.processStatus))
			return false;
		if (trBoard == null) {
			if (other.trBoard != null)
				return false;
		} else if (!trBoard.equals(other.trBoard))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TrBoardApproval [boardApprovalId=" + boardApprovalId
				+ ", mainImageUrl=" + mainImageUrl + ", approvalStatus="
				+ approvalStatus + ", comments=" + comments + ", approverName="
				+ approverName + ", processStatus=" + processStatus
				+ ", errorMessage=" + errorMessage + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", trBoard=" + trBoard + "]";
	}
}
