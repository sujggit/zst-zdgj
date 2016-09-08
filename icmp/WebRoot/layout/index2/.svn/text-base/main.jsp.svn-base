<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${sys_ctx }/layout/js/frame.js"></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/UserAction.js'> </script>
<script type="text/javascript">
		
	//add by yangyi  当前操作会场信息
	var operateMeetingRoom = "";
	
	function getOperateMeetingRoom(){
		return operateMeetingRoom;
	}
	
	function setOperateMeetingRoom(id){
		//alert("myID::"+id);
		operateMeetingRoom = id;
	}


</script>

<title>欢迎登陆${sys_viewName }</title>
</head>
 

  <frameset name="secmainbody" cols="180,10,*" frameborder="no" border="0" framespacing="0">
    <frame src="${sys_ctx }/layout/index2/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="${sys_ctx }/layout/index2/middle.jsp" name="middleFrame" scrolling="No" noresize="noresize" id="middleFrame" title="middleFrame" />
	<frameset rows="43,*" cols="*" frameborder="no" border="0" framespacing="0">
        <frame src="${sys_ctx }/layout/index2/current.jsp" name="currentFrame" id="currentFrame" title="currentFrame" scrolling="No" />
        <frame src="${sys_ctx }/layout/index2/welcom.jsp" id="rightFrame" name="rightFrame" scrolling="auto" noresize />
    </frameset>
  </frameset>
<noframes>
	<body class="id_bg" >

	</body>
</noframes>

</html>
