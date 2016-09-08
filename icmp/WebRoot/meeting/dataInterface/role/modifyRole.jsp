<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>角色修改页面 </title>
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
			obj.title("rolename","输入长度不超过25个字符");	
		};
		/**
		*	修改会议室
		*@return	null	
		*/
 		function  roleModify(){
 			$('#modifyForm').validate({    
			  rules:{    
			   "riVO.rolename" : {
			           required:true,
			           minlength:1,
			           maxlength:25  
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
		


     	
        /**
		*	返回列表
		*@return	null
		*/
        function backHistory(){
        	window.location.href="/icmp/roleInterface/queryRole.action";
        };
        
      
         
    </script>
</head>
<body onload="pageInit();">
  <form action="${sys_ctx}/roleInterface/modify.action" id="modifyForm" name="modifyForm" method="post" class="contentwrapper" >
    <input name="riVO.roleid" id="roleID" type="hidden" value="${riVO.roleid}" />
    <div class="contenttitle2">
      <h5 class="fwb fl10">角色修改</h5>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>角色</td>
          <td width="35%" class="tableadd_data" >
            <input class="inputtran" style="width:80%" type="text" name="riVO.rolename" id="rolename" value='${riVO.rolename}' />
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="roleModify();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
      <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>
  </form>
</body>
</html>