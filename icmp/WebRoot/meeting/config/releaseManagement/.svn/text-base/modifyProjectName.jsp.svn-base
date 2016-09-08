<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>系统配置</title>
  <script type="text/javascript">
	   function menu(){
		 document.getElementById("m2").style.backgroundColor="#fff";
	   }

	   $(document).ready(function(){
		    var obj = new htmlUtil();
			obj.title("appName","输入长度为1-20的汉字或字符");
			//obj.title("copyright","输入长度为1-100的汉字或字符");
		})
		
        function modifyconfig(){
	         $('#modifyForm').validate({    
						rules:{   
						 "configVO.appName" : {
					           required:true,
					           minlength:1,
	                           maxlength:25 
					    }
			    /**
					    "configVO.copyright" : {
					           required:true,
					           minlength:1,
	                           maxlength:100 
					    }
			   */
					}  
			  });
	          $("#modifyForm").submit();
          	  document.getElementById("uploadSpan").innerHTML="修改成功后刷新页面即可";
          	  setTimeout("document.getElementById('uploadSpan').innerHTML=''",3000);
	    };
    </script>
  </head>
  <body class="withvernav" style="OVERFLOW:AUTO;OVERFLOW-X:HIDDEN" onload="menu();">
    <div id="contentwrapper" class="contentwrapper"><!--contenttitle-->
      <%@include file="./pageLabel.jsp"%>
      <div id="k2"  class="k" style="display:block">
         <form action="${sys_ctx }/config/modifySysConfig.action" id="modifyForm" name="modifyForm" method="post">
      		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
      		  <!--<div class="contenttitle2">
        		<h5 class="fwb fl10">系统配置</h5>
      		  </div>-->
        	  <tr>
        	    <td class="tableaddtitle" width="30%"><span class="fonttsx">*</span>系统名称</td>
        		<td class="tableadd_data" width="70%">
        		  <input maxlength="20" name="configVO.appName" class="inputtran" id="appName" value="${configVO.appName }"/>
        		</td>
          	 </tr>
          	 <!-- 
          	 <tr>
        	    <td class="tableaddtitle" width="30%"><span class="fonttsx">*</span>版权信息：</td>
        		<td class="tableadd_data" width="70%">
        		  <input name="configVO.copyright" class="inputtran" id="copyright" value="${configVO.copyright }"/>
        		</td>
          	 </tr>
          	  -->
           </table>
           <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	 <tfoot>
        	 </tfoot>
        	 <tbody>
          	   <tr>
            	 <td>
            	   <span id="uploadSpan" class="promptSpan"></span>
            	   <input type="button" class="submit1 radius2" value="确 定" onclick="modifyconfig()"/>
                 </td>
              </tr>
        	</tbody>
      	  </table>
      	  <div style="height:200px;"></div>
         </form>
        </div>
        </div>
  </body>
</html>