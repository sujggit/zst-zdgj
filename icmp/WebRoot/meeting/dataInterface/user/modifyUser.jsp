<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>用户修改页面 </title>
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
			obj.title("loginname","输入长度不超过25个字符");	
			obj.title("fullname","输入长度不超过25个字符");	
			obj.title("email","请输入正确的email格式");	
			obj.title("mobilephone","请输入手机号码");	
			obj.title("rolename","输入长度不超过25个字符");	
			obj.title("departmentid","输入长度不超过25个字符");	
		};
		/**
		*	修改会议室
		*@return	null	
		*/
 		function  userModify(){
 			$('#modifyForm').validate({    
			  rules:{    
 				"uiVO.loginname" : {
			           required:true,
			           minlength:1,
			           maxlength:25  
			           },
			     "uiVO.fullname" : {
			           required:true,
			           minlength:1,
			           maxlength:25 
			           },
			    "uiVO.email" : {
			           required:true,
			           email:true
			           },
			     "uiVO.mobilephone" : {
			        	   required:true,
						   digits:true,
						   max:19999999999,
						   min:10000000000
			           },
			       "uiVO.rolename" : {
			        	 required:true,
			        	 minlength:1,
				         maxlength:25
			           },
			       "uiVO.departmentid" : {
			           required:true,
			           minlength:1,
			           maxlength:50 
			           }
			    }
		    });
 			    $('#modifyForm').submit();
 	 		
         };
        /**
		*	返回列表
		*@return	null
		*/
        function backHistory(){
        	window.location.href="/icmp/userInterface/queryUser.action";
        };
    </script>
</head>
<body onload="pageInit();">
  <form action="${sys_ctx}/userInterface/modify.action" id="modifyForm" name="modifyForm" method="post" class="contentwrapper" >
    <input name="uiVO.userid" id="userID" type="hidden" value="${uiVO.userid}" />
    <div class="contenttitle2">
      <h5 class="fwb fl10">用户修改</h5>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>用户名</td>
          <td width="35%" class="tableadd_data" >
            <input class="inputtran" style="width:80%" type="text" name="uiVO.loginname" id="loginname" value='${uiVO.loginname}' />
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>姓名</td>
          <td width="35%" class="tableadd_data">
           <input class="inputtran" style="width:80%" type="text" name="uiVO.fullname" id="fullname" value='${uiVO.fullname}' />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>邮箱</td>
          <td class="tableadd_data" >
          <input class="inputtran"  id="email"  name="uiVO.email" type="text"  value='${uiVO.email}' />
          </td>
          <td class="tableaddtitle"><span>*</span>手机</td>
          <td class="tableadd_data">
            <input type="text" class="inputtran" name="uiVO.mobilephone" id="mobilephone"  value="${uiVO.mobilephone}" />
            </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>角色</td>
          <td class="tableadd_data" >
           <input type="text" class="inputtran" name="uiVO.rolename" id="rolename"  value="${uiVO.rolename}" />
          </td>
          <td class="tableaddtitle"><span>*</span>部门</td>
          <td class="tableadd_data">
            <input type="text" class="inputtran" name="uiVO.departmentid" id="departmentid" value="${uiVO.departmentid}" />
          </td>  
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="userModify();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
      <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>
  </form>
</body>
</html>