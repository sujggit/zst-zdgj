<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>会议调试通知 </title>
		<script type="text/javascript">
		
	
		
		//add by yangyi
		function pageInit(){
			    var obj = new htmlUtil();
				obj.title("debugTime","选择调试时间");	
				obj.title("noticeTime","选择通知时间");	
			}
			
			//modify by yangyi
			function add(){
			
					$('#form').validate({    
					rules:{ 
								"meetingDetailVO.meetingDebugVO.debugStartTime":{
									required: true
					           		},
								"meetingDetailVO.meetingDebugVO.noticeTime":{
									required: true
								
					           		}
								
						  	}
						});
					var email = document.getElementById("email").checked;
					var sms = document.getElementById("sms").checked;
					if(!email&&!sms){
						alert("请选择通知方式");
						return;
					}else{
						if(email&&!sms){
						document.getElementById("notice").value = "01";
						}else if(sms&&!email){
						document.getElementById("notice").value = "10";
						}else{
						document.getElementById("notice").value = "11";
						}
					}
					$("#form").submit();
					if($('#form').valid()){
					window.opener.location.reload();
					window.close();
					}
				}
			
			function cancle(){
				window.close();
			}	
		
			</script>

</head>
	<body  onload="pageInit();">
	
		<form action="${sys_ctx }/detail/addMeetingDebugNotice.action" 	method="post" name="form" id="form">
			<input type="hidden" value="${meetingDetailVO.meetingDetailID }" name="meetingDetailVO.meetingDebugVO.meetingDetailId"/>
	 <div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">会议调试通知</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td  class="tableaddtitle">会议名称</td>
          <td  class="tableadd_data"><input id="meetingName" type="text" class="inputtran"  value="${meetingDetailVO.meetingName }" readonly="readonly"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>调试时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" id="debugTime" name="meetingDetailVO.meetingDebugVO.debugStartTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingDetailVO.meetingDebugVO.debugStartTime}"  pattern="yyyy-MM-dd HH:mm"/>'/></td>
         </tr>
         <tr>
          <td class="tableaddtitle"><span>*</span>通知方式</td>
          <td class="tableadd_data">
          	<span <c:if test="${email != true }">style="display:none"</c:if>><input type="checkbox" id="email" <c:if test="${meetingDetailVO.meetingDebugVO.noticeType == '11'or meetingDetailVO.meetingDebugVO.noticeType == '01' }">checked disabled</c:if> />邮件</span>
          	<span <c:if test="${sms != true }">style="display:none"</c:if>><input type="checkbox" id="sms" <c:if test="${meetingDetailVO.meetingDebugVO.noticeType == '11'or meetingDetailVO.meetingDebugVO.noticeType == '10' }">checked disabled</c:if> />短信</span>
          	<input type="hidden" value="00" id="notice" name="meetingDetailVO.meetingDebugVO.noticeType"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>通知时间</td>
          <td class="tableadd_data" >
          <img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" id="noticeTime" name="meetingDetailVO.meetingDebugVO.noticeTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingDetailVO.meetingDebugVO.noticeTime}"  pattern="yyyy-MM-dd HH:mm"/>'/>
          </td>
          
        </tr>
        
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2" value="确 定" onclick="add();"/>
              
              <input type="button" class="reset1 radius2" value="取 消" onclick="cancle()"/>
              </td>
          </tr>
        </tbody>
      </table>
      
      <!--contenttitle--> 
     </div>
  </form>
 
  
</body>

</html>