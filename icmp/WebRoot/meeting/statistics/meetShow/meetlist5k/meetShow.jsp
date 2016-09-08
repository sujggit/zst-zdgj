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
var sqls="";
function querySubmit(){
sqls="";
var table=document.getElementById("OwnershipStructure"); 

var trs=table.rows;

for(var i=0;i<trs.length-1;i++){
var cs=trs[i].childNodes;
var strName=cs[0].childNodes[0].value;
var strType=cs[1].childNodes[0].value;
var strVal=cs[2].childNodes[0].value;
if(strName!=""&&strType!=""&&strVal!=""){
if(strName=="view_meeting_dept_name"){
strVal=cs[2].childNodes[1].value;
sqls+=" and view_depLinkCode like 'Percent,"+strVal+",Percent'" ;
}else{
if(strType=='in'){
sqls+=" and "+strName+" like 'Percent"+strVal+"Percent'" ;
}else{
sqls+=" and "+strName+" "+strType+" '"+strVal+"'" ;
}
}
}
}
var iframe=document.getElementById("queryFrame");
if(sqls!=""){
iframe.src="${sys_ctx }/vmeeting5k/getMeetingInfoList.action?findvm.strsql="+encodeURI(encodeURI((sqls)));
}else{
iframe.src="${sys_ctx }/vmeeting5k/getMeetingInfoList.action?findvm.viewMeetingYear=${findvm.viewMeetingYear }";
}
document.getElementById("modeChangeItem1").selected="true";
}

function SelectChange(sname){
var contTime='<input type="text" readonly="readonly" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'});" />';
var contDep='<input type="text" class="inputtran" id="corpName" onclick="selectDepartments(this);" readonly="readonly" /><input type="hidden" id="corpID" />';
var contInp='<input type="text" />';
var row=sname.parentNode.parentNode;
var cs=row.childNodes;
if(sname.value=="view_startTime"){
cs[2].innerHTML=contTime;
}else if(sname.value=="view_meeting_type"){
cs[2].innerHTML=document.getElementById("selectMeetingType").innerHTML;
}else if(sname.value=="view_meeting_dept_name"){
cs[2].innerHTML=contDep;
}else{
cs[2].innerHTML=contInp;
}

}

function modeSelect(modeName){
var frameSrc="";
var tempstr="";
if(sqls!=""){
tempstr="?findvm.strsql="+encodeURI(encodeURI((sqls)));
}else{
tempstr="?findvm.viewMeetingYear=${findvm.viewMeetingYear }";
}

if(modeName=="meetShowDep"){
frameSrc="${sys_ctx }/vmeeting5k/viewDeptTotal.action"+tempstr;
}else if(modeName=="meetShowMonth"){
frameSrc="${sys_ctx }/vmeeting5k/viewMonthTotal.action"+tempstr;
}else if(modeName=="meetShowNotice"){
frameSrc="${sys_ctx }/vmeeting5k/viewNoticeTotal.action"+tempstr;
}else if(modeName=="meetShowType"){
frameSrc="${sys_ctx }/vmeeting5k/viewTypeTotal.action"+tempstr;
}else  if(modeName=="meetShowAll"){
frameSrc="${sys_ctx }/vmeeting5k/getMeetingInfoList.action"+tempstr;
}

var iframe=document.getElementById("queryFrame");
iframe.src=frameSrc;

}
//打印方法
function excelPrint(){
	var src = document.getElementById("queryFrame").src;
	//alert(src);
	src += "&isPrint=isPrint"
	window.showModalDialog(src,window,'dialogWidth=29.7cm;dialogHeight=21cm;');
}

function excelExport(){
var modeName=document.getElementById("modeChange").value;
var frameSrc="";
var tempstr="";
if(sqls!=""){
tempstr="?efindvm.strsql="+encodeURI(encodeURI((sqls)));
}else{
tempstr="?efindvm.viewMeetingYear=${findvm.viewMeetingYear }";
}

if(modeName=="meetShowDep"){
frameSrc="${sys_ctx }/vmeeting5k/viewDeptTotalExport.action"+tempstr;
}else if(modeName=="meetShowMonth"){
frameSrc="${sys_ctx }/vmeeting5k/viewMonthTotalExport.action"+tempstr;
}else if(modeName=="meetShowNotice"){
frameSrc="${sys_ctx }/vmeeting5k/viewNoticeTotalExport.action"+tempstr;
}else if(modeName=="meetShowType"){
frameSrc="${sys_ctx }/vmeeting5k/viewTypeTotalExport.action"+tempstr;
}else  if(modeName=="meetShowAll"){
frameSrc="${sys_ctx }/vmeeting5k/getMeetingInfoListExport.action"+tempstr;
}
document.getElementById('excelID').href=frameSrc;

}

function selectDepartments(thisDom){
	              var departParameters = {
	                  methodName:'getReturnDepartMethod',
	                  selectType:'radio',
	                  extraDept:'false',
	                  middleSelect:'true'
	              }
	             creatDepartmentSelect(thisDom,departParameters); 
	          }
 function getReturnDepartMethod(departList){
		    	var departmentID="";
	            var departmentName="";
	            var depLength = departList.length;
	            for(var i=0;i<depLength;i++){
	              departmentID+=departList[i].departmentID;
	              departmentName+=departList[i].departmentName;
	              //alert(departList[i].departmentName+" + "+departList[i].departmentID);
	            }
	          	$("#corpID").attr("value",departmentID);
               	$("#corpName").attr("value",departmentName);
}

</script> 
</head>
<body>

<div id="selectStatus" style="display: none;" >
<select id="status"  class="select200 fontstyle">
 <zzst:option type="meetingStatus" value="${meetingDetailVO.status}" required="false"/>
</select>
</div>
<form id="pageform"></form>
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
			  <h5 class="fwb fl10">查询列表&nbsp;&nbsp;
       <select id="modeChange"  onchange="modeSelect(this.value);">
            <option id="modeChangeItem1" value="meetShowAll">会议详情</option>
			<!-- <option id="modeChangeItem2" value="meetShowDep">部门统计</option> -->
			<option id="modeChangeItem3" value="meetShowMonth">月统计</option>
			<!-- <option id="modeChangeItem4" value="meetShowNotice">标签统计</option> -->
			<option id="modeChangeItem5" value="meetShowType">类型统计</option>
		</select>		
        </h5>
        
		<h5 class="fwb fl10" style="float:right" ><a href="#" onclick="excelPrint();">打印预览</a>&nbsp;|&nbsp;<a id="excelID" href="" onclick="excelExport();">导出</a>&nbsp;</h5>
		</div>

<iframe id="queryFrame" frameborder="0" style="height: 800px;" width="100%" src="${sys_ctx }/vmeeting5k/getMeetingInfoList.action?findvm.viewMeetingYear=${findvm.viewMeetingYear }" >
</iframe>
</div>	
</body>
</html>