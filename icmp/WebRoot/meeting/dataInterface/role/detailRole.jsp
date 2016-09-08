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
 <body style='OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'  >
   <div id="basicform" class="contentwrapper">
    <div class="contenttitle2" style="width:100%">
        <h5 class="fwb fl10">角色查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="25%" class="tableaddtitle">角色名</td>
          <td width="75%" class="tableadd_data" >${riVO.rolename}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">操作描述</td>
          <td class="tableadd_data" ><c:out value="${riVO.importdesc}"></c:out></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
              </td>
          </tr>
        </tbody>
     </table>
     </div>
	</body>
</html>
