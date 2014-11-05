//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:40 AM EST 
//


package EventCalendarEventListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DATEFILTER" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="INCLUDEINACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ONLYSHOWUSERSEVENTS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SITEID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="EVENTCATEGORYCODEID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="EVENTLOCATIONID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="HIDEEVENTS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterData", propOrder = {
    "datefilter",
    "includeinactive",
    "onlyshowusersevents",
    "siteid",
    "eventcategorycodeid",
    "eventlocationid",
    "hideevents"
})
public class FilterData {

    @XmlElement(name = "DATEFILTER", required = true, type = Short.class, nillable = true)
    @XmlSchemaType(name = "unsignedByte")
    protected Short datefilter;
    @XmlElement(name = "INCLUDEINACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean includeinactive;
    @XmlElement(name = "ONLYSHOWUSERSEVENTS", required = true, type = Boolean.class, nillable = true)
    protected Boolean onlyshowusersevents;
    @XmlElement(name = "SITEID", required = true, nillable = true)
    protected String siteid;
    @XmlElement(name = "EVENTCATEGORYCODEID", required = true, nillable = true)
    protected String eventcategorycodeid;
    @XmlElement(name = "EVENTLOCATIONID", required = true, nillable = true)
    protected String eventlocationid;
    @XmlElement(name = "HIDEEVENTS", required = true, type = Boolean.class, nillable = true)
    protected Boolean hideevents;

    /**
     * Gets the value of the datefilter property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDATEFILTER() {
        return datefilter;
    }

    /**
     * Sets the value of the datefilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDATEFILTER(Short value) {
        this.datefilter = value;
    }

    /**
     * Gets the value of the includeinactive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isINCLUDEINACTIVE() {
        return includeinactive;
    }

    /**
     * Sets the value of the includeinactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setINCLUDEINACTIVE(Boolean value) {
        this.includeinactive = value;
    }

    /**
     * Gets the value of the onlyshowusersevents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isONLYSHOWUSERSEVENTS() {
        return onlyshowusersevents;
    }

    /**
     * Sets the value of the onlyshowusersevents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setONLYSHOWUSERSEVENTS(Boolean value) {
        this.onlyshowusersevents = value;
    }

    /**
     * Gets the value of the siteid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEID(String value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the eventcategorycodeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTCATEGORYCODEID() {
        return eventcategorycodeid;
    }

    /**
     * Sets the value of the eventcategorycodeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTCATEGORYCODEID(String value) {
        this.eventcategorycodeid = value;
    }

    /**
     * Gets the value of the eventlocationid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTLOCATIONID() {
        return eventlocationid;
    }

    /**
     * Sets the value of the eventlocationid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTLOCATIONID(String value) {
        this.eventlocationid = value;
    }

    /**
     * Gets the value of the hideevents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHIDEEVENTS() {
        return hideevents;
    }

    /**
     * Sets the value of the hideevents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHIDEEVENTS(Boolean value) {
        this.hideevents = value;
    }

}
