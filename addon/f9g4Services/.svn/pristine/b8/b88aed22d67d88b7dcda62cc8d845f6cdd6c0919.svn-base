package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
		@NamedQuery(name = "findAllTrRatingss", query = "select myTrRatings from TrRatings myTrRatings"),
		@NamedQuery(name = "findTrRatingsByAvgRating", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.avgRating = ?1"),
		@NamedQuery(name = "findTrRatingsByComment", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.comment = ?1"),
		@NamedQuery(name = "findTrRatingsByCommentContaining", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.comment like ?1"),
		@NamedQuery(name = "findTrRatingsByCreatedBy", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.createdBy = ?1"),
		@NamedQuery(name = "findTrRatingsByCreationDate", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.creationDate = ?1"),
		@NamedQuery(name = "findTrRatingsByLangCode", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.langCode = ?1"),
		@NamedQuery(name = "findTrRatingsByLangCodeContaining", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.langCode like ?1"),
		@NamedQuery(name = "findTrRatingsByLastUpdateDate", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrRatingsByLastUpdatedBy", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrRatingsByPrimaryKey", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.ratingId = ?1"),
		@NamedQuery(name = "findTrRatingsByRating1", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.rating1 = ?1"),
		@NamedQuery(name = "findTrRatingsByRating2", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.rating2 = ?1"),
		@NamedQuery(name = "findTrRatingsByRating3", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.rating3 = ?1"),
		@NamedQuery(name = "findTrRatingsByRating4", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.rating4 = ?1"),
		@NamedQuery(name = "findTrRatingsByRating5", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.rating5 = ?1"),
		@NamedQuery(name = "findTrRatingsByRating6", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.rating6 = ?1"),
		@NamedQuery(name = "findTrRatingsByRatingId", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.ratingId = ?1"),
		@NamedQuery(name = "findTrRatingsByUserId", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.adUsers.userId = ?1"),
		@NamedQuery(name = "findTrRatingsByRatingUserId", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.adRatingUsers.userId = ?1"),
		@NamedQuery(name = "findTrRatingsByUserIdforBoardId", query = "select myTrRatings from TrRatings myTrRatings where  myTrRatings.adUsers.userId = ?1 and myTrRatings.trBoard.boardId = ?2"),
		@NamedQuery(name = "findTrRatingsByBoardId", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.trBoard.boardId = ?1"),
		@NamedQuery(name = "findTrRatingsByRatingQuestion6Id", query = "select myTrRatings from TrRatings myTrRatings where myTrRatings.ratingQuestion6Id = ?1") })


@Table( name = "tr_ratings")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrRatings")
public class TrRatings implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "RATING_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ratingId;
	/**
	 */

	@Column(name = "AVG_RATING", precision = 12, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal avgRating;
	/**
	 */

	@Column(name = "RATING1", precision = 12, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating1;
	/**
	 */

	@Column(name = "RATING2", precision = 12, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating2;
	/**
	 */

	@Column(name = "RATING3", precision = 12, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating3;
	/**
	 */

	@Column(name = "RATING4", precision = 12, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating4;
	/**
	 */

	@Column(name = "RATING5", precision = 12)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating5;
	/**
	 */

	@Column(name = "RATING_QUESTION6_ID")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ratingQuestion6Id;
	/**
	 */

	@Column(name = "RATING6", precision = 12)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rating6;
	/**
	 */

	@Column(name = "COMMENT", length = 4000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String comment;
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
	 * Positive, Negative, Neutral
	 * 
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATE_TRANSACTION_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByRateTransactionId;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard trBoard;
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATING_QUESTION2_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByRatingQuestion2Id;
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATING_QUESTION3_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByRatingQuestion3Id;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATING_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adRatingUsers;
	
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATING_QUESTION5_ID", referencedColumnName = "LOOKUP_VALUE_ID") })
	@XmlTransient
	AdLookupValues adLookupValuesByRatingQuestion5Id;
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATING_QUESTION4_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByRatingQuestion4Id;
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RATING_QUESTION1_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesByRatingQuestion1Id;

	/**
	 */
	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	/**
	 */
	public Integer getRatingId() {
		return this.ratingId;
	}

	/**
	 */
	public void setAvgRating(BigDecimal avgRating) {
		this.avgRating = avgRating;
	}

	/**
	 */
	public BigDecimal getAvgRating() {
		return this.avgRating;
	}

	/**
	 */
	public void setRating1(BigDecimal rating1) {
		this.rating1 = rating1;
	}

	/**
	 */
	public BigDecimal getRating1() {
		return this.rating1;
	}

	/**
	 */
	public void setRating2(BigDecimal rating2) {
		this.rating2 = rating2;
	}

	/**
	 */
	public BigDecimal getRating2() {
		return this.rating2;
	}

	/**
	 */
	public void setRating3(BigDecimal rating3) {
		this.rating3 = rating3;
	}

	/**
	 */
	public BigDecimal getRating3() {
		return this.rating3;
	}

	/**
	 */
	public void setRating4(BigDecimal rating4) {
		this.rating4 = rating4;
	}

	/**
	 */
	public BigDecimal getRating4() {
		return this.rating4;
	}

	/**
	 */
	public void setRating5(BigDecimal rating5) {
		this.rating5 = rating5;
	}

	/**
	 */
	public BigDecimal getRating5() {
		return this.rating5;
	}

	/**
	 */
	public void setRatingQuestion6Id(Integer ratingQuestion6Id) {
		this.ratingQuestion6Id = ratingQuestion6Id;
	}

	/**
	 */
	public Integer getRatingQuestion6Id() {
		return this.ratingQuestion6Id;
	}

	/**
	 */
	public void setRating6(BigDecimal rating6) {
		this.rating6 = rating6;
	}

	/**
	 */
	public BigDecimal getRating6() {
		return this.rating6;
	}

	/**
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 */
	public String getComment() {
		return this.comment;
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
	 * Positive, Negative, Neutral
	 * 
	 */
	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * Positive, Negative, Neutral
	 * 
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
	public void setAdLookupValuesByRateTransactionId(AdLookupValues adLookupValuesByRateTransactionId) {
		this.adLookupValuesByRateTransactionId = adLookupValuesByRateTransactionId;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByRateTransactionId() {
		return adLookupValuesByRateTransactionId;
	}

	/**
	 */
	public void setTrBoard(TrBoard trBoard) {
		this.trBoard = trBoard;
	}

	/**
	 */
	@JsonIgnore
	public TrBoard getTrBoard() {
		return trBoard;
	}

	/**
	 */
	public void setAdLookupValuesByRatingQuestion2Id(AdLookupValues adLookupValuesByRatingQuestion2Id) {
		this.adLookupValuesByRatingQuestion2Id = adLookupValuesByRatingQuestion2Id;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByRatingQuestion2Id() {
		return adLookupValuesByRatingQuestion2Id;
	}

	/**
	 */
	public void setAdLookupValuesByRatingQuestion3Id(AdLookupValues adLookupValuesByRatingQuestion3Id) {
		this.adLookupValuesByRatingQuestion3Id = adLookupValuesByRatingQuestion3Id;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByRatingQuestion3Id() {
		return adLookupValuesByRatingQuestion3Id;
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
	public void setAdLookupValuesByRatingQuestion5Id(AdLookupValues adLookupValuesByRatingQuestion5Id) {
		this.adLookupValuesByRatingQuestion5Id = adLookupValuesByRatingQuestion5Id;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByRatingQuestion5Id() {
		return adLookupValuesByRatingQuestion5Id;
	}

	/**
	 */
	public void setAdLookupValuesByRatingQuestion4Id(AdLookupValues adLookupValuesByRatingQuestion4Id) {
		this.adLookupValuesByRatingQuestion4Id = adLookupValuesByRatingQuestion4Id;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByRatingQuestion4Id() {
		return adLookupValuesByRatingQuestion4Id;
	}

	/**
	 */
	public void setAdLookupValuesByRatingQuestion1Id(AdLookupValues adLookupValuesByRatingQuestion1Id) {
		this.adLookupValuesByRatingQuestion1Id = adLookupValuesByRatingQuestion1Id;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValuesByRatingQuestion1Id() {
		return adLookupValuesByRatingQuestion1Id;
	}
	
	

	public AdUsers getAdRatingUsers() {
		return adRatingUsers;
	}

	public void setAdRatingUsers(AdUsers adRatingUsers) {
		this.adRatingUsers = adRatingUsers;
	}

	/**
	 */
	public TrRatings() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrRatings that) {
		setRatingId(that.getRatingId());
		setAvgRating(that.getAvgRating());
		setRating1(that.getRating1());
		setRating2(that.getRating2());
		setRating3(that.getRating3());
		setRating4(that.getRating4());
		setRating5(that.getRating5());
		setRatingQuestion6Id(that.getRatingQuestion6Id());
		setRating6(that.getRating6());
		setComment(that.getComment());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setAdLookupValuesByRateTransactionId(that.getAdLookupValuesByRateTransactionId());
		setTrBoard(that.getTrBoard());
		setAdLookupValuesByRatingQuestion2Id(that.getAdLookupValuesByRatingQuestion2Id());
		setAdLookupValuesByRatingQuestion3Id(that.getAdLookupValuesByRatingQuestion3Id());
		setAdUsers(that.getAdUsers());
		setAdLookupValuesByRatingQuestion5Id(that.getAdLookupValuesByRatingQuestion5Id());
		setAdLookupValuesByRatingQuestion4Id(that.getAdLookupValuesByRatingQuestion4Id());
		setAdLookupValuesByRatingQuestion1Id(that.getAdLookupValuesByRatingQuestion1Id());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("ratingId=[").append(ratingId).append("] ");
		buffer.append("avgRating=[").append(avgRating).append("] ");
		buffer.append("rating1=[").append(rating1).append("] ");
		buffer.append("rating2=[").append(rating2).append("] ");
		buffer.append("rating3=[").append(rating3).append("] ");
		buffer.append("rating4=[").append(rating4).append("] ");
		buffer.append("rating5=[").append(rating5).append("] ");
		buffer.append("ratingQuestion6Id=[").append(ratingQuestion6Id).append("] ");
		buffer.append("rating6=[").append(rating6).append("] ");
		buffer.append("comment=[").append(comment).append("] ");
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
		result = (int) (prime * result + ((ratingId == null) ? 0 : ratingId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrRatings))
			return false;
		TrRatings equalCheck = (TrRatings) obj;
		if ((ratingId == null && equalCheck.ratingId != null) || (ratingId != null && equalCheck.ratingId == null))
			return false;
		if (ratingId != null && !ratingId.equals(equalCheck.ratingId))
			return false;
		return true;
	}
}
