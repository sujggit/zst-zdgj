<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <title>告示列表</title>
  <script type="text/javascript">	
		//add by chenshuo	
		function addNotice(){  
			window.location.href="${sys_ctx}/equipment/noticeBeforeAdd.action";
		}
		               
	       /**
	       *选择会议室
	       */
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
			/**
			*	查看设备管理详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDetail(id){
			
				window.showModalDialog("${sys_ctx}/equipment/noticeDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
          	}
			/**
			*	添加设备管理
			*@param		null
			*@param		null
			*/
			function addMeetingRoom(){
				 window.location.href="${sys_ctx}/equipment/add.action";
			}

			/**
			*	修改设备管理信息
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentModify(id){
					window.location.href="${sys_ctx}/equipment/noticeBeforeModify.action?equipmentVO.equipmentID="+id;
			}

			/**
			*删除设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/equipment/deleteNotice.action?equipmentVO.equipmentID="+id;
			}
			/**
			*查询设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentqeury(){
			  document.getElementById("pageform").submit();
			  var equipmentTypess= document.getElementById("equipmentType").value;
			  //  document.pageform.submit();
		    }

            function pageInit(){
			    var obj = new htmlUtil();
				obj.title("meetingRoomName","请输入");	
			}
			//显示隐藏查询域
			function disquery(){
				$(".tableadd").slideToggle('fast');
			}
			function exportEquipment(){
				document.getElementById('pageform').action="${sys_ctx}/equipment/exportQuery.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/equipment/queryNotice.action";
			}

			function equipmentMainTain(id){
				var re = window.showModalDialog("${sys_ctx}/equipment/equipmentMaintain.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=370px;');
				if( re == "1" ){
					window.location.reload();
				}
			}
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/equipment/queryNotice.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">      
  <!-- 
     <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <td width="15%" class="tableaddtitle">设备类型</td>
          <td width="35%" class="tableadd_data" >
         	 <select name="equipmentVO.equipmentType" id="equipmentType" title="请选择" style="cursor:pointer" >
				 <zzst:option type="equipmentType" value="${equipmentVO.equipmentType}" required="false"/>
			 </select>
          </td>
          <td width="15%" class="tableaddtitle">所属会议室</td>
          <td width="35%" class="tableadd_data">
          	<input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" value="${equipmentVO.meetingRoomVO.meetingRoomID}"  />
          	<input type="text" class="inputtran" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" value="${equipmentVO.meetingRoomVO.meetingRoomName}" style="cursor:pointer"  onclick="selectConference(this)"/> 	
          </td>
          <td class="tableaddtitle"><input type="button" class="searchbtn radius2" value="查 询" onclick="equipmentqeury();" /></td>
        </tr>
      </table>
      
      
      <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
       -->
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="addNotice();">增加</a> </h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="15%" class="head1">设备名称</th>
            <th width="15%" class="head1">设备类型</th>
            <th width="15%" class="head1">设备mac</th>
            <th width="19%" class="head1">所属会议室</th>
            <th width="15%" class="head1">状态</th>
            <th width="15%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${equipmentVOList}" var="equipmentVO" 	varStatus="state">
			<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentVO.equipmentNO}"/></td>
				<td>
					<zzst:lable type="equipmentType" value="${equipmentVO.equipmentType}">
					</zzst:lable>
			    </td>
				<td><c:out value="${equipmentVO.mac}"/></td>
                <td><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"/></td>
                <td><zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable></td>
          	    <td class="alc">
          	        <a onclick="javascript:equipmentDetail('${equipmentVO.equipmentID}');" >查看</a> |
          	    	<a onclick="javascript:equipmentModify('${equipmentVO.equipmentID}');"  >修改</a> | 
          	    	<!--  
          	    	<a onclick="javascript:equipmentMainTain('${equipmentVO.equipmentID}');" >维护</a> |
          	    	-->
          	        <a onclick="javascript:equipmentDele('${equipmentVO.equipmentID}');" >删除</a>
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
