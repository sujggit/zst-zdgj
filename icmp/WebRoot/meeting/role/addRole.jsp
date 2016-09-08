<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>增加角色</title>
		<script type='text/javascript' src='/icmp/dwr/engine.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/util.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
	    <script type="text/javascript">
		    <%--validate form--%>
	        var roleName_result=false;
	        
	        function pageInit(){
				var obj = new htmlUtil();
				obj.title("roleName","输入长度为1-15的汉字或字符");
				obj.title("description","输入长度不超过100个字符");
	        }
	        $(document).ready(function(){
				pageInit();
		    })
		    
			function add(){    
			$('#form').validate({    
				rules:{    
				   "roleVO.roleName" : {
				           required:true,
				           minlength:1,
				           maxlength:15
				           },
				    "roleVO.note":{
							minlength:0,
				           	maxlength:100
				           	}
					}
				});
				check_RoleName();
			}
			
			//check roleName when the roleName 'input' onblur
			function check_RoleName(){
				var roleName=document.getElementById("roleName");
				DwrMethod.validation_roleName(roleName.value,calback);
			}
			function calback(para){
				if(para){
					alert("角色名已存在！");//para is ture，the roleName has existed
					document.getElementById("roleName").value="";
				}else{
					$("#form").submit();
				}
			}


	     function check(id){
		  		var a=document.getElementById(id);	  
		  		if(a.value==""||a.value==null){
					return;
				}
			    DwrMethod.checkRoleName(a.value,callback);
		};
	      
	     function callback(result){
	    	if(result){
	    		alert("此角色名称已被占用");
	    		document.getElementById("roleName").value="";  	
	    	}			
 		};
			
		</script>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="/icmp/role/addRole.action" method="post" name="form" id="form">
		<input type="hidden" name="roleVO.create_by" value="admin" />
		<input type="hidden" name="res" id="res" value="" />
	    <div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">增加角色</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="15%"  class="tableaddtitle"><span>*</span>角色</td>
	          <td class="tableadd_data" ><input type="text" class="inputtran" id="roleName" name="roleVO.roleName" maxlength="15" onblur="check('roleName');"/></td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle" style="vertical-align:top;">描述</td>
	          <td class="tableadd_data" ><textarea rows="5" class="areatran" name="roleVO.note" id="description"></textarea></td>
	        </tr>
	       </table>
		  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		            	<input class="submit1 radius2 submitBtn_Disa" type="button" name="addButton" id="addButton" value="确  定"  onclick="add();"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="javascript:window.history.go(-1);"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
	</form>
  </body>
</html>
