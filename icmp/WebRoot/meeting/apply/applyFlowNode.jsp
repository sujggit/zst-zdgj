<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>流程节点编辑页面</title>
</head>
<body>
<div class="flow_top">
提示：单击流程中的某个节点，可以增加节点、替换或删除当前节点、设置节点属性。
</div>
<div class="flow_center">
    <input type="hidden" id="index" value=""/>
    <input type="hidden" id="flag" value=""/>
    <table id="flowTab" style="margin-left:10px">
        <tr>
            <th><input value="开始" style="display:none" />开始</th>
            <td id="nodeBlank0"></td>
            <!--
            <th id="nodeTitle1">单位主管</th>
            <th id="nodeBlank1"></th>
            -->
            <th>结束</th>
        </tr>
        <tr>
            <th><img src="images/start.png" onclick="addFirstNode()"/></th>
            <td id="nodeImgArrows0"><img src="images/arrows.png" /></td>
            <!--
            <th id="nodeImg1"><img src="images/person.png" onclick="appandDiv(event,1)" /></th>
            <th id="nodeImgArrows1"><img src="images/arrows.png" /></th>
            -->
            <th><img style="cursor:default" src="images/end.png" /></th>
        </tr>
    </table>
    <div id="operateDiv" onmouseout="leaveOperDiv(event, this)">
        <ul>
            <li onclick="addNode()">增加节点</li>
            <li onclick="delNode()">删除节点</li>
            <li onclick="repNode()">替换节点</li>
            <li onclick="nodeAttributes()">节点属性</li>
        </ul>
    </div>
</div> 
<div class="flow_bottom">   
<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table"  style="width:100%;">
	<tr>
		<td>
			<input type="button" class="submit1 radius2" value="确 定" onclick="commit()"/>
			<input type="button" class="reset1 radius2" value="取 消" onclick="window.close()"/>
		</td>
	</tr>
</table>
</div>
<script type="text/javascript">
	var appandDiv = function(event,flag){
		var x = event.pageX || (event.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));
		var y = event.pageY || (event.clientY + (document.documentElement.scrollTop || document.body.scrollTop));
		document.getElementById("operateDiv").style.left = x + "px";
		document.getElementById("operateDiv").style.top = (y-50) + "px";
		document.getElementById("operateDiv").style.display = "block";
		document.getElementById("flag").value = flag;
	}
	var leaveOperDiv = function(e, obj){
		//document.getElementById("operateDiv").style.display = "none";
		/* e.relatedTarget：返回鼠标进入的另一个标签元素对象，在这里指内层div */
		var eleObj = e.relatedTarget ? e.relatedTarget : e.type == 'mouseout' ? e.toElement : e.fromElement;
		while(eleObj && eleObj != obj)
			eleObj = eleObj.parentNode; /* 找到内层元素的根节点对象 */
		if(eleObj != obj) /* 如果不是我们需要的根节点对象，说明鼠标已经离开外层元素区域了 */
			obj.style.display='none';
	}

	var addFirstNode = function(){
		selectUsersAndPost(this,'radio','start');
	}
	var addNode = function(){
		selectUsersAndPost(this,'radio','other');
	}
	var delNode = function(){
		var flag = document.getElementById("flag").value;
		$("#nodeTitle"+ flag).remove();
		$("#nodeBlank"+ flag).remove();
		$("#nodeImg"+ flag).remove();
		$("#nodeImgArrows"+ flag).remove();
	}
	var repNode = function(){
		selectUsersAndPost(this,'radio','replace');
	}
	var nodeAttributes = function(){
	
	}
	
	var type="";
    function selectUsersAndPost(thisDom,selectType,key){
    	type = selectType;
        var selectedUser;
        if(key == "start"){
        	var userParameters = {
               methodName:'getReturnUserPostMethod1',
               selectedUser:selectedUser,
               selectType:selectType
            }
        }else if(key == "other"){
        	var userParameters = {
               methodName:'getReturnUserPostMethod',
               selectedUser:selectedUser,
               selectType:selectType
           }
        }else if(key == "replace"){
        	var userParameters = {
               methodName:'getReturnUserPostMethod2',
               selectedUser:selectedUser,
               selectType:selectType
           }
        }
        creatUserAndPostSelect(thisDom,userParameters); 
    }

    function getReturnUserPostMethod1(userArray){
        var userArray = eval(userArray);
	    if(type=='radio'){
	      	var selType = userArray[0].selType;
          	userID=userArray[0].userID;
          	userName=userArray[0].userName;
         	var index = document.getElementById("index").value;
         	var hiddenHTML = "<input type='hidden' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' name='nodeType' value='"+userArray[0].selType+"'/>";
    		if(index){
    			var indexTemp = Number(index)+ 1;
    			$("#nodeBlank0").after("<th id='nodeTitle"+indexTemp+"'>"+userArray[0].userName+hiddenHTML+"</th><td id='nodeBlank"+indexTemp+"'></td>");
				if(selType=="person"){
					$("#nodeImgArrows0").after("<th id='nodeImg"+indexTemp+"'><img src='images/person.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td id='nodeImgArrows"+indexTemp+"'><img src='images/arrows.png' /></td>");
				}else if(selType=="post"){
					$("#nodeImgArrows0").after("<th id='nodeImg"+indexTemp+"'><img src='images/post.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td id='nodeImgArrows"+indexTemp+"'><img src='images/arrows.png' /></td>");
				}
    			document.getElementById("index").value = indexTemp;
    		}else{
    			$("#nodeBlank0").after("<th id='nodeTitle1'>"+userArray[0].userName+hiddenHTML+"</th><td id='nodeBlank1'></td>");
    			if(selType=="person"){
    				$("#nodeImgArrows0").after("<th id='nodeImg1'><img src='images/person.png' onclick='appandDiv(event,1)' /></th><td id='nodeImgArrows1'><img src='images/arrows.png' /></td>");
    			}else if(selType=="post"){
    				$("#nodeImgArrows0").after("<th id='nodeImg1'><img src='images/post.png' onclick='appandDiv(event,1)' /></th><td id='nodeImgArrows1'><img src='images/arrows.png' /></td>");
        		}
        		document.getElementById("index").value = 1;
    		}
       }
    }
    function getReturnUserPostMethod(userArray){
        var userArray = eval(userArray);
	    if(type=='radio'){
	    	var selType = userArray[0].selType;
          	userID=userArray[0].userID;
          	userName=userArray[0].userName;
         	var flag = document.getElementById("flag").value;
    		var index = document.getElementById("index").value;
    		var hiddenHTML = "<input type='hidden' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' name='nodeType' value='"+userArray[0].selType+"'/>";
    		var indexTemp = Number(index)+ 1;
    		$("#nodeBlank"+ flag).after("<th id='nodeTitle"+indexTemp+"'>"+userArray[0].userName+hiddenHTML+"</th><td id='nodeBlank"+indexTemp+"'></td>");
    		if(selType=="person"){
    			$("#nodeImgArrows"+ flag).after("<th id='nodeImg"+indexTemp+"'><img src='images/person.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td	id='nodeImgArrows"+indexTemp+"'><img src='images/arrows.png' /></td>");
    		}else if(selType=="post"){
    			$("#nodeImgArrows"+ flag).after("<th id='nodeImg"+indexTemp+"'><img src='images/post.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td id='nodeImgArrows"+indexTemp+"'><img src='images/arrows.png' /></td>");
    		}
    		document.getElementById("index").value = indexTemp;
       }
    }
    function getReturnUserPostMethod2(userArray){
        var userArray = eval(userArray);
	    if(type=='radio'){
	    	var selType = userArray[0].selType;
          	userID=userArray[0].userID;
          	userName=userArray[0].userName;
         	var flag = document.getElementById("flag").value;
         	var hiddenHTML = "<input type='hidden' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' name='nodeType' value='"+userArray[0].selType+"'/>";
    		$("#nodeTitle"+ flag).replaceWith("<th id='nodeTitle"+flag+"'>"+userArray[0].userName+hiddenHTML+"</th>");
    		if(selType=="person"){
    			$("#nodeImg"+ flag).replaceWith("<th id='nodeImg"+flag+"'><img src='images/person.png' onclick='appandDiv(event,"+flag+")' /></th>");
    		}else if(selType=="post"){
    			$("#nodeImg"+ flag).replaceWith("<th id='nodeImg"+flag+"'><img src='images/post.png' onclick='appandDiv(event,"+flag+")' /></th>");
    		}
       }
    }
</script>
</body>
</html>
