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
import javax.xml.bind.annotation.XmlType;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.StMemPricingOptionsDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
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
 * <p>Java class for UserInfoDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserInfoDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="regStatus" type="{http://domain.businessobjects.f9g4.com}adLookupValuesDomain"/>
 *         &lt;element name="activeStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userLogo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userType" type="{http://domain.businessobjects.f9g4.com}adLookupValuesDomain"/>
 *         &lt;element name="membership" type="{http://domain.businessobjects.f9g4.com}adUserMembershipDomain" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="memPricingOption" type="{http://domain.businessobjects.f9g4.com}stMemPricingOptionsDomain"/>
 *         &lt;element name="approverComment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portfolio" type="{http://domain.businessobjects.f9g4.com}trPortfolioDomain" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adminRating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfoDomain", propOrder = {
    "userId",
    "userName",
    "name",
    "regStatus",
    "activeStatus",
    "userLogo",
    "userType",
    "membership",
    "memPricingOption",
    "approverComment",
    "portfolio",
    "adminRating"
})
public class UserInfoDomain implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected int userId;
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected AdLookupValuesDomain regStatus;
    protected int activeStatus;
    @XmlElement(required = true)
    protected String userLogo;
    @XmlElement(required = true)
    protected AdLookupValuesDomain userType;
    protected List<AdUserMembershipDomain> membership;
    @XmlElement(required = true)
    protected StMemPricingOptionsDomain memPricingOption;
    @XmlElement(required = true)
    protected String approverComment;
    protected List<TrPortfolioDomain> portfolio;
    protected int adminRating;

    /**
     * Default no-arg constructor
     * 
     */
    public UserInfoDomain() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public UserInfoDomain(final int userId, final String userName, final String name, final AdLookupValuesDomain regStatus, final int activeStatus, final String userLogo, final AdLookupValuesDomain userType, final List<AdUserMembershipDomain> membership, final StMemPricingOptionsDomain memPricingOption, final String approverComment, final List<TrPortfolioDomain> portfolio, final int adminRating) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.regStatus = regStatus;
        this.activeStatus = activeStatus;
        this.userLogo = userLogo;
        this.userType = userType;
        this.membership = membership;
        this.memPricingOption = memPricingOption;
        this.approverComment = approverComment;
        this.portfolio = portfolio;
        this.adminRating = adminRating;
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
     * Gets the value of the regStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public AdLookupValuesDomain getRegStatus() {
        return regStatus;
    }

    /**
     * Sets the value of the regStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public void setRegStatus(AdLookupValuesDomain value) {
        this.regStatus = value;
    }

    /**
     * Gets the value of the activeStatus property.
     * 
     */
    public int getActiveStatus() {
        return activeStatus;
    }

    /**
     * Sets the value of the activeStatus property.
     * 
     */
    public void setActiveStatus(int value) {
        this.activeStatus = value;
    }

    /**
     * Gets the value of the userLogo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLogo() {
        return userLogo;
    }

    /**
     * Sets the value of the userLogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLogo(String value) {
        this.userLogo = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public AdLookupValuesDomain getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdLookupValuesDomain }
     *     
     */
    public void setUserType(AdLookupValuesDomain value) {
        this.userType = value;
    }

    /**
     * Gets the value of the membership property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the membership property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMembership().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdUserMembershipDomain }
     * 
     * 
     */
    public List<AdUserMembershipDomain> getMembership() {
        if (membership == null) {
            membership = new ArrayList<AdUserMembershipDomain>();
        }
        return this.membership;
    }

    /**
     * Gets the value of the memPricingOption property.
     * 
     * @return
     *     possible object is
     *     {@link StMemPricingOptionsDomain }
     *     
     */
    public StMemPricingOptionsDomain getMemPricingOption() {
        return memPricingOption;
    }

    /**
     * Sets the value of the memPricingOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link StMemPricingOptionsDomain }
     *     
     */
    public void setMemPricingOption(StMemPricingOptionsDomain value) {
        this.memPricingOption = value;
    }

    /**
     * Gets the value of the approverComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverComment() {
        return approverComment;
    }

    /**
     * Sets the value of the approverComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverComment(String value) {
        this.approverComment = value;
    }

    /**
     * Gets the value of the portfolio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portfolio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortfolio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrPortfolioDomain }
     * 
     * 
     */
    public List<TrPortfolioDomain> getPortfolio() {
        if (portfolio == null) {
            portfolio = new ArrayList<TrPortfolioDomain>();
        }
        return this.portfolio;
    }

    /**
     * Gets the value of the adminRating property.
     * 
     */
    public int getAdminRating() {
        return adminRating;
    }

    /**
     * Sets the value of the adminRating property.
     * 
     */
    public void setAdminRating(int value) {
        this.adminRating = value;
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
            String theUserName;
            theUserName = this.getUserName();
            strategy.appendField(locator, this, "userName", buffer, theUserName);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            AdLookupValuesDomain theRegStatus;
            theRegStatus = this.getRegStatus();
            strategy.appendField(locator, this, "regStatus", buffer, theRegStatus);
        }
        {
            int theActiveStatus;
            theActiveStatus = this.getActiveStatus();
            strategy.appendField(locator, this, "activeStatus", buffer, theActiveStatus);
        }
        {
            String theUserLogo;
            theUserLogo = this.getUserLogo();
            strategy.appendField(locator, this, "userLogo", buffer, theUserLogo);
        }
        {
            AdLookupValuesDomain theUserType;
            theUserType = this.getUserType();
            strategy.appendField(locator, this, "userType", buffer, theUserType);
        }
        {
            List<AdUserMembershipDomain> theMembership;
            theMembership = this.getMembership();
            strategy.appendField(locator, this, "membership", buffer, theMembership);
        }
        {
            StMemPricingOptionsDomain theMemPricingOption;
            theMemPricingOption = this.getMemPricingOption();
            strategy.appendField(locator, this, "memPricingOption", buffer, theMemPricingOption);
        }
        {
            String theApproverComment;
            theApproverComment = this.getApproverComment();
            strategy.appendField(locator, this, "approverComment", buffer, theApproverComment);
        }
        {
            List<TrPortfolioDomain> thePortfolio;
            thePortfolio = this.getPortfolio();
            strategy.appendField(locator, this, "portfolio", buffer, thePortfolio);
        }
        {
            int theAdminRating;
            theAdminRating = this.getAdminRating();
            strategy.appendField(locator, this, "adminRating", buffer, theAdminRating);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UserInfoDomain)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UserInfoDomain that = ((UserInfoDomain) object);
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
            String lhsUserName;
            lhsUserName = this.getUserName();
            String rhsUserName;
            rhsUserName = that.getUserName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userName", lhsUserName), LocatorUtils.property(thatLocator, "userName", rhsUserName), lhsUserName, rhsUserName)) {
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
            AdLookupValuesDomain lhsRegStatus;
            lhsRegStatus = this.getRegStatus();
            AdLookupValuesDomain rhsRegStatus;
            rhsRegStatus = that.getRegStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "regStatus", lhsRegStatus), LocatorUtils.property(thatLocator, "regStatus", rhsRegStatus), lhsRegStatus, rhsRegStatus)) {
                return false;
            }
        }
        {
            int lhsActiveStatus;
            lhsActiveStatus = this.getActiveStatus();
            int rhsActiveStatus;
            rhsActiveStatus = that.getActiveStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activeStatus", lhsActiveStatus), LocatorUtils.property(thatLocator, "activeStatus", rhsActiveStatus), lhsActiveStatus, rhsActiveStatus)) {
                return false;
            }
        }
        {
            String lhsUserLogo;
            lhsUserLogo = this.getUserLogo();
            String rhsUserLogo;
            rhsUserLogo = that.getUserLogo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userLogo", lhsUserLogo), LocatorUtils.property(thatLocator, "userLogo", rhsUserLogo), lhsUserLogo, rhsUserLogo)) {
                return false;
            }
        }
        {
            AdLookupValuesDomain lhsUserType;
            lhsUserType = this.getUserType();
            AdLookupValuesDomain rhsUserType;
            rhsUserType = that.getUserType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userType", lhsUserType), LocatorUtils.property(thatLocator, "userType", rhsUserType), lhsUserType, rhsUserType)) {
                return false;
            }
        }
        {
            List<AdUserMembershipDomain> lhsMembership;
            lhsMembership = this.getMembership();
            List<AdUserMembershipDomain> rhsMembership;
            rhsMembership = that.getMembership();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "membership", lhsMembership), LocatorUtils.property(thatLocator, "membership", rhsMembership), lhsMembership, rhsMembership)) {
                return false;
            }
        }
        {
            StMemPricingOptionsDomain lhsMemPricingOption;
            lhsMemPricingOption = this.getMemPricingOption();
            StMemPricingOptionsDomain rhsMemPricingOption;
            rhsMemPricingOption = that.getMemPricingOption();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "memPricingOption", lhsMemPricingOption), LocatorUtils.property(thatLocator, "memPricingOption", rhsMemPricingOption), lhsMemPricingOption, rhsMemPricingOption)) {
                return false;
            }
        }
        {
            String lhsApproverComment;
            lhsApproverComment = this.getApproverComment();
            String rhsApproverComment;
            rhsApproverComment = that.getApproverComment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "approverComment", lhsApproverComment), LocatorUtils.property(thatLocator, "approverComment", rhsApproverComment), lhsApproverComment, rhsApproverComment)) {
                return false;
            }
        }
        {
            List<TrPortfolioDomain> lhsPortfolio;
            lhsPortfolio = this.getPortfolio();
            List<TrPortfolioDomain> rhsPortfolio;
            rhsPortfolio = that.getPortfolio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "portfolio", lhsPortfolio), LocatorUtils.property(thatLocator, "portfolio", rhsPortfolio), lhsPortfolio, rhsPortfolio)) {
                return false;
            }
        }
        {
            int lhsAdminRating;
            lhsAdminRating = this.getAdminRating();
            int rhsAdminRating;
            rhsAdminRating = that.getAdminRating();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adminRating", lhsAdminRating), LocatorUtils.property(thatLocator, "adminRating", rhsAdminRating), lhsAdminRating, rhsAdminRating)) {
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
            String theUserName;
            theUserName = this.getUserName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userName", theUserName), currentHashCode, theUserName);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            AdLookupValuesDomain theRegStatus;
            theRegStatus = this.getRegStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "regStatus", theRegStatus), currentHashCode, theRegStatus);
        }
        {
            int theActiveStatus;
            theActiveStatus = this.getActiveStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activeStatus", theActiveStatus), currentHashCode, theActiveStatus);
        }
        {
            String theUserLogo;
            theUserLogo = this.getUserLogo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userLogo", theUserLogo), currentHashCode, theUserLogo);
        }
        {
            AdLookupValuesDomain theUserType;
            theUserType = this.getUserType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userType", theUserType), currentHashCode, theUserType);
        }
        {
            List<AdUserMembershipDomain> theMembership;
            theMembership = this.getMembership();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "membership", theMembership), currentHashCode, theMembership);
        }
        {
            StMemPricingOptionsDomain theMemPricingOption;
            theMemPricingOption = this.getMemPricingOption();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "memPricingOption", theMemPricingOption), currentHashCode, theMemPricingOption);
        }
        {
            String theApproverComment;
            theApproverComment = this.getApproverComment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "approverComment", theApproverComment), currentHashCode, theApproverComment);
        }
        {
            List<TrPortfolioDomain> thePortfolio;
            thePortfolio = this.getPortfolio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "portfolio", thePortfolio), currentHashCode, thePortfolio);
        }
        {
            int theAdminRating;
            theAdminRating = this.getAdminRating();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adminRating", theAdminRating), currentHashCode, theAdminRating);
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
        if (draftCopy instanceof UserInfoDomain) {
            final UserInfoDomain copy = ((UserInfoDomain) draftCopy);
            int sourceUserId;
            sourceUserId = this.getUserId();
            int copyUserId = strategy.copy(LocatorUtils.property(locator, "userId", sourceUserId), sourceUserId);
            copy.setUserId(copyUserId);
            if (this.userName!= null) {
                String sourceUserName;
                sourceUserName = this.getUserName();
                String copyUserName = ((String) strategy.copy(LocatorUtils.property(locator, "userName", sourceUserName), sourceUserName));
                copy.setUserName(copyUserName);
            } else {
                copy.userName = null;
            }
            if (this.name!= null) {
                String sourceName;
                sourceName = this.getName();
                String copyName = ((String) strategy.copy(LocatorUtils.property(locator, "name", sourceName), sourceName));
                copy.setName(copyName);
            } else {
                copy.name = null;
            }
            if (this.regStatus!= null) {
                AdLookupValuesDomain sourceRegStatus;
                sourceRegStatus = this.getRegStatus();
                AdLookupValuesDomain copyRegStatus = ((AdLookupValuesDomain) strategy.copy(LocatorUtils.property(locator, "regStatus", sourceRegStatus), sourceRegStatus));
                copy.setRegStatus(copyRegStatus);
            } else {
                copy.regStatus = null;
            }
            int sourceActiveStatus;
            sourceActiveStatus = this.getActiveStatus();
            int copyActiveStatus = strategy.copy(LocatorUtils.property(locator, "activeStatus", sourceActiveStatus), sourceActiveStatus);
            copy.setActiveStatus(copyActiveStatus);
            if (this.userLogo!= null) {
                String sourceUserLogo;
                sourceUserLogo = this.getUserLogo();
                String copyUserLogo = ((String) strategy.copy(LocatorUtils.property(locator, "userLogo", sourceUserLogo), sourceUserLogo));
                copy.setUserLogo(copyUserLogo);
            } else {
                copy.userLogo = null;
            }
            if (this.userType!= null) {
                AdLookupValuesDomain sourceUserType;
                sourceUserType = this.getUserType();
                AdLookupValuesDomain copyUserType = ((AdLookupValuesDomain) strategy.copy(LocatorUtils.property(locator, "userType", sourceUserType), sourceUserType));
                copy.setUserType(copyUserType);
            } else {
                copy.userType = null;
            }
            if ((this.membership!= null)&&(!this.membership.isEmpty())) {
                List<AdUserMembershipDomain> sourceMembership;
                sourceMembership = this.getMembership();
                @SuppressWarnings("unchecked")
                List<AdUserMembershipDomain> copyMembership = ((List<AdUserMembershipDomain> ) strategy.copy(LocatorUtils.property(locator, "membership", sourceMembership), sourceMembership));
                copy.membership = null;
                List<AdUserMembershipDomain> uniqueMembershipl = copy.getMembership();
                uniqueMembershipl.addAll(copyMembership);
            } else {
                copy.membership = null;
            }
            if (this.memPricingOption!= null) {
                StMemPricingOptionsDomain sourceMemPricingOption;
                sourceMemPricingOption = this.getMemPricingOption();
                StMemPricingOptionsDomain copyMemPricingOption = ((StMemPricingOptionsDomain) strategy.copy(LocatorUtils.property(locator, "memPricingOption", sourceMemPricingOption), sourceMemPricingOption));
                copy.setMemPricingOption(copyMemPricingOption);
            } else {
                copy.memPricingOption = null;
            }
            if (this.approverComment!= null) {
                String sourceApproverComment;
                sourceApproverComment = this.getApproverComment();
                String copyApproverComment = ((String) strategy.copy(LocatorUtils.property(locator, "approverComment", sourceApproverComment), sourceApproverComment));
                copy.setApproverComment(copyApproverComment);
            } else {
                copy.approverComment = null;
            }
            if ((this.portfolio!= null)&&(!this.portfolio.isEmpty())) {
                List<TrPortfolioDomain> sourcePortfolio;
                sourcePortfolio = this.getPortfolio();
                @SuppressWarnings("unchecked")
                List<TrPortfolioDomain> copyPortfolio = ((List<TrPortfolioDomain> ) strategy.copy(LocatorUtils.property(locator, "portfolio", sourcePortfolio), sourcePortfolio));
                copy.portfolio = null;
                List<TrPortfolioDomain> uniquePortfoliol = copy.getPortfolio();
                uniquePortfoliol.addAll(copyPortfolio);
            } else {
                copy.portfolio = null;
            }
            int sourceAdminRating;
            sourceAdminRating = this.getAdminRating();
            int copyAdminRating = strategy.copy(LocatorUtils.property(locator, "adminRating", sourceAdminRating), sourceAdminRating);
            copy.setAdminRating(copyAdminRating);
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new UserInfoDomain();
    }

}