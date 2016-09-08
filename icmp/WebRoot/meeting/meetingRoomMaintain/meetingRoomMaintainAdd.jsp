<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<title>会场维护新增</title>
		<script type="text/javascript">
				/**
			*	设置页面参数
			*@return	null	
			*/
           function pageInit(){
			    var obj = new htmlUtil();
				obj.title("meetingRoomName","输选择");	
				obj.title("maintainUserName","输入长度不超过25个字符");	
				obj.title("createTime","选择时间");	
			};
			/**
			*	修改会议室
			*@return	null	
			*/
   			function  meetingRoomMaintainAdd(){
   			   $('#addForm').validate({    
					rules:{    
					   "meetingRoomMaintainVO.meetingRoomVO.meetingRoomName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
					           "meetingRoomMaintainVO.createTime" : {
						           required:true
						         
						           },
					           
					     "meetingRoomMaintainVO.maintainUserName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           }
					  
					}
				  });
                     $('#addForm').submit();
           	};
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/meetingRoomMaintain/query.action";
            };
             
	        function selectMeetingRoomMaintainTime(thisDom,timeType){
			     var parameters = {
			         dateType : "datetime",
			         isNeedInfo:"true"
			     }
			    creatCalendar(thisDom,parameters);
			}
	          
	      function selectConference(thisDom){
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
                  selectType:'radio'
              }
             creatConferenceSelect(thisDom,conferenceParameters); 
          }
     
          function getReturnConferenceMethod(conferenceArray){
              //alert(userArray);
            //  alert(conferenceArray[0].conferenceID);
            //  alert(conferenceArray[0].conferenceName+"//"+conferenceArray[0].conferenceName);
                  var meetingRoomID="";
	              var meetingRoomName="";
	              var conferenceLength = conferenceArray.length;
	              for(var i=0;i<conferenceLength;i++){
	            	  meetingRoomID=conferenceArray[i].conferenceID;
	            	  meetingRoomName=conferenceArray[i].conferenceName;
	              }
	          	$("#meetingRoomID").attr("value",meetingRoomID);
               	$("#meetingRoomName").attr("value",meetingRoomName);
          }
    	</script>
	</head>
	<body onload="pageInit();" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx}/meetingRoomMaintain/add.action" id="addForm" name="addForm" method="post">
			<div class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						会场维护新增
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td class="tableaddtitle">
							<span>*</span>会场名称
						</td>
						<td class="tableadd_data">
							<input type="text" class="inputtran" name="meetingRoomMaintainVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" readonly="readonly"  onclick="selectConference(this);"/>
               				<input type="hidden" name="meetingRoomMaintainVO.roomID" id="meetingRoomID"  />
						</td>
						<td class="tableaddtitle">
							<span>*</span>维护日期
						</td>
						<td class="tableadd_data">
						 <input type="text" name="meetingRoomMaintainVO.createTime" class="inputtran" style="cursor:pointer;" readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:#{%m+1}'});" value="${meetingRoomMaintainVO.createTime}" id="createTime"   />
							  
						</td>
					</tr>
					
					<tr>
						<td class="tableaddtitle">
							<span>*</span>维护人员
						</td>
						<td class="tableadd_data" colspan="3">
							  <input  class="inputtran" type="text" name="meetingRoomMaintainVO.maintainUserName" id="maintainUserName" />
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>设备开机
						</td>
						<td class="tableadd_data" colspan="3">
							 <input type="radio"  name="status1" value="0" checked/>正常
                             <input type="radio"  name="status1" value="1"/>存在故障
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description1"
								id="description1" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>终端连接
						</td>
						<td class="tableadd_data" colspan="3">
							<input type="radio"  name="status2" value="0" checked/>正常
                           <input type="radio"  name="status2" value="1"/>存在故障
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description2"
								id="description2" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>本地图像
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status3" value="0" checked/>正常
                        <input type="radio" name="status3"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description3"
								id="description3" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>本地声音
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status4" value="0" checked/>正常
                        <input type="radio" name="status4"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description4"
								id="description4" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
						<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>远端图像
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status5" value="0" checked/>正常
                        <input type="radio" name="status5"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description5"
								id="description5" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>远端声音
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status6" value="0" checked/>正常
                        <input type="radio" name="status6"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description6"
								id="description6" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>双流测试
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status7" value="0" checked/>正常
                        <input type="radio" name="status7"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述：
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description7"
								id="description7" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>设备关机
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status8" value="0" checked/>正常
                        <input type="radio" name="status8"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description8"
								id="description8" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>网络连接
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status9" value="0" checked/>正常
                        <input type="radio" name="status9"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description9"
								id="description9" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>IP电话
						</td>
						<td class="tableadd_data" colspan="3">
						 <input type="radio"  name="status10" value="0" checked/>正常
                        <input type="radio" name="status10"  value="1"/>存在故障
							
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>问题描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="description10"
								id="description10" cols="5" style="width:90%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td width="15%" class="tableaddtitle">
							<span></span>其他问题
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran"  name="meetingRoomMaintainVO.description"   id="questionDes" cols="5" style="width:90%"></textarea>
						</td>
					
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
					<tfoot>
					</tfoot>
					<tbody>
					  <tr>
						<td>
						  <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="meetingRoomMaintainAdd();" />
						  <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();" />
						</td>
					  </tr>
					</tbody>
				</table>
			</div>
		</form>
	</body>
</html>