//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for AbstractCTRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractCTRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://common.businessobjects.f9g4.com}Header"/>
 *         &lt;element name="sortCriteria" type="{http://common.businessobjects.f9g4.com}SortCriteria" minOccurs="0"/>
 *         &lt;element name="filterCriteria" type="{http://common.businessobjects.f9g4.com}FilterCriteria" minOccurs="0"/>
 *         &lt;element name="pageRequest" type="{http://common.businessobjects.f9g4.com}PaginationRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCTRequest", propOrder = {
    "header",
    "sortCriteria",
    "filterCriteria",
    "pageRequest"
})
public class AbstractCTRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Header header;
    protected SortCriteria sortCriteria;
    protected FilterCriteria filterCriteria;
    protected PaginationRequest pageRequest;

    /**
     * Default no-arg constructor
     * 
     */
    public AbstractCTRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public AbstractCTRequest(final Header header, final SortCriteria sortCriteria, final FilterCriteria filterCriteria, final PaginationRequest pageRequest) {
        this.header = header;
        this.sortCriteria = sortCriteria;
        this.filterCriteria = filterCriteria;
        this.pageRequest = pageRequest;
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the sortCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link SortCriteria }
     *     
     */
    public SortCriteria getSortCriteria() {
        return sortCriteria;
    }

    /**
     * Sets the value of the sortCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortCriteria }
     *     
     */
    public void setSortCriteria(SortCriteria value) {
        this.sortCriteria = value;
    }

    /**
     * Gets the value of the filterCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link FilterCriteria }
     *     
     */
    public FilterCriteria getFilterCriteria() {
        return filterCriteria;
    }

    /**
     * Sets the value of the filterCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterCriteria }
     *     
     */
    public void setFilterCriteria(FilterCriteria value) {
        this.filterCriteria = value;
    }

    /**
     * Gets the value of the pageRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationRequest }
     *     
     */
    public PaginationRequest getPageRequest() {
        return pageRequest;
    }

    /**
     * Sets the value of the pageRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationRequest }
     *     
     */
    public void setPageRequest(PaginationRequest value) {
        this.pageRequest = value;
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
            Header theHeader;
            theHeader = this.getHeader();
            strategy.appendField(locator, this, "header", buffer, theHeader);
        }
        {
            SortCriteria theSortCriteria;
            theSortCriteria = this.getSortCriteria();
            strategy.appendField(locator, this, "sortCriteria", buffer, theSortCriteria);
        }
        {
            FilterCriteria theFilterCriteria;
            theFilterCriteria = this.getFilterCriteria();
            strategy.appendField(locator, this, "filterCriteria", buffer, theFilterCriteria);
        }
        {
            PaginationRequest thePageRequest;
            thePageRequest = this.getPageRequest();
            strategy.appendField(locator, this, "pageRequest", buffer, thePageRequest);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractCTRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AbstractCTRequest that = ((AbstractCTRequest) object);
        {
            Header lhsHeader;
            lhsHeader = this.getHeader();
            Header rhsHeader;
            rhsHeader = that.getHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "header", lhsHeader), LocatorUtils.property(thatLocator, "header", rhsHeader), lhsHeader, rhsHeader)) {
                return false;
            }
        }
        {
            SortCriteria lhsSortCriteria;
            lhsSortCriteria = this.getSortCriteria();
            SortCriteria rhsSortCriteria;
            rhsSortCriteria = that.getSortCriteria();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sortCriteria", lhsSortCriteria), LocatorUtils.property(thatLocator, "sortCriteria", rhsSortCriteria), lhsSortCriteria, rhsSortCriteria)) {
                return false;
            }
        }
        {
            FilterCriteria lhsFilterCriteria;
            lhsFilterCriteria = this.getFilterCriteria();
            FilterCriteria rhsFilterCriteria;
            rhsFilterCriteria = that.getFilterCriteria();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "filterCriteria", lhsFilterCriteria), LocatorUtils.property(thatLocator, "filterCriteria", rhsFilterCriteria), lhsFilterCriteria, rhsFilterCriteria)) {
                return false;
            }
        }
        {
            PaginationRequest lhsPageRequest;
            lhsPageRequest = this.getPageRequest();
            PaginationRequest rhsPageRequest;
            rhsPageRequest = that.getPageRequest();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pageRequest", lhsPageRequest), LocatorUtils.property(thatLocator, "pageRequest", rhsPageRequest), lhsPageRequest, rhsPageRequest)) {
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
            Header theHeader;
            theHeader = this.getHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "header", theHeader), currentHashCode, theHeader);
        }
        {
            SortCriteria theSortCriteria;
            theSortCriteria = this.getSortCriteria();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sortCriteria", theSortCriteria), currentHashCode, theSortCriteria);
        }
        {
            FilterCriteria theFilterCriteria;
            theFilterCriteria = this.getFilterCriteria();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "filterCriteria", theFilterCriteria), currentHashCode, theFilterCriteria);
        }
        {
            PaginationRequest thePageRequest;
            thePageRequest = this.getPageRequest();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageRequest", thePageRequest), currentHashCode, thePageRequest);
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
        if (draftCopy instanceof AbstractCTRequest) {
            final AbstractCTRequest copy = ((AbstractCTRequest) draftCopy);
            if (this.header!= null) {
                Header sourceHeader;
                sourceHeader = this.getHeader();
                Header copyHeader = ((Header) strategy.copy(LocatorUtils.property(locator, "header", sourceHeader), sourceHeader));
                copy.setHeader(copyHeader);
            } else {
                copy.header = null;
            }
            if (this.sortCriteria!= null) {
                SortCriteria sourceSortCriteria;
                sourceSortCriteria = this.getSortCriteria();
                SortCriteria copySortCriteria = ((SortCriteria) strategy.copy(LocatorUtils.property(locator, "sortCriteria", sourceSortCriteria), sourceSortCriteria));
                copy.setSortCriteria(copySortCriteria);
            } else {
                copy.sortCriteria = null;
            }
            if (this.filterCriteria!= null) {
                FilterCriteria sourceFilterCriteria;
                sourceFilterCriteria = this.getFilterCriteria();
                FilterCriteria copyFilterCriteria = ((FilterCriteria) strategy.copy(LocatorUtils.property(locator, "filterCriteria", sourceFilterCriteria), sourceFilterCriteria));
                copy.setFilterCriteria(copyFilterCriteria);
            } else {
                copy.filterCriteria = null;
            }
            if (this.pageRequest!= null) {
                PaginationRequest sourcePageRequest;
                sourcePageRequest = this.getPageRequest();
                PaginationRequest copyPageRequest = ((PaginationRequest) strategy.copy(LocatorUtils.property(locator, "pageRequest", sourcePageRequest), sourcePageRequest));
                copy.setPageRequest(copyPageRequest);
            } else {
                copy.pageRequest = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AbstractCTRequest();
    }

}