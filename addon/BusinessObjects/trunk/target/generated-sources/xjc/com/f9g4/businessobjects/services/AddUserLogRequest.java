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
import com.f9g4.businessobjects.domain.AdActiveUserDomain;
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
 * <p>Java class for AddUserLogRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddUserLogRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="action" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userLogger" type="{http://domain.businessobjects.f9g4.com}adActiveUserDomain"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUserLogRequest", propOrder = {
    "action",
    "userLogger"
})
@XmlRootElement(name = "AddUserLogRequest")
public class AddUserLogRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String action;
    @XmlElement(required = true)
    protected AdActiveUserDomain userLogger;

    /**
     * Default no-arg constructor
     * 
     */
    public AddUserLogRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public AddUserLogRequest(final String action, final AdActiveUserDomain userLogger) {
        this.action = action;
        this.userLogger = userLogger;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the userLogger property.
     * 
     * @return
     *     possible object is
     *     {@link AdActiveUserDomain }
     *     
     */
    public AdActiveUserDomain getUserLogger() {
        return userLogger;
    }

    /**
     * Sets the value of the userLogger property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdActiveUserDomain }
     *     
     */
    public void setUserLogger(AdActiveUserDomain value) {
        this.userLogger = value;
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
            String theAction;
            theAction = this.getAction();
            strategy.appendField(locator, this, "action", buffer, theAction);
        }
        {
            AdActiveUserDomain theUserLogger;
            theUserLogger = this.getUserLogger();
            strategy.appendField(locator, this, "userLogger", buffer, theUserLogger);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AddUserLogRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AddUserLogRequest that = ((AddUserLogRequest) object);
        {
            String lhsAction;
            lhsAction = this.getAction();
            String rhsAction;
            rhsAction = that.getAction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "action", lhsAction), LocatorUtils.property(thatLocator, "action", rhsAction), lhsAction, rhsAction)) {
                return false;
            }
        }
        {
            AdActiveUserDomain lhsUserLogger;
            lhsUserLogger = this.getUserLogger();
            AdActiveUserDomain rhsUserLogger;
            rhsUserLogger = that.getUserLogger();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userLogger", lhsUserLogger), LocatorUtils.property(thatLocator, "userLogger", rhsUserLogger), lhsUserLogger, rhsUserLogger)) {
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
            String theAction;
            theAction = this.getAction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "action", theAction), currentHashCode, theAction);
        }
        {
            AdActiveUserDomain theUserLogger;
            theUserLogger = this.getUserLogger();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userLogger", theUserLogger), currentHashCode, theUserLogger);
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
        if (draftCopy instanceof AddUserLogRequest) {
            final AddUserLogRequest copy = ((AddUserLogRequest) draftCopy);
            if (this.action!= null) {
                String sourceAction;
                sourceAction = this.getAction();
                String copyAction = ((String) strategy.copy(LocatorUtils.property(locator, "action", sourceAction), sourceAction));
                copy.setAction(copyAction);
            } else {
                copy.action = null;
            }
            if (this.userLogger!= null) {
                AdActiveUserDomain sourceUserLogger;
                sourceUserLogger = this.getUserLogger();
                AdActiveUserDomain copyUserLogger = ((AdActiveUserDomain) strategy.copy(LocatorUtils.property(locator, "userLogger", sourceUserLogger), sourceUserLogger));
                copy.setUserLogger(copyUserLogger);
            } else {
                copy.userLogger = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AddUserLogRequest();
    }

}