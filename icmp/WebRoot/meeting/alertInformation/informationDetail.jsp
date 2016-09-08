<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>添加告示</title>
</head>
<body style='OVERFLOW-X:HIDDEN;OVERFLOW-Y:HIDDEN'>
<form action="${sys_ctx}/config/modifyCenterControlInfo.action" id="centerControlAddForm" name="centerControlAddForm" method="post">
<div>
    <!--pageheader-->
    <div id="basicform" class="contentwrapper">
        <div class="contenttitle2">
          <h5 class="fwb fl10">消息查看</h5>
        </div>
       <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">警告标题</td>
          <td width="35%" class="tableadd_data" ><c:out value="${informationVO.title}"></c:out></td>
          <td width="15%" class="tableaddtitle">警告类型</td>
          <td width="35%" class="tableadd_data">
                 <zzst:lable type="infoType" 
							value="${informationVO.infoType}">
					</zzst:lable>
            </td>
        </tr>
        
         <tr>
          <%--<td class="tableaddtitle">发起人</td>--%>
          <%--<td class="tableadd_data" ><c:out value="${informationVO.createUserID}"></c:out></td>--%>
          <td class="tableaddtitle">告警时间</td>
          <td class="tableadd_data" colspan="3"><fmt:formatDate value="${informationVO.createTime}"  pattern="yyyy-MM-dd"/></td>
        </tr>
        
        
        <tr>
          <td class="tableaddtitle">描述</td>
          <td class="tableadd_data" colspan="3"><c:out value="${informationVO.content}"></c:out></td>
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
        </div>
        </form>
        </body>
        </html>