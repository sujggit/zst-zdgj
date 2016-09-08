<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>中控详情</title>
</head>
<body>
<form action="${sys_ctx}/config/modifyCenterControlInfo.action" id="centerControlAddForm" name="centerControlAddForm" method="post">
<input type="hidden" name="centerControlVO.id" id="centerControlVO.id" value="${centerControlVO.id}"/>
    <div id="contentwrapper" class="contentwrapper"><!--contenttitle-->
        <div class="contenttitle2">
          <h5 class="fwb fl10">中控配置查看</h5>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
          <tr>
            <td class="tableaddtitle"><span>*</span>设备名称</td>
            <td class="tableadd_data" title="${centerControlVO.equipmentName}"> <input type="text" class="inputtran" id="datepicker4" readonly  value="${centerControlVO.equipmentName}"/>  </td>
          </tr>
          <tr>
            <td class="tableaddtitle"><span>*</span>中控IP</td>
            <td class="tableadd_data" ><input type="text" class="inputtran" id="datepicker4" name="centerControlVO.ccIP"  readonly  value="${centerControlVO.ccIP}" /></td>
          </tr>
          <tr>
            <td class="tableaddtitle"><span>*</span>设备类型</td>
            <td class="tableadd_data" >
             <zzst:lable type="ccequipmentType" value="${centerControlVO.equipmentType}"></zzst:lable>
           </td>
          </tr>
          <tr>
            <td width="15%" class="tableaddtitle"><span>*</span>设备编号</td>
            <td class="tableadd_data" ><input type="text" class="inputtran" id="datepicker4" value="${centerControlVO.ccNO}" readonly/> </td>
          </tr>
          <tr>
            <td class="tableaddtitle" style="vertical-align:top;">详细配置</td>
            <td class="tableadd_data" ><c:out value="${centerControlVO.controlInitDate}"></c:out> </td>
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
    </form>
  </body>
</html>