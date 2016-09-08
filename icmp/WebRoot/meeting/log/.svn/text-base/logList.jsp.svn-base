<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <title>日志管理</title>
  <script type="text/javascript">
	 function pageInit(){
	    var obj = new htmlUtil();
		obj.title("logType","请选择");	
		obj.title("meetingStartTime","请点击图片");	
		obj.title("meetingEndTime","请点击图片");
		obj.title("userName","请点击选择");
	 }

	 function selectUsers(thisDom){
          var userParameters = {
              methodName:'getReturnUserMethod',
              selectType:'radio'
          }
          creatUserSelect(thisDom,userParameters); 
      }
      
      function getReturnUserMethod(userArray){
          var userID="";
          var userName="";
          var userLength = userArray.length;
          for(var i=0;i<userLength;i++){
        	  userID=userArray[i].userID;
        	  userName=userArray[i].userName;
          }
      	 $("#userID").attr("value",userID);
         $("#userName").attr("value",userName);
      }
	 
	  //选择时间
	  function selectOperatorDate(viewID,timeType){
		var parameters = {
			dateType : "datetime",
			isNeedInfo:"true"
		}
		var thisDom = document.getElementById(viewID);
		creatCalendar(thisDom,parameters);
		
		var currentTime = new Date(Date.getCurrentDateTime().replace(/\-/g, "\/"));   
		var startTime = new Date(document.getElementById('meetingStartTime').value.replace(/\-/g, "\/"));
        var endTime = new Date(document.getElementById('meetingEndTime').value.replace(/\-/g, "\/")); 
        if(startTime>=endTime){
           	alert("结束时间必须晚于开始时间！");
            document.getElementById('meetingEndTime').value="";
            return;
         }
	  }			  
	  function logQeury(){
		$('#pageform').submit();
	  }
	
	 function exportLog(){
		 if(totalNo){
			 if(totalNo>1000) {
					if(!confirm("数据量超过30000条，确定仍然要导出吗？")){
						return;
					}
				}
		 }
	   var userName= document.getElementById('userName').value;
	  // var logType= document.getElementById('logType').value;
	   //alert(logType);
	   var starTime=document.getElementById('starTime').value;
	   var endTime=document.getElementById('endTime').value;
	   document.getElementById('pageform').action="${sys_ctx}/log/exportQuery.action?logVO.userName="+userName+"&logVO.starTime="+starTime+"&logVO.endTime="+endTime;
	   document.getElementById('pageform').submit();
	   document.getElementById('pageform').action="${sys_ctx}/log/query.action";
	 }

	 //查看日志详细内容
	 function detail(id){
		 window.showModalDialog("${sys_ctx }/log/detail.action?logVO.logID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	 }

	 var totalNo;
	 $(document).ready(function(){
		 var spanTotal = $("#spanTotal");
		 totalNo = $("#spanTotal").html();
	})
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx}/log/query.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td class="tableaddtitle">操作人</td>
          <td class="tableadd_data" >
	          <input type="hidden"  name="logVO.userID" id="userID" class="" value="${logVO.userID}" />
	      	  <input type="text"  class="inputtran" name="logVO.userName" id="userName" value="${logVO.userName}" style="cursor:pointer" readonly="readonly" onclick="selectUsers(this);" />
          </td>
          <td class="tableaddtitle">日志类型</td>
          <td class="tableadd_data">
            <select name="logVO.logType" class="select200 fontstyle"  id="logType">                  
            	<zzst:option type="logType" value="${logVO.logType}" required="false"/>
		    </select>
          </td>
          <td rowspan="2" class="tableaddtitle" style="vertical-align:middle;"><input type="button" class="stdbtn mlr10" onclick="queryForm();" value="查 询" /></td>
        </tr>
        <tr>
          <td width="15%" class="tableaddtitle">开始时间</td>
          <td width="35%" class="tableadd_data" >
          <img src="${sys_style1 }/images/c2.png" width="16" height="16"  style="vertical-align:middle; padding:3px;"   />
          <input type="text" id="starTime" name="logVO.starTime" class="inputtran"	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${logVO.starTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
         </td>
          <td width="15%" class="tableaddtitle">结束时间</td>
          <td width="35%" class="tableadd_data">
         <img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
           <input type="text" id="endTime" name="logVO.endTime" class="inputtran"	readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"   value='<fmt:formatDate value="${logVO.endTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
          </td>
        </tr>
      </table>
 
       <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
          </a>
        </div>
      </div>
  
     </div>
     <div id="contentwrapper" class="contentwrapper">
       <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp; </h5>
        <h5 class="fwb fr10"><a onclick="exportLog();">导出</a></h5>
       </div>
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="9%" class="head1">序号</th>
            <th width="14%" class="head1">日志类型</th>
            <th width="39%" class="head1">描述</th>
            <th width="14%" class="head1">操作时间</th>
            <th width="10%" class="head1">操作人</th>
            <th width="14"  class="head1">操作</th>
            <!--  <th width="10%" class="head1">操作</th>-->
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${logVOList}" var="logVO" 	varStatus="state">
			   <tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				 <td><zzst:lable type="logType" value="${logVO.logType}"></zzst:lable>
				 </td>
				 <td>&nbsp;<c:out value="${logVO.operatorContent}"/></td>
				 <td>&nbsp;<fmt:formatDate value="${logVO.operatorDate}"  pattern="yyyy-MM-dd HH:mm"/></td>
				 <td class="alc">&nbsp;<c:out value="${logVO.userName}"/></td>
				 <td class="alc">
				 	<a onclick="javascript:detail('${logVO.logID}');"/> 查看
				 </td>
				 <%--<td class="alc">&nbsp;<a style="cursor: pointer;" onclick="javascript:del('${logVO.logID}');">删除</a>--%>
			   </tr>
	        </c:forEach>
        </tbody>
      </table>
      <script type="text/javascript">
        function del(id){
      		if(!window.confirm("是否确认删除？")) return;
     		window.location.href="${sys_ctx }/log/DelLog.action?logVO.logID="+id;
        }
      </script>
      <div><jsp:include page="/common/pageFooter.jsp"/></div>
    </div>
  </form>
 </body>
</html>