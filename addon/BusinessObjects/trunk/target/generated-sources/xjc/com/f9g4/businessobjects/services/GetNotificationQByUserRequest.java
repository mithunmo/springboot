//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.services;

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
 * <p>Java class for GetNotificationQByUserRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetNotificationQByUserRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetNotificationQByUserRequest", propOrder = {
    "userid"
})
public class GetNotificationQByUserRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int userid;

    /**
     * Default no-arg constructor
     * 
     */
    public GetNotificationQByUserRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetNotificationQByUserRequest(final int userid) {
        this.userid = userid;
    }

    /**
     * Gets the value of the userid property.
     * 
     */
    public int getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     */
    public void setUserid(int value) {
        this.userid = value;
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
            int theUserid;
            theUserid = this.getUserid();
            strategy.appendField(locator, this, "userid", buffer, theUserid);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetNotificationQByUserRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetNotificationQByUserRequest that = ((GetNotificationQByUserRequest) object);
        {
            int lhsUserid;
            lhsUserid = this.getUserid();
            int rhsUserid;
            rhsUserid = that.getUserid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userid", lhsUserid), LocatorUtils.property(thatLocator, "userid", rhsUserid), lhsUserid, rhsUserid)) {
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
            int theUserid;
            theUserid = this.getUserid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userid", theUserid), currentHashCode, theUserid);
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
        if (draftCopy instanceof GetNotificationQByUserRequest) {
            final GetNotificationQByUserRequest copy = ((GetNotificationQByUserRequest) draftCopy);
            int sourceUserid;
            sourceUserid = this.getUserid();
            int copyUserid = strategy.copy(LocatorUtils.property(locator, "userid", sourceUserid), sourceUserid);
            copy.setUserid(copyUserid);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetNotificationQByUserRequest();
    }

}
