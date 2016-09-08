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
  <div class="fl"><img src="${sys_page_list_table }" width="20" height="25" /></div>
  <div class="fl">&nbsp;会议室添加</div>
</div>
<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
  <tr class="">
    <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>会议室名称：</td>
    <td class="al pl3"><input type="text" name="textfield2" id="textfield2" class="input200 fontstyle"  />
      <div class="ts fontts"><img src="../images/blue/ts.gif" width="11" height="10" /> 输入长度不超过25个字符度不超过收到收到</div></td>
    <td class="ar fontstyle fontb pr3">会议室编号：</td>
    <td class="al pl3"><input type="text" name="textfield3" id="textfield3" class="input200 fontstyle"  /></td>
  </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3"><span class="fonttsx">*</span>会议室类型：</td>
    <td class="al pl3"><select name="select" id="select" class="select200 fontstyle">
      <option>会议室一</option>
      </select></td>
    <td class="ar fontstyle fontb pr3"><span class="fonttsx">*</span>会议室位置：</td>
    <td class="al pl3"><select name="select2" id="select2" class="select200 fontstyle">
      </select></td>
  </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3">容纳人数：</td>
    <td class="al pl3"><input type="text" name="textfield" id="textfield" class="input200 fontstyle" /></td>
    <td class="ar fontstyle fontb pr3"><span class="fonttsx">*</span>状态：</td>
    <td class="al pl3"><select name="select3" id="select3" class="select200 fontstyle">
    </select></td>
    </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3"><span class="fonttsx">*</span>所属单位：</td>
    <td class="al pl3">
      <input type="text" name="textfield5" id="textfield5" class="input200 fontstyle" />
    </td>
    <td class="ar fontstyle fontb pr3"><span class="fonttsx">*</span>管理员：</td>
    <td class="al pl3">
      <input type="text" name="textfield4" id="textfield4" class="input200 fontstyle" />
    </td>
  </tr>
  <tr class="tdhight">
    <td class="ar fontstyle fontb pr3" valign="top">会议室描述：</td>
    <td colspan="3" class="al pl3"><textarea name="textarea" id="textarea" cols="45" rows="9" class="areatext fontstyle">ddd</textarea></td>
    </tr>
</table></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
  <tr>
    <td class="btntable ac"><input type="submit" name="button" id="button" value="确 定" class="button fontstyle fontb" />
      <input type="submit" name="button2" id="button2" value="返 回" class="button fontstyle fontb" /></td>
  </tr>
</table>
</div>
</div>
</body>
</html>

