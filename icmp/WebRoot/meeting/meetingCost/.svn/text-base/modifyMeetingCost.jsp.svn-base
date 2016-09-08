<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <title>会议费用修改 </title>
</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<%
	  String meetingName = new String(request.getParameter("meetingName").getBytes("ISO8859-1"),"UTF-8");
	  String meetingDetailId = new String(request.getParameter("meetingDetailId").getBytes("ISO8859-1"),"UTF-8");
    %>  
	<div id="basicform" class="contentwrapper">
		<form action="${sys_ctx }/meetingCost/meetingCostList.action" method="post" name="form" id="form">
		  <input type="hidden" name="meetingDetailCostVO.createUserID" id="createUserID" value="${sys_userSession.userID}"/>
          <div class="contenttitle2">
            <h5 class="fwb fl10">会议费用修改（只能输入整数；单位：人*天）</h5>
          </div>
          <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td class="tableaddtitle">会议名称 ： </td>
	          <td class="tableadd_data" colspan="3">
	            <input type="text" class="inputtran" name="meetingDetailCostVO.meetingDetailVO.meetingName" id="meetingName" value="<%=meetingName%>" disabled="disabled"/>
	            <input type="hidden" name="meetingDetailCostVO.meetingDetailVO.meetingName" id="meetingDetailId" value="<%=meetingDetailId%>" />
	          </td>
	        </tr>
	        <c:forEach items="${mcList}" var="meetingDetailCostVO" varStatus="state">
	        <tr>
	          <td class="tableaddtitle"><span>*</span>
	            <c:out value="${meetingDetailCostVO.costItem }" /> : 
	          </td>
	          <td class="tableadd_data" >
	            <input type="hidden" id="costItem${state.index+1}" name="meetingDetailCostVO.costItem" value="${meetingDetailCostVO.costItem }" />
	            <input type="hidden" id="costValue${state.index+1}" name="meetingDetailCostVO.costValue" value="${meetingDetailCostVO.costValue }"/>
	            <input type="text" class="inputtran" id="cout${state.index+1}" name="meetingDetailCostVO.cout" value="${meetingDetailCostVO.cout }"/>
	            <span id="checkSpan${state.index+1}" style="margin-right: 50px；font-weight:bold; color: red;"></span>
	            <!--  <span id="unit" style="margin-right: 50px"> （单位：个） </span>-->
	          </td>
	          <td class="tableaddtitle">
	            	费用（元/天） : 
	          </td>
	          <td class="tableadd_data" >
	            <input class="inputtran" disabled="disabled" value="${meetingDetailCostVO.costValue }"/>
	          </td>
	        </tr>
          </c:forEach>
          </table>
          <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="button" class="submit1 radius2" value="确 定" onclick="addMeetingCost();"/>
                  <input type="button" class="reset1 radius2" value="取 消" onclick="javascript:backHistory();"/>
                </td>
             </tr>
           </tbody>
      </table>
    </form>
  </div>
  <script>
    function addMeetingCost(){
    	var size = document.getElementsByName("meetingDetailCostVO.costItem").length;
		var costArr = new Array();
		for(var i=1;i<=size;i++){
			var costItem = document.getElementById("costItem"+i).value;
			var costValue = document.getElementById("costValue"+i).value;
			var cout = document.getElementById("cout"+i).value;
			
			if(!/^-?\d+$/.test(cout)){
				  document.getElementById("checkSpan"+i).innerHTML='请输入整数';
	    	      document.getElementById("cout"+i).value="";
	    	      document.getElementById("cout"+i).select();
	    	      return;
	    	}

	    	if(cout<0){
	    	     document.getElementById("checkSpan"+i).innerHTML='设置不能为负数';
	    	      document.getElementById("cout"+i).value="";
	    	      document.getElementById("cout"+i).select();
	    	      return;
	    	}
	    	if(!cout){
	    		document.getElementById("cout"+i).select();
	    		document.getElementById("checkSpan"+i).innerHTML='设置不能为空';
	    		return;
		    }

			var cost = costItem+":"+costValue+":"+cout;
			costArr.push(cost);
		}
		var meetingDetailId = document.getElementById("meetingDetailId").value;
		var createUserID = document.getElementById("createUserID").value;
    	DwrMethod.modifyMeetingCost(meetingDetailId,createUserID,costArr,callback);
    }
    function callback(result){
    	if(result){
			location.href = "${sys_ctx }/meetingCost/meetingCostList.action";
		}else{
			alert("修改失败!");
		}
    }

    $(":text").change(function(){
    	  if(!/^-?\d+$/.test(this.value)){
        	this.value="";
  			$(this).next().html("请输入整数");
  			this.focus();
    	  }else{
    		  $(this).next().html("");
          }
      })
      
     function backHistory(){
      	window.location.href="${sys_ctx }/meetingCost/meetingCostList.action";
    }
  </script>
</body>
</html>