/**
 * AppWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pmcg.imti.view.ws;



public class AppWSServiceLocator extends org.apache.axis.client.Service implements pmcg.imti.view.ws.AppWSService {

    public AppWSServiceLocator() {
    }


    public AppWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AppWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceGTM
    //TESTE
//    private java.lang.String WebServiceGTM_address = "http://172.17.0.43:8180/dsf_cgr_gtm/services/WebServiceGTM";

    //PRODUÇÃO
    //private java.lang.String WebServiceGTM_address = "http://172.17.0.66/dsf_cgr_gtm/services/WebServiceGTM";
    private java.lang.String WebServiceGTM_address = "http://siat.pmcg.ms.gov.br/dsf_cgr_gtm/services/WebServiceGTM";
//    private java.lang.String WebServiceGTM_address = new CfgDAO().getValorByParam("URL_WS_GUIA_PAG");

    public java.lang.String getWebServiceGTMAddress() {
        return WebServiceGTM_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceGTMWSDDServiceName = "WebServiceGTM";

    public java.lang.String getWebServiceGTMWSDDServiceName() {
        return WebServiceGTMWSDDServiceName;
    }

    public void setWebServiceGTMWSDDServiceName(java.lang.String name) {
        WebServiceGTMWSDDServiceName = name;
    }

    public pmcg.imti.view.ws.AppWS getWebServiceGTM() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceGTM_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceGTM(endpoint);
    }

    public pmcg.imti.view.ws.AppWS getWebServiceGTM(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pmcg.imti.view.ws.WebServiceGTMSoapBindingStub _stub = new pmcg.imti.view.ws.WebServiceGTMSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceGTMWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceGTMEndpointAddress(java.lang.String address) {
        WebServiceGTM_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pmcg.imti.view.ws.AppWS.class.isAssignableFrom(serviceEndpointInterface)) {
                pmcg.imti.view.ws.WebServiceGTMSoapBindingStub _stub = new pmcg.imti.view.ws.WebServiceGTMSoapBindingStub(new java.net.URL(WebServiceGTM_address), this);
                _stub.setPortName(getWebServiceGTMWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceGTM".equals(inputPortName)) {
            return getWebServiceGTM();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:WebServiceGTM", "AppWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:WebServiceGTM", "WebServiceGTM"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceGTM".equals(portName)) {
            setWebServiceGTMEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
