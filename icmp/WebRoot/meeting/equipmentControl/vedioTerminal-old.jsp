<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp"%>

<link rel="stylesheet" href="${sys_ctx }/style/blue/reset.css" type="text/css" />
<link rel="stylesheet" href="${sys_ctx }/style/blue/font.css" type="text/css" />
<link rel="stylesheet" href="${sys_ctx }/style/blue/global.css" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>视频终端</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.slider-min.js"></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.dependClass.js"></script>
<script type="text/javascript">  
	// oldContents = "";
	var chooseKey = "";
	function contentShow(input){
		var inputContents = document.getElementById("contentShow");
		var oldContents = inputContents.value;
		var newContents = oldContents+input;
		inputContents.value = newContents;
	}
	
	
    function controlTerminal(data){
     if(data == "dot"){
     	chooseKey = ".";
     }
     if(data == "delete"){
     	var operateValue = document.getElementById("contentShow");
     	var beforeValue = operateValue.value;
     	var afterValue = beforeValue.substring(0,beforeValue.length-1);
     	operateValue.value = afterValue;
     }
     var ids=document.getElementById("equipmentId").value;
      if(ids==""||ids==null){
       // alert(ids);
        alert("请选择终端!");
		return;
		}
     TerminalDwrMethod.controlTerminalById(ids,data,controlTerminalback);
    }
    function controlTerminalback(result)
    {		
    		//alert(chooseKey);
        	if(result!=true){
	    		alert("失败！");
	    	}else if(chooseKey == "."){
	    		contentShow(chooseKey);
	    	} 
	}                                                                                                                                                                 
 
	//数字键
	function numKey(num){
	  chooseKey = num;
      var ids=document.getElementById("equipmentId").value;
      if(ids==""||ids==null){
       // alert(ids);
        alert("请选择终端!");
		return;
		}
    //  alert(ids);
    TerminalDwrMethod.numKeys(ids,num,numKeyback);
    }
    function numKeyback(result)
    {		//alert(chooseKey);
    		 if(result!=true){
	            alert("失败！");
	            //document.getElementById("contentShow").value = oldContents;
	        }else{
	        	contentShow(chooseKey);
	        }		
	}
	//方向键
	function directionKey(nums){
	// alert(nums);
     var ids=document.getElementById("equipmentId").value;
      if(ids==""||ids==null){
        alert("请选择终端!");
		return;
		}
   TerminalDwrMethod.directionKey(ids,nums,directionKeyback);
    }
    function directionKeyback(result)
    {
    	 if(result!=true){
	         alert("失败！");
	        }		
	}
	
	//方向键鼠标移开
	function undirectionKey(){
	}
	
	//add by yangyi
	function change(){
		var ip = document.getElementById("equipmentId").value;
		//alert("111:"+ip);
		window.location.href="${sys_ctx}/equipmentControl/videoEndPointBefore.action?equipmentVO.equipmentID="+ip;
	}
    
    
</script>

<link rel="stylesheet" href="${sys_ctx}/style/blue/reset.css" type="text/css" />
<link rel="stylesheet" href="${sys_ctx}/style/blue/font.css" type="text/css" />
<link rel="stylesheet" href="${sys_ctx}/style/blue/global.css" type="text/css" />
</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
<div id="container">
  <div class="content">
    <div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_style_url}/titleicon.gif" width="20" height="25" /></div>
  <div class="fl">&nbsp;视频终端</div>
</div>
    <div class="tablesdiv">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
        <tr class="tdhight">
          <td class="ar fontstyle fontb pr3">请选择视频终端：</td>
          <td class="al pl3">
          	<select name="select" id="equipmentId" onchange="change();" class="select200 fontstyle">
              <c:forEach items="${equipmentList}" var="equipmentVOs" varStatus="state">
   	        	<option value="${equipmentVOs.equipmentID}" ${equipmentVOs.equipmentID==equipmentVO.equipmentID  ? "selected" : "" } ><c:out value="${equipmentVOs.equipmentNO}"/></option>
   			  </c:forEach>
            </select></td>
        </tr>
      </table>
      <table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td width="500" align="center"><div class="spzddiv">
              <ul>
                <li class="spbtn spzdbtn1 font12wb" style="cursor:pointer" onclick='controlTerminal("painted");'>画中画</li>
                <li class="spbtn spzdbtn2 font12wb" style="cursor:pointer" onclick='controlTerminal("cameras");'>摄像机</li>
                <li class="spbtn spzdbtn3 font12wb" style="cursor:pointer" onclick='controlTerminal("content");'>内 容</li>
                <li class="spbtn spzdbtn4 font12wb" style="cursor:pointer" onclick='controlTerminal("messages");'>信 息</li>
              </ul>
          </div></td>
          <td width="300" align="center">
              <input type="text" id="contentShow" readonly="readonly" 	class="input300 font18stylew"  />
            </td>
        </tr>
        <tr>
          <td height="25" align="center">
          <div class="spzddiv"><table width="300" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td height="54">&nbsp;</td>
                <td><div class="spyd font12sb" style="cursor:pointer" onclick='controlTerminal("buttonfar");'>远端</div></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="37">
                <div class="spjp font12sb" style="margin-right:10px; cursor:pointer" onclick='controlTerminal("keyboard");'>键盘</div></td>
                <td><table width="242" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="48">&nbsp;</td>
                      <td width="146"><img src="${sys_style_url}/zd/spzd_kzt.png" style="cursor:pointer" onclick='directionKey("up")' width="146" height="43" /></td>
                      <td width="48">&nbsp;</td>
                    </tr>
                    <tr>
                      <td><img src="${sys_style_url}/zd/spzd_kzl.png" style="cursor:pointer" onclick='directionKey("left")' width="48" height="147" /></td>
                      <td><img src="${sys_style_url}/zd/spzd_enter.png" style="cursor:pointer" onclick='directionKey("centers")' width="146" height="147" /></td>
                      <td><img src="${sys_style_url}/zd/spzd_kzr.png" style="cursor:pointer" onclick='directionKey("right")' width="49" height="147" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td><img src="${sys_style_url}/zd/spzd_kzb.png" style="cursor:pointer" onclick='directionKey("down")' width="145" height="44" /></td>
                      <td>&nbsp;</td>
                    </tr>
                  </table></td>
                <td><div class="spjp font12sb" style="margin-left:10px; cursor:pointer" onclick='controlTerminal("keyboard");'>键盘</div></td>
              </tr>
              <tr>
                <td height="53">&nbsp;</td>
                <td><div class="spjd font12sb" style="margin-top:10px; cursor:pointer" onclick='controlTerminal("buttonnear");'>近端</div></td>
                <td>&nbsp;</td>
              </tr>
            </table></div></td>
          <td><table width="300" border="0" cellspacing="0" cellpadding="0" class="ac">
            <tr>
              <td width="30%"><input name="input" type="button" class="szj font18wb"  value="1" onclick='numKey("1")' /></td>
              <td width="30%"><input name="input" type="button" class="szj font18wb"  value="2" onclick='numKey("2")' /></td>
              <td width="30%"><input name="input" type="button" class="szj font18wb"  value="3" onclick='numKey("3")' /></td>
            </tr>
            <tr>
              <td><input name="input" type="button" class="szj font18wb"  value="4" onclick='numKey("4")'/></td>
              <td><input name="input" type="button" class="szj font18wb"  value="5" onclick='numKey("5")'/></td>
              <td><input name="input" type="button" class="szj font18wb"  value="6" onclick='numKey("6")'/></td>
            </tr>
            <tr>
              <td><input name="input" type="button" class="szj font18wb"  value="7" onclick='numKey("7")'/></td>
              <td><input name="input" type="button" class="szj font18wb"  value="8" onclick='numKey("8")'/></td>
              <td><input name="input" type="button" class="szj font18wb"  value="9" onclick='numKey("9")'/></td>
            </tr>
            <tr>
              <td><input name="input" type="button" class="szj font18wb"  value="*" onclick='numKey("*")'/></td>
              <td><input name="input" type="button" class="szj font18wb"  value="0" onclick='numKey("0")'/></td>
              <td><input name="input" type="button" class="szj font18wb"  value="#" onclick='numKey("#")'/></td>
            </tr>
            <tr>
              <td><input name="input" type="button" class="szjbh font18wb"  value=" " onclick='controlTerminal("dialing");'/></td>
              <td><input name="input" type="button" class="szj font40wb"  value="." onclick='controlTerminal("dot");' /></td>
              <td><input name="input" type="button" class="szjgd font18wb"  value=" " onclick='controlTerminal("hangup");'/></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="25" align="center"><div class="spzddiv">
              <ul>
                <li class=" spbtn spzdbtn5 font12wb" style="cursor:pointer" onclick='controlTerminal("home");'>主页</li>
                <li class="spbtn spzdbtn6 font12wb" style="cursor:pointer" onclick='controlTerminal("back");'>返 回</li>
                <li class="spbtn spzdbtn7 font12wb" style="cursor:pointer" onclick='controlTerminal("mute");'>静 音</li>
                <li class="spbtn spzdbtn8 font12wb" style="cursor:pointer" onclick='controlTerminal("delete");'>删 除</li>
             
              </ul>
            </div></td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
</html>
