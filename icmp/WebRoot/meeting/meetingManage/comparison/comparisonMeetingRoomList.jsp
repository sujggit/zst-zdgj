<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
<link rel="stylesheet" type="text/css" href="${sys_ctx}/meeting/meetingManage/comparison/css/comparisonCss.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>会议比对列表</title>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
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
		 function modify(id){
  location.href="${sys_ctx}/videoCardCompare/singleCompareCriteria.action?comparisonReferenceVO.ID="+id;
  }	
  
  
  function singleCompareadd(){
  window.location.href="${sys_ctx}/meeting/meetingManage/singleComparisonCriteriaAdd.jsp";
  
  }
  
  
   function equipmentdel(ID){
  
	if(!window.confirm("是否确认删除？")) return;
  window.location.href="${sys_ctx}/videoCardCompare/SingleCompareCriteriaDel.action?comparisonReferenceVO.ID="+ID;
  
  }
  function Qeury(){
  $("#pageform").submit();
  }
//跳转到未标定页
  function queryUnReferenced(){
	  //alert(111);
	  //window.location.href="${sys_ctx}/videoCardCompare/queryUnReferencedMeeting.action";
	  
	  //window.location.href="${sys_ctx}/videoCardCompare/queryUnReferencedMeeting.action"

	  window.showModalDialog("${sys_ctx}/videoCardCompare/queryUnReferencedMeeting.action",window,'dialogWidth=1000px;dialogHeight=470px;');
		  }


//标定
  function getReferenceRGB(meetingRoomID){
	  showBg('dialog','dialog_content');
 VideoCardDwrMethod.setStandardRGB(meetingRoomID,refback);
	
	
	
  }


function refback(flag){
	closeBg();
	if(flag=='true'){
		//alert(flag);
		alert("标定成功！");
		}else{
			//alert(flag);
			alert("标定失败！");
			}
		
	
}

  


  function toView(meetingRoomID,meetingRoomName){
	 
      
	  window.showModalDialog("${sys_ctx}/meeting/meetingManage/viewCompare/referenceCompareView.jsp?meetingRoomName="+meetingRoomName+"&meetingRoomNo="+meetingRoomID,window,'dialogWidth=1000px;dialogHeight=470px;');
		  }

  function test(vip){
	  alert(vip);
	  VideoCardDwrMethod.getCompareRGB(vip);
	  }




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
  
     </script>  
     
</head>
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
   
    <form action="/icmp/videoCardCompare/queryCompareMeeting.action" method="post" name="pageform" id="pageform">
    
    
    <div id="contentwrapper" class="contentwrapper">
      <!--contenttitle-->
		<div class="contenttitle2">
			<h5 class="fwb fl10">查询列表</h5>
		</div>
      	<div class="contentwrapper" >           
                    <span style=" float:right;margin:0;padding:0" class="comparison">
                    	<a class="funcOper <%= FuncEnum.FUNC_NO_QUERYUNREFERENCED%>" onclick="queryUnReferenced();"><span class="comparison_1">未标定</span><img src="${sys_ctx}/images/image/comparison_1.png" />${unReferencedRoomCount}个</a>
                        <a class="funcOper <%= FuncEnum.FUNC_NO_QUERYREFERENCED%>" href="#"><span class="comparison_2">已标定</span><img src="${sys_ctx}/images/image/comparison_2.png" />${referencedRoomCount }个</a>
                    	<!--span class="in" onclick="drag1.init().move('drag1')" /><input type="reset" value="未标定会场" style="width:80px;height:50px" /></span>
                    	
						<span class="in" onclick="drag2.init().move('drag2')" /><input type="reset" value="6个已标定会场" /></span-->	
                    </span>
		</div>
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="26%" class="head1">会场名称</th>
            <th width="26%" class="head1">比对卡ip</th>
            <th width="20%" class="head1">终端ip</th>
            <th width="20%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${comparisonReferenceVOList}" var="comparisonReferenceVO" varStatus="status">
				        <tr>
				          	<td class="alc"><c:out value="${status.index+1}"></c:out></td>
				          	<td>
				          		<c:out value="${comparisonReferenceVO.meetingRoomName}" />
				               <input type="hidden" value="${comparisonReferenceVO.meetingRoomID}"/>
				          	</td>
				          	<%--<td class="center">
				          		<c:out value="${meetingDetailVO.meetingName}" />
				          	</td>--%>
				          	<td>
				          		<c:out value="${comparisonReferenceVO.videoCardIp}" />
				
				          	</td>
				          	<td>
				          		<c:out value="${comparisonReferenceVO.terminalIp}" />
				
				          	</td>
				          	<td class="alc">
				          <a class="funcOper <%= FuncEnum.FUNC_NO_REFERENCERGB%>" style="cursor: pointer;" onclick="getReferenceRGB('${comparisonReferenceVO.meetingRoomID}')">重新标定</a> <a class="funcOper <%= FuncEnum.FUNC_NO_TOVIEW%>" onclick="toView('${comparisonReferenceVO.meetingRoomID}','${comparisonReferenceVO.meetingRoomName}')">直方图</a> 
				          <a class="funcOper <%= FuncEnum.FUNC_NO_TEST%>" onclick="test('${comparisonReferenceVO.videoCardIp}')">测试</a>
				          	</td>
				          

				          
				        </tr>
			</c:forEach>
         
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    </div>
    
    <div id="fullbg"></div>
<!-- end JS遮罩层 -->
<!-- 对话框 -->
<div class="showWindow" style="display:none" id="dialog">
	<div  class="dialogDiv" id="dialog_content">
		<p class="dialog_title"></p>
		<p class="fontone">比对卡标定中，可能需要几秒，请稍等...</p>
		<p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
		<p class="fonttwo"></p>
	</div>
	</div>
   </form>
  </body>
</html>
