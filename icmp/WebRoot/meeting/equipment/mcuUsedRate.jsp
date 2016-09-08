<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <title>MCU端口使用率</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx }/dictionary/dictionaryList.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">  
      
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">MCU端口使用率</h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
          	<th width="15" class="head1">序号</th>
            <th width="25%" class="head1">MCU名称</th>
            <th width="30%" class="head1">MCU音频端口</th>
            <th width="30%" class="head1">MCU视频端口</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${equipmentVOList}" var="equipmentVO" 	varStatus="state">
			<tr>
				<td  class="alc"> <c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentVO.equipmentNO}"></c:out></td>
				<td><span style="width:130px;display:inline-block">语音音频：${equipmentVO.audioUsing }/${equipmentVO.audioTotal }</span></td>
				<td><span style="width:130px;display:inline-block">视频：${ equipmentVO.vedioUsing}/${equipmentVO.vedioTotal}</span></td>
			</tr>
		  </c:forEach>
        </tbody>
      </table>
    </div>
 </form>
<jsp:include page="/common/pageFooter.jsp" />
</body>
</html>
