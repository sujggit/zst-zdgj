<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.TemplateEquipmentEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp"%>
	<title>会议组列表</title>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<script type="text/javascript">
		
	//function preAddEquipment(){
//	var groupId=$("#groupId").val();
	
	//window.showModalDialog("${sys_ctx}/templateEquipment/EquipmentQuery.action?templateEquipmentGroupVO.ID="+groupId,window,'dialogWidth=850px;dialogHeight=470px;');
	  
//	}
	
  	function preAddEquipment(){
		var groupId=$("#groupId").val();
		var returnValue=window.showModalDialog("${sys_ctx}/templateEquipment/EquipmentQuery.action?templateEquipmentGroupVO.ID="+groupId,window,'dialogWidth=850px;dialogHeight=470px;');
	    if(returnValue==1){
	    	window.location.href="${sys_ctx}/templateEquipment/MeetingEquipmentQuery.action?templateEquipmentGroupVO.ID="+groupId;
	    }  
	}
	
	function add(groupId){
		//var groupId=$("#groupId").val();
		//alert(groupId);
		window.location.href="${sys_ctx}/templateEquipment/preToAddMeeting.action?templateEquipmentGroupVO.ID="+groupId;
	}
	
	function radioGet(current,id,groupId){
		if(current.checked==false)
        {
			DwrMethod.cancelRadio(id,groupId);         
	   		return;
	     }
    	var radio=document.getElementsByName("radio");
    	for(var i=0;i<radio.length;i++){
     		radio[i].checked=false;
   		}
    	current.checked=true;
    	DwrMethod.setRadio(id,groupId);
	}
	
	function speakerSet(current,id,groupId){
   		if(current.checked==false)
        { 
	   		DwrMethod.cancelSpeaker(id,groupId);    
	   		return;
	   }
	   
      var radio=document.getElementsByName("speaker");
      for(var i=0;i<radio.length;i++){
     	radio[i].checked=false;
   	  }
      current.checked=true;
      DwrMethod.setSpeaker(id,groupId);
	}
	
	function setSpeakerAndRadio(){
		$("input[name='checkbox']")
	}
	
	function DelTemplateEquipment(id,groupId){
		if(!window.confirm("是否确认删除？")) return;
    	window.location.href="${sys_ctx}/templateEquipment/MeetingEquipmentDel.action?id="+id+"&templateEquipmentGroupVO.ID="+groupId;
	}
	
	function modifyTemplateEquipment(id,groupId){
		window.location.href="${sys_ctx}/templateEquipment/preMeetingEquipmentModify.action?id="+id+"&templateEquipmentGroupVO.ID="+groupId;
	}
	
	function goBack(){
		window.location.href="${sys_ctx}/templateEquipmentGroup/MeetingGroupQuery.action";
	}
	
	
	</script>
</head>
<body style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
	<form action="/icmp/templateEquipment/Query.action" method="post" name="pageform" id="pageform">
	  <div id="basicform" class="contentwrapper">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" align="center">
			<tr>
				<td width="15%" class="tableaddtitle">参会单位名称</td>
				<td class="tableadd_data">
				<input id="equipmentName" name="equipmentName" value="${equipmentName }" type="text" class="inputtran" />
				</td>
				<td class="tableaddtitle">
				<!--获得会场组id-->
					<input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" />
				</td>
			</tr>
		</table>
		<!--contenttitle-->
		<div class="widgetcontent">
			<div class="msgmore" onclick="disquery()";>
				<a href="javascript:void(0);"><img
						src="${sys_style1 }/images/calarrow_1.png" width="51" height="5"
						border="0" usemap="#Map" /> <map name="Map" id="Map">
						<area shape="rect" coords="2,-1,6,7" />
						<area shape="rect" coords="36,0,51,6" />
					</map> </a>
			</div>
		</div>
      <div class="contenttitle2">
        <h5 class="fwb fl10">当前为${templateEquipmentGroupVO.name}查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="add('${templateEquipmentGroupVO.ID}');">增加</a> |
        <a style="cursor: pointer;" onclick="preAddEquipment();" >地址簿</a>
        <input type="hidden" id="groupId" name="templateEquipmentGroupVO.ID" value="${templateEquipmentGroupVO.ID}"/>
		 |<a style="cursor: pointer;" onclick="goBack();">返回</a>				
        </h5>
        </div>
		<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
			<thead>
				<tr>
					<th class="head1" width="15%">
						序号
					</th>
					<th class="head1" width="30%">
						参会单位名称
					</th>
					<th class="head1" width="30%">
						ip
					</th>
                          <th class="head1" width="8%">
						广播者
					</th>
				   <th class="head1" width="8%">
						演讲者
					</th>
					 <th class="head1" width="9%">
						操作
					</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
			<tbody>
				<c:forEach items="${templateEquipmentVOList}"
					var="templateEquipmentVO" varStatus="status">
					<tr>

						<td class="alc">
							<c:out value="${status.index+1}"></c:out>
							
						</td>
						<td>
							<c:out value="${templateEquipmentVO.equipmentName}" />
						</td>
						<td>
							<c:out value="${templateEquipmentVO.equipmentIp}"></c:out>
						</td>
						<td>
						<input type="checkbox" name="radio"  <c:if test="${templateEquipmentVO.isMain=='1'||templateEquipmentVO.isMain=='3'}">checked</c:if>   onclick="radioGet(this,'${templateEquipmentVO.ID}','${templateEquipmentGroupVO.ID}');"/>
						</td>
						<td>
							<input type="checkbox" name="speaker" <c:if test="${templateEquipmentVO.isMain=='2'||templateEquipmentVO.isMain=='3'}">checked</c:if>  onclick="speakerSet(this,'${templateEquipmentVO.ID}','${templateEquipmentGroupVO.ID}');"/>
						</td>
                        <td class="alc">
						  <a style="cursor: pointer;" onclick="modifyTemplateEquipment('${templateEquipmentVO.ID}','${templateEquipmentGroupVO.ID}')">编辑</a> |
						  <a style="cursor: pointer;" onclick="DelTemplateEquipment('${templateEquipmentVO.ID}','${templateEquipmentGroupVO.ID}')">删除</a>
						</td>
					  </tr>
					</c:forEach>
				</tbody>
			</table>
			<jsp:include page="/common/pageFooter.jsp" />
	  </div>
	</form>
</body>
</html>
