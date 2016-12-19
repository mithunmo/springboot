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
 * <p>Java class for adUserExpertisesDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adUserExpertisesDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userExpertiseId">
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
 *         &lt;element name="expertiseId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="expertiseName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="500"/>
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
 *         &lt;element name="other">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="240"/>
 *               &lt;minLength value="1"/>
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
@XmlType(name = "adUserExpertisesDomain", propOrder = {
    "userExpertiseId",
    "userId",
    "expertiseId",
    "expertiseName",
    "activeStatus",
    "createdby",
    "lastupdateby",
    "other"
})
public class AdUserExpertisesDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int userExpertiseId;
    protected int userId;
    protected int expertiseId;
    @XmlElement(required = true)
    protected String expertiseName;
    protected int activeStatus;
    protected int createdby;
    protected int lastupdateby;
    @XmlElement(required = true)
    protected String other;

    /**
     * Default no-arg constructor
     * 
     */
    public AdUserExpertisesDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public AdUserExpertisesDomain(final int userExpertiseId, final int userId, final int expertiseId, final String expertiseName, final int activeStatus, final int createdby, final int lastupdateby, final String other) {
        this.userExpertiseId = userExpertiseId;
        this.userId = userId;
        this.expertiseId = expertiseId;
        this.expertiseName = expertiseName;
        this.activeStatus = activeStatus;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
        this.other = other;
    }

    /**
     * Gets the value of the userExpertiseId property.
     * 
     */
    public int getUserExpertiseId() {
        return userExpertiseId;
    }

    /**
     * Sets the value of the userExpertiseId property.
     * 
     */
    public void setUserExpertiseId(int value) {
        this.userExpertiseId = value;
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
     * Gets the value of the expertiseId property.
     * 
     */
    public int getExpertiseId() {
        return expertiseId;
    }

    /**
     * Sets the value of the expertiseId property.
     * 
     */
    public void setExpertiseId(int value) {
        this.expertiseId = value;
    }

    /**
     * Gets the value of the expertiseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpertiseName() {
        return expertiseName;
    }

    /**
     * Sets the value of the expertiseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpertiseName(String value) {
        this.expertiseName = value;
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
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOther(String value) {
        this.other = value;
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
            int theUserExpertiseId;
            theUserExpertiseId = this.getUserExpertiseId();
            strategy.appendField(locator, this, "userExpertiseId", buffer, theUserExpertiseId);
        }
        {
            int theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId);
        }
        {
            int theExpertiseId;
            theExpertiseId = this.getExpertiseId();
            strategy.appendField(locator, this, "expertiseId", buffer, theExpertiseId);
        }
        {
            String theExpertiseName;
            theExpertiseName = this.getExpertiseName();
            strategy.appendField(locator, this, "expertiseName", buffer, theExpertiseName);
        }
        {
            int theActiveStatus;
            theActiveStatus = this.getActiveStatus();
            strategy.appendField(locator, this, "activeStatus", buffer, theActiveStatus);
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
            String theOther;
            theOther = this.getOther();
            strategy.appendField(locator, this, "other", buffer, theOther);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AdUserExpertisesDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AdUserExpertisesDomain that = ((AdUserExpertisesDomain) object);
        {
            int lhsUserExpertiseId;
            lhsUserExpertiseId = this.getUserExpertiseId();
            int rhsUserExpertiseId;
            rhsUserExpertiseId = that.getUserExpertiseId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userExpertiseId", lhsUserExpertiseId), LocatorUtils.property(thatLocator, "userExpertiseId", rhsUserExpertiseId), lhsUserExpertiseId, rhsUserExpertiseId)) {
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
            int lhsExpertiseId;
            lhsExpertiseId = this.getExpertiseId();
            int rhsExpertiseId;
            rhsExpertiseId = that.getExpertiseId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expertiseId", lhsExpertiseId), LocatorUtils.property(thatLocator, "expertiseId", rhsExpertiseId), lhsExpertiseId, rhsExpertiseId)) {
                return false;
            }
        }
        {
            String lhsExpertiseName;
            lhsExpertiseName = this.getExpertiseName();
            String rhsExpertiseName;
            rhsExpertiseName = that.getExpertiseName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expertiseName", lhsExpertiseName), LocatorUtils.property(thatLocator, "expertiseName", rhsExpertiseName), lhsExpertiseName, rhsExpertiseName)) {
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
            String lhsOther;
            lhsOther = this.getOther();
            String rhsOther;
            rhsOther = that.getOther();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "other", lhsOther), LocatorUtils.property(thatLocator, "other", rhsOther), lhsOther, rhsOther)) {
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
            int theUserExpertiseId;
            theUserExpertiseId = this.getUserExpertiseId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userExpertiseId", theUserExpertiseId), currentHashCode, theUserExpertiseId);
        }
        {
            int theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId);
        }
        {
            int theExpertiseId;
            theExpertiseId = this.getExpertiseId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expertiseId", theExpertiseId), currentHashCode, theExpertiseId);
        }
        {
            String theExpertiseName;
            theExpertiseName = this.getExpertiseName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expertiseName", theExpertiseName), currentHashCode, theExpertiseName);
        }
        {
            int theActiveStatus;
            theActiveStatus = this.getActiveStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activeStatus", theActiveStatus), currentHashCode, theActiveStatus);
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
            String theOther;
            theOther = this.getOther();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "other", theOther), currentHashCode, theOther);
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
        if (draftCopy instanceof AdUserExpertisesDomain) {
            final AdUserExpertisesDomain copy = ((AdUserExpertisesDomain) draftCopy);
            int sourceUserExpertiseId;
            sourceUserExpertiseId = this.getUserExpertiseId();
            int copyUserExpertiseId = strategy.copy(LocatorUtils.property(locator, "userExpertiseId", sourceUserExpertiseId), sourceUserExpertiseId);
            copy.setUserExpertiseId(copyUserExpertiseId);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            int sourceExpertiseId;
            sourceExpertiseId = this.getExpertiseId();
            int copyExpertiseId = strategy.copy(LocatorUtils.property(locator, "expertiseId", sourceExpertiseId), sourceExpertiseId);
            copy.setExpertiseId(copyExpertiseId);
            if (this.expertiseName!= null) {
                String sourceExpertiseName;
                sourceExpertiseName = this.getExpertiseName();
                String copyExpertiseName = ((String) strategy.copy(LocatorUtils.property(locator, "expertiseName", sourceExpertiseName), sourceExpertiseName));
                copy.setExpertiseName(copyExpertiseName);
            } else {
                copy.expertiseName = null;
            }
            int sourceActiveStatus;
            sourceActiveStatus = this.getActiveStatus();
            int copyActiveStatus = strategy.copy(LocatorUtils.property(locator, "activeStatus", sourceActiveStatus), sourceActiveStatus);
            copy.setActiveStatus(copyActiveStatus);
            int sourceCreatedby;
            sourceCreatedby = this.getCreatedby();
            int copyCreatedby = strategy.copy(LocatorUtils.property(locator, "createdby", sourceCreatedby), sourceCreatedby);
            copy.setCreatedby(copyCreatedby);
            int sourceLastupdateby;
            sourceLastupdateby = this.getLastupdateby();
            int copyLastupdateby = strategy.copy(LocatorUtils.property(locator, "lastupdateby", sourceLastupdateby), sourceLastupdateby);
            copy.setLastupdateby(copyLastupdateby);
            if (this.other!= null) {
                String sourceOther;
                sourceOther = this.getOther();
                String copyOther = ((String) strategy.copy(LocatorUtils.property(locator, "other", sourceOther), sourceOther));
                copy.setOther(copyOther);
            } else {
                copy.other = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AdUserExpertisesDomain();
    }

}