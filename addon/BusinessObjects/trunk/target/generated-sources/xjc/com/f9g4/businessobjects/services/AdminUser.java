//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.12 at 09:23:49 PM EST 
//


package com.f9g4.businessobjects.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for AdminUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdminUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="activeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="langCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company" type="{http://services.businessobjects.f9g4.com}Company"/>
 *         &lt;element name="authoroties" type="{http://services.businessobjects.f9g4.com}UserAuthorities"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdminUser", propOrder = {
    "userName",
    "emailAddress",
    "firstName",
    "lastName",
    "activeFlag",
    "langCode",
    "company",
    "authoroties"
})
@XmlRootElement(name = "AdminUser")
public class AdminUser implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String emailAddress;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String activeFlag;
    @XmlElement(required = true)
    protected String langCode;
    @XmlElement(required = true)
    protected Company company;
    @XmlElement(required = true)
    protected UserAuthorities authoroties;

    /**
     * Default no-arg constructor
     * 
     */
    public AdminUser() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public AdminUser(final String userName, final String emailAddress, final String firstName, final String lastName, final String activeFlag, final String langCode, final Company company, final UserAuthorities authoroties) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activeFlag = activeFlag;
        this.langCode = langCode;
        this.company = company;
        this.authoroties = authoroties;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the activeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiveFlag() {
        return activeFlag;
    }

    /**
     * Sets the value of the activeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiveFlag(String value) {
        this.activeFlag = value;
    }

    /**
     * Gets the value of the langCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangCode() {
        return langCode;
    }

    /**
     * Sets the value of the langCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangCode(String value) {
        this.langCode = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setCompany(Company value) {
        this.company = value;
    }

    /**
     * Gets the value of the authoroties property.
     * 
     * @return
     *     possible object is
     *     {@link UserAuthorities }
     *     
     */
    public UserAuthorities getAuthoroties() {
        return authoroties;
    }

    /**
     * Sets the value of the authoroties property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAuthorities }
     *     
     */
    public void setAuthoroties(UserAuthorities value) {
        this.authoroties = value;
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
            String theUserName;
            theUserName = this.getUserName();
            strategy.appendField(locator, this, "userName", buffer, theUserName);
        }
        {
            String theEmailAddress;
            theEmailAddress = this.getEmailAddress();
            strategy.appendField(locator, this, "emailAddress", buffer, theEmailAddress);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            strategy.appendField(locator, this, "firstName", buffer, theFirstName);
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            strategy.appendField(locator, this, "lastName", buffer, theLastName);
        }
        {
            String theActiveFlag;
            theActiveFlag = this.getActiveFlag();
            strategy.appendField(locator, this, "activeFlag", buffer, theActiveFlag);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            strategy.appendField(locator, this, "langCode", buffer, theLangCode);
        }
        {
            Company theCompany;
            theCompany = this.getCompany();
            strategy.appendField(locator, this, "company", buffer, theCompany);
        }
        {
            UserAuthorities theAuthoroties;
            theAuthoroties = this.getAuthoroties();
            strategy.appendField(locator, this, "authoroties", buffer, theAuthoroties);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AdminUser)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AdminUser that = ((AdminUser) object);
        {
            String lhsUserName;
            lhsUserName = this.getUserName();
            String rhsUserName;
            rhsUserName = that.getUserName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userName", lhsUserName), LocatorUtils.property(thatLocator, "userName", rhsUserName), lhsUserName, rhsUserName)) {
                return false;
            }
        }
        {
            String lhsEmailAddress;
            lhsEmailAddress = this.getEmailAddress();
            String rhsEmailAddress;
            rhsEmailAddress = that.getEmailAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "emailAddress", lhsEmailAddress), LocatorUtils.property(thatLocator, "emailAddress", rhsEmailAddress), lhsEmailAddress, rhsEmailAddress)) {
                return false;
            }
        }
        {
            String lhsFirstName;
            lhsFirstName = this.getFirstName();
            String rhsFirstName;
            rhsFirstName = that.getFirstName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "firstName", lhsFirstName), LocatorUtils.property(thatLocator, "firstName", rhsFirstName), lhsFirstName, rhsFirstName)) {
                return false;
            }
        }
        {
            String lhsLastName;
            lhsLastName = this.getLastName();
            String rhsLastName;
            rhsLastName = that.getLastName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastName", lhsLastName), LocatorUtils.property(thatLocator, "lastName", rhsLastName), lhsLastName, rhsLastName)) {
                return false;
            }
        }
        {
            String lhsActiveFlag;
            lhsActiveFlag = this.getActiveFlag();
            String rhsActiveFlag;
            rhsActiveFlag = that.getActiveFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activeFlag", lhsActiveFlag), LocatorUtils.property(thatLocator, "activeFlag", rhsActiveFlag), lhsActiveFlag, rhsActiveFlag)) {
                return false;
            }
        }
        {
            String lhsLangCode;
            lhsLangCode = this.getLangCode();
            String rhsLangCode;
            rhsLangCode = that.getLangCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "langCode", lhsLangCode), LocatorUtils.property(thatLocator, "langCode", rhsLangCode), lhsLangCode, rhsLangCode)) {
                return false;
            }
        }
        {
            Company lhsCompany;
            lhsCompany = this.getCompany();
            Company rhsCompany;
            rhsCompany = that.getCompany();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "company", lhsCompany), LocatorUtils.property(thatLocator, "company", rhsCompany), lhsCompany, rhsCompany)) {
                return false;
            }
        }
        {
            UserAuthorities lhsAuthoroties;
            lhsAuthoroties = this.getAuthoroties();
            UserAuthorities rhsAuthoroties;
            rhsAuthoroties = that.getAuthoroties();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "authoroties", lhsAuthoroties), LocatorUtils.property(thatLocator, "authoroties", rhsAuthoroties), lhsAuthoroties, rhsAuthoroties)) {
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
            String theUserName;
            theUserName = this.getUserName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userName", theUserName), currentHashCode, theUserName);
        }
        {
            String theEmailAddress;
            theEmailAddress = this.getEmailAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "emailAddress", theEmailAddress), currentHashCode, theEmailAddress);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstName", theFirstName), currentHashCode, theFirstName);
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastName", theLastName), currentHashCode, theLastName);
        }
        {
            String theActiveFlag;
            theActiveFlag = this.getActiveFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activeFlag", theActiveFlag), currentHashCode, theActiveFlag);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "langCode", theLangCode), currentHashCode, theLangCode);
        }
        {
            Company theCompany;
            theCompany = this.getCompany();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "company", theCompany), currentHashCode, theCompany);
        }
        {
            UserAuthorities theAuthoroties;
            theAuthoroties = this.getAuthoroties();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "authoroties", theAuthoroties), currentHashCode, theAuthoroties);
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
        if (draftCopy instanceof AdminUser) {
            final AdminUser copy = ((AdminUser) draftCopy);
            if (this.userName!= null) {
                String sourceUserName;
                sourceUserName = this.getUserName();
                String copyUserName = ((String) strategy.copy(LocatorUtils.property(locator, "userName", sourceUserName), sourceUserName));
                copy.setUserName(copyUserName);
            } else {
                copy.userName = null;
            }
            if (this.emailAddress!= null) {
                String sourceEmailAddress;
                sourceEmailAddress = this.getEmailAddress();
                String copyEmailAddress = ((String) strategy.copy(LocatorUtils.property(locator, "emailAddress", sourceEmailAddress), sourceEmailAddress));
                copy.setEmailAddress(copyEmailAddress);
            } else {
                copy.emailAddress = null;
            }
            if (this.firstName!= null) {
                String sourceFirstName;
                sourceFirstName = this.getFirstName();
                String copyFirstName = ((String) strategy.copy(LocatorUtils.property(locator, "firstName", sourceFirstName), sourceFirstName));
                copy.setFirstName(copyFirstName);
            } else {
                copy.firstName = null;
            }
            if (this.lastName!= null) {
                String sourceLastName;
                sourceLastName = this.getLastName();
                String copyLastName = ((String) strategy.copy(LocatorUtils.property(locator, "lastName", sourceLastName), sourceLastName));
                copy.setLastName(copyLastName);
            } else {
                copy.lastName = null;
            }
            if (this.activeFlag!= null) {
                String sourceActiveFlag;
                sourceActiveFlag = this.getActiveFlag();
                String copyActiveFlag = ((String) strategy.copy(LocatorUtils.property(locator, "activeFlag", sourceActiveFlag), sourceActiveFlag));
                copy.setActiveFlag(copyActiveFlag);
            } else {
                copy.activeFlag = null;
            }
            if (this.langCode!= null) {
                String sourceLangCode;
                sourceLangCode = this.getLangCode();
                String copyLangCode = ((String) strategy.copy(LocatorUtils.property(locator, "langCode", sourceLangCode), sourceLangCode));
                copy.setLangCode(copyLangCode);
            } else {
                copy.langCode = null;
            }
            if (this.company!= null) {
                Company sourceCompany;
                sourceCompany = this.getCompany();
                Company copyCompany = ((Company) strategy.copy(LocatorUtils.property(locator, "company", sourceCompany), sourceCompany));
                copy.setCompany(copyCompany);
            } else {
                copy.company = null;
            }
            if (this.authoroties!= null) {
                UserAuthorities sourceAuthoroties;
                sourceAuthoroties = this.getAuthoroties();
                UserAuthorities copyAuthoroties = ((UserAuthorities) strategy.copy(LocatorUtils.property(locator, "authoroties", sourceAuthoroties), sourceAuthoroties));
                copy.setAuthoroties(copyAuthoroties);
            } else {
                copy.authoroties = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AdminUser();
    }

}