<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>数据字典详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">数据字典查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">数据类型</td>
          <td width="35%" class="tableadd_data" > <zzst:lable type="dicType" value="${dictionaryVO.dicType}"></zzst:lable>
          <c:if test="${dictionaryVO.dicType=='applyFlow'}">流程类型</c:if>
			
		  <c:if test="${dictionaryVO.dicType=='changeCss'}">换肤模板</c:if>
			
          <c:if test="${dictionaryVO.dicType=='controlMenu'}">控制菜单</c:if>
          
          <c:if test="${dictionaryVO.dicType=='controlRightMenu'}">右键菜单</c:if>
		  	
		  </td>
          <td width="15%" class="tableaddtitle">数据名称</td>
          <td width="35%" class="tableadd_data" ><input type="text" class="inputtran" id="datepicker2" value="${dictionaryVO.dicViewName}" disabled /></td>
          
        </tr>
        <tr>
          <td class="tableaddtitle">数值</td>
          <td class="tableadd_data" ><input type="text" class="inputtran" id="datepicker4" value="${dictionaryVO.dicValue}" disabled="disabled" /></td>
          <td class="tableaddtitle">描述</td>
          <td colspan="3" class="tableadd_data" ><input type="text" class="inputtran" id="datepicker4" value="${dictionaryVO.description}" disabled="disabled" /></td>
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