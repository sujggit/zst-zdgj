<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>中控状态</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function go(){
	  window.setInterval("runit()",'${sys_refreshTime}');
	}
	
	function runit(){
	  var ips = document.getElementsByName("ips");
	  var tmp ="";
	   for(var i=0;i< ips.length; i++){
	     tmp= tmp + ips[i].value+";";
	     //alert(tmp);
	   }
	    DwrMethod.getCenterControl(tmp,rback);
	}
	
	function rback(lst){	
		for(var i=0;i<lst.length;i++){
			var ipAndStatus = lst[i];
			var ip_status = ipAndStatus.split(";");
			var status = ip_status[1];
			var ip = "pw"+ip_status[0];
			
			var logo = document.getElementById(ip);
			
			if(status=="0")
			{
				logo.src ="${sys_ctx }/meeting/equipmentControl/image/open.png";
			}
			else if(status=="1")
			{
			  	logo.src ="${sys_ctx }/meeting/equipmentControl/image/close.png";
			}
			else
			{
			   logo.src ="${sys_ctx }/meeting/equipmentControl/image/wait.gif";
			}
		}
	}
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="go();" >
	<div id="basicform" class="contentwrapper">
	  <div class="contenttitle2">
	        <h5 class="fwb fl10">查询列表</h5>
	  </div>
	  <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
          <thead>
          <tr>
          	<th width="9%" class="head1">序号</th>
            <th width="66%" class="head1" >会场名称</th>
            <th width="25%" class="head1" >状态</th>
          </tr>
          </thead>
          <tbody>
	         <c:forEach items="${equipmentList}" var="equipmentVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"></c:out></td>
				 <td class="alc">
				    <input type="hidden" name="ips" value="${equipmentVO.ip }" />
				 	<image src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" name="logo"  id="pw${equipmentVO.ip }" />
				 	
				 </td>				
				</tr>
				</c:forEach>
          </tbody>
          <script type="text/javascript">
          	runit();
          </script>
          </table>
     </div>
</body>
</html>