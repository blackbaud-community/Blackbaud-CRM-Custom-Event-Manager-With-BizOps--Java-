//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:42 AM EST 
//


package EventExpenseDeleteRecordOperation;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceErrorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceErrorCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GeneralError"/>
 *     &lt;enumeration value="AccessDenied"/>
 *     &lt;enumeration value="InvalidAppDatabaseName"/>
 *     &lt;enumeration value="InvalidRequest"/>
 *     &lt;enumeration value="BadWebConfig"/>
 *     &lt;enumeration value="DbTransactionOutOfSync"/>
 *     &lt;enumeration value="DbConnectionError"/>
 *     &lt;enumeration value="DataFormError"/>
 *     &lt;enumeration value="BadMetaData"/>
 *     &lt;enumeration value="ServiceExecutionError"/>
 *     &lt;enumeration value="BusinessProcessError"/>
 *     &lt;enumeration value="InvalidAPIUse"/>
 *     &lt;enumeration value="DatabaseRevisionMismatch"/>
 *     &lt;enumeration value="InvalidSiteInfoID"/>
 *     &lt;enumeration value="InvalidProductIsHash"/>
 *     &lt;enumeration value="ProductListNotLoaded"/>
 *     &lt;enumeration value="TimeoutError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceErrorCode")
@XmlEnum
public enum ServiceErrorCode {

    @XmlEnumValue("GeneralError")
    GENERAL_ERROR("GeneralError"),
    @XmlEnumValue("AccessDenied")
    ACCESS_DENIED("AccessDenied"),
    @XmlEnumValue("InvalidAppDatabaseName")
    INVALID_APP_DATABASE_NAME("InvalidAppDatabaseName"),
    @XmlEnumValue("InvalidRequest")
    INVALID_REQUEST("InvalidRequest"),
    @XmlEnumValue("BadWebConfig")
    BAD_WEB_CONFIG("BadWebConfig"),
    @XmlEnumValue("DbTransactionOutOfSync")
    DB_TRANSACTION_OUT_OF_SYNC("DbTransactionOutOfSync"),
    @XmlEnumValue("DbConnectionError")
    DB_CONNECTION_ERROR("DbConnectionError"),
    @XmlEnumValue("DataFormError")
    DATA_FORM_ERROR("DataFormError"),
    @XmlEnumValue("BadMetaData")
    BAD_META_DATA("BadMetaData"),
    @XmlEnumValue("ServiceExecutionError")
    SERVICE_EXECUTION_ERROR("ServiceExecutionError"),
    @XmlEnumValue("BusinessProcessError")
    BUSINESS_PROCESS_ERROR("BusinessProcessError"),
    @XmlEnumValue("InvalidAPIUse")
    INVALID_API_USE("InvalidAPIUse"),
    @XmlEnumValue("DatabaseRevisionMismatch")
    DATABASE_REVISION_MISMATCH("DatabaseRevisionMismatch"),
    @XmlEnumValue("InvalidSiteInfoID")
    INVALID_SITE_INFO_ID("InvalidSiteInfoID"),
    @XmlEnumValue("InvalidProductIsHash")
    INVALID_PRODUCT_IS_HASH("InvalidProductIsHash"),
    @XmlEnumValue("ProductListNotLoaded")
    PRODUCT_LIST_NOT_LOADED("ProductListNotLoaded"),
    @XmlEnumValue("TimeoutError")
    TIMEOUT_ERROR("TimeoutError");
    private final String value;

    ServiceErrorCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceErrorCode fromValue(String v) {
        for (ServiceErrorCode c: ServiceErrorCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
