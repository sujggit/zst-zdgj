<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.MeetingTypeEnum" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <head>
	<%@include file="/common/common.jsp" %>
	<%
		String[][] meetingTypes = MeetingTypeEnum.getMeetingType();
	%>
	<title>维护会议类型</title>
	<script type="text/javascript" src="/icmp/meeting/config/dateDictionary/js/dateDictionary.js"></script>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN;height:100%' onload="num(document.form2)">
		<form id="form2" name="form2" action="" method="post">
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
              <td><input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="moveAllOptions(document.form2.form2leftsel,document.form2.form2rightsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="moveOption(document.form2.form2leftsel,document.form2.form2rightsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;删除" onclick="moveOption(document.form2.form2rightsel,document.form2.form2leftsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="moveAllOptions(document.form2.form2rightsel,document.form2.form2leftsel)" /></td>
            </tr>
          </table>
					          </td>
							<th width="45%" style="text-align:center;">已选择<span style="font-weight:bold;text-align:center;color:red"  id="form2numberID"></span>个类型 </th>
						</tr>
				  		<tr>
							<td>
								<div class="input_txt" style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form2leftsel" style="width:100%;  height: 300px;"  multiple="multiple" ondblclick="moveOption(document.form2.form2leftsel,document.form2.form2rightsel)">
										<%
											for( int i=0; i<meetingTypes.length; i++){%>
												<option value="<%=meetingTypes[i][0]%>" ><%=meetingTypes[i][1]%></option>
											<%}
										%>
		    						</select>
								</div>
							</td>
							 
							<td align="center">
								<div class="input_txt"  style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form2rightsel" style="width:100%;  height: 300px;" multiple="multiple"  ondblclick="moveOption(document.form2.form2rightsel,document.form2.form2leftsel)">
	   									<zzst:option type="meetingType" value="" />
	   								</select>
								</div>
							</td>
						</tr>
						<input type="hidden" id="form2baseInfoValues" name="baseInfoValues" value=""/>
						<input type="hidden" id="form2baseInfoTexts"  name="baseInfoTexts" value=""/>
						<input type="hidden" id="dateDictionaryType"  name="dateDictionaryType" value="<%=BaseInfoEnum.DICTIONARY_MEEITNG_TYPE%>"/>
					</table>						
				</td>								
			</tr>																		
		</table>						
		 
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		  <tr>
		    <td>
  		      <input type="button" name="button" id="button" value="确 定"    class="submit1 radius2"  onclick="save(document.form2)"/>
		      <input type="button" name="button2" id="button2" value="返 回"  class="reset1 radius2" onclick="goBack()"/></td>
		  </tr>
		</table>
		</div>
		</div>
		</form>
		
	</body>
</html>
