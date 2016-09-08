<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>确认</title>
	<link rel="stylesheet" type="text/css" href="${sys_ctx }/js/DataTables-1.9.4/demo_table_jui.css" />
<script type='text/javascript' src='${swh_ctx }/dwr/interface/StatisticsAction.js'></script>
<script type="text/javascript" src="${sys_ctx }/js/fusionChat/FusionCharts.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/alertJS/zDrag.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/alertJS/zDialog.js"></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
			$(document).ready(function() { $('#query_table2').dataTable({
		   //"sUrl": "/SSS/dataTables/de_DE.txt"
		    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
		//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
		   "aLengthMenu": [[5,10, 20, 50, -1], [5,10, 20, 50, "All"]],//下拉框
		   "bJQueryUI": true,
		   "bLengthChange": false, 
		    "bFilter": false,
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
	
	
	function submitFromAll(){
	//meetmanNum
	var rows=document.getElementsByName("meetmanNum");
	for(var i=0;i<rows.length;i++){
	if(rows[i].value!=""){
	var row=rows[i].parentNode.parentNode;
	var cs=row.childNodes;
	var manNum=cs[2].childNodes[0].value;
	var content=cs[3].childNodes[0].value;
	var meetids=cs[3].childNodes[1].value;
	var roomids=cs[3].childNodes[2].value;
	if(!isNaN(manNum)){
	DwrMethod.upadateMeetDetailRoom(meetids,roomids,manNum,content,function(result){});
	}
	}
	}
	alert('操作成功');
	}
	
	function submitFrom(sname){
	var row=sname.parentNode.parentNode;
	var cs=row.childNodes;
	var manNum=cs[2].childNodes[0].value;
	var content=cs[3].childNodes[0].value;
	var meetids=cs[3].childNodes[1].value;
	var roomids=cs[3].childNodes[2].value;
	if(manNum==""){
	alert("参会人数不能为空");
	}else{
	if(!isNaN(manNum)){
	DwrMethod.upadateMeetDetailRoom(meetids,roomids,manNum,content,function(result){
	if(result=='success'){
	alert("操作成功");
	}else{
	alert("操作失败");
	}
	});
	}else{
	alert('参会人数必须为数字');
	}
	}
	
	}
	
	
	function roomMaintainAdd(id,name,meetRoomID){//会场记录~会议室维护记录添加
	//window.showModalDialog("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceAddBefore.action?meetingDetailVO.meetingDetailID="+id+"&meetingDetailVO.meetingRoomID="+meetRoomID,window,'dialogWidth=800px;dialogHeight=520px;')
	var itop = (window.screen.availHeight-30-520)/2;        
    var ileft = (window.screen.availWidth-10-800)/2;       
    window.open("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceAddBefore.action?meetingDetailVO.meetingDetailID="+id+"&meetingDetailVO.meetingRoomID="+meetRoomID,'newwindow','height=520, width=800,top='+itop+',left='+ileft+',toolbar=no,menubar=no,scrollbars=no,resizable=no,location=n ostatus=no')
    }
</script>
</head>
<body>
  <div id="basicform" class="contentwrapper">  
   <div class="contenttitle2">
			<h5 class="fwb fl10">会议名称:${meetingName }</h5>
			<h5 class="fwb fr10"></h5>
		</div>
<form action="${sys_ctx }/vmeetingDetail/query.action" id="pageform" name="pageform" method="post">     
	  
	<table id="query_table2" cellpadding="0" cellspacing="0" border="0" class="stdtable">
			<thead>
				<tr>
					<th class="head1" width="20px">序号</th>
					<th class="head1">会场名称</th>
					<th class="head1" width="55px">参会人数</th>
					<th class="head1">描述</th>
				    <th class="head1">操作</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach items="${mrvlist}" var="vdv" varStatus="state">
				<tr>
					<td>${state.index+1 }</td>
					<td>${vdv.meetingRoomName }</td>
				    <td>
				    <input name="meetmanNum" class="inputtran" type="text" value="${vdv.manNum}" maxlength="5" style="width: 50px"/>
				    </td>
					<td>
					<input class="inputtran" type="text" value="${vdv.description }" /><input type="hidden" value="${vdv.meetingDetailId }"/><input type="hidden" value="${vdv.meetingRoomId }"/>
					</td>
					<td>
					<!--  
					<a onclick="submitFrom(this)">确认</a>
					-->
					<a onclick="roomMaintainAdd('${vdv.meetingDetailId}','${vdv.meetingDetailName}','${vdv.meetingRoomId}')" title="会场记录"> 会场记录</a>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			<tr>
				<td>
					
					  <input type="button" class="submit1 radius2 submitBtn_Disa" value="保存" onclick="submitFromAll()"/>
					  <input type="button" class="reset1 radius2" value="关 闭" onclick="window.close()"/>
					
					
				</td>
			</tr>
		</table>
		
</form>
</div>
</body>
</html>