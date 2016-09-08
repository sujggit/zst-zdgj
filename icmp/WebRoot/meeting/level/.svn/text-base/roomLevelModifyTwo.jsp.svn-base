<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.LevelEnum"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="swh_ctx" value="${pageContext.request.contextPath}"></c:set>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"%>
<%@ page import="com.zzst.model.meeting.address.AddressVO"%>
<%@ page import="com.zzst.action.meeting.meetingRoom.MeetingRoomAction"%>
<%@ page import="com.zzst.model.enums.UserEnum"  %>
<%@ page import="com.zzst.model.enums.DateBaseEnum"  %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>会议室分级配置修改页面</title>
	 <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
	
		<script type="text/javascript">
		var setting = {

			view: {
				selectedMulti: true
			},
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
	             // onDblClick: zTreeOnDblClick
			}
		};
		
		  <%
			 MeetingRoomAction dptAction = new MeetingRoomAction();
        	response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store"); 
        	response.setDateHeader("Expires",0);
        	response.setHeader("Pragma","no-cache");
        	ArrayList listDpt = dptAction.getRoomAdressList();
	
			     if(null!=listDpt){
			    	 Object sessionUvo=session.getAttribute(UserEnum.USER_SESSION_ID);
			          StringBuffer dataWH = new StringBuffer();
			          dataWH.append("var dataWH = new Array();");
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
			          int deptLength = listDpt.size();
					      for(int i=0;i<deptLength;i++){
					         AddressVO dpvo = (AddressVO)listDpt.get(i);
					         
					        // UserAction  userAction = new UserAction();
					         String departID = dpvo.getAddressID();
					         String departName = dpvo.getName();
					         
					         ArrayList lst_user = dptAction.getMeetingRoomByAddress(departID,sessionUvo);
					         if(!(dpvo.getAddressID().equals(DateBaseEnum.Default_ID))){
								if(lst_user==null||lst_user.size()<1){continue;}
								}
					         if(null!=lst_user){
					            int length = lst_user.size();
					             for(int j=0;j<length;j++){
					                 MeetingRoomVO userVO = (MeetingRoomVO)lst_user.get(j);
					                 dataObj.append("{id:'"+userVO.getMeetingRoomID()+"',pId:'"+departID+"',name:\""+userVO.getMeetingRoomName()+"\",fullName:\""+userVO.getMeetingRoomName()+"\",open:false,isParent:false},");
					                 String newObj = "{"+
							          "conferenceID:'"+userVO.getMeetingRoomID()+"',"+
							          "conferenceName:'"+userVO.getMeetingRoomName()+"'"+
							         "};";               
					                 dataWH.append("dataWH['"+userVO.getMeetingRoomID()+"'] = "+newObj+";");
					             }
					         }
					         if(i==deptLength-1){
					             dataObj.append("{id:'"+departID+"',pId:'"+dpvo.getParentID()+"',name:\""+departName+"\",fullName:\""+dpvo.getName()+"\",open:false,isParent:true}");
					         }else{
					             dataObj.append("{id:'"+departID+"',pId:'"+dpvo.getParentID()+"',name:\""+dpvo.getName()+"\",fullName:\""+dpvo.getName()+"\",open:false,isParent:true},");
					         }
				         }
				      dataObj.append("];");
				      out.println(dataWH);
				      out.println(dataObj);
			     }
		%>
		function createTree() {
			$.fn.zTree.init($("#treeObject"), setting, zNodes);
			$.fn.zTree.getZTreeObj("treeObject").setting.check.chkboxType = { "Y" : "s", "N" : "ps" };
			var zTree = $.fn.zTree.getZTreeObj("treeObject");
			var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			var allCheckedNodesIDs="${levelVO.levelKeyIds1 }";
			var strids= new Array();   
           strids=allCheckedNodesIDs.split(",");      
           for (i=0;i<strids.length ;i++ ){
           zTree.checkNode(zTree.getNodeByParam("id", strids[i], null),true,true,false);
           } 
		}
		
		
		$(document).ready(function(){
		    initLevel();
			createTree();	
					
		});
		
		function initLevel(){
	 		var power = document.getElementById("power").value;
	 		if(power == "noPower"){
		 		$("#meetingRoomNames").attr("disabled","disabled");
		 		$("#addButton").val("分级权限不够").attr("disabled","disabled");
		 	}else if(power == "LEVEL_IS_CLOSE"){
		 		$("#meetingRoomNames").attr("disabled","disabled");
		 		$("#addButton").val("分级已关闭").attr("disabled","disabled");
		 	}
		 }
		 
		
	     
	 	function add(){    
	 	var zTree = $.fn.zTree.getZTreeObj("treeObject");
		var nodes = zTree.getCheckedNodes(true);
		var checkedNodeIDs="";
		for(var i=0;i<nodes.length;i++){
		checkedNodeIDs+=nodes[i].id+",";
		}
			checkedNodeIDs=checkedNodeIDs.substring(0,checkedNodeIDs.length-1);	
			document.getElementById("meetingRoomNameIDs").value=checkedNodeIDs;
		    $('#form').submit();
		}

		function backHistory(){
			var level_pId=document.getElementById("level_pId").value;
			window.location.href = "${sys_ctx }/level/roomLevelList.action?parentId="+level_pId;
		}

		
   
		
		</script>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/level/roomLevelModify.action?" method="post" name="form" id="form">
	    <div id="basicform" class="contentwrapper">
	    <input type="hidden" id="power" value="${power }"/>
	    <input id="levelType" name="levelConfigVO.levelType" type="hidden" value="<%=LevelEnum.LEVEL_ROOM %>"/>
	    <input id="level_pId" name="level_pId" type="hidden" value="<%=request.getAttribute("level_pId")%>"/>
	    
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">会议室分级配置修改</h5>
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
				<td class="tableaddtitle" valign="top"><span>*</span>会议室名称</td>
				<td class="tableadd_data" align="left" valign="top">
	            <input id="meetingRoomNameIDs" name="levelConfigVO.levelKey" type="hidden" value="${levelVO.levelKeyIds1 }"/>
	            <input id="description" name="levelConfigVO.description" type="hidden"/>
				
					<div  style="width:470px;height:300px;padding:0;overflow:auto;">
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
		            	<input class="submit1 radius2 submitBtn_Disa" type="button" name="addButton" id="addButton" value="确  定"  onclick="add();"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="backHistory()"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
	</form>
			
  </body>
</html>
