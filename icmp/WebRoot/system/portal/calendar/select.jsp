<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title></title>
<%@include file="/common/common_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${sys_ctx}/system/portal/calendar/js/JSCalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${sys_ctx }/system/portal/calendar">
<script type="text/javascript">

<!--
var Parameters = new Object();
window.onload = function(){
	var queryString = document.location.search;
	
	if(queryString){
		queryString = queryString.substring(1);
		
		var params = queryString.split("&");
		
		for(var i = 0; i < params.length; i++) {
			var items = params[i].split("=");
		
			eval("Parameters." + items[0] + "='" + items[1] + "'")
		}
	}
	
	document.title = _parent.v3x.getMessage("V3XLang.calendar_page_title");
	
	if(_parent.__addDataEventObject){
		var originalValue = _parent.__addDataEventObject.value;
		if(originalValue == _parent.__addDataEventObject.getAttribute("deaultValue")){
			originalValue = "";
		}
	
		var _year = null;
		var _month = null;
		var _date = null;
		var _hour = null;
		var _minute = null;
		
		if(originalValue){
			document.getElementById("d").value = originalValue;
		    
			var date = null;
			var time = null;
			
			if(originalValue.indexOf(" ") > -1){
				var d1 = originalValue.split(" ");
				date = d1[0];
				time = d1[1];
			}
			else{
				date = originalValue;
			}
			
			var d = date.split("-");
			
			_year = d[0];
			
			_month = parseInt("1" + d[1]) - 100;
			_date = parseInt("1" + d[2]) - 100;
		
			if(time){
				var d2 = time.split(":");
				//_hour = parseInt(d2[0]);
				//_minute = parseInt(d2[1]);
				_hour = Number(d2[0]);
				_minute = Number(d2[1]);
			}
		}
	}
	
	//alert(_year + "\t" + _month + "\t" +  _date + "\t" + _hour + "\t" + _minute);
    
	JSCalendar(document.getElementById("d"), _year, _month, _date, _hour, _minute);
	
	
	
}

function returnFun(){
	var date = document.getElementById("d").value;

	if(!date){
		return;
	}
	
	if(_parent.__addDataEventObject){
		_parent.__addDataEventObject.value = date;
	}
	else{

		returnValue = date;//new Date(d[0], parseInt(d[1] - 1, d[2]));
	}
	
	window.close();
}
function returnFun1(){
	

	
	if(_parent.__addDataEventObject){
		_parent.__addDataEventObject.value = "";
	}
	else{
	
		returnValue = "";//new Date(d[0], parseInt(d[1] - 1, d[2]));
	}
	
	window.close();
}
function closeCalendar(){
    window.close();
}
function onkeydownFun(){
	if(event.keyCode == 27){
		window.close();
	}
}

	function getCalendarInfo(year,month){
	   
	  
	   CalendarAction.getCalendarInfo(year,month,function(lst){
	       
	        var dateArray = new Array();
	      
	        for(var index in lst){
	          
	           var newDate = {
	               date:lst[index].day,
	               month:lst[index].month,
	               year:lst[index].year,
	               dayoff:lst[index].dayoffValue,
	               description:lst[index].description
	           }
            
	           dateArray[lst[index].day] = newDate;
	        }
	        changeCalendarDatesStyle(dateArray,year,month);
	   })
	}
	
-->
</script>
</head>

<body onkeydown="onkeydownFun()" scroll="no">
<iframe id=frm name=frm height='100%' width='100%' frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
<input type="hidden" name="d" id="d">

</body>
</html>
