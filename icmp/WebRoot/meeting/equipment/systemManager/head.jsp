<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.meeting.auth.FuncVO"%>
<%@page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@page language="java" import="java.util.ArrayList"%>
<%@page language="java" import="java.util.List"%>
<%@page import="com.zzst.model.meeting.user.UserVO"%>
<%@page import="com.zzst.model.enums.UserEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
   function menu1()
  {
       location.href="${sys_ctx}/equipmentBackup/mcuBackupquery.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="#fff";
     
      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
  
  
    function menu2()
  { 
        location.href="${sys_ctx }/equipmentBackup/terminalBackupquery.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
     

      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
</script>
</head>
  <body>
   
       
     
    <!--pageheader-->
       
            <div id="m">
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
             				if("8a8690153947d1f4013947d4325e9811".equals(funcVO.getFunc_id())){
             				%>
                            	<li id="m1" onmousedown="menu1();" style="background:<%=request.getAttribute("style1")%>">MCU备份管理</li>
                            <%
             				}else if("8a8690153947d1f4013947d4325e9812".equals(funcVO.getFunc_id())){
             				%>
                            	<li id="m2" onmousedown="menu2();" style="background:<%=request.getAttribute("style2")%>">终端备份管理</li>
                            <%
             				}
             				
             			}
             		}
             		%>
              </ul>
            </div>
           
            
  </body>
</html>