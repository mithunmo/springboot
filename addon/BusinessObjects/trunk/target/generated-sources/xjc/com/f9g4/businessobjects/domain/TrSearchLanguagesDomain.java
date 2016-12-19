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
 * <p>Java class for trSearchLanguagesDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trSearchLanguagesDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchLanguageId">
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
 *         &lt;element name="langId">
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
@XmlType(name = "trSearchLanguagesDomain", propOrder = {
    "searchLanguageId",
    "searchId",
    "langId",
    "createdby",
    "lastupdateby"
})
public class TrSearchLanguagesDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int searchLanguageId;
    protected int searchId;
    protected int langId;
    protected int createdby;
    protected int lastupdateby;

    /**
     * Default no-arg constructor
     * 
     */
    public TrSearchLanguagesDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrSearchLanguagesDomain(final int searchLanguageId, final int searchId, final int langId, final int createdby, final int lastupdateby) {
        this.searchLanguageId = searchLanguageId;
        this.searchId = searchId;
        this.langId = langId;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
    }

    /**
     * Gets the value of the searchLanguageId property.
     * 
     */
    public int getSearchLanguageId() {
        return searchLanguageId;
    }

    /**
     * Sets the value of the searchLanguageId property.
     * 
     */
    public void setSearchLanguageId(int value) {
        this.searchLanguageId = value;
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
     * Gets the value of the langId property.
     * 
     */
    public int getLangId() {
        return langId;
    }

    /**
     * Sets the value of the langId property.
     * 
     */
    public void setLangId(int value) {
        this.langId = value;
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
            int theSearchLanguageId;
            theSearchLanguageId = this.getSearchLanguageId();
            strategy.appendField(locator, this, "searchLanguageId", buffer, theSearchLanguageId);
        }
        {
            int theSearchId;
            theSearchId = this.getSearchId();
            strategy.appendField(locator, this, "searchId", buffer, theSearchId);
        }
        {
            int theLangId;
            theLangId = this.getLangId();
            strategy.appendField(locator, this, "langId", buffer, theLangId);
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
        if (!(object instanceof TrSearchLanguagesDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrSearchLanguagesDomain that = ((TrSearchLanguagesDomain) object);
        {
            int lhsSearchLanguageId;
            lhsSearchLanguageId = this.getSearchLanguageId();
            int rhsSearchLanguageId;
            rhsSearchLanguageId = that.getSearchLanguageId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchLanguageId", lhsSearchLanguageId), LocatorUtils.property(thatLocator, "searchLanguageId", rhsSearchLanguageId), lhsSearchLanguageId, rhsSearchLanguageId)) {
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
            int lhsLangId;
            lhsLangId = this.getLangId();
            int rhsLangId;
            rhsLangId = that.getLangId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "langId", lhsLangId), LocatorUtils.property(thatLocator, "langId", rhsLangId), lhsLangId, rhsLangId)) {
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
            int theSearchLanguageId;
            theSearchLanguageId = this.getSearchLanguageId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchLanguageId", theSearchLanguageId), currentHashCode, theSearchLanguageId);
        }
        {
            int theSearchId;
            theSearchId = this.getSearchId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchId", theSearchId), currentHashCode, theSearchId);
        }
        {
            int theLangId;
            theLangId = this.getLangId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "langId", theLangId), currentHashCode, theLangId);
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
        if (draftCopy instanceof TrSearchLanguagesDomain) {
            final TrSearchLanguagesDomain copy = ((TrSearchLanguagesDomain) draftCopy);
            int sourceSearchLanguageId;
            sourceSearchLanguageId = this.getSearchLanguageId();
            int copySearchLanguageId = strategy.copy(LocatorUtils.property(locator, "searchLanguageId", sourceSearchLanguageId), sourceSearchLanguageId);
            copy.setSearchLanguageId(copySearchLanguageId);
            int sourceSearchId;
            sourceSearchId = this.getSearchId();
            int copySearchId = strategy.copy(LocatorUtils.property(locator, "searchId", sourceSearchId), sourceSearchId);
            copy.setSearchId(copySearchId);
            int sourceLangId;
            sourceLangId = this.getLangId();
            int copyLangId = strategy.copy(LocatorUtils.property(locator, "langId", sourceLangId), sourceLangId);
            copy.setLangId(copyLangId);
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
        return new TrSearchLanguagesDomain();
    }

}