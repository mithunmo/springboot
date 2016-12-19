//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for adAccepttermsDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adAccepttermsDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acceptTermId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="userId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="acceptanceDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="termConditionId">
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
@XmlType(name = "adAccepttermsDomain", propOrder = {
    "acceptTermId",
    "userId",
    "acceptanceDate",
    "termConditionId",
    "createdby",
    "lastupdateby"
})
public class AdAccepttermsDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int acceptTermId;
    protected int userId;
    @XmlElement(required = true)
    protected XMLGregorianCalendar acceptanceDate;
    protected int termConditionId;
    protected int createdby;
    protected int lastupdateby;

    /**
     * Default no-arg constructor
     * 
     */
    public AdAccepttermsDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public AdAccepttermsDomain(final int acceptTermId, final int userId, final XMLGregorianCalendar acceptanceDate, final int termConditionId, final int createdby, final int lastupdateby) {
        this.acceptTermId = acceptTermId;
        this.userId = userId;
        this.acceptanceDate = acceptanceDate;
        this.termConditionId = termConditionId;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
    }

    /**
     * Gets the value of the acceptTermId property.
     * 
     */
    public int getAcceptTermId() {
        return acceptTermId;
    }

    /**
     * Sets the value of the acceptTermId property.
     * 
     */
    public void setAcceptTermId(int value) {
        this.acceptTermId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the acceptanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcceptanceDate() {
        return acceptanceDate;
    }

    /**
     * Sets the value of the acceptanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcceptanceDate(XMLGregorianCalendar value) {
        this.acceptanceDate = value;
    }

    /**
     * Gets the value of the termConditionId property.
     * 
     */
    public int getTermConditionId() {
        return termConditionId;
    }

    /**
     * Sets the value of the termConditionId property.
     * 
     */
    public void setTermConditionId(int value) {
        this.termConditionId = value;
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
            int theAcceptTermId;
            theAcceptTermId = this.getAcceptTermId();
            strategy.appendField(locator, this, "acceptTermId", buffer, theAcceptTermId);
        }
        {
            int theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId);
        }
        {
            XMLGregorianCalendar theAcceptanceDate;
            theAcceptanceDate = this.getAcceptanceDate();
            strategy.appendField(locator, this, "acceptanceDate", buffer, theAcceptanceDate);
        }
        {
            int theTermConditionId;
            theTermConditionId = this.getTermConditionId();
            strategy.appendField(locator, this, "termConditionId", buffer, theTermConditionId);
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
        if (!(object instanceof AdAccepttermsDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AdAccepttermsDomain that = ((AdAccepttermsDomain) object);
        {
            int lhsAcceptTermId;
            lhsAcceptTermId = this.getAcceptTermId();
            int rhsAcceptTermId;
            rhsAcceptTermId = that.getAcceptTermId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "acceptTermId", lhsAcceptTermId), LocatorUtils.property(thatLocator, "acceptTermId", rhsAcceptTermId), lhsAcceptTermId, rhsAcceptTermId)) {
                return false;
            }
        }
        {
            int lhsUserId;
            lhsUserId = this.getUserId();
            int rhsUserId;
            rhsUserId = that.getUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userId", lhsUserId), LocatorUtils.property(thatLocator, "userId", rhsUserId), lhsUserId, rhsUserId)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsAcceptanceDate;
            lhsAcceptanceDate = this.getAcceptanceDate();
            XMLGregorianCalendar rhsAcceptanceDate;
            rhsAcceptanceDate = that.getAcceptanceDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "acceptanceDate", lhsAcceptanceDate), LocatorUtils.property(thatLocator, "acceptanceDate", rhsAcceptanceDate), lhsAcceptanceDate, rhsAcceptanceDate)) {
                return false;
            }
        }
        {
            int lhsTermConditionId;
            lhsTermConditionId = this.getTermConditionId();
            int rhsTermConditionId;
            rhsTermConditionId = that.getTermConditionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "termConditionId", lhsTermConditionId), LocatorUtils.property(thatLocator, "termConditionId", rhsTermConditionId), lhsTermConditionId, rhsTermConditionId)) {
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
            int theAcceptTermId;
            theAcceptTermId = this.getAcceptTermId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acceptTermId", theAcceptTermId), currentHashCode, theAcceptTermId);
        }
        {
            int theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId);
        }
        {
            XMLGregorianCalendar theAcceptanceDate;
            theAcceptanceDate = this.getAcceptanceDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "acceptanceDate", theAcceptanceDate), currentHashCode, theAcceptanceDate);
        }
        {
            int theTermConditionId;
            theTermConditionId = this.getTermConditionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "termConditionId", theTermConditionId), currentHashCode, theTermConditionId);
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
        if (draftCopy instanceof AdAccepttermsDomain) {
            final AdAccepttermsDomain copy = ((AdAccepttermsDomain) draftCopy);
            int sourceAcceptTermId;
            sourceAcceptTermId = this.getAcceptTermId();
            int copyAcceptTermId = strategy.copy(LocatorUtils.property(locator, "acceptTermId", sourceAcceptTermId), sourceAcceptTermId);
            copy.setAcceptTermId(copyAcceptTermId);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            if (this.acceptanceDate!= null) {
                XMLGregorianCalendar sourceAcceptanceDate;
                sourceAcceptanceDate = this.getAcceptanceDate();
                XMLGregorianCalendar copyAcceptanceDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "acceptanceDate", sourceAcceptanceDate), sourceAcceptanceDate));
                copy.setAcceptanceDate(copyAcceptanceDate);
            } else {
                copy.acceptanceDate = null;
            }
            int sourceTermConditionId;
            sourceTermConditionId = this.getTermConditionId();
            int copyTermConditionId = strategy.copy(LocatorUtils.property(locator, "termConditionId", sourceTermConditionId), sourceTermConditionId);
            copy.setTermConditionId(copyTermConditionId);
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
        return new AdAccepttermsDomain();
    }

}
