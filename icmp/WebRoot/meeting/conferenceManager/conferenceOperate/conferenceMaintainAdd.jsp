<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <title>添加会议记录 </title>
  <script type="text/javascript">
  
  		/**
		*	设置页面参数
		*@return	null	
		*/
        function pageInit(){
		    var obj = new htmlUtil();
			obj.title("description","不超过500个字符");	
		}
			
		function add(){
			$('#form').validate({    
				rules:{
					"meetingDetailVO.description":{
						required: true,
						minlength:1,
		           		maxlength:500
		           	}
			  	}
			});
			$("#form").submit();
		}
		
		function backHistory(){
           	window.location.href="${sys_ctx}/detail/queryLocalConference.action";
        }
  </script>
</head>
<body onload="pageInit(); " >
  <div id="basicform" class="contentwrapper">
    <form action="${sys_ctx }/meetingRoomMaintain/addConferenceMaintain.action" 	method="post" name="form" id="form">
	  <input type="hidden" name="meetingRoomMaintainVO.maintainKey" value="${meetingDetailVO.meetingDetailID }">
      <div class="contenttitle2">
        <h5 class="fwb fl10">会议记录</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" >${meetingDetailVO.meetingName }</td>
          <td width="15%" class="tableaddtitle">记录人</td>
          <td width="35%" class="tableadd_data">${user.name }</td>
        </tr>
        <tr>
          <td class="tableaddtitle">开始实际</td>
          <td class="tableadd_data" ><fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
          <td class="tableaddtitle">结束实际</td>
          <td class="tableadd_data"><fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
         <tr>
          <td class="tableaddtitle"><span>*</span>记录内容</td>
          <td colspan="3" class="tableadd_data" >
	          <textarea name="meetingRoomMaintainVO.description" rows="10" class="areatran" id="description" onclick="javascript:$('#viewInfo').html('')">${meetingRoomMaintainVO.description }</textarea>
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td class="tableaddtitle">
              <span id="viewInfo">${info }</span>&nbsp;&nbsp;&nbsp;<input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="返 回" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>