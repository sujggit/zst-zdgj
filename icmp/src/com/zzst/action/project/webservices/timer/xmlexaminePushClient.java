package com.zzst.action.project.webservices.timer;

import javax.jws.WebService;

import com.zzst.action.project.webservices.examinepush.examinePushClient;

@WebService(serviceName = "examine", portName = "examine_ServicePort", endpointInterface = "com.zzst.action.project.webservices.examinepush.examinePushClient", targetNamespace = "http://www.zkasoft.com/v1.7/", name = "examine_ServiceImpl")
public interface xmlexaminePushClient  extends examinePushClient {
}
