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
 * <p>Java class for SecurityQuestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityQuestion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Answer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityQuestion", propOrder = {
    "questionId",
    "description",
    "answer"
})
public class SecurityQuestion implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    protected String description;
    @XmlElement(name = "Answer")
    protected String answer;

    /**
     * Default no-arg constructor
     * 
     */
    public SecurityQuestion() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SecurityQuestion(final Integer questionId, final String description, final String answer) {
        this.questionId = questionId;
        this.description = description;
        this.answer = answer;
    }

    /**
     * Gets the value of the questionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * Sets the value of the questionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionId(Integer value) {
        this.questionId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the answer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the value of the answer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswer(String value) {
        this.answer = value;
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
            Integer theQuestionId;
            theQuestionId = this.getQuestionId();
            strategy.appendField(locator, this, "questionId", buffer, theQuestionId);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            String theAnswer;
            theAnswer = this.getAnswer();
            strategy.appendField(locator, this, "answer", buffer, theAnswer);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SecurityQuestion)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SecurityQuestion that = ((SecurityQuestion) object);
        {
            Integer lhsQuestionId;
            lhsQuestionId = this.getQuestionId();
            Integer rhsQuestionId;
            rhsQuestionId = that.getQuestionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "questionId", lhsQuestionId), LocatorUtils.property(thatLocator, "questionId", rhsQuestionId), lhsQuestionId, rhsQuestionId)) {
                return false;
            }
        }
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            String lhsAnswer;
            lhsAnswer = this.getAnswer();
            String rhsAnswer;
            rhsAnswer = that.getAnswer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "answer", lhsAnswer), LocatorUtils.property(thatLocator, "answer", rhsAnswer), lhsAnswer, rhsAnswer)) {
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
            Integer theQuestionId;
            theQuestionId = this.getQuestionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "questionId", theQuestionId), currentHashCode, theQuestionId);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            String theAnswer;
            theAnswer = this.getAnswer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "answer", theAnswer), currentHashCode, theAnswer);
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
        if (draftCopy instanceof SecurityQuestion) {
            final SecurityQuestion copy = ((SecurityQuestion) draftCopy);
            if (this.questionId!= null) {
                Integer sourceQuestionId;
                sourceQuestionId = this.getQuestionId();
                Integer copyQuestionId = ((Integer) strategy.copy(LocatorUtils.property(locator, "questionId", sourceQuestionId), sourceQuestionId));
                copy.setQuestionId(copyQuestionId);
            } else {
                copy.questionId = null;
            }
            if (this.description!= null) {
                String sourceDescription;
                sourceDescription = this.getDescription();
                String copyDescription = ((String) strategy.copy(LocatorUtils.property(locator, "description", sourceDescription), sourceDescription));
                copy.setDescription(copyDescription);
            } else {
                copy.description = null;
            }
            if (this.answer!= null) {
                String sourceAnswer;
                sourceAnswer = this.getAnswer();
                String copyAnswer = ((String) strategy.copy(LocatorUtils.property(locator, "answer", sourceAnswer), sourceAnswer));
                copy.setAnswer(copyAnswer);
            } else {
                copy.answer = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SecurityQuestion();
    }

}
