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
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
		<script type="text/javascript">
			/**
			*查询会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function findQeury(){
			  $("#pageform110").submit();
			  //  document.pageform.submit();
		    }
                        
	       /**
	       *选择会议室
	       */
          
          function selectConference(thisDom){
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
                  selectType:'radio'
              }
             creatConferenceSelect(thisDom,conferenceParameters); 
          }
          function getReturnConferenceMethod(conferenceArray){
          
                  var meetingRoomID="";
	              var meetingRoomName="";
	              var conferenceLength = conferenceArray.length;
	              for(var i=0;i<conferenceLength;i++){
	            	  meetingRoomID=conferenceArray[i].conferenceID;
	            	  meetingRoomName=conferenceArray[i].conferenceName;
	              }
	          	$("#meetingRoomID").attr("value",meetingRoomID);
               	$("#meetingRoomName").attr("value",meetingRoomName);
              
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

 <div id="basicform" class="contentwrapper">
     <div id="basicform" class="contentwrapper">
     <form action="${sys_ctx}/vmeeting/viewRoomAssets.action" id="pageform110" name="pageform" method="post">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">设备类型</td>
          <td width="35%" class="tableadd_data" >
         	 <select name="equipmentMaintainVO.equipmentVO.equipmentType" id="equipmentType" title="请选择" style="cursor:pointer" >
				     <zzst:option type="equipmentType" value="${equipmentMaintainVO.equipmentVO.equipmentType}" required="false"/>
			 </select>
          </td>
          <td width="15%" class="tableaddtitle">所属会议室</td>
          <td width="35%" class="tableadd_data">
          	<input type="hidden" name="equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomID" id="meetingRoomID" class="inputtran" value="${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomID}"  />
          	<input type="text" class="inputtran" name="equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" value="${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName}" style="cursor:pointer"  onclick="selectConference(this)" readonly="readonly"/> 	
          </td>
          <td rowspan="2" class="tableaddtitle" style="vertical-align:middle;"><input type="button" class="stdbtn mlr10" onclick="findQeury();" value="查 询" /></td>
        </tr>
        <tr>
          <td width="15%" class="tableaddtitle">开始时间</td>
          <td width="35%" class="tableadd_data" >
          <img src="${sys_style1 }/images/c2.png" width="16" height="16"  style="vertical-align:middle; padding:3px;"   />
          <input type="text" id="starTime" name="findvm.viewMeetingInfo" class="inputtran"	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='${findvm.viewMeetingInfo}'/>
         </td>
          <td width="15%" class="tableaddtitle">结束时间</td>
          <td width="35%" class="tableadd_data">
         <img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
           <input type="text" id="endTime" name="findvm.viewMeetingRoomName" class="inputtran"	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"   value='${findvm.viewMeetingRoomName}'/>
          </td>
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
		&nbsp;
		</h5>
      </div>
    
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
            <th width="24%" class="head1">设备名称</th>
            <th width="10%" class="head1">维修次数</th>
           <th width="24%" class="head1">维修费用</th>
           <th width="" class="head1">所属会议室</th>
           
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
										    <c:out value="${vml.viewTimeLong}" />元
										</td>
										<td title="${vml.viewMeetingName}">
											<c:out value="${vml.viewMeetingName}" />&nbsp;
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
        var depcs="<chart caption='设备维修次数统计（次数）' xAxisName='设备名称' yAxisName='次数' showValues='0' decimals='0' formatNumberScale='0' palette='4'  baseFontSize='12'>";
        var depcs2="<chart caption='设备维修费用统计（元）' xAxisName='会议室' yAxisName='小时' showValues='0' decimals='0' formatNumberScale='0' palette='4'  baseFontSize='12'>";
        var depcs_pie="<chart caption='设备维修次数统计（次数）' palette='2' animation='1' formatNumberScale='0' pieSliceDepth='30' startingAngle='125' baseFontSize='12'>";
        var depcs_pie2="<chart caption='设备维修费用统计（元）' palette='2' animation='1' formatNumberScale='0' pieSliceDepth='30' startingAngle='125' baseFontSize='12'>";
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