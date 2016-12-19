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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.TrPortfolioContestDomain;
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
 * <p>Java class for GetContestByUserIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetContestByUserIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contest" type="{http://domain.businessobjects.f9g4.com}trPortfolioContestDomain" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://common.businessobjects.f9g4.com}Status"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetContestByUserIdResponse", propOrder = {
    "contest",
    "status"
})
@XmlRootElement(name = "GetContestByUserIdResponse")
public class GetContestByUserIdResponse implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected List<TrPortfolioContestDomain> contest;
    @XmlElement(required = true)
    protected Status status;

    /**
     * Default no-arg constructor
     * 
     */
    public GetContestByUserIdResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetContestByUserIdResponse(final List<TrPortfolioContestDomain> contest, final Status status) {
        this.contest = contest;
        this.status = status;
    }

    /**
     * Gets the value of the contest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrPortfolioContestDomain }
     * 
     * 
     */
    public List<TrPortfolioContestDomain> getContest() {
        if (contest == null) {
            contest = new ArrayList<TrPortfolioContestDomain>();
        }
        return this.contest;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
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
            List<TrPortfolioContestDomain> theContest;
            theContest = this.getContest();
            strategy.appendField(locator, this, "contest", buffer, theContest);
        }
        {
            Status theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetContestByUserIdResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetContestByUserIdResponse that = ((GetContestByUserIdResponse) object);
        {
            List<TrPortfolioContestDomain> lhsContest;
            lhsContest = this.getContest();
            List<TrPortfolioContestDomain> rhsContest;
            rhsContest = that.getContest();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contest", lhsContest), LocatorUtils.property(thatLocator, "contest", rhsContest), lhsContest, rhsContest)) {
                return false;
            }
        }
        {
            Status lhsStatus;
            lhsStatus = this.getStatus();
            Status rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
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
            List<TrPortfolioContestDomain> theContest;
            theContest = this.getContest();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contest", theContest), currentHashCode, theContest);
        }
        {
            Status theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
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
        if (draftCopy instanceof GetContestByUserIdResponse) {
            final GetContestByUserIdResponse copy = ((GetContestByUserIdResponse) draftCopy);
            if ((this.contest!= null)&&(!this.contest.isEmpty())) {
                List<TrPortfolioContestDomain> sourceContest;
                sourceContest = this.getContest();
                @SuppressWarnings("unchecked")
                List<TrPortfolioContestDomain> copyContest = ((List<TrPortfolioContestDomain> ) strategy.copy(LocatorUtils.property(locator, "contest", sourceContest), sourceContest));
                copy.contest = null;
                List<TrPortfolioContestDomain> uniqueContestl = copy.getContest();
                uniqueContestl.addAll(copyContest);
            } else {
                copy.contest = null;
            }
            if (this.status!= null) {
                Status sourceStatus;
                sourceStatus = this.getStatus();
                Status copyStatus = ((Status) strategy.copy(LocatorUtils.property(locator, "status", sourceStatus), sourceStatus));
                copy.setStatus(copyStatus);
            } else {
                copy.status = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetContestByUserIdResponse();
    }

}
