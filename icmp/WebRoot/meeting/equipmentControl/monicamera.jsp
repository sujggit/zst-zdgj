<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${sys_ctx }/meeting/equipmentControl/css/lg.css" type="text/css" rel="stylesheet" />
<link href="${sys_ctx }/plug-in/jquery-slider/css/jslider.css" type="text/css" rel="stylesheet" />
<link href="${sys_ctx }/plug-in/jquery-slider/css/jslider.round.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

 <title>摄像头控制</title>
 <script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
  function direction(op,id)
  {
    
     DwrMethod.directionKey(id,op,opback);
  }
			
    function opback(para)
    {
    	if(para !="")
    	{
    	  alert(para);
    	}		
	}
	function speed(op,id)
	{
	   DwrMethod.speed(op,id,sback);
	}
    
    function sback(para)
    {
    		
	}
	

</script>     
</head>
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
   <input type="button" value="上" onclick="direction('up','10.209.4.60')" />
   <input type="button" value="下" onclick="direction('down','10.209.4.60')" />
   <input type="button" value="左" onclick="direction('left','10.209.4.60')" />
   <input type="button" value="右" onclick="direction('right','10.209.4.60')" />
   <input type="button" value="快" onclick="speed('3','10.209.4.60')" />
   <input type="button" value="中" onclick="speed('2','10.209.4.60')" />
   <input type="button" value="慢" onclick="speed('l','10.209.4.60')" />
  </body>
</html>
