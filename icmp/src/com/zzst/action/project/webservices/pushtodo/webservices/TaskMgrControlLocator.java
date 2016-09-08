/**
 * TaskMgrControlLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zzst.action.project.webservices.pushtodo.webservices;

import com.zzst.action.meeting.util.MeetingAppConfig;

public class TaskMgrControlLocator extends org.apache.axis.client.Service implements com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControl {

    public TaskMgrControlLocator() {
    }


    public TaskMgrControlLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaskMgrControlLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaskMgrControlHttpPort
//    private java.lang.String TaskMgrControlHttpPort_address = "http://192.168.129.38:9080/UnionTask/services/TaskMgrControl?wsdl";
    private java.lang.String TaskMgrControlHttpPort_address = "";//MeetingAppConfig.zh_Task_address;
    
    public java.lang.String getTaskMgrControlHttpPortAddress() {
        return TaskMgrControlHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaskMgrControlHttpPortWSDDServiceName = "TaskMgrControlHttpPort";

    public java.lang.String getTaskMgrControlHttpPortWSDDServiceName() {
        return TaskMgrControlHttpPortWSDDServiceName;
    }

    public void setTaskMgrControlHttpPortWSDDServiceName(java.lang.String name) {
        TaskMgrControlHttpPortWSDDServiceName = name;
    }

    public com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlPortType getTaskMgrControlHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaskMgrControlHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaskMgrControlHttpPort(endpoint);
    }

    public com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlPortType getTaskMgrControlHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlHttpBindingStub _stub = new com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlHttpBindingStub(portAddress, this);
            _stub.setPortName(getTaskMgrControlHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaskMgrControlHttpPortEndpointAddress(java.lang.String address) {
        TaskMgrControlHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlPortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlHttpBindingStub _stub = new com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlHttpBindingStub(new java.net.URL(TaskMgrControlHttpPort_address), this);
                _stub.setPortName(getTaskMgrControlHttpPortWSDDServiceName());
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
        if ("TaskMgrControlHttpPort".equals(inputPortName)) {
            return getTaskMgrControlHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://com/meritit/portal/uniontask/webservice", "TaskMgrControl");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://com/meritit/portal/uniontask/webservice", "TaskMgrControlHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaskMgrControlHttpPort".equals(portName)) {
            setTaskMgrControlHttpPortEndpointAddress(address);
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
