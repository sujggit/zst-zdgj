 <%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <%@include file="/common/common.jsp"%>
   
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
	<script type="text/javascript">
		/**
		function exportComparison(){onload="setInterval('refresh()',6*1000)"
			window.location.href="${sys_ctx}/detail/exportComparisonList.action";
		}
		*/
		var meetingDetailId;
		//VideoCardParameter音视频参数
		function compare(){ 
		
			var VideoCardParameter=null;
			var disabled='disabled';
			var meetingDetailIDSelect = document.getElementById("meetingDetailIDSelect");
			//meetingDetailIDSelect.disabled = "disabled";
			VideoCardDwrMethod.autoCompare(meetingDetailIDSelect.value,VideoCardParameter, compareBackup);	
			
			//document.getElementById("pageform").submit();
		}

		function compareBackup(result){
			if(result == "none"){
				alert("现在不能点名，一个时间段只能有一个会议能点名！");
			}else{
			//var disabled='disabled';
			//window.location.href = "${sys_ctx}/videoCardCompare/queryComparisonList.action?chooseMeetingNumber=" + meetingDetailIDSelect.value+"&disabled="+disabled;
			refresh();
			}
		}

		function stopCompare(){
			var meetingDetailIDSelect = document.getElementById("meetingDetailIDSelect");
			
			VideoCardDwrMethod.stopAutoCompare(meetingDetailIDSelect.value, stopCompareBackup);	
		}

		function stopCompareBackup(result){
			//if(result == "none"){
			//	alert("目前可能没有点名线程");
			//}else{
				alert("操作成功!");
			//}
		}
		
		function refresh(){
			var meetingDetailIDSelect = document.getElementById("meetingDetailIDSelect");
			window.location.href = "${sys_ctx}/videoCardCompare/queryComparisonList.action?chooseMeetingNumber=" + meetingDetailIDSelect.value;
        	//window.location.href = window.location.href;
        	//window.location.reload();
		}

		function changeMeetingDetail(selectValue){
			//var chooseMeetingNumber = document.getElementById("meetingDetailIDSelect").value;
			//alert(chooseMeetingNumber);
			meetingDetailId = selectValue;
		}


		function comparisonDetail(compDetailID,comparisonID){
        
         window.location.href="${sys_ctx}/videoCardCompare/comparisonDetail.action?comparisonVO.compDetailID="+compDetailID+"&comparisonVO.ID="+comparisonID;
			}


		function reView(){
			window.location.href="/icmp/meeting/meetingManage/viewCompare/RviewCompare.jsp";

			}
			 function toView(meetingRoomID,meetingDetailId,compDetailID,IP){
	  window.showModalDialog("${sys_ctx}/meeting/meetingManage/viewCompare/detailCompareView.jsp?meetingRoomNo="+meetingRoomID+"&meetingDetailId="+meetingDetailId+"&compareDetailId="+compDetailID+"&equipIp="+IP,window,'dialogWidth=1100px;dialogHeight=670px;');
		  }
	 </script>
  </head>
  <body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
	<form action="${sys_ctx}/videoCardCompare/queryComparisonList.action" id="pageform" name="pageform" method="post">
      <div id="basicform" class="contentwrapper">
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td width="15%" class="tableaddtitle">会议列表</td>
				<td width="46%" class="tableadd_data">
					<select name="" id="meetingDetailIDSelect" class="select200 fontstyle" onchange="changeMeetingDetail(this.value);" <c:if test="${disabled=='disabled'}">disabled</c:if>>
					  <c:forEach items="${meetingDetailList}" var="meetingDetail" >
						<option value="${meetingDetail.meetingDetailID }" ${meetingDetail.meetingDetailID == chooseMeetingNumber ? "selected" : "" }>
							${meetingDetail.meetingName }
						</option>
				      </c:forEach>
					  <c:if test="${empty  meetingDetailList}">
						<option value="">没有会议</option>
					  </c:if>
	              </select>
	              <span><input type="checkbox" name="comparisonType" value="audioVideo" checked="checked" />音视频</span>
	              <span><input type="checkbox" name="comparisonType" value="video"/>视频</span>
	            </td>
                <td class="tableaddtitle">
                	<input type="button" class="stdbtn mlr10" value="点 名" onclick="compare()" />
                	<input type="button" class="stdbtn mlr10" value="终止点名" onclick="stopCompare()" />
                	<input type="button" class="stdbtn mlr10" value="刷 新" onclick="refresh()" />
                </td>
		  </tr>
		</table>
    </div>
    
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp;
        </h5>
        <h5 class="fwb fr10"><a style="cursor:pointer" onclick="">进度</a></h5>
      </div>
       <div id="tableShow">
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="16%" class="head1">会场名称</th>
            <th width="9%" class="head1">上行视频</th>
            <th width="9%" class="head1">下行视频</th>
            <th width="9%" class="head1">上行音频</th>
            <th width="9%" class="head1">下行音频</th>
            <th width="12%" class="head1">发送丢包率</th>
            <th width="12%" class="head1">接收丢包率</th>
            <th width="6%" class="head1">结果</th>
            <th width="12%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${comparisonVOList}" var="comparisonVO" varStatus="status">
			<tr>
				<td class="alc">
				<c:out value="${status.index+1}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.meetingRoomVO.meetingRoomName}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.upVideoQuality}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.downVideoQuality}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.upAudioQuality}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.downAudioQuality}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.sendPacketLoss}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.receivePacketLoss}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.result}"></c:out>
				</td>
				<td class="alc">
				<a onclick="reView();">手工确认</a> |<a onclick="toView('${comparisonVO.meetingRoomID}','${comparisonVO.meetingDetailID}','${comparisonVO.compDetailID}','10.1.6.40')">详情</a>
				</td>
			  </tr>
		    </c:forEach>
          </tbody>
         </table>
       </div>
      </div>
    </form>
  </body>
</html>