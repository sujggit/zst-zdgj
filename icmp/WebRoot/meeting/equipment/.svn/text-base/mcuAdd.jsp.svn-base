<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>MCU添加</title>

<!--[if IE]><script type="text/javascript" src="../../js/jquery.bgiframe.min.js"></script><![endif]-->


<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="../../css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="../../css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="../../js/css3-mediaqueries.js"></script>
<![endif]-->
<script type="text/javascript">
<%
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
Date date=new Date();
%>
function backHistory(){
	window.location.href="${sys_ctx}/equipment/query.action";
}
function pageInit(){
			    var obj = new htmlUtil();
			    //obj.title("equipmentType","请选择");	
			    //obj.title("equipmentName","输入不超过25个字符");
			    obj.title("equipmentModel","请选择");
			    obj.title("equipmentNO","不超过25个字符");
			    obj.title("ip","输入正确的IP");	
			    //obj.title("allResourceNumber","输入10000内整数");	
			    //obj.title("createDate","请输入");	
			    //obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
				obj.title("loginNamesss","请选择");
				obj.title("commandIP","输入正确的IP");	
			    obj.title("description","不超过500个字符");
			    obj.title("loginName","输入用户名");
			    obj.title("loginPassword","输入密码");
			    //obj.title("equipmentNO","请输入显示名称,输入长度不超过25个字符");
			    obj.title("equipmentIdentifier","不超过25个字符");	
			    obj.title("serialNumber","不超过25个字符");
			    obj.title("port","输入10000内整数");
			    obj.title("allResourceNumber","输入10000内整数");
			    var templateTd = document.getElementById("equipmentType");
			    getEquipmentName(templateTd);
			
			}
function equipmentMcuAdd(){
      $('#addMcuForm').validate({    
		rules:{    
		   "equipmentVO.equipmentType" : {
		           required:true
		           },
		     "equipmentVO.equipmentName" : {
		           required:true,
		           minlength:1,
		           maxlength:25  
		           },
		    "equipmentVO.equipmentModel" : {
		           required:true,
		           minlength:1,
		           maxlength:25  
		           },
		    "equipmentVO.equipmentNO" : {
		    	   required:true,	
		           minlength:1,
		           maxlength:25  
		           },
		     "equipmentVO.ip" : {
		          required:true,
		           minlength:1,
		           maxlength:25,
		           checkIP:true
		           },
		       "equipmentVO.port" : {
			           digits:true,
			           range:[0,10000]
			           },
			   "equipmentMcuVO.allResourceNumber" : {
			           digits:true,
			           range:[0,10000]
			           },
		       "equipmentVO.meetingRoomVO.meetingRoomName" : {
		           required:true
		           },
		         "equipmentVO.userVO.name" : {
		           required:true
		           },
		           "equipmentMcuVO.commandIP":{
		            required:true,
		             minlength:1,
		            maxlength:25,
		            checkIP:true
		           },
		       "equipmentMcuVO.loginName" : {
		             required:true,
		            minlength:1,
		            maxlength:25
		           },
		        "equipmentMcuVO.loginPassword" : {
		            required:true,
		            minlength:1,
		            maxlength:25
		           },
		        "equipmentVO.description" : {
		           minlength:1,
		           maxlength:500  
		           },
	           "equipmentVO.serialNumber":{
		            minlength:1,
		           maxlength:25 
		        },
		        "equipmentVO.equipmentIdentifier":{
		            minlength:1,
		           maxlength:25 
		        }
		           
		} 
	  });
	  

		if( $('#addMcuForm').valid()){
         $('#addMcuForm').submit();
         $("#button").attr("disabled",true);
         }
 }  
 	/**
		*	选择人员
		*@return	null	
		*/
       	
	  function selectUsers(thisDom){
     	 var userParameters = {
          methodName:'getReturnUserMethod',
          selectType:'radio'
     	 }
     	creatUserSelect(thisDom,userParameters); 
  	}
  function getReturnUserMethod(userArray){
      var userID="";
      var loginName="";
      var userLength = userArray.length;
      for(var i=0;i<userLength;i++){
    	  userID=userArray[i].userID;
    	  loginName=userArray[i].userName;
      }
  	$("#userID").attr("value",userID);
   	$("#loginNamesss").attr("value",loginName);
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
	 // alert(conferenceArray[0].conferenceID);
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

	function getEquipmentName(op){
			var mcuId = op.value;
			var templateTd = document.getElementById("equipmentName_");
			var html ="<select name='equipmentVO.equipmentName' class='inputtran' id='equipmentName' title='请选择' onchange='getEquipmentModel(this)'><option value=''>请选择...</option>";
			DwrMethod.getDicNameByDicID(mcuId,function cb(rs){
				    if( rs != null ){
				    	html += rs;
				    	html += "</select>";
						templateTd.innerHTML=html;
					}
				});
		}

	function getEquipmentModel(op){
			var mcuId = op.value;
			if(mcuId.length>0){
				var templateTd = document.getElementById("equipmentModel_");
				var html ="<select name='equipmentVO.equipmentModel' class='inputtran' id='equipmentModel' title='请选择'><option value=''>请选择...</option>";
				DwrMethod.getDicNameByDicID(mcuId,function cb(rs){
				    if( rs != null ){
				    	html += rs;
				    	html += "</select>";
						templateTd.innerHTML=html;
					}
				});
			}else if(mcuId==null||mcuId==""){
				var templateTd = document.getElementById("equipmentModel_");
				var html ="<select name='equipmentVO.equipmentModel' class='inputtran' id='equipmentModel' title='请选择' onclick='checkEquipmentName()'><option value=''>请选择...</option></select>";
				templateTd.innerHTML=html;
	 		}
		}

	function checkEquipmentName(){
		alert("请选择设备厂家");
	}

	//控制参数默认隐藏
	function toggle(id){
		var tb=document.getElementById(id);
		if(tb.style.display=='none') tb.style.display='block';
		else tb.style.display='none';
	}
</script>
</head>
  
  
  <body onload="pageInit();" STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx}/equipment/mcuAdd.action" id="addMcuForm" name="addMcuForm" method="post">
   <div id="basicform" class="contentwrapper"> 
  <div id="m" style="background:none;border:none">
     <%@include file="./equipmentAddHead.jsp"%>
   </div>
   
                <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                    <tr>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备类型</td>
                      <td width="35%" class="tableadd_data" >
                      <select name="equipmentVO.equipmentType" id="equipmentType" class="inputtran" disabled="disabled">
						<zzst:option type="equipmentEnum" value="1" required="true"/>
			   		  </select>  
                      </td>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备厂家</td>
                      <td width="35%" class="tableadd_data"  id="equipmentName_">
                      <select name="equipmentVO.equipmentName" id="equipmentName" class="inputtran" onchange="getEquipmentModel(this)">
	              		<option value="">请选择...</option>
	      			  </select>       
                      </td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>设备型号</td>
                      <td class="tableadd_data" id="equipmentModel_">
                      <select name="equipmentVO.equipmentModel" id="equipmentModel" class="inputtran" onclick="checkEquipmentName()">
							<option value="">请选择...</option>
			   		  </select>
                      </td>
                      <td class="tableaddtitle"><span>*</span>设备名称</td>
                      <td class="tableadd_data">
                      <input type="text" maxlength="25" name="equipmentVO.equipmentNO" onblur="javascript:checkNames('equipmentNO');" id="equipmentNO" class="inputtran"  />
                      </td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>管理IP</td>
                      <td class="tableadd_data" >
                      <input type="text" maxlength="25" class="inputtran" name="equipmentVO.ip" id="ip" onblur="javascript:check('ip');"/>
                      </td>
                      <td class="tableaddtitle"><span>*</span>所属会议室</td>
                      <td class="tableadd_data" >
                      <input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" />
                      <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly" onclick="selectConference(this)"/>
                      </td>
                      
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>信令IP</td>
                      <td class="tableadd_data" >
                      <input id="commandIP" maxlength="25" name="equipmentMcuVO.commandIP" value="" type="text" class="inputtran" onblur="javascript:checkCommandIP('commandIP');" />
                      </td>
                      <td class="tableaddtitle"><span>*</span>管理员</td>
                      <td class="tableadd_data">
                      <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="inputtran" value="${userID}"/>
                       <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly"  onclick="selectUsers(this)" value="${userName }"/>        
                      </td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>用户名</td>
                      <td class="tableadd_data" >
                      <input type="text" maxlength="25" name="equipmentMcuVO.loginName" id="loginName" class="inputtran" />
                      </td>
                      <td class="tableaddtitle"><span>*</span>密码</td>
                      <td class="tableadd_data">
                       <input type="password" maxlength="25" name="equipmentMcuVO.loginPassword" id="loginPassword" class="inputtran" />
                      </td>
                    </tr>
                    
                    <tr>
			          <td class="tableaddtitle">维保开始日期</td>
			          <td class="tableadd_data" >
			          	 <input name="equipmentVO.maintenanceStartTime" class="inputtran" id="maintenanceStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value="<%=sdf.format(date) %>"/>
			          </td>
			          <td class="tableaddtitle">期限</td>
			          <td class="tableadd_data">
			          	<select class="inputtran"  name="equipmentVO.maintenanceMonths" id="maintenanceMonths">
			    <%--<option value="23">请选择...</option>--%>
			    <%--<option value="0.05" ${meetingDetailVO.meetingDescription=="0.05" ? "selected" : "" }>0.05</option>--%>
						    <zzst:option type="maintenanceStartTime" value="" />
			    		</select> 
			          </td>
			        </tr>
			        <tr>
			          <td class="tableaddtitle">资产编号</td>
			          <td class="tableadd_data" ><input type="text" maxlength="25" name="equipmentVO.equipmentIdentifier" id="equipmentIdentifier" class="inputtran" value="" /></td>
			          <td class="tableaddtitle">序列号</td>
			          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.serialNumber" id="serialNumber" class="inputtran" value="" /></td>
        		   </tr>
        		   <tr>
                      	<td class="tableaddtitle">资源总数</td>
                      	<td class="tableadd_data" colspan="3">
                      		<input type="text" maxlength="25" name="equipmentMcuVO.allResourceNumber" id="allResourceNumber" class="inputtran" value="100" />
                      	</td>
                      </tr>
                    <tr>
                      <td class="tableaddtitle">设备描述</td>
                       <td colspan="3" class="tableadd_data" ><textarea name="equipmentVO.description" rows="5" class="areatran" id="description"></textarea></td>
                      </tr>
                      <tr>
                      	<td class="tableaddtitle">控制参数</td>
                      	<td class="tableadd_data" colspan="3">
                      		<input type="checkbox" value="1" onClick="toggle('table1')" id="isCheck" name="equipmentMcuVO.isCheck"/>              
                      	</td>
                      </tr>
                  </table>
                  <table id="table1" class="tableadd" width="100%" border="0" cellspacing="1" cellpadding="0" style="display:none">
                      			<tr>
                      				<td width="15%" class="tableaddtitle">呼叫方式方向</td>
			          				<td width="35%" class="tableadd_data" >
			          					<select id="dialingDirection" name="equipmentMcuVO.dialingDirection" class="inputtran">
											<zzst:option type="dialingDirection" value=""/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">类型</td>
			          				<td class="tableadd_data" >
			          					<select id="dialingType" name="equipmentMcuVO.dialingType" class="inputtran">
											<zzst:option type="dialingType" value=""/>
										</select>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">分辨率</td>
			          				<td class="tableadd_data" >
			          					<select id="maxPesolution" name="equipmentMcuVO.maxPesolution" class="inputtran">
											<zzst:option type="maxPesolution" value=""/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">别名/类型</td>
			          				<td class="tableadd_data" >
			          					<input type="text"  name="equipmentMcuVO.aliasName" id="aliasName" maxlength="25" class="inputtran"/>
										<select style="width:100px;" name="equipmentMcuVO.aliasType" id="aliasType" class="inputtran">
											<zzst:option type="aliasType" value=""/>
										</select>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">视频协议</td>
			          				<td class="tableadd_data" >
			          					<select name="equipmentMcuVO.videoTreaty" id="aliasType" class="inputtran">
											<zzst:option type="videoTreaty" value=""/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">连接速率</td>
			          				<td class="tableadd_data" >
			          					<select name="equipmentMcuVO.speed" id="speed" class="inputtran">
											<zzst:option type="speed" value=""/>
										</select>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">级联</td>
			          				<td class="tableadd_data" >
			          					<select id="cascadeRole" name="equipmentMcuVO.cascadeRole" class="inputtran">
											<zzst:option type="cascadeRole" value=""/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">端口号</td>
			          				<td class="tableadd_data" >
			          					<input type="text" maxlength="25" name="equipmentVO.port" id="port" class="inputtran" value="24" />
			          				</td>
                      			</tr>
                      		</table>
                  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
                    <tfoot>
                    </tfoot>
                    <tbody>
                      <tr>
                        <td>
                        
                           <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" name="button" id="button" onclick="equipmentMcuAdd();"/>
                          <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
                        </td>
                      </tr>
                    </tbody>
                </table>            
            </div>
            </form>
  </body>
