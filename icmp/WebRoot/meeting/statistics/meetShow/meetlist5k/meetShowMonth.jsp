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
		    
		    
		 function meetingInfoList(tempid){
	      var srcurl="";
	      var sqls="${findvm.strsql }";
	      var addstr=" and view_meeting_month='"+tempid+"'";
	      addstr=encodeURI(encodeURI((addstr)));
	      if(sqls!=""){
          srcurl="${sys_ctx }/vmeeting5k/getMeetingInfoListOne.action?findvm.strsql="+sqls+addstr;
          }else{
          srcurl="${sys_ctx }/vmeeting5k/getMeetingInfoListOne.action?findvm.viewMeetingYear=${findvm.viewMeetingYear }&findvm.strsql="+sqls+addstr;
          }
			window.showModalDialog(srcurl,window,'dialogWidth:780px;dialogHeight:470px;');
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
			
		</script>

</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >
<!-- 判断是否显示打印按钮 -->
	<c:if test="${isPrint=='isPrint'}">
	<input  type='button' value='打印' class='notprint' onclick='javascript:window.print();'/>
	<hr width="100%" style="border: 2px solid #FB9337;" class='notprint'/>
	</c:if>
 <div id="basicform" class="contentwrapper">
  
    </div>
    <div id="contentwrapper" class="contentwrapper">
     
    
       <div id="chartdivNumDIV" style="display: none" align="center">
       <table>
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
             <th width="8%" class="head1">序号</th>
            <th width="24%" class="head1">月份</th>
            <th width="10%" class="head1">开会次数</th>
           <th width="20%" class="head1">开会时长</th>
           <th width="" class="head1">会议列表</th>
           
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
       
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
											<a onclick="meetingInfoList('${vml.viewMeetingType}');">查看</a>
										</td>
									</tr>
								
        </c:forEach>
        
        </tbody>
      </table>
       <script type="text/javascript">
        var depcs="<chart caption='月开会次数统计（次数）' xAxisName='月份' yAxisName='次数' showValues='0' decimals='0' formatNumberScale='0' palette='4'  baseFontSize='12' >";
         var depcs2="<chart caption='月开会时长统计（小时）' xAxisName='月份' yAxisName='小时' showValues='0' decimals='0' formatNumberScale='0' palette='4'  baseFontSize='12'>";
        var depcs_pie="<chart caption='月开会次数统计（次数）' palette='2' animation='1' formatNumberScale='0' pieSliceDepth='30' startingAngle='125' baseFontSize='12'>";
        var depcs_pie2="<chart caption='月开会时长统计（小时）' palette='2' animation='1' formatNumberScale='0' pieSliceDepth='30' startingAngle='125' baseFontSize='12'>";
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
	
				     depcs+="</chart>";
					 var chartdivMainRenfence = new FusionCharts("${sys_ctx }/js/fusionChat/Column3D.swf", "chartdivMainRenfenceID", "500", "320", "0", "0");
		                 chartdivMainRenfence.setDataXML(depcs);		   
		                 chartdivMainRenfence.render("chartdivNumDIV1");	
		                 depcs2+="</chart>";
					 var chartdivMainRenfence2 = new FusionCharts("${sys_ctx }/js/fusionChat/Column3D.swf", "chartdivMainRenfenceID2", "500", "320", "0", "0");
		                 chartdivMainRenfence2.setDataXML(depcs2);		   
		                 chartdivMainRenfence2.render("chartdivNumDIV2");	
		               
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
       
       
        <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp;
       <select id="modeChange"  onchange="modeSelect();">
			<option value="tableShow">列表模式</option>
			<option value="chartdivNumDIV">柱状图模式</option>
			<option value="chartdivNumDIVPie">饼图模式</option>
		</select>		
        </h5>
     
      </div>
      </div>
     
      </body>
      </html>