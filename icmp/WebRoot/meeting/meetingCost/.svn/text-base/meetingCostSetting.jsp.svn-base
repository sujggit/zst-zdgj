<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<%@include file="/common/common.jsp" %>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<title>会议费用设置 </title>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
	  <form action="${sys_ctx }/meetingCost/meetingCostSetting.action" 	method="post" name="form" id="form">
        <div class="contenttitle2">
        	<h5 class="fwb fl10">会议费用设置（只能输入整数；负数代表节省的费用；单位：元/天）</h5>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
      	  <c:forEach items="${costList}" var="dictionaryVO" varStatus="state">
	        <tr>
	          <td width="30%" class="tableaddtitle"><span>*</span>
	            <c:out value="${dictionaryVO.dicViewName }" />
	          </td>
	          <td width="70%" class="tableadd_data" >
	            <input type="hidden" id="dicViewName${state.index+1}" value="${dictionaryVO.dicViewName }" />
	            <input type="text" class="inputtran" id="dicValue${state.index+1}" name="dictionaryVO.dicValue" value="${dictionaryVO.dicValue }" />
	          	<span id="checkSpan${state.index+1}" style="margin-right: 50px；font-weight:bold; color: red;"></span>
	          	<!--  <span id="unit" style="margin-right: 50px"> （单位：元） </span>-->
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
                <span style="font-size:14px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; color: red;margin-right: 8px" id="resultSpan"></span>
                <input type="button" class="submit1 radius2" value="确 定" onclick="meetingCostSetting();"/>
                <input type="button" class="reset1 radius2" value="取 消" onclick="javascript:backHistory();"/>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
    <script>
      function backHistory(){
    	window.location.href = "${sys_ctx }/layout/inc1/welcom.jsp";
      }
    
      function meetingCostSetting(){
		var size = document.getElementsByName("dictionaryVO.dicValue").length;
		var costArr = new Array();
		for(var i=1;i<=size;i++){
			var dicViewName = document.getElementById("dicViewName"+i).value;
			var dicValue = document.getElementById("dicValue"+i).value;
			
			if(!/^-?\d+$/.test(dicValue)){
				  document.getElementById("checkSpan"+i).innerHTML='请输入整数';
	    	      document.getElementById("dicValue"+i).value="";
	    	      document.getElementById("dicValue"+i).select();
	    	      return;
	    	}
			if(!dicValue){
	    		document.getElementById("dicValue"+i).select();
	    		document.getElementById("checkSpan"+i).innerHTML='费用设置不能为空';
	    		return;
		    }
		    /**
		    if(dicValue<0){
	    		document.getElementById("dicValue"+i).select();
	    		document.getElementById("checkSpan"+i).innerHTML='设置不能为负数';
	    		return;
		    }
		    */
			//不能超过-2147483648和
			if(Number(dicValue)>=999999999){
				document.getElementById("checkSpan"+i).innerHTML='费用设置不能超过999999999';
				document.getElementById("dicValue"+i).value="";
				return;
			}
			if(Number(dicValue)<=-999999999){
				document.getElementById("checkSpan"+i).innerHTML='费用设置不能低于-999999999';
				document.getElementById("dicValue"+i).value="";
				return;
			}
			var cost = dicViewName+":"+dicValue;
			document.getElementById("checkSpan"+i).innerHTML='';
			costArr.push(cost);
		}
		DwrMethod.meetingCostSetting(costArr,callback);
      }
      function callback(result){
		if(result){
			document.getElementById("resultSpan").innerHTML="费用设置成功";
			setTimeout("document.getElementById('resultSpan').innerHTML=''",3000);
		}else{
			alert("设置失败!");
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
    </script>
  </body>
</html>