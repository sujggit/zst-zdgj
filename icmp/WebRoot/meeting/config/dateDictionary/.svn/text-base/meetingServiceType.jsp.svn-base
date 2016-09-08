<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.MeetingServiceEnum" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<%@include file="/common/common.jsp" %>
	<%
		String[][] meetingServiceTypes = MeetingServiceEnum.getMeetingService();
	%>
	<title>维护会议室类型</title>
	<script type="text/javascript" src="/icmp/meeting/config/dateDictionary/js/dateDictionary.js"></script>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN;height:100%' onload="num(document.form6)">
		<form id="form6" name="form6" action="" method="post">
		<div id="container">
		<div class="content">
		<div class="tablesdiv">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
			<tr>
				<td>
					<table border="0" cellspacing="1" cellpadding="0" class="table_css_lx">
						<tr id="dp2">
							<th width="45%" style="text-align:center;" >请选择类型</th>
							<td width="100" rowspan="2">
					         
					           <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center; height:200px;">
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="moveAllOptions(document.form6.form6leftsel,document.form6.form6rightsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="moveOption(document.form6.form6leftsel,document.form6.form6rightsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;删除" onclick="moveOption(document.form6.form6rightsel,document.form6.form6leftsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="moveAllOptions(document.form6.form6rightsel,document.form6.form6leftsel)" /></td>
            </tr>
          </table>
					          </td>
							<th width="45%" style="text-align:center;">已选择<span style="font-weight:bold;text-align:center;color:red"  id="form6numberID"></span>个类型 </th>
						</tr>
				  		<tr>
							<td>
								<div class="input_txt" style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form6leftsel" style="width:100%;  height: 300px;"  multiple="multiple" ondblclick="moveOption(document.form6.form6leftsel,document.form6.form6rightsel)">
										<%
											for( int i=0; i<meetingServiceTypes.length; i++){%>
												<option value="<%=meetingServiceTypes[i][0]%>" ><%=meetingServiceTypes[i][1]%></option>
											<%}
										%>
		    						</select>
								</div>
							</td>
							 
							<td align="center">
								<div class="input_txt"  style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form6rightsel" style="width:100%;  height: 300px;" multiple="multiple"  ondblclick="moveOption(document.form6.form6rightsel,document.form6.form6leftsel)">
	   									<zzst:option type="meetingServiceType" value="" />
	   								</select>
								</div>
							</td>
						</tr>
						<input type="hidden"  id="form6baseInfoValues" name="baseInfoValues" value=""/>
						<input type="hidden" id="form6baseInfoTexts"  name="baseInfoTexts" value=""/>
						<input type="hidden" id="dateDictionaryType"  name="dateDictionaryType" value="<%=BaseInfoEnum.DICTIONARY_MEETINGSERVICE_TYPE%>"/>
					</table>						
				</td>								
			</tr>																		
		</table>						
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		  <tr>
		    <td>
  		      <input type="button" name="button" id="button" value="确 定"   class="submit1 radius2" onclick="save(document.form6)"/>
		      <input type="button" name="button2" id="button2" value="返 回"  class="reset1 radius2" onclick="goBack()"/></td>
		  </tr>
		</table>
		</div>
		</div>
		</form>
	</body>
</html>
