<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>用户分级配置修改页面</title>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/level/userLevelModify.action?" method="post" name="form" id="form">
	    <div id="basicform" class="contentwrapper">
	      <input type="hidden" id="power" value="${power }"/>
	      <input id="levelType" name="levelConfigVO.levelType" type="hidden" value="<%=LevelEnum.LEVEL_USER %>"/>
	      <input id="level_pId" name="level_pId" type="hidden" value="<%=request.getAttribute("level_pId")%>"/>
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">用户分级配置修改（超级用户：拥有本级及下一级的权限；普通用户：仅拥有本级的权限）</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
			  <td class="tableaddtitle"><span>*</span>分级名称</td>
			  <td class="tableadd_data" >
			  	<input id="levelID" name="levelConfigVO.levelID" type="hidden" value="${levelVO.levelID}"/>
			  	<input id="levelName" name="levelName" class="inputtran" value="${levelVO.levelName}" disabled="disabled"/>
			  </td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span></span>超级用户名称</td>
				<td class="tableadd_data" >
					<input id="userID_super" name="levelConfigVO.description" type="hidden" value="${levelVO.levelKeyIds1}" />
					<input id="userName_super" name="userName" class="inputtran" onclick="selectUsers(this)" readonly="readonly" value="${levelVO.levelKeyNames1}" title="${levelVO.levelKeyNames1}"/>
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span></span>普通用户名称</td>
				<td class="tableadd_data" >
					<input id="userID" name="levelConfigVO.levelKey" type="hidden" value="${levelVO.levelKeyIds2 }" />
					<textarea id="userName" name="userName" class="inputtran" onclick="selectUsers(this)" readonly="readonly" title="${levelVO.levelKeyNames2}" style="cursor:pointer;width:100%"><c:out  value="${levelVO.levelKeyNames2 }"></c:out></textarea>
				</td>
			</tr>
	       </table>
		  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		            	<input class="submit1 radius2 submitBtn_Disa" type="button" name="addButton" id="addButton" value="确  定"  onclick="add();"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="backHistory()"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
	</form>
	 <script type="text/javascript">
	 	$(document).ready(function(){
	 		pageInit();
	 		var power = document.getElementById("power").value;
	 		if(power == "noPower"){
		 		$("#userName").attr("disabled","disabled");
		 		$("#userName_super").attr("disabled","disabled");
		 		$("#addButton").val("分级权限不够").attr("disabled","disabled");
		 	}else if(power == "LEVEL_IS_CLOSE"){
		 		$("#userName").attr("disabled","disabled");
		 		$("#userName_super").attr("disabled","disabled");
		 		$("#addButton").val("分级已关闭").attr("disabled","disabled");
		 	}
		 });
		 
		 function pageInit(){
				var obj = new htmlUtil();
				obj.title("userName","请选择人员信息");
				//obj.title("description","输入长度不超过300个字符");
	     }
	 	function add(){ 
	 		var userName = document.getElementById("userName").value;
			var userName_super = document.getElementById("userName_super").value;
			var userName_temp = "${levelVO.levelKeyNames2}";
			var userName_super_temp = "${levelVO.levelKeyNames1}";
			if(userName==userName_temp && userName_super==userName_super_temp){
				backHistory();
				return;
			}
			if(userName || userName_super){
				$('#form').submit();
			}else{
				alert("不能将人员分级配置信息清空");
				return;
			}
		}

		function backHistory(){
			var level_pId=document.getElementById("level_pId").value;
			window.location.href = "${sys_ctx }/level/userLevelList.action?parentId="+level_pId;
		}

		/**选择用户信息
		*/
		function selectUsers(thisDom){
			var userID_super = document.getElementById("userID_super").value;
			var userID = document.getElementById("userID").value;
			var selectedUser = userID+";"+userID_super;
            var userParameters = {
                methodName:'getReturnUserMethod',
                selectedUser:selectedUser,
                selectType:'multiple'
            }
            creatUserSelAll(thisDom,userParameters); 
      	};
  		function getReturnUserMethod(userArray){
            var userID="";
            var userName="";
            var userID_super="";
            var userName_super="";
            userArray = eval(userArray);
            var userLength = userArray.length;
            for(var i=0;i<userLength;i++){
                if(userArray[i].superPower==<%=LevelEnum.LEVELCONFIG_SUPERPOWER%>){
   	                userName_super =userName_super+userArray[i].userName+",";
   	                userID_super = userID_super+userArray[i].userID+",";
                }else  if(userArray[i].superPower==<%=LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE%>){
   	                userName =userName+userArray[i].userName+",";
   	                userID = userID+userArray[i].userID+",";
                }
            }
            userName_super = userName_super.substring(0,userName_super.length-1);
            userID_super = userID_super.substring(0,userID_super.length-1);
            userName = userName.substring(0,userName.length-1);
            userID = userID.substring(0,userID.length-1);
        	$("#userID").attr("value",userID);
      		$("#userName").attr("value",userName);
      		$("#userID_super").attr("value",userID_super);
     		$("#userName_super").attr("value",userName_super);
       };
	 </script>
  </body>
</html>
