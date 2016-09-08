<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.zzst.model.enums.EquipmentEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>中控添加</title>
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
			   // obj.title("equipmentType","请选择");	
			   // obj.title("equipmentName","长度不超过25个字符");
			    obj.title("equipmentModel","请选择");
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
			    var templateTd = document.getElementById("equipmentType");
			    getEquipmentName(templateTd);
			
			}

			
               function centerControlAdd(){
               //alert("come in");
                  $('#addcontrolForm').validate({    
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
				 // alert("************");
				 if( $('#addcontrolForm').valid()){
                	$('#addcontrolForm').submit();
                	$("#button").attr("disabled",true);
                }
               // alert("************");
             }
           	
          
	               	
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
	     
          function selectConference(thisDom){
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
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
			}else{
				return;
			}
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
</head>
  
  
 <body onload="pageInit();" STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx}/equipment/centerControlAdd.action" id="addcontrolForm" name="addcontrolForm" method="post">
   <div id="basicform" class="contentwrapper"> 
  <div id="m" style="background:none;border:none">  
               <%@include file="./equipmentAddHead.jsp"%>
    </div>

                <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                    <tr>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备类型</td>
                      <td width="35%" class="tableadd_data" >
                      <select name="equipmentVO.equipmentType" id="equipmentType" class="inputtran" disabled="disabled">
							<zzst:option type="equipmentEnum" value="2" required="true"/>
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
                      <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.equipmentNO" onblur="checkNames('equipmentNO');" id="equipmentNO" class="inputtran" value=""/></td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>管理IP</td>
                      <td class="tableadd_data" ><input type="text" maxlength="25" name="equipmentVO.ip" id="ip" class="inputtran" value="" onblur="javascript:check('ip');" /></td>
                      <td class="tableaddtitle"><span>*</span>端口号</td>
                      <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.port" id="port" class="inputtran" value="1550" /></td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle">启用时间</td>
                      <td class="tableadd_data" >
                     <input name="equipmentVO.createDate" class="inputtran" id="createDate" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value="<%=sdf.format(date) %>"/>
          			</td>  <!--<script type="text/javascript">
                            function selectMeetingTime(thisDom){
							     
							     var parameters = {
							         dateType : "datetime",
							         isNeedInfo:"true"
							     }
							  
							     creatCalendar(thisDom,parameters);
							}
         			 </script> -->
                      
                      <td class="tableaddtitle"><span>*</span>状态</td>
                      <td class="tableadd_data"><select name="equipmentVO.status" id="status" class="inputtran">
					<zzst:option type="equipmentStatus" value="" required="true"/>
			   </select></td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>所属会议室</td>
                      <td class="tableadd_data" >
                      <input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="" />
                      <input type="text" class="inputtran" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="" style="cursor:pointer"  readonly="readonly" onclick="selectConference(this)" onblur="checkRoomIsOnly(<%=EquipmentEnum.TYPE_ID_CENTERCONTROL %>);"/></td>
                      <td class="tableaddtitle"><span>*</span>管理员</td>
                      <td class="tableadd_data">
                      <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="" value="${userID}"/>
			           <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly"  onclick="selectUsers(this)" value="${userName }"/></td>
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
                      <td class="tableaddtitle">设备描述</td>
                      <td colspan="3" class="tableadd_data" >
                      <textarea name="equipmentVO.description" id="description" class="areatran"  style="width:70% rows="10"></textarea>
                      </td>
                      </tr>
                  </table>
                  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table" >
                    <tfoot>
                    </tfoot>
                    <tbody>
                      <tr>
                        <td>
                        <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" name="button" id="button"  onclick="centerControlAdd();"/>
                        <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
                        </td>
                      </tr>
                    </tbody>
                </table>            
            </div>
            </form>
  </body>
  </html>
