<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/common_header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<body>
<div id="container">
<div class="content">
<div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_page_list_down }" width="20" height="25" /></div>
  <div class="fl">&nbsp;会议室查看</div>
</div>
<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
  <tr class="">
    <td class="ar fontstyle fontb pr3 tdhight">会议室名称：</td>
    <td class="al pl3 "><input type="text" name="textfield2" id="textfield2" readonly="readonly" class="inputview fontstyle" value="中石油商务会议测试会场" /></td>
    <td class="ar fontstyle fontb pr3 tdhight">会议室编号：</td>
    <td class="al pl3"><input type="text" name="textfield3" id="textfield3" readonly="readonly" class="inputview fontstyle" value="编号001" /></td>
  </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3 tdhight">会议室类型：</td>
    <td class="al pl3"><input type="text" name="textfield6" id="textfield6" readonly="readonly" class="inputview fontstyle" value="视频会议室" /></td>
    <td class="ar fontstyle fontb pr3 tdhight">会议室位置：</td>
    <td class="al pl3"><input type="text" name="textfield7" id="textfield7" readonly="readonly" class="inputview fontstyle" value="位置001" /></td>
  </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3 tdhight">容纳人数：</td>
    <td class="al pl3"><input type="text" name="textfield" id="textfield" readonly="readonly" class="inputview fontstyle" value="111" /></td>
    <td class="ar fontstyle fontb pr3 tdhight">状态：</td>
    <td class="al pl3"><input type="text" name="textfield8" id="textfield8" readonly="readonly" class="inputview fontstyle" value="审批通过" /></td>
    </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3 tdhight">所属单位：</td>
    <td class="al pl3"><input type="text" name="textfield5" id="textfield5" readonly="readonly" class="inputview fontstyle" value="中石油" /></td>
    <td class="ar fontstyle fontb pr3 tdhight">管理员：</td>
    <td class="al pl3"><input type="text" name="textfield4" id="textfield4" readonly="readonly" class="inputview fontstyle" value="张德泉" /></td>
  </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3 tdhight">会议室描述：</td>
    <td colspan="3" class="al pl3"><textarea name="textarea" id="textarea" cols="45" rows="9" class="areatextview fontstyle" >中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试会场中石油商务会议测试石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场石油商务会议测试会场会场</textarea></td>
    </tr>
</table></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
  <tr>
    <td class="btntable ac"><input type="submit" name="button" id="button" value="确 定" class="button fontstyle fontb"  />
  </tr>
</table>
</div>
</div>
</body>
</html>
