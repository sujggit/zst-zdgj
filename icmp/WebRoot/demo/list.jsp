<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/common_header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<body>
<div id="container">
<div class="content">
<div class="contenttitle fontstyle ">
  <div class="fl"><img src="${sys_page_list_down}" width="20" height="25" /></div>
  <div class="fl fontb">&nbsp;查询条件</div>
  <div class="fr"><input name="" type="button" class="searbutton fontstyle fontb" value="查 询" /></div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
    <tr>
      <td width="20%" class="ar fontstyle pr3 tdhight">会议室名称：</td>
      <td width="25%" class="al pl3 tdhight"><input type="text" name="textfield2" id="textfield2" class="input200 fontstyle"  /></td>
      <td width="20%" class="ar fontstyle pr3 tdhight">&nbsp;</td>
      <td width="35%" class="al pl3 tdhight">&nbsp;</td>
    </tr>
    <tr>
      <td class="ar fontstyle pr3 tdhight tdhight">开始时间：</td>
      <td class="al pl3 tdhight"><input type="text" name="textfield" id="textfield" class="input200 fontstyle" />
        <img src="${sys_page_list_time}" width="16" height="16" /></td>
      <td class="ar fontstyle pr3 tdhight">结束时间：</td>
      <td class="al pl3 tdhight"><input type="text" name="textfield3" id="textfield3" class="input200 fontstyle" />
        <img src="${sys_page_list_time}" width="16" height="16" /></td>
    </tr>
    <tr>
      <td class="ar fontstyle pr3 tdhight">会议状态：</td>
      <td class="al pl3 tdhight"><select name="select" id="select" class="select200 fontstyle">
        <option>会议</option>
      </select></td>
      <td class="ar fontstyle pr3 tdhight">会议类型：</td>
      <td class="al pl3 tdhight"><select name="select3" id="select3" class="select200 fontstyle">
      </select></td>
    </tr>
  </table>
  <div class="contenttitle fontstyle ">
  <div class="fl"><img src="${sys_page_list_table }" width="20" height="25" /></div>
  <div class="fl fontb">&nbsp;查询结果</div>
</div>

<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="listsearch">
   <thead>
	          <tr>
	          	<th width="65px" class="titlehome ac fontstyle">序号</th>
	            <th width="120px" class="titlehome ac fontstyle">日志类型</th>
	            <th width="" class="titlehome ac fontstyle">描述</th>
	            <th width="140px" class="titlehome ac fontstyle">时间</th>
	            <th width="10%" class="titlehome ac fontstyle">操作人</th>
	            <th width="130px" class="titlehome ac fontstyle">操作IP</th>
	          </tr>
          </thead>
           <tbody>
           <c:forEach items="${logVOList}" var="logVO" 	varStatus="state">
			   <tr>
				<td class="ac fontstyle "><c:out value="${state.index+1}"></c:out></td>
				 <td class="ac fontstyle ">&nbsp;
				 	<zzst:lable type="logType" value="${logVO.logType}"></zzst:lable>
				 </td>
				 <td class="ac fontstyle ">&nbsp;<c:out value="${logVO.operatorContent}"/></td>
				 <td class="ac fontstyle ">&nbsp;<fmt:formatDate value="${logVO.operatorDate }"  pattern="yyyy-MM-dd HH:mm"/></td>
				 <td class="ac fontstyle ">&nbsp;<c:out value="${logVO.userName}"/></td>
				 <td class="ac fontstyle ">&nbsp;<c:out value="${logVO.userIP}"/></td>
			   </tr>
	        </c:forEach>
			</tbody>
</table>

</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
  <tr>
    <td>
    	<jsp:include page="/common/pageFooter.jsp"/>
    </td>
  </tr>
</table>
</div>
</div>
</body>
</html>
