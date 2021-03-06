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
 * <p>Java class for RedeemUserCreditRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RedeemUserCreditRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="credits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RedeemUserCreditRequest", propOrder = {
    "userId",
    "credits"
})
@XmlRootElement(name = "RedeemUserCreditRequest")
public class RedeemUserCreditRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "UserId")
    protected int userId;
    protected int credits;

    /**
     * Default no-arg constructor
     * 
     */
    public RedeemUserCreditRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public RedeemUserCreditRequest(final int userId, final int credits) {
        this.userId = userId;
        this.credits = credits;
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
     * Gets the value of the credits property.
     * 
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the value of the credits property.
     * 
     */
    public void setCredits(int value) {
        this.credits = value;
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
            int theCredits;
            theCredits = this.getCredits();
            strategy.appendField(locator, this, "credits", buffer, theCredits);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RedeemUserCreditRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RedeemUserCreditRequest that = ((RedeemUserCreditRequest) object);
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
            int lhsCredits;
            lhsCredits = this.getCredits();
            int rhsCredits;
            rhsCredits = that.getCredits();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "credits", lhsCredits), LocatorUtils.property(thatLocator, "credits", rhsCredits), lhsCredits, rhsCredits)) {
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
            int theCredits;
            theCredits = this.getCredits();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "credits", theCredits), currentHashCode, theCredits);
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
        if (draftCopy instanceof RedeemUserCreditRequest) {
            final RedeemUserCreditRequest copy = ((RedeemUserCreditRequest) draftCopy);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            int sourceCredits;
            sourceCredits = this.getCredits();
            int copyCredits = strategy.copy(LocatorUtils.property(locator, "credits", sourceCredits), sourceCredits);
            copy.setCredits(copyCredits);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RedeemUserCreditRequest();
    }

}
