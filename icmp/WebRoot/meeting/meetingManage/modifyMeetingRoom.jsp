<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
	<head>
		<title>会场修改</title>
		<%@include file="/common/common.jsp"%>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>	
		<script type="text/javascript">
				/**
			*	设置页面参数
			*@return	null	
			*/
           function pageInit(){
			    var obj = new htmlUtil();
				obj.title("mcu_participant_name","输入长度不超过25个字符");				
				obj.title("mcuParticipantIp","输入正确格式的ip");	

				var connectStatus = "${zzoMainStatusVO.connectStatus}";
				
				if(connectStatus == 1 || connectStatus == 2){
					document.getElementById("casDialDirection").disabled = "disabled";
					document.getElementById("pInterface").disabled = "disabled";
					document.getElementById("mcuParticipantIp").disabled = "disabled";
					document.getElementById("aliasName").disabled = "disabled";
					document.getElementById("aliasType").disabled = "disabled";
					document.getElementById("callSpeed").disabled = "disabled";
					document.getElementById("maxResolution").disabled = "disabled";
					document.getElementById("videoProtocol").disabled = "disabled";
					document.getElementById("cascadeRole").disabled = "disabled";
					document.getElementById("ptsNamesid").disabled="disbled";
					document.getElementById("ptsTelephoneId").disabled="disbled";
					document.getElementById("meetingRoomAdminNameId").disabled="disbled";
					document.getElementById("meetingRoomAdminTelephoneID").disabled="disbled";
					
				}
			};
			
   			
            /**
			*	关闭对话框
			*@return	null
			*/
            function closeWindow(){
            	window.close();
            };
           function modify(){
        	   var connectStatus = "${zzoMainStatusVO.connectStatus}";
				var meetingDetailID = "${zzoMainStatusVO.confFlagId}";
				var confId = "${confId}";
				var ptsParticipantId = "${zzoMainStatusVO.mcu_participant_id}";

				var infoValue = new Array();
				
                
				if(connectStatus == 3 || connectStatus == 4){

					
					var mcu_participant_name = document.getElementById("mcu_participant_name").value;
					var casDialDirection = document.getElementById("casDialDirection").value;
					var pInterface = document.getElementById("pInterface").value;
					var mcu_participant_ip = document.getElementById("mcuParticipantIp").value;
					var aliasName = document.getElementById("aliasName").value;
					var aliasType = document.getElementById("aliasType").value;
					var callSpeed = document.getElementById("callSpeed").value;
					var maxResolution = document.getElementById("maxResolution").value;
					var videoProtocol = document.getElementById("videoProtocol").value;
					var cascadeRole = document.getElementById("cascadeRole").value;

					infoValue.push(mcu_participant_name);	
					infoValue.push(casDialDirection);	
					infoValue.push(pInterface);
					infoValue.push(mcu_participant_ip);
					infoValue.push(aliasName);
					infoValue.push(aliasType);
					infoValue.push(callSpeed);
					infoValue.push(maxResolution);	
					infoValue.push(videoProtocol);	
					infoValue.push(cascadeRole);			
					
					McuDwrMethod.updateParticipant(meetingDetailID,confId,ptsParticipantId,infoValue, function callBack1(){window.close()});
				}else if(connectStatus ==1 || connectStatus ==2){
					var mcu_participant_name = document.getElementById("mcu_participant_name").value;
					McuDwrMethod.setParticipantVisualName(meetingDetailID, confId, ptsParticipantId, mcu_participant_name,function callBack2(){
						if(window.opener){
							var kid =  document.getElementById("meetingMCUKeyID").value; 
							window.opener.document.getElementById("font_"+kid).innerText = mcu_participant_name ;
						}
						window.close();
					});
				}
             /*$('#addForm').validate({    
					rules:{    
					   "zzoMainStatusVO.mcu_participant_name" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
				      "zzoMainStatusVO.mcu_participant_ip" : {
				               required:true,
				                checkIP:true					         
					           }
					}
					
				  });*/
          
           
	     // $("#addForm").submit();
		
		}


           
    	</script>
		<style type="text/css">
</style>
	</head>
	<body onload="pageInit(); ">
		<form action="${sys_ctx}/templateEquipment/MeetingEquipmentAdd.action"  id="addForm"
			name="addForm" method="post">
		  <input id="meetingMCUKeyID" value="${zzoMainStatusVO.meetingMCUKeyID}" type="hidden"/></input>
			
			
		

			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="tableadd">
				<tr>
					<td width="15%" class="tableaddtitle">
						名称
					</td>
					<td width="35%" class="tableadd_data">
						<input type="text" class="inputtran"
							name="zzoMainStatusVO.mcu_participant_name" id="mcu_participant_name" 
							    <c:choose>
							    	<c:when test="${zzoMainStatusVO.mcu_participant_visualName != null &&  zzoMainStatusVO.mcu_participant_visualName != '' }">value="${zzoMainStatusVO.mcu_participant_visualName }"</c:when>
							    	<c:otherwise>value="${zzoMainStatusVO.mcu_participant_name}"</c:otherwise>
							    </c:choose>
							   
							 />
					</td>
					<td width="15%" class="tableaddtitle">
						呼叫方式方向
					</td>
					<td width="35%" class="tableadd_data">
						<select style="width: 49%; float: left"
						name="zzoMainStatusVO.casDialDirection" id="casDialDirection">
							<option value="dial_out" <c:if test="${zzoMainStatusVO.casDialDirection == 'dial_out' }">selected</c:if>  >
								呼出
							</option>
							<option value="dial_in" <c:if test="${zzoMainStatusVO.casDialDirection == 'dial_in' }">selected</c:if>  >
								呼入
							</option>

						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						类型
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="zzoMainStatusVO.pInterface" id="pInterface">
							<option value="h323">
								h.323
							</option>

						</select>
					</td>
					<td class="tableaddtitle">
						IP地址
					</td>
					<td class="tableadd_data">
						<input type="text" style="float: left"
							name="zzoMainStatusVO.mcu_participant_ip" id="mcuParticipantIp" value="${zzoMainStatusVO.mcu_participant_ip }"
							 />
						<span style="color: red;">&nbsp;</span>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						别名/类型
					</td>
					<td class="tableadd_data">
						<input type="text" name="zzoMainStatusVO.aliasName" value="${zzoMainStatusVO.aliasName}" id="aliasName"/>

						<select style="width: 120px;" name="zzoMainStatusVO.aliasType" id="aliasType">
							<option value="323_id" <c:if test="${zzoMainStatusVO.aliasType == '323_id' }">selected</c:if> >
								323_ID
							</option>
							<option value="e164"  <c:if test="${zzoMainStatusVO.aliasType == 'e164' }">selected</c:if>>
								e164
							</option>
						</select>
					</td>
					<td class="tableaddtitle">
						连接速率
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="zzoMainStatusVO.callSpeed" id="callSpeed">
							<option value="automatic" <c:if test="${zzoMainStatusVO.callSpeed == 'automatic'}">selected</c:if>>
								AUTO
							</option>
							<option value="385"  <c:if test="${zzoMainStatusVO.callSpeed == '385'}">selected</c:if>>
								385
							</option>
							<option value="512" <c:if test="${zzoMainStatusVO.callSpeed == '512'}">selected</c:if>>
								512
							</option>
							<option value="768" <c:if test="${zzoMainStatusVO.callSpeed == '768'}">selected</c:if>>
								768
							</option>
							<option value="1024" <c:if test="${zzoMainStatusVO.callSpeed == '1024'}">selected</c:if>>
								1024
							</option>
							<option value="1536" <c:if test="${zzoMainStatusVO.callSpeed == '1536'}">selected</c:if>>
								1536
							</option>
							<option value="1920" <c:if test="${zzoMainStatusVO.callSpeed == '1920'}">selected</c:if>>
								1920
							</option>
							<option value="2048" <c:if test="${zzoMainStatusVO.callSpeed == '2048'}">selected</c:if>>
								2048
							</option>
							<option value="4096" <c:if test="${zzoMainStatusVO.callSpeed == '4096'}">selected</c:if>>
								4096
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						分辨率
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="zzoMainStatusVO.maxResolution" id="maxResolution">
							<option value="auto" <c:if test="${zzoMainStatusVO.maxResolution == 'auto'}">selected</c:if>>
								AUTO
							</option>
							<option value="cif" <c:if test="${zzoMainStatusVO.maxResolution == 'cif'}">selected</c:if>>
								CIF
							</option>
							<option value="sd" <c:if test="${zzoMainStatusVO.maxResolution == 'sd'}">selected</c:if>>
								SD
							</option>
							<option value="hd_720" <c:if test="${zzoMainStatusVO.maxResolution == 'hd_720'}">selected</c:if>>
								HD 720
							</option>
							<option value="hd_1080" <c:if test="${zzoMainStatusVO.maxResolution == 'hd_1080'}">selected</c:if>>
								HD 1080
							</option>
						</select>
					</td>
					<td class="tableaddtitle">
						视频协议
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="zzoMainStatusVO.videoProtocol" id="videoProtocol">
							<option value="auto" <c:if test="${zzoMainStatusVO.videoProtocol == 'auto'}">selected</c:if>>
								自动
							</option>
							<option value="h261" <c:if test="${zzoMainStatusVO.videoProtocol == 'h261'}">selected</c:if>>
								h261
							</option>
							<option value="h263" <c:if test="${zzoMainStatusVO.videoProtocol == 'h263'}">selected</c:if>>
								h263
							</option>
							<option value="h264" <c:if test="${zzoMainStatusVO.videoProtocol == 'h264'}">selected</c:if>>
								h264
							</option>

						</select>
					</td>
				</tr>
				<!-- <tr>
					<td class="tableaddtitle">
						加密
					</td>
					<td colspan="3" class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.agc">
							<option value="">
								自动
							</option>
							<option value="">
								呼出
							</option>
						</select>
					</td>
				</tr> -->

				<tr>
					<td class="tableaddtitle">
						级联
					</td>
					<td colspan="3" class="tableadd_data">
						<select style="width: 49%; float: left"
							name="zzoMainStatusVO.cascadeRole" id="cascadeRole">
							<option value="none" <c:if test="${zzoMainStatusVO.cascadeRole == 'none'}">selected</c:if>>
								none
							</option>
							<option value="master" <c:if test="${zzoMainStatusVO.cascadeRole == 'master'}">selected</c:if>>
								master
							</option>
							<option value="slave" <c:if test="${zzoMainStatusVO.cascadeRole == 'slave'}">selected</c:if>>
								slave
							</option>


						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						终端管理员
					</td>
					<td class="tableadd_data">
						<input value="${ptsName}" id="ptsNamesid" />
					</td>
					<td class="tableaddtitle">
						电话
					</td>
					<td class="tableadd_data">
					<input value="${ptsTelephone }" id="ptsTelephoneId"/>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						会议室管理员
					</td>
					<td class="tableadd_data">
					<input value="${meetingRoomAdminName }" id="meetingRoomAdminNameId" />
					</td>
					<td class="tableaddtitle">
						电话
					</td>
					<td class="tableadd_data">
					<input value="${meetingRoomAdminTelephone }" id="meetingRoomAdminTelephoneID" />
					</td>
				</tr>
				

			</table>
			<table cellpadding="0" cellspacing="0" border="0"
				class="buttoncontainer" id="table">
				<tfoot>
				</tfoot>
				<tbody>
					<tr>
						<td>
							<input type="button" class="submit1 radius2" value="确 定"
								onclick="modify();" />

							<input type="button" class="reset1 radius2" value="退 出"
								onclick=" closeWindow();" />

						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>

</html>