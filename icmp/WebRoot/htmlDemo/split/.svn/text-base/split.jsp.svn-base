<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<%@include file="/common/common.jsp"%>
    <title>split</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <script type="text/javascript" charset="utf-8">
	$(document).ready(function() { $('#query_table').dataTable({
	   "bPaginate": false,  
	   "bLengthChange": false, 
	   "bFilter": true,
	   "bInfo": false,
	   "bAutoWidth": true,  //自适应宽度 
	   "bAutoHeight":true,
	   //"sUrl": "/SSS/dataTables/de_DE.txt"
	    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
	//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
	   "oLanguage": {
           "sProcessing": "正在加载中......",
           "sZeroRecords": "没有符合条件的数据！",
           "sSearch":"搜索："
		}    
	});
	
	  $("#query_table tr:gt(0)").bind("mouseover",function(){
	        $(this).css('background-color','#f4e9bb');
	  });
	  $("#query_table tr:gt(0)").bind("mouseout",function(){
	        $(this).css('background-color','');
	  });
    
	var noSTable = $('#query_table_nosearch').dataTable({
	   "bPaginate": false,  
	   "bLengthChange": false, 
	   "bFilter": false,
	   "bInfo": false,
	   "bAutoWidth": true,  //自适应宽度 
	   "bAutoHeight":true,
	   //"sUrl": "/SSS/dataTables/de_DE.txt"
	    //"sDom": '<"top"i>rt<"bottom"flp<"clear">'//这段是自定义布局没搞。
	//"sPaginationType": "full_numbers" //分页，一共两种样式 另一种为two_button  是datatables默认
	   "oLanguage": {
           "sProcessing": "正在加载中......",
           "sZeroRecords": "没有符合条件的数据！",
           "sSearch":"搜索"
		}    
	});
	
	  $("#query_table_nosearch tr:gt(0)").bind("mouseover",function(){
	        $(this).css('background-color','#f4e9bb');
	  });
	  $("#query_table_nosearch tr:gt(0)").bind("mouseout",function(){
	        $(this).css('background-color','');
	  });
	//jquery-validate1.11.1自定义验证方法（扩展的验证规则）
	  $.validator.addMethod("isMobilephone",function(value,element){
	  	var mobilephoneReg = /^((\+86)|(86))?(1[3|4|5|8])\d{9}$/;
	  	return mobilephoneReg.test(value);
	  },"请输入正确的手机格式");
	  $.validator.addMethod("isTelephone",function(value,element){
	  	var telephoneReg = /^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
	  	return telephoneReg.test(value);
	  },"请输入正确的电话格式，如（010-24673631）");
	  $.validator.addMethod("isIp",function(value,element){
	  	var ip = document.getElementById("ip");//将完整的IP进行验证
	  	var ipReg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	  	return ipReg.test(ip.value);
	  },"请输入正确的IP格式（由0到255之间的整数和.组成）");
	  $.validator.addMethod("checkIP",function(value,element){
			var ipReg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
			return ipReg.test(value);
		},"请输入正确的IP格式（由0到255之间的整数和.组成）");
	 } );
	 //显示、隐藏查询条件
	 function disquery(){
		$(".tableadd").toggle();
	 }
	 
	 //换肤
     var cssPath = getCookie("cssPath"); //获取默认皮肤路径   
	//判断用户Cookie中是否有路径,无采用默认,有采用用户的信息   
	if (cssPath != null && cssPath != ""){   
	    document.write("<link href='/icmp/style/" + cssPath + "/css/style.default.css' id='style' rel='stylesheet' type='text/css' />");   
     }else{   
          setCookie('cssPath',"normal",365);   
	      document.write("<link href='/icmp/style/normal/css/style.default.css' id='style' rel='stylesheet' type='text/css' />");   
	}
</script>
<title>分屏选择</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	window.frmright.window.location.href="/icmp/mcuControl/screenModel.action?meetingDetailID=8a81832f3fe1a7b8013fe54fc6d50030&stuats="+stuats+"&layout_mode="+op+"&confId="+confId;
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
}
</script>
  
  
  </head>
  
  <body>
  <div style="background:#eee;width:780px;margin:0 auto">
    <input type="hidden" name="confVO.confID" value="" id="confID" />
    <input type="hidden" name="mark" value="0" id="mark" />
    <div class="contenttitle2"><h5 class="fwb fl10">会议分屏</h5></div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="width:100%">
    	<tr>
    		<td class="tableaddtitle"><input class="stdbtn mlr10" type="button" onclick="javascript:query()" value="会议模式"></td>
    	</tr>
        <!--<tr>
            <td width="15%" class="tableaddtitle">会议选择</td>
            <td width="35%" class="tableadd_data">
                <span class="field">
                    <select id="conf" onchange="setConfID(this);">
                        <option value="-1">请选择...</option>
                        <option value="8a81832f3fe1bb41013fe54fc7bf000c">永久会测试--误删 </option>
                    </select>
                </span>
            </td>
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
        </tr> -->
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:2px;border:1px solid #ccc">
        <tr>
            <td width="180" rowspan="2"  align="left"   valign="top" showstate="3">
                <div style="width:180px; height:420px;background:#eee;border-right:1px solid #ccc;margin-right:1px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="aaa" >
                                <a onfocus="this.blur()" style="cursor:pointer;" onclick="screenH1();">
                                    <div class="fcolor">单分屏</div>
                                </a>
                            </td>
                            <td class="leftviewdataOff2" id="aaa1" style="display:none;">
                                <a onfocus="this.blur()" style="cursor:pointer" >
                                    <div class="fcolor">单分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="123" style="">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10"> 
                                    <a onfocus="this.blur()" href="split_right1_1.jsp" class="leftlink" onclick="changeScreen('oneAndOne',1)"> 
                                        <img src="../../images/splitScreen/singleScreen.png"  width="20" height="19" class="plr10_1" />
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="bbb">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenH2();">
                                    <div class="fcolor">二分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="234" style="display:none">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10"> 
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right2_1.jsp" class="leftlink" onclick="changeScreen('oneAndOne',2)"> 
                                                    <img src="../../images/splitScreen/twoScreen1.png" width="20" height="19" />
                                                </a>
                                             </td>
                                              <td width="40px">
                                                <a onfocus="this.blur()" href="split_right2_2.jsp" class="leftlink" onclick="changeScreen('oneAndOne',2)"> 
                                                    <img src="../../images/splitScreen/twoScreen2.png" width="20" height="19" />
                                                </a>
                                             </td>
                                             <td width="40px">
                                                <a onfocus="this.blur()" href="split_right2_3.jsp" class="leftlink" onclick="changeScreen('oneAndOne',2)"> 
                                                    <img src="../../images/splitScreen/twoScreen3.png" width="20" height="19" />
                                                </a>
                                             </td>
                                         </tr>
                                         <tr>
                                              <td width="40px">
                                                <a onfocus="this.blur()" href="split_right2_4.jsp" class="leftlink" onclick="changeScreen('oneAndOne',2)"> 
                                                    <img src="../../images/splitScreen/twoScreen4.png" width="20" height="19" />
                                                </a>
                                             </td>
                                             <td width="40px">
                                                <a onfocus="this.blur()" href="split_right2_5.jsp" class="leftlink" onclick="changeScreen('oneAndOne',2)"> 
                                                    <img src="../../images/splitScreen/twoScreen5.png" width="20" height="19" />
                                                </a>
                                             </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr >
                            <td class="leftviewdataOff2 plr10" id="ccc">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenH3();">
                                    <div class="fcolor">三分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="345" style="display:none">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_1.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',3)">
                                                    <img src="../../images/splitScreen/threeScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_2.jsp" class="leftlink" onclick="changeScreen('oneAndTwo1',3)">
                                                    <img src="../../images/splitScreen/threeScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_3.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',3)">
                                                    <img src="../../images/splitScreen/threeScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_4.jsp" class="leftlink" onclick="changeScreen('oneAndTwo1',3)">
                                                    <img src="../../images/splitScreen/threeScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_5.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',3)">
                                                    <img src="../../images/splitScreen/threeScreen5.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_6.jsp" class="leftlink" onclick="changeScreen('oneAndTwo1',3)">
                                                    <img src="../../images/splitScreen/threeScreen6.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>
                                         <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right3_7.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',3)">
                                                    <img src="../../images/splitScreen/threeScreen7.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="ddd">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenH4();">
                                    <div class="fcolor">四分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="456" style="display:none">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_1.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_2.jsp" class="leftlink" onclick="changeScreen('oneAndTwo1',4)">
                                                    <img src="../../images/splitScreen/fourScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_3.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_4.jsp" class="leftlink" onclick="changeScreen('oneAndTwo1',4)">
                                                    <img src="../../images/splitScreen/fourScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>                                            
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="#split_right4_6.jsp" class="leftlink" onclick="changeScreen('oneAndTwo1',4)">
                                                    <img src="../../images/splitScreen/fourScreen6.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_7.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen7.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>
                                         <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_8.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen8.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_9.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen9.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_10.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen10.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right4_11.jsp" class="leftlink" onclick="changeScreen('oneAndTwo',4)">
                                                    <img src="../../images/splitScreen/fourScreen11.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="eee" >
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenH5();">
                                    <div class="fcolor">5+分屏 </div>
                                </a>
                            </td>
                        </tr>
                        <tr id="567" style="display:none">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right5_1.jsp" onclick="changeScreen('oneAndFive',5)" class="leftlink" >
                                                    <img src="../../images/splitScreen/fiveScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right5_2.jsp" onclick="changeScreen('oneAndSeven',5)" class="leftlink" >
                                                    <img src="../../images/splitScreen/fiveScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right5_3.jsp" onclick="changeScreen('oneAndFive',5)" class="leftlink" >
                                                    <img src="../../images/splitScreen/fiveScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>                                        
                                         <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right6_1.jsp" onclick="changeScreen('oneAndFive',5)" class="leftlink" >
                                                    <img src="../../images/splitScreen/sixScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right8_1.jsp" onclick="changeScreen('oneAndSeven',5)" class="leftlink" >
                                                    <img src="../../images/splitScreen/eightScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                         </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="fff">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenH6();">
                                    <div class="fcolor">九分屏</div>
                                </a>
                            </td>
                        </tr>
                        <tr id="678" style="display:none">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right9_1.jsp" onclick="changeScreen('nine',9)" class="leftlink"> 
                                                    <img src="../../images/splitScreen/nineScreen1.png"  width="20" height="20" />
                                                    
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right9_2.jsp" onclick="changeScreen('nine',9)" class="leftlink"> 
                                                    <img src="../../images/splitScreen/nineScreen2.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right9_3.jsp" onclick="changeScreen('nine',9)" class="leftlink"> 
                                                    <img src="../../images/splitScreen/nineScreen3.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right9_4.jsp" onclick="changeScreen('nine',9)" class="leftlink"> 
                                                    <img src="../../images/splitScreen/nineScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="leftviewdataOff2 plr10" id="ggg">
                                <a onfocus="this.blur()" style="cursor:pointer" onclick="screenH7();">
                                    <div class="fcolor">十分屏</div>
                                </a>
                            </td>
                        </tr >
                        <tr id="789"  style="display:none">
                            <td class="leftviewdataOff1" valign="top">
                                <div class="plr10">
                                    <table>
                                        <tr>
                                            <td width="40px" >
                                                <a onfocus="this.blur()" href="split_right10_1.jsp" onclick="changeScreen('oneAndTwelve',13)" class="leftlink" > 
                                                    <img src="../../images/splitScreen/tenScreen1.png"  width="20" height="20" />
                                                </a>
                                            </td>
                                            <td width="40px" >
                                                <a onfocus="this.blur()" href="split_right13_1.jsp" onclick="changeScreen('oneAndTwelve',13)" class="leftlink" > 
                                                    <img src="../../images/splitScreen/tenScreen4.png"  width="20" height="20" />
                                                </a>
                                            </td>                                            
                                            <td width="40px">
                                                <a onfocus="this.blur()" href="split_right16_1.jsp" onclick="changeScreen('nine',9)" class="leftlink"> 
                                                    <img src="../../images/splitScreen/sixteenScreen1.png"  width="20" height="20" />
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
                <iframe id="frmright3" frameborder="0" name="frmright" src="split_right1.jsp" style="height:420px;background:#eee;visibility:inherit;width:100%;Z-INDEX:1"  scrolling="auto"> </iframe>
            </td>
            <td width="241" rowspan="2" align="right" valign="top" nowrap="nowrap" id="frrightTitle2" style="display:none" name="frrightTitle" showstate="3">&nbsp;</td>
        </tr>
        
    </table>
</div>
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






