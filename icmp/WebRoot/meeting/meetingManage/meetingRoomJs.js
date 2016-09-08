//get an element position
var room_Name = new Array();//所有会场名称数组 会场名_mcukeyid
var t_IP = new Array();//所有终端ip数组 终端ip_mcukeyid
var mcu_IP = new Array();//所属mcuIP数组 终端ip_mcukeyid
var mcuIps = new Array();//当前开会的mcu数组

function getElementPos(elementId) {
	var ua = navigator.userAgent.toLowerCase();
	var isOpera = (ua.indexOf('opera') != -1);
	var isIE = (ua.indexOf('msie') != -1 && !isOpera); // not opera spoof
	var el = document.getElementById(elementId);
	if(el.parentNode === null || el.style.display == 'none') {
	  return false;
	}      
	var parent = null;
	var pos = [];     
	var box;     
	if(el.getBoundingClientRect)    //IE
	{         
	   box = el.getBoundingClientRect();
	   var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
	   var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
	  return {x:box.left + scrollLeft, y:box.top + scrollTop};
	}else if(document.getBoxObjectFor)    // gecko    
	{
	   box = document.getBoxObjectFor(el); 
	   var borderLeft = (el.style.borderLeftWidth)?parseInt(el.style.borderLeftWidth):0; 
	   var borderTop = (el.style.borderTopWidth)?parseInt(el.style.borderTopWidth):0; 
	   pos = [box.x - borderLeft, box.y - borderTop];
	} else    // safari & opera    
	{
	   pos = [el.offsetLeft, el.offsetTop]; 
	   parent = el.offsetParent;     
	   if (parent != el) { 
	    while (parent) { 
	     pos[0] += parent.offsetLeft; 
	     pos[1] += parent.offsetTop; 
	     parent = parent.offsetParent;
	    } 
	   }   
	   if (ua.indexOf('opera') != -1 || ( ua.indexOf('safari') != -1 && el.style.position == 'absolute' )) { 
	    pos[0] -= document.body.offsetLeft;
	    pos[1] -= document.body.offsetTop;         
	   }    
	}              
	if (el.parentNode) { 
	   parent = el.parentNode;
	} else {
	   parent = null;
	}
	while (parent && parent.tagName != 'BODY' && parent.tagName != 'HTML') { // account for any scrolled ancestors
	   pos[0] -= parent.scrollLeft;
	   pos[1] -= parent.scrollTop;
	   if (parent.parentNode) {
	    parent = parent.parentNode;
	   } else {
	    parent = null;
	   }
	}
	return {x:pos[0], y:pos[1]};
}
//******************************************add js function by wangle 2013-2-18***********************************************************
var globalMeetingDetailId = "";
var globalProjectName = "";

function setGlobalMeetingDetailId(meetingDetailId){
	globalMeetingDetailId = meetingDetailId;
}

function setGlobalProjectName(projectName){
	globalProjectName = projectName;
}

function stopKstMeeting(){
	var kstMeetNumber = $("#kstMeetNumber").val();
	var meetingDetailID = getMeetingDetailId();
	DwrMethod.stopMonitoring(kstMeetNumber,meetingDetailID,function(back){
		alert(back);
	});
}
var index = 0;


Array.prototype.del=function(n) {  //n表示第几项，从0开始算起。
//prototype为对象原型，注意这里为对象增加自定义方法的方法。
  if(n<0)  //如果n<0，则不进行任何操作。
    return this;
  else
    return this.slice(0,n).concat(this.slice(n+1,this.length));
    /**//*
      concat方法：返回一个新数组，这个新数组是由两个或更多数组组合而成的。
      　　　　　　这里就是返回this.slice(0,n)/this.slice(n+1,this.length)
     　　　　　　组成的新数组，这中间，刚好少了第n项。
      slice方法： 返回一个数组的一段，两个参数，分别指定开始和结束的位置。
    */
}


function show(id){

$("#"+id).toggle();
}

//设置个人模式 （主会场广播） add by yangyi
function setPersonalMode(room){
var meetingRoomMID = "";
var roomIDs = assembleRoomIDs(room, true);
if(room == "room"){
var roomID = roomIDs.split(",");
if(roomID.length > 1){
	alert("一次操作只能设置一个会场为个人模式！");
	return;
}
meetingRoomMID = document.getElementById("mparticipantid_"+roomIDs).value;
}
var meetingDetailId = getMeetingDetailId();

ControlDWR.setPersonalMode(meetingDetailId, roomIDs, meetingRoomMID, "", function(result){

});
}

//分会场广播	add by yangyi
function setSecondRoomBroad(room){
var meetingRoomMID = "";
if(room == "room"){
var meetingDetailId = getMeetingDetailId();
var roomIDs = assembleRoomIDs(room, true);

var roomID = roomIDs.split(",");

if(roomID.length > 1){
	alert("一次操作只能广播一个分会场！");
	return;
}
meetingRoomMID = document.getElementById("mparticipantid_"+roomIDs).value;
}
ControlDWR.setSecondRoomBroad(meetingDetailId, roomIDs, meetingRoomMID, function(result){

});
}

//点名（个人模式下） add by yangyi 
function callMeetingRoom(forceID,roomInfo){
var meetingDetailId = getMeetingDetailId();
ControlDWR.callMeetingRoom(meetingDetailId, forceID, roomInfo, function(result){
if(result != ""){
	alert(result);
}
});
}

//开始轮询（个人模式）
function startRolling(room){
var rollInfo = "";
if(room == "room"){
var meetingDetailId = getMeetingDetailId();
var roomIDs = assembleRoomIDs(room, true);
var roomInfo = roomIDs.split("-");

if((roomInfo.length) <= 1){
	roomIDs = assembleRoomIDs(room, "all");
	roomInfo = roomIDs.split("-");
}

for(var i=0;i<roomInfo.length;i++){
	var roomMID = document.getElementById("mparticipantid_"+roomInfo[i]).value;
	rollInfo += roomInfo[i]+"-"+roomMID
	if(i<(roomInfo.length-1)){
		rollInfo += ",";
	}				
}

ControlDWR.startRolling(meetingDetailId,rollInfo);
}
}

//开始或暂停轮询
function startOrStopRolling(room){
var rollInfo = "";
if(room == "room"){
var meetingDetailId = getMeetingDetailId();
var roomIDs = assembleRoomIDs(room, true);
var roomInfo = roomIDs.split("-");

if((roomInfo.length) <= 1){
	roomIDs = assembleRoomIDs(room, "all");
	roomInfo = roomIDs.split("-");
}

for(var i=0;i<roomInfo.length;i++){
	var roomMID = document.getElementById("mparticipantid_"+roomInfo[i]).value;
	rollInfo += roomInfo[i]+"-"+roomMID
	if(i<(roomInfo.length-1)){
		rollInfo += ",";
	}				
}

}

ControlDWR.startOrStopRolling(meetingDetailId,rollInfo,"10");
}

//停止轮询（个人模式）
function stopRolling(room){
ControlDWR.stopRolling();
}

//预监换屏
function changeScreen(){
var meetingDetailId = getMeetingDetailId();
ControlDWR.changeMonitor(meetingDetailId);
}

function scrollToElement(nodeTypeId, ElementId){
var nodeType = document.getElementById(nodeTypeId);
if(nodeType.value == "1"){
var pos=getElementPos(ElementId);
window.scroll(0,pos.y);
}
}

function backUpCreatConfInMcu(){
var meetingDetailId = getMeetingDetailId();
ControlDWR.backUpCreatConfInMcu(meetingDetailId,function(){
location.href = globalProjectName + "/mcuControl/getClassifiedRoomList.action";
});
}

function assembleRoomIDs(room, isChecked){
var roomIDs = "";
var rooms = document.getElementsByName(room);

if(isChecked == "all"){
for(var i=0; i < rooms.length; i++){
	if(roomIDs != ""){
		roomIDs += "-";
	}
	roomIDs += rooms[i].value;
}

}else if(isChecked){
for(var i=0; i < rooms.length; i++){
	if(rooms[i].checked == true){
		if(roomIDs != ""){
			roomIDs += "-";
		}
		
		roomIDs += rooms[i].value;
	}
}
}else if(!isChecked){
for(var i=0; i < rooms.length; i++){
	if(rooms[i].checked == false){
		if(roomIDs != ""){
			roomIDs += "-";
		}
		
		roomIDs += rooms[i].value;
	}
}
}

return roomIDs;
}

function getPlayPtsMessage(room){
var meetingDetailId = getMeetingDetailId();
var roomIDs = assembleRoomIDs(room, true);
McuDwrMethod.moveToNextEP(meetingDetailId, getPlayPtsMessageCallBack);
}

function getPlayPtsMessageCallBack(){

//window.open(''+ playMessage);
// window.showModalDialog(playMessage);

}
function muteParticipants(room, isMuted){
var roomIDs = assembleRoomIDs(room, true);
var meetingDetailId = getMeetingDetailId();
if(isMuted == "true"){ 
//mute participants
McuDwrMethod.muteParticipants(meetingDetailId, roomIDs, true, muteParticipantsCallBack);
}else{
//unmute participants
McuDwrMethod.muteParticipants(meetingDetailId, roomIDs, false, muteParticipantsCallBack);
}
}

function muteParticipantsCallBack(map){
cancle();
}

function blockParticipants2(room, isMuted){
var roomIDs = assembleRoomIDs(room, true);
var meetingDetailId = getMeetingDetailId();
if(isMuted == "true"){ 
//mute participants
McuDwrMethod.blockParticipants(meetingDetailId, roomIDs, true, blockParticipantsCallBack);

}else{
//unmute participants
McuDwrMethod.blockParticipants(meetingDetailId, roomIDs, false, blockParticipantsCallBack);
}
}
function blockParticipantsCallBack(map){
cancle();
}

function suspendParticipants2(room, isMuted){
var roomIDs = assembleRoomIDs(room, true);
var meetingDetailId = getMeetingDetailId();


if(isMuted == "true"){ 
//mute participants
mcuControlMethod.suspendParticipants(meetingDetailId, roomIDs, true, suspendParticipantsCallBack);
}else{
//unmute participants
mcuControlMethod.suspendParticipants(meetingDetailId, roomIDs, false, suspendParticipantsCallBack);
}
}
function suspendParticipantsCallBack(map){
cancle();
}

function addParticipants(){
var meetingDetailID = getMeetingDetailId();
if(meetingDetailID==false){
	return;
}
window.open(globalProjectName + '/mcuControl/getOtherRoomList.action?chooseMeetingNumber='+meetingDetailID+'&op=add&date=' + new Date(),'getOtherRoomList','width=620px,height=445px,directories,scrollbars=yes');
	
}
function addRollMeetingRoom(meetingDetailID){
window.open(globalProjectName + '/mcuControl/pollMeetingRoomList.action?chooseMeetingNumber=${chooseMeetingNumber}&op=add&date=' + new Date(),'pollMeetingRoomList','width=700px,height=550px,directories,scrollbars=yes');
}

//打开显示层
function viewDIV(divID){
document.getElementById(divID).style.display="block";
}

//隐藏显示层
function closeDIV(divID){
document.getElementById(divID).style.display="none";
}


//开始轮询
function startPolling(){
/*closeDIV('lunXunTimeDiv');
var meetingDetailID = getMeetingDetailId();
if(!meetingDetailID){
return;
}
var meetingRoomIDs = assembleRoomIDs("room", true);

var roomInfo = meetingRoomIDs.split("-");

if((roomInfo.length) <= 1){
meetingRoomIDs = assembleRoomIDs("room", "all");
}

var intervalTime = document.getElementById("lunXunTimeID").value;

mcuControlMethod.startPolling(meetingDetailID,meetingRoomIDs,intervalTime);*/
	var videoMode = document.getElementById("videoMode1").value;
	var lectureName = document.getElementById("lectureName").value;
	var	meetingDetailID = getMeetingDetailId();
	window.open(globalProjectName + '/mcuControl/getAllMeetingRoom.action?meetingDetailID=' + meetingDetailID+'&videoMode='+videoMode+'&lectureName='+lectureName,'poll','width=700px,height=475px,directories,scrollbars=yes');
}

function stopPolling(){
	var meetingDetailId = getMeetingDetailId();
	var videoMode = document.getElementById("videoMode1").value;
	var lectureName = document.getElementById("lectureName").value;
	McuDwrMethod.stopPoll(meetingDetailId,videoMode,lectureName);
}

//var deletedPts = new Array();
function delParticipants(room){
var	meetingDetailID = getMeetingDetailId();
if(meetingDetailID != false){
	$("#abc").trigger("update");
	if($("#tbodyId tr td span :checkbox:checked").length > 0){
		if(confirm("确定删除会场吗?")){
			var roomIDs = assembleRoomIDs(room, true);
			//var rooms = document.getElementsByName(room);
			McuDwrMethod.deleteParticipant(meetingDetailID, roomIDs, function delBackup(){});
		}
	}else{
		alert("请选择会场");
	}
}
}
/*
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	//delete participant
	var roomID = rooms[i].value;
	//deletedPts[deletedPts.length] = roomID;
	McuDwrMethod.deleteParticipant('${chooseMeetingNumber}', roomID, function delBackup(meetingMcu){
	
isUpdated = true; 
$("#abc").trigger("update")
	});
}
}
*/


function muteOtherParticipants(room, isMuted){
var roomIDs = assembleRoomIDs(room, false);
var meetingDetailId = getMeetingDetailId();
McuDwrMethod.muteParticipants(meetingDetailId, roomIDs, "", true, muteParticipantsCallBack);

roomIDs = assembleRoomIDs(room, true);
McuDwrMethod.muteParticipants(meetingDetailId, roomIDs, "", false, muteParticipantsCallBack);

}

function dialParticipants(room, isDialed){
var meetingDetailId = getMeetingDetailId();
var roomIDs = assembleRoomIDs(room, true);

if(isDialed == "true"){
McuDwrMethod.dialParticipants(meetingDetailId, roomIDs, true, dialParticipantsCallBack);
//var rooms = document.getElementsByName(room);
//for(var i=0; i < rooms.length; i++){
//	if(rooms[i].checked == true){
		//dial participants
//		document.getElementById("img_connect_" + rooms[i].value).src = globalProjectName + "/images/rmx1000/connecting.gif";	
//	}
//}
}else{
//disconnect participants
//var roomIDs = assembleRoomIDs(room, true);
McuDwrMethod.dialParticipants(meetingDetailId, roomIDs, false, dialParticipantsCallBack);
}
}

function dialParticipantsCallBack(map){
cancle();
}

function changeContentTokenOwner(room, isContentTokenOwner){
var meetingDetailId = getMeetingDetailId();
var roomID = "";
var count = 0;
var rooms = document.getElementsByName(room);
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	count++;
	roomID += rooms[i].value;
}
}

if(count == 1){
if(isContentTokenOwner == "true"){
	McuDwrMethod.changeContentTokenOwner(meetingDetailId, roomID, true,function(isSuccessful){cancle();});
}else{
	McuDwrMethod.changeContentTokenOwner(meetingDetailId, roomID, false,function(isSuccessful){cancle();});	
}
}else{
if(count == 0){
	alert("请选择一个会议室作为双流发送者！");
}else{
	alert("只能选择一个会议室成为双流发送者！");
}
}
}

// terminal
function terminal(room){
var meetingDetailID = getMeetingDetailId();
var roomID = "";
var count = 0;
var rooms = document.getElementsByName(room);
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	count++;
	roomID += rooms[i].value;
	
}
}
if(count == 1){
window.open(globalProjectName + '/meetingManage/dech.jsp?meetingDetailID=' + meetingDetailID +'&roomID=' + roomID +'&mark=1'  ,'03','width=700px,height=475px,directories,scrollbars=yes');
}else{
if(count == 0){
	alert("请选择一个会议室！");
}else{
	alert("一次只能选择一个会议室！");
}
}
}


// sendPacketLoss
function sendPacketLoss(room){
var meetingDetailID = getMeetingDetailId();
var roomID = "";
var count = 0;
var rooms = document.getElementsByName(room);
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	count++;
	roomID += rooms[i].value;
	
}
}
if(count == 1){
window.open(globalProjectName + '/conf/getPtsChannel.action?meetingDetailID=' + meetingDetailID +'&roomID=' + roomID   ,'03','width=700px,height=475px,directories,scrollbars=yes');
}else{
if(count == 0){
	alert("请选择一个会议室！");
}else{
	alert("一次只能选择一个会议室！");
}
}
}

//发送双流
function sendShuangl(room, isSend){
var meetingDetailId = getMeetingDetailId();

var roomID = "";
var count = 0;
var rooms = document.getElementsByName(room);
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	count++;
	roomID += rooms[i].value;
}
}
if(count == 1){
if(isSend == 'true'){
	mcuControlMethod.changeContentTokenOwner(meetingDetailId, roomID, true,
		function(isSuccessful){
			cancle();
	});
}else if(isSend == 'false'){
	mcuControlMethod.changeContentTokenOwner(meetingDetailId, roomID, false,
		function(isSuccessful){
			cancle();
	});
}
}else{
if(count == 0){
	alert("请选择一个会议室！");
}else{
	alert("只能选择一个会议室！");
}
}
}


function setPresident(room){
var meetingDetailId = getMeetingDetailId();
var roomID = "";
var count = 0;
var roomIDs = assembleRoomIDs(room, true);

var roomID = roomIDs.split(",");

if(roomID.length > 1){
alert("只能选择一个会场！");
return;
}

if(roomID.length == 1){
mcuControlMethod.setLecturer(meetingDetailId, roomIDs, 
			function(isSuccessful){
				cancle();
			}
	);
}else{
if(count == 0){
	alert("请选择一个会议室！");
}else{
	alert("只能选择一个会场！");
}
}
}

/**
停止监测
*/
function stopBlowDown(room){
var roomID = "";
var rooms = document.getElementsByName(room);
var name = "";
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	document.getElementById("checkC_" + rooms[i].value).style.display="none";
	if(rooms[i].value == bID && bID != "" &&bID != null){
	parent.right.window.clearTimeout(mark);
	parent.right.window.stopImg();
	parent.window.aa(blowUpIp);
	}
}else{

}
}
}

/**
继续监测
*/
function stopBlowUp(room){
var meetingDetailId = getMeetingDetailId();
var roomID = "";
var count = 0;

var rooms = document.getElementsByName(room);
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	document.getElementById("checkC_" + rooms[i].value).style.display="";
	if(rooms[i].value == bID){
	parent.right.window.clearTimeout(mark);
	parent.right.window.blowUp(blowUpIp,bName,bID);
	parent.window.aa(blowUpIp);
	}
}else{

}
}
}

function setSpeaker(roomID,ifNeedMute){
	var meetingDetailId = getMeetingDetailId();
	var commandIp = document.getElementById("commandIp_"+roomID).value;
	var linkSiteInput = document.getElementById("infoIps_" +commandIp);
	if(linkSiteInput != null ){//级联会 设为发言人入口
	McuDwrMethod.setSpeakerOnLinkConf(meetingDetailId, roomID,linkSiteInput.value,ifNeedMute,
			function(isSuccessful){
					cancle();
				});
		
	}else{
		McuDwrMethod.setSpeaker(meetingDetailId, roomID,ifNeedMute,
				function(isSuccessful){
					cancle();
				}
			);
	}

}
/* modified by wangle in 2010-10-26
function meetingRoomStatusBackup(){
}
*/	


/**
* interval call method  更新会场状态

function getMeetingRoomList(room){
//var rooms = document.getElementsByName(room);
//var meetingDetailID = '${chooseMeetingNumber}';
room_Name = new Array();
t_IP = new Array();
mcu_IP = new Array();


var td_roomNames = document.getElementsByName("td_Mcu_participant_name");
var td_roomIp = document.getElementsByName("td_Mcu_participant_ip");
var td_Mcu = document.getElementsByName("td_Mcu");
for( var i=0; i<td_roomNames.length; i++ ){
	var td_id = td_roomNames[i].id;
	var val_roomName = td_roomNames[i].innerHTML+"_"+td_id.split("_")[1];
	room_Name.push(val_roomName);//会场名数组
}
for( var i=0; i<td_roomIp.length; i++ ){
	var td_id = td_roomIp[i].id;
	t_IP.push(td_id);//会场ip数组
}
for( var i=0; i<td_Mcu.length; i++ ){
	var td_MCU = td_Mcu[i].id;
	mcu_IP.push(td_MCU);//所属mcu数组
}

//获取mcuIps
McuDwrMethod.getMeetingMcuIPs(meetingDetailID,function backIps(strs){
	if(strs.length == 0){
	   return;
	}
    mcuIps= new Array();
	mcuIps = strs;
})


if(globalMeetingDetailId != null && globalMeetingDetailId != ""){
	McuDwrMethod.getMeetingMcuList(globalMeetingDetailId, roomStatusCallBack);
	}
}

*/
/* modified by wangle in 2010-10-26
function testRoom(lst){
}
*/	
//save previous room Id list to check if there is the room that was deleted.
var prevRoomIdLst = new Array();
//save latest room id list.
var latestRoomIdLst = new Array();

var kst_mcu_isChoosed = false;
//2013-2-22
var totalPtsKeyId = "";
var currentOnlineNumber = 0;
/**
*call back room status 
*/
//备注的回调 
function terminalCommentCallBack( result ){
	if(result != null  ){
		for( var key in  result ){
			if(document.getElementById("comment_"+key)!=null){
			document.getElementById("comment_"+key).innerHTML=result[key];
			document.getElementById("comment_"+key).title=result[key];
			}
			
			var content = result[key];
			//updateCell(content,"comment","room_"+key);
		}
		//$("#abc").trigger("update");
	}
}



function roomStatusCallBack(lst){
if(lst == null || lst.length <= 0){
/*	
if(!confirm("会议意外终止，是否重建？")){
	window.clearInterval(intervalFunc);
	deleteTbody("tbodyId");
	return;
}else{
	alert("正在准备重建......");
	McuDwrMethod.createConf('${chooseMeetingNumber}', function(){alert("已经重建完成！！！");});
	return;
}
window.clearInterval(intervalFunc);
window.clearInterval(intervalPingFunc);
 
deleteTbody("tbodyId");
*/
//refresh page when conference doesn't exist
window.setTimeout("refreshSelf('2')", 3000);
return;
}
//alert("lst.length:"+lst.length);
var isChoosed = false;

updateRoomIdList(true, 0);
var isCascade = false;

//alert("lst[0]:"+lst[0].meetingMCUKeyID);

for(var i=0; i < lst.length; i++){
	if(lst[i] != null){
		if(i != lst.length -1 ){
			var aTr = document.getElementById("room_" + lst[i].meetingMCUKeyID);
			var equipmentIP = lst[i].mcu_participant_ip;
			if(equipmentIP == "${sys_kst_mcu_ip}"){
				isChoosed = true;
			}
			if(aTr == null){
				createTr(lst[i]);
			}else{
				if(lst[i] != null){
					 opRoomStatus(lst[i]);//更新会场状态
				}
			}
			//update used mcu port
			if(lst[i].meetingMcuVO != null && lst[i].meetingMcuVO.nodeType == 1){
				 updateUsedMcuPort(lst[i]);
				 isCascade = true;
			}else{
				if(lst[i].meetingMcuVO != null && lst[i].meetingMcuVO.nodeType == 2){
					updateUsedMcuPort(lst[i]);
					isCascade = true;
				}else{
					if(i == lst.length-1 && isCascade == false){
						updateUsedMcuPort(lst[i]);
					}
				}
			}
		}else{
			document.getElementById("meetingRoomCount").innerHTML = lst[i].ptsNumber;
		}
		
		//check and collect latest room id list
		//updateRoomIdList(false, lst[i].meetingMCUKeyID);
		//check if it is necessary to delete pts 
		//if(i == lst.length - 1){
		//	deletePts();
		//}
		if(i == lst.length - 1){
			totalPtsKeyId = lst[i].description;
			//check and collect latest room id list
			var ptsArray = totalPtsKeyId.split("__");
			for(var j=0; j<ptsArray.length; j++){
				updateRoomIdList(false, ptsArray[j]);
			}
			//check if it is necessary to delete pts 
			deletePts();
			currentOnlineNumber = lst[i].ptsNumber;
		}
	}
}


kst_mcu_isChoosed = isChoosed;

//delete selected pts after clicking deleting operation 
//deletePts(lst);
//alert("isUpdated is " + isUpdated);

if(isUpdated){
isUpdated = false; 
$("#abc").trigger("update");
}/*
alert("wangle end funct");
*/
lst.length = 0;

//alert("kst_mcu_isChoosed::"+kst_mcu_isChoosed);
//window.setTimeout("getMeetingRoomList('${chooseMeetingNumber}')", 2000);
//getMeetingRoomList('${chooseMeetingNumber}');
	window.setTimeout("getMeetingRoomList('${chooseMeetingNumber}')",3000);
}

function updateUsedMcuPort(meetingRoom){
if(meetingRoom == null || meetingRoom.mcuEquipment == null){
return;
}
var usedMcuPortObject = document.getElementById("used_pts_audio_number_" + meetingRoom.mcuEquipment.meetingMCUKeyID);
if(usedMcuPortObject != null){
if(meetingRoom.mcuEquipment.description == null || meetingRoom.mcuEquipment.description == ""){
	usedMcuPortObject.innerHTML = "0";
}else{
	if(usedMcuPortObject.innerHTML != meetingRoom.mcuEquipment.description){
		usedMcuPortObject.innerHTML = meetingRoom.mcuEquipment.description;
	}
}
}
}

function updateRoomIdList(isInitial, latestMeetingRoomID){
if(isInitial){
if(latestRoomIdLst == null){
	latestRoomIdLst =  new Array();
}else{
	latestRoomIdLst.length = 0;
}	
return;
}
//collect latest room id
latestRoomIdLst[latestRoomIdLst.length] = latestMeetingRoomID;
//delete room id from previous room id list
if(prevRoomIdLst == null || prevRoomIdLst.length == 0){
return;
}
for(var k=prevRoomIdLst.length - 1; k >= 0; k--){
if(prevRoomIdLst[k] == latestMeetingRoomID){
	prevRoomIdLst = prevRoomIdLst.del(k);
	break;
}	
}	
}
function  deletePts(){
if(prevRoomIdLst != null && prevRoomIdLst.length > 0){
for(var k=prevRoomIdLst.length - 1; k >= 0; k--){
	var tr = document.getElementById("room_" + prevRoomIdLst[k]);
	if(tr != null){
		tr.parentNode.removeChild(tr);
	}
}
}
prevRoomIdLst = latestRoomIdLst;
latestRoomIdLst = new Array();
}
/*
//delete selected pts after clicking deleting operation 
function  deletePts(lst){
if(deletedPts != null && deletedPts.length > 0){
for(var k=deletedPts.length - 1; k >= 0; k--){
	var isFound = false;
	for(var j=0; j < lst.length; j++){
		if(deletedPts[k] == lst[j].meetingRoomID){
			//not to delete this pts when lst has this pts element
			isFound = true;
			break;
		}
	}
	if(!isFound){
		var tr = document.getElementById("room_" + deletedPts[k]);
		if(tr != null){
			tr.parentNode.removeChild(tr);	
			deletedPts = deletedPts.del(k);
		}
	}
}
}
}
*/
function deleteTbody(tbodyId){
var tb = document.getElementById(tbodyId);  
if(tb != null){
tb.parentNode.removeChild(tb);
}		
}

/**
*create a new row including role, connection status, call speed and so on
*/
function createTr(meetingRoom){
	/*
if(meetingRoom == null || meetingRoom == null ){
return;	
}
if(meetingRoom.nodeType != null &&  meetingRoom.nodeType == 2){
return;
}
var cellInfos = new Array();

var tbodyId = meetingRoom.mcuIp;
var tb = document.getElementById("tbodyId"); 
alert(tb);
var rnum = tb.rows.length+1; 
var row = document.createElement("tr");
row.id = "room_" + meetingRoom.meetingMCUKeyID;
//row.style="border:1px solid #2d96dc;";
row.setAttribute("style", "border:1px solid #2d96dc;"); 


//create checkbox and room name
var cell = document.createElement("td");  
cell.className = "ac fontstyle";
cell.innerHTML = "<input type='checkbox'  name='room' value='" + meetingRoom.mcu_participant_name + "__" +meetingRoom.mcuMeetingID+ "__" + meetingRoom.mcuIp + "' id='checkbox_" + meetingRoom.meetingMCUKeyID + "_a'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.nodeType + "' id='nodeType_" + meetingRoom.mcu_participant_ip + "'/>";
row.appendChild(cell);	

cell = document.createElement("td");  
cell.className = "ac fontstyle";
cell.innerHTML +="<SPAN title='" + meetingRoom.mcu_participant_name + "'/>";
cell.innerHTML +="<font title='" + meetingRoom.mcu_participant_name + "' id=\"font_" + meetingRoom.meetingMCUKeyID + "\" color=\"#005F00\">";
//cell.innerHTML +="<a style=\"cursor:hand\" title='" + meetingRoom.mcu_participant_name + "' onclick=\"scrollToElement('nodeType_"+ meetingRoom.mcu_participant_ip +"', 'tableId_" + meetingRoom.mcu_participant_ip + "');\">" + meetingRoom.mcu_participant_name+"</a>";
cell.innerHTML +="<a style=\"cursor:hand\" title='" + meetingRoom.mcu_participant_name + "' onclick=ipGo('"+ meetingRoom.mcu_participant_ip+"')>" + meetingRoom.mcu_participant_name+"</a>";
cell.innerHTML +="</font></SPAN>";
cell.innerHTML +="<input type='hidden' value='" + meetingRoom.mcu_participant_name + "' id='" + meetingRoom.meetingMCUKeyID + "'/>";
row.appendChild(cell);

//comment
cell = document.createElement("td");  
cell.className = "ac fontstyle";
row.appendChild(cell);

//create Ip
cell = document.createElement("td");  
cell.className = "ac fontstyle";
cell.innerHTML ="<SPAN>";
cell.innerHTML +="<a style=\"cursor:hand\" onclick=\"ipGo('"+ meetingRoom.mcu_participant_ip +"');>" + meetingRoom.mcu_participant_ip+"</a>";
cell.innerHTML += "</SPAN>";
row.appendChild(cell);	

//create connect status
cell = document.createElement("td"); 
cell.className = "ac fontstyle"; 
if(meetingRoom.connectStatus == 1){
cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">1</SPAN>";
cell.innerHTML += "<img src=globalProjectName + '/images/rmx1000/connected.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>" ;
}else{
if(meetingRoom.connectStatus == 2){
	cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">2</SPAN>";
	cell.innerHTML += "<img src=globalProjectName + '/images/rmx1000/connecting.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>" ;
}else{
	cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">3</SPAN>";
	cell.innerHTML += "<img src=globalProjectName + '/images/rmx1000/disconnected.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>" ;
}
}
row.appendChild(cell);	

//create audio status				
cell = document.createElement("td"); 
cell.className = "ac fontstyle";
if(meetingRoom.audio == 1 && meetingRoom.connectStatus == 1){
//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
cell.innerHTML = "";
cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
cell.innerHTML += "&nbsp;<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
}else{
if(meetingRoom.audio == 2 && meetingRoom.connectStatus == 1){
	//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML = "";
	cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
}else{
	if(meetingRoom.audio == 3 && meetingRoom.connectStatus == 1){
		//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
		cell.innerHTML = "";
		cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
	}else{
		if(meetingRoom.audio == 4 && meetingRoom.connectStatus == 1){
			//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
			cell.innerHTML = "";
			cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
		}else{
			if(meetingRoom.audio == 5 && meetingRoom.connectStatus == 1){
				//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
				cell.innerHTML = "";
				cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
			}else{
				if(meetingRoom.audio == 6 && meetingRoom.connectStatus == 1){
					//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
					cell.innerHTML = "";
					cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
				}else{
					if(meetingRoom.audio == 7 && meetingRoom.connectStatus == 1){
						//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
						cell.innerHTML = "";
						cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
					}else{
						if(meetingRoom.audio == 8 && meetingRoom.connectStatus == 1){
							//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
							cell.innerHTML = "";
							cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
							cell.innerHTML += "&nbsp;<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
						}else{
							if(meetingRoom.audio == 9 && meetingRoom.connectStatus == 1){
								//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
								cell.innerHTML = "";
								cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
								cell.innerHTML += "&nbsp;<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
							}else{
								if(meetingRoom.audio == 10 && meetingRoom.connectStatus == 1){
									//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
									cell.innerHTML = "";
									cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
								}else{
									if(meetingRoom.audio == 11 && meetingRoom.connectStatus == 1){
										//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
										cell.innerHTML = "";
										cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
									}else{
										if(meetingRoom.audio == 12 && meetingRoom.connectStatus == 1){
											//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
											cell.innerHTML = "";
											cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
										}else{
											if(meetingRoom.audio == 13 && meetingRoom.connectStatus == 1){
												//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
												cell.innerHTML = "";
												cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
											}else{
												if(meetingRoom.audio == 14 && meetingRoom.connectStatus == 1){
													//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
													cell.innerHTML = "";
													cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
												}else{
													if(meetingRoom.audio == 15 && meetingRoom.connectStatus == 1){
														//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/speaker.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
														cell.innerHTML = "";
														cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
													}else{
														//cell.innerHTML = "<img src=globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_speaker_" + meetingRoom.meetingMCUKeyID + "'/>";
														cell.innerHTML = "";
														cell.innerHTML += "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/><img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
}
row.appendChild(cell);	

//create video
cell = document.createElement("td"); 
cell.className = "ac fontstyle";
if(meetingRoom.video == 1 && meetingRoom.connectStatus == 1){
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/suspendVideo.gif' id='img_video_" + meetingRoom.meetingMCUKeyID + "'/>";
}else{
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_video_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
row.appendChild(cell);	


//create role
cell = document.createElement("td");  
cell.className = "ac fontstyle";
if(meetingRoom.isLecturer == 1){
var rooms = document.getElementsByName('room');
for(var i=0; i < rooms.length; i++){
	cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_member_" + rooms[i].value + "'/>";	
}
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/lecturer.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}else{
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}

if(meetingRoom.isSpeaker == 1){
var rooms = document.getElementsByName('room');
for(var i=0; i < rooms.length; i++){
	cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_member_" + rooms[i].value + "'/>";	
}
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}else{
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}

if(meetingRoom.contentToken == 1 || meetingRoom.contentToken == 3){
cell.innerHTML += "&nbsp;&nbsp;<img src =globalProjectName + '/images/rmx1000/contentOwner.gif' id='is_content_owner_" + meetingRoom.meetingMCUKeyID + "'/>";
}else{
cell.innerHTML += "&nbsp;&nbsp;<img src =globalProjectName + '/images/rmx1000/blank.gif' id='is_content_owner_" + meetingRoom.meetingMCUKeyID + "'/>";
}

row.appendChild(cell);

//create content token
cell = document.createElement("td");  
cell.className = "ac fontstyle";
if(meetingRoom.contentToken == 2 || meetingRoom.contentToken == 3){
	cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/contentToken.gif' id='content_token_" + meetingRoom.meetingMCUKeyID + "'/>";
}else{
	cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='content_token_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
row.appendChild(cell);	


/*
//create alias
<!--		cell = document.createElement("td");  -->
<!--		cell.className = "cx_bgsx2";-->
<!--		cell.innerHTML ="<SPAN>" + meetingRoom.aliasName + "</SPAN>";-->
<!--		row.appendChild(cell);	-->


*/
//create dial direction 
/*
cell = document.createElement("td");  
cell.className = "ac fontstyle";
if((meetingRoom.casDialDirection == 'dial_out' || meetingRoom.casDialDirection == 'Dial-out' )&& meetingRoom.connectStatus == 1){
cell.innerHTML ="<SPAN id='casDialDirection_" +meetingRoom.meetingMCUKeyID+"'>呼出</SPAN>";
}
if((meetingRoom.casDialDirection == 'dial_in' || meetingRoom.casDialDirection == 'Dial-in' ) && meetingRoom.connectStatus == 1){
cell.innerHTML ="<SPAN id='casDialDirection_" +meetingRoom.meetingMCUKeyID+"'>呼入</SPAN>";
}
if(meetingRoom.connectStatus != 1){
cell.innerHTML ="<SPAN id='casDialDirection_" +meetingRoom.meetingMCUKeyID+"'>&nbsp;</SPAN>";
}
row.appendChild(cell);	
*/




/*
//create content token
cell = document.createElement("td");  
cell.width = "4%";
cell.className = "cx_bgsx2";
if(meetingRoom.contentToken == 2 || meetingRoom.contentToken == 3){
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/contentToken.gif' id='content_token_" + meetingRoom.meetingMCUKeyID + "'/>";
}else{
cell.innerHTML = "<img src =globalProjectName + '/images/rmx1000/blank.gif' id='content_token_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
row.appendChild(cell);	

//create send package loss
cell = document.createElement("td");  
cell.width = "4%";
cell.className = "cx_bgsx2";
cell.style.display="none";
if(meetingRoom.sendPacketLoss == null){
meetingRoom.sendPacketLoss = "";
}
cell.innerHTML ="<SPAN id='send_"+meetingRoom.meetingMCUKeyID+"'/>" + meetingRoom.sendPacketLoss + "</SPAN>";
row.appendChild(cell);	

//create send package loss
cell = document.createElement("td");  
cell.width = "4%";
cell.className = "cx_bgsx2";
cell.style.display="none";
if(meetingRoom.receivePacketLoss == null){
meetingRoom.receivePacketLoss = "";
}
cell.innerHTML ="<SPAN id='receive_"+meetingRoom.meetingMCUKeyID+"'/>" + meetingRoom.receivePacketLoss + "</SPAN>";
row.appendChild(cell);	



//create mcu
cell = document.createElement("td"); 
cell.width = "8%";
cell.className = "cx_bgsx2";
cell.innerHTML ="<SPAN> meetingRoom.mcuEquipment.equipmentName </SPAN>";
row.appendChild(cell);	
/*	
//add contact person	
cell = document.createElement("td");  
cell.width = "4%";
cell.className = "cx_bgsx2";
cell.innerHTML = "<SPAN style=\"cursor:hand\">" ;
if(meetingRoom.chargerName != null && meetingRoom.chargerName != ""){
cell.innerHTML += "<a href=\"javascript:void(0);\" onclick=\"pop_userList('" + meetingRoom.chargerID + "');mask1.style.visibility='visible';massage_box1.style.visibility='visible'\" onfocus=\"this.blur()\">" + meetingRoom.chargerName + "</a>";
}else{
cell.innerHTML += "&nbsp;&nbsp;";
}
cell.innerHTML += "</SPAN>";
row.appendChild(cell);		

//create call speed cell
cell = document.createElement("td"); 
cell.width = "5%";
cell.className = "cx_bgsx2";
cell.style.display="none";
if(meetingRoom.callSpeed == null){
cell.innerHTML = "<SPAN id='callSpeed_" + meetingRoom.meetingMCUKeyID + "' title='" + meetingRoom.callSpeed + " Kpbs'></SPAN>";
}else{
cell.innerHTML = "<SPAN id='callSpeed_" + meetingRoom.meetingMCUKeyID + "' title='" + meetingRoom.callSpeed + " Kpbs'>" + meetingRoom.callSpeed + "</SPAN>";
}
row.appendChild(cell);

tb.appendChild(row);//加一行

//右键操作
//addRightMenu("room_"+meetingRoom.meetingMCUKeyID);
//bgChange();
*/
window.location.reload();
}


/**
*operate room status specially
*/
function opRoomStatus(meetingMcu)
{
if(meetingMcu != null){
	var ptsFlag = meetingMcu.mcu_participant_name + "__" + meetingMcu.mcuMeetingID + "__" + meetingMcu.mcuIp;
	document.getElementById("connectstatus__" + ptsFlag).value = meetingMcu.connectStatus;		
	document.getElementById("audio__" + ptsFlag).value = meetingMcu.audio;	
	document.getElementById("video__" + ptsFlag).value = meetingMcu.video;	
	document.getElementById("contenttoken__" + ptsFlag).value = meetingMcu.contentToken;	
	document.getElementById("dialdirection__" + ptsFlag).value = meetingMcu.casDialDirection;	
	document.getElementById("lecturer__" + ptsFlag).value = meetingMcu.isLecturer;
	document.getElementById("speaker__" + ptsFlag).value = meetingMcu.isSpeaker;	
	document.getElementById("receivepacketloss__" + ptsFlag).value = meetingMcu.receivePacketLoss;
	document.getElementById("sendpacketloss__" + ptsFlag).value = meetingMcu.sendPacketLoss;
	//右键功能所需：room_${meetingRoom.meetingMCUKeyID}_IPConnectStatus
	document.getElementById("room_"+ meetingMcu.meetingMCUKeyID + "_IPConnectStatus").value = meetingMcu.connectStatus;
	document.getElementById("room_"+ meetingMcu.meetingMCUKeyID + "_video").value = meetingMcu.video;
	document.getElementById("room_"+ meetingMcu.meetingMCUKeyID + "_contentToken").value = meetingMcu.contentToken;
	document.getElementById("room_"+ meetingMcu.meetingMCUKeyID + "_audio").value = meetingMcu.audio;
//do audio
if(meetingMcu.audio == 1 && meetingMcu.connectStatus == 1){
	//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
	document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/mute.gif";
	document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";	
}else{
	if(meetingMcu.audio == 2 && meetingMcu.connectStatus == 1){
		//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
		document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/block.gif";
		document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";							
	}else {
		if(meetingMcu.audio == 3 && meetingMcu.connectStatus == 1){
		//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
		document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/muteAndBlock.gif";		
		document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
		}else {
			if(meetingMcu.audio == 4 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else{ 
			if(meetingMcu.audio == 5 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/mute.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else{ 
			if(meetingMcu.audio == 6 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/block.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else {
			if(meetingMcu.audio == 7 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/muteAndBlock.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else{
			if(meetingMcu.audio == 8 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";	
		}else{
			if(meetingMcu.audio == 9 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/mute.gif";
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";	
		}else{
			if(meetingMcu.audio == 10 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/block.gif";
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";							
		}else {
			if(meetingMcu.audio == 11 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/muteAndBlock.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
		}else {
			if(meetingMcu.audio == 12 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else{ 
			if(meetingMcu.audio == 13 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/mute.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else{ 
			if(meetingMcu.audio == 14 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/block.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else {
			if(meetingMcu.audio == 15 && meetingMcu.connectStatus == 1){
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/speaker.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/muteAndBlock.gif";		
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/ptsmute.gif";
		}else{
			//document.getElementById("img_audio_speaker_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			document.getElementById("img_audio_ptsmute_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
			}
		}}}}}}}
		}
		}
		}
		}
		}
	}
}
//do video
 
if(meetingMcu.video == 1 && meetingMcu.connectStatus == 1){
	document.getElementById("img_video_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/suspendVideo.gif";	
}else{
	document.getElementById("img_video_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
}

//	do casDialDirection
/*
if((meetingMcu.casDialDirection == 'dial_in' || meetingMcu.casDialDirection == 'Dial-in')&& meetingMcu.connectStatus == 1){
	document.getElementById("casDialDirection_" + meetingMcu.meetingMCUKeyID).innerHTML = "呼入";	
}else if((meetingMcu.casDialDirection == 'dial_out' || meetingMcu.casDialDirection == 'Dial-out')&& meetingMcu.connectStatus == 1){
	document.getElementById("casDialDirection_" + meetingMcu.meetingMCUKeyID).innerHTML = "呼出";
}else if(meetingMcu.connectStatus != 1){
	document.getElementById("casDialDirection_" + meetingMcu.meetingMCUKeyID).innerHTML = " ";
}
*/
var pic = document.getElementById("img_connect_" + meetingMcu.meetingMCUKeyID);
var spanObject = document.getElementById("span_img_connect_" + meetingMcu.meetingMCUKeyID);
if(pic != null && spanObject != null && meetingMcu.connectStatus == 1){
	//alert("wangle");
	if(pic.src.indexOf(globalProjectName + "/images/rmx1000/connected.gif") == -1){
		pic.src = globalProjectName + "/images/rmx1000/connected.gif";
		spanObject.innerHTML = "1";

		isUpdated = true;
	}
	
	document.getElementById("font_" + meetingMcu.meetingMCUKeyID).color="#4c94b7";		
	/*if(meetingMcu.callSpeed != null){
		document.getElementById("callSpeed_" + meetingMcu.meetingMCUKeyID).title = meetingMcu.callSpeed + " Kbps";
		document.getElementById("callSpeed_" + meetingMcu.meetingMCUKeyID).innerHTML = meetingMcu.callSpeed;
	}*/
}else{
	if(pic != null && spanObject != null && meetingMcu.connectStatus == 2){
		if(pic.src.indexOf(globalProjectName + "/images/rmx1000/connecting.gif") == -1){
			pic.src = globalProjectName + "/images/rmx1000/connecting.gif";
			spanObject.innerHTML = "2";

			isUpdated = true;
		}
		
		document.getElementById("font_" + meetingMcu.meetingMCUKeyID).color="#4c94b7";
	}else{
		if(pic != null && spanObject != null && meetingMcu.connectStatus == 3){
			if(pic.src.indexOf(globalProjectName + "/images/rmx1000/disconnected.gif") == -1){
				pic.src = globalProjectName + "/images/rmx1000/disconnected.gif";
				spanObject.innerHTML = "3";

				isUpdated = true;
			}
			
			//document.getElementById("callSpeed_" + meetingMcu.meetingMCUKeyID).innerHTML = "";
		}
	}
}
if(meetingMcu.isLecturer == 1){
	document.getElementById("img_member_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/lecturer.gif";
}else{
	if(meetingMcu.isSpeaker == 1){
		document.getElementById("img_member_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/broadcaster.gif";
	}else{
		document.getElementById("img_member_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
	}
}
  //alert("meetingMcu.contentToken::"+meetingMcu.contentToken);
		if(meetingMcu.contentToken == 1){ 
					 if(document.getElementById("content_token_" + meetingMcu.meetingMCUKeyID).src.indexOf(globalProjectName + "/images/rmx1000/contentToken.gif") != -1){ 
						document.getElementById("content_token_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif"; 
					 } 
					 document.getElementById("is_content_owner_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/contentOwner.gif"; 
		} 
		if(meetingMcu.contentToken != 1 && meetingMcu.contentToken != 3 ){ 
					document.getElementById("is_content_owner_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif"; 
		} 
		if(meetingMcu.contentToken == 3){ 
					document.getElementById("is_content_owner_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/contentOwner.gif"; 
					document.getElementById("content_token_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/contentToken.gif"; 
		} 
		if(meetingMcu.contentToken == 2 || meetingMcu.contentToken == 3 ){ 
			document.getElementById("content_token_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/contentToken.gif"; 
		}else{
			document.getElementById("content_token_" + meetingMcu.meetingMCUKeyID).src = globalProjectName + "/images/rmx1000/blank.gif";
		}
		
		if(meetingMcu.vOFractionLossPeak!=null||meetingMcu.vOFractionLossPeak != '0.0'){
			document.getElementById("send_"+ meetingMcu.meetingMCUKeyID).innerHTML =  meetingMcu.vOFractionLoss + " " + meetingMcu.vOFractionLossPeak;
		}
		if(meetingMcu.vIFractionLossPeak!=null||meetingMcu.vIFractionLossPeak != '0.0'){
			document.getElementById("receive_"+ meetingMcu.meetingMCUKeyID).innerHTML = meetingMcu.vIFractionLoss + " " + meetingMcu.vIFractionLossPeak;
		}
		if(meetingMcu.vOFractionLossPeak==null||meetingMcu.vOFractionLossPeak == '0.0'||meetingMcu.connectStatus == 3){
			document.getElementById("send_"+ meetingMcu.meetingMCUKeyID).innerHTML = "";
		}
		if(meetingMcu.vIFractionLossPeak==null||meetingMcu.vIFractionLossPeak=='0.0'||meetingMcu.connectStatus == 3){
			document.getElementById("receive_"+ meetingMcu.meetingMCUKeyID).innerHTML = "";
		}
		
}
}

//check roll
function callFor(id){
var meetingDetailID = document.getElementById("select").value;
window.open(globalProjectName + '/checkroll/callFor.action?meetingDetailID=' + meetingDetailID+ '&meetingMCUKeyID=' + id ,'example03','width=400px,height=190px,directories,scrollbars=yes');
}

function checkContentToken(roomID){
if(document.getElementById("content_token_" + roomID).src.indexOf(globalProjectName + "/images/rmx1000/contentToken.gif") != -1 
	|| document.getElementById("is_content_owner_" + roomID).src.indexOf(globalProjectName + "/images/rmx1000/contentOwner.gif") != -1){
return true;
}
return false;

}
                   
//checkall为设置全选
function checkall(oj){
var room = document.getElementById("checkAll");
if(room.checked == true && oj!= undefined){

      for (var i=0;i<oj.length;i++ )
            {
    	  	  //add cascade point condition by wangle 2013-09-22
    	      var temp = oj[i].id.split("_")[1]; 
    	      if(document.getElementById("room_" + temp + "_roomIP") != null){
	    		temp = document.getElementById("room_" + temp + "_roomIP").value;
	    		if(document.getElementById("nodeType_" + temp) != null){
	    			if(document.getElementById("nodeType_" + temp).value==2){
	    				continue;	
	    			}
	    		}
	    	  }
              oj[i].checked=true;
            }
}
if(room.checked == false &&oj!=undefined){
      for (var i=0;i<oj.length;i++ )
            {
              oj[i].checked=false;
            }
}
}

//标记

function checkS(id){
var aaa = document.getElementById("aa_"+id );
var meetingMCUKey = id;
if(aaa.checked==true){
window.open(globalProjectName + '/meetingManage/marker.jsp?meetingMCUKeyID=' + meetingMCUKey ,'example03','width=400px,height=170px,directories,scrollbars=yes');
}else if(aaa.checked==false){
McuDwrMethod.modifyUncheckroll(meetingMCUKey,callBack7);
}	
}
function callBack7(){
return;
}
//ping ip
/*function pingIP(){
var ip = document.getElementById("mcu_participant_ip").value;

McuDwrMethod.modifyCheckroll(ip, callBack1);

}
*/
function callBack1(mark){
var aa = document.getElementById("aaa");
if(mark==true){
aa.style.color="red"
}
}
//DOS  cmd
/*
function pingIP(){
McuDwrMethod.getPingIP(callBack3);
}	
function callBack3(){
return;
}*/

function changeS(){
var	meetingDetail = document.getElementById("filterSelectId").value; 
var layoutMode = document.getElementById("layoutMode").value;
layoutMode = "101"; 
var videoMode = document.getElementById("videoMode").value;
videoMode =	"LECTURE";
McuDwrMethod.setLayout(meetingDetail , layoutMode , videoMode , layoutCallBack);
}
function changeS2(){
var	meetingDetail = document.getElementById("filterSelectId").value; 
var layoutMode = document.getElementById("layoutMode").value;
layoutMode = "601"; 
var videoMode = document.getElementById("videoMode").value;
videoMode =	"SAME";
McuDwrMethod.setLayout(meetingDetail,layoutMode,videoMode,  layoutCallBack);

//remove role flag
var rooms = document.getElementsByName('room');
for(var i=0; i < rooms.length; i++){
if(document.getElementById("img_member_" + rooms[i].value).src.indexOf(globalProjectName + "/images/rmx1000/blank.gif") == -1){
	document.getElementById("img_member_" + rooms[i].value).src = globalProjectName + "/images/rmx1000/blank.gif";
}
}
}
function layoutCallBack(){
return;
}

//I帧抑制

function IFrame(room){
var meetingDetailID = getMeetingDetailId();
var roomID = "";
var count = 0;
var rooms = document.getElementsByName(room);
for(var i=0; i < rooms.length; i++){
if(rooms[i].checked == true){
	count++;
	roomID += rooms[i].value;
}
}

if(count == 1){
window.open(globalProjectName + '/polycom/getIFrameInfo.action?meetingDetailID=' + meetingDetailID+ '&meetingMCUKeyID=' + roomID ,'example03','width=400px,height=190px,directories,scrollbars=yes');
//window.open(globalProjectName + '/polycom/getIFrameInfo.action?meetingDetailID=' + meetingDetailID+ '&meetingMCUKeyID=' + roomID ,'example03','');
}else{
if(count == 0){
	alert("请选择一个会议室！");
}else{
	alert("一次只能选择一个会议室！");
}
}
}
var mark;
var blowUpIp;
var bName;
var meetingRoomid;
var bID;
function setMark(id,ip,name,meetingRoomid){
mark=id;
blowUpIp = ip;
bName = name;
bID = meetingRoomid;
}

var blowIP;
/**
* interval call method
*/
function blowUp(ip,name,meetingRoomId){

parent.right.window.clearTimeout(mark);
parent.right.window.blowUp(ip,name,meetingRoomId);	
blowIP = ip;
parent.window.aa(blowIP);
}


//勾选后取消
function cancle(){
var rooms = document.getElementsByName('room');
	for(var i=0; i < rooms.length; i++){
	rooms[i].checked = false;
	}
	document.getElementById("checkAll").checked = false;
}
/*
// 分屏显示
function autoScreen(confID){
//var meetingDelayID = document.getElementsByTagName('input');
var meetingDetailID = document.getElementById("filterSelectId").value;
McuHelpDwrMethod.mainMCU(meetingDetailID,function(mark){
if(mark != null){
	window.open(globalProjectName + '/conf/meetingRoom.action?confVO.confID='+mark,'03','width=500px,height=410px,directories,scrollbars=yes');
}
});

}
*/
function changeMeetingDetail(meetingDetailId){
window.location.href = globalProjectName + "/mcuControl/getClassifiedRoomList.action?chooseMeetingNumber=" + meetingDetailId;
}

function ipGo(ip){
window.open('http://' + ip);
}

function getMcuInfo(){
var meetingDetailID = document.getElementById("filterSelectId").value;
McuDwrMethod.getMeetingMcuList(meetingDetailID,'10.8.40.3',  function(){});
}
function startRecord(){
var meetingDetailID = document.getElementById("filterSelectId").value;
McuDwrMethod.startRecording(meetingDetailID,  function(){});
}
function stopRecord(){
var meetingDetailID = document.getElementById("filterSelectId").value;
McuDwrMethod.stopRecording(meetingDetailID,  function(){});
}


function deleteConf(){
var meetingDetailId = getMeetingDetailId();
if(!meetingDetailId) return;
var meetingDetailID = document.getElementById("filterSelectId").value;
if(meetingDetailID !="" && meetingDetailID != null) {
	if(!confirm("确定结束该会议吗？")){
		return;
	}
		McuDwrMethod.deleteConf(meetingDetailID, function(){
			window.location.reload();
		});
}
}

/*
function meetingDelay(){
var meetingDetailID = document.getElementById("filterSelectId").value;
if(meetingDetailID !="" && meetingDetailID != null) {
		window.open(globalProjectName + '/meeting/meetingManage/meetingDelay.jsp?meetingDetailID=' + meetingDetailID ,'04','width=300px,height=145px,directories,scrollbars=yes');
	}	
}
*/

/**-------------------------
接受拖动事件的方法
**/
/**
var unTriggerID;
$(document).ready(function() {
$("#droppableContent").droppable({
  drop: function() {
  	if("vedioMonitorDivID"!=unTriggerID&&"operateDivID"!=unTriggerID){//不处理捕捉到的事件
  		 var meetingDetailID = $("#filterSelectId").val();

        if(meetingDetailID==null||meetingDetailID=="") return alert("请选择会议"); 
        mcuControlMethod.addParticipants(meetingDetailID, chooseNodeIP, function(parame){
			if(!parame) alert("添加失败！");
        });
  	}
  }
});
});
**/
/**-------------------------
拖动添加会场层时触发事件
**/
//var MENU_VIEW=0;
function controlMenu(){
/**if(MENU_VIEW==0){
   $("#containerTest").css("width","80%");
   $("#operateDiv").show();
   MENU_VIEW=1;
	   parame.src = globalProjectName + "/images/blue/page5.gif";
}else{
   $("#containerTest").css("width","100%");
	 $("#operateDiv").hide();
	 parame.src=globalProjectName + "/images/blue/page2.gif";
   MENU_VIEW=0;
}**/
// $("#operateDiv").attr("display","none");

$("#operateDiv").dialog({
   /** dragStart: function(event, ui) {
	    unTriggerID = "operateDivID";
    },
    dragStop: function(event, ui) {
	    unTriggerID = "";
    }**/
    title:"视频会场列表",
	height:500
});
}

function createMeetingRoomList(thisDom){

	var meetingDetailID = getMeetingDetailId();
	if(meetingDetailID==false){
		return;
	}
    var  meetingID = document.getElementById("filterSelectId").value;
    var conferenceParameters = {
        methodName:'getReturnConferenceMethod',
        mcuIpsStr:mcuIps,
        meetingDetailID:meetingID
    }
   creatMeetingRoomList(conferenceParameters); 
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
            conferenceName =conferenceName+conferenceArray[i].conferenceName;
            conferenceID = conferenceID+conferenceArray[i].conferenceID;
        
    }
    document.getElementById("meetingRoomNames").value=conferenceName;
    document.getElementById("meetingRoomNameIDs").value=conferenceID;
}


/**-------------------------
拖动视频监控摄像头层时触发事件
**/
function vedioMonitor() {
	$("#vedioMonitorDiv").dialog({
	   /** dragStart: function(event, ui) {
		    unTriggerID = "vedioMonitorDivID";
	    },
	    dragStop: function(event, ui) {
		    unTriggerID = "";
	    }**/
	    title:"视频监控摄像头列表",
	    height:500
    });
};




//开始分屏轮询
function startScreenRolling(){
var meetingDetailId = getMeetingDetailId();
//TODO
window.open(globalProjectName + '/apply/rolling/beforeStartRolling.action?meetingDetailID ='+meetingDetailId +'&mark=0','03','width=780px,height=475px,directories,scrollbars=yes');
}

//会场控制（本地发送双流）
function roomControl(){
window.open(globalProjectName + '/project/zhuanyuanban/roomControl.jsp','03','width=450px,height=240px,directories,scrollbars=yes');
}

//备份
function record(){
window.open(globalProjectName + '/project/zhuanyuanban/reBack.jsp','','');
}

//会议延迟
function meetingDelay(){
var meetingDetailId = getMeetingDetailId();
if(meetingDetailId!=null){
	delayTime = document.getElementById("delayMeetingTimeID").value;
	mcuControlMethod.meetingDelay(meetingDetailId,delayTime,meetingDelayBack);
}
}

function meetingDelayBack(){
refreshSelf("4");
}

function cssOdd(id,ind){
  if(ind%2==0)
	$("#"+id).css("background","#E2E4FF");
  else 
  	$("#"+id).css("background","#eeffee");
}

function setBroadcaster(room,isTrue){
var meetingDetailId = getMeetingDetailId();

//if(!meetingDetailId){
	//return;
//}

if(isTrue == 'true'){
	var roomIDs = assembleRoomIDs(room, true);
	var roomLs = roomIDs.split("-");

	if(roomLs.length==0 || roomIDs == ""){
		alert("请选择一个会场作为广播者 ！");
		return;
	}
	
	if(roomLs.length>1){
		alert("只能选择一个会场作为广播者！");
		return;
	}

	var meetingRoomMID = document.getElementById("mparticipantid_"+roomIDs).value;
	
	mcuControlMethod.setBroadcaster(meetingDetailId,roomIDs,meetingRoomMID);
}
}

//分屏模式
function screenModel(){
var meetingDetailId = getMeetingDetailId();
if(meetingDetailId==false){
	return;
}
window.open(globalProjectName + '/mcuControl/screenModelBefore.action?meetingDetailID ='+meetingDetailId +'&mark=0'+'&type=meeting','03','width=790px,height=500px,directories,scrollbars=yes');
}

function getMeetingDetailId(){
	var meetingSelect = document.getElementById("filterSelectId");
	//alert("meetingSelect::"+meetingSelect.value);
	if(meetingSelect.value == ""){
	alert("未选择会议！");
	return false;
	}else{
	return meetingSelect.options[meetingSelect.selectedIndex].value;
	}
}

//会场分屏
function setPersonal(room){
	var meetingDetailId = getMeetingDetailId();
	if(meetingDetailId==false){
		return;
	}
	var roomID = "";
	var count = 0;
	var roomIDs = assembleRoomIDs(room, true);
	
	var roomID = roomIDs.split("-");
		
	if(roomID.length > 1){
		alert("禁止多选！");
		return;
	}
	//alert(roomID.length);
	if(roomID.length == 1&&roomID!=""){
		var pId = document.getElementById("mparticipantid_"+roomID).value;
		roomID = roomID +"__"+pId;
		window.open(globalProjectName + "/mcuControl/screenModelBefore.action?meetingDetailID ="+meetingDetailId +"&monitor="+roomID+"&type=meetingroom","setPersonal","width=790px,height=500px,directories,scrollbars=no");
			
	}else{
		if(count == 0||roomID==""){
			alert("请选择一个会议室！");
		}else{
			alert("禁止多选！");
		}
	}
}	

//add by chenshuo


function clearInput(htmlObject){
 	var searchVal = htmlObject.value;//搜所条件
 	if(searchVal =="请输入关键字"){
 	  htmlObject.value="";
 	}
 }

 function serachRoom(htmlObject){
    var flag = false;
    //alert(room_Name[0]+"--"+room_Name[1]);
 	var searchVal = htmlObject.value;//搜所条件
 	var tb = document.getElementById("tbodyId"); 
 	var tbRows = tb.rows;
 	for( var i=0; i<tb.rows.length; i++){
 	   tb.rows[i].style.display="none";
 	}
 	if(searchVal ==null || searchVal ==""){
 	  for( var i=0; i<tb.rows.length; i++){
 	      tb.rows[i].style.display="";//查询条件为空时还原显示所有数据
 		}
 	  return;
 	}
 	
 	for( var i=0; i<room_Name.length; i++ ){//会场名数组
 	   var roomName = room_Name[i].split("_")[0];//会场名
 	   var rowId = "room_"+room_Name[i].split("_")[1];
 	   if( roomName.indexOf(searchVal) != -1){//匹配到会场名
 	     for( var j=0; j<tbRows.length; j++){
 	     	if( tbRows[j].id==rowId){//找到匹配到的那一行显示
 	     	   tbRows[j].style.display="";
 	     	}
 	     }
 	   }
 	}
 	
 	for( var i=0; i<t_IP.length; i++ ){//终端ip数组
 	   var tIPx = t_IP[i].split("_")[0];//ip
 	   var rowId = "room_"+t_IP[i].split("_")[1];
 	   if( tIPx.indexOf(searchVal) != -1){//匹配到ip
 	     for( var j=0; j<tbRows.length; j++){
 	     	if( tbRows[j].id==rowId){//找到匹配到的那一行显示
 	     	   tbRows[j].style.display="";
 	     	}
 	     }
 	   }
 	}
 	
 	for( var i=0; i<mcu_IP.length; i++ ){//所属mcu数组
 	   var mcu_IPx = mcu_IP[i].split("_")[0];//mcuip
 	   var rowId = "room_"+mcu_IP[i].split("_")[1];
 	   if( mcu_IPx.indexOf(searchVal) != -1){//匹配到mcuip
 	     for( var j=0; j<tbRows.length; j++){
 	     	if( tbRows[j].id==rowId){//找到匹配到的那一行显示
 	     	   tbRows[j].style.display="";
 	     	}
 	     }
 	   }
 	}
 	
 }
 
//图像预监
 function videoShowTrue(ip){
 	var meetingDetailID = getMeetingDetailId();
 	//McuHelpDwrMethod.videoShow(meetingDetailID,roomID,function(message){
 	//window.open(globalProjectName + '/meeting/meetingManage/videoShow.jsp?message='+message+'&meetingDetailID='+meetingDetailID+'&roomID='+roomID ,'example20','width=485px,height=300px,directories,scrollbars=yes');
 	//});
 	window.open(globalProjectName + '/meeting/meetingManage/videoShow.jsp?message='+ip+'&meetingDetailID='+meetingDetailID,'example20','width=485px,height=300px,directories,scrollbars=yes');
 }
 
//字幕
function getMessageOverlay(){
	var meetingDetailId = getMeetingDetailId();
	if(meetingDetailId==false){
		return;
	}
	window.open(globalProjectName + '/mcuControl/getMessageOverlay.action?confID=' + globalMeetingDetailId,'02','width=600px,height=470px,directories,scrollbars=yes');
	
}

//广播会场
function setVideo(roomID){
	var meetingDetailId = getMeetingDetailId();
	McuDwrMethod.setVideo(meetingDetailId, roomID, function(){});
}

//录播控制
function recordControl(op){
	var meetingDetailID = getMeetingDetailId();
	if(meetingDetailID==false){
		return;
	}
	var confID = document.getElementById("confID").value;
	//alert(confID);
	if(op==1){
		McuDwrMethod.recording(meetingDetailID,confID,"start",recordCallBack);
		
	}else if(op=="stop"){
		McuDwrMethod.recording(meetingDetailID,confID,"stop",recordCallBack);
		
	}else if(op==2){
		McuDwrMethod.recording(meetingDetailID,confID,"pause",recordCallBack);
		
	}else if(op==3){
		McuDwrMethod.recording(meetingDetailID,confID,"resume",recordCallBack);
		
	}
	
}

function recordCallBack(data){
	//alert(33);
	if(data=="start"){
		
		document.getElementById("recordNew").innerHTML="<a href='#' onclick='recordControl(2);' title='暂停录制'><span class='czdiv_ztlz'></span></a>";
	}else if(data=="stop"){
		document.getElementById("recordNew").innerHTML="<a href='#' onclick='recordControl(1);' title='开始录制'><span class='czdiv_kslz'></span></a>";
		//document.getElementById("recordNew").innerHTML="<a href='#' onclick='recordControl(1);'><img src='"+globalProjectName+"/images/mcu/delhc.png' align='absmiddle' />1开始录制1</a>";
		//alert(4);
	}else if(data=="pause"){
		document.getElementById("recordNew").innerHTML="<a href='#' onclick='recordControl(3);' title='继续录制'><span class='czdiv_jxlz'></span></a>";
	}
}

//点名 选看会场
function rollCall(roomID,ifNeedMute){
	var videoMode = document.getElementById("videoMode1").value;
	var lectureName = document.getElementById("lectureName").value;
	var meetingDetailId = getMeetingDetailId();
	var participantId = document.getElementById("mparticipantid_"+roomID).value;
	if(lectureName!="[None]"){					//演讲者模式
		if(ifNeedMute){
			setSpeaker(roomID,ifNeedMute);
		}else{
			var commandIp = document.getElementById("commandIp_"+roomID).value;
			if(commandIp==""){
				commandIp =  document.getElementById("mcuip__"+roomID).value;
			}
			var mcuIp =  document.getElementById("mcuip__"+roomID).value;
			var confMcuIp = document.getElementById("confMcuIp").value;
			var linkSiteInput = document.getElementById("infoIps_" +commandIp);
		
			if(linkSiteInput != null ){//级联会 设为发言人入口
				var linkparticipantId = document.getElementById("mparticipantid_"+linkSiteInput.value).value;
				McuDwrMethod.checkParticipantLecture(meetingDetailId,roomID,participantId);
				if(confMcuIp!=mcuIp){
				McuDwrMethod.checkParticipantLecture(meetingDetailId,linkSiteInput.value,linkparticipantId);
				}
			}else{
			
			McuDwrMethod.checkParticipantLecture(meetingDetailId,roomID,participantId);
			}
		}
	}else{									//个人模式
		
		var roomInfo = document.getElementById("personalInfo_"+roomID).value;
		McuDwrMethod.rollCall(meetingDetailId, roomInfo,ifNeedMute, rollCallCallback);
	
	}
}

function rollCallCallback(message){
	if(message=="none"){
		alert("未对主会场进行广播!");
}
}

//终端备份
function terminalBackup(room){
	
var rooms = document.getElementsByName(room);
var meetingDetailID =getMeetingDetailId();
if(meetingDetailID==false){
	return;
}

	var infos=new Array();
	var k = 0;
	for(var i=0; i < rooms.length; i++){
		if(rooms[i].checked == true){
			infos[k]= document.getElementById("backupInfo_"+rooms[i].value).value;
			k++;
		}
	}
	DwrMethod.terminalBackup(meetingDetailID,infos);
}

//会议控制页面最大化、还原
function maximizition(){
	//window.location.reload();
	if(parent.document.getElementById("mainFrame")==null){
		return;	
	}
	
	var isMax = parent.document.getElementById("mainFrame").rows;
	
	if(isMax!="0,0,*,0"){
		
		parent.document.getElementById("mainFrame").rows="0,0,*,0";
		parent.document.getElementById("leftMenu").cols="0,*";
		parent.document.getElementById("rightF").rows="0,*";
		document.getElementById("maxW").src=globalProjectName+"/images/qp.png";
		document.getElementById("maxSpan").title="还原";
		//document.documentElement.offsetHeight
		//document.getElementById("meetingRoomDiv").style.height = document.body.clientHeight+145;
		document.getElementById("meetingRoomDiv").style.height = document.documentElement.offsetHeight-180;
		
	}else{
	    
		parent.document.getElementById("mainFrame").rows="58,78,*,28";
		parent.document.getElementById("leftMenu").cols="235,*";
		parent.document.getElementById("rightF").rows="28,*";
		document.getElementById("maxW").src=globalProjectName+"/images/sf.png";
		document.getElementById("maxSpan").title="最大化";
		//document.getElementById("meetingRoomDiv").style.height = document.body.clientHeight-145;
		//document.getElementById("meetingRoomDiv").style.height = document.documentElement.scrollHeight-145;
		document.getElementById("meetingRoomDiv").style.height = document.documentElement.offsetHeight-180;
	}
	
	aDoc = [document.documentElement.offsetWidth, document.documentElement.offsetHeight];
}

//添加cookie
function addCookie(key,value){
	var date = new Date();
	var expiresDays = 365;
	date.setTime(date.getTime()+expiresDays*24*60*60*1000);
	var cookieStr = key+"="+encodeURI(value);
	document.cookie=cookieStr+"; expires="+date.toUTCString();
}
//根据key获取cookie的值
function getCookie(key){
	var cookie = document.cookie;
	var cookieStr = cookie.split("; ");
	var strArr = new Array();
	var flag =false;
	for(var i=0;i<cookieStr.length;i++){
		strArr = cookieStr[i].split("=");
		if(key==strArr[0]){
			return decodeURI(strArr[1]);
		}
	}
	return "";
}
//添加备注
function addComments(key,meetingDetailID,roomIP){
	var value = document.getElementById("commentText").value;
	if(value.length>50){
		alert("请输入50个字符之内！");
		return;
	}else{
		McuDwrMethod.setCommentByIp(meetingDetailID,key,value,roomIP,function bkc(result){
			closeDIV("comments");
			//document.getElementById("comment_"+key.value).innerHTML=value;
			//document.getElementById("comment_"+key.value).title=value;
		});
		//addCookie(key.value,value);
		
	}
}
//显示备注
function displayComments(key,id){	
	var comment = getCookie(key);
	if(comment!=""){
		document.getElementById(id).title = comment;
	}
}

//中航轮询
function getConfList(){
	var meetingDetailId = getMeetingDetailId();
	if( !meetingDetailId){
		return;
	}
	window.open(globalProjectName + '/mcuControl/getConfList.action?meetingDetailID=' + meetingDetailID,'conflist','width=510px,height=675px,directories,scrollbars=yes');
}

//中航停止轮询
function stopPoll(){
	var meetingDetailId = getMeetingDetailId();
	if( confirm("确定停止轮询吗?")){
		McuDwrMethod.stopOneAndTwoPoll(meetingDetailId,stopPollCallback);
	}
	
}



//轮询
function startPolling1(){
	var videoMode = document.getElementById("videoMode1").value;
	var lectureName = document.getElementById("lectureName").value;
	var	meetingDetailID = getMeetingDetailId();
	if(meetingDetailID==false){
		return;
	}
	
	window.open(globalProjectName + '/mcuControl/getConfList1.action?meetingDetailID=' + meetingDetailID+'&videoMode='+videoMode+'&lectureName='+lectureName,'conflist1','width=559px,height=589px,directories,scrollbars=yes');
}
//停止轮询
function stopPoll1(){
	var meetingDetailId = getMeetingDetailId();
	if(meetingDetailId==false){
		return;
	}
	if( confirm("确定停止轮询?")){
		McuDwrMethod.stopPoll(meetingDetailId,stopPollCallback);
	}
	
	
}


function stopPollCallback(result){
	
	
}

function suspendPoll(){
	var meetingDetailId = getMeetingDetailId();
	if(meetingDetailId==false){
		return;
	}
	McuDwrMethod.suspendPoll(meetingDetailId,function suspendPollBack(result){
		if( result == "ok" ){
			document.getElementById("polla").innerHTML='<span class="czdiv_ztlx_bf"></span>';
			document.getElementById("polla").setAttribute("onclick", "resumePoll()");
			document.getElementById("polla").setAttribute("title", "继续轮询");
		}else if( result == "fall" ){
			alert("当前会议没有轮询");
		}else{
			alert("操作失败");
		}
		
	});
}

function resumePoll(){
	var meetingDetailId = getMeetingDetailId();
	if(meetingDetailId==false){
		return;
	}
	McuDwrMethod.resumePoll(meetingDetailId,function resumePollBack(result){
		if( result == "ok" ){
			document.getElementById("polla").innerHTML='<span class="czdiv_ztlx_zt"></span>';
			document.getElementById("polla").setAttribute("onclick", "suspendPoll()");
			document.getElementById("polla").setAttribute("title", "暂停轮询");
		}else if( result == "falll" ){
			alert("当前会议没有轮询");
		}else{
			alert("操作失败");
		}
		
	});
}


function beforeModifyPoll(){
	
	var meetingDetailId = getMeetingDetailId();
	if(meetingDetailId==false){
		return;
	}
	var videoMode = document.getElementById("videoMode1").value;
	var lectureName = document.getElementById("lectureName").value;
	
	window.open(globalProjectName + '/mcuControl/beforeModifyPoll.action?meetingDetailID=' + meetingDetailID+'&videoMode='+videoMode+'&lectureName='+lectureName,'conflist1','width=559px,height=589px,directories,scrollbars=yes');
	
	
	/*McuDwrMethod.modifyPoll(meetingDetailId,function modifyPollBack(result){
		if( result == "ok"){
			window.open(globalProjectName + '/mcuControl/beforeModifyPoll.action?meetingDetailID=' + meetingDetailID,'conflist1','width=559px,height=589px,directories,scrollbars=yes');
			
		}else{
			alert("当前会议没有轮询");
		}
	});*/
	
	
}
/**
 * synchronize conferences from every mcu .wangle 2013-09-16
 * @return
 */
function synConfsFromMcu(){
	McuDwrMethod.synConfsFromMcu("", synConfsFromMcuCallBack);
	return;
	/*
	var meetingDetailId = getMeetingDetailId();
	if(!meetingDetailId) return;
	if(!confirm("确定数据同步?")) return;
	McuDwrMethod.synConfsFromMcu(meetingDetailId, synConfsFromMcuCallBack);
	*/
}

function synConfsFromMcuCallBack(result){
	return;
}

function createTrNew(meetingRoom){
if(meetingRoom == null || meetingRoom == null ){
return;	
}
if(meetingRoom.nodeType != null &&  meetingRoom.nodeType == 2){
return;
}
var cellInfos = new Array();

var tbodyId = meetingRoom.mcuIp;
var tb = document.getElementById("tbodyId");
var rnum = tb.rows.length+1;
var row = document.createElement("tr");
row.id = "room_" + meetingRoom.meetingMCUKeyID;
row.onmousemove="onchangActionTr('"+meetingRoom.meetingMCUKeyID+"');";
row.indexTr="'"+tb.rows.length+"'";

//create checkbox
var cell = document.createElement("td");
cell.width = "4%";
cell.innerHTML = "<span lang='zh-cn' xml:lang='zh-cn'><input type='checkbox'  name='room' value='" + meetingRoom.mcu_participant_name + "__" +meetingRoom.mcuMeetingID+ "__" + meetingRoom.mcuIp + "' id='room_" + meetingRoom.meetingMCUKeyID + "_checkbox'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_name + "__" +meetingRoom.mcuMeetingID+ "__" + meetingRoom.mcuIp + "' id='room_" + meetingRoom.meetingMCUKeyID + "_roomIds'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_ip + "' id='room_" + meetingRoom.meetingMCUKeyID + "_roomIP'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_name + "' id='room_" + meetingRoom.meetingMCUKeyID + "_roomName'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.connectStatus + "' id='room_" + meetingRoom.meetingMCUKeyID + "_IPConnectStatus'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.video + "' id='room_" + meetingRoom.meetingMCUKeyID + "_video'/>";   
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.contentToken + "' id='room_" + meetingRoom.meetingMCUKeyID + "_contentToken'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.audio + "' id='room_" + meetingRoom.meetingMCUKeyID + "_audio'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_ip + "_" + meetingRoom.mcuIp+"' id='room_" + meetingRoom.meetingMCUKeyID + "_backupInfo'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.nodeType + "' id='room_" + meetingRoom.meetingMCUKeyID + "_nodeType'/>";
<!-- 右键菜单 -->
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.meetingMCUKeyID + "' id='meetingRoomMID_" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_id + "' id='mparticipantid_" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.meetingMCUKeyID + "' id='meetingMCUKeyID'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.nodeType + "' id='nodeType_" + meetingRoom.mcu_participant_ip + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcuCommandIp + "' id='commandIp_" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcuCommandIp + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "' id='infoIps_" + meetingRoom.mcu_participant_ip + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_id + "_" + meetingRoom.mcuMeetingID + "_" + meetingRoom.confFlagId + "_" + meetingRoom.mcuIp + "_" + meetingRoom.mcu_participant_name + "' id='personalInfo_" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_ip + "_" + meetingRoom.mcuIp + "' id='backupInfo_" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_ip + "' id='participantIp_" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";

cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_id + "__" + meetingRoom.confFlagId + "__" + meetingRoom.mcuIp + "__" + meetingRoom.mcu_participant_name + "' id='room_" + meetingRoom.meetingMCUKeyID + "_participant_id'/>";

cell.innerHTML += "<input type='hidden' value='" + meetingRoom.connectStatus + "' id='connectstatus__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.audio + "' id='audio__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.video + "' id='video__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.contentToken + "' id='contenttoken__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.casDialDirection + "' id='dialdirection__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.isLecturer + "' id='lecturer__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.isSpeaker + "' id='speaker__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcu_participant_name + "' id='mcuptsname__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcuMeetingID + "' id='mcuMeetingID__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.mcuIp + "' id='mcuip__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.receivePacketLoss + "' id='receivepacketloss__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";
cell.innerHTML += "<input type='hidden' value='" + meetingRoom.sendPacketLoss + "' id='sendpacketloss__" + meetingRoom.mcu_participant_name + "__" + meetingRoom.mcuMeetingID + "__" + meetingRoom.mcuIp + "'/>";

cell.innerHTML += "</span>";
row.appendChild(cell);

//会场名
cell = document.createElement("td");
cell.width ="14%";
//cell.style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
if(meetingRoom.mcu_participant_visualName!=null && meetingRoom.mcu_participant_visualName!=""){
	cell.innerHTML = "<span style='display: none'>"+meetingRoom.mcu_participant_visualName+"</span>";
	cell.innerHTML +="<a style='cursor: pointer' onmouseover='displayComments(\""+meetingRoom.mcu_participant_ip+"\",\"font_"+meetingRoom.meetingMCUKeyID+"\");'>";
	cell.innerHTML +="<font style='color: #000' title='"+meetingRoom.mcu_participant_visualName+"' id='font_"+meetingRoom.meetingMCUKeyID+"' class='td_Mcu_participant_name'>"+meetingRoom.mcu_participant_visualName+"</font> </a>";
}else{
	cell.innerHTML = "<span style='display: none'>"+meetingRoom.mcu_participant_name+"</span>";
	cell.innerHTML +="<a style='cursor: pointer' onmouseover='displayComments(\""+meetingRoom.mcu_participant_ip+"\",\"font_"+meetingRoom.meetingMCUKeyID+"\");'>";
	cell.innerHTML +="<font style='color: #000' title='"+meetingRoom.mcu_participant_name+"' id='font_"+meetingRoom.meetingMCUKeyID+"' class='td_Mcu_participant_name'>"+meetingRoom.mcu_participant_name+"</font> </a>";
}
row.appendChild(cell);

//备注
cell = document.createElement("td");
cell.width = "6%";
//cell.style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
//HashMap ob = McuDwrMethod.getTerComment();
//Object ipMap = ob.get((String) request.getAttribute("chooseMeetingNumber"));
//if (ipMap != null) {
//	String com = (String) ((HashMap) ipMap).get(meetingRoom.getMeetingMCUKeyID());
//	if (com != null) {
		cell.innerHTML = "<span id='comment_"+meetingRoom.meetingMCUKeyID+"' style='white-space: nowrap; overflow: hidden; text-overflow: ellipsis'>&nbsp;</span>";
//	}

//}
row.appendChild(cell);

//Ip
cell = document.createElement("td");
cell.width = "14%";
//cell.style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
cell.innerHTML ="<SPAN style='cursor: pointer' onclick='ipGo(\""+meetingRoom.mcu_participant_ip+"\")' class='td_Mcu_participant_ip' id='"+meetingRoom.mcu_participant_ip+"_"+meetingRoom.getMeetingMCUKeyID+"'>"+meetingRoom.mcu_participant_ip+"</span>";
row.appendChild(cell);	

//状态
cell = document.createElement("td");
cell.width = "6%";
if(meetingRoom.connectStatus!=null && meetingRoom.connectStatus == 1){
cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">1</SPAN>";
cell.innerHTML += "<img src='"+globalProjectName + "/images/rmx1000/connected.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>" ;
}else{
if(meetingRoom.connectStatus!=null && (meetingRoom.connectStatus == 2 || meetingRoom.connectStatus== 5)){
	cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">2</SPAN>";
	cell.innerHTML += "<img src='"+globalProjectName + "/images/rmx1000/connecting.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>";
}else{
	if(meetingRoom.connectStatus!=null && (meetingRoom.connectStatus == 3|| meetingRoom.connectStatus== 4)){
		cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">3</SPAN>";
		cell.innerHTML += "<img src='"+globalProjectName + "/images/rmx1000/disconnected.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>";
	}else{
		cell.innerHTML = "<SPAN style=\"display: none;\" id=\"span_img_connect_" + meetingRoom.meetingMCUKeyID + "\">3</SPAN>";
		cell.innerHTML += "<img src='"+globalProjectName + "/images/rmx1000/disconnected.gif' id='img_connect_" + meetingRoom.meetingMCUKeyID + "'/>";
	}
}
}
row.appendChild(cell);

//音频				
cell = document.createElement("td");
cell.width = "7%";
//cell.style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
if(meetingRoom.audio == 0 && meetingRoom.connectStatus == 1){
cell.innerHTML = "<SPAN4></SPAN>";
cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
cell.innerHTML += "&nbsp;<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
if(meetingRoom.audio == 1 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN2></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 2 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN1></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 3 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 4 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN4></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 5 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN5></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 6 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN6></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 7 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN7></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 8 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN8></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 9 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN9></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 10 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN1></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 11 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 12 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN4></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 13 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN5></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/mute.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 14 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN6></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/block.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.audio == 15 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN7></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/muteAndBlock.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/ptsmute.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.connectStatus != 1){
	cell.innerHTML = "<SPAN0></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_" + meetingRoom.meetingMCUKeyID + "'/>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_audio_ptsmute_" + meetingRoom.meetingMCUKeyID + "'/>";
}
row.appendChild(cell);	

//视频
cell = document.createElement("td");
cell.width = "5%";
if(meetingRoom.video == 1 && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<SPAN1></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/suspendVideo.gif' id='img_video_" + meetingRoom.meetingMCUKeyID + "'/>";
}
if(meetingRoom.video != 1 || meetingRoom.connectStatus != 1){
	cell.innerHTML = "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_video_" + meetingRoom.meetingMCUKeyID + "'/>";
}
row.appendChild(cell);	


//角色
cell = document.createElement("td");
cell.width = "8%";
//cell.style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
if(meetingRoom.isLecturer == 1){
	
	cell.innerHTML = "<SPAN1></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/lecturer.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
if(meetingRoom.isSpeaker == 1){
	cell.innerHTML = "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/broadcaster.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
if(meetingRoom.isSpeaker != 1 && meetingRoom.isLecturer != 1){
	cell.innerHTML = "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='img_member_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
if(meetingRoom.contentToken == 1 || meetingRoom.contentToken == 3){
	cell.innerHTML += "<SPAN2></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/contentOwner.gif' id='is_content_owner_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
if(meetingRoom.contentToken != 1 && meetingRoom.contentToken != 3){
	cell.innerHTML += "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='is_content_owner_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
row.appendChild(cell);

//内容
cell = document.createElement("td");
cell.width = "5%";
//cell.style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
if(meetingRoom.connectStatus == 1 && (meetingRoom.contentToken == 2 || meetingRoom.contentToken == 3)){
	cell.innerHTML = "<SPAN1></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/contentToken.gif' id='content_token_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
if(meetingRoom.contentToken != 2 && meetingRoom.contentToken != 3){
	cell.innerHTML = "<SPAN3></SPAN>";
	cell.innerHTML += "<img src ='"+globalProjectName + "/images/rmx1000/blank.gif' id='content_token_" + meetingRoom.meetingMCUKeyID + "'/>";	
}
row.appendChild(cell);	

//输入(%)
cell = document.createElement("td");
cell.width = "9%";
cell.style.display="none";
//cell.style="display: none;word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
if(meetingRoom.vIFractionLossPeak != '0.0' && meetingRoom.vIFractionLossPeak != null && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<span id='receive_" +meetingRoom.meetingMCUKeyID+"'>"+meetingRoom.vIFractionLoss+"&nbsp;"+meetingRoom.vIFractionLossPeak+"</span>";
}
if(meetingRoom.vIFractionLossPeak == '0.0' || meetingRoom.vIFractionLossPeak == null || meetingRoom.connectStatus != 1){
	cell.innerHTML = "<span id='receive_" +meetingRoom.meetingMCUKeyID+"'></span>";
}
row.appendChild(cell);

//输出(%) 
cell = document.createElement("td");
cell.width = "9%";
cell.style.display="none";
//cell.style="display: none;word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;";
if(meetingRoom.vOFractionLossPeak != '0.0' && meetingRoom.vOFractionLossPeak != null && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<span id='send_" +meetingRoom.meetingMCUKeyID+"'>"+meetingRoom.vOFractionLoss+"&nbsp;"+meetingRoom.vOFractionLossPeak+"</span>";
}
if(meetingRoom.vOFractionLossPeak == '0.0' || meetingRoom.vOFractionLossPeak == null || meetingRoom.connectStatus != 1){
	cell.innerHTML = "<span id='send_" +meetingRoom.meetingMCUKeyID+"'></span>";
}
row.appendChild(cell);	

//方向
cell = document.createElement("td");
cell.width = "6%";
cell.style.display="none";
//cell.style="display: none";
if((meetingRoom.casDialDirection =='dial_out' || meetingRoom.casDialDirection =='Dial-out') && meetingRoom.connectStatus == 1 ){
	cell.innerHTML = "<span id='casDialDirection_" +meetingRoom.meetingMCUKeyID+"'>呼出</span>";
}
if((meetingRoom.casDialDirection =='dial_in' || meetingRoom.casDialDirection =='Dial-in') && meetingRoom.connectStatus == 1){
	cell.innerHTML = "<span id='casDialDirection_" +meetingRoom.meetingMCUKeyID+"'>呼入</span>";
}
if(meetingRoom.connectStatus != 1){
	cell.innerHTML = "<span id='casDialDirection_" +meetingRoom.meetingMCUKeyID+"'></span>";
}
row.appendChild(cell);	

//所属mcu

cell = document.createElement("td");
cell.width = "12%";
cell.className = "td_Mcu";
cell.innerHTML ="<SPAN id='mcuName_"+meetingRoom.meetingMCUKeyID+"' ></SPAN>";
row.appendChild(cell);

tb.appendChild(row);//加一行
//右键操作


initMeetingRoomList('${chooseMeetingNumber}');
 var oMenu = document.getElementById("rightMenu");
 var maxWidth = maxHeight = 0;
 var oMenAreasConventer=document.getElementById("room_"+meetingRoom.meetingMCUKeyID);

 oMenu.style.display = "none";
 
 //自定义右键菜单
oMenAreasConventer.oncontextmenu = function (event)
 {
 //document.getElementById('tempMeetingMcuKeyId3').value=meetingRoom.meetingMCUKeyID;
 document.getElementById('tempMeetingMcuKeyId').value=document.getElementById('tempMeetingMcuKeyId2').value=document.getElementById('tempMeetingMcuKeyId3').value=meetingRoom.meetingMCUKeyID;
 var meetingRoomNameTemp=document.getElementById('room_'+meetingRoom.meetingMCUKeyID+'_roomName').value;
 document.getElementById('rightMenuMeetingRoomName').innerHTML=meetingRoomNameTemp;
 initMenuList();
 // alert(meetingRoomNameTemp);
  var event = event || window.event;
  oMenu.style.display = "block";
  oMenu.style.top = event.clientY + "px";
  oMenu.style.left = event.clientX + "px";

  
  //最大显示范围
  maxWidth = aDoc[0] - oMenu.offsetWidth;
  maxHeight = aDoc[1] - oMenu.offsetHeight;
  
  //防止菜单溢出
  oMenu.offsetTop > maxHeight && (oMenu.style.top = maxHeight + "px");
  oMenu.offsetLeft > maxWidth && (oMenu.style.left = maxWidth + "px");
  return false;
 };

//window.location.reload();

McuDwrMethod.getMcuNameNew(meetingRoom.mcuIp,function getMcuNameBack(str){
	//alert("id:"+meetingRoom.meetingMCUKeyID);
	document.getElementById('mcuName_'+meetingRoom.meetingMCUKeyID).innerHTML=str;
});
$("#abc").trigger("update");


}
