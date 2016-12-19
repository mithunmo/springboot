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
import javax.xml.bind.annotation.XmlSchemaType;
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
 * <p>Java class for BoardsViewed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BoardsViewed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateViewed" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="numberOfBoards" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoardsViewed", propOrder = {
    "dateViewed",
    "numberOfBoards"
})
public class BoardsViewed implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateViewed;
    protected int numberOfBoards;

    /**
     * Default no-arg constructor
     * 
     */
    public BoardsViewed() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public BoardsViewed(final XMLGregorianCalendar dateViewed, final int numberOfBoards) {
        this.dateViewed = dateViewed;
        this.numberOfBoards = numberOfBoards;
    }

    /**
     * Gets the value of the dateViewed property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateViewed() {
        return dateViewed;
    }

    /**
     * Sets the value of the dateViewed property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateViewed(XMLGregorianCalendar value) {
        this.dateViewed = value;
    }

    /**
     * Gets the value of the numberOfBoards property.
     * 
     */
    public int getNumberOfBoards() {
        return numberOfBoards;
    }

    /**
     * Sets the value of the numberOfBoards property.
     * 
     */
    public void setNumberOfBoards(int value) {
        this.numberOfBoards = value;
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
            XMLGregorianCalendar theDateViewed;
            theDateViewed = this.getDateViewed();
            strategy.appendField(locator, this, "dateViewed", buffer, theDateViewed);
        }
        {
            int theNumberOfBoards;
            theNumberOfBoards = this.getNumberOfBoards();
            strategy.appendField(locator, this, "numberOfBoards", buffer, theNumberOfBoards);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BoardsViewed)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BoardsViewed that = ((BoardsViewed) object);
        {
            XMLGregorianCalendar lhsDateViewed;
            lhsDateViewed = this.getDateViewed();
            XMLGregorianCalendar rhsDateViewed;
            rhsDateViewed = that.getDateViewed();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateViewed", lhsDateViewed), LocatorUtils.property(thatLocator, "dateViewed", rhsDateViewed), lhsDateViewed, rhsDateViewed)) {
                return false;
            }
        }
        {
            int lhsNumberOfBoards;
            lhsNumberOfBoards = this.getNumberOfBoards();
            int rhsNumberOfBoards;
            rhsNumberOfBoards = that.getNumberOfBoards();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "numberOfBoards", lhsNumberOfBoards), LocatorUtils.property(thatLocator, "numberOfBoards", rhsNumberOfBoards), lhsNumberOfBoards, rhsNumberOfBoards)) {
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
            XMLGregorianCalendar theDateViewed;
            theDateViewed = this.getDateViewed();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateViewed", theDateViewed), currentHashCode, theDateViewed);
        }
        {
            int theNumberOfBoards;
            theNumberOfBoards = this.getNumberOfBoards();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numberOfBoards", theNumberOfBoards), currentHashCode, theNumberOfBoards);
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
        if (draftCopy instanceof BoardsViewed) {
            final BoardsViewed copy = ((BoardsViewed) draftCopy);
            if (this.dateViewed!= null) {
                XMLGregorianCalendar sourceDateViewed;
                sourceDateViewed = this.getDateViewed();
                XMLGregorianCalendar copyDateViewed = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "dateViewed", sourceDateViewed), sourceDateViewed));
                copy.setDateViewed(copyDateViewed);
            } else {
                copy.dateViewed = null;
            }
            int sourceNumberOfBoards;
            sourceNumberOfBoards = this.getNumberOfBoards();
            int copyNumberOfBoards = strategy.copy(LocatorUtils.property(locator, "numberOfBoards", sourceNumberOfBoards), sourceNumberOfBoards);
            copy.setNumberOfBoards(copyNumberOfBoards);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new BoardsViewed();
    }

}
