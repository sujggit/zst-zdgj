<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@page import="com.zzst.model.enums.EquipmentEnum"%>
<%@page import="com.zzst.model.meeting.dictionary.DictionaryEquipmentVO"%>
<html>

<script type="text/javascript">
   function menu6()
  {
        location.href="${sys_ctx }/equipment/noticeBeforeAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="#fff";
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
  
  
    function menu7()
  {      
         location.href="${sys_ctx }/equipment/audioBeforeAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
</script>
  <body>
     <div id="m">
         <ul> 
         <%
     	ArrayList deList = (ArrayList)request.getAttribute("deList");
     	if(deList != null && deList.size() > 0){
     		for(int i=0; i<deList.size(); i++){
     			DictionaryEquipmentVO dVo = (DictionaryEquipmentVO)deList.get(i);
     			if(dVo.getDicValue()==EquipmentEnum.TYPE_ID_ENC){
     				%>
     				<li id="m6" onmousedown="menu6();" style="background:<%=request.getAttribute("style6")%>">告示增加</li> 
     				
     				<%
     			}
     			if(dVo.getDicValue()==EquipmentEnum.TYPE_ID_AUDIO){
     				
     				%>
     				<li id="m7" onmousedown="menu7();" style="background:<%=request.getAttribute("style7")%>">音频增加</li>
     				<%
     			}
     		}
     	}
     	%>
     	 
       </ul>
     </div>
  </body>
</html>