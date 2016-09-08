<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>日志管理详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">日志查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">日志类型</td>
          <td width="35%" class="tableadd_data" > 
          	<zzst:lable type="logType" value="${logVO.logType}" ></zzst:lable>
          </td>
          <td width="15%" class="tableaddtitle">操作时间</td>
          <td width="35%" class="tableadd_data" >
          	<fmt:formatDate value="${logVO.operatorDate}"  pattern="yyyy-MM-dd HH:mm" />
          </td>
          
        </tr>
        <tr>
          <td class="tableaddtitle">操作人</td>
          <td class="tableadd_data" colspan="3">${logVO.userName}</td>
          <tr>
          <td class="tableaddtitle">描述</td>
          <td colspan="3" class="tableadd_data" >${logVO.operatorContent}</td>
          </tr>
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