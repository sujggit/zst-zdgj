<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>

	<title>RMX1000字幕</title>
	<script type="text/javascript">
		function boxCaption(id){
		if(id.checked == true){
			document.getElementById("contentID").disabled = "";
			document.getElementById("fontSizeID").disabled = "";
			document.getElementById("loopNumID").disabled = "";
		}else{
			document.getElementById("contentID").disabled = "disabled";
			document.getElementById("fontSizeID").disabled = "disabled";
			document.getElementById("loopNumID").disabled = "disabled";
		}
	}

		function pageInit(){
		    var obj = new htmlUtil();
		    obj.title("contentID","请输入40个字符");
		    obj.title("positionID","请输入100以内数字");	
		
		}

		function showMessage(confID, isEnableContentID, contentID, fontSizeID, colorID, loopNumID, speedID, positionID,transparency){
			var confOjbect = window.parent.document.getElementById(confID);
			
			if(confOjbect.value==""){
				alert("请选择会议！");
				return;
			}
			var isEnableContent = document.getElementById(isEnableContentID);
			var conent = document.getElementById(contentID);
			var fontSize = document.getElementById(fontSizeID);
			var color = document.getElementById(colorID);
			var loopNum = document.getElementById(loopNumID);
			var speed = document.getElementById(speedID);
			var position = document.getElementById(positionID);
			var transparency = document.getElementById(transparency);

			if( conent.value.length>40){
				alert("限定40字符");
				return;
			}

			if( position.value >100 || position.value<1 ){
				alert("限定1-100以内");
				return;
			}
			
			//alert("wangle" + confID + isEnableContent.checked );
			McuDwrMethod.showMessage("RMX2000_ONLY", confOjbect.value, isEnableContent.checked, conent.value, fontSize.value, color.value, loopNum.value, speed.value, position.value, transparency.value ,function(){});
		}

	</script>
</head>
  <body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit()">
  <div id="basicform" class="contentwrapper">
 <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
    <tr>
    <td  width="20%" class="tableaddtitle"  >启用</td>
    <td  class="tableadd_data">
    	<input type="checkbox" class="noborder" id="checkboxID" onclick="boxCaption(this);"/>
    	<input type="hidden" value="${confVO.isShow}" name="confVO.isShow" id="isShow"/>
    </td>
  </tr>
    <tr>
    <td width="10%" class="tableaddtitle" >内容</td>
    <td  class="tableadd_data">
    <input type="text" style="width:300px;" value="${confVO.content}" name="confVO.content" id="contentID" maxlength="40"/><span style="color:red">*限40字符</span>
    </td>
  </tr>
   <tr>
    <td width="10%" class="tableaddtitle" >字体大小</td>
    <td   class="tableadd_data">
    <select name="confVO.fontSize" id="fontSizeID" style="width:150px;">
<%--	    <option value="small" ${confVO.fontSize=="small" ? "selected" : "" }>1</option>--%>
<%--	    <option value="medium" ${confVO.fontSize=="medium" ? "selected" : "" }>中</option>--%>
<%--	    <option value="large" ${confVO.fontSize=="large" ? "selected" : "" }>大</option>--%>
	<option value="24" ${confVO.fontSize=="24" ? "selected" : "" }>24</option>
    <option value="9" ${confVO.fontSize=="9" ? "selected" : "" }>9</option>
    <option value="10" ${confVO.fontSize=="10" ? "selected" : "" }>10</option>
    <option value="11" ${confVO.fontSize=="11" ? "selected" : "" }>11</option>
    <option value="12" ${confVO.fontSize=="12" ? "selected" : "" }>12</option>
    <option value="13" ${confVO.fontSize=="13" ? "selected" : "" }>13</option>
    <option value="14" ${confVO.fontSize=="14" ? "selected" : "" }>14</option>
    <option value="15" ${confVO.fontSize=="15" ? "selected" : "" }>15</option>
    <option value="16" ${confVO.fontSize=="16" ? "selected" : "" }>16</option>
    <option value="17" ${confVO.fontSize=="17" ? "selected" : "" }>17</option>
    <option value="18" ${confVO.fontSize=="18" ? "selected" : "" }>18</option>
    <option value="19" ${confVO.fontSize=="19" ? "selected" : "" }>19</option>
    <option value="20" ${confVO.fontSize=="20" ? "selected" : "" }>20</option>
    <option value="21" ${confVO.fontSize=="21" ? "selected" : "" }>21</option>
    <option value="22" ${confVO.fontSize=="22" ? "selected" : "" }>22</option>
    <option value="23" ${confVO.fontSize=="23" ? "selected" : "" }>23</option>
    <option value="25" ${confVO.fontSize=="25" ? "selected" : "" }>25</option>
    <option value="26" ${confVO.fontSize=="26" ? "selected" : "" }>26</option>
    <option value="27" ${confVO.fontSize=="27" ? "selected" : "" }>27</option>
    <option value="28" ${confVO.fontSize=="28" ? "selected" : "" }>28</option>
    <option value="29" ${confVO.fontSize=="29" ? "selected" : "" }>29</option>
    <option value="30" ${confVO.fontSize=="30" ? "selected" : "" }>30</option>
    <option value="31" ${confVO.fontSize=="31" ? "selected" : "" }>31</option>
	<option value="32" ${confVO.fontSize=="32" ? "selected" : "" }>32</option>
	</select>
    </td>
  </tr>
    <tr id="background">
    <td  class="tableaddtitle" >背景颜色</td>
    <td   class="tableadd_data">
    <select name="confVO.color" id="colorID" style="width:150px;">
    	<option value="0x00FF0000_0x00FFFFFF" ${confVO.color=="0x00ff0000"&&confVO.backColor=="0x00ffffff" ? "selected" : "" }>白底红字</option>
	    <option value="0x00FFFFFF_0x00800000" ${confVO.color=="0x00ffffff"&&confVO.backColor=="0x00800000" ? "selected" : "" }>红底白字</option>
	    <option value="0x00FFFFFF_0x00000000" ${confVO.color=="0x00ffffff"&&confVO.backColor=="0x00000000" ? "selected" : "" }>黑底白字</option>
	    <option value="0x00FFFF00_0x00000000" ${confVO.color=="0x00ffff00"&&confVO.backColor=="0x00000000" ? "selected" : "" }>黑底黄字</option>
	   </select>
<!--    2000、4000颜色定义 -->
<!--    <select name="confVO.color" id="colorID" style="width:150px;">-->
<!--    	<option value="white_font_on_red_background" >红色</option>-->
<!--	    <option value="white_font_on_light_blue_background" >白色</option>-->
<!--	    <option value="white_font_on_black_background">黑色</option>-->
<!--	    <option value="white_font_on_gray_background" >灰色</option>-->
<!--	    <option value="white_font_on_orange_background" >橘红</option>-->
<!--	    <option value="white_font_on_blue_background" >蓝色</option>-->
<!--	    <option value="white_font_on_olive_background" >橄榄色</option>-->
<!--	    <option value="white_font_on_green_background" >绿色</option>-->
<!--	    <option value="white_font_on_purple_background" >紫色</option>-->
<!--	   </select>-->
    </td>
  </tr>
  <tr style="display:none;">
    <td   class="tabletitleLeft">背景透明度(0-100)</td>
    <td  class="tabledata">
    <input type="text" value="50" name="confVO.transparency" id="transparency"/>
    </td>
  </tr>
  <tr>
    <td class="tableaddtitle" >显示次数</td>
    <td  class="tableadd_data" >
    <select name="confVO.loopNum" id="loopNumID">
    <option value="20" ${confVO.loopNum=="20" ? "selected" : "" }>20</option>
    <option value="1" ${confVO.loopNum=="1" ? "selected" : "" }>1</option>
    <option value="2" ${confVO.loopNum=="2" ? "selected" : "" }>2</option>
    <option value="3" ${confVO.loopNum=="3" ? "selected" : "" }>3</option>
    <option value="4" ${confVO.loopNum=="4" ? "selected" : "" }>4</option>
    <option value="5" ${confVO.loopNum=="5" ? "selected" : "" }>5</option>
    <option value="6" ${confVO.loopNum=="6" ? "selected" : "" }>6</option>
    <option value="7" ${confVO.loopNum=="7" ? "selected" : "" }>7</option>
    <option value="8" ${confVO.loopNum=="8" ? "selected" : "" }>8</option>
    <option value="9" ${confVO.loopNum=="9" ? "selected" : "" }>9</option>
    <option value="10" ${confVO.loopNum=="10" ? "selected" : "" }>10</option>
    <option value="11" ${confVO.loopNum=="11" ? "selected" : "" }>11</option>
    <option value="12" ${confVO.loopNum=="12" ? "selected" : "" }>12</option>
    <option value="13" ${confVO.loopNum=="13" ? "selected" : "" }>13</option>
    <option value="14" ${confVO.loopNum=="14" ? "selected" : "" }>14</option>
    <option value="15" ${confVO.loopNum=="15" ? "selected" : "" }>15</option>
    <option value="16" ${confVO.loopNum=="16" ? "selected" : "" }>16</option>
    <option value="17" ${confVO.loopNum=="17" ? "selected" : "" }>17</option>
    <option value="18" ${confVO.loopNum=="18" ? "selected" : "" }>18</option>
    <option value="19" ${confVO.loopNum=="19" ? "selected" : "" }>19</option>
    </select>
    
    </td>
  </tr>
   <tr id="position">
    <td class="tableaddtitle"  >显示位置</td>
    <td   class="tableadd_data" >
    <input type="text" value="${confVO.vertical }" name="confVO.align" id="positionID"/><span style="color:red">*限1-100以内</span>
<!--    原来位置显示-->
<!--    <select name="confVO.align" id="positionID">-->
<!--	    <option value="20" ${confVO.align=="20" ? "selected" : "" }>上方</option>-->
<!--	    <option value="90" ${confVO.align=="90" ? "selected" : "" }>下方</option>-->
<!--    </select>-->
    </td>
  </tr>
    <tr id="speed">
    <td  class="tableaddtitle" >显示速度</td>
    <td  class="tableadd_data">
    <select name="confVO.speed" id="speedID">
	    <option value="3" ${confVO.speed=="3" ? "selected" : "" }>3</option>
	    <option value="0" ${confVO.speed=="0" ? "selected" : "" }>0</option>
	    <option value="1" ${confVO.speed=="1" ? "selected" : "" }>1</option>
	    <option value="2" ${confVO.speed=="2" ? "selected" : "" }>2</option>
	    <option value="4" ${confVO.speed=="4" ? "selected" : "" }>4</option>
	    <option value="5" ${confVO.speed=="5" ? "selected" : "" }>5</option>
	    <option value="6" ${confVO.speed=="6" ? "selected" : "" }>6</option>
	    <option value="7" ${confVO.speed=="7" ? "selected" : "" }>7</option>
	    <option value="8" ${confVO.speed=="8" ? "selected" : "" }>8</option>
	    <option value="9" ${confVO.speed=="9" ? "selected" : "" }>9</option>
	    <option value="10" ${confVO.speed=="10" ? "selected" : "" }>10</option>
   
	    <%--<option value="slow" ${confVO.speed=="slow" ? "selected" : "" }>慢</option>
	    <option value="fast" ${confVO.speed=="fast" ? "selected" : "" }>快</option>
	    <option value="static" ${confVO.speed=="static" ? "selected" : "" }>静态</option>
    --%></select>
    </td>
  </tr>
  </table>
  
  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td><input type="button" class="submit1 radius2" value="确 定" onclick="showMessage('filterSelectId', 'checkboxID', 'contentID', 'fontSizeID', 'colorID','loopNumID', 'speedID', 'positionID','transparency');"/>
                  </button>
                  <input type="reset" class="reset1 radius2" value="退 出" onclick="javascript:window.parent.close();"/>
                </button></td>
              </tr>
            </tbody>
  </table>
  </div>
  <script>
  if(document.getElementById("positionID").value == ""){document.getElementById("positionID").value == "20"}
	if(document.getElementById("isShow").value == "YES"){
		document.getElementById("checkboxID").checked = true;
		document.getElementById("contentID").disabled = "";
		document.getElementById("fontSizeID").disabled = "";
		document.getElementById("loopNumID").disabled = "";
	}else{
		document.getElementById("checkboxID").checked = false;
		document.getElementById("contentID").disabled = "disabled";
		document.getElementById("fontSizeID").disabled = "disabled";
		document.getElementById("loopNumID").disabled = "disabled";
	}
</script>
  </body>
</html>
