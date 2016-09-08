<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp"%>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<%@include file="/common/common.jsp"%>
	<link href="${sys_ctx }/meeting/conferenceBook/css/style.css" type="text/css" rel="stylesheet" />
	<title>会议室日历</title>
	<script type="text/javascript">
		/**
		 *	设置页面参数
		 */
		function pageInit(){
			var obj = new htmlUtil();
			//obj.title("selectDate","点击选择日期");
			var selectDate = document.getElementById("selectDate");
			document.getElementById("currDate").innerHTML = selectDate.value;
		}

		function selectYear(){
			var currDate = $("#currDate").text();
			var currYear = currDate.substring(0,4);
		    var currMonth = Number(currDate.substring(5,7));
		    var currDay = currDate.substring(8,10); 
			window.location.href = "${sys_ctx }/meeting/conferenceBook/calendarYear.jsp?currYear="+currYear+"&currMonth="+currMonth+"&currDay="+currDay;
		}
		
		function bookMeeting(param,param2,param3,param4,param5,param6){
			$("#bookMeetingRoomName").attr("value",param4);
			$("#bookMeetingRoomID").attr("value",param2);
			$("#meetingStartTime").attr("value",param5.replace("*", " "));
			$("#meetingEndTime").attr("value",param6.replace("*", " "));
			$("#meetingStartTimeTemp").attr("value",param5.replace("*", " "));
			$("#meetingEndTimeTemp").attr("value",param6.replace("*", " "));
			
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
		*	查看会议详细信息
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
				var ids = "";
				var names = "";
				for(var i=0;i<mrArray.length;i++){
					if(i==0){
						ids   = mrArray[i].conferenceID
						names = mrArray[i].conferenceName;
					}else{
						ids 	= ids+","+mrArray[i].conferenceID;
						names   = names+","+mrArray[i].conferenceName;
					}
				}
				$("#meetingRoomID").attr("value",ids);
				$("#meetingRoomName").attr("value",names);
			}
		}

		function queryMeetingList(){
			var date = $("#selectDate").val();
			if(date!=null&&date.length>0){
				$("#meetingStartTime").attr("value",$("#selectDate").val());
			     $("#meetingEndTime").attr("value",$("#selectDate").val());
				//$("#starttimePlan").attr("value",date+" ${startHour}:00:00");
				//$("#endtimePlan").attr("value",date+" ${endHour}:00:00");
			}
			$("#pageform").submit();
		}
	</script>
  </head>
  <body onload="pageInit();" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<form action="${sys_ctx }/conference/conferenceList.action" id="pageform" name="pageform" method="post">
		<input id="meetingRoomID" name="meetingRoomVO.meetingRoomID" type="hidden" value="${meetingRoomVO.meetingRoomID }"/>
		<input id="changeTime" name="changeTime" type="hidden"/>
		<input name="meetingDetailVO.meetingStartTime" id="meetingStartTime" type="hidden"  value="${meetingDetailVO.meetingStartTime }"/>
		<input name="meetingDetailVO.meetingEndTime" id="meetingEndTime"  type="hidden" value="${meetingDetailVO.meetingEndTime }"/>

		<div id="contentwrapper" class="contentwrapper">
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="15%" class="tableaddtitle">开始时间</td>
	          <td width="35%" class="tableadd_data" ><img src="${sys_ctx}/style/normal/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	            <input name="selectDate" id="selectDate" style="cursor:hand" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" class="inputtran" title="点击选择开始时间" value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd"/>'/>
	            </td>
	          <td width="15%" class="tableaddtitle">选择会议室</td>
	          <td width="35%" class="tableadd_data">
	          	<input onclick="selectMeetingRoom(this);" style="cursor:pointer" readonly="readonly" name="meetingRoomVO.meetingRoomName" id="meetingRoomName"  value="${meetingRoomVO.meetingRoomName }" class="inputtran" title="点击选择会议室"/>
	          </td>
	          <td class="tableaddtitle">
		          <input type="button" name="button" id="button" value="查 询" onclick="queryMeetingList();" class="stdbtn mlr10"/>
	          </td>
	        </tr>
	      </table>
	    </div>
	    <div id="contentwrapper" class="contentwrapper">
	    <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="" style="table-layout:fixed;">
	      <tr>
           <td style="text-align:left;width: 20%">
           <a href="#" onclick=chengeTime('left')>
           <img src="../meeting/conferenceBook/images/arrow-left.png"/></a>
           </td>
           <td style="text-align: center;width: 30%">
           <a onclick="selectYear()" id="currDate"></a>
           </td>
           <td style="text-align:right;width: 20%">
	           <a href="#" onclick=chengeTime('right')>
	           <img src="../meeting/conferenceBook/images/arrow-right.png"/></a>
           </td>
           <td class="graph" style="text-align:center;width: 30%">
	           <strong class="bar3" style="width: 33%;color: black;">不可预约</strong>
	           <strong class="bar2" style="width: 33%;">已预约</strong>
	           <strong class="bar4" style="width: 33%;">可预约</strong>
           </td>
          </tr>
        </table>
        
     
        
	      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="" style="table-layout:fixed">
	        <thead>
	          <tr>
	            <th width="15%" class="head1" style= "white-space:nowrap;overflow:hidden;text-overflow: ellipsis; " >会议室名称</th>
	            <c:forEach	items='${viewHour}' var = "viewHour" varStatus = "vstatus" >
	            	<th width="%" class="head1" style= "white-space:nowrap;overflow:hidden;text-overflow: ellipsis; " title="${viewHour }:00">
						<!-- ${vstatus.last ? "<span id='btn2'><a href='#'><img onclick=chengeTime('right') title='下一时间段' src='../meeting/conferenceBook/images/arrow-right.png' width='24' height='24' align='middle' /></a></span>" : ""  } -->
						${viewHour }:00
						<!-- ${vstatus.first ? "<span id='btn2'><a href='#'><img onclick=chengeTime('left'); title='上一时间段' src='../meeting/conferenceBook/images/arrow-left.png' width='24' height='24' align='middle' /></a></span>" : ""  } -->
			      </th>
      			</c:forEach>
	          </tr>
	        </thead>
	        <tfoot>
	        </tfoot>
	        <tbody>
	          <tr>
	            <c:forEach	items='${meetingRoomList}' var = "meetingRoomVO" varStatus = "vstatus" >
				   	<tr>
				      <td height="35" class="title" style= "white-space:nowrap;overflow:hidden;text-overflow: ellipsis; " title="${meetingRoomVO.meetingRoomName }">${meetingRoomVO.meetingRoomName }</td>
				      <td height="35" class="title"  style= "white-space:nowrap;overflow:hidden;text-overflow: ellipsis; padding: 0 1px" colspan="${clospanNumber }">${meetingRoomVO.viewStr}</td>
				    </tr>
			   	</c:forEach>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	</form>
	<form action="#" id="bookForm" name="bookForm" method="post">
		<input id="bookMeetingRoomID" name="meetingDetailVO.meetingRoomID" type="hidden"/>
		<input id="bookMeetingRoomName" name="meetingDetailVO.meetingRoomName" type="hidden"/>
		<input name="meetingDetailVO.meetingStartTime" id="meetingStartTimeTemp" type="hidden"  value="${meetingDetailVO.meetingStartTime }"/>
		<input name="meetingDetailVO.meetingEndTime" id="meetingEndTimeTemp"  type="hidden" value="${meetingDetailVO.meetingEndTime }"/>
	</form>
  </body>
</html>
