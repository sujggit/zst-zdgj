<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>修改角色名</title>
		<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
		function pageInit(){
		    var obj = new htmlUtil();
			obj.title("description","输入长度不超过100个字符");
		}
		function add(){
			$('#form').validate({    
			rules:{ 
					"roleVO.note":{
						minlength:0,
		           		maxlength:100
		           		}
			  	}
			});
			var roleName=document.getElementById("roleName");	
			if(roleName.value==null|| roleName.value =="")
			{
			  alert("请输入角色名");
			  return;
			}
			$("#form").submit();
		}
			function check(id){
		  		var a=document.getElementById(id);	 
		  		if( a.value==""||a.value==null || "${roleVO.roleName}" == a.value ){
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
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' class="id_bg"  onload="pageInit();">
		<form action="/icmp/role/modifyRole.action" method="post" name="form" id="form">
			<input type="hidden" name="roleVO.roleID" value="${roleVO.roleID}" />
	    	<div id="basicform" class="contentwrapper">
		      	<div class="contenttitle2">
		        	<h5 class="fwb fl10">修改角色名</h5>
		      	</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				  <tr>
				    <td width="15%" class="tableaddtitle"><span>*</span>角色</td>
				    <td class="tableadd_data" >
				    	<input type="text" class="inputtran" id="roleName" name="roleVO.roleName" value="${roleVO.roleName }" onblur="javascript:check('roleName');" maxlength=16 />
				    </td>
				  </tr>
				  <tr>
				    <td class="tableaddtitle" style="vertical-align:top;">描述</td>
				    <td class="tableadd_data" >
				    	<textarea rows="5" class="areatran" name="roleVO.note" id="description">${roleVO.note}</textarea>
				    </td>
				  </tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
				  <tfoot>
				  </tfoot>
				  <tbody>
				    <tr>
				      <td><input type="button" class="submit1 radius2" value="确 定" onclick="add();"/>
				        <input type="button" class="reset1 radius2" value="取 消" onclick="javascript:backHistory();"/>
				        </td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</form>
		<script type="text/javascript">
			<%--validate form--%>
	        var roleName_result=false;
	      
			function save(){
				var roleName=document.getElementById("roleName");	
				if(roleName.value==null|| roleName.value =="")
				{
				  alert("请输入角色名");
				  return;
				}
				document.getElementById("form").submit();
			}
			
			//check roleName when the roleName 'input' onblur
			function check_RoleName()
			{
				var rname ='${roleVO.roleName }';
				var roleName=document.getElementById("roleName");
				if(rname!=roleName.value )
				{
					DwrMethod.validation_roleName(roleName.value,calback);
				}
			}
			function calback(para){
				roleName_result=para;
				if(para){
					alert("角色名已存在！");//para is ture，the roleName has existed
					document.getElementById("roleName").value="";
				}
			}
			function backHistory(){
		        window.location.href="${sys_ctx }/role/manageRoleList.action";
		    }
		</script>
	</body>
</html>