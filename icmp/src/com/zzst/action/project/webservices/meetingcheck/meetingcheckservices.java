package com.zzst.action.project.webservices.meetingcheck;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;



@WebService(targetNamespace = "http://www.zkasoft.com/v1.7/", name = "meetingcheck")
public interface meetingcheckservices {
	@WebResult(name = "getReferralResponse", targetNamespace = "http://www.zkasoft.com/v1.7/", partName = "parameters")
	@WebMethod
public String getXml(
		@WebParam(partName = "parameters", name = "strXml", targetNamespace = "http://www.zkasoft.com/v1.7/") String strXml); 
}
 