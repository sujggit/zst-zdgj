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
		  //给打印按钮绑定方法
		  $("#printbut").bind("click",function(){
		        $(this).hide();
		       	$("#query_table2_length").hide();
		       	$("#query_table2_filter").hide();
		       	$("#mhr").hide();
		       	$("#mh4").html("会议列表");
		        window.print();
		        $("#query_table2_length").show();
		       	$("#query_table2_filter").show();
		       	$("#mhr").show();
		        $(this).show();
		        $("#mh4").empty();
		  });
	});
			
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
	    
	     //详细页面
     function meetDetail(meetingID,meetingTpyes){
           if(meetingTpyes==1){
           window.showModalDialog("${sys_ctx }/detail/generalDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=600px;dialogHeight=470px;');
           }else if(meetingTpyes==2){
           window.showModalDialog("${sys_ctx }/detail/vedioDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=600px;dialogHeight=470px;');
           }
     }
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >
	<!-- 判断是否显示打印按钮 -->
	<c:if test="${isPrint=='isPrint'}">
		<div align="center">
			<input id="printbut"  type='button' value='打印' class="submit1 radius2"/><br/>
		<h4 id="mh4"></h4>
		</div><br/>
	<hr id="mhr" width="100%" style="border: 2px solid #FB9337;" class='notprint'/>
	</c:if>
 <div id="basicform" class="contentwrapper">

   
    </div>
    <div id="contentwrapper">
     
    
       <div id="chartdivNumDIV" style="display: none" align="center">
       <table>
       <tr>
       <td>
       <div id="chartdivNumDIV1" style="padding-top: 10px;padding-right: 10px;"></div>
       </td>
       <td>
        <div id="chartdivNumDIV2" style="padding-top: 10px"></div>
        </td>
        </tr>
        </table>
       </div>
          
          
         <div id="chartdivNumDIVPie" style="display: none" align="center">
       <table>
       <tr>
       <td>
       <div id="chartdivNumDIVPie1" style="padding-top: 10px;padding-right: 10px;"></div>
       </td>
       <td>
        <div id="chartdivNumDIVPie2" style="padding-top: 10px;"></div>
        </td>
        </tr>
        </table>
       </div>      
       <div id="tableShow">
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th class="head1">序号</th>
            <th class="head1">会议名称</th>
            <th class="head1">开始时间</th>
            <th class="head1">会议类型</th>
            <!-- <th class="head1">会议标签</th> -->
            <th class="head1">预约人</th>
            <th class="head1">参会人数</th>
            <th class="head1">会议详情</th>
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
										<%-- <td>
											<c:out value="${vml.viewUserName}" />
										</td> --%>
										<td>
											<c:out value="${vml.viewManNum}" />
										</td>
										<td>
											<a onclick="meetDetail('${vml.viewMeetingId}','${vml.viewMeetingType}');">查看</a>
										</td>
									</tr>
						
        </c:forEach>
        
        </tbody>
      </table>
       </div>
       
       
     
      
      </div>
      </body>
      </html>