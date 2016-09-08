<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common.jsp"%>

<script type='text/javascript' src='${swh_ctx }/dwr/interface/StatisticsAction.js'></script>
	<script type="text/javascript">
			
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
           //返回方法
          //用于获取返回参数
          //返回参数为数组类型
          //用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
          //以提供的参数：conferenceID,conferenceName
          function getReturnVenueMethod(conferenceArray){
              var conferenceName = "";
              var conferenceID = "";
              var length = conferenceArray.length;
              for(var i=0;i<length;i++){
                  if(i==(length-1)){
                      conferenceName =conferenceName+conferenceArray[i].conferenceName;
                      conferenceID = conferenceID+conferenceArray[i].conferenceID;
                  }else{
                      conferenceName =conferenceName+conferenceArray[i].conferenceName+",";
                      conferenceID = conferenceID+conferenceArray[i].conferenceID+",";
                  }
              }
              document.getElementById("meetingRoomName").value=conferenceName;
              document.getElementById("meetingRoomID").value=conferenceID;
          }
           //选择时间
			function selectMeetingTime(thisDom,timeType){
			     
			     var parameters = {
			         dateType : "datetime",
			         isNeedInfo:"true"
			     }
			     
			    creatCalendar(thisDom,parameters);
			  
			}
			
		function exportTimeNum(){
		 var modeChange=$("#modeChange").val();
		
		    var meetingRoomID= document.getElementById('meetingRoomID').value;
		     var startTime= document.getElementById('startTime').value;
		      var endTime=document.getElementById('endTime').value;
		      document.getElementById('pageform').action="${sys_ctx}/statistics/exportLongQuery.action?modeChange="+modeChange;
			  document.getElementById('pageform').submit();
			  document.getElementById('pageform').action="${sys_ctx}/statistics/query.action";		     
		}
		
		function modeSelect(){
			var modeSelect = (document.getElementById("modeChange")).value;
			if(modeSelect == "tableShow"){
				document.getElementById("tableShow").style.display = "";
				document.getElementById("picShow").style.display = "none";
			}else if(modeSelect == "picShow"){
				document.getElementById("picShow").style.display = "";
				document.getElementById("tableShow").style.display = "none";
			}
		}
		</script>

</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx}/statistics/query.action" id="pageform" name="pageform" method="post">
 <div id="basicform" class="contentwrapper">
    
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议室名称</td>
          <td width="35%" class="tableadd_data" >
          <input type="text" name="meetingRoomVO.meetingRoomName" class="inputtran" id="meetingRoomName"  value="${meetingRoomVO.meetingRoomName}" style="cursor:pointer" readonly="readonly" onclick="javascript:selectVenue(this)"/>
          <input  name="meetingRoomVO.meetingRoomID" id="meetingRoomID" type="hidden" class="tablexxInput" value="${meetingRoomVO.meetingRoomID}"/>
        
          </td>
          <td width="15%" class="tableaddtitle">起止时间</td>
          <td width="35%" class="tableadd_data">
        
           <input type="text" name="meetingRoomVO.startTime" id="startTime"	readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"   value='<fmt:formatDate value="${meetingRoomVO.startTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
          --        
           <input type="text" name="meetingRoomVO.endTime" id="endTime"	readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"   value='<fmt:formatDate value="${meetingRoomVO.endTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
          </td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10"  onclick="queryForm();" value="查 询" /></td>
        </tr>
      </table>
      
      
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
			<option value="picShow">图表模式</option>
		</select>
        </h5>
        <h5 class="fwb fr10"><a style="cursor:pointer" onclick="exportTimeNum();">导出</a></h5>
      </div>
    
       <div id="picShow" style="display: none">
		<table class="cx_tab" cellspacing="0" id="" cellpadding="0" border="0" width="100%">
			<tr valign="top">
				<td>
					<img src="${sys_ctx}/file/statistic/${roomUseTimeImageName }?<%=System.currentTimeMillis()%>"id="statisticImage"  width="100%"/>
				</td>
			</tr>
		</table>
	</div>
                
       <div id="tableShow">
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="24%" class="head1">会议室名称</th>
            <th width="24%" class="head1">使用时长(小时)</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${listMeetingRoom}" var="meetingRoomVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${meetingRoomVO.meetingRoomName}"></c:out></td>
				 <td class="ac fontstyle "><c:out value="${meetingRoomVO.useTime}"></c:out></td>				
				</tr>
		 </c:forEach>
         
        
        </tbody>
      </table>
       <jsp:include page="/common/pageFooter.jsp" />
       </div>
       
      </div>
      </form>
      </body>
      </html>