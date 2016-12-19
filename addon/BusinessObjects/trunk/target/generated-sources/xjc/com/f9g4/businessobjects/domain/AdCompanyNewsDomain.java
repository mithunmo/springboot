//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 * <p>Java class for adCompanyNewsDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adCompanyNewsDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyNewsId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="contentType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="45"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="contentLocation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="contentAlias">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="startDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="endDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="companyNewsDetails" type="{http://domain.businessobjects.f9g4.com}adCompanyNewsDetailDomain" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "adCompanyNewsDomain", propOrder = {
    "companyNewsId",
    "contentType",
    "contentLocation",
    "contentAlias",
    "startDate",
    "endDate",
    "companyNewsDetails",
    "createdby",
    "lastupdateby"
})
public class AdCompanyNewsDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int companyNewsId;
    @XmlElement(required = true)
    protected String contentType;
    @XmlElement(required = true)
    protected String contentLocation;
    @XmlElement(required = true)
    protected String contentAlias;
    @XmlElement(required = true)
    protected XMLGregorianCalendar startDate;
    @XmlElementRef(name = "endDate", namespace = "http://domain.businessobjects.f9g4.com", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDate;
    protected List<AdCompanyNewsDetailDomain> companyNewsDetails;
    protected int createdby;
    protected int lastupdateby;

    /**
     * Default no-arg constructor
     * 
     */
    public AdCompanyNewsDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public AdCompanyNewsDomain(final int companyNewsId, final String contentType, final String contentLocation, final String contentAlias, final XMLGregorianCalendar startDate, final JAXBElement<XMLGregorianCalendar> endDate, final List<AdCompanyNewsDetailDomain> companyNewsDetails, final int createdby, final int lastupdateby) {
        this.companyNewsId = companyNewsId;
        this.contentType = contentType;
        this.contentLocation = contentLocation;
        this.contentAlias = contentAlias;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyNewsDetails = companyNewsDetails;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
    }

    /**
     * Gets the value of the companyNewsId property.
     * 
     */
    public int getCompanyNewsId() {
        return companyNewsId;
    }

    /**
     * Sets the value of the companyNewsId property.
     * 
     */
    public void setCompanyNewsId(int value) {
        this.companyNewsId = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the contentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentLocation() {
        return contentLocation;
    }

    /**
     * Sets the value of the contentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentLocation(String value) {
        this.contentLocation = value;
    }

    /**
     * Gets the value of the contentAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentAlias() {
        return contentAlias;
    }

    /**
     * Sets the value of the contentAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentAlias(String value) {
        this.contentAlias = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.endDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the companyNewsDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the companyNewsDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompanyNewsDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdCompanyNewsDetailDomain }
     * 
     * 
     */
    public List<AdCompanyNewsDetailDomain> getCompanyNewsDetails() {
        if (companyNewsDetails == null) {
            companyNewsDetails = new ArrayList<AdCompanyNewsDetailDomain>();
        }
        return this.companyNewsDetails;
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
            int theCompanyNewsId;
            theCompanyNewsId = this.getCompanyNewsId();
            strategy.appendField(locator, this, "companyNewsId", buffer, theCompanyNewsId);
        }
        {
            String theContentType;
            theContentType = this.getContentType();
            strategy.appendField(locator, this, "contentType", buffer, theContentType);
        }
        {
            String theContentLocation;
            theContentLocation = this.getContentLocation();
            strategy.appendField(locator, this, "contentLocation", buffer, theContentLocation);
        }
        {
            String theContentAlias;
            theContentAlias = this.getContentAlias();
            strategy.appendField(locator, this, "contentAlias", buffer, theContentAlias);
        }
        {
            XMLGregorianCalendar theStartDate;
            theStartDate = this.getStartDate();
            strategy.appendField(locator, this, "startDate", buffer, theStartDate);
        }
        {
            JAXBElement<XMLGregorianCalendar> theEndDate;
            theEndDate = this.getEndDate();
            strategy.appendField(locator, this, "endDate", buffer, theEndDate);
        }
        {
            List<AdCompanyNewsDetailDomain> theCompanyNewsDetails;
            theCompanyNewsDetails = this.getCompanyNewsDetails();
            strategy.appendField(locator, this, "companyNewsDetails", buffer, theCompanyNewsDetails);
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
        if (!(object instanceof AdCompanyNewsDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AdCompanyNewsDomain that = ((AdCompanyNewsDomain) object);
        {
            int lhsCompanyNewsId;
            lhsCompanyNewsId = this.getCompanyNewsId();
            int rhsCompanyNewsId;
            rhsCompanyNewsId = that.getCompanyNewsId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "companyNewsId", lhsCompanyNewsId), LocatorUtils.property(thatLocator, "companyNewsId", rhsCompanyNewsId), lhsCompanyNewsId, rhsCompanyNewsId)) {
                return false;
            }
        }
        {
            String lhsContentType;
            lhsContentType = this.getContentType();
            String rhsContentType;
            rhsContentType = that.getContentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentType", lhsContentType), LocatorUtils.property(thatLocator, "contentType", rhsContentType), lhsContentType, rhsContentType)) {
                return false;
            }
        }
        {
            String lhsContentLocation;
            lhsContentLocation = this.getContentLocation();
            String rhsContentLocation;
            rhsContentLocation = that.getContentLocation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentLocation", lhsContentLocation), LocatorUtils.property(thatLocator, "contentLocation", rhsContentLocation), lhsContentLocation, rhsContentLocation)) {
                return false;
            }
        }
        {
            String lhsContentAlias;
            lhsContentAlias = this.getContentAlias();
            String rhsContentAlias;
            rhsContentAlias = that.getContentAlias();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentAlias", lhsContentAlias), LocatorUtils.property(thatLocator, "contentAlias", rhsContentAlias), lhsContentAlias, rhsContentAlias)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsStartDate;
            lhsStartDate = this.getStartDate();
            XMLGregorianCalendar rhsStartDate;
            rhsStartDate = that.getStartDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "startDate", lhsStartDate), LocatorUtils.property(thatLocator, "startDate", rhsStartDate), lhsStartDate, rhsStartDate)) {
                return false;
            }
        }
        {
            JAXBElement<XMLGregorianCalendar> lhsEndDate;
            lhsEndDate = this.getEndDate();
            JAXBElement<XMLGregorianCalendar> rhsEndDate;
            rhsEndDate = that.getEndDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "endDate", lhsEndDate), LocatorUtils.property(thatLocator, "endDate", rhsEndDate), lhsEndDate, rhsEndDate)) {
                return false;
            }
        }
        {
            List<AdCompanyNewsDetailDomain> lhsCompanyNewsDetails;
            lhsCompanyNewsDetails = this.getCompanyNewsDetails();
            List<AdCompanyNewsDetailDomain> rhsCompanyNewsDetails;
            rhsCompanyNewsDetails = that.getCompanyNewsDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "companyNewsDetails", lhsCompanyNewsDetails), LocatorUtils.property(thatLocator, "companyNewsDetails", rhsCompanyNewsDetails), lhsCompanyNewsDetails, rhsCompanyNewsDetails)) {
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
            int theCompanyNewsId;
            theCompanyNewsId = this.getCompanyNewsId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "companyNewsId", theCompanyNewsId), currentHashCode, theCompanyNewsId);
        }
        {
            String theContentType;
            theContentType = this.getContentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentType", theContentType), currentHashCode, theContentType);
        }
        {
            String theContentLocation;
            theContentLocation = this.getContentLocation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentLocation", theContentLocation), currentHashCode, theContentLocation);
        }
        {
            String theContentAlias;
            theContentAlias = this.getContentAlias();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentAlias", theContentAlias), currentHashCode, theContentAlias);
        }
        {
            XMLGregorianCalendar theStartDate;
            theStartDate = this.getStartDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "startDate", theStartDate), currentHashCode, theStartDate);
        }
        {
            JAXBElement<XMLGregorianCalendar> theEndDate;
            theEndDate = this.getEndDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "endDate", theEndDate), currentHashCode, theEndDate);
        }
        {
            List<AdCompanyNewsDetailDomain> theCompanyNewsDetails;
            theCompanyNewsDetails = this.getCompanyNewsDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "companyNewsDetails", theCompanyNewsDetails), currentHashCode, theCompanyNewsDetails);
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
        if (draftCopy instanceof AdCompanyNewsDomain) {
            final AdCompanyNewsDomain copy = ((AdCompanyNewsDomain) draftCopy);
            int sourceCompanyNewsId;
            sourceCompanyNewsId = this.getCompanyNewsId();
            int copyCompanyNewsId = strategy.copy(LocatorUtils.property(locator, "companyNewsId", sourceCompanyNewsId), sourceCompanyNewsId);
            copy.setCompanyNewsId(copyCompanyNewsId);
            if (this.contentType!= null) {
                String sourceContentType;
                sourceContentType = this.getContentType();
                String copyContentType = ((String) strategy.copy(LocatorUtils.property(locator, "contentType", sourceContentType), sourceContentType));
                copy.setContentType(copyContentType);
            } else {
                copy.contentType = null;
            }
            if (this.contentLocation!= null) {
                String sourceContentLocation;
                sourceContentLocation = this.getContentLocation();
                String copyContentLocation = ((String) strategy.copy(LocatorUtils.property(locator, "contentLocation", sourceContentLocation), sourceContentLocation));
                copy.setContentLocation(copyContentLocation);
            } else {
                copy.contentLocation = null;
            }
            if (this.contentAlias!= null) {
                String sourceContentAlias;
                sourceContentAlias = this.getContentAlias();
                String copyContentAlias = ((String) strategy.copy(LocatorUtils.property(locator, "contentAlias", sourceContentAlias), sourceContentAlias));
                copy.setContentAlias(copyContentAlias);
            } else {
                copy.contentAlias = null;
            }
            if (this.startDate!= null) {
                XMLGregorianCalendar sourceStartDate;
                sourceStartDate = this.getStartDate();
                XMLGregorianCalendar copyStartDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "startDate", sourceStartDate), sourceStartDate));
                copy.setStartDate(copyStartDate);
            } else {
                copy.startDate = null;
            }
            if (this.endDate!= null) {
                JAXBElement<XMLGregorianCalendar> sourceEndDate;
                sourceEndDate = this.getEndDate();
                @SuppressWarnings("unchecked")
                JAXBElement<XMLGregorianCalendar> copyEndDate = ((JAXBElement<XMLGregorianCalendar> ) strategy.copy(LocatorUtils.property(locator, "endDate", sourceEndDate), sourceEndDate));
                copy.setEndDate(copyEndDate);
            } else {
                copy.endDate = null;
            }
            if ((this.companyNewsDetails!= null)&&(!this.companyNewsDetails.isEmpty())) {
                List<AdCompanyNewsDetailDomain> sourceCompanyNewsDetails;
                sourceCompanyNewsDetails = this.getCompanyNewsDetails();
                @SuppressWarnings("unchecked")
                List<AdCompanyNewsDetailDomain> copyCompanyNewsDetails = ((List<AdCompanyNewsDetailDomain> ) strategy.copy(LocatorUtils.property(locator, "companyNewsDetails", sourceCompanyNewsDetails), sourceCompanyNewsDetails));
                copy.companyNewsDetails = null;
                List<AdCompanyNewsDetailDomain> uniqueCompanyNewsDetailsl = copy.getCompanyNewsDetails();
                uniqueCompanyNewsDetailsl.addAll(copyCompanyNewsDetails);
            } else {
                copy.companyNewsDetails = null;
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
        return new AdCompanyNewsDomain();
    }

}