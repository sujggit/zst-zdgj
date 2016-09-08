<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<%@include file="/common/common_header.jsp"%>
<base target="_self" /> 
<link href="${sys_ctx }/meeting/equipmentControl/css/lg.css" type="text/css" rel="stylesheet" />
  <script type='text/javascript' src='/icmp/dwr/interface/TerminalDwrMethod.js'></script>
  <script language="javascript">
function btnchClick(){
    el=event.srcElement
    if (el.tagName=="INPUT"&&el.type=="button") {
        if (el.className == "cc_btn") {
            var inputArray = document.getElementsByName("inputName");
            if(inputArray != null && inputArray.length > 0){
				for(var i=0; i<inputArray.length; i++){
					inputArray[i].className = "cc_btn";
				}
            }
            el.className = "gray-an";
        }        
        else {
            el.className = "cc_btn";
        }
    }
}

function btnqhClick(){
    el=event.srcElement
    if (el.tagName=="INPUT"&&el.type=="button") {
        if (el.className == "cc_btn2") {
            el.className = "gray-an";
        }        
        else {
            el.className = "cc_btn2";
        }
    }
}


   function matriSwitchss(){
       var ids1=document.getElementById("matrixNames").value;
    //   var outputValues=document.getElementsByName("allModelSwitchOutPort").id;
       var inputArray = document.getElementsByName("inputName");
       var inputVlaues;
       for(var i=0;i<inputArray.length;i++){
       if (inputArray[i].className == "gray-an") {
           // alert(inputArray[i].id);
            inputVlaues=inputArray[i].id;
          }
         }
   //   alert(outputValues);
      var idss="";
     var outputValues="1";
     //输出数据模拟
     TerminalDwrMethod.matriSwitchesByIP(idss,ids1,inputVlaues,outputValues,matriSwitchssback);
   }
   
    function matriSwitchssback(result)
    {
	    	if(result==true){
	    	alert("成功！");
	    	window.close(); 
	    	}else{
	    	alert("失败！");
	    	window.close(); 
	    	}	
	}
	
	
	
	
	function matrixName(){
      var ids=document.getElementById("matrixNames").value;
      var ips=document.getElementById("ip").value;
       var element =document.createElement("a");   
			    element.href="${sys_ctx}/equipmentControl/bigscreenInputBefore.action?equipmentVO.ip="+ips+"&matrixSwitchVO.id="+ids;   
			    document.body.appendChild(element);   
			    element.click();
    }
</script>
  </head>
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="id_bg">
 	<form action="${sys_ctx}/equipmentControl/bigscreenInputBefore.action" id="pageform" name="pageform" method="post">
      <div class="blueb">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <input type="hidden" name="equipmentVO.ip"  id="ip"   value="${equipmentVO.ip}">
        <tr>
        <td colspan="2" valign="middle" style="height:30px">
         <select name="matrixSwitchVO.id" class="sel_sx" id="matrixNames" onchange="matrixName();">
        	<c:forEach items="${matrixSwitchVOList}" var="matrixSwitchVOTemp" varStatus="state">
   		             <option value="${matrixSwitchVOTemp.id}" ${matrixSwitchVOTemp.id==matrixSwitchVO.id  ? "selected" : "" } ><c:out value="${matrixSwitchVOTemp.name}"/></option>
            </c:forEach>
        </select>
        </td>
        </tr>
      <tr>
        <td colspan="2" class="text_sr">输入</td>
        </tr>
      <tr>
        <td colspan="2">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="height:150px; border-bottom:#1e302f 1px solid;">
         <tr> 
         <c:forEach items="${matrixSwitchVO.in}" var="vo"  varStatus="status">  
          <td><input type="button"  class="cc_btn"  value="${vo[1]}" onclick="btnchClick()" onfocus="this.blur()"  name="inputName"  id="${vo[0]}"/></td>
           <c:if test="${status.index>0&&(status.index+1)%5==0}"> 
          </tr>
         </c:if>
        </c:forEach>
        </table>
        </td>
        </tr>
      <tr>
         <td>
         <input type="hidden" name="allModelSwitchOutPort" id="${allModelSwitchOutPort}" value="${allModelSwitchOutPort}">
         </td>
       </tr>
         
       <%-- 
        <tr>
         <c:forEach items="${viewScreentVO.allModelSwitchOutPort}" var="map"  varStatus="status">  
          <td><input type="button"  class="cc_btn"  value="${map.value}" onclick="btnchClick()" onfocus="this.blur()"  name="inputName"  id="${map.key}"/></td>
           <c:if test="${status.index>0&&(status.index+1)%5==0}"> 
          </tr>
         </c:if>
        </c:forEach>
       
         --%>
 
        
       <tr>
        <td >
<%--        <span class="tablexxInput">输入1给输出1</span>--%>
        <td align="right" valign="bottom" style="padding-right:25px;"><input type="button" class="cc_btn3" value="确定"  onclick="matriSwitchss();"></td>
      </tr>
    </table>
   </div>
  </form>
  </body>
</html>
