<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp"%>
	<title>岗位详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
    <div class="contenttitle2">
        <h5 class="fwb fl10">岗位查看</h5>
    </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="25%" class="tableaddtitle">岗位编号</td>
          <td width="75%" class="tableadd_data">${postVO.postNO}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">岗位名称</td>
          <td class="tableadd_data">${postVO.postName}</td>
        </tr>
        <tr>
          <td class="tableaddtitle" style="vertical-align:top;">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 述</td>
          <td class="tableadd_data" title="${postVO.description}">${postVO.description}</td>
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