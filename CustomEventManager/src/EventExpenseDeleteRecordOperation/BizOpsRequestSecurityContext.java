//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:42 AM EST 
//


package EventExpenseDeleteRecordOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BizOpsRequestSecurityContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BizOpsRequestSecurityContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SecurityFeatureType" type="{blackbaud_appfx_server_bizops}SecurityFeatureType" minOccurs="0"/>
 *         &lt;element name="SecurityFeatureID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="RecordContextRecordID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecordContextRecordType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BizOpsRequestSecurityContext", propOrder = {
    "securityFeatureType",
    "securityFeatureID",
    "recordContextRecordID",
    "recordContextRecordType"
})
public class BizOpsRequestSecurityContext {

    @XmlElement(name = "SecurityFeatureType", defaultValue = "None")
    protected SecurityFeatureType securityFeatureType;
    @XmlElement(name = "SecurityFeatureID", required = true)
    protected String securityFeatureID;
    @XmlElement(name = "RecordContextRecordID")
    protected String recordContextRecordID;
    @XmlElement(name = "RecordContextRecordType")
    protected String recordContextRecordType;

    /**
     * Gets the value of the securityFeatureType property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityFeatureType }
     *     
     */
    public SecurityFeatureType getSecurityFeatureType() {
        return securityFeatureType;
    }

    /**
     * Sets the value of the securityFeatureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityFeatureType }
     *     
     */
    public void setSecurityFeatureType(SecurityFeatureType value) {
        this.securityFeatureType = value;
    }

    /**
     * Gets the value of the securityFeatureID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityFeatureID() {
        return securityFeatureID;
    }

    /**
     * Sets the value of the securityFeatureID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityFeatureID(String value) {
        this.securityFeatureID = value;
    }

    /**
     * Gets the value of the recordContextRecordID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordContextRecordID() {
        return recordContextRecordID;
    }

    /**
     * Sets the value of the recordContextRecordID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordContextRecordID(String value) {
        this.recordContextRecordID = value;
    }

    /**
     * Gets the value of the recordContextRecordType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordContextRecordType() {
        return recordContextRecordType;
    }

    /**
     * Sets the value of the recordContextRecordType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordContextRecordType(String value) {
        this.recordContextRecordType = value;
    }

}
