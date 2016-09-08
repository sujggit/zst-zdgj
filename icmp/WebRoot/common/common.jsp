<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="taglibs.jsp" %>
<c:set var="sys_ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="sys_refreshTime" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.refresh_time %>"></c:set>
<c:set var="sys_viewName" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.APP_NAME %>"></c:set>
<c:set var="sys_copyright" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.COPYRIGHT %>"></c:set>
<c:set var="sys_userSession" value="${user_session}"></c:set>
<c:set var="sys_date_num" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.meeting_space_time %>"></c:set>
<c:set var="sys_view_div" value="true"/><!-- ture时，没有页面跳转，都用层展示 -->
<c:set var="sys_style1" value="${pageContext.request.contextPath }/style/normal"></c:set>
<meta http-equiv="X-UA-Compatible" content="IE=8" />

<link rel="stylesheet" type="text/css" href="${sys_ctx }/plug-in/table-order/css/table.css"/>

<script type="text/javascript" src="${sys_ctx }/js/jquery-1.4.2.js"></script>
<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/util.js'></script>
<script type="text/javascript" src="${sys_style1}/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<!--  <script type="text/javascript" src="${sys_style1}/js/custom/general.js"></script>-->
<script type='text/javascript' src='${sys_ctx }/system/portal/conference/js/conferenceSelect.js'></script>
<script type='text/javascript' src='${sys_ctx }/system/portal/user/js/userSelect.js'></script>
<script type='text/javascript' src='${sys_ctx }/system/portal/selectTree/selectTree.js'></script>
<script type='text/javascript' src='${sys_ctx }/system/portal/calendar/js/cplugin.js'></script>
<script type="text/javascript" src="${sys_ctx }/js/validation/jquery.validate.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/windowInit.js"></script>
<script type="text/javascript" src="${sys_ctx }/js/webutil.js"></script>
<script type='text/javascript' src='${sys_ctx }/system/portal/department/js/departmentSelect.js'></script>
<script type='text/javascript' src="${sys_ctx }/js/my97DatePicker/WdatePicker.js"></script><!-- 时间插件 -->

<script type="text/javascript" src="${sys_style1}/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="${sys_ctx}/js/skin.js"></script>

<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/table-order/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="${sys_ctx }/js/validation/default.css">
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="${sys_ctx }/style/normal/css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="${sys_ctx }/style/normal/css/style.ie8.css"/>
   
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/css3-mediaqueries.js"></script>
<![endif]-->

<script type="text/javascript" charset="utf-8">
	$(document).ready(function(){//重复提交的问题
		window.onbeforeunload = function(){
			$(".submitBtn_Disa").val("请等待").attr("disabled","disabled");
			//$(":submit").val("请等待").attr("disabled","disabled");
		}
	})

	$(document).ready(function() { $('#query_table').dataTable({
	   "bPaginate": false,  
	   "bLengthChange": false, 
	   "bFilter": false,
	   "bInfo": false,
	   "bAutoWidth": true,  //自适应宽度 
	   "bAutoHeight":true,
	   //"sUrl": "/SSS/dataTables/de_DE.txt"
	    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
	//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
	   "oLanguage": {
           "sProcessing": "正在加载中......",
           "sZeroRecords": "没有符合条件的数据！"
           //"sSearch":"搜索："
		}    
	});
	
	  $("#query_table tr:gt(0)").bind("mouseover",function(){
	        $(this).css('background-color','#f4e9bb');
	  });
	  $("#query_table tr:gt(0)").bind("mouseout",function(){
	        $(this).css('background-color','');
	  });
    
	var noSTable = $('#query_table_nosearch').dataTable({
	   "bPaginate": false,  
	   "bLengthChange": false, 
	   "bFilter": false,
	   "bInfo": false,
	   "bAutoWidth": true,  //自适应宽度 
	   "bAutoHeight":true,
	   //"sUrl": "/SSS/dataTables/de_DE.txt"
	    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
	//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
	   "oLanguage": {
           "sProcessing": "正在加载中......",
           "sZeroRecords": "没有符合条件的数据！",
           "sSearch":"搜索"
		}    
	});
	
	  $("#abc tr:gt(0)").bind("mouseover",function(){
	        $(this).css('background-color','#f4e9bb');
	  });
	  $("#abc tr:gt(0)").bind("mouseout",function(){
	        $(this).css('background-color','');
	  });
	//jquery-validate1.11.1自定义验证方法（扩展的验证规则）
	  $.validator.addMethod("isMobilephone",function(value,element){
	  	var mobilephoneReg = /^((\+86)|(86))?(1[3|4|5|8])\d{9}$/;
	  	return mobilephoneReg.test(value);
	  },"请输入正确的手机格式");
	  $.validator.addMethod("isTelephone",function(value,element){
	  	var telephoneReg = /^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
	  	return telephoneReg.test(value);
	  },"请输入正确的电话格式，如（010-24673631）");
	  $.validator.addMethod("isIp",function(value,element){
	  	var ip = document.getElementById("ip");//将完整的IP进行验证
	  	var ipReg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	  	return ipReg.test(ip.value);
	  },"请输入正确的IP格式（由0到255之间的整数和.组成）");
	  $.validator.addMethod("checkIP",function(value,element){
			var ipReg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
			return ipReg.test(value);
		},"请输入正确的IP格式（由0到255之间的整数和.组成）");
	 } );
	 //显示、隐藏查询条件
	 function disquery(){
		$(".tableadd").toggle();
	 }
	 
	 //换肤
     var cssPath = getCookie("cssPath"); //获取默认皮肤路径   
	//判断用户Cookie中是否有路径,无采用默认,有采用用户的信息   
	if (cssPath != null && cssPath != ""){   
	    document.write("<link href='/icmp/style/" + cssPath + "/css/style.default.css' id='style' rel='stylesheet' type='text/css' />");   
     }else{   
          setCookie('cssPath',"normal",365);   
	      document.write("<link href='/icmp/style/normal/css/style.default.css' id='style' rel='stylesheet' type='text/css' />");   
	}
</script>