<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.FileEnum"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>文件下载权限设置</title>
    <%@include file="/common/common.jsp"%>    
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle.css" type="text/css" />
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.all-3.5.min.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<div id="basicform" class="contentwrapper">
	  <div class="contenttitle2">
	    <h5 class="fwb fl10" id="titleDiv">文件下载权限设置</h5>
	  </div>
	  <div id="m" style="display: none">
		<ul>
		  <li onclick="forMeetingUsers()"><span id="selectMeetingUsersLi">按参会人员授权</span></li>
          <li onclick="forUsers()"><span id="selectUsersLi">按员工授权</span></li> 
		</ul>
	  </div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><h5 class="fwb" style="float: left">请选择人员</h5></td>
		</tr>
		<tr>
			<td>
			  <div id="treeDiv" class="bk1">
				<ul id="treeObject" class="ztree"></ul>
			  </div>
			</td>
		</tr>
	  </table>

      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	     <tfoot>
	     </tfoot>
		 <tbody>
          <tr>
            <td>
                <span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
            	<input class="submit1 radius2" type="button" name="" id="" value="确 定" onclick="subtree()"/>
              	<input class="reset1 radius2" type="button" name="" id="" value="返 回" onclick="javascript:backHistory();"/>
              </td>
          </tr>
	     </tbody>
	  </table>
    </div>
    <script>
      var uploadId = "${param.id}";
	  var uploadType = "${param.type}";
	  var uploadKey = "${param.key}";
	  //乱码问题
	  <%
	   String meetingName = request.getParameter("mName");
	   meetingName = new String(meetingName.getBytes("ISO8859-1"), "UTF-8");
	   out.println("var meetingName = '" + meetingName + "'");
	   String fileName = request.getParameter("fName");
	   fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
	   out.println("var fileName = '" + fileName + "'");
	  %>

	  $("#m ul li").bind("click",function(){
		$("#m ul li").removeClass("kk");
		$(this).addClass("kk"); 
	  })
	  
      var setting = {
			view: {
				selectedMulti: true,
				showTitle: true
			},
			check: {
				enable: true
	  		},
			edit: {
				enable: false
			},
			data: {
				key: {
					title: "fullName"
				},
				simpleData: {
					enable: true
				}
			}
		};
  	  
      $(document).ready(function(){
    	 if(<%=FileEnum.MEETING_FILE%>==uploadType||<%=FileEnum.MEETING_RECORD_FILE%>==uploadType){
        	 document.getElementById("titleDiv").innerHTML = "文件下载权限设置（所属会议：" + meetingName + "） （所属文件："+ fileName + "）";
    		 DwrMethod.isGetMeetingUsers(uploadKey,isGetUserBack);
         }else if(<%=FileEnum.RULE_FILE%>==uploadType){
             document.getElementById("selectUsersLi").click();
         }
    	 
      })
      function isGetUserBack(para){
         if(para==true){
        	 document.getElementById("m").style.display = "block";
        	 document.getElementById("selectMeetingUsersLi").click();
        	 //forMeetingUsers();用模拟点击代替
	     }else{
	    	 document.getElementById("selectUsersLi").click();
		 }
      }

      function forMeetingUsers(){
    	  DwrMethod.getMeetingUsers(uploadKey,function(para){
    		if(para!=null){
				var zNodes = eval(para);
				$.fn.zTree.init($("#treeObject"), setting, zNodes);
				getUserByUploadId();
				document.getElementById("promptSpan").innerHTML = "获取参会员工信息成功";
				setTimeout("document.getElementById('promptSpan').innerHTML = '';",1000);
    	  	}else{
				document.getElementById("promptSpan").innerHTML = "获取参会员工信息失败";
			}
  	  	  })
      }
      function forUsers(){
    	  DwrMethod.getUsers(function(para){
			if(para!=null){
				var zNodes = eval(para);
				$.fn.zTree.init($("#treeObject"), setting, zNodes);
				getUserByUploadId();
				document.getElementById("promptSpan").innerHTML = "获取员工信息成功";
				setTimeout("document.getElementById('promptSpan').innerHTML = '';",1000);
			}else{
				document.getElementById("promptSpan").innerHTML = "获取员工信息失败";
			}
		});
      }
	  //根据uploadId获取有下载权限的人,并自动选中
	  function getUserByUploadId(){
		  DwrMethod.getUserByUploadId(uploadId,function(para){
			if(para){
				var data = eval(para);
				var treeObj = $.fn.zTree.getZTreeObj("treeObject");
				var chkNode;
				for(var i = 0;i<data.length;i++){
					chkNode = treeObj.getNodeByParam("id",data[i].userId,null);
					if(chkNode){//解决用户ID被篡改的jsbug
						treeObj.checkNode(chkNode,true,true);
						if(<%=FileEnum.STATUS_IMPOWER_MANAGER%> == data[i].status){
							treeObj.setChkDisabled(chkNode,true);
						}
					}
				}
			}
		  })
	  }
	  
      function subtree(){
    	//选择状态的节点
		var treeObj = $.fn.zTree.getZTreeObj("treeObject");
		var checkedNodes = treeObj.getCheckedNodes();
		var userIDs = new Array();
		for(var i=0;i<checkedNodes.length;i++){
			if(!checkedNodes[i].isParent){
				userIDs.push(checkedNodes[i].id);
			}
		}

		var fileUploadIds = new Array();
		fileUploadIds.push(uploadId);
		DwrMethod.updateFileImpower("${sys_userSession.userID}",fileUploadIds,userIDs,function(para){
			if(para == false){
	    	 	alert("设置权限失败！");	          	
	    	}else{
	    		alert("设置权限成功");	  
	    	}
		})
      }

      function backHistory(){
      	window.location.href="${sys_ctx }/file/meetingFileDownloadList.action";
      }
    </script>
  </body>
</html>
