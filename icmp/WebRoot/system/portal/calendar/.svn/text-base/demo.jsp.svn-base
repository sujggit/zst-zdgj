<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

	<%@include file="/common/common_header.jsp"%>

    <title>日历demo页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <input type="text" class="tinput" onclick="javascript:selectMeetingTime(this)" style="cursor:hand" />
    
                    
						<script type="text/javascript">
						/**
						 *creatCalendar(param1,param2)方法说明
						 *param1为出发日历控件对象自身传this就行
						 *param2为日历类型有两种date(仅日期),datetime(日期+时间)
						 *param3为语言目前传递"cn"(此功能上不可用)
						 *param4为日历弹出位置控制一般传递100
						 *param5为路径设置固定传递"${swh_ctx }/system/baseinfo/"
						 *
						 **/
						   //选择时间
							function selectMeetingTime(thisDom){
							     
							     var parameters = {
							         dateType : "datetime",
							         isNeedInfo:"true"
							     }
							  
							     creatCalendar(thisDom,parameters);
							}
			</script>
  </body>
</html>
