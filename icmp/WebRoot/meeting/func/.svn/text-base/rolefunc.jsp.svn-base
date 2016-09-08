<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.zzst.action.meeting.role.RoleAction" %>
<%@include file="/common/common_header.jsp"%>
<script type="text/javascript">
var _g_imgWay = "<%=request.getContextPath()%>"+"/images/";
var _constant_context = "<%=request.getContextPath()%>"; 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>修改功能-已废弃</title>
    <script src="${sys_ctx}/js/mztree2/jsframework.js"></script>
    <script type='text/javascript' src='${sys_ctx}/dwr/engine.js'> </script>
	<script type='text/javascript' src='${sys_ctx}/dwr/util.js'> </script>
	<script type='text/javascript' src='${sys_ctx}/dwr/interface/DwrMethod.js'></script>
  </head>
  
 <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="id_bg" >
  <form name="treeform" action="${sys_ctx}/func/updateRoleFunc.action" method="post">

 <input name="checkeditem" type="hidden"  /> 
 <input name="roleID" type="hidden" value="<%=request.getAttribute("roleID") %>"/>
   
    <SCRIPT LANGUAGE="JavaScript">
    	var data={};
    
    	<jsp:include page="updatetreedata.jsp" flush="true" />       

        Using("System.Web.UI.WebControls.MzTreeView");
        var a = new MzTreeView();
        a.dataSource = data;
        a.isExpand = false;
        //a.rootId="50000004";
        //a.autoSort=false;
        a.useCheckbox=true
        //a.canOperate=false;
        var tmp =a.render();
    
        document.write(tmp);
        a.expandLevel(2);
       
       checkeditem='';
	function itercheck(obj)
	{	
	       	if(obj.checked==true)
	       	checkeditem+=obj.id+',';
	       	if(obj.hasChild==true)
	       	{
	       	for(var kk=0;kk<obj.childNodes.length;kk++)
	       		{
	       			if(true)
	       			{
	       				itercheck(obj.childNodes[kk]);
	       			}
	       		}
	     }
	}
 function ddd(obj)
 {
 	itercheck(obj);
 	
 }
 function addchecked(obj)
 {
 	alert(this.innerHTML);
 }      
 
 function subtree(obj){
 	itercheck(obj);
 	//if(checkeditem==""){
	//	alert("请选择要挂接的功能");
 	//	return ;
 	//}
 	var roleid = '<%=request.getAttribute("roleID") %>';
 	
 	document.treeform.checkeditem.value=checkeditem;
 	//jqueryWating(); 
 	//document.treeform.submit();
 	DwrMethod.updateRoleFunc(roleid,checkeditem,uback);
 	
 }
  function uback(para)
    {
    	if(para !=null){
    	 	alert("设置权限失败！");	          	
    	}else{
    		alert("设置成功，需要重新登录");	  
    	}	
    	checkeditem = "";
    	//window.close();		
	}
</SCRIPT>
    </form>
    <div class="buttoncontainer">
	    <input type="button" name="" id="" value="确定"  class="submit1 radius2"  onclick="subtree(a.nodes[3])" />
	    <input type="button" name="" id="" value="返回"  class="reset1 radius2"  onclick="javascript:window.location.href='${sys_ctx}/role/manageRoleList.action'" />
    </div>
  </body>
</html>
