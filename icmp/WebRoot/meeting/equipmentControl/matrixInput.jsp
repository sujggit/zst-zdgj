<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <script language="javascript">
     

   

</script>
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
  	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="">
  	  <tr class="">
  	  	<input type="hidden" id="meetingRoomIDs" value="${equipmentVO.meetingRoomVO.meetingRoomID}"/>
          <td class="ar fontstyle pr3">
          	<select id="meetingRoomID" name="equipmentVO.ip" onchange="matrix();" class="select200 fontstyle">
              <c:forEach items="${equipmentList}" var="equipmentVOs" varStatus="state">
   				<option value="${equipmentVOs.ip}" ${equipmentVOs.ip==equipmentVO.ip  ? "selected" : "" } ><c:out value="${equipmentVOs.meetingRoomVO.meetingRoomName}"/></option>
   			  </c:forEach>
            </select></td>
          <td class="al pl3">
          	<select name="matrixSwitchVO.id" id="matrixNames" class="select200 fontstyle" onchange="matrixName();">
              <c:forEach items="${matrixSwitchVOList}" var="matrixSwitchVOTemp" varStatus="state">
   		    	<option value="${matrixSwitchVOTemp.id}" ${matrixSwitchVOTemp.id==matrixSwitchVO.id  ? "selected" : "" } ><c:out value="${matrixSwitchVOTemp.name}"/></option>
              </c:forEach>
            </select></td>
  	  </tr>
  	</table>
  	<table width="98%" border="0" cellspacing="1" cellpadding="0" class="jztable" align="center">
      <tr>
        <td class="jztitle pl3 fontstyle fontb">输入</td>
      </tr>
      <tr>
         <td class="jztd ac">
         <c:forEach items="${matrixSwitchVO.in}" var="vo"  varStatus="status">  
         	<input type="button"  class="srbtn fontstyle fontb"  value="${vo[1]}" onclick="btnchClick()" onfocus="this.blur()"  name="inputName"  id="${vo[0]}"/>
         	<c:if test="${status.index>0&&(status.index+1)%7==0&&status.last==false}"> 
          		</td></tr>
          		<tr><td class="jztd ac">
          </c:if>
          <c:if test="${status.index>0&&status.last==true}">
          	</td></tr>
          </c:if>
       </c:forEach>
    </table>
    <table width="98%" border="0" cellspacing="1" cellpadding="0" class="jztable" align="center">
      <tr>
        <td class="jztitle pl3 fontstyle fontb">输出</td>
      </tr>
      <tr> 
       <td class="jztd ac">
       <c:forEach items="${matrixSwitchVO.out}" var="vo"  varStatus="status">  
          <input type="button"  class="scbtn fontstyle fontb"  value="${vo[1]}" onclick="btnqhClick()" onfocus="this.blur()"  name="outputName"  id="${vo[0]}"/>
          <c:if test="${status.index>0&&(status.index+1)%7==0&&status.last==false}"> 
          	  </td></tr>
          	  <tr><td class="jztd ac">
          </c:if>
          <c:if test="${status.index>0&&status.last==true}">
          	</td></tr>
          </c:if>
        </c:forEach>
     </table>
  </body>
</html>
