<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.ApplyEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>流程节点编辑页面</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <style type="text/css">
    /*遮罩层*/
	.lockDiv{display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; overflow: hidden; background-color: rgb(255, 255, 255); opacity: 0.5; z-index: 1981; background-position: initial initial; background-repeat: initial initial;}
	.lockDivIE{display: none; z-index: 1981; position: fixed; filter:  alpha(opacity=50); WIDTH: 100%; zoom: 1; background: #fff; height: 100%; overflow: hidden; top: 0px; left: 0px;}
	#layerDiv{display: none; visibility: visible; position: absolute; width: auto; left: 10%; top: 25%; right: 10%; z-index: 1982;}
  </style>
</head>
<body>
<div class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10">提示：单击流程中的某个节点，可以增加节点、替换或删除当前节点、设置节点属性。</h5>
	</div>
<div class="flow_center" style="border:1px solid #ccc;width:99%;left:4px;text-align:left">
	<input type="hidden" value="${param.flowID}" name="flownodeVO.flowID" id="flowID"/>
    <input type="hidden" id="index" value=""/>
    <input type="hidden" id="flag" value=""/>
    <input type="hidden" id="isExist" value=""/>
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
            <th><img src="../images/start.png" onclick="addFirstNode()"/></th>
            <td id="nodeImgArrows0"><img src="../images/arrows.png" /></td>
            <!--
            <th id="nodeImg1"><img src="../images/person.png" onclick="appandDiv(event,1)" /></th>
            <th id="nodeImgArrows1"><img src="../images/arrows.png" /></th>
            -->
            <th><img style="cursor:default" src="../images/end.png" /></th>
        </tr>
    </table>
    <div id="operateDiv" onmouseout="leaveOperDiv(event, this)" class="displayDiv">
        <ul>
            <li onclick="addNode()">增加节点</li>
            <li onclick="delNode()">删除节点</li>
            <li onclick="repNode()">替换节点</li>
            <li onclick="nodeAttributes()">节点属性</li>
        </ul>
    </div>
</div> 
<div class="flow_bottom" style="left:0">   
<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer pfb" id="table" style="left:4px">
	<tr>
		<td>
			<span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
			<input type="button" class="submit1 radius2" value="确 定" id="addBtn" onclick="commit()"/>
			<input type="button" class="reset1 radius2" value="取 消" onclick="window.close()"/>
		</td>
	</tr>
</table>
</div>
<div id="lockmask" class="lockDivIE"></div>
<div id="layerDiv">
  <table class="ui_border ui_state_focus ui_state_lock">
	<TBODY>
		<DIV class=ui_inner>
		<TABLE class=ui_dialog>
		<TBODY>
		<TR>
		<TD colSpan=2>
		<DIV class=ui_title_bar>
		<DIV style="CURSOR: move" class=ui_title unselectable="on">视窗 </DIV>
		<DIV class=ui_title_buttons><A style="DISPLAY: none" class=ui_min title=最小化 href="javascript:void(0);"><B class=ui_min_b></B></A><A style="DISPLAY: none" class=ui_max title=最大化 href="javascript:void(0);"><B class=ui_max_b></B></A><A class=ui_res title=还原 href="javascript:void(0);"><B class=ui_res_b></B><B class=ui_res_t></B></A><A style="DISPLAY: inline-block" class=ui_close title=关闭 href="javascript:void(0);" onclick="hidediv()">×</A></DIV></DIV></TD></TR>
		<TR>
		<TD class=ui_icon><!-- <IMG class=ui_icon_bg> --></TD>
		<TD style="WIDTH: auto; HEIGHT: auto" class=ui_main>
		<DIV style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px" class=ui_content>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
		        <tr>
		          <td width="25%" class="tableaddtitle">执行人：</td>
		          <td width="75%" class="tableadd_data" ><input name="checkman" id="checkman" value="" class="inputtran" readonly="readonly" style="margin-left: 10px"/></td>
		        </tr>
		        <tr>
		          <td width="25%" class="tableaddtitle">会议秘密等级：</td>
		          <td width="75%" class="tableadd_data">
		            <input type="radio" name="secret" id="nosecret" value="no" checked="checked" style="margin-left: 10px"/>普通
		          	<input type="radio" name="secret" id="secret" value="yes" />涉密
		          </td>
		        </tr>
	        </table>
		</DIV></TD></TR>
		<TR>
		<TD colSpan=2>
		<DIV class=ui_buttons><INPUT class=ui_state_highlight value=确定 type=button onclick="setAttributes()"><INPUT value=取消 type=button onclick="hidediv()"></DIV></TD></TR>
		</TBODY></TABLE></DIV></TD>
		<TD class=ui_r></TD></TR>
	</TBODY>
  </table>
</div>
</div>
<script type="text/javascript">
	var isOperate = false;//用户操作的标识符
	var flowID = document.getElementById("flowID");
	var flowType = "${param.flowType}";
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
		selectUsersAndPost(this,'radio',flowType,'start');
	}
	var addNode = function(){
		selectUsersAndPost(this,'radio',flowType,'other');
	}
	var delNode = function(){
		var flag = document.getElementById("flag").value;
		$("#nodeTitle"+ flag).remove();
		$("#nodeBlank"+ flag).remove();
		$("#nodeImg"+ flag).remove();
		$("#nodeImgArrows"+ flag).remove();
		isOperate = true;
		document.getElementById("operateDiv").style.display = "none";
	}
	var repNode = function(){
		selectUsersAndPost(this,'radio',flowType,'replace');
	}
	var nodeAttributes = function(){
		showdiv();
		var flag = document.getElementById("flag").value;
		var userName = document.getElementById("userName"+flag).value;
		document.getElementById("checkman").value = userName.replace(new RegExp("<br>","g"),"，");;
		var checkRuleVal = document.getElementById("checkRule"+flag).value;
		if(checkRuleVal.indexOf("<%=ApplyEnum.CHECKRULE_SECRET%>") === -1){
			document.getElementById("nosecret").checked = "checked";
		}else{
			document.getElementById("secret").checked = "checked";
		}
	}
	var setAttributes = function(){
		var flag = document.getElementById("flag").value;
		var secret = document.getElementsByName("secret");
		isOperate = true;
		for(var i=0;i<secret.length;i++){
			if(secret[i].checked){
				var issecret = secret[i].value;
				if(issecret == "no"){
					document.getElementById("checkRule"+flag).value = "<%=ApplyEnum.CHECKRULE_DEFAULT%>";
				}else if(issecret == "yes"){
					document.getElementById("checkRule"+flag).value = "<%=ApplyEnum.CHECKRULE_SECRET%>";
				}
				hidediv();
				return;
			}
		}
	}
	function showdiv() {            
        document.getElementById("lockmask").style.display = "block";
        document.getElementById("layerDiv").style.display = "block";
    }
    function hidediv() {
        document.getElementById("lockmask").style.display = 'none';
        document.getElementById("layerDiv").style.display = 'none';
    }
	
	var type="";
    function selectUsersAndPost(thisDom,selectType,flowType,key){
    	type = selectType;
        var selectedUser;
        if(key == "start"){
        	var userParameters = {
               methodName:'getReturnUserPostMethod1',
               selectedUser:selectedUser,
               selectType:selectType,
               flowType:flowType
            }
        }else if(key == "other"){
        	var userParameters = {
               methodName:'getReturnUserPostMethod2',
               selectedUser:selectedUser,
               selectType:selectType,
               flowType:flowType
           }
        }else if(key == "replace"){
        	var userParameters = {
               methodName:'getReturnUserPostMethod3',
               selectedUser:selectedUser,
               selectType:selectType,
               flowType:flowType
           }
        }
        creatUserAndPostSelect(thisDom,userParameters); 
    }

    function getReturnUserPostMethod1(userArray){
        var userArray = eval(userArray);
        isOperate = true;
	    if(type=='radio'){
	      	var selType = userArray[0].selType;
         	var index = document.getElementById("index").value;
    		if(index){
    			var indexTemp = Number(index)+ 1;
    			var hiddenHTML = "<input type='hidden' id='userID"+indexTemp+"' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' id='userName"+indexTemp+"' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' id='nodeType"+indexTemp+"' name='nodeType' value='"+userArray[0].selType+"'/><input type='hidden' id='checkRule"+indexTemp+"' name='checkRule' value='<%=ApplyEnum.CHECKRULE_DEFAULT%>'/>";
    			$("#nodeBlank0").after("<th id='nodeTitle"+indexTemp+"'>"+userArray[0].userName+hiddenHTML+"</th><td id='nodeBlank"+indexTemp+"'></td>");
				if(selType=="person"){
					$("#nodeImgArrows0").after("<th id='nodeImg"+indexTemp+"'><img src='../images/person.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td id='nodeImgArrows"+indexTemp+"'><img src='../images/arrows.png' /></td>");
				}else if(selType=="post"){
					$("#nodeImgArrows0").after("<th id='nodeImg"+indexTemp+"'><img src='../images/post.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td id='nodeImgArrows"+indexTemp+"'><img src='../images/arrows.png' /></td>");
				}
    			document.getElementById("index").value = indexTemp;
    		}else{
    			var hiddenHTML = "<input type='hidden' id='userID1' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' id='userName1' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' id='nodeType1' name='nodeType' value='"+userArray[0].selType+"'/><input type='hidden' id='checkRule1' name='checkRule' value='<%=ApplyEnum.CHECKRULE_DEFAULT%>'/>";
    			$("#nodeBlank0").after("<th id='nodeTitle1'>"+userArray[0].userName+hiddenHTML+"</th><td id='nodeBlank1'></td>");
    			if(selType=="person"){
    				$("#nodeImgArrows0").after("<th id='nodeImg1'><img src='../images/person.png' onclick='appandDiv(event,1)' /></th><td id='nodeImgArrows1'><img src='../images/arrows.png' /></td>");
    			}else if(selType=="post"){
    				$("#nodeImgArrows0").after("<th id='nodeImg1'><img src='../images/post.png' onclick='appandDiv(event,1)' /></th><td id='nodeImgArrows1'><img src='../images/arrows.png' /></td>");
        		}
        		document.getElementById("index").value = 1;
    		}
       }
    }
    function getReturnUserPostMethod2(userArray){
        var userArray = eval(userArray);
        isOperate = true;
	    if(type=='radio'){
	    	var selType = userArray[0].selType;
         	var flag = document.getElementById("flag").value;
    		var index = document.getElementById("index").value;
    		var indexTemp = Number(index)+ 1;
    		var hiddenHTML = "<input type='hidden' id='userID"+indexTemp+"' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' id='userName"+indexTemp+"' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' id='nodeType"+indexTemp+"' name='nodeType' value='"+userArray[0].selType+"'/><input type='hidden' id='checkRule"+indexTemp+"' name='checkRule' value='<%=ApplyEnum.CHECKRULE_DEFAULT%>'/>";
    		$("#nodeBlank"+ flag).after("<th id='nodeTitle"+indexTemp+"'>"+userArray[0].userName+hiddenHTML+"</th><td id='nodeBlank"+indexTemp+"'></td>");
    		if(selType=="person"){
    			$("#nodeImgArrows"+ flag).after("<th id='nodeImg"+indexTemp+"'><img src='../images/person.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td	id='nodeImgArrows"+indexTemp+"'><img src='../images/arrows.png' /></td>");
    		}else if(selType=="post"){
    			$("#nodeImgArrows"+ flag).after("<th id='nodeImg"+indexTemp+"'><img src='../images/post.png' onclick='appandDiv(event,"+indexTemp+")' /></th><td id='nodeImgArrows"+indexTemp+"'><img src='../images/arrows.png' /></td>");
    		}
    		document.getElementById("index").value = indexTemp;
       }
    }
    function getReturnUserPostMethod3(userArray){
        var userArray = eval(userArray);
        isOperate = true;
	    if(type=='radio'){
	    	var selType = userArray[0].selType;
         	var flag = document.getElementById("flag").value;
         	var hiddenHTML = "<input type='hidden' id='userID"+flag+"' name='userID' value='"+userArray[0].userID+"'/><input type='hidden' id='userName"+flag+"' name='userName' value='"+userArray[0].userName+"'/><input type='hidden' id='nodeType"+flag+"' name='nodeType' value='"+userArray[0].selType+"'/><input type='hidden' id='checkRule"+flag+"' name='checkRule' value='<%=ApplyEnum.CHECKRULE_DEFAULT%>'/>";
    		$("#nodeTitle"+ flag).replaceWith("<th id='nodeTitle"+flag+"'>"+userArray[0].userName+hiddenHTML+"</th>");
    		if(selType=="person"){
    			$("#nodeImg"+ flag).replaceWith("<th id='nodeImg"+flag+"'><img src='../images/person.png' onclick='appandDiv(event,"+flag+")' /></th>");
    		}else if(selType=="post"){
    			$("#nodeImg"+ flag).replaceWith("<th id='nodeImg"+flag+"'><img src='../images/post.png' onclick='appandDiv(event,"+flag+")' /></th>");
    		}
       }
    }

    function commit(){
		if(isOperate){
			var userID = document.getElementsByName("userID");
			var userName = document.getElementsByName("userName");
			var nodeType = document.getElementsByName("nodeType");
			var checkRule = document.getElementsByName("checkRule");
			var isExist = document.getElementById("isExist");//此flow是否之前已经有了节点的标识
			$("#addBtn").attr("disabled","disabled");
			DwrMethod.delFlownode(flowID.value,function(param){
				if(param){
					if(userID.length){
						for(var i=0;i<userID.length;i++){
							if(i == userID.length-1){
								DwrMethod.addFlownode(<%=ApplyEnum.ORDERNUM_END%>,flowID.value,userID[i].value,userName[i].value,nodeType[i].value,checkRule[i].value,function(para){
									if(para=="failure"){
										document.getElementById('promptSpan').innerHTML = "编辑模板失败！";
										setTimeout("document.getElementById('promptSpan').innerHTML=''",3000);
										return;
									}else{
										window.close();
									}
								})
							}else{//orderNum从2开始，申请人是1，即ApplyEnum.ORDERNUM_END
								DwrMethod.addFlownode(i+2,flowID.value,userID[i].value,userName[i].value,nodeType[i].value,checkRule[i].value,function(para){
									if(para=="failure"){
										document.getElementById('promptSpan').innerHTML = "编辑模板失败！";
										setTimeout("document.getElementById('promptSpan').innerHTML=''",3000);
										return;
									}
								})
							}
						}
					}else{
						window.close();
					}
				}
			});
		}else{//若节点没有相应的操作，则直接关闭，即只’查看‘，不修改，也不删除
			window.close();
		}
    }

    $(document).ready(function(){
    	if(flowType!=0&&flowType!=2){//视频会议申请，录像文件导出
    		$("#operateDiv ul li").last().remove();
		}
    	if(!!(window.attachEvent && navigator.userAgent.indexOf('Opera') === -1)){//判断IE
			document.getElementById("lockmask").className="lockDivIE";
		}else{
			document.getElementById("lockmask").className="lockDiv";
		}
      DwrMethod.getFlownode(flowID.value,function(para){
		if(para){
		  var data = eval(para);
		  var hiddenHTML;
		  for(var i = (data.length-1);i>=0;i--){
			if(data[i].checkType==<%= ApplyEnum.CHECKTYPE_PERSON%>){
				hiddenHTML = "<input type='hidden' id='userID"+(i+1)+"' name='userID' value='"+data[i].userID+"'/><input type='hidden' id='userName"+(i+1)+"' name='userName' value='"+data[i].flownodeName+"'/><input type='hidden' id='nodeType"+(i+1)+"' name='nodeType' value='person'/><input type='hidden' id='checkRule"+(i+1)+"' name='checkRule' value='"+data[i].checkRule+"'/>";
				$("#nodeBlank0").after("<th id='nodeTitle"+(i+1)+"'>"+data[i].flownodeName+hiddenHTML+"</th><td id='nodeBlank"+(i+1)+"'></td>");
				$("#nodeImgArrows0").after("<th id='nodeImg"+(i+1)+"'><img src='../images/person.png' onclick='appandDiv(event,"+(i+1)+")' /></th><td id='nodeImgArrows"+(i+1)+"'><img src='../images/arrows.png' /></td>");
			}else if(data[i].checkType==<%= ApplyEnum.CHECKTYPE_POST%>){
				hiddenHTML = "<input type='hidden' id='userID"+(i+1)+"' name='userID' value='"+data[i].postNO+"'/><input type='hidden' id='userName"+(i+1)+"' name='userName' value='"+data[i].flownodeName+"'/><input type='hidden' id='nodeType"+(i+1)+"' name='nodeType' value='post'/><input type='hidden' id='checkRule"+(i+1)+"' name='checkRule' value='"+data[i].checkRule+"'/>";
				$("#nodeBlank0").after("<th id='nodeTitle"+(i+1)+"'>"+data[i].flownodeName+hiddenHTML+"</th><td id='nodeBlank"+(i+1)+"'></td>");
				$("#nodeImgArrows0").after("<th id='nodeImg"+(i+1)+"'><img src='../images/post.png' onclick='appandDiv(event,"+(i+1)+")' /></th><td id='nodeImgArrows"+(i+1)+"'><img src='../images/arrows.png' /></td>");
			}
		  }
		  document.getElementById("index").value = data.length;
		  document.getElementById("isExist").value = data.length;//此流程是否有节点的标识
		}
      })
    })
</script>
</body>
</html>
