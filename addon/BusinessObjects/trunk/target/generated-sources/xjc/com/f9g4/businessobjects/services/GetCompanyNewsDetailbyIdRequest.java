//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for GetCompanyNewsDetailbyIdRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCompanyNewsDetailbyIdRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companynewsid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCompanyNewsDetailbyIdRequest", propOrder = {
    "companynewsid"
})
@XmlRootElement(name = "GetCompanyNewsDetailbyIdRequest")
public class GetCompanyNewsDetailbyIdRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int companynewsid;

    /**
     * Default no-arg constructor
     * 
     */
    public GetCompanyNewsDetailbyIdRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetCompanyNewsDetailbyIdRequest(final int companynewsid) {
        this.companynewsid = companynewsid;
    }

    /**
     * Gets the value of the companynewsid property.
     * 
     */
    public int getCompanynewsid() {
        return companynewsid;
    }

    /**
     * Sets the value of the companynewsid property.
     * 
     */
    public void setCompanynewsid(int value) {
        this.companynewsid = value;
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
            int theCompanynewsid;
            theCompanynewsid = this.getCompanynewsid();
            strategy.appendField(locator, this, "companynewsid", buffer, theCompanynewsid);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetCompanyNewsDetailbyIdRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetCompanyNewsDetailbyIdRequest that = ((GetCompanyNewsDetailbyIdRequest) object);
        {
            int lhsCompanynewsid;
            lhsCompanynewsid = this.getCompanynewsid();
            int rhsCompanynewsid;
            rhsCompanynewsid = that.getCompanynewsid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "companynewsid", lhsCompanynewsid), LocatorUtils.property(thatLocator, "companynewsid", rhsCompanynewsid), lhsCompanynewsid, rhsCompanynewsid)) {
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
            int theCompanynewsid;
            theCompanynewsid = this.getCompanynewsid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "companynewsid", theCompanynewsid), currentHashCode, theCompanynewsid);
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
        if (draftCopy instanceof GetCompanyNewsDetailbyIdRequest) {
            final GetCompanyNewsDetailbyIdRequest copy = ((GetCompanyNewsDetailbyIdRequest) draftCopy);
            int sourceCompanynewsid;
            sourceCompanynewsid = this.getCompanynewsid();
            int copyCompanynewsid = strategy.copy(LocatorUtils.property(locator, "companynewsid", sourceCompanynewsid), sourceCompanynewsid);
            copy.setCompanynewsid(copyCompanynewsid);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetCompanyNewsDetailbyIdRequest();
    }

}