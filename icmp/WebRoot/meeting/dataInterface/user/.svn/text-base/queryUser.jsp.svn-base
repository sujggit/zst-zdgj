<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <%@include file="/common/common.jsp"%>
	    <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DataInterfaceDwr.js'></script>
		<title>用户查询页面</title>
		<style type="text/css">
			#fullbg {background-color: #a6b7c8;/*#aadfe4*/display:none;z-index:3;position:absolute;
			    left:0px;top:0px;width:100%;height:100%;filter:Alpha(Opacity=30);/* IE */-moz-opacity:0.4;/* Moz + FF */opacity: 0.6;}
			.showWindow{background: #DCDCDC;border:2px solid #6A5AEB;position:absolute;z-index: 10;filter:Alpha(Opacity=70);/* IE */ -moz-opacity:0.7;/* Moz + FF */ opacity: 0.6;}
			.dialogDiv{background: no-repeat; width:399px; height:199px; border:0px; }
			.dialog_title{background: #6A5AEB; height: 20px; line-height: 20px;filter:Alpha(Opacity=80);}
			.fontone{padding-top:60px; font-size:24px; color:#a90d19; font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;}
			.fonttwo{text-align:right; padding-right:30px; color:414243; width:399px; font-size:18px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif;}
			.fonttwo a { text-decoration: none; color: #414243; outline: none; }
			.fonttwo a:hover { text-decoration: underline; color: #000000; outline: none; }
		</style>
		<script type="text/javascript">
		//显示灰色JS遮罩层 
		function showBg(ct,content){ 
		    var bH=$("body").height()+20; 
		    var bW=$("body").width()+16; 
		    var objWH=getObjWh(ct); 
		    $("#fullbg").css({display:"block"}); 
		    var tbT=objWH.split("|")[0]+"px"; 
		    var tbL=objWH.split("|")[1]+"px"; 
		    $("#"+ct).css({top:tbT,left:tbL,display:"block"}); 
		    $(window).scroll(function(){resetBg()}); 
		   	$(window).resize(function(){resetBg()}); 
		} 
		function getObjWh(obj){ 
		    var st=document.documentElement.scrollTop;//滚动条距顶部的距离 
		    var sl=document.documentElement.scrollLeft;//滚动条距左边的距离 
		    var ch=document.documentElement.clientHeight;//屏幕的高度 
		    var cw=document.documentElement.clientWidth;//屏幕的宽度 
		    var objH=$("#"+obj).height();//浮动对象的高度 
		    var objW=$("#"+obj).width();//浮动对象的宽度 
		    var objT=Number(st)+(Number(ch)-Number(objH))/2; 
		    var objL=Number(sl)+(Number(cw)-Number(objW))/2; 
		    return objT+"|"+objL; 
		} 

		function resetBg(){ 
		    var fullbg=$("#fullbg").css("display"); 
		    if(fullbg=="block"){ 
		        var bH2=$("body").height(); 
		        var bW2=$("body").width()+16; 
		        $("#fullbg").css({width:bW2,height:bH2}); 
		        var objV=getObjWh("dialog"); 
		        var tbT=objV.split("|")[0]+"px"; 
		        var tbL=objV.split("|")[1]+"px"; 
		        $("#dialog").css({top:tbT,left:tbL}); 
		    } 
		} 
		//关闭灰色JS遮罩层和操作窗口 
		function closeBg(){ 
		    $("#fullbg").css("display","none"); 
		    $("#showWindow").css("display","none"); 
		    $("#dialog").css("display","none"); 
		} 
			/**
			*	查看会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function userDetail(id){
				window.showModalDialog("${sys_ctx }/userInterface/detail.action?uiVO.userid="+id,window,'dialogWidth=600px;dialogHeight=470px;');
                 //window.location.href="${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id;
			}


			/**
			*	查看会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function userModify(id){
				window.location.href="${sys_ctx }/userInterface/beforeModify.action?uiVO.userid="+id;
				
			}

			/**
			*删除会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function userDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx }/userInterface/delete.action?uiVO.userid="+id;
			}
			/**
			*查询会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function userqeury(){
				document.pageform.currentPage.value=1;
				$('#pageform').validate({    
					  rules:{    
					   "uiVO.loginname" : {
					           minlength:1,
					           maxlength:25  
					       }
					    }
				    });
				$('#pageform').submit();
		    }

	      
	          function pageInit(){
				    var obj = new htmlUtil();
					obj.title("status","输选择");	
					obj.title("username","请输入长度不超过25个字符");	
				}
			
			function exportUser(){
				document.getElementById('pageform').action="${sys_ctx}/userInterface/exportQuery.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/userInterface/queryUser.action";
			}

			var type1 = "user";
			function importExcel(){
				
				var result = window.showModalDialog("${sys_ctx }/meeting/meetingRoom/importExcel.jsp",window,'dialogWidth=700px;dialogHeight=270px;');

				if( result == "1" ){
					window.location.reload();
				}
			}

			function dataImport(){
				if( confirm("同步操作会清空现有数据，同步新数据，请做好备份,是否确认继续?")){
					showBg('dialog','dialog_content');
					DataInterfaceDwr.userImport(
						function backa(){
							closeBg();
							window.location.reload();
						}
					);
				 
				}
		    }
		</script>
	</head>
	<body style=OVERFLOW:AUTO;OVERFLOW-X:HIDDEN onload="pageInit()">
		<form action="${sys_ctx}/userInterface/queryUser.action" id="pageform" name="pageform" method="post">
			<div id="basicform" class="contentwrapper">
			  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
                 <tr>
                   <td width="15%" class="tableaddtitle">用户名</td>
                   <td width="35%" class="tableadd_data" >
			         <input class="inputtran" title="" type="text" name="uiVO.loginname" id="username"  value="${uiVO.loginname}" />
				   </td>
                   <td width="15%" class="tableaddtitle">操作状态</td>
                   <td width="35%" class="tableadd_data">
                   <select  class="" name="uiVO.importstatus" id="status">
					   <zzst:option type="importStatus" value="${uiVO.importstatus}" required="false" />
				   </select></td>
                   <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="userqeury();" /></td>
                </tr>
             </table>
            
       <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_IMPORTEXCEL%>" style="cursor: pointer;" onclick="importExcel();"> 导入</a> <a class="funcOper <%= FuncEnum.FUNC_NO_DATAIMPORT%>" style="cursor: pointer;" onclick="dataImport();"> 数据同步</a> <a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportUser();"> 导出</a></h5>
      </div>
					
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="19%" class="head1">用户名</th>
            <th width="19%" class="head1">姓名</th>
			<th width="18%" class="head1">操作状态</th>
            <th width="20%" class="head1">描述</th>
            <th width="18%" class="head1">操作</th>
          </tr>
        </thead>
		  <tbody>
			<c:forEach items="${uiList}" var="uiVO" varStatus="state">
				<tr>
					<td class="alc">
						<c:out value="${state.index+1}"></c:out>
					</td>
					<td>
						<c:out value="${uiVO.loginname}" />
					</td>
					<td>
						<c:out value="${uiVO.fullname}" />
					</td>
					<td
						<c:if test="${uiVO.importstatus == 1}">style="color: green;"</c:if>	
						<c:if test="${uiVO.importstatus == 2}">style="color: red;"</c:if>
					>
						<zzst:lable type="importStatus" value="${uiVO.importstatus}"></zzst:lable>
					</td>
					<td>
						<c:out value="${uiVO.importdesc}" />
					</td>
					<td class="alc">
						<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:userDetail('${uiVO.userid}');"/>查看   
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:userModify('${uiVO.userid}');" />修改   
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:userDele('${uiVO.userid}');"/> 删除
					</td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		<jsp:include page="/common/pageFooter.jsp" />
		</div>
		<div id="fullbg"></div>
<!-- end JS遮罩层 -->
<!-- 对话框 -->
<div class="showWindow" style="display:none" id="dialog">
	<div  class="dialogDiv" id="dialog_content">
		<p class="dialog_title"></p>
		<p class="fontone">正在同步到数据库，请稍等...</p>
		<p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
		<p class="fonttwo"></p>
	</div>
</div>
	  </form>
	</body>
</html>
