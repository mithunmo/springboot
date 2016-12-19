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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.f9g4.businessobjects.domain.TrBoardDomain;
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
 * <p>Java class for SubmitSamplesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitSamplesRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="samples" type="{http://domain.businessobjects.f9g4.com}trBoardDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitSamplesRequest", propOrder = {
    "userId",
    "samples"
})
@XmlRootElement(name = "SubmitSamplesRequest")
public class SubmitSamplesRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int userId;
    protected List<TrBoardDomain> samples;

    /**
     * Default no-arg constructor
     * 
     */
    public SubmitSamplesRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SubmitSamplesRequest(final int userId, final List<TrBoardDomain> samples) {
        this.userId = userId;
        this.samples = samples;
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
     * Gets the value of the samples property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the samples property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSamples().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrBoardDomain }
     * 
     * 
     */
    public List<TrBoardDomain> getSamples() {
        if (samples == null) {
            samples = new ArrayList<TrBoardDomain>();
        }
        return this.samples;
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
            int theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId);
        }
        {
            List<TrBoardDomain> theSamples;
            theSamples = this.getSamples();
            strategy.appendField(locator, this, "samples", buffer, theSamples);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SubmitSamplesRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SubmitSamplesRequest that = ((SubmitSamplesRequest) object);
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
            List<TrBoardDomain> lhsSamples;
            lhsSamples = this.getSamples();
            List<TrBoardDomain> rhsSamples;
            rhsSamples = that.getSamples();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "samples", lhsSamples), LocatorUtils.property(thatLocator, "samples", rhsSamples), lhsSamples, rhsSamples)) {
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
            int theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId);
        }
        {
            List<TrBoardDomain> theSamples;
            theSamples = this.getSamples();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "samples", theSamples), currentHashCode, theSamples);
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
        if (draftCopy instanceof SubmitSamplesRequest) {
            final SubmitSamplesRequest copy = ((SubmitSamplesRequest) draftCopy);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            if ((this.samples!= null)&&(!this.samples.isEmpty())) {
                List<TrBoardDomain> sourceSamples;
                sourceSamples = this.getSamples();
                @SuppressWarnings("unchecked")
                List<TrBoardDomain> copySamples = ((List<TrBoardDomain> ) strategy.copy(LocatorUtils.property(locator, "samples", sourceSamples), sourceSamples));
                copy.samples = null;
                List<TrBoardDomain> uniqueSamplesl = copy.getSamples();
                uniqueSamplesl.addAll(copySamples);
            } else {
                copy.samples = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SubmitSamplesRequest();
    }

}