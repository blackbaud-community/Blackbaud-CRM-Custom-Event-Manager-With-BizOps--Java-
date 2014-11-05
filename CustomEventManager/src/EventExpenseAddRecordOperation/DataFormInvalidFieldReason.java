//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:42 AM EST 
//


package EventExpenseAddRecordOperation;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataFormInvalidFieldReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataFormInvalidFieldReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RequiredFldMissing"/>
 *     &lt;enumeration value="DataTooLong"/>
 *     &lt;enumeration value="InvalidDataFormat"/>
 *     &lt;enumeration value="ValueGreaterThanMax"/>
 *     &lt;enumeration value="ValueLessThanMin"/>
 *     &lt;enumeration value="DataNotUnique"/>
 *     &lt;enumeration value="InvalidCodeTableEntry"/>
 *     &lt;enumeration value="DBForeignKeyFailure"/>
 *     &lt;enumeration value="DBConstraintFailure"/>
 *     &lt;enumeration value="CustomException"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DataFormInvalidFieldReason")
@XmlEnum
public enum DataFormInvalidFieldReason {

    @XmlEnumValue("RequiredFldMissing")
    REQUIRED_FLD_MISSING("RequiredFldMissing"),
    @XmlEnumValue("DataTooLong")
    DATA_TOO_LONG("DataTooLong"),
    @XmlEnumValue("InvalidDataFormat")
    INVALID_DATA_FORMAT("InvalidDataFormat"),
    @XmlEnumValue("ValueGreaterThanMax")
    VALUE_GREATER_THAN_MAX("ValueGreaterThanMax"),
    @XmlEnumValue("ValueLessThanMin")
    VALUE_LESS_THAN_MIN("ValueLessThanMin"),
    @XmlEnumValue("DataNotUnique")
    DATA_NOT_UNIQUE("DataNotUnique"),
    @XmlEnumValue("InvalidCodeTableEntry")
    INVALID_CODE_TABLE_ENTRY("InvalidCodeTableEntry"),
    @XmlEnumValue("DBForeignKeyFailure")
    DB_FOREIGN_KEY_FAILURE("DBForeignKeyFailure"),
    @XmlEnumValue("DBConstraintFailure")
    DB_CONSTRAINT_FAILURE("DBConstraintFailure"),
    @XmlEnumValue("CustomException")
    CUSTOM_EXCEPTION("CustomException");
    private final String value;

    DataFormInvalidFieldReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataFormInvalidFieldReason fromValue(String v) {
        for (DataFormInvalidFieldReason c: DataFormInvalidFieldReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
