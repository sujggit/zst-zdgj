<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<title>终端状态</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
  
	function go()
	{
	  window.setInterval("javascript:window.location.reload()",'${sys_refreshTime}');
	}
	
	function runit()
	{
	  var ips = document.getElementsByName("ips");
	  var tmp ="";
	   for(var i=0;i< ips.length; i++)
	   {
	      	      
	     tmp= tmp + ips[i].value+";";
	   }
	    DwrMethod.getTerminalControl(tmp,rback);
	    
	}
	
	function rback(lst)
	{	
		for(var i=0;i<lst.length;i++)
		{
			var ipAndStatus = lst[i];
			var ip_status = ipAndStatus.split(";");
			var status = ip_status[1];
			var ip = "pw"+ip_status[0];
			
			var logo = document.getElementById(ip);
			
			if(status=="0")
			{
				logo.src ="${sys_ctx }/meeting/equipmentControl/image/open.png";
				document.getElementById("span"+ip_status[0]).innerHTML="开启";//20131212
			}
			else if(status=="1")
			{
			  	logo.src ="${sys_ctx }/meeting/equipmentControl/image/close.png";
			  	document.getElementById("span"+ip_status[0]).innerHTML="关闭";
			}
			else
			{
			   logo.src ="${sys_ctx }/meeting/equipmentControl/image/wait.gif";
			   document.getElementById("span"+ip_status[0]).innerHTML="未知";
			}
		}
		$('#query_table3').dataTable({
			   "bPaginate": false,  
			   "bLengthChange": false, 
			   "bFilter": false,
			   "bInfo": false,
			   "bAutoWidth": true,  //自适应宽度 
			   "bAutoHeight":true,
			   //"sUrl": "/SSS/dataTables/de_DE.txt"
			    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
			//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
			   "oLanguage": {
		           "sProcessing": "正在加载中......",
		           "sZeroRecords": "没有符合条件的数据！"
		           //"sSearch":"搜索："
				}    
			});
			
			  $("#query_table3 tr:gt(0)").bind("mouseover",function(){
			        $(this).css('background-color','#f4e9bb');
			  });
			  $("#query_table3 tr:gt(0)").bind("mouseout",function(){
			        $(this).css('background-color','');
			  });
		    
			var noSTable = $('#query_table3_nosearch').dataTable({
			   "bPaginate": false,  
			   "bLengthChange": false, 
			   "bFilter": false,
			   "bInfo": false,
			   "bAutoWidth": true,  //自适应宽度 
			   "bAutoHeight":true,
			   //"sUrl": "/SSS/dataTables/de_DE.txt"
			    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
			//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
			   "oLanguage": {
		           "sProcessing": "正在加载中......",
		           "sZeroRecords": "没有符合条件的数据！",
		           "sSearch":"搜索"
				}    
			});
			
			  $("#abc tr:gt(0)").bind("mouseover",function(){
			        $(this).css('background-color','#f4e9bb');
			  });
			  $("#abc tr:gt(0)").bind("mouseout",function(){
			        $(this).css('background-color','');
			  });
	}
</script>
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="go();" >
  <div id="basicform" class="contentwrapper">
	  <div class="contenttitle2">
	        <h5 class="fwb fl10">查询列表</h5>
	  </div>
	  <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table3">
          <thead>
          <tr valign="top">
          	<th width="9%" class="head1">序号</th>
            <th width="49%" class="head1" >终端名称</th>
            <th width="20%" class="head1">终端IP</th>
            <th width="22%" class="head1" >状态</th>
          </tr>
          </thead>
          <tbody>
	         <c:forEach items="${equipmentList}" var="equipmentVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td class="ac fontstyle "><c:out value="${equipmentVO.equipmentNO}"></c:out></td>
				<td class="ac fontstyle "><c:out value="${equipmentVO.ip}"></c:out></td>
				 <td class="alc">
				    <input type="hidden" name="ips" value="${equipmentVO.ip }" />
				 	<image src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" name="logo"  id="pw${equipmentVO.ip }" />
				 	<span id="span${equipmentVO.ip }"></span>
				 </td>				
				</tr>
				</c:forEach>
          </tbody>
          <script type="text/javascript">
          	runit();
          </script>
        </table>
	</div>
</body>
</html>