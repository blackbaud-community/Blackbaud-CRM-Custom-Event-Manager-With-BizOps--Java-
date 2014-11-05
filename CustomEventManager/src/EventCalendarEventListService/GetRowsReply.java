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
 * <p>Java class for GetRowsReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRowsReply">
 *   &lt;complexContent>
 *     &lt;extension base="{blackbaud_appfx_server_bizops}BizOpsReply">
 *       &lt;sequence>
 *         &lt;element name="TotalAvailableRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalRowsInReply" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rows" type="{blackbaud_appfx_server_bizops}ArrayOfListRow" minOccurs="0"/>
 *         &lt;element name="MoreRowsRangeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRowsReply", propOrder = {
    "totalAvailableRows",
    "totalRowsInReply",
    "rows",
    "moreRowsRangeKey"
})
public class GetRowsReply
    extends BizOpsReply
{

    @XmlElement(name = "TotalAvailableRows")
    protected int totalAvailableRows;
    @XmlElement(name = "TotalRowsInReply")
    protected int totalRowsInReply;
    @XmlElement(name = "Rows")
    protected ArrayOfListRow rows;
    @XmlElement(name = "MoreRowsRangeKey")
    protected String moreRowsRangeKey;

    /**
     * Gets the value of the totalAvailableRows property.
     * 
     */
    public int getTotalAvailableRows() {
        return totalAvailableRows;
    }

    /**
     * Sets the value of the totalAvailableRows property.
     * 
     */
    public void setTotalAvailableRows(int value) {
        this.totalAvailableRows = value;
    }

    /**
     * Gets the value of the totalRowsInReply property.
     * 
     */
    public int getTotalRowsInReply() {
        return totalRowsInReply;
    }

    /**
     * Sets the value of the totalRowsInReply property.
     * 
     */
    public void setTotalRowsInReply(int value) {
        this.totalRowsInReply = value;
    }

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

}
