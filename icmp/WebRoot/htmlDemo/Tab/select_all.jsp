<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>全选</title>
<script type="text/javascript" src="../js/windowInit.js" ></script>
</head>
<body>
	<div class="pageheader notab">
		<h3 class="pagetitle">当前位置：视频会议 ⇒ 全选</h3>
	</div>
	<div id="basicform" class="contentwrapper">
		<div class="contenttitle2">
			<h5 class="fwb fl10">全选</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td class="tableaddtitle"><span>*</span>单选</td>
				<td class="tableadd_data" ><input type="radio" name="radio" class="most" /> 男 <input type="radio" name="radio" class="most" /> 女 </td>
				<td class="tableaddtitle"><span>*</span>全选 <input id="chkA03" onClick="ChkA03Click('chkSon','chkA03')" type="checkbox" class="most" /></td>
				<td class="tableadd_data">
					<input name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" class="most" /> A  
					<input name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" class="most" /> B  
					<input name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')"  class="most"/> C  
					<input name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" class="most" /> D  
				</td>
			</tr>
		</table>		
	</div>
</body>
</html>