<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>比对卡复制 </title>
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
			   // obj.title("equipmentName","输入长度不超过25个字符");
			    //obj.title("equipmentModel","输入长度不超过25个字符");
			    obj.title("equipmentNO","不超过25个字符");
			    obj.title("ip","输入正确的IP格式");	
			    obj.title("port","输入10000内的整数");	
			    obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
				obj.title("loginNamesss","请选择");
			    obj.title("description","长度不超过500个字符");
			    obj.title("loginName","输入用户名");
			    obj.title("loginPassWord","请输入密码");
			    obj.title("appraisalTaskNum","请选择");	
				obj.title("showFormatFlag","请选择");
			    obj.title("outputModel","长度不超过500个字符");
			    obj.title("appraisalModel","输入用户名");
			    obj.title("inputModel","输入密码");
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
					         "equipmentVO.userVO.loginName" : {
					           required:true
					           },
					       
					        
					        /*
					        "equipmentTerminalVO.videoTreaty" : {
					            minlength:1,
					            maxlength:25
					           },
					        */
					    
					        "equipmentVO.description" : {
					           minlength:1,
					           maxlength:500  
					           }
					           
					}
				  });
				  
				  
                  var meetingRoomID=document.getElementById("meetingRoomID").value;
          	    //alert(meetingRoomID);
          	    VideoCardDwrMethod.isTerminalHaveVideoCard(meetingRoomID,boolback);
          	    
              
                  
           }  

          		
          	 
          function boolback(flag){
          if(flag=="no"){
           if($('#modifyTerminalForm').valid()){
          	 $('#modifyTerminalForm').submit();
          	 $("#button").attr("disabled",true);
          	 }
          }
          else{
          	alert("此会议室下已注册比对卡");
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

   	 		
    	</script>
</head>

<body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'   onload="pageInit();">
<form action="${sys_ctx}/equipment/videoCardAdd.action" id="modifyTerminalForm" name="modifyTerminalForm" method="post">
<input type="hidden" name="" id="equipmentID" class="" value="${equipmentVO.equipmentID}"  />
<input type="hidden" name="" id="equipmentIDs" class="" value="${videoCardVO.equipmentID}"  />
 <div id="basicform" class="contentwrapper"> 
<div class="contenttitle2">
        <h5 class="fwb fl10">比对卡复制</h5>
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
          <!-- <td class="tableaddtitle"><span>*</span>设备型号</td>
          <td class="tableadd_data" ></td> -->
          
          <td class="tableaddtitle"><span>*</span>状态</td>
          <td class="tableadd_data" ><select name="equipmentVO.status" id="status" class="inputtran">
				<zzst:option type="equipmentStatus" value="${equipmentVO.status}"   required="true"/>
			 </select></td>
          <td class="tableaddtitle"><span>*</span>设备名称</td>
          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.equipmentNO" id="equipmentNO" onblur="checkNames('equipmentNO');" class="inputtran" value="" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>管理IP</td>
          <td class="tableadd_data" > <input type="text" maxlength="25" name="equipmentVO.ip" id="ip" class="inputtran" value="" onchange="check('ip');" /></td>
          <td class="tableaddtitle"><span>*</span>端口号</td>
          <td class="tableadd_data"><input type="text" maxlength="25" name="equipmentVO.port" id="port" class="inputtran" value="${equipmentVO.port}" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>所属会议室</td>
          <td class="tableadd_data" ><input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" />
                             <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" style="cursor:pointer" readonly="readonly"  value="" onclick="selectConference(this)"/></td>
          <td class="tableaddtitle"><span>*</span>管理员</td>
          <td class="tableadd_data"> <input type="hidden" name="equipmentVO.userVO.userID" id="userID" class="" value="${equipmentVO.userVO.userID}" />
			   <input type="text" name="equipmentVO.userVO.name" id="loginNamesss" class="inputtran" style="cursor:pointer" readonly="readonly" value="${equipmentVO.userVO.name}" onclick="selectUsers(this)" /></td>
        </tr>
       
      
        <tr>
          <td class="tableaddtitle">用户名</td>
          <td class="tableadd_data" > <input type="text" maxlength="25" name="videoCardVO.loginName" id="loginName" class="inputtran" value="${videoCardVO.loginName}" /></td>
          <td class="tableaddtitle">密码</td>
          <td class="tableadd_data"><input type="password" maxlength="25" name="videoCardVO.loginPassWord" id="loginPassWord" class="inputtran" value="${videoCardVO.loginPassWord}" /></td>
        </tr>
        
           <tr>
                      <td class="tableaddtitle"><span>*</span>评测任务号</td>
                      <td class="tableadd_data" >
                      <select name="videoCardVO.appraisalTaskNum" id="appraisalTaskNum" >
                      <option value="A0" <c:if test="${videoCardVO.appraisalTaskNum=='A0'}">selected</c:if> >全白</option>
                      <option value="A1" <c:if test="${videoCardVO.appraisalTaskNum=='A1'}">selected</c:if>>全灰</option>
                      <option value="A2" <c:if test="${videoCardVO.appraisalTaskNum=='A2'}">selected</c:if>>全黑</option>
                      <option value="A3" <c:if test="${videoCardVO.appraisalTaskNum=='A3'}">selected</c:if>>全红</option>
                      <option value="A4" <c:if test="${videoCardVO.appraisalTaskNum=='A4'}">selected</c:if>>全绿</option>
                      <option value="A5" <c:if test="${videoCardVO.appraisalTaskNum=='A5'}">selected</c:if>>全蓝</option>
                      <option value="A6" <c:if test="${videoCardVO.appraisalTaskNum=='A6'}">selected</c:if>>标准</option>
                      <option value="A7" <c:if test="${videoCardVO.appraisalTaskNum=='A7'}">selected</c:if>>方格</option>
                      <option value="A8" <c:if test="${videoCardVO.appraisalTaskNum=='A8'}">selected</c:if>>冻结帧</option>
                      </select>
                      
                      
                      
                     
                      </td>
                      <td class="tableaddtitle"><span>*</span>显示格式</td>
                      <td class="tableadd_data">
                     <select name="videoCardVO.showFormatFlag" id="showFormatFlag" >
                      <option value="B0"  <c:if test="${videoCardVO.showFormatFlag=='B0'}">selected</c:if> >1080p@60Hz</option>
                      <option value="B1"  <c:if test="${videoCardVO.showFormatFlag=='B1'}">selected</c:if> >1080p@50Hz</option>
                      <option value="B2"  <c:if test="${videoCardVO.showFormatFlag=='B2'}">selected</c:if> >1080p@30Hz</option>
                      <option value="B3"  <c:if test="${videoCardVO.showFormatFlag=='B3'}">selected</c:if> >1080p@25Hz</option>
                      <option value="B4"  <c:if test="${videoCardVO.showFormatFlag=='B4'}">selected</c:if> >1080p@24Hz</option>
                      <option value="B5"  <c:if test="${videoCardVO.showFormatFlag=='B5'}">selected</c:if> >1080i@60Hz</option>
                      <option value="B6"  <c:if test="${videoCardVO.showFormatFlag=='B6'}">selected</c:if> >1080i@50Hz</option>
                      <option value="B7"  <c:if test="${videoCardVO.showFormatFlag=='B7'}">selected</c:if> >720p@60Hz</option>
                      
                       <option value="B8"  <c:if test="${videoCardVO.showFormatFlag=='B8'}">selected</c:if> >720p@50Hz</option>

                      <option value="BA"  <c:if test="${videoCardVO.showFormatFlag=='BA'}">selected</c:if> >1280*1024@60Hz</option>
                      <option value="BB"  <c:if test="${videoCardVO.showFormatFlag=='BB'}">selected</c:if> >1024*768@60Hz</option>
                       
                      </select>
                     
                     
                     
                     
                      </td>
                    </tr>
             <tr>
                      <td class="tableaddtitle"><span>*</span>输入方式</td>
                      <td class="tableadd_data" >
                       <select name="videoCardVO.inputModel" id="inputModel" >
                      <option value="D0" <c:if test="${videoCardVO.inputModel=='D0'}">selected</c:if>>DVI</option>
                      <option value="D1" <c:if test="${videoCardVO.inputModel=='D1'}">selected</c:if>>[VGA]</option>
                      <option value="D2" <c:if test="${videoCardVO.inputModel=='D2'}">selected</c:if>>YPbPr</option>
                      </select>
                      
                    
                      </td>
                      <td class="tableaddtitle"><span>*</span>输出方式</td>
                      <td class="tableadd_data">
                      <select name="videoCardVO.outputModel" id="outputModel" >
                      <option value="C0" <c:if test="${videoCardVO.outputModel=='C0'}">selected</c:if>>DVI</option>
                      <option value="C1" <c:if test="${videoCardVO.outputModel=='C1'}">selected</c:if>>[VGA]</option>
                      <option value="C2" <c:if test="${videoCardVO.outputModel=='C2'}">selected</c:if>>YPbPr</option>
                      </select>
                      
                      
                      
                      </td>
                    </tr>
            
            <tr>
                      <td class="tableaddtitle"><span>*</span>评价方式</td>
                      <td class="tableadd_data" >
                       <select name="videoCardVO.appraisalModel" id="appraisalModel">
                      <option value="E0" <c:if test="${videoCardVO.appraisalModel=='E0'}">selected</c:if>>绝对偏差</option>
                      <option value="E1" <c:if test="${videoCardVO.appraisalModel=='E1'}">selected</c:if>>平均偏差</option>
                      <option value="E2" <c:if test="${videoCardVO.appraisalModel=='E2'}">selected</c:if>>自标准差</option>
                      <option value="E3" <c:if test="${videoCardVO.appraisalModel=='E3'}">selected</c:if>>自平均</option>
                       <option value="E4" <c:if test="${videoCardVO.appraisalModel=='E4'}">selected</c:if>>源标准差</option>
                      <option value="E5" <c:if test="${videoCardVO.appraisalModel=='E5'}">selected</c:if>>源平均</option>
                     
                      </select>
            
                    
                      </td>
                      <td class="tableaddtitle"><span>*</span>采集方式</td>
                       <td class="tableadd_data">
                       <select name="videoCardVO.collectModel" id="collectModel">
                         <option value="F0" <c:if test="${videoCardVO.collectModel=='F0'}">selected</c:if>>单帧采集</option>
                      <option value="F1" <c:if test="${videoCardVO.collectModel=='F1'}">selected</c:if>>多帧采集</option>                             
                      </select>
            
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
            
            <input type="button" name="button" id="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="equipmentTerminalModify();"/>
              
              <input type="button"name="button2" id="button2"  class="reset1 radius2" value="取 消" onclick="backHistory();"/>
              </td>
          </tr>
        </tbody>
      </table>
      </div>
  </form>
</body>

</html>