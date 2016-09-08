<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>添加告示</title>
		<script type="text/javascript"><!--
		
            
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/equipment/query.action";
            }

         
           function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("equipmentType","输选择");	
			    obj.title("equipmentName","输入长度不超过25个字符");	
			    obj.title("ip","请输入正确的IP格式如：10.1.1.1");	
			    obj.title("port","请输入5000内数值型数据");	
			    obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
			    obj.title("terminalIP","请输入正确的IP格式如：10.1.1.1");	
			    
			
			}

			/**
			*	注册mcu添加事件，实现验证、友好提示功能
			*@return	null	
			*/
               function QBoxAdd(){
                  $('#addQBoxForm').validate({    
					rules:{    
					   "equipmentVO.equipmentType" : {
					           required:true
					           },
					     "equipmentVO.equipmentName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
					       "equipmentVO.ip" : {
					           minlength:1,
					           maxlength:25,
					           checkIP:true
					           },
					       "equipmentVO.port" : {
					            required:true,
					           range:[0,5000]
					           },
					       "equipmentVO.status" : {
					           required:true
					           },
					       "equipmentVO.meetingRoomVO.meetingRoomName" : {
					           required:true
					           },
					        "equipmentVO.description" : {
					           required:true,
					           checkIP:true
					           }
					}  
				  });
				  
                $('#addQBoxForm').submit();
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
          
 
        function check(id){
		  var a=document.getElementById(id);	  
		  if(a.value==""||a.value==null){
			return;
			}
		    DwrMethod.checkEquipmentIP(a.value,callback);
		}
			
	    function callback(lst){
	    	if(lst.length > 0){
	    	alert("此设备IP已被占用");
	    	document.getElementById("ip").value="";  	
	    	}			
 		}
 		

         
    	--></script>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="id_bg"  onload="pageInit();">
<form action="${sys_ctx}/equipment/QBoxAdd.action" id="addQBoxForm" name="addQBoxForm" method="post">
<div id="container">
<div class="content">
<div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_ctx}/images/blue/titleicon.gif" width="20" height="25" /></div>
  <%@include file="/meeting/equipment/addInclude.jsp" %>
</div>
<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
          <tr>
            <td width="15%" class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>设备类型：</td>
             <td width="30%" class="al pl3">
		    <input type="text" name="equipmentVO.equipmentType" id="equipmentType" class="input200 fontstyle" value="QBOX"  disabled/>  
            
            </td>
            <td width="15%" class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>设备名称：</td>
            <td width="40%" class="al pl3"> <input type="text" name="equipmentVO.equipmentName" id="equipmentName" class="input200 fontstyle" value="QBOX" disabled="disabled"/>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>管理IP：</td>
            <td class="al pl3">
             <input type="text" name="equipmentVO.ip" id="ip" class="input200 fontstyle" value="" onblur="javascript:check('ip');" />
             
            </td>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>端口号：</td>
            <td class="al pl3">
            <input type="text" name="equipmentVO.port" id="port" class="input200 fontstyle" value="" />
             
            </td>
          </tr>
          <tr>
           <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>设备型号：</td>
           <td class="al pl3">
          	<select name="equipmentVO.equipmentModel" id="equipmentModel" class="select200 fontstyle">
					<zzst:option type="equipment_QBox_Model" value="" required="true"/>
			 </select>
           
            </td>
		   <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>呼叫IP：</td>
           <td class="al pl3">
           		<input type="text" name="equipmentVO.description" id="terminalIP" class="input200 fontstyle" value=""/>
           </td> 
          </tr>
          <tr>
           <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>所属会议室：</td>
             <td class="al pl3"><input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="" />
                             <input type="text" class="input200 fontstyle" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="" style="cursor:pointer"  readonly="readonly" onclick="selectConference(this)"/>
           
            </td>
           <!--<td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>Mac地址：</td>
           <td class="al pl3">
           		<input type="text" name="equipmentVO.mac" id="mac" class="input200 fontstyle" value=""/>
           </td>
          -->
          <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>管理员：</td>
            <td class="al pl3">
			    <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="" />
			   <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="input200 fontstyle" style="cursor:pointer" readonly="readonly"  onclick="selectUsers(this)"/>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>状态：</td>
            <td class="al pl3">
              	<select name="equipmentVO.status" id="status" class="select200 fontstyle">
					<zzst:option type="equipmentStatus" value="" required="true"/>
			   </select>            
            </td>
          </tr>
        </table>
          </div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
 <tfoot>
 </tfoot>        
 <tbody>
  <tr>
    <td><input type="button" name="button" id="button" value="确 定" onclick="QBoxAdd();"  class="submit1 radius2 submitBtn_Disa" />
      <input type="button" name="button2" id="button2" value="返 回" onclick="backHistory();" class="reset1 radius2" /></td>
  </tr>
  </tbody>
</table>
</div>
</div>
  </form>
</body>

</html>