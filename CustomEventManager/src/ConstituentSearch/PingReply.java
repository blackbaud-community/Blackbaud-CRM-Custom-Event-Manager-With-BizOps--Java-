//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:44 AM EST 
//


package ConstituentSearch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pingMessageOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pingMessageOut"
})
@XmlRootElement(name = "PingReply")
public class PingReply {

    protected String pingMessageOut;

    /**
     * Gets the value of the pingMessageOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPingMessageOut() {
        return pingMessageOut;
    }

    /**
     * Sets the value of the pingMessageOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPingMessageOut(String value) {
        this.pingMessageOut = value;
    }

}
