<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<%@include file="/common/common.jsp"%>
    <title><c:if test="${type=='meeting' }">会议分屏</c:if><c:if test="${type=='meetingroom' }">会场分屏</c:if></title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/meeting/meetingManage/split/splitJs.js'></script>
<script type="text/javascript">


function changeScreen(op,stuats){
	var confId = document.getElementById("conf").value;
	var type = document.getElementById("type").value;
	var monitor = document.getElementById("monitor").value;
	if(confId=="-1"&&type=="meeting"){
		alert("请选择会议！");
		return;
	}
	$(".plr10_1").removeClass();
	$("#"+op).find("img").addClass("plr10_1");
	window.frmright.window.location.href="/icmp/mcuControl/screenModel.action?meetingDetailID=${meetingDetailID}&stuats="+stuats+"&layout_mode="+op+"&confId="+confId+"&type="+type+"&monitor="+monitor;
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
		document.getElementById("mcu1000_1").style.display = "";
		var videoMode = document.getElementById(thisHtml.value+"_videoMode").value;
		$("#mode option").each(function(i){
			if(this.value == videoMode){
				this.selected=true;
			}
		});
		$(".notin1000").each(function(i){
			this.style.display="none";
		});
	}else{
		document.getElementById("mcu1000").style.display = "none";
		document.getElementById("mcu1000_1").style.display = "none";
		$(".notin1000").each(function(i){
			this.style.display="";
		});
	}
	var meetingDetailId = window.opener.getMeetingDetailId();
	if( meetingDetailId == null || meetingDetailId == "-1"){
		alert("没有会议！");
		return;
	}
	
	McuDwrMethod.getLayOutModeByConfID(thisHtml.value,meetingDetailId,function( result ){
		if( result[0] == "noPage" ){
			alert("暂不支持该分屏");
			return;
		}
		screenTab("screen"+result[2]);
		changeScreen(result[0],result[2]);
		//window.frmright.window.location.href="${sys_ctx }/mcuControl/screenModel.action?meetingDetailID="+meetingDetailId+"&layout_mode="+result[0]+"&confId="+thisHtml.value;
	});
}

function screenTab(id){
	$(".screen_tab").each(function(i){
		if($(this).attr("id")==id){
			this.style.display="";
		}else{
			this.style.display="none";
		}
	});
}

$(document).ready(function(){
var type = $("#type").val();
if(type=="meetingroom"){
		screenTab("screen${layOutInfo[2]}");
		changeScreen("${layOutInfo[0]}","${layOutInfo[2]}");	
}
});

  </script>
  
  </head>
  
  <body>
  <div style="background:#eee;width:780px;height:450px;margin:0 auto">
    <input type="hidden" name="confVO.confID" value="" id="confID" />
    <input type="hidden" name="mark" value="0" id="mark" />
    <input type="hidden" value="${monitor }" id="monitor"/>
    <input type="hidden" value="${type }" id="type"/>
    <input type="hidden" value="${meetingDetailID }" id="meetingDetailID"/>
    <div class="contenttitle2"><h5 class="fwb fl10"><c:if test="${type=='meeting' }">会议分屏</c:if><c:if test="${type=='meetingroom' }">会场分屏</c:if></h5></div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="width:100%">
        
        <tr <c:if test="${type=='meetingroom' }">style="display:none"</c:if>>
            <td class="tableaddtitle" style="width:165px;">会议选择</td>
            <td class="tableadd_data">
                <span class="field">
                    <select id="conf" onchange="setConfID(this);">
                        <option value="-1">请选择...</option>
      					<c:forEach items="${confVOList}" var="confVO">
      					<option value="${confVO.confID }">${confVO.confName } </option>
      					</c:forEach>
      					<c:forEach items="${confVOList}" var="confVO">
      					<input type="hidden" value="${confVO.mcuType }" id="${confVO.confID }"/>
      					</c:forEach>
      					<c:forEach items="${confVOList}" var="confVO">
      					<input type="hidden" value="${confVO.videoMode }" id="${confVO.confID }_videoMode"/>
      					</c:forEach>
                    </select>
                </span>
            </td>
            <!--  
            <td width="15%" class="tableaddtitle">间隔时间</td>
            <td width="35%" class="tableadd_data">
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
            </td>
            -->
            <td id="mcu1000"  width="15%" class="tableaddtitle" style="display:none;">模式</td>
            <td id="mcu1000_1" width="35%" class="tableadd_data"  style="display:none;">
      		<select id="mode">
      			<option value="LECTURE">演讲者</option>
      			<option value="SAME">相同分屏</option>
     	 	</select>
      		</td>
        </tr>
        
        
        <tr <c:if test="${type=='meeting' }">style="display:none"</c:if>>
    		<td class="tableaddtitle"><input class="stdbtn mlr10" type="button" onclick="splitSubmit(100,'1x1')" value="会议模式"/></td>
    	</tr>
    	
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:2px;border:1px solid #999;border-top:none">
        <tr>
            <td width="180" rowspan="2"  align="left"   valign="top" >
                <div style="width:180px; height:420px;background:#eee;border-right:1px solid #ccc;margin-right:1px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="aaa" >
                                <a onfocus="this.blur()" style="cursor:pointer;" onclick="screenTab('screen1');">
                                    <div class="fcolor">单分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="screen1" style="" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10"> 
                                    <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right1_1',1)" id="split_right1_1"> 
                                        <img src="${sys_ctx }/images/splitScreen/singleScreen.png"  width="20" height="19"  />
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="bbb">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenTab('screen2');">
                                    <div class="fcolor">二分屏</div>
                                </a>
                            </td>
                           
                        </tr>
                        <tr id="screen2" style="display:none" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10"> 
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right2_1',2)" id="split_right2_1"> 
                                                    <img src="${sys_ctx }/images/splitScreen/twoScreen1.png" width="20" height="19" />
                                                </a>
                                             </td>
                                              <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right2_2',2)" id="split_right2_2"> 
                                                    <img src="${sys_ctx }/images/splitScreen/twoScreen2.png" width="20" height="19" />
                                                </a>
                                             </td>
                                             <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right2_3',2)" id="split_right2_3"> 
                                                    <img src="${sys_ctx }/images/splitScreen/twoScreen3.png" width="20" height="19" />
                                                </a>
                                             </td>
                                         </tr>
                                         <tr>
                                              <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right2_4',2)" id="split_right2_4"> 
                                                    <img src="${sys_ctx }/images/splitScreen/twoScreen4.png" width="20" height="19" />
                                                </a>
                                             </td>
                                             <td width="40px" class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right2_5',2)" id="split_right2_5"> 
                                                    <img src="${sys_ctx }/images/splitScreen/twoScreen5.png" width="20" height="19" />
                                                </a>
                                             </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr >
                            <td class="leftviewdataOff2 plr10" id="ccc">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenTab('screen3');">
                                    <div class="fcolor">三分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="screen3" style="display:none" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_1',3)" id="split_right3_1">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_2',3)" id="split_right3_2">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_3',3)" id="split_right3_3">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_4',3)" id="split_right3_4">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_5',3)" id="split_right3_5">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen5.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_6',3)" id="split_right3_6">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen6.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>
                                         <tr>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right3_7',3)" id="split_right3_7">
                                                    <img src="${sys_ctx }/images/splitScreen/threeScreen7.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="ddd">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenTab('screen4');">
                                    <div class="fcolor">四分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="screen4" style="display:none" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_1',4)"  id="split_right4_1">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_2',4)" id="split_right4_2">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_3',4)" id="split_right4_3">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_4',4)" id="split_right4_4">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px"  class="notin1000" >
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_6',4)" id="split_right4_6">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen6.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_7',4)" id="split_right4_7">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen7.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            </tr>
                                         <tr>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_8',4)" id="split_right4_8">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen8.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_9',4)" id="split_right4_9">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen9.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                       
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_10',4)" id="split_right4_10">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen10.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                             </tr>
                                        <tr>
                                            <td width="40px"  class="notin1000">
                                                <a onfocus="this.blur()" href="#" class="leftlink" onclick="changeScreen('split_right4_11',4)" id="split_right4_11">
                                                    <img src="${sys_ctx }/images/splitScreen/fourScreen11.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="eee" >
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenTab('screen5');">
                                    <div class="fcolor">5+分屏 </div>
                                </a>
                            </td>
                        </tr>
                        <tr id="screen5" style="display:none" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right5_1',5)" class="leftlink"  id="split_right5_1">
                                                    <img src="${sys_ctx }/images/splitScreen/fiveScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right5_2',5)" class="leftlink"  id="split_right5_2">
                                                    <img src="${sys_ctx }/images/splitScreen/fiveScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right5_3',5)" class="leftlink"  id="split_right5_3">
                                                    <img src="${sys_ctx }/images/splitScreen/fiveScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>
                                         <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right6_1',5)" class="leftlink" id="split_right6_1">
                                                    <img src="${sys_ctx }/images/splitScreen/sixScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right8_1',5)" class="leftlink" id="split_right8_1">
                                                    <img src="${sys_ctx }/images/splitScreen/eightScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="fff">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenTab('screen9');">
                                    <div class="fcolor">九分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="screen9" style="display:none" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right9_1',9)" class="leftlink" id="split_right9_1"> 
                                                    <img src="${sys_ctx }/images/splitScreen/nineScreen1.png"  width="20" height="20" />
                                                    
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right9_2',9)" class="leftlink" id="split_right9_2"> 
                                                    <img src="${sys_ctx }/images/splitScreen/nineScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right9_3',9)" class="leftlink" id="split_right9_3"> 
                                                    <img src="${sys_ctx }/images/splitScreen/nineScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right9_4',9)" class="leftlink" id="split_right9_4"> 
                                                    <img src="${sys_ctx }/images/splitScreen/nineScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                           
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="ggg">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenTab('screen10');">
                                    <div class="fcolor">十分屏</div>
                                </a>
                            </td>
                        </tr >
                        <tr id="screen10"  style="display:none" class="screen_tab">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px" >
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right10_1',10)" class="leftlink"  id="split_right10_1"> 
                                                    <img src="${sys_ctx }/images/splitScreen/tenScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px" >
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right13_1',10)" class="leftlink"  id="split_right13_1"> 
                                                    <img src="${sys_ctx }/images/splitScreen/tenScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                           <td width="40px">
                                                <a onfocus="this.blur()" href="#" onclick="changeScreen('split_right16_1',10)" class="leftlink"  id="split_right16_1"> 
                                                    <img src="${sys_ctx }/images/splitScreen/sixteenScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
            <td align="left"  valign="top" id="frmright2">
                <iframe id="frmright3" frameborder="0" name="frmright" src="${sys_ctx }/meeting/meetingManage/split/split_right1.jsp" style="height:420px;visibility:inherit;width:100%;Z-INDEX:1"  scrolling="auto"> </iframe>
            </td>
            <td width="241" rowspan="2" align="right" valign="top" nowrap="nowrap" id="frrightTitle2" style="display:none" name="frrightTitle" showstate="3">&nbsp;</td>
        </tr>
       
    </table>
</div>
</body>

</html>






