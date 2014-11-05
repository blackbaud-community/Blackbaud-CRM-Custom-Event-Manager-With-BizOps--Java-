//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:43 AM EST 
//


package EventExpenseEditRecordOperation;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityFeatureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SecurityFeatureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Form"/>
 *     &lt;enumeration value="DataList"/>
 *     &lt;enumeration value="RecordOperation"/>
 *     &lt;enumeration value="BusinessProcess"/>
 *     &lt;enumeration value="Dashboard"/>
 *     &lt;enumeration value="SearchList"/>
 *     &lt;enumeration value="SimpleDataList"/>
 *     &lt;enumeration value="Task"/>
 *     &lt;enumeration value="SmartQuery"/>
 *     &lt;enumeration value="AdHocQueryView"/>
 *     &lt;enumeration value="BatchType"/>
 *     &lt;enumeration value="AddCodeTableEntry"/>
 *     &lt;enumeration value="UpdateCodeTableEntry"/>
 *     &lt;enumeration value="DeleteCodeTableEntry"/>
 *     &lt;enumeration value="Batch"/>
 *     &lt;enumeration value="BatchTemplate"/>
 *     &lt;enumeration value="Kpi"/>
 *     &lt;enumeration value="MergeTask"/>
 *     &lt;enumeration value="SmartField"/>
 *     &lt;enumeration value="GlobalChange"/>
 *     &lt;enumeration value="ReportParameter"/>
 *     &lt;enumeration value="SystemPrivilege"/>
 *     &lt;enumeration value="ConfigurationData"/>
 *     &lt;enumeration value="BatchTemplateCustomize"/>
 *     &lt;enumeration value="BatchProcessor"/>
 *     &lt;enumeration value="Page"/>
 *     &lt;enumeration value="MapEntity"/>
 *     &lt;enumeration value="ExportDefinition"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SecurityFeatureType")
@XmlEnum
public enum SecurityFeatureType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Form")
    FORM("Form"),
    @XmlEnumValue("DataList")
    DATA_LIST("DataList"),
    @XmlEnumValue("RecordOperation")
    RECORD_OPERATION("RecordOperation"),
    @XmlEnumValue("BusinessProcess")
    BUSINESS_PROCESS("BusinessProcess"),
    @XmlEnumValue("Dashboard")
    DASHBOARD("Dashboard"),
    @XmlEnumValue("SearchList")
    SEARCH_LIST("SearchList"),
    @XmlEnumValue("SimpleDataList")
    SIMPLE_DATA_LIST("SimpleDataList"),
    @XmlEnumValue("Task")
    TASK("Task"),
    @XmlEnumValue("SmartQuery")
    SMART_QUERY("SmartQuery"),
    @XmlEnumValue("AdHocQueryView")
    AD_HOC_QUERY_VIEW("AdHocQueryView"),
    @XmlEnumValue("BatchType")
    BATCH_TYPE("BatchType"),
    @XmlEnumValue("AddCodeTableEntry")
    ADD_CODE_TABLE_ENTRY("AddCodeTableEntry"),
    @XmlEnumValue("UpdateCodeTableEntry")
    UPDATE_CODE_TABLE_ENTRY("UpdateCodeTableEntry"),
    @XmlEnumValue("DeleteCodeTableEntry")
    DELETE_CODE_TABLE_ENTRY("DeleteCodeTableEntry"),
    @XmlEnumValue("Batch")
    BATCH("Batch"),
    @XmlEnumValue("BatchTemplate")
    BATCH_TEMPLATE("BatchTemplate"),
    @XmlEnumValue("Kpi")
    KPI("Kpi"),
    @XmlEnumValue("MergeTask")
    MERGE_TASK("MergeTask"),
    @XmlEnumValue("SmartField")
    SMART_FIELD("SmartField"),
    @XmlEnumValue("GlobalChange")
    GLOBAL_CHANGE("GlobalChange"),
    @XmlEnumValue("ReportParameter")
    REPORT_PARAMETER("ReportParameter"),
    @XmlEnumValue("SystemPrivilege")
    SYSTEM_PRIVILEGE("SystemPrivilege"),
    @XmlEnumValue("ConfigurationData")
    CONFIGURATION_DATA("ConfigurationData"),
    @XmlEnumValue("BatchTemplateCustomize")
    BATCH_TEMPLATE_CUSTOMIZE("BatchTemplateCustomize"),
    @XmlEnumValue("BatchProcessor")
    BATCH_PROCESSOR("BatchProcessor"),
    @XmlEnumValue("Page")
    PAGE("Page"),
    @XmlEnumValue("MapEntity")
    MAP_ENTITY("MapEntity"),
    @XmlEnumValue("ExportDefinition")
    EXPORT_DEFINITION("ExportDefinition");
    private final String value;

    SecurityFeatureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SecurityFeatureType fromValue(String v) {
        for (SecurityFeatureType c: SecurityFeatureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
