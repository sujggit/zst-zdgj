<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <script type="text/javascript">
  	function pageInit(){
		var obj = new htmlUtil();
		obj.title("nodeIP","输入正确的IP");	
		obj.title("nodePort","输入10000内整数");
	}
	function add(){
		$('#form').validate({    
		rules:{    
		     "levelVO.nodeIP" : {
		          required:true,
		          minlength:1,
		          maxlength:25,
		          checkIP:true
		          },
		     "levelVO.nodePort" : {
			      digits:true,
			      range:[0,10000]
			      }
		           
		}
		
	  });
	  if( $('#form').valid()){
         var levelID = document.getElementById("levelID").value;
         var nodeIP = document.getElementById("nodeIP").value;
         var nodePort = document.getElementById("nodePort").value;
         DwrMethod.changeNode(levelID,nodeIP,nodePort,function back(flag){
         	if(flag){
         		window.close();
         	}
         });
      }
	}
	$(document).ready(function(){
	 		var power = document.getElementById("power").value;
	 		if(power == "noPower"){
		 		$("#nodeIP").attr("disabled","disabled");
		 		$("#nodePort").attr("disabled","disabled");
		 		$("#button").val("分级权限不够").attr("disabled","disabled");
		 	}else if(power == "LEVEL_IS_CLOSE"){
		 		$("#nodeIP").attr("disabled","disabled");
		 		$("#nodePort").attr("disabled","disabled");
		 		$("#button").val("分级已关闭").attr("disabled","disabled");
		 	}
		 });
	
  </script>
  <title>修改节点信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">
  <form action="${sys_ctx }/level/modifyNode.action" id="form">
  <input type="hidden" id="power" value="${power }"/>
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">修改节点信息</h5>
      </div>
     <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
			  <td class="tableaddtitle"><span>*</span>节点名称</td>
			  <td class="tableadd_data" >
			  	<input id="levelID" name="levelVO.levelID" type="hidden" value="${levelVO.levelID}"/>
			  	<input id="levelName" name="levelVO.levelName" value="${levelVO.levelName}" disabled="disabled"/>
			  </td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>节点IP</td>
				<td class="tableadd_data">
					<input id="nodeIP" name="levelVO.nodeIP" value="${levelVO.nodeIP}"/>
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle">节点端口</td>
				<td class="tableadd_data">
					<input id="nodePort" name="levelVO.nodePort" value="${levelVO.nodePort}"/>
				</td>
			</tr>
	  </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input class="submit1 radius2 submitBtn_Disa" type="button"  name="button" id="button" value="确  定"  onclick="add();"/>
		      <input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="javascript:window.close();"/>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</body>
</html>