<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zzst.model.enums.FuncEnum"%>
<%@page import="com.zzst.action.meeting.util.task.DateConnection"%>
<style>
	a.funcOper{display:none}
	.stdtable tbody td.alc a{background:url(../images/line.jpg) no-repeat right;padding-right:3px;margin-left:3px;}
	.stdtable tbody td.alc a.endLine{background:none}
	div.contenttitle2 h5.fwb a{background:url(../images/line.jpg) no-repeat right;padding-right:3px;margin-left:3px}
	div.contenttitle2 h5.fwb a.endLine{background:none}
</style>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/UserAction.js'></script>
<script type="text/javascript" charset="utf-8">
<%
String funcId = request.getAttribute("funcId").toString();
out.print("var funcId = '"+funcId+"';");
StringBuffer dbBakAllow = new StringBuffer();
dbBakAllow.append(",");
if(DateConnection.isBak){//当前为备份数据库
	dbBakAllow.append(FuncEnum.FUNC_NO_QUERY);
	dbBakAllow.append(","+FuncEnum.FUNC_NO_DETAIL);
	dbBakAllow.append(","+FuncEnum.FUNC_NO_EXPORT);
}
dbBakAllow.append(",");
out.print("var dbBakAllow = '"+dbBakAllow+"';");
%>
	var func_oper_List; 
	$(document).ready(function(){
		//前端分页
		$('#query_table2').dataTable({
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

		
		
		getPowerOper();
		clickSelect();
		clickSpan();
		
	})
	
	//每次点击上一页，下一页触发的函数
	function clickSelect(){
		$("#query_table2_length label select").bind("click",function(){//点击分页选择的时候触发
			//getFuncOper(func_oper_List);
			getPowerOper();
			clickSpan();
		})
	}
	function clickSpan(){
		$("#query_table2_paginate span").bind("click",function(){//每次点击上一页，下一页触发的函数
			getPowerOper();
			//getFuncOper(func_oper_List);
			clickSpan();
		});
	}
	
	//获取页面有权限的操作按钮
	function getPowerOper(){
		var funcIds = funcId.split(";");
		for(var i=0;i<funcIds.length;i++){
			if(funcIds[i]){
				var funcNos = $("."+funcIds[i]);
				for(var j=0;j<funcNos.length;j++){
					if(dbBakAllow.length>2&&dbBakAllow.indexOf(","+funcNo+",")<0){
						continue;
					}
					$(funcNos[j]).removeClass("funcOper");
				}
			}
		}

		//20140819将当前用户没有权限的操作功能从页面移除 
		var noPowerFuncs = $(".funcOper");
		for(var m=0;m<noPowerFuncs.length;m++){
			$(noPowerFuncs[m]).remove();
		}
		if($("div.contenttitle2 h5.fwb a")){//’导出新增‘栏
			$("div.contenttitle2 h5.fwb a").last().attr("class","endLine");
   		}
   		var funcOperAreas = $(".stdtable tbody td.alc");//'操作'栏
		if(funcOperAreas&&funcOperAreas.length>0){
   			for(var n=0;n<funcOperAreas.length;n++){
				$(funcOperAreas[n]).children().last().attr("class","endLine");
	   		}
   		}
		/**
		//var funcId = parent.frames["currentFrame"].document.getElementById("funcId").value;
		var funcIds = funcId.split(";");
		var flag = false;
		for(var i=0;i<funcIds.length;i++){
			UserAction.getFunTreeByID(funcIds[i],function(list){
				if(list&&list.length>0){
					func_oper_List = list;
					getFuncOper(func_oper_List);
					flag = true;
				}else{
					func_oper_List = "";
					//alert("用户信息失效，请重新登录！");
					//window.parent.location.href = "${sys_ctx }/user/userExit.action";
				}
		    });	
		    if(flag){
				continue;
			}
		}
		*/
	}

	//通过当前功能的funcNo（子操作功能）的集合，将当前用户没有权限的操作功能从页面移除 
	function getFuncOper(list){
		if(func_oper_List){
			for(var i=0;i<list.length;i++){
				var funcNo = list[i].funcNo;
				if(!funcNo){
					break;
				}
				var funcNos = $("."+funcNo);
				for(var j=0;j<funcNos.length;j++){
					if(dbBakAllow.length>2&&dbBakAllow.indexOf(","+funcNo+",")<0){
						continue;
					}
					$(funcNos[j]).removeClass("funcOper");
				}
			}
			var noPowerFuncs = $(".funcOper");
			for(var m=0;m<noPowerFuncs.length;m++){
				$(noPowerFuncs[m]).remove();
			}
			if($("div.contenttitle2 h5.fwb a")){//’导出新增‘栏
				$("div.contenttitle2 h5.fwb a").last().attr("class","endLine");
	   		}
	   		var funcOperAreas = $(".stdtable tbody td.alc");//'操作'栏
				if(funcOperAreas&&funcOperAreas.length>0){
	   			for(var n=0;n<funcOperAreas.length;n++){
					$(funcOperAreas[n]).children().last().attr("class","endLine");
		   		}
	   		}
		}
	}
</script>
