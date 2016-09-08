<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.action.meeting.util.MeetingAppConfig"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">

<%@include file="/common/common.jsp"%>
		<title>添加级联点</title>

		<link href="<%=MeetingAppConfig.CONTENT_PATH%>/style/css.css"
			type="text/css" rel="stylesheet">
		<script type="text/javascript"
			src="<%=MeetingAppConfig.CONTENT_PATH%>/js1/Common.js"></script>
		<link type="text/css" rel="stylesheet"
			href="<%=MeetingAppConfig.CONTENT_PATH%>/css/func.css" />
        <script type='text/javascript' src='<%=MeetingAppConfig.CONTENT_PATH%>/dwr/engine.js'> </script>
		<script type='text/javascript' src='<%=MeetingAppConfig.CONTENT_PATH%>/dwr/util.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>

		<script type="text/javascript">
			 function closeWind() {
				window.close();
									}
			function checkSubmit(){
				var name = document.getElementById("equipmentName").value;
				var ip  = document.getElementById("equipmentIp").value;
				var confId = document.getElementById("mcuIPs").value;
				if(name==""||name==null){
					alert("请输入名称！");
					
					return;
				}
				if(ip==""||ip==null){
					alert("请输入IP！");
					
					return;
				}
				if(confId==""||confId==null||confId=="-1"){
					alert("请选择会议!");

					return;
				}
				
			addNewParticipant();
			}
			function addNewParticipant(){
			
				var meetingDetailID = document.getElementById("meetingDetailID").value;
				//var confId = document.getElementById("confId").value;
				var ptsVO = new Object();
				ptsVO.equipmentName = document.getElementById("equipmentName").value;
				ptsVO.callDirection = document.getElementById("callDirection").value;
				ptsVO.pInterface = document.getElementById("pInterface").value;
				ptsVO.equipmentIP = document.getElementById("equipmentIp").value;
				ptsVO.aliasName = document.getElementById("aliasName").value;
				ptsVO.aliasType = document.getElementById("aliasType").value;
				ptsVO.lineRate = document.getElementById("lineRate").value;
				ptsVO.maxResolution = document.getElementById("maxResolution").value;
				ptsVO.videoProtocol = document.getElementById("videoProtocol").value;
				ptsVO.cascadeRole = document.getElementById("cascadeRole").value;
				
				var confId = document.getElementById("mcuIPs").value;
				//alert(confId);
				McuDwrMethod.addParticipantNew(meetingDetailID,confId,ptsVO,callback);
				}
			function callback(){
				window.close();
			}

			window.onload = function(){
				var mcuIps = document.getElementById("confId").value;
				var mcuIpsStr = mcuIps.split(",");
				//alert(mcuIpsStr.length+"=========:"+mcuIps);
			 	//初始化选择MCU下拉框
	       if( mcuIpsStr.length > 0 && mcuIps!=null && mcuIps!=""){
            var options ="<select style='width:150px' id='mcuIPs'>";
        	for( var i=0; i<mcuIpsStr.length; i++ ){
            	//alert("id:"+mcuIpsStr[i].split("_")[0]+"==:"+mcuIpsStr[i].split("_")[2]);
        	    options += "<option value='"+mcuIpsStr[i].split("_")[0]+"'>"+mcuIpsStr[i].split("_")[2]+"</option>";
        	}
        	options +="</select>"
        	document.getElementById("mcuIPsTd").innerHTML=options;
        }
			    
			
			}
		</script>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<form action="<%=MeetingAppConfig.CONTENT_PATH %>/equipmentGroup/addEquipmentGroup.action" method="post" name="myform" id="myform">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				<tr>
				 	<td width="35%" class="tableaddtitle"><span>*</span>名称</td>
          			<td width="65%" class="tableadd_data" ><input id="equipmentName" type="text" class="inputtran" name="equipmentName"/></td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						呼叫方式方向：
					</td>
					<td class="tableadd_data">
						<select style="width: 51%; float: left" name="callDirection" id="callDirection">
							<option value="1">呼出</option>
							<option value="0">呼入</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						类型：
					</td>
					<td class="tableadd_data">
						<select style="width: 51%; float: left" name="pInterface" id="pInterface">
							<option value="h323">h.323</option>
							<option value="sip">sip</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle"><span>*</span>
						IP地址：
					</td>
					<td class="tableadd_data">
						<input type="text" style="width: 49%;float: left" name="equipmentIp" id="equipmentIp"/>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						别名/类型：
					</td>
					<td class="tableadd_data">
						<input type="text"    name="aliasName" id="aliasName"/>
						<select style="width:100px;" name="aliasType" id="aliasType">
							<option  value="323_id">323_ID</option>
							<option value="e164">e164</option>
							
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						连接速率：
					</td>
					<td class="tableadd_data">
						<select style="width: 51%; float: left" name="lineRate" id="lineRate">
							<option value=""   >AUTO</option>
							<option value="384">384</option>
							<option value="512">512</option>
							<option value="768">768</option>
							<option value="1024">1024</option>
							<option value="1536">1536</option>
							<option value="1920">1920</option>
							<option value="2048">2048</option>
							<option value="4096">4096</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						分辨率：
					</td>
					<td class="tableadd_data">
						<select style="width: 51%; float: left" name="maxResolution" id="maxResolution">
							<option value="auto">AUTO</option>
							<option value="cif">CIF</option>
							<option value="sd">SD</option>
							<option value="hd_720">HD 720</option>
							<option value="hd_1080">HD 1080</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						视频协议：
					</td>
					<td class="tableadd_data">
						<select style="width: 51%; float: left" name="videoProtocol" id="videoProtocol">
							<option value="auto">AUTO</option>
							<option value="h261">h261</option>
							<option value="h263">h263</option>
							<option value="h264">h264</option>
						</select>
					</td>
				</tr>
				<!--
				<tr>
					<td class="treetableTitle">
						加密：
					</td>
					<td class="treetableTitle" colspan="2">
						<select style="width: 49%; float: left">
							<option value="">自动</option>
							<option value="">呼出</option>
						</select>
					</td>
				</tr>
				-->
				<tr>
					<td class="tableaddtitle">
						级联：
					</td>
					<td class="tableadd_data">
						<select style="width: 51%; float: left" name="cascadeRole" id="cascadeRole">
							<option value="none">none</option>
							<option value="master">master</option>
							<option value="slave">slave</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						添加到会议：
					</td>
					<td class="tableadd_data" id="mcuIPsTd">
						<select style="width:150px" id="mcuIPs"><option value="-1">未找到会议</option></select>
					</td>
				</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        		<tfoot>
        		</tfoot>        
        		<tbody>
         		 <tr>
           			 <td>
              			<input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="checkSubmit();"/>
             			 <input type="button" class="reset1 radius2" value="取 消" onclick="closeWind()"/>
            	</td>
         	 </tr>
        	</tbody>
      </table>
			
			<input type="hidden" value="<%=request.getParameter("meetingDetailID") %>" id="meetingDetailID"/>
				<input type="hidden" value="<%=new String(request.getParameter("confId").getBytes("ISO-8859-1"),"utf-8") %>" id="confId"/>
			
		</form>
	</body>
</html>
