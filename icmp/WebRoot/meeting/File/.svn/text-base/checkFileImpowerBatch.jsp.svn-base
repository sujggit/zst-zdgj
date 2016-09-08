<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.FileEnum"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>文件下载权限批量设置</title>
    <%@include file="/common/common.jsp"%>
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle.css" type="text/css" />
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.all-3.5.min.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<div id="basicform" class="contentwrapper">
	  <div class="contenttitle2">
	    <h5 class="fwb fl10" id="titleDiv">文件下载权限批量设置</h5>
	  </div>
	  <div id="m" style="display: none">
		<ul> 
          <li onclick="forMeetingUsers()"><span id="selectMeetingUsersLi">按参会人员授权</span></li>
          <li onclick="forUsers()"><span id="selectUsersLi">按员工授权</span></li>  
		</ul>
	  </div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="48%"><h5 class="fwb" style="float: left">说明：如有特殊权限，建议去会议资料下载页面进行单个文件的授权</h5></td>
			<td width="4%"></td>
			<td width="48%"><h5 class="fwb" style="float: left">请选择人员</h5></td>
		</tr>
	    <tr>
	  	  <td>
	  		<div id="meetingFileDiv" class="bk1">
	  		  <ul id="fileTreeObject" class="ztree"></ul>
	  		</div>
	  	  </td>
	  	  <td></td>
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
      var uploadKey = "${param.id}";
	  var uploadType = <%=FileEnum.MEETING_FILE%>;
	  //乱码问题
	  <%
	   String meetingName=request.getParameter("meetingName");
	   meetingName = new String(meetingName.getBytes("ISO8859-1"), "UTF-8");
	   out.println("var meetingName = '" + meetingName + "'"); 
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
      var settingFile = {
   			view: {
   				selectedMulti: false,
   				showTitle: true
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
       	 document.getElementById("titleDiv").innerHTML = "文件下载权限批量设置（所属会议：" + meetingName + "）";
   		 DwrMethod.getMeetingFileName(uploadType,uploadKey,meetingName,function(para){
   			 if(para!=null){
   				 var fileList = eval(para);
				 $.fn.zTree.init($("#fileTreeObject"), settingFile, fileList);
   	         }else{
   	        	 document.getElementById("meetingFileDiv").style.display = "none";
       	     }
       	 });
   		 DwrMethod.isGetMeetingUsers(uploadKey,isGetUserBack);
      })
      function isGetUserBack(para){
         if(para==true){
        	 document.getElementById("m").style.display = "block";
        	 document.getElementById("selectMeetingUsersLi").click();//forMeetingUsers();用模拟点击代替
	     }else{
	    	 document.getElementById("selectUsersLi").click();
		 }
      }

      function forMeetingUsers(){
    	  DwrMethod.getMeetingUsers(uploadKey,function(para){
    		if(para!=null){
				var zNodes = eval(para);
				$.fn.zTree.init($("#treeObject"), setting, zNodes);
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
				document.getElementById("promptSpan").innerHTML = "获取员工信息成功";
				setTimeout("document.getElementById('promptSpan').innerHTML = '';",1000);
			}else{
				document.getElementById("promptSpan").innerHTML = "获取员工信息失败";
			}
		});
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
		//获取所有文件节点（即所有子节点）
		var fileTreeObj = $.fn.zTree.getZTreeObj("fileTreeObject");
		if(!fileTreeObj){
			alert("没有文件可以授权！");
			return;
		}
		var childNodes = fileTreeObj.getNodesByParam("level",1,null);
		var fileUploadIds = new Array();
		for(var i=0;i<childNodes.length;i++){
			fileUploadIds.push(childNodes[i].id);
		}
		DwrMethod.updateFileImpower("${sys_userSession.userID}",fileUploadIds,userIDs,function(para){
			if(para == false){
	    	 	alert("设置权限失败！");	          	
	    	}else{
	    		alert("设置权限成功");	  
	    	}
		})
      }

      function backHistory(){
        window.location.href="${sys_ctx }/file/manageMeetingFileList.action";
      }
    </script>
  </body>
</html>
