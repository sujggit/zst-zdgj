<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>

<title>维修记录列表</title>
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
			*查询设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
//			function equipmentqeury(){
//			  document.getElementById("pageform").submit();
//			  var equipmentTypess= document.getElementById("equipmentType").value;
			  //  document.pageform.submit();
//		    }

            function pageInit(){
			    var obj = new htmlUtil();
				obj.title("equipmentType","请选择");	
				obj.title("meetingRoomName","请选择");	
			}
			//显示隐藏查询域
			function disquery(){
				$(".tableadd").slideToggle('fast');
			}
			function exportEquipment(){
				document.getElementById('pageform').action="${sys_ctx}/equipment/exportQuery.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/equipment/query.action";
			}

			//查看维修详情
			function maintainDetail(id){
				window.location.href="${sys_ctx}/equipment/maintainDetail.action?equipmentMaintainVO.equipmentID="+id;
			 	 
			}

			function exportEquipment(){
				document.getElementById('pageform').action="${sys_ctx}/equipment/exportEquipmentMaintain.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/equipment/queryEquipmentMaintain.action";
			}

		</script>
</head>
 <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/equipment/queryEquipmentMaintain.action" id="pageform" name="pageform" method="post">

<div id="basicform" class="contentwrapper">      
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <td width="15%" class="tableaddtitle">设备类型</td>
          <td width="35%" class="tableadd_data" >
         	 <select name="equipmentMaintainVO.equipmentVO.equipmentType" id="equipmentType" title="请选择" style="cursor:pointer" >
				     <zzst:option type="equipmentType" value="${equipmentMaintainVO.equipmentVO.equipmentType}" required="false"/>
			 </select>
          </td>
          <td width="15%" class="tableaddtitle">所属会议室</td>
          <td width="35%" class="tableadd_data">
          	<input type="hidden" name="equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" value="${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomID}"  />
          	<input type="text" class="inputtran" name="equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" value="${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName}" style="cursor:pointer"  onclick="selectConference(this)" readonly="readonly"/> 	
          </td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" /></td>
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
      <div id="contentwrapper" class="contentwrapper"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportEquipment();"> 导出</a></h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table" style="table-layout: fixed">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="12%" class="head1">设备名称</th>
            <th width="12%" class="head1">设备类型</th>
            <th width="8%" class="head1">维修次数</th>
            <th width="12%" class="head1">维修成本(元)</th>
            <th width="19%" class="head1">所属会议室</th>
            <th width="15%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${list}" var="equipmentMaintainVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentMaintainVO.equipmentVO.equipmentNO }"><c:out value="${equipmentMaintainVO.equipmentVO.equipmentNO}"/></td>
				<td >
					<zzst:lable type="equipmentType" 
							value="${equipmentMaintainVO.equipmentVO.equipmentType}">
					</zzst:lable>
			    </td>
				<td ><c:out value="${equipmentMaintainVO.maintainTime}"/></td>
                <td ><c:out value="${equipmentMaintainVO.sumCost}"/> 元</td>
                <td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName }">${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName }</td>
          	    <td class="alc">
          	       
          	        <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" style="cursor:pointer"  onclick="javascript:maintainDetail('${equipmentMaintainVO.equipmentID}');" >查看详细</a> 
          	   	</td>
				</tr>
				</c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    
 </form>
</body>


</html>
