<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk" pageEncoding="gbk" %>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO" %>
<%@ page import="com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%
String meetingRoomId="";
String startTime="";
String endTime="";
String sqls=" and status='5' ";
request.setCharacterEncoding("gbk");
 if(request.getParameter("meetingRoomId")!=null&&!("".equals(request.getParameter("meetingRoomId")))){
 meetingRoomId=request.getParameter("meetingRoomId");
 sqls+=" and roomID='"+meetingRoomId+"' ";
 }else {
 sqls+=" and roomID='' ";
 }
 
  if(request.getParameter("startTime")!=null&&!("".equals(request.getParameter("startTime")))){
  startTime=request.getParameter("startTime");
  sqls+=" and updateTime >='"+startTime+" 00:00:00'";
 }
 
  if(request.getParameter("endTime")!=null&&!("".equals(request.getParameter("startTime")))){
  endTime=request.getParameter("endTime");
   sqls+=" and updateTime <='"+endTime+" 23:59:59'";
 }
EquipmentMaintainVO emv=new EquipmentMaintainVO();
emv.setSqls(sqls);
ArrayList list=ServiceFactory.getEquipmentMaintainService().queryWhereSQLS(emv,null);
Set idSet=new HashSet();

for(int i=0;i<list.size();i++){
EquipmentMaintainVO e=((EquipmentMaintainVO)(list.get(i)));
if(e.getEquipmentID()!=null&&!("".equals(e.getEquipmentID()))){
idSet.add(e.getEquipmentID());
}
}
 %>
<chart caption="" palette="2" animation="1" formatNumberScale="0" numberPrefix="" labeldisplay="ROTATE" slantLabels="1" seriesNameInToolTip="0" sNumberSuffix="" showValues="0" plotSpacePercent="0"
 labelDisplay="STAGGER">
<%
Iterator idit=idSet.iterator();
while(idit.hasNext()){
EquipmentVO ev=ServiceFactory.getEquipmentService().queryByID(idit.next().toString());
if(ev==null) continue;
EquipmentMaintainVO emvtj=new EquipmentMaintainVO();

emvtj.setSqls(sqls+" and equipmentID='"+ev.getEquipmentID()+"'");
ArrayList listtj=ServiceFactory.getEquipmentMaintainService().queryWhereSQLS(emvtj,null);


 %>
<set label="<%=ev.getEquipmentName() %>" value="<%=listtj.size() %>" />

<%} %>

<styles>
<definition>
<style type="font" name="CaptionFont" size="15" color="666666" />
<style type="font" name="SubCaptionFont" bold="0" />
</definition><application>
<apply toObject="caption" styles="CaptionFont" />
<apply toObject="SubCaption" styles="SubCaptionFont" />
</application>
</styles>
</chart>