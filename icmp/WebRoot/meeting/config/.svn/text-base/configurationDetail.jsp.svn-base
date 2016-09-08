<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
   <%@include file="/common/common.jsp"%>
  </head>
  
  <body>
  <form action="${sys_ctx}/baseInfo/configurationDetail.action" id="detailForm" name="detailForm" method="post">
      <div id="basicform" class="contentwrapper">
        <div class="contenttitle2">
          <h5 class="fwb fl10">配置列表查看</h5>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
          <tr>
            <td width="15%" class="tableaddtitle"><span></span>类型配置</td>
            <td class="tableadd_data" >
            <zzst:lable type="baseInfoType" value="${baseInfoVO.infoType}"></zzst:lable>
            <input name="baseInfoVO.id" type="hidden" value="${baseInfoVO.id}"></td>
          </tr>
          <tr>
            <td class="tableaddtitle"><span></span>配置名称</td>
            <td class="tableadd_data" ><c:out value="${baseInfoVO.infoName}"></c:out></td>
          </tr>
          <tr>
            <td class="tableaddtitle"><span></span>配置内容</td>
            <td class="tableadd_data" ><c:out value="${baseInfoVO.infoValue}"></c:out></td>
          </tr>
          <tr>
            <td class="tableaddtitle" style="vertical-align:top;">描述</td>
            <td class="tableadd_data" ><c:out value="${baseInfoVO.description}"></c:out> </td>
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
        <!--contenttitle-->
      </div>
   </form>
  </body>
</html>
