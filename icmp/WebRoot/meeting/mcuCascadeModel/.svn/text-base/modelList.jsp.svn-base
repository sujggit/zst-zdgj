<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<title>会议模式管理页面</title>
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
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
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
		function synchroMCUMode(){
			showBg('dialog','dialog_content');
			McuDwrMethod.synchroMCUmode(backInfo);
		} 
		function backInfo(para){
			info = para;
			closeBg();
			setTimeout("infoBack()",100);
		}  
		function infoBack(){
			alert(info);
		} 

		//add by yangyi	
		function addmode(){
			window.location.href="${sys_ctx}/mcuCascadeModel/add.action";

		}         
	       /**
	       *选择会议室
	       */
          
          function selectConference(thisDom){
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
                  selectType:'radio'
              }
             creatConferenceSelect(thisDom,conferenceParameters); 
          }
          function getReturnConferenceMethod(conferenceArray){
              //alert(userArray);
            //  alert(conferenceArray[0].conferenceID);
            //  alert(conferenceArray[0].conferenceName+"//"+conferenceArray[0].conferenceName);
                  var meetingRoomID="";
	              var meetingRoomName="";
	              var conferenceLength = conferenceArray.length;
	              for(var i=0;i<conferenceLength;i++){
	            	  meetingRoomID=conferenceArray[i].conferenceID;
	            	  meetingRoomName=conferenceArray[i].conferenceName;
	              }
	          	$("#meetingRoomID").attr("value",meetingRoomID);
               	$("#meetingRoomName").attr("value",meetingRoomName);
              
          }
			/**
			*	查看设备管理详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDetail(id,id2){
			  if(id2==1){
				window.showModalDialog("${sys_ctx}/equipment/mcuDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
			 }else if(id2==0){
				window.showModalDialog("${sys_ctx}/equipment/terminalDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
			}else if(id2==2){
				window.showModalDialog("${sys_ctx}/equipment/controlDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
			}else if(id2==4){
				window.showModalDialog("${sys_ctx}/equipment/noticeDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
			}else if(id2==5){
				window.showModalDialog("${sys_ctx}/equipment/QBoxDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
			}
          }
			/**
			*	添加设备管理
			*@param		null
			*@param		null
			*/
			function addMeetingRoom(){
				 window.location.href="${sys_ctx}/equipment/add.action";
			}

			/**
			*	修改设备管理信息
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentModify(id,id2){
			   if(id2==1){
				   window.location.href="${sys_ctx}/equipment/mcuBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==0){
				   window.location.href="${sys_ctx}/equipment/terminalBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==2){
				   window.location.href="${sys_ctx}/equipment/controlBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==4){
					window.location.href="${sys_ctx}/equipment/noticeBeforeModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==5){
					window.location.href="${sys_ctx}/equipment/QBoxBeforeModify.action?equipmentVO.equipmentID="+id;
				}
			}

			/**
			*删除设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function modeDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/mcuCascadeModel/delete.action?mcuCascadeModelVO.cascadeID="+id;
			}
			

            function pageInit(){
			    var obj = new htmlUtil();
				//obj.title("equipmentType","请选择");	
				obj.title("meetingRoomName","请输入");	
			}
	
			/**
			*导出 
			*@param		${String}	id
			*@return	null	
			*/
			function exportEquipment(){
			 var description=$("#description").val();
			var cascadeName=$("#cascadeName").val();
			  document.getElementById('pageform').action="${sys_ctx}/mcuCascadeModel/McuCascadeModelexportQuery.action";
			  document.getElementById('pageform').submit();
			  document.getElementById('pageform').action="${sys_ctx}/mcuCascadeModel/query.action";
				}
		</script>
	</head>
<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx}/mcuCascadeModel/query.action" id="pageform" name="pageform" method="post">
 
    
    <!--pageheader-->
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">主MCU</td>
          <td width="35%" class="tableadd_data" >
          <select name="mcuCascadeModelVO.description" id="description" title="请选择"  class="select200 fontstyle" style="cursor:pointer" >
				            	  <option value="">请选择...</option>
				            	  <c:forEach items="${equipmentVOList}" var="equipmentVO" 	varStatus="state"> 
				            	  <option value="${equipmentVO.equipmentID }" ${mcuCascadeModelVO.description == equipmentVO.equipmentID? "selected" : "" }>
									${equipmentVO.equipmentNO }
								  </option>
				            	   </c:forEach>
		</select>
							    </td>
          <td width="15%" class="tableaddtitle">会议模式</td>
          <td width="35%" class="tableadd_data"><input type="text" name="mcuCascadeModelVO.cascadeName" id=cascadeName class="inputtran" value="${mcuCascadeModelVO.cascadeName }"  /></td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" onclick="queryForm();"  value="查 询" /></td>
        </tr>
      </table>
      
      
      <!--contenttitle--> 
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />         
        </a>
        </div>
      
    </div>
    
    
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_SYNCHROMCUMODE%>" onclick="synchroMCUMode();">同步MCU模板 </a>  <a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" onclick="addmode();">增加 </a>  <a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" onclick="exportEquipment();">导出</a></h5>
      </div>
     
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table" style="table-layout: fixed">
        <thead>
          <tr>
            <th width="7%" class="head1">序号</th>
            <th width="20%" class="head1">会议模式</th>
            <th width="20%" class="head1">主MCU名称</th>
            <th width="20%" class="head1">MCU名称</th>
            <th width="20%" class="head1">MCU模板</th>
            <%--<th width="10%" class="head1">创建人</th>--%>
          
            <th width="13%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
        <c:forEach items="${mcuCascadeModelVOList}" var="mcuCascadeModelVO" 	varStatus="state">
          <tr >
            <td class="alc"><c:out value="${state.index+1}"></c:out></td>
            <input type="hidden"  value="${mcuCascadeModelVO.cascadeID } "/>
            <td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${mcuCascadeModelVO.cascadeName}">${mcuCascadeModelVO.cascadeName}</td>
            <td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${mcuCascadeModelVO.equipmentNO}">${mcuCascadeModelVO.equipmentNO}</td>
            <td class="center" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${mcuCascadeModelVO.mcuName}">${mcuCascadeModelVO.mcuName}</td>
            <td style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${mcuCascadeModelVO.modelName}">${mcuCascadeModelVO.modelName}</td>
            <%--<td><c:out value="${mcuCascadeModelVO.createUserID}"/></td>--%>
          
            <td class="alc">
            	<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" style="font-family: Microsoft Yahei, Arial, Helvetica, sans-serif;font-size: 14px" title="查看会议模式" onclick="javascript:meetingRoomDetail('${mcuCascadeModelVO.cascadeID}');">查看</a>
            	  <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" style="font-family: Microsoft Yahei, Arial, Helvetica, sans-serif;font-size: 14px" title="删除会议模式" onclick="javascript:mcuCascadeDelete('${mcuCascadeModelVO.cascadeID}');">删除</a>
            </td>
          </tr>
          </c:forEach>
         
          <script type="text/javascript">
              function meetingRoomDetail(id){				
				window.showModalDialog("${sys_ctx}/mcuCascadeModel/mcuCascadeDetail.action?mcuCascadeModelVO.cascadeID="+id,window,'dialogWidth=600px;dialogHeight=400px;');

				}
              function mcuCascadeDelete(id){	
            	  if(!confirm("确定要删除吗？")){
      				return;
      			  }	
      			  location.href="${sys_ctx}/mcuCascadeModel/delete.action?mcuCascadeModelVO.cascadeID="+id;
		
  			  }
      </script>      
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    </div>
    <!--contentwrapper--> 
  
<div id="fullbg"></div>
<!-- end JS遮罩层 -->
<!-- 对话框 -->
<div class="showWindow" style="display:none" id="dialog">
	<div  class="dialogDiv" id="dialog_content">
		<p class="dialog_title"></p>
		<p class="fontone">正在同步MCU模板，请稍等...</p>
		<p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
		<p class="fonttwo"></p>
	</div>
</div>

</form>
</body>
</html>