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
 * <p>Java class for trBroadcastMessagesDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trBroadcastMessagesDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broadcastId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="templateName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="msgScopeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="msgStatusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="adLookupValuesByMsgScopeId" type="{http://domain.businessobjects.f9g4.com}adLookupValuesDomain"/>
 *         &lt;element name="adLookupValuesByMsgStatusId" type="{http://domain.businessobjects.f9g4.com}adLookupValuesDomain"/>
 *         &lt;element name="processedDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="0001-01-01T00:00:00.000000000"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59.000000000"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}.\p{Nd}{1}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creationDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="0001-01-01T00:00:00.000000000"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59.000000000"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}.\p{Nd}{1}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastUpdateDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="0001-01-01T00:00:00.000000000"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59.000000000"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}.\p{Nd}{1}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lastUpdatedBy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trBroadcastMessagesDomain", propOrder = {
    "broadcastId",
    "templateName",
    "subject",
    "messageText",
    "msgScopeId",
    "msgStatusId",
    "adLookupValuesByMsgScopeId",
    "adLookupValuesByMsgStatusId",
    "processedDate",
    "errorMessage",
    "creationDate",
    "createdBy",
    "lastUpdateDate",
    "lastUpdatedBy"
})
public class TrBroadcastMessagesDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int broadcastId;
    @XmlElement(required = true)
    protected String templateName;
    @XmlElement(required = true)
    protected String subject;
    @XmlElement(required = true)
    protected String messageText;
    protected int msgScopeId;
    protected int msgStatusId;
    @XmlElement(required = true)
    protected AdLookupValuesDomain adLookupValuesByMsgScopeId;
    @XmlElement(required = true)
    protected AdLookupValuesDomain adLookupValuesByMsgStatusId;
    @XmlElement(required = true)
    protected XMLGregorianCalendar processedDate;
    @XmlElement(required = true)
    protected String errorMessage;
    @XmlElement(required = true)
    protected XMLGregorianCalendar creationDate;
    protected int createdBy;
    @XmlElement(required = true)
    protected XMLGregorianCalendar lastUpdateDate;
    protected int lastUpdatedBy;

    /**
     * Default no-arg constructor
     * 
     */
    public TrBroadcastMessagesDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrBroadcastMessagesDomain(final int broadcastId, final String templateName, final String subject, final String messageText, final int msgScopeId, final int msgStatusId, final AdLookupValuesDomain adLookupValuesByMsgScopeId, final AdLookupValuesDomain adLookupValuesByMsgStatusId, final XMLGregorianCalendar processedDate, final String errorMessage, final XMLGregorianCalendar creationDate, final int createdBy, final XMLGregorianCalendar lastUpdateDate, final int lastUpdatedBy) {
        this.broadcastId = broadcastId;
        this.templateName = templateName;
        this.subject = subject;
        this.messageText = messageText;
        this.msgScopeId = msgScopeId;
        this.msgStatusId = msgStatusId;
        this.adLookupValuesByMsgScopeId = adLookupValuesByMsgScopeId;
        this.adLookupValuesByMsgStatusId = adLookupValuesByMsgStatusId;
        this.processedDate = processedDate;
        this.errorMessage = errorMessage;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the value of the broadcastId property.
     * 
     */
    public int getBroadcastId() {
        return broadcastId;
    }

    /**
     * Sets the value of the broadcastId property.
     * 
     */
    public void setBroadcastId(int value) {
        this.broadcastId = value;
    }

    /**
     * Gets the value of the templateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the messageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Sets the value of the messageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageText(String value) {
        this.messageText = value;
    }

    /**
     * Gets the value of the msgScopeId property.
     * 
     */
    public int getMsgScopeId() {
        return msgScopeId;
    }

    /**
     * Sets the value of the msgScopeId property.
     * 
     */
    public void setMsgScopeId(int value) {
        this.msgScopeId = value;
    }

    /**
     * Gets the value of the msgStatusId property.
     * 
     */
    public int getMsgStatusId() {
        return msgStatusId;
    }

    /**
     * Sets the value of the msgStatusId property.
     * 
     */
    public void setMsgStatusId(int value) {
        this.msgStatusId = value;
    }

    /**
     * Gets the value of the adLookupValuesByMsgScopeId property.
     * 
     * @return
     *     possible object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public AdLookupValuesDomain getAdLookupValuesByMsgScopeId() {
        return adLookupValuesByMsgScopeId;
    }

    /**
     * Sets the value of the adLookupValuesByMsgScopeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public void setAdLookupValuesByMsgScopeId(AdLookupValuesDomain value) {
        this.adLookupValuesByMsgScopeId = value;
    }

    /**
     * Gets the value of the adLookupValuesByMsgStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public AdLookupValuesDomain getAdLookupValuesByMsgStatusId() {
        return adLookupValuesByMsgStatusId;
    }

    /**
     * Sets the value of the adLookupValuesByMsgStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public void setAdLookupValuesByMsgStatusId(AdLookupValuesDomain value) {
        this.adLookupValuesByMsgStatusId = value;
    }

    /**
     * Gets the value of the processedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessedDate() {
        return processedDate;
    }

    /**
     * Sets the value of the processedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessedDate(XMLGregorianCalendar value) {
        this.processedDate = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     */
    public int getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     */
    public void setCreatedBy(int value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the lastUpdatedBy property.
     * 
     */
    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Sets the value of the lastUpdatedBy property.
     * 
     */
    public void setLastUpdatedBy(int value) {
        this.lastUpdatedBy = value;
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
            int theBroadcastId;
            theBroadcastId = this.getBroadcastId();
            strategy.appendField(locator, this, "broadcastId", buffer, theBroadcastId);
        }
        {
            String theTemplateName;
            theTemplateName = this.getTemplateName();
            strategy.appendField(locator, this, "templateName", buffer, theTemplateName);
        }
        {
            String theSubject;
            theSubject = this.getSubject();
            strategy.appendField(locator, this, "subject", buffer, theSubject);
        }
        {
            String theMessageText;
            theMessageText = this.getMessageText();
            strategy.appendField(locator, this, "messageText", buffer, theMessageText);
        }
        {
            int theMsgScopeId;
            theMsgScopeId = this.getMsgScopeId();
            strategy.appendField(locator, this, "msgScopeId", buffer, theMsgScopeId);
        }
        {
            int theMsgStatusId;
            theMsgStatusId = this.getMsgStatusId();
            strategy.appendField(locator, this, "msgStatusId", buffer, theMsgStatusId);
        }
        {
            AdLookupValuesDomain theAdLookupValuesByMsgScopeId;
            theAdLookupValuesByMsgScopeId = this.getAdLookupValuesByMsgScopeId();
            strategy.appendField(locator, this, "adLookupValuesByMsgScopeId", buffer, theAdLookupValuesByMsgScopeId);
        }
        {
            AdLookupValuesDomain theAdLookupValuesByMsgStatusId;
            theAdLookupValuesByMsgStatusId = this.getAdLookupValuesByMsgStatusId();
            strategy.appendField(locator, this, "adLookupValuesByMsgStatusId", buffer, theAdLookupValuesByMsgStatusId);
        }
        {
            XMLGregorianCalendar theProcessedDate;
            theProcessedDate = this.getProcessedDate();
            strategy.appendField(locator, this, "processedDate", buffer, theProcessedDate);
        }
        {
            String theErrorMessage;
            theErrorMessage = this.getErrorMessage();
            strategy.appendField(locator, this, "errorMessage", buffer, theErrorMessage);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            strategy.appendField(locator, this, "creationDate", buffer, theCreationDate);
        }
        {
            int theCreatedBy;
            theCreatedBy = this.getCreatedBy();
            strategy.appendField(locator, this, "createdBy", buffer, theCreatedBy);
        }
        {
            XMLGregorianCalendar theLastUpdateDate;
            theLastUpdateDate = this.getLastUpdateDate();
            strategy.appendField(locator, this, "lastUpdateDate", buffer, theLastUpdateDate);
        }
        {
            int theLastUpdatedBy;
            theLastUpdatedBy = this.getLastUpdatedBy();
            strategy.appendField(locator, this, "lastUpdatedBy", buffer, theLastUpdatedBy);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TrBroadcastMessagesDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrBroadcastMessagesDomain that = ((TrBroadcastMessagesDomain) object);
        {
            int lhsBroadcastId;
            lhsBroadcastId = this.getBroadcastId();
            int rhsBroadcastId;
            rhsBroadcastId = that.getBroadcastId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "broadcastId", lhsBroadcastId), LocatorUtils.property(thatLocator, "broadcastId", rhsBroadcastId), lhsBroadcastId, rhsBroadcastId)) {
                return false;
            }
        }
        {
            String lhsTemplateName;
            lhsTemplateName = this.getTemplateName();
            String rhsTemplateName;
            rhsTemplateName = that.getTemplateName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "templateName", lhsTemplateName), LocatorUtils.property(thatLocator, "templateName", rhsTemplateName), lhsTemplateName, rhsTemplateName)) {
                return false;
            }
        }
        {
            String lhsSubject;
            lhsSubject = this.getSubject();
            String rhsSubject;
            rhsSubject = that.getSubject();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subject", lhsSubject), LocatorUtils.property(thatLocator, "subject", rhsSubject), lhsSubject, rhsSubject)) {
                return false;
            }
        }
        {
            String lhsMessageText;
            lhsMessageText = this.getMessageText();
            String rhsMessageText;
            rhsMessageText = that.getMessageText();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageText", lhsMessageText), LocatorUtils.property(thatLocator, "messageText", rhsMessageText), lhsMessageText, rhsMessageText)) {
                return false;
            }
        }
        {
            int lhsMsgScopeId;
            lhsMsgScopeId = this.getMsgScopeId();
            int rhsMsgScopeId;
            rhsMsgScopeId = that.getMsgScopeId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "msgScopeId", lhsMsgScopeId), LocatorUtils.property(thatLocator, "msgScopeId", rhsMsgScopeId), lhsMsgScopeId, rhsMsgScopeId)) {
                return false;
            }
        }
        {
            int lhsMsgStatusId;
            lhsMsgStatusId = this.getMsgStatusId();
            int rhsMsgStatusId;
            rhsMsgStatusId = that.getMsgStatusId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "msgStatusId", lhsMsgStatusId), LocatorUtils.property(thatLocator, "msgStatusId", rhsMsgStatusId), lhsMsgStatusId, rhsMsgStatusId)) {
                return false;
            }
        }
        {
            AdLookupValuesDomain lhsAdLookupValuesByMsgScopeId;
            lhsAdLookupValuesByMsgScopeId = this.getAdLookupValuesByMsgScopeId();
            AdLookupValuesDomain rhsAdLookupValuesByMsgScopeId;
            rhsAdLookupValuesByMsgScopeId = that.getAdLookupValuesByMsgScopeId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adLookupValuesByMsgScopeId", lhsAdLookupValuesByMsgScopeId), LocatorUtils.property(thatLocator, "adLookupValuesByMsgScopeId", rhsAdLookupValuesByMsgScopeId), lhsAdLookupValuesByMsgScopeId, rhsAdLookupValuesByMsgScopeId)) {
                return false;
            }
        }
        {
            AdLookupValuesDomain lhsAdLookupValuesByMsgStatusId;
            lhsAdLookupValuesByMsgStatusId = this.getAdLookupValuesByMsgStatusId();
            AdLookupValuesDomain rhsAdLookupValuesByMsgStatusId;
            rhsAdLookupValuesByMsgStatusId = that.getAdLookupValuesByMsgStatusId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adLookupValuesByMsgStatusId", lhsAdLookupValuesByMsgStatusId), LocatorUtils.property(thatLocator, "adLookupValuesByMsgStatusId", rhsAdLookupValuesByMsgStatusId), lhsAdLookupValuesByMsgStatusId, rhsAdLookupValuesByMsgStatusId)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsProcessedDate;
            lhsProcessedDate = this.getProcessedDate();
            XMLGregorianCalendar rhsProcessedDate;
            rhsProcessedDate = that.getProcessedDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "processedDate", lhsProcessedDate), LocatorUtils.property(thatLocator, "processedDate", rhsProcessedDate), lhsProcessedDate, rhsProcessedDate)) {
                return false;
            }
        }
        {
            String lhsErrorMessage;
            lhsErrorMessage = this.getErrorMessage();
            String rhsErrorMessage;
            rhsErrorMessage = that.getErrorMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "errorMessage", lhsErrorMessage), LocatorUtils.property(thatLocator, "errorMessage", rhsErrorMessage), lhsErrorMessage, rhsErrorMessage)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreationDate;
            lhsCreationDate = this.getCreationDate();
            XMLGregorianCalendar rhsCreationDate;
            rhsCreationDate = that.getCreationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationDate", lhsCreationDate), LocatorUtils.property(thatLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate)) {
                return false;
            }
        }
        {
            int lhsCreatedBy;
            lhsCreatedBy = this.getCreatedBy();
            int rhsCreatedBy;
            rhsCreatedBy = that.getCreatedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "createdBy", lhsCreatedBy), LocatorUtils.property(thatLocator, "createdBy", rhsCreatedBy), lhsCreatedBy, rhsCreatedBy)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLastUpdateDate;
            lhsLastUpdateDate = this.getLastUpdateDate();
            XMLGregorianCalendar rhsLastUpdateDate;
            rhsLastUpdateDate = that.getLastUpdateDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastUpdateDate", lhsLastUpdateDate), LocatorUtils.property(thatLocator, "lastUpdateDate", rhsLastUpdateDate), lhsLastUpdateDate, rhsLastUpdateDate)) {
                return false;
            }
        }
        {
            int lhsLastUpdatedBy;
            lhsLastUpdatedBy = this.getLastUpdatedBy();
            int rhsLastUpdatedBy;
            rhsLastUpdatedBy = that.getLastUpdatedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastUpdatedBy", lhsLastUpdatedBy), LocatorUtils.property(thatLocator, "lastUpdatedBy", rhsLastUpdatedBy), lhsLastUpdatedBy, rhsLastUpdatedBy)) {
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
            int theBroadcastId;
            theBroadcastId = this.getBroadcastId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "broadcastId", theBroadcastId), currentHashCode, theBroadcastId);
        }
        {
            String theTemplateName;
            theTemplateName = this.getTemplateName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "templateName", theTemplateName), currentHashCode, theTemplateName);
        }
        {
            String theSubject;
            theSubject = this.getSubject();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subject", theSubject), currentHashCode, theSubject);
        }
        {
            String theMessageText;
            theMessageText = this.getMessageText();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messageText", theMessageText), currentHashCode, theMessageText);
        }
        {
            int theMsgScopeId;
            theMsgScopeId = this.getMsgScopeId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "msgScopeId", theMsgScopeId), currentHashCode, theMsgScopeId);
        }
        {
            int theMsgStatusId;
            theMsgStatusId = this.getMsgStatusId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "msgStatusId", theMsgStatusId), currentHashCode, theMsgStatusId);
        }
        {
            AdLookupValuesDomain theAdLookupValuesByMsgScopeId;
            theAdLookupValuesByMsgScopeId = this.getAdLookupValuesByMsgScopeId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adLookupValuesByMsgScopeId", theAdLookupValuesByMsgScopeId), currentHashCode, theAdLookupValuesByMsgScopeId);
        }
        {
            AdLookupValuesDomain theAdLookupValuesByMsgStatusId;
            theAdLookupValuesByMsgStatusId = this.getAdLookupValuesByMsgStatusId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adLookupValuesByMsgStatusId", theAdLookupValuesByMsgStatusId), currentHashCode, theAdLookupValuesByMsgStatusId);
        }
        {
            XMLGregorianCalendar theProcessedDate;
            theProcessedDate = this.getProcessedDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "processedDate", theProcessedDate), currentHashCode, theProcessedDate);
        }
        {
            String theErrorMessage;
            theErrorMessage = this.getErrorMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "errorMessage", theErrorMessage), currentHashCode, theErrorMessage);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationDate", theCreationDate), currentHashCode, theCreationDate);
        }
        {
            int theCreatedBy;
            theCreatedBy = this.getCreatedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "createdBy", theCreatedBy), currentHashCode, theCreatedBy);
        }
        {
            XMLGregorianCalendar theLastUpdateDate;
            theLastUpdateDate = this.getLastUpdateDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastUpdateDate", theLastUpdateDate), currentHashCode, theLastUpdateDate);
        }
        {
            int theLastUpdatedBy;
            theLastUpdatedBy = this.getLastUpdatedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastUpdatedBy", theLastUpdatedBy), currentHashCode, theLastUpdatedBy);
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
        if (draftCopy instanceof TrBroadcastMessagesDomain) {
            final TrBroadcastMessagesDomain copy = ((TrBroadcastMessagesDomain) draftCopy);
            int sourceBroadcastId;
            sourceBroadcastId = this.getBroadcastId();
            int copyBroadcastId = strategy.copy(LocatorUtils.property(locator, "broadcastId", sourceBroadcastId), sourceBroadcastId);
            copy.setBroadcastId(copyBroadcastId);
            if (this.templateName!= null) {
                String sourceTemplateName;
                sourceTemplateName = this.getTemplateName();
                String copyTemplateName = ((String) strategy.copy(LocatorUtils.property(locator, "templateName", sourceTemplateName), sourceTemplateName));
                copy.setTemplateName(copyTemplateName);
            } else {
                copy.templateName = null;
            }
            if (this.subject!= null) {
                String sourceSubject;
                sourceSubject = this.getSubject();
                String copySubject = ((String) strategy.copy(LocatorUtils.property(locator, "subject", sourceSubject), sourceSubject));
                copy.setSubject(copySubject);
            } else {
                copy.subject = null;
            }
            if (this.messageText!= null) {
                String sourceMessageText;
                sourceMessageText = this.getMessageText();
                String copyMessageText = ((String) strategy.copy(LocatorUtils.property(locator, "messageText", sourceMessageText), sourceMessageText));
                copy.setMessageText(copyMessageText);
            } else {
                copy.messageText = null;
            }
            int sourceMsgScopeId;
            sourceMsgScopeId = this.getMsgScopeId();
            int copyMsgScopeId = strategy.copy(LocatorUtils.property(locator, "msgScopeId", sourceMsgScopeId), sourceMsgScopeId);
            copy.setMsgScopeId(copyMsgScopeId);
            int sourceMsgStatusId;
            sourceMsgStatusId = this.getMsgStatusId();
            int copyMsgStatusId = strategy.copy(LocatorUtils.property(locator, "msgStatusId", sourceMsgStatusId), sourceMsgStatusId);
            copy.setMsgStatusId(copyMsgStatusId);
            if (this.adLookupValuesByMsgScopeId!= null) {
                AdLookupValuesDomain sourceAdLookupValuesByMsgScopeId;
                sourceAdLookupValuesByMsgScopeId = this.getAdLookupValuesByMsgScopeId();
                AdLookupValuesDomain copyAdLookupValuesByMsgScopeId = ((AdLookupValuesDomain) strategy.copy(LocatorUtils.property(locator, "adLookupValuesByMsgScopeId", sourceAdLookupValuesByMsgScopeId), sourceAdLookupValuesByMsgScopeId));
                copy.setAdLookupValuesByMsgScopeId(copyAdLookupValuesByMsgScopeId);
            } else {
                copy.adLookupValuesByMsgScopeId = null;
            }
            if (this.adLookupValuesByMsgStatusId!= null) {
                AdLookupValuesDomain sourceAdLookupValuesByMsgStatusId;
                sourceAdLookupValuesByMsgStatusId = this.getAdLookupValuesByMsgStatusId();
                AdLookupValuesDomain copyAdLookupValuesByMsgStatusId = ((AdLookupValuesDomain) strategy.copy(LocatorUtils.property(locator, "adLookupValuesByMsgStatusId", sourceAdLookupValuesByMsgStatusId), sourceAdLookupValuesByMsgStatusId));
                copy.setAdLookupValuesByMsgStatusId(copyAdLookupValuesByMsgStatusId);
            } else {
                copy.adLookupValuesByMsgStatusId = null;
            }
            if (this.processedDate!= null) {
                XMLGregorianCalendar sourceProcessedDate;
                sourceProcessedDate = this.getProcessedDate();
                XMLGregorianCalendar copyProcessedDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "processedDate", sourceProcessedDate), sourceProcessedDate));
                copy.setProcessedDate(copyProcessedDate);
            } else {
                copy.processedDate = null;
            }
            if (this.errorMessage!= null) {
                String sourceErrorMessage;
                sourceErrorMessage = this.getErrorMessage();
                String copyErrorMessage = ((String) strategy.copy(LocatorUtils.property(locator, "errorMessage", sourceErrorMessage), sourceErrorMessage));
                copy.setErrorMessage(copyErrorMessage);
            } else {
                copy.errorMessage = null;
            }
            if (this.creationDate!= null) {
                XMLGregorianCalendar sourceCreationDate;
                sourceCreationDate = this.getCreationDate();
                XMLGregorianCalendar copyCreationDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "creationDate", sourceCreationDate), sourceCreationDate));
                copy.setCreationDate(copyCreationDate);
            } else {
                copy.creationDate = null;
            }
            int sourceCreatedBy;
            sourceCreatedBy = this.getCreatedBy();
            int copyCreatedBy = strategy.copy(LocatorUtils.property(locator, "createdBy", sourceCreatedBy), sourceCreatedBy);
            copy.setCreatedBy(copyCreatedBy);
            if (this.lastUpdateDate!= null) {
                XMLGregorianCalendar sourceLastUpdateDate;
                sourceLastUpdateDate = this.getLastUpdateDate();
                XMLGregorianCalendar copyLastUpdateDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "lastUpdateDate", sourceLastUpdateDate), sourceLastUpdateDate));
                copy.setLastUpdateDate(copyLastUpdateDate);
            } else {
                copy.lastUpdateDate = null;
            }
            int sourceLastUpdatedBy;
            sourceLastUpdatedBy = this.getLastUpdatedBy();
            int copyLastUpdatedBy = strategy.copy(LocatorUtils.property(locator, "lastUpdatedBy", sourceLastUpdatedBy), sourceLastUpdatedBy);
            copy.setLastUpdatedBy(copyLastUpdatedBy);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TrBroadcastMessagesDomain();
    }

}
