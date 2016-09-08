<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@include file="/common/common.jsp"%>
	<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
	<title>巡检管理列表</title>
	<script type="text/javascript">
		/**
		*	查看维护情况详细信息
		*@param		${String}	id
		*@return	null	
		*/
		function meetingRoomMaintainDetail(id){
			window.showModalDialog("${sys_ctx }/meetingRoomMaintain/detail.action?meetingRoomMaintainVO.maintainID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
		}

		/**
		*	添加单位维护名称
		*@param		null
		*@param		null
		*/
		function addMeetingRoomMaintain(){
			 window.location.href="${sys_ctx }/meetingRoomMaintain/addBefore.action";
		}

		/**
		*	修改单位系统维护详细信息
		*@param		${String}	id
		*@return	null	
		*/
		function meetingRoomMaintainModify(id){
			window.location.href="${sys_ctx }/meetingRoomMaintain/modifyBefore.action?meetingRoomMaintainVO.maintainID="+id;
		}

		/**
		*删除单位系统维护 详细 信息 
		*@param		${String}	id
		*@return	null	
		*/
		function meetingRoomMaintainDele(id){
			if(!window.confirm("是否确认删除？")) return;
			window.location.href="${sys_ctx }/meetingRoomMaintain/delete.action?meetingRoomMaintainVO.maintainID="+id;
		}

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
		/*function exportRoom(){
			document.getElementById('pageform').action="${sys_ctx}/meetingRoom/exportQuery.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/meetingRoom/query.action";
		}*/
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/meetingRoomMaintain/query.action" id="pageform" name="pageform" method="post">
   <div class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" >
        <tr>
          <td class="tableaddtitle">会场名称</td>
          <td class="tableadd_data">
             <input type="text" class="inputtran" name="meetingRoomMaintainVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" readonly="readonly"  onclick="selectConference(this);" value="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName }"/>
             <input type="hidden" name="meetingRoomMaintainVO.roomID" id="meetingRoomID" class="" value="${meetingRoomMaintainVO.roomID }" />
          </td>
          <td class="tableaddtitle"><input type="button"  class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
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
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" onclick="addMeetingRoomMaintain();" style="cursor:pointer">增加  </a><span><!--  </span><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" onclick="exportLog();" style="cursor:pointer">导出</a> --></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="38%" class="head1">会场名称</th>
            <th width="38%" class="head1">维护人员</th>
            <th width="16%" class="head1">操作</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${meetingRoomMaintainVOList}" var="meetingRoomMaintainVO" varStatus="state">
              <tr>
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td><c:out value="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName}" /></td>
	            <td><c:out value="${meetingRoomMaintainVO.maintainUserName}" /></td>
	            <td class="alc"><a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:meetingRoomMaintainDetail('${meetingRoomMaintainVO.maintainID}');" >查看</a>   <a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:meetingRoomMaintainModify('${meetingRoomMaintainVO.maintainID}');">修改</a>   <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:meetingRoomMaintainDele('${meetingRoomMaintainVO.maintainID}');">删除</a></td>
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
