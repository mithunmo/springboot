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
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
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
 * <p>Java class for UpdatePortfolioRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePortfolioRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="portfolio" type="{http://domain.businessobjects.f9g4.com}trPortfolioDomain"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdatePortfolioRequest", propOrder = {
    "portfolio"
})
@XmlRootElement(name = "UpdatePortfolioRequest")
public class UpdatePortfolioRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected TrPortfolioDomain portfolio;

    /**
     * Default no-arg constructor
     * 
     */
    public UpdatePortfolioRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public UpdatePortfolioRequest(final TrPortfolioDomain portfolio) {
        this.portfolio = portfolio;
    }

    /**
     * Gets the value of the portfolio property.
     * 
     * @return
     *     possible object is
     *     {@link TrPortfolioDomain }
     *     
     */
    public TrPortfolioDomain getPortfolio() {
        return portfolio;
    }

    /**
     * Sets the value of the portfolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrPortfolioDomain }
     *     
     */
    public void setPortfolio(TrPortfolioDomain value) {
        this.portfolio = value;
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
            TrPortfolioDomain thePortfolio;
            thePortfolio = this.getPortfolio();
            strategy.appendField(locator, this, "portfolio", buffer, thePortfolio);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UpdatePortfolioRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UpdatePortfolioRequest that = ((UpdatePortfolioRequest) object);
        {
            TrPortfolioDomain lhsPortfolio;
            lhsPortfolio = this.getPortfolio();
            TrPortfolioDomain rhsPortfolio;
            rhsPortfolio = that.getPortfolio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "portfolio", lhsPortfolio), LocatorUtils.property(thatLocator, "portfolio", rhsPortfolio), lhsPortfolio, rhsPortfolio)) {
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
            TrPortfolioDomain thePortfolio;
            thePortfolio = this.getPortfolio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "portfolio", thePortfolio), currentHashCode, thePortfolio);
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
        if (draftCopy instanceof UpdatePortfolioRequest) {
            final UpdatePortfolioRequest copy = ((UpdatePortfolioRequest) draftCopy);
            if (this.portfolio!= null) {
                TrPortfolioDomain sourcePortfolio;
                sourcePortfolio = this.getPortfolio();
                TrPortfolioDomain copyPortfolio = ((TrPortfolioDomain) strategy.copy(LocatorUtils.property(locator, "portfolio", sourcePortfolio), sourcePortfolio));
                copy.setPortfolio(copyPortfolio);
            } else {
                copy.portfolio = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new UpdatePortfolioRequest();
    }

}
