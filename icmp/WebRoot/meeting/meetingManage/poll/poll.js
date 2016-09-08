/*页面初始化*/
function init(){
	
	$(".screen").each(
		function(index,dom){
			$(this).droppable({
				drop:function(event,ui){
					ui.draggable.attr("style","cursor:pointer");
					ui.draggable.clone().appendTo('#'+$(this).attr("id")+' ul');
					ui.draggable.remove();
					$('#'+$(this).attr("id")+' li').draggable({ revert:'invalid',addClasses: false });
				}
			});
		});
		$('#confList1 li').draggable({ revert:'invalid',addClasses: false });
		$('ul,li').disableSelection();
		
}

function venueSortable(){
	$(".participants ul").each(
		function(index,dom){
			$(this).sortable();
		}
	);
	
}

var globalMeetingDetailId = "";
var globalProjectName = "";
function setGlobalProjectName(projectName){
	globalProjectName = projectName;
}
function setGlobalMeetingDetailId(meetingDetailId){
	globalMeetingDetailId = meetingDetailId;
}

/*下一步*/
function nextStep(){
	var ifShow = "";
	if( document.getElementById("ifShow") != null ){
		ifShow = document.getElementById("ifShow").checked;
	}
	
	//marker标识符，用于标识此次下一步点击出自几分屏
	var layoutMode = document.getElementById("layoutMode").value;
	var mcuMode = document.getElementById("mcuMode").value;
	var pollTemplate = document.getElementById("pollTemplate").value;
	var meetings = new Array();
	//meetings.push(marker);
	$("ul").each(function(i){
		var str = "";
		$("#"+$(this).attr("id")+" li").each(function(i){
			if(str!=""){
				str += "_";
			}
			//str += $(this).html();
			str += $(this).find("input").val();
		});
		if(str == ""){
			str += "None";
		}
		meetings.push(str);
	});
	window.location.href = globalProjectName+'/mcuControl/getPollList1.action?meetingDetailID=' + globalMeetingDetailId+'&meetings='+meetings+'&layoutMode='+layoutMode+'&mcuMode='+mcuMode+'&pollTemplate='+pollTemplate+'&ifShow='+ifShow;
}
/*删除单个会场*/
function delTerminal(id){
	if($("#"+$("#"+id).parent().attr("id")+" li").size()==1){
		alert("不能删除所有会场！");
		return;
	}
	$("#"+id).remove();
}

function delMeeting(id){
	if($("#"+$("#"+id).parent().attr("id")+" li").size()==1){
		alert("不能删除所有会议！");
		return;
	}
	$("#"+id).remove();
}
/*确定轮询*/
function callPoll(){
	var intervalTime = document.getElementById("intervalTime").value;
	var mcuMode = document.getElementById("mcuMode").value;
	var layoutMode = document.getElementById("layoutMode").value;
	var meetings = document.getElementById("meetings").value;
	var infos = new Array();
	$("ul").each(function(i){
		var infosTemp = new Array();
		$("#"+$(this).attr("id")+" li").each(function(i){
			infosTemp.push($(this).find("input").val());
		});
		if(infosTemp.length==0){
			infosTemp.push("None");
		}
		infos.push(infosTemp);
	})
	McuDwrMethod.startPoll(globalMeetingDetailId,mcuMode,layoutMode,infos,intervalTime,meetings,callback);
}
function callback(result){
	if(result=="ok"){
		alert("轮询成功");
		/*window.opener.document.getElementById("polla").innerHTML='<img src="'+globalProjectName+'/meeting/meetingManage/image/report/lx.png" align="absmiddle" /> 停止轮询';
		window.opener.document.getElementById("polla").setAttribute("onclick", "stopPoll1()");
		
		window.opener.document.getElementById("suspolla").innerHTML='<img src="'+globalProjectName+'/meeting/meetingManage/image/report/ztlx.png" align="absmiddle" /> 暂停轮询';
		window.opener.document.getElementById("suspolla").setAttribute("onclick", "suspendPoll()");

		window.opener.document.getElementById("suspolla").style="color:black";*/
		window.close();
	}else{
		alert("轮询失败");
		window.close();
	}
}

/**
 * 定制轮询添加会场操作
 * @param thisSelect
 * @return
 */
function addTer(thisSelect){
	if( thisSelect.value == "-1"){//没选择会场
		return;
	}
	var scrul = document.getElementById("terList"+thisSelect.id);//选择当前下拉框对应的ul
	
	
	var lis = $("#terList"+thisSelect.id+" li");//取该ul下所有li
	
	for( var i=0; i<lis.length; i++ ){
		var liQuery = $(lis[i]);
		var inValue = $("#"+liQuery.attr("id")+" input:first");
		if( inValue.val() == thisSelect.value ){
			alert("已选择该会场");
			return;
		}
	}
	var len = $("#terList"+thisSelect.id+" li").length+1;
	var liid = "ter"+thisSelect.id+len;
	var newli="<li id='"+liid+"'>"+"<input type='hidden' value='"+thisSelect.value+"'/><input   type='button' class='participantsDelBtn' value='删除' /><span class='participantsSpan'>"+thisSelect.options[thisSelect.selectedIndex].text+"</span></li>";
	$("#terList"+thisSelect.id).append(newli);
	$("#"+liid).bind("click",function(){
		delTerminal(liid);
	});
//	var newli = document.createElement("li");
	//newli.id = thisSelect.value.substring(0,5);
//	newli.innerHTML = "<input type='hidden' value='"+thisSelect.value+"'/><input type='button' class='participantsDelBtn' value='删除' id='del"+thisSelect.value+"' onclick='delTerminal('"+thisSelect.value.substring(0,5)+"')'/><span class='participantsSpan'>"+thisSelect.options[thisSelect.selectedIndex].text+"</span>";
	
//	scrul.appendChild(newli);
//	document.getElementById("del"+thisSelect.value).setAttribute("onclick", "delTerminal('"+thisSelect.value.substring(0,5)+"')");
	//$("#del"+thisSelect.value).attr("onclick","delTerminal('"+thisSelect.value+"')");
}

function modifyPoll(){
	var intervalTime = document.getElementById("intervalTime").value;
	var infos = new Array();
	$("ul").each(function(i){
		var infosTemp = new Array();
		$("#"+$(this).attr("id")+" li").each(function(i){
			infosTemp.push($(this).find("input").val());
		});
		if(infosTemp.length==0){
			infosTemp.push("None");
		}
		infos.push(infosTemp);
	})
	McuDwrMethod.modifyPoll(globalMeetingDetailId,infos,intervalTime,function modifyPoll(result){
		if( result == "ok"){
			alert("增加成功");
			window.close();
		}else if( result == "nopoll"){
			alert("会议没有轮询");
			window.close();
		}else {
			alert("操作失败");
			window.close();
		}
	});
}