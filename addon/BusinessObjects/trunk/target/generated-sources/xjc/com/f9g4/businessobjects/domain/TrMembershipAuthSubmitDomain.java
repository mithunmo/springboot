//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for trMembershipAuthSubmitDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trMembershipAuthSubmitDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="memAuthSubmitId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="membershipId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="chargeAmount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="15"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-10000000000000"/>
 *               &lt;maxExclusive value="10000000000000"/>
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
 *         &lt;element name="initialTimeStamp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="0001-01-01T00:00:00.000000000"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59.000000000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="secureToken">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="receiveMembershipPayments" type="{http://domain.businessobjects.f9g4.com}trReceiveMembershipPaymentsDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trMembershipAuthSubmitDomain", propOrder = {
    "memAuthSubmitId",
    "membershipId",
    "chargeAmount",
    "createdby",
    "lastupdateby",
    "initialTimeStamp",
    "secureToken",
    "receiveMembershipPayments"
})
public class TrMembershipAuthSubmitDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int memAuthSubmitId;
    protected int membershipId;
    @XmlElement(required = true)
    protected BigDecimal chargeAmount;
    protected int createdby;
    protected int lastupdateby;
    @XmlElement(required = true)
    protected XMLGregorianCalendar initialTimeStamp;
    @XmlElement(required = true)
    protected String secureToken;
    protected List<TrReceiveMembershipPaymentsDomain> receiveMembershipPayments;

    /**
     * Default no-arg constructor
     * 
     */
    public TrMembershipAuthSubmitDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrMembershipAuthSubmitDomain(final int memAuthSubmitId, final int membershipId, final BigDecimal chargeAmount, final int createdby, final int lastupdateby, final XMLGregorianCalendar initialTimeStamp, final String secureToken, final List<TrReceiveMembershipPaymentsDomain> receiveMembershipPayments) {
        this.memAuthSubmitId = memAuthSubmitId;
        this.membershipId = membershipId;
        this.chargeAmount = chargeAmount;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
        this.initialTimeStamp = initialTimeStamp;
        this.secureToken = secureToken;
        this.receiveMembershipPayments = receiveMembershipPayments;
    }

    /**
     * Gets the value of the memAuthSubmitId property.
     * 
     */
    public int getMemAuthSubmitId() {
        return memAuthSubmitId;
    }

    /**
     * Sets the value of the memAuthSubmitId property.
     * 
     */
    public void setMemAuthSubmitId(int value) {
        this.memAuthSubmitId = value;
    }

    /**
     * Gets the value of the membershipId property.
     * 
     */
    public int getMembershipId() {
        return membershipId;
    }

    /**
     * Sets the value of the membershipId property.
     * 
     */
    public void setMembershipId(int value) {
        this.membershipId = value;
    }

    /**
     * Gets the value of the chargeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    /**
     * Sets the value of the chargeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChargeAmount(BigDecimal value) {
        this.chargeAmount = value;
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
     * Gets the value of the initialTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInitialTimeStamp() {
        return initialTimeStamp;
    }

    /**
     * Sets the value of the initialTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInitialTimeStamp(XMLGregorianCalendar value) {
        this.initialTimeStamp = value;
    }

    /**
     * Gets the value of the secureToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecureToken() {
        return secureToken;
    }

    /**
     * Sets the value of the secureToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecureToken(String value) {
        this.secureToken = value;
    }

    /**
     * Gets the value of the receiveMembershipPayments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiveMembershipPayments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiveMembershipPayments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrReceiveMembershipPaymentsDomain }
     * 
     * 
     */
    public List<TrReceiveMembershipPaymentsDomain> getReceiveMembershipPayments() {
        if (receiveMembershipPayments == null) {
            receiveMembershipPayments = new ArrayList<TrReceiveMembershipPaymentsDomain>();
        }
        return this.receiveMembershipPayments;
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
            int theMemAuthSubmitId;
            theMemAuthSubmitId = this.getMemAuthSubmitId();
            strategy.appendField(locator, this, "memAuthSubmitId", buffer, theMemAuthSubmitId);
        }
        {
            int theMembershipId;
            theMembershipId = this.getMembershipId();
            strategy.appendField(locator, this, "membershipId", buffer, theMembershipId);
        }
        {
            BigDecimal theChargeAmount;
            theChargeAmount = this.getChargeAmount();
            strategy.appendField(locator, this, "chargeAmount", buffer, theChargeAmount);
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
            XMLGregorianCalendar theInitialTimeStamp;
            theInitialTimeStamp = this.getInitialTimeStamp();
            strategy.appendField(locator, this, "initialTimeStamp", buffer, theInitialTimeStamp);
        }
        {
            String theSecureToken;
            theSecureToken = this.getSecureToken();
            strategy.appendField(locator, this, "secureToken", buffer, theSecureToken);
        }
        {
            List<TrReceiveMembershipPaymentsDomain> theReceiveMembershipPayments;
            theReceiveMembershipPayments = this.getReceiveMembershipPayments();
            strategy.appendField(locator, this, "receiveMembershipPayments", buffer, theReceiveMembershipPayments);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TrMembershipAuthSubmitDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrMembershipAuthSubmitDomain that = ((TrMembershipAuthSubmitDomain) object);
        {
            int lhsMemAuthSubmitId;
            lhsMemAuthSubmitId = this.getMemAuthSubmitId();
            int rhsMemAuthSubmitId;
            rhsMemAuthSubmitId = that.getMemAuthSubmitId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "memAuthSubmitId", lhsMemAuthSubmitId), LocatorUtils.property(thatLocator, "memAuthSubmitId", rhsMemAuthSubmitId), lhsMemAuthSubmitId, rhsMemAuthSubmitId)) {
                return false;
            }
        }
        {
            int lhsMembershipId;
            lhsMembershipId = this.getMembershipId();
            int rhsMembershipId;
            rhsMembershipId = that.getMembershipId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "membershipId", lhsMembershipId), LocatorUtils.property(thatLocator, "membershipId", rhsMembershipId), lhsMembershipId, rhsMembershipId)) {
                return false;
            }
        }
        {
            BigDecimal lhsChargeAmount;
            lhsChargeAmount = this.getChargeAmount();
            BigDecimal rhsChargeAmount;
            rhsChargeAmount = that.getChargeAmount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "chargeAmount", lhsChargeAmount), LocatorUtils.property(thatLocator, "chargeAmount", rhsChargeAmount), lhsChargeAmount, rhsChargeAmount)) {
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
            XMLGregorianCalendar lhsInitialTimeStamp;
            lhsInitialTimeStamp = this.getInitialTimeStamp();
            XMLGregorianCalendar rhsInitialTimeStamp;
            rhsInitialTimeStamp = that.getInitialTimeStamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "initialTimeStamp", lhsInitialTimeStamp), LocatorUtils.property(thatLocator, "initialTimeStamp", rhsInitialTimeStamp), lhsInitialTimeStamp, rhsInitialTimeStamp)) {
                return false;
            }
        }
        {
            String lhsSecureToken;
            lhsSecureToken = this.getSecureToken();
            String rhsSecureToken;
            rhsSecureToken = that.getSecureToken();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "secureToken", lhsSecureToken), LocatorUtils.property(thatLocator, "secureToken", rhsSecureToken), lhsSecureToken, rhsSecureToken)) {
                return false;
            }
        }
        {
            List<TrReceiveMembershipPaymentsDomain> lhsReceiveMembershipPayments;
            lhsReceiveMembershipPayments = this.getReceiveMembershipPayments();
            List<TrReceiveMembershipPaymentsDomain> rhsReceiveMembershipPayments;
            rhsReceiveMembershipPayments = that.getReceiveMembershipPayments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "receiveMembershipPayments", lhsReceiveMembershipPayments), LocatorUtils.property(thatLocator, "receiveMembershipPayments", rhsReceiveMembershipPayments), lhsReceiveMembershipPayments, rhsReceiveMembershipPayments)) {
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
            int theMemAuthSubmitId;
            theMemAuthSubmitId = this.getMemAuthSubmitId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "memAuthSubmitId", theMemAuthSubmitId), currentHashCode, theMemAuthSubmitId);
        }
        {
            int theMembershipId;
            theMembershipId = this.getMembershipId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "membershipId", theMembershipId), currentHashCode, theMembershipId);
        }
        {
            BigDecimal theChargeAmount;
            theChargeAmount = this.getChargeAmount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "chargeAmount", theChargeAmount), currentHashCode, theChargeAmount);
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
            XMLGregorianCalendar theInitialTimeStamp;
            theInitialTimeStamp = this.getInitialTimeStamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "initialTimeStamp", theInitialTimeStamp), currentHashCode, theInitialTimeStamp);
        }
        {
            String theSecureToken;
            theSecureToken = this.getSecureToken();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "secureToken", theSecureToken), currentHashCode, theSecureToken);
        }
        {
            List<TrReceiveMembershipPaymentsDomain> theReceiveMembershipPayments;
            theReceiveMembershipPayments = this.getReceiveMembershipPayments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "receiveMembershipPayments", theReceiveMembershipPayments), currentHashCode, theReceiveMembershipPayments);
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
        if (draftCopy instanceof TrMembershipAuthSubmitDomain) {
            final TrMembershipAuthSubmitDomain copy = ((TrMembershipAuthSubmitDomain) draftCopy);
            int sourceMemAuthSubmitId;
            sourceMemAuthSubmitId = this.getMemAuthSubmitId();
            int copyMemAuthSubmitId = strategy.copy(LocatorUtils.property(locator, "memAuthSubmitId", sourceMemAuthSubmitId), sourceMemAuthSubmitId);
            copy.setMemAuthSubmitId(copyMemAuthSubmitId);
            int sourceMembershipId;
            sourceMembershipId = this.getMembershipId();
            int copyMembershipId = strategy.copy(LocatorUtils.property(locator, "membershipId", sourceMembershipId), sourceMembershipId);
            copy.setMembershipId(copyMembershipId);
            if (this.chargeAmount!= null) {
                BigDecimal sourceChargeAmount;
                sourceChargeAmount = this.getChargeAmount();
                BigDecimal copyChargeAmount = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "chargeAmount", sourceChargeAmount), sourceChargeAmount));
                copy.setChargeAmount(copyChargeAmount);
            } else {
                copy.chargeAmount = null;
            }
            int sourceCreatedby;
            sourceCreatedby = this.getCreatedby();
            int copyCreatedby = strategy.copy(LocatorUtils.property(locator, "createdby", sourceCreatedby), sourceCreatedby);
            copy.setCreatedby(copyCreatedby);
            int sourceLastupdateby;
            sourceLastupdateby = this.getLastupdateby();
            int copyLastupdateby = strategy.copy(LocatorUtils.property(locator, "lastupdateby", sourceLastupdateby), sourceLastupdateby);
            copy.setLastupdateby(copyLastupdateby);
            if (this.initialTimeStamp!= null) {
                XMLGregorianCalendar sourceInitialTimeStamp;
                sourceInitialTimeStamp = this.getInitialTimeStamp();
                XMLGregorianCalendar copyInitialTimeStamp = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "initialTimeStamp", sourceInitialTimeStamp), sourceInitialTimeStamp));
                copy.setInitialTimeStamp(copyInitialTimeStamp);
            } else {
                copy.initialTimeStamp = null;
            }
            if (this.secureToken!= null) {
                String sourceSecureToken;
                sourceSecureToken = this.getSecureToken();
                String copySecureToken = ((String) strategy.copy(LocatorUtils.property(locator, "secureToken", sourceSecureToken), sourceSecureToken));
                copy.setSecureToken(copySecureToken);
            } else {
                copy.secureToken = null;
            }
            if ((this.receiveMembershipPayments!= null)&&(!this.receiveMembershipPayments.isEmpty())) {
                List<TrReceiveMembershipPaymentsDomain> sourceReceiveMembershipPayments;
                sourceReceiveMembershipPayments = this.getReceiveMembershipPayments();
                @SuppressWarnings("unchecked")
                List<TrReceiveMembershipPaymentsDomain> copyReceiveMembershipPayments = ((List<TrReceiveMembershipPaymentsDomain> ) strategy.copy(LocatorUtils.property(locator, "receiveMembershipPayments", sourceReceiveMembershipPayments), sourceReceiveMembershipPayments));
                copy.receiveMembershipPayments = null;
                List<TrReceiveMembershipPaymentsDomain> uniqueReceiveMembershipPaymentsl = copy.getReceiveMembershipPayments();
                uniqueReceiveMembershipPaymentsl.addAll(copyReceiveMembershipPayments);
            } else {
                copy.receiveMembershipPayments = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TrMembershipAuthSubmitDomain();
    }

}
