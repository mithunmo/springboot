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
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
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
 * <p>Java class for CreateMembershipRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateMembershipRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adUserMembershipDomain" type="{http://domain.businessobjects.f9g4.com}adUserMembershipDomain"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateMembershipRequest", propOrder = {
    "adUserMembershipDomain"
})
@XmlRootElement(name = "CreateMembershipRequest")
public class CreateMembershipRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected AdUserMembershipDomain adUserMembershipDomain;

    /**
     * Default no-arg constructor
     * 
     */
    public CreateMembershipRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CreateMembershipRequest(final AdUserMembershipDomain adUserMembershipDomain) {
        this.adUserMembershipDomain = adUserMembershipDomain;
    }

    /**
     * Gets the value of the adUserMembershipDomain property.
     * 
     * @return
     *     possible object is
     *     {@link AdUserMembershipDomain }
     *     
     */
    public AdUserMembershipDomain getAdUserMembershipDomain() {
        return adUserMembershipDomain;
    }

    /**
     * Sets the value of the adUserMembershipDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdUserMembershipDomain }
     *     
     */
    public void setAdUserMembershipDomain(AdUserMembershipDomain value) {
        this.adUserMembershipDomain = value;
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
            AdUserMembershipDomain theAdUserMembershipDomain;
            theAdUserMembershipDomain = this.getAdUserMembershipDomain();
            strategy.appendField(locator, this, "adUserMembershipDomain", buffer, theAdUserMembershipDomain);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CreateMembershipRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CreateMembershipRequest that = ((CreateMembershipRequest) object);
        {
            AdUserMembershipDomain lhsAdUserMembershipDomain;
            lhsAdUserMembershipDomain = this.getAdUserMembershipDomain();
            AdUserMembershipDomain rhsAdUserMembershipDomain;
            rhsAdUserMembershipDomain = that.getAdUserMembershipDomain();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adUserMembershipDomain", lhsAdUserMembershipDomain), LocatorUtils.property(thatLocator, "adUserMembershipDomain", rhsAdUserMembershipDomain), lhsAdUserMembershipDomain, rhsAdUserMembershipDomain)) {
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
            AdUserMembershipDomain theAdUserMembershipDomain;
            theAdUserMembershipDomain = this.getAdUserMembershipDomain();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adUserMembershipDomain", theAdUserMembershipDomain), currentHashCode, theAdUserMembershipDomain);
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
        if (draftCopy instanceof CreateMembershipRequest) {
            final CreateMembershipRequest copy = ((CreateMembershipRequest) draftCopy);
            if (this.adUserMembershipDomain!= null) {
                AdUserMembershipDomain sourceAdUserMembershipDomain;
                sourceAdUserMembershipDomain = this.getAdUserMembershipDomain();
                AdUserMembershipDomain copyAdUserMembershipDomain = ((AdUserMembershipDomain) strategy.copy(LocatorUtils.property(locator, "adUserMembershipDomain", sourceAdUserMembershipDomain), sourceAdUserMembershipDomain));
                copy.setAdUserMembershipDomain(copyAdUserMembershipDomain);
            } else {
                copy.adUserMembershipDomain = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CreateMembershipRequest();
    }

}
