<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <%@include file="/common/common.jsp"%>
    <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>高级模板管理列表页面</title>
	<script type="text/javascript">
		/**
		*	配置模板中的会议
		*@param		${String}	id
		*@return	null	
		*/
		function templateMeetingAdd(id){
			window.location.href ="${sys_ctx }/detail/getTopMeetingList.action?templateVO.id="+id;
                //window.location.href="${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id;
		}

		/**
		*	跳转到添加模板
		*@param		null
		*@param		null
		*/
		function beforeAddTopMeetingTemplate(){
			 window.location.href="${sys_ctx}/detail/beforeAddTopMeetingTemplate.action";
		}

		/**
		*	打开修改模板页面
		*@param		${String}	id
		*@return	null	
		*/
		function templatebeforeModify(id){
			//window.showModalDialog("${sys_ctx }/detail/beforeModifyTopMeetingTemplate.action?templateVO.id="+id,window,'dialogWidth=600px;dialogHeight=450px;');
			location.href = "${sys_ctx }/detail/beforeModifyTopMeetingTemplate.action?templateVO.id="+id;
		}

		/**
		*删除高级模板
		*@param		${String}	id
		*@return	null	
		*/
		function templateMeetingDelete(id){
			if(!window.confirm("是否确认删除？")) return;
			window.location.href="${sys_ctx }/detail/deleteTopMeetingTemplate.action?templateVO.id="+id;
		}
		

        function pageInit(){
		    var obj = new htmlUtil();
			obj.title("templateName","请输入");	
		}
		
		function exportTemplateQuery(){
			document.getElementById('pageform').action="${sys_ctx}/detail/exportTopMeetingTemplateList.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/detail/manageTopMeetingTemplateList.action";
		}
		var a=1;//不让重复点击“立即召开”
		function addVideoMeeting(id){
			if(a==1){
			window.location.href="${sys_ctx}/detail/addVideoMeetingOnMcu.action?templateVO.id="+id;
			a=0;
			}else{
				alert("正在建会，请稍后再试！");
			}
		}
		function templateMeetingTree(id){
			window.showModalDialog("${sys_ctx }/meeting/template/templateMeetingTree.jsp?id="+id,window,'dialogWidth=600px;dialogHeight=450px;');
		}

		$(function(){
			$(".func_addVideoMeeting").click(function(){
				$(this).css("color","#CCC");
				$(this).unbind("click");
			});
		});
	</script>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit()">
	<form action="${sys_ctx}/detail/manageTopMeetingTemplateList.action" id="pageform" name="pageform" method="post">
	  <div id="basicform" class="contentwrapper"/>
	    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
          <tr>
            <td width="15%" class="tableaddtitle">模板名称</td>
            <td class="tableadd_data"><input id="templateName" name="templateVO.templateName" type="text" class="inputtran" value="${templateVO.templateName}"/></td>
            <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
     	  </tr>
        </table>
        <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()">
          <a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" /></a>
        </div>
      </div>
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;"  onclick="beforeAddTopMeetingTemplate();">添加 </a><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportTemplateQuery();"> 导出</a></h5>
      </div>
					
  	  <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th class="head1" width="8%" >序号</th>
            <th width="37%" class="head1">模板名称</th>
            <th width="16%" class="head1">会议时长</th>
         <!-- <th class="head1" width="16%">立即召开</th> -->
            <th width="23%" class="head1">操作</th>
          </tr>
        </thead>
	    <tbody>
			<c:forEach items="${templateList}" var="templateVO" varStatus="state">
				<tr>
					<td class="alc">
						<c:out value="${state.index+1}"></c:out>
					</td>
					<td>
						<c:out value="${templateVO.templateName }" />
					</td>
					<td> 
					    <c:choose>
					    	<c:when test="${templateVO.duration == '169' }">永久</c:when>
					    	<c:otherwise>${templateVO.duration}小时</c:otherwise>
					    </c:choose>
					</td>
					<!--  
					<td>
						<input type="button" class="stdbtn" value="立即召开" onclick="addVideoMeeting('${templateVO.id}');"/>
					</td>
					-->
					<td class="alc">
					    <a class="funcOper <%= FuncEnum.FUNC_NO_ADDVIDEOMEETING%>" style="cursor: pointer;" onclick="javascript:addVideoMeeting('${templateVO.id}');"/>立即召开  
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" style="cursor: pointer;" onclick="javascript:templatebeforeModify('${templateVO.id}');"/>修改  
						<a class="funcOper <%= FuncEnum.FUNC_NO_TEMPLATEMEETINGADD%>" style="cursor: pointer;" onclick="javascript:templateMeetingAdd('${templateVO.id}');" />配置  
						<a class="funcOper <%= FuncEnum.FUNC_NO_MEETINGTREE%>" style="cursor: pointer;" onclick="javascript:templateMeetingTree('${templateVO.id}');" />会议结构  
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" style="cursor: pointer;" onclick="javascript:templateMeetingDelete('${templateVO.id}');"/>删除
					</td>
				</tr>
			</c:forEach>
		  </tbody>
	    </table>
		
	  <jsp:include page="/common/pageFooter.jsp" />
	</form>
  </body>
</html>
