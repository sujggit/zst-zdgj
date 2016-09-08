package com.zzst.action.project.webservices.pushtodo.webservices;

public class TaskMgrControlPortTypeProxy implements com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlPortType {
  private String _endpoint = null;
  private com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlPortType taskMgrControlPortType = null;
  
  public TaskMgrControlPortTypeProxy() {
    _initTaskMgrControlPortTypeProxy();
  }
  
  public TaskMgrControlPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initTaskMgrControlPortTypeProxy();
  }
  
  private void _initTaskMgrControlPortTypeProxy() {
    try {
      taskMgrControlPortType = (new com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlLocator()).getTaskMgrControlHttpPort();
      if (taskMgrControlPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)taskMgrControlPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)taskMgrControlPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (taskMgrControlPortType != null)
      ((javax.xml.rpc.Stub)taskMgrControlPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlPortType getTaskMgrControlPortType() {
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType;
  }
  
  public java.lang.String sychTaskBig(java.lang.String appId, java.lang.String handleTime) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.sychTaskBig(appId, handleTime);
  }
  
  public java.lang.String deleteTaskByType(java.lang.String appId, java.lang.String taskType) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.deleteTaskByType(appId, taskType);
  }
  
  public java.lang.String addTaskBatch(java.lang.String tasksXml) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.addTaskBatch(tasksXml);
  }
  
  public java.lang.String addTask(java.lang.String appID, java.lang.String taskName, java.lang.String appTaskID, java.lang.String taskType, java.lang.String appSendUID, java.lang.String appReceiveUID, java.lang.String sendTime, java.lang.String endTime, java.lang.String url, java.lang.String taskDesc, java.lang.String priorityID) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.addTask(appID, taskName, appTaskID, taskType, appSendUID, appReceiveUID, sendTime, endTime, url, taskDesc, priorityID);
  }
  
  public java.lang.String sychTaskSmall(java.lang.String appId, java.lang.String handleTime, java.lang.String taskStr) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.sychTaskSmall(appId, handleTime, taskStr);
  }
  
  public java.lang.String completeTaskUpdate(java.lang.String userId, java.lang.String appTaskID, java.lang.String appID, java.lang.String handleTime) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.completeTaskUpdate(userId, appTaskID, appID, handleTime);
  }
  
  public java.lang.String viewTask(java.lang.String appTaskID, java.lang.String appID, java.lang.String handleTime) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.viewTask(appTaskID, appID, handleTime);
  }
  
  public java.lang.String completeTaskBatch(java.lang.String appTaskID, java.lang.String appID, java.lang.String handleTime) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.completeTaskBatch(appTaskID, appID, handleTime);
  }
  
  public java.lang.String addReadTask(java.lang.String appID, java.lang.String taskName, java.lang.String appTaskID, java.lang.String taskType, java.lang.String appSendUID, java.lang.String appReceiveUID, java.lang.String sendTime, java.lang.String endTime, java.lang.String url, java.lang.String taskDesc, java.lang.String priorityID, java.lang.String inoticeinterval) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.addReadTask(appID, taskName, appTaskID, taskType, appSendUID, appReceiveUID, sendTime, endTime, url, taskDesc, priorityID, inoticeinterval);
  }
  
  public java.lang.String completeTask(java.lang.String appTaskID, java.lang.String appID, java.lang.String handleTime) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.completeTask(appTaskID, appID, handleTime);
  }
  
  public java.lang.String addReadTaskBatch(java.lang.String readTasksXml) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.addReadTaskBatch(readTasksXml);
  }
  
  public java.lang.String cancelTask(java.lang.String appTaskID, java.lang.String appID, java.lang.String handleTime) throws java.rmi.RemoteException{
    if (taskMgrControlPortType == null)
      _initTaskMgrControlPortTypeProxy();
    return taskMgrControlPortType.cancelTask(appTaskID, appID, handleTime);
  }
  
  
}