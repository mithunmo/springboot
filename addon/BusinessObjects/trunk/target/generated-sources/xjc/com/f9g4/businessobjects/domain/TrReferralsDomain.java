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
 * <p>Java class for trReferralsDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trReferralsDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referalId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sentUserId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="firstName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lastName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="phone">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="email">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="signedupUserid">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="expirationDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="whyRefer">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="message">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="authCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="120"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dateSent">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="signupOn">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="langCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *               &lt;minLength value="1"/>
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
@XmlType(name = "trReferralsDomain", propOrder = {
    "referalId",
    "sentUserId",
    "firstName",
    "lastName",
    "phone",
    "email",
    "signedupUserid",
    "expirationDate",
    "whyRefer",
    "message",
    "authCode",
    "dateSent",
    "signupOn",
    "langCode",
    "createdby",
    "lastupdateby"
})
public class TrReferralsDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int referalId;
    protected int sentUserId;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String phone;
    @XmlElement(required = true)
    protected String email;
    protected int signedupUserid;
    @XmlElement(required = true)
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(required = true)
    protected String whyRefer;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected String authCode;
    @XmlElement(required = true)
    protected XMLGregorianCalendar dateSent;
    @XmlElement(required = true)
    protected XMLGregorianCalendar signupOn;
    @XmlElement(required = true, defaultValue = "en-US")
    protected String langCode;
    protected int createdby;
    protected int lastupdateby;

    /**
     * Default no-arg constructor
     * 
     */
    public TrReferralsDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrReferralsDomain(final int referalId, final int sentUserId, final String firstName, final String lastName, final String phone, final String email, final int signedupUserid, final XMLGregorianCalendar expirationDate, final String whyRefer, final String message, final String authCode, final XMLGregorianCalendar dateSent, final XMLGregorianCalendar signupOn, final String langCode, final int createdby, final int lastupdateby) {
        this.referalId = referalId;
        this.sentUserId = sentUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.signedupUserid = signedupUserid;
        this.expirationDate = expirationDate;
        this.whyRefer = whyRefer;
        this.message = message;
        this.authCode = authCode;
        this.dateSent = dateSent;
        this.signupOn = signupOn;
        this.langCode = langCode;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
    }

    /**
     * Gets the value of the referalId property.
     * 
     */
    public int getReferalId() {
        return referalId;
    }

    /**
     * Sets the value of the referalId property.
     * 
     */
    public void setReferalId(int value) {
        this.referalId = value;
    }

    /**
     * Gets the value of the sentUserId property.
     * 
     */
    public int getSentUserId() {
        return sentUserId;
    }

    /**
     * Sets the value of the sentUserId property.
     * 
     */
    public void setSentUserId(int value) {
        this.sentUserId = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the signedupUserid property.
     * 
     */
    public int getSignedupUserid() {
        return signedupUserid;
    }

    /**
     * Sets the value of the signedupUserid property.
     * 
     */
    public void setSignedupUserid(int value) {
        this.signedupUserid = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the whyRefer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhyRefer() {
        return whyRefer;
    }

    /**
     * Sets the value of the whyRefer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhyRefer(String value) {
        this.whyRefer = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the authCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Sets the value of the authCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthCode(String value) {
        this.authCode = value;
    }

    /**
     * Gets the value of the dateSent property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateSent() {
        return dateSent;
    }

    /**
     * Sets the value of the dateSent property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateSent(XMLGregorianCalendar value) {
        this.dateSent = value;
    }

    /**
     * Gets the value of the signupOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSignupOn() {
        return signupOn;
    }

    /**
     * Sets the value of the signupOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSignupOn(XMLGregorianCalendar value) {
        this.signupOn = value;
    }

    /**
     * Gets the value of the langCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangCode() {
        return langCode;
    }

    /**
     * Sets the value of the langCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangCode(String value) {
        this.langCode = value;
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
            int theReferalId;
            theReferalId = this.getReferalId();
            strategy.appendField(locator, this, "referalId", buffer, theReferalId);
        }
        {
            int theSentUserId;
            theSentUserId = this.getSentUserId();
            strategy.appendField(locator, this, "sentUserId", buffer, theSentUserId);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            strategy.appendField(locator, this, "firstName", buffer, theFirstName);
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            strategy.appendField(locator, this, "lastName", buffer, theLastName);
        }
        {
            String thePhone;
            thePhone = this.getPhone();
            strategy.appendField(locator, this, "phone", buffer, thePhone);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            strategy.appendField(locator, this, "email", buffer, theEmail);
        }
        {
            int theSignedupUserid;
            theSignedupUserid = this.getSignedupUserid();
            strategy.appendField(locator, this, "signedupUserid", buffer, theSignedupUserid);
        }
        {
            XMLGregorianCalendar theExpirationDate;
            theExpirationDate = this.getExpirationDate();
            strategy.appendField(locator, this, "expirationDate", buffer, theExpirationDate);
        }
        {
            String theWhyRefer;
            theWhyRefer = this.getWhyRefer();
            strategy.appendField(locator, this, "whyRefer", buffer, theWhyRefer);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            strategy.appendField(locator, this, "message", buffer, theMessage);
        }
        {
            String theAuthCode;
            theAuthCode = this.getAuthCode();
            strategy.appendField(locator, this, "authCode", buffer, theAuthCode);
        }
        {
            XMLGregorianCalendar theDateSent;
            theDateSent = this.getDateSent();
            strategy.appendField(locator, this, "dateSent", buffer, theDateSent);
        }
        {
            XMLGregorianCalendar theSignupOn;
            theSignupOn = this.getSignupOn();
            strategy.appendField(locator, this, "signupOn", buffer, theSignupOn);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            strategy.appendField(locator, this, "langCode", buffer, theLangCode);
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
        if (!(object instanceof TrReferralsDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrReferralsDomain that = ((TrReferralsDomain) object);
        {
            int lhsReferalId;
            lhsReferalId = this.getReferalId();
            int rhsReferalId;
            rhsReferalId = that.getReferalId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "referalId", lhsReferalId), LocatorUtils.property(thatLocator, "referalId", rhsReferalId), lhsReferalId, rhsReferalId)) {
                return false;
            }
        }
        {
            int lhsSentUserId;
            lhsSentUserId = this.getSentUserId();
            int rhsSentUserId;
            rhsSentUserId = that.getSentUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sentUserId", lhsSentUserId), LocatorUtils.property(thatLocator, "sentUserId", rhsSentUserId), lhsSentUserId, rhsSentUserId)) {
                return false;
            }
        }
        {
            String lhsFirstName;
            lhsFirstName = this.getFirstName();
            String rhsFirstName;
            rhsFirstName = that.getFirstName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "firstName", lhsFirstName), LocatorUtils.property(thatLocator, "firstName", rhsFirstName), lhsFirstName, rhsFirstName)) {
                return false;
            }
        }
        {
            String lhsLastName;
            lhsLastName = this.getLastName();
            String rhsLastName;
            rhsLastName = that.getLastName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastName", lhsLastName), LocatorUtils.property(thatLocator, "lastName", rhsLastName), lhsLastName, rhsLastName)) {
                return false;
            }
        }
        {
            String lhsPhone;
            lhsPhone = this.getPhone();
            String rhsPhone;
            rhsPhone = that.getPhone();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "phone", lhsPhone), LocatorUtils.property(thatLocator, "phone", rhsPhone), lhsPhone, rhsPhone)) {
                return false;
            }
        }
        {
            String lhsEmail;
            lhsEmail = this.getEmail();
            String rhsEmail;
            rhsEmail = that.getEmail();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail)) {
                return false;
            }
        }
        {
            int lhsSignedupUserid;
            lhsSignedupUserid = this.getSignedupUserid();
            int rhsSignedupUserid;
            rhsSignedupUserid = that.getSignedupUserid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signedupUserid", lhsSignedupUserid), LocatorUtils.property(thatLocator, "signedupUserid", rhsSignedupUserid), lhsSignedupUserid, rhsSignedupUserid)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsExpirationDate;
            lhsExpirationDate = this.getExpirationDate();
            XMLGregorianCalendar rhsExpirationDate;
            rhsExpirationDate = that.getExpirationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expirationDate", lhsExpirationDate), LocatorUtils.property(thatLocator, "expirationDate", rhsExpirationDate), lhsExpirationDate, rhsExpirationDate)) {
                return false;
            }
        }
        {
            String lhsWhyRefer;
            lhsWhyRefer = this.getWhyRefer();
            String rhsWhyRefer;
            rhsWhyRefer = that.getWhyRefer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "whyRefer", lhsWhyRefer), LocatorUtils.property(thatLocator, "whyRefer", rhsWhyRefer), lhsWhyRefer, rhsWhyRefer)) {
                return false;
            }
        }
        {
            String lhsMessage;
            lhsMessage = this.getMessage();
            String rhsMessage;
            rhsMessage = that.getMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
                return false;
            }
        }
        {
            String lhsAuthCode;
            lhsAuthCode = this.getAuthCode();
            String rhsAuthCode;
            rhsAuthCode = that.getAuthCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "authCode", lhsAuthCode), LocatorUtils.property(thatLocator, "authCode", rhsAuthCode), lhsAuthCode, rhsAuthCode)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateSent;
            lhsDateSent = this.getDateSent();
            XMLGregorianCalendar rhsDateSent;
            rhsDateSent = that.getDateSent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateSent", lhsDateSent), LocatorUtils.property(thatLocator, "dateSent", rhsDateSent), lhsDateSent, rhsDateSent)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsSignupOn;
            lhsSignupOn = this.getSignupOn();
            XMLGregorianCalendar rhsSignupOn;
            rhsSignupOn = that.getSignupOn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signupOn", lhsSignupOn), LocatorUtils.property(thatLocator, "signupOn", rhsSignupOn), lhsSignupOn, rhsSignupOn)) {
                return false;
            }
        }
        {
            String lhsLangCode;
            lhsLangCode = this.getLangCode();
            String rhsLangCode;
            rhsLangCode = that.getLangCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "langCode", lhsLangCode), LocatorUtils.property(thatLocator, "langCode", rhsLangCode), lhsLangCode, rhsLangCode)) {
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
            int theReferalId;
            theReferalId = this.getReferalId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referalId", theReferalId), currentHashCode, theReferalId);
        }
        {
            int theSentUserId;
            theSentUserId = this.getSentUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sentUserId", theSentUserId), currentHashCode, theSentUserId);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstName", theFirstName), currentHashCode, theFirstName);
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastName", theLastName), currentHashCode, theLastName);
        }
        {
            String thePhone;
            thePhone = this.getPhone();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "phone", thePhone), currentHashCode, thePhone);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
        }
        {
            int theSignedupUserid;
            theSignedupUserid = this.getSignedupUserid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signedupUserid", theSignedupUserid), currentHashCode, theSignedupUserid);
        }
        {
            XMLGregorianCalendar theExpirationDate;
            theExpirationDate = this.getExpirationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expirationDate", theExpirationDate), currentHashCode, theExpirationDate);
        }
        {
            String theWhyRefer;
            theWhyRefer = this.getWhyRefer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "whyRefer", theWhyRefer), currentHashCode, theWhyRefer);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            String theAuthCode;
            theAuthCode = this.getAuthCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "authCode", theAuthCode), currentHashCode, theAuthCode);
        }
        {
            XMLGregorianCalendar theDateSent;
            theDateSent = this.getDateSent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateSent", theDateSent), currentHashCode, theDateSent);
        }
        {
            XMLGregorianCalendar theSignupOn;
            theSignupOn = this.getSignupOn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signupOn", theSignupOn), currentHashCode, theSignupOn);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "langCode", theLangCode), currentHashCode, theLangCode);
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
        if (draftCopy instanceof TrReferralsDomain) {
            final TrReferralsDomain copy = ((TrReferralsDomain) draftCopy);
            int sourceReferalId;
            sourceReferalId = this.getReferalId();
            int copyReferalId = strategy.copy(LocatorUtils.property(locator, "referalId", sourceReferalId), sourceReferalId);
            copy.setReferalId(copyReferalId);
            int sourceSentUserId;
            sourceSentUserId = this.getSentUserId();
            int copySentUserId = strategy.copy(LocatorUtils.property(locator, "sentUserId", sourceSentUserId), sourceSentUserId);
            copy.setSentUserId(copySentUserId);
            if (this.firstName!= null) {
                String sourceFirstName;
                sourceFirstName = this.getFirstName();
                String copyFirstName = ((String) strategy.copy(LocatorUtils.property(locator, "firstName", sourceFirstName), sourceFirstName));
                copy.setFirstName(copyFirstName);
            } else {
                copy.firstName = null;
            }
            if (this.lastName!= null) {
                String sourceLastName;
                sourceLastName = this.getLastName();
                String copyLastName = ((String) strategy.copy(LocatorUtils.property(locator, "lastName", sourceLastName), sourceLastName));
                copy.setLastName(copyLastName);
            } else {
                copy.lastName = null;
            }
            if (this.phone!= null) {
                String sourcePhone;
                sourcePhone = this.getPhone();
                String copyPhone = ((String) strategy.copy(LocatorUtils.property(locator, "phone", sourcePhone), sourcePhone));
                copy.setPhone(copyPhone);
            } else {
                copy.phone = null;
            }
            if (this.email!= null) {
                String sourceEmail;
                sourceEmail = this.getEmail();
                String copyEmail = ((String) strategy.copy(LocatorUtils.property(locator, "email", sourceEmail), sourceEmail));
                copy.setEmail(copyEmail);
            } else {
                copy.email = null;
            }
            int sourceSignedupUserid;
            sourceSignedupUserid = this.getSignedupUserid();
            int copySignedupUserid = strategy.copy(LocatorUtils.property(locator, "signedupUserid", sourceSignedupUserid), sourceSignedupUserid);
            copy.setSignedupUserid(copySignedupUserid);
            if (this.expirationDate!= null) {
                XMLGregorianCalendar sourceExpirationDate;
                sourceExpirationDate = this.getExpirationDate();
                XMLGregorianCalendar copyExpirationDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "expirationDate", sourceExpirationDate), sourceExpirationDate));
                copy.setExpirationDate(copyExpirationDate);
            } else {
                copy.expirationDate = null;
            }
            if (this.whyRefer!= null) {
                String sourceWhyRefer;
                sourceWhyRefer = this.getWhyRefer();
                String copyWhyRefer = ((String) strategy.copy(LocatorUtils.property(locator, "whyRefer", sourceWhyRefer), sourceWhyRefer));
                copy.setWhyRefer(copyWhyRefer);
            } else {
                copy.whyRefer = null;
            }
            if (this.message!= null) {
                String sourceMessage;
                sourceMessage = this.getMessage();
                String copyMessage = ((String) strategy.copy(LocatorUtils.property(locator, "message", sourceMessage), sourceMessage));
                copy.setMessage(copyMessage);
            } else {
                copy.message = null;
            }
            if (this.authCode!= null) {
                String sourceAuthCode;
                sourceAuthCode = this.getAuthCode();
                String copyAuthCode = ((String) strategy.copy(LocatorUtils.property(locator, "authCode", sourceAuthCode), sourceAuthCode));
                copy.setAuthCode(copyAuthCode);
            } else {
                copy.authCode = null;
            }
            if (this.dateSent!= null) {
                XMLGregorianCalendar sourceDateSent;
                sourceDateSent = this.getDateSent();
                XMLGregorianCalendar copyDateSent = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "dateSent", sourceDateSent), sourceDateSent));
                copy.setDateSent(copyDateSent);
            } else {
                copy.dateSent = null;
            }
            if (this.signupOn!= null) {
                XMLGregorianCalendar sourceSignupOn;
                sourceSignupOn = this.getSignupOn();
                XMLGregorianCalendar copySignupOn = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "signupOn", sourceSignupOn), sourceSignupOn));
                copy.setSignupOn(copySignupOn);
            } else {
                copy.signupOn = null;
            }
            if (this.langCode!= null) {
                String sourceLangCode;
                sourceLangCode = this.getLangCode();
                String copyLangCode = ((String) strategy.copy(LocatorUtils.property(locator, "langCode", sourceLangCode), sourceLangCode));
                copy.setLangCode(copyLangCode);
            } else {
                copy.langCode = null;
            }
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
        return new TrReferralsDomain();
    }

}
