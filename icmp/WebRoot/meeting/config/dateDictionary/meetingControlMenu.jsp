<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.MeetingControlMenuEnum" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<%String[][] menu = MeetingControlMenuEnum.getPubMenuList(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<%@include file="/common/common.jsp" %>
		<title>会议控制-控制按钮字典</title>
		
		<script type="text/javascript" src="${sys_ctx }/meeting/config/dateDictionary/js/dateDictionary.js"></script>
		
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
							<th width="45%" style="text-align:center;" >请选择类型&nbsp;&nbsp;&nbsp;<span style="font-weight:bold;text-align:center;color:red"></span></th>
							<td width="100" rowspan="2">
					          <div class="btn_nav">
					          	<input type="button" class="stdbtn mlr10" name="Submit" value="添加所有 &gt;&gt;" onclick="moveAllOptions(document.form6.form6leftsel,document.form6.form6rightsel)"  />
					          </div>
					          <div class="btn_nav">
					            <input type="button" class="stdbtn mlr10" name="Submit" value="添加 &gt;" onclick="moveOption(document.form6.form6leftsel,document.form6.form6rightsel)"  />
					          </div>
					          <div class="btn_nav">
					            <input type="button" class="stdbtn mlr10" name="Submit"  onclick="moveOption(document.form6.form6rightsel,document.form6.form6leftsel)" value="&lt; 删除" />
					        </div>
					        <div class="btn_nav">
					            <input type="button" class="stdbtn mlr10"  name="Submit" onclick="moveAllOptions(document.form6.form6rightsel,document.form6.form6leftsel)" value="&lt; 删除所有" />
					        </div>
					          </td>
							<th width="45%" style="text-align:center;">已选择<span style="font-weight:bold;text-align:center;color:red"  id="form6numberID"></span>个类型 </th>
						</tr>
				  		<tr>
							<td>
								<div class="input_txt" style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form6leftsel" style="width:100%;  height: 300px;"  multiple="multiple" onchange="num(document.form6)" ondblclick="moveOption(document.form6.form6leftsel,document.form6.form6rightsel)">
										<%
										
											for( int i=0; i<menu.length; i++){%>
												<option value="<%=menu[i][0]%>" ><%=menu[i][1]%></option>
											<%}
										%>
		    						</select>
								</div>
							</td>
							 
							<td align="center">
								<div class="input_txt"  style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form6rightsel" style="width:100%;  height: 300px;" multiple="multiple"  ondblclick="moveOption(document.form6.form6rightsel,document.form6.form6leftsel)">
	   									<zzst:option type="meetingControlMenu" value="" />
	   								</select>
								</div>
							</td>
						</tr>
						<input type="hidden"  id="form6baseInfoValues" name="baseInfoValues" value=""/>
						<input type="hidden" id="form6baseInfoTexts"  name="baseInfoTexts" value=""/>
						<input type="hidden" id="dateDictionaryType"  name="dateDictionaryType" value="<%=BaseInfoEnum.DICTIONARY_MEETINGCONTROL_MENU %>"/>
					</table>						
				</td>								
			</tr>																		
		</table>						
		 
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		  <tr>
		    <td>
  		      <input type="button" name="button" id="button" value="确定"   class="submit1 radius2" onclick="save(document.form6)"/>
		      <input type="button" name="button2" id="button2" value="返回"  class="reset1 radius2" onclick="goBack()"/></td>
		  </tr>
		</table>
		</div>
		</div>
		</form>
	</body>
</html>