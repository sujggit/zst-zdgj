<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>用户分级配置增加页面</title>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/level/levelConfigAdd.action" method="post" name="form" id="form">
	    <div id="basicform" class="contentwrapper">
	      <input id="levelType" name="levelConfigVO.levelType" type="hidden" value="<%=LevelEnum.LEVEL_USER %>"/>
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">用户分级配置增加（超级用户：拥有本级及下一级的权限；普通用户：仅拥有本级的权限）</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
			  <td class="tableaddtitle"><span>*</span>分级名称</td>
			  <td class="tableadd_data" >
			  	<input id="levelID" name="levelConfigVO.levelID" type="hidden" />
			  	<input id="levelName" name="levelName" class="inputtran" onclick="selectLevelInfo(this)" readonly="readonly"/>
			  </td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>超级用户名称</td>
				<td class="tableadd_data" >
					<input id="userID_super" name="levelConfigVO.description" type="hidden"/>
					<input id="userName_super" name="userName" class="inputtran" onclick="selectUsers(this)" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>普通用户名称</td>
				<td class="tableadd_data" >
					<input id="userID" name="levelConfigVO.levelKey" type="hidden"/>
					<input id="userName" name="userName" class="inputtran" onclick="selectUsers(this)" readonly="readonly"/>
				</td>
			</tr>
	       </table>
		  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		            	<input class="submit1 radius2 submitBtn_Disa" type="button" name="addButton" id="addButton" value="确  定"  onclick="add();"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="backHistory()"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
	</form>
	 <script type="text/javascript">
	 	$(document).ready(function(){
	 		pageInit();
		 });
		 
		 function pageInit(){
				var obj = new htmlUtil();
				obj.title("levelName","请选择分级信息");
				obj.title("userName_super","请选择人员信息");
				obj.title("userName","请选择人员信息");
				//obj.title("description","输入长度不超过300个字符");
	     }
	 	function add(){    
			$('#form').validate({    
				rules:{    
				   "levelName" : {
				           required:true
					}
					/**
					"userName" : {
				           required:true,
					},
					
					"levelConfigVO.description" : {
				           maxlength:300
					}
					*/
				}
			});
			checkLevelId();
		}

	 	var flag1 = false;
	 	var flag2 = false;
		function checkLevelId(){
			flag1 = false;
			var levelID = document.getElementById("levelID").value;
			var levelName = document.getElementById("levelName").value;
			var levelType = document.getElementById("levelType").value;
			if(levelID){
				BaseDwrMethod.checkLevelConfig(levelID,levelType,function(para){
					if(para){
						document.getElementById("levelName").value = "";
						alert(levelName+":分级已经配置了！");
						return;
					}else{
						flag1 = true;
						checkUsers();
						//$('#form').submit();
					}
				})
			}else{
				$('#form').submit();
			}
		}
	 	
		function checkUsers(){
			flag2 = false;
			var userID = document.getElementById("userID").value;
			var userID_super = document.getElementById("userID_super").value;
			var levelID = document.getElementById("levelID").value;
			var levelName = document.getElementById("levelName").value;
			var levelType = document.getElementById("levelType").value;
			if(userID || userID_super){
				flag2 = true;
				if(flag1 && flag2){
					$('#form').submit();
				}
			}else{
				alert("人员必选");
				return;
			}
		}

		function backHistory(){
			window.location.href = "${sys_ctx }/level/userLevelList.action";
		}

		/**选择分级信息
		*/
		function selectLevelInfo(thisDom){
			 var uParameters = {
                methodName:'getReturnLevelMethod',
                selectType:'radio'
            }
           creatLevelSelect(thisDom,uParameters);
		}
		function getReturnLevelMethod(returnObj){
			var returnObjs = eval(returnObj);
            var id="";
            var name="";
            for(var i=0;i<returnObjs.length;i++){
          	  id += returnObjs[i].id;
          	  name += returnObjs[i].name;
            }
        	$("#levelID").attr("value",id);
      		$("#levelName").attr("value",name);
       };

		/**选择用户信息
		*/
		function selectUsers(thisDom){
            var userParameters = {
                methodName:'getReturnUserMethod',
                selectType:'multiple'
            }
            creatUserSelAll(thisDom,userParameters); 
      	};
  		function getReturnUserMethod(userArray){
            var userID="";
            var userName="";
            var userID_super="";
            var userName_super="";
            userArray = eval(userArray);
            var userLength = userArray.length;
            for(var i=0;i<userLength;i++){
                if(userArray[i].superPower==<%=LevelEnum.LEVELCONFIG_SUPERPOWER%>){
   	                userName_super =userName_super+userArray[i].userName+",";
   	                userID_super = userID_super+userArray[i].userID+",";
                }else  if(userArray[i].superPower==<%=LevelEnum.LEVELCONFIG_SUPERPOWER_CLOSE%>){
   	                userName =userName+userArray[i].userName+",";
   	                userID = userID+userArray[i].userID+",";
                }
            }
            userName_super = userName_super.substring(0,userName_super.length-1);
            userID_super = userID_super.substring(0,userID_super.length-1);
            userName = userName.substring(0,userName.length-1);
            userID = userID.substring(0,userID.length-1);
        	$("#userID").attr("value",userID);
      		$("#userName").attr("value",userName);
      		$("#userID_super").attr("value",userID_super);
     		$("#userName_super").attr("value",userName_super);
       };

       /**选择超级用户信息
		*/
		function selectUsers_super(thisDom){
           var userParameters = {
               methodName:'getReturnUserMethod_super',
               selectType:'multiple'
           }
           creatUserSelAll(thisDom,userParameters); 
     	};
 		function getReturnUserMethod_super(userArray){
           var userID="";
           var userName="";
           userArray = eval(userArray);
           var userLength = userArray.length;
           for(var i=0;i<userLength;i++){
	          	if(i==(userLength-1)){
	                userName =userName+userArray[i].userName;
	                userID = userID+userArray[i].userID;
	            }else{
	                userName =userName+userArray[i].userName+",";
	                userID = userID+userArray[i].userID+",";
	            }
           }
       		$("#userID_super").attr("value",userID);
     		$("#userName_super").attr("value",userName);
      };
	 </script>
  </body>
</html>
