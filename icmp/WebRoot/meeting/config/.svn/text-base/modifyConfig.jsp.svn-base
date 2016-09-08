<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
  <%@include file="/common/common.jsp"%>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<script type="text/javascript">
		function pageInit(){
	        var obj = new htmlUtil();
			//obj.title("qUERY_VIEW_START_HOUR","请输入0-24之间的整数");	
			//obj.title("qUERY_VIEW_END_HOUR","请输入0-24之间的整数");
			//obj.title("tASK_PERIOD_HOUR","请输入0-24之间的整数");
			obj.title("billboardTime","请输入0-180之间的整数");
		}
		
         function modifyconfig(){
	         var qUERY_VIEW_START_HOUR=document.getElementById("qUERY_VIEW_START_HOUR").value;
	         var qUERY_VIEW_END_HOUR=document.getElementById("qUERY_VIEW_END_HOUR").value;
	         var flag = (qUERY_VIEW_END_HOUR - qUERY_VIEW_START_HOUR<0); 
	         var flag1 = (qUERY_VIEW_END_HOUR == qUERY_VIEW_START_HOUR);
	         var pso_s=document.getElementById("pso_s");
	         if(flag||flag1) {
	         	pso_s.innerHTML="&nbsp;&nbsp;&nbsp;结束时间应晚于开始时间";
	         	//$(pso_s).attr("text","结束时间应大于开始时间");
	         }else{
	         	$('#modifyForm').validate({    
						rules:{   
						 "configVO.qUERY_VIEW_START_HOUR" : {
						           required:true,
						           digits:true,
						           range:[0,24]
						           },
						 "configVO.qUERY_VIEW_END_HOUR" : {
						           required:true,
						            digits:true,
						            range:[0,24]
						           },
						 "configVO.tASK_PERIOD_HOUR" : {
						           required:true,
						            digits:true,
						            range:[0,24]
						           },
						 "configVO.billboardTime" : {
						           required:true,
						            digits:true,
						            range:[0,180]
						           }
						}  
					  });
	          		 $("#modifyForm").submit();
	         		}
	         };
                  
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href = "${sys_ctx }/layout/inc1/welcom.jsp";
            };
			function clearSpan(){
				//alert($("#pso_s").text());
				$("#pso_s").text("");
			}
    </script>
  </head >
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();" >
	<div id="basicform" class="contentwrapper"> 
  	  <form action="/icmp/config/modifyConfig.action" id="modifyForm" name="modifyForm" method="post">
  	    
        <div class="contenttitle2">
          <h5 class="fwb fl10">系统配置</h5>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
          <tr>
            <td width="30%" class="tableaddtitle">会议室日历-开始时间</td>
            <td width="25%" class="tableadd_data" >
              <select name="configVO.qUERY_VIEW_START_HOUR" id="qUERY_VIEW_START_HOUR">
                <c:forEach var="i" begin="0" end="23" step="1">
                  <option value="${i }"<c:if test="${configVO.qUERY_VIEW_START_HOUR==i }">selected</c:if>>${i }</option>
                </c:forEach>
              </select>&nbsp;&nbsp;时
	         <!-- <input style="width: 92px;text-align: center" name="configVO.qUERY_VIEW_START_HOUR" class="inputtran" id="qUERY_VIEW_START_HOUR" value="${configVO.qUERY_VIEW_START_HOUR }"/>点
	        -->
           </td>
           <td width="30%" class="tableaddtitle">会议室日历-结束时间</td>
           <td width="25%" class="tableadd_data">
             <select name="configVO.qUERY_VIEW_END_HOUR" id="qUERY_VIEW_END_HOUR">
               <c:forEach var="i" begin="0" end="23" step="1">
                 <option value="${i }"<c:if test="${configVO.qUERY_VIEW_END_HOUR==i }">selected</c:if>>${i }</option>
               </c:forEach>
             </select>&nbsp;&nbsp;时
	          <!--  <input style="width: 92px;text-align: center" name="configVO.qUERY_VIEW_END_HOUR" class="inputtran" id="qUERY_VIEW_END_HOUR" value="${configVO.qUERY_VIEW_END_HOUR }" onfocus="javascript:clearSpan();"/>点-->
	         <span id="pso_s" style="color:red"></span>
           </td>
         </tr>
         <tr>
            <td class="tableaddtitle">内务处理时间</td>
            <td class="tableadd_data" >
              <select name="configVO.tASK_PERIOD_HOUR" id="tASK_PERIOD_HOUR">
                <c:forEach var="i" begin="0" end="23" step="1">
                  <option value="${i }"<c:if test="${configVO.tASK_PERIOD_HOUR==i }">selected</c:if>>${i }</option>
                </c:forEach>
              </select>&nbsp;&nbsp;时
	          <!-- <input  style="width: 92px;text-align: center" name="configVO.tASK_PERIOD_HOUR" class="inputtran"  id="tASK_PERIOD_HOUR" value="${configVO.tASK_PERIOD_HOUR }"/>点-->
            </td>
           <td class="tableaddtitle">告示提前时间</td>
            <td class="tableadd_data" >
           	  <input name="configVO.billboardTime" class="" value="${configVO.billboardTime }" type="text" id="billboardTime" size=5/>
           	  <span>分钟</span>
          </td>
            
        </tr>

        <tr>
          <td class="tableaddtitle">通知配置</td>
          <td class="tableadd_data" >
           	<span> <input name="configVO.email" class="" value="true" type="checkbox" <c:if test="${configVO.email == true }">checked</c:if>  />邮件</span>
           	<span><input name="configVO.sms" class="" value="true" type="checkbox" <c:if test="${configVO.sms == true }">checked</c:if> />短信</span>
           	<span><input name="configVO.billboard" class="" value="true" type="checkbox" <c:if test="${configVO.billboard == true }">checked</c:if> />告示</span>
          </td>
          <td class="tableaddtitle">会议服务</td>
          <td class="tableadd_data">
           	<span> <input name="configVO.meetingbook_service" class="" value="true" type="checkbox" <c:if test="${configVO.meetingbook_service == true }">checked</c:if> />会议服务等级</span>
           	<span> <input name="configVO.record" class="" value="true" type="checkbox" <c:if test="${configVO.record == true }">checked</c:if> />录播</span>
          </td>
        </tr>
        <tr>
        <td class="tableaddtitle">调试会议持续时间</td>
            <td class="tableadd_data">
           	  <select class="select200 fontstyle"  name="configVO.meetingDebugDuration" id="meetingDebugDuration">
	  			  <zzst:option type="meetingDebugDuration" value="${configVO.meetingDebugDuration}" />
    			</select> 
          </td>
           <td class="tableaddtitle">开启日志</td>
            <td class="tableadd_data" >
           	  <input name="configVO.ifOpenLog" class="" value="true" type="checkbox" <c:if test="${configVO.ifOpenLog == true }">checked</c:if> />
          </td>
        </tr>
        <tr>        
        <td class="tableaddtitle">呼入会场时静音</td>
            <td class="tableadd_data" colspan="3">
           	  <input name="configVO.autoMute" class="" value="1" type="checkbox" <c:if test="${configVO.autoMute == 1 }">checked</c:if> />
            </td>
            </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td >
              <input type="button" class="submit1 radius2" value="确 定" onclick="modifyconfig()"/>
            </td>
          </tr>
        </tbody>
      </table>
      <div style="height:200px;"></div>
    
  </form>
  </div>
</body>
</html>