//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.12 at 11:16:38 AM EST 
//


package AltruEventCalendarItemListListService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the AltruEventCalendarItemListListService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMoreRowsReply_QNAME = new QName("blackbaud_appfx_server_bizops", "GetMoreRowsReply");
    private final static QName _GetRowsReply_QNAME = new QName("blackbaud_appfx_server_bizops", "GetRowsReply");
    private final static QName _GetRowsRequest_QNAME = new QName("blackbaud_appfx_server_bizops", "GetRowsRequest");
    private final static QName _GetMoreRowsRequest_QNAME = new QName("blackbaud_appfx_server_bizops", "GetMoreRowsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: AltruEventCalendarItemListListService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SessionStartRequest }
     * 
     */
    public SessionStartRequest createSessionStartRequest() {
        return new SessionStartRequest();
    }

    /**
     * Create an instance of {@link BizOpsHourMinute }
     * 
     */
    public BizOpsHourMinute createBizOpsHourMinute() {
        return new BizOpsHourMinute();
    }

    /**
     * Create an instance of {@link GetAllRowsReply }
     * 
     */
    public GetAllRowsReply createGetAllRowsReply() {
        return new GetAllRowsReply();
    }

    /**
     * Create an instance of {@link GetMoreRowsReply }
     * 
     */
    public GetMoreRowsReply createGetMoreRowsReply() {
        return new GetMoreRowsReply();
    }

    /**
     * Create an instance of {@link GetRowsReply }
     * 
     */
    public GetRowsReply createGetRowsReply() {
        return new GetRowsReply();
    }

    /**
     * Create an instance of {@link BizOpsErrorDetail }
     * 
     */
    public BizOpsErrorDetail createBizOpsErrorDetail() {
        return new BizOpsErrorDetail();
    }

    /**
     * Create an instance of {@link GetAllRowsRequest }
     * 
     */
    public GetAllRowsRequest createGetAllRowsRequest() {
        return new GetAllRowsRequest();
    }

    /**
     * Create an instance of {@link ListRow }
     * 
     */
    public ListRow createListRow() {
        return new ListRow();
    }

    /**
     * Create an instance of {@link PingReply }
     * 
     */
    public PingReply createPingReply() {
        return new PingReply();
    }

    /**
     * Create an instance of {@link GetRowsRequest }
     * 
     */
    public GetRowsRequest createGetRowsRequest() {
        return new GetRowsRequest();
    }

    /**
     * Create an instance of {@link BizOpsSessionStartReply }
     * 
     */
    public BizOpsSessionStartReply createBizOpsSessionStartReply() {
        return new BizOpsSessionStartReply();
    }

    /**
     * Create an instance of {@link BizOpsRequestSecurityContext }
     * 
     */
    public BizOpsRequestSecurityContext createBizOpsRequestSecurityContext() {
        return new BizOpsRequestSecurityContext();
    }

    /**
     * Create an instance of {@link SessionStartReply }
     * 
     */
    public SessionStartReply createSessionStartReply() {
        return new SessionStartReply();
    }

    /**
     * Create an instance of {@link FilterData }
     * 
     */
    public FilterData createFilterData() {
        return new FilterData();
    }

    /**
     * Create an instance of {@link PingRequest }
     * 
     */
    public PingRequest createPingRequest() {
        return new PingRequest();
    }

    /**
     * Create an instance of {@link ArrayOfListRow }
     * 
     */
    public ArrayOfListRow createArrayOfListRow() {
        return new ArrayOfListRow();
    }

    /**
     * Create an instance of {@link SessionEndRequest }
     * 
     */
    public SessionEndRequest createSessionEndRequest() {
        return new SessionEndRequest();
    }

    /**
     * Create an instance of {@link GetMoreRowsRequest }
     * 
     */
    public GetMoreRowsRequest createGetMoreRowsRequest() {
        return new GetMoreRowsRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoreRowsReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "blackbaud_appfx_server_bizops", name = "GetMoreRowsReply")
    public JAXBElement<GetMoreRowsReply> createGetMoreRowsReply(GetMoreRowsReply value) {
        return new JAXBElement<GetMoreRowsReply>(_GetMoreRowsReply_QNAME, GetMoreRowsReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRowsReply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "blackbaud_appfx_server_bizops", name = "GetRowsReply")
    public JAXBElement<GetRowsReply> createGetRowsReply(GetRowsReply value) {
        return new JAXBElement<GetRowsReply>(_GetRowsReply_QNAME, GetRowsReply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRowsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "blackbaud_appfx_server_bizops", name = "GetRowsRequest")
    public JAXBElement<GetRowsRequest> createGetRowsRequest(GetRowsRequest value) {
        return new JAXBElement<GetRowsRequest>(_GetRowsRequest_QNAME, GetRowsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoreRowsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "blackbaud_appfx_server_bizops", name = "GetMoreRowsRequest")
    public JAXBElement<GetMoreRowsRequest> createGetMoreRowsRequest(GetMoreRowsRequest value) {
        return new JAXBElement<GetMoreRowsRequest>(_GetMoreRowsRequest_QNAME, GetMoreRowsRequest.class, null, value);
    }

}
