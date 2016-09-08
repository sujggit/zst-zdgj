<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>系统配置</title>
  <script type="text/javascript">
	function menu(){
		document.getElementById("m3").style.backgroundColor="#fff";
	}
          	function plus(id){
				var num = document.getElementById(id);
				if(num.value){
					num.value = Number(num.value) +1;
				}
			}
			function reduce(id){
				var num = document.getElementById(id);
				if(num.value){
					num.value = num.value - 1;
				}
			}
    </script>
  </head>
  <body class="withvernav" style="OVERFLOW:AUTO;OVERFLOW-X:HIDDEN" onload="menu();">
    <div id="contentwrapper" class="contentwrapper"><!--contenttitle-->
      <%@include file="./pageLabel.jsp"%>
      <div id="k3"  class="k" style="display:block">
         <form action="${sys_ctx }/config/modifySysConfig.action" id="modifyForm" name="modifyForm" method="post">
      		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        	  <tr>
        	    <td class="tableaddtitle" width="15%">时长（天）</td>
        		<td class="tableadd_data" width="35%">
        		  <input name="equipmentVO.createDate" class="inputtran" id="createDate" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" />
        		</td>
        		<td class="tableaddtitle" width="15%">MCU个数</td>
        		<td class="tableadd_data" width="35%">
        		  <div class="acquiesce"><input id="mcuNumber" value="10" /></div>
					<div class="acquiesce_list">
						<span class="acquiesce_list_1"><input type="button" value="" onClick="plus('mcuNumber');" /></span>
						<span class="acquiesce_list_2"><input type="button" value="" onClick="reduce('mcuNumber');" /></span>
					</div>
        		</td>  
          	 </tr> 
          	 <tr>
        	    <td class="tableaddtitle" width="15%">终端个数</td>
        		<td class="tableadd_data" width="35%">
	        		<div class="acquiesce"><input id="terNumber" value="10" /></div>
					<div class="acquiesce_list">
						<span class="acquiesce_list_1"><input type="button" value="" onClick="plus('terNumber');" /></span>
						<span class="acquiesce_list_2"><input type="button" value="" onClick="reduce('terNumber');" /></span>
					</div>
        		</td>
        		 
          	 </tr>
           </table>
           <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	 <tbody>
          	   <tr>
            	 <td>
            	   <input type="button" class="submit1 radius2" value="确 定" onclick="modifyconfig()"/>
                 </td>
              </tr>
        	</tbody>
      	  </table>
         </form>
        </div>
        </div>
  </body>
</html>