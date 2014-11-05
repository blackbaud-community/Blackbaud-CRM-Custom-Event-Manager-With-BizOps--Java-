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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMoreRowsReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMoreRowsReply">
 *   &lt;complexContent>
 *     &lt;extension base="{blackbaud_appfx_server_bizops}BizOpsReply">
 *       &lt;sequence>
 *         &lt;element name="Rows" type="{blackbaud_appfx_server_bizops}ArrayOfListRow" minOccurs="0"/>
 *         &lt;element name="DataNoLongerAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMoreRowsReply", propOrder = {
    "rows",
    "dataNoLongerAvailable"
})
public class GetMoreRowsReply
    extends BizOpsReply
{

    @XmlElement(name = "Rows")
    protected ArrayOfListRow rows;
    @XmlElement(name = "DataNoLongerAvailable", defaultValue = "false")
    protected Boolean dataNoLongerAvailable;

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfListRow }
     *     
     */
    public ArrayOfListRow getRows() {
        return rows;
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfListRow }
     *     
     */
    public void setRows(ArrayOfListRow value) {
        this.rows = value;
    }

    /**
     * Gets the value of the dataNoLongerAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDataNoLongerAvailable() {
        return dataNoLongerAvailable;
    }

    /**
     * Sets the value of the dataNoLongerAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDataNoLongerAvailable(Boolean value) {
        this.dataNoLongerAvailable = value;
    }

}
