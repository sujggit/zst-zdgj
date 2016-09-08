<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>修改告示 </title>
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
			    obj.title("equipmentNO","不超过25个字符");
			    obj.title("mac","不超过25个字符");
			    obj.title("ip","请输入正确的IP格式");	
			   // obj.title("port","请输入10000内数值型数据");	
			    obj.title("createDate","请输入");	
			    obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
				obj.title("loginNamesss","请选择");
			    obj.title("description","不超过500个字符");
			    //obj.title("equipmentNO","请输入显示名称,输入长度不超过25个字符");
			    obj.title("equipmentIdentifier","不超过25个字符");	
			    obj.title("serialNumber","不超过25个字符");	
			}

			/**
			*	注册终端添加事件，实现验证、友好提示功能
			*@return	null	
			*/
   	          function equipmentNotifyModify(){
                  $('#modifyNoticeForm').validate({    
					rules:{    
		   "equipmentVO.equipmentType" : {
		           required:true
		           },
		     "equipmentVO.equipmentName" : {
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
		       "equipmentVO.meetingRoomVO.meetingRoomName" : {
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
		        },
		        "equipmentVO.mac":{
		        	required:true,
		            minlength:1,
		           	maxlength:25 
		        }
		           
		} 
				  });
				  
				  if( $('#modifyNoticeForm').valid()){
                     $('#modifyNoticeForm').submit();
                     $("#button").attr("disabled",true);
                   }
             }

   	      function check(id){
	var a=document.getElementById(id);
	if(a.value==""||a.value==null){
	  return;
	}
	DwrMethod.checkEquipmentIP(a.value,callback);
	}
	function callback(lst){
	if(lst.length>0){
	alert("此设备的IP已被占用");
	document.getElementById("ip").value="";
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
                  selectType:'multiple'
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
	    	 
	    	   if(i==(conferenceLength-1)){
			       meetingRoomName =meetingRoomName+conferenceArray[i].conferenceName;
			       meetingRoomID = meetingRoomID+conferenceArray[i].conferenceID;
			   }else{
			       meetingRoomName =meetingRoomName+conferenceArray[i].conferenceName+",";
			       meetingRoomID = meetingRoomID+conferenceArray[i].conferenceID+",";
			   }
	      }
	  	$("#meetingRoomID").attr("value",meetingRoomID);
	   	$("#meetingRoomName").attr("value",meetingRoomName);
	}
          
           //addby chenshuo查询会议室是否已有终端
          function checkMeetingRoomTerminal(){
		  var a=document.getElementById("meetingRoomID");	
		  if(a.value=='${equipmentVO.meetingRoomVO.meetingRoomID}' || a.value==null){
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
    	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'   onload="pageInit();">
<form action="${sys_ctx}/equipment/noticeModify.action" id="modifyNoticeForm" name="modifyNoticeForm" method="post">
<input type="hidden" name="equipmentVO.equipmentID" id="equipmentID" class="" value="${equipmentVO.equipmentID}"  />
 <div id="basicform" class="contentwrapper">  
<div class="contenttitle2">
        <h5 class="fwb fl10">告示修改</h5>
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
			<select name="equipmentVO.equipmentName" id="equipmentName" class="inputtran">
          		<zzst:option type="equipmentName_" value="${dicName}"/>
            </select>
          </td>
        </tr>
        <tr>
          
          <td class="tableaddtitle"><span>*</span>设备名称</td>
          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.equipmentNO" id="equipmentNO" class="inputtran" value="${equipmentVO.equipmentNO}" /></td>
      		<td class="tableaddtitle"><span>*</span>mac地址</td>
      		<td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.mac" id="mac" class="inputtran" value="${equipmentVO.mac}" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>管理IP</td>
          <td class="tableadd_data" > <input type="text" maxlength="25" name="equipmentVO.ip" id="ip" class="inputtran" value="${equipmentVO.ip}" onblur="javascript:check('ip');"/></td>
           <td class="tableaddtitle"><span>*</span>状态</td>
          <td class="tableadd_data" ><select name="equipmentVO.status" id="status" class="inputtran">
				<zzst:option type="equipmentStatus" value="${equipmentVO.status}"   required="true"/>
			 </select></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>所属会议室</td>
          <td class="tableadd_data" colspan="3"><input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="" value="${equipmentVO.meetingRoomVO.meetingRoomID}"  />
                             <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly"  value="${equipmentVO.meetingRoomVO.meetingRoomName}" onclick="selectConference(this)" /></td>
          
        </tr>
        <tr>
         <td class="tableaddtitle">管理员</td>
          <td class="tableadd_data"> <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="" value="${equipmentVO.userVO.userID}" />
			   <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly" value="${equipmentVO.userVO.name}" onclick="selectUsers(this)" /></td>
          <td class="tableaddtitle">序列号</td>
          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.serialNumber" value="${equipmentVO.serialNumber}" id="serialNumber" class="inputtran" value="${equipmentVO.serialNumber }" /></td>
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
          <td class="tableaddtitle">启用时间</td>
          <td class="tableadd_data" > 
             <input name="equipmentVO.createDate" class="inputtran" id="createDate" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" 
             	 value="<fmt:formatDate value='${equipmentVO.createDate}' pattern='yyyy-MM-dd HH:mm'/>"
             />
          </td>
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
              <input type="button" name="button" id="button" class="submit1 radius2" value="确 定" onclick="equipmentNotifyModify();"/>
              <input type="button"name="button2" id="button2"  class="reset1 radius2" value="取 消" onclick="backHistory();"/>
              </td>
          </tr>
        </tbody>
      </table>
      </div>
  </form>
</body>

</html>