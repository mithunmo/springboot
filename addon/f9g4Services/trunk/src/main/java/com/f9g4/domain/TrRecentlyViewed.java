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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
		@NamedQuery(name = "findAllTrRecentlyVieweds", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed"),
		@NamedQuery(name = "findTrRecentlyViewedByClickId", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.clickId = ?1"),
		@NamedQuery(name = "findTrRecentlyViewedByCreatedBy", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.createdBy = ?1"),
		@NamedQuery(name = "findTrRecentlyViewedByCreationDate", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.creationDate = ?1"),
		@NamedQuery(name = "findTrRecentlyViewedByEventTimestamp", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.eventTimestamp = ?1"),
		@NamedQuery(name = "findTrRecentlyViewedByLastUpdateDate", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrRecentlyViewedByLastUpdatedBy", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrRecentlyViewedByPrimaryKey", query = "select myTrRecentlyViewed from TrRecentlyViewed myTrRecentlyViewed where myTrRecentlyViewed.clickId = ?1")
		})

@NamedNativeQueries({
@NamedNativeQuery(name = "findCompanyGridInfo", query = "select tv.*, tbi.*,sy.*,tb.*,au.*, (tb.total_price+((tb.total_price*commission)/100)) TEMP_SALE_PRICE "+ 
" from tr_recently_viewed  tv, tr_board tb, tr_board_images tbi, st_season_year sy, tr_portfolio tp, ad_users au, st_mem_pricing_options po "+
" where tb.board_id = tv.board_id "+  
" and tb.board_id = tbi.board_id "+  
" and tp.portfolio_id = tb.portfolio_id "+      
" and sy.season_year_id = tp.season_year_id "+
" and au.user_id = tb.original_user_id " +
" and tb.active_status = 1 "+ 
" and (tb.publish_to_mp = 1 OR tb.status_id = 471) "+  
" and date(tb.expiration_date) > sysdate() "+ 
" AND po.mem_pricing_id = ?3 "+
" and tv.user_id =?1 " + 
" and date(tv.event_timestamp) > ?2 "+
" order by event_timestamp desc "
,resultClass=com.f9g4.domain.TrActivityScreenCompanyGrid.class),

@NamedNativeQuery(name = "findDesignerGridInfo", query =   " select tv.*,tb.*, tbi.*,sy.*, tp.name as PORTFOLIO_NAME "+
" from tr_recently_viewed  tv, tr_board tb, tr_board_images tbi,tr_portfolio tp,st_season_year sy "+
" where tb.board_id = tv.board_id " +  
" and tb.board_id = tbi.board_id "+ 
" and tp.portfolio_id = tb.portfolio_id "+ 
" and tp.season_year_id = sy.season_year_id "+
" and date(tb.expiration_date) > sysdate() "+ 
" and tb.original_user_id = ?1 " +
" and date(tv.event_timestamp) > ?2 "+
" order by event_timestamp desc "  
,resultClass=com.f9g4.domain.TrActivityScreenDesignerGrid.class),

@NamedNativeQuery(name = "findCompanyCount", query =   " select count(*) as COUNT "+ 
" from tr_recently_viewed  tv, tr_board tb "+
" where tb.board_id = tv.board_id "+  
" and tb.active_status = 1 "+ 
" and (tb.publish_to_mp = 1 OR tb.status_id = 471) "+  
" and date(tb.expiration_date) > sysdate() "+ 
" and tv.user_id =?1 " + 
" and date(tv.event_timestamp) > ?2 ",resultClass=com.f9g4.domain.SingleResultLong.class ),

@NamedNativeQuery(name = "findDesignerCount", query =   " select count(*) as COUNT "+ 
" from tr_recently_viewed  tv, tr_board tb "+
" where tb.board_id = tv.board_id "+  
" and date(tb.expiration_date) > sysdate() "+ 
" and tb.original_user_id = ?1 "+
" and date(tv.event_timestamp) > ?2 ",resultClass=com.f9g4.domain.SingleResultLong.class ),

@NamedNativeQuery(name = "findCompanyGraphInfo", query =" select date(tv.event_timestamp) as time_stamp,count(*) as hit_count" +
			 " from tr_recently_viewed  tv, tr_board tb "+ 
			 " where tb.board_id = tv.board_id "+  
			 " and tb.active_status = 1 "+ 
			 " and (tb.publish_to_mp = 1 OR tb.status_id = 471) "+
			 " and tb.expiration_date > sysdate() "+
			 " and tv.user_id =?1 "+ 
			 " and date(tv.event_timestamp) > ?2 "+
" Group by  date(tv.event_timestamp) ;"
,resultClass=com.f9g4.domain.TrActivityScreenGraph.class),
@NamedNativeQuery(name = "findDesignerGraphInfo", query =" select date(tv.event_timestamp) as time_stamp,count(*) as hit_count " +
			 "from tr_recently_viewed  tv, tr_board tb"+
			 " where tb.board_id = tv.board_id "+   
			 " and tb.expiration_date > sysdate() "+ 
             " and tb.original_user_id = ?1 " +
             " and tv.event_timestamp > ?2 "+
             " Group by  date(tv.event_timestamp);"
,resultClass=com.f9g4.domain.TrActivityScreenGraph.class)

})

@Table( name = "tr_recently_viewed")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrRecentlyViewed")
public class TrRecentlyViewed implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Primary Key
	 * 
	 */

	@Column(name = "CLICK_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer clickId;
	/**
	 * Event Date timestamp.
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_TIMESTAMP", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar eventTimestamp;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "BOARD_ID", referencedColumnName = "BOARD_ID", nullable = false) })
	@XmlTransient
	TrBoard trBoard;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 * Primary Key
	 * 
	 */
	public void setClickId(Integer clickId) {
		this.clickId = clickId;
	}

	/**
	 * Primary Key
	 * 
	 */
	public Integer getClickId() {
		return this.clickId;
	}

	/**
	 * Event Date timestamp.
	 * 
	 */
	public void setEventTimestamp(Calendar eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}

	/**
	 * Event Date timestamp.
	 * 
	 */
	public Calendar getEventTimestamp() {
		return this.eventTimestamp;
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
	public TrRecentlyViewed() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrRecentlyViewed that) {
		setClickId(that.getClickId());
		setEventTimestamp(that.getEventTimestamp());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setTrBoard(that.getTrBoard());
		setAdUsers(that.getAdUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("clickId=[").append(clickId).append("] ");
		buffer.append("eventTimestamp=[").append(eventTimestamp).append("] ");
		buffer.append("creationDate=[").append(creationDate).append("] ");
		buffer.append("createdBy=[").append(createdBy).append("] ");
		buffer.append("lastUpdateDate=[").append(lastUpdateDate).append("] ");
		buffer.append("lastUpdatedBy=[").append(lastUpdatedBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((clickId == null) ? 0 : clickId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrRecentlyViewed))
			return false;
		TrRecentlyViewed equalCheck = (TrRecentlyViewed) obj;
		if ((clickId == null && equalCheck.clickId != null) || (clickId != null && equalCheck.clickId == null))
			return false;
		if (clickId != null && !clickId.equals(equalCheck.clickId))
			return false;
		return true;
	}
}
