//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import java.math.BigDecimal;
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
 * <p>Java class for trBoardSearchDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trBoardSearchDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boardId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="portfolioId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="description">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="boardPrice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="15"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-10000000000000"/>
 *               &lt;maxExclusive value="10000000000000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="totalPrice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="15"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-10000000000000"/>
 *               &lt;maxExclusive value="10000000000000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="salePrice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="15"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minExclusive value="-10000000000000"/>
 *               &lt;maxExclusive value="10000000000000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="thumbnailUrl">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="mainImageUrl">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tileImageUrl">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="designerName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="1000-01-01T00:00:00"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59"/>
 *               &lt;pattern value="\p{Nd}{4}-\p{Nd}{2}-\p{Nd}{2}T\p{Nd}{2}:\p{Nd}{2}:\p{Nd}{2}"/>
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
@XmlType(name = "trBoardSearchDomain", propOrder = {
    "boardId",
    "portfolioId",
    "name",
    "description",
    "boardPrice",
    "totalPrice",
    "salePrice",
    "thumbnailUrl",
    "mainImageUrl",
    "tileImageUrl",
    "designerName",
    "date"
})
public class TrBoardSearchDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int boardId;
    protected int portfolioId;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected BigDecimal boardPrice;
    @XmlElement(required = true)
    protected BigDecimal totalPrice;
    @XmlElement(required = true)
    protected BigDecimal salePrice;
    @XmlElement(required = true)
    protected String thumbnailUrl;
    @XmlElement(required = true)
    protected String mainImageUrl;
    @XmlElement(required = true)
    protected String tileImageUrl;
    @XmlElement(required = true)
    protected String designerName;
    @XmlElement(required = true)
    protected XMLGregorianCalendar date;

    /**
     * Default no-arg constructor
     * 
     */
    public TrBoardSearchDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrBoardSearchDomain(final int boardId, final int portfolioId, final String name, final String description, final BigDecimal boardPrice, final BigDecimal totalPrice, final BigDecimal salePrice, final String thumbnailUrl, final String mainImageUrl, final String tileImageUrl, final String designerName, final XMLGregorianCalendar date) {
        this.boardId = boardId;
        this.portfolioId = portfolioId;
        this.name = name;
        this.description = description;
        this.boardPrice = boardPrice;
        this.totalPrice = totalPrice;
        this.salePrice = salePrice;
        this.thumbnailUrl = thumbnailUrl;
        this.mainImageUrl = mainImageUrl;
        this.tileImageUrl = tileImageUrl;
        this.designerName = designerName;
        this.date = date;
    }

    /**
     * Gets the value of the boardId property.
     * 
     */
    public int getBoardId() {
        return boardId;
    }

    /**
     * Sets the value of the boardId property.
     * 
     */
    public void setBoardId(int value) {
        this.boardId = value;
    }

    /**
     * Gets the value of the portfolioId property.
     * 
     */
    public int getPortfolioId() {
        return portfolioId;
    }

    /**
     * Sets the value of the portfolioId property.
     * 
     */
    public void setPortfolioId(int value) {
        this.portfolioId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the boardPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBoardPrice() {
        return boardPrice;
    }

    /**
     * Sets the value of the boardPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBoardPrice(BigDecimal value) {
        this.boardPrice = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPrice(BigDecimal value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the salePrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the value of the salePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSalePrice(BigDecimal value) {
        this.salePrice = value;
    }

    /**
     * Gets the value of the thumbnailUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Sets the value of the thumbnailUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbnailUrl(String value) {
        this.thumbnailUrl = value;
    }

    /**
     * Gets the value of the mainImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainImageUrl() {
        return mainImageUrl;
    }

    /**
     * Sets the value of the mainImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainImageUrl(String value) {
        this.mainImageUrl = value;
    }

    /**
     * Gets the value of the tileImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTileImageUrl() {
        return tileImageUrl;
    }

    /**
     * Sets the value of the tileImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTileImageUrl(String value) {
        this.tileImageUrl = value;
    }

    /**
     * Gets the value of the designerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignerName() {
        return designerName;
    }

    /**
     * Sets the value of the designerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignerName(String value) {
        this.designerName = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
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
            int theBoardId;
            theBoardId = this.getBoardId();
            strategy.appendField(locator, this, "boardId", buffer, theBoardId);
        }
        {
            int thePortfolioId;
            thePortfolioId = this.getPortfolioId();
            strategy.appendField(locator, this, "portfolioId", buffer, thePortfolioId);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            BigDecimal theBoardPrice;
            theBoardPrice = this.getBoardPrice();
            strategy.appendField(locator, this, "boardPrice", buffer, theBoardPrice);
        }
        {
            BigDecimal theTotalPrice;
            theTotalPrice = this.getTotalPrice();
            strategy.appendField(locator, this, "totalPrice", buffer, theTotalPrice);
        }
        {
            BigDecimal theSalePrice;
            theSalePrice = this.getSalePrice();
            strategy.appendField(locator, this, "salePrice", buffer, theSalePrice);
        }
        {
            String theThumbnailUrl;
            theThumbnailUrl = this.getThumbnailUrl();
            strategy.appendField(locator, this, "thumbnailUrl", buffer, theThumbnailUrl);
        }
        {
            String theMainImageUrl;
            theMainImageUrl = this.getMainImageUrl();
            strategy.appendField(locator, this, "mainImageUrl", buffer, theMainImageUrl);
        }
        {
            String theTileImageUrl;
            theTileImageUrl = this.getTileImageUrl();
            strategy.appendField(locator, this, "tileImageUrl", buffer, theTileImageUrl);
        }
        {
            String theDesignerName;
            theDesignerName = this.getDesignerName();
            strategy.appendField(locator, this, "designerName", buffer, theDesignerName);
        }
        {
            XMLGregorianCalendar theDate;
            theDate = this.getDate();
            strategy.appendField(locator, this, "date", buffer, theDate);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TrBoardSearchDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrBoardSearchDomain that = ((TrBoardSearchDomain) object);
        {
            int lhsBoardId;
            lhsBoardId = this.getBoardId();
            int rhsBoardId;
            rhsBoardId = that.getBoardId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "boardId", lhsBoardId), LocatorUtils.property(thatLocator, "boardId", rhsBoardId), lhsBoardId, rhsBoardId)) {
                return false;
            }
        }
        {
            int lhsPortfolioId;
            lhsPortfolioId = this.getPortfolioId();
            int rhsPortfolioId;
            rhsPortfolioId = that.getPortfolioId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "portfolioId", lhsPortfolioId), LocatorUtils.property(thatLocator, "portfolioId", rhsPortfolioId), lhsPortfolioId, rhsPortfolioId)) {
                return false;
            }
        }
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            BigDecimal lhsBoardPrice;
            lhsBoardPrice = this.getBoardPrice();
            BigDecimal rhsBoardPrice;
            rhsBoardPrice = that.getBoardPrice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "boardPrice", lhsBoardPrice), LocatorUtils.property(thatLocator, "boardPrice", rhsBoardPrice), lhsBoardPrice, rhsBoardPrice)) {
                return false;
            }
        }
        {
            BigDecimal lhsTotalPrice;
            lhsTotalPrice = this.getTotalPrice();
            BigDecimal rhsTotalPrice;
            rhsTotalPrice = that.getTotalPrice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalPrice", lhsTotalPrice), LocatorUtils.property(thatLocator, "totalPrice", rhsTotalPrice), lhsTotalPrice, rhsTotalPrice)) {
                return false;
            }
        }
        {
            BigDecimal lhsSalePrice;
            lhsSalePrice = this.getSalePrice();
            BigDecimal rhsSalePrice;
            rhsSalePrice = that.getSalePrice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "salePrice", lhsSalePrice), LocatorUtils.property(thatLocator, "salePrice", rhsSalePrice), lhsSalePrice, rhsSalePrice)) {
                return false;
            }
        }
        {
            String lhsThumbnailUrl;
            lhsThumbnailUrl = this.getThumbnailUrl();
            String rhsThumbnailUrl;
            rhsThumbnailUrl = that.getThumbnailUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "thumbnailUrl", lhsThumbnailUrl), LocatorUtils.property(thatLocator, "thumbnailUrl", rhsThumbnailUrl), lhsThumbnailUrl, rhsThumbnailUrl)) {
                return false;
            }
        }
        {
            String lhsMainImageUrl;
            lhsMainImageUrl = this.getMainImageUrl();
            String rhsMainImageUrl;
            rhsMainImageUrl = that.getMainImageUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mainImageUrl", lhsMainImageUrl), LocatorUtils.property(thatLocator, "mainImageUrl", rhsMainImageUrl), lhsMainImageUrl, rhsMainImageUrl)) {
                return false;
            }
        }
        {
            String lhsTileImageUrl;
            lhsTileImageUrl = this.getTileImageUrl();
            String rhsTileImageUrl;
            rhsTileImageUrl = that.getTileImageUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tileImageUrl", lhsTileImageUrl), LocatorUtils.property(thatLocator, "tileImageUrl", rhsTileImageUrl), lhsTileImageUrl, rhsTileImageUrl)) {
                return false;
            }
        }
        {
            String lhsDesignerName;
            lhsDesignerName = this.getDesignerName();
            String rhsDesignerName;
            rhsDesignerName = that.getDesignerName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "designerName", lhsDesignerName), LocatorUtils.property(thatLocator, "designerName", rhsDesignerName), lhsDesignerName, rhsDesignerName)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDate;
            lhsDate = this.getDate();
            XMLGregorianCalendar rhsDate;
            rhsDate = that.getDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "date", lhsDate), LocatorUtils.property(thatLocator, "date", rhsDate), lhsDate, rhsDate)) {
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
            int theBoardId;
            theBoardId = this.getBoardId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boardId", theBoardId), currentHashCode, theBoardId);
        }
        {
            int thePortfolioId;
            thePortfolioId = this.getPortfolioId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "portfolioId", thePortfolioId), currentHashCode, thePortfolioId);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            BigDecimal theBoardPrice;
            theBoardPrice = this.getBoardPrice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boardPrice", theBoardPrice), currentHashCode, theBoardPrice);
        }
        {
            BigDecimal theTotalPrice;
            theTotalPrice = this.getTotalPrice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalPrice", theTotalPrice), currentHashCode, theTotalPrice);
        }
        {
            BigDecimal theSalePrice;
            theSalePrice = this.getSalePrice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "salePrice", theSalePrice), currentHashCode, theSalePrice);
        }
        {
            String theThumbnailUrl;
            theThumbnailUrl = this.getThumbnailUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "thumbnailUrl", theThumbnailUrl), currentHashCode, theThumbnailUrl);
        }
        {
            String theMainImageUrl;
            theMainImageUrl = this.getMainImageUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mainImageUrl", theMainImageUrl), currentHashCode, theMainImageUrl);
        }
        {
            String theTileImageUrl;
            theTileImageUrl = this.getTileImageUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tileImageUrl", theTileImageUrl), currentHashCode, theTileImageUrl);
        }
        {
            String theDesignerName;
            theDesignerName = this.getDesignerName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "designerName", theDesignerName), currentHashCode, theDesignerName);
        }
        {
            XMLGregorianCalendar theDate;
            theDate = this.getDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date", theDate), currentHashCode, theDate);
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
        if (draftCopy instanceof TrBoardSearchDomain) {
            final TrBoardSearchDomain copy = ((TrBoardSearchDomain) draftCopy);
            int sourceBoardId;
            sourceBoardId = this.getBoardId();
            int copyBoardId = strategy.copy(LocatorUtils.property(locator, "boardId", sourceBoardId), sourceBoardId);
            copy.setBoardId(copyBoardId);
            int sourcePortfolioId;
            sourcePortfolioId = this.getPortfolioId();
            int copyPortfolioId = strategy.copy(LocatorUtils.property(locator, "portfolioId", sourcePortfolioId), sourcePortfolioId);
            copy.setPortfolioId(copyPortfolioId);
            if (this.name!= null) {
                String sourceName;
                sourceName = this.getName();
                String copyName = ((String) strategy.copy(LocatorUtils.property(locator, "name", sourceName), sourceName));
                copy.setName(copyName);
            } else {
                copy.name = null;
            }
            if (this.description!= null) {
                String sourceDescription;
                sourceDescription = this.getDescription();
                String copyDescription = ((String) strategy.copy(LocatorUtils.property(locator, "description", sourceDescription), sourceDescription));
                copy.setDescription(copyDescription);
            } else {
                copy.description = null;
            }
            if (this.boardPrice!= null) {
                BigDecimal sourceBoardPrice;
                sourceBoardPrice = this.getBoardPrice();
                BigDecimal copyBoardPrice = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "boardPrice", sourceBoardPrice), sourceBoardPrice));
                copy.setBoardPrice(copyBoardPrice);
            } else {
                copy.boardPrice = null;
            }
            if (this.totalPrice!= null) {
                BigDecimal sourceTotalPrice;
                sourceTotalPrice = this.getTotalPrice();
                BigDecimal copyTotalPrice = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "totalPrice", sourceTotalPrice), sourceTotalPrice));
                copy.setTotalPrice(copyTotalPrice);
            } else {
                copy.totalPrice = null;
            }
            if (this.salePrice!= null) {
                BigDecimal sourceSalePrice;
                sourceSalePrice = this.getSalePrice();
                BigDecimal copySalePrice = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "salePrice", sourceSalePrice), sourceSalePrice));
                copy.setSalePrice(copySalePrice);
            } else {
                copy.salePrice = null;
            }
            if (this.thumbnailUrl!= null) {
                String sourceThumbnailUrl;
                sourceThumbnailUrl = this.getThumbnailUrl();
                String copyThumbnailUrl = ((String) strategy.copy(LocatorUtils.property(locator, "thumbnailUrl", sourceThumbnailUrl), sourceThumbnailUrl));
                copy.setThumbnailUrl(copyThumbnailUrl);
            } else {
                copy.thumbnailUrl = null;
            }
            if (this.mainImageUrl!= null) {
                String sourceMainImageUrl;
                sourceMainImageUrl = this.getMainImageUrl();
                String copyMainImageUrl = ((String) strategy.copy(LocatorUtils.property(locator, "mainImageUrl", sourceMainImageUrl), sourceMainImageUrl));
                copy.setMainImageUrl(copyMainImageUrl);
            } else {
                copy.mainImageUrl = null;
            }
            if (this.tileImageUrl!= null) {
                String sourceTileImageUrl;
                sourceTileImageUrl = this.getTileImageUrl();
                String copyTileImageUrl = ((String) strategy.copy(LocatorUtils.property(locator, "tileImageUrl", sourceTileImageUrl), sourceTileImageUrl));
                copy.setTileImageUrl(copyTileImageUrl);
            } else {
                copy.tileImageUrl = null;
            }
            if (this.designerName!= null) {
                String sourceDesignerName;
                sourceDesignerName = this.getDesignerName();
                String copyDesignerName = ((String) strategy.copy(LocatorUtils.property(locator, "designerName", sourceDesignerName), sourceDesignerName));
                copy.setDesignerName(copyDesignerName);
            } else {
                copy.designerName = null;
            }
            if (this.date!= null) {
                XMLGregorianCalendar sourceDate;
                sourceDate = this.getDate();
                XMLGregorianCalendar copyDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "date", sourceDate), sourceDate));
                copy.setDate(copyDate);
            } else {
                copy.date = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TrBoardSearchDomain();
    }

}