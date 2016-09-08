<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="com.zzst.model.enums.FuncEnum"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>导航</title>
</head>
<body>

  <div class="pageheader notab">
      <h3 class="pagetitle" style="padding-left: 16px"><%=FuncEnum.CURRENT_TITLE %><span id="currentDiv">首页</span></h3>
      <input type="hidden" id="funcId" />
    </div>

</body>
</html>
