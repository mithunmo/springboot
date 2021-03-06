//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for trSearchSeasonDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trSearchSeasonDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchSeasonId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="searchId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="seasonYearId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trSearchSeasonDomain", propOrder = {
    "searchSeasonId",
    "searchId",
    "seasonYearId",
    "createdby",
    "lastupdateby"
})
public class TrSearchSeasonDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int searchSeasonId;
    protected int searchId;
    protected int seasonYearId;
    protected int createdby;
    protected int lastupdateby;

    /**
     * Default no-arg constructor
     * 
     */
    public TrSearchSeasonDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrSearchSeasonDomain(final int searchSeasonId, final int searchId, final int seasonYearId, final int createdby, final int lastupdateby) {
        this.searchSeasonId = searchSeasonId;
        this.searchId = searchId;
        this.seasonYearId = seasonYearId;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
    }

    /**
     * Gets the value of the searchSeasonId property.
     * 
     */
    public int getSearchSeasonId() {
        return searchSeasonId;
    }

    /**
     * Sets the value of the searchSeasonId property.
     * 
     */
    public void setSearchSeasonId(int value) {
        this.searchSeasonId = value;
    }

    /**
     * Gets the value of the searchId property.
     * 
     */
    public int getSearchId() {
        return searchId;
    }

    /**
     * Sets the value of the searchId property.
     * 
     */
    public void setSearchId(int value) {
        this.searchId = value;
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
            int theSearchSeasonId;
            theSearchSeasonId = this.getSearchSeasonId();
            strategy.appendField(locator, this, "searchSeasonId", buffer, theSearchSeasonId);
        }
        {
            int theSearchId;
            theSearchId = this.getSearchId();
            strategy.appendField(locator, this, "searchId", buffer, theSearchId);
        }
        {
            int theSeasonYearId;
            theSeasonYearId = this.getSeasonYearId();
            strategy.appendField(locator, this, "seasonYearId", buffer, theSeasonYearId);
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
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TrSearchSeasonDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrSearchSeasonDomain that = ((TrSearchSeasonDomain) object);
        {
            int lhsSearchSeasonId;
            lhsSearchSeasonId = this.getSearchSeasonId();
            int rhsSearchSeasonId;
            rhsSearchSeasonId = that.getSearchSeasonId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchSeasonId", lhsSearchSeasonId), LocatorUtils.property(thatLocator, "searchSeasonId", rhsSearchSeasonId), lhsSearchSeasonId, rhsSearchSeasonId)) {
                return false;
            }
        }
        {
            int lhsSearchId;
            lhsSearchId = this.getSearchId();
            int rhsSearchId;
            rhsSearchId = that.getSearchId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchId", lhsSearchId), LocatorUtils.property(thatLocator, "searchId", rhsSearchId), lhsSearchId, rhsSearchId)) {
                return false;
            }
        }
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theSearchSeasonId;
            theSearchSeasonId = this.getSearchSeasonId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchSeasonId", theSearchSeasonId), currentHashCode, theSearchSeasonId);
        }
        {
            int theSearchId;
            theSearchId = this.getSearchId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchId", theSearchId), currentHashCode, theSearchId);
        }
        {
            int theSeasonYearId;
            theSeasonYearId = this.getSeasonYearId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "seasonYearId", theSeasonYearId), currentHashCode, theSeasonYearId);
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
        if (draftCopy instanceof TrSearchSeasonDomain) {
            final TrSearchSeasonDomain copy = ((TrSearchSeasonDomain) draftCopy);
            int sourceSearchSeasonId;
            sourceSearchSeasonId = this.getSearchSeasonId();
            int copySearchSeasonId = strategy.copy(LocatorUtils.property(locator, "searchSeasonId", sourceSearchSeasonId), sourceSearchSeasonId);
            copy.setSearchSeasonId(copySearchSeasonId);
            int sourceSearchId;
            sourceSearchId = this.getSearchId();
            int copySearchId = strategy.copy(LocatorUtils.property(locator, "searchId", sourceSearchId), sourceSearchId);
            copy.setSearchId(copySearchId);
            int sourceSeasonYearId;
            sourceSeasonYearId = this.getSeasonYearId();
            int copySeasonYearId = strategy.copy(LocatorUtils.property(locator, "seasonYearId", sourceSeasonYearId), sourceSeasonYearId);
            copy.setSeasonYearId(copySeasonYearId);
            int sourceCreatedby;
            sourceCreatedby = this.getCreatedby();
            int copyCreatedby = strategy.copy(LocatorUtils.property(locator, "createdby", sourceCreatedby), sourceCreatedby);
            copy.setCreatedby(copyCreatedby);
            int sourceLastupdateby;
            sourceLastupdateby = this.getLastupdateby();
            int copyLastupdateby = strategy.copy(LocatorUtils.property(locator, "lastupdateby", sourceLastupdateby), sourceLastupdateby);
            copy.setLastupdateby(copyLastupdateby);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TrSearchSeasonDomain();
    }

}
