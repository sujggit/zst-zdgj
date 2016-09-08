<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"%>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@ page import="com.zzst.model.enums.UserEnum" %>
<%@ page import="com.zzst.model.meeting.user.UserVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<script type='text/javascript'
			src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
		<script type='text/javascript'
			src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
		<title>模式添加</title>
		<% 
		UserVO uservo=(UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
		String createrID=uservo.getUserID();
		 %>
		<script type="text/javascript">
		//nullAlert
		
		
		function mcuCascadeModelPart1(){  
		$("#button").attr("disabled",true);	
			var bool=nameVal();
			if(bool==0){
			$("#button").attr("disabled","");	
			return;
			}
			var modeID = document.getElementsByName("modeID");//MCU模板
			var mainMcu = document.getElementsByName("description");//主MCU
			var mcus = document.getElementsByName("mcuName");//选择MCU
			var cascadeName = document.getElementById("cascadeName").value;//会议模式
			 //获得创建者id
			var cascadeCreater=document.getElementById("createrID").value; 
			var confModel = document.getElementById("confModel").value;
			
		   	var mcuIDs = "";
		   	var mainMcuID = "";
		   	var modeIDs = "";
			
			   for(var z=0; z<mcus.length; z++){
				   if(mcus[z].checked == true){
			   			if(mcuIDs != ""){
							mcuIDs += "_";
						}
						mcuIDs += mcus[z].value;
				   }
			   }
		
		
			   for(var k=0; k<mainMcu.length; k++){
				   if(mainMcu[k].checked == true){
			   			if(mainMcuID != ""){
							mainMcuID += "_";
						}
						mainMcuID += mainMcu[k].value;
				   }
			   }
			   
			   
			   for(var l=0; l<modeID.length; l++){
						if( !modeID[l].disabled ){
							if(modeIDs != ""){
							modeIDs += "_";
						    }
							modeIDs += modeID[l].value;
						}		
			  }

			   
			   if(mcuIDs !="" && mainMcuID != "" && modeIDs!="" && cascadeName != "" && cascadeCreater !="" && confModel!=""){
			  
				   	McuDwrMethod.addMode(mcuIDs,mainMcuID,modeIDs,cascadeName,cascadeCreater,confModel,function(status){
				   	
					   	if(status ==true){
					   		alert("保存成功");
					   	}else{
					   		alert("保存失败");
					   	}
				   });
			   }else{
			   		alert("信息不完整，请查看");
			   		$("#button").attr("disabled","");	
			   		return;
			   }
		}

		function checkInfo(id){
			if(document.getElementById(id).checked == true ){
			document.getElementById('description_'+id).disabled = false;
			document.getElementById('modeID_'+id).disabled = false;
			}else{
			document.getElementById('description_'+id).disabled = true;
			document.getElementById('description_'+id).checked = false;
			document.getElementById('modeID_'+id).disabled = true;
			document.getElementById('modeID_'+id).value = "";
			}	
		
		}
		
		
		function nameVal(){
		var cascadeName = document.getElementById("cascadeName").value;
		var c=document.getElementById("nullAlert");
		if(cascadeName==null||cascadeName==""){
		c.innerHTML="会议模式名称不能为空";
		 return 0;
		}
		 return 1;
		}
		
		
		function backHistory(){
			window.location.href="${sys_ctx}/mcuCascadeModel/query.action"
		}
   	</script>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<form action="${sys_ctx}/equipment/mcuAdd.action" id="addMcuForm" name="addMcuForm" method="post">
			<!--pageheader-->
			<div id="basicform" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						增加会议模式
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td width="5%" class="tableaddtitle">
							<span>*</span>会议模式
						</td>
						<td width="35%" class="tableadd_data"  title="请输入会议模式">
							<input maxlength="25" type="text" value="" name="mcuCascadeModelVO.cascadeName" class="input200 fontstyle" id="cascadeName"/><span id="nullAlert" style="color:red"></span>
						    <input type="hidden" value="<%=createrID%>" id="createrID" name="createrID"/>
						</td>
						
						
					</tr>
					<tr>
						<td width="5%" class="tableaddtitle">
							<span>*</span>建会方式
						</td>
						<td width="35%" class="tableadd_data"  title="请选择">
							<select name="mcuCascadeModelVO.confModel" id="confModel" style="width: 157px;">
								<zzst:option type="confModel" value=""/>
							</select><br/>
							<span style="color: red;">(说明:个人模式： 主会个人模式+从会级联点个人模式   &nbsp;  相同分屏模式: 主会相同分屏 + 从会级联点演讲者 &nbsp;   演讲者模式: 主会演讲者 + 从会级联点演讲者)</span>
						</td>
					</tr>
					
				</table>
				<table cellpadding="0" cellspacing="0" border="0"
					class="stdtable stdtablecb overviewtable2"  >
					
					<thead>
						<tr>
							<th width="10%" class="head1">
								序号
							</th>
							<th width="20%" class="head1">
								选择MCU
							</th>
							<th width="20%" class="head1">
								主MCU
							</th>
							<th width="20%" class="head1">
								MCUIP
							</th>
							<th width="30%" class="head1">
								MCU模板
							</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					
					
					 <%
          	List equipmentVOList = (List)request.getAttribute("equipmentVOList");
		    Map mcuEquipmentMap = (Map)request.getAttribute("mcuEquipmentMap");
		    
		    for(int i = 0 ;i<equipmentVOList.size();i++){
			    EquipmentVO equipmentVO = new EquipmentVO();
				equipmentVO = (EquipmentVO)equipmentVOList.get(i);
				ArrayList mcuEquipmentList = (ArrayList)mcuEquipmentMap.get(equipmentVOList.get(i));
		    %>
					
					
					<tbody>
						<tr>
							<td class="alc">
							<%=i+1 %>
							</td>
							<td>
							<input type="checkbox" name="mcuName" id="<%=equipmentVO.getEquipmentID() %>" value="<%=equipmentVO.getEquipmentID() %>" onclick="checkInfo('<%=equipmentVO.getEquipmentID() %>');" title="请先选择MCU"/>
							</td>
							<td>
								<input type="radio" name="description" value="<%=equipmentVO.getEquipmentID() %>" id="description_<%=equipmentVO.getEquipmentID() %>" disabled="disabled"/>
			      	     <%=equipmentVO.getEquipmentNO()%>
							</td>
							<td>
									<%=equipmentVO.getIp()%>
							</td>
							<td>
								<select name="modeID" disabled="disabled" class="select200 fontstyle" id="modeID_<%=equipmentVO.getEquipmentID() %>">
			      		
			      	<%  
			      	for(int j=0;j<mcuEquipmentList.size();j++){
			      		BaseInfoVO baseInfoVO = new BaseInfoVO();
			      		baseInfoVO = (BaseInfoVO)mcuEquipmentList.get(j);
			      		%>
			      		<option value="<%=baseInfoVO.getInfoValue() %>">
			      		<%=baseInfoVO.getDescription() %>
			      		</option>
			      		<%
			      	}
			      	%> 
		            </select>
							</td>
						</tr>
		<%
		    }
		  %>
					</tbody>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer"
					id="table2">
					<tfoot>
					</tfoot>
					<tbody>
						<tr>
							<td>
								<input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定"
									onclick="mcuCascadeModelPart1();" id="button"/>

								<input type="button" class="reset1 radius2" value="取 消"
									onclick="backHistory();" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</body>
</html>