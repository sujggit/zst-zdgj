<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>修改终端 </title>
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
			    //obj.title("equipmentType","请选择");	
			    //obj.title("equipmentName","输入长度不超过25个字符");	
			    obj.title("equipmentModel","不超过25个字符");	
			    obj.title("equipmentNO","不超过25个字符");	
			    obj.title("ip","输入正确的IP格式");	
			    obj.title("port","输入10000内整数");	
			    //obj.title("status","请选择");	
			    obj.title("meetingRoomName","请选择");	
				obj.title("loginNamesss","请选择");	
				//obj.title("createDate","请输入");
			    obj.title("loginName","输入用户名");	
			    obj.title("loginPassword","输入密码");	
				obj.title("pstn","不超过25个字符");	
				//obj.title("speed","输入5000内整数");	
			    obj.title("equipmentMCUID","请选择");	
			    //obj.title("radioTreaty","不超过25个字符");	
			    obj.title("description","不超过500个字符");
			    obj.title("equipmentIdentifier","不超过25个字符");	
			    obj.title("serialNumber","不超过25个字符");	

			    var templateTd = document.getElementById("equipmentName");
			    getEquipmentName(templateTd);
			}

			/**
			*	注册终端添加事件，实现验证、友好提示功能
			*@return	null	
			*/
   	          function equipmentTerminalModify(){
                  $('#modifyTerminalForm').validate({    
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
					       "equipmentVO.status" : {
					           required:true
					           },
					       "equipmentVO.userVO.name" :{
					           required:true
					           },
					       "equipmentVO.meetingRoomVO.meetingRoomName" : {
					           required:true
					           },
					       "equipmentTerminalVO.loginName" : {
							       
						            minlength:1,
						            maxlength:25
						       },
					         "equipmentTerminalVO.pstn" : {
					            minlength:1,
					            maxlength:25
					           },
					           /*
					        "equipmentTerminalVO.speed" : {
					           required:true,
					           digits:true,
					           range:[0,5000]
					           },
					           */
					        /*
					        "equipmentTerminalVO.videoTreaty" : {
					            minlength:1,
					            maxlength:25
					           },
					        
					       "equipmentTerminalVO.radioTreaty" : {
					            minlength:1,
					            maxlength:25
					           },
					           */
					        "equipmentVO.description" : {
					           minlength:1,
					           maxlength:500  
					           },
				           "equipmentTerminalVO.equipmentMCUID":{
					            minlength:1,
					           maxlength:500 
					        },
					        "equipmentVO.serialNumber":{
					            minlength:1,
					           maxlength:25 
					        },
					        "equipmentTerminalVO.equipmentMCUID":{
					         required:true 
					        },
					        "equipmentVO.equipmentIdentifier":{
					            minlength:1,
					           maxlength:25 
					        }
					           
					},    
					messages:{
					      equipmentType: {required: "必选"},
					      equipmentName:{required :"必填"},
					      status:{required: "必选"},
	       			  	  meetingRoomName: {required: "必选"},
	       				  loginName:{required: "必选"} 
	       				
					
					}    
				  });
				  
				  if($('#modifyTerminalForm').valid()){
                     $('#modifyTerminalForm').submit();
                     $("#button").attr("disabled",true);
                  }
             }



  
           	
           /**
			*	选择人员
			*@return	null	
			*/
	               	
           	  function selectUsers(thisDom){
           	  var selectedUser = document.getElementById("userID").value;
	              var userParameters = {
	                  methodName:'getReturnUserMethod',
	                  selectedUser:selectedUser,
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
               var selectedUser = document.getElementById("userID").value;
               if(selectedUser==null||selectedUser==""){
               	$("#userID").value="";
               	$("#loginNamesss").value="";
               }
                
	         
	          }
	          
	          
	            /**
	       *选择会议室
	       */
          
           function selectConference(thisDom){
           var selectedConference=document.getElementById("meetingRoomID").value;
               var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
                  selectedConference:selectedConference,
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
               	var selectedConference=document.getElementById("meetingRoomID").value;
               	if(selectedConference==null||selectedConference==""){
               		$("#meetingRoomID").value="";
               		$("#meetingRoomName").value="";
               	}
              
          }
          
           //addby chenshuo查询会议室是否已有终端
          function checkMeetingRoomTerminal(){
		  var a=document.getElementById("meetingRoomID");	
		  if(a.value=='${equipmentVO.meetingRoomVO.meetingRoomID}' || a.value==null||a.value==""){
			return;
			}
		    DwrMethod.isMeetingRoomTerminalExist(a.value,checkMeetingRoomTerminalcallback);
		}
			
	    function checkMeetingRoomTerminalcallback(result){
	    	
	    	if(result == true ){
	    	var b=document.getElementById("meetingRoomName").value;	
	    	alert( b + "会议室已有终端");
	    	document.getElementById("meetingRoomID").value="${equipmentVO.meetingRoomVO.meetingRoomID}";  	
	    	document.getElementById("meetingRoomName").value="${equipmentVO.meetingRoomVO.meetingRoomName}"; 
	       }			
 		}

 		function commuConveChek(){
			var radioTreaty = document.getElementById("radioTreaty");
			var ip = document.getElementById("ip");
			if(radioTreaty.value!="e164"){
				ip.disabled = false;
				ip.value = "";
			}else{
				if(confirm("E.164模式下，设备IP将不能填写，确认修改么？")){
					ip.value = "0.0.0.0";
					ip.disabled = true;
				}else{
					radioTreaty.value = "";
				}
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


 		//控制参数默认隐藏
		function toggle(id){
			var tb=document.getElementById(id);
			if(tb.style.display=='none') tb.style.display='block';
			else tb.style.display='none';
		}
    	</script>
</head>

<body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'   onload="pageInit();">
<form action="${sys_ctx}/equipment/terminalModify.action" id="modifyTerminalForm" name="modifyTerminalForm" method="post">
<input type="hidden" name="equipmentVO.equipmentID" id="equipmentID" class="" value="${equipmentVO.equipmentID}"  />
<input type="hidden" name="equipmentTerminalVO.equipmentID" id="equipmentIDs" class="" value="${equipmentTerminalVO.equipmentID}"  />
 <div id="basicform" class="contentwrapper"> 
<div class="contenttitle2">
        <h5 class="fwb fl10">终端修改</h5>
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
					<zzst:option type="equipment_Terminal_Model" value="${equipmentVO.equipmentModel}" required="true"/>
			   </select> -->
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
          <td class="tableadd_data" > <input type="text" maxlength="25" name="equipmentVO.ip" id="ip" class="inputtran" value="${equipmentVO.ip}" onchange="checkTerIP('ip');" /></td>
          <td class="tableaddtitle"><span>*</span>管理员</td>
          <td class="tableadd_data"> <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="" value="${equipmentVO.userVO.userID}" />
			   <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly" value="${equipmentVO.userVO.name}" onclick="selectUsers(this)" />
		  </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>所属会议室</td>
          <td class="tableadd_data" ><input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="" value="${equipmentVO.meetingRoomVO.meetingRoomID}"  />
              <!-- <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly"  value="${equipmentVO.meetingRoomVO.meetingRoomName}" onclick="selectConference(this)" onblur="checkMeetingRoomTerminal()"/> -->
              <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly"  value="${equipmentVO.meetingRoomVO.meetingRoomName}" onclick="selectConference(this)" />
          </td>
          <td class="tableaddtitle"><span>*</span>所属MCU</td>
          <td class="tableadd_data" ><select name="equipmentTerminalVO.equipmentMCUID" id="equipmentMCUID" class="inputtran">
				<c:forEach items="${equipmentVOListsss}" var="eMcu">
				<option value="${eMcu.equipmentID}" ${eMcu.equipmentID==equipmentTerminalVO.equipmentMCUID ? "selected" : "" }>
							 ${eMcu.equipmentNO}(${eMcu.ip})
					</option>
			    </c:forEach>
			</select></td>
        </tr>
        <tr>
          <td class="tableaddtitle">用户名</td>
          <td class="tableadd_data" > <input type="text" maxlength="25" name="equipmentTerminalVO.loginName" id="loginName" class="inputtran" value="${equipmentTerminalVO.loginName}" /></td>
          <td class="tableaddtitle">密码</td>
          <td class="tableadd_data"><input type="password" maxlength="25" name="equipmentTerminalVO.loginPassword" id="loginPassword" class="inputtran" value="${equipmentTerminalVO.loginPassword}" /></td>
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
        <tr>
        	<td class="tableaddtitle">控制参数</td>
            <td class="tableadd_data" colspan="3">
                <input type="checkbox" value="1" onClick="toggle('table1')" id="isCheck" name="equipmentTerminalVO.isCheck" <c:if test="${equipmentTerminalVO.isCheck==1}">checked="checked"</c:if>/>              
            </td>
        </tr>
      </table>
      <table id="table1" class="tableadd" width="100%" border="0" cellspacing="1" cellpadding="0" <c:if test="${equipmentTerminalVO.isCheck==0}">style="display:none"</c:if> >
                      			<tr>
                      				<td width="15%" class="tableaddtitle">呼叫方式方向</td>
			          				<td width="35%" class="tableadd_data" >
			          					<select id="dialingDirection" name="equipmentTerminalVO.dialingDirection" class="inputtran">
											<zzst:option type="dialingDirection" value="${equipmentTerminalVO.dialingDirection}"/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">类型</td>
			          				<td class="tableadd_data" >
			          					<select id="dialingType" name="equipmentTerminalVO.dialingType" class="inputtran">
											<zzst:option type="dialingType" value="${equipmentTerminalVO.dialingType}"/>
										</select>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">分辨率</td>
			          				<td class="tableadd_data" >
			          					<select id="maxPesolution" name="equipmentTerminalVO.maxPesolution" class="inputtran">
											<zzst:option type="maxPesolution" value="${equipmentTerminalVO.maxPesolution}"/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">别名/类型</td>
			          				<td class="tableadd_data" >
			          					<input type="text"  name="equipmentTerminalVO.aliasName" id="aliasName" maxlength="25" class="inputtran" value="${equipmentTerminalVO.aliasName}"/>
										<select style="width:100px;" name="equipmentTerminalVO.aliasType" id="aliasType" class="inputtran">
											<zzst:option type="aliasType" value="${equipmentTerminalVO.aliasType}"/>
										</select>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">视频协议</td>
			          				<td class="tableadd_data" >
			          					<select name="equipmentTerminalVO.videoTreaty" id="aliasType" class="inputtran">
											<zzst:option type="videoTreaty" value="${equipmentTerminalVO.videoTreaty}"/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">级联</td>
			          				<td class="tableadd_data" >
			          					<select id="cascadeRole" name="equipmentTerminalVO.cascadeRole" class="inputtran">
											<zzst:option type="cascadeRole" value="${equipmentTerminalVO.cascadeRole}"/>
										</select>
			          				</td>
			          				
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">连接速率</td>
			          				<td class="tableadd_data" >
			          					<select name="equipmentTerminalVO.speed" id="speed" class="inputtran">
											<zzst:option type="speed" value="${equipmentTerminalVO.speed}"/>
										</select>
			          				</td>
			          				<td class="tableaddtitle">端口号</td>
			          				<td class="tableadd_data" >
			          					<input type="text" maxlength="25" name="equipmentVO.port" id="port" class="inputtran" value="${equipmentVO.port}" />
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">通信协议</td>
          							<td class="tableadd_data"><select name="equipmentTerminalVO.radioTreaty" id="radioTreaty" class="inputtran" onchange="commuConveChek();">
										<zzst:option type="radioTreaty" value="${equipmentTerminalVO.radioTreaty}"/>
			   							</select>
			   						</td>
			   						<td class="tableaddtitle">模拟电话</td>
          							<td class="tableadd_data"> 
          								<input maxlength="25"  type="text" name="equipmentTerminalVO.pstn" id="pstn" class="inputtran" value="${equipmentTerminalVO.pstn}"/>
          							</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">占用MCU资源数</td>
          							<td class="tableadd_data">
          							<input maxlength="25"  type="text" name="equipmentTerminalVO.mcuResourse" id="mcuResourse" class="inputtran" value="${equipmentTerminalVO.mcuResourse }"/>
			   						</td>
			   						<td class="tableaddtitle">终端角色</td>
          							<td class="tableadd_data">
	          							<select name="equipmentTerminalVO.useRole" id="useRole" class="inputtran" >
											<option value="主终端">主终端</option>
											<option value="备终端">备终端</option>
											<option value="预监终端">预监终端</option>
				   						</select>
				   						<script>
										   $("#useRole option[value='${equipmentTerminalVO.useRole}']").attr("selected", true);
										</script> 
          							</td>
                      			</tr>
                      			<tr>
			                      <td class="tableaddtitle">控制参数</td>
			                      <td colspan="3" class="tableadd_data" ><textarea name="equipmentTerminalVO.controlParameter" rows="5" class="areatran" id="controlParameter">${equipmentTerminalVO.controlParameter }</textarea></td>
			                      </tr>
			        			<tr>
                      		</table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
            
            <input type="button" name="button" id="button" class="submit1 radius2" value="确 定" onclick="equipmentTerminalModify();"/>
              
              <input type="button"name="button2" id="button2"  class="reset1 radius2" value="取 消" onclick="backHistory();"/>
              </td>
          </tr>
        </tbody>
      </table>
      </div>
  </form>
</body>


</html>