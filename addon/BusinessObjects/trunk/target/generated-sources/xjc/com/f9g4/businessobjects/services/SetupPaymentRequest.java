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
 * <p>Java class for SetupPaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetupPaymentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cancelUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ipnUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderItem" type="{http://services.businessobjects.f9g4.com}OrderItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetupPaymentRequest", propOrder = {
    "returnUrl",
    "cancelUrl",
    "ipnUrl",
    "orderItem"
})
@XmlRootElement(name = "SetupPaymentRequest")
public class SetupPaymentRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String returnUrl;
    @XmlElement(required = true)
    protected String cancelUrl;
    @XmlElement(required = true)
    protected String ipnUrl;
    @XmlElement(required = true)
    protected List<OrderItem> orderItem;

    /**
     * Default no-arg constructor
     * 
     */
    public SetupPaymentRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SetupPaymentRequest(final String returnUrl, final String cancelUrl, final String ipnUrl, final List<OrderItem> orderItem) {
        this.returnUrl = returnUrl;
        this.cancelUrl = cancelUrl;
        this.ipnUrl = ipnUrl;
        this.orderItem = orderItem;
    }

    /**
     * Gets the value of the returnUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * Sets the value of the returnUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnUrl(String value) {
        this.returnUrl = value;
    }

    /**
     * Gets the value of the cancelUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelUrl() {
        return cancelUrl;
    }

    /**
     * Sets the value of the cancelUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelUrl(String value) {
        this.cancelUrl = value;
    }

    /**
     * Gets the value of the ipnUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpnUrl() {
        return ipnUrl;
    }

    /**
     * Sets the value of the ipnUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpnUrl(String value) {
        this.ipnUrl = value;
    }

    /**
     * Gets the value of the orderItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderItem }
     * 
     * 
     */
    public List<OrderItem> getOrderItem() {
        if (orderItem == null) {
            orderItem = new ArrayList<OrderItem>();
        }
        return this.orderItem;
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
            String theReturnUrl;
            theReturnUrl = this.getReturnUrl();
            strategy.appendField(locator, this, "returnUrl", buffer, theReturnUrl);
        }
        {
            String theCancelUrl;
            theCancelUrl = this.getCancelUrl();
            strategy.appendField(locator, this, "cancelUrl", buffer, theCancelUrl);
        }
        {
            String theIpnUrl;
            theIpnUrl = this.getIpnUrl();
            strategy.appendField(locator, this, "ipnUrl", buffer, theIpnUrl);
        }
        {
            List<OrderItem> theOrderItem;
            theOrderItem = this.getOrderItem();
            strategy.appendField(locator, this, "orderItem", buffer, theOrderItem);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SetupPaymentRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SetupPaymentRequest that = ((SetupPaymentRequest) object);
        {
            String lhsReturnUrl;
            lhsReturnUrl = this.getReturnUrl();
            String rhsReturnUrl;
            rhsReturnUrl = that.getReturnUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "returnUrl", lhsReturnUrl), LocatorUtils.property(thatLocator, "returnUrl", rhsReturnUrl), lhsReturnUrl, rhsReturnUrl)) {
                return false;
            }
        }
        {
            String lhsCancelUrl;
            lhsCancelUrl = this.getCancelUrl();
            String rhsCancelUrl;
            rhsCancelUrl = that.getCancelUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cancelUrl", lhsCancelUrl), LocatorUtils.property(thatLocator, "cancelUrl", rhsCancelUrl), lhsCancelUrl, rhsCancelUrl)) {
                return false;
            }
        }
        {
            String lhsIpnUrl;
            lhsIpnUrl = this.getIpnUrl();
            String rhsIpnUrl;
            rhsIpnUrl = that.getIpnUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ipnUrl", lhsIpnUrl), LocatorUtils.property(thatLocator, "ipnUrl", rhsIpnUrl), lhsIpnUrl, rhsIpnUrl)) {
                return false;
            }
        }
        {
            List<OrderItem> lhsOrderItem;
            lhsOrderItem = this.getOrderItem();
            List<OrderItem> rhsOrderItem;
            rhsOrderItem = that.getOrderItem();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orderItem", lhsOrderItem), LocatorUtils.property(thatLocator, "orderItem", rhsOrderItem), lhsOrderItem, rhsOrderItem)) {
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
            String theReturnUrl;
            theReturnUrl = this.getReturnUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "returnUrl", theReturnUrl), currentHashCode, theReturnUrl);
        }
        {
            String theCancelUrl;
            theCancelUrl = this.getCancelUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cancelUrl", theCancelUrl), currentHashCode, theCancelUrl);
        }
        {
            String theIpnUrl;
            theIpnUrl = this.getIpnUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ipnUrl", theIpnUrl), currentHashCode, theIpnUrl);
        }
        {
            List<OrderItem> theOrderItem;
            theOrderItem = this.getOrderItem();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orderItem", theOrderItem), currentHashCode, theOrderItem);
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
        if (draftCopy instanceof SetupPaymentRequest) {
            final SetupPaymentRequest copy = ((SetupPaymentRequest) draftCopy);
            if (this.returnUrl!= null) {
                String sourceReturnUrl;
                sourceReturnUrl = this.getReturnUrl();
                String copyReturnUrl = ((String) strategy.copy(LocatorUtils.property(locator, "returnUrl", sourceReturnUrl), sourceReturnUrl));
                copy.setReturnUrl(copyReturnUrl);
            } else {
                copy.returnUrl = null;
            }
            if (this.cancelUrl!= null) {
                String sourceCancelUrl;
                sourceCancelUrl = this.getCancelUrl();
                String copyCancelUrl = ((String) strategy.copy(LocatorUtils.property(locator, "cancelUrl", sourceCancelUrl), sourceCancelUrl));
                copy.setCancelUrl(copyCancelUrl);
            } else {
                copy.cancelUrl = null;
            }
            if (this.ipnUrl!= null) {
                String sourceIpnUrl;
                sourceIpnUrl = this.getIpnUrl();
                String copyIpnUrl = ((String) strategy.copy(LocatorUtils.property(locator, "ipnUrl", sourceIpnUrl), sourceIpnUrl));
                copy.setIpnUrl(copyIpnUrl);
            } else {
                copy.ipnUrl = null;
            }
            if ((this.orderItem!= null)&&(!this.orderItem.isEmpty())) {
                List<OrderItem> sourceOrderItem;
                sourceOrderItem = this.getOrderItem();
                @SuppressWarnings("unchecked")
                List<OrderItem> copyOrderItem = ((List<OrderItem> ) strategy.copy(LocatorUtils.property(locator, "orderItem", sourceOrderItem), sourceOrderItem));
                copy.orderItem = null;
                List<OrderItem> uniqueOrderIteml = copy.getOrderItem();
                uniqueOrderIteml.addAll(copyOrderItem);
            } else {
                copy.orderItem = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SetupPaymentRequest();
    }

}
