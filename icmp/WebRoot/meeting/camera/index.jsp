<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.action.meeting.util.MeetingAppConfig"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@include file="/common/common_header.jsp"%>
		<title>组摄像头</title>
		<script type='text/javascript'
			src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
		
		function view(sysid,id){
			DwrMethod.viewOne(sysid,id,"3",viewOneBack);
		}
		
		function viewOneBack(url){
			if(url==null || url==""){
				alert("未取到摄像头图像");
			}
			window.open(url);
		}
		
		function viewall(sysid,id){
			DwrMethod.viewAll(sysid,id,"2",viewallBack);
		}
		
		function viewallBack(url){
			if(url==null || url==""){
				alert("未取到摄像头图像");
			}
			window.open(url);
		}            
        
		</script>
</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
 <div id="container">
				<div class="content">
					<div class="contenttitle fontstyle ">
						<div class="fl">
							<img src="${sys_page_list_down}" width="20" height="25" />
						</div>
						<div class="fl fontb">
							&nbsp;查询
						</div>
						<div class="fr">
							<input name="button2" type="button" onclick="viewall('${clist[0].domainid}','${clist[0].groupid}')" class="searbutton fontstyle fontb"
								value="组查看" onclick="" />
						</div>
					</div>
       				 
        			<div class="contenttitle fontstyle ">
						<div class="fl">
							<img src="${sys_page_list_table }" width="20" height="25" />
						</div>
						<div class="fl fontb">
							&nbsp;查询结果
						</div>
					</div>

					<div class="tablesdiv">
						<table width="100%" border="0" id="query_table" cellspacing="0"
							cellpadding="0" class="listsearch">
							<thead>
								<tr>
					          	<th width="65px" class="titlehome ac fontstyle" >序号</th>
					            <th width=""  class="titlehome ac fontstyle">名称</th>
					            <th width="" class="titlehome ac fontstyle" >所属组名</th>
					            <th width="110px" class="titlehome ac fontstyle" >操作</th>
					          </tr>
					          </thead>
					          <tbody>
	          <c:forEach items="${clist}" var="camera" 	varStatus="state">
		              <tr >
		                    <td class="ac fontstyle ">&nbsp;<c:out value="${camera.cameraid}"/></td>
				            <td class="ac fontstyle ">&nbsp;<c:out value="${camera.cameraname}"/></td>
				            <td class="ac fontstyle ">&nbsp;<c:out value="${camera.groupname}"/></td>
				           
				            <td class="ac fontstyle ">
   				                <img src="/icmp/images/main/save-icon.gif" style="cursor:pointer" onclick="view('${camera.domainid} ','${camera.cameraid}')" title="查看" name="button2" id="button2" value="" class="cx_Detailed" />
				            </td>
		              </tr>
	          </c:forEach>
        </tbody>
						</table>
					</div>
				</div>
			</div>
	</body>
</html>
