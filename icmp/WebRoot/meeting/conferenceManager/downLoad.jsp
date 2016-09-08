<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会议列表</title>

</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >

 <div id="container">
<div class="content">
<div class="contenttitle fontstyle ">
  <div class="fl fontb">&nbsp;文件下载</div>
</div>

 

<div class="tablesdiv">
<table width="100%" border="0" id="query_table" cellspacing="0" cellpadding="0" class="listsearch">
         <thead>
	        <tr>
           	<th width="65px" class="titlehome ac fontstyle" >序号</th>
            <th class="titlehome ac fontstyle" style="border-left:0px">会议名称</th>           
          
          </tr>
          </thead>
          <tbody>
          
          <c:forEach  items="${upload_list}" var="uploadFileVO" >
  <tr>
  
      <td class="ac fontstyle ">1</td>
      <td class="ac fontstyle ">
      <form action="${sys_ctx }/detail/download.action" method="post">
      <input type="hidden" name="fileName" value="${uploadFileVO.fileName}"/>
      <input type="submit" value="${uploadFileVO.fileName}" style="cursor:pointer"" />
      </form>
      </td>
     
 </tr>
 
 
  </c:forEach>
  
          </tbody>
       </table>
</div>
  <input type="button" name="button2" id="cancelButton" value="关  闭" style="cursor:pointer"  class="submit1 radius2"  onclick="javascript:window.close();" />	

</div>
</div>

</body>
</html>