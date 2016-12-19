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
		@NamedQuery(name = "findAdActiveUsersByActiveUserId", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.activeUserId = ?1"),
		@NamedQuery(name = "findAdActiveUsersByCreatedBy", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.createdBy = ?1"),
		@NamedQuery(name = "findAdActiveUsersByCreationDate", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.creationDate = ?1"),
		@NamedQuery(name = "findAdActiveUsersByLastUpdateDate", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.lastUpdateDate = ?1"),
		@NamedQuery(name = "findAdActiveUsersByLastUpdatedBy", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findAdActiveUsersByLoginDate", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.loginDate = ?1"),
		@NamedQuery(name = "findAdActiveUsersByLogoutDate", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.logoutDate = ?1"),
		@NamedQuery(name = "findAdActiveUsersByPrimaryKey", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.activeUserId = ?1"),
		@NamedQuery(name = "findAdActiveUsersBySessionId", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers where myAdActiveUsers.sessionId = ?1"),
		@NamedQuery(name = "findAllAdActiveUserss", query = "select myAdActiveUsers from AdActiveUsers myAdActiveUsers") })
@Table( name = "ad_active_users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "AdActiveUsers")
public class AdActiveUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Primary Key
	 * 
	 */

	@Column(name = "ACTIVE_USER_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer activeUserId;
	/**
	 * Date/time of user login
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar loginDate;
	/**
	 * User logout timestamp
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGOUT_DATE")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar logoutDate;
	/**
	 * Session ID of the current user session
	 * 
	 */

	@Column(name = "SESSION_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String sessionId;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsers;

	/**
	 * Primary Key
	 * 
	 */
	public void setActiveUserId(Integer activeUserId) {
		this.activeUserId = activeUserId;
	}

	/**
	 * Primary Key
	 * 
	 */
	public Integer getActiveUserId() {
		return this.activeUserId;
	}

	/**
	 * Date/time of user login
	 * 
	 */
	public void setLoginDate(Calendar loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * Date/time of user login
	 * 
	 */
	public Calendar getLoginDate() {
		return this.loginDate;
	}

	/**
	 * User logout timestamp
	 * 
	 */
	public void setLogoutDate(Calendar logoutDate) {
		this.logoutDate = logoutDate;
	}

	/**
	 * User logout timestamp
	 * 
	 */
	public Calendar getLogoutDate() {
		return this.logoutDate;
	}

	/**
	 * Session ID of the current user session
	 * 
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Session ID of the current user session
	 * 
	 */
	public String getSessionId() {
		return this.sessionId;
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
	public AdActiveUsers() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AdActiveUsers that) {
		setActiveUserId(that.getActiveUserId());
		setLoginDate(that.getLoginDate());
		setLogoutDate(that.getLogoutDate());
		setSessionId(that.getSessionId());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setAdUsers(that.getAdUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("activeUserId=[").append(activeUserId).append("] ");
		buffer.append("loginDate=[").append(loginDate).append("] ");
		buffer.append("logoutDate=[").append(logoutDate).append("] ");
		buffer.append("sessionId=[").append(sessionId).append("] ");
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
		result = (int) (prime * result + ((activeUserId == null) ? 0 : activeUserId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AdActiveUsers))
			return false;
		AdActiveUsers equalCheck = (AdActiveUsers) obj;
		if ((activeUserId == null && equalCheck.activeUserId != null) || (activeUserId != null && equalCheck.activeUserId == null))
			return false;
		if (activeUserId != null && !activeUserId.equals(equalCheck.activeUserId))
			return false;
		return true;
	}
}
