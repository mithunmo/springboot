//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for stSeasonYearDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stSeasonYearDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seasonYearId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="season">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="year">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="activeStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="langCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="createdby">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lastupdateby">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="portfolio" type="{http://domain.businessobjects.f9g4.com}trPortfolioDomain" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="searchSeason" type="{http://domain.businessobjects.f9g4.com}trSearchSeasonDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stSeasonYearDomain", propOrder = {
    "seasonYearId",
    "season",
    "year",
    "activeStatus",
    "langCode",
    "createdby",
    "lastupdateby",
    "portfolio",
    "searchSeason"
})
public class StSeasonYearDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int seasonYearId;
    @XmlElement(required = true)
    protected String season;
    @XmlElement(required = true)
    protected String year;
    protected int activeStatus;
    @XmlElement(required = true, defaultValue = "en-US")
    protected String langCode;
    protected int createdby;
    protected int lastupdateby;
    protected List<TrPortfolioDomain> portfolio;
    protected List<TrSearchSeasonDomain> searchSeason;

    /**
     * Default no-arg constructor
     * 
     */
    public StSeasonYearDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public StSeasonYearDomain(final int seasonYearId, final String season, final String year, final int activeStatus, final String langCode, final int createdby, final int lastupdateby, final List<TrPortfolioDomain> portfolio, final List<TrSearchSeasonDomain> searchSeason) {
        this.seasonYearId = seasonYearId;
        this.season = season;
        this.year = year;
        this.activeStatus = activeStatus;
        this.langCode = langCode;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
        this.portfolio = portfolio;
        this.searchSeason = searchSeason;
    }

    /**
     * Gets the value of the seasonYearId property.
     * 
     */
    public int getSeasonYearId() {
        return seasonYearId;
    }

    /**
     * Sets the value of the seasonYearId property.
     * 
     */
    public void setSeasonYearId(int value) {
        this.seasonYearId = value;
    }

    /**
     * Gets the value of the season property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeason() {
        return season;
    }

    /**
     * Sets the value of the season property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeason(String value) {
        this.season = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYear(String value) {
        this.year = value;
    }

    /**
     * Gets the value of the activeStatus property.
     * 
     */
    public int getActiveStatus() {
        return activeStatus;
    }

    /**
     * Sets the value of the activeStatus property.
     * 
     */
    public void setActiveStatus(int value) {
        this.activeStatus = value;
    }

    /**
     * Gets the value of the langCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangCode() {
        return langCode;
    }

    /**
     * Sets the value of the langCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangCode(String value) {
        this.langCode = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     */
    public int getCreatedby() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     */
    public void setCreatedby(int value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the lastupdateby property.
     * 
     */
    public int getLastupdateby() {
        return lastupdateby;
    }

    /**
     * Sets the value of the lastupdateby property.
     * 
     */
    public void setLastupdateby(int value) {
        this.lastupdateby = value;
    }

    /**
     * Gets the value of the portfolio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portfolio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortfolio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrPortfolioDomain }
     * 
     * 
     */
    public List<TrPortfolioDomain> getPortfolio() {
        if (portfolio == null) {
            portfolio = new ArrayList<TrPortfolioDomain>();
        }
        return this.portfolio;
    }

    /**
     * Gets the value of the searchSeason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchSeason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchSeason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrSearchSeasonDomain }
     * 
     * 
     */
    public List<TrSearchSeasonDomain> getSearchSeason() {
        if (searchSeason == null) {
            searchSeason = new ArrayList<TrSearchSeasonDomain>();
        }
        return this.searchSeason;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            int theSeasonYearId;
            theSeasonYearId = this.getSeasonYearId();
            strategy.appendField(locator, this, "seasonYearId", buffer, theSeasonYearId);
        }
        {
            String theSeason;
            theSeason = this.getSeason();
            strategy.appendField(locator, this, "season", buffer, theSeason);
        }
        {
            String theYear;
            theYear = this.getYear();
            strategy.appendField(locator, this, "year", buffer, theYear);
        }
        {
            int theActiveStatus;
            theActiveStatus = this.getActiveStatus();
            strategy.appendField(locator, this, "activeStatus", buffer, theActiveStatus);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            strategy.appendField(locator, this, "langCode", buffer, theLangCode);
        }
        {
            int theCreatedby;
            theCreatedby = this.getCreatedby();
            strategy.appendField(locator, this, "createdby", buffer, theCreatedby);
        }
        {
            int theLastupdateby;
            theLastupdateby = this.getLastupdateby();
            strategy.appendField(locator, this, "lastupdateby", buffer, theLastupdateby);
        }
        {
            List<TrPortfolioDomain> thePortfolio;
            thePortfolio = this.getPortfolio();
            strategy.appendField(locator, this, "portfolio", buffer, thePortfolio);
        }
        {
            List<TrSearchSeasonDomain> theSearchSeason;
            theSearchSeason = this.getSearchSeason();
            strategy.appendField(locator, this, "searchSeason", buffer, theSearchSeason);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof StSeasonYearDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final StSeasonYearDomain that = ((StSeasonYearDomain) object);
        {
            int lhsSeasonYearId;
            lhsSeasonYearId = this.getSeasonYearId();
            int rhsSeasonYearId;
            rhsSeasonYearId = that.getSeasonYearId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "seasonYearId", lhsSeasonYearId), LocatorUtils.property(thatLocator, "seasonYearId", rhsSeasonYearId), lhsSeasonYearId, rhsSeasonYearId)) {
                return false;
            }
        }
        {
            String lhsSeason;
            lhsSeason = this.getSeason();
            String rhsSeason;
            rhsSeason = that.getSeason();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "season", lhsSeason), LocatorUtils.property(thatLocator, "season", rhsSeason), lhsSeason, rhsSeason)) {
                return false;
            }
        }
        {
            String lhsYear;
            lhsYear = this.getYear();
            String rhsYear;
            rhsYear = that.getYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear)) {
                return false;
            }
        }
        {
            int lhsActiveStatus;
            lhsActiveStatus = this.getActiveStatus();
            int rhsActiveStatus;
            rhsActiveStatus = that.getActiveStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activeStatus", lhsActiveStatus), LocatorUtils.property(thatLocator, "activeStatus", rhsActiveStatus), lhsActiveStatus, rhsActiveStatus)) {
                return false;
            }
        }
        {
            String lhsLangCode;
            lhsLangCode = this.getLangCode();
            String rhsLangCode;
            rhsLangCode = that.getLangCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "langCode", lhsLangCode), LocatorUtils.property(thatLocator, "langCode", rhsLangCode), lhsLangCode, rhsLangCode)) {
                return false;
            }
        }
        {
            int lhsCreatedby;
            lhsCreatedby = this.getCreatedby();
            int rhsCreatedby;
            rhsCreatedby = that.getCreatedby();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "createdby", lhsCreatedby), LocatorUtils.property(thatLocator, "createdby", rhsCreatedby), lhsCreatedby, rhsCreatedby)) {
                return false;
            }
        }
        {
            int lhsLastupdateby;
            lhsLastupdateby = this.getLastupdateby();
            int rhsLastupdateby;
            rhsLastupdateby = that.getLastupdateby();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastupdateby", lhsLastupdateby), LocatorUtils.property(thatLocator, "lastupdateby", rhsLastupdateby), lhsLastupdateby, rhsLastupdateby)) {
                return false;
            }
        }
        {
            List<TrPortfolioDomain> lhsPortfolio;
            lhsPortfolio = this.getPortfolio();
            List<TrPortfolioDomain> rhsPortfolio;
            rhsPortfolio = that.getPortfolio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "portfolio", lhsPortfolio), LocatorUtils.property(thatLocator, "portfolio", rhsPortfolio), lhsPortfolio, rhsPortfolio)) {
                return false;
            }
        }
        {
            List<TrSearchSeasonDomain> lhsSearchSeason;
            lhsSearchSeason = this.getSearchSeason();
            List<TrSearchSeasonDomain> rhsSearchSeason;
            rhsSearchSeason = that.getSearchSeason();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchSeason", lhsSearchSeason), LocatorUtils.property(thatLocator, "searchSeason", rhsSearchSeason), lhsSearchSeason, rhsSearchSeason)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theSeasonYearId;
            theSeasonYearId = this.getSeasonYearId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "seasonYearId", theSeasonYearId), currentHashCode, theSeasonYearId);
        }
        {
            String theSeason;
            theSeason = this.getSeason();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "season", theSeason), currentHashCode, theSeason);
        }
        {
            String theYear;
            theYear = this.getYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
        }
        {
            int theActiveStatus;
            theActiveStatus = this.getActiveStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activeStatus", theActiveStatus), currentHashCode, theActiveStatus);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "langCode", theLangCode), currentHashCode, theLangCode);
        }
        {
            int theCreatedby;
            theCreatedby = this.getCreatedby();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "createdby", theCreatedby), currentHashCode, theCreatedby);
        }
        {
            int theLastupdateby;
            theLastupdateby = this.getLastupdateby();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastupdateby", theLastupdateby), currentHashCode, theLastupdateby);
        }
        {
            List<TrPortfolioDomain> thePortfolio;
            thePortfolio = this.getPortfolio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "portfolio", thePortfolio), currentHashCode, thePortfolio);
        }
        {
            List<TrSearchSeasonDomain> theSearchSeason;
            theSearchSeason = this.getSearchSeason();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchSeason", theSearchSeason), currentHashCode, theSearchSeason);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof StSeasonYearDomain) {
            final StSeasonYearDomain copy = ((StSeasonYearDomain) draftCopy);
            int sourceSeasonYearId;
            sourceSeasonYearId = this.getSeasonYearId();
            int copySeasonYearId = strategy.copy(LocatorUtils.property(locator, "seasonYearId", sourceSeasonYearId), sourceSeasonYearId);
            copy.setSeasonYearId(copySeasonYearId);
            if (this.season!= null) {
                String sourceSeason;
                sourceSeason = this.getSeason();
                String copySeason = ((String) strategy.copy(LocatorUtils.property(locator, "season", sourceSeason), sourceSeason));
                copy.setSeason(copySeason);
            } else {
                copy.season = null;
            }
            if (this.year!= null) {
                String sourceYear;
                sourceYear = this.getYear();
                String copyYear = ((String) strategy.copy(LocatorUtils.property(locator, "year", sourceYear), sourceYear));
                copy.setYear(copyYear);
            } else {
                copy.year = null;
            }
            int sourceActiveStatus;
            sourceActiveStatus = this.getActiveStatus();
            int copyActiveStatus = strategy.copy(LocatorUtils.property(locator, "activeStatus", sourceActiveStatus), sourceActiveStatus);
            copy.setActiveStatus(copyActiveStatus);
            if (this.langCode!= null) {
                String sourceLangCode;
                sourceLangCode = this.getLangCode();
                String copyLangCode = ((String) strategy.copy(LocatorUtils.property(locator, "langCode", sourceLangCode), sourceLangCode));
                copy.setLangCode(copyLangCode);
            } else {
                copy.langCode = null;
            }
            int sourceCreatedby;
            sourceCreatedby = this.getCreatedby();
            int copyCreatedby = strategy.copy(LocatorUtils.property(locator, "createdby", sourceCreatedby), sourceCreatedby);
            copy.setCreatedby(copyCreatedby);
            int sourceLastupdateby;
            sourceLastupdateby = this.getLastupdateby();
            int copyLastupdateby = strategy.copy(LocatorUtils.property(locator, "lastupdateby", sourceLastupdateby), sourceLastupdateby);
            copy.setLastupdateby(copyLastupdateby);
            if ((this.portfolio!= null)&&(!this.portfolio.isEmpty())) {
                List<TrPortfolioDomain> sourcePortfolio;
                sourcePortfolio = this.getPortfolio();
                @SuppressWarnings("unchecked")
                List<TrPortfolioDomain> copyPortfolio = ((List<TrPortfolioDomain> ) strategy.copy(LocatorUtils.property(locator, "portfolio", sourcePortfolio), sourcePortfolio));
                copy.portfolio = null;
                List<TrPortfolioDomain> uniquePortfoliol = copy.getPortfolio();
                uniquePortfoliol.addAll(copyPortfolio);
            } else {
                copy.portfolio = null;
            }
            if ((this.searchSeason!= null)&&(!this.searchSeason.isEmpty())) {
                List<TrSearchSeasonDomain> sourceSearchSeason;
                sourceSearchSeason = this.getSearchSeason();
                @SuppressWarnings("unchecked")
                List<TrSearchSeasonDomain> copySearchSeason = ((List<TrSearchSeasonDomain> ) strategy.copy(LocatorUtils.property(locator, "searchSeason", sourceSearchSeason), sourceSearchSeason));
                copy.searchSeason = null;
                List<TrSearchSeasonDomain> uniqueSearchSeasonl = copy.getSearchSeason();
                uniqueSearchSeasonl.addAll(copySearchSeason);
            } else {
                copy.searchSeason = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new StSeasonYearDomain();
    }

}
