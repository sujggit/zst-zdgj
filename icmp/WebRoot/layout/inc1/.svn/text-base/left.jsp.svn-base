<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/UserAction.js'></script>
  <title>左侧菜单</title>
  <script type="text/javascript">//<!--
//function window.onload(){
  //if(window.parent.length>0)
	//window.parent.location=location;
	//}
	//--></script>
  <!--
  <script type="text/javascript">
  if(top.location!==self.location){
  top.location="${sys_ctx }/user/userLogin.action";
  }
  </script>
  
  --><script type="text/javascript">
    var a=true;
	function leftmenu_ctrl(){
	if(parent.document.getElementById('leftMenu').cols=="230,*"&&a==true){
	     parent.document.getElementById('leftMenu').cols="30,*";
	     document.images[0].src="${sys_style1}/images/menucollapsed_left.png";
	     a=false;
	     //var leftImgUrl=${sys_style1}/images/menucollapsed_left.png;
	     //var rightImgUrl=${sys_style1}/images/menucollapsed.png;
	     
	      //document.getElementById("iconID").style.display="none";
	    //leftSwitch.innerHTML='>>';
	      //leftSwitch.innerHTML="<img style='cursor:pointer' src='${sys_style1}/images/menucollapsed_left.png' />";
	}else{
	 parent.document.getElementById('leftMenu').cols="230,*";
	 document.images[0].src="${sys_style1}/images/one.png";
	 a=true;
	 //leftSwitch.innerHTML='<<';
	 // leftSwitch.innerHTML="<img style='cursor:pointer' src='${sys_style1}/images/menucollapsed_right.png' />";
	}
	
	}
	
	function changeClass(a){
	//alert("come in");
	 var removeClassA=$('ul li .current a');
       $('li').bind('click',function(){
      
     removeClassA.removeClass('current');
      $(this).addClass('current');
      removeClassA=$(this);
   });
  
	}
	//er ji cai dan tiao zhuan 
	function issession(){
		var userID = "${sys_userSession.userID}";
		UserAction.getFunTreeByID('1',menuBack);
	}
	
	function menuBack(list){
		if(list){
		}else{
			window.parent.location.href = "${sys_ctx }/user/userExit.action";
		}
	}	
	
	
  </script>
</head>
<body class="bodywrapper">
<input type="hidden" name="uploadFileVO.createUserID" id="userID" value="${sys_userSession.userID}"/>
  <div class="vernav2 iconmenu" id="leftDiv" >
    <ul id="leftUl">
     <li  onclick="window.parent.openNewFunction('/icmp/detail/immediatelyVideoMeetingBeforeAdd.action');window.parent.openNewCurrentFunction1('立即召开');changeClass('this')"><a class='tables'>立即召开</a></li> 
      <li onclick="window.parent.openNewFunction('/icmp/detail/generalAddBefor.action');window.parent.openNewCurrentFunction1('会议预约');changeClass('this')" ><a  class='gallery'>会议预约</a></li>
      <li onclick="window.parent.openNewFunction('/icmp/mcuControl/getClassifiedRoomList.action');window.parent.openNewCurrentFunction1('会议控制');changeClass('this')"><a  class='calendar'>会议控制</a></li>
      <li onclick="window.parent.openNewFunction('/icmp/detail/queryLocalConference.action');window.parent.openNewCurrentFunction1('会议管理');changeClass('this')"><a  class='widgets'>会议管理</a></li>
      <li onclick="window.parent.openNewFunction('/icmp/detail/manageMeetingTemplateList.action');window.parent.openNewCurrentFunction1('模板管理');changeClass('this')"><a   class='widgets'>模板管理</a></li>
      <li onclick="window.parent.openNewFunction('/icmp/equipmentControl/videoEndPointBefore.action');window.parent.openNewCurrentFunction1('视频终端控制');changeClass('this')" ><a  class='elements'>视频终端控制</a></li>
     
    </ul>
    
   <div style="width:230px; text-align:center;margin-top:10px">
     <a style="margin:0 auto;display:block"><img src="${sys_style1}/images/one.png" id="leftSwitch"  style="text-align:center;" onclick="leftmenu_ctrl();"></img></a> <br />  
   </div> 
  </div>  
</body>
</html>
