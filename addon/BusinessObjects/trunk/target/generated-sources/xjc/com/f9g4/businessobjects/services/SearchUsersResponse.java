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
import com.f9g4.businessobjects.domain.AdUsersDomain;
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
 * <p>Java class for SearchUsersResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchUsersResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://common.businessobjects.f9g4.com}Status"/>
 *         &lt;element name="users" type="{http://domain.businessobjects.f9g4.com}adUsersDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchUsersResponse", propOrder = {
    "status",
    "users"
})
@XmlRootElement(name = "SearchUsersResponse")
public class SearchUsersResponse implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Status status;
    protected List<AdUsersDomain> users;

    /**
     * Default no-arg constructor
     * 
     */
    public SearchUsersResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SearchUsersResponse(final Status status, final List<AdUsersDomain> users) {
        this.status = status;
        this.users = users;
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

    /**
     * Gets the value of the users property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the users property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdUsersDomain }
     * 
     * 
     */
    public List<AdUsersDomain> getUsers() {
        if (users == null) {
            users = new ArrayList<AdUsersDomain>();
        }
        return this.users;
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
            Status theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            List<AdUsersDomain> theUsers;
            theUsers = this.getUsers();
            strategy.appendField(locator, this, "users", buffer, theUsers);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchUsersResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchUsersResponse that = ((SearchUsersResponse) object);
        {
            Status lhsStatus;
            lhsStatus = this.getStatus();
            Status rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            List<AdUsersDomain> lhsUsers;
            lhsUsers = this.getUsers();
            List<AdUsersDomain> rhsUsers;
            rhsUsers = that.getUsers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "users", lhsUsers), LocatorUtils.property(thatLocator, "users", rhsUsers), lhsUsers, rhsUsers)) {
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
            Status theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            List<AdUsersDomain> theUsers;
            theUsers = this.getUsers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "users", theUsers), currentHashCode, theUsers);
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
        if (draftCopy instanceof SearchUsersResponse) {
            final SearchUsersResponse copy = ((SearchUsersResponse) draftCopy);
            if (this.status!= null) {
                Status sourceStatus;
                sourceStatus = this.getStatus();
                Status copyStatus = ((Status) strategy.copy(LocatorUtils.property(locator, "status", sourceStatus), sourceStatus));
                copy.setStatus(copyStatus);
            } else {
                copy.status = null;
            }
            if ((this.users!= null)&&(!this.users.isEmpty())) {
                List<AdUsersDomain> sourceUsers;
                sourceUsers = this.getUsers();
                @SuppressWarnings("unchecked")
                List<AdUsersDomain> copyUsers = ((List<AdUsersDomain> ) strategy.copy(LocatorUtils.property(locator, "users", sourceUsers), sourceUsers));
                copy.users = null;
                List<AdUsersDomain> uniqueUsersl = copy.getUsers();
                uniqueUsersl.addAll(copyUsers);
            } else {
                copy.users = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SearchUsersResponse();
    }

}
