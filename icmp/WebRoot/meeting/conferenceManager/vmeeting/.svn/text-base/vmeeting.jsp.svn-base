<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>会议管理</title>
	<script language="javascript" type="text/javascript"> 
function AddStructureRow() 
{ 
var obj=document.getElementById("OwnershipStructure"); 
var trs=obj.rows.length;
if(trs>6){
alert('只支持6个条件');
}else{
var tr =obj.insertRow(1); 
var td0 = tr.insertCell(0); 
td0.setAttribute("class","tableaddtitle searched"); 
td0.innerHTML = document.getElementById("StructureRightTd0").innerHTML; 
var td1 = tr.insertCell(1); 
td1.setAttribute("class","tableaddtitle searched"); 
td1.innerHTML =document.getElementById("StructureRightTd1").innerHTML;  
var td2 = tr.insertCell(2); 
td2.setAttribute("class","tableaddtitle searched"); 
td2.innerHTML =document.getElementById("StructureRightTd2").innerHTML; 
var td3 = tr.insertCell(3); 
td3.setAttribute("class","tableaddtitle searched"); 
td3.innerHTML ='<a href="#" class="lvse"><img src="${sys_ctx }/images/vmeeting/cancel_search.gif" onclick="DelStructureRow(this)"  /></a>'; 
} 
}

function DelStructureRow(row) 
{ 
var obj=document.getElementById("OwnershipStructure"); 
obj.deleteRow(row.parentNode.parentNode.parentNode.rowIndex); 

} 

function querySubmit(){
var table=document.getElementById("OwnershipStructure"); 

var trs=table.rows;
var sqls="";
for(var i=0;i<trs.length-1;i++){
var cs=trs[i].childNodes;
var strName=cs[0].childNodes[0].value;
var strType=cs[1].childNodes[0].value;
var strVal=cs[2].childNodes[0].value;
if(strName!=""&&strType!=""&&strVal!=""){
if(strType=='in'){
sqls+=" and "+strName+" like 'Percent"+strVal+"Percent'" ;
}else{
sqls+=" and "+strName+" "+strType+" '"+strVal+"'" ;
}
}
}
var iframe=document.getElementById("queryFrame");
if(sqls!=""){

iframe.src="${sys_ctx }/vmeetingDetail/query.action?strsql="+encodeURI(encodeURI((sqls)));
}else{
iframe.src="${sys_ctx }/vmeetingDetail/query.action";
}

}

function SelectChange(sname){
var contTime='<input type="text" readonly="readonly" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'});" />';
var contInp='<input type="text" />';
var row=sname.parentNode.parentNode;
var cs=row.childNodes;
if(sname.value=="startTime"||sname.value=="endTime"){
cs[2].innerHTML=contTime;
}else if(sname.value=="STATUS"){
cs[2].innerHTML=document.getElementById("selectStatus").innerHTML;
}else if(sname.value=="meetingType"){
cs[2].innerHTML=document.getElementById("selectMeetingType").innerHTML;
}else{
cs[2].innerHTML=contInp;
}

}


</script> 
</head>
<body>
<div id="selectStatus" style="display: none;" >
<select id="status"  class="select200 fontstyle">
 <zzst:option type="meetingStatus" value="${meetingDetailVO.status}" required="false"/>
</select>
</div>

<div id="selectMeetingType" style="display: none;" >
<select class="select200 fontstyle">
<option value="">请选择</option>
<option value="1">本地会议</option>
<option value="2">视频会议</option>
</select>
</div>
<div class="contentwrapper">
	<table id="OwnershipStructure" width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" align="center">
		<tr id="StructureRight">
			<td id="StructureRightTd0" class="tableaddtitle searched">
				<select onchange="SelectChange(this)">
					<option value="">请选择</option>
					<c:forEach items="${strname}" var="name" varStatus="state">
					<option value="${name[0] }">${name[1] }</option>
					</c:forEach>
				</select>
			</td>
			<td id="StructureRightTd1" class="tableaddtitle searched">
				<select>
					<option value="">请选择</option>
					<c:forEach items="${strtype}" var="types" varStatus="state">
					<option value="${types[0] }">${types[1] }</option>
					</c:forEach>
				</select>
			</td>
			<td id="StructureRightTd2" class="tableaddtitle searched"><input type="text" /></td>
			<td id="StructureRightTd3" class="tableaddtitle searched" >
				<a href="#" class="lvse"><img id="addRow110" onclick="AddStructureRow()" src="${sys_ctx }/images/vmeeting/add_search.gif" /></a>
			</td>
		</tr>
		
				
		<tr>
			<td class="tableaddtitle" colspan="4"><input type="reset" class="stdbtn mlr10" onclick="querySubmit()" value="查 询" /></td>
		</tr>
	</table>

	<div class="widgetcontent">
		<div class="msgmore" onclick="disquery();">
			<a href="javascript:void(0);">
				<img src="${sys_ctx }/style/normal/images/calarrow_1.png" width="51" height="5" border="0" />
				
				<map name="Map" id="Map">
					<area shape="rect" coords="2,-1,6,7" href="" />
					<area shape="rect" coords="36,0,51,6" href="" />
				</map>
			</a>
		</div>
	</div>  
</div>
<div id="basicform" class="contentwrapper">
<div class="contenttitle2">
			<h5 class="fwb fl10">会议记录</h5>
			<h5 class="fwb fr10"></h5>
		</div>

<iframe id="queryFrame" frameborder="0" style="height: 800px;" width="100%" src="${sys_ctx }/vmeetingDetail/query.action" >
</iframe>
</div>	
</body>
</html>