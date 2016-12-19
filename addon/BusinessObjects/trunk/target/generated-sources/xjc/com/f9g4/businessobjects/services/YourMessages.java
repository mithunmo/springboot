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
import javax.xml.bind.annotation.XmlSchemaType;
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
 * <p>Java class for yourMessages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="yourMessages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alerts" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="latestAlertsTS" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="messages" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="latestMessagesTS" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "yourMessages", propOrder = {
    "alerts",
    "latestAlertsTS",
    "messages",
    "latestMessagesTS"
})
public class YourMessages implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected long alerts;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestAlertsTS;
    protected long messages;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestMessagesTS;

    /**
     * Default no-arg constructor
     * 
     */
    public YourMessages() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public YourMessages(final long alerts, final XMLGregorianCalendar latestAlertsTS, final long messages, final XMLGregorianCalendar latestMessagesTS) {
        this.alerts = alerts;
        this.latestAlertsTS = latestAlertsTS;
        this.messages = messages;
        this.latestMessagesTS = latestMessagesTS;
    }

    /**
     * Gets the value of the alerts property.
     * 
     */
    public long getAlerts() {
        return alerts;
    }

    /**
     * Sets the value of the alerts property.
     * 
     */
    public void setAlerts(long value) {
        this.alerts = value;
    }

    /**
     * Gets the value of the latestAlertsTS property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestAlertsTS() {
        return latestAlertsTS;
    }

    /**
     * Sets the value of the latestAlertsTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestAlertsTS(XMLGregorianCalendar value) {
        this.latestAlertsTS = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     */
    public long getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     */
    public void setMessages(long value) {
        this.messages = value;
    }

    /**
     * Gets the value of the latestMessagesTS property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestMessagesTS() {
        return latestMessagesTS;
    }

    /**
     * Sets the value of the latestMessagesTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestMessagesTS(XMLGregorianCalendar value) {
        this.latestMessagesTS = value;
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
            long theAlerts;
            theAlerts = this.getAlerts();
            strategy.appendField(locator, this, "alerts", buffer, theAlerts);
        }
        {
            XMLGregorianCalendar theLatestAlertsTS;
            theLatestAlertsTS = this.getLatestAlertsTS();
            strategy.appendField(locator, this, "latestAlertsTS", buffer, theLatestAlertsTS);
        }
        {
            long theMessages;
            theMessages = this.getMessages();
            strategy.appendField(locator, this, "messages", buffer, theMessages);
        }
        {
            XMLGregorianCalendar theLatestMessagesTS;
            theLatestMessagesTS = this.getLatestMessagesTS();
            strategy.appendField(locator, this, "latestMessagesTS", buffer, theLatestMessagesTS);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof YourMessages)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final YourMessages that = ((YourMessages) object);
        {
            long lhsAlerts;
            lhsAlerts = this.getAlerts();
            long rhsAlerts;
            rhsAlerts = that.getAlerts();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "alerts", lhsAlerts), LocatorUtils.property(thatLocator, "alerts", rhsAlerts), lhsAlerts, rhsAlerts)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLatestAlertsTS;
            lhsLatestAlertsTS = this.getLatestAlertsTS();
            XMLGregorianCalendar rhsLatestAlertsTS;
            rhsLatestAlertsTS = that.getLatestAlertsTS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "latestAlertsTS", lhsLatestAlertsTS), LocatorUtils.property(thatLocator, "latestAlertsTS", rhsLatestAlertsTS), lhsLatestAlertsTS, rhsLatestAlertsTS)) {
                return false;
            }
        }
        {
            long lhsMessages;
            lhsMessages = this.getMessages();
            long rhsMessages;
            rhsMessages = that.getMessages();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messages", lhsMessages), LocatorUtils.property(thatLocator, "messages", rhsMessages), lhsMessages, rhsMessages)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLatestMessagesTS;
            lhsLatestMessagesTS = this.getLatestMessagesTS();
            XMLGregorianCalendar rhsLatestMessagesTS;
            rhsLatestMessagesTS = that.getLatestMessagesTS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "latestMessagesTS", lhsLatestMessagesTS), LocatorUtils.property(thatLocator, "latestMessagesTS", rhsLatestMessagesTS), lhsLatestMessagesTS, rhsLatestMessagesTS)) {
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
            long theAlerts;
            theAlerts = this.getAlerts();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alerts", theAlerts), currentHashCode, theAlerts);
        }
        {
            XMLGregorianCalendar theLatestAlertsTS;
            theLatestAlertsTS = this.getLatestAlertsTS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "latestAlertsTS", theLatestAlertsTS), currentHashCode, theLatestAlertsTS);
        }
        {
            long theMessages;
            theMessages = this.getMessages();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messages", theMessages), currentHashCode, theMessages);
        }
        {
            XMLGregorianCalendar theLatestMessagesTS;
            theLatestMessagesTS = this.getLatestMessagesTS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "latestMessagesTS", theLatestMessagesTS), currentHashCode, theLatestMessagesTS);
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
        if (draftCopy instanceof YourMessages) {
            final YourMessages copy = ((YourMessages) draftCopy);
            long sourceAlerts;
            sourceAlerts = this.getAlerts();
            long copyAlerts = strategy.copy(LocatorUtils.property(locator, "alerts", sourceAlerts), sourceAlerts);
            copy.setAlerts(copyAlerts);
            if (this.latestAlertsTS!= null) {
                XMLGregorianCalendar sourceLatestAlertsTS;
                sourceLatestAlertsTS = this.getLatestAlertsTS();
                XMLGregorianCalendar copyLatestAlertsTS = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "latestAlertsTS", sourceLatestAlertsTS), sourceLatestAlertsTS));
                copy.setLatestAlertsTS(copyLatestAlertsTS);
            } else {
                copy.latestAlertsTS = null;
            }
            long sourceMessages;
            sourceMessages = this.getMessages();
            long copyMessages = strategy.copy(LocatorUtils.property(locator, "messages", sourceMessages), sourceMessages);
            copy.setMessages(copyMessages);
            if (this.latestMessagesTS!= null) {
                XMLGregorianCalendar sourceLatestMessagesTS;
                sourceLatestMessagesTS = this.getLatestMessagesTS();
                XMLGregorianCalendar copyLatestMessagesTS = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "latestMessagesTS", sourceLatestMessagesTS), sourceLatestMessagesTS));
                copy.setLatestMessagesTS(copyLatestMessagesTS);
            } else {
                copy.latestMessagesTS = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new YourMessages();
    }

}