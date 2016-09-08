<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>会议模板</title>
		<script type="text/javascript">
		function qeury(){
			document.pageform.submit();
		}
		
		function showWall(id){	
			//window.open('${kst_wall_preset}' + id);
			el=event.srcElement
		    if (el.tagName=="INPUT"&&el.type=="button") {
		        if (el.className == "button2 fontstyle fontb") {
		            var inputArray = document.getElementsByName("inputName");
		            if(inputArray != null && inputArray.length > 0){
						for(var i=0; i<inputArray.length; i++){
							inputArray[i].className = "button2 fontstyle fontb";
						}
		            }
		            el.className = "button2 fontstyle fontb";
		        }        
		    }
			//var url = '${kst_wall_preset}' + id;
			DwrMethod.sendMsgToWallPreset(id,sendMsgToWallPresetBack);
		}
		
		function sendMsgToWallPresetBack(result){
			if(result == true){
				alert("操作成功");
			}
			if(result == false){
				alert("操作失败");
			}
		}
		
		function synchronizeInfo(){
			DwrMethod.synchronizeInfo_wallPreset(synchronizeInfoback);
			//location.href = "${sys_ctx}/camera/synchronizeInfo.action";
		}
		
		function synchronizeInfoback(result){
			if(result == false){
				alert("失败！");
			}else if(result == true){
				alert("同步成功");
				//window.parent.document.getElementById("left").src = "${sys_ctx}/meeting/camera/tree.jsp?treelist="+result;
				window.location.reload();   
			}
		}
     </script>  
</head>
	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
		<form action="/icmp/camera/queryForWallPreset.action" method="post" name="pageform" id="pageform">
		<div id="container">
<div class="content">
<div class="contenttitle fontstyle ">
  <div class="fl"><img src="${sys_page_list_down}" width="20" height="25" /></div>
  <div class="fl fontb">&nbsp;查询条件</div>
  <div class="fr">
  <input name="button2" type="button" class="searbutton fontstyle fontb"
		value="查 询" onclick="qeury();" />
  <input name="button2" type="button" class="searbutton fontstyle fontb"
		value="同步数据" onclick="synchronizeInfo();" />
  <%--<input type="button" value="同步电视墙数据" class="scbtn fontstyle fontb" onclick="synchronizeInfo();" />--%>
  
  </div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
	<tr>
		<td style="width: 40%" class="ar fontstyle fontb pr3 tdhight">地区名称：</td>
        <td style="width: 60%" class="al pl3 tdhight">
        	<input type="text" id="wallPresetVO.viewName" onblur="qeury();" name="wallPresetVO.viewName" value="${wallPresetVO.viewName}" class="input200 fontstyle" />
        </td>
    </tr>
</table>

<div class="tablesdiv">
<table width="98%" border="0" cellspacing="1" cellpadding="0" class="jztable" align="center">
	<tr>
        <td class="jztitle pl3 fontstyle fontb">地区分组</td>
    </tr>
    <tr>
         <td class="jztd ac">
		<c:forEach items="${wallPresetList}" var="wallPreset"  varStatus="status">  
         	<input type="button"  class="button2 fontstyle fontb"  value="${wallPreset.viewName}" onclick="showWall('${wallPreset.id}');" onfocus="this.blur()"  name="inputName"  id="${vo[0]}"/>
         	<c:if test="${status.index>0&&(status.index+1)%5==0&&status.last==false}"> 
          		</td></tr>
          		<tr><td class="jztd ac">
          </c:if>
          <c:if test="${status.index>0&&status.last==true}">
          	</td></tr>
          </c:if>
       </c:forEach>
</table>
		</div>

    	<jsp:include page="/common/pageFooter.jsp"/>

</div>
</div>
 </form>
</body>
</html>