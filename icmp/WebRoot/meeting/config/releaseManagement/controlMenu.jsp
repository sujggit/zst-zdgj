<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>控制菜单</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <style>
  	.stdtable th, .stdtable td { vertical-align: middle; color: #fff;word-break:keep-all;white-space:normal;overflow:hidden;text-overflow:ellipsis }
  	.controlMenuUL li{float: left;margin-left: 10px;}
  </style>
  </head>
  <body onload="menu()">
  	<div id="contentwrapper" class="contentwrapper">
  		<%@include file="./pageLabel.jsp"%>
  		<input type="hidden" id="editRowNum"/>
  		<input type="hidden" id="sumRowNum"/>
  		<div id="basicform">
			<div class="contenttitle2">
	          <h5 class="fwb fl10">控制菜单编辑</h5>
	          <h5 class="fwb fr10"><a onclick="addNewGroup()">增加  </a><span> | </span><a onclick="delGroups()">删除</a></h5>
	        </div>
	    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="stdtable" style="table-layout: auto">
	    	  <thead>
	    		<tr>
	    			<th class="head1" width="50px"><input type="checkbox" id="chkAll" onclick="ChkA03Click('chkSon','chkAll')"/></th>
	    			<th class="head1" width="166px">组名称<font size="-10" color="red">(最长6个汉字)</font></th>
	    			<th class="head1">组宽度</th>
	    			<th class="head1" width="%">功能区</th>
	    			<th class="head1" width="99px">操作</th>
	    		</tr>
	    	  </thead>
	    	  <tbody id='groupTbody'>
	    	  	<tr id="noGroupTR">
	    		  <td class="alc"><br /></td>
		          <td><input disabled="disabled" value="未分组的功能"/></td>
		          <td>总宽度 960 PX</td>
		          <td>
		          	<ul class="controlMenuUL" id="noGroupCM"></ul>
		          </td>
		          <td class="alc">
		          	<a id="noGroupControl" onclick="editFinish()" style="display: none;"/>完成编辑
		          </td>
		        </tr>
	    	  	<c:forEach items="${findList}" var="dVO" varStatus="state">
	    	  	  <c:if test="${dVO.sysValue<0}" >
	    	  	    <script>
	    	  	    	$(document).ready(function(){
	    	  	    		var dicValue = "${dVO.dicValue}";
		    	  	    	var dicViewName = "${dVO.dicViewName}"
		    	  	    	$("#noGroupCM").append("<li><input type='checkbox' name='controlMenuNone' value='"+dicValue+"' checked='checked' onclick='this.checked=!this.checked' disabled='disabled'/><label>"+dicViewName+"</label></li>");
		    	  	    })
	    	  	    </script>
	    	  	  </c:if>
	    	  	  <c:if test="${dVO.sysValue>0}" >
	    	  	    <script>
	    	  	    	$(document).ready(function(){
		    	  	    	var index = ${dVO.sysValue};
		    	  	    	var tempstr="";
		    	  	    	var groupName = "${dVO.description}";
		    	  	    	if($("#groupCM"+index).html()==null){
			    	  	    	$("#sumRowNum").val(index);
			    	  	    	$("#groupTbody").append("<tr><td class='alc' id='groupChk"+index+"'><input name='chkSon' id='chk"+index+"' type='checkbox'/></td><td><input id='groupID"+index+"' maxlength='6' name='groupName' value='"+groupName+"'/></td><td><input id='groupRatio"+index+"' name='groupRatio' value='${dVO.createUserID }'/></td><td><ul id='groupCM"+index+"' class='controlMenuUL'></ul></td><td class='alc'><a id='groupControl"+index+"' onclick='editCM("+index+")' name='groupControl'>编辑功能</a></td></tr>");
				    	  	}
	    	  	    		var dicValue = "${dVO.dicValue}";
		    	  	    	var dicViewName = "${dVO.dicViewName}";
		    	  	    	$("#groupCM"+index).append("<li><input type='checkbox' name='controlMenuNone' value='"+dicValue+"' checked='checked' onclick='this.checked=!this.checked' disabled='disabled'/><label>"+dicViewName+"</label></li>");
		    	  	    })
	    	  	    </script>
	    	  	  </c:if>
	    	  	</c:forEach>
	    	  </tbody>
	    	</table>
	    	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	        <tfoot>
	        </tfoot>        
	        <tbody>
	          <tr>
	            <td>
	              <span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
	              <input type="button" class="submit1 radius2" value="确 定" onclick="saveConfig();"/>
	            </td>
	          </tr>
	        </tbody>
          </table>
	    </div>
    </div>
    <script type="text/javascript">
      function menu(){
		document.getElementById("m4").style.backgroundColor="#fff";
	  }

	function editCM(trID){
		//如果当前又正在被编辑的，先结束上次编辑，再开始此次编辑
		if($("#editRowNum").val()){
			editFinish();
		}
		//1、当编辑当前行的功能组时，当前行的‘编辑功能’消失，未分组行的‘完成编辑’出现
		$("#chk"+trID).attr("checked","checked");
		$("#noGroupControl").attr("style","display: block");
		$("#groupControl"+trID).attr("style","display: none");
		$("#editRowNum").val(""+trID);//记录当前组的行号？？
		//2、未分组功能区：取消禁用，以供编辑
		var noGroupCMs = $("#noGroupCM input:checkbox");
		for(var i=0;i<noGroupCMs.length;i++){
			$(noGroupCMs[i]).removeAttr("disabled");
			//$(noGroupCMs[i]).attr("onclick","editC(this,\"groupCM"+trID+"\",\"noGroupCM\")");
			$(noGroupCMs[i]).parent().unbind("mouseup");//必须解绑，否则持续绑定editC事件，eg:多次编辑就会绑定了editC(this,"groupCM1","noGroupCM"),editC(this,"groupCM2","noGroupCM")...
			$(noGroupCMs[i]).parent().bind("mouseup",function editFun(){
				editC(this,"groupCM"+trID,"noGroupCM");
			});
		}
		//3、正在编辑的功能组：取消禁用，以供编辑
		var groupCMs = $("#groupCM"+trID+" input:checkbox");
		for(var i=0;i<groupCMs.length;i++){
			$(groupCMs[i]).removeAttr("disabled");
			//$(groupCMs[i]).attr("onclick","editC(this,'noGroupCM','groupCM"+trID+"')");
			$(groupCMs[i]).parent().unbind("mouseup");
			$(groupCMs[i]).parent().bind("mouseup",function(){
				editC(this,"noGroupCM","groupCM"+trID);
			});
		}
	}

	function editFinish(){
		var currentRowNum = $("#editRowNum").val();
		//1、当点击‘完成编辑’时，结束编辑，正在编辑行的‘编辑功能’出现，‘完成编辑’消失
		$("#noGroupControl").attr("style","display: none");
		$("#groupControl"+currentRowNum).attr("style","display: block");
		$("#chk"+currentRowNum).removeAttr("checked");
		//2、未分组功能区：禁用checkbox，取消编辑
		var noGroupCMs = $("#noGroupCM input:checkbox");
		for(var i=0;i<noGroupCMs.length;i++){
			$(noGroupCMs[i]).attr("disabled","disabled");
		}
		//3、正在编辑的功能组：禁用checkbox，取消编辑
		var groupCMs = $("#groupCM"+currentRowNum+" input:checkbox");
		for(var i=0;i<groupCMs.length;i++){
			$(groupCMs[i]).attr("disabled","disabled");
		}
		$("#editRowNum").val('');
	}

	function addNewGroup(){
		editFinish();
		$("#sumRowNum").val(Number($("#sumRowNum").val())+1);
		var sumRowNum = $("#sumRowNum").val();
		$('#groupTbody').append("<tr><td class='alc' id='groupChk"+sumRowNum+"'><input name='chkSon' id='chk"+sumRowNum+"' type='checkbox'/></td><td><input id='groupID"+sumRowNum+"' name='groupName' maxlength='6' value='新建分组"+sumRowNum+"'/></td><td><input id='groupRatio"+sumRowNum+"' name='groupRatio'/></td><td><ul id='groupCM"+sumRowNum+"' class='controlMenuUL'></ul></td><td class='alc'><a id='groupControl"+sumRowNum+"' onclick='editCM("+sumRowNum+")' name='groupControl'>编辑功能</a></td></tr>");
	}
	function delGroups(){
		var chkSons = $("input[name='chkSon']:checked");
		if(chkSons.length){
			if(!window.confirm("是否确认删除当前选中的分组？")) return;
			for(var i=0;i<chkSons.length;i++){
				$("#noGroupCM").append($(chkSons[i]).parent().next().next().next().html());//将删除行的功能添加到未分组的功能项中
				editFinish();
				$(chkSons[i]).parent().parent().remove();
			}
		}else{
			alert("请至少选择一个功能组！");
		}
	}
	
	function editC(c,targetID,currentID){
		$(c).children().first().attr("disabled","disabled");
		$(c).clone().appendTo($("#"+targetID));
		//$(c).next().clone().appendTo($("#"+targetID));
		//删除当前的checkbox以及其后的值
		$(c).remove();
		//$(c).remove();
	}

	function saveConfig(){
		editFinish();
		var groupNames = document.getElementsByName("groupName");
		var groupRatios= document.getElementsByName("groupRatio");
		var str = "";
		var counts=0;
		for(var i=0;i<groupNames.length;i++){
		   if(isNaN(groupRatios[i].value)||groupRatios[i].value==""){
		    alert("组宽度必须为数字");
		    return;
		     }else{
		     counts+=parseInt(groupRatios[i].value);
			if(!groupNames[i].value){
				alert("功能组名称不能为空！");
				return;
			}else{
			    //var ulID = $(groupNames[i]).parent().next().children().first().attr('id');
				var tdID = $(groupNames[i]).parent().next().next().children().first().attr("id");
				if(!$("#"+tdID).html()){
					alert("功能区的功能不能为空！");
					return;
				}else{
					str += groupNames[i].value+"~"+groupRatios[i].value + ",";
					var controlMenus = $("#"+tdID+" li").children();
					for(var j=1;j<=controlMenus.length;j++){
						if(j%2==0){
							if(j<controlMenus.length){
								str += $(controlMenus[j-1]).html() + "&";
							}else{
								str += $(controlMenus[j-1]).html() + ";";
							}
						}else{
							str += controlMenus[j-1].value + ",";
						}
					}
				}
			}
			}
		}
		if(counts>960){
		alert("各组宽度之和为:"+counts+" 超过了总宽度:960");
		}else{
		DwrMethod.saveControlMenuConfig(str,function(para){
			if(para){
				document.getElementById("promptSpan").innerHTML = "控制菜单配置成功！";
			}else{
				document.getElementById("promptSpan").innerHTML = "控制菜单配置失败！";
			}
		})
	}
	}
  </script>
  </body>
</html>
