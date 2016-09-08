<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
		<style type="text/css">
		   input{
		       border:0px ;
		   }
		</style>
	</head >
 <body STYLE='OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'  >
   <div id="basicform" class="contentwrapper">
    <div class="contenttitle2" style="width:100%">
        <h5 class="fwb fl10">用户查看</h5>
      </div>
 	
        
         <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        <tr>
          <td width="20%" class="tableaddtitle">用户名</td>
          <td width="30%" class="tableadd_data" >${uiVO.loginname}</td>
          <td width="20%" class="tableaddtitle">姓名</td>
          <td width="30%" class="tableadd_data" >${uiVO.fullname}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">邮箱</td>
          <td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${uiVO.email}">${uiVO.email}</td>
          <td class="tableaddtitle">手机</td>
          <td class="tableadd_data" >${uiVO.mobilephone}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">角色</td>
          <td class="tableadd_data" >${uiVO.rolename}</td>
          <td  class="tableaddtitle">部门</td>
          <td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${uiVO.departmentid}">${uiVO.departmentid}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">操作描述</td>
          <td colspan="3" class="tableadd_data" ><c:out value="${uiVO.importdesc}"></c:out></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="reset" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
              </td>
          </tr>
        </tbody>
     </table>
     </div>
	</body>
</html>
