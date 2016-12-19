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
 * <p>Java class for trRecentlyViewedDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trRecentlyViewedDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clickId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="boardId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="userId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="eventTime">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *               &lt;minInclusive value="0001-01-01T00:00:00.000000000"/>
 *               &lt;maxInclusive value="9999-12-31T23:59:59.000000000"/>
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
@XmlType(name = "trRecentlyViewedDomain", propOrder = {
    "clickId",
    "boardId",
    "userId",
    "eventTime",
    "createdby",
    "lastupdateby"
})
public class TrRecentlyViewedDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int clickId;
    protected int boardId;
    protected int userId;
    @XmlElement(required = true)
    protected XMLGregorianCalendar eventTime;
    protected int createdby;
    protected int lastupdateby;

    /**
     * Default no-arg constructor
     * 
     */
    public TrRecentlyViewedDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrRecentlyViewedDomain(final int clickId, final int boardId, final int userId, final XMLGregorianCalendar eventTime, final int createdby, final int lastupdateby) {
        this.clickId = clickId;
        this.boardId = boardId;
        this.userId = userId;
        this.eventTime = eventTime;
        this.createdby = createdby;
        this.lastupdateby = lastupdateby;
    }

    /**
     * Gets the value of the clickId property.
     * 
     */
    public int getClickId() {
        return clickId;
    }

    /**
     * Sets the value of the clickId property.
     * 
     */
    public void setClickId(int value) {
        this.clickId = value;
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
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the eventTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEventTime() {
        return eventTime;
    }

    /**
     * Sets the value of the eventTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEventTime(XMLGregorianCalendar value) {
        this.eventTime = value;
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
            int theClickId;
            theClickId = this.getClickId();
            strategy.appendField(locator, this, "clickId", buffer, theClickId);
        }
        {
            int theBoardId;
            theBoardId = this.getBoardId();
            strategy.appendField(locator, this, "boardId", buffer, theBoardId);
        }
        {
            int theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId);
        }
        {
            XMLGregorianCalendar theEventTime;
            theEventTime = this.getEventTime();
            strategy.appendField(locator, this, "eventTime", buffer, theEventTime);
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
        if (!(object instanceof TrRecentlyViewedDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrRecentlyViewedDomain that = ((TrRecentlyViewedDomain) object);
        {
            int lhsClickId;
            lhsClickId = this.getClickId();
            int rhsClickId;
            rhsClickId = that.getClickId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clickId", lhsClickId), LocatorUtils.property(thatLocator, "clickId", rhsClickId), lhsClickId, rhsClickId)) {
                return false;
            }
        }
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
            int lhsUserId;
            lhsUserId = this.getUserId();
            int rhsUserId;
            rhsUserId = that.getUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userId", lhsUserId), LocatorUtils.property(thatLocator, "userId", rhsUserId), lhsUserId, rhsUserId)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsEventTime;
            lhsEventTime = this.getEventTime();
            XMLGregorianCalendar rhsEventTime;
            rhsEventTime = that.getEventTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "eventTime", lhsEventTime), LocatorUtils.property(thatLocator, "eventTime", rhsEventTime), lhsEventTime, rhsEventTime)) {
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
            int theClickId;
            theClickId = this.getClickId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clickId", theClickId), currentHashCode, theClickId);
        }
        {
            int theBoardId;
            theBoardId = this.getBoardId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boardId", theBoardId), currentHashCode, theBoardId);
        }
        {
            int theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId);
        }
        {
            XMLGregorianCalendar theEventTime;
            theEventTime = this.getEventTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eventTime", theEventTime), currentHashCode, theEventTime);
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
        if (draftCopy instanceof TrRecentlyViewedDomain) {
            final TrRecentlyViewedDomain copy = ((TrRecentlyViewedDomain) draftCopy);
            int sourceClickId;
            sourceClickId = this.getClickId();
            int copyClickId = strategy.copy(LocatorUtils.property(locator, "clickId", sourceClickId), sourceClickId);
            copy.setClickId(copyClickId);
            int sourceBoardId;
            sourceBoardId = this.getBoardId();
            int copyBoardId = strategy.copy(LocatorUtils.property(locator, "boardId", sourceBoardId), sourceBoardId);
            copy.setBoardId(copyBoardId);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            if (this.eventTime!= null) {
                XMLGregorianCalendar sourceEventTime;
                sourceEventTime = this.getEventTime();
                XMLGregorianCalendar copyEventTime = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "eventTime", sourceEventTime), sourceEventTime));
                copy.setEventTime(copyEventTime);
            } else {
                copy.eventTime = null;
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
        return new TrRecentlyViewedDomain();
    }

}