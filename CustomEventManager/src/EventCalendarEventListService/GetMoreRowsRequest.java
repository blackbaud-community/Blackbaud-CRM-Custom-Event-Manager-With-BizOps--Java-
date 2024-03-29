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
 * <p>Java class for GetMoreRowsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMoreRowsRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{blackbaud_appfx_server_bizops}BizOpsRequest">
 *       &lt;sequence>
 *         &lt;element name="DiscardRowsWhenComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MoreRowsRangeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartRowIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMoreRowsRequest", propOrder = {
    "discardRowsWhenComplete",
    "moreRowsRangeKey",
    "numRows",
    "startRowIndex"
})
public class GetMoreRowsRequest
    extends BizOpsRequest
{

    @XmlElement(name = "DiscardRowsWhenComplete", defaultValue = "false")
    protected Boolean discardRowsWhenComplete;
    @XmlElement(name = "MoreRowsRangeKey")
    protected String moreRowsRangeKey;
    @XmlElement(name = "NumRows")
    protected int numRows;
    @XmlElement(name = "StartRowIndex")
    protected int startRowIndex;

    /**
     * Gets the value of the discardRowsWhenComplete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiscardRowsWhenComplete() {
        return discardRowsWhenComplete;
    }

    /**
     * Sets the value of the discardRowsWhenComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiscardRowsWhenComplete(Boolean value) {
        this.discardRowsWhenComplete = value;
    }

    /**
     * Gets the value of the moreRowsRangeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoreRowsRangeKey() {
        return moreRowsRangeKey;
    }

    /**
     * Sets the value of the moreRowsRangeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoreRowsRangeKey(String value) {
        this.moreRowsRangeKey = value;
    }

    /**
     * Gets the value of the numRows property.
     * 
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Sets the value of the numRows property.
     * 
     */
    public void setNumRows(int value) {
        this.numRows = value;
    }

    /**
     * Gets the value of the startRowIndex property.
     * 
     */
    public int getStartRowIndex() {
        return startRowIndex;
    }

    /**
     * Sets the value of the startRowIndex property.
     * 
     */
    public void setStartRowIndex(int value) {
        this.startRowIndex = value;
    }

}
