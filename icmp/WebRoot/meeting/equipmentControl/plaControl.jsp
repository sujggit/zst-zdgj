<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp"%>
<title>系统电源</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
  function pwopen(id)
  {
    
     DwrMethod.plaControl_Open(id,openback);
  }
			
    function openback(para)
    {
    	if(para !=null){
    	 var aa = "pw"+para;	 
    	 document.getElementById(aa).src ="${sys_ctx }/meeting/equipmentControl/image/open.png";	
	          	
    	}			
	}
	function pwclose(id)
	{
	   DwrMethod.plaControl_Close(id,closeback);
	}
    
    function closeback(para)
    {
    	if(para !=null){
    	 var aa = "pw"+para;	 
    	 document.getElementById(aa).src ="${sys_ctx }/meeting/equipmentControl/image/close.png";	
	          	
    	}			
	}
	
	function go()
	{
	  window.setInterval("runit()",'${sys_refreshTime}');
	}
	
	function runit()
	{
	  var ips = document.getElementsByName("ips");
	  var tmp ="";
	   for(var i=0;i< ips.length; i++)
	   {
	      	      
	     tmp= tmp + ips[i].value+";";
	   }
	    DwrMethod.getPlaStatusList(tmp,rback);
	    
	}
	function rback(lst)
	{
		for(var i=0;i<lst.length;i++)
		{
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

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' onload="go();">
<div id="container">
<div class="content">
 <div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_style_url}/titleicon.gif" width="20" height="25" /></div>
  <div class="fl">&nbsp;系统电源</div>
</div>
<div class="tablesdiv">
    <table class="listsearch" cellspacing="0" width="100%" id="query_table" cellpadding="0" border="0">
          <thead>
          <tr valign="top">
          	<th width="65px" class="titlehome ac fontstyle">序号</th>
            <th width="" class="titlehome ac fontstyle" >会场名称</th>
            <th width="" class="titlehome ac fontstyle" >等离子电视</th>
            <th width="" class="titlehome ac fontstyle" >状态</th>
            <th width="90px" class="titlehome ac fontstyle" >开</th>
            <th width="90px" class="titlehome ac fontstyle" >关</th>
          </tr>
          </thead>
          <tbody>
	         <c:forEach items="${equipmentList}" var="equipmentVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td class="ac fontstyle "><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"></c:out></td>
				<td class="ac fontstyle "><c:out value="${equipmentVO.description}"></c:out></td>
				 <td class="ac fontstyle ">
				    <input type="hidden" name="ips" value="${equipmentVO.ip }_${equipmentVO.equipmentID }" />
				    <input type="hidden" name="plaId" value="${equipmentVO.equipmentID }" />
				 	<image src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" name="logo"  id="pw${equipmentVO.ip }_${equipmentVO.equipmentID}" />
				 	
				 </td>				
				 <td class="ac fontstyle ">
				 <img src="${sys_ctx }/meeting/equipmentControl/image/open.png" title="打开" alt="打开" style="cursor:pointer" onclick="pwopen('${equipmentVO.ip }_${equipmentVO.equipmentID}')" />
				 </td>
                 <td class="ac fontstyle ">
				 <img src="${sys_ctx }/meeting/equipmentControl/image/close.png" title="关闭" alt="关闭" style="cursor:pointer" onclick="pwclose('${equipmentVO.ip }_${equipmentVO.equipmentID}')" />
                 </td>
				</tr>
				</c:forEach>
          </tbody>
        </table>
   </div>
  </div>
  </div>
</body>
</html>