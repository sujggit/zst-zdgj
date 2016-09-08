<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.application.mcuVO.ZZOConfProfileVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>demo</title>
<%@include file="/common/common.jsp"%>
	<script type="text/javascript">	

	function getMcuProfiles(){
		var uri = "${sys_ctx}/meeting/config/mcu/getMcuTemplate.jsp";
		window.location.href=uri;
	}
    </script>
</head>
<body class="withvernav">
<form action="${sys_ctx}/baseInfo/mcuList.action" id="pageform" name="pageform" method="post">
<!--pageheader-->
    <div id="basicform" class="contentwrapper">
    
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">MCUIP</td>
          <td class="tableadd_data"><input id="mcuIpID" type="text" class="inputtran" name="baseInfoVO.infoName" value="${baseInfoVO.infoName}" /></td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询"  onclick="queryForm();"/></td>
        </tr>
      </table>
      
      
      <!--contenttitle-->
      <div class="widgetcontent">
         <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a  onclick="getMcuProfiles();return false;">提取模板</a></h5>
      </div>
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="24%" class="head1">MCUIP</th>
            <th width="24%" class="head1">MCU模板ID</th>
            <th width="24%" class="head1">MCU模板名称</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
	        <c:forEach items="${baseInfoList}" var="baseInfoVO" 	varStatus="state">
	          <tr>
	            <td>${baseInfoVO.infoName}</td>
	            <td>${baseInfoVO.infoValue}</td>
	            <td class="center">${baseInfoVO.description}</td>
	          </tr>
	        </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    </div>
    <!--contentwrapper--> 
    </form>
</body>
</html>