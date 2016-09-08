<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>用户详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">用户查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">用户名</td>
          <td width="35%" class="tableadd_data" >${userVO.loginName}</td>
          <td width="15%" class="tableaddtitle">姓名</td>
          <td width="35%" class="tableadd_data">${userVO.name}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">角色</td>
          <td class="tableadd_data" >${userRoleVO.roleName}</td>
          <td class="tableaddtitle">部门</td>
          <td class="tableadd_data">${userVO.departmentVO.title }</td>
        </tr>
        <tr>
          <td class="tableaddtitle">邮箱</td>
          <td class="tableadd_data" >${userVO.email}</td>
          <td class="tableaddtitle">手机</td>
          <td class="tableadd_data">${userVO.mobile}</td>
        </tr>
        
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
</body>
</html>