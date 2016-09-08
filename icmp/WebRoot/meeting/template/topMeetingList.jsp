<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <%@include file="/common/common.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<title>会议管理列表页面</title>

		<script type="text/javascript">
			/**
			*	查看会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function meetingRoomDetail(id){
				
				window.showModalDialog("${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
                 //window.location.href="${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id;
				}


			/**
			*	跳转到添加会议信息
			*@param		null
			*@param		null
			*/
			function beforeAddMeeting(){
				 var templateId = document.getElementById("templateId").value;
				 window.location.href="${sys_ctx}/detail/beforeAddMeeting.action?templateMeetingVO.templateId="+templateId;
			}

			/**
			*	打开修改模板会议页面
			*@param		${String}	id
			*@return	null	
			*/
			function beforeModifyMeeting(id){
				var templateId = document.getElementById("templateId").value;
				//window.showModalDialog("${sys_ctx }/detail/beforeModifyTopMeetingTemplate.action?templateVO.id="+id,window,'dialogWidth=600px;dialogHeight=450px;');
				location.href = "${sys_ctx }/detail/beforeModifyMeetingInfo.action?templateMeetingVO.id="+id+"&"+"templateMeetingVO1.templateId="+templateId;
			}

			/**
			*删除会议信息 
			*@param		${String}	id
			*@return	null	
			*/
			function meetingDele(id,tid){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx }/detail/deleteTopMeeting.action?templateMeetingVO.id="+id+"&templateVO.id="+tid;
			}
			
	          function pageInit(){
				    var obj = new htmlUtil();
					obj.title("meetingName","请输入");	
				}
			
			function exportTemplateQuery(){
				document.getElementById('pageform').action="${sys_ctx}/detail/exportTopMeetingTemplateList.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/detail/manageTopMeetingTemplateList.action";
			}

			function backHistory(){
					window.location.href="${sys_ctx }/detail/manageMeetingTemplateList.action";
				}
		</script>
	</head>
	<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' onload="pageInit()">
	
		<form action="${sys_ctx}/detail/getTopMeetingList.action?templateVO.id=${templateMeetingVO.templateId}" id="pageform" name="pageform" method="post">
			
			<div id="basicform" class="contentwrapper"/>
			  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
                 <tr>
		          <td width="15%" class="tableaddtitle">会议名称</td>
		          <td class="tableadd_data"><input id="meetingName" name="templateMeetingVO.meetingName" type="text" class="inputtran" value="${templateMeetingVO.meetingName}"/></td>
		          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
       			 </tr>
             </table>
            
       <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
           
        </a></div>
      </div>
      
      <!--contenttitle--> 
    	<input type="hidden" value="${templateVO.id }" id="templateId"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;"  onclick="beforeAddMeeting();">添加 </a>|<a style="cursor: pointer;" onclick="backHistory();"> 返回</a></h5>
      </div>
					
  <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="19%" class="head1">MCU名称</th>
            <th width="19%" class="head1">会议名称</th>
            <th width="19%" class="head1">会议号码</th>
            <th width="19%" class="head1">会议顺序</th>
            <th width="17%" class="head1">操作</th>
          </tr>
        </thead>
       
        
				 <tbody>
								<c:forEach items="${tmList}" var="templateMeetingVO" varStatus="state">
									<tr>
										<td class="alc">
											<c:out value="${state.index+1}"></c:out>
										</td>
										<td>
											<c:out value="${templateMeetingVO.mcuEquipmentName }" />
										</td>
										<td>
											<c:out value="${templateMeetingVO.meetingName}"/>
										</td>
										<td>
											<c:out value="${templateMeetingVO.meetingNumber }" />
										</td>
										<td>
											<c:out value="${templateMeetingVO.rank }" />
										</td>
										<td class="alc">
												
												<a style="cursor: pointer;" onclick="javascript:beforeModifyMeeting('${templateMeetingVO.id}');"/>修改|
												<a style="cursor: pointer;" onclick="javascript:meetingDele('${templateMeetingVO.id}','${templateMeetingVO.templateId}');"/>删除
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					
					<jsp:include page="/common/pageFooter.jsp" />
				
					
					
		</form>
	</body>
</html>
