//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:38 AM EST 
//


package AltruEventCalendarItemListListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ListRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STARTDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="STARTTIME" type="{blackbaud_appfx_server_bizops}BizOpsHourMinute" minOccurs="0"/>
 *         &lt;element name="ENDDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ENDTIME" type="{blackbaud_appfx_server_bizops}BizOpsHourMinute" minOccurs="0"/>
 *         &lt;element name="TYPECODE" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListRow", propOrder = {
    "id",
    "name",
    "startdate",
    "starttime",
    "enddate",
    "endtime",
    "typecode",
    "description"
})
public class ListRow {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "NAME")
    protected String name;
    @XmlElement(name = "STARTDATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdate;
    @XmlElement(name = "STARTTIME")
    protected BizOpsHourMinute starttime;
    @XmlElement(name = "ENDDATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enddate;
    @XmlElement(name = "ENDTIME")
    protected BizOpsHourMinute endtime;
    @XmlElement(name = "TYPECODE")
    @XmlSchemaType(name = "unsignedByte")
    protected short typecode;
    @XmlElement(name = "DESCRIPTION")
    protected String description;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
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
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the startdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTARTDATE() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTARTDATE(XMLGregorianCalendar value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the starttime property.
     * 
     * @return
     *     possible object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public BizOpsHourMinute getSTARTTIME() {
        return starttime;
    }

    /**
     * Sets the value of the starttime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public void setSTARTTIME(BizOpsHourMinute value) {
        this.starttime = value;
    }

    /**
     * Gets the value of the enddate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getENDDATE() {
        return enddate;
    }

    /**
     * Sets the value of the enddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setENDDATE(XMLGregorianCalendar value) {
        this.enddate = value;
    }

    /**
     * Gets the value of the endtime property.
     * 
     * @return
     *     possible object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public BizOpsHourMinute getENDTIME() {
        return endtime;
    }

    /**
     * Sets the value of the endtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public void setENDTIME(BizOpsHourMinute value) {
        this.endtime = value;
    }

    /**
     * Gets the value of the typecode property.
     * 
     */
    public short getTYPECODE() {
        return typecode;
    }

    /**
     * Sets the value of the typecode property.
     * 
     */
    public void setTYPECODE(short value) {
        this.typecode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
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
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

}
