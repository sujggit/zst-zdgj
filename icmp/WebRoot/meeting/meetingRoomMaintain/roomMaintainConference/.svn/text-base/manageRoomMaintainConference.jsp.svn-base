<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@include file="/common/common.jsp"%>
	<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
	<title>巡检管理列表</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/meetingRoomMaintain/manageRoomMaintainConference.action" id="pageform" name="pageform" method="post">
   <div class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" >
        <tr>
          <td class="tableaddtitle" width="15%">会议名称</td>
          <td class="tableadd_data" width="35%">
             <input class="inputtran" name="meetingRoomMaintainVO.meetingDetailVO.meetingName" id="meetingName" value="${meetingRoomMaintainVO.meetingDetailVO.meetingName }" title="请输入会议名称"/>
          </td>
          <td class="tableaddtitle" width="15%">会场名称</td>
          <td class="tableadd_data" width="35%">
             <input class="inputtran" name="meetingRoomMaintainVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" readonly="readonly" onclick="selectRoom(this);" value="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName }" title="请选择"/>
             <input type="hidden" name="meetingRoomMaintainVO.roomID" id="meetingRoomID" value="${meetingRoomMaintainVO.roomID }" />
          </td>
          <td class="tableaddtitle" rowspan="3"><input type="button"  class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle">检查项</td>
          <td class="tableadd_data">
             <select name="meetingRoomMaintainVO.meetingRoomMaintainDetailVO.maintainName">
                <option value="">请选择</option>
				<c:forEach items="${dListType}" var="dictionaryVO1" varStatus="state1">
				  <option value="${dictionaryVO1.dicViewName }" ${dictionaryVO1.dicViewName==meetingRoomMaintainVO.meetingRoomMaintainDetailVO.maintainName ? "selected" : "" }>${dictionaryVO1.dicViewName }</option>
				</c:forEach>
			 </select>
		  </td>
		  <td class="tableaddtitle">状态</td>
          <td class="tableadd_data">
             <select name="meetingRoomMaintainVO.meetingRoomMaintainDetailVO.description">
                <option value="">请选择</option>
				<c:forEach items="${dListStatus}" var="dictionaryVO2" varStatus="state2">
				  <option value="${dictionaryVO2.dicViewName }" ${dictionaryVO2.dicViewName==meetingRoomMaintainVO.meetingRoomMaintainDetailVO.description ? "selected" : "" }>${dictionaryVO2.dicViewName }</option>
				</c:forEach>
			 </select>
		  </td>
        </tr>
        <tr>
          <td class="tableaddtitle">会议开始时间</td>
          <td class="tableadd_data"><img src="${sys_ctx}/style/normal/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input class="inputtran" id="meetingStartTime" name="meetingRoomMaintainVO.meetingDetailVO.meetingStartTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingRoomMaintainVO.meetingDetailVO.meetingStartTime }" pattern="yyyy-MM-dd HH:mm"/>' readonly="readonly"/>
          </td>
          <td class="tableaddtitle">检查起止时间</td>
          <td class="tableadd_data"><!-- <img src="${sys_ctx}/style/normal/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
           <input class="inputtran" name="meetingRoomMaintainVO.createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingRoomMaintainVO.createTime }" pattern="yyyy-MM-dd HH:mm"/>' readonly="readonly"/> --> 
            <input name="meetingRoomMaintainVO.createTime" id="startTime" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingRoomMaintainVO.createTime }" pattern="yyyy-MM-dd HH:mm"/>'/>
          --        
           <input name="meetingRoomMaintainVO.endTime" id="endTime"	readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingRoomMaintainVO.endTime }" pattern="yyyy-MM-dd HH:mm"/>'/>
          </td>
        </tr>
      </table>
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" onclick="exportQuery();">导出</a></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="%" class="head1">会场名称</th>
            <th width="%" class="head1">会议名称</th>
            <th width="122px" class="head1">会议时间</th>            
            <%--<th width="122px" class="head1">检查项</th>--%>
            <%--<th width="88px" class="head1">状态</th>--%>
            <th width="88px" class="head1">检查人</th>
            <th width="122px" class="head1">检查时间</th>
            <th width="122px" class="head1">操作</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${meetingRoomMaintainVOList}" var="meetingRoomMaintainVO" varStatus="state">
              <tr>
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td><c:out value="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName}" /></td>
                <td><c:out value="${meetingRoomMaintainVO.meetingDetailVO.meetingName}" /></td>
                <td><fmt:formatDate value="${meetingRoomMaintainVO.meetingDetailVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/></td>                
                <%--<td><c:out value="${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.maintainName}" /></td>--%>
                <%--<td><c:out value="${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.description}" /></td>--%>
                <td><c:out value="${meetingRoomMaintainVO.maintainUserName}" /></td>
                <td><fmt:formatDate value="${meetingRoomMaintainVO.createTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
	            <td class="alc"><a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="meetingRoomMaintainDetailNew('${meetingRoomMaintainVO.meetingRoomVO.meetingRoomID}','${meetingRoomMaintainVO.meetingDetailVO.meetingDetailID }');" >查看</a></td>
              </tr>
	      </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    </div>
  </form>
  <script type="text/javascript">
		/**
		*	查看维护情况详细信息
		*@param		${String}	id
		*@return	null	
		*/
		function meetingRoomMaintainDetail(rooID,detailID){
			//window.showModalDialog("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceDetail.action?meetingRoomMaintainVO.maintainID="+maintainID+"&meetingRoomMaintainVO.meetingRoomMaintainDetailVO.detailID="+detailID,window,'dialogWidth=680px;dialogHeight=470px;');
			window.showModalDialog("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceDetail.action?meetingRoomMaintainVO.meetingRoomVO.meetingRoomID="+rooID+"&meetingRoomMaintainVO.meetingRoomMaintainDetailVO.detailID="+detailID,window,'dialogWidth=680px;dialogHeight=470px;');
		}

		/**
		*	查看维护情况详细信息
		*@param		${String}	id
		*@return	null	
		*/
		function meetingRoomMaintainDetailNew(rooID,detailID){
			window.showModalDialog("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceDetailNew.action?meetingRoomMaintainVO.meetingRoomVO.meetingRoomID="+rooID+"&meetingRoomMaintainVO.meetingRoomMaintainDetailVO.detailID="+detailID,window,'dialogWidth=680px;dialogHeight=470px;');
			//window.showModalDialog("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceDetailNew.action?meetingRoomMaintainVO.maintainID="+maintainID,window,'dialogWidth:780px;dialogHeight:470px;');
		}
       /**
	     *选择会议室
	     */
	    function selectRoom(thisDom){
	        var conferenceParameters = {
	            methodName:'getReturnRoomMethod',
	            selectType:'radio'
	        }
	       creatConferenceSelect(thisDom,conferenceParameters); 
	    }
	    function getReturnRoomMethod(conferenceArray){
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
		function exportQuery(){
			if(!($("#meetingStartTime").val()||$("#startTime").val()||$("#endTime").val())){
				if(!window.confirm("未选择时段，导出时间可能很长，是否继续导出？")) return;
			}
			document.getElementById('pageform').action="${sys_ctx}/meetingRoomMaintain/exportQuery5K.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/meetingRoomMaintain/manageRoomMaintainConference.action";
		}
	</script>
</body>
</html>
