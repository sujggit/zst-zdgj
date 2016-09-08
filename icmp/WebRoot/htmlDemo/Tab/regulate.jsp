<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>控制字符个数</title>

</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 控制字符个数</h3>
</div>
<div id="basicform" class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10">控制字符个数</h5>
	</div>
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td class="tableaddtitle"><span>*</span>25个字符</td>
			<td class="tableadd_data" >
				<input name="textfield1" type="text" id="textfield" value="不能超出25个字符" onmouseover="this.style.borderColor='#ccc'" onmouseout="this.style.borderColor=''" onFocus="if (value =='不能超出25个字符'){this.style.color='#000';value=''}" maxlength="25" class="mosts"/>
			</td>
			<td class="tableaddtitle"><span>*</span>50个字符</td>
			<td class="tableadd_data">
				<input name="textfield2" type="text" id="textfield" value="不能超出50个字符" onmouseover="this.style.borderColor='#ccc'" onmouseout="this.style.borderColor=''" onFocus="if (value =='不能超出50个字符'){this.style.color='#000';value=''}" maxlength="50" class="mosts"/>
			</td>
		</tr>
	</table>
</div>
</body>
</html>