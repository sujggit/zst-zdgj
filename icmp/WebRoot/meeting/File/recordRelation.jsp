<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>综合会议管理平台</title>
<link rel="stylesheet" href="../css/style.default.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${sys_ctx }/meeting/meetingManage/poll/poll.css"/>   
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">

	function recordRelation(){
		var meetingDetailID = document.getElementById("meetingDetailID").value;
	
		var fileUrlArray = new Array();
		var fileNameArray = new Array();
		$("#confList1 li").find("input[type='checkbox']").each(function(i){
			if(this.checked){
				fileUrlArray.push($(this).next().val());
				fileNameArray.push($(this).parent().text());
			}
		
		});
		DwrMethod.videoRelation(meetingDetailID,fileUrlArray,fileNameArray,function(){window.close();});
		
	}
</script> 
</head>
<body>
<form action="${sys_ctx }/user/manageUserList.action" id="pageform" name="pageform" method="post">
<div id="basicform" class="contentwrapper">
    <div class="contenttitle2" >
        <h5 class="fwb fl10">视频会议（所属会议：<c:out value="${meetingName }"></c:out>）</h5>
    </div>
    <div id="screenContainer" class="screenContainerDiv" >
        <div id="screen1" style="width:100%;height:100%;" class="screen">
            <ul id="confList1" class="screenUl">
                
                <c:forEach items="${fileMap}" var="file">
                <c:set var="flag" value="0"/>
                <c:forEach items="${fileList }" var="oldfile">
                <c:if test="${file.key==oldfile.fileUrl}">
                <li><input type="checkbox" checked/><input class="fileurl" type="hidden" value="${file.key}"/>${file.value }</li>
                <c:set var="flag" value="1"/>
                </c:if>
                </c:forEach>
                <c:if test="${flag == 0 }">
                <li><input type="checkbox"/><input class="fileurl" type="hidden" value="${file.key}"/>${file.value }</li>
                </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
    <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer pfb" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="button" class="submit1 radius2" value="确 定" onclick="recordRelation();"/>
                  <input type="button" class="reset1 radius2" value="关 闭" onclick="window.close();"/>
                </td>
              </tr>
            </tbody>
    </table>
</div>
</form>
<input type="hidden" value="${meetingDetailID }" id="meetingDetailID"/>
</body>
</html>
