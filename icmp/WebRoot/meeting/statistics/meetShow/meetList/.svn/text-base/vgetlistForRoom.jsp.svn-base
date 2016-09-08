<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>会议清单</title>
	<link rel="stylesheet" type="text/css" href="${sys_ctx }/js/DataTables-1.9.4/demo_table_jui.css" />
<script type='text/javascript' src='${swh_ctx }/dwr/interface/StatisticsAction.js'></script>
<script type="text/javascript" src="${sys_ctx }/js/fusionChat/FusionCharts.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/alertJS/zDrag.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/alertJS/zDialog.js"></script>
		<script type="text/javascript">
			$(document).ready(function() { $('#query_table2').dataTable({
		   //"sUrl": "/SSS/dataTables/de_DE.txt"
		    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
		//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
		   "aLengthMenu": [[5,10, 20, 50, -1], [5,10, 20, 50, "All"]],//下拉框
		   "bJQueryUI": true,
			"sPaginationType": "full_numbers",//分页样式
		   "oLanguage": {
	         "sProcessing": "正在加载中......",
	         "sZeroRecords": "没有符合条件的数据！",
	         "sSearch":"搜索：",
	         "oPaginate":{"sFirst":"首页","sLast":"尾页","sNext":"下一页","sPrevious":"上一页"},
	         "sInfo":"共 _TOTAL_ 条信息 | 当前第 _START_ / _END_ 项",
	         "sInfoEmpty":"共 0 条信息 | 当前第 0 项",
	         "sInfoFiltered": "",
	         "sLengthMenu":"显示 _MENU_ 项"
			}    
		});
		
		  $("#query_table2 tr:gt(0)").bind("mouseover",function(){
		        $(this).css('background-color','#f4e9bb');
		  });
		  $("#query_table2 tr:gt(0)").bind("mouseout",function(){
		        $(this).css('background-color','');
		  });
	})
	
	
</script>
</head>
<body>
   <div id="basicform" class="contentwrapper">  
   <div class="contenttitle2">
			<h5 class="fwb fl10">会议列表:${info }</h5>
			<h5 class="fwb fr10"></h5>
		</div> 
<form action="${sys_ctx }/vmeetingDetail/query.action" id="pageform" name="pageform" method="post">     
	
	<table id="query_table2" cellpadding="0" cellspacing="0" border="0" class="stdtable">
			<thead>
				<tr>
					<th class="head1">序号</th>
					<th class="head1">会议名称</th>
					<th class="head1">开始时间</th>
					<th class="head1">结束时间</th>
					<th class="head1">会议类型</th>
					<th class="head1">预约人 </th>
			
				</tr>
			</thead>
			<tbody>
			  <c:forEach items="${meetList}" var="ml" varStatus="state">
				<tr>
					<td>${state.index+1 }</td>
					<td>${ml.viewMeetingName }</td>
					<td><fmt:formatDate value="${ml.viewStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
					<td><fmt:formatDate value="${ml.viewEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
					<td><zzst:lable type="meetingType" value="${ml.viewMeetingType }"></zzst:lable></td>
					<td>${ml.viewMeetingInfo }</td><!-- info 做 预约人 （中电国际） -->
				</tr>
				</c:forEach>
				
			</tbody>
		</table>

</form>
</div>
</body>
</html>