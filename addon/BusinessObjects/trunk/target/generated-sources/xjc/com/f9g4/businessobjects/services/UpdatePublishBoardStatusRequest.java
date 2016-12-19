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
 * <p>Java class for UpdatePublishBoardStatusRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePublishBoardStatusRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boards" type="{http://domain.businessobjects.f9g4.com}trBoardDomain" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdatePublishBoardStatusRequest", propOrder = {
    "boards"
})
@XmlRootElement(name = "UpdatePublishBoardStatusRequest")
public class UpdatePublishBoardStatusRequest implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<TrBoardDomain> boards;

    /**
     * Default no-arg constructor
     * 
     */
    public UpdatePublishBoardStatusRequest() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public UpdatePublishBoardStatusRequest(final List<TrBoardDomain> boards) {
        this.boards = boards;
    }

    /**
     * Gets the value of the boards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrBoardDomain }
     * 
     * 
     */
    public List<TrBoardDomain> getBoards() {
        if (boards == null) {
            boards = new ArrayList<TrBoardDomain>();
        }
        return this.boards;
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
            List<TrBoardDomain> theBoards;
            theBoards = this.getBoards();
            strategy.appendField(locator, this, "boards", buffer, theBoards);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UpdatePublishBoardStatusRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UpdatePublishBoardStatusRequest that = ((UpdatePublishBoardStatusRequest) object);
        {
            List<TrBoardDomain> lhsBoards;
            lhsBoards = this.getBoards();
            List<TrBoardDomain> rhsBoards;
            rhsBoards = that.getBoards();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "boards", lhsBoards), LocatorUtils.property(thatLocator, "boards", rhsBoards), lhsBoards, rhsBoards)) {
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
            List<TrBoardDomain> theBoards;
            theBoards = this.getBoards();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boards", theBoards), currentHashCode, theBoards);
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
        if (draftCopy instanceof UpdatePublishBoardStatusRequest) {
            final UpdatePublishBoardStatusRequest copy = ((UpdatePublishBoardStatusRequest) draftCopy);
            if ((this.boards!= null)&&(!this.boards.isEmpty())) {
                List<TrBoardDomain> sourceBoards;
                sourceBoards = this.getBoards();
                @SuppressWarnings("unchecked")
                List<TrBoardDomain> copyBoards = ((List<TrBoardDomain> ) strategy.copy(LocatorUtils.property(locator, "boards", sourceBoards), sourceBoards));
                copy.boards = null;
                List<TrBoardDomain> uniqueBoardsl = copy.getBoards();
                uniqueBoardsl.addAll(copyBoards);
            } else {
                copy.boards = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new UpdatePublishBoardStatusRequest();
    }

}
