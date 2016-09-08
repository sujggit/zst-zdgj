<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.enums.EquipmentEnum" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<%@page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@page import="com.zzst.service.meeting.baseinfo.BaseInfoService"%>
<%@page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	  <%@include file="/common/common.jsp" %>
	  <%
		String[][] euqipTypes = EquipmentEnum.getEquipmentType();
		String[][] selectedEuqipTypes  = BaseInfoHelp.getMeetingType();
	  %>
	  <title>维护设备类型</title>
	  <script type="text/javascript" src="/icmp/meeting/config/dateDictionary/js/dateDictionary.js"></script>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN;height:100%' onload="num(document.form1)">
		<form id="form1" name="form1" action="" method="post">
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
              <td><input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="moveAllOptions(document.form1.form1leftsel,document.form1.form1rightsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="moveOption(document.form1.form1leftsel,document.form1.form1rightsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;删除" onclick="moveOption(document.form1.form1rightsel,document.form1.form1leftsel)"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="moveAllOptions(document.form1.form1rightsel,document.form1.form1leftsel)" /></td>
            </tr>
          </table>
					          </td>
							<th width="45%" style="text-align:center;">已选择<span style="font-weight:bold;text-align:center;color:red"  id="form1numberID"></span>个类型 </th>
						</tr>
				  		<tr>
							<td>
								<div class="input_txt" style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form1leftsel" style="width:100%;  height: 300px;"  multiple="multiple" ondblclick="moveOption(document.form1.form1leftsel,document.form1.form1rightsel)">
										<%
											for( int i=0; i<euqipTypes.length; i++){%>
												<option value="<%=euqipTypes[i][0]%>" ><%=euqipTypes[i][1]%></option>
											<%}
										%>
		    						</select>
								</div>
							</td>
							 
							<td align="center">
								<div class="input_txt"  style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
									<select id="form1rightsel" style="width:100%;  height: 300px;" multiple="multiple"  ondblclick="moveOption(document.form1.form1rightsel,document.form1.form1leftsel)">
										<zzst:option type="equipmentType" value="" />
	   								</select>
								</div>
							</td>
						</tr>
						<input type="hidden"  id="form1baseInfoValues" name="baseInfoValues" value=""/>
						<input type="hidden" id="form1baseInfoTexts"  name="baseInfoTexts" value=""/>
						<input type="hidden" id="from1dateDictionaryType"  name="dateDictionaryType" value="<%=BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE%>"/>
					</table>						
				</td>								
			</tr>																		
		</table>						
		 
		</div>
		
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		  <tr>
		    <td>
  		      <input type="button" name="button" id="button" value="确 定"    class="submit1 radius2"  onclick="save(document.form1)"/>
		      <input type="button" name="button2" id="button2" value="返 回"   class="reset1 radius2" onclick="goBack()"/></td>
		  </tr>
		</table>
		</div>
		</form>
	</body>
	
</html>
 