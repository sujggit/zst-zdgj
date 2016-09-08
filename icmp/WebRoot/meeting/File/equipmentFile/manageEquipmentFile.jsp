<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <title>设备资料列表</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/file/manageEquipmentFileList.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">      
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
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="equipmentqeury();" /></td>
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
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportEquipment();">导出</a></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="%" class="head1">设备名称</th>
            <th width="88px" class="head1">设备类型</th>
            <th width="122px" class="head1">设备IP</th>
            <th width="%" class="head1">所属会议室</th>
            <th width="88px" class="head1">状态</th>
            <th width="166px" class="head1">操作</th>
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
				<td><c:out value="${equipmentVO.ip}"/></td>
                <td><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"/></td>
                <td><zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable></td>
          	    <td class="alc">
          	        <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:equipmentDetail('${equipmentVO.equipmentID}','${equipmentVO.equipmentType}');" >查看</a>  
          	    	<a class="funcOper <%= FuncEnum.FUNC_NO_UPLOAD%>" onclick="javascript:fileuploadload('${equipmentVO.equipmentNO}','${equipmentVO.equipmentID}');" />上传
          	   	</td>
			</tr>
		  </c:forEach>
        </tbody>
      </table>
    </div>
 </form>
 <script type="text/javascript">
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
		function equipmentDetail(id,id2){
		  if(id2==1){
			window.showModalDialog("${sys_ctx}/equipment/mcuDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		 }else if(id2==0){
			window.showModalDialog("${sys_ctx}/equipment/terminalDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}else if(id2==2){
			window.showModalDialog("${sys_ctx}/equipment/controlDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}else if(id2==4){
			window.showModalDialog("${sys_ctx}/equipment/noticeDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}else if(id2==5){
			window.showModalDialog("${sys_ctx}/equipment/QBoxDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}
		else if(id2==6){
			window.showModalDialog("${sys_ctx}/equipment/microphoneDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}
		else if(id2==7){
			window.showModalDialog("${sys_ctx}/equipment/videoCardDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}else if( id2==8 ){
			window.showModalDialog("${sys_ctx}/equipment/otherEquipmentDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
		}
			
         }

		/**
		*查询设备管理详细 信息 
		*@param		${String}	id
		*@return	null	
		*/
		function equipmentqeury(){
		  document.getElementById("pageform").submit();
		  var equipmentTypess= document.getElementById("equipmentType").value;
	    }

		function exportEquipment(){
			document.getElementById('pageform').action="${sys_ctx}/equipment/exportQuery.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/equipment/query.action";
		}

		function fileuploadload(name,id){
			 var result = window.showModalDialog("${sys_ctx }/meeting/File/equipmentFile/equipmentFileUpload.jsp?name="+name+"&id="+id,window,'dialogWidth=700px;dialogHeight=470px;');
	    	 //window.showModalDialog("${sys_ctx }/meeting/conferenceManager/upload.jsp",window,'dialogWidth=600px;dialogHeight=470px;');
			 if( result == "1" ){
					window.location.href = "${sys_ctx }/file/equipmentFileDownloadList.action";
			 }
		 }
	</script>
</body>
</html>
