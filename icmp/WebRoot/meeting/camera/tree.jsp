<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.kst.Camera" %>
<%@ page import="com.zzst.model.meeting.kst.CameraGroup" %>
<%@ page  import="com.zzst.service.meeting.kst.KstVedioMoniterServiceImpl" %>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO" %>
<%@ page import="com.zzst.service.meeting.baseinfo.BaseInfoServiceImpl" %>
<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE> 异步加载数据</TITLE>
	
	 <%@include file="/common/common_header.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
   
   
   <!--<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery-1.4.4.min.js"></script>-->
      <SCRIPT type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></SCRIPT>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
		var setting = {
			view: {
			   selectedMulti: false
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
			    showRenameBtn: false
				},
			data: {
				simpleData: {
					enable: true
				},
				keep: {
				    parent:true
				}
			},
			callback: {
			    beforeExpand: beforeExpandTree,
			    beforeCollapse: beforeCollapseTree,
				onCollapse: onCollapseTree,
				onClick:   onClickName,
				onExpand: onExpandTree
				
			}
		};

		<%
	 		 
	 		 BaseInfoVO b = new BaseInfoVO();
			 b.setInfoType("kst_guid");
			 ArrayList list = new BaseInfoServiceImpl().query(b,null);
			if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
			          //dataObj.append("{id:'000',pid:'0',name:'视频监控系统',infotype:'aaa'");
			          //dataObj.append(",isParent:true},");
			           for(int i=0;i<list.size();i++){
				    	    BaseInfoVO baseinfo = (BaseInfoVO)list.get(i);
				    	    dataObj.append("{id:'"+baseinfo.getInfoValue()+"',pid:'000',name:'"+baseinfo.getInfoName()+"',infotype:\""+baseinfo.getInfoType()+"\"");
				    	    dataObj.append(",isParent:true");
				    	    dataObj.append("}");
			                 if(i!=list.size()-1){
							      dataObj.append(",");			                	 
			                 }
				       }
				      dataObj.append("];");
				     
				      out.print(dataObj);
				     
		}     
		%>
		function beforeCollapseTree(treeId, treeNode) {
			//className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeCollapse ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name );
			return (treeNode.collapse !== false);
		}
		function beforeExpandTree(treeId, treeNode) {
			//className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeExpand ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name );
			return (treeNode.expand !== false);
		}
		
		function onCollapseTree(event, treeId, treeNode) {
			//showLog("[ "+getTime()+" onCollapse ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name);
		}
		
		var signStr = "";var pidCode = "";
		function onExpandTree(event,treeId, treeNode) {
			var pid = treeNode.id;
			if(pid.length>6){pidCode=pid.substring(pid.length-5);}
			if(signStr.indexOf(pidCode)>-1){return;}
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			DwrMethod.expandTreeName(pid,function(treeList){
			   for(var i=0;i<treeList.length;i++){
			   	   var groupid=treeList[i].groupid;
				   var groupname=treeList[i].groupname;
				   var leaf=treeList[i].leaf;
				   if(leaf==0){
				   		zTree.addNodes(treeNode,{id:groupid, pid:pid, isParent:true,name:groupname});
				   }
				   else{
						zTree.addNodes(treeNode,{id:groupid, pid:pid, name:groupname});
				   }
				}
		 	});	
		 	signStr += pidCode+",";
		};
		function onClickName(event, treeId, treeNode){
		   var groupid=treeNode.id;
		  
		   if(!treeNode.isParent){
		    window.parent.frmright0.location.href="/icmp/camera/getCamerasByGroupid.action?groupid="+groupid;
		   }
		};

		function initjPa(){
			$.fn.zTree.init($("#treeDemo"), setting,zNodes);
		};
		
		 
	</SCRIPT>

</HEAD>

<BODY onload="initjPa()" class="content_wrap">

<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	
</div>
</BODY>
</HTML>