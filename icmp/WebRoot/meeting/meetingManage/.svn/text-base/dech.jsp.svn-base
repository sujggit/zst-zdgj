<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<title>分屏选择</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${sys_ctx }/style/screenModel.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${sys_ctx }/js1/Common.js"></script>
		<script src="${sys_ctx }/js1/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
<script>
function screenH1(){
if(document.getElementById("123").style.display=="none"){
document.getElementById("123").style.display="";
document.getElementById("234").style.display="none";
document.getElementById("345").style.display="none";
document.getElementById("456").style.display="none";
document.getElementById("567").style.display="none";
document.getElementById("678").style.display="none";
document.getElementById("789").style.display="none";
}else{
document.getElementById("123").style.display="none";
}
}
function screenH2(){
if(document.getElementById("234").style.display=="none"){
document.getElementById("234").style.display="";
document.getElementById("123").style.display="none";
document.getElementById("345").style.display="none";
document.getElementById("456").style.display="none";
document.getElementById("567").style.display="none";
document.getElementById("678").style.display="none";
document.getElementById("789").style.display="none";
}else{
document.getElementById("234").style.display="none";
}
}
function screenH3(){
if(document.getElementById("345").style.display=="none"){
document.getElementById("345").style.display="";
document.getElementById("123").style.display="none";
document.getElementById("234").style.display="none";
document.getElementById("456").style.display="none";
document.getElementById("567").style.display="none";
document.getElementById("678").style.display="none";
document.getElementById("789").style.display="none";
}else{
document.getElementById("345").style.display="none";
}
}
function screenH4(){
if(document.getElementById("456").style.display=="none"){
document.getElementById("456").style.display="";
document.getElementById("123").style.display="none";
document.getElementById("234").style.display="none";
document.getElementById("345").style.display="none";
document.getElementById("567").style.display="none";
document.getElementById("678").style.display="none";
document.getElementById("789").style.display="none";
}else{
document.getElementById("456").style.display="none";
}
}
function screenH5(){
if(document.getElementById("567").style.display=="none"){
document.getElementById("567").style.display="";
document.getElementById("123").style.display="none";
document.getElementById("234").style.display="none";
document.getElementById("345").style.display="none";
document.getElementById("456").style.display="none";
document.getElementById("678").style.display="none";
document.getElementById("789").style.display="none";
}else{
document.getElementById("567").style.display="none";
}
}
function screenH6(){
if(document.getElementById("678").style.display=="none"){
document.getElementById("678").style.display="";
document.getElementById("123").style.display="none";
document.getElementById("234").style.display="none";
document.getElementById("345").style.display="none";
document.getElementById("456").style.display="none";
document.getElementById("567").style.display="none";
document.getElementById("789").style.display="none";
}else{
document.getElementById("678").style.display="none";
}
}
function screenH7(){
if(document.getElementById("789").style.display=="none"){
document.getElementById("789").style.display="";
document.getElementById("123").style.display="none";
document.getElementById("234").style.display="none";
document.getElementById("345").style.display="none";
document.getElementById("456").style.display="none";
document.getElementById("567").style.display="none";
document.getElementById("678").style.display="none";
}else{
document.getElementById("789").style.display="none";
}
}

function changeScreen(op,stuats){
	var confId = document.getElementById("conf").value;
	if(confId=="-1"){
		alert("请选择会议！");
		return;
	}
	window.frmright.window.location.href="${sys_ctx }/mcuControl/screenModel.action?meetingDetailID=${meetingDetailID}&stuats="+stuats+"&layout_mode="+op+"&confId="+confId;
}

function setIntervaltime(){
	var time = document.getElementById("time").value;
	var confId = document.getElementById("conf").value;
	McuDwrMethod.setIntervaltime(confId,time);
}
//add by chenshuo 切换会议时更新隐藏域confID
function setConfID(thisHtml){
	document.getElementById("confID").value = thisHtml.value;
	var mcuType = document.getElementById(thisHtml.value).value;
	if(mcuType == 11){
		document.getElementById("mcu1000").style.display = "";
	}else{
		document.getElementById("mcu1000").style.display = "none";
	}

	var meetingDetailId = window.opener.getMeetingDetailId();

	if( meetingDetailId == null || meetingDetailId == "-1"){
		alert("没有会议！");
		return;
	}
	
	McuDwrMethod.getLayOutModeByConfID(thisHtml.value,meetingDetailId,function getLayOutCallBack( result ){
		if( result[0] == "noPage" ){
			alert("暂不支持该分屏");
			return;
		}
		window.frmright.window.location.href="${sys_ctx }/mcuControl/screenModel.action?meetingDetailID="+meetingDetailId+"&layout_mode="+result[0]+"&confId="+thisHtml.value;
	});
}
</script>
  </head>
  
  <body>
  <input type="hidden" name="confVO.confID" value="${param.confID }" id="confID" />
  <input type="hidden" name="mark" value="${param.mark }" id="mark" />
  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
    <tr>
      <td width="180px" style="background:#EEEEEE"> 选择会议</td>
      <td style="background:#F7F7F7;border-right:none">
      	<div style="float:left">
      		<select id="conf" onchange="setConfID(this);">
      			<option value="-1">请选择...</option>
      			<c:forEach items="${confVOList}" var="confVO">
      				<option value="${confVO.confID }">${confVO.confName } </option>
      			</c:forEach>
      			<c:forEach items="${confVOList}" var="confVO">
      				<input type="hidden" value="${confVO.mcuType }" id="${confVO.confID }"/>
      			</c:forEach>
      
      		</select>
      	</div>
      </td>
      <td style="background:#f7f7f7;border-left:none">
      	<span>间隔时间：
      		<select id="time">
			      <option value="5">5</option>
			      <option value="10">10</option>
			      <option value="20">20</option>
			      <option value="30">30</option>
			      <option value="60">60</option>
			      <option value="90">90</option>
			      <option value="120">120</option>
			      <option value="150">150</option>
			      <option value="180">180</option>
			      <option value="210">210</option>
			      <option value="240">240</option>
			      <option value="270">270</option>
			      <option value="300">300</option>
		      </select>秒
      	</span>
      </td>
      
      <td id="mcu1000" style="display:none;background:#f7f7f7">模式：
      <select id="mode">
      <option value="LECTURE">演讲者</option>
      <option value="SAME">相同分屏</option>
      </select>
      </td>
    </tr>
  </table>
  
    <table width="100%" border="0s" cellspacing="0" cellpadding="0" style="margin-top:2px;">
    <tr>
      <td  align="left"   valign="top" showstate="3" width="180">
      <div style="width:180px; height:430px;">
      <table width="178" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
     
      <tr>
        <td class="leftviewdataOff2" id="aaa" ><a onfocus="this.blur()" style="cursor:hand" onclick="screenH1();"><div>单分屏</div></a>
        </td>
        <td class="leftviewdataOff2" id="aaa1" style="display:none;"><a onfocus="this.blur()" style="cursor:hand" ><div>单分屏</div></a>
        </td>
      </tr>
       <tr id="123" style="">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('oneAndOne',1)">
        <img src="${sys_ctx }/images/screenModel/singleScreen.png"  width="20" height="20" /></a>
        </div>
        </td>
      </tr>
      <tr style="display:none">
        <td class="leftviewdataOff2" id="bbb"><a onfocus="this.blur()" style="cursor:hand" onclick="screenH2();"><div>二分屏</div></a>
        </td>
        <td class="leftviewdataOff2" id="bbb1"><a onfocus="this.blur()" style="cursor:hand" ><div>双分屏</div></a>
        </td>
      </tr>
      <tr id="234" style="display:none">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <table>
        <tr>
        <td width="40px">
        <a onfocus="this.blur()" onclick="changeScreen('two1',2)" href="#"  class="leftlink" ><img src="${sys_ctx }/images/screenModel/twoScreen.png"  width="20" height="20" /></a>
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/twoScreen1.png"  width="20" height="20" />
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/twoScreen2.png"  width="20" height="20" />
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/twoScreen3.png"  width="20" height="20" />
        </td>
        </tr>
        </table>
        </div>
        </td>
      </tr>
      <tr >
        <td class="leftviewdataOff2" id="ccc"><a onfocus="this.blur()" style="cursor:hand" onclick="screenH3();"><div>三分屏</div></a>
        </td>
      </tr>
      
       <tr id="345" style="display:none">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <table>
        <tr><td width="40px">
         <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('oneAndTwo',3)"><img src="${sys_ctx }/images/screenModel/threeScreen1.png"  width="20" height="20"></a>
        </td>
        <td width="40px">
        <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('oneAndTwo1',3)"><img src="${sys_ctx }/images/screenModel/threeScreen3.png"  width="20" height="20"></a>
        </td>
        <!-- 
        <td width="40px">
       
        <img src="${sys_ctx }/images/screenModel/threeScreen.png"  width="20" height="20" /></a>
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/threeScreen2.png"  width="20" height="20"></a>
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/threeScreen3.png"  width="20" height="20"></a>
        </td></tr><tr><td width="40px">
        <img src="${sys_ctx }/images/screenModel/threeScreen4.png"  width="20" height="20"></a>
       	</td>
       	 -->
       	</tr>
       	</table>
        </div>
        </td>
      </tr>
      <tr>
        <td class="leftviewdataOff2" id="ddd"><a onfocus="this.blur()" style="cursor:hand" onclick="screenH4();"><div>四分屏</div></a>
        </td>
      </tr>
       <tr id="456" style="display:none">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <table>
        <tr><td width="40px">
        <a onfocus="this.blur()"  class="leftlink" target="frmright" onclick="changeScreen('four',4)"><img src="${sys_ctx }/images/screenModel/fourScreen.png"  width="20" height="20" /></a>
        </td><td width="40px">
        
       </td></tr>
       </table>
       </div>
        </td>
      </tr>
      <tr>
        <td class="leftviewdataOff2" id="eee"><a onfocus="this.blur()" style="cursor:hand" onclick="screenH5();"><div>5+分屏</div></a>
        </td>
      </tr>
      <tr id="567" style="display:none">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <table>
        <tr>
        <td width="40px">
        <a onfocus="this.blur()" href="#" onclick="changeScreen('oneAndFive',6)" class="leftlink" ><img src="${sys_ctx }/images/screenModel/fiveScreen1.png"  width="20" height="20" title="1+5分屏" ></a>
        </td>
        <!--
        <td width="40px">
        <a onfocus="this.blur()" href="#" onclick="changeScreen('oneAndSeven',8)" class="leftlink" ><img src="${sys_ctx }/images/screenModel/fiveScreen9.png"  width="20" height="20" title="1+7分屏" ></a>
        </td>
         
        <td width="40px">
        </td><td width="40px">
       	</td></tr><tr><td width="40px">
     	</td><td width="40px">
        </td><td width="40px">
        </td><td width="40px">
        </td></tr><tr><td width="40px">
      	</td>
      	 -->
      	</tr>
       </table>
        </div>
        </td>
      </tr>
      <tr style="">
        <td class="leftviewdataOff2" id="fff"><a onfocus="this.blur()" style="cursor:hand" onclick="screenH6();" ><div>九分屏</div></a>
        </td>
      </tr>
      <tr id="678" style="display:none">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <table>
        <tr>
        <td width="40px">
		<a onfocus="this.blur()" href="#" onclick="changeScreen('nine',9)" class="leftlink">
        <img src="${sys_ctx }/images/screenModel/nineScreen.png"  width="20" height="20"></a>
        </td>
        <!-- 
        <td width="40px">
        <img src="${sys_ctx }/images/screenModel/nineScreen1.png"  width="20" height="20"></a>
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/nineScreen2.png"  width="20" height="20"></a>
        </td><td width="40px">
        <img src="${sys_ctx }/images/screenModel/nineScreen3.png"  width="20" height="20"></a>
        </td>
         -->
        </tr></table>
        </div>
        </td>
      </tr>
      <tr>
        <td class="leftviewdataOff2" id="ggg"><a onfocus="this.blur()" style="cursor:hand" onclick="screenH7();"><div>10+分屏</div></a>
        </td>
       
      </tr >
      <tr id="789"  style="display:none">
        <td class="leftviewdataOff1" valign="top">
        <div style="padding-top:10px;">
        <table>
        <tr>

        <td width="40px" >
        <a onfocus="this.blur()" href="#" onclick="changeScreen('oneAndTwelve',13)" class="leftlink" >
        <img src="${sys_ctx }/images/screenModel/tenScreen4.png"  width="20" height="20" alt="12+1分屏" title="12+1分屏"></a>
        </td>
        </tr></table>
        </div>
        </td>
      </tr>
    </table></td>
  </tr>
 
</table>

</div>
      </td>
      
       <td align="left"  valign="top" id="frmright1">
      	<iframe id="frmright" frameborder="0"   name="frmright" src=""  style="HEIGHT: 435px; visibility: inherit; WIDTH: 100%; Z-INDEX: 1 "> </iframe>
      </td>
      
      <td id="frrightTitle" align="right" name="frrightTitle" nowrap="" valign="top" width="241" showstate="3" style="display:none"><iframe id="right" frameborder="0" name="right" scrolling="no" src="${sys_ctx }/meetingManage/right.jsp" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 3"></iframe></td>
    </tr>
  </table>
  </body>
<script type="text/javascript">
var mark = document.getElementById("mark").value;
if(mark == "1"){
document.getElementById("frmright1").style.display = "none";
document.getElementById("aaa").style.display = "none";
document.getElementById("aaa1").style.display = "";
document.getElementById("bbb").style.display = "none";
document.getElementById("bbb1").style.display = "";
document.getElementById("ccc").style.display = "none";
document.getElementById("ccc1").style.display = "";
document.getElementById("ddd").style.display = "none";
document.getElementById("ddd1").style.display = "";
document.getElementById("eee").style.display = "none";
document.getElementById("eee1").style.display = "";
document.getElementById("fff").style.display = "none";
document.getElementById("fff1").style.display = "";
document.getElementById("ggg").style.display = "none";
document.getElementById("ggg1").style.display = "";

}
if(mark != "1"){
document.getElementById("frmright1").style.display = "";
document.getElementById("aaa1").style.display = "none";
document.getElementById("aaa").style.display = "";
document.getElementById("bbb1").style.display = "none";
document.getElementById("bbb").style.display = "";
document.getElementById("ccc1").style.display = "none";
document.getElementById("ccc").style.display = "";
document.getElementById("ddd1").style.display = "none";
document.getElementById("ddd").style.display = "";
document.getElementById("eee1").style.display = "none";
document.getElementById("eee").style.display = "";
document.getElementById("fff1").style.display = "none";
document.getElementById("fff").style.display = "";
document.getElementById("ggg1").style.display = "none";
document.getElementById("ggg").style.display = "";
}
</script>
</html>
