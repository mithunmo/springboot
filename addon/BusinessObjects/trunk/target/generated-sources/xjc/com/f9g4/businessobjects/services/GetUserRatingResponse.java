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
 * <p>Java class for GetUserRatingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUserRatingResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="overallRating" type="{http://services.businessobjects.f9g4.com}Rating1"/>
 *         &lt;element name="qualityRating" type="{http://services.businessobjects.f9g4.com}Rating1"/>
 *         &lt;element name="priceRating" type="{http://services.businessobjects.f9g4.com}Rating1"/>
 *         &lt;element name="reliabilityRating" type="{http://services.businessobjects.f9g4.com}Rating1"/>
 *         &lt;element name="customizationRating" type="{http://services.businessobjects.f9g4.com}Rating1"/>
 *         &lt;element name="averageRating" type="{http://services.businessobjects.f9g4.com}Rating1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserRatingResponse", propOrder = {
    "overallRating",
    "qualityRating",
    "priceRating",
    "reliabilityRating",
    "customizationRating",
    "averageRating"
})
@XmlRootElement(name = "GetUserRatingResponse")
public class GetUserRatingResponse implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Rating1 overallRating;
    @XmlElement(required = true)
    protected Rating1 qualityRating;
    @XmlElement(required = true)
    protected Rating1 priceRating;
    @XmlElement(required = true)
    protected Rating1 reliabilityRating;
    @XmlElement(required = true)
    protected Rating1 customizationRating;
    @XmlElement(required = true)
    protected Rating1 averageRating;

    /**
     * Default no-arg constructor
     * 
     */
    public GetUserRatingResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetUserRatingResponse(final Rating1 overallRating, final Rating1 qualityRating, final Rating1 priceRating, final Rating1 reliabilityRating, final Rating1 customizationRating, final Rating1 averageRating) {
        this.overallRating = overallRating;
        this.qualityRating = qualityRating;
        this.priceRating = priceRating;
        this.reliabilityRating = reliabilityRating;
        this.customizationRating = customizationRating;
        this.averageRating = averageRating;
    }

    /**
     * Gets the value of the overallRating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating1 }
     *     
     */
    public Rating1 getOverallRating() {
        return overallRating;
    }

    /**
     * Sets the value of the overallRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating1 }
     *     
     */
    public void setOverallRating(Rating1 value) {
        this.overallRating = value;
    }

    /**
     * Gets the value of the qualityRating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating1 }
     *     
     */
    public Rating1 getQualityRating() {
        return qualityRating;
    }

    /**
     * Sets the value of the qualityRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating1 }
     *     
     */
    public void setQualityRating(Rating1 value) {
        this.qualityRating = value;
    }

    /**
     * Gets the value of the priceRating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating1 }
     *     
     */
    public Rating1 getPriceRating() {
        return priceRating;
    }

    /**
     * Sets the value of the priceRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating1 }
     *     
     */
    public void setPriceRating(Rating1 value) {
        this.priceRating = value;
    }

    /**
     * Gets the value of the reliabilityRating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating1 }
     *     
     */
    public Rating1 getReliabilityRating() {
        return reliabilityRating;
    }

    /**
     * Sets the value of the reliabilityRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating1 }
     *     
     */
    public void setReliabilityRating(Rating1 value) {
        this.reliabilityRating = value;
    }

    /**
     * Gets the value of the customizationRating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating1 }
     *     
     */
    public Rating1 getCustomizationRating() {
        return customizationRating;
    }

    /**
     * Sets the value of the customizationRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating1 }
     *     
     */
    public void setCustomizationRating(Rating1 value) {
        this.customizationRating = value;
    }

    /**
     * Gets the value of the averageRating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating1 }
     *     
     */
    public Rating1 getAverageRating() {
        return averageRating;
    }

    /**
     * Sets the value of the averageRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating1 }
     *     
     */
    public void setAverageRating(Rating1 value) {
        this.averageRating = value;
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
            Rating1 theOverallRating;
            theOverallRating = this.getOverallRating();
            strategy.appendField(locator, this, "overallRating", buffer, theOverallRating);
        }
        {
            Rating1 theQualityRating;
            theQualityRating = this.getQualityRating();
            strategy.appendField(locator, this, "qualityRating", buffer, theQualityRating);
        }
        {
            Rating1 thePriceRating;
            thePriceRating = this.getPriceRating();
            strategy.appendField(locator, this, "priceRating", buffer, thePriceRating);
        }
        {
            Rating1 theReliabilityRating;
            theReliabilityRating = this.getReliabilityRating();
            strategy.appendField(locator, this, "reliabilityRating", buffer, theReliabilityRating);
        }
        {
            Rating1 theCustomizationRating;
            theCustomizationRating = this.getCustomizationRating();
            strategy.appendField(locator, this, "customizationRating", buffer, theCustomizationRating);
        }
        {
            Rating1 theAverageRating;
            theAverageRating = this.getAverageRating();
            strategy.appendField(locator, this, "averageRating", buffer, theAverageRating);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetUserRatingResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetUserRatingResponse that = ((GetUserRatingResponse) object);
        {
            Rating1 lhsOverallRating;
            lhsOverallRating = this.getOverallRating();
            Rating1 rhsOverallRating;
            rhsOverallRating = that.getOverallRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "overallRating", lhsOverallRating), LocatorUtils.property(thatLocator, "overallRating", rhsOverallRating), lhsOverallRating, rhsOverallRating)) {
                return false;
            }
        }
        {
            Rating1 lhsQualityRating;
            lhsQualityRating = this.getQualityRating();
            Rating1 rhsQualityRating;
            rhsQualityRating = that.getQualityRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "qualityRating", lhsQualityRating), LocatorUtils.property(thatLocator, "qualityRating", rhsQualityRating), lhsQualityRating, rhsQualityRating)) {
                return false;
            }
        }
        {
            Rating1 lhsPriceRating;
            lhsPriceRating = this.getPriceRating();
            Rating1 rhsPriceRating;
            rhsPriceRating = that.getPriceRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "priceRating", lhsPriceRating), LocatorUtils.property(thatLocator, "priceRating", rhsPriceRating), lhsPriceRating, rhsPriceRating)) {
                return false;
            }
        }
        {
            Rating1 lhsReliabilityRating;
            lhsReliabilityRating = this.getReliabilityRating();
            Rating1 rhsReliabilityRating;
            rhsReliabilityRating = that.getReliabilityRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reliabilityRating", lhsReliabilityRating), LocatorUtils.property(thatLocator, "reliabilityRating", rhsReliabilityRating), lhsReliabilityRating, rhsReliabilityRating)) {
                return false;
            }
        }
        {
            Rating1 lhsCustomizationRating;
            lhsCustomizationRating = this.getCustomizationRating();
            Rating1 rhsCustomizationRating;
            rhsCustomizationRating = that.getCustomizationRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "customizationRating", lhsCustomizationRating), LocatorUtils.property(thatLocator, "customizationRating", rhsCustomizationRating), lhsCustomizationRating, rhsCustomizationRating)) {
                return false;
            }
        }
        {
            Rating1 lhsAverageRating;
            lhsAverageRating = this.getAverageRating();
            Rating1 rhsAverageRating;
            rhsAverageRating = that.getAverageRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "averageRating", lhsAverageRating), LocatorUtils.property(thatLocator, "averageRating", rhsAverageRating), lhsAverageRating, rhsAverageRating)) {
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
            Rating1 theOverallRating;
            theOverallRating = this.getOverallRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "overallRating", theOverallRating), currentHashCode, theOverallRating);
        }
        {
            Rating1 theQualityRating;
            theQualityRating = this.getQualityRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "qualityRating", theQualityRating), currentHashCode, theQualityRating);
        }
        {
            Rating1 thePriceRating;
            thePriceRating = this.getPriceRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "priceRating", thePriceRating), currentHashCode, thePriceRating);
        }
        {
            Rating1 theReliabilityRating;
            theReliabilityRating = this.getReliabilityRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reliabilityRating", theReliabilityRating), currentHashCode, theReliabilityRating);
        }
        {
            Rating1 theCustomizationRating;
            theCustomizationRating = this.getCustomizationRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "customizationRating", theCustomizationRating), currentHashCode, theCustomizationRating);
        }
        {
            Rating1 theAverageRating;
            theAverageRating = this.getAverageRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "averageRating", theAverageRating), currentHashCode, theAverageRating);
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
        if (draftCopy instanceof GetUserRatingResponse) {
            final GetUserRatingResponse copy = ((GetUserRatingResponse) draftCopy);
            if (this.overallRating!= null) {
                Rating1 sourceOverallRating;
                sourceOverallRating = this.getOverallRating();
                Rating1 copyOverallRating = ((Rating1) strategy.copy(LocatorUtils.property(locator, "overallRating", sourceOverallRating), sourceOverallRating));
                copy.setOverallRating(copyOverallRating);
            } else {
                copy.overallRating = null;
            }
            if (this.qualityRating!= null) {
                Rating1 sourceQualityRating;
                sourceQualityRating = this.getQualityRating();
                Rating1 copyQualityRating = ((Rating1) strategy.copy(LocatorUtils.property(locator, "qualityRating", sourceQualityRating), sourceQualityRating));
                copy.setQualityRating(copyQualityRating);
            } else {
                copy.qualityRating = null;
            }
            if (this.priceRating!= null) {
                Rating1 sourcePriceRating;
                sourcePriceRating = this.getPriceRating();
                Rating1 copyPriceRating = ((Rating1) strategy.copy(LocatorUtils.property(locator, "priceRating", sourcePriceRating), sourcePriceRating));
                copy.setPriceRating(copyPriceRating);
            } else {
                copy.priceRating = null;
            }
            if (this.reliabilityRating!= null) {
                Rating1 sourceReliabilityRating;
                sourceReliabilityRating = this.getReliabilityRating();
                Rating1 copyReliabilityRating = ((Rating1) strategy.copy(LocatorUtils.property(locator, "reliabilityRating", sourceReliabilityRating), sourceReliabilityRating));
                copy.setReliabilityRating(copyReliabilityRating);
            } else {
                copy.reliabilityRating = null;
            }
            if (this.customizationRating!= null) {
                Rating1 sourceCustomizationRating;
                sourceCustomizationRating = this.getCustomizationRating();
                Rating1 copyCustomizationRating = ((Rating1) strategy.copy(LocatorUtils.property(locator, "customizationRating", sourceCustomizationRating), sourceCustomizationRating));
                copy.setCustomizationRating(copyCustomizationRating);
            } else {
                copy.customizationRating = null;
            }
            if (this.averageRating!= null) {
                Rating1 sourceAverageRating;
                sourceAverageRating = this.getAverageRating();
                Rating1 copyAverageRating = ((Rating1) strategy.copy(LocatorUtils.property(locator, "averageRating", sourceAverageRating), sourceAverageRating));
                copy.setAverageRating(copyAverageRating);
            } else {
                copy.averageRating = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetUserRatingResponse();
    }

}