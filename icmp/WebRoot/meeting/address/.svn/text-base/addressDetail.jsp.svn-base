<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common_header.jsp"%>
		<style type="text/css">
		   input{
		       border:0px ;
		   }
		</style>
	</head >

  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
		<tr>
		    <td colspan="4" class="contenttitle fontstyle fontb">位置详情：${addressVO.name}</td>
		  </tr>
          <tr>
            <td width="20%" class="ar fontstyle fontb pr3 tdhight">位置名称：</td>
             <td width="30%" class="al pl3">
             <c:out value="${addressVO.name}"></c:out>
            </td>
            <td width="15%" class="ar fontstyle fontb pr3 tdhight">上级节点：</td>
            <td width="35%" class="al pl3"><c:out value="${addressVO.parentID}"></c:out>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">状态：</td>
            <td class="al pl3">
             <c:out value="${addressVO.status}" ></c:out>
            </td>
            <td class="ar fontstyle fontb pr3 tdhight">描述：</td>
            <td class="al pl3">
            <c:out value="${addressVO.description}"></c:out>
            </td>
          </tr>
        </table>           
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		  <tr>
		    <td>
		          <input type="button" name="button2" id="cancelButton" value="关  闭"  class="submit1 radius2"  onclick="javascript:window.close();" />
		    	 </td>
		    	 </tr>
    	 </table>
	</body>
</html>