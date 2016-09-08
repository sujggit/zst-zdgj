<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.zzst.service.meeting.auth.FuncServiceImpl" %>
<%@ page import="com.zzst.model.meeting.auth.FuncVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>权限设置</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
		var setting = {
			view: {
				selectedMulti: false
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
				beforeCheck: beforeCheck,
				onCheck: onCheck
			}
		};
		<%
	 		 Map map = (Map)request.getAttribute("roleFuncMap");
			 ArrayList list =  new FuncServiceImpl().getFuncList(null, null);
			     if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
				      for(int i=0;i<list.size();i++){
				    	  FuncVO funcVO = (FuncVO)list.get(i);
			                 dataObj.append("{id:'"+funcVO.getFunc_id()+"',pId:'"+funcVO.getParent_id()+"',name:\""+funcVO.getFunc_name()+"\"");
			                 if(i<3)
				                 dataObj.append(",open:true");
			                 
			                 //设置当前角色是否拥有该功能
			                 if(map!=null)
			                	 if(map.get(funcVO.getFunc_id()+"")!=null)
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
			var checkedNodes = treeObj.getCheckedNodes();
			var funcIDs = new Array();
			var funcNames=new Array();
			for(var i=0;i<checkedNodes.length;i++){
				funcIDs.push(checkedNodes[i].id);
				funcNames.push(checkedNodes[i].name);
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
		 	DwrMethod.updateRoleFunc(roleid,funcIDs,funcNames,function(back){
		 		if(back !=null){
		    	 	alert("设置权限失败！");	          	
		    	}else{
		    		alert("设置成功，需要重新登陆");	  
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
	        <h5 class="fwb fl10">权限设置</h5>
	   
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
			            	<input class="submit1 radius2" type="button" name="" id="subbtn" value="确 定" style="cursor:pointer" onclick="subtree()"/>
			              	<input class="reset1 radius2" type="button" name="" id="" value="返 回" style="cursor:pointer"  onclick="backHistory();"/>
			              </td>
			          </tr>
			        </tbody>
			    </table>
			</div>
		</div>
	</body>
</html>
