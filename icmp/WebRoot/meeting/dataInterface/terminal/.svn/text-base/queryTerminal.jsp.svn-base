<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <%@include file="/common/common.jsp"%>
	    <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DataInterfaceDwr.js'></script>
		<title>设备接口页面</title>
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
			function equipmentDetail(id,type){
				if( type == 0 ){
					window.showModalDialog("${sys_ctx }/equipmentInterface/detailTerminal.action?difVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
				}
				else if( type == 1 ){
					window.showModalDialog("${sys_ctx }/equipmentInterface/detailMcu.action?difVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
				}
				else if( type == 2 ){
					window.showModalDialog("${sys_ctx }/equipmentInterface/detailCenterControl.action?difVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
				}
				else if( type == 7 ){
					window.showModalDialog("${sys_ctx }/equipmentInterface/detailVideoCard.action?difVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
				}
				else if( type == 8 ){
					window.showModalDialog("${sys_ctx }/equipmentInterface/detailOtherEquipment.action?difVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
				}else{
					window.showModalDialog("${sys_ctx }/equipmentInterface/detailOtherEquipment.action?difVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
				}
				
			}


			/**
			*	查看会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function terminalModify(id){
				window.location.href="${sys_ctx }/terminalInterface/beforeModify.action?tifVO.equipmentID="+id;
				
			}

			/**
			*删除会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx }/equipmentInterface/delete.action?difVO.equipmentID="+id;
			}
			/**
			*查询会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentQeury(){
				document.pageform.currentPage.value=1;
				$('#pageform').validate({    
					  rules:{    
					   "difVO.equipmentNO" : {
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
					obj.title("equipmentNO","请输入长度不超过25个字符");	
				}
			
			function exportEquipment(){
				document.getElementById('pageform').action="${sys_ctx}/equipmentInterface/exportQuery.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/equipmentInterface/queryEquipment.action";
			}


			var type1 = "terminal";
			function importExcel(){
				
				var result = window.showModalDialog("${sys_ctx }/meeting/meetingRoom/importExcel.jsp",window,'dialogWidth=700px;dialogHeight=270px;');

				if( result == "1" ){
					window.location.reload();
				}
			}

			function dataImport(){
				showBg('dialog','dialog_content');
				DataInterfaceDwr.equipmentImport(
					function backa(result){
						closeBg();
						window.location.reload();
					}
				);
		    }
		</script>
	</head>
	<body style=OVERFLOW:AUTO;OVERFLOW-X:HIDDEN onload="pageInit()">
		<form action="${sys_ctx}/equipmentInterface/queryEquipment.action" id="pageform" name="pageform" method="post">
			<div id="basicform" class="contentwrapper">
			  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
                 <tr>
                   <td width="15%" class="tableaddtitle">设备名称</td>
                   <td width="35%" class="tableadd_data" >
			         <input class="inputtran" title="请输入会议室关键字" type="text" name="difVO.equipmentNO" id="equipmentNO"  value="${difVO.equipmentNO}" />
				   </td>
                   <td width="15%" class="tableaddtitle">操作状态</td>
                   <td width="35%" class="tableadd_data">
                   <select  class="" name="difVO.status" id="status">
					   <zzst:option type="importStatus" value="${difVO.status}" required="false" />
				   </select></td>
                   <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="equipmentQeury();" /></td>
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
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_IMPORTEXCEL%>" style="cursor: pointer;" onclick="importExcel();"> 导入</a> <a class="funcOper <%= FuncEnum.FUNC_NO_DATAIMPORT%>" style="cursor: pointer;" onclick="dataImport();"> 数据同步</a> <a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportEquipment();"> 导出</a></h5>
      </div>
					
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table" style="table-layout: fixed">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="10%" class="head1">设备名称</th>
            <th width="10%" class="head1">设备类型</th>
            <th width="8%" class="head1">设备IP</th>
            <th width="10%" class="head1">所属会议室编号</th>
            <th width="10%" class="head1">管理员</th>
            <th width="10%" class="head1">序列号</th>
            <th width="9%" class="head1">操作状态</th>
            <th width="10%" class="head1">描述</th>
            <th width="18%" class="head1">操作</th>
          </tr>
        </thead>
		  <tbody>
			<c:forEach items="${difList}" var="equipmentInterfaceVO" varStatus="state">
				<tr>
					<td class="alc">
						<c:out value="${state.index+1}"></c:out>
					</td>
					<td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentInterfaceVO.equipmentNO }">
						<c:out value="${equipmentInterfaceVO.equipmentNO}" />
					</td>
					<td>
						<zzst:lable type="equipmentType" value="${equipmentInterfaceVO.equipmentType}">
						</zzst:lable>
					</td>
					<td>
						<c:out value="${equipmentInterfaceVO.ip}" />
					</td>
					<td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentInterfaceVO.roomNO}">
						<c:out value="${equipmentInterfaceVO.roomNO}" />
					</td>
					<td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentInterfaceVO.adminName}">
						<c:out value="${equipmentInterfaceVO.adminName}" />
					</td>
					<td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentInterfaceVO.serialNumber}">
						<c:out value="${equipmentInterfaceVO.serialNumber}" />
					</td>
					<td
						<c:if test="${equipmentInterfaceVO.status == 1}">style="color: green;"</c:if>	
						<c:if test="${equipmentInterfaceVO.status == 2}">style="color: red;"</c:if>
					>
						<zzst:lable type="importStatus" value="${equipmentInterfaceVO.status}"></zzst:lable>
					</td>
					<td class="center" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${equipmentInterfaceVO.description}">
						<c:out value="${equipmentInterfaceVO.description}" />
					</td>
					<td class="alc">
						<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:equipmentDetail('${equipmentInterfaceVO.equipmentID}','${equipmentInterfaceVO.equipmentType }');"/>查看   
						<!--<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:terminalModify('${terminalInterfaceVO.equipmentID}');" />修改 | --> 
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:equipmentDele('${equipmentInterfaceVO.equipmentID}');"/> 删除
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
