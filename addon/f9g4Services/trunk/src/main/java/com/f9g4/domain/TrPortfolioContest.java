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
		@NamedQuery(name = "findAllTrPortfolioContest", query = "select myTrPortfolioContest from TrPortfolioContest myTrPortfolioContest"),
		@NamedQuery(name = "findTrPortfolioContestByPortfolioId", query = "select myTrPortfolioContest from TrPortfolioContest myTrPortfolioContest where myTrPortfolioContest.trPortfolio.portfolioId = ?1 "),
		@NamedQuery(name = "findTrPortfolioByContestIdAndPortfolioId", query = "select myTrPortfolioContest from TrPortfolioContest myTrPortfolioContest where myTrPortfolioContest.trPortfolio.portfolioId = ?1 and myTrPortfolioContest.contestId = ?2  "),
				
 })
@Table( name = "tr_portfolio_contest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrPortfolioContest")
public class TrPortfolioContest implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 */
	
	@GeneratedValue
	@Column(name = "CONTEST_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer contestId;
	/**
	 * 	 
	 */
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PORTFOLIO_ID", referencedColumnName = "PORTFOLIO_ID", nullable = false) })
	@XmlTransient
	TrPortfolio trPortfolio;
	/**
	 */

	@Column(name = "CATEGORY", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String category;
	/**
	 */

	@Column(name = "INTRODUCTION", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String introduction;
	/**
	 */
		
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

	@Column(name = "LAST_UPDATE_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpatedBy;
	/**
	 */
	
	@Column(name = "PROJECT_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer projectStatus;
	/**
	 */

	@Column(name = "PROJECT_Type", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer projectType;
	/**
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;
	/**
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endDate;
	/**
	 */
	
	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;
	/**
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BOARD_DIMENSION", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesDimension;

	/**
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "BOARD_FORMAT", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesFormat;
	/**
	 */
	
	@Column(name = "DELIVERABLE", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String deliverable;
	/**
	 */
	
	@Column(name = "OTHER_INFORMATION", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String otherInformation;	
	/**
	 */

	@Column(name = "NUMBER_OF_WINNERS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numberOfWinners;
	/**
	 */
	
	@Column(name = "ASSOCIATED_BRANDS_INFLUENCE", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String associatedBrandsInfluence;
	/**
	 */
	
	@Column(name = "ASSOCIATED_BRANDS_HANG_WITH", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String associatedBrandsHangWith;	
	
	/**
	 */
	public Integer getContestId() {
		return contestId;
	}

	/**
	 */
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	
	/**
	 */
	public TrPortfolio getTrPortfolio() {
		return trPortfolio;
	}

	/**
	 */
	public void setTrPortfolio(TrPortfolio trPortfolio) {
		this.trPortfolio = trPortfolio;
	}
	
	/**
	 */
	public String getCategory() {
		return category;
	}

	/**
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 */
	public Integer getProjectStatus() {
		return projectStatus;
	}

	/**
	 */
	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	/**
	 */
	public Integer getProjectType() {
		return projectType;
	}

	/**
	 */
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	/**
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 */
	public String getLangCode() {
		return langCode;
	}

	/**
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	
	/**
	 */
	public AdLookupValues getAdLookupValuesDimension() {
		return adLookupValuesDimension;
	}

	/**
	 */
	public void setAdLookupValuesDimension(AdLookupValues adLookupValuesDimension) {
		this.adLookupValuesDimension = adLookupValuesDimension;
	}

	/**
	 */
	public AdLookupValues getAdLookupValuesFormat() {
		return adLookupValuesFormat;
	}

	/**
	 */
	public void setAdLookupValuesFormat(AdLookupValues adLookupValuesFormat) {
		this.adLookupValuesFormat = adLookupValuesFormat;
	}

	/**
	 */
	public String getDeliverable() {
		return deliverable;
	}

	/**
	 */
	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}

	/**
	 */
	public String getOtherInformation() {
		return otherInformation;
	}

	/**
	 */
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	/**
	 */
	public Integer getNumberOfWinners() {
		return numberOfWinners;
	}

	/**
	 */
	public void setNumberOfWinners(Integer numberOfWinners) {
		this.numberOfWinners = numberOfWinners;
	}

	/**
	 */
	public String getAssociatedBrandsInfluence() {
		return associatedBrandsInfluence;
	}

	/**
	 */
	public void setAssociatedBrandsInfluence(String associatedBrandsInfluence) {
		this.associatedBrandsInfluence = associatedBrandsInfluence;
	}

	/**
	 */
	public String getAssociatedBrandsHangWith() {
		return associatedBrandsHangWith;
	}

	/**
	 */
	public void setAssociatedBrandsHangWith(String associatedBrandsHangWith) {
		this.associatedBrandsHangWith = associatedBrandsHangWith;
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
	public TrPortfolioContest() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrPortfolioContest that) {
		
		setContestId(that.getContestId());
		setTrPortfolio(that.getTrPortfolio());
		setStartDate(that.getStartDate());
		setEndDate(that.getEndDate());
		setCategory(that.getCategory());
		setIntroduction(that.getIntroduction());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpatedBy(that.getLastUpatedBy());
		setLangCode(that.getLangCode());
		setProjectStatus(that.getProjectStatus());
		setProjectType(that.getProjectType());
		setAdLookupValuesDimension(that.getAdLookupValuesDimension());
		setAdLookupValuesFormat(that.getAdLookupValuesFormat());
		setNumberOfWinners(that.getNumberOfWinners());
		setDeliverable(that.getDeliverable());
		setOtherInformation(that.getOtherInformation());
		setAssociatedBrandsHangWith(that.getAssociatedBrandsHangWith());
		setAssociatedBrandsInfluence(that.getAssociatedBrandsInfluence());
		
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("contestId=[").append(contestId).append("] ");
		buffer.append("category=[").append(category).append("] ");
		buffer.append("introduction=[").append(introduction).append("] ");
		buffer.append("projectType=[").append(projectType).append("] ");
		buffer.append("projectStatus=[").append(projectStatus).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");
		buffer.append("endDate=[").append(endDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpatedBy=[").append(lastUpatedBy).append("] ");
		buffer.append("langCode=[").append(langCode).append("] ");
		buffer.append("associatedBrandsHangWith=[").append(associatedBrandsHangWith).append("] ");
		buffer.append("associatedBrandsInfluence=[").append(associatedBrandsInfluence).append("] ");
		buffer.append("numberOfWinners=[").append(numberOfWinners).append("] ");
		buffer.append("otherInformation=[").append(otherInformation).append("] ");
		buffer.append("deliverable=[").append(deliverable).append("] ");
		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((contestId == null) ? 0 : contestId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrPortfolioContest))
			return false;
		TrPortfolioContest equalCheck = (TrPortfolioContest) obj;
		if (( contestId == null && equalCheck.contestId != null) || (contestId != null && equalCheck.contestId == null))
			return false;
		if (contestId != null && !contestId.equals(equalCheck.contestId))
			return false;
		return true;
	}
}
