<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<%@page import="com.zzst.model.meeting.auth.FuncVO"%>
<%@page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@page language="java" import="java.util.ArrayList"%>
<%@page language="java" import="java.util.List"%>
<%@page import="com.zzst.model.meeting.user.UserVO"%>
<%@page import="com.zzst.model.enums.UserEnum"%>
<html>
<head>
	<script type="text/javascript">
	   function menu1()
	  {
			var level_pId=document.getElementById("levelPid").value;
			alert(level_pId);
	        location.href="${sys_ctx }/level/userLevelList.action?level_pId="+level_pId;
	       //document.getElementsByTagName("li")[x-1].style.backgroundColor="#fff";
	       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
	  }
	  
	    function menu2()
	  {      
	    	var level_pId=document.getElementById("levelPid").value;
			alert(level_pId);
	         location.href="${sys_ctx }/level/roomLevelList.action?level_pId="+level_pId;
	       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
	       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
	  }
	</script>
</head>
  <body>
     <div id="m">
     <input type="hidden" id="levelPid" name="levelPid" value="<%=request.getAttribute("level_pId")%>"/>
         <ul>
         
         <%
          	FuncVO funcVO = new FuncVO();
          	UserVO userVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
       		List fcList = new ArrayList();
       		fcList = ServiceFactory.getFuncService().getFuncList(userVO,null);
       		if(fcList!=null&&fcList.size()>0){
       			StringBuffer sb = new StringBuffer();
       			for(int i=0;i<fcList.size();i++){
       				funcVO =(FuncVO)fcList.get(i);
       				if("8a8690153947d1f4013947d4325e9915".equals(funcVO.getFunc_id())){
       				%>
                      	<li id="m1" onmousedown="menu1();" style="background:<%=request.getAttribute("style1")%>">人员分级配置</li>
                      	
                      <%
       				}else if("8a8690153947d1f4013947d4325e9916".equals(funcVO.getFunc_id())){
       				%>
                      	<li id="m2" onmousedown="menu2();" style="background:<%=request.getAttribute("style2")%>">会议室分级配置</li>
                      <%
       				}
       				
       			}
       		}
         %>
       </ul>
     </div>
  </body>
</html>