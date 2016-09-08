<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%>
  <title>会议记录</title>
  <script type="text/javascript">
  	function checkedStatus(typeName){
  		var allBoxName = "allbox"+typeName;
		var allStatus = document.getElementById(allBoxName);
		var boxName = "box"+typeName;
		var checkbox	=	document.getElementsByName(boxName);
  		for(var i=0;i<checkbox.length;i++){
  			if(allStatus.checked){//全选
  				if(!checkbox[i].checked){//没有选中的，进行选中
					checkbox[i].click();  				
  				}
  			}else{
	  			if(checkbox[i].checked){
					checkbox[i].click();  				
  				}
  			}
  		}
	}
	
	$(document).ready(function(){
		$('#maintainTable').dataTable({
				//"bSort": false,全部不排序
				//"asSorting": [[0,'desc']],
				//"aoColumnDefs":[{"bSortable":false,"aTargets":[2]}],//2列不排序
			   "bJQueryUI": true,
				"sPaginationType": "full_numbers",//分页样式
				"bPaginate":false,//不启用分页
			   "oLanguage": {
		         "sProcessing": "正在加载中......",
		         "sZeroRecords": "没有符合条件的数据！",
		         "sSearch":"搜索：",
		         "sInfo":"共 _TOTAL_ 条信息 | 当前第 _START_ / _END_ 项",
		         "sInfoEmpty":"共 0 条信息 | 当前第 0 项",
		         "sInfoFiltered": "",
		         "sLengthMenu":"显示 _MENU_ 项"
				}    
			});
	})
	
	
	
	function chechStatus(obj,typeID,rowID,checkOption,TypeName){
		if($("#"+typeID).attr("value").length>0&&$("#"+typeID).attr("value")!=checkOption){//checkbox多选时提醒
			alert("不能重复选择");		
			obj.checked = false;
			return;
		}

		if(obj.checked)//状态项是否选择
			$("#"+typeID).attr("value",checkOption);//记录当前选择的状态
		else
			$("#"+typeID).attr("value","");

		var all = document.getElementsByName(TypeName);//读取所有检查类型下选择的状态值
		var content="";
		for(var i=0;i<all.length;i++){
			if(all[i].value==null||all[i].value.length==0)
				content = content+"";
			else
				content = content+all[i].value;
			if(i==all.length-1) continue;
				content = content+"-";		//分割符于action类内一致,于默认显示地方一致
		};
		$("#"+rowID).attr("value",content);//记录该会场所有检查项的状态值，多个表示方式：1=1,1=0,1=1,
	}
	
	function add(){
		$('#addForm').submit();
	}
	
	function backHistory(meetingDetailID){
		window.location.href="${sys_ctx }/detail/beforeMeetingDebug.action?meetingDetailVO.meetingDetailID=" + meetingDetailID;
    }
  </script>
</head>
<body>
<form action="${sys_ctx}/meetingRoomMaintain/addDebugConferenceMaintain.action" id="addForm" name="addForm" method="post" escapeAmp="false">
	<div class="contentwrapper">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td class="tableaddtitle">会议名称</td>
				<td class="tableadd_data">
					<input type="hidden" name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID}" size="5"/>
				${meetingDetailVO.meetingName }</td>
				<td class="tableadd_data" colspan="2"></td>
			</tr>
			<tr>
				<td class="tableaddtitle">开始时间</td>
				<td class="tableadd_data">&nbsp;<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
				<td class="tableaddtitle">结束时间</td>
				<td class="tableadd_data">&nbsp;<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</table>
		            
			<div class="contenttitle2">
				<h5 class="fwb fl10">会议记录</h5>
			</div>
			<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="maintainTable">
				<thead>
					<tr>
						<th width="20px" class="head1">序号</th>
						<th width="%" class="head1">会场名称</th>
						<c:forEach items="${dListType}" var="dictionaryVO" 	varStatus="state">
							<th width="%" class="head1">
								<c:forEach items="${dListStatus}" var="dictionaryVO2" varStatus="stateb">
									<c:if test="${stateb.index==0 }">
										<!-- 全选按钮,默认选择第一个状态 -->
										<input id="allbox${dictionaryVO.dicValue }${dictionaryVO2.dicValue }"  onclick="checkedStatus('${dictionaryVO.dicValue }${dictionaryVO2.dicValue }');" type="checkbox"  value="allOperate"/>
									</c:if>
								</c:forEach>
								${dictionaryVO.dicViewName }
							</th>
						</c:forEach> 
						<th width="%" class="head1">备注</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="meetingDetailRoomVO" 	varStatus="state">
					<tr>
						<td class="alc">${state.index+1}
							<input type="hidden" id="${meetingDetailRoomVO.meetingRoomId }" name="meetingRoomMaintainVO.roomID" value="${meetingDetailRoomVO.meetingRoomId }" size="5"/>
						</td>
						<td>
						<input type="hidden" id="${meetingDetailRoomVO.meetingRoomId }b" name="meetingRoomMaintainVO.maintainUserName" value=""  size="30"/><!-- 选择记录会场所有选择状态的所有状态格式：typeID=value#typeID=value# 在chechStatus()方法内拼装-->
						${meetingDetailRoomVO.meetingRoomName }</td>
						<c:forEach items="${meetingDetailRoomVO.listType}" var="dictionaryVO" 	varStatus="statea">
							<td>
							<input type="hidden" id="${meetingDetailRoomVO.meetingRoomId }${dictionaryVO.dicValue }" name="c${meetingDetailRoomVO.meetingRoomId }" value=""  size="10"/><!-- 一个类型的选择情况 格式：typeID:状态value -->
							<c:forEach items="${meetingDetailRoomVO.listStatus}" var="dictionaryVO2" varStatus="stateb">
								<input id="g${meetingDetailRoomVO.meetingRoomId }r${dictionaryVO.dicValue }=${dictionaryVO2.dicValue }" name="box${dictionaryVO.dicValue }${dictionaryVO2.dicValue }" style="cursor:pointer" type="checkbox" onclick="chechStatus(this,'${meetingDetailRoomVO.meetingRoomId }${dictionaryVO.dicValue }','${meetingDetailRoomVO.meetingRoomId }b','${dictionaryVO.dicValue }=${dictionaryVO2.dicValue }','c${meetingDetailRoomVO.meetingRoomId }')" value="${dictionaryVO2.dicValue }"/>${dictionaryVO2.dicViewName }
								<script type="text/javascript">
									var typeValue = "${dictionaryVO.dicValue }";
									var statusValue = "${dictionaryVO2.dicValue }";
									var checkID =	"g${meetingDetailRoomVO.meetingRoomId }r${dictionaryVO.dicValue }=${dictionaryVO2.dicValue }";
									var	allOption = "${meetingDetailRoomVO.info2}";//检查项默认选中状态
									var a = allOption.split("-");
									
									for(var i=0;i<a.length;i++){//默认显示之前的输入信息	
										var b = a[i].split("=");
										if(typeValue==b[0]&&statusValue==b[1]){
											var obj = document.getElementById(checkID).click();
										}
									}
								</script>
							</c:forEach>
							</td>
						</c:forEach>
						<td><input type="text" class="inputtran" style="width:100%" name="meetingRoomMaintainVO.description" value="${meetingDetailRoomVO.info1 }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			<tr>
				<td>
					<input type="hidden" name="meetingRoomMaintainVO.maintainKey" value="${debugMeetingDetailVO.meetingDetailID }" />
					<input type="button" class="submit1 radius2" value="确 定" onclick="add();" />
					<input type="button" class="reset1 radius2" value="返 回" onclick="backHistory('${meetingDetailVO.meetingDetailID }');" />
				</td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>