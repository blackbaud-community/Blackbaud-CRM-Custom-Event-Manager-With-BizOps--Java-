//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 12:58:05 PM EST 
//


package EventExpenseType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTableEntryListRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTableEntryListRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TableEntryListRow" type="{blackbaud_appfx_server_bizops}TableEntryListRow" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTableEntryListRow", propOrder = {
    "tableEntryListRow"
})
public class ArrayOfTableEntryListRow {

    @XmlElement(name = "TableEntryListRow", nillable = true)
    protected List<TableEntryListRow> tableEntryListRow;

    /**
     * Gets the value of the tableEntryListRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableEntryListRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTableEntryListRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TableEntryListRow }
     * 
     * 
     */
    public List<TableEntryListRow> getTableEntryListRow() {
        if (tableEntryListRow == null) {
            tableEntryListRow = new ArrayList<TableEntryListRow>();
        }
        return this.tableEntryListRow;
    }

}