<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.ApplyEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>流程节点编辑页面</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
  	var appandDiv = function(event,flag){
  	  	if(flag!=1){
	  	  	var x = event.pageX || (event.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));
			var y = event.pageY || (event.clientY + (document.documentElement.scrollTop || document.body.scrollTop));
			var winWidth = document.body.clientWidth;
			if(x <= winWidth/2){
				document.getElementById("flowDetailDiv").style.left = x + "px";
				document.getElementById("flowDetailDiv").style.width = (winWidth-10-x) + "px";
				document.getElementById("flowDetailDiv").style.right = "10px";
			}else{
				document.getElementById("flowDetailDiv").style.left = "10px";
				document.getElementById("flowDetailDiv").style.width = (x-10) + "px";
				document.getElementById("flowDetailDiv").style.right = x + "px";
			}
			document.getElementById("flowDetailDiv").style.top = y + "px";
			document.getElementById("flowDetailDiv").style.display = "block";
			var checkUserIDs = document.getElementById("checkUserIDs"+flag).value;
			var userID = document.getElementById("userID"+flag).value;
			document.getElementById("realCheckUser").innerHTML = "";
			document.getElementById("realCheckUser").title = "";
			document.getElementById("checkUser").innerHTML = "";
			document.getElementById("checkUser").title = "";
			if(userID!='null'){
				DwrMethod.getUserNameByID(userID,function(para){
					document.getElementById("realCheckUser").innerHTML = para;
					document.getElementById("realCheckUser").title = para;
				})
			}
			if(checkUserIDs!='null'){
				DwrMethod.getUserNameByID(checkUserIDs,function(para){
					document.getElementById("checkUser").innerHTML = para;
					document.getElementById("checkUser").title = para;
				})
			}
  	  	}
	}
  	var leaveDiv = function(e, obj){
		//document.getElementById("operateDiv").style.display = "none";
		/* e.relatedTarget：返回鼠标进入的另一个标签元素对象，在这里指内层div */
		var eleObj = e.relatedTarget ? e.relatedTarget : e.type == 'mouseout' ? e.toElement : e.fromElement;
		while(eleObj && eleObj != obj)
			eleObj = eleObj.parentNode; /* 找到内层元素的根节点对象 */
		if(eleObj != obj) /* 如果不是我们需要的根节点对象，说明鼠标已经离开外层元素区域了 */
			obj.style.display='none';
	}

  
    $(document).ready(function(){
      DwrMethod.seeFlow("${param.applyID}",function(para){
		if(para){
		  var data = eval(para);
		  var hiddenHTML;
		  for(var i = 0;i<data.length;i++){
			  if(data[i].orderNum==<%=ApplyEnum.ORDERNUM_START%>){
				var flowDes = data[i].suggestion;
				if(flowDes!='null'){
					document.getElementById("flowDesDiv").style.display = "block";
					document.getElementById("flowDesSpan").innerHTML = flowDes;
				}
			  }
			hiddenHTML = "<input type='hidden' id='checkUserIDs"+(i+1)+"' name='checkUserIDs' value='"+data[i].checkUserIDs+"'/><input type='hidden' id='userID"+(i+1)+"' name='userID' value='"+data[i].userID+"'/>";
			if(data[i].checkType==<%= ApplyEnum.CHECKTYPE_PERSON%>){
				$("#nodeBlank0").before("<th id='nodeTitle"+(i+1)+"'>"+data[i].flownodeName+hiddenHTML+"</th><td id='nodeBlank"+(i+1)+"'></td>");
				if(data[i].status==<%=ApplyEnum.STATUS_INVALID%>||data[i].orderNum==<%=ApplyEnum.ORDERNUM_START%>){
					$("#nodeImgArrows0").before("<th id='nodeImg"+(i+1)+"' onclick='appandDiv(event,"+(i+1)+")'><img src='${sys_ctx }/meeting/apply/images/person.png' /><img src='${sys_ctx }/meeting/apply/images/agree.png' /><td id='nodeImgArrows"+(i+1)+"'><img src='${sys_ctx }/meeting/apply/images/arrows.png' /></td>");
				}else if(data[i].status==<%=ApplyEnum.STATUS_REJECT%>){
					$("#nodeImgArrows0").before("<th id='nodeImg"+(i+1)+"' onclick='appandDiv(event,"+(i+1)+")'><img src='${sys_ctx }/meeting/apply/images/person.png' /><img src='${sys_ctx }/meeting/apply/images/disagree.png' /><td id='nodeImgArrows"+(i+1)+"'><img src='${sys_ctx }/meeting/apply/images/arrows.png' /></td>");
				}else{
					$("#nodeImgArrows0").before("<th id='nodeImg"+(i+1)+"' onclick='appandDiv(event,"+(i+1)+")'><img src='${sys_ctx }/meeting/apply/images/person.png' /><img src='${sys_ctx }/meeting/apply/images/blank.png' /><td id='nodeImgArrows"+(i+1)+"'><img src='${sys_ctx }/meeting/apply/images/arrows.png' /></td>");
				}
			}else if(data[i].checkType==<%= ApplyEnum.CHECKTYPE_POST%>){
				$("#nodeBlank0").before("<th id='nodeTitle"+(i+1)+"'>"+data[i].flownodeName+hiddenHTML+"</th><td id='nodeBlank"+(i+1)+"'></td>");
				if(data[i].status==<%=ApplyEnum.STATUS_INVALID%>||data[i].orderNum==<%=ApplyEnum.ORDERNUM_START%>){
					$("#nodeImgArrows0").before("<th id='nodeImg"+(i+1)+"' onclick='appandDiv(event,"+(i+1)+")'><img src='${sys_ctx }/meeting/apply/images/post.png' /><img src='${sys_ctx }/meeting/apply/images/agree.png' /></th><td id='nodeImgArrows"+(i+1)+"'><img src='${sys_ctx }/meeting/apply/images/arrows.png' /></td>");
				}else if(data[i].status==<%=ApplyEnum.STATUS_REJECT%>){
					$("#nodeImgArrows0").before("<th id='nodeImg"+(i+1)+"' onclick='appandDiv(event,"+(i+1)+")'><img src='${sys_ctx }/meeting/apply/images/post.png' /><img src='${sys_ctx }/meeting/apply/images/disagree.png' /></th><td id='nodeImgArrows"+(i+1)+"'><img src='${sys_ctx }/meeting/apply/images/arrows.png' /></td>");
				}else{
					$("#nodeImgArrows0").before("<th id='nodeImg"+(i+1)+"' onclick='appandDiv(event,"+(i+1)+")'><img src='${sys_ctx }/meeting/apply/images/post.png' /><img src='${sys_ctx }/meeting/apply/images/blank.png' /></th><td id='nodeImgArrows"+(i+1)+"'><img src='${sys_ctx }/meeting/apply/images/arrows.png' /></td>");
				}
			}
		  }
		  //document.getElementById("index").value = data.length;
		  //document.getElementById("isExist").value = data.length;//此流程是否有节点的标识
		}
      })
    })
  </script>
</head>
<body>
<div class="contentwrapper">
	<div class="contenttitle2">
        <h5 class="fwb fl10">提示：单击流程中的某个节点，可以查看当前节点的审批人和实际的执行审批的人。</h5>
	</div>
	<div class="flow_center" style="border:1px solid #ccc;width:99%;left:4px;text-align:left">
	    <input type="hidden" id="index" value=""/>
	    <input type="hidden" id="flag" value=""/>
	    <input type="hidden" id="isExist" value=""/>
	    <table id="flowTab" style="margin-left:10px">
    	    <tr>
        	    <th id="nodeBlank0">结束</th>
        	</tr>
        	<tr>
        	    <th id="nodeImgArrows0"><img style="cursor:default" src="${sys_ctx }/meeting/apply/images/end.png" /></th>
        	</tr>
    	</table>
    	<div style="float:left;margin:10px;display:none" id='flowDesDiv'><span id="flowDesSpan">流程处理人   联系方式</span></div>
		<table cellpadding="0" cellspacing="0" border="0" style="text-align:left;bottom:50px;width:99%;padding:0;margin:0;position:fixed;margin:0 auto;border:1px solid #CCC">
			<tr>
				<td style="height:30px;padding-left:5px;border-right:1px solid #ccc;">图例	</td>
				<td style="height:30px;padding-left:5px;border-right:1px solid #ccc;"><img src='${sys_ctx }/meeting/apply/images/agree.png' /> 审批通过的节点</td>
				<td style="height:30px;padding-left:5px;border-right:1px solid #ccc;"><img src='${sys_ctx }/meeting/apply/images/disagree.png' /> 审批不通过的节点</td>
				<td style="height:30px;padding-left:5px;"> <img src='${sys_ctx }/meeting/apply/images/blank.png' /> 正在流转的节点</td>
			</tr>
		</table>
	</div>
	<div id="flowDetailDiv" onmouseout="leaveDiv(event, this)" class="displayDiv">
   		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
    	    <tr>
        		<td width="30%" class="tableaddtitle">审批人：</td>
          		<td width="70%" class="tableadd_data" id="checkUser"></td>
        	</tr>
        	<tr>
         		<td class="tableaddtitle" style="vertical-align:top;">实际审批人：</td>
          		<td class="tableadd_data" title="" id="realCheckUser"></td>
        	</tr>
   		</table>
	</div> 
	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer pfb" id="table" style="left:4px;">
		<tr>
			<td>
				<input type="button" class="submit1 radius2" value="关 闭" onclick="window.close()"/>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
