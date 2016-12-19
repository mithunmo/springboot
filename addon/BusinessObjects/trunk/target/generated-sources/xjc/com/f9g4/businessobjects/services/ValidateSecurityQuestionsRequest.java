//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for ValidateSecurityQuestionsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateSecurityQuestionsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="securityQuestion1" type="{http://services.businessobjects.f9g4.com}SecurityQuestion"/>
 *         &lt;element name="securityQuestion2" type="{http://services.businessobjects.f9g4.com}SecurityQuestion"/>
 *         &lt;element name="securityQuestion3" type="{http://services.businessobjects.f9g4.com}SecurityQuestion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateSecurityQuestionsRequest", propOrder = {
    "userId",
    "securityQuestion1",
    "securityQuestion2",
    "securityQuestion3"
})
@XmlRootElement(name = "ValidateSecurityQuestionsRequest")
public class ValidateSecurityQuestionsRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int userId;
    @XmlElement(required = true)
    protected SecurityQuestion securityQuestion1;
    @XmlElement(required = true)
    protected SecurityQuestion securityQuestion2;
    @XmlElement(required = true)
    protected SecurityQuestion securityQuestion3;

    /**
     * Default no-arg constructor
     * 
     */
    public ValidateSecurityQuestionsRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ValidateSecurityQuestionsRequest(final int userId, final SecurityQuestion securityQuestion1, final SecurityQuestion securityQuestion2, final SecurityQuestion securityQuestion3) {
        this.userId = userId;
        this.securityQuestion1 = securityQuestion1;
        this.securityQuestion2 = securityQuestion2;
        this.securityQuestion3 = securityQuestion3;
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
     * Gets the value of the securityQuestion1 property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityQuestion }
     *     
     */
    public SecurityQuestion getSecurityQuestion1() {
        return securityQuestion1;
    }

    /**
     * Sets the value of the securityQuestion1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityQuestion }
     *     
     */
    public void setSecurityQuestion1(SecurityQuestion value) {
        this.securityQuestion1 = value;
    }

    /**
     * Gets the value of the securityQuestion2 property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityQuestion }
     *     
     */
    public SecurityQuestion getSecurityQuestion2() {
        return securityQuestion2;
    }

    /**
     * Sets the value of the securityQuestion2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityQuestion }
     *     
     */
    public void setSecurityQuestion2(SecurityQuestion value) {
        this.securityQuestion2 = value;
    }

    /**
     * Gets the value of the securityQuestion3 property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityQuestion }
     *     
     */
    public SecurityQuestion getSecurityQuestion3() {
        return securityQuestion3;
    }

    /**
     * Sets the value of the securityQuestion3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityQuestion }
     *     
     */
    public void setSecurityQuestion3(SecurityQuestion value) {
        this.securityQuestion3 = value;
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
            int theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId);
        }
        {
            SecurityQuestion theSecurityQuestion1;
            theSecurityQuestion1 = this.getSecurityQuestion1();
            strategy.appendField(locator, this, "securityQuestion1", buffer, theSecurityQuestion1);
        }
        {
            SecurityQuestion theSecurityQuestion2;
            theSecurityQuestion2 = this.getSecurityQuestion2();
            strategy.appendField(locator, this, "securityQuestion2", buffer, theSecurityQuestion2);
        }
        {
            SecurityQuestion theSecurityQuestion3;
            theSecurityQuestion3 = this.getSecurityQuestion3();
            strategy.appendField(locator, this, "securityQuestion3", buffer, theSecurityQuestion3);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ValidateSecurityQuestionsRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ValidateSecurityQuestionsRequest that = ((ValidateSecurityQuestionsRequest) object);
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
            SecurityQuestion lhsSecurityQuestion1;
            lhsSecurityQuestion1 = this.getSecurityQuestion1();
            SecurityQuestion rhsSecurityQuestion1;
            rhsSecurityQuestion1 = that.getSecurityQuestion1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityQuestion1", lhsSecurityQuestion1), LocatorUtils.property(thatLocator, "securityQuestion1", rhsSecurityQuestion1), lhsSecurityQuestion1, rhsSecurityQuestion1)) {
                return false;
            }
        }
        {
            SecurityQuestion lhsSecurityQuestion2;
            lhsSecurityQuestion2 = this.getSecurityQuestion2();
            SecurityQuestion rhsSecurityQuestion2;
            rhsSecurityQuestion2 = that.getSecurityQuestion2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityQuestion2", lhsSecurityQuestion2), LocatorUtils.property(thatLocator, "securityQuestion2", rhsSecurityQuestion2), lhsSecurityQuestion2, rhsSecurityQuestion2)) {
                return false;
            }
        }
        {
            SecurityQuestion lhsSecurityQuestion3;
            lhsSecurityQuestion3 = this.getSecurityQuestion3();
            SecurityQuestion rhsSecurityQuestion3;
            rhsSecurityQuestion3 = that.getSecurityQuestion3();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityQuestion3", lhsSecurityQuestion3), LocatorUtils.property(thatLocator, "securityQuestion3", rhsSecurityQuestion3), lhsSecurityQuestion3, rhsSecurityQuestion3)) {
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
            int theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId);
        }
        {
            SecurityQuestion theSecurityQuestion1;
            theSecurityQuestion1 = this.getSecurityQuestion1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityQuestion1", theSecurityQuestion1), currentHashCode, theSecurityQuestion1);
        }
        {
            SecurityQuestion theSecurityQuestion2;
            theSecurityQuestion2 = this.getSecurityQuestion2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityQuestion2", theSecurityQuestion2), currentHashCode, theSecurityQuestion2);
        }
        {
            SecurityQuestion theSecurityQuestion3;
            theSecurityQuestion3 = this.getSecurityQuestion3();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityQuestion3", theSecurityQuestion3), currentHashCode, theSecurityQuestion3);
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
        if (draftCopy instanceof ValidateSecurityQuestionsRequest) {
            final ValidateSecurityQuestionsRequest copy = ((ValidateSecurityQuestionsRequest) draftCopy);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            if (this.securityQuestion1 != null) {
                SecurityQuestion sourceSecurityQuestion1;
                sourceSecurityQuestion1 = this.getSecurityQuestion1();
                SecurityQuestion copySecurityQuestion1 = ((SecurityQuestion) strategy.copy(LocatorUtils.property(locator, "securityQuestion1", sourceSecurityQuestion1), sourceSecurityQuestion1));
                copy.setSecurityQuestion1(copySecurityQuestion1);
            } else {
                copy.securityQuestion1 = null;
            }
            if (this.securityQuestion2 != null) {
                SecurityQuestion sourceSecurityQuestion2;
                sourceSecurityQuestion2 = this.getSecurityQuestion2();
                SecurityQuestion copySecurityQuestion2 = ((SecurityQuestion) strategy.copy(LocatorUtils.property(locator, "securityQuestion2", sourceSecurityQuestion2), sourceSecurityQuestion2));
                copy.setSecurityQuestion2(copySecurityQuestion2);
            } else {
                copy.securityQuestion2 = null;
            }
            if (this.securityQuestion3 != null) {
                SecurityQuestion sourceSecurityQuestion3;
                sourceSecurityQuestion3 = this.getSecurityQuestion3();
                SecurityQuestion copySecurityQuestion3 = ((SecurityQuestion) strategy.copy(LocatorUtils.property(locator, "securityQuestion3", sourceSecurityQuestion3), sourceSecurityQuestion3));
                copy.setSecurityQuestion3(copySecurityQuestion3);
            } else {
                copy.securityQuestion3 = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ValidateSecurityQuestionsRequest();
    }

}
