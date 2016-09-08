<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.text.*" %>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO" %>
<%@ page import="com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO" %>
<%@ page import="com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pathData = basePath + "meeting/statistics/";//viewRoomAssetsDetailDate.jsp
	request.setCharacterEncoding("UTF-8");
String meetingRoomId="";
String meetingRoomName="";
String startTime=""+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
String endTime=""+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
String AddDaysTime="AddDaysTime();";
 if(request.getParameter("meetingRoomId")!=null&&!("".equals(request.getParameter("meetingRoomId")))){
 meetingRoomId=request.getParameter("meetingRoomId");
 }
 
 if(request.getParameter("meetingRoomVO.meetingRoomName")!=null&&!("".equals(request.getParameter("meetingRoomVO.meetingRoomName")))){
 meetingRoomName=request.getParameter("meetingRoomVO.meetingRoomName");

 }
 
  if(request.getParameter("startTime")!=null&&!("".equals(request.getParameter("startTime")))){
  startTime=request.getParameter("startTime");
   AddDaysTime="";
 }
 
  if(request.getParameter("endTime")!=null&&!("".equals(request.getParameter("endTime")))){
  endTime=request.getParameter("endTime");
 }


 %>
<html>
<head>
		<%@include file="/common/common.jsp"%>
		<title>统计</title>
		<script type="text/javascript" src="FusionCharts.js" charset="UTF-8"></script>
		<script type="text/javascript">
Date.prototype.format = function(format){ 
var o = { 
"M+" : this.getMonth()+1, //month 
"d+" : this.getDate(), //day 
"h+" : this.getHours(), //hour 
"m+" : this.getMinutes(), //minute 
"s+" : this.getSeconds(), //second 
"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
"S" : this.getMilliseconds() //millisecond 
} 

if(/(y+)/.test(format)) { 
format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
} 

for(var k in o) { 
if(new RegExp("("+ k +")").test(format)) { 
format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
} 
} 
return format; 
} 
		
		function AddDaysTime() {
          var now=new Date();
          var newdate=new Date();
          var newtimems=newdate.getTime()-(${sys_date_num }*24*60*60*1000);
          newdate.setTime(newtimems);
          now=now.format("yyyy-MM-dd");
          newdate=newdate.format("yyyy-MM-dd");
          document.getElementById("startTime").value=newdate;
          tempnow=document.getElementById("endTime").value=now;
          
}
			
			function pageInit(){
			
			     AddDaysTime(); 
				var obj = new htmlUtil();
				//obj.title("selectDate","点击选择日期");
			}
		
			function bookMeeting(param,param2,param3,param4,param5,param6){
				$("#bookMeetingRoomName").attr("value",param4);
				$("#bookMeetingRoomID").attr("value",param2);
				if(param=="1"){
					$("#bookForm").attr("action","${sys_ctx }/detail/generalAddBefor.action");
				}else if(param=="2"){
					$("#bookForm").attr("action","${sys_ctx }/detail/vedioAddBefor.action");
				}
				$("#bookForm").submit();
			}
			//addby chenshuo
			function addMeeting(){
				//window.location.href="${sys_ctx}/equipment/noticeBeforAdd.action";
				<%
					String html = BaseInfoHelp.InitializePage(BaseInfoEnum.DICTIONARY_MEEITNG_TYPE);
				%>
				var uri = "<%=html%>";
				window.location.href=uri;
			}
			 /**
			*	选择开始时间
			*@return	null
			*/
			function selectStarttimePlan(thisDom){
			     var parameters = {
			         dateType : "date",
			         isNeedInfo:"true"
			     }
			     creatCalendar(thisDom,parameters);
			    
			}
			
			/**
			*	查看会议详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function meetingDetail(type,id){
				window.showModalDialog("${swh_ctx }/meetingManage/detail.action?meetingVO.meetingID="+id+"&meetingVO.meetingType="+type,window,"");
			}

			function chengeTime(param){
				$("#changeTime").attr("value",param);
				$("#pageform").submit();
			}
			/**
			*	选择会议室
			*@return	null
			*/
			function selectMeetingRoom(param){
				var venueParam = {
					 methodName:'getReturnMRMethod',
					 roomType:'meetingRoom', 
	                 selectType:'radio'
	            }
				creatConferenceSelect(param,venueParam); 
			}
			
			function getReturnMRMethod(mrArray){
				if(mrArray!=null){
					
					var ids = mrArray[0].conferenceID;
					var names =mrArray[0].conferenceName;
					
						
					$("#meetingRoomID").attr("value",ids);
					$("#meetingRoomName").attr("value",names);
				}
			}
       			    
	
		</script>
		
</head>
<body onload="<%=AddDaysTime %>" class="withvernav" STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<form action="viewRoomAssetsDetail.jsp" id="pageform" name="pageform" method="post">
		<input id="meetingRoomID" name="meetingRoomId" type="hidden" value="<%=meetingRoomId %>"/>
         
		<div id="contentwrapper" class="contentwrapper">
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="10%" class="tableaddtitle">开始时间</td>
	          <td width="20%" class="tableadd_data" ><img src="${sys_ctx}/style/normal/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	            <input type="text" name="startTime" id="startTime" style="cursor:hand" readonly onclick='selectStarttimePlan(this);'
	             class="inputtran" title="点击选择开始时间" value="<%=startTime %>"/>
	            </td>
	            
	           <td width="10%" class="tableaddtitle">结束时间</td>
	          <td width="20%" class="tableadd_data" ><img src="${sys_ctx}/style/normal/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	            <input type="text" name="endTime" id="endTime" style="cursor:hand" readonly 
	            onclick='selectStarttimePlan(this);' class="inputtran" title="点击选择开始时间" value='<%=endTime %>'/>
	            </td> 
	          <td width="10%" class="tableaddtitle">选择会议室</td>
	          <td width="30%" class="tableadd_data">
	          	<input type="text" onclick="selectMeetingRoom(this);" style="cursor:hand"  readonly  
	          	name="meetingRoomVO.meetingRoomName" id="meetingRoomName"  value="<%=meetingRoomName %>" 
	          	class="inputtran" title="点击选择会议室"/>
	          </td>
	          <td class="tableaddtitle">
		          <input type="submit" name="button" id="button" value="查询"  title="查询" onclick="queryMeetingList();" class="stdbtn mlr10"/>
	          </td>
	        </tr>
	      </table>
	    </div>
	    
	 </form>
	
	 <div id="contentwrapper" class="contentwrapper">
	 <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp;
       <select id="modeChange"  onchange="modeSelect();">
			<option value="tableShow">列表模式</option>
			<option value="chartdivNumDIV">柱状图模式</option>
		</select>		
        </h5>
        <h5 class="fwb fl10" style="float:right" >
        
		</h5>
      </div> 
      
      <div id="chartdivNumDIV" style="display: none" align="center">
       <table>
       <tr>
       <td>
       <div id="chartdivNumDIV1" style="padding-top: 10px;padding-right: 10px;"></div>
       </td>
       <td>
        <div id="chartdivNumDIV2" style="padding-top: 10px"></div>
        </td>
        </tr>
        </table>
       </div>
       
        <div id="tableShow">
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
             <th width="8%" class="head1">序号</th>
            <th width="24%" class="head1">部门名称</th>
            <th width="24%" class="head1">开会次数</th>
           <th width="24%" class="head1">开会时长</th>
           <th width="24%" class="head1">会议列表</th>
           
          </tr>
        </thead>
       
        <tbody>
       
         
        
        </tbody>
      </table>
    </div>  
	<div align="center">
     <table align="center">
     <tr>
     <td align="center">维修次数统计</td>
     <td align="center">维修费用统计</td>
     </tr>
     
     <tr>
     <td align="center"><div id="chartdivNumDIV" align="center">请选择条件</div>
	 <script type="text/javascript">
                       var chartdivMainRenfence = new FusionCharts("Column3D.swf", "chartdivMainRenfenceID", "500", "220", "0", "0");
		                chartdivMainRenfence.setDataURL("<%=pathData+"viewRoomAssetsDetailDate.jsp?meetingRoomId="+meetingRoomId+"&startTime="+startTime+"&endTime="+endTime %>");		   
		               chartdivMainRenfence.render("chartdivNumDIV");
         </script>
         </td>
     <td align="center">
<div id="chartdivMoneyDIV" align="center">请选择条件</div>
	  <script type="text/javascript">
                       var chartdivMainRenfence2 = new FusionCharts("Column3D.swf", "chartMoney", "500", "220", "0", "0");
		                chartdivMainRenfence2.setDataURL("<%=pathData+"viewRoomAssetsDetailMoneyDate.jsp?meetingRoomId="+meetingRoomId+"&startTime="+startTime+"&endTime="+endTime %>");		   
		               chartdivMainRenfence2.render("chartdivMoneyDIV");
         </script>
</td>
     </tr>
     </table>
	</div>  
	 </body>
	 </html>
	    
	    
	    
	    
	    