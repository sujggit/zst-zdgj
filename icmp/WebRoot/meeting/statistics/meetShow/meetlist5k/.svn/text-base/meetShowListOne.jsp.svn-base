 <%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common.jsp"%>

<script type='text/javascript' src='${swh_ctx }/dwr/interface/StatisticsAction.js'></script>
<script type="text/javascript" src="${sys_ctx }/js/fusionChat/FusionCharts.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/alertJS/zDrag.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/alertJS/zDialog.js"></script>
		<script type="text/javascript">
			/**
			*查询会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function meetingRoomqeury(){
			  $("#pageform").submit();
			  //  document.pageform.submit();
		    }
           /**
	       *选择会议室
	       */
          
           function selectVenue(thisDom){
                         
              			  var conferenceParameters = {
			                  methodName:'getReturnVenueMethod',			                
			                  selectType:'multiple'
			              }
			             creatConferenceSelect(thisDom,conferenceParameters); 
		 }

			
		function modeSelect(){
		
			var modeSelect = (document.getElementById("modeChange")).value;
			if(modeSelect == "tableShow"){
				document.getElementById("tableShow").style.display = "";
				document.getElementById("chartdivNumDIV").style.display = "none";
				document.getElementById("chartdivNumDIVPie").style.display = "none";
			}else if(modeSelect == "chartdivNumDIV"){
				document.getElementById("chartdivNumDIV").style.display = "";
				document.getElementById("tableShow").style.display = "none";
				document.getElementById("chartdivNumDIVPie").style.display = "none";
			}else if(modeSelect == "chartdivNumDIVPie"){
			    document.getElementById("tableShow").style.display = "none";
				document.getElementById("chartdivNumDIV").style.display = "none";
				document.getElementById("chartdivNumDIVPie").style.display = "";
			}
		}
			
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
			
		function selectDepartments(thisDom){
              var departParameters = {
                  methodName:'getReturnDepartMethod',
                  selectType:'radio',
                  extraDept:'false',
                  middleSelect:'true'
              }
             creatDepartmentSelect(thisDom,departParameters); 
          }
	    function getReturnDepartMethod(departList){
	    	var departmentID="";
            var departmentName="";
            var depLength = departList.length;
            for(var i=0;i<depLength;i++){
              departmentID+=departList[i].departmentID;
              departmentName+=departList[i].departmentName;
              //alert(departList[i].departmentName+" + "+departList[i].departmentID);
            }
          	$("#deptID").attr("value",departmentID);
            $("#deptName").attr("value",departmentName);
	    }
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >
 <div class="contenttitle2">
        <h5 class="fwb fl10">会议列表 </h5>
       
      </div>
         
       <div id="tableShow">
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th class="head1" width="10%">序号</th>
            <th class="head1" width="15%">会议名称</th>
            <th class="head1" width="20%">开始时间</th>
            <th class="head1" width="15%">会议类型</th>
            <th class="head1" width="15%">会议标签</th>
            <th class="head1" width="10%">参会人数</th>
            <th class="head1" width="15%">预约人</th>
          
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
      
           <c:forEach items="${vlist}" var="vml" varStatus="state">
									
									<tr>
										<td class="alc">
											<c:out value="${state.index+1}"></c:out>
										</td>
										<td>
											<c:out value="${vml.viewMeetingName }" />
										</td>
										<td>
											<fmt:formatDate value="${vml.viewStartTime }"  pattern="yyyy-MM-dd HH:mm"/>
										</td>
										<td>
										<zzst:lable type="meetingType" value="${vml.viewMeetingType }"></zzst:lable>
										</td>
										<td>
											<c:out value="${vml.viewMeetingInfo}" />
										</td>
										<td>
											<c:out value="${vml.viewManNum}" />
										</td>
										<td>
											<c:out value="${vml.viewUserName}" />
										</td>
									</tr>
						
        </c:forEach>
        
        </tbody>
      </table>
      
       </div>
       
       
     
      
      </div>
     
      </body>
      </html>