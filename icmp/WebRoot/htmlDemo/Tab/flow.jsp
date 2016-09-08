<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>流程节点添加</title>

</head>
<body>
<div id="basicform" class="contentwrapper">
    <div class="contenttitle2">
    	<h5 class="fwb fl10">提示：单击流程中的某个节点，可以增加节点、替换或删除当前节点、设置节点属性。</h5>
    </div>
    <div class="flow_center">
        <input type="hidden" id="index" value=""/>
        <input type="hidden" id="flag" value=""/>
        <table id="flowTab">
            <tr>
                <th><input value="开始" style="display:none" />开始</th>
                <td id="nodeBlank0"></td>
                <th>结束</th>
            </tr>
            <tr>
                <th><img src="../images/start.png" onclick="addFirstNode()"/></th>
                <td id="nodeImgArrows0"><img src="../images/arrows.png" /></td>
                <!--
                <th id="nodeImg1"><img src="images/person.png" onclick="appandDiv(event,1)" /></th>
                <th id="nodeImgArrows1"><img src="images/arrows.png" /></th>
                -->
                <th><img style="cursor:default" src="../images/end.png" /></th>
            </tr>
        </table>
        <div id="operateDiv" onmouseout="leaveOperDiv(event, this)" style="display:none">
            <ul>
                <li onclick="addNode()">增加节点</li>
                <li onclick="delNode()">删除节点</li>
                <li onclick="repNode()">替换节点</li>
                <li onclick="nodeAttributes()">节点属性</li>
            </ul>
        </div>
    </div>   
    <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer pfb" id="table">
        <tr>
            <td>
                <input type="button" class="submit1 radius2" value="确 定" onclick="commit()"/></button>
                <input type="button" class="reset1 radius2" value="取 消" onclick="window.history.back()"/></button>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
	var appandDiv = function(event,flag){
		var x = event.pageX || (event.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));
		var y = event.pageY || (event.clientY + (document.documentElement.scrollTop || document.body.scrollTop));
		document.getElementById("operateDiv").style.left = x + "px";
		document.getElementById("operateDiv").style.top = y + "px";
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
		var index = document.getElementById("index").value;
		if(index){
			var indexTemp = Number(index)+ 1;
			$("#nodeBlank0").after("<th id='nodeTitle"+indexTemp+"'>保密部门负责人"+indexTemp+"</th><td id='nodeBlank"+indexTemp+"'></td>");
			$("#nodeImgArrows0").after("<th id='nodeImg"+indexTemp+"'><img src='../images/post.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td				id='nodeImgArrows"+indexTemp+"'><img src='../images/arrows.png' /></td>");
			document.getElementById("index").value = indexTemp;
		}else{
			$("#nodeBlank0").after("<th id='nodeTitle1'>单位主管1</th><td id='nodeBlank1'></td>");
			$("#nodeImgArrows0").after("<th id='nodeImg1'><img src='../images/post.png' onclick='appandDiv(event,1)' /></th><td id='nodeImgArrows1'><img src='../images/arrows.png' /></td>");
			document.getElementById("index").value = 1;
		}
	}
	var addNode = function(){
		var flag = document.getElementById("flag").value;
		var index = document.getElementById("index").value;
		var indexTemp = Number(index)+ 1;
		$("#nodeBlank"+ flag).after("<th id='nodeTitle"+indexTemp+"'>保密部门负责人"+indexTemp+"</th><td id='nodeBlank"+indexTemp+"'></td>");
		$("#nodeImgArrows"+ flag).after("<th id='nodeImg"+indexTemp+"'><img src='../images/person.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td				id='nodeImgArrows"+indexTemp+"'><img src='../images/arrows.png' /></td>");
		document.getElementById("index").value = indexTemp;
	}
	var delNode = function(){
		var flag = document.getElementById("flag").value;
		$("#nodeTitle"+ flag).remove();
		$("#nodeBlank"+ flag).remove();
		$("#nodeImg"+ flag).remove();
		$("#nodeImgArrows"+ flag).remove();
	}
	var repNode = function(){
		var flag = document.getElementById("flag").value;
		document.getElementById("nodeTitle"+ flag).innerHTML = "保密部门负责人";
	}
	var nodeAttributes = function(){
	
	}
</script>
</body>
</html>