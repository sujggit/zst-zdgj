<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>会议室分级配置增加页面</title>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/level/levelConfigAdd.action" method="post" name="form" id="form">
	    <div id="basicform" class="contentwrapper">
	      <input id="levelType" name="levelConfigVO.levelType" type="hidden" value="<%=LevelEnum.LEVEL_ROOM %>"/>
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">会议室分级配置增加</h5>
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
				<td class="tableaddtitle"><span>*</span>会议室名称</td>
				<td class="tableadd_data" >
					<input id="meetingRoomNameIDs" name="levelConfigVO.levelKey" type="hidden"/>
					<input id="meetingRoomNames" name="meetingRoomNames" class="inputtran" onclick="selectConference(this)" readonly="readonly"/>
					<input id="description" name="levelConfigVO.description" type="hidden"/>
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
				obj.title("meetingRoomNames","请选择会议室信息");
				//obj.title("description","输入长度不超过300个字符");
	     }
	 	function add(){
	 		var levelID = document.getElementById("levelID").value;
	 		var levelType = document.getElementById("levelType").value;    
	 		var levelName = document.getElementById("levelName").value;
			$('#form').validate({    
				rules:{    
				   "levelName" : {
				           required:true
					},
					"meetingRoomNames" : {
				           required:true
					}
				}
			});
			BaseDwrMethod.checkLevelConfig(levelID,levelType,function(para){
				if(para){
					alert(levelName+":分级已经配置了！");
					document.getElementById("levelName").value = "";
					return;
				}else{
					$('#form').submit();
				}
			})
		}

		function backHistory(){
			window.location.href = "${sys_ctx }/level/roomLevelList.action";
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

       /**选择会议室
   		*/
   		function selectConference(thisDom){
            var selectedConference = document.getElementById("meetingRoomNameIDs").value;
          	var conferenceParameters = {
              methodName:'getReturnConferenceMethod',
              selectedConference:selectedConference,
              selectType:'multiple'
          	}
     		creatConferenceSelect(thisDom,conferenceParameters); 
   	 	}
   		//返回方法
   		//用于获取返回参数
   		//返回参数为数组类型
   		//用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
   		//以提供的参数：conferenceID,conferenceName
   		function getReturnConferenceMethod(conferenceArray){
      		//alert(userArray);
      		var conferenceName = "";
      		var conferenceID = "";
      		var length = conferenceArray.length;
      		for(var i=0;i<length;i++){
 	          	if(i==(length-1)){
 	          		conferenceName =conferenceName+conferenceArray[i].conferenceName;
 	          		conferenceID = conferenceID+conferenceArray[i].conferenceID;
 	            }else{
 	            	conferenceName =conferenceName+conferenceArray[i].conferenceName+",";
 	            	conferenceID = conferenceID+conferenceArray[i].conferenceID+",";
 	            }
            }
            $("#meetingRoomNames").attr("value",conferenceName);
            $("#meetingRoomNameIDs").attr("value",conferenceID);
   		}
	 </script>
  </body>
</html>
