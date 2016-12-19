package com.f9g4.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllStCategoryDenorms", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel1Id", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel1Id = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel1Value", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel1Value = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel1ValueContaining", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel1Value like ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel2Id", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel2Id = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel2Value", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel2Value = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel2ValueContaining", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel2Value like ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel3Id", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel3Id = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel3Value", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel3Value = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel3ValueContaining", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel3Value like ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel4Id", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel4Id = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel4Value", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel4Value = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel4ValueContaining", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel4Value like ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel5Id", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel5Id = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel5Value", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel5Value = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCatLevel5ValueContaining", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.catLevel5Value like ?1"),
		@NamedQuery(name = "findStCategoryDenormByCategoryDenormId", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.categoryDenormId = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCreatedBy", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.createdBy = ?1"),
		@NamedQuery(name = "findStCategoryDenormByCreationDate", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.creationDate = ?1"),
		@NamedQuery(name = "findStCategoryDenormByLangCode", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.langCode = ?1"),
		@NamedQuery(name = "findStCategoryDenormByLangCodeContaining", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.langCode like ?1"),
		@NamedQuery(name = "findStCategoryDenormByLastUpdateDate", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.lastUpdateDate = ?1"),
		@NamedQuery(name = "findStCategoryDenormByLastUpdatedBy", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findStCategoryDenormByPrimaryKey", query = "select myStCategoryDenorm from StCategoryDenorm myStCategoryDenorm where myStCategoryDenorm.categoryDenormId = ?1") })
@Table( name = "st_category_denorm")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "StCategoryDenorm")
public class StCategoryDenorm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CATEGORY_DENORM_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer categoryDenormId;
	/**
	 */

	@Column(name = "CAT_LEVEL1_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer catLevel1Id;
	/**
	 */

	@Column(name = "CAT_LEVEL1_VALUE", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String catLevel1Value;
	/**
	 */

	@Column(name = "CAT_LEVEL2_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer catLevel2Id;
	/**
	 */

	@Column(name = "CAT_LEVEL2_VALUE", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String catLevel2Value;
	/**
	 */

	@Column(name = "CAT_LEVEL3_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer catLevel3Id;
	/**
	 */

	@Column(name = "CAT_LEVEL3_VALUE", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String catLevel3Value;
	/**
	 */

	@Column(name = "CAT_LEVEL4_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer catLevel4Id;
	/**
	 */

	@Column(name = "CAT_LEVEL4_VALUE", length = 240, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String catLevel4Value;
	/**
	 */

	@Column(name = "CAT_LEVEL5_ID")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer catLevel5Id;
	/**
	 */

	@Column(name = "CAT_LEVEL5_VALUE", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String catLevel5Value;
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

	@Column(name = "LANG_CODE", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	/**
	 */
	public void setCategoryDenormId(Integer categoryDenormId) {
		this.categoryDenormId = categoryDenormId;
	}

	/**
	 */
	public Integer getCategoryDenormId() {
		return this.categoryDenormId;
	}

	/**
	 */
	public void setCatLevel1Id(Integer catLevel1Id) {
		this.catLevel1Id = catLevel1Id;
	}

	/**
	 */
	public Integer getCatLevel1Id() {
		return this.catLevel1Id;
	}

	/**
	 */
	public void setCatLevel1Value(String catLevel1Value) {
		this.catLevel1Value = catLevel1Value;
	}

	/**
	 */
	public String getCatLevel1Value() {
		return this.catLevel1Value;
	}

	/**
	 */
	public void setCatLevel2Id(Integer catLevel2Id) {
		this.catLevel2Id = catLevel2Id;
	}

	/**
	 */
	public Integer getCatLevel2Id() {
		return this.catLevel2Id;
	}

	/**
	 */
	public void setCatLevel2Value(String catLevel2Value) {
		this.catLevel2Value = catLevel2Value;
	}

	/**
	 */
	public String getCatLevel2Value() {
		return this.catLevel2Value;
	}

	/**
	 */
	public void setCatLevel3Id(Integer catLevel3Id) {
		this.catLevel3Id = catLevel3Id;
	}

	/**
	 */
	public Integer getCatLevel3Id() {
		return this.catLevel3Id;
	}

	/**
	 */
	public void setCatLevel3Value(String catLevel3Value) {
		this.catLevel3Value = catLevel3Value;
	}

	/**
	 */
	public String getCatLevel3Value() {
		return this.catLevel3Value;
	}

	/**
	 */
	public void setCatLevel4Id(Integer catLevel4Id) {
		this.catLevel4Id = catLevel4Id;
	}

	/**
	 */
	public Integer getCatLevel4Id() {
		return this.catLevel4Id;
	}

	/**
	 */
	public void setCatLevel4Value(String catLevel4Value) {
		this.catLevel4Value = catLevel4Value;
	}

	/**
	 */
	public String getCatLevel4Value() {
		return this.catLevel4Value;
	}

	/**
	 */
	public void setCatLevel5Id(Integer catLevel5Id) {
		this.catLevel5Id = catLevel5Id;
	}

	/**
	 */
	public Integer getCatLevel5Id() {
		return this.catLevel5Id;
	}

	/**
	 */
	public void setCatLevel5Value(String catLevel5Value) {
		this.catLevel5Value = catLevel5Value;
	}

	/**
	 */
	public String getCatLevel5Value() {
		return this.catLevel5Value;
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
	public StCategoryDenorm() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(StCategoryDenorm that) {
		setCategoryDenormId(that.getCategoryDenormId());
		setCatLevel1Id(that.getCatLevel1Id());
		setCatLevel1Value(that.getCatLevel1Value());
		setCatLevel2Id(that.getCatLevel2Id());
		setCatLevel2Value(that.getCatLevel2Value());
		setCatLevel3Id(that.getCatLevel3Id());
		setCatLevel3Value(that.getCatLevel3Value());
		setCatLevel4Id(that.getCatLevel4Id());
		setCatLevel4Value(that.getCatLevel4Value());
		setCatLevel5Id(that.getCatLevel5Id());
		setCatLevel5Value(that.getCatLevel5Value());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("categoryDenormId=[").append(categoryDenormId).append("] ");
		buffer.append("catLevel1Id=[").append(catLevel1Id).append("] ");
		buffer.append("catLevel1Value=[").append(catLevel1Value).append("] ");
		buffer.append("catLevel2Id=[").append(catLevel2Id).append("] ");
		buffer.append("catLevel2Value=[").append(catLevel2Value).append("] ");
		buffer.append("catLevel3Id=[").append(catLevel3Id).append("] ");
		buffer.append("catLevel3Value=[").append(catLevel3Value).append("] ");
		buffer.append("catLevel4Id=[").append(catLevel4Id).append("] ");
		buffer.append("catLevel4Value=[").append(catLevel4Value).append("] ");
		buffer.append("catLevel5Id=[").append(catLevel5Id).append("] ");
		buffer.append("catLevel5Value=[").append(catLevel5Value).append("] ");
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
		result = (int) (prime * result + ((categoryDenormId == null) ? 0 : categoryDenormId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof StCategoryDenorm))
			return false;
		StCategoryDenorm equalCheck = (StCategoryDenorm) obj;
		if ((categoryDenormId == null && equalCheck.categoryDenormId != null) || (categoryDenormId != null && equalCheck.categoryDenormId == null))
			return false;
		if (categoryDenormId != null && !categoryDenormId.equals(equalCheck.categoryDenormId))
			return false;
		return true;
	}
}
