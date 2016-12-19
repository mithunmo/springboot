//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.TrReferralsDomain;
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
 * <p>Java class for GetReferralByAuthCodeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReferralByAuthCodeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://common.businessobjects.f9g4.com}Status"/>
 *         &lt;element name="referral" type="{http://domain.businessobjects.f9g4.com}trReferralsDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReferralByAuthCodeResponse", propOrder = {
    "status",
    "referral"
})
@XmlRootElement(name = "GetReferralByAuthCodeResponse")
public class GetReferralByAuthCodeResponse implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Status status;
    protected List<TrReferralsDomain> referral;

    /**
     * Default no-arg constructor
     * 
     */
    public GetReferralByAuthCodeResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetReferralByAuthCodeResponse(final Status status, final List<TrReferralsDomain> referral) {
        this.status = status;
        this.referral = referral;
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
     * Gets the value of the referral property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referral property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferral().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrReferralsDomain }
     * 
     * 
     */
    public List<TrReferralsDomain> getReferral() {
        if (referral == null) {
            referral = new ArrayList<TrReferralsDomain>();
        }
        return this.referral;
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
            List<TrReferralsDomain> theReferral;
            theReferral = this.getReferral();
            strategy.appendField(locator, this, "referral", buffer, theReferral);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetReferralByAuthCodeResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetReferralByAuthCodeResponse that = ((GetReferralByAuthCodeResponse) object);
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
            List<TrReferralsDomain> lhsReferral;
            lhsReferral = this.getReferral();
            List<TrReferralsDomain> rhsReferral;
            rhsReferral = that.getReferral();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "referral", lhsReferral), LocatorUtils.property(thatLocator, "referral", rhsReferral), lhsReferral, rhsReferral)) {
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
            List<TrReferralsDomain> theReferral;
            theReferral = this.getReferral();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referral", theReferral), currentHashCode, theReferral);
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
        if (draftCopy instanceof GetReferralByAuthCodeResponse) {
            final GetReferralByAuthCodeResponse copy = ((GetReferralByAuthCodeResponse) draftCopy);
            if (this.status!= null) {
                Status sourceStatus;
                sourceStatus = this.getStatus();
                Status copyStatus = ((Status) strategy.copy(LocatorUtils.property(locator, "status", sourceStatus), sourceStatus));
                copy.setStatus(copyStatus);
            } else {
                copy.status = null;
            }
            if ((this.referral!= null)&&(!this.referral.isEmpty())) {
                List<TrReferralsDomain> sourceReferral;
                sourceReferral = this.getReferral();
                @SuppressWarnings("unchecked")
                List<TrReferralsDomain> copyReferral = ((List<TrReferralsDomain> ) strategy.copy(LocatorUtils.property(locator, "referral", sourceReferral), sourceReferral));
                copy.referral = null;
                List<TrReferralsDomain> uniqueReferrall = copy.getReferral();
                uniqueReferrall.addAll(copyReferral);
            } else {
                copy.referral = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetReferralByAuthCodeResponse();
    }

}