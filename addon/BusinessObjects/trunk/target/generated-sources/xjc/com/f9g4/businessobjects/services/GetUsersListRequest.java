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
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
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
 * <p>Java class for GetUsersListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUsersListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="regStatus" type="{http://domain.businessobjects.f9g4.com}adLookupValuesDomain" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userType" type="{http://domain.businessobjects.f9g4.com}adLookupValuesDomain" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sortOption" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUsersListRequest", propOrder = {
    "regStatus",
    "userType",
    "sortOption",
    "firstResult",
    "maxResult"
})
@XmlRootElement(name = "GetUsersListRequest")
public class GetUsersListRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected List<AdLookupValuesDomain> regStatus;
    protected List<AdLookupValuesDomain> userType;
    protected int sortOption;
    protected int firstResult;
    protected int maxResult;

    /**
     * Default no-arg constructor
     * 
     */
    public GetUsersListRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GetUsersListRequest(final List<AdLookupValuesDomain> regStatus, final List<AdLookupValuesDomain> userType, final int sortOption, final int firstResult, final int maxResult) {
        this.regStatus = regStatus;
        this.userType = userType;
        this.sortOption = sortOption;
        this.firstResult = firstResult;
        this.maxResult = maxResult;
    }

    /**
     * Gets the value of the regStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdLookupValuesDomain }
     * 
     * 
     */
    public List<AdLookupValuesDomain> getRegStatus() {
        if (regStatus == null) {
            regStatus = new ArrayList<AdLookupValuesDomain>();
        }
        return this.regStatus;
    }

    /**
     * Gets the value of the userType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdLookupValuesDomain }
     * 
     * 
     */
    public List<AdLookupValuesDomain> getUserType() {
        if (userType == null) {
            userType = new ArrayList<AdLookupValuesDomain>();
        }
        return this.userType;
    }

    /**
     * Gets the value of the sortOption property.
     * 
     */
    public int getSortOption() {
        return sortOption;
    }

    /**
     * Sets the value of the sortOption property.
     * 
     */
    public void setSortOption(int value) {
        this.sortOption = value;
    }

    /**
     * Gets the value of the firstResult property.
     * 
     */
    public int getFirstResult() {
        return firstResult;
    }

    /**
     * Sets the value of the firstResult property.
     * 
     */
    public void setFirstResult(int value) {
        this.firstResult = value;
    }

    /**
     * Gets the value of the maxResult property.
     * 
     */
    public int getMaxResult() {
        return maxResult;
    }

    /**
     * Sets the value of the maxResult property.
     * 
     */
    public void setMaxResult(int value) {
        this.maxResult = value;
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
            List<AdLookupValuesDomain> theRegStatus;
            theRegStatus = this.getRegStatus();
            strategy.appendField(locator, this, "regStatus", buffer, theRegStatus);
        }
        {
            List<AdLookupValuesDomain> theUserType;
            theUserType = this.getUserType();
            strategy.appendField(locator, this, "userType", buffer, theUserType);
        }
        {
            int theSortOption;
            theSortOption = this.getSortOption();
            strategy.appendField(locator, this, "sortOption", buffer, theSortOption);
        }
        {
            int theFirstResult;
            theFirstResult = this.getFirstResult();
            strategy.appendField(locator, this, "firstResult", buffer, theFirstResult);
        }
        {
            int theMaxResult;
            theMaxResult = this.getMaxResult();
            strategy.appendField(locator, this, "maxResult", buffer, theMaxResult);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetUsersListRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetUsersListRequest that = ((GetUsersListRequest) object);
        {
            List<AdLookupValuesDomain> lhsRegStatus;
            lhsRegStatus = this.getRegStatus();
            List<AdLookupValuesDomain> rhsRegStatus;
            rhsRegStatus = that.getRegStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "regStatus", lhsRegStatus), LocatorUtils.property(thatLocator, "regStatus", rhsRegStatus), lhsRegStatus, rhsRegStatus)) {
                return false;
            }
        }
        {
            List<AdLookupValuesDomain> lhsUserType;
            lhsUserType = this.getUserType();
            List<AdLookupValuesDomain> rhsUserType;
            rhsUserType = that.getUserType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userType", lhsUserType), LocatorUtils.property(thatLocator, "userType", rhsUserType), lhsUserType, rhsUserType)) {
                return false;
            }
        }
        {
            int lhsSortOption;
            lhsSortOption = this.getSortOption();
            int rhsSortOption;
            rhsSortOption = that.getSortOption();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sortOption", lhsSortOption), LocatorUtils.property(thatLocator, "sortOption", rhsSortOption), lhsSortOption, rhsSortOption)) {
                return false;
            }
        }
        {
            int lhsFirstResult;
            lhsFirstResult = this.getFirstResult();
            int rhsFirstResult;
            rhsFirstResult = that.getFirstResult();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "firstResult", lhsFirstResult), LocatorUtils.property(thatLocator, "firstResult", rhsFirstResult), lhsFirstResult, rhsFirstResult)) {
                return false;
            }
        }
        {
            int lhsMaxResult;
            lhsMaxResult = this.getMaxResult();
            int rhsMaxResult;
            rhsMaxResult = that.getMaxResult();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxResult", lhsMaxResult), LocatorUtils.property(thatLocator, "maxResult", rhsMaxResult), lhsMaxResult, rhsMaxResult)) {
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
            List<AdLookupValuesDomain> theRegStatus;
            theRegStatus = this.getRegStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "regStatus", theRegStatus), currentHashCode, theRegStatus);
        }
        {
            List<AdLookupValuesDomain> theUserType;
            theUserType = this.getUserType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userType", theUserType), currentHashCode, theUserType);
        }
        {
            int theSortOption;
            theSortOption = this.getSortOption();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sortOption", theSortOption), currentHashCode, theSortOption);
        }
        {
            int theFirstResult;
            theFirstResult = this.getFirstResult();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstResult", theFirstResult), currentHashCode, theFirstResult);
        }
        {
            int theMaxResult;
            theMaxResult = this.getMaxResult();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxResult", theMaxResult), currentHashCode, theMaxResult);
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
        if (draftCopy instanceof GetUsersListRequest) {
            final GetUsersListRequest copy = ((GetUsersListRequest) draftCopy);
            if ((this.regStatus!= null)&&(!this.regStatus.isEmpty())) {
                List<AdLookupValuesDomain> sourceRegStatus;
                sourceRegStatus = this.getRegStatus();
                @SuppressWarnings("unchecked")
                List<AdLookupValuesDomain> copyRegStatus = ((List<AdLookupValuesDomain> ) strategy.copy(LocatorUtils.property(locator, "regStatus", sourceRegStatus), sourceRegStatus));
                copy.regStatus = null;
                List<AdLookupValuesDomain> uniqueRegStatusl = copy.getRegStatus();
                uniqueRegStatusl.addAll(copyRegStatus);
            } else {
                copy.regStatus = null;
            }
            if ((this.userType!= null)&&(!this.userType.isEmpty())) {
                List<AdLookupValuesDomain> sourceUserType;
                sourceUserType = this.getUserType();
                @SuppressWarnings("unchecked")
                List<AdLookupValuesDomain> copyUserType = ((List<AdLookupValuesDomain> ) strategy.copy(LocatorUtils.property(locator, "userType", sourceUserType), sourceUserType));
                copy.userType = null;
                List<AdLookupValuesDomain> uniqueUserTypel = copy.getUserType();
                uniqueUserTypel.addAll(copyUserType);
            } else {
                copy.userType = null;
            }
            int sourceSortOption;
            sourceSortOption = this.getSortOption();
            int copySortOption = strategy.copy(LocatorUtils.property(locator, "sortOption", sourceSortOption), sourceSortOption);
            copy.setSortOption(copySortOption);
            int sourceFirstResult;
            sourceFirstResult = this.getFirstResult();
            int copyFirstResult = strategy.copy(LocatorUtils.property(locator, "firstResult", sourceFirstResult), sourceFirstResult);
            copy.setFirstResult(copyFirstResult);
            int sourceMaxResult;
            sourceMaxResult = this.getMaxResult();
            int copyMaxResult = strategy.copy(LocatorUtils.property(locator, "maxResult", sourceMaxResult), sourceMaxResult);
            copy.setMaxResult(copyMaxResult);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetUsersListRequest();
    }

}
