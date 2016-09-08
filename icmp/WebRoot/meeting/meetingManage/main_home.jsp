<%@ page language="java"  pageEncoding="UTF-8"%>
<!-- 
该功能废除，在conferenceTemplate模块内实现
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <%@include file="/common/common.jsp" %>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	  <title>会议模板列表</title>
	  <script type="text/javascript">
		function addMeeting(id){	
		location.href="/icmp/detail/getMeetingTemplateInfo.action?meetingDetailVO.meetingDetailID=" + id;
		}
		function createConfCallback(){
		   parent.window.location.href = "/icmp/meetingControl.jsp";
		}
       function back(){
      	alert("模板添加成功");
     	location.href = "/icmp/template/manageMeetingTemplateList.action?date=" + new Date();
        
       }

       function backRe(){
        	location.href = "/icmp/template/manageMeetingTemplateList.action?date=" + new Date();
           
          }
   		function modifyTemplate(id){
        location.href="/icmp/detail/meetingTemplateBeforeModify.action?meetingDetailVO.meetingDetailID=" + id;
       }
       
       function delTemplate(meetingDetailID){
	       if(confirm("确认删除此模板？")){
	       	  location.href="/icmp/detail/delMeetingTemplate.action?meetingDetailVO.meetingDetailID=" + meetingDetailID;
	       }else{
	       	  return;
	       }
       }


       function addTemplate(){
           location.href = "/icmp/detail/meetingTemplateBeforeAdd.action";
       }
		var a=1;//不让重复点击“立即召开”
       function addVideoMeeting(id){
           if(a==1){
           location.href = "/icmp/detail/addVideoConference.action?meetingDetailVO.meetingDetailID="+id;
			a=0;
           }else{
				alert("正在建会，请稍后再试！");
           }
        }

       function exportMeetingTemplateInfo(){
   		document.getElementById('pageform').action="${sys_ctx}/detail/exportTemplateQuery.action";
   		document.getElementById('pageform').submit();
   		document.getElementById('pageform').action="${sys_ctx }/detail/manageMeetingTemplateList.action";
   	   }
		//点击“立即召开”颜色显灰
       $(function(){
			$(".func_addVideoMeeting").click(function(){
				$(this).css("color","#CCC");
				$(this).unbind("click");
			});
		});
		
		var b=1;//不让重复点击“立即召开”---高级模版“立即召开”
		function addVideoMeetingGJ(id){
			if(b==1){
			window.location.href="${sys_ctx}/detail/addVideoMeetingOnMcu.action?templateVO.id="+id;
			b=0;
			}else{
				alert("正在建会，请稍后再试！");
			}
		}
		/**
		*	打开修改高级模板页面
		*@param		${String}	id
		*@return	null	
		*/
		function templatebeforeModify(id){
			//window.showModalDialog("${sys_ctx }/detail/beforeModifyTopMeetingTemplate.action?templateVO.id="+id,window,'dialogWidth=600px;dialogHeight=450px;');
			location.href = "${sys_ctx }/detail/beforeModifyTopMeetingTemplate.action?templateVO.id="+id;
		}
		/**
		*	配置高级模板中的会议
		*@param		${String}	id
		*@return	null	
		*/
		function templateMeetingAdd(id){
			window.location.href ="${sys_ctx }/detail/getTopMeetingList.action?templateVO.id="+id;
                //window.location.href="${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id;
		}
		/**
		*	高级模板中的会议结构
		*@param		${String}	id
		*@return	null	
		*/
		function templateMeetingTree(id){
			window.showModalDialog("${sys_ctx }/meeting/template/templateMeetingTree.jsp?id="+id,window,'dialogWidth=600px;dialogHeight=450px;');
		}
		/**
		*   删除高级模板
		*@param		${String}	id
		*@return	null	
		*/
		function templateMeetingDelete(id,meetingDetailID){
			if(!window.confirm("是否确认删除？")) return;
			window.location.href="${sys_ctx }/detail/deleteTopMeetingTemplate.action?templateVO.id="+id+"&meetingDetailID="+meetingDetailID;
		}
		/**
		*	跳转到高级模板添加
		*@param		null
		*@param		null
		*/
		function beforeAddTopMeetingTemplate(){
			 window.location.href="${sys_ctx}/detail/beforeAddTopMeetingTemplate.action";
		}
		/**
		*	导出高级模板
		*@param		null
		*@param		null
		*/
		function exportTemplateQuery(){
			document.getElementById('pageform').action="${sys_ctx}/detail/exportTopMeetingTemplateList.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/detail/manageTopMeetingTemplateList.action";
		}
     </script>  
  </head>
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
   
    <form action="/icmp/detail/manageMeetingTemplateList.action" method="post" name="pageform" id="pageform">
    <div id="basicform" class="contentwrapper">  
    <!--pageheader-->
    
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td class="tableadd_data"><input id="meetingName" name="meetingDetailVO.meetingName" type="text" class="inputtran" value="${meetingDetailVO.meetingName }"/></td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
        </tr>
      </table>
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_TEMPLATEADD%>" style="cursor: pointer;"  onclick="beforeAddTopMeetingTemplate();">添加高级模版</a><a class="funcOper <%= FuncEnum.FUNC_NO_TEMPLATEEXPORT%>" style="cursor: pointer;" onclick="exportTemplateQuery();">导出高级模版</a><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;" onclick="addTemplate();">增加</a><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportMeetingTemplateInfo();">导出</a></h5>
      </div>
      <!--contenttitle-->
      
      <!--<div class="tableoptions">
       <span style=" float:right; margin-right:10px;">搜索：<input id="datepicker" type="text" class="searwidth100" /></span>
      </div>-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th class="head1" width="5%" >序号</th>
            <th class="head1" width="" >会议名称</th>
            <th  class="head1" width="10%">会议时长</th>
            <th  class="head1" width="250px">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
           <c:forEach items="${meetingDetailVOList}" var="meetingDetailVO" varStatus="status">
		        <tr>
		          	<td class="alc"><c:out value="${status.index+1}"></c:out></td>
		          	<td>
		          		<c:out value="${meetingDetailVO.meetingName}" />
		          	</td>
		          	<td id="${meetingDetailVO.meetingDetailID}">
		          	<script type="text/javascript">
						
						var startTime = "${meetingDetailVO.meetingStartTime }";
						
						startTime = startTime.substr(0,19);//不要.后边的。
						startTime = startTime.replace(/-/g,"/");//替换字符，变成标准格式
						var startDate = new Date(Date.parse(startTime));
						
						var endTime = "${meetingDetailVO.meetingEndTime }";
						endTime = endTime.substr(0,19)
						endTime = endTime.replace(/-/g,"/");//替换字符，变成标准格式
						var endDate = new Date(Date.parse(endTime));
						var t = (endDate.getTime()-startDate.getTime())/(60*60*1000);
						
						var htmlStr ="";
						if(t>=24*3) 
							document.write("3天以上")
						else
							document.write(t+"小时")
					</script>
		          	</td>
		          	 <td class="alc">
		          	 	<c:choose>
					    	<c:when test="${meetingDetailVO.templateType == '1' }">
					    		<a class="funcOper <%= FuncEnum.FUNC_NO_ADDVIDEOMEETING%>" style="cursor: pointer;" onclick="javascript:addVideoMeetingGJ('${meetingDetailVO.templateID}');"/>立即召开  
								<a class="funcOper <%= FuncEnum.FUNC_NO_TEMPLATEMODIFY%>" style="cursor: pointer;" onclick="javascript:templatebeforeModify('${meetingDetailVO.templateID}');"/>修改  
								<a class="funcOper <%= FuncEnum.FUNC_NO_TEMPLATEMEETINGADD%>" style="cursor: pointer;" onclick="javascript:templateMeetingAdd('${meetingDetailVO.templateID}');" />配置  
								<a class="funcOper <%= FuncEnum.FUNC_NO_MEETINGTREE%>" style="cursor: pointer;" onclick="javascript:templateMeetingTree('${meetingDetailVO.templateID}');" />会议结构  
								<a class="funcOper <%= FuncEnum.FUNC_NO_TEMPLATEDEL%>" style="cursor: pointer;" onclick="javascript:templateMeetingDelete('${meetingDetailVO.templateID}','${meetingDetailVO.meetingDetailID}');"/>删除
					    	</c:when>
					    	<c:otherwise>
					    		<a class="funcOper <%= FuncEnum.FUNC_NO_ADDVIDEOMEETING%>" style="cursor: pointer;" onclick="addVideoMeeting('${meetingDetailVO.meetingDetailID}')">立即召开</a>  
		          	 			<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" style="cursor: pointer;" onclick="modifyTemplate('${meetingDetailVO.meetingDetailID}')">修改</a>  
		          	 			<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" style="cursor: pointer;" onclick="delTemplate('${meetingDetailVO.meetingDetailID}')">删除</a>
		          	 		</c:otherwise>
					 	</c:choose>
		          	 </td>
		        </tr>
			</c:forEach>
        </tbody>
      </table>
    <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
	</div>
   </form>
  </body>
</html>
