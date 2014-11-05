//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:42 AM EST 
//


package EventExpenseAddRecordOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetDefaultDataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDefaultDataRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{blackbaud_appfx_server_bizops}BizOpsRequest">
 *       &lt;sequence>
 *         &lt;element name="ContextRecordID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExcludeValueTranslations" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SecurityContext" type="{blackbaud_appfx_server_bizops}BizOpsRequestSecurityContext" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDefaultDataRequest", propOrder = {
    "contextRecordID",
    "excludeValueTranslations",
    "securityContext"
})
public class GetDefaultDataRequest
    extends BizOpsRequest
{

    @XmlElement(name = "ContextRecordID")
    protected String contextRecordID;
    @XmlElement(name = "ExcludeValueTranslations", defaultValue = "false")
    protected Boolean excludeValueTranslations;
    @XmlElement(name = "SecurityContext")
    protected BizOpsRequestSecurityContext securityContext;

    /**
     * Gets the value of the contextRecordID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextRecordID() {
        return contextRecordID;
    }

    /**
     * Sets the value of the contextRecordID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextRecordID(String value) {
        this.contextRecordID = value;
    }

    /**
     * Gets the value of the excludeValueTranslations property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExcludeValueTranslations() {
        return excludeValueTranslations;
    }

    /**
     * Sets the value of the excludeValueTranslations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludeValueTranslations(Boolean value) {
        this.excludeValueTranslations = value;
    }

    /**
     * Gets the value of the securityContext property.
     * 
     * @return
     *     possible object is
     *     {@link BizOpsRequestSecurityContext }
     *     
     */
    public BizOpsRequestSecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * Sets the value of the securityContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link BizOpsRequestSecurityContext }
     *     
     */
    public void setSecurityContext(BizOpsRequestSecurityContext value) {
        this.securityContext = value;
    }

}
