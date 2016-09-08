package com.zzst.meeting.util.test.webService;


import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class WSClient {
	/**
	 * 取消会议
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public String getXml4(String xml) throws Exception{
		String returnInfo = "";
		//访问webservice的地址
		String endpoint = "http://localhost:8888/icmp/services/ConferenceService?wsdl";
		//service实例
		Service service = new Service();
		//通过service创建call的实例
		Call call = (Call) service.createCall();
		//为call设置访问地址
		call.setTargetEndpointAddress(endpoint);
		//要访问的方法名称
		call.setOperationName(new QName("cancelBookMeet"));
		//设置返回值类型
		call.setReturnType(XMLType.XSD_STRING);
		//设置参数
		call.addParameter("strXml", XMLType.XSD_STRING, ParameterMode.IN);//String paramName 不能变
		//调用webservice接口并接收返回值
		returnInfo = (String)call.invoke(new Object[]{(xml)});
		return returnInfo;
	}
	/**
	 * 预约会议
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public String getXml3(String xml) throws Exception{
		String returnInfo = "";
		//访问webservice的地址
		String endpoint = "http://localhost:8888/icmp/services/ConferenceService?wsdl";
		//String endpoint = "http://172.28.100.84:8888/icmp/services/ConferenceService?wsdl";
		//service实例
		Service service = new Service();
		//通过service创建call的实例
		Call call = (Call) service.createCall();
		//为call设置访问地址
		call.setTargetEndpointAddress(endpoint);
		//要访问的方法名称
		call.setOperationName(new QName("conferenceBook"));
		//设置返回值类型
		call.setReturnType(XMLType.XSD_STRING);
		//设置参数
		call.addParameter("strXml", XMLType.XSD_STRING, ParameterMode.IN);//String paramName 不能变
		//调用webservice接口并接收返回值
		returnInfo = (String)call.invoke(new Object[]{(xml)});
		return returnInfo;
	}
	
	/**
	 * 得到会议室列表
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public String getXml(String xml) throws Exception{
		String returnInfo = "";
		//访问webservice的地址
		String endpoint = "http://127.0.0.1:8888/icmp/services/meetingRoomService?wsdl";
		//service实例
		Service service = new Service();
		//通过service创建call的实例
		Call call = (Call) service.createCall();
		//为call设置访问地址
		call.setTargetEndpointAddress(endpoint);
		//要访问的方法名称
		call.setOperationName(new QName("getMeetingRoomList"));
		//设置返回值类型
		call.setReturnType(XMLType.XSD_STRING);
		//设置参数
		call.addParameter("strJSON", XMLType.XSD_STRING, ParameterMode.IN);//String paramName 不能变
		//调用webservice接口并接收返回值
		returnInfo = (String)call.invoke(new Object[]{(xml)});
		return returnInfo;
	}
	/**
	 * 查询所有部门
	 * @return
	 * @throws Exception
	 */
	public String getXml2() throws Exception{
		String returnInfo = "";
		String endpoint = "http://172.28.100.84:8888/icmp/services/meetingRoomService?wsdl";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName(new QName("getAllDepartmentList"));
		call.setReturnType(XMLType.XSD_STRING);
		returnInfo = (String)call.invoke(new Object[]{});
		return returnInfo;
	}
	public static void main(String[] args) {
		WSClient client = new WSClient();
		String bookInfo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<ROOT><CONTENT>" +
				"<meetingRoomName><![CDATA[718会议室]]></meetingRoomName>" +//会议室名称
				"<meetingName><![CDATA[测试会议]]></meetingName>" +//会议名称
				"<meetingRange><![CDATA[外宾类]]></meetingRange>" +//外宾类等
				"<meetingForm><![CDATA[本地会议]]></meetingForm>" +//视频会议
				"<applicant><![CDATA[开发人员]]></applicant>" +
				"<applicantDepartment><![CDATA[研发中心]]></applicantDepartment>" +
				"<meetingStartTime><![CDATA[2016-9-02 14:01:01]]></meetingStartTime>" +
				"<meetingEndTime><![CDATA[2016-9-02 15:01:01]]></meetingEndTime>" +
				"<number><![CDATA[20]]></number>" +//参会人数
				"<host><![CDATA[王晓伟]]></host>" +
				"<rostrum><![CDATA[]]></rostrum>" +
				"<frontSeat><![CDATA[]]></frontSeat>" +
				"<ourName><![CDATA[王晓伟]]></ourName>" +
				"<ourTel><![CDATA[15701574020]]></ourTel>" +
				"<guestName><![CDATA[王3]]></guestName>" +
				"<guestTel><![CDATA[18888888888]]></guestTel>" +
				"<service><![CDATA[一级服务]]></service>" +
				"<kezhuo><![CDATA[课桌式]]></kezhuo>" +
				"<uxingzhuo><![CDATA[U型桌]]></uxingzhuo>" +
				"<huixingzhuo><![CDATA[回型桌]]></huixingzhuo>" +
				"<scroll><![CDATA[条幅]]></scroll>" +
				"<board><![CDATA[背板]]></board>" +
				"<sign><![CDATA[桌签]]></sign>" +
				"<telMeeting><![CDATA[电话会议]]></telMeeting>" +
				"<projection><![CDATA[投影]]></projection>" +
				"<record><![CDATA[录播]]></record>" +
				"<video><![CDATA[录像]]></video>" +
				"<voice><![CDATA[录音]]></voice>" +
				"<photograph><![CDATA[拍照]]></photograph>" +
				"<food><![CDATA[四菜一汤]]></food>" +
				"<description><![CDATA[这是一个测试会议]]></description>" +
				"<remark><![CDATA[这是一条备注信息]]></remark>" +
				"</CONTENT></ROOT>";

		/*String cancelInfo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<ROOT>" +
				"<CONTENT>" +
				"<meetingDetailID><![CDATA[123123124]]></meetingDetailID>" +
				"</CONTENT>" +
				"</ROOT>";*/

		try {
			String result = client.getXml3(bookInfo);//预约会议
			//String result = client.getXml4(bookInfo);//取消会议
			 
			 System.out.println(result);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
