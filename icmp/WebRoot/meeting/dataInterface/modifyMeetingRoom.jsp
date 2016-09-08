<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>会议室修改页面 </title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
		
			
		/**
		*	设置页面参数
		*@return	null	
		*/
        function pageInit(){
		    var obj = new htmlUtil();
			obj.title("meetingRoomName","输入长度不超过25个字符");	
			obj.title("roomNO","输入长度不超过25个字符");	
			obj.title("meetingRoomType","请选择");	
			obj.title("capacity","请输入5000内数值型数据");	
			obj.title("name","输入长度不超过25个字符");	
			obj.title("title","输入长度不超过25个字符");	
			obj.title("names","输入长度不超过25个字符");	
			//obj.title("planeImg","请上传图片");	
			obj.title("status","请选择");
		};
		/**
		*	修改会议室
		*@return	null	
		*/
 		function  MeetingRoomModify(){
 			$('#modifyForm').validate({    
			  rules:{    
			   "mrVO.meetingroomName" : {
			           required:true,
			           minlength:1,
			           maxlength:25  
			           },
			     "mrVO.roomNO" : {
			           required:true,
			           minlength:1,
			           maxlength:25  
			           },
			    "mrVO.meetingRoomType" : {
			           required:true
			        
			           },
			     "mrVO.capacity" : {
			           required:true,
			           range:[0,5000]
			           },
			       "mrVO.addressName" : {
			           required:true,
			           minlength:1,
			           maxlength:25 
			           },
			       "mrVO.departmentName" : {
			           required:true,
			           minlength:1,
			           maxlength:25 
			           },
			       "mrVO.adminName" : {
			           required:true,
			           minlength:1,
			           maxlength:25 
			           },
			       "mrVO.meetingRoomStatus" : {
			           required:true
			           }
			    }
		    });
 			//var a = document.getElementById("roomNO");
 			//check("meetingRoomName");
 			//checkNO(a);
 			    $('#modifyForm').submit();
 	 		
 			//window.returnValue="1";
     	   	//window.close();
		    /*var a = document.getElementById("meetingRoomName");
		    if("${mrVO.meetingroomName }" == a.value){
		    	$('#modifyForm').submit();
		    	window.returnValue="1";
		    	window.close();
			}else{
				DwrMethod.checkMeetingRoomName(a.value,callbackForm);
   				function callbackForm(list){
   					if(list.length > 0){
   		      	    	alert("此会议室名称已被占用");
   		      	    	document.getElementById("meetingRoomName").value="";  	
   		      	    }else{
   		      	        $('#modifyForm').submit();
   		      	        window.returnValue="1";
   		      	   		window.close();
   	   		        }
   	   			}
			}*/
         };
		//校验会议室名字是否存在，不包括自己本身
         function check(id){
    		  var a=document.getElementById(id);	  
    		  if(a.value==""||a.value==null||"${mrVO.meetingroomName }" == a.value){
    			return;
    		  }
    		  DwrMethod.checkMeetingRoomName(a.value,callback);
    	 };
    	      
    	 function callback(lst){
    	    if(lst.length > 0){
    	    	alert("此会议室名称已被占用");
    	    	document.getElementById("meetingRoomName").value="";  	
    	    }			
     	 };


     	function checkNO(op){
		    
			  if(op.value==""||op.value==null || "${mrVO.roomNO}" == op.value){
				return;
			  }
			  DwrMethod.checkMeetingRoomNO(op.value,function callbackNO(result){
					
						if(result){
							alert("会议室编号已被占用");
							op.value="";  
					   }
	 		 });

	 	}
        /**
		*	返回列表
		*@return	null
		*/
        function backHistory(){
        	window.location.href="/icmp/meetingroomInterface/queryMeetingRoom.action";
        };
        
      
         
    </script>
</head>
<body onload="pageInit();">
  <form action="${sys_ctx}/meetingroomInterface/modify.action" id="modifyForm" name="modifyForm" method="post" class="contentwrapper" >
    <input name="mrVO.id" id="meetingRoomID" type="hidden" value="${mrVO.id}" />
    <div class="contenttitle2">
      <h5 class="fwb fl10">会议室修改</h5>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>会议室名称</td>
          <td width="35%" class="tableadd_data" >
            <input class="inputtran" style="width:80%" type="text" name="mrVO.meetingroomName" id="meetingRoomName" value='${mrVO.meetingroomName}' />
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>会议室类型</td>
          <td width="35%" class="tableadd_data">
            <select class="" name="mrVO.meetingRoomType" id="meetingRoomType" >
				<zzst:option type="meetingRoomType" value="${mrVO.meetingRoomType}" required="true"/>
			</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>会议室位置</td>
          <td class="tableadd_data" >
          <input class="inputtran"  id="name"  name="mrVO.addressName" type="text"  value='${mrVO.addressName}' />
          </td>
          <td class="tableaddtitle"><span>*</span>所属单位</td>
          <td class="tableadd_data">
            <input type="text" class="inputtran" name="mrVO.departmentName" id="title"  value="${mrVO.departmentName}" />
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>会议室状态</td>
          <td class="tableadd_data" >
                 <select class="" name="mrVO.meetingRoomStatus" id="status" >
					<zzst:option type="meetingRoomStatus" value="${mrVO.meetingRoomStatus}" required="true"/>
				</select></td>
          <td class="tableaddtitle"><span>*</span>管理员</td>
          <td class="tableadd_data">
            
            <input type="text" class="inputtran" name="mrVO.adminName" id="names" value="${mrVO.adminName}" />
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>容纳人数</td>
          <td class="tableadd_data" ><input class="inputtran" type="text" name="mrVO.capacity" id="capacity"  value="${mrVO.capacity}"></td>
          <td class="tableaddtitle"><span>*</span>会议室编号</td>
          <td class="tableadd_data"><input class="inputtran" type="text" name="mrVO.roomNO" id="roomNO"  value="${mrVO.roomNO}" /></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="MeetingRoomModify();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
      <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>
  </form>
</body>
</html>