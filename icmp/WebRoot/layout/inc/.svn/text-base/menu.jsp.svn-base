<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一级菜单</title>
<script language="javascript">
	var tdIDs = new Array();
	
	var selectID;
	function setSelectID(id){
		selectID = id;
	}
	function chengeOver(param){
		param.className = 'font12wb ac menuselect';
	}
	function chengeOut(param){
		if(param.id !=selectID)
		param.className = 'font12wb ac ';
	}
	
	function menu(id,name)
	{
		for(var i=0;i<tdIDs.length;i++)
		{
		var node = document.getElementById(tdIDs[i]);
		  if(tdIDs[i]== id){
			  setSelectID(id);
			  node.className = 'font12wb ac menuselect';
		  }else{
		   	  node.className = 'font12wb ac ';
		  }
		}
		window.parent.cLeftMenu(id,name);
	}
</script>	
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="menu">
  <tr>
  <c:forEach  items="${sys_userSession.funcVOList}" var="funVO" varStatus="state">
       <c:if test="${funVO.parent_id!= '-1' && funVO.parent_id == '0' }">
        <td class="font12wb ac" onmouseover="chengeOver(this)" onmouseout="chengeOut(this)" onmouseup="menu('${funVO.func_id}','${funVO.func_name }');" id="${funVO.func_id }" style="cursor:pointer"  >
         <%--<a hidefocus href="javascript:void(0)" onmouseup="menu('${funVO.func_id}','${rank }','${funVO.func_name }');" id="${funVO.func_id}" url="${funVO.func_url}">--%>
                 ${funVO.func_name }
            <%--</a>--%>
        </td>
    	<td class="menuline">&nbsp;</td>
        <script>
        	tdIDs.push('${funVO.func_id}');
        </script>
       </c:if>
   </c:forEach>
  </tr>
</table>
</body>
</html>
