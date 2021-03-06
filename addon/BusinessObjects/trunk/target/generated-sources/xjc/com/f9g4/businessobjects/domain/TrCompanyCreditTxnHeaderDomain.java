//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.20 at 11:56:16 AM EST 
//


package com.f9g4.businessobjects.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for trCompanyCreditTxnHeaderDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trCompanyCreditTxnHeaderDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="txnheaderId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="totalCredits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-2147483648"/>
 *               &lt;maxInclusive value="2147483647"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trCompanyCreditTxnHeaderDomain", propOrder = {
    "txnheaderId",
    "totalCredits",
    "createdby"
})
public class TrCompanyCreditTxnHeaderDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int txnheaderId;
    protected int totalCredits;
    protected int createdby;

    /**
     * Default no-arg constructor
     * 
     */
    public TrCompanyCreditTxnHeaderDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public TrCompanyCreditTxnHeaderDomain(final int txnheaderId, final int totalCredits, final int createdby) {
        this.txnheaderId = txnheaderId;
        this.totalCredits = totalCredits;
        this.createdby = createdby;
    }

    /**
     * Gets the value of the txnheaderId property.
     * 
     */
    public int getTxnheaderId() {
        return txnheaderId;
    }

    /**
     * Sets the value of the txnheaderId property.
     * 
     */
    public void setTxnheaderId(int value) {
        this.txnheaderId = value;
    }

    /**
     * Gets the value of the totalCredits property.
     * 
     */
    public int getTotalCredits() {
        return totalCredits;
    }

    /**
     * Sets the value of the totalCredits property.
     * 
     */
    public void setTotalCredits(int value) {
        this.totalCredits = value;
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
            int theTxnheaderId;
            theTxnheaderId = this.getTxnheaderId();
            strategy.appendField(locator, this, "txnheaderId", buffer, theTxnheaderId);
        }
        {
            int theTotalCredits;
            theTotalCredits = this.getTotalCredits();
            strategy.appendField(locator, this, "totalCredits", buffer, theTotalCredits);
        }
        {
            int theCreatedby;
            theCreatedby = this.getCreatedby();
            strategy.appendField(locator, this, "createdby", buffer, theCreatedby);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TrCompanyCreditTxnHeaderDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TrCompanyCreditTxnHeaderDomain that = ((TrCompanyCreditTxnHeaderDomain) object);
        {
            int lhsTxnheaderId;
            lhsTxnheaderId = this.getTxnheaderId();
            int rhsTxnheaderId;
            rhsTxnheaderId = that.getTxnheaderId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "txnheaderId", lhsTxnheaderId), LocatorUtils.property(thatLocator, "txnheaderId", rhsTxnheaderId), lhsTxnheaderId, rhsTxnheaderId)) {
                return false;
            }
        }
        {
            int lhsTotalCredits;
            lhsTotalCredits = this.getTotalCredits();
            int rhsTotalCredits;
            rhsTotalCredits = that.getTotalCredits();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalCredits", lhsTotalCredits), LocatorUtils.property(thatLocator, "totalCredits", rhsTotalCredits), lhsTotalCredits, rhsTotalCredits)) {
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theTxnheaderId;
            theTxnheaderId = this.getTxnheaderId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "txnheaderId", theTxnheaderId), currentHashCode, theTxnheaderId);
        }
        {
            int theTotalCredits;
            theTotalCredits = this.getTotalCredits();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalCredits", theTotalCredits), currentHashCode, theTotalCredits);
        }
        {
            int theCreatedby;
            theCreatedby = this.getCreatedby();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "createdby", theCreatedby), currentHashCode, theCreatedby);
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
        if (draftCopy instanceof TrCompanyCreditTxnHeaderDomain) {
            final TrCompanyCreditTxnHeaderDomain copy = ((TrCompanyCreditTxnHeaderDomain) draftCopy);
            int sourceTxnheaderId;
            sourceTxnheaderId = this.getTxnheaderId();
            int copyTxnheaderId = strategy.copy(LocatorUtils.property(locator, "txnheaderId", sourceTxnheaderId), sourceTxnheaderId);
            copy.setTxnheaderId(copyTxnheaderId);
            int sourceTotalCredits;
            sourceTotalCredits = this.getTotalCredits();
            int copyTotalCredits = strategy.copy(LocatorUtils.property(locator, "totalCredits", sourceTotalCredits), sourceTotalCredits);
            copy.setTotalCredits(copyTotalCredits);
            int sourceCreatedby;
            sourceCreatedby = this.getCreatedby();
            int copyCreatedby = strategy.copy(LocatorUtils.property(locator, "createdby", sourceCreatedby), sourceCreatedby);
            copy.setCreatedby(copyCreatedby);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TrCompanyCreditTxnHeaderDomain();
    }

}
