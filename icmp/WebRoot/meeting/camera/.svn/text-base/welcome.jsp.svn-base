<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.kst.Camera" %>
<%@ page import="com.zzst.model.meeting.kst.CameraGroup" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<%@include file="/common/common_header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>同步页面</title>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<script type='text/javascript'>
		function synchronizeInfo(){
			DwrMethod.synchronizeInfo_camera(synchronizeInfoback);
			//location.href = "${sys_ctx}/camera/synchronizeInfo.action";
		}
		
		function synchronizeInfoback(result){
			if(result == false){
				alert("失败！");
			}else if(result == true){
				alert("同步成功");
				//window.parent.document.getElementById("left").src = "${sys_ctx}/meeting/camera/tree.jsp?treelist="+result;
				window.parent.frames['left'].location.reload();   
			}
		}
	</script>
  </head>
  
  <body>
  	<input type="button" value="同步视频监控数据" class="scbtn fontstyle fontb" onclick="synchronizeInfo();" />
  </body>
</html>
