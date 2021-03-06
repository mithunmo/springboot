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
import com.f9g4.businessobjects.common.Status;
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
 * <p>Java class for CompletePaymentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompletePaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://common.businessobjects.f9g4.com}Status"/>
 *         &lt;element name="payerID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ack" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correlationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="build" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletePaymentResponse", propOrder = {
    "status",
    "payerID",
    "transactionID",
    "ack",
    "correlationId",
    "timestamp",
    "build"
})
@XmlRootElement(name = "CompletePaymentResponse")
public class CompletePaymentResponse implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Status status;
    @XmlElement(required = true)
    protected String payerID;
    @XmlElement(required = true)
    protected String transactionID;
    protected String ack;
    protected String correlationId;
    protected String timestamp;
    protected String build;

    /**
     * Default no-arg constructor
     * 
     */
    public CompletePaymentResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CompletePaymentResponse(final Status status, final String payerID, final String transactionID, final String ack, final String correlationId, final String timestamp, final String build) {
        this.status = status;
        this.payerID = payerID;
        this.transactionID = transactionID;
        this.ack = ack;
        this.correlationId = correlationId;
        this.timestamp = timestamp;
        this.build = build;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the payerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayerID() {
        return payerID;
    }

    /**
     * Sets the value of the payerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayerID(String value) {
        this.payerID = value;
    }

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the ack property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAck() {
        return ack;
    }

    /**
     * Sets the value of the ack property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAck(String value) {
        this.ack = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the build property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuild(String value) {
        this.build = value;
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
            Status theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            String thePayerID;
            thePayerID = this.getPayerID();
            strategy.appendField(locator, this, "payerID", buffer, thePayerID);
        }
        {
            String theTransactionID;
            theTransactionID = this.getTransactionID();
            strategy.appendField(locator, this, "transactionID", buffer, theTransactionID);
        }
        {
            String theAck;
            theAck = this.getAck();
            strategy.appendField(locator, this, "ack", buffer, theAck);
        }
        {
            String theCorrelationId;
            theCorrelationId = this.getCorrelationId();
            strategy.appendField(locator, this, "correlationId", buffer, theCorrelationId);
        }
        {
            String theTimestamp;
            theTimestamp = this.getTimestamp();
            strategy.appendField(locator, this, "timestamp", buffer, theTimestamp);
        }
        {
            String theBuild;
            theBuild = this.getBuild();
            strategy.appendField(locator, this, "build", buffer, theBuild);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CompletePaymentResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CompletePaymentResponse that = ((CompletePaymentResponse) object);
        {
            Status lhsStatus;
            lhsStatus = this.getStatus();
            Status rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            String lhsPayerID;
            lhsPayerID = this.getPayerID();
            String rhsPayerID;
            rhsPayerID = that.getPayerID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "payerID", lhsPayerID), LocatorUtils.property(thatLocator, "payerID", rhsPayerID), lhsPayerID, rhsPayerID)) {
                return false;
            }
        }
        {
            String lhsTransactionID;
            lhsTransactionID = this.getTransactionID();
            String rhsTransactionID;
            rhsTransactionID = that.getTransactionID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transactionID", lhsTransactionID), LocatorUtils.property(thatLocator, "transactionID", rhsTransactionID), lhsTransactionID, rhsTransactionID)) {
                return false;
            }
        }
        {
            String lhsAck;
            lhsAck = this.getAck();
            String rhsAck;
            rhsAck = that.getAck();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ack", lhsAck), LocatorUtils.property(thatLocator, "ack", rhsAck), lhsAck, rhsAck)) {
                return false;
            }
        }
        {
            String lhsCorrelationId;
            lhsCorrelationId = this.getCorrelationId();
            String rhsCorrelationId;
            rhsCorrelationId = that.getCorrelationId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "correlationId", lhsCorrelationId), LocatorUtils.property(thatLocator, "correlationId", rhsCorrelationId), lhsCorrelationId, rhsCorrelationId)) {
                return false;
            }
        }
        {
            String lhsTimestamp;
            lhsTimestamp = this.getTimestamp();
            String rhsTimestamp;
            rhsTimestamp = that.getTimestamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timestamp", lhsTimestamp), LocatorUtils.property(thatLocator, "timestamp", rhsTimestamp), lhsTimestamp, rhsTimestamp)) {
                return false;
            }
        }
        {
            String lhsBuild;
            lhsBuild = this.getBuild();
            String rhsBuild;
            rhsBuild = that.getBuild();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "build", lhsBuild), LocatorUtils.property(thatLocator, "build", rhsBuild), lhsBuild, rhsBuild)) {
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
            Status theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            String thePayerID;
            thePayerID = this.getPayerID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "payerID", thePayerID), currentHashCode, thePayerID);
        }
        {
            String theTransactionID;
            theTransactionID = this.getTransactionID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transactionID", theTransactionID), currentHashCode, theTransactionID);
        }
        {
            String theAck;
            theAck = this.getAck();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ack", theAck), currentHashCode, theAck);
        }
        {
            String theCorrelationId;
            theCorrelationId = this.getCorrelationId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "correlationId", theCorrelationId), currentHashCode, theCorrelationId);
        }
        {
            String theTimestamp;
            theTimestamp = this.getTimestamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timestamp", theTimestamp), currentHashCode, theTimestamp);
        }
        {
            String theBuild;
            theBuild = this.getBuild();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "build", theBuild), currentHashCode, theBuild);
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
        if (draftCopy instanceof CompletePaymentResponse) {
            final CompletePaymentResponse copy = ((CompletePaymentResponse) draftCopy);
            if (this.status!= null) {
                Status sourceStatus;
                sourceStatus = this.getStatus();
                Status copyStatus = ((Status) strategy.copy(LocatorUtils.property(locator, "status", sourceStatus), sourceStatus));
                copy.setStatus(copyStatus);
            } else {
                copy.status = null;
            }
            if (this.payerID!= null) {
                String sourcePayerID;
                sourcePayerID = this.getPayerID();
                String copyPayerID = ((String) strategy.copy(LocatorUtils.property(locator, "payerID", sourcePayerID), sourcePayerID));
                copy.setPayerID(copyPayerID);
            } else {
                copy.payerID = null;
            }
            if (this.transactionID!= null) {
                String sourceTransactionID;
                sourceTransactionID = this.getTransactionID();
                String copyTransactionID = ((String) strategy.copy(LocatorUtils.property(locator, "transactionID", sourceTransactionID), sourceTransactionID));
                copy.setTransactionID(copyTransactionID);
            } else {
                copy.transactionID = null;
            }
            if (this.ack!= null) {
                String sourceAck;
                sourceAck = this.getAck();
                String copyAck = ((String) strategy.copy(LocatorUtils.property(locator, "ack", sourceAck), sourceAck));
                copy.setAck(copyAck);
            } else {
                copy.ack = null;
            }
            if (this.correlationId!= null) {
                String sourceCorrelationId;
                sourceCorrelationId = this.getCorrelationId();
                String copyCorrelationId = ((String) strategy.copy(LocatorUtils.property(locator, "correlationId", sourceCorrelationId), sourceCorrelationId));
                copy.setCorrelationId(copyCorrelationId);
            } else {
                copy.correlationId = null;
            }
            if (this.timestamp!= null) {
                String sourceTimestamp;
                sourceTimestamp = this.getTimestamp();
                String copyTimestamp = ((String) strategy.copy(LocatorUtils.property(locator, "timestamp", sourceTimestamp), sourceTimestamp));
                copy.setTimestamp(copyTimestamp);
            } else {
                copy.timestamp = null;
            }
            if (this.build!= null) {
                String sourceBuild;
                sourceBuild = this.getBuild();
                String copyBuild = ((String) strategy.copy(LocatorUtils.property(locator, "build", sourceBuild), sourceBuild));
                copy.setBuild(copyBuild);
            } else {
                copy.build = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CompletePaymentResponse();
    }

}
