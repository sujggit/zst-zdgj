<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="taglibs.jsp" %>
<c:set var="sys_ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="sys_viewName" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.APP_NAME %>"></c:set>
<c:set var="sys_refreshTime" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.refresh_time %>"></c:set>
<c:set var="swh_meeting_space_time" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.meeting_space_time %>"></c:set>
<c:set var="sys_userSession" value="${user_session}"></c:set>
<c:set var="dialogStyle" value="dialogWidth=900px;dialogHeight=570px;"></c:set>
<c:set var="sys_view_div" value="true"/><!-- ture时，没有页面跳转，都用层展示 -->

<!-------------- add by yangyi 可视通服务器IP ------------ -->
<c:set var="sys_kst_mcu_ip" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.kst_mcu_IP %>"></c:set>

<%@include file="jsfile.jsp" %>
<!-- 页面用的图片   	开始 -->
<c:set var="sys_page_list_down" value="${sys_ctx}/images/blue/searchicon.gif"></c:set>
<c:set var="sys_page_list_up" value="${sys_ctx}/images/blue/searchicon.gif"></c:set>
<c:set var="sys_page_list_table" value="${sys_ctx}/images/blue/titleicon.gif"></c:set>
<c:set var="sys_page_list_time" value="${sys_ctx}/images/blue/calendar.gif"></c:set>
<c:set var="sys_style_url" value="${sys_ctx}/images/blue"></c:set>
<!-- 页面用的图片   	结束 -->


<link rel="stylesheet" type="text/css" href="${sys_ctx }/style/blue/layout.css"/>
<link rel="stylesheet" type="text/css" href="${sys_ctx }/style/blue/font.css"/>
<link rel="stylesheet" type="text/css" href="${sys_ctx }/style/blue/global.css"/>
<link rel="stylesheet" type="text/css" href="${sys_ctx }/style/blue/reset.css"/>
<link rel="stylesheet" type="text/css" href="${sys_ctx }/style/blue/css.css"/>

















 
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/uploadfile/upload.js"></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/table-order/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8">
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
		}    
	});
	
	  $("#query_table tr:gt(0)").bind("mouseover",function(){
	        $(this).css('background-color','#f4e9bb');
	  });
	  $("#query_table tr:gt(0)").bind("mouseout",function(){
	        $(this).css('background-color','');
	  })
     jQuery.validator.addMethod("checkIP",function(value,element,params){
      var format = /^((25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)(.)(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)(.)(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)(.)(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d))$/; 	
//		var nowIP=document.getElementById(id);
		var fIp=value.replace(/^\s+|\s+$/g,"");
        if(params){
		  if(!format.exec(fIp)){
		                   
       	  //alert("ip格式错误,请重新输入！");
       	  //document.getElementById(id+"msg").innerHTML="<img src='../images/error.png'size=20 height=20>";
       	  return false;
          }
        }
    	return true;
    },"null");
	
	 } );

	//新页面表现样式控制  	开始 
	function closeOperateDIv(){
	    var obj = document.getElementById("sys_pageOperateDiv");
		obj.style.display = "none";
		document.getElementById("sys_pageContentDiv").innerHTML="";
   }

	/**
	入口
	url 调整的全路径
	mark    modalDialog	模式窗口
			href		location.href
	**/
	function operateUI(url,mark){
		if(${sys_view_div}){
			$("#sys_pageOperateDiv").css("display","");
			document.getElementById("sys_pageContentDiv").innerHTML="<iframe width='100%' height='100%' id='sys_operateIframe' src=''></iframe>";
			$("#sys_operateIframe").attr("src",url);
		}else if(mark=='modalDialog'){
			window.showModalDialog(url,window,'dialogWidth=600px;dialogHeight=470px;');
		}else if(mark=='href'){
			location.href=url;
		}
	}

	/**
	结束
	close  不操作父窗口
	reload 刷新父窗口
	**/
	function operateUIEnd(type){
		if(type=='close'){
			if(${sys_view_div})
				window.parent.closeOperateDIv();
			else
				window.close();
		}else if(type=='reload'){
			if(${sys_view_div})
				window.parent.location.reload(true);
				window.parent.closeOperateDIv();
		}
	}
	//新页面表现样式控制  	结束
	
	
</script>
<style type="text/css" title="currentStyle">
	@import "${sys_ctx }/plug-in/table-order/css/table.css";
</style>