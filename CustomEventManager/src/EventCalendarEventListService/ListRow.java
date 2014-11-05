//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:40 AM EST 
//


package EventCalendarEventListService;

import java.math.BigDecimal;
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
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Start_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Start_time" type="{blackbaud_appfx_server_bizops}BizOpsHourMinute" minOccurs="0"/>
 *         &lt;element name="End_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="End_time" type="{blackbaud_appfx_server_bizops}BizOpsHourMinute" minOccurs="0"/>
 *         &lt;element name="No_of_registrants" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Budgeted_amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Actual_amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Main_event" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BASECURRENCYID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="ISFRIENDSASKINGFRIENDS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "startDate",
    "startTime",
    "endDate",
    "endTime",
    "noOfRegistrants",
    "budgetedAmount",
    "actualAmount",
    "mainEvent",
    "basecurrencyid",
    "isfriendsaskingfriends"
})
public class ListRow {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Start_date", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "Start_time")
    protected BizOpsHourMinute startTime;
    @XmlElement(name = "End_date", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "End_time")
    protected BizOpsHourMinute endTime;
    @XmlElement(name = "No_of_registrants")
    protected int noOfRegistrants;
    @XmlElement(name = "Budgeted_amount", required = true)
    protected BigDecimal budgetedAmount;
    @XmlElement(name = "Actual_amount", required = true)
    protected BigDecimal actualAmount;
    @XmlElement(name = "Main_event")
    protected String mainEvent;
    @XmlElement(name = "BASECURRENCYID", required = true)
    protected String basecurrencyid;
    @XmlElement(name = "ISFRIENDSASKINGFRIENDS")
    protected boolean isfriendsaskingfriends;

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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public BizOpsHourMinute getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public void setStartTime(BizOpsHourMinute value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public BizOpsHourMinute getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BizOpsHourMinute }
     *     
     */
    public void setEndTime(BizOpsHourMinute value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the noOfRegistrants property.
     * 
     */
    public int getNoOfRegistrants() {
        return noOfRegistrants;
    }

    /**
     * Sets the value of the noOfRegistrants property.
     * 
     */
    public void setNoOfRegistrants(int value) {
        this.noOfRegistrants = value;
    }

    /**
     * Gets the value of the budgetedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBudgetedAmount() {
        return budgetedAmount;
    }

    /**
     * Sets the value of the budgetedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBudgetedAmount(BigDecimal value) {
        this.budgetedAmount = value;
    }

    /**
     * Gets the value of the actualAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * Sets the value of the actualAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualAmount(BigDecimal value) {
        this.actualAmount = value;
    }

    /**
     * Gets the value of the mainEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainEvent() {
        return mainEvent;
    }

    /**
     * Sets the value of the mainEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainEvent(String value) {
        this.mainEvent = value;
    }

    /**
     * Gets the value of the basecurrencyid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBASECURRENCYID() {
        return basecurrencyid;
    }

    /**
     * Sets the value of the basecurrencyid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBASECURRENCYID(String value) {
        this.basecurrencyid = value;
    }

    /**
     * Gets the value of the isfriendsaskingfriends property.
     * 
     */
    public boolean isISFRIENDSASKINGFRIENDS() {
        return isfriendsaskingfriends;
    }

    /**
     * Sets the value of the isfriendsaskingfriends property.
     * 
     */
    public void setISFRIENDSASKINGFRIENDS(boolean value) {
        this.isfriendsaskingfriends = value;
    }

}
