<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>可输入/可点击增长</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script>
	function plus(){
		var num = document.getElementById("number");
		if(num.value){
			num.value = Number(num.value) +1;
		}
	}
	function reduce(){
		var num = document.getElementById("number");
		if(num.value){
			num.value = num.value - 1;
		}
	}
</script>
</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 可输入、可点击增长</h3>
</div>
<div id="basicform" class="contentwrapper">
    <div class="contenttitle2">
        <h5 class="fwb fl10">可输入、可点击增长</h5>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
            <td class="tableaddtitle"><span>*</span>MCU个数</td>
            <td class="tableadd_data" >
                <div class="acquiesce"><input id="number" value="10" /></div>
                <div class="acquiesce_list">
                    <span class="acquiesce_list_1"><input type="button" value="" onClick="plus();" /></span>
                    <span class="acquiesce_list_2"><input type="button" value="" onClick="reduce();" /></span>
                </div>
            </td>
            <td class="tableaddtitle"><span>*</span>文件上传</td>
            <td class="tableadd_data"><input type="file" class="most" /></td>
        </tr>
    </table>
</div>
</body>
</html>