<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>模板会议信息添加 </title>
		<script type="text/javascript">
		
		function backHistory(){
        	window.location.href="${sys_ctx}/detail/getTopMeetingList.action?templateVO.id=${templateMeetingVO.templateId }";
        }

		//获取会议模板
		function getTemplateByMcu(op){
				var mcuId = op.value;
				var templateTd = document.getElementById("templateTd");
				var html ="<select name='templateMeetingVO.mcuTemplateID' class='inputtran' id='templateId'>";
				DwrMethod.getTemplateByMcuIp(mcuId,function cb(rs){
					    if( rs != null ){
					    	html += rs;
					    	html += "</select>";
							templateTd.innerHTML=html;
						}
					});
			}
		
		
		//add by chenshuo
		function pageInit(){
			    var obj = new htmlUtil();
				obj.title("meetingName","输入长度不超过25个字符");	
				obj.title("templateId","请选择");
				obj.title("mcuEquipmentId","请选择");	
				obj.title("meetingNumber","输入数字,最小4位");
				obj.title("groupId","请选择");
				obj.title("templateTd","请选择");
				var templateTd = document.getElementById("mcuEquipmentId");
				getTemplateByMcu(templateTd);

			}
			
			//modify by chenshuo
			function addMeeting(){
					$('#form').validate({    
					rules:{ 
								"templateMeetingVO.meetingName": 
									{
									required: true,
									minlength:1,
					           		maxlength:25
									}, 
								"templateMeetingVO.templateId":{
									required: true
								},
								"templateMeetingVO.mcuEquipmentId":{
									required:true
								},
								"templateMeetingVO.meetingNumber":{
									required: true,
					           		number: true,
					           		minlength:4
								},
								"templateMeetingVO.groupId":   {
									required: true
					           		}
						  	}
						});
					$("#form").submit();
				}
				
			function disableParent(op){
				  if( op.checked ){
					  document.getElementById("parentId").disabled="disabled";
				  }else{
					  document.getElementById("parentId").disabled="";
					 }
				}
			</script>

</head>
	<body  onload="pageInit();">
	<div id="basicform" class="contentwrapper">
		<form action="${sys_ctx }/detail/addMeetingInfo.action" 	method="post" name="form" id="form">
		<input type="hidden" value="${templateMeetingVO.templateId }" name="templateMeetingVO.templateId"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">模板增加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
          <td width="35%" class="tableadd_data" >
          	<input id="meetingName" type="text" class="inputtran" name="templateMeetingVO.meetingName" />
          </td>
		  <td width="15%" class="tableaddtitle"><span>*</span>会议号码</td>
          <td width="35%" class="tableadd_data"><input name="templateMeetingVO.meetingNumber" id="meetingNumber" type="text" class="inputtran" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>建会MCU</td>
          <td class="tableadd_data">
          	<select name="templateMeetingVO.mcuEquipmentId" class="inputtran" id="mcuEquipmentId" onchange="getTemplateByMcu(this)">
				<c:forEach items="${mcuList}" var="mcuVO">
					<option value="${mcuVO.equipmentID}">
						${mcuVO.equipmentNO}
					</option>
				</c:forEach>
			</select>
          </td>
          <td class="tableaddtitle"><span>*</span>会议模板</td>
          <td class="tableadd_data" id="templateTd">
          	 <select name="templateMeetingVO.mcuTemplateID" class="inputtran" id="templateId">
          	 	<option value="-1">请选择MCU</option>
          	 </select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">是否主会</td>
          <td class="tableadd_data" ><input name="templateMeetingVO.isMain" id="isMain" type="checkbox" class="" value="1" onclick="disableParent(this)"/></td>
          <td class="tableaddtitle">上联会议</td>
          <td class="tableadd_data">
          	 <select name="templateMeetingVO.parentId" class="inputtran" id="parentId">
          	 	<c:forEach items="${tmList}" var="templateMeetingVO">
					<option value="${templateMeetingVO.id}">
						${templateMeetingVO.meetingName}
					</option>
				 </c:forEach>
          	 </select>
          </td>
        </tr>
        <tr>
          <!--<td class="tableaddtitle"><span>*</span>建会顺序</td>
          <td class="tableadd_data" ><input name="templateMeetingVO.rank" id="rank" type="text" class="inputtran" /></td> -->
          <td class="tableaddtitle"><span>*</span>参会会场组</td>
          <td class="tableadd_data" colspan="3">
          	 <select name="templateMeetingVO.groupId" class="inputtran" id="groupId">
          	 	<c:forEach items="${tegList}" var="tegVO">
					<option value="${tegVO.ID}">
						${tegVO.name}
					</option>
				</c:forEach>
          	 </select>
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="addMeeting();"/>
              
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
              </td>
          </tr>
        </tbody>
      </table>
      
      <!--contenttitle--> 
    
  </form>
  </div>
  
</body>

</html>