<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.EquipmentEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>复制中控</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
		<script type="text/javascript">
		
            
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/equipment/query.action";
            }

         
    
         
             function pageInit(){
			     var obj = new htmlUtil();
			   // obj.title("equipmentType","请选择");	
			   // obj.title("equipmentName","长度不超过25个字符");
			    obj.title("equipmentModel","不超过25个字符");
			    obj.title("equipmentNO","不超过25个字符");
			    obj.title("ip","输入正确的IP格式");	
			    obj.title("port","输入10000内整数");	
			    obj.title("createDate","请输入");	
			    obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
				obj.title("loginNamesss","请选择");	
			    obj.title("description","不超过500个字符");
			    obj.title("equipmentIdentifier","不超过25个字符");	
			    obj.title("serialNumber","不超过25个字符");
			    
			    var templateTd = document.getElementById("equipmentName");
			    getEquipmentName(templateTd);
			}

			/**
			*	注册mcu添加事件，实现验证、友好提示功能
			*@return	null	
			*/
   		  function mcuModify(){
                  $('#modifyForm').validate({    
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
					           range:[0,5000]
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
				  
				  
				  
				  
				  
				  if( $('#modifyForm').valid()){
                    $('#modifyForm').submit();
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
			  var selectedConference = document.getElementById("meetingRoomID").value;
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
				  selectedConference:selectedConference,
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
      	 * 检查会议室此类型设备是够已经存在
      	 */  
          function checkRoomIsOnly(equipmentType){
  			var meetingRoomID = document.getElementById("meetingRoomID").value;
			if(meetingRoomID){
				DwrMethod.checkRoomIsOnly(meetingRoomID,equipmentType,function(resultInfo){
					if(resultInfo){
						alert("此会议室已经注册了一个中控设备");
						document.getElementById("meetingRoomID").value="";
						document.getElementById("meetingRoomName").value="";
					}
				})
			}
   	 	} 
   	 	
   	 	function getEquipmentName(op){
				var mcuId = op.value;
				var templateTd = document.getElementById("equipmentModel_");
				var html ="<select name='equipmentVO.equipmentModel' class='inputtran' id='equipmentModel' title='请选择'><zzst:option type="equipmentModel_" value='${equipmentVO.equipmentModel}'/>";
				html += "</select>";
				templateTd.innerHTML=html;
			}
		function getEquipmentNameNew(op){
				var mcuId = op.value;
				var templateTd = document.getElementById("equipmentModel_");
				var html ="<select name='equipmentVO.equipmentModel' class='inputtran' id='equipmentModel' title='请选择'>";
				DwrMethod.getDicNameByDicID(mcuId,function cb(rs){
					    if( rs != null ){
					    	html += rs;
					    	html += "</select>";
							templateTd.innerHTML=html;
						}
					});
			}	 	 
         
    	</script>
</head>

<body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'  onload="pageInit();">
<form action="${sys_ctx}/equipment/centerControlAdd.action" id="modifyForm" name="modifyForm" method="post">
<input type="hidden" name="" id="equipmentID" class="" value="${equipmentVO.equipmentID}"  />
  <div id="basicform" class="contentwrapper"> 
 <div class="contenttitle2">
        <h5 class="fwb fl10">中控复制</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>设备类型</td>
          <td width="35%" class="tableadd_data" >
          <select name="equipmentVO.equipmentType" id="equipmentType" class="inputtran" disabled="disabled">
					<zzst:option type="equipmentEnum" value="${equipmentVO.equipmentType}" required="true"/>
			   </select>
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>设备厂家</td>
          <td width="35%" class="tableadd_data">
          <!-- <input type="text" name="equipmentVO.equipmentName" id="equipmentName" class="inputtran" value="${equipmentVO.equipmentName}" disabled/> -->
          <select name="equipmentVO.equipmentName" id="equipmentName" class="inputtran" onchange="getEquipmentNameNew(this)">
          		<zzst:option type="equipmentName_" value="${dicName}"/>
          </select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>设备型号</td>
          <td class="tableadd_data" id="equipmentModel_">
          <!-- <select name="equipmentVO.equipmentModel" id="equipmentModel" class="inputtran">
					<zzst:option type="equipment_Centercontrol_Model" value="${equipmentVO.equipmentModel}" required="true"/>
		  </select>-->
		  <select name="equipmentVO.equipmentModel" id="equipmentModel" class="inputtran">
					<!--<zzst:option type="equipment_Terminal_Model" value="1" required="true"/>-->
					<option value="">请选择...</option>
		  </select>
		  </td>
          <td class="tableaddtitle"><span>*</span>设备名称</td>
          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.equipmentNO" onchange="checkNames('equipmentNO','${equipmentVO.equipmentNO}');" id="equipmentNO" class="inputtran" value="${equipmentVO.equipmentNO}" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>管理IP</td>
          <td class="tableadd_data" > <input type="text" maxlength="25" name="equipmentVO.ip" id="ip" class="inputtran" value="" onchange="check('ip');" /></td>
          <td class="tableaddtitle"><span>*</span>端口号</td>
          <td class="tableadd_data">  <input type="text" maxlength="25" name="equipmentVO.port" id="port" class="inputtran" value="${equipmentVO.port}" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>所属会议室</td>
          <td class="tableadd_data" ><input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class=""  />
                             <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly" onclick="selectConference(this)" onblur="checkRoomIsOnly(<%=EquipmentEnum.TYPE_ID_CENTERCONTROL %>)"/></td>
          <td class="tableaddtitle"><span>*</span>管理员</td>
          <td class="tableadd_data"> <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="" value="${equipmentVO.userVO.userID}" />
			   <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly" value="${equipmentVO.userVO.name}" onclick="selectUsers(this)" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>状态</td>
          <td class="tableadd_data" ><select name="equipmentVO.status" id="status" class="inputtran">
				<zzst:option type="equipmentStatus" value="${equipmentVO.status}"   required="true"/>
			 </select></td>
           <td class="tableaddtitle">启用时间</td>
          <td class="tableadd_data" > 
        	 <input name="equipmentVO.createDate" class="inputtran" id="createDate" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" 
             	 value="<fmt:formatDate value='${equipmentVO.createDate}' pattern='yyyy-MM-dd HH:mm'/>"
             />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">维保开始日期</td>
          <td class="tableadd_data" >
          	 <input name="equipmentVO.maintenanceStartTime" value="<fmt:formatDate value='${equipmentVO.maintenanceStartTime}' pattern='yyyy-MM-dd HH:mm'/>" class="inputtran" id="maintenanceStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"/>
          </td>
          <td class="tableaddtitle">期限</td>
          <td class="tableadd_data">
          	<select class="inputtran"  name="equipmentVO.maintenanceMonths" id="maintenanceMonths">
    <%--<option value="23">请选择...</option>--%>
    <%--<option value="0.05" ${meetingDetailVO.meetingDescription=="0.05" ? "selected" : "" }>0.05</option>--%>
			    <zzst:option type="maintenanceStartTime" value="${equipmentVO.maintenanceMonths}" />
    		</select> 
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">资产编号</td>
          <td class="tableadd_data" ><input type="text" maxlength="25" name="equipmentVO.equipmentIdentifier" value="${equipmentVO.equipmentIdentifier}" id="equipmentIdentifier" class="inputtran" value="" /></td>
          <td class="tableaddtitle">序列号</td>
          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.serialNumber" value="${equipmentVO.serialNumber}" id="serialNumber" class="inputtran" value="${equipmentVO.serialNumber }" /></td>
        </tr>
         
        <tr>
          <td class="tableaddtitle">设备描述</td>
          <td colspan="3" class="tableadd_data" >
          
          <textarea name="equipmentVO.description" class="areatran" id="description" style="width:70% rows="10"><c:out value="${equipmentVO.description}"></c:out></textarea>
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
            
            <input type="button" name="button" id="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="mcuModify();"/>
              
              <input type="button"name="button2" id="button2"  class="reset1 radius2" value="取 消" onclick="backHistory();"/>
              </td>
          </tr>
        </tbody>
      </table>
      </div>
  </form>
</body>

</html>