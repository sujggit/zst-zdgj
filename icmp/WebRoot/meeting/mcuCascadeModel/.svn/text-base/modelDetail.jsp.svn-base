<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>会议模式查看</title>
		
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx}/config/modifyCenterControlInfo.action" id="centerControlAddForm" name="centerControlAddForm" method="post">
	<div id="basicform" class="contentwrapper">
        <div class="contenttitle2">
          <h5 class="fwb fl10">会议模式查看</h5>
        </div>
       <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        <tr>
          <td width="19%" class="tableaddtitle">会议模式</td>
          <td width="30%" class="tableadd_data" title="${mcuCascadeModelVO.cascadeName}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out value="${mcuCascadeModelVO.cascadeName}"></c:out></td>
          <td width="19%" class="tableaddtitle">创建时间</td>
          <td width="30%" class="tableadd_data">
          <fmt:formatDate value="${mcuCascadeModelVO.createDate}"  pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
              <td class="tableaddtitle" style="vertical-align:top;">建会方式</td>
              <td colspan="3" class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis">
              	<zzst:lable type="confModel" value="${mcuCascadeModelVO.confModel}"/>
              </td>
        </tr>
       <tr>
              <td class="tableaddtitle" style="vertical-align:top;">MCU名称</td>
              <td colspan="3" class="tableadd_data" title="${mcuCascadeModelVO.mcuName}"style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out value="${mcuCascadeModelVO.mcuName}"></c:out></td>
            </tr>
            <tr>
              <td class="tableaddtitle" style="vertical-align:top;">MCUIP</td>
              <td colspan="3" class="tableadd_data" title="${mcuCascadeModelVO.mcuIp}"style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out value="${mcuCascadeModelVO.mcuIp}"></c:out></td>
            </tr>
             <tr>
              <td class="tableaddtitle" style="vertical-align:top;">MCU模板</td>
              <td colspan="3" class="tableadd_data" title="${mcuCascadeModelVO.modelName}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out value="${mcuCascadeModelVO.modelName}"></c:out></td>
            </tr>
            <tr>
              <td class="tableaddtitle" style="vertical-align:top;">MCU模板ID</td>
              <td colspan="3" class="tableadd_data" title="${mcuCascadeModelVO.modelID}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out value="${mcuCascadeModelVO.modelID}"></c:out></td>
            </tr>
      </table>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
          <tfoot>
          </tfoot>
          <tbody>
            <tr>
              <td>
              <input type="reset" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
                </td>
            </tr>
          </tbody>
        </table>
        </div>
        </form>
        </body>
        </html>