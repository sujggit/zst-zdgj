<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>其他设备添加</title>
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
			   // obj.title("equipmentName","输入长度不超过25个字符");
			    obj.title("equipmentModel","请选择");
			    obj.title("equipmentNO","不超过25个字符");
			    obj.title("ip","输入正确的IP格式");	
			    obj.title("port","输入10000内整数");	
			    obj.title("mac","不超过25个字符");
			    obj.title("createDate","请输入");	
			    obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
				obj.title("loginNamesss","请选择");
			    obj.title("description","不超过500个字符");
			    //obj.title("equipmentNO","请输入显示名称,输入长度不超过25个字符");
			    obj.title("equipmentIdentifier","不超过25个字符");	
			    obj.title("serialNumber","不超过25个字符");	
			    var templateTd = document.getElementById("equipmentType");
			    getEquipmentName(templateTd);
			}
function equipmentAdd(){
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
		           required:true,
		           digits:true,
		           range:[0,10000]
		           },
	           "equipmentVO.mac" : {
		           required:true,
		           minlength:1,
		           maxlength:25
		           },
		       "equipmentVO.status" : {
		           required:true
		           },
		       "equipmentVO.meetingRoomVO.meetingRoomName" : {
		           required:true
		           },
		         "equipmentVO.userVO.name" : {
		           required:true
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
</script>
</head>
  <body onload="pageInit();" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx}/equipment/otherEquipmentAdd.action" id="addMcuForm" name="addMcuForm" method="post"/>
   <div id="basicform" class="contentwrapper"> 
  <div id="m" style="background:none;border:none">  
     <%@include file="./equipmentAddHead.jsp"%>
   </div>

                <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                    <tr>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备类型</td>
                      <td width="35%" class="tableadd_data" >
	                      <select name="equipmentVO.equipmentType" id="equipmentType" class="inputtran" disabled="disabled">
							<zzst:option type="equipmentEnum" value="8" required="true"/>
			   			</select>
                      </td>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备厂家</td>
                      <td width="35%" class="tableadd_data" id="equipmentName_">
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
                     	 <input type="text" maxlength="25" name="equipmentVO.equipmentNO" id="equipmentNO" class="inputtran" onblur="checkNames('equipmentNO');" />
                      </td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>管理IP</td>
                      <td class="tableadd_data" >
                      	<input type="text" maxlength="25" class="inputtran" name="equipmentVO.ip" id="ip" onblur="javascript:check('ip');"/>
                      </td>
                      <td class="tableaddtitle"><span>*</span>MAC</td>
                      <td class="tableadd_data">
                      	<input type="text" maxlength="25" name="equipmentVO.mac" id="mac" class="inputtran" value="" />
                      </td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>端口号</td>
                      <td class="tableadd_data" >
                      <input id="port" maxlength="25" name="equipmentVO.port" value="" type="text" class="inputtran" />
                      </td>
                      <td class="tableaddtitle"><span>*</span>状态</td>
                      <td class="tableadd_data">
                        <select name="equipmentVO.status" id="status" class="inputtran">
							<zzst:option type="equipmentStatus" value=""  required="true"/>
			 			</select></td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>所属会议室</td>
                      <td class="tableadd_data" >
                      <input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" />
                      <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly" onclick="selectConference(this)"/>
                      </td>
                      <td class="tableaddtitle"><span>*</span>管理员</td>
                      <td class="tableadd_data">
                      <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="inputtran" value="${userID}"/>
                       <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly"  onclick="selectUsers(this)" value="${userName }"/>        
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
			          <td class="tableaddtitle">登录名称</td>
			          <td class="tableadd_data" ><input type="text" maxlength="25" name="equipmentVO.loginName" id="loginName" class="inputtran" value="" /></td>
			          <td class="tableaddtitle">登录密码</td>
			          <td class="tableadd_data"><input type="password" maxlength="25" name="equipmentVO.password" id="password" class="inputtran" value="" /></td>
        		   </tr>
        		   <tr>
			          <td class="tableaddtitle">通道号</td>
			          <td class="tableadd_data"  colspan="3" >
			          	<input type="text" maxlength="25" name="equipmentVO.equroomID" id="equroomID" class="inputtran" value="" />
			          </td>
        		   </tr>
        		   
        		   <tr>
        		      <td class="tableaddtitle">启用时间</td>
                      <td class="tableadd_data" colspan="3" >
                      	<input name="equipmentVO.createDate" class="inputtran" id="createDate" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value="<%=sdf.format(date) %>"/>
          			  </td>
                      
                    </tr>
                    <tr>
                      <td class="tableaddtitle">设备描述</td>
                       <td colspan="3" class="tableadd_data" ><textarea name="equipmentVO.description" rows="5" class="areatran" id="description"></textarea></td>
                      </tr>
                  </table>
                  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
                    <tfoot>
                    </tfoot>
                    <tbody>
                      <tr>
                        <td>
                           <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" name="button" id="button" onclick="equipmentAdd();"/>
                           <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
                        </td>
                      </tr>
                    </tbody>
                </table>            
            </div>
  </body>
</html>