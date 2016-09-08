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
 function meetingList(meetroomid){
	var selectYear=document.getElementById("selectYear").value;	
	var selectMonth=document.getElementById("selectMonth").value;   
	if(selectMonth==0){selectMonth="";}
   window.showModalDialog("${sys_ctx }/vmeeting/getListForRoom.action?findvm.viewMeetRoomId="+meetroomid+"&findvm.viewMeetingYear="+selectYear+"&findvm.viewMeetingMonth="+selectMonth,window,'dialogWidth=900px;dialogHeight=520px;')
   }
	
	function exportMeetingRoomInfo(){
	var selectYear=document.getElementById("selectYear").value;	
	var selectMonth=document.getElementById("selectMonth").value;   
	if(selectMonth==0){selectMonth="";}
		document.getElementById('pageform').action="${sys_ctx}/vmeeting/viewRoomTotalExport.action?efindvm.viewMeetingYear="+selectYear+"&efindvm.viewMeetingMonth="+selectMonth;
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx }/vmeeting/viewRoomTotal.action";
	}	
		</script>

</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >

 <div id="basicform" class="contentwrapper">
   <form action="${sys_ctx}/vmeeting/viewRoomTotal.action" id="pageform" name="pageform" method="post"> 
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          
          <td class="tableaddtitle">
          年
           </td>
           <td  class="tableadd_data">
           <select id="selectYear" name="findvm.viewMeetingYear"  onchange="modeSelect();">
             <c:forEach items="${yearList}" var="vml" varStatus="state">
			<option value="${vml }" <c:if test="${findvm.viewMeetingYear == vml }">selected</c:if>>${vml }年</option>
			</c:forEach>
		</select>
           </td>
                  <td class="tableaddtitle">
          月
           </td>
           <td class="tableadd_data">
           <select id="selectMonth" name="findvm.viewMeetingMonth" onchange="modeSelect();">
           <option value="0" selected="selected">选择月份</option>
           <c:forEach var="i" begin="1" end="12" step="1">
			<option value="${i }" <c:if test="${findvm.viewMeetingMonth == i }">selected</c:if>>${i }月份</option>
			</c:forEach>
			
		</select>
           </td>
          <td class="tableaddtitle">
          <input type="submit" class="stdbtn mlr10"  value="查 询" /></td>
        </tr>
      </table>
       </form>
      
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />         
        </a>
        </div>
      </div>
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp;
       <select id="modeChange"  onchange="modeSelect();">
			<option value="tableShow">列表模式</option>
			<option value="chartdivNumDIV">柱状图模式</option>
			<option value="chartdivNumDIVPie">饼图模式</option>
		</select>		
        </h5>
        <h5 class="fwb fl10" style="float:right" >
        <c:if test="${findvm.viewMeetingYear>0 }">${findvm.viewMeetingYear }年</c:if>
        <c:if test="${findvm.viewMeetingMonth>0 }">${findvm.viewMeetingMonth }月</c:if>
		<a style="cursor: pointer;" onclick="exportMeetingRoomInfo();"> 导出</a>&nbsp;
		</h5>
		
      </div>
    
       <div id="chartdivNumDIV" style="display: none" align="center">
       <table border="1">
       <tr>
       <td>
       <div id="chartdivNumDIV1" style="padding-top: 10px;padding-right: 10px;"></div>
       </td>
       <td>
        <div id="chartdivNumDIV2" style="padding-top: 10px;"></div>
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
            <th width="20%" class="head1">序号</th>
            <th width="20%" class="head1">会议室名称</th>
            <th width="20%" class="head1">开会次数</th>
            <th width="20%" class="head1">开会时长</th>
            <th width="20%" class="head1">会议列表</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
       <script type="text/javascript">
        var csVar=0;
        var scVar=0.00;
        </script>
           <c:forEach items="${vlist}" var="vml"
									varStatus="state">
									
									<tr>
										<td class="alc">
											<c:out value="${state.index+1}"></c:out>
										</td>
										<td>
											<c:out value="${vml.viewMeetingDeptName }" />
										</td>
										<td>
											<c:out value="${vml.viewMeetingMonth}" />次
										</td>
										<td>
										<fmt:formatNumber value="${vml.viewTimeLong}" pattern="#.##" /> 小时
										</td>
										<td>
												<a onclick="meetingList('${vml.viewMeetRoomId}')" title="查看">	查看</a>
										</td>
									</tr>
						<c:if test="${state.index>=10}">							
		<script type="text/javascript">
        csVar+=${vml.viewMeetingMonth};
        scVar+=${vml.viewTimeLong};
        </script>	
		</c:if>					
        </c:forEach>
        
        </tbody>
      </table>
       <script type="text/javascript">
        var depcs="<chart caption='各会议室开会次数统计（次数）' xAxisName='会议室' yAxisName='次数' showValues='0' decimals='0' formatNumberScale='0' palette='4'  baseFontSize='12'>";
        var depcs2="<chart caption='各会议室开会时长统计（小时）' xAxisName='会议室' yAxisName='小时' showValues='0' decimals='0' formatNumberScale='0' palette='4'  baseFontSize='12'>";
        var depcs_pie="<chart caption='各会议室开会次数统计（次数）' palette='2' animation='1' formatNumberScale='0' pieSliceDepth='30' startingAngle='125' baseFontSize='12'>";
        var depcs_pie2="<chart caption='各会议室开会时长统计（小时）' palette='2' animation='1' formatNumberScale='0' pieSliceDepth='30' startingAngle='125' baseFontSize='12'>";
        </script>
        <c:forEach items="${vlist2}" var="vml" varStatus="state">
									<script type="text/javascript">
									depcs+="<set label='${vml.viewMeetingDeptName }' value='${vml.viewMeetingMonth}' />";
									depcs2+="<set label='${vml.viewMeetingDeptName }' value='${vml.viewTimeLong}' />";
									depcs_pie+="<set label='${vml.viewMeetingDeptName }' value='${vml.viewMeetingMonth}' />";
		                            depcs_pie2+="<set label='${vml.viewMeetingDeptName }' value='${vml.viewTimeLong}' />";
									</script>
		</c:forEach>
         <script type="text/javascript">
	
				     depcs+="</chart>";//alert(depcs);
					 var chartdivMainRenfence = new FusionCharts("${sys_ctx }/js/fusionChat/Column3D.swf", "chartdivMainRenfenceID", "500", "320", "0", "0");
		                chartdivMainRenfence.setDataXML(depcs);		   
		               chartdivMainRenfence.render("chartdivNumDIV1");	
		               
		               depcs2+="</chart>";//alert(depcs2);
					 var chartdivMainRenfence2 = new FusionCharts("${sys_ctx }/js/fusionChat/Column3D.swf", "chartdivMainRenfenceID2", "500", "320", "0", "0");
		                 chartdivMainRenfence2.setDataXML(depcs2);		   
		                 chartdivMainRenfence2.render("chartdivNumDIV2");	
		                 
		              if(csVar>0){
		               depcs_pie+="<set label='其他' value='"+csVar+"' />";
		               depcs_pie2+="<set label='其他' value='"+scVar+"' />";
		               }
		                 
		                depcs_pie+="</chart>";
					    var chartdivMainRenfence2 = new FusionCharts("${sys_ctx }/js/fusionChat/Pie3D.swf", "chartdivMainRenfenceIDPie", "500", "320", "0", "0");
		                chartdivMainRenfence2.setDataXML(depcs_pie);		   
		                chartdivMainRenfence2.render("chartdivNumDIVPie1");	
		                
		                depcs_pie2+="</chart>";
					    var chartdivMainRenfence2 = new FusionCharts("${sys_ctx }/js/fusionChat/Pie3D.swf", "chartdivMainRenfenceIDPie2", "500", "320", "0", "0");
		                chartdivMainRenfence2.setDataXML(depcs_pie2);		   
		                chartdivMainRenfence2.render("chartdivNumDIVPie2");	  
		              		
		 </script>
       </div>
       
      </div>
     
      </body>
      </html>