<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.zzst.model.meeting.user.UserVO" %>
<%@ page import="com.zzst.model.meeting.department.DepartmentVO" %>
<%@page import="com.zzst.action.meeting.util.MeetingAppConfig"%>
<%@page import="com.zzst.model.enums.UserEnum"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>权限设置</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.excheck-3.5.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true,
				chkboxType:{"Y":"","N":""}
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeCheck: beforeCheck,
				onCheck: onCheck
			}
		}; 
		<%
	 		 Map map = (Map)request.getAttribute("authorizationMap");
			 ArrayList list =  (ArrayList)request.getAttribute("uList");
			 ArrayList dlist =  (ArrayList)request.getAttribute("dList");
			     if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
			          for(int i=0;i<dlist.size();i++){
			          	DepartmentVO dVO = (DepartmentVO)dlist.get(i);
			          	dataObj.append("{id:'"+dVO.getId()+"_dept',pId:'"+dVO.getParentId()+"_dept',name:\""+dVO.getTitle()+"\"");
			          	if(dVO.getParentId().indexOf("-")>=0 || dVO.getParentId()==null || "".equals(dVO.getParentId())){
			          	
			          	 dataObj.append(",open:true");
			          	 }
			          	 dataObj.append(",chkDisabled:true");
			          	 dataObj.append("}");
			          	  dataObj.append(",");	
			          }
				      for(int i=0;i<list.size();i++){
				    	  UserVO userVO = (UserVO)list.get(i);
				    	  
				    	  UserVO sUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
				    	  if("true".equalsIgnoreCase(MeetingAppConfig.PWDAUTH)){
				    	  	if(userVO.getUserID().equalsIgnoreCase(sUserVO.getUserID())){
				    	  		continue;
				    	  	}
				    	  }
				    	  
			              dataObj.append("{id:'"+userVO.getUserID()+"',pId:'"+userVO.getDepartmentVO().getId()+"_dept',name:\""+userVO.getName()+"\"");
			              if(map!=null)
			              	if(map.get(userVO.getUserID()+"")!=null)
			               		dataObj.append(",checked:true");
			                 
		                	dataObj.append("}");
			                if(i!=list.size()-1){
							      dataObj.append(",");			                	 
			                }
				       }
				      dataObj.append("];");
				      out.print(dataObj);
			     }
		%>

		var code, log, className = "dark";
		function beforeCheck(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeCheck ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name );
			return (treeNode.doCheck !== false);
		}
		function onCheck(e, treeId, treeNode) {
			//showLog("[ "+getTime()+" onCheck ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name );
		}		
		 
		$(document).ready(function(){
			$.fn.zTree.init($("#funcTree"), setting, zNodes);
		});
		
		function subtree(){
			var roleid = "<%=request.getAttribute("roleID")%>";
		
			//选择状态的节点
			var treeObj = $.fn.zTree.getZTreeObj("funcTree");
			var checkedNodes = treeObj.getCheckedNodes(true);
			var userIDs = new Array();
			var userNames = new Array();
			for(var i=0;i<checkedNodes.length;i++){
				userIDs.push(checkedNodes[i].id);
				userNames.push(checkedNodes[i].name);
			}
			
			//半选状态的节点
			//var cheFalseNodes = treeObj.getCheckedNodes(false);
			//for(var i=0;i<cheFalseNodes.length;i++){
			//	if(cheFalseNodes[i].getCheckStatus().half==true){
			//		funcIDs.push(cheFalseNodes[i].id);
			//	}
			//}
			$("#subbtn").val("请等待").attr("disabled","disabled");
             $("#subbtn").attr("class","");
			DwrMethod.updateAuthorization(roleid,userIDs,userNames,function(back){
		 		if(back == "failure"){
		    	 	alert("设置失败！");	          	
		    	}else{
		    		alert("设置成功！");	  
		    	}
		    	history.go(0);
		 	});
		}

		function backHistory(){
	        window.location.href="${sys_ctx }/role/manageRoleList.action";
	    }
	</script>
  </head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">分配人员</h5>
	   
	    <!--pageheader   addBy 熊顺~改变页头样式-->
	          <div class="dtree">
	            <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
	              <tfoot>
	              </tfoot>
	              <tbody>
	                <tr class="gradeA">
	                  <td align="">
						 <ul id="funcTree" class="ztree"></ul>
						</td>
	                </tr>
	              </tbody>
	            </table>
	          </div>
					 <!--  改变确定取消按钮的样式（权限管理~挂接功能）addBy 熊顺
					 <input type="button" name="" id="" value="确定" style="cursor:pointer"  class="button fontstyle fontb"  onclick="subtree()" />
				    <input type="button" name="" id="" value="返回" style="cursor:pointer"  class="button fontstyle fontb"  onclick="javascript:window.location.href='${sys_ctx}/role/manageRoleList.action'" />
				    -->
			    <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			        <tfoot>
			        </tfoot>
					<tbody>
			          <tr>
			            <td>
			            	<input class="submit1 radius2" type="button" name="subbtn" id="" value="确 定" style="cursor:pointer" onclick="subtree()"/>
			              	<input class="reset1 radius2" type="button" name="" id="" value="返 回" style="cursor:pointer"  onclick="backHistory();"/>
			              </td>
			          </tr>
			        </tbody>
			    </table>
			</div>
		</div>
	</body>
</html>
