<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/meeting/equipment/check.js'> </script>
<title>比对卡添加</title>
<script type="text/javascript">
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
		       "videoCardVO.loginName" : {
		             required:true,
		            minlength:1,
		            maxlength:25
		           },
		        "videoCardVO.loginPassWord" : {
		            required:true,
		            minlength:1,
		            maxlength:25
		           },
		             "videoCardVO.appraisalTaskNum" : {
		             required:true,
		            minlength:1,
		            maxlength:25
		           },
		        "videoCardVO.showFormatFlag" : {
		            required:true,
		            minlength:1,
		            maxlength:25
		           },
		             "videoCardVO.outputModel" : {
		             required:true,
		            minlength:1,
		            maxlength:25
		           },
		        "videoCardVO.appraisalModel" : {
		            required:true,
		            minlength:1,
		            maxlength:25
		           },
		             "videoCardVO.inputModel" : {
		             required:true,
		            minlength:1,
		            maxlength:25
		           },		       
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
 if($('#addMcuForm').valid()){
	 $('#addMcuForm').submit();
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

	function getEquipmentName(op){
			var mcuId = op.value;
			var templateTd = document.getElementById("equipmentName_");
			var html ="<select name='equipmentVO.equipmentName' class='inputtran' id='equipmentName' title='请选择'><option value=''>请选择...</option>";
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
  
  
  <body onload="pageInit();" STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx}/equipment/videoCardAdd.action" id="addMcuForm" name="addMcuForm" method="post"/>
  <div id="basicform" class="contentwrapper"> 
  <div id="m" style="background:none;border:none">  
     <%@include file="./equipmentAddHead.jsp"%>
   </div>
   
                <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                    <tr>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备类型</td>
                      <td width="35%" class="tableadd_data" >
                      <select name="equipmentVO.equipmentType" id="equipmentType" class="inputtran" disabled="disabled">
						<zzst:option type="equipmentEnum" value="7" required="true"/>
			   		  </select>  
                      </td>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备厂家</td>
                      <td width="35%" class="tableadd_data" id="equipmentName_">
                      <select name="equipmentVO.equipmentName" id="equipmentName" class="inputtran">
	              			<option value="">请选择...</option>
	      			  </select>       
                      </td>
                    </tr>
                    <tr>
                     <!-- <td class="tableaddtitle"><span>*</span>设备型号</td>
                      <td class="tableadd_data" >
                      <select name="equipmentVO.equipmentModel" id="equipmentModel" >
							<zzst:option type="equipment_MCU_Model" value="1" required="true"/>
			 			  </select>
                      </td>-->
                       <td class="tableaddtitle"><span>*</span>状态</td>
                      <td class="tableadd_data" >
                        <select name="equipmentVO.status" id="status" >
							<zzst:option type="equipmentStatus" value=""  required="true"/>
			 			</select></td>
                      
                      <td class="tableaddtitle"><span>*</span>设备名称</td>
                      <td class="tableadd_data">
                      <input type="text" maxlength="25" name="equipmentVO.equipmentNO" onblur="checkNames('equipmentNO');" id="equipmentNO" class="inputtran"  />
                      </td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>管理IP</td>
                      <td class="tableadd_data" >
                      <input type="text" maxlength="25" class="inputtran" name="equipmentVO.ip" id="ip" onblur="check('ip');"/>
                      </td>
                      <td class="tableaddtitle"><span>*</span>端口号</td>
                      <td class="tableadd_data">
                      <input type="text" maxlength="25" name="equipmentVO.port" id="port" class="inputtran" value="24" />
                      </td>
                    </tr>
                  
                    <tr>
                      <td class="tableaddtitle"><span>*</span>所属会议室</td>
                      <td class="tableadd_data" >
                      <input type="hidden" name="equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" />
                      <input type="text" name="equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran"  style="cursor:pointer" readonly="readonly" onclick="selectConference(this)"/>
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
                      <input type="text" maxlength="25" name="videoCardVO.loginName" id="loginName" class="inputtran" />
                      </td>
                      <td class="tableaddtitle"><span>*</span>密码</td>
                      <td class="tableadd_data">
                       <input type="password" maxlength="25" name="videoCardVO.loginPassWord" id="loginPassWord" class="inputtran" />
                      </td>
                    </tr>
            
              <tr>
                      <td class="tableaddtitle"><span>*</span>评测任务号</td>
                      <td class="tableadd_data" >
                      <select name="videoCardVO.appraisalTaskNum" id="appraisalTaskNum" >
                      <option value="A0">全白</option>
                      <option value="A1">全灰</option>
                      <option value="A2">全黑</option>
                      <option value="A3">全红</option>
                      <option value="A4">全绿</option>
                      <option value="A5">全蓝</option>
                      <option value="A6">标准</option>
                      <option value="A7">方格</option>
                      <option value="A8">冻结帧</option>
                      </select>
                      
                      </td>
                      <td class="tableaddtitle"><span>*</span>显示格式</td>
                      <td class="tableadd_data">
                      <select name="videoCardVO.showFormatFlag" id="showFormatFlag" >
                      <option value="B0">1080p@60Hz</option>
                      <option value="B1">1080p@50Hz</option>
                      <option value="B2">1080p@30Hz</option>
                      <option value="B3">1080p@25Hz</option>
                      <option value="B4">1080p@24Hz</option>
                      <option value="B5">1080i@60Hz</option>
                      <option value="B6">1080i@50Hz</option>
                  
                      
                      <option value="B7">720p@60Hz</option>
                      
                       <option value="B8">720p@50Hz</option>
                      
                      <option value="BA">1280*1024@60Hz</option>
                      <option value="BB">1024*768@60Hz</option>
                       
               
                      </select>
                      
                    
                      </td>
                    </tr>
             <tr>
                      <td class="tableaddtitle"><span>*</span>输入方式</td>
                      <td class="tableadd_data" >
                       
                      <select name="videoCardVO.inputModel" id="inputModel" >
                      <option value="D0">DVI</option>
                      <option value="D1">[VGA]</option>
                      <option value="D2">YPbPr</option>
                      </select>
                     
                      </td>
                      <td class="tableaddtitle"><span>*</span>输出方式</td>
                      <td class="tableadd_data">
                       <select name="videoCardVO.outputModel" id="outputModel">
                      <option value="C0">DVI</option>
                      <option value="C1">[VGA]</option>
                      <option value="C2">YPbPr</option>
                      </select>
            
                      </td>
                    </tr>
            
            <tr>
                      <td class="tableaddtitle"><span>*</span>评价方式</td>
                      <td class="tableadd_data" >
                     <select name="videoCardVO.appraisalModel" id="appraisalModel">
                      <option value="E0">绝对偏差</option>
                      <option value="E1">平均偏差</option>
                      <option value="E2">自标准差</option>
                      <option value="E3">自平均</option>
                       <option value="E4">源标准差</option>
                      <option value="E5">源平均</option>
                     
                      </select>
            
                
                      </td>
                      
                       <td class="tableaddtitle"><span>*</span>采集方式</td>
                       <td class="tableadd_data">
                       <select name="videoCardVO.collectModel" id="collectModel">
                      <option value="F0">单帧采集</option>
                      <option value="F1">多帧采集</option>                  
                      </select>
            
                      </td>
                     
                    </tr>
            
                    <tr>
                      <td class="tableaddtitle">描述</td>
                       <td colspan="3" class="tableadd_data" ><textarea name="equipmentVO.description" rows="5" class="areatran" id="description"></textarea></td>
                      </tr>
                  </table>
                  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table" >
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
  </body>
</html>